package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.LanguageIdentifier;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationOverlayManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskAiSuggestionPdf extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskAiSuggestionPdf");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        int mCurrentPageIndex;
        SpenWNote mNote;
        PdfManager mPdfManager;
        TextManager mTextManager;

        public InputValues(PdfManager pdfManager, TextManager textManager, SpenWNote spenWNote, int i) {
            this.mPdfManager = pdfManager;
            this.mTextManager = textManager;
            this.mNote = spenWNote;
            this.mCurrentPageIndex = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        Locale mIdentifiedLocale;

        public ResultValues(Locale locale) {
            this.mIdentifiedLocale = locale;
        }

        public Locale getIdentifiedLocale() {
            return this.mIdentifiedLocale;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(final InputValues inputValues) {
        String str = TAG;
        Logger.m11003i(str, "executeTask#");
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor(new SenlThreadFactory(str));
        this.mExecutorService = executorServiceNewSingleThreadExecutor;
        executorServiceNewSingleThreadExecutor.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAiSuggestionPdf.1
            private String getBodyText(InputValues inputValues2) {
                int textSectionStart;
                int iMax;
                SpenObjectTextBox bodyText = inputValues2.mNote.getBodyText();
                if (inputValues2.mNote.getPageMode() == SpenWNote.PageMode.SINGLE) {
                    ISpenNoteTextManager spenNoteTextManager = inputValues2.mTextManager.getSpenNoteTextManager();
                    textSectionStart = spenNoteTextManager.getCursorSelectionStartOnScreenInBodyText();
                    if (textSectionStart < 0) {
                        Logger.m10999d(TaskAiSuggestionPdf.TAG, "getBodyText# isSingleMode fail to find cursor index of page");
                        return "";
                    }
                    iMax = spenNoteTextManager.getCursorSelectionEndOnScreenInBodyText();
                    if (textSectionStart >= iMax) {
                        Logger.m10999d(TaskAiSuggestionPdf.TAG, "getBodyText# isSingleMode text length of current page is 0");
                        return "";
                    }
                } else {
                    int i = inputValues2.mCurrentPageIndex;
                    textSectionStart = bodyText.getTextSectionStart(i);
                    if (textSectionStart < 0) {
                        Logger.m10999d(TaskAiSuggestionPdf.TAG, "getBodyText# fail to find cursor index of page");
                        return "";
                    }
                    iMax = Math.max(0, bodyText.getTextSectionLength(i) + textSectionStart);
                    if (textSectionStart >= iMax) {
                        Logger.m10999d(TaskAiSuggestionPdf.TAG, "getBodyText# text length of current page is 0");
                        return "";
                    }
                }
                return bodyText.getText().substring(textSectionStart, iMax);
            }

            @Override // java.lang.Runnable
            public void run() {
                InputValues inputValues2 = inputValues;
                PdfManager pdfManager = inputValues2.mPdfManager;
                int i = inputValues2.mCurrentPageIndex;
                String textToIdentifyForLanguage = pdfManager.getPageTextLength(i) > 0 ? TranslationOverlayManager.getTextToIdentifyForLanguage(i, pdfManager.getPageTextList(i)) : getBodyText(inputValues);
                if (textToIdentifyForLanguage.trim().isEmpty()) {
                    TaskAiSuggestionPdf.this.notifyCallback(false, new ResultValues(null));
                } else {
                    new LanguageIdentifier().identifyLanguage(textToIdentifyForLanguage, new LanguageIdentifier.AsyncCallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskAiSuggestionPdf.1.1
                        @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.common.LanguageIdentifier.AsyncCallback
                        public void onCompleted(Locale locale) {
                            Logger.m10999d(TaskAiSuggestionPdf.TAG, "identifyLanguage# identifiedLocale " + locale);
                            if (locale != null) {
                                TaskAiSuggestionPdf.this.notifyCallback(true, new ResultValues(locale));
                            } else {
                                Logger.m11000e(TaskAiSuggestionPdf.TAG, "identifyLanguage#onCompleted failed to identify");
                                TaskAiSuggestionPdf.this.notifyCallback(false, new ResultValues(locale));
                            }
                        }
                    });
                }
            }
        });
    }
}
