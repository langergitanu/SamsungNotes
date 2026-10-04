package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.context.presenter;

import android.graphics.RectF;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.core.util.Pair;
import androidx.glance.AbstractC2821a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.sdk.composer.pdf.SpenNotePdfCursorPosition;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTable;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.p151ai.common.AiMaxLength;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.PdfManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.TextManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.CursorChangedListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiCommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.pdf.TranslationOverlayManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.SrcContentInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span.ResolvableSpanObject;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.modelinput.span.ResolvableSpanObjectType;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.Task;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskSelectPdf;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SelectionText implements CursorChangedListenerImpl.TextSelectionChangedListener, PdfManager.PdfSelectionChangedListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_TEXT_LENGTH_AI_AUTO_SELECTION = 2000;
    private static final int MIN_STROKE_LENGTH_AI_SELECTION = 1;
    private static final int MIN_TEXT_LENGTH_FOR_AI_SELECTION = 200;
    private static final String TAG = Logger.createTag("SelectionText", AiConstants.PREFIX_TAG);
    private static final int VALID_STROKE_LENGTH_AI_SELECTION = 5;
    private final boolean mBlockAutoStartFlag;
    private boolean mCanStartAutomatically;
    private final ComposerViewPresenter mComposerViewPresenter;
    private final Contract mContract;
    private final ControllerManager mControllerManager;
    private Integer mPdfPageIndex;
    private final TranslationOverlayManager mTranslationOverlayManager;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        int getPageIndex();

        void onChanged(int i, int i2);

        void onReleasedSelection();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface MaxSelectionCallback {
        void onCompleted(boolean z);
    }

    public SelectionText(ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, TranslationOverlayManager translationOverlayManager, boolean z, Contract contract) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mControllerManager = controllerManager;
        this.mTranslationOverlayManager = translationOverlayManager;
        this.mContract = contract;
        this.mBlockAutoStartFlag = z;
    }

    private Pair<Integer, Integer> checkBodyText(SpenWNote spenWNote) {
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        ArrayList<SpenObjectBase> selectedObject = spenWNote.getSelectedObject();
        if (selectedObject == null || selectedObject.isEmpty() || !bodyText.equals(selectedObject.get(0))) {
            this.mComposerViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(false);
            spenWNote.selectObject(bodyText);
            this.mComposerViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(true);
        }
        int[] cursorFromFocusedTextBox = this.mComposerViewPresenter.getTextManager().getCursorFromFocusedTextBox();
        int i = cursorFromFocusedTextBox[0];
        int i2 = cursorFromFocusedTextBox[1];
        if (i != i2) {
            Pair<Integer, Integer> pairTrimText = trimText(bodyText, i, i2);
            if (pairTrimText.first.intValue() != -1 && (pairTrimText.second.intValue() + 1) - pairTrimText.first.intValue() > 0) {
                return pairTrimText;
            }
        }
        ISpenNoteTextManager spenNoteTextManager = this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager();
        spenNoteTextManager.lockBodyTextPage();
        Pair<Integer, Integer> pairFindSelection = findSelection(bodyText);
        spenNoteTextManager.unlockBodyTextPage();
        if (pairFindSelection == null) {
            return null;
        }
        return trimText(bodyText, pairFindSelection.first.intValue(), pairFindSelection.second.intValue());
    }

    private Pair<Integer, Integer> checkBodyTextForAiStartAutomatically(SpenWNote spenWNote) {
        SpenObjectTextBox bodyText = spenWNote.getBodyText();
        Pair<Integer, Integer> pairFindSelectionInNote = findSelectionInNote(bodyText);
        if (pairFindSelectionInNote == null) {
            return null;
        }
        return trimText(bodyText, pairFindSelectionInNote.first.intValue(), pairFindSelectionInNote.second.intValue());
    }

    private void checkToShowMaximum(int[] iArr) {
        if (iArr[1] >= iArr[0] + AiMaxLength.LEN_SELECTED_MAX) {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_MAX_LENGTH_TO_SELECT_TEXT, "c");
            AiCommonUtil.showCustomToast(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.ai_error_cannot_select_more_maximum_characters));
        }
    }

    private void executeSelectMaximumForPdfText(@Nullable final MaxSelectionCallback maxSelectionCallback) {
        this.mControllerManager.getTaskController().execute(new TaskSelectPdf(), new TaskSelectPdf.InputValues(this.mComposerViewPresenter.getPdfManager(), this.mComposerViewPresenter.getDoc(), this.mTranslationOverlayManager, this.mComposerViewPresenter.getCurrentPageIndex(), true), new Task.Callback<TaskSelectPdf.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionText.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskSelectPdf.ResultValues resultValues) {
                MaxSelectionCallback maxSelectionCallback2 = maxSelectionCallback;
                if (maxSelectionCallback2 != null) {
                    maxSelectionCallback2.onCompleted(false);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskSelectPdf.ResultValues resultValues) {
                SelectionText.this.mComposerViewPresenter.getPdfManager().setTextSelection(resultValues.getStartPosition(), resultValues.getEndPosition());
                SelectionText.this.mComposerViewPresenter.smoothScrollToPage(resultValues.getEndPosition().getPageIndex());
                if (resultValues.isNeedToShowMaximumToast()) {
                    ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_MAX_LENGTH_TO_SELECT_TEXT, "c");
                    AiCommonUtil.showCustomToast(SelectionText.this.mComposerViewPresenter.getActivity(), SelectionText.this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.ai_error_cannot_select_more_maximum_characters));
                }
                MaxSelectionCallback maxSelectionCallback2 = maxSelectionCallback;
                if (maxSelectionCallback2 != null) {
                    maxSelectionCallback2.onCompleted(true);
                }
            }
        }, false);
    }

    private void executeSelectNextPageForPdfText() {
        this.mControllerManager.getTaskController().execute(new TaskSelectPdf(), new TaskSelectPdf.InputValues(this.mComposerViewPresenter.getPdfManager(), this.mComposerViewPresenter.getDoc(), this.mTranslationOverlayManager, this.mComposerViewPresenter.getCurrentPageIndex(), false), new Task.Callback<TaskSelectPdf.ResultValues>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionText.2
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onError(TaskSelectPdf.ResultValues resultValues) {
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.Task.Callback
            public void onSuccess(TaskSelectPdf.ResultValues resultValues) {
                SelectionText.this.mComposerViewPresenter.getPdfManager().setTextSelection(resultValues.getStartPosition(), resultValues.getEndPosition());
                if (SelectionText.this.mComposerViewPresenter.getCurrentPageIndex() != resultValues.getEndPosition().getPageIndex()) {
                    SelectionText.this.mComposerViewPresenter.smoothScrollToPage(resultValues.getEndPosition().getPageIndex());
                }
                if (resultValues.isNeedToShowMaximumToast()) {
                    ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_MAX_LENGTH_TO_SELECT_TEXT, "c");
                    AiCommonUtil.showCustomToast(SelectionText.this.mComposerViewPresenter.getActivity(), SelectionText.this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.ai_error_cannot_select_more_maximum_characters));
                }
            }
        }, false);
    }

    private Pair<Integer, Integer> findSelection(SpenObjectTextBox spenObjectTextBox) {
        return this.mComposerViewPresenter.getComposerModel().isSingleMode() ? findSelectionInSingleNote() : findSelectionInPagesNote(spenObjectTextBox);
    }

    private Pair<Integer, Integer> findSelectionInNote(SpenObjectTextBox spenObjectTextBox) {
        String text = spenObjectTextBox.getText();
        int length = text != null ? text.length() : 0;
        if (length <= 0 || length > 2000) {
            return null;
        }
        Logger.m10999d(TAG, "findSelectionInNote# boxTextLength = " + length);
        return new Pair<>(0, Integer.valueOf(length));
    }

    private Pair<Integer, Integer> findSelectionInPagesNote(SpenObjectTextBox spenObjectTextBox) {
        int pageIndex = this.mContract.getPageIndex();
        int textSectionStart = spenObjectTextBox.getTextSectionStart(pageIndex);
        if (textSectionStart < 0) {
            Logger.m10999d(TAG, "findSelectionInPagesNote# fail to find cursor index of page");
            return null;
        }
        int iMax = Math.max(0, spenObjectTextBox.getTextSectionLength(pageIndex) + textSectionStart);
        if (textSectionStart < iMax) {
            return new Pair<>(Integer.valueOf(textSectionStart), Integer.valueOf(iMax));
        }
        Logger.m10999d(TAG, "findSelectionInPagesNote# text length of current page is 0");
        return null;
    }

    private Pair<Integer, Integer> findSelectionInSingleNote() {
        ISpenNoteTextManager spenNoteTextManager = this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager();
        int cursorSelectionStartOnScreenInBodyText = spenNoteTextManager.getCursorSelectionStartOnScreenInBodyText();
        if (cursorSelectionStartOnScreenInBodyText < 0) {
            Logger.m10999d(TAG, "findSelectionInSingleNote# fail to find cursor index of page");
            return null;
        }
        int cursorSelectionEndOnScreenInBodyText = spenNoteTextManager.getCursorSelectionEndOnScreenInBodyText();
        if (cursorSelectionStartOnScreenInBodyText < cursorSelectionEndOnScreenInBodyText) {
            return new Pair<>(Integer.valueOf(cursorSelectionStartOnScreenInBodyText), Integer.valueOf(cursorSelectionEndOnScreenInBodyText));
        }
        Logger.m10999d(TAG, "findSelectionInSingleNote# text length of current page is 0");
        return null;
    }

    public static String getBodyText(ComposerViewPresenter composerViewPresenter) {
        int textSectionStart;
        int iMax;
        SpenObjectTextBox bodyText = composerViewPresenter.getDoc().getBodyText();
        if (composerViewPresenter.getComposerModel().isSingleMode()) {
            ISpenNoteTextManager spenNoteTextManager = composerViewPresenter.getTextManager().getSpenNoteTextManager();
            textSectionStart = spenNoteTextManager.getCursorSelectionStartOnScreenInBodyText();
            if (textSectionStart < 0) {
                Logger.m10999d(TAG, "getBodyText# isSingleMode fail to find cursor index of page");
                return "";
            }
            iMax = spenNoteTextManager.getCursorSelectionEndOnScreenInBodyText();
            if (textSectionStart >= iMax) {
                Logger.m10999d(TAG, "getBodyText# isSingleMode text length of current page is 0");
                return "";
            }
        } else {
            int currentPageIndex = composerViewPresenter.getCurrentPageIndex();
            textSectionStart = bodyText.getTextSectionStart(currentPageIndex);
            if (textSectionStart < 0) {
                Logger.m10999d(TAG, "getBodyText# fail to find cursor index of page");
                return "";
            }
            iMax = Math.max(0, bodyText.getTextSectionLength(currentPageIndex) + textSectionStart);
            if (textSectionStart >= iMax) {
                Logger.m10999d(TAG, "getBodyText# text length of current page is 0");
                return "";
            }
        }
        return bodyText.getText().substring(textSectionStart, iMax);
    }

    private int getNextEndCursor(SpenObjectShape spenObjectShape, int i) {
        int textSectionLength = 0;
        int i2 = i;
        while (true) {
            if (i2 >= this.mComposerViewPresenter.getDoc().getPageCount()) {
                break;
            }
            textSectionLength = spenObjectShape.getTextSectionLength(i2);
            if (textSectionLength > 0) {
                i = i2;
                break;
            }
            i2++;
        }
        return spenObjectShape.getTextSectionStart(i) + textSectionLength;
    }

    private int getPdfPageTextLength(int i) {
        return this.mComposerViewPresenter.getPdfManager().getOverlayTextLength(i);
    }

    private boolean isCursorOnPage(int i, int i2) {
        int textSectionStart = this.mComposerViewPresenter.getDoc().getBodyText().getTextSectionStart(i2);
        return i >= textSectionStart && i < this.mComposerViewPresenter.getDoc().getBodyText().getTextSectionLength(i2) + textSectionStart;
    }

    private boolean isOnlySpace(SpenObjectShape spenObjectShape, int i, int i2) {
        try {
            return spenObjectShape.getText().substring(i, i2).trim().isEmpty();
        } catch (Exception e) {
            AbstractC8014b.m7207i("isOnlySpace# :", e, TAG);
            return false;
        }
    }

    private static void logSAForAIMaxLength(int i) {
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_MAX_LENGTH_TO_SELECT_TEXT, "b");
        ComposerSA.insertLog("401", ComposerSAConstants.EVENT_AI_MAX_LENGTH_TO_SELECT_TEXT_COUNT, ComposerSA.getDetailAiSelectedTextMaxLength(i, 10000, 5000, 5));
    }

    private void setSelectionBodyTextAndSmoothScroll(SpenObjectShape spenObjectShape, int[] iArr) {
        this.mComposerViewPresenter.setAutoScrollEnabled(false);
        spenObjectShape.setSelection(iArr[0], iArr[1]);
        this.mComposerViewPresenter.smoothScrollToPage(this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().getPageIndexByTextOfBodyText(Math.max(iArr[1] - 1, 0)));
        this.mComposerViewPresenter.setAutoScrollEnabled(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        r5 = r12 + r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private Pair<Integer, Integer> trimObjectSpan(ArrayList<SpenObjectSpan> arrayList, int i, int i2, String str) {
        int i4;
        int i5;
        this.mComposerViewPresenter.getTextManager().updateBodyObjectSpanPosition(i, i2 - i);
        Collections.sort(arrayList, new Comparator<SpenObjectSpan>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionText.1
            @Override // java.util.Comparator
            public int compare(SpenObjectSpan spenObjectSpan, SpenObjectSpan spenObjectSpan2) {
                return spenObjectSpan.getTextIndex() - spenObjectSpan2.getTextIndex();
            }
        });
        int length = str.length();
        int i6 = 0;
        int i7 = i;
        int i8 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            char cCharAt = str.charAt(i6);
            if (cCharAt != ' ' && cCharAt != '\n') {
                if (i8 >= arrayList.size() || (i5 = i + i6) != arrayList.get(i8).getTextIndex()) {
                    break;
                }
                if (!(arrayList.get(i8).getObj() instanceof SpenObjectTable)) {
                    i8++;
                    if (i6 == length - 1) {
                        i7 = i5;
                    }
                } else {
                    if (i5 == i2) {
                        return new Pair<>(Integer.valueOf(i5), Integer.valueOf(i2));
                    }
                    i7 = i5;
                }
            }
            i6++;
        }
        if (i7 == i2) {
            return new Pair<>(-1, -1);
        }
        int size = arrayList.size() - 1;
        int i9 = length - 1;
        while (true) {
            if (i9 < 0) {
                break;
            }
            char cCharAt2 = str.charAt(i9);
            if (cCharAt2 != ' ' && cCharAt2 != '\n') {
                if (size <= -1 || (i4 = i + i9) != arrayList.get(size).getTextIndex()) {
                    break;
                }
                if (arrayList.get(size).getObj() instanceof SpenObjectTable) {
                    i2 = i4;
                    break;
                }
                size--;
            }
            i9--;
        }
        i2 = i + i9;
        return new Pair<>(Integer.valueOf(i7), Integer.valueOf(i2));
    }

    private Pair<Integer, Integer> trimText(SpenObjectTextBox spenObjectTextBox, int i, int i2) {
        String strSubstring = spenObjectTextBox.getText() == null ? "" : spenObjectTextBox.getText().substring(i, i2);
        String strTrim = strSubstring.trim();
        if (TextUtils.isEmpty(strTrim)) {
            return new Pair<>(-1, -1);
        }
        int iIndexOf = strSubstring.indexOf(strTrim.charAt(0)) + i;
        int iLastIndexOf = strSubstring.lastIndexOf(strTrim.charAt(strTrim.length() - 1)) + i;
        ArrayList<SpenObjectSpan> arrayListFindObjectSpan = spenObjectTextBox.findObjectSpan(iIndexOf, iLastIndexOf);
        return (arrayListFindObjectSpan == null || arrayListFindObjectSpan.isEmpty()) ? new Pair<>(Integer.valueOf(iIndexOf), Integer.valueOf(iLastIndexOf)) : trimObjectSpan(arrayListFindObjectSpan, iIndexOf, iLastIndexOf, strTrim);
    }

    public Pair<Boolean, Boolean> canSelectMoreForText(boolean z) {
        boolean z2 = true;
        if (this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
            PdfManager pdfManager = this.mComposerViewPresenter.getPdfManager();
            SpenWNote doc = this.mComposerViewPresenter.getDoc();
            SpenNotePdfCursorPosition startSelectionCursorPosition = pdfManager.getStartSelectionCursorPosition();
            SpenNotePdfCursorPosition endSelectionCursorPosition = pdfManager.getEndSelectionCursorPosition();
            if (endSelectionCursorPosition.getPageIndex() == doc.getPageCount() - 1 || !hasMorePdf(doc, endSelectionCursorPosition.getPageIndex() + 1)) {
                int pdfPageTextLength = getPdfPageTextLength(endSelectionCursorPosition.getPageIndex());
                if (endSelectionCursorPosition.getCursorIndex() >= pdfPageTextLength - 1) {
                    AbstractC8014b.m7217s(pdfPageTextLength, "canSelectMoreForText# pdf last textLength = ", TAG);
                    if (z) {
                        z2 = this.mComposerViewPresenter.getPdfManager().getSelectedText().length() >= 200;
                    }
                    return new Pair<>(Boolean.FALSE, Boolean.valueOf(z2));
                }
            }
            int pageIndex = startSelectionCursorPosition.getPageIndex();
            int cursorIndex = 0;
            while (pageIndex <= endSelectionCursorPosition.getPageIndex()) {
                if (doc.getPageCount() <= pageIndex || doc.getPage(pageIndex).hasPDF()) {
                    if (pageIndex == startSelectionCursorPosition.getPageIndex()) {
                        cursorIndex = (pageIndex == endSelectionCursorPosition.getPageIndex() ? endSelectionCursorPosition.getCursorIndex() : getPdfPageTextLength(pageIndex)) - startSelectionCursorPosition.getCursorIndex();
                    } else {
                        cursorIndex = pageIndex == endSelectionCursorPosition.getPageIndex() ? endSelectionCursorPosition.getCursorIndex() + cursorIndex : cursorIndex + getPdfPageTextLength(pageIndex);
                    }
                    if (cursorIndex >= AiMaxLength.LEN_SELECTED_MAX) {
                        Logger.m11003i(TAG, "canSelectMoreForText# pdf selectedLength = " + cursorIndex);
                        return new Pair<>(Boolean.FALSE, Boolean.TRUE);
                    }
                }
                pageIndex++;
            }
            if (z) {
                if (cursorIndex >= 200) {
                    z = true;
                }
            }
            return new Pair<>(Boolean.TRUE, Boolean.valueOf(z2));
        }
        SpenObjectShape textBox = this.mComposerViewPresenter.getTextManager().getTextBox();
        int[] cursor = this.mComposerViewPresenter.getTextManager().getCursor(textBox);
        int i = cursor[1] - cursor[0];
        if (i >= AiMaxLength.LEN_SELECTED_MAX) {
            Logger.m11003i(TAG, "canSelectMoreForText# text selectedLength = " + i);
            return new Pair<>(Boolean.FALSE, Boolean.TRUE);
        }
        z = !z || i >= 200;
        if (textBox.getText() != null && cursor[1] >= textBox.getText().length()) {
            return new Pair<>(Boolean.FALSE, Boolean.valueOf(z));
        }
        z2 = z;
        return new Pair<>(Boolean.TRUE, Boolean.valueOf(z2));
    }

    public boolean canStartAutomatically() {
        return this.mCanStartAutomatically;
    }

    public boolean canStartBodyText(SpenWNote spenWNote) {
        SpenObjectTextBox bodyText;
        android.util.Pair<Integer, Integer> cursorRangeByRectInBodytext;
        if (this.mComposerViewPresenter.getComposerModel().isPDFReader()) {
            return false;
        }
        if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
            RectF contentRectInView = this.mComposerViewPresenter.getObjectManager().getNoteZoomScroller().getContentRectInView();
            int size = spenWNote.getPage(0).findObjectInRect(1, contentRectInView, false).size();
            if (size <= 1) {
                return true;
            }
            return size <= 5 && (cursorRangeByRectInBodytext = this.mComposerViewPresenter.getTextManager().getCursorRangeByRectInBodytext(contentRectInView)) != null && ((Integer) cursorRangeByRectInBodytext.second).intValue() - ((Integer) cursorRangeByRectInBodytext.first).intValue() >= 200;
        }
        int objectCount = spenWNote.getPage(this.mContract.getPageIndex()).getObjectCount(1, false);
        if (objectCount <= 1) {
            return true;
        }
        if (objectCount <= 5 && (bodyText = this.mComposerViewPresenter.getNoteManager().getBodyText(this.mContract.getPageIndex())) != null && bodyText.getText() != null && bodyText.getText().length() >= 200) {
            return true;
        }
        return false;
    }

    public boolean canStartPdf(SpenWNote spenWNote) {
        return this.mComposerViewPresenter.getComposerModel().isPDFReader() ? selectPdfTextMin(spenWNote, this.mContract.getPageIndex(), false) : selectPdfText(spenWNote, this.mContract.getPageIndex(), false);
    }

    public void clear(boolean z) {
        this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().setCursorSelectionMaxLength(0);
        this.mComposerViewPresenter.getPdfManager().setCursorSelectionMaxLength(0);
        if (z) {
            this.mComposerViewPresenter.getListenerManager().setTextSelectionChangedListener(null);
        }
    }

    public List<ResolvableSpanObject> getResolvableSpanObjectList(int i) {
        ResolvableSpanObjectType resolvableSpanObjectTypeFrom;
        TextManager textManager = this.mComposerViewPresenter.getTextManager();
        SpenObjectShape textBox = textManager.getTextBox();
        int[] cursorFromFocusedTextBox = textManager.getCursorFromFocusedTextBox();
        ArrayList<SpenObjectSpan> arrayListFindObjectSpan = textBox.findObjectSpan(cursorFromFocusedTextBox[0], cursorFromFocusedTextBox[1]);
        ArrayList arrayList = new ArrayList();
        if (arrayListFindObjectSpan != null) {
            for (SpenObjectSpan spenObjectSpan : arrayListFindObjectSpan) {
                SpenObjectBase obj = spenObjectSpan.getObj();
                if (obj != null && (resolvableSpanObjectTypeFrom = ResolvableSpanObjectType.INSTANCE.from(obj.getType())) != ResolvableSpanObjectType.OTHER) {
                    arrayList.add(new ResolvableSpanObject(spenObjectSpan.getTextIndex() - i, resolvableSpanObjectTypeFrom, resolvableSpanObjectTypeFrom.replace(obj)));
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SrcContentInfo getSrcContentInfo() {
        PdfManager pdfManager = this.mComposerViewPresenter.getPdfManager();
        String selectedText = pdfManager.getSelectedText();
        if (!TextUtils.isEmpty(selectedText)) {
            SrcContentInfo srcContentInfo = new SrcContentInfo(selectedText);
            Integer num = this.mPdfPageIndex;
            int pageIndex = num == null ? this.mContract.getPageIndex() : num.intValue();
            srcContentInfo.setSrcPageIndex(pageIndex, pageIndex);
            srcContentInfo.setPdfStartPos(new SrcContentInfo.PdfSelectionPos(pdfManager.getStartSelectionCursorPosition()));
            srcContentInfo.setPdfEndPos(new SrcContentInfo.PdfSelectionPos(pdfManager.getEndSelectionCursorPosition()));
            return srcContentInfo;
        }
        TextManager textManager = this.mComposerViewPresenter.getTextManager();
        int[] cursorFromFocusedTextBox = textManager.getCursorFromFocusedTextBox();
        String selectedText2 = textManager.getSelectedText();
        if (selectedText2 == null) {
            Logger.m11000e(TAG, "getSrcContentInfo# selectedText is null");
            return null;
        }
        int i = cursorFromFocusedTextBox[0];
        SrcContentInfo srcContentInfo2 = new SrcContentInfo(selectedText2, i, cursorFromFocusedTextBox[1], getResolvableSpanObjectList(i));
        if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
            srcContentInfo2.setSrcPageIndex(0, 0);
            return srcContentInfo2;
        }
        int pageIndexByCursorOfBodyText = this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().getPageIndexByCursorOfBodyText(cursorFromFocusedTextBox[0]);
        String str = TAG;
        AbstractC8014b.m7195A(AbstractC0541b.m778t(pageIndexByCursorOfBodyText, "getSrcContentInfo# first startPageIndex ", " / pos "), str, cursorFromFocusedTextBox[0]);
        if (pageIndexByCursorOfBodyText > 0) {
            int i2 = pageIndexByCursorOfBodyText - 1;
            if (isCursorOnPage(cursorFromFocusedTextBox[0], i2)) {
                AbstractC8014b.m7217s(i2, "getSrcContentInfo# 1 startPageIndex ", str);
                pageIndexByCursorOfBodyText = i2;
            } else {
                int i4 = pageIndexByCursorOfBodyText + 1;
                if (isCursorOnPage(cursorFromFocusedTextBox[0], i4)) {
                    AbstractC8014b.m7217s(i4, "getSrcContentInfo# 2 startPageIndex ", str);
                    pageIndexByCursorOfBodyText = i4;
                }
            }
        }
        srcContentInfo2.setSrcPageIndex(pageIndexByCursorOfBodyText, pageIndexByCursorOfBodyText);
        return srcContentInfo2;
    }

    public boolean hasMorePdf(SpenWNote spenWNote, int i) {
        while (i < spenWNote.getPageCount()) {
            if (spenWNote.getPage(i).hasPDF()) {
                return true;
            }
            i++;
        }
        return false;
    }

    public void matchSelectionRange(SrcContentInfo srcContentInfo) {
        int pdfPageTextLength;
        int cursorIndex;
        if (srcContentInfo.getSrcType() == 1) {
            if (this.mComposerViewPresenter.getTextManager().getSelectedText() != null && srcContentInfo.getSelectedText().length() < this.mComposerViewPresenter.getTextManager().getSelectedText().length()) {
                this.mComposerViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(true);
                this.mComposerViewPresenter.getDoc().getBodyText().setSelection(srcContentInfo.mStartPos, srcContentInfo.mEndPos);
                return;
            }
            return;
        }
        if (srcContentInfo.getSrcType() == 0) {
            PdfManager pdfManager = this.mComposerViewPresenter.getPdfManager();
            SpenNotePdfCursorPosition startSelectionCursorPosition = pdfManager.getStartSelectionCursorPosition();
            SpenNotePdfCursorPosition endSelectionCursorPosition = pdfManager.getEndSelectionCursorPosition();
            int length = srcContentInfo.getSelectedText().length();
            Logger.m10999d(TAG, "matchSelectionRange# limit length: " + length);
            int pageIndex = startSelectionCursorPosition.getPageIndex();
            while (pageIndex <= endSelectionCursorPosition.getPageIndex()) {
                if (pageIndex == startSelectionCursorPosition.getPageIndex()) {
                    pdfPageTextLength = pageIndex == endSelectionCursorPosition.getPageIndex() ? endSelectionCursorPosition.getCursorIndex() : getPdfPageTextLength(pageIndex);
                    cursorIndex = pdfPageTextLength - startSelectionCursorPosition.getCursorIndex();
                } else if (pageIndex == endSelectionCursorPosition.getPageIndex()) {
                    pdfPageTextLength = endSelectionCursorPosition.getCursorIndex();
                    cursorIndex = endSelectionCursorPosition.getCursorIndex();
                } else {
                    pdfPageTextLength = getPdfPageTextLength(pageIndex);
                    cursorIndex = pdfPageTextLength;
                }
                length -= cursorIndex;
                String str = TAG;
                StringBuilder sbM1173s = AbstractC0622a.m1173s(pageIndex, length, "matchSelectionRange# page ", ": ", " (");
                sbM1173s.append(pdfPageTextLength);
                sbM1173s.append(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                sbM1173s.append(cursorIndex);
                Logger.m10999d(str, sbM1173s.toString());
                if (length <= 0) {
                    pdfManager.setTextSelection(startSelectionCursorPosition, new SpenNotePdfCursorPosition(pageIndex, pdfPageTextLength + length));
                    if (this.mComposerViewPresenter.getCurrentPageIndex() != pageIndex) {
                        this.mComposerViewPresenter.smoothScrollToPage(pageIndex);
                        return;
                    }
                    return;
                }
                pageIndex++;
            }
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.CursorChangedListenerImpl.TextSelectionChangedListener
    public void onChanged(int i, int i2) {
        if (i == i2) {
            this.mContract.onReleasedSelection();
        } else {
            this.mContract.onChanged(i, i2);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.PdfManager.PdfSelectionChangedListener
    public void onCursorChanged(SpenNotePdfCursorPosition spenNotePdfCursorPosition, SpenNotePdfCursorPosition spenNotePdfCursorPosition2) {
        if (this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().isNeedToReleaseAiSelectionOnFirstMove()) {
            this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().setNeedToReleaseAiSelectionOnFirstMove(false);
            this.mComposerViewPresenter.getComposerControllerManager().getComposerAiController().clearAiTextFormat();
        }
        if (spenNotePdfCursorPosition.getPageIndex() == -1 && spenNotePdfCursorPosition2.getCursorIndex() == -1) {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                this.mContract.onReleasedSelection();
            } else {
                this.mComposerViewPresenter.getHandler().post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.context.presenter.SelectionText.4
                    @Override // java.lang.Runnable
                    public void run() {
                        SelectionText.this.mContract.onReleasedSelection();
                    }
                });
            }
        }
        this.mContract.onChanged(spenNotePdfCursorPosition.getCursorIndex(), spenNotePdfCursorPosition2.getCursorIndex());
    }

    public void selectMaximumForText(@Nullable MaxSelectionCallback maxSelectionCallback) {
        if (this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
            executeSelectMaximumForPdfText(maxSelectionCallback);
            return;
        }
        SpenObjectShape textBox = this.mComposerViewPresenter.getTextManager().getTextBox();
        int[] cursor = this.mComposerViewPresenter.getTextManager().getCursor(textBox);
        cursor[1] = Math.min(cursor[0] + AiMaxLength.LEN_SELECTED_MAX, textBox.getText().length());
        setSelectionBodyTextAndSmoothScroll(textBox, cursor);
        checkToShowMaximum(cursor);
        if (maxSelectionCallback != null) {
            maxSelectionCallback.onCompleted(true);
        }
    }

    public void selectNextPageForText() {
        if (this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
            executeSelectNextPageForPdfText();
            return;
        }
        SpenObjectShape textBox = this.mComposerViewPresenter.getTextManager().getTextBox();
        int[] cursor = this.mComposerViewPresenter.getTextManager().getCursor(textBox);
        int pageIndexByTextOfBodyText = this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().getPageIndexByTextOfBodyText(Math.max(cursor[1] - 1, 0));
        int textCountByPage = this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().getTextCountByPage(pageIndexByTextOfBodyText) + this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().getTextStartByPage(pageIndexByTextOfBodyText);
        String str = TAG;
        StringBuilder sb = new StringBuilder("extendSelectionForText# :");
        AbstractC2821a.m2235z(sb, cursor[1], pageIndexByTextOfBodyText, " page = ", " / endInPageBodyText = ");
        AbstractC8014b.m7221w(sb, str, textCountByPage);
        int i = cursor[1];
        if (i < textCountByPage) {
            if (isOnlySpace(textBox, i, textCountByPage)) {
                cursor[1] = getNextEndCursor(textBox, pageIndexByTextOfBodyText + 1);
            } else {
                cursor[1] = textCountByPage;
            }
        } else {
            if (i != textCountByPage) {
                this.mComposerViewPresenter.getObjectManager().getNoteZoomScroller().scrollToContentRect(this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager().getCursorRect(textBox, cursor[1]));
                return;
            }
            cursor[1] = getNextEndCursor(textBox, pageIndexByTextOfBodyText + 1);
        }
        int i2 = cursor[0];
        int i4 = AiMaxLength.LEN_SELECTED_MAX;
        if (i2 + i4 < cursor[1]) {
            cursor[1] = Math.min(i2 + i4, textBox.getText().length());
        }
        setSelectionBodyTextAndSmoothScroll(textBox, cursor);
        checkToShowMaximum(cursor);
    }

    public boolean selectPdfText(SpenWNote spenWNote, int i, boolean z) {
        if (!spenWNote.getPage(i).hasPDF()) {
            return false;
        }
        if (this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
            if (z) {
                this.mComposerViewPresenter.getPdfManager().setPdfSelectionChangedListener(this);
            }
            return true;
        }
        if (!this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
            int overlayTextLength = this.mComposerViewPresenter.getPdfManager().getOverlayTextLength(i);
            if (overlayTextLength < 200) {
                return false;
            }
            if (z) {
                this.mComposerViewPresenter.getPdfManager().selectText(i, 0, overlayTextLength);
                this.mPdfPageIndex = Integer.valueOf(i);
                this.mComposerViewPresenter.getPdfManager().setPdfSelectionChangedListener(this);
            }
        } else {
            if (this.mComposerViewPresenter.getPdfManager().getTextLengthOnScreen() < 200) {
                return false;
            }
            if (z) {
                this.mComposerViewPresenter.getPdfManager().selectTextOnScreen();
                this.mPdfPageIndex = Integer.valueOf(i);
                this.mComposerViewPresenter.getPdfManager().setPdfSelectionChangedListener(this);
            }
        }
        return true;
    }

    public boolean selectPdfTextMin(SpenWNote spenWNote, int i, boolean z) {
        if (!spenWNote.getPage(i).hasPDF()) {
            return false;
        }
        if (this.mComposerViewPresenter.getComposerModel().isSingleMode()) {
            if (this.mComposerViewPresenter.getPdfManager().getTextLengthOnScreen() <= 0) {
                return false;
            }
            if (!z) {
                return true;
            }
            this.mComposerViewPresenter.getPdfManager().selectTextOnScreen();
            this.mPdfPageIndex = Integer.valueOf(i);
            this.mComposerViewPresenter.getPdfManager().setPdfSelectionChangedListener(this);
            return true;
        }
        int overlayTextLength = this.mComposerViewPresenter.getPdfManager().getOverlayTextLength(i);
        if (overlayTextLength <= 0) {
            return false;
        }
        if (!z) {
            return true;
        }
        this.mComposerViewPresenter.getPdfManager().selectText(i, 0, overlayTextLength);
        this.mPdfPageIndex = Integer.valueOf(i);
        this.mComposerViewPresenter.getPdfManager().setPdfSelectionChangedListener(this);
        return true;
    }

    public Pair<Integer, Integer> startSelectBodyText(SpenObjectTextBox spenObjectTextBox, boolean z) {
        ISpenNoteTextManager spenNoteTextManager = this.mComposerViewPresenter.getTextManager().getSpenNoteTextManager();
        spenNoteTextManager.lockBodyTextPage();
        Pair<Integer, Integer> pairFindSelection = findSelection(spenObjectTextBox);
        spenNoteTextManager.unlockBodyTextPage();
        if (pairFindSelection == null) {
            return null;
        }
        Pair<Integer, Integer> pairTrimText = trimText(spenObjectTextBox, pairFindSelection.first.intValue(), pairFindSelection.second.intValue());
        if (z) {
            if (((pairTrimText == null || pairTrimText.first.intValue() == -1) ? 0 : (pairTrimText.second.intValue() + 1) - pairTrimText.first.intValue()) > 0) {
                this.mComposerViewPresenter.getDoc().selectObject(this.mComposerViewPresenter.getDoc().getBodyText());
                this.mComposerViewPresenter.getTextManager().setFocusedTextBox(this.mComposerViewPresenter.getDoc().getBodyText());
                this.mComposerViewPresenter.getDoc().getBodyText().setSelection(pairTrimText.first.intValue(), pairTrimText.second.intValue() + 1);
                this.mComposerViewPresenter.getListenerManager().setTextSelectionChangedListener(this);
            }
        }
        return pairTrimText;
    }

    public boolean startTextSelection(boolean z) {
        Pair<Integer, Integer> pairCheckBodyTextForAiStartAutomatically;
        this.mCanStartAutomatically = false;
        SpenWNote doc = this.mComposerViewPresenter.getDoc();
        AbstractC8014b.m7220v("startTextSelection# select : ", TAG, z);
        if (this.mComposerViewPresenter.getPdfManager().hasSelectedText()) {
            if (z) {
                this.mComposerViewPresenter.getPdfManager().setPdfSelectionChangedListener(this);
            }
            return true;
        }
        if (this.mComposerViewPresenter.getComposerModel().isPDFReader()) {
            return selectPdfTextMin(doc, this.mContract.getPageIndex(), z);
        }
        Pair<Integer, Integer> pairCheckBodyText = checkBodyText(doc);
        int iIntValue = pairCheckBodyText != null ? pairCheckBodyText.second.intValue() - pairCheckBodyText.first.intValue() : 0;
        int[] cursorFromFocusedTextBox = this.mComposerViewPresenter.getTextManager().getCursorFromFocusedTextBox();
        if (cursorFromFocusedTextBox[0] != cursorFromFocusedTextBox[1] && iIntValue > 0) {
            if (z && iIntValue > AiMaxLength.LEN_SELECTED_MAX) {
                logSAForAIMaxLength(iIntValue);
                this.mComposerViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(true);
                SpenObjectTextBox bodyText = this.mComposerViewPresenter.getDoc().getBodyText();
                int i = cursorFromFocusedTextBox[0];
                bodyText.setSelection(i, AiMaxLength.LEN_SELECTED_MAX + i);
                AiCommonUtil.showCustomToast(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.ai_error_reselect_maximum_characters));
            }
            this.mComposerViewPresenter.getListenerManager().setTextSelectionChangedListener(this);
            return true;
        }
        if (iIntValue >= AiMaxLength.LEN_SELECTED_MAX) {
            if (z && pairCheckBodyText != null) {
                logSAForAIMaxLength(iIntValue);
                this.mComposerViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(true);
                this.mComposerViewPresenter.getDoc().getBodyText().setSelection(pairCheckBodyText.first.intValue(), iIntValue <= AiMaxLength.LEN_SELECTED_MAX ? pairCheckBodyText.second.intValue() + 1 : pairCheckBodyText.first.intValue() + AiMaxLength.LEN_SELECTED_MAX);
                AiCommonUtil.showCustomToast(this.mComposerViewPresenter.getActivity(), this.mComposerViewPresenter.getActivity().getResources().getString(C9086R.string.ai_error_reselect_maximum_characters));
                this.mComposerViewPresenter.getListenerManager().setTextSelectionChangedListener(this);
            }
            return true;
        }
        if (selectPdfText(doc, this.mContract.getPageIndex(), false)) {
            if (z) {
                this.mComposerViewPresenter.getObjectManager().clearSelectObject();
                selectPdfText(doc, this.mContract.getPageIndex(), true);
            }
            return true;
        }
        if (!this.mBlockAutoStartFlag && iIntValue > 0 && (pairCheckBodyTextForAiStartAutomatically = checkBodyTextForAiStartAutomatically(doc)) != null) {
            this.mCanStartAutomatically = true;
            iIntValue = pairCheckBodyTextForAiStartAutomatically.second.intValue() - pairCheckBodyTextForAiStartAutomatically.first.intValue();
            pairCheckBodyText = pairCheckBodyTextForAiStartAutomatically;
        }
        if (iIntValue > 0 && z && pairCheckBodyText != null) {
            this.mComposerViewPresenter.getDoc().getBodyText().setSelection(pairCheckBodyText.first.intValue(), pairCheckBodyText.second.intValue() + 1);
            this.mComposerViewPresenter.getListenerManager().setTextSelectionChangedListener(this);
        } else if (iIntValue == 0 && pairCheckBodyText != null && pairCheckBodyText.first.intValue() != -1) {
            this.mComposerViewPresenter.getDoc().getBodyText().setSelection(pairCheckBodyText.first.intValue(), pairCheckBodyText.first.intValue() + 1);
            this.mComposerViewPresenter.getListenerManager().setTextSelectionChangedListener(this);
            iIntValue = 1;
        }
        if (iIntValue > 0) {
            return true;
        }
        return selectPdfTextMin(doc, this.mContract.getPageIndex(), z);
    }
}
