package com.samsung.android.sdk.composer.voice;

import android.annotation.SuppressLint;
import android.content.Context;
import com.google.android.gms.common.data.AbstractC4539a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.engine.SpenToastActionListener;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u000fH\u0007J\b\u0010\u0011\u001a\u00020\u000fH\u0007J\b\u0010\u0012\u001a\u00020\u000fH\u0007J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\u0007J\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u0007H\u0007J\b\u0010\u001a\u001a\u00020\u0007H\u0007J\b\u0010\u001b\u001a\u00020\u0007H\u0007J\b\u0010\u001c\u001a\u00020\u0007H\u0007J\b\u0010\u001d\u001a\u00020\u001eH\u0007J\b\u0010\u001f\u001a\u00020\u001eH\u0007J\b\u0010 \u001a\u00020\u000fH\u0007J\b\u0010!\u001a\u00020\u000fH\u0007J\b\u0010\"\u001a\u00020\u000fH\u0007J\u0012\u0010#\u001a\u00020\u000f2\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J \u0010&\u001a\u00020\u000f2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010(2\u0006\u0010)\u001a\u00020\u001eH\u0007J \u0010*\u001a\u00020\u000f2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010(2\u0006\u0010)\u001a\u00020\u001eH\u0007J\b\u0010+\u001a\u00020\u0007H\u0007J\b\u0010,\u001a\u00020\u0007H\u0007J\b\u0010-\u001a\u00020\u0007H\u0007J\n\u0010.\u001a\u0004\u0018\u00010%H\u0007J\n\u0010/\u001a\u0004\u0018\u00010\u0018H\u0007J\b\u00100\u001a\u00020\u001eH\u0007J\u0010\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u000203H\u0007J\b\u00104\u001a\u000203H\u0007J\u001a\u00105\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u001e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0010\u00106\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u001eH\u0007J\b\u00107\u001a\u00020\u0007H\u0007J\u0010\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020\u001eH\u0007J\u0018\u00108\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u001e2\u0006\u00109\u001a\u00020\u001eH\u0007J\u0018\u00108\u001a\u00020\u00072\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001eH\u0007J \u00108\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u001e2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020\u001eH\u0007J\u0010\u0010<\u001a\u00020\u00072\u0006\u0010=\u001a\u00020\u001eH\u0007J\u0012\u0010>\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010?H\u0007J\u0012\u0010@\u001a\u00020\u000f2\b\u0010A\u001a\u0004\u0018\u00010%H\u0007J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010C\u001a\u00020\u000fH\u0007J\b\u0010D\u001a\u00020\u000fH\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006E"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/VoiceManager;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "setContext", "", "context", "Landroid/content/Context;", "setStateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnStateChanged;", "removeStateListener", "isRecordingActivated", "", "isRecording", "isRecordingPaused", "isRecorderWorking", "setMediaRecorderConfig", "recorderConfig", "Lcom/samsung/android/sdk/composer/voice/SpenMediaRecorderConfig;", "startRecording", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "stopRecording", "cancelRecording", "pauseRecording", "resumeRecording", "getRecordProgress", "", "getMaxAmplitude", "isPlayingActivated", "isPlaying", "isPlayingPaused", "play", "voice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "initVoicePlayer", XmlErrorCodes.LIST, "Ljava/util/ArrayList;", "index", "playVoiceList", "stopPlaying", "resumePlaying", "pausePlaying", "getObjectVoice", "getVoiceData", "getPlayProgress", "setSpeed", "speed", "", "getSpeed", "insertVoiceData", "removeVoiceData", "updatePlayProgress", "seekTo", "time", "", "mode", "toastVoiceMessage", "errorCode", "setToastActionListener", "Lcom/samsung/android/sdk/pen/engine/SpenToastActionListener;", "isAddingValidated", "objectVoice", "setAudioEraserEnabled", "enabled", "isAudioEraserSupported", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class VoiceManager {

    @NotNull
    public static final VoiceManager INSTANCE = new VoiceManager();

    @NotNull
    private static final String TAG = "VoiceManager";

    private VoiceManager() {
    }

    @JvmStatic
    public static final void cancelRecording() {
        SpenNoteVoiceManager.cancelRecording();
    }

    @JvmStatic
    public static final int getMaxAmplitude() {
        return SpenNoteVoiceManager.INSTANCE.getMaxAmplitude();
    }

    @JvmStatic
    @Nullable
    public static final SpenObjectVoice getObjectVoice() {
        return SpenNoteVoiceManager.INSTANCE.getObjectVoice();
    }

    @JvmStatic
    public static final int getPlayProgress() {
        return SpenNoteVoiceManager.getPlayProgress();
    }

    @JvmStatic
    public static final int getRecordProgress() {
        return SpenNoteVoiceManager.INSTANCE.getRecordProgress();
    }

    @JvmStatic
    public static final float getSpeed() {
        return SpenNoteVoiceManager.INSTANCE.getSpeed();
    }

    @JvmStatic
    @Nullable
    public static final SpenVoiceData getVoiceData() {
        return SpenNoteVoiceManager.INSTANCE.getVoiceData();
    }

    @JvmStatic
    public static final boolean initVoicePlayer(@Nullable ArrayList<SpenVoiceData> list, int index) {
        return SpenNoteVoiceManager.INSTANCE.initVoicePlayer(list, index);
    }

    @JvmStatic
    public static final boolean insertVoiceData(int index, @Nullable SpenVoiceData voiceData) {
        return SpenNoteVoiceManager.INSTANCE.insertVoiceData(index, voiceData);
    }

    @JvmStatic
    public static final boolean isAddingValidated(@Nullable SpenObjectVoice objectVoice) {
        if (objectVoice == null) {
            return false;
        }
        return SpenNoteVoiceManager.INSTANCE.isAddingValidated(objectVoice);
    }

    @JvmStatic
    public static final boolean isAudioEraserSupported() {
        return SpenNoteVoiceManager.INSTANCE.isAudioEraserSupported();
    }

    @JvmStatic
    public static final boolean isPlaying() {
        return SpenNoteVoiceManager.INSTANCE.isPlaying();
    }

    @JvmStatic
    public static final boolean isPlayingActivated() {
        return SpenNoteVoiceManager.INSTANCE.isPlayingActivated();
    }

    @JvmStatic
    public static final boolean isPlayingPaused() {
        return SpenNoteVoiceManager.INSTANCE.isPlayingPaused();
    }

    @JvmStatic
    public static final boolean isRecorderWorking() {
        return SpenNoteVoiceManager.isRecorderWorking();
    }

    @JvmStatic
    public static final boolean isRecording() {
        return SpenNoteVoiceManager.INSTANCE.isRecording();
    }

    @JvmStatic
    public static final boolean isRecordingActivated() {
        return SpenNoteVoiceManager.INSTANCE.isRecordingActivated();
    }

    @JvmStatic
    public static final boolean isRecordingPaused() {
        return SpenNoteVoiceManager.INSTANCE.isRecordingPaused();
    }

    @JvmStatic
    public static final void pausePlaying() {
        SpenNoteVoiceManager.pausePlaying();
    }

    @JvmStatic
    public static final void pauseRecording() {
        SpenNoteVoiceManager.pauseRecording();
    }

    @JvmStatic
    public static final boolean play(@Nullable SpenObjectVoice voice) {
        return SpenNoteVoiceManager.INSTANCE.play(voice);
    }

    @JvmStatic
    public static final boolean playVoiceList(@Nullable ArrayList<SpenVoiceData> list, int index) {
        return SpenNoteVoiceManager.INSTANCE.playVoiceList(list, index);
    }

    @JvmStatic
    public static final boolean removeVoiceData(int index) {
        return SpenNoteVoiceManager.INSTANCE.removeVoiceData(index);
    }

    @JvmStatic
    public static final void resumePlaying() {
        SpenNoteVoiceManager.resumePlaying();
    }

    @JvmStatic
    public static final void resumeRecording() {
        SpenNoteVoiceManager.resumeRecording();
    }

    @JvmStatic
    public static final void seekTo(int time) {
        SpenNoteVoiceManager.seekTo(time);
    }

    @JvmStatic
    public static final void setAudioEraserEnabled(boolean enabled) {
        AbstractC4539a.m3208r("setAudioEraserEnabled enabled= ", TAG, enabled);
        SpenNoteVoiceManager.INSTANCE.setAudioEraserEnabled(enabled);
    }

    @JvmStatic
    public static final synchronized void setContext(@Nullable Context context) {
        try {
            if (context == null) {
                SpenNoteVoiceManager.INSTANCE.close();
            } else {
                SpenNoteVoiceManager.INSTANCE.construct(context);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @JvmStatic
    public static final void setMediaRecorderConfig(@NotNull SpenMediaRecorderConfig recorderConfig) {
        Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
        SpenNoteVoiceManager.INSTANCE.setMediaRecorderConfig(recorderConfig);
    }

    @JvmStatic
    public static final void setSpeed(float speed) {
        AbstractC4539a.m3205o("setSpeed() ", TAG, speed);
        SpenNoteVoiceManager.INSTANCE.setSpeed(speed);
    }

    @JvmStatic
    public static final void setToastActionListener(@Nullable SpenToastActionListener listener) {
        SpenNoteVoiceManager.INSTANCE.setToastActionListener(listener);
    }

    @JvmStatic
    public static final boolean startRecording(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        AbstractC6670b.m4756q("startRecording voiceData ", voiceData.getName(), TAG);
        return SpenNoteVoiceManager.INSTANCE.startRecording(voiceData);
    }

    @JvmStatic
    public static final void stopPlaying() {
        SpenNoteVoiceManager.stopPlaying();
    }

    @JvmStatic
    public static final void stopRecording() {
        SpenNoteVoiceManager.stopRecording();
    }

    @JvmStatic
    public static final void toastVoiceMessage(int errorCode) {
        SpenNoteVoiceManager.toastVoiceMessage(errorCode);
    }

    @JvmStatic
    public static final void updatePlayProgress() {
        SpenNoteVoiceManager.updatePlayProgress();
    }

    public final synchronized void removeStateListener(@Nullable SpenVoiceListenerManager.OnStateChanged listener) {
        if (listener == null) {
            return;
        }
        SpenVoiceListenerManager.removeStateListener(listener);
    }

    public final synchronized void setStateListener(@NotNull SpenVoiceListenerManager.OnStateChanged listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SpenVoiceListenerManager.setStateListener(listener);
    }

    @JvmStatic
    public static final void seekTo(int index, int time) {
        SpenNoteVoiceManager.INSTANCE.seekTo(index, time);
    }

    @JvmStatic
    public static final void seekTo(long time, int mode) {
        SpenNoteVoiceManager.INSTANCE.seekTo(time, mode);
    }

    @JvmStatic
    public static final void seekTo(int index, long time, int mode) {
        SpenNoteVoiceManager.INSTANCE.seekTo(index, time, mode);
    }
}
