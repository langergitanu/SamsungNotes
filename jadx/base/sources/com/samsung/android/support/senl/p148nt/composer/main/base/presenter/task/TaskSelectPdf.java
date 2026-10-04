package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfCursorPosition;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationOverlayManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TaskSelectPdf extends SingleThreadTask<InputValues, ResultValues> {
    private static final String TAG = Logger.createTag("TaskSelectPdf");
    private boolean mIsCanceled;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class InputValues implements Task.InputValues {
        boolean mIsMaximum;
        SpenWNote mNote;
        PdfManager mPdfManager;
        int mStartPageIndex;
        TranslationOverlayManager mTranslationOverlayManager;

        public InputValues(PdfManager pdfManager, SpenWNote spenWNote, TranslationOverlayManager translationOverlayManager, int i, boolean z) {
            this.mPdfManager = pdfManager;
            this.mNote = spenWNote;
            this.mTranslationOverlayManager = translationOverlayManager;
            this.mStartPageIndex = i;
            this.mIsMaximum = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ResultValues implements Task.ResultValues {
        SpenNotePdfCursorPosition mEndPosition;
        boolean mIsNeedToShowMaximumToast;
        SpenNotePdfCursorPosition mStartPosition;

        public ResultValues(SpenNotePdfCursorPosition spenNotePdfCursorPosition, SpenNotePdfCursorPosition spenNotePdfCursorPosition2, boolean z) {
            this.mStartPosition = spenNotePdfCursorPosition;
            this.mEndPosition = spenNotePdfCursorPosition2;
            this.mIsNeedToShowMaximumToast = z;
        }

        public SpenNotePdfCursorPosition getEndPosition() {
            return this.mEndPosition;
        }

        public SpenNotePdfCursorPosition getStartPosition() {
            return this.mStartPosition;
        }

        public boolean isNeedToShowMaximumToast() {
            return this.mIsNeedToShowMaximumToast;
        }
    }

    private void executeToSelectMaximum(final InputValues inputValues) {
        this.mExecutorService.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskSelectPdf.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                InputValues inputValues2 = inputValues;
                PdfManager pdfManager = inputValues2.mPdfManager;
                SpenWNote spenWNote = inputValues2.mNote;
                TaskSelectPdf.waitToCompleteForTranslation(inputValues2, inputValues2.mStartPageIndex);
                SpenNotePdfCursorPosition startSelectionCursorPosition = pdfManager.getStartSelectionCursorPosition();
                SpenNotePdfCursorPosition endSelectionCursorPosition = pdfManager.getEndSelectionCursorPosition();
                int pageIndex = startSelectionCursorPosition.getPageIndex();
                int pageCount = spenWNote.getPageCount();
                int i = pageIndex;
                int i2 = i;
                int cursorIndex = 0;
                int overlayTextLength = 0;
                while (i < pageCount) {
                    if (spenWNote.getPage(i).hasPDF()) {
                        if (TaskSelectPdf.this.mIsCanceled) {
                            break;
                        }
                        TaskSelectPdf.waitToCompleteForTranslation(inputValues, i);
                        if (TaskSelectPdf.this.mIsCanceled) {
                            break;
                        }
                        overlayTextLength = pdfManager.getOverlayTextLength(i);
                        cursorIndex += i == pageIndex ? overlayTextLength - startSelectionCursorPosition.getCursorIndex() : overlayTextLength;
                        int i4 = AiMaxLength.LEN_SELECTED_MAX;
                        if (cursorIndex >= i4) {
                            int i5 = cursorIndex - i4;
                            overlayTextLength -= i5;
                            cursorIndex -= i5;
                            z = true;
                            break;
                        }
                        i2 = i;
                    }
                    i++;
                }
                z = false;
                i = i2;
                String str = TaskSelectPdf.TAG;
                StringBuilder sbM778t = AbstractC0541b.m778t(i, "selectMaximumContent# pdf page ", ": ");
                AbstractC2821a.m2235z(sbM778t, AiMaxLength.LEN_SELECTED_MAX, overlayTextLength, " (", CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                AbstractC8014b.m7195A(sbM778t, str, cursorIndex);
                if (TaskSelectPdf.this.mIsCanceled) {
                    TaskSelectPdf.this.notifyCallback(false, new ResultValues(startSelectionCursorPosition, endSelectionCursorPosition, false));
                } else {
                    TaskSelectPdf.this.notifyCallback(true, new ResultValues(startSelectionCursorPosition, new SpenNotePdfCursorPosition(i, overlayTextLength), z));
                }
            }
        });
    }

    private void executeToSelectNextPage(final InputValues inputValues) {
        this.mExecutorService.submit(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskSelectPdf.3
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                InputValues inputValues2 = inputValues;
                PdfManager pdfManager = inputValues2.mPdfManager;
                SpenWNote spenWNote = inputValues2.mNote;
                TaskSelectPdf.waitToCompleteForTranslation(inputValues2, inputValues2.mStartPageIndex);
                SpenNotePdfCursorPosition startSelectionCursorPosition = pdfManager.getStartSelectionCursorPosition();
                SpenNotePdfCursorPosition endSelectionCursorPosition = pdfManager.getEndSelectionCursorPosition();
                int i = AiMaxLength.LEN_SELECTED_MAX;
                int pageIndex = startSelectionCursorPosition.getPageIndex();
                int cursorIndex = 0;
                int i2 = 0;
                while (pageIndex < spenWNote.getPageCount() && !TaskSelectPdf.this.mIsCanceled) {
                    if (spenWNote.getPage(pageIndex).hasPDF()) {
                        TaskSelectPdf.waitToCompleteForTranslation(inputValues, pageIndex);
                        if (TaskSelectPdf.this.mIsCanceled) {
                            break;
                        }
                        int overlayTextLength = pdfManager.getOverlayTextLength(pageIndex);
                        if (pageIndex == startSelectionCursorPosition.getPageIndex()) {
                            cursorIndex = overlayTextLength - startSelectionCursorPosition.getCursorIndex();
                        } else {
                            int i4 = cursorIndex + overlayTextLength;
                            if (i4 >= i) {
                                i2 = i - cursorIndex;
                                z = true;
                                break;
                            } else {
                                cursorIndex = i4;
                                i2 = overlayTextLength;
                            }
                        }
                        if (pageIndex == endSelectionCursorPosition.getPageIndex()) {
                            overlayTextLength--;
                            if (endSelectionCursorPosition.getCursorIndex() < overlayTextLength) {
                                z = false;
                                i2 = overlayTextLength;
                                break;
                            }
                        } else if (pageIndex > endSelectionCursorPosition.getPageIndex()) {
                            z = false;
                            i2 = overlayTextLength;
                            break;
                        }
                    }
                    pageIndex++;
                }
                z = false;
                String str = TaskSelectPdf.TAG;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(pageIndex, i, "selectNextPageForText# pdf page ", ": ", " (");
                sbM1173s.append(i2);
                sbM1173s.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                sbM1173s.append(cursorIndex);
                Logger.m11003i(str, sbM1173s.toString());
                if (TaskSelectPdf.this.mIsCanceled) {
                    TaskSelectPdf.this.notifyCallback(false, new ResultValues(startSelectionCursorPosition, endSelectionCursorPosition, false));
                } else {
                    TaskSelectPdf.this.notifyCallback(true, new ResultValues(startSelectionCursorPosition, new SpenNotePdfCursorPosition(Math.min(pageIndex, spenWNote.getPageCount() - 1), i2), z));
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean waitToCompleteForTranslation(InputValues inputValues, int i) {
        boolean zBooleanValue;
        if (!inputValues.mTranslationOverlayManager.isActivated() || inputValues.mTranslationOverlayManager.isTranslated(i)) {
            return true;
        }
        Logger.m11003i(TAG, "waitToCompleteForTranslation# pageIndex start" + i);
        final CompletableFuture completableFuture = new CompletableFuture();
        inputValues.mTranslationOverlayManager.requestTranslate(i, new TranslationOverlayManager.TaskListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.TaskSelectPdf.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.TaskListener
            public void onCompleted() {
                Logger.m11003i(TaskSelectPdf.TAG, "waitToCompleteForTranslation# onCompleted");
                completableFuture.complete(Boolean.TRUE);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.TaskListener
            public void onFailed(int i2, @NonNull String str) {
                AbstractC8014b.m7197C("waitToCompleteForTranslation# onFailed", str, TaskSelectPdf.TAG);
                completableFuture.complete(Boolean.FALSE);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.pdf.TranslationOverlayManager.TaskListener
            public void onProgress(int i2, int i4) {
            }
        });
        try {
            zBooleanValue = ((Boolean) completableFuture.get(10L, TimeUnit.SECONDS)).booleanValue();
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            AbstractC8014b.m7207i("waitToCompleteForTranslation, e: ", e, TAG);
            zBooleanValue = false;
        }
        AbstractC8014b.m7224z("waitToCompleteForTranslation# pageIndex end : result = ", TAG, zBooleanValue);
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void cancel(Task.ICancelCallback iCancelCallback) {
        Logger.m11003i(TAG, "cancel ");
        this.mIsCanceled = true;
        if (iCancelCallback != null) {
            iCancelCallback.onCancel(true);
        }
        clear();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task
    public void executeTask(InputValues inputValues) {
        String str = TAG;
        Logger.m11003i(str, "executeTask# : mIsMaximum = " + inputValues.mIsMaximum);
        this.mExecutorService = Executors.newSingleThreadExecutor(new SenlThreadFactory(str));
        if (inputValues.mIsMaximum) {
            executeToSelectMaximum(inputValues);
        } else {
            executeToSelectNextPage(inputValues);
        }
    }
}
