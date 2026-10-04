package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.StringRes;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.composer.text.SpenBodyTextContext;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.document.textspan.SpenAlignmentParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenObjectSpan;
import com.samsung.android.sdk.pen.document.textspan.SpenTextParagraphBase;
import com.samsung.android.sdk.pen.document.textspan.SpenTextSpanBase;
import com.samsung.android.sdk.pen.setting.color.SpenColorThemeUtil;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.access.composer.ComposerAccessHandler;
import com.samsung.android.support.senl.p148nt.base.common.util.ContextUtils;
import com.samsung.android.support.senl.p148nt.base.composer.clipboard.ClipboardCacheManager;
import com.samsung.android.support.senl.p148nt.base.composer.text.common.TextUtil;
import com.samsung.android.support.senl.p148nt.base.winset.toast.ToastHandler;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.object.ObjectTextFactory;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.common.AiConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultParser;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskActionSend;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCopy;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ResultOperation {
    private static final String TAG = Logger.createTag("ResultOperation", AiConstants.PREFIX_TAG);
    private List<SpenObjectBase> mAnchorObjectsOnOverwrite = null;
    private boolean shouldRemoveTableOnOverwrite = false;
    private boolean shouldRemoveCodeBlockOnOverwrite = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum AddTo {
        NewPageBefore(C9086R.string.ai_add_to_new_page_before),
        EndOfNote(C9086R.string.ai_add_to_end_of_note),
        NewNote(C9086R.string.ai_add_to_new_note),
        NearContent(C9086R.string.ai_action_add_to_note);


        @StringRes
        final int mDisplayNameId;

        AddTo(@StringRes int i) {
            this.mDisplayNameId = i;
        }

        @StringRes
        public int getDisplayName() {
            return this.mDisplayNameId;
        }
    }

    private boolean checkTextLimitToInsert(ComposerViewPresenter composerViewPresenter, SpenWNote spenWNote, SpenObjectTextBox spenObjectTextBox) {
        if (spenWNote.getBodyText().getText() != null && spenObjectTextBox.getText() != null) {
            if (spenObjectTextBox.getText().length() + spenWNote.getBodyText().getText().length() > 350000) {
                Context context = composerViewPresenter.getView().getContext();
                ToastHandler.show(context, context.getString(C9086R.string.ss_maximum_number_of_characters_exceeded, 350000), 0);
                return false;
            }
        }
        return true;
    }

    private void convertColor(ComposerViewPresenter composerViewPresenter, SpenObjectTextBox spenObjectTextBox) {
        if (composerViewPresenter.getNoteManager().getBackgroundColor() != composerViewPresenter.getActivity().getColor(C9086R.color.composer_main_background_dark)) {
            return;
        }
        ArrayList<SpenTextSpanBase> textSpan = spenObjectTextBox.getTextSpan();
        int color = composerViewPresenter.getActivity().getColor(C9086R.color.composer_light_font_color);
        int color2 = Color.parseColor("#fafafa");
        int i = 0;
        for (SpenTextSpanBase spenTextSpanBase : textSpan) {
            if (spenTextSpanBase.getType() == 1 && (spenTextSpanBase instanceof SpenForegroundColorSpan)) {
                SpenForegroundColorSpan spenForegroundColorSpan = (SpenForegroundColorSpan) spenTextSpanBase;
                i++;
                Logger.m10999d(TAG, "convertColor# color : " + spenForegroundColorSpan.getColor());
                if (spenForegroundColorSpan.getColor() == ServerResultParser.MAIN_DEF_FONT_COLOR || spenForegroundColorSpan.getColor() == ServerResultParser.MAIN_SECOND_DEF_FONT_COLOR || spenForegroundColorSpan.getColor() == color) {
                    spenObjectTextBox.appendTextSpan(new SpenForegroundColorSpan(spenForegroundColorSpan.getStart(), spenForegroundColorSpan.getEnd(), spenForegroundColorSpan.getExpansion(), color2));
                }
            }
        }
        if (i == 0) {
            spenObjectTextBox.appendTextSpan(new SpenForegroundColorSpan(0, spenObjectTextBox.getText().length(), 2, color2));
        }
    }

    private List<SpenObjectSpan> findObjectSpan(ComposerViewPresenter composerViewPresenter, int i, int i2) {
        SpenObjectTextBox bodyText = composerViewPresenter.getDoc().getBodyText();
        if (bodyText.findObjectSpan(i, i2) == null) {
            return null;
        }
        composerViewPresenter.getTextManager().updateBodyObjectSpanPosition(i, i2 - i);
        ArrayList<SpenObjectSpan> arrayListFindObjectSpan = bodyText.findObjectSpan(i, i2);
        Collections.sort(arrayListFindObjectSpan, new Comparator<SpenObjectSpan>() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.ai.result.presenter.ResultOperation.1
            @Override // java.util.Comparator
            public int compare(SpenObjectSpan spenObjectSpan, SpenObjectSpan spenObjectSpan2) {
                return spenObjectSpan.getTextIndex() - spenObjectSpan2.getTextIndex();
            }
        });
        return arrayListFindObjectSpan;
    }

    private int removeAnchorToText(ComposerViewPresenter composerViewPresenter, int i, int i2) {
        List<SpenObjectSpan> listFindObjectSpan = findObjectSpan(composerViewPresenter, i, i2);
        int i4 = 0;
        if (listFindObjectSpan == null) {
            return 0;
        }
        SpenWNote doc = composerViewPresenter.getDoc();
        for (int size = listFindObjectSpan.size() - 1; size >= 0; size--) {
            SpenObjectSpan spenObjectSpan = listFindObjectSpan.get(size);
            if (spenObjectSpan.getObj().getType() != 22 && spenObjectSpan.getObj().getType() != 23) {
                doc.transferObject(spenObjectSpan.getTextIndex(), doc.getPage(spenObjectSpan.getObject().getPageIndex()));
                i4++;
            }
        }
        return i4;
    }

    private void removeSrcContents(ComposerViewPresenter composerViewPresenter, int i, int i2) {
        if (!composerViewPresenter.getObjectManager().isSelectedBodyText()) {
            Logger.m11000e(TAG, "removeSrcContents# isSelectedBodyText: false");
        } else if (i == i2) {
            Logger.m11004w(TAG, "removeSrcContents# not selected");
        } else {
            composerViewPresenter.getDoc().getBodyText().removeText(i, (i2 - i) - removeAnchorToText(composerViewPresenter, i, i2));
        }
    }

    private void restoreAnchorObjectSpans(SpenWNote spenWNote, int i) {
        List<SpenObjectBase> list = this.mAnchorObjectsOnOverwrite;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            spenWNote.getBodyText().appendObjectSpan(new SpenObjectSpan(this.mAnchorObjectsOnOverwrite.get(i2), i + i2));
        }
    }

    private void saveAnchorObjectSpans(ComposerViewPresenter composerViewPresenter, int i, int i2) {
        List<SpenObjectBase> list = this.mAnchorObjectsOnOverwrite;
        if (list == null) {
            this.mAnchorObjectsOnOverwrite = new ArrayList();
        } else {
            list.clear();
        }
        List<SpenObjectSpan> listFindObjectSpan = findObjectSpan(composerViewPresenter, i, i2);
        if (listFindObjectSpan == null) {
            return;
        }
        int size = listFindObjectSpan.size();
        for (int i4 = 0; i4 < size; i4++) {
            SpenObjectSpan spenObjectSpan = listFindObjectSpan.get(i4);
            if ((!this.shouldRemoveTableOnOverwrite && spenObjectSpan.getObj().getType() == 22) || (!this.shouldRemoveCodeBlockOnOverwrite && spenObjectSpan.getObj().getType() == 23)) {
                this.mAnchorObjectsOnOverwrite.add(spenObjectSpan.getObj());
            }
        }
    }

    public void addToNewNote(ComposerViewPresenter composerViewPresenter, SpenObjectTextBox spenObjectTextBox) {
        Throwable th;
        IOException iOException;
        SpenWNote doc;
        SpenWNote spenWNote;
        SpenObjectShape spenObjectShapeCopyText = ObjectTextFactory.copyText(spenObjectTextBox, 0, spenObjectTextBox.getText().length() - 1);
        ArrayList<SpenObjectBase> arrayList = new ArrayList<>(1);
        arrayList.add(spenObjectShapeCopyText);
        Activity activity = composerViewPresenter.getActivity();
        File cacheDir = activity.getCacheDir();
        if (cacheDir == null) {
            Logger.m11000e(TAG, "addToNewNote# cacheDir is null");
            return;
        }
        String str = cacheDir.getAbsolutePath() + File.separator + "ResultOperation_" + ClipboardCacheManager.getDateString() + ".sdocx";
        SpenWNote spenWNote2 = null;
        try {
            try {
                doc = composerViewPresenter.getDoc();
                spenWNote = new SpenWNote(activity, null, SpenWNote.PageMode.LIST, doc.getOrientation(), doc.getPageDefaultWidth(), false);
            } catch (IOException e) {
                iOException = e;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            spenWNote.setPageDefaultHeight(doc.getPageDefaultHeight());
            spenWNote.appendPage(doc.getPageDefaultWidth(), doc.getPageDefaultHeight()).appendObjectList(arrayList);
            DocumentFileManager.getInstance().saveAsDirectory(spenWNote, str);
            try {
                DocumentFileManager.getInstance().close(str, spenWNote, true);
            } catch (IOException e2) {
                AbstractC8014b.m7204f(e2, new StringBuilder("addToNewNote# close, e: "), TAG);
            }
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setClass(activity, ComposerAccessHandler.getNativeComposerActionNewActivityClass());
            intent.setFlags(403177472);
            intent.setType("text/plain");
            intent.putExtra(TaskActionSend.DESIGNATED_CASE_AI, str);
            activity.startActivity(intent);
        } catch (IOException e3) {
            iOException = e3;
            spenWNote2 = spenWNote;
            Logger.m11000e(TAG, "addToNewNote# e:" + iOException.getMessage());
            try {
                DocumentFileManager.getInstance().close(str, spenWNote2, true);
            } catch (IOException e5) {
                AbstractC8014b.m7204f(e5, new StringBuilder("addToNewNote# close, e: "), TAG);
            }
        } catch (Throwable th3) {
            th = th3;
            spenWNote2 = spenWNote;
            try {
                DocumentFileManager.getInstance().close(str, spenWNote2, true);
                throw th;
            } catch (IOException e6) {
                AbstractC8014b.m7204f(e6, new StringBuilder("addToNewNote# close, e: "), TAG);
                throw th;
            }
        }
    }

    public void convertTextColor(Context context, SpenObjectShape spenObjectShape, boolean z) {
        if (z) {
            convertTextColor(context, spenObjectShape, !ContextUtils.isNightMode(context) ? 1 : 0);
        } else if (ContextUtils.isNightMode(context)) {
            convertTextColor(context, spenObjectShape, 1);
        }
    }

    public void copy(ComposerViewPresenter composerViewPresenter, SpenObjectTextBox spenObjectTextBox) {
        if (spenObjectTextBox.getText().length() == 0) {
            Logger.m10999d(TAG, "copy# fail : empty text");
            return;
        }
        Activity activity = composerViewPresenter.getActivity();
        ObjectManager objectManager = composerViewPresenter.getObjectManager();
        TaskCopy taskCopy = new TaskCopy();
        taskCopy.copyText(activity, objectManager, spenObjectTextBox, 0, spenObjectTextBox.getText().length());
        taskCopy.handleResult(taskCopy.makeClipData(), activity);
    }

    public void insert(ComposerViewPresenter composerViewPresenter, SpenObjectTextBox spenObjectTextBox, int i) {
        boolean z;
        if (spenObjectTextBox.getText().length() == 0) {
            Logger.m10999d(TAG, "insert# fail : empty text");
            return;
        }
        SpenWNote doc = composerViewPresenter.getDoc();
        if (doc.isGroupingHistory()) {
            z = false;
        } else {
            doc.beginHistoryGroup();
            z = true;
        }
        doc.getBodyText().setCursorPosition(i);
        doc.getBodyText().insertText("\n", i);
        doc.getBodyText().insertText(i, spenObjectTextBox, 0, spenObjectTextBox.getText().length());
        composerViewPresenter.getWritingToolManager().cancelConvertToText();
        if (z) {
            doc.endHistoryGroup();
        }
    }

    public void insertInNewPageFront(ComposerViewPresenter composerViewPresenter, SrcContentInfo srcContentInfo, SpenObjectTextBox spenObjectTextBox) {
        boolean z;
        ArrayList<Integer> pageIndexListByRect;
        if (spenObjectTextBox == null) {
            spenObjectTextBox = composerViewPresenter.getObjectManager().getNewBodyText();
            spenObjectTextBox.setText(srcContentInfo.getSelectedText());
        }
        if (spenObjectTextBox.getText().length() == 0) {
            Logger.m10999d(TAG, "insertInNewPageFront# fail : empty text");
            return;
        }
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.copy(spenObjectTextBox);
        if (srcContentInfo.mIsConvertibleColor) {
            convertColor(composerViewPresenter, newSpenObjectTextBox);
        }
        SpenWNote doc = composerViewPresenter.getDoc();
        if (doc.isGroupingHistory()) {
            z = false;
        } else {
            doc.beginHistoryGroup();
            z = true;
        }
        ISpenNoteTextManager spenNoteTextManager = composerViewPresenter.getTextManager().getSpenNoteTextManager();
        int currentPageIndex = composerViewPresenter.getCurrentPageIndex();
        if (composerViewPresenter.getPdfManager().hasSelectedPDF()) {
            currentPageIndex = composerViewPresenter.getPdfManager().getStartSelectionCursorPosition().getPageIndex();
            AbstractC0000a.m3D(currentPageIndex, "insertInNewPageFront# hasSelectedPDF : targetPageIndex = ", TAG);
        } else if (composerViewPresenter.getObjectManager().isSelectedBodyText() && composerViewPresenter.getTextManager().isSelected()) {
            int[] cursorFromFocusedTextBox = composerViewPresenter.getTextManager().getCursorFromFocusedTextBox();
            currentPageIndex = spenNoteTextManager.getPageIndexByCursorOfBodyText(Math.min(cursorFromFocusedTextBox[0], cursorFromFocusedTextBox[1]));
            AbstractC0000a.m3D(currentPageIndex, "insertInNewPageFront# isSelectedBodyText : targetPageIndex = ", TAG);
        } else {
            RectF rectF = srcContentInfo.mSelectedRectF;
            if (rectF != null && !rectF.isEmpty() && (pageIndexListByRect = composerViewPresenter.getObjectManager().getPageIndexListByRect(srcContentInfo.mSelectedRectF)) != null && !pageIndexListByRect.isEmpty()) {
                Logger.m10999d(TAG, "insertInNewPageFront# getPageIndexListByRect : targetPageIndex = " + pageIndexListByRect.get(0));
                currentPageIndex = Math.max(pageIndexListByRect.get(0).intValue(), 0);
            }
        }
        if (checkTextLimitToInsert(composerViewPresenter, doc, newSpenObjectTextBox)) {
            spenNoteTextManager.lockBodyTextPage();
            SpenWPage spenWPage = composerViewPresenter.getNoteManager().insertPagesWithNoBodyTextFront(1, currentPageIndex).get(0);
            int iCalculateOverflowPageCount = spenNoteTextManager.calculateOverflowPageCount(newSpenObjectTextBox, spenWPage);
            ArrayList<SpenWPage> arrayList = iCalculateOverflowPageCount == 0 ? new ArrayList<>() : (ArrayList) composerViewPresenter.getNoteManager().insertPagesWithNoBodyTextFront(iCalculateOverflowPageCount, currentPageIndex);
            arrayList.add(0, spenWPage);
            Logger.m10999d(TAG, "insertInNewPageFront# newPageList size = " + arrayList.size() + " / st_indx = " + currentPageIndex);
            spenNoteTextManager.insertBodyTextTo(currentPageIndex, arrayList, newSpenObjectTextBox, composerViewPresenter.getTextManager().getFontSizeDelta());
            spenNoteTextManager.unlockBodyTextPage();
            if (z) {
                doc.endHistoryGroup();
            }
            int startCursorIndexByPage = spenNoteTextManager.getStartCursorIndexByPage(currentPageIndex);
            if (startCursorIndexByPage < 0) {
                return;
            }
            doc.getBodyText().setCursorPosition(startCursorIndexByPage);
            composerViewPresenter.getObjectManager().getNoteZoomScroller().scrollToContentRect(composerViewPresenter.getTextManager().getSpenNoteTextManager().getCursorRect(doc.getBodyText(), startCursorIndexByPage));
            composerViewPresenter.getWritingToolManager().cancelConvertToText();
            composerViewPresenter.getComposerModel().getModeManager().setMode(Mode.Text, "ai insertInNewPageFront", true);
            if (!composerViewPresenter.getObjectManager().isSelectedBodyText()) {
                composerViewPresenter.getObjectManager().selectObject(composerViewPresenter.getDoc().getBodyText());
            }
            doc.getBodyText().setSelection(startCursorIndexByPage, newSpenObjectTextBox.getText().length() + startCursorIndexByPage);
        }
    }

    public void insertNewPageEndOfNote(ComposerViewPresenter composerViewPresenter, SrcContentInfo srcContentInfo, SpenObjectTextBox spenObjectTextBox) {
        boolean z;
        if (spenObjectTextBox == null) {
            spenObjectTextBox = composerViewPresenter.getObjectManager().getNewBodyText();
            spenObjectTextBox.setText(srcContentInfo.getSelectedText());
        }
        if (spenObjectTextBox.getText().length() == 0) {
            Logger.m10999d(TAG, "insertNewPageEndOfNote# fail : empty text");
            return;
        }
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.copy(spenObjectTextBox);
        if (srcContentInfo.mIsConvertibleColor) {
            convertColor(composerViewPresenter, newSpenObjectTextBox);
        }
        SpenWNote doc = composerViewPresenter.getDoc();
        if (doc.isGroupingHistory()) {
            z = false;
        } else {
            doc.beginHistoryGroup();
            z = true;
        }
        ISpenNoteTextManager spenNoteTextManager = composerViewPresenter.getTextManager().getSpenNoteTextManager();
        int pageCount = doc.getPageCount() - 1;
        int[] newPageSize = composerViewPresenter.getNoteManager().getNewPageSize(pageCount);
        if (checkTextLimitToInsert(composerViewPresenter, doc, newSpenObjectTextBox)) {
            spenNoteTextManager.lockBodyTextPage();
            SpenWPage spenWPage = composerViewPresenter.getNoteManager().insertPagesWithNoBodyText(1, newPageSize[1], pageCount).get(0);
            int iCalculateOverflowPageCount = spenNoteTextManager.calculateOverflowPageCount(newSpenObjectTextBox, spenWPage);
            ArrayList<SpenWPage> arrayList = iCalculateOverflowPageCount == 0 ? new ArrayList<>() : (ArrayList) composerViewPresenter.getNoteManager().insertPagesWithNoBodyText(iCalculateOverflowPageCount, newPageSize[1], pageCount);
            arrayList.add(0, spenWPage);
            Logger.m10999d(TAG, "insertNewPageEndOfNote# newPageList size = " + arrayList.size() + " / st_indx = " + pageCount);
            spenNoteTextManager.insertBodyTextTo(pageCount, arrayList, newSpenObjectTextBox, composerViewPresenter.getTextManager().getFontSizeDelta());
            spenNoteTextManager.unlockBodyTextPage();
            if (z) {
                doc.endHistoryGroup();
            }
            int startCursorIndexByPage = spenNoteTextManager.getStartCursorIndexByPage(pageCount);
            if (startCursorIndexByPage < 0) {
                return;
            }
            doc.getBodyText().setCursorPosition(startCursorIndexByPage);
            composerViewPresenter.getObjectManager().getNoteZoomScroller().scrollToContentRect(composerViewPresenter.getTextManager().getSpenNoteTextManager().getCursorRect(doc.getBodyText(), startCursorIndexByPage));
            composerViewPresenter.getWritingToolManager().cancelConvertToText();
            composerViewPresenter.getComposerModel().getModeManager().setMode(Mode.Text, "ai insertNewPageEndOfNote", true);
            if (!composerViewPresenter.getObjectManager().isSelectedBodyText()) {
                composerViewPresenter.getObjectManager().selectObject(composerViewPresenter.getDoc().getBodyText());
            }
            doc.getBodyText().setSelection(startCursorIndexByPage, newSpenObjectTextBox.getText().length() + startCursorIndexByPage);
        }
    }

    public void insertToBottom(ComposerViewPresenter composerViewPresenter, SrcContentInfo srcContentInfo, SpenObjectTextBox spenObjectTextBox) {
        boolean z;
        float f;
        if (spenObjectTextBox == null) {
            spenObjectTextBox = composerViewPresenter.getObjectManager().getNewBodyText();
            spenObjectTextBox.setText(srcContentInfo.getSelectedText());
        }
        if (spenObjectTextBox.getText().length() == 0) {
            Logger.m10999d(TAG, "insertToBottom# fail : empty text");
            return;
        }
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.copy(spenObjectTextBox);
        if (srcContentInfo.mIsConvertibleColor) {
            convertColor(composerViewPresenter, newSpenObjectTextBox);
        }
        SpenWNote doc = composerViewPresenter.getDoc();
        if (doc.isGroupingHistory()) {
            z = false;
        } else {
            doc.beginHistoryGroup();
            z = true;
        }
        SpenWPage page = doc.getPage(srcContentInfo.mSrcPageIndex);
        SpenBodyTextContext spenBodyTextContext = new SpenBodyTextContext(composerViewPresenter.getActivity());
        spenBodyTextContext.setDocument(doc);
        spenBodyTextContext.measureText();
        RectF drawnRectOfAllObject = page.getDrawnRectOfAllObject();
        RectF measuredFitRect = spenBodyTextContext.getMeasuredFitRect(srcContentInfo.mSrcPageIndex);
        if (page.hasPDF()) {
            ArrayList<SpenWPage.PDFData> pDFData = page.getPDFData();
            f = pDFData.get(pDFData.size() - 1).rect.bottom;
        } else {
            f = 0.0f;
        }
        PointF pointF = new PointF(0.0f, Math.max(Math.max(drawnRectOfAllObject.bottom, measuredFitRect.bottom), f));
        ISpenNoteTextManager spenNoteTextManager = composerViewPresenter.getTextManager().getSpenNoteTextManager();
        TextUtil.insertLineFeed(doc.getBodyText(), spenNoteTextManager.getLineCountFromBodyTextBottom(pointF));
        RectF lineRectOfBodyText = spenNoteTextManager.getLineRectOfBodyText(doc.getPage(0), pointF.y);
        if (lineRectOfBodyText != null && !lineRectOfBodyText.isEmpty()) {
            float f4 = lineRectOfBodyText.top;
            float f5 = pointF.y;
            if (f4 < f5 - 2.0f || f5 == measuredFitRect.bottom + 1.0f) {
                TextUtil.insertLineFeed(doc.getBodyText(), spenNoteTextManager.getLineCountFromBodyTextBottom(new PointF(pointF.x, lineRectOfBodyText.bottom + 1.0f)));
                pointF.y = lineRectOfBodyText.bottom + 1.0f;
            }
        }
        int cursorIndexToInsertIntoBodyText = composerViewPresenter.getTextManager().getCursorIndexToInsertIntoBodyText(pointF);
        doc.getBodyText().setCursorPosition(cursorIndexToInsertIntoBodyText);
        doc.getBodyText().insertText(cursorIndexToInsertIntoBodyText, newSpenObjectTextBox, 0, newSpenObjectTextBox.getText().length());
        if (z) {
            doc.endHistoryGroup();
        }
        SpenObjectTextBox bodyText = doc.getBodyText();
        ArrayList<SpenObjectBase> selectedObject = doc.getSelectedObject();
        if (selectedObject.isEmpty() || !bodyText.equals(selectedObject.get(0))) {
            composerViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(false);
            doc.selectObject(bodyText);
            composerViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(true);
        }
        composerViewPresenter.getObjectManager().getNoteZoomScroller().scrollToContentRect(composerViewPresenter.getTextManager().getSpenNoteTextManager().getCursorRect(doc.getBodyText(), composerViewPresenter.getTextManager().getCursor(doc.getBodyText())[0]));
        composerViewPresenter.getWritingToolManager().cancelConvertToText();
        composerViewPresenter.getComposerModel().getModeManager().setMode(Mode.Text, "ai insertToBottom", true);
        if (!composerViewPresenter.getObjectManager().isSelectedBodyText()) {
            composerViewPresenter.getObjectManager().selectObject(composerViewPresenter.getDoc().getBodyText());
        }
        doc.getBodyText().setSelection(cursorIndexToInsertIntoBodyText, newSpenObjectTextBox.getText().length() + cursorIndexToInsertIntoBodyText);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void overwrite(ComposerViewPresenter composerViewPresenter, SpenObjectTextBox spenObjectTextBox, SrcContentInfo srcContentInfo) {
        boolean z;
        if (spenObjectTextBox.getText().length() == 0) {
            Logger.m10999d(TAG, "overwrite# fail : empty text");
            return;
        }
        SpenWNote doc = composerViewPresenter.getDoc();
        SpenObjectTextBox newSpenObjectTextBox = ObjectTextFactory.getNewSpenObjectTextBox();
        newSpenObjectTextBox.copy(spenObjectTextBox);
        if (srcContentInfo.mIsConvertibleColor) {
            convertColor(composerViewPresenter, newSpenObjectTextBox);
        }
        int i = 1;
        if (doc.isGroupingHistory()) {
            z = false;
        } else {
            doc.beginHistoryGroup();
            z = true;
        }
        ISpenNoteTextManager spenNoteTextManager = composerViewPresenter.getTextManager().getSpenNoteTextManager();
        spenNoteTextManager.lockBodyTextPage();
        int[] cursorFromFocusedTextBox = composerViewPresenter.getTextManager().getCursorFromFocusedTextBox();
        int i2 = cursorFromFocusedTextBox[0];
        int i4 = cursorFromFocusedTextBox[1];
        saveAnchorObjectSpans(composerViewPresenter, i2, i4);
        removeSrcContents(composerViewPresenter, i2, i4);
        SpenObjectTextBox bodyText = doc.getBodyText();
        bodyText.setCursorPosition(i2);
        if (srcContentInfo.isOverwriteNextLineFlag()) {
            int[] paragraphIndex = composerViewPresenter.getTextManager().getParagraphIndex(bodyText, new int[]{i2, cursorFromFocusedTextBox[1] + 1});
            ArrayList<SpenTextParagraphBase> arrayListFindTextParagraph = doc.getBodyText().findTextParagraph(paragraphIndex[0], paragraphIndex[1]);
            if (arrayListFindTextParagraph != null) {
                for (SpenTextParagraphBase spenTextParagraphBase : arrayListFindTextParagraph) {
                    if ((spenTextParagraphBase instanceof SpenBulletParagraph) || (spenTextParagraphBase instanceof SpenAlignmentParagraph)) {
                        doc.getBodyText().removeTextParagraph(spenTextParagraphBase);
                        break;
                    }
                }
            }
            if (i2 > 0) {
                doc.getBodyText().insertText("\n", i2);
            } else {
                i = 0;
            }
        }
        int i5 = i2 + i;
        int length = newSpenObjectTextBox.getText().length();
        doc.getBodyText().insertText(i5, newSpenObjectTextBox, 0, length);
        int i6 = length + i5;
        restoreAnchorObjectSpans(doc, i6);
        spenNoteTextManager.unlockBodyTextPage();
        if (z) {
            doc.endHistoryGroup();
        }
        doc.getBodyText().setSelection(i5, i6);
    }

    public void overwriteInTextBox(ComposerViewPresenter composerViewPresenter, SrcContentInfo srcContentInfo, SpenObjectTextBox spenObjectTextBox) {
        boolean z;
        if (spenObjectTextBox == null) {
            spenObjectTextBox = composerViewPresenter.getObjectManager().getNewTextBox();
            spenObjectTextBox.setText(srcContentInfo.getSelectedText());
        }
        if (spenObjectTextBox.getText().length() == 0) {
            Logger.m10999d(TAG, "overwriteInTextBox# fail : empty text");
            return;
        }
        SpenWNote doc = composerViewPresenter.getDoc();
        if (doc.isGroupingHistory()) {
            z = false;
        } else {
            doc.beginHistoryGroup();
            z = true;
        }
        composerViewPresenter.getTextManager().getSpenNoteTextManager().reduceFontSizeToFitPage(spenObjectTextBox, (int) srcContentInfo.mSelectedRectF.width(), (int) srcContentInfo.mSelectedRectF.height());
        ObjectManager objectManager = composerViewPresenter.getObjectManager();
        RectF rectF = srcContentInfo.mSelectedRectF;
        objectManager.addTextBoxFromCTT(spenObjectTextBox, new PointF(rectF.left, rectF.top));
        composerViewPresenter.getWritingToolManager().cancelConvertToText();
        if (z) {
            doc.endHistoryGroup();
        }
    }

    public void removeLastEmptyLinefeed(SpenObjectTextBox spenObjectTextBox) {
        String text = spenObjectTextBox.getText();
        if (text.length() > 2) {
            char cM4a = AbstractC0000a.m4a(1, text);
            if (AbstractC0000a.m4a(2, text) == '\n' && cM4a == '\n') {
                spenObjectTextBox.removeText(text.length() - 1, 1);
            }
        }
    }

    public void setShouldRemoveCodeBlockOnOverwrite(boolean z) {
        this.shouldRemoveCodeBlockOnOverwrite = z;
    }

    public void setShouldRemoveTableOnOverwrite(boolean z) {
        this.shouldRemoveTableOnOverwrite = z;
    }

    private void convertTextColor(Context context, SpenObjectShape spenObjectShape, int i) {
        SpenColorThemeUtil spenColorThemeUtil = new SpenColorThemeUtil(context);
        spenColorThemeUtil.setColorTheme(i);
        for (SpenTextSpanBase spenTextSpanBase : spenObjectShape.getTextSpan()) {
            if (spenTextSpanBase.getType() == 1 && (spenTextSpanBase instanceof SpenForegroundColorSpan)) {
                SpenForegroundColorSpan spenForegroundColorSpan = (SpenForegroundColorSpan) spenTextSpanBase;
                int color = spenColorThemeUtil.getColor(spenForegroundColorSpan.getColor());
                Logger.m10999d(TAG, "convertTextColor# " + spenForegroundColorSpan.getColor() + " -> " + color);
                spenObjectShape.appendTextSpan(new SpenForegroundColorSpan(spenForegroundColorSpan.getStart(), spenForegroundColorSpan.getEnd(), spenForegroundColorSpan.getExpansion(), color));
            }
        }
        spenColorThemeUtil.close();
    }
}
