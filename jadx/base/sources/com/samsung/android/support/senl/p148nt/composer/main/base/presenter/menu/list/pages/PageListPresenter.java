package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.list.pages.PageListState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.ModeManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SearchController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.SoftInputManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListDataManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListHolderPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListThumbnailHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListMode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeBookmark;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeEdit;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListModeSearch;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.mode.PageListSearch;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.BackgroundColorUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.NavigationBarUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.SaveInstancesHelper;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.SortPageSAConstants;
import com.samsung.android.support.senl.p148nt.model.securefolder.common.SecureFolderConstants;
import java.util.Observable;
import java.util.Observer;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PageListPresenter implements PageDragListenerImpl.IPresenter, PageListContract.IPresenter, NoteManager.ObserverBackgroundColor {
    private static final String KEY = "PageListState";
    private static final String TAG = Logger.createTag("PageListPresenter");
    private final ComposerViewPresenter mCompViewPresenter;
    private PageListComposerModeHelper mComposerModeHelper;
    protected ComposerModel mComposerModel;
    private final PageListContract.IContainerPresenter mContainerPresenter;
    private final ControllerManager mControllerManager;
    private final DialogPresenterManager mDialogPresenterManager;
    private PageDragListenerImpl mDragListener;
    private PageListEditModeMenuPresenter mEditModeMenuPresenter;
    private final boolean mIsBookmarkMenuEnabled;
    private boolean mIsRestored;
    private final MenuPresenterContract.IMenuManager mMenuManager;
    private final OnKeyListenerImpl mOnKeyListener;
    private OptionMenuPresenter mOptionMenuPresenter;
    private final PageListHolderPresenter mPageHolderPresenter;
    private final PageListDataManager mPageListDataManager;
    private PageListSearch mPageListSearch;
    private SaveInstancesHelper mSaveInstancesHelper;
    private final SearchController mSearchController;
    private final SoftInputManager mSoftInputManager;
    private PageListThumbnailHelper mThumbnailHelper;
    private PageListContract.IView mView;
    private int mOrientation = 1;
    private boolean mIsShownWithPhoneLayout = false;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class OnKeyListenerImpl implements View.OnKeyListener {
        boolean mIsShiftPressed = false;

        public OnKeyListenerImpl() {
        }

        public boolean isShiftPressed() {
            return this.mIsShiftPressed;
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i, KeyEvent keyEvent) {
            if (i == 59 || i == 60) {
                if (keyEvent.getAction() == 0) {
                    this.mIsShiftPressed = true;
                } else if (keyEvent.getAction() == 1) {
                    this.mIsShiftPressed = false;
                }
                if (PageListPresenter.this.isShowing()) {
                    PageListPresenter.this.mView.onKeyEvent(i, keyEvent);
                }
            } else if ((i == 113 || i == 114) && PageListPresenter.this.isShowing()) {
                PageListPresenter.this.mView.onKeyEvent(i, keyEvent);
            }
            return false;
        }
    }

    public PageListPresenter(PageListContract.IContainerPresenter iContainerPresenter, ComposerViewPresenter composerViewPresenter, ControllerManager controllerManager, DialogPresenterManager dialogPresenterManager, final MenuPresenterContract.IMenuManager iMenuManager) {
        this.mContainerPresenter = iContainerPresenter;
        this.mCompViewPresenter = composerViewPresenter;
        this.mControllerManager = controllerManager;
        this.mSearchController = controllerManager.getSearchController();
        this.mSoftInputManager = controllerManager.getSoftInputManager();
        composerViewPresenter.getNoteManager().addBackgroundColorObserver(this);
        PageListDataManager pageListDataManager = new PageListDataManager(new PageListDataManager.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.a
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListDataManager.Contract
            public final PageListContract.IView getView() {
                return this.f7002a.lambda$new$0();
            }
        }, controllerManager.getTaskController());
        this.mPageListDataManager = pageListDataManager;
        this.mDialogPresenterManager = dialogPresenterManager;
        this.mIsBookmarkMenuEnabled = composerViewPresenter.getComponentFactory().getConfig().isBookmarkMenuEnabled();
        OnKeyListenerImpl onKeyListenerImpl = new OnKeyListenerImpl();
        this.mOnKeyListener = onKeyListenerImpl;
        this.mPageHolderPresenter = new PageListHolderPresenter(iContainerPresenter, composerViewPresenter, controllerManager, pageListDataManager, onKeyListenerImpl, new PageListHolderPresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListHolderPresenter.Contract
            public PageListContract.IView getView() {
                return PageListPresenter.this.mView;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListHolderPresenter.Contract
            public void hideStickyMemo() {
                iMenuManager.hideStickyMemo("9");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListHolderPresenter.Contract
            public void setEditMode(int i) {
                PageListPresenter.this.setEditMode(i, false);
            }
        });
        this.mMenuManager = iMenuManager;
    }

    private void connectModel(PageManager pageManager, ComposerModel composerModel) {
        this.mPageListDataManager.setPageManager(pageManager);
        this.mPageHolderPresenter.setComposerModel(composerModel);
        this.mComposerModel = composerModel;
        composerModel.getModeManager().addObserver(new Observer() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListPresenter.2
            @Override // java.util.Observer
            public void update(Observable observable, Object obj) {
                if (obj instanceof ModeManager.SubMode) {
                    PageListPresenter.this.updateSubModeState();
                } else {
                    PageListPresenter.this.onComposerModeChanged();
                }
            }
        });
        this.mPageListDataManager.setBookmarkModel(this.mComposerModel.getBookmarkModel());
    }

    @NonNull
    private PageListEditModeMenuPresenter.Contract getPageListEditModeMenuPresenterContract() {
        return new PageListEditModeMenuPresenter.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListPresenter.4
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter.Contract
            public PageListContract.IView getView() {
                return PageListPresenter.this.mView;
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter.Contract
            public void hideStickyMemo() {
                PageListPresenter.this.mMenuManager.hideStickyMemo("9");
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter.Contract
            public boolean isMode(int i) {
                return PageListPresenter.this.mPageListDataManager.isMode(i);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter.Contract
            public void setBlockThumbnailUpdate(boolean z) {
                PageListPresenter.this.setBlockThumbnailUpdate(z);
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListEditModeMenuPresenter.Contract
            public void setMode(int i) {
                PageListPresenter.this.setMode(i);
            }
        };
    }

    private SaveInstancesHelper getSaveInstancesHelper(Context context) {
        if (this.mSaveInstancesHelper == null) {
            this.mSaveInstancesHelper = new SaveInstancesHelper(context);
        }
        return this.mSaveInstancesHelper;
    }

    private void initMenu(OptionMenuPresenter optionMenuPresenter) {
        this.mPageListSearch = new PageListSearch(this.mSearchController);
        PageListComposerModeHelper pageListComposerModeHelper = new PageListComposerModeHelper(this.mComposerModel, this.mCompViewPresenter, this.mSoftInputManager);
        this.mComposerModeHelper = pageListComposerModeHelper;
        this.mPageHolderPresenter.initMenu(pageListComposerModeHelper, optionMenuPresenter);
        this.mEditModeMenuPresenter = new PageListEditModeMenuPresenter(getPageListEditModeMenuPresenterContract(), this.mPageListDataManager, this.mComposerModel, this.mCompViewPresenter, this.mControllerManager.getTaskController(), this.mComposerModeHelper, optionMenuPresenter);
        this.mThumbnailHelper = new PageListThumbnailHelper(new PageListThumbnailHelper.Contract() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListPresenter.3
            @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListThumbnailHelper.Contract
            public int getSpanCount() {
                return PageListPresenter.this.mView.getSpanCount();
            }
        }, this.mPageListDataManager, this.mCompViewPresenter);
    }

    private void initSearch(Context context) {
        if (TextUtils.isEmpty(this.mPageListSearch.getCachePath())) {
            this.mPageListSearch.setCachePath(context, this.mComposerModel.getDocState().getUuid());
        }
        this.mPageListSearch.init(context, this.mPageListDataManager.getPageIdList(), this.mView, this.mCompViewPresenter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ PageListContract.IView lambda$new$0() {
        return this.mView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onComposerModeChanged() {
        if (this.mView == null) {
            return;
        }
        boolean z = this.mComposerModel.isTabletLayout() && this.mComposerModel.getModeManager().isComposerViewMode();
        boolean z2 = this.mComposerModel.isTabletLayout() && this.mComposerModel.getModeManager().isEditModeWithReadOnly();
        if (z) {
            if (this.mView.isShowing()) {
                if (this.mPageListDataManager.isMode(1)) {
                    setMode(0);
                } else if (this.mPageListDataManager.isMode(2)) {
                    this.mView.hideSearchMode(false);
                    this.mCompViewPresenter.requestFocus();
                }
            }
            this.mView.updateSearchButtonVisibility(false);
            return;
        }
        if (!z2) {
            this.mView.updateSearchButtonVisibility(true);
            return;
        }
        if (this.mView.isShowing() && this.mPageListDataManager.isMode(1)) {
            setMode(0);
        }
        this.mView.updateSearchButtonVisibility(true);
    }

    private void prepareModeToShow() {
        this.mPageListDataManager.resetData();
        setMode(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateSubModeState() {
        PageListContract.IView iView = this.mView;
        if (iView == null) {
            return;
        }
        iView.setDisableAddPage(this.mComposerModel.getModeManager().isDeleteOnlyMode() || getComponentFactory().getConfig().isOnlyDeletableInPageList());
    }

    public boolean canMultiSelection() {
        return isEditable() && (this.mPageListDataManager.isMode(0) || this.mPageListDataManager.isMode(1));
    }

    public boolean canSearch() {
        OptionMenuPresenter optionMenuPresenter = this.mOptionMenuPresenter;
        if (optionMenuPresenter == null || !optionMenuPresenter.isTranslationOverlayActivated()) {
            return true;
        }
        this.mCompViewPresenter.getDialogPresenterManager().showTranslatedPDFBlockingDialog();
        return false;
    }

    public void clearPageIdList() {
        this.mPageListDataManager.getPageIdList().clear();
    }

    public ComposerViewPresenter.ComponentFactory getComponentFactory() {
        return this.mCompViewPresenter.getComponentFactory();
    }

    public int getDataIndex(String str) {
        return this.mPageListDataManager.getPageIndex(str);
    }

    public PageDragListenerImpl getDragListener() {
        return this.mDragListener;
    }

    public PageListEditModeMenuPresenter getEditModeMenuPresenter() {
        return this.mEditModeMenuPresenter;
    }

    public PageListHolderPresenter getPageHolderPresenter() {
        return this.mPageHolderPresenter;
    }

    public PageListSearch getSearchPresenter() {
        return this.mPageListSearch;
    }

    public boolean hasBookmarkedPage() {
        return this.mPageListDataManager.getBookmarkModel().hasBookmarkedPage();
    }

    public boolean hasUnknownObject() {
        return this.mComposerModel.getComposerSpenDocModel().hasUnknownObject();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IPresenter
    public void hide() {
        if (this.mView == null) {
            return;
        }
        Logger.m10999d(TAG, "hide#");
        PageDragListenerImpl pageDragListenerImpl = this.mDragListener;
        if (pageDragListenerImpl != null) {
            pageDragListenerImpl.setEnable(false);
        }
        this.mView.hide();
        this.mPageHolderPresenter.getMoreMenuPresenter().clearBodyTextContext();
        this.mCompViewPresenter.setFocusable(true);
        if (this.mComposerModel.getModeManager().isMode(Mode.Writing) && this.mIsShownWithPhoneLayout) {
            NavigationBarUtil.hideNavigationBar(this.mCompViewPresenter.getActivity());
        }
        this.mIsShownWithPhoneLayout = false;
        this.mCompViewPresenter.requestFocus();
        this.mCompViewPresenter.getListenerManager().removeKeyListener(this.mOnKeyListener);
    }

    public void hideMoreListPopup(String str) {
        this.mPageHolderPresenter.dismissMoreMenuPopup(str);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IPresenter
    public boolean hideSoftInput(View view) {
        PageListContract.IView iView;
        Logger.m10999d(TAG, "hideSoftInput, targetView = " + view);
        if (view == null && (iView = this.mView) != null) {
            view = iView.getKeyboardTargetView();
        }
        if (view == null || !this.mSoftInputManager.isInputMethodShown()) {
            return false;
        }
        this.mSoftInputManager.hide(view);
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IPresenter
    public void ignoreInputEvent(boolean z) {
        PageListContract.IView iView = this.mView;
        if (iView != null) {
            iView.ignoreInputEvent(z);
        }
    }

    public void init(PageManager pageManager, ComposerModel composerModel, OptionMenuPresenter optionMenuPresenter) {
        this.mOptionMenuPresenter = optionMenuPresenter;
        connectModel(pageManager, composerModel);
        initMenu(optionMenuPresenter);
    }

    public void initView() {
        PageListContract.IView iView = this.mView;
        if (iView != null) {
            iView.init();
        }
    }

    public boolean isBookmarked(String str) {
        return this.mPageListDataManager.isBookmarked(str);
    }

    public boolean isChecked(String str) {
        return this.mPageListDataManager.getPageListMode().isChecked(str);
    }

    public boolean isEditable() {
        return this.mComposerModel.isEditable() && this.mComposerModel.getMdeInfo().hasWritePermission();
    }

    public boolean isEnabledBookmark() {
        return this.mIsBookmarkMenuEnabled && !this.mComposerModel.getMdeInfo().isMde();
    }

    public boolean isItemMoreEnable() {
        return isEditable();
    }

    public boolean isLandscapePage() {
        return this.mCompViewPresenter.getNoteManager().isLandscapePage();
    }

    public boolean isRestored() {
        return this.mIsRestored;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IPresenter
    public boolean isShowing() {
        PageListContract.IView iView = this.mView;
        return iView != null && iView.isShowing();
    }

    public boolean isShownWithPhoneLayout() {
        return this.mIsShownWithPhoneLayout;
    }

    public void minimizeSoftInput(View view) {
        this.mSoftInputManager.minimizeSoftInput(view);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageDragListenerImpl.IPresenter
    public void move(String str, String str2) {
        String str3 = TAG;
        Logger.m10999d(str3, "move# fromId / toId " + str + " / " + str2);
        int pageIndex = this.mPageListDataManager.getPageIndex(str2);
        VoiceAssistantTTS.getInstance().sendTalkBackMessage(this.mView.getView().getContext().getResources().getString(C9086R.string.base_drag_drop_at, Integer.valueOf(pageIndex + 1)));
        if (!str.equals(str2) && !TextUtils.isEmpty(str2)) {
            Logger.addFileLog(str3, "PageMove", 0);
            int iReleaseReadMode = this.mComposerModeHelper.releaseReadMode(SecureFolderConstants.TEMP_FOLDER_NAME);
            int pageIndex2 = this.mPageListDataManager.getPageIndex(str);
            this.mCompViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(false);
            this.mCompViewPresenter.getNoteManager().movePage(pageIndex2, pageIndex);
            this.mCompViewPresenter.getComposerControllerManager().getScrollController().goToPage(pageIndex);
            this.mComposerModeHelper.setCursorAfterEditModeChange(iReleaseReadMode, pageIndex);
            this.mCompViewPresenter.getTextManager().setAutoScrollToCursorOnLayoutChanged(true);
        }
        if (this.mView.getAdapter() != null) {
            this.mView.getAdapter().disableAnimation();
            this.mView.getAdapter().notifyDataSetChangedWithNoAnimation();
        }
    }

    public void onActivityResult(int i, Intent intent) {
        this.mPageHolderPresenter.getMoreMenuPresenter().onActivityResult(i, intent);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IPresenter
    public boolean onBackPressed() {
        Logger.m10999d(TAG, "onBackPressed");
        if (isShowing()) {
            if (this.mView.onBackPressed() || this.mPageHolderPresenter.dismissMoreMenuPopup()) {
                return true;
            }
            if (this.mComposerModel.isTabletLayout() && this.mCompViewPresenter.onBackPressed()) {
                return true;
            }
            if (!this.mPageListDataManager.isMode(0)) {
                setMode(0);
                return true;
            }
        }
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
    public void onChangedBackgroundColor(int i, boolean z, boolean z2) {
        if (isShowing()) {
            this.mView.setPageBackgroundColor(BackgroundColorUtil.getBackgroundThemeColor(this.mCompViewPresenter.getActivity(), i, z, z2));
        }
    }

    public void onClose() {
        this.mPageListDataManager.insertSALogWithMode(SortPageSAConstants.SORTPAGE_EVENT_CLOSE);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IPresenter
    public void onConfigurationChanged(Configuration configuration) {
        if (this.mOrientation != configuration.orientation) {
            this.mPageHolderPresenter.onConfigurationChanged();
            PageListEditModeMenuPresenter pageListEditModeMenuPresenter = this.mEditModeMenuPresenter;
            if (pageListEditModeMenuPresenter != null) {
                pageListEditModeMenuPresenter.onConfigurationChanged();
            }
        }
        this.mOrientation = configuration.orientation;
        PageListContract.IView iView = this.mView;
        if (iView != null) {
            iView.onConfigurationChanged(configuration);
        }
    }

    public void onDestroy() {
        SearchController searchController = this.mSearchController;
        if (searchController != null) {
            searchController.cancel();
        }
        this.mPageHolderPresenter.onDestroy();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IPresenter
    public void onDetachView() {
        this.mSearchController.cancel();
        this.mPageHolderPresenter.onDetachView();
        PageListEditModeMenuPresenter pageListEditModeMenuPresenter = this.mEditModeMenuPresenter;
        if (pageListEditModeMenuPresenter != null) {
            pageListEditModeMenuPresenter.onDetachView();
        }
        if (this.mDialogPresenterManager.getQuickNoteDialogPresenter() != null) {
            this.mDialogPresenterManager.getQuickNoteDialogPresenter().blockToShow(false);
        }
        this.mPageListDataManager.release();
        this.mView = null;
    }

    public void onEditClicked(int i) {
        if (this.mComposerModeHelper.checkNoServerPermission()) {
            return;
        }
        hideSoftInput(this.mView.getKeyboardTargetView());
        setEditMode(i, false);
        if (this.mComposerModel.isTabletLayout()) {
            ComposerSA.insertLog("403", SortPageSAConstants.EVENT_TABLET_PAGE_EDIT);
        } else {
            ComposerSA.insertLog("504", SortPageSAConstants.SORTPAGE_EVENT_EDIT_MODE);
        }
    }

    public void onFocusChanged(View view, boolean z) {
        if (!z && (!this.mComposerModel.getModeManager().isMode(Mode.Text) || this.mCompViewPresenter.getObjectManager().getSelectedObjectList().isEmpty())) {
            hideSoftInput(view);
        } else if (z) {
            this.mSoftInputManager.blockToHide(true);
        }
        this.mCompViewPresenter.getTextManager().setCursorBlink(!z);
        if (z) {
            this.mSoftInputManager.blockToHide(false);
        }
    }

    public void onHide() {
        this.mPageHolderPresenter.onHide();
        this.mPageListSearch.release();
        this.mThumbnailHelper.clearDisplayList();
        this.mDialogPresenterManager.getQuickNoteDialogPresenter().blockToShow(false);
    }

    public void onHideSearch() {
        Logger.m10999d(TAG, "onHideSearch#");
        setMode(0);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IPresenter
    public boolean onKeyEvent(int i) {
        if (!isShowing()) {
            return false;
        }
        if (this.mComposerModel.isTabletLayout()) {
            return !this.mPageListDataManager.isMode(2) && this.mView.onRequestSearchMode();
        }
        if (!this.mPageListDataManager.isMode(2)) {
            this.mView.onRequestSearchMode();
        }
        return true;
    }

    public void onPageIndexChanged(View view, int i) {
        AbstractC0000a.m3D(i, "onPageIndexChanged# ", TAG);
        this.mCompViewPresenter.getObjectManager().clearSelectObject();
        this.mCompViewPresenter.getComposerControllerManager().getScrollController().goToPage(i);
        if (!this.mComposerModel.isTabletLayout()) {
            this.mContainerPresenter.hide(false);
        }
        this.mSoftInputManager.hide(view);
        view.clearFocus();
    }

    public void onPenMultiSelection(int i) {
        if (this.mPageListDataManager.isMode(1)) {
            ((PageListModeEdit) this.mPageListDataManager.getPageListMode()).reverseSelection(this.mPageListDataManager.getPageIdList(), this.mView, i);
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        if (isShowing()) {
            PageListState pageListStateSaveState = this.mPageListDataManager.getPageListMode().saveState(this.mPageListDataManager.getPageIdList(), this.mView);
            this.mEditModeMenuPresenter.saveState(pageListStateSaveState);
            getSaveInstancesHelper(this.mView.getView().getContext()).save(bundle, pageListStateSaveState, KEY);
        }
    }

    public void onShowSearch() {
        Logger.m10999d(TAG, "onShowSearch#");
        setMode(2);
    }

    public void onVisibleItemChanged(int i, int i2) {
        this.mThumbnailHelper.updateDisplayList(i, i2);
    }

    public boolean onWindowFocusChanged(boolean z) {
        if (!z || !isShowing()) {
            return false;
        }
        if (this.mComposerModel.isTabletLayout()) {
            return this.mPageListDataManager.isMode(2) && this.mView.hasSearchFieldFocus();
        }
        if (!this.mPageListDataManager.isMode(2)) {
            this.mCompViewPresenter.getView().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListPresenter.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!PageListPresenter.this.isShowing() || PageListPresenter.this.mPageListDataManager.isMode(2)) {
                        return;
                    }
                    PageListPresenter.this.mSoftInputManager.hide(PageListPresenter.this.mCompViewPresenter.getView());
                }
            }, 200L);
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IPresenter
    public void release() {
    }

    public void requestMakeThumbnail(int i) {
        this.mThumbnailHelper.updateThumbnail(i);
    }

    public void restoreState(Activity activity, Bundle bundle) {
        PageListState pageListState = (PageListState) getSaveInstancesHelper(activity).restore(bundle, KEY, PageListState.CREATOR);
        if (pageListState == null) {
            return;
        }
        this.mIsRestored = true;
        String str = TAG;
        Logger.m10999d(str, "restoreState");
        if (!this.mPageListDataManager.isPrepared()) {
            Logger.m10999d(str, "restoreState#, fail to restore PageList");
            return;
        }
        if (this.mCompViewPresenter.isOverlappingWithFragment()) {
            this.mContainerPresenter.hide(true);
            Logger.m10999d(str, "isOverlappingWithFragment true");
            return;
        }
        this.mContainerPresenter.show(true);
        setMode(pageListState.getMode());
        this.mPageListDataManager.getPageListMode().restore(pageListState, this.mView, this.mCompViewPresenter);
        if (this.mComposerModel.isTabletLayout()) {
            return;
        }
        this.mCompViewPresenter.getObjectManager().clearSelection();
    }

    public void restoreUIResource() {
        if (isShowing()) {
            this.mView.getAdapter().notifyDataSetChanged();
        }
    }

    public void setBlockThumbnailUpdate(boolean z) {
        this.mThumbnailHelper.setBlockThumbnailUpdate(z);
    }

    public void setEditMode(int i, boolean z) {
        this.mIsRestored = z;
        this.mComposerModeHelper.setLastToolType(i);
        setMode(1);
    }

    public void setLockContentView(boolean z, @Nullable View view) {
        this.mSoftInputManager.setLockViewEnabled(z, view);
    }

    public void setMode(int i) {
        int mode;
        String str = TAG;
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "setMode, request: ", ", current: ");
        sbM778t.append(this.mPageListDataManager.getPageListMode());
        Logger.m10999d(str, sbM778t.toString());
        boolean z = false;
        if (this.mPageListDataManager.getPageListMode() == null) {
            mode = 0;
        } else {
            if (this.mPageListDataManager.getPageListMode().getMode() == i) {
                return;
            }
            this.mPageListDataManager.getPageListMode().clear(this.mPageListDataManager.getPageIdList(), this.mView);
            mode = this.mPageListDataManager.getPageListMode().getMode();
        }
        this.mPageHolderPresenter.clearIsStartedEditModeByShift();
        if (i == 1) {
            this.mComposerModeHelper.releaseReadMode("prepareEditMode");
            this.mPageListDataManager.setPageListMode(new PageListModeEdit(this.mPageListDataManager.getPageManager()));
            this.mEditModeMenuPresenter.setMode((PageListModeEdit) this.mPageListDataManager.getPageListMode());
        } else if (i == 2) {
            this.mPageListDataManager.setPageListMode(new PageListModeSearch(this.mPageListDataManager.getPageManager(), this.mCompViewPresenter, this.mSoftInputManager, this.mPageListSearch));
            this.mComposerModel.saveCacheAndRequestCollect();
        } else if (i != 3) {
            this.mPageListDataManager.setPageListMode(new PageListMode(this.mPageListDataManager.getPageManager()));
        } else {
            this.mPageListDataManager.setPageListMode(new PageListModeBookmark(this.mPageListDataManager.getPageManager(), this.mPageListDataManager.getBookmarkModel()));
        }
        this.mPageListDataManager.getPageListMode().init(this.mPageListDataManager.getPageIdList());
        this.mThumbnailHelper.initUpdateDisplayList();
        this.mView.onModeChanged(mode, i);
        if (this.mView.getAdapter() != null) {
            this.mView.getAdapter().enableAnimation();
            this.mView.getAdapter().notifyDataSetChanged();
        }
        this.mView.onModeChangedPost(mode, i);
        PageDragListenerImpl pageDragListenerImpl = this.mDragListener;
        if (pageDragListenerImpl != null) {
            if (i == 0 && !getComponentFactory().getConfig().isOnlyDeletableInPageList()) {
                z = true;
            }
            pageDragListenerImpl.setEnable(z);
        }
    }

    public void setView(PageListContract.IView iView, int i) {
        this.mView = iView;
        this.mOrientation = i;
        PageDragListenerImpl pageDragListenerImpl = new PageDragListenerImpl(this);
        this.mDragListener = pageDragListenerImpl;
        this.mPageHolderPresenter.setDragListener(pageDragListenerImpl);
        initView();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.common.IBaseListContract.IPresenter
    public void show(Activity activity) {
        this.mPageListDataManager.getPageManager().initPageInfoList(this.mComposerModel.getDoc());
        this.mSoftInputManager.hide((View) null);
        int currentPageIndex = this.mPageListDataManager.getPageManager().getDocPageInfo().getCurrentPageIndex();
        String str = TAG;
        AbstractC0000a.m3D(currentPageIndex, "show# ", str);
        prepareModeToShow();
        this.mEditModeMenuPresenter.setPageIdList(this.mPageListDataManager.getPageIdList());
        onComposerModeChanged();
        this.mThumbnailHelper.initUpdateDisplayList();
        int backgroundThemeColor = this.mCompViewPresenter.getBackgroundThemeColor();
        PageListContract.IView iView = this.mView;
        PageListDataManager pageListDataManager = this.mPageListDataManager;
        iView.initAdapter(pageListDataManager, pageListDataManager.adjustCurrentPageIndex(currentPageIndex), backgroundThemeColor);
        this.mView.show();
        if (this.mComposerModel.isTabletLayout()) {
            this.mIsShownWithPhoneLayout = false;
        } else {
            this.mIsShownWithPhoneLayout = true;
            this.mCompViewPresenter.setFocusable(false);
            NavigationBarUtil.clearHideNavigationBarFlag(activity);
            this.mDialogPresenterManager.getQuickNoteDialogPresenter().blockToShow(true);
        }
        this.mPageHolderPresenter.getMoreMenuPresenter().initBodyTextContext(activity);
        initSearch(activity);
        if (this.mComposerModel.getModeManager().isDeleteOnlyMode() || getComponentFactory().getConfig().isOnlyDeletableInPageList()) {
            this.mView.setDisableAddPage(true);
        }
        PageDragListenerImpl pageDragListenerImpl = this.mDragListener;
        if (pageDragListenerImpl != null) {
            pageDragListenerImpl.setEnable(!getComponentFactory().getConfig().isOnlyDeletableInPageList());
        }
        Logger.m10999d(str, "show# isSplitView " + this.mComposerModel.isTabletLayout());
        this.mCompViewPresenter.getListenerManager().addKeyListener(this.mOnKeyListener);
    }

    public void showSoftInput(View view) {
        this.mSoftInputManager.show(view);
    }

    public void trimUIResource() {
        if (isShowing()) {
            this.mView.clearThumbnail();
        }
    }

    public void trimUnnecessaryResource() {
        if (isShowing()) {
            this.mView.clearRecyclerViewPool();
        }
    }

    public void updateSearchButtonVisibility(boolean z) {
        if (this.mView == null) {
            return;
        }
        if (this.mComposerModel.isTabletLayout() && this.mComposerModel.getModeManager().isComposerViewMode()) {
            this.mView.updateSearchButtonVisibility(false);
            return;
        }
        this.mView.updateSearchButtonVisibility(true);
        if (this.mView.isShowing() && this.mPageListDataManager.isMode(2) && z) {
            this.mView.hideSearchMode(false);
        }
    }
}
