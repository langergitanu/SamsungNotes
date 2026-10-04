package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.voice;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager;
import com.samsung.android.sdk.composer.voice.VoiceManager;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.ComposerModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.composer.ObjectManager;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.EraserState;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceModel;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.voice.VoiceState;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.ComposerConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import com.samsung.android.support.senl.p148nt.composer.main.screenoff.util.Constants;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p258y.AbstractC14516b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\tH\u0016J\"\u0010\u000f\u001a\u00020\u00102\b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0018"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceService;", "Landroid/app/Service;", "<init>", "()V", "mNotificationHelper", "Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceNotificationHelper;", "mVoiceStateChangedListener", "Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnStateChanged;", "stop", "", "onBind", "Landroid/os/IBinder;", MarketingConstants.LINK_TYPE_INTENT, "Landroid/content/Intent;", "onCreate", "onStartCommand", "", "flags", "startId", "onDestroy", "currentProgress", "getCurrentProgress", "()I", "Companion", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class VoiceService extends Service {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG;

    @NotNull
    private static Object lock;

    @Nullable
    private static Context mAppContext;

    @Nullable
    private static Intent mAppIntent;
    private static boolean mIsWorking;

    @Nullable
    private static ObjectManager mObjectManager;

    @Nullable
    private static VoiceModel mVoiceModel;

    @Nullable
    private VoiceNotificationHelper mNotificationHelper;

    @NotNull
    private final SpenVoiceListenerManager.OnStateChanged mVoiceStateChangedListener = new SpenVoiceListenerManager.OnStateChanged() { // from class: com.samsung.android.support.senl.nt.composer.main.base.presenter.voice.VoiceService$mVoiceStateChangedListener$1
        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onInfo(SpenObjectVoice spenObjectVoice, int i) {
            Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayClicked(SpenObjectVoice objectVoice) {
            Intrinsics.checkNotNullParameter(objectVoice, "objectVoice");
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayComplete(SpenObjectVoice spenObjectVoice) {
            Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
            Logger.m11003i(VoiceService.TAG, "onPlayComplete, spenObjectVoice: " + spenObjectVoice);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.setVoiceState(VoiceState.NONE);
                }
            }
            this.this$0.stop();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayError(SpenObjectVoice spenObjectVoice, int i) {
            Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
            Logger.m11000e(VoiceService.TAG, "onPlayError, spenObjectVoice: " + spenObjectVoice);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.setVoiceState(VoiceState.ERROR);
                }
            }
            this.this$0.stop();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayInfo(SpenObjectVoice spenObjectVoice, int mediaInfo) {
            Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayPaused(SpenObjectVoice spenObjectVoice) {
            Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
            Logger.m11003i(VoiceService.TAG, "onPlayPaused, spenObjectVoice: " + spenObjectVoice);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    VoiceState voiceState = VoiceState.PLAY_PAUSE;
                    voiceModel2.setVoiceState(voiceState);
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    if (voiceNotificationHelper != null) {
                        voiceNotificationHelper.updatePlayStatus(VoiceManager.getPlayProgress() / 1000, voiceState);
                    }
                }
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayPrepared(SpenObjectVoice spenObjectVoice, int i) {
            Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayResumed(SpenObjectVoice spenObjectVoice) {
            Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
            Logger.m11003i(VoiceService.TAG, "onPlayResumed, spenObjectVoice: " + spenObjectVoice);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    VoiceState voiceState = VoiceState.PLAY_RESUMED;
                    voiceModel2.setVoiceState(voiceState);
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    if (voiceNotificationHelper != null) {
                        voiceNotificationHelper.updatePlayStatus(VoiceManager.getPlayProgress() / 1000, voiceState);
                    }
                }
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlaySeekComplete(SpenObjectVoice spenObjectVoice, int i) {
            Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.setAudioProgress(i);
                    VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel3);
                    if (voiceModel3.isPlayingState()) {
                        VoiceModel voiceModel4 = VoiceService.mVoiceModel;
                        Intrinsics.checkNotNull(voiceModel4);
                        voiceModel4.setVoiceState(VoiceState.PLAY_PROGRESS);
                    }
                    if (this.this$0.mNotificationHelper == null || !VoiceService.mIsWorking) {
                        return;
                    }
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    Intrinsics.checkNotNull(voiceNotificationHelper);
                    voiceNotificationHelper.updatePlayTime(i);
                }
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayStarted(SpenObjectVoice spenObjectVoice) {
            Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
            Logger.m11003i(VoiceService.TAG, "onPlayStarted, spenObjectVoice: " + spenObjectVoice);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasObjectVoice(spenObjectVoice)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.setPlayData(spenObjectVoice, null);
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    if (voiceNotificationHelper != null) {
                        voiceNotificationHelper.updatePlayStatus(VoiceManager.getPlayProgress() / 1000, VoiceState.PLAY_STARTED);
                    }
                }
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayStopped(SpenObjectVoice spenObjectVoice) {
            Intrinsics.checkNotNullParameter(spenObjectVoice, "spenObjectVoice");
            Logger.m11003i(VoiceService.TAG, "onPlayStopped, spenObjectVoice: " + spenObjectVoice);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentObjectVoice(spenObjectVoice)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.setVoiceState(VoiceState.NONE);
                }
            }
            this.this$0.stop();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onRecordCancelled(SpenVoiceData spenVoiceData) {
            Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
            Logger.m11003i(VoiceService.TAG, "onRecordCancelled, spenVoiceData: " + spenVoiceData);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(spenVoiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.removeErrorVoiceData(spenVoiceData);
                    VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel3);
                    voiceModel3.setVoiceState(VoiceState.CANCEL);
                }
            }
            this.this$0.stop();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onRecordError(SpenVoiceData spenVoiceData, int i) {
            Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
            Logger.m11000e(VoiceService.TAG, "onRecordError, spenVoiceData: " + spenVoiceData + ", i: " + i);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(spenVoiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.removeErrorVoiceData(spenVoiceData);
                    VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel3);
                    voiceModel3.setVoiceState(VoiceState.ERROR);
                }
            }
            this.this$0.stop();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onRecordPaused(SpenVoiceData spenVoiceData) {
            Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
            Logger.m11003i(VoiceService.TAG, "onRecordPaused, spenVoiceData: " + spenVoiceData);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(spenVoiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    VoiceState voiceState = VoiceState.RECORD_PAUSE;
                    voiceModel2.setVoiceState(voiceState);
                    VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel3);
                    int recordingTime = voiceModel3.getRecordingTime() * 1000;
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    if (voiceNotificationHelper != null) {
                        voiceNotificationHelper.updateRecordStatus(recordingTime, voiceState);
                    }
                }
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onRecordResumed(SpenVoiceData spenVoiceData) {
            Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
            Logger.m11003i(VoiceService.TAG, "onRecordResumed, spenVoiceData: " + spenVoiceData);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(spenVoiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    VoiceState voiceState = VoiceState.RECORD_RESUMED;
                    voiceModel2.setVoiceState(voiceState);
                    VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel3);
                    int recordingTime = voiceModel3.getRecordingTime() * 1000;
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    if (voiceNotificationHelper != null) {
                        voiceNotificationHelper.updateRecordStatus(recordingTime, voiceState);
                    }
                }
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onRecordStarted(SpenVoiceData spenVoiceData, String cachePath) {
            Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
            Intrinsics.checkNotNullParameter(cachePath, "cachePath");
            Logger.m11003i(VoiceService.TAG, "onRecordStarted, spenVoiceData: " + spenVoiceData);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasVoiceData(spenVoiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.setRecordData(spenVoiceData);
                    if (this.this$0.mNotificationHelper != null) {
                        VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                        Intrinsics.checkNotNull(voiceModel3);
                        int voiceDataIndex = voiceModel3.getVoiceDataIndex(spenVoiceData);
                        VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                        Intrinsics.checkNotNull(voiceNotificationHelper);
                        VoiceModel voiceModel4 = VoiceService.mVoiceModel;
                        Intrinsics.checkNotNull(voiceModel4);
                        voiceNotificationHelper.updateRecordStatus(voiceModel4.getVoiceDataTimeByIndex(voiceDataIndex) / 1000, VoiceState.RECORD_STARTED);
                    }
                }
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onRecordStopped(SpenVoiceData spenVoiceData) {
            Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
            Logger.m11003i(VoiceService.TAG, "onRecordStopped, spenVoiceData: " + spenVoiceData);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasVoiceData(spenVoiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.setVoiceState(VoiceState.NONE);
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    if (voiceNotificationHelper != null) {
                        VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                        Intrinsics.checkNotNull(voiceModel3);
                        voiceNotificationHelper.updateNewRecordStatus(voiceModel3.getAllRecordTime() / 1000, VoiceState.RECORD_IDLE);
                        return;
                    }
                    return;
                }
            }
            this.this$0.stop();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onRecordUpdateTime(SpenVoiceData spenVoiceData, int i) {
            Intrinsics.checkNotNullParameter(spenVoiceData, "spenVoiceData");
            Logger.m10999d(VoiceService.TAG, "onRecordUpdateTime, spenVoiceData: " + spenVoiceData + ", i: " + i);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(spenVoiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    int voiceDataIndex = voiceModel2.getVoiceDataIndex(spenVoiceData);
                    VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel3);
                    int voiceDataTimeByIndex = (voiceModel3.getVoiceDataTimeByIndex(voiceDataIndex) / 1000) + i;
                    VoiceModel voiceModel4 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel4);
                    voiceModel4.setRecordingTimeState(voiceDataTimeByIndex);
                    if (this.this$0.mNotificationHelper == null || !VoiceService.mIsWorking) {
                        return;
                    }
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    Intrinsics.checkNotNull(voiceNotificationHelper);
                    voiceNotificationHelper.updateRecordTime(voiceDataTimeByIndex);
                    return;
                }
            }
            if (VoiceService.mVoiceModel == null) {
                Logger.m11004w(VoiceService.TAG, "onRecordUpdateTime, error. model is null");
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayInfo(SpenVoiceData voiceData, int mediaInfo) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayPrepared(SpenVoiceData voiceData, int duration) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayComplete(SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            Logger.m11003i(VoiceService.TAG, "onPlayComplete, voiceData: " + voiceData);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(voiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    if (voiceModel2.isLastVoiceData(voiceData)) {
                        VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                        Intrinsics.checkNotNull(voiceModel3);
                        voiceModel3.setVoiceState(VoiceState.NONE);
                        this.this$0.stop();
                        return;
                    }
                    return;
                }
            }
            this.this$0.stop();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayError(SpenVoiceData voiceData, int errorCode) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            Logger.m11000e(VoiceService.TAG, "onPlayError, voiceData: " + voiceData + ", errorCode: " + errorCode);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(voiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.setVoiceState(VoiceState.ERROR);
                }
            }
            this.this$0.stop();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlaySeekComplete(SpenVoiceData voiceData, int position) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(voiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    int voiceDataIndex = voiceModel2.getVoiceDataIndex(voiceData);
                    VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel3);
                    voiceModel3.setRecordPlayingInfo(voiceDataIndex, position);
                    VoiceModel voiceModel4 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel4);
                    int voiceDataTimeByIndex = voiceModel4.getVoiceDataTimeByIndex(voiceDataIndex) + position;
                    if (this.this$0.mNotificationHelper == null || !VoiceService.mIsWorking) {
                        return;
                    }
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    Intrinsics.checkNotNull(voiceNotificationHelper);
                    voiceNotificationHelper.updatePlayTime(voiceDataTimeByIndex);
                }
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayStopped(SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            Logger.m11003i(VoiceService.TAG, "onPlayStopped voiceData: " + voiceData);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(voiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    voiceModel2.setVoiceState(VoiceState.NONE);
                }
            }
            this.this$0.stop();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayPaused(SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            Logger.m11003i(VoiceService.TAG, "onPlayPaused, voiceData: " + voiceData);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(voiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    if (voiceModel2.getMEraserState() == EraserState.ERASING) {
                        return;
                    }
                    VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel3);
                    VoiceState voiceState = VoiceState.PLAY_PAUSE;
                    voiceModel3.setVoiceState(voiceState);
                    VoiceModel voiceModel4 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel4);
                    int voiceDataIndex = voiceModel4.getVoiceDataIndex(voiceData);
                    VoiceModel voiceModel5 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel5);
                    int voiceDataTimeByIndex = voiceModel5.getVoiceDataTimeByIndex(voiceDataIndex);
                    VoiceModel voiceModel6 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel6);
                    int recordPlayingProgress = voiceModel6.getRecordPlayingProgress() + voiceDataTimeByIndex;
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    if (voiceNotificationHelper != null) {
                        voiceNotificationHelper.updatePlayStatus(recordPlayingProgress / 1000, voiceState);
                    }
                }
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayResumed(SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            Logger.m11003i(VoiceService.TAG, "onPlayResumed, voiceData: " + voiceData);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasCurrentVoiceData(voiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    if (voiceModel2.getMEraserState() == EraserState.ERASING) {
                        return;
                    }
                    VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel3);
                    VoiceState voiceState = VoiceState.PLAY_RESUMED;
                    voiceModel3.setVoiceState(voiceState);
                    VoiceModel voiceModel4 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel4);
                    int voiceDataIndex = voiceModel4.getVoiceDataIndex(voiceData);
                    VoiceModel voiceModel5 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel5);
                    int voiceDataTimeByIndex = voiceModel5.getVoiceDataTimeByIndex(voiceDataIndex);
                    VoiceModel voiceModel6 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel6);
                    int recordPlayingProgress = voiceModel6.getRecordPlayingProgress() + voiceDataTimeByIndex;
                    VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                    if (voiceNotificationHelper != null) {
                        voiceNotificationHelper.updatePlayStatus(recordPlayingProgress / 1000, voiceState);
                    }
                }
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnStateChanged
        public void onPlayStarted(SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            Logger.m11003i(VoiceService.TAG, "onPlayStarted, voiceData: " + voiceData);
            if (VoiceService.mVoiceModel != null) {
                VoiceModel voiceModel = VoiceService.mVoiceModel;
                Intrinsics.checkNotNull(voiceModel);
                if (voiceModel.hasVoiceData(voiceData)) {
                    VoiceModel voiceModel2 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel2);
                    if (voiceModel2.getMEraserState() == EraserState.ERASING) {
                        return;
                    }
                    VoiceModel voiceModel3 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel3);
                    if (!voiceModel3.isPlayingVoiceDataState() && this.this$0.mNotificationHelper != null) {
                        VoiceModel voiceModel4 = VoiceService.mVoiceModel;
                        Intrinsics.checkNotNull(voiceModel4);
                        int voiceDataIndex = voiceModel4.getVoiceDataIndex(voiceData);
                        VoiceModel voiceModel5 = VoiceService.mVoiceModel;
                        Intrinsics.checkNotNull(voiceModel5);
                        int voiceDataTimeByIndex = voiceModel5.getVoiceDataTimeByIndex(voiceDataIndex);
                        VoiceNotificationHelper voiceNotificationHelper = this.this$0.mNotificationHelper;
                        Intrinsics.checkNotNull(voiceNotificationHelper);
                        voiceNotificationHelper.updatePlayStatus(voiceDataTimeByIndex / 1000, VoiceState.PLAY_STARTED);
                    }
                    VoiceModel voiceModel6 = VoiceService.mVoiceModel;
                    Intrinsics.checkNotNull(voiceModel6);
                    voiceModel6.setPlayData(null, voiceData);
                }
            }
        }
    };

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fJ\u0006\u0010\u0018\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/composer/main/base/presenter/voice/VoiceService$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mAppContext", "Landroid/content/Context;", "mAppIntent", "Landroid/content/Intent;", "mIsWorking", "", "mVoiceModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/voice/VoiceModel;", "mObjectManager", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/composer/ObjectManager;", "lock", "startService", "", Constants.StringExtra.EXECUTE_TYPE_ACTIVITY, "Landroid/app/Activity;", "composerModel", "Lcom/samsung/android/support/senl/nt/composer/main/base/model/ComposerModel;", "objectManager", "stopService", "ntComposer_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void startService(@Nullable Activity activity, @Nullable ComposerModel composerModel, @Nullable ObjectManager objectManager) {
            synchronized (VoiceService.lock) {
                try {
                    String str = VoiceService.TAG;
                    Object obj = activity == null ? "null" : activity;
                    Logger.m11003i(str, "startService " + obj + " mIsWorking: " + VoiceService.mIsWorking);
                    if (activity != null && !VoiceService.mIsWorking && composerModel != null && composerModel.getVoiceModel() != null) {
                        activity.startService(new Intent(activity, (Class<?>) VoiceService.class));
                        VoiceService.mAppIntent = activity.getIntent();
                        VoiceService.mAppContext = activity.getApplicationContext();
                        VoiceService.mVoiceModel = composerModel.getVoiceModel();
                        VoiceService.mObjectManager = objectManager;
                        VoiceService.mIsWorking = true;
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void stopService() {
            synchronized (VoiceService.lock) {
                try {
                    Logger.m11003i(VoiceService.TAG, "stopService " + VoiceService.mAppContext);
                    if (VoiceService.mAppContext != null) {
                        Intent intent = new Intent(VoiceService.mAppContext, (Class<?>) VoiceService.class);
                        Context context = VoiceService.mAppContext;
                        Intrinsics.checkNotNull(context);
                        context.stopService(intent);
                    }
                    VoiceService.mVoiceModel = null;
                    VoiceService.mAppContext = null;
                    VoiceService.mObjectManager = null;
                    VoiceService.mIsWorking = false;
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        private Companion() {
        }
    }

    static {
        String strCreateTag = Logger.createTag("VoiceService");
        Intrinsics.checkNotNullExpressionValue(strCreateTag, "createTag(...)");
        TAG = strCreateTag;
        lock = new Object();
    }

    private final int getCurrentProgress() {
        VoiceModel voiceModel = mVoiceModel;
        Intrinsics.checkNotNull(voiceModel);
        if (voiceModel.isPlayingVoiceDataState()) {
            VoiceModel voiceModel2 = mVoiceModel;
            Intrinsics.checkNotNull(voiceModel2);
            VoiceModel voiceModel3 = mVoiceModel;
            Intrinsics.checkNotNull(voiceModel3);
            int voiceDataTimeByIndex = voiceModel2.getVoiceDataTimeByIndex(voiceModel3.getRecordPlayingIndex());
            VoiceModel voiceModel4 = mVoiceModel;
            Intrinsics.checkNotNull(voiceModel4);
            return voiceModel4.getRecordPlayingProgress() + voiceDataTimeByIndex;
        }
        VoiceModel voiceModel5 = mVoiceModel;
        Intrinsics.checkNotNull(voiceModel5);
        if (voiceModel5.isPlayingObjectVoiceState()) {
            VoiceModel voiceModel6 = mVoiceModel;
            Intrinsics.checkNotNull(voiceModel6);
            return voiceModel6.getAudioProgress();
        }
        VoiceModel voiceModel7 = mVoiceModel;
        Intrinsics.checkNotNull(voiceModel7);
        return voiceModel7.getRecordingTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stop() {
        Logger.m10999d(TAG, "stop self");
        stopSelf();
        synchronized (lock) {
            mVoiceModel = null;
            mAppContext = null;
            mObjectManager = null;
            mIsWorking = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Intent intent = mAppIntent;
        if (intent != null) {
            intent.putExtra(ComposerConstants.ARG_VOICE_NOTIFICATION_ON, true);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        Logger.m10999d(TAG, "onDestroy VoiceService");
        Intent intent = mAppIntent;
        if (intent != null) {
            intent.putExtra(ComposerConstants.ARG_VOICE_NOTIFICATION_ON, false);
        }
        synchronized (lock) {
            mIsWorking = false;
            Unit unit = Unit.INSTANCE;
        }
        VoiceManager.INSTANCE.removeStateListener(this.mVoiceStateChangedListener);
        VoiceNotificationHelper voiceNotificationHelper = this.mNotificationHelper;
        if (voiceNotificationHelper != null) {
            Intrinsics.checkNotNull(voiceNotificationHelper);
            voiceNotificationHelper.removeVoiceNotification();
            this.mNotificationHelper = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
        AbstractC14516b.m15114b(flags, startId, "onStartCommand flags = ", " startId = ", TAG);
        synchronized (lock) {
            try {
                try {
                    if (mAppContext != null && mVoiceModel != null && mObjectManager != null) {
                        if (this.mNotificationHelper == null) {
                            Context applicationContext = getApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                            ObjectManager objectManager = mObjectManager;
                            Intrinsics.checkNotNull(objectManager);
                            int currentProgress = getCurrentProgress();
                            VoiceModel voiceModel = mVoiceModel;
                            Intrinsics.checkNotNull(voiceModel);
                            this.mNotificationHelper = new VoiceNotificationHelper(applicationContext, true, true, objectManager, currentProgress, voiceModel);
                        }
                        VoiceModel voiceModel2 = mVoiceModel;
                        Intrinsics.checkNotNull(voiceModel2);
                        int i = voiceModel2.isPlayingVoiceState() ? 2 : 128;
                        VoiceNotificationHelper voiceNotificationHelper = this.mNotificationHelper;
                        Intrinsics.checkNotNull(voiceNotificationHelper);
                        if (voiceNotificationHelper.connectService(this, i)) {
                            synchronized (lock) {
                                mIsWorking = true;
                                Unit unit = Unit.INSTANCE;
                            }
                            VoiceManager.INSTANCE.setStateListener(this.mVoiceStateChangedListener);
                            return 1;
                        }
                    }
                } catch (UnsatisfiedLinkError e) {
                    Logger.m11000e(TAG, "onStartCommand error :" + e.getMessage());
                }
                stop();
                Unit unit2 = Unit.INSTANCE;
                return 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
