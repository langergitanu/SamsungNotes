package com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.presenter.menu.option;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.dialog.DialogPresenterManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.common.MenuPresenterContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.contextmenu.RunnableC9767a;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuBackPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.CommonUtil;
import com.samsung.android.support.senl.p148nt.composer.main.pdfwriter.model.PwComposerModel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class PwOptionMenuBackPresenter extends OptionMenuBackPresenter {
    private final Runnable mViewModeRunnable;

    public PwOptionMenuBackPresenter(ControllerManager controllerManager, ComposerViewPresenter composerViewPresenter, ComposerModel composerModel, DialogPresenterManager dialogPresenterManager, MenuPresenterContract.IMenuManager iMenuManager) {
        super(controllerManager, composerViewPresenter, composerModel, dialogPresenterManager, iMenuManager);
        this.mViewModeRunnable = new RunnableC9767a(this, 21);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        ((PwComposerModel) this.mComposerModel).deleteCacheInfo();
        this.mComposerModel.getModeManager().setMode(Mode.View, "goBackComposer#", true);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuBackPresenter
    public boolean goBackComposer(Activity activity, @NonNull @OptionMenuBackPresenter.Caller String str) {
        boolean zEquals = OptionMenuBackPresenter.Caller.BACK_KEY.equals(str);
        if (zEquals && canSkipBackPressed()) {
            return true;
        }
        clearCurrentState();
        if (this.mComposerModel.getModeManager().isMode(Mode.View)) {
            finishComposer(activity, zEquals, getScenario(zEquals));
            ((PwComposerModel) this.mComposerModel).trimCacheInfo();
            return true;
        }
        if (((PwComposerModel) this.mComposerModel).isChangedDocStateWithSnapSavedDataAndDirty()) {
            showSaveNoteConfirmDialog(this.mViewModeRunnable);
        } else {
            this.mViewModeRunnable.run();
        }
        return true;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.OptionMenuBackPresenter
    public boolean needFinishActivity(Activity activity, boolean z) {
        if (z) {
            return true;
        }
        boolean zIsTaskRoot = activity.isTaskRoot();
        boolean zIsLockTaskMode = CommonUtil.isLockTaskMode(activity);
        if (!zIsTaskRoot || !zIsLockTaskMode) {
            return true;
        }
        activity.showLockTaskEscapeMessage();
        return false;
    }
}
