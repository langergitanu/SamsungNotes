package com.samsung.android.support.senl.p148nt.composer.main.base.model.composer;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.sdk.composer.input.ISpenNotePageLayouter;
import com.samsung.android.sdk.composer.text.ISpenNoteTextManager;
import com.samsung.android.sdk.pen.document.SpenBoundFileNotFoundException;
import com.samsung.android.sdk.pen.document.SpenObjectBase;
import com.samsung.android.sdk.pen.document.SpenObjectContainer;
import com.samsung.android.sdk.pen.document.SpenObjectTextBox;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p145cm.base.framework.support.INTEGER;
import com.samsung.android.support.senl.p145cm.base.spenwrapper.common.CollectionHelper;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.NoteCaptureControl;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TextOnlyModeState;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageCopyData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.dynamic.common.DynamicTemplateObjectUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.model.base.document.DocumentPageRatio;
import com.samsung.android.support.senl.p148nt.model.collector.CollectController;
import com.samsung.android.support.senl.p148nt.model.collector.common.CollectParam;
import com.samsung.android.support.senl.p148nt.model.collector.common.ICollectParam;
import com.samsung.android.support.senl.p148nt.model.documents.file.DocumentFileManager;
import com.samsung.android.support.senl.p148nt.model.utils.DocumentBackgroundUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class NoteManager {
    private static final int INITIAL_PAGE_COUNT_BASE = 2;
    private static final int STATE_COPYING = 1;
    private static final int STATE_NONE = 0;
    private static final String TAG = Logger.createTag("NoteManager");
    private List<ObserverBackgroundColor> mBgObserverList;
    private boolean mCancel;
    private String mDefTemplatePath;
    private int mDefTemplateType;
    private float mDocRatio;
    private InvertBackgroundColorListener mInvertBackgroundColorListener;
    private ObserverInvertBackgroundColor mInvertBgObserver;
    private boolean mIsChangedInvertBGAndNotify;
    private boolean mIsLandscapePage;
    private boolean mIsSingleMode;
    private SpenWNote mNote;
    private ISpenNotePageLayouter mSpenNotePageLayouter;
    private ISpenNoteTextManager mSpenNoteTextManager;
    private TextOnlyModeState mTextOnlyModeState;
    private INTEGER mBackgroundColor = null;
    private int mCurrentWorkingState = 0;
    private final NotePdfData mNotePdfData = new NotePdfData();
    private final Set<String> mAddPageBlock = new HashSet();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface InvertBackgroundColorListener {
        void onInvertBackgroundColorChanged(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ObserverBackgroundColor {
        void onChangedBackgroundColor(int i, boolean z, boolean z2);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ObserverInvertBackgroundColor {
        void onUpdateInvertBackgroundColor(DocumentBackgroundUtils.InvertBackgroundColorType invertBackgroundColorType);
    }

    private void changePage(SpenWPage spenWPage, int i) {
        boolean z;
        if (this.mNote.isGroupingHistory()) {
            z = false;
        } else {
            this.mNote.beginHistoryGroup();
            z = true;
        }
        insertPage(i - 1, i - 2, spenWPage.getWidth(), spenWPage.getHeight(), null, null, 0, true);
        this.mNote.removePage(i);
        this.mSpenNotePageLayouter.requestPageLayout();
        if (z) {
            this.mNote.endHistoryGroup();
        }
    }

    private int getImageMode() {
        return this.mIsSingleMode ? 3 : 2;
    }

    private void updateTextOnlyMode(SpenWPage spenWPage) {
        TextOnlyModeState textOnlyModeState = this.mTextOnlyModeState;
        if (textOnlyModeState == null || !textOnlyModeState.canUseTextOnlyMode()) {
            return;
        }
        if (spenWPage.getTemplateType() != 0 || spenWPage.getObjectList().size() > 0) {
            this.mTextOnlyModeState.setCanUseTextOnlyMode(false, 2);
        }
    }

    public void addBackgroundColorObserver(ObserverBackgroundColor observerBackgroundColor) {
        if (this.mBgObserverList == null) {
            this.mBgObserverList = new ArrayList(2);
        }
        this.mBgObserverList.add(observerBackgroundColor);
    }

    public List<SpenWPage> addPages(int i, int i2, int i4, boolean z, boolean z2) {
        AbstractC0000a.m3D(i, "addPages# ", TAG);
        int[] iArr = new int[i];
        Arrays.fill(iArr, i4);
        SpenWNote spenWNote = this.mNote;
        SpenWPage page = spenWNote.getPage(spenWNote.getPageCount() - 1);
        ArrayList<SpenWPage> arrayListAppendPageList = this.mNote.appendPageList(iArr, page.getBackgroundColor(), page.getBackgroundImageMode(), page.getTemplateType(), page.getTemplateURI());
        for (int i5 = 0; i5 < i; i5++) {
            copyBackground(page, arrayListAppendPageList.get(i5));
        }
        this.mSpenNotePageLayouter.requestPageLayout();
        if (z) {
            commitHistory();
            if (z2) {
                this.mNote.combineLastUndo(1);
            }
        }
        Logger.m10999d(TAG, "addPages# end");
        return arrayListAppendPageList;
    }

    public void changePageHeight(DocumentPageRatio.PageRatioType pageRatioType) {
        int pageDefaultWidth = this.mNote.getPageDefaultWidth();
        int height = pageRatioType.getHeight(pageDefaultWidth);
        this.mNote.setPageDefaultHeight(height);
        addPages(2, pageDefaultWidth, height, false, false);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(0);
        arrayList.add(1);
        deletePageList(arrayList, false, false);
        this.mNote.clearHistory();
    }

    public void clearPage(int i, List<SpenWPage> list) {
        boolean z;
        if (list != null) {
            Iterator<SpenWPage> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (this.mNote.getPageIndexById(it.next().getId()) == i) {
                    this.mNote.selectObject((SpenObjectBase) null);
                    break;
                }
            }
        }
        if (this.mNote.isGroupingHistory()) {
            z = false;
        } else {
            this.mNote.beginHistoryGroup();
            z = true;
        }
        this.mSpenNoteTextManager.lockBodyTextPage();
        SpenWPage page = this.mNote.getPage(i);
        if (page.getTemplateType() == 17) {
            DynamicTemplateObjectUtil.removeAllObject(page);
        } else {
            page.removeAllObject();
        }
        this.mSpenNoteTextManager.clearBodyTextIn(i);
        this.mSpenNoteTextManager.unlockBodyTextPage();
        if (z) {
            this.mNote.endHistoryGroup();
        }
    }

    public void commitHistory() {
        this.mNote.commitHistory();
    }

    public void copyBackground(SpenWPage spenWPage, SpenWPage spenWPage2) {
        spenWPage2.setBackgroundColor(getBackgroundColor(), true);
        if (spenWPage.getTemplateType() == 17) {
            setTemplate(spenWPage2, 0, (String) null, (String) null);
            return;
        }
        if (!spenWPage.hasPDF()) {
            setTemplate(spenWPage2, spenWPage.getTemplateType(), spenWPage.getBackgroundImageId(), spenWPage.getTemplateURI());
            return;
        }
        if (spenWPage.getTemplateType() == 16) {
            setPdfTemplate(spenWPage2, spenWPage.getPDFData());
            return;
        }
        int i = this.mDefTemplateType;
        if (i == 16) {
            setTemplate(spenWPage2, 0, (String) null, (String) null);
        } else {
            String str = this.mDefTemplatePath;
            setTemplate(spenWPage2, i, str, str);
        }
    }

    public boolean copyPage(Context context, SpenWNote.Orientation orientation, int i, List<PageCopyData> list, String str) {
        boolean z;
        SpenWNote spenWNote = new SpenWNote(context, null, SpenWNote.PageMode.LIST, orientation, i, false);
        this.mCurrentWorkingState = 1;
        try {
            for (PageCopyData pageCopyData : list) {
                if (this.mCancel) {
                    Logger.m10999d(TAG, "copyPage# cancel");
                    this.mCancel = false;
                    spenWNote.close(true);
                    this.mCurrentWorkingState = 0;
                    return false;
                }
                SpenWPage page = this.mNote.getPage(pageCopyData.getIndex());
                int width = page.getWidth();
                int height = page.getHeight();
                if (width == 0 || height == 0) {
                    Logger.m11000e(TAG, "copyPage# e : pageindex = " + pageCopyData.getIndex() + " : w = " + width + " / h = " + height);
                } else {
                    spenWNote.copyPage(page, spenWNote.getPageCount());
                    SpenWPage spenWPageAppendPage = spenWNote.appendPage(width, height);
                    SpenObjectContainer spenObjectContainer = new SpenObjectContainer();
                    SpenObjectTextBox spenObjectTextBoxCopyBodyTextFrom = this.mSpenNoteTextManager.copyBodyTextFrom(pageCopyData.getIndex());
                    spenObjectContainer.setExtraDataInt(PageCopyData.PAGE_COPY_BOOKMARK_KEY, pageCopyData.isBookmarked() ? 1 : 0);
                    if (spenObjectTextBoxCopyBodyTextFrom != null) {
                        spenObjectContainer.appendObject(spenObjectTextBoxCopyBodyTextFrom);
                    }
                    spenWPageAppendPage.appendObject(spenObjectContainer);
                }
            }
            spenWNote.setBodyTextFontSizeDelta(this.mSpenNoteTextManager.getTextSizeDelta());
            DocumentFileManager.getInstance().saveAsDirectory(spenWNote, str);
            z = true;
        } catch (SpenBoundFileNotFoundException e) {
            e = e;
            AbstractC8014b.m7207i("copyPage# e :", e, TAG);
            z = false;
        } catch (IllegalArgumentException e2) {
            e = e2;
            AbstractC8014b.m7207i("copyPage# e :", e, TAG);
            z = false;
        }
        DocumentFileManager.getInstance().close(str, spenWNote, true);
        this.mCurrentWorkingState = 0;
        return z;
    }

    public void deleteBackgroundColorInvertedAndNotify() {
        if (isBackgroundColorInverted()) {
            Logger.m11003i(TAG, "deleteBackgroundColorInverted#");
            this.mIsChangedInvertBGAndNotify = true;
            invertBackgroundColor(false);
        }
    }

    public void deletePage(int i, boolean z, boolean z2) {
        boolean z3;
        AbstractC0000a.m3D(i, "deletePage# ", TAG);
        if (!z || this.mNote.isGroupingHistory()) {
            z3 = false;
        } else {
            this.mNote.beginHistoryGroup();
            z3 = true;
        }
        boolean z4 = z2 && isLastPage(i, this.mNote.getPageCount());
        this.mSpenNoteTextManager.removeBodyTextFrom(i);
        this.mNote.removePage(i);
        this.mSpenNotePageLayouter.requestPageLayout();
        if (z4) {
            updateDummyPage();
        }
        if (z3) {
            this.mNote.endHistoryGroup();
        }
    }

    public List<String> deletePageList(List<Integer> list, boolean z) {
        return deletePageList(list, z, true);
    }

    public int getBackgroundColor() {
        if (this.mBackgroundColor == null) {
            this.mBackgroundColor = new INTEGER(this.mNote.getPage(0).getBackgroundColor());
            Logger.m11003i(TAG, "getBackgroundColor# " + this.mBackgroundColor.getValue());
        }
        return this.mBackgroundColor.getValue();
    }

    public SpenObjectTextBox getBodyText(int i) {
        return this.mSpenNoteTextManager.copyBodyTextFrom(i);
    }

    public String getDefTemplatePath() {
        return this.mDefTemplatePath;
    }

    public int getDefTemplateType() {
        return this.mDefTemplateType;
    }

    public int[] getNewPageSize(int i) {
        boolean z;
        int pageDefaultWidth;
        int pageDefaultHeight;
        SpenWPage page = this.mNote.getPage(i);
        if (page.getTemplateType() == 16) {
            pageDefaultWidth = page.getWidth();
            pageDefaultHeight = page.getHeight();
            z = true;
        } else {
            z = false;
            if (isDummyPage(i, this.mNote.getPageCount())) {
                pageDefaultWidth = page.getWidth();
                pageDefaultHeight = page.getHeight();
            } else {
                pageDefaultWidth = this.mNote.getPageDefaultWidth();
                pageDefaultHeight = this.mNote.getPageDefaultHeight();
            }
        }
        Logger.m10999d(TAG, "getNewPageSize# " + (pageDefaultWidth / pageDefaultHeight) + " pdf: " + z);
        return new int[]{pageDefaultWidth, pageDefaultHeight};
    }

    public SpenWNote getNote() {
        return this.mNote;
    }

    public NotePdfData getNotePdfData() {
        return this.mNotePdfData;
    }

    public Bitmap getPageThumbnail(NoteCaptureControl noteCaptureControl, SpenWNote spenWNote, int i) {
        noteCaptureControl.setWNote(spenWNote);
        noteCaptureControl.setContents(spenWNote.getPage(i), spenWNote.getBodyText(), i);
        return noteCaptureControl.capturePage(1.0f);
    }

    public ISpenNotePageLayouter getSpenNotePageLayouter() {
        return this.mSpenNotePageLayouter;
    }

    public void init(SpenWNote spenWNote, float f) {
        this.mNotePdfData.setNoteKey(spenWNote);
        this.mNote = spenWNote;
        this.mDocRatio = f;
        this.mIsSingleMode = spenWNote.getPageMode() == SpenWNote.PageMode.SINGLE;
        this.mCancel = false;
        this.mBackgroundColor = null;
        this.mIsLandscapePage = spenWNote.getOrientation() == SpenWNote.Orientation.LANDSCAPE_NEW;
    }

    public SpenWPage insertDefaultPage(int i, int i2, int i4, int i5, String str, String str2) {
        this.mSpenNoteTextManager.lockBodyTextPage();
        SpenWPage spenWPageInsertPage = this.mNote.insertPage(i, i2, i4);
        spenWPageInsertPage.setBackgroundColor(getBackgroundColor());
        setTemplate(spenWPageInsertPage, i5, str, str2);
        this.mSpenNotePageLayouter.requestPageLayout();
        this.mSpenNoteTextManager.insertEmptyBodyTextTo(i, i4, this.mDocRatio);
        this.mSpenNoteTextManager.unlockBodyTextPage();
        if (!this.mNote.isGroupingHistory()) {
            commitHistory();
        }
        return spenWPageInsertPage;
    }

    public void insertNewPageByCurrentPage(int i) {
        this.mSpenNoteTextManager.lockBodyTextPage();
        SpenWPage page = this.mNote.getPage(i);
        int i2 = i + 1;
        SpenWPage spenWPageInsertPage = this.mNote.insertPage(i2, page.getWidth(), page.getHeight());
        spenWPageInsertPage.setBackgroundColor(getBackgroundColor(), true);
        if (page.getTemplateType() == 17) {
            setTemplate(spenWPageInsertPage, 0, (String) null, (String) null);
        } else if (!page.hasPDF()) {
            setTemplate(spenWPageInsertPage, page.getTemplateType(), page.getBackgroundImageId(), page.getTemplateURI());
        } else if (page.getTemplateType() == 16) {
            setPdfTemplate(spenWPageInsertPage, page.getPDFData());
        } else {
            setTemplate(spenWPageInsertPage, 0, (String) null, (String) null);
        }
        this.mSpenNotePageLayouter.requestPageLayout();
        this.mSpenNoteTextManager.insertEmptyBodyTextTo(i2, page.getHeight(), this.mDocRatio);
        this.mSpenNoteTextManager.unlockBodyTextPage();
        commitHistory();
    }

    public SpenWPage insertPage(int i) {
        int[] newPageSize = getNewPageSize(i);
        return insertPage(i, newPageSize[0], newPageSize[1], null, null, 0, true);
    }

    public List<SpenWPage> insertPagesWithNoBodyText(int i, int i2, int i4) {
        AbstractC0000a.m3D(i, "insertPagesWithNoBodyText# ", TAG);
        int[] iArr = new int[i];
        Arrays.fill(iArr, i2);
        SpenWPage page = this.mNote.getPage(i4);
        ArrayList<SpenWPage> arrayListInsertPageList = this.mNote.insertPageList(i4 + 1, iArr);
        for (int i5 = 0; i5 < i; i5++) {
            copyBackground(page, arrayListInsertPageList.get(i5));
        }
        this.mSpenNotePageLayouter.requestPageLayout();
        Logger.m10999d(TAG, "insertPagesWithNoBodyText# end");
        return arrayListInsertPageList;
    }

    public List<SpenWPage> insertPagesWithNoBodyTextFront(int i, int i2) {
        Logger.m10999d(TAG, "insertPagesWithNoBodyTextFront# " + i);
        int[] newPageSize = getNewPageSize(i2);
        SpenWPage page = this.mNote.getPage(i2);
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < i; i4++) {
            SpenWPage spenWPageInsertPage = this.mNote.insertPage(i2, newPageSize[0], newPageSize[1]);
            copyBackground(page, spenWPageInsertPage);
            arrayList.add(0, spenWPageInsertPage);
        }
        this.mSpenNotePageLayouter.requestPageLayout();
        Logger.m10999d(TAG, "insertPagesWithNoBodyTextFront# end");
        return arrayList;
    }

    public void invertBackgroundColor(boolean z) {
        Logger.m11003i(TAG, "invertBackgroundColor# color : " + getBackgroundColor() + ", invert : " + z + ", hasBackgroundImage : " + BackgroundColorUtil.hasBackgroundImage(this.mNote.getPageList()));
        this.mNote.invertBackgroundColor(z);
        InvertBackgroundColorListener invertBackgroundColorListener = this.mInvertBackgroundColorListener;
        if (invertBackgroundColorListener != null) {
            invertBackgroundColorListener.onInvertBackgroundColorChanged(z);
        }
    }

    public boolean isAddPageBlocked() {
        if (this.mAddPageBlock.isEmpty()) {
            return false;
        }
        Logger.m10999d(TAG, "isAddPageBlocked: " + Arrays.toString(this.mAddPageBlock.toArray()));
        return true;
    }

    public boolean isBackgroundColorInverted() {
        return this.mNote.isBackgroundColorInverted();
    }

    public boolean isDummyPage(int i, int i2) {
        return i == i2 - 1;
    }

    public boolean isLandscapePage() {
        return this.mIsLandscapePage;
    }

    public boolean isLastPage(int i, int i2) {
        return i == i2 + (-2);
    }

    public boolean isObjectEmpty(int i) {
        return this.mNote.getPage(i).getObjectCount(false) <= 0;
    }

    public void movePage(int i, int i2) {
        boolean z;
        if (this.mNote.isGroupingHistory()) {
            z = false;
        } else {
            this.mNote.beginHistoryGroup();
            z = true;
        }
        this.mSpenNoteTextManager.lockBodyTextPage();
        SpenWNote spenWNote = this.mNote;
        spenWNote.movePageIndex(spenWNote.getPage(i), i2);
        this.mSpenNotePageLayouter.requestPageLayout();
        this.mSpenNoteTextManager.moveBodyTextTo(i, i2, this.mDocRatio);
        this.mSpenNoteTextManager.unlockBodyTextPage();
        if (isLastPage(i2, this.mNote.getPageCount()) || isLastPage(i, this.mNote.getPageCount())) {
            updateDummyPage();
        }
        if (z) {
            this.mNote.endHistoryGroup();
        }
    }

    public void notifyBackgroundColorChange() {
        List<ObserverBackgroundColor> list = this.mBgObserverList;
        if (list == null) {
            return;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            this.mBgObserverList.get(i).onChangedBackgroundColor(getBackgroundColor(), isBackgroundColorInverted(), BackgroundColorUtil.hasBackgroundImage(this.mNote.getPageList()));
        }
    }

    public void notifyInvertBackgroundColor(DocumentBackgroundUtils.InvertBackgroundColorType invertBackgroundColorType) {
        ObserverInvertBackgroundColor observerInvertBackgroundColor = this.mInvertBgObserver;
        if (observerInvertBackgroundColor == null) {
            return;
        }
        observerInvertBackgroundColor.onUpdateInvertBackgroundColor(invertBackgroundColorType);
    }

    public void release() {
        List<ObserverBackgroundColor> list = this.mBgObserverList;
        if (list != null) {
            list.clear();
            this.mBgObserverList = null;
        }
    }

    public void removeBackgroundColorObserver(ObserverBackgroundColor observerBackgroundColor) {
        List<ObserverBackgroundColor> list = this.mBgObserverList;
        if (list != null) {
            list.remove(observerBackgroundColor);
        }
    }

    public SpenWPage replacePage(int i, int i2, int i4, int i5, String str, String str2) {
        SpenWPage spenWPageInsertDefaultPage = insertDefaultPage(i, i2, i4, i5, str, str2);
        this.mNote.removePage(i + 1);
        this.mSpenNotePageLayouter.requestPageLayout();
        return spenWPageInsertDefaultPage;
    }

    public void setAddPageBlocked(String str, boolean z) {
        if (z) {
            this.mAddPageBlock.add(str);
        } else {
            this.mAddPageBlock.remove(str);
        }
    }

    public void setBackgroundColor(int i) {
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "setBackgroundColor# color : ", ", invert : ");
        sbM778t.append(isBackgroundColorInverted());
        sbM778t.append(", hasBackgroundImage : ");
        sbM778t.append(BackgroundColorUtil.hasBackgroundImage(this.mNote.getPageList()));
        Logger.m11003i(str, sbM778t.toString());
        this.mNote.setBackgroundColor(i, true);
    }

    public void setCancelState() {
        if (this.mCurrentWorkingState != 0) {
            this.mCancel = true;
        }
    }

    public void setCursorOnScreen(int i) {
        this.mSpenNoteTextManager.setCursorOnScreen(this.mNote.getBodyText(), i);
    }

    public void setCustomTemplate(SpenWPage spenWPage, int i, String str) {
        spenWPage.setTemplateType(12);
        spenWPage.setBackgroundImageMode(getImageMode());
        spenWPage.setBackgroundImage(i, true);
        spenWPage.setTemplateURI(str);
        updateTextOnlyMode(spenWPage);
    }

    public void setDefaultTemplate(int i, String str) {
        this.mDefTemplateType = i;
        this.mDefTemplatePath = str;
    }

    public void setDynamicTemplate(SpenWPage spenWPage, ArrayList<SpenWPage.PDFData> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        Logger.m10999d(TAG, "setDynamicTemplate, pdfData count: " + arrayList.size());
        spenWPage.setTemplateType(17);
        spenWPage.setPDFData(arrayList);
        updateTextOnlyMode(spenWPage);
    }

    public void setInvertBackgroundColorListener(InvertBackgroundColorListener invertBackgroundColorListener) {
        this.mInvertBackgroundColorListener = invertBackgroundColorListener;
    }

    public void setInvertBackgroundColorObserver(ObserverInvertBackgroundColor observerInvertBackgroundColor) {
        this.mInvertBgObserver = observerInvertBackgroundColor;
    }

    public void setPdfTemplate(SpenWPage spenWPage, ArrayList<SpenWPage.PDFData> arrayList) {
        spenWPage.setTemplateType(16);
        spenWPage.setPDFData(arrayList);
        updateTextOnlyMode(spenWPage);
    }

    public void setSpenNotePageLayouter(ISpenNotePageLayouter iSpenNotePageLayouter) {
        this.mSpenNotePageLayouter = iSpenNotePageLayouter;
    }

    public void setSpenNoteTextManager(ISpenNoteTextManager iSpenNoteTextManager) {
        this.mSpenNoteTextManager = iSpenNoteTextManager;
    }

    public void setSpenWNote(SpenWNote spenWNote) {
        this.mNote = spenWNote;
    }

    public void setTemplate(SpenWPage spenWPage, int i, String str, String str2) {
        setTemplate(spenWPage, i, str, str2, getImageMode());
    }

    public void setTextInputBlock(boolean z) {
        ISpenNoteTextManager iSpenNoteTextManager = this.mSpenNoteTextManager;
        if (iSpenNoteTextManager != null) {
            iSpenNoteTextManager.setTextInputBlock(z);
        }
    }

    public void setTextOnlyModeState(TextOnlyModeState textOnlyModeState) {
        this.mTextOnlyModeState = textOnlyModeState;
    }

    public boolean updateBackgroundColor(int i) {
        INTEGER integer = this.mBackgroundColor;
        if (integer == null) {
            Logger.m11000e(TAG, "updateBackgroundColor# mBackgroundColor is null");
            return false;
        }
        if (integer.getValue() == i) {
            return false;
        }
        this.mBackgroundColor.setValue(i);
        notifyBackgroundColorChange();
        return true;
    }

    public void updateBodyTextPage() {
        ISpenNoteTextManager iSpenNoteTextManager = this.mSpenNoteTextManager;
        if (iSpenNoteTextManager != null) {
            iSpenNoteTextManager.updateBodyTextPage();
        }
    }

    public void updateDummyPage() {
        int pageCount = this.mNote.getPageCount();
        if (this.mNote.getPageCount() <= 1) {
            Logger.m11003i(TAG, "updateDummyPage# skip");
            return;
        }
        SpenWPage page = this.mNote.getPage(pageCount - 2);
        SpenWPage page2 = this.mNote.getPage(pageCount - 1);
        if (page.getTemplateType() == 17) {
            changePage(page, pageCount);
            return;
        }
        if (!page.hasPDF()) {
            if (page.getHeight() == page2.getHeight() && page.getTemplateType() == page2.getTemplateType() && (page.getBackgroundImagePath() == null || page.getBackgroundImagePath().equals(page2.getBackgroundImagePath()))) {
                return;
            }
            changePage(page, pageCount);
            return;
        }
        if (page.getTemplateType() == 16) {
            if (page2.getTemplateType() != 16) {
                changePage(page, pageCount);
                return;
            }
            SpenWPage.PDFData pDFData = page.getPDFData().get(0);
            SpenWPage.PDFData pDFData2 = page2.getPDFData().get(0);
            if (pDFData.getBoundFileId() == pDFData2.getBoundFileId() && pDFData.index == pDFData2.index) {
                return;
            }
            changePage(page, pageCount);
        }
    }

    public boolean updateInvertBackgroundColor() {
        DocumentBackgroundUtils.InvertBackgroundColorType invertBackgroundColorType;
        if ((!isBackgroundColorInverted() && !this.mIsChangedInvertBGAndNotify) || (invertBackgroundColorType = BackgroundColorUtil.getInvertBackgroundColorType(this.mNote.getPageList())) == DocumentBackgroundUtils.InvertBackgroundColorType.None) {
            return false;
        }
        invertBackgroundColor(false);
        notifyBackgroundColorChange();
        notifyInvertBackgroundColor(invertBackgroundColorType);
        this.mIsChangedInvertBGAndNotify = false;
        return true;
    }

    public void updatePageLayout() {
        ISpenNotePageLayouter iSpenNotePageLayouter = this.mSpenNotePageLayouter;
        if (iSpenNotePageLayouter != null) {
            iSpenNotePageLayouter.requestPageLayout();
        }
    }

    public List<String> deletePageList(List<Integer> list, boolean z, boolean z2) {
        boolean z3;
        Logger.m10999d(TAG, "deletePageList# start " + list.size());
        boolean z4 = false;
        if (!z || this.mNote.isGroupingHistory()) {
            z3 = false;
        } else {
            this.mNote.beginHistoryGroup();
            z3 = true;
        }
        int pageCount = this.mNote.getPageCount();
        this.mSpenNoteTextManager.removeBodyTextFrom(CollectionHelper.toArrayList(list));
        ArrayList<SpenWPage> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        for (Integer num : list) {
            SpenWPage page = this.mNote.getPage(num.intValue());
            arrayList.add(page);
            arrayList2.add(page.getId());
            if (z2 && isLastPage(num.intValue(), pageCount)) {
                z4 = true;
            }
        }
        this.mNote.removePageList(arrayList);
        this.mSpenNotePageLayouter.requestPageLayout();
        if (z4 && this.mNote.getPageCount() > 1) {
            updateDummyPage();
        }
        if (z3) {
            this.mNote.endHistoryGroup();
        }
        Logger.m10999d(TAG, "deletePageList# end");
        return arrayList2;
    }

    public void setTemplate(SpenWPage spenWPage, int i, String str, String str2, int i2) {
        spenWPage.setTemplateType(i);
        spenWPage.setBackgroundImageMode(i2);
        spenWPage.setBackgroundImage(str, true);
        spenWPage.setTemplateURI(str2);
        updateTextOnlyMode(spenWPage);
    }

    public SpenWPage insertPage(int i, int i2) {
        int[] newPageSize = getNewPageSize(i2);
        return insertPage(i, i2, newPageSize[0], newPageSize[1], null, null, 0, true);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class NotePdfData {
        boolean mHavingPdf = false;
        int mNoteKey;

        public void clearHavingPdf() {
            if (this.mHavingPdf) {
                Logger.m11003i(NoteManager.TAG, "clearHavingPdf#");
                this.mHavingPdf = false;
                notifyPdfCollectorTask(false);
            }
        }

        public void clearNoteKey() {
            this.mNoteKey = -1;
        }

        public void notifyPdfCollectorTask(boolean z) {
            CollectController.getInstance().postCollectorTask(new CollectParam.CollectParamBuilder().setPdfActionKey("Composer").setPdfActionCaller(getClass()).setActionType(z ? ICollectParam.ActionType.PAUSE_PDF.getValue() : ICollectParam.ActionType.RESUME_PDF.getValue()).build());
        }

        public void setHavingPdf() {
            if (this.mHavingPdf) {
                return;
            }
            Logger.m11003i(NoteManager.TAG, "setHavingPdf# ");
            this.mHavingPdf = true;
            notifyPdfCollectorTask(true);
        }

        public void setNoteKey(SpenWNote spenWNote) {
            int mHandle = spenWNote.getMHandle();
            if (this.mNoteKey == mHandle) {
                return;
            }
            this.mNoteKey = mHandle;
            clearHavingPdf();
            Iterator<SpenWPage> it = spenWNote.getPageList().iterator();
            while (it.hasNext()) {
                if (it.next().hasPDF()) {
                    setHavingPdf();
                    return;
                }
            }
        }

        public void setHavingPdf(SpenWPage spenWPage) {
            if (!this.mHavingPdf && spenWPage.hasPDF()) {
                Logger.m11003i(NoteManager.TAG, "setHavingPdf# page");
                this.mHavingPdf = true;
                notifyPdfCollectorTask(true);
            }
        }
    }

    public SpenWPage insertPage(int i, int i2, int i4, SpenWPage spenWPage, SpenObjectTextBox spenObjectTextBox, int i5, boolean z) {
        return insertPage(i, i, i2, i4, spenWPage, spenObjectTextBox, i5, z);
    }

    public SpenWPage insertPage(int i, int i2, int i4, int i5, SpenWPage spenWPage, SpenObjectTextBox spenObjectTextBox, int i6, boolean z) {
        SpenWPage spenWPageCopyPage;
        int i7;
        String str = TAG;
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i4, "insertPage# ", " w/h = ", " / ");
        sbM1173s.append(i5);
        sbM1173s.append(" / src index = ");
        sbM1173s.append(i2);
        Logger.m10999d(str, sbM1173s.toString());
        if (spenWPage != null) {
            updateTextOnlyMode(spenWPage);
        }
        this.mSpenNoteTextManager.lockBodyTextPage();
        SpenWPage page = this.mNote.getPage(i2);
        if (spenWPage != null) {
            spenWPageCopyPage = this.mNote.copyPage(spenWPage, i);
            spenWPageCopyPage.setBackgroundColor(getBackgroundColor(), true);
        } else {
            if (i4 != this.mNote.getPageDefaultWidth()) {
                StringBuilder sbM778t = AbstractC0541b.m778t(i4, "insertPage# width of page is different ", " / ");
                sbM778t.append(this.mNote.getPageDefaultWidth());
                Logger.m11000e(str, sbM778t.toString());
            }
            SpenWPage spenWPageInsertPage = this.mNote.insertPage(i, i4, i5);
            copyBackground(page, spenWPageInsertPage);
            spenWPageCopyPage = spenWPageInsertPage;
        }
        this.mSpenNotePageLayouter.requestPageLayout();
        if (spenObjectTextBox != null && !TextUtils.isEmpty(spenObjectTextBox.getText())) {
            i7 = i;
            this.mSpenNoteTextManager.insertBodyTextTo(i7, i5, this.mDocRatio, spenObjectTextBox, i6);
        } else {
            i7 = i;
            this.mSpenNoteTextManager.insertEmptyBodyTextTo(i7, i5, this.mDocRatio);
        }
        this.mSpenNoteTextManager.unlockBodyTextPage();
        if (z) {
            commitHistory();
        }
        AbstractC0000a.m3D(i7, "insertPage# finish ", str);
        return spenWPageCopyPage;
    }

    public void setTemplate(SpenWPage spenWPage, int i, int i2, String str) {
        setTemplate(spenWPage, i, i2, str, getImageMode());
    }

    public void setTemplate(SpenWPage spenWPage, int i, int i2, String str, int i4) {
        spenWPage.setTemplateType(i);
        spenWPage.setBackgroundImageMode(i4);
        if (i2 != -1) {
            spenWPage.setBackgroundImage(i2, true);
        }
        spenWPage.setTemplateURI(str);
        updateTextOnlyMode(spenWPage);
    }

    public void deletePage(int i) {
        deletePage(i, true, true);
    }
}
