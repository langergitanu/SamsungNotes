package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.TemplateEditorModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.template.editor.image.FileOperationTask;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.IContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.TEAdjustPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.template.editor.adjust.zoom.TEZoomPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.ChangeTemplateConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TemplateEditorPresenter {
    private static final String TAG = "TemplateEditorPresenter";
    private TEAdjustPresenter mAdjustPresenter;
    private TemplateEditorModel mModel;
    private IContract.IView mView;
    private TEZoomPresenter mZoomPresenter;

    public TemplateEditorPresenter(IContract.IView iView, TemplateEditorModel templateEditorModel) {
        this.mView = iView;
        this.mModel = templateEditorModel;
        templateEditorModel.getImageModel().setCallback(new FileOperationTask.ICallback() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.menu.template.editor.TemplateEditorPresenter.1
            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.template.editor.image.FileOperationTask.ICallback
            public void onEnd(boolean z) {
                if (TemplateEditorPresenter.this.mView != null) {
                    TemplateEditorPresenter.this.mView.finish(z);
                }
            }

            @Override // com.samsung.android.support.senl.nt.composer.main.base.model.menu.template.editor.image.FileOperationTask.ICallback
            public void onStarted() {
                if (TemplateEditorPresenter.this.mView != null) {
                    TemplateEditorPresenter.this.mView.showProgressDialog();
                }
            }
        });
        this.mAdjustPresenter = new TEAdjustPresenter(templateEditorModel.getAdjustModel());
        this.mZoomPresenter = new TEZoomPresenter(templateEditorModel.getAdjustModel().getZoomModel());
    }

    public void close() {
        this.mView = null;
        this.mAdjustPresenter.close();
        this.mAdjustPresenter = null;
        this.mZoomPresenter.close();
        this.mZoomPresenter = null;
        this.mModel.deleteObservers();
        this.mModel.close();
        this.mModel = null;
    }

    public TEAdjustPresenter getAdjustPresenter() {
        return this.mAdjustPresenter;
    }

    public TemplateEditorModel getModel() {
        return this.mModel;
    }

    public TEZoomPresenter getZoomPresenter() {
        return this.mZoomPresenter;
    }

    public void onRestoreInstanceState(@NonNull Bundle bundle) {
        Logger.m11003i(TAG, "onRestoreInstanceState#");
        this.mModel.getAdjustModel().storeEditState(bundle.getFloat(ChangeTemplateConstants.KEY_TE_DELTA_SCALE), bundle.getInt(ChangeTemplateConstants.KEY_TE_OPACITY), bundle.getFloat(ChangeTemplateConstants.KEY_TE_IMG_X_TRANS_RATIO), bundle.getFloat(ChangeTemplateConstants.KEY_TE_IMG_Y_TRANS_RATIO));
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        Logger.m11003i(TAG, "onSaveInstanceState#");
        bundle.putFloat(ChangeTemplateConstants.KEY_TE_DELTA_SCALE, this.mModel.getAdjustModel().calculateDeltaScale());
        bundle.putInt(ChangeTemplateConstants.KEY_TE_OPACITY, this.mModel.getAdjustModel().getOpacity());
        bundle.putFloat(ChangeTemplateConstants.KEY_TE_IMG_X_TRANS_RATIO, this.mModel.getAdjustModel().calculateImageXTransRatio());
        bundle.putFloat(ChangeTemplateConstants.KEY_TE_IMG_Y_TRANS_RATIO, this.mModel.getAdjustModel().calculateImageYTransRatio());
    }

    public void storeData() {
        this.mModel.getAdjustModel().storeEditState();
    }
}
