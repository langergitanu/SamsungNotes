package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice;

import android.app.Activity;
import android.text.TextUtils;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.pen.worddoc.SpenWNote;
import com.samsung.android.support.senl.p145cm.base.common.util.LocaleUtils;
import com.samsung.android.support.senl.p145cm.base.framework.content.SharedPreferencesCompat;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.UserInputSkipper;
import com.samsung.android.support.senl.p148nt.composer.C9086R;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.NoteManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.mode.Mode;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.EraserState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceViewState;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.composer.ComposerViewPresenter;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.ControllerManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.controller.TaskController;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.voice.VoiceRecordMenuContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskSaveVoiceForRecordApp;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskShareVoiceData;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.EarphoneButtonManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceService;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice.VoiceUtil;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.FeatureInfo;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.constants.SharedPreferencesConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSA;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.p156sa.ComposerSAConstants;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 S2\u00020\u0001:\u0001SB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\t2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\rJ\b\u0010#\u001a\u00020\u001cH\u0002J\u0010\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010\u0005J\u0010\u0010&\u001a\u00020\u001c2\b\u0010'\u001a\u0004\u0018\u00010\u0013J\u0006\u0010(\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020\u001cJ\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u0018J\u0006\u0010,\u001a\u00020\u001cJ\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0018J\b\u0010/\u001a\u000200H\u0002J\b\u00101\u001a\u00020\u0018H\u0002J\u000e\u00102\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u0015J\u0010\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u00020\u0015H\u0002J\u0010\u00106\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u0015H\u0002J\u0006\u00108\u001a\u00020\u001cJ\u0006\u00109\u001a\u00020\u0018J\u0010\u00108\u001a\u00020\u001c2\u0006\u00103\u001a\u00020\u0015H\u0002J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00150;J\u000e\u0010<\u001a\u00020\u001c2\u0006\u0010=\u001a\u00020\u0018J\u0006\u0010>\u001a\u00020\u0018J\u000e\u0010?\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020AJ\u000e\u0010B\u001a\u00020\u001c2\u0006\u00101\u001a\u00020\u0018J\u0006\u0010C\u001a\u00020\u001cJ\u0006\u0010D\u001a\u00020\u001cJ\u000e\u0010E\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u0018J\u0016\u0010G\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020A2\u0006\u0010F\u001a\u00020\u0018J \u0010H\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020A2\u0006\u0010J\u001a\u00020\u00182\u0006\u0010K\u001a\u00020\u0018H\u0016J\u0006\u0010L\u001a\u00020\u001cJ\u0006\u0010M\u001a\u00020\u001cJ\u000e\u0010N\u001a\u00020\u001c2\u0006\u0010O\u001a\u00020\u0018J\u0006\u0010P\u001a\u00020\u0018J\u0006\u0010Q\u001a\u00020\u001cJ\u0006\u0010R\u001a\u00020\u001cR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006T"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuSubPresenter;", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/NoteManager$ObserverBackgroundColor;", "<init>", "()V", "mView", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordMenuContract$IView;", "mListPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/menu/voice/VoiceRecordListPresenter;", "mComposerViewPresenter", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/composer/ComposerViewPresenter;", "mTaskController", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/TaskController;", "mObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "mComposerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "mVoiceModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "mActivity", "Landroid/app/Activity;", "mPlaySpeed", "", "mAudioPlaySpeed", "mIsEnabled", "", "mPrevEditMode", "mIsRunErased", "init", "", "composerModel", "presenter", "composerViewPresenter", "controllerManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/controller/ControllerManager;", "objectManager", "initWithPreference", "setView", "view", "onAttachView", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "onDetachView", "onTrashClick", "cancelSelect", "isViewUpdate", "onShareClick", "onSave", "isSelected", "getScreenID", "", "isEditMode", "changeSpeed", "speed", "getNextSpeed", "oldSpeed", "insertLogForSpeed", "playSpeed", "setPlaySpeed", "isShowingRecordingMenu", "getVoiceDataPlayPoints", "", "changeSyncOption", "enabled", "getSyncOption", "voiceItemClick", "index", "", "changeMode", "collapseSyncPlayDisable", "onEditClick", "checkAllItem", "checked", "checkItem", "onChangedBackgroundColor", "color", "invert", "hasBackgroundImage", "runAudioEraser", "changeToNormalVoice", "updateAudioEraserAnimation", "isEnable", "isEnableAudioEraser", "onAudioEraserInitCompleted", "clearErasingState", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceRecordMenuSubPresenter implements NoteManager.ObserverBackgroundColor {

    @NotNull
    private static final String TAG;

    @Nullable
    private Activity mActivity;
    private ComposerModel mComposerModel;
    private ComposerViewPresenter mComposerViewPresenter;
    private boolean mIsEnabled;
    private boolean mIsRunErased;
    private VoiceRecordListPresenter mListPresenter;
    private ObjectManager mObjectManager;
    private boolean mPrevEditMode;
    private TaskController mTaskController;

    @Nullable
    private VoiceRecordMenuContract.IView mView;
    private VoiceModel mVoiceModel;
    private float mPlaySpeed = 1.0f;
    private float mAudioPlaySpeed = 1.0f;

    static {
        String strCreateTag = Logger.createTag("VoiceRecordMenuSubPresenter");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
    }

    private final float getNextSpeed(float oldSpeed) {
        if (oldSpeed >= 2.0f) {
            return 0.5f;
        }
        return oldSpeed >= 1.5f ? oldSpeed + 0.5f : oldSpeed + 0.25f;
    }

    private final String getScreenID() {
        return isEditMode() ? ComposerSAConstants.SCREEN_RECORDING : ComposerSAConstants.SCREEN_VIEW_303;
    }

    private final void initWithPreference() {
        SharedPreferencesCompat.Companion companion = SharedPreferencesCompat.INSTANCE;
        this.mPlaySpeed = companion.getInstance("Composer").getFloat(SharedPreferencesConstants.COMPOSER_VOICE_RECORDING_PLAY_SPEED, 1.0f);
        this.mAudioPlaySpeed = companion.getInstance("Composer").getFloat(SharedPreferencesConstants.COMPOSER_AUDIO_PLAY_SPEED, 1.0f);
        this.mIsEnabled = companion.getInstance("Composer").getBoolean(SharedPreferencesConstants.COMPOSER_VOICE_RECORDING_PLAY_OPTION, true);
        VoiceModel voiceModel = this.mVoiceModel;
        ComposerViewPresenter composerViewPresenter = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.setSyncEnable(this.mIsEnabled);
        ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
        if (composerViewPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
        } else {
            composerViewPresenter = composerViewPresenter2;
        }
        composerViewPresenter.getVoiceController().setVoiceSyncPlayEnabled(this.mIsEnabled);
        ComposerSA.insertStatusLog(ComposerSAConstants.EVENT_STATUS_VOICE_RECORD_NOTE_REPLAY, this.mIsEnabled ? "1" : "0");
    }

    private final void insertLogForSpeed(float playSpeed) {
        String str = playSpeed == 1.25f ? "b" : playSpeed == 1.5f ? "c" : playSpeed == 2.0f ? "d" : playSpeed == 0.5f ? "e" : playSpeed == 0.75f ? "f" : "a";
        if (isShowingRecordingMenu()) {
            ComposerSA.insertLog(getScreenID(), isEditMode() ? ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_SPEED : ComposerSAConstants.EVENT_VOICE_VIEW_PANEL_SPEED, str);
        }
    }

    private final boolean isEditMode() {
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        return composerModel.getModeManager().isEditModeWithReadOnly();
    }

    public final void cancelSelect(boolean isViewUpdate) {
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.clearSelectedVoiceList();
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel3 = null;
        }
        voiceModel3.setSelectMode(false);
        VoiceRecordListPresenter voiceRecordListPresenter = this.mListPresenter;
        if (voiceRecordListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
            voiceRecordListPresenter = null;
        }
        voiceRecordListPresenter.clearVoiceDataList();
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.setItemSelectedMode(false);
        }
        VoiceRecordMenuContract.IView iView2 = this.mView;
        if (iView2 != null) {
            VoiceRecordListPresenter voiceRecordListPresenter2 = this.mListPresenter;
            if (voiceRecordListPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
                voiceRecordListPresenter2 = null;
            }
            iView2.setTotalRecordTime(voiceRecordListPresenter2.getTotalRecordTimeString());
        }
        VoiceRecordMenuContract.IView iView3 = this.mView;
        if (iView3 != null) {
            iView3.notifyDataChanged();
        }
        if (isViewUpdate) {
            VoiceModel voiceModel4 = this.mVoiceModel;
            if (voiceModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel4 = null;
            }
            if (voiceModel4.compareViewState(VoiceViewState.Type.EDIT)) {
                VoiceModel voiceModel5 = this.mVoiceModel;
                if (voiceModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                } else {
                    voiceModel2 = voiceModel5;
                }
                voiceModel2.setViewStateType(VoiceViewState.Type.LIST);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void changeMode(boolean isEditMode) {
        boolean z;
        ComposerModel composerModel = this.mComposerModel;
        VoiceModel voiceModel = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        if (composerModel.getModeManager().isMode(Mode.Init)) {
            return;
        }
        String str = TAG;
        ComposerModel composerModel2 = this.mComposerModel;
        if (composerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel2 = null;
        }
        Mode prevMode = composerModel2.getModeManager().getPrevMode();
        ComposerModel composerModel3 = this.mComposerModel;
        if (composerModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel3 = null;
        }
        Logger.m11003i(str, "changeMode. " + prevMode + " / " + composerModel3.getModeManager().getMode());
        boolean z2 = false;
        if (this.mPrevEditMode) {
            z = true;
        } else {
            ComposerModel composerModel4 = this.mComposerModel;
            if (composerModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
                composerModel4 = null;
            }
            if (composerModel4.getModeManager().getPrevMode() != Mode.ReadOnly) {
                z = false;
            }
        }
        if (isEditMode) {
            z2 = true;
        } else {
            ComposerModel composerModel5 = this.mComposerModel;
            if (composerModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
                composerModel5 = null;
            }
            if (composerModel5.getModeManager().isMode(Mode.ReadOnly)) {
            }
        }
        if (z != z2) {
            if (this.mView != null) {
                VoiceRecordListPresenter voiceRecordListPresenter = this.mListPresenter;
                if (voiceRecordListPresenter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
                    voiceRecordListPresenter = null;
                }
                String totalRecordTimeString = voiceRecordListPresenter.getTotalRecordTimeString();
                if (!TextUtils.isEmpty(totalRecordTimeString)) {
                    VoiceModel voiceModel2 = this.mVoiceModel;
                    if (voiceModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                        voiceModel2 = null;
                    }
                    if (!voiceModel2.isPlayingVoiceDataState()) {
                        VoiceModel voiceModel3 = this.mVoiceModel;
                        if (voiceModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                            voiceModel3 = null;
                        }
                        if (!voiceModel3.isRecordingVoiceState()) {
                            VoiceRecordMenuContract.IView iView = this.mView;
                            Intrinsics.checkNotNull(iView);
                            iView.setTotalRecordTime(totalRecordTimeString);
                        }
                    }
                }
                if (!z2) {
                    VoiceModel voiceModel4 = this.mVoiceModel;
                    if (voiceModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                        voiceModel4 = null;
                    }
                    if (voiceModel4.getSelectMode()) {
                        cancelSelect(true);
                        VoiceRecordMenuContract.IView iView2 = this.mView;
                        Intrinsics.checkNotNull(iView2);
                        iView2.hideEditTrashView();
                    }
                }
                VoiceRecordMenuContract.IView iView3 = this.mView;
                Intrinsics.checkNotNull(iView3);
                VoiceModel voiceModel5 = this.mVoiceModel;
                if (voiceModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                } else {
                    voiceModel = voiceModel5;
                }
                iView3.changeMode(z2, voiceModel.getViewState());
            }
            if (!z2) {
                EarphoneButtonManager.INSTANCE.getInstance().releaseMediaSession();
            }
        }
        collapseSyncPlayDisable();
        this.mPrevEditMode = isEditMode;
    }

    public final void changeSpeed(float speed) {
        ComposerModel composerModel = this.mComposerModel;
        VoiceRecordListPresenter voiceRecordListPresenter = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        if (composerModel.getNotesDocEntityManager().isDeleted()) {
            return;
        }
        VoiceRecordListPresenter voiceRecordListPresenter2 = this.mListPresenter;
        if (voiceRecordListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
        } else {
            voiceRecordListPresenter = voiceRecordListPresenter2;
        }
        voiceRecordListPresenter.clearSelectionObject();
        if (isShowingRecordingMenu()) {
            if (0.5f > speed || speed > 2.0f) {
                speed = getNextSpeed(this.mPlaySpeed);
            }
            this.mPlaySpeed = speed;
            SharedPreferencesCompat.INSTANCE.getInstance("Composer").putFloat(SharedPreferencesConstants.COMPOSER_VOICE_RECORDING_PLAY_SPEED, this.mPlaySpeed);
        } else {
            if (0.5f > speed || speed > 2.0f) {
                speed = getNextSpeed(this.mAudioPlaySpeed);
            }
            this.mAudioPlaySpeed = speed;
            SharedPreferencesCompat.INSTANCE.getInstance("Composer").putFloat(SharedPreferencesConstants.COMPOSER_AUDIO_PLAY_SPEED, this.mAudioPlaySpeed);
        }
        insertLogForSpeed(speed);
        setPlaySpeed(speed);
    }

    public final void changeSyncOption(boolean enabled) {
        this.mIsEnabled = enabled;
        AbstractC8014b.m7224z("changeSyncOption. ", TAG, enabled);
        ComposerViewPresenter composerViewPresenter = this.mComposerViewPresenter;
        VoiceModel voiceModel = null;
        if (composerViewPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            composerViewPresenter = null;
        }
        composerViewPresenter.getVoiceController().setVoiceSyncPlayEnabled(enabled);
        VoiceModel voiceModel2 = this.mVoiceModel;
        if (voiceModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
        } else {
            voiceModel = voiceModel2;
        }
        voiceModel.setSyncEnable(enabled);
        SharedPreferencesCompat.INSTANCE.getInstance("Composer").putBoolean(SharedPreferencesConstants.COMPOSER_VOICE_RECORDING_PLAY_OPTION, this.mIsEnabled);
    }

    public final void changeToNormalVoice() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.setEraserState(EraserState.NORMAL);
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            VoiceRecordMenuContract.IView.DefaultImpls.updateViewForEraser$default(iView, false, 1, null);
        }
    }

    public final void checkAllItem(boolean checked) {
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        for (SpenVoiceData spenVoiceData : voiceModel.getVoiceDataList()) {
            if (checked) {
                VoiceModel voiceModel3 = this.mVoiceModel;
                if (voiceModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel3 = null;
                }
                voiceModel3.addSelectedVoice(spenVoiceData.getName());
            } else {
                VoiceModel voiceModel4 = this.mVoiceModel;
                if (voiceModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel4 = null;
                }
                voiceModel4.removeSelectedVoice(spenVoiceData.getName());
            }
        }
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.notifyDataChanged();
        }
        VoiceRecordMenuContract.IView iView2 = this.mView;
        if (iView2 != null) {
            VoiceModel voiceModel5 = this.mVoiceModel;
            if (voiceModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            } else {
                voiceModel2 = voiceModel5;
            }
            iView2.updateSelectedItemMenu(voiceModel2.getSelectedVoiceListSize());
        }
    }

    public final void checkItem(int index, boolean checked) {
        if (this.mView == null || index < 0) {
            return;
        }
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (index < voiceModel.getVoiceDataListSize()) {
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            String name = voiceModel3.getVoiceDataList().get(index).getName();
            if (checked) {
                VoiceModel voiceModel4 = this.mVoiceModel;
                if (voiceModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel4 = null;
                }
                voiceModel4.addSelectedVoice(name);
            } else {
                VoiceModel voiceModel5 = this.mVoiceModel;
                if (voiceModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel5 = null;
                }
                voiceModel5.removeSelectedVoice(name);
            }
            VoiceRecordMenuContract.IView iView = this.mView;
            Intrinsics.checkNotNull(iView);
            VoiceModel voiceModel6 = this.mVoiceModel;
            if (voiceModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            } else {
                voiceModel2 = voiceModel6;
            }
            iView.updateSelectedItemMenu(voiceModel2.getSelectedVoiceListSize());
            VoiceRecordMenuContract.IView iView2 = this.mView;
            Intrinsics.checkNotNull(iView2);
            iView2.notifyItemChanged(index);
        }
    }

    public final void clearErasingState() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (voiceModel.getMEraserState() != EraserState.ERASING) {
            return;
        }
        this.mIsRunErased = false;
        VoiceModel voiceModel2 = this.mVoiceModel;
        if (voiceModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel2 = null;
        }
        voiceModel2.setEraserState(EraserState.NORMAL);
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            VoiceRecordMenuContract.IView.DefaultImpls.updateViewForEraser$default(iView, false, 1, null);
        }
    }

    public final void collapseSyncPlayDisable() {
        ComposerModel composerModel = this.mComposerModel;
        ComposerViewPresenter composerViewPresenter = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        if (composerModel.getModeManager().isEditMode()) {
            VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel = null;
            }
            if (voiceModel.isPauseVoiceData()) {
                VoiceModel voiceModel2 = this.mVoiceModel;
                if (voiceModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel2 = null;
                }
                if (voiceModel2.compareViewState(VoiceViewState.Type.VOICEINIT)) {
                    Logger.m11003i(TAG, "collapseSyncPlayDisable. ");
                    ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
                    if (composerViewPresenter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
                    } else {
                        composerViewPresenter = composerViewPresenter2;
                    }
                    composerViewPresenter.getVoiceController().setVoiceSyncPlayEnabled(false);
                }
            }
        }
    }

    /* JADX INFO: renamed from: getSyncOption, reason: from getter */
    public final boolean getMIsEnabled() {
        return this.mIsEnabled;
    }

    @NotNull
    public final List<Float> getVoiceDataPlayPoints() {
        ArrayList arrayList = new ArrayList();
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        int i = 0;
        for (SpenVoiceData spenVoiceData : voiceModel.getVoiceDataList()) {
            int recordingTime = (int) spenVoiceData.getRecordingTime();
            if (recordingTime <= 0) {
                recordingTime = VoiceUtil.INSTANCE.changeTimeType(spenVoiceData.getPlayTime()) * 1000;
            }
            i += recordingTime;
            arrayList.add(Float.valueOf(i));
        }
        return arrayList;
    }

    public final void init(@NotNull ComposerModel composerModel, @NotNull VoiceRecordListPresenter presenter, @NotNull ComposerViewPresenter composerViewPresenter, @NotNull ControllerManager controllerManager, @NotNull ObjectManager objectManager) {
        Intrinsics.checkNotNullParameter(composerModel, "composerModel");
        Intrinsics.checkNotNullParameter(presenter, "presenter");
        Intrinsics.checkNotNullParameter(composerViewPresenter, "composerViewPresenter");
        Intrinsics.checkNotNullParameter(controllerManager, "controllerManager");
        Intrinsics.checkNotNullParameter(objectManager, "objectManager");
        this.mComposerModel = composerModel;
        this.mVoiceModel = composerModel.getVoiceModel();
        this.mListPresenter = presenter;
        this.mComposerViewPresenter = composerViewPresenter;
        this.mTaskController = controllerManager.getTaskController();
        this.mObjectManager = objectManager;
        ComposerModel composerModel2 = this.mComposerModel;
        if (composerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel2 = null;
        }
        this.mPrevEditMode = composerModel2.getModeManager().isEditMode();
        initWithPreference();
    }

    public final boolean isEnableAudioEraser() {
        VoiceUtil voiceUtil = VoiceUtil.INSTANCE;
        VoiceRecordListPresenter voiceRecordListPresenter = this.mListPresenter;
        if (voiceRecordListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
            voiceRecordListPresenter = null;
        }
        return voiceUtil.changeTimeType(voiceRecordListPresenter.getTotalRecordTimeString()) >= 2;
    }

    public final boolean isShowingRecordingMenu() {
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        return voiceModel.getViewState().isShowingRecordingState();
    }

    public final void onAttachView(@Nullable Activity activity) {
        this.mActivity = activity;
    }

    public final void onAudioEraserInitCompleted() {
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        if (voiceModel.getMEraserState() != EraserState.ERASING) {
            return;
        }
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel3 = null;
        }
        voiceModel3.setEraserState(EraserState.ERASED);
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            VoiceRecordMenuContract.IView.DefaultImpls.updateViewForEraser$default(iView, false, 1, null);
        }
        VoiceRecordMenuContract.IView iView2 = this.mView;
        if (iView2 != null) {
            VoiceModel voiceModel4 = this.mVoiceModel;
            if (voiceModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            } else {
                voiceModel2 = voiceModel4;
            }
            iView2.updateAudioEraserAnimation(voiceModel2.isPlayingVoiceData());
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.model.composer.NoteManager.ObserverBackgroundColor
    public void onChangedBackgroundColor(int color, boolean invert, boolean hasBackgroundImage) {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateBackground(color, invert, hasBackgroundImage, true);
        }
    }

    public final void onDetachView() {
        this.mActivity = null;
        this.mView = null;
    }

    public final void onEditClick() {
        VoiceModel voiceModel = this.mVoiceModel;
        VoiceModel voiceModel2 = null;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.stopPlaying();
        VoiceService.INSTANCE.stopService();
        VoiceRecordListPresenter voiceRecordListPresenter = this.mListPresenter;
        if (voiceRecordListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
            voiceRecordListPresenter = null;
        }
        voiceRecordListPresenter.clearSelectionObject();
        clearErasingState();
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel3 = null;
        }
        voiceModel3.setSelectMode(true);
        VoiceRecordListPresenter voiceRecordListPresenter2 = this.mListPresenter;
        if (voiceRecordListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
            voiceRecordListPresenter2 = null;
        }
        voiceRecordListPresenter2.setDeleteVisible(true);
        VoiceRecordListPresenter voiceRecordListPresenter3 = this.mListPresenter;
        if (voiceRecordListPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
            voiceRecordListPresenter3 = null;
        }
        voiceRecordListPresenter3.updatePlayingItemByIndex(0);
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            VoiceModel voiceModel4 = this.mVoiceModel;
            if (voiceModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            } else {
                voiceModel2 = voiceModel4;
            }
            iView.showEditView(true, voiceModel2.getSelectedVoiceListSize());
        }
        VoiceRecordMenuContract.IView iView2 = this.mView;
        if (iView2 != null) {
            iView2.notifyDataChanged();
        }
    }

    public final void onSave(boolean isSelected) {
        ArrayList arrayList;
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        voiceModel.stopPlaying();
        VoiceRecordListPresenter voiceRecordListPresenter = this.mListPresenter;
        if (voiceRecordListPresenter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
            voiceRecordListPresenter = null;
        }
        voiceRecordListPresenter.clearSelectionObject();
        if (isSelected) {
            arrayList = new ArrayList();
            VoiceModel voiceModel2 = this.mVoiceModel;
            if (voiceModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel2 = null;
            }
            ArrayList arrayList2 = new ArrayList(voiceModel2.getVoiceDataList());
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            for (String str : voiceModel3.getSelectedVoiceList()) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        SpenVoiceData spenVoiceData = (SpenVoiceData) it.next();
                        if (Intrinsics.areEqual(str, spenVoiceData.getName())) {
                            arrayList.add(spenVoiceData);
                            break;
                        }
                    }
                }
            }
        } else {
            VoiceModel voiceModel4 = this.mVoiceModel;
            if (voiceModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel4 = null;
            }
            arrayList = new ArrayList(voiceModel4.getVoiceDataList());
        }
        AbstractC8014b.m7217s(arrayList.size(), "onSave. shareList = ", TAG);
        TaskController taskController = this.mTaskController;
        if (taskController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTaskController");
            taskController = null;
        }
        TaskSaveVoiceForRecordApp taskSaveVoiceForRecordApp = new TaskSaveVoiceForRecordApp();
        Activity activity = this.mActivity;
        ComposerModel composerModel = this.mComposerModel;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        String uuid = composerModel.getDocInfo().getUuid();
        ComposerModel composerModel2 = this.mComposerModel;
        if (composerModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel2 = null;
        }
        taskController.execute(taskSaveVoiceForRecordApp, new TaskSaveVoiceForRecordApp.InputValues(activity, uuid, arrayList, composerModel2.getDocInfo().getDocPath()), null, false);
    }

    public final void onShareClick() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            Logger.m11003i(TAG, "onShareClick.");
            UserInputSkipper.setHoldingEventTime(1000L, tag);
            VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel = null;
            }
            voiceModel.stopPlaying();
            VoiceRecordListPresenter voiceRecordListPresenter = this.mListPresenter;
            if (voiceRecordListPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
                voiceRecordListPresenter = null;
            }
            voiceRecordListPresenter.clearSelectionObject();
            ArrayList arrayList = new ArrayList();
            VoiceModel voiceModel2 = this.mVoiceModel;
            if (voiceModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel2 = null;
            }
            ArrayList arrayList2 = new ArrayList(voiceModel2.getVoiceDataList());
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            for (String str : voiceModel3.getSelectedVoiceList()) {
                Iterator it = arrayList2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        SpenVoiceData spenVoiceData = (SpenVoiceData) it.next();
                        if (Intrinsics.areEqual(str, spenVoiceData.getName())) {
                            arrayList.add(spenVoiceData);
                            break;
                        }
                    }
                }
            }
            ComposerSA.insertLog(getScreenID(), isEditMode() ? ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_SHARE : ComposerSAConstants.EVENT_VOICE_VIEW_PANEL_SHARE, arrayList.size() == 1 ? "a" : "b");
            TaskController taskController = this.mTaskController;
            if (taskController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mTaskController");
                taskController = null;
            }
            TaskShareVoiceData taskShareVoiceData = new TaskShareVoiceData();
            Activity activity = this.mActivity;
            ObjectManager objectManager = this.mObjectManager;
            if (objectManager == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mObjectManager");
                objectManager = null;
            }
            ComposerModel composerModel = this.mComposerModel;
            if (composerModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
                composerModel = null;
            }
            taskController.execute(taskShareVoiceData, new TaskShareVoiceData.InputValues(activity, objectManager, arrayList, composerModel.getDocInfo().getDocPath()), null, false);
        }
    }

    public final void onTrashClick() {
        UserInputSkipper.Tag tag = UserInputSkipper.Tag.Menu;
        if (UserInputSkipper.isValidEvent(tag)) {
            String str = TAG;
            Logger.m11003i(str, "onTrashClick.");
            Logger.addFileLog(str, "VoiceTrash", 0);
            UserInputSkipper.setHoldingEventTime(300L, tag);
            ComposerSA.insertLog(ComposerSAConstants.SCREEN_RECORDING, ComposerSAConstants.EVENT_VOICE_RECORDING_PANEL_DELETE);
            VoiceModel voiceModel = this.mVoiceModel;
            ObjectManager objectManager = null;
            if (voiceModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel = null;
            }
            ArrayList arrayList = new ArrayList(voiceModel.getVoiceDataList());
            VoiceModel voiceModel2 = this.mVoiceModel;
            if (voiceModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel2 = null;
            }
            for (String str2 : voiceModel2.getSelectedVoiceList()) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        SpenVoiceData spenVoiceData = (SpenVoiceData) it.next();
                        if (Intrinsics.areEqual(spenVoiceData.getName(), str2)) {
                            int iIndexOf = arrayList.indexOf(spenVoiceData);
                            it.remove();
                            VoiceModel voiceModel3 = this.mVoiceModel;
                            if (voiceModel3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                                voiceModel3 = null;
                            }
                            voiceModel3.removeVoiceData(iIndexOf);
                            VoiceManager.removeVoiceData(iIndexOf);
                            VoiceModel voiceModel4 = this.mVoiceModel;
                            if (voiceModel4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                                voiceModel4 = null;
                            }
                            SpenWNote mWNote = voiceModel4.getMWNote();
                            if (mWNote != null) {
                                mWNote.removeVoiceData(iIndexOf);
                            }
                            VoiceRecordListPresenter voiceRecordListPresenter = this.mListPresenter;
                            if (voiceRecordListPresenter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
                                voiceRecordListPresenter = null;
                            }
                            voiceRecordListPresenter.remove(iIndexOf);
                        }
                    }
                }
            }
            VoiceModel voiceModel5 = this.mVoiceModel;
            if (voiceModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel5 = null;
            }
            voiceModel5.clearSelectedVoiceList();
            VoiceModel voiceModel6 = this.mVoiceModel;
            if (voiceModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel6 = null;
            }
            if (!voiceModel6.getVoiceDataList().isEmpty()) {
                VoiceModel voiceModel7 = this.mVoiceModel;
                if (voiceModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel7 = null;
                }
                voiceModel7.setViewStateType(VoiceViewState.Type.LIST);
                VoiceModel voiceModel8 = this.mVoiceModel;
                if (voiceModel8 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel8 = null;
                }
                VoiceModel voiceModel9 = this.mVoiceModel;
                if (voiceModel9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel9 = null;
                }
                voiceModel8.setRecordingTime(voiceModel9.getAllRecordTime() / 1000);
                VoiceRecordListPresenter voiceRecordListPresenter2 = this.mListPresenter;
                if (voiceRecordListPresenter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
                    voiceRecordListPresenter2 = null;
                }
                voiceRecordListPresenter2.setDeleteVisible(false);
            }
            ObjectManager objectManager2 = this.mObjectManager;
            if (objectManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mObjectManager");
            } else {
                objectManager = objectManager2;
            }
            objectManager.commitHistory();
        }
    }

    public final void runAudioEraser() {
        if (this.mIsRunErased) {
            VoiceModel voiceModel = this.mVoiceModel;
            if (voiceModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel = null;
            }
            voiceModel.setEraserState(EraserState.ERASED);
        } else {
            this.mIsRunErased = true;
            VoiceModel voiceModel2 = this.mVoiceModel;
            if (voiceModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel2 = null;
            }
            voiceModel2.setEraserState(EraserState.ERASING);
            VoiceRecordListPresenter voiceRecordListPresenter = this.mListPresenter;
            if (voiceRecordListPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
                voiceRecordListPresenter = null;
            }
            voiceRecordListPresenter.clearSelectionObject();
            VoiceModel voiceModel3 = this.mVoiceModel;
            if (voiceModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel3 = null;
            }
            if (!voiceModel3.isPlayingVoiceData()) {
                VoiceModel voiceModel4 = this.mVoiceModel;
                if (voiceModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                    voiceModel4 = null;
                }
                if (!voiceModel4.playPause()) {
                    VoiceModel voiceModel5 = this.mVoiceModel;
                    if (voiceModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                        voiceModel5 = null;
                    }
                    voiceModel5.playVoiceData();
                }
            }
        }
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            VoiceRecordMenuContract.IView.DefaultImpls.updateViewForEraser$default(iView, false, 1, null);
        }
    }

    public final void setPlaySpeed() {
        setPlaySpeed(isShowingRecordingMenu() ? this.mPlaySpeed : this.mAudioPlaySpeed);
    }

    public final void setView(@Nullable VoiceRecordMenuContract.IView view) {
        this.mView = view;
    }

    public final void updateAudioEraserAnimation(boolean isEnable) {
        VoiceRecordMenuContract.IView iView = this.mView;
        if (iView != null) {
            iView.updateAudioEraserAnimation(isEnable);
        }
    }

    public final void voiceItemClick(int index) {
        ComposerModel composerModel = this.mComposerModel;
        ComposerViewPresenter composerViewPresenter = null;
        if (composerModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mComposerModel");
            composerModel = null;
        }
        if (composerModel.getNotesDocEntityManager().isDeleted()) {
            return;
        }
        VoiceModel voiceModel = this.mVoiceModel;
        if (voiceModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel = null;
        }
        List<SpenVoiceData> voiceDataList = voiceModel.getVoiceDataList();
        AbstractC14516b.m15114b(index, voiceDataList.size(), "voiceItemClick. position=", " / ", TAG);
        if (index < 0 || index >= voiceDataList.size()) {
            return;
        }
        VoiceModel voiceModel2 = this.mVoiceModel;
        if (voiceModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel2 = null;
        }
        voiceModel2.setRecordPlayingInfo(index, 0);
        if (FeatureInfo.isSupportSTTFunction()) {
            VoiceRecordListPresenter voiceRecordListPresenter = this.mListPresenter;
            if (voiceRecordListPresenter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
                voiceRecordListPresenter = null;
            }
            voiceRecordListPresenter.updateSTTShowItem(index);
        }
        VoiceModel voiceModel3 = this.mVoiceModel;
        if (voiceModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
            voiceModel3 = null;
        }
        if (voiceModel3.isPlayingState()) {
            VoiceManager.seekTo(index, 0);
        } else {
            VoiceModel voiceModel4 = this.mVoiceModel;
            if (voiceModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVoiceModel");
                voiceModel4 = null;
            }
            voiceModel4.playVoiceData();
        }
        VoiceRecordListPresenter voiceRecordListPresenter2 = this.mListPresenter;
        if (voiceRecordListPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListPresenter");
            voiceRecordListPresenter2 = null;
        }
        if (voiceRecordListPresenter2.isAutoScrollEnableMode()) {
            ComposerViewPresenter composerViewPresenter2 = this.mComposerViewPresenter;
            if (composerViewPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mComposerViewPresenter");
            } else {
                composerViewPresenter = composerViewPresenter2;
            }
            composerViewPresenter.getVoiceController().setVoiceSyncPlayAutoScroll(true);
        }
        ComposerSA.insertLog(getScreenID(), isEditMode() ? ComposerSAConstants.EVENT_VOICE_RECORDING_VOICE_PLAY_BY_ITEM_CLICK : ComposerSAConstants.EVENT_VOICE_VIEW_PLAY_BY_ITEM_CLICK);
    }

    private final void setPlaySpeed(float speed) {
        Activity activity = this.mActivity;
        if (activity == null) {
            return;
        }
        Logger.m11003i(TAG, "setPlaySpeed# " + speed);
        VoiceManager.setSpeed(speed);
        DecimalFormat decimalFormat = new DecimalFormat("0.0#");
        if (LocaleUtils.isRTLMode()) {
            VoiceRecordMenuContract.IView iView = this.mView;
            if (iView != null) {
                String string = activity.getString(C9086R.string.composer_voice_record_play_speed_arabic, 'x', decimalFormat.format(speed));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                iView.setPlaySpeed(string);
                return;
            }
            return;
        }
        VoiceRecordMenuContract.IView iView2 = this.mView;
        if (iView2 != null) {
            String string2 = activity.getString(C9086R.string.composer_voice_record_play_speed, decimalFormat.format(speed), 'x');
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            iView2.setPlaySpeed(string2);
        }
    }
}
