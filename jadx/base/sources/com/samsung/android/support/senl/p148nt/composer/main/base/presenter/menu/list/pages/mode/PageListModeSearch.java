package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode;

import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.EditText;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageId;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageListState;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListModeSearch extends PageListMode {
    private static final String TAG = Logger.createTag("PageListModeSearch");
    private final ComposerViewPresenter mComposerViewPresenter;
    private final PageListSearch mPageListSearch;
    private final SoftInputManager mSoftInputManager;

    public PageListModeSearch(PageManager pageManager, ComposerViewPresenter composerViewPresenter, SoftInputManager softInputManager, PageListSearch pageListSearch) {
        super(pageManager);
        this.mComposerViewPresenter = composerViewPresenter;
        this.mSoftInputManager = softInputManager;
        this.mPageListSearch = pageListSearch;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void clear(List<PageId> list, PageListModeContract.IView iView) {
        this.mPageListSearch.setSearchMode(false);
        this.mSoftInputManager.hide(iView.getKeyboardTargetView());
        if (this.mComposerViewPresenter.getView() == null || this.mComposerViewPresenter.getView().isFocused()) {
            return;
        }
        this.mComposerViewPresenter.getView().requestFocus();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public int getMode() {
        return 2;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public String getTag() {
        return TAG;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void init(List<PageId> list) {
        list.clear();
        this.mPageListSearch.setSearchMode(true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void mapToPageIdList(List<PageId> list) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageDeleted(List<PageId> list, PageListModeContract.IView iView, PageManager.PageUpdateState pageUpdateState) {
        for (String str : pageUpdateState.getPageIdList()) {
            Iterator<PageId> it = list.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().getId().equals(str)) {
                        it.remove();
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        iView.getAdapter().notifyDataSetChanged();
        if (list.isEmpty()) {
            iView.updateNoResultView(true);
        }
        iView.updatePageCountInfo();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageInserted(List<PageId> list, PageListModeContract.IView iView, PageManager.PageUpdateState pageUpdateState) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageListChanged(List<PageId> list, PageListModeContract.IView iView) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageMoved(List<PageId> list, PageListModeContract.IView iView) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void onPageUpdated(List<PageId> list, PageListModeContract.IView iView, int i) {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public void restore(PageListState pageListState, PageListModeContract.IView iView, ComposerViewPresenter composerViewPresenter) {
        if (iView == null || !pageListState.hasSearchInputFieldFocus() || TextUtils.isEmpty(pageListState.getSearchKeyword())) {
            return;
        }
        if (iView.getPageSearchEditView() != null) {
            this.mPageListSearch.setRestoring(true);
            iView.getPageSearchEditView().setText(pageListState.getSearchKeyword());
            iView.getPageSearchEditView().setSelection(pageListState.getSearchKeyword().length());
            this.mPageListSearch.setRestoring(false);
        }
        iView.updateNoResultView(pageListState.getPageIndexArray().length == 0);
        this.mPageListSearch.updatePageIndexList(pageListState.getPageIndexArray(), pageListState.getPageSearchThumbnailArray());
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode
    public PageListState saveState(List<PageId> list, PageListModeContract.IView iView) {
        PageListState pageListStateSaveState = super.saveState(list, iView);
        EditText pageSearchEditView = iView.getPageSearchEditView();
        int i = 0;
        boolean z = pageSearchEditView != null && pageSearchEditView.hasFocus();
        SpannableString spannableString = new SpannableString(pageSearchEditView == null ? "" : pageSearchEditView.getText());
        int[] iArr = new int[list.size()];
        String[] strArr = new String[list.size()];
        for (PageId pageId : list) {
            int iIndexOf = this.mPageManager.indexOf(pageId.getId());
            if (iIndexOf < 0) {
                Logger.m11004w(getTag(), "onSaveInstanceState#, invalid index : " + iIndexOf);
            } else {
                iArr[i] = iIndexOf;
                strArr[i] = pageId.getSearchThumbnailPath();
                i++;
            }
        }
        pageListStateSaveState.setHasSearchInputFieldFocus(z);
        pageListStateSaveState.setSearchKeyword(spannableString.toString());
        pageListStateSaveState.setPageIndexArray(iArr);
        pageListStateSaveState.setPageSearchThumbnailArray(strArr);
        return pageListStateSaveState;
    }
}
