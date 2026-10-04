package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListMoreMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeEdit;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListHolderPresenter {
    private static final String TAG = Logger.createTag("PageListHolderPresenter");
    private final ComposerViewPresenter mCompViewPresenter;
    private PageListComposerModeHelper mComposerModeHelper;
    private ComposerModel mComposerModel;
    private final PageListContract.IContainerPresenter mContainerPresenter;
    private final Contract mContract;
    private final ControllerManager mControllerManager;
    private PageDragListenerImpl mDragListener;
    private MoreMenuListPopup mMoreMenuListPopup;
    private PageListMoreMenuPresenter mMoreMenuPresenter;
    private final PageListPresenter.OnKeyListenerImpl mOnKeyListener;
    private final PageListDataManager mPageListDataManager;
    private boolean mIsStartedEditModeByShift = false;
    private final Handler mHandler = new Handler(Looper.getMainLooper());

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Contract {
        PageListContract.IView getView();

        void hideStickyMemo();

        void setEditMode(int i);
    }

    public PageListHolderPresenter(PageListContract.IContainerPresenter iContainerPresenter, ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, PageListDataManager pageListDataManager, PageListPresenter.OnKeyListenerImpl onKeyListenerImpl, Contract contract) {
        this.mContainerPresenter = iContainerPresenter;
        this.mCompViewPresenter = composerViewPresenter;
        this.mControllerManager = controllerManager;
        this.mPageListDataManager = pageListDataManager;
        this.mOnKeyListener = onKeyListenerImpl;
        this.mContract = contract;
    }

    @NonNull
    private PageListMoreMenuPresenter.Contract getPageListMoreMenuPresenterContract() {
        return new PageListMoreMenuPresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListHolderPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListMoreMenuPresenter.Contract
            public void clearPageFocus() {
                PageListHolderPresenter.this.mContract.getView().clearPageFocus();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListMoreMenuPresenter.Contract
            public View getPageSearchEditView() {
                if (PageListHolderPresenter.this.mContract.getView() == null) {
                    return null;
                }
                return PageListHolderPresenter.this.mContract.getView().getPageSearchEditView();
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListMoreMenuPresenter.Contract
            public void hideStickyMemo() {
                PageListHolderPresenter.this.mContract.hideStickyMemo();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void moreBtnClicked(View view, String str, int i, int i2) {
        String str2 = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "moreBtnClicked#, index : ", " / view : ");
        sbM778t.append(view.hashCode());
        sbM778t.append("/ pId: ");
        sbM778t.append(str);
        Logger.m10999d(str2, sbM778t.toString());
        if (this.mMoreMenuListPopup == null) {
            this.mMoreMenuListPopup = new MoreMenuListPopup(this.mMoreMenuPresenter);
        }
        if (this.mMoreMenuListPopup.isShowing()) {
            this.mMoreMenuListPopup.dismiss();
        }
        this.mMoreMenuListPopup.show(view, str, i, this.mMoreMenuPresenter.getMenuList(str), this.mContract.getView());
        this.mComposerModeHelper.setLastToolType(i2);
        PageDragListenerImpl pageDragListenerImpl = this.mDragListener;
        if (pageDragListenerImpl != null) {
            pageDragListenerImpl.cancelDragAndDrop();
        }
        if (this.mComposerModel.isTabletLayout()) {
            ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_MORE_OPTIONS);
        } else {
            this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_PAGE_MORE_OPTION);
        }
    }

    private void onDummyPageClicked(int i) {
        Logger.addFileLog(TAG, "onDummyPageClicked", 0);
        this.mCompViewPresenter.getNoteManager().setAddPageBlocked("onDummyPageClicked", true);
        int iPreExecute = this.mMoreMenuPresenter.preExecute("onDummyPageClicked");
        this.mCompViewPresenter.getNoteManager().insertPage(i, i);
        this.mMoreMenuPresenter.updatePageIndex(iPreExecute, i - 1, i);
        View keyboardTargetView = this.mContract.getView().getKeyboardTargetView();
        if (keyboardTargetView != null) {
            keyboardTargetView.clearFocus();
            this.mControllerManager.getSoftInputManager().hide(keyboardTargetView);
        }
        this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_ADD_PAGE);
        this.mCompViewPresenter.getNoteManager().setAddPageBlocked("onDummyPageClicked", false);
    }

    private boolean onItemClickedByMouseWithKey(String str, int i) {
        if (i != 3 || (!this.mCompViewPresenter.isCtrlPressedLast() && !this.mOnKeyListener.mIsShiftPressed)) {
            return false;
        }
        String str2 = TAG;
        StringBuilder sb = new StringBuilder("onItemClickedByMouseWithKey# with ctrl: ");
        sb.append(this.mCompViewPresenter.isCtrlPressedLast());
        sb.append(" shift: ");
        AbstractC8014b.m7215q(sb, this.mOnKeyListener.isShiftPressed(), str2);
        if (this.mPageListDataManager.getPageListMode().getMode() == 0) {
            if (this.mComposerModel.getComposerSpenDocModel().hasUnknownObject()) {
                return false;
            }
            this.mContract.setEditMode(i);
            ((PageListModeEdit) this.mPageListDataManager.getPageListMode()).updateSelection(this.mContract.getView(), str, true);
            this.mIsStartedEditModeByShift = true;
            return true;
        }
        if (canMouseShiftSelectionAction() && this.mPageListDataManager.getPageListMode().getMode() == 1) {
            PageListModeEdit pageListModeEdit = (PageListModeEdit) this.mPageListDataManager.getPageListMode();
            int pageIndex = this.mPageListDataManager.getPageIndex(pageListModeEdit.getSelectedItems().iterator().next());
            int pageIndex2 = this.mPageListDataManager.getPageIndex(str);
            if (pageIndex < pageIndex2) {
                pageListModeEdit.updateSelection(this.mPageListDataManager.getPageIdList(), this.mContract.getView(), pageIndex, pageIndex2, true);
            } else {
                pageListModeEdit.updateSelection(this.mPageListDataManager.getPageIdList(), this.mContract.getView(), pageIndex2, pageIndex, true);
            }
        }
        this.mIsStartedEditModeByShift = false;
        return true;
    }

    public boolean canDrag(String str) {
        if (!this.mComposerModel.getMdeManager().getCoeditAdapter().isCoeditNote() && !this.mComposerModel.getModeManager().isDeleteOnlyMode() && !this.mCompViewPresenter.getComponentFactory().getConfig().isOnlyDeletableInPageList()) {
            if (this.mDragListener.hasDragInfo()) {
                Logger.m11000e(TAG, "onItemLongClicked# already dragging " + this.mDragListener.getDragIndex());
                return false;
            }
            int pageIndex = this.mPageListDataManager.getPageIndex(str);
            if (pageIndex >= 0 && !this.mPageListDataManager.isLastPage(pageIndex) && this.mPageListDataManager.getPageIdList().size() == this.mPageListDataManager.getPageManager().getPageCount()) {
                return true;
            }
        }
        return false;
    }

    public boolean canMouseShiftSelectionAction() {
        return this.mIsStartedEditModeByShift && this.mOnKeyListener.isShiftPressed();
    }

    public void clearIsStartedEditModeByShift() {
        this.mIsStartedEditModeByShift = false;
    }

    public PageListMoreMenuPresenter createMoreMenuPresenter(PageListMoreMenuPresenter.Contract contract, PageListDataManager pageListDataManager, ComposerModel composerModel, ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, PageListComposerModeHelper pageListComposerModeHelper, OptionMenuPresenter optionMenuPresenter) {
        return new PageListMoreMenuPresenter(contract, pageListDataManager, composerModel, composerViewPresenter, controllerManager, pageListComposerModeHelper, optionMenuPresenter);
    }

    public boolean dismissMoreMenuPopup() {
        MoreMenuListPopup moreMenuListPopup = this.mMoreMenuListPopup;
        if (moreMenuListPopup == null || !moreMenuListPopup.isShowing()) {
            return false;
        }
        this.mMoreMenuListPopup.dismiss();
        return true;
    }

    public PageListMoreMenuPresenter getMoreMenuPresenter() {
        return this.mMoreMenuPresenter;
    }

    public int getPageIndex(String str) {
        return this.mPageListDataManager.getPageIndex(str);
    }

    public void initMenu(PageListComposerModeHelper pageListComposerModeHelper, OptionMenuPresenter optionMenuPresenter) {
        this.mComposerModeHelper = pageListComposerModeHelper;
        this.mMoreMenuPresenter = createMoreMenuPresenter(getPageListMoreMenuPresenterContract(), this.mPageListDataManager, this.mComposerModel, this.mCompViewPresenter, this.mControllerManager, this.mComposerModeHelper, optionMenuPresenter);
    }

    public void onBookmarkClicked(String str) {
        AbstractC8014b.m7197C("onBookmarkClicked, index = /", str, TAG);
        this.mPageListDataManager.updateBookmark(str);
        if (this.mComposerModel.isTabletLayout()) {
            ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_BOOKMARK_PAGE);
        } else {
            this.mPageListDataManager.getPageListMode().insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_PAGE_BOOKMARK, this.mPageListDataManager.isBookmarked(str) ? "1" : "0");
        }
    }

    public void onCheckBoxClicked(String str, boolean z) {
        this.mIsStartedEditModeByShift = false;
        if (this.mPageListDataManager.isMode(1)) {
            ((PageListModeEdit) this.mPageListDataManager.getPageListMode()).updateSelection(this.mContract.getView(), str, z);
        }
    }

    public void onConfigurationChanged() {
        MoreMenuListPopup moreMenuListPopup = this.mMoreMenuListPopup;
        if (moreMenuListPopup != null) {
            moreMenuListPopup.dismiss();
        }
        PageListMoreMenuPresenter pageListMoreMenuPresenter = this.mMoreMenuPresenter;
        if (pageListMoreMenuPresenter != null) {
            pageListMoreMenuPresenter.onConfigurationChanged();
        }
    }

    public void onDestroy() {
        PageListMoreMenuPresenter pageListMoreMenuPresenter = this.mMoreMenuPresenter;
        if (pageListMoreMenuPresenter != null) {
            pageListMoreMenuPresenter.onDestroy();
        }
    }

    public void onDetachView() {
        MoreMenuListPopup moreMenuListPopup = this.mMoreMenuListPopup;
        if (moreMenuListPopup != null) {
            moreMenuListPopup.clear();
        }
        PageListMoreMenuPresenter pageListMoreMenuPresenter = this.mMoreMenuPresenter;
        if (pageListMoreMenuPresenter != null) {
            pageListMoreMenuPresenter.onDetachView();
        }
    }

    public void onHide() {
        dismissMoreMenuPopup();
    }

    public void onItemClicked(String str, int i) {
        int pageIndex = this.mPageListDataManager.getPageIndex(str);
        String str2 = TAG;
        AbstractC0000a.m3D(pageIndex, "onItemClicked# ", str2);
        MoreMenuListPopup moreMenuListPopup = this.mMoreMenuListPopup;
        if (moreMenuListPopup != null && moreMenuListPopup.isShowing()) {
            Logger.m10999d(str2, "onItemClicked# unexpected click event while more menu popup is showing");
            return;
        }
        if (pageIndex >= 0 && !onItemClickedByMouseWithKey(str, i)) {
            this.mIsStartedEditModeByShift = false;
            this.mCompViewPresenter.getObjectManager().clearSelectObject();
            if (this.mPageListDataManager.isLastPage(pageIndex)) {
                if (this.mComposerModeHelper.checkNoServerPermission()) {
                    return;
                }
                this.mComposerModeHelper.setLastToolType(i);
                onDummyPageClicked(pageIndex);
                return;
            }
            if (!this.mComposerModel.isTabletLayout()) {
                if (this.mPageListDataManager.isMode(2)) {
                    this.mCompViewPresenter.getSearchController().clearSearch();
                }
                this.mContainerPresenter.hide(false);
            }
            this.mPageListDataManager.getPageManager().getDocPageInfo().setCurrentPageIndex(pageIndex);
            this.mPageListDataManager.getPageManager().getDocPageInfo().setBlockToSetCurrentPage(true);
            this.mCompViewPresenter.getComposerControllerManager().getScrollController().goToPage(pageIndex);
            this.mPageListDataManager.getPageManager().getDocPageInfo().setBlockToSetCurrentPage(false);
        }
    }

    public void onMoreBtnClicked(final View view, final String str, final int i, final int i2) {
        if (this.mContract.getView().getPageSearchEditView() == null) {
            moreBtnClicked(view, str, i, i2);
        } else {
            this.mControllerManager.getSoftInputManager().hide(this.mContract.getView().getPageSearchEditView());
            this.mHandler.postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListHolderPresenter.2
                @Override // java.lang.Runnable
                public void run() {
                    PageListHolderPresenter.this.moreBtnClicked(view, str, i, i2);
                }
            }, 200L);
        }
    }

    public void onStartLongPressMultiSelection(int i) {
        this.mIsStartedEditModeByShift = false;
        this.mContract.getView().startLongPressMultiSelection(i);
    }

    public void readyDrag(int i) {
        this.mCompViewPresenter.getObjectManager().clearSelectObject();
        this.mComposerModeHelper.setLastToolType(i);
        if (this.mComposerModel.isTabletLayout()) {
            ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_MOVING_PAGE);
        } else {
            this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_PAGE_DRAG_AND_DROP);
        }
    }

    public void setComposerModel(ComposerModel composerModel) {
        this.mComposerModel = composerModel;
    }

    public void setDragListener(PageDragListenerImpl pageDragListenerImpl) {
        this.mDragListener = pageDragListenerImpl;
    }

    public void dismissMoreMenuPopup(String str) {
        MoreMenuListPopup moreMenuListPopup = this.mMoreMenuListPopup;
        if (moreMenuListPopup == null || !moreMenuListPopup.isShowing()) {
            return;
        }
        if (str == null || this.mMoreMenuListPopup.isSamePage(str)) {
            this.mMoreMenuListPopup.dismiss();
        }
    }
}
