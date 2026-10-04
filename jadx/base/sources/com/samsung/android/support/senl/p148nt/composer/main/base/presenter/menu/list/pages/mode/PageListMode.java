package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageListState;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.common.IPageAdapter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListMode {
    private static final String TAG = Logger.createTag("$PL$PageListMode");
    protected PageManager mPageManager;

    public PageListMode(PageManager pageManager) {
        this.mPageManager = pageManager;
    }

    private void updatePageAdapter(IPageAdapter iPageAdapter) {
        if (iPageAdapter != null) {
            iPageAdapter.enableAnimation();
            iPageAdapter.notifyDataSetChanged();
        }
    }

    public int adjustCurrentPageIndex(int i) {
        int iMax = i == this.mPageManager.getPageList().size() + (-1) ? Math.max(i - 1, 0) : i;
        AbstractC8014b.m7216r(i, iMax, "adjustCurrentPageIndex# pageIndex / result ", " / ", getTag());
        return iMax;
    }

    public void clear(List<PageId> list, PageListModeContract.IView iView) {
    }

    public int getMode() {
        return 0;
    }

    public String getScreenId() {
        return "504";
    }

    public HashSet<String> getSelectedItems() {
        return new HashSet<>();
    }

    public String getTag() {
        return TAG;
    }

    public void init(List<PageId> list) {
        mapToPageIdList(list);
    }

    public void insertSALogWithMode(String str) {
        ComposerSA.insertLog(getScreenId(), str);
    }

    public boolean isChecked(String str) {
        return false;
    }

    public boolean isMode(int i) {
        return getMode() == i;
    }

    public void mapToPageIdList(List<PageId> list) {
        list.clear();
        int pageCount = this.mPageManager.getPageCount();
        for (int i = 0; i < pageCount; i++) {
            list.add(new PageId(this.mPageManager.getPageInfo(i).getPageId()));
        }
    }

    public void onBookmarkUpdated(List<PageId> list, PageListModeContract.IView iView, boolean z) {
        IPageAdapter adapter = iView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    public void onPageDeleted(List<PageId> list, PageListModeContract.IView iView, PageManager.PageUpdateState pageUpdateState) {
        mapToPageIdList(list);
        iView.updatePageCountInfo(adjustCurrentPageIndex(this.mPageManager.getDocPageInfo().getCurrentPageIndex()));
        updatePageAdapter(iView.getAdapter());
    }

    public void onPageInserted(List<PageId> list, PageListModeContract.IView iView, PageManager.PageUpdateState pageUpdateState) {
        Logger.m10999d(getTag(), "onPageInserted# ");
        mapToPageIdList(list);
        iView.notifyCurrentPageIndexChanged(adjustCurrentPageIndex(this.mPageManager.getDocPageInfo().getCurrentPageIndex()), pageUpdateState.getPageIdList().size() > 1, false);
        updatePageAdapter(iView.getAdapter());
    }

    public void onPageListChanged(List<PageId> list, PageListModeContract.IView iView) {
        mapToPageIdList(list);
        updatePageAdapter(iView.getAdapter());
        iView.updatePageCountInfo();
    }

    public void onPageMoved(List<PageId> list, PageListModeContract.IView iView) {
        mapToPageIdList(list);
        updatePageAdapter(iView.getAdapter());
    }

    public void onPageUpdated(List<PageId> list, PageListModeContract.IView iView, int i) {
        Logger.m10999d(getTag(), "onPageUpdated# " + i);
        IPageAdapter adapter = iView.getAdapter();
        if (adapter != null) {
            adapter.disableAnimation();
            adapter.notifyItemChanged(i);
        }
    }

    public void restore(PageListState pageListState, PageListModeContract.IView iView, ComposerViewPresenter composerViewPresenter) {
    }

    public PageListState saveState(List<PageId> list, PageListModeContract.IView iView) {
        return new PageListState(getMode());
    }

    @NonNull
    public String toString() {
        return String.valueOf(getMode());
    }

    public void insertSALogWithMode(String str, String str2) {
        ComposerSA.insertLog(getScreenId(), str, str2);
    }
}
