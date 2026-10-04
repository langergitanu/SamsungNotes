package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.toolbar.hwtoolbar;

import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.common.presenter.keyguard.KeyguardPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwHwToolbarPresenter extends HwToolbarPresenter {
    public PwHwToolbarPresenter(@NonNull MenuPresenterContract.IMenuManager iMenuManager, @NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager, @NonNull DialogPresenterManager dialogPresenterManager, @NonNull KeyguardPresenter keyguardPresenter) {
        super(iMenuManager, composerViewPresenter, controllerManager, dialogPresenterManager, keyguardPresenter);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public void changeTextMode() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean isTextButtonEnabled() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter, com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenterImpl
    public boolean onPreClick(int i) {
        this.mObjectManager.clearSelection();
        return false;
    }
}
