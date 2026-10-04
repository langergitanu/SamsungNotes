package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener;

import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.pen.document.changedInfo.SpenPageChangedInfo;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.sdk.pen.worddoc.SpenWPage;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.app.main.noteslist.presenter.somrecognize.common.Constant;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.BookmarkModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.listener.ListenerImplContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpenPageEventListener implements SpenWNote.PageEventListener {
    private static final int INPUTSIZE_THRESOLD = 1000;
    private static final String TAG = Logger.createTag("SpenPageEventListener");
    private ComposerModel mComposerModel;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private NoteManager mNoteManager;
    private PageManager mPageManager;
    private ListenerImplContract.IPresenter mPresenter;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PageComparator implements Comparator<PageInfo>, Serializable {
        private static final long serialVersionUID = 1;

        public /* synthetic */ PageComparator(int i) {
            this();
        }

        private PageComparator() {
        }

        @Override // java.util.Comparator
        public int compare(PageInfo pageInfo, PageInfo pageInfo2) {
            return pageInfo.getPageIndex() - pageInfo2.getPageIndex();
        }
    }

    public SpenPageEventListener(ListenerImplContract.IPresenter iPresenter) {
        this.mPresenter = iPresenter;
        this.mComposerModel = iPresenter.getComposerModel();
        this.mPageManager = iPresenter.getPageManager();
        this.mNoteManager = iPresenter.getNoteManager();
    }

    private void insertPage(SpenWNote spenWNote, ArrayList<SpenWPage> arrayList) {
        HashMap map;
        int size = arrayList.size();
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(size, "onPageInserted# arg: ", " before list size: ");
        sbM778t.append(this.mPageManager.getPageCount());
        Logger.m10999d(str, sbM778t.toString());
        if (this.mPageManager.getPageCount() == 0) {
            Logger.m11000e(str, "onPageInserted# unexpected condition : page count is 0");
        }
        Logger.addFileLog(str, "onPageInsert", 16);
        int i = 0;
        if (size > 1000) {
            ArrayList<SpenWPage> pageList = spenWNote.getPageList();
            map = new HashMap();
            int size2 = pageList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                map.put(spenWNote.getPage(i2).getId(), Integer.valueOf(i2));
            }
        } else {
            map = null;
        }
        ArrayList<PageInfo> arrayList2 = new ArrayList(size);
        for (SpenWPage spenWPage : arrayList) {
            String id = spenWPage.getId();
            int iIntValue = map != null ? ((Integer) map.get(id)).intValue() : spenWNote.getPageIndexById(id);
            int width = spenWPage.getWidth();
            int height = spenWPage.getHeight();
            BookmarkModel bookmarkModel = this.mComposerModel.getBookmarkModel();
            if (bookmarkModel != null) {
                bookmarkModel.updateDeletedInfo(id, false);
            }
            arrayList2.add(new PageInfo(iIntValue, width, height, id));
        }
        Collections.sort(arrayList2, new PageComparator(i));
        ArrayList arrayList3 = new ArrayList(arrayList2.size());
        ArrayList arrayList4 = new ArrayList(arrayList2.size());
        for (PageInfo pageInfo : arrayList2) {
            arrayList3.add(Integer.valueOf(pageInfo.getPageIndex()));
            arrayList4.add(pageInfo.getPageId());
        }
        this.mPageManager.insert(arrayList2, arrayList3, new PageManager.PageUpdateState(isThread(), arrayList4));
    }

    private boolean isAvailableEventType(int i) {
        return i == 4 || i == 1 || i == 2;
    }

    private boolean isThread() {
        return Looper.getMainLooper() != Looper.myLooper();
    }

    private void onBackgroundColorChanged(SpenPageChangedInfo spenPageChangedInfo, SpenWPage spenWPage) {
        NoteManager noteManager;
        if (spenPageChangedInfo.pageChangedType == 2 && (noteManager = this.mNoteManager) != null && noteManager.updateBackgroundColor(spenWPage.getBackgroundColor())) {
            this.mComposerModel.getNotesDocEntityManager().setBackgroundColor(this.mNoteManager.getBackgroundColor());
            this.mPresenter.getThumbnailUpdateHandler().updateThumbnailAll();
        }
    }

    private void onBackgroundImageChanged(SpenWNote spenWNote, ArrayList<SpenPageChangedInfo> arrayList, ArrayList<SpenWPage> arrayList2, boolean z) {
        if (z) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arrayList.size(); i++) {
                int i2 = arrayList.get(i).pageChangedType;
                if (i2 == 7 || i2 == 5 || i2 == 3) {
                    try {
                        int pageIndex = spenWNote.getPageIndex(arrayList2.get(i));
                        this.mPresenter.getThumbnailUpdateHandler().updateThumbnail(pageIndex);
                        sb.append(pageIndex);
                        sb.append(',');
                    } catch (Exception e) {
                        AbstractC8014b.m7205g(e, new StringBuilder("onBackgroundImageChanged# ex "), TAG);
                    }
                }
            }
            if (sb.length() > 0) {
                Logger.m10999d(TAG, "onBackgroundImageChanged# " + sb.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBackground(SpenWNote spenWNote, ArrayList<SpenPageChangedInfo> arrayList, ArrayList<SpenWPage> arrayList2, boolean z) {
        Logger.m10999d(TAG, "onPageChanged# start");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            SpenWPage spenWPage = arrayList2.get(i);
            SpenPageChangedInfo spenPageChangedInfo = arrayList.get(i);
            sb.append(spenWPage.getId());
            sb.append(": ");
            sb.append(spenPageChangedInfo.pageChangedType);
            sb.append("\n");
        }
        onBackgroundColorChanged(arrayList.get(0), arrayList2.get(0));
        onBackgroundImageChanged(spenWNote, arrayList, arrayList2, z);
        String str = TAG;
        Logger.m10999d(str, "onPageChanged# " + sb.toString());
        Logger.m10999d(str, "onPageChanged# end");
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.PageEventListener
    public void onPageChanged(final SpenWNote spenWNote, final ArrayList<SpenPageChangedInfo> arrayList, final ArrayList<SpenWPage> arrayList2, int i) {
        if (arrayList == null || arrayList.size() == 0 || !isAvailableEventType(i)) {
            return;
        }
        Looper mainLooper = Looper.getMainLooper();
        final boolean zIsEditingByCoedit = spenWNote.isEditingByCoedit();
        if (Thread.currentThread() == mainLooper.getThread()) {
            updateBackground(spenWNote, arrayList, arrayList2, zIsEditingByCoedit);
        } else {
            this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.listener.SpenPageEventListener.1
                @Override // java.lang.Runnable
                public void run() {
                    SpenPageEventListener.this.updateBackground(spenWNote, arrayList, arrayList2, zIsEditingByCoedit);
                }
            });
        }
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.PageEventListener
    public void onPageIndexMoved(SpenWNote spenWNote, ArrayList<SpenWPage> arrayList, ArrayList<Integer> arrayList2, ArrayList<Integer> arrayList3, int i) {
        PageInfo pageInfo;
        if (isAvailableEventType(i)) {
            String str = TAG;
            Logger.m10999d(str, "onPageIndexMoved# start");
            Logger.addFileLog(str, "onPageMov", 16);
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                SpenWPage spenWPage = arrayList.get(i2);
                int iIntValue = arrayList2.get(i2).intValue();
                int iIntValue2 = arrayList3.get(i2).intValue();
                if (this.mPageManager.getPageInfo(iIntValue).getPageId().equals(spenWPage.getId())) {
                    this.mPageManager.move(iIntValue, iIntValue2);
                } else {
                    Logger.m11000e(TAG, "onPageIndexMoved# page list and document are not matched");
                    int pageCount = this.mPageManager.getPageCount();
                    int i4 = 0;
                    while (true) {
                        if (i4 >= pageCount) {
                            pageInfo = null;
                            break;
                        }
                        pageInfo = this.mPageManager.getPageInfo(i4);
                        if (pageInfo.getPageId().equals(spenWPage.getId())) {
                            break;
                        } else {
                            i4++;
                        }
                    }
                    if (pageInfo == null) {
                        Logger.m11000e(TAG, "onPageIndexMoved# pageInfo is null");
                        this.mPageManager.insert(new PageInfo(iIntValue2, spenWPage.getWidth(), spenWPage.getHeight(), spenWPage.getId()), iIntValue2, new PageManager.PageUpdateState(true, spenWPage.getId()));
                    } else {
                        this.mPageManager.move(i4, iIntValue2);
                    }
                }
            }
            Logger.m10999d(TAG, "onPageIndexMoved# end");
        }
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.PageEventListener
    public void onPageInserted(SpenWNote spenWNote, ArrayList<SpenWPage> arrayList, int i) {
        if (spenWNote == null) {
            Logger.m11000e(TAG, "onPageInserted# note is null : " + i);
            return;
        }
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "onPageInserted# ", " isCoedit: ");
        sbM778t.append(spenWNote.isEditingByCoedit());
        Logger.m10999d(str, sbM778t.toString());
        if (arrayList == null || arrayList.isEmpty()) {
            Logger.m11000e(str, "onPageInserted# arrayList is null : " + i);
        } else if (isAvailableEventType(i)) {
            insertPage(spenWNote, arrayList);
        }
    }

    @Override // com.samsung.android.sdk.pen.worddoc.SpenWNote.PageEventListener
    public void onPageRemoved(SpenWNote spenWNote, ArrayList<SpenWPage> arrayList, int i) {
        if (arrayList == null || arrayList.isEmpty()) {
            Logger.m11000e(TAG, "onPageRemoved# arrayList is 0 : " + i);
            return;
        }
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "onPageRemoved# ", Constant.WHITE_SPACE_FOR_LINK_ICON);
        sbM778t.append(arrayList.size());
        Logger.m10999d(str, sbM778t.toString());
        if (isAvailableEventType(i)) {
            Logger.addFileLog(str, "onPageRemove", 16);
            Logger.m10999d(str, "onPageRemoved# arg: " + arrayList.size() + " before list size: " + this.mPageManager.getPageCount());
            ArrayList arrayList2 = new ArrayList(arrayList.size());
            for (SpenWPage spenWPage : arrayList) {
                String id = spenWPage.getId();
                arrayList2.add(spenWPage.getId());
                BookmarkModel bookmarkModel = this.mComposerModel.getBookmarkModel();
                if (bookmarkModel != null) {
                    bookmarkModel.updateDeletedInfo(id, true);
                }
            }
            this.mPageManager.remove(arrayList2, new PageManager.PageUpdateState(isThread(), arrayList2));
        }
    }

    public void release() {
        this.mPageManager = null;
        this.mComposerModel = null;
        this.mNoteManager = null;
        this.mHandler.removeCallbacksAndMessages(null);
        this.mPresenter = null;
    }
}
