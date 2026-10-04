package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.page.PageManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.common.IBaseListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.list.pages.PageListPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerRequestCode;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CompListPresenter implements PageListContract.IContainerPresenter {
    private static final String TAG = "CompListPresenter";
    private Activity mActivity;
    private ComposerModel mComposerModel;
    private boolean mIsClicked = false;
    MenuPresenterContract.IMenuManager mMenuManager;
    private final OptionMenuPresenter mOptionMenuPresenter;
    private final PageListPresenter mPageListPresenter;
    private final IBaseListContract.IPresenter mSubPresenter;
    private CompListContract mViewContract;

    public CompListPresenter(MenuPresenterContract.IMenuManager iMenuManager, ComposerViewPresenter composerViewPresenter, OptionMenuPresenter optionMenuPresenter, ControllerManager controllerManager, DialogPresenterManager dialogPresenterManager) {
        this.mMenuManager = iMenuManager;
        this.mOptionMenuPresenter = optionMenuPresenter;
        PageListPresenter pageListPresenter = new PageListPresenter(this, composerViewPresenter, controllerManager, dialogPresenterManager, iMenuManager);
        this.mPageListPresenter = pageListPresenter;
        this.mSubPresenter = pageListPresenter;
    }

    private void onPreShow() {
        this.mSubPresenter.ignoreInputEvent(false);
    }

    private void updateButtonStateOfPageList() {
        if (this.mComposerModel.isTabletLayout()) {
            this.mMenuManager.invalidateOptionsMenu();
        }
    }

    public PageListPresenter getPageListPresenter() {
        return this.mPageListPresenter;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IContainerPresenter
    public void hide(boolean z) {
        if (this.mViewContract == null) {
            return;
        }
        boolean zHideSoftInput = this.mSubPresenter.hideSoftInput(null);
        if (z) {
            this.mViewContract.hide(true);
        } else {
            new Handler().postDelayed(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.CompListPresenter.1
                @Override // java.lang.Runnable
                public void run() {
                    CompListPresenter.this.mViewContract.hide(false);
                }
            }, zHideSoftInput ? 200L : 0L);
        }
        this.mIsClicked = false;
        updateButtonStateOfPageList();
    }

    public void hideForActivityResult() {
        CompListContract compListContract = this.mViewContract;
        if (compListContract != null && compListContract.hideForActivityResult()) {
            this.mIsClicked = false;
        }
    }

    public void init(PageManager pageManager, ComposerModel composerModel) {
        this.mComposerModel = composerModel;
        this.mPageListPresenter.init(pageManager, composerModel, this.mOptionMenuPresenter);
    }

    public boolean isClicked() {
        return this.mIsClicked;
    }

    public boolean isShowing() {
        IBaseListContract.IPresenter iPresenter = this.mSubPresenter;
        return iPresenter != null && iPresenter.isShowing();
    }

    public boolean onActivityResult(int i, int i2, Intent intent) {
        if (i != ComposerRequestCode.AddPageTemplate.getId()) {
            return false;
        }
        this.mPageListPresenter.onActivityResult(i2, intent);
        return true;
    }

    public void onAttachView(Activity activity) {
        this.mActivity = activity;
    }

    public boolean onBackPressed() {
        if (this.mSubPresenter.onBackPressed()) {
            return true;
        }
        if (!this.mViewContract.isShown()) {
            return false;
        }
        hide(false);
        return true;
    }

    public void onClicked() {
        CompListContract compListContract = this.mViewContract;
        if (compListContract == null) {
            return;
        }
        if (compListContract.isShown()) {
            hide(false);
        } else {
            show(false);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        this.mSubPresenter.onConfigurationChanged(configuration);
    }

    public void onDestroy() {
        PageListPresenter pageListPresenter = this.mPageListPresenter;
        if (pageListPresenter != null) {
            pageListPresenter.onDestroy();
        }
    }

    public void onDetachView() {
        PageListPresenter pageListPresenter = this.mPageListPresenter;
        if (pageListPresenter != null) {
            pageListPresenter.onDetachView();
            this.mIsClicked = false;
        }
    }

    public boolean onKeyEvent(int i) {
        AbstractC0000a.m3D(i, "onKeyEvent, keyCode = ", TAG);
        return this.mSubPresenter.onKeyEvent(i);
    }

    public void onPostHide() {
        this.mSubPresenter.hide();
        this.mSubPresenter.release();
    }

    public void onPreHide() {
        this.mSubPresenter.ignoreInputEvent(true);
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        PageListPresenter pageListPresenter = this.mPageListPresenter;
        if (pageListPresenter != null) {
            pageListPresenter.onSaveInstanceState(bundle);
        }
    }

    public boolean onWindowFocusChanged(boolean z) {
        PageListPresenter pageListPresenter = this.mPageListPresenter;
        return pageListPresenter != null && pageListPresenter.onWindowFocusChanged(z);
    }

    public void restoreState(Activity activity, Bundle bundle) {
        PageListPresenter pageListPresenter = this.mPageListPresenter;
        if (pageListPresenter != null) {
            pageListPresenter.restoreState(activity, bundle);
        }
    }

    public void setView(CompListContract compListContract) {
        this.mViewContract = compListContract;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IContainerPresenter
    public void show(boolean z) {
        if (this.mViewContract == null) {
            return;
        }
        onPreShow();
        this.mSubPresenter.show(this.mActivity);
        this.mViewContract.show(z);
        this.mIsClicked = true;
        updateButtonStateOfPageList();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.list.pages.PageListContract.IContainerPresenter
    public void updateTemplateResult(Intent intent) {
        this.mOptionMenuPresenter.updateTemplateResult(intent);
    }
}
