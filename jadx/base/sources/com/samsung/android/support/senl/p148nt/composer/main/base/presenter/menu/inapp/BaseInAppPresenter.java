package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.inapp;

import android.app.Activity;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.ToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.hwtoolbar.HwToolbarPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.quicktool.QuickToolPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.richtext.RtToolbarPresenter;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class BaseInAppPresenter implements ComposerViewContract.InAppContract {
    private void clearInAppMode(@Nullable Bundle bundle) {
        ComposerState composerState;
        if (bundle == null || (composerState = (ComposerState) bundle.getParcelable(ComposerState.KEY_STATE)) == null) {
            return;
        }
        composerState.setIsInAppCollaborationMode(false);
    }

    public void connect() {
    }

    public void disconnect() {
    }

    public void init(ComposerViewPresenter composerViewPresenter, OptionMenuPresenter optionMenuPresenter, HwToolbarPresenter hwToolbarPresenter, RtToolbarPresenter rtToolbarPresenter, ToolbarPresenter toolbarPresenter, ControllerManager controllerManager, QuickToolPresenter quickToolPresenter) {
    }

    public boolean isEnabledInAppCollaboration() {
        return false;
    }

    public boolean isRestrictedInAppCollaboration() {
        return !DeviceInfo.isVSTModel();
    }

    public void onActivityCreated(@NonNull Activity activity, @NonNull Fragment fragment, @Nullable Bundle bundle) {
        clearInAppMode(bundle);
    }

    public void onAttachView(Activity activity) {
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onDestroy() {
    }

    public void onDetachView() {
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.InAppContract
    public void onInAppCollaborationCloseButtonClicked() {
    }

    public void onPause() {
    }

    public void onResume() {
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
    }

    public void onWindowModeChanged(int i) {
    }

    public void setIsInAppCollaborationMode(boolean z) {
    }

    public void startInAppCollaboration(String str) {
    }
}
