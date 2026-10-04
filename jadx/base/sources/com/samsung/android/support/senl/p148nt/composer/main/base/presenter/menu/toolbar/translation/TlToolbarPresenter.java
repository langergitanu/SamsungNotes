package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.translation;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.toolbar.translation.TlToolbarContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TlToolbarPresenter implements ComposerViewContract.TlToolbarContract {
    public static final String TAG = "TlToolbarPresenter";
    private final ComposerModel mComposerModel;

    @Nullable
    private TlToolbarContract.IView mView;

    public TlToolbarPresenter(@NonNull ComposerViewPresenter composerViewPresenter, @NonNull ControllerManager controllerManager, @NonNull DialogPresenterManager dialogPresenterManager) {
        Logger.m10999d(TAG, "TlToolbarPresenter#");
        this.mComposerModel = composerViewPresenter.getComposerModel();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.TlToolbarContract
    public void addPendingActionAfterInflate(Runnable runnable) {
        TlToolbarContract.IView iView = this.mView;
        if (iView == null) {
            Logger.m10999d(TAG, "addPendingActionAfterInflate# Ignored by invalid status.");
        } else {
            iView.addPendingActionAfterInflate(runnable);
        }
    }

    public ComposerModel getComposerModel() {
        return this.mComposerModel;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.TlToolbarContract
    public View getContainer() {
        if (this.mView == null) {
            return null;
        }
        Logger.m10999d(TAG, "getContainer#");
        return this.mView.getContainer();
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.TlToolbarContract
    public boolean isInflated() {
        TlToolbarContract.IView iView = this.mView;
        if (iView != null) {
            return iView.isInflated();
        }
        Logger.m10999d(TAG, "isInflated# false by invalid status.");
        return false;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.TlToolbarContract
    public boolean isTranslated() {
        return this.mComposerModel.getComposerState().isTranslated();
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        TlToolbarContract.IView iView;
        if (this.mComposerModel.getModeManager().isEditMode() && (iView = this.mView) != null) {
            iView.onSaveInstanceState(bundle);
        }
    }

    public void restoreState(Bundle bundle) {
        TlToolbarContract.IView iView;
        if (this.mComposerModel.getModeManager().isEditMode() && (iView = this.mView) != null) {
            iView.restore(bundle);
        }
    }

    public void setView(TlToolbarContract.IView iView) {
        Logger.m10999d(TAG, "setView#");
        this.mView = iView;
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.ComposerViewContract.TlToolbarContract
    public void show() {
        if (this.mView == null) {
            Logger.m10999d(TAG, "show# Ignored by invalid status.");
        } else {
            Logger.m10999d(TAG, "show#");
            this.mView.show();
        }
    }
}
