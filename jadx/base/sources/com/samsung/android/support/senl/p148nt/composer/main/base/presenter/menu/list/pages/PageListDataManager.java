package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.BookmarkModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.DocPageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageList;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListDataManager implements PageManager.OnPageUpdateListener, DocPageInfo.PageIndexObserver, BookmarkModel.IBookmarkUpdateListener, IPageList {
    private static final String TAG = Logger.createTag("PageListDataManager");
    private BookmarkModel mBookmarkModel;
    private final Contract mContract;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private List<PageId> mPageIdList;
    private PageListMode mPageListMode;
    private PageManager mPageManager;
    private boolean mSkipBookmarkUpdated;
    private final TaskController mTaskController;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        PageListContract.IView getView();
    }

    public PageListDataManager(Contract contract, TaskController taskController) {
        this.mContract = contract;
        this.mTaskController = taskController;
    }

    public int adjustCurrentPageIndex(int i) {
        int iMax = i == this.mPageManager.getPageList().size() + (-1) ? Math.max(i - 1, 0) : i;
        AbstractC8014b.m7216r(i, iMax, "adjustCurrentPageIndex# pageIndex / result ", " / ", TAG);
        return iMax;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageList
    public int getAllPageCount() {
        return this.mPageManager.getPageCount();
    }

    public BookmarkModel getBookmarkModel() {
        return this.mBookmarkModel;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageList
    public PageId getItem(int i) {
        return this.mPageIdList.get(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageList
    public int getItemCount() {
        return this.mPageIdList.size();
    }

    public List<PageId> getPageIdList() {
        return this.mPageIdList;
    }

    public int getPageIndex(String str) {
        return this.mPageManager.indexOf(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageList
    public PageInfo getPageInfo(String str) {
        return this.mPageManager.getPageInfo(str);
    }

    public PageListMode getPageListMode() {
        return this.mPageListMode;
    }

    public PageManager getPageManager() {
        return this.mPageManager;
    }

    public void insertSALogWithMode(String str) {
        this.mPageListMode.insertSALogWithMode(str);
    }

    public boolean isBookmarked(String str) {
        return this.mBookmarkModel.isBookmarked(str);
    }

    public boolean isLastPage(int i) {
        return this.mPageManager.getPageCount() - 1 == i;
    }

    public boolean isMode(int i) {
        return this.mPageListMode.isMode(i);
    }

    public boolean isNotNeededToUpdatePageState() {
        return this.mContract.getView() == null || this.mContract.getView().getAdapter() == null;
    }

    public boolean isPrepared() {
        int pageCount = this.mPageManager.getPageCount();
        AbstractC0000a.m3D(pageCount, "isPrepared#,  page list size is : ", TAG);
        return pageCount > 0;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.list.pages.BookmarkModel.IBookmarkUpdateListener
    public void onBookmarkPageUpdated(String str, int i, boolean z) {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.list.pages.BookmarkModel.IBookmarkUpdateListener
    public void onBookmarkUpdated(String str, int i, boolean z, boolean z2) {
        if (this.mContract.getView() == null || !this.mContract.getView().isShowing()) {
            return;
        }
        if (!this.mSkipBookmarkUpdated || (isMode(3) && !this.mContract.getView().isComputingLayout())) {
            this.mPageListMode.onBookmarkUpdated(this.mPageIdList, this.mContract.getView(), z);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
    public void onDeletedPages(List<Integer> list, final PageManager.PageUpdateState pageUpdateState) {
        if (isNotNeededToUpdatePageState()) {
            return;
        }
        if (pageUpdateState.isThread()) {
            this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListDataManager.2
                @Override // java.lang.Runnable
                public void run() {
                    PageListDataManager.this.mPageListMode.onPageDeleted(PageListDataManager.this.mPageIdList, PageListDataManager.this.mContract.getView(), pageUpdateState);
                }
            });
        } else {
            this.mPageListMode.onPageDeleted(this.mPageIdList, this.mContract.getView(), pageUpdateState);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
    public void onInsertedPages(final PageManager.PageUpdateState pageUpdateState) {
        if (isNotNeededToUpdatePageState()) {
            return;
        }
        if (pageUpdateState.isThread()) {
            this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListDataManager.1
                @Override // java.lang.Runnable
                public void run() {
                    PageListDataManager.this.mPageListMode.onPageInserted(PageListDataManager.this.mPageIdList, PageListDataManager.this.mContract.getView(), pageUpdateState);
                }
            });
        } else {
            this.mPageListMode.onPageInserted(this.mPageIdList, this.mContract.getView(), pageUpdateState);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.DocPageInfo.PageIndexObserver
    public void onPageIndexChanged(int i) {
        if (isNotNeededToUpdatePageState()) {
            return;
        }
        AbstractC0000a.m3D(i, "onPageIndexChanged# ", TAG);
        if (this.mTaskController.isAvailableToUpdate()) {
            this.mContract.getView().notifyCurrentPageIndexChanged(adjustCurrentPageIndex(i), true, true);
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.page.PageManager.OnPageUpdateListener
    public void onUpdatePage(int i, int i2, int i4, PageManager.PageUpdateState pageUpdateState) {
        if (isNotNeededToUpdatePageState()) {
            return;
        }
        if (i == 1) {
            this.mPageListMode.onPageUpdated(this.mPageIdList, this.mContract.getView(), i2);
        } else if (i == 2) {
            this.mPageListMode.onPageMoved(this.mPageIdList, this.mContract.getView());
        } else {
            if (i != 3) {
                return;
            }
            this.mPageListMode.onPageListChanged(this.mPageIdList, this.mContract.getView());
        }
    }

    public void release() {
        this.mHandler.removeCallbacksAndMessages(null);
    }

    public void resetData() {
        this.mPageIdList = new ArrayList(this.mPageManager.getPageCount());
        this.mPageListMode = null;
    }

    public void setBookmarkModel(BookmarkModel bookmarkModel) {
        this.mBookmarkModel = bookmarkModel;
        bookmarkModel.addListener(this);
    }

    public void setPageListMode(PageListMode pageListMode) {
        this.mPageListMode = pageListMode;
    }

    public void setPageManager(PageManager pageManager) {
        this.mPageManager = pageManager;
        pageManager.addListener(this);
        pageManager.getDocPageInfo().addPageIndexObserver(this);
    }

    public void updateBookmark(String str) {
        PageInfo pageInfo = this.mPageManager.getPageInfo(str);
        if (pageInfo != null) {
            this.mSkipBookmarkUpdated = true;
            this.mBookmarkModel.update(pageInfo);
            this.mSkipBookmarkUpdated = false;
        }
    }
}
