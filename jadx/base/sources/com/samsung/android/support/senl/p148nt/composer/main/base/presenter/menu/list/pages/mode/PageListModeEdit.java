package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageListState;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListModeEdit extends PageListMode {
    private static final String TAG = Logger.createTag("PageListModeEdit");
    private boolean mBlockOnPageDeleted;
    private HashSet<String> mSelectedItems;

    public PageListModeEdit(PageManager pageManager) {
        super(pageManager);
    }

    private void checkSelectedItems(PageManager pageManager) {
        if (pageManager.getPageCount() == 0) {
            Logger.m11000e(TAG, "checkSelectedItems# pageList is empty");
            return;
        }
        int size = this.mSelectedItems.size();
        ArrayList arrayList = new ArrayList();
        PageInfo pageInfo = pageManager.getPageInfo(pageManager.getPageCount() - 1);
        for (String str : this.mSelectedItems) {
            PageInfo pageInfo2 = pageManager.getPageInfo(str);
            if (pageInfo2 == null || pageInfo2.getPageId().equals(pageInfo.getPageId())) {
                arrayList.add(str);
            }
        }
        this.mSelectedItems.removeAll(arrayList);
        String str2 = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(size, "checkSelectedItems, before/after = ", "/");
        sbM778t.append(this.mSelectedItems.size());
        Logger.m10999d(str2, sbM778t.toString());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void clear(List<PageId> list, PageListModeContract.IView iView) {
        selectAll(list, iView, false, false);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public int getMode() {
        return 1;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public String getScreenId() {
        return SortPageSAConstants.SORTPAGE_SCREEN_ID_PAGE_LIST_EDIT;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public HashSet<String> getSelectedItems() {
        return this.mSelectedItems;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void init(List<PageId> list) {
        super.init(list);
        this.mSelectedItems = new HashSet<>();
        this.mBlockOnPageDeleted = false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public boolean isChecked(String str) {
        return this.mSelectedItems.contains(str);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void mapToPageIdList(List<PageId> list) {
        list.clear();
        int pageCount = this.mPageManager.getPageCount() - 1;
        for (int i = 0; i < pageCount; i++) {
            list.add(new PageId(this.mPageManager.getPageInfo(i).getPageId()));
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageDeleted(List<PageId> list, PageListModeContract.IView iView, PageManager.PageUpdateState pageUpdateState) {
        if (this.mBlockOnPageDeleted) {
            return;
        }
        super.onPageDeleted(list, iView, pageUpdateState);
        checkSelectedItems(this.mPageManager);
        iView.onSelectedPageUpdated(this.mSelectedItems.size(), this.mSelectedItems.size());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageInserted(List<PageId> list, PageListModeContract.IView iView, PageManager.PageUpdateState pageUpdateState) {
        super.onPageInserted(list, iView, pageUpdateState);
        iView.onSelectedPageUpdated(this.mSelectedItems.size(), this.mSelectedItems.size());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageListChanged(List<PageId> list, PageListModeContract.IView iView) {
        super.onPageListChanged(list, iView);
        checkSelectedItems(this.mPageManager);
        iView.onSelectedPageUpdated(this.mSelectedItems.size(), this.mSelectedItems.size());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void restore(PageListState pageListState, PageListModeContract.IView iView, ComposerViewPresenter composerViewPresenter) {
        this.mSelectedItems.addAll(pageListState.getSelectedItems());
        if (pageListState.isDeletingPages()) {
            composerViewPresenter.getNoteManager().getNote().endHistoryGroup();
            composerViewPresenter.getThumbnailUpdateHandler().setBlockToUpdate(false);
            checkSelectedItems(this.mPageManager);
        }
        iView.onSelectedPageUpdated(0, this.mSelectedItems.size());
    }

    public void reverseSelection(List<PageId> list, PageListModeContract.IView iView, int i) {
        int size = this.mSelectedItems.size();
        String id = list.get(i).getId();
        if (this.mSelectedItems.contains(id)) {
            this.mSelectedItems.remove(id);
        } else {
            this.mSelectedItems.add(id);
        }
        iView.onSelectedPageUpdated(size, this.mSelectedItems.size());
        iView.onToggleCheckBox(i);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public PageListState saveState(List<PageId> list, PageListModeContract.IView iView) {
        PageListState pageListStateSaveState = super.saveState(list, iView);
        pageListStateSaveState.setSelectedItems(new ArrayList(this.mSelectedItems));
        return pageListStateSaveState;
    }

    public void selectAll(List<PageId> list, PageListModeContract.IView iView, boolean z, boolean z2) {
        int size = this.mSelectedItems.size();
        if (z) {
            Iterator<PageId> it = list.iterator();
            while (it.hasNext()) {
                this.mSelectedItems.add(it.next().getId());
            }
        } else {
            this.mSelectedItems.clear();
        }
        iView.onSelectedPageUpdated(size, this.mSelectedItems.size());
        String str = TAG;
        StringBuilder sbM3200j = AbstractC4539a.m3200j("selectAll#, checked/selectedCount : ", " / ", z);
        sbM3200j.append(this.mSelectedItems.size());
        Logger.m10999d(str, sbM3200j.toString());
        if (z2) {
            iView.getAdapter().notifyDataSetChanged();
        }
    }

    public void setBlockOnPageDeleted(boolean z) {
        this.mBlockOnPageDeleted = z;
    }

    public void updateSelection(PageListModeContract.IView iView, String str, boolean z) {
        int size = this.mSelectedItems.size();
        if (z) {
            this.mSelectedItems.add(str);
        } else {
            this.mSelectedItems.remove(str);
        }
        iView.onSelectedPageUpdated(size, this.mSelectedItems.size());
        String str2 = TAG;
        StringBuilder sbM2229t = AbstractC2821a.m2229t("onCheckBoxClicked#, pageId/checked : ", str, " / ", z, ", checkedCount = ");
        sbM2229t.append(this.mSelectedItems.size());
        Logger.m10999d(str2, sbM2229t.toString());
        insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_EDIT_MODE_PAGE_SELECTION);
    }

    public void updateSelection(List<PageId> list, PageListModeContract.IView iView, int i, int i2, boolean z) {
        int size = this.mSelectedItems.size();
        while (true) {
            i++;
            if (i <= i2) {
                String id = list.get(i).getId();
                if (z) {
                    this.mSelectedItems.add(id);
                } else {
                    this.mSelectedItems.remove(id);
                }
            } else {
                iView.onSelectedPageUpdated(size, this.mSelectedItems.size());
                iView.getAdapter().notifyDataSetChanged();
                return;
            }
        }
    }
}
