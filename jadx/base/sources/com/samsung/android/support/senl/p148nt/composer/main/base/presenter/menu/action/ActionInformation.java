package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.winset.builder.AlertDialogBuilderForAppCompat;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import com.samsung.android.support.senl.p148nt.model.documents.data.StorageInfo;
import com.samsung.android.support.senl.p148nt.model.documents.spen.SpenWordDocument;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class ActionInformation extends AbsAction {
    private static final boolean FEATURE_ENABLED = false;
    private static final String TAG = Logger.createTag("ActionInformation");
    private final ComposerModel mComposerModel;
    private final ComposerViewPresenter mComposerViewPresenter;

    public ActionInformation(ComposerViewPresenter composerViewPresenter) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerViewPresenter.getComposerModel();
    }

    public static boolean isFeatureEnabled() {
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean doAction(String str) {
        AbstractC8014b.m7196B("doAction# task is running / ", str, TAG);
        if (this.mComposerModel.getModeManager().isMode(Mode.View) || this.mComposerModel.getComposerSaveModel().isAutoSaveOptionEnabled() || !this.mComposerModel.isChangedDocStateWithSnapSavedData()) {
            this.mComposerModel.saveCache(true, 0);
        }
        StorageInfo storageSize = ((SpenWordDocument) this.mComposerModel.getDocState().getDoc()).getStorageSize();
        new AlertDialogBuilderForAppCompat(this.mComposerViewPresenter.getActivity()).setTitle(CoverStickerConstants.Category.INFORMATION.NAME).setMessage("Size = " + storageSize.getValue() + " " + storageSize.getUnit()).create().show();
        return false;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.action.AbsAction
    public boolean isSupported() {
        return isFeatureEnabled();
    }
}
