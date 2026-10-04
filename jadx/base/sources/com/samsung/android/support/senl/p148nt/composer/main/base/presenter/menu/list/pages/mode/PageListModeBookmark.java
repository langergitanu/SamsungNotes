package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode;

import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.BookmarkModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import java.util.List;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListModeBookmark extends PageListMode {
    private static final String TAG = Logger.createTag("PageListModeBookmark");
    private BookmarkModel mBookmarkModel;

    public PageListModeBookmark(PageManager pageManager, BookmarkModel bookmarkModel) {
        super(pageManager);
        this.mBookmarkModel = bookmarkModel;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public int getMode() {
        return 3;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void init(List<PageId> list) {
        super.init(list);
        insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_BOOKMARK_MODE);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void mapToPageIdList(List<PageId> list) {
        list.clear();
        int pageCountExcludedDummy = this.mPageManager.getPageCountExcludedDummy();
        for (int i = 0; i < pageCountExcludedDummy; i++) {
            PageInfo pageInfo = this.mPageManager.getPageInfo(i);
            if (this.mBookmarkModel.isBookmarked(pageInfo.getPageId())) {
                list.add(new PageId(pageInfo.getPageId()));
            }
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onBookmarkUpdated(List<PageId> list, PageListModeContract.IView iView, boolean z) {
        mapToPageIdList(list);
        if (!z) {
            iView.updateNoBookmarkView(!this.mBookmarkModel.hasBookmarkedPage());
        }
        super.onBookmarkUpdated(list, iView, z);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageDeleted(List<PageId> list, PageListModeContract.IView iView, PageManager.PageUpdateState pageUpdateState) {
        super.onPageDeleted(list, iView, pageUpdateState);
        iView.updateNoBookmarkView(!this.mBookmarkModel.hasBookmarkedPage());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageInserted(List<PageId> list, PageListModeContract.IView iView, PageManager.PageUpdateState pageUpdateState) {
        super.onPageInserted(list, iView, pageUpdateState);
        iView.updateNoBookmarkView(!this.mBookmarkModel.hasBookmarkedPage());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageListChanged(List<PageId> list, PageListModeContract.IView iView) {
        super.onPageListChanged(list, iView);
        iView.updateNoBookmarkView(!this.mBookmarkModel.hasBookmarkedPage());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageUpdated(List<PageId> list, PageListModeContract.IView iView, int i) {
        AbstractC0000a.m3D(i, "onPageUpdated# ", getTag());
        PageInfo pageInfo = this.mPageManager.getPageInfo(i);
        int pageCount = this.mPageManager.getPageCount();
        for (int i2 = 0; i2 < pageCount; i2++) {
            if (list.get(i2).getId().equals(pageInfo.getPageId())) {
                Logger.m10999d(getTag(), "onPageUpdated# pageIndex to pageId Index: " + i2);
                iView.getAdapter().disableAnimation();
                iView.getAdapter().notifyItemChanged(i2);
                return;
            }
        }
    }
}
