package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option;

import android.annotation.SuppressLint;
import android.app.Activity;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.base.winset.accessibility.VoiceAssistantTTS;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class OptionMenuFingerDrawingPresenter implements IOptionMenuFingerDrawingPresenter {
    private static final String TAG = Logger.createTag("OptionMenuFingerDrawingPresenter");
    protected Activity mActivity;
    protected ComposerModel mComposerModel;
    protected ComposerViewPresenter mComposerViewPresenter;

    public OptionMenuFingerDrawingPresenter(ComposerViewPresenter composerViewPresenter, ComposerModel composerModel) {
        this.mComposerViewPresenter = composerViewPresenter;
        this.mComposerModel = composerModel;
    }

    private boolean isReadOnlyMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            return false;
        }
        return composerModel.getModeManager().isMode(Mode.ReadOnly);
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public void blockSmartTip() {
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public int getSmartTipState() {
        return -2;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public boolean isSpenOnlyMode() {
        return this.mComposerViewPresenter.getWritingToolManager().isSpenOnlyMode();
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public void onAttachView(Activity activity) {
        this.mActivity = activity;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    @SuppressLint({"StringFormatInvalid"})
    public void onClickFingerDrawing() {
        String string;
        if (isReadOnlyMode()) {
            this.mComposerModel.getModeManager().setMode(Mode.Writing, AbstractC0622a.m1170p(TAG, "#onClickFingerDrawing", new StringBuilder()), true);
        }
        boolean zIsSpenOnlyMode = this.mComposerViewPresenter.getWritingToolManager().isSpenOnlyMode();
        boolean z = !zIsSpenOnlyMode;
        if (zIsSpenOnlyMode) {
            Activity activity = this.mActivity;
            string = activity.getString(C9086R.string.composer_tts_is_on, activity.getString(C9086R.string.composer_finger_drawing));
        } else {
            Activity activity2 = this.mActivity;
            string = activity2.getString(C9086R.string.composer_tts_turned_off, activity2.getString(C9086R.string.composer_finger_drawing));
        }
        VoiceAssistantTTS.getInstance().sendTalkBackMessage(string);
        this.mComposerModel.setLastSpenOnlyMode(z);
        this.mComposerViewPresenter.getWritingToolManager().setSpenOnlyMode(z);
        String str = !zIsSpenOnlyMode ? "1" : "0";
        ComposerSA.insertStatusLog(ComposerSAConstants.EVENT_STATUS_FINGER_DRAWING, str);
        if (this.mComposerModel.getCoeditAdapter().isCoeditNote()) {
            ComposerSA.insertLog("683", ComposerSAConstants.EVENT_EDIT_TURN_ONOFF_SPEN_ONLY, str);
        } else if (this.mComposerModel.getComposerState().isInAppCollaborationMode()) {
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_IN_APP_SERVER, ComposerSAConstants.EVENT_IN_APP_EDIT_TURN_ONOFF_SPEN_ONLY, str);
        } else {
            ComposerSA.insertLog("401", ComposerSAConstants.EVENT_EDIT_TURN_ONOFF_SPEN_ONLY, str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public void onDetachView() {
        this.mActivity = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.option.IOptionMenuFingerDrawingPresenter
    public void setSmartTipState(int i) {
    }
}
