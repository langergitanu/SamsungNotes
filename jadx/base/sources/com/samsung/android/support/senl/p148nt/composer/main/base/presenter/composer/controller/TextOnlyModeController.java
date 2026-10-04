package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.controller;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.sdk.pen.text.SpenTextScaleListener;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.common.TextOnlyModeState;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class TextOnlyModeController implements TextOnlyModeState.OnCanUseTextOnlyModeChangeListener {
    private ComposerModel mComposerModel;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private OnTextOnlyModeDisabledListener mOnTextOnlyModeDisabledListener;
    private ComposerControllerContract mView;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface OnTextOnlyModeDisabledListener {
        void onTextOnlyModeDisabled(int i);
    }

    public void init(ComposerModel composerModel) {
        this.mComposerModel = composerModel;
        composerModel.getTextOnlyModeState().setOnCanUseTextOnlyModeChangeListener(this);
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.common.TextOnlyModeState.OnCanUseTextOnlyModeChangeListener
    public void onCanUseChanged(final boolean z, final int i) {
        if (z) {
            return;
        }
        if (!CommonUtils.isOnMainUIThread()) {
            this.mHandler.post(new Runnable() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.TextOnlyModeController.2
                @Override // java.lang.Runnable
                public void run() {
                    TextOnlyModeController.this.onCanUseChanged(z, i);
                }
            });
            return;
        }
        setTextOnlyEnable(false);
        OnTextOnlyModeDisabledListener onTextOnlyModeDisabledListener = this.mOnTextOnlyModeDisabledListener;
        if (onTextOnlyModeDisabledListener != null) {
            onTextOnlyModeDisabledListener.onTextOnlyModeDisabled(i);
        }
    }

    public void setOnTextOnlyModeDisabledListener(OnTextOnlyModeDisabledListener onTextOnlyModeDisabledListener) {
        this.mOnTextOnlyModeDisabledListener = onTextOnlyModeDisabledListener;
    }

    public void setTextOnlyEnable(boolean z) {
        float lastZoomScale;
        SpenTextScaleListener spenTextScaleListener;
        if (this.mView == null) {
            return;
        }
        if (z == this.mComposerModel.getTextOnlyModeState().isEnableTextOnlyMode() && z == this.mView.isEnableTextOnlyMode()) {
            return;
        }
        this.mComposerModel.getTextOnlyModeState().setIsEnableTextOnlyMode(z);
        if (z) {
            spenTextScaleListener = new SpenTextScaleListener() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.composer.controller.TextOnlyModeController.1
                @Override // com.samsung.android.sdk.pen.text.SpenTextScaleListener
                public void onTextScaleChanged(float f) {
                    if (TextOnlyModeController.this.mComposerModel.getTextOnlyModeState().canUseTextOnlyMode()) {
                        TextOnlyModeController.this.mComposerModel.getTextOnlyModeState().setLastTextScale(f);
                        TextOnlyModeController.this.mView.onTextScaleChanged(f);
                    }
                }
            };
            lastZoomScale = this.mComposerModel.getTextOnlyModeState().getLastTextScale();
            this.mComposerModel.getTextOnlyModeState().setLastZoomScale(this.mView.getScale());
        } else {
            lastZoomScale = this.mComposerModel.getTextOnlyModeState().getLastZoomScale();
            spenTextScaleListener = null;
        }
        this.mView.setEnableTextOnlyMode(z, lastZoomScale, spenTextScaleListener);
    }

    public void setView(ComposerControllerContract composerControllerContract) {
        this.mView = composerControllerContract;
        if (composerControllerContract == null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
    }
}
