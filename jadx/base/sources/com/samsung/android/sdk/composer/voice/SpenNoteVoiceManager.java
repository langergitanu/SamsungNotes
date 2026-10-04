package com.samsung.android.sdk.composer.voice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.composer.util.SpenComposerUtil;
import com.samsung.android.sdk.composer.voice.MediaPlayerInterface;
import com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.engine.SpenToastActionListener;
import com.samsung.android.sdk.pen.view.SpenConfiguration;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.spen.C7932R;
import com.samsung.android.spen.libinterface.MediaRecorderInterface;
import com.samsung.android.spen.libwrapper.FloatingFeatureWrapper;
import com.samsung.android.spen.libwrapper.MediaRecorderWrapper;
import com.samsung.android.spen.libwrapper.utils.PlatformException;
import com.samsung.android.spen.libwrapper.utils.PlatformUtils;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\bA\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u0015J\u0006\u0010,\u001a\u00020*J\u0006\u0010-\u001a\u00020*J\u0006\u0010.\u001a\u00020*J\u000e\u0010/\u001a\u00020*2\u0006\u00100\u001a\u00020(J\u000e\u00101\u001a\u00020*2\u0006\u00100\u001a\u00020(J\u0006\u00102\u001a\u00020\u0019J\u0006\u00103\u001a\u00020\u0019J\u0006\u00104\u001a\u00020\u0019J\b\u00105\u001a\u00020\u0019H\u0007J\u000e\u00106\u001a\u00020*2\u0006\u00107\u001a\u00020\u001eJ\u000e\u00108\u001a\u00020\u00192\u0006\u00109\u001a\u00020:J\b\u0010;\u001a\u00020*H\u0007J\b\u0010<\u001a\u00020*H\u0007J\b\u0010=\u001a\u00020*H\u0007J\b\u0010>\u001a\u00020*H\u0007J\u0006\u0010?\u001a\u00020\bJ\u0006\u0010@\u001a\u00020\bJ\b\u0010A\u001a\u00020\u0019H\u0002J\u0012\u00108\u001a\u00020\u00192\b\u0010B\u001a\u0004\u0018\u00010\u0005H\u0003J\b\u0010C\u001a\u00020*H\u0003J\b\u0010D\u001a\u00020*H\u0002J\u0006\u0010E\u001a\u00020\u0019J\u0006\u0010F\u001a\u00020\u0019J\u0006\u0010G\u001a\u00020\u0019J\u0010\u0010H\u001a\u00020\u00192\b\u0010I\u001a\u0004\u0018\u00010JJ\u001e\u0010K\u001a\u00020\u00192\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010M2\u0006\u0010N\u001a\u00020\bJ\u001e\u0010O\u001a\u00020\u00192\u000e\u0010L\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010M2\u0006\u0010N\u001a\u00020\bJ\b\u0010P\u001a\u00020*H\u0007J\b\u0010Q\u001a\u00020*H\u0007J\b\u0010R\u001a\u00020*H\u0007J\b\u0010S\u001a\u0004\u0018\u00010JJ\b\u0010T\u001a\u0004\u0018\u00010:J\b\u0010U\u001a\u00020\bH\u0007J\u000e\u0010V\u001a\u00020*2\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020XJ\u0018\u0010Z\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u00010:J\u000e\u0010[\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\bJ\b\u0010\\\u001a\u00020*H\u0007J\u0010\u0010]\u001a\u00020*2\u0006\u0010^\u001a\u00020\bH\u0007J\u0016\u0010]\u001a\u00020*2\u0006\u0010N\u001a\u00020\b2\u0006\u0010^\u001a\u00020\bJ\u0016\u0010]\u001a\u00020*2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\bJ\u001e\u0010]\u001a\u00020*2\u0006\u0010N\u001a\u00020\b2\u0006\u0010^\u001a\u00020_2\u0006\u0010`\u001a\u00020\bJ\u001a\u0010a\u001a\u00020\b2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010b\u001a\u00020_H\u0007J\u000e\u0010c\u001a\u00020*2\u0006\u0010d\u001a\u00020\u0019J\u000e\u0010e\u001a\u00020*2\u0006\u0010d\u001a\u00020\u0019J\u000e\u0010f\u001a\u00020\u00192\u0006\u0010g\u001a\u00020JJ\u0010\u0010h\u001a\u00020*2\b\u00100\u001a\u0004\u0018\u00010 J\u000e\u0010i\u001a\u00020*2\u0006\u0010j\u001a\u00020\u0019J\u0010\u0010k\u001a\u00020*2\u0006\u0010l\u001a\u00020\bH\u0007J\u0006\u0010m\u001a\u00020\u0019J\u0012\u0010n\u001a\u00020\u00192\b\u0010+\u001a\u0004\u0018\u00010\u0015H\u0002J\u0012\u0010H\u001a\u00020*2\b\u0010B\u001a\u0004\u0018\u00010\u0005H\u0003J\u0012\u0010o\u001a\u00020*2\b\u0010B\u001a\u0004\u0018\u00010\u0005H\u0003J\u0010\u0010p\u001a\u00020\u00192\u0006\u0010B\u001a\u00020\u0005H\u0002J \u0010q\u001a\u00020*2\u0006\u0010r\u001a\u00020\u00192\u0006\u0010s\u001a\u00020\u00192\u0006\u0010t\u001a\u00020\u0019H\u0002J\u0012\u0010u\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010v\u001a\u00020*H\u0003J\b\u0010w\u001a\u00020\u0019H\u0002J\u0010\u0010x\u001a\u00020\u00052\u0006\u0010^\u001a\u00020\bH\u0002J\u0010\u0010y\u001a\u00020*2\u0006\u0010b\u001a\u00020_H\u0003J\u0013\u0010z\u001a\u00020*2\b\u0010{\u001a\u0004\u0018\u00010\u0005H\u0083 J\u0011\u0010|\u001a\u00020*2\u0006\u0010l\u001a\u00020\bH\u0083 J-\u0010}\u001a\u00020*2\u0006\u0010~\u001a\u00020\b2\b\u0010g\u001a\u0004\u0018\u00010J2\b\u00109\u001a\u0004\u0018\u00010:2\u0006\u0010r\u001a\u00020\u0019H\u0083 J\u0011\u0010\u007f\u001a\u00020*2\u0006\u0010r\u001a\u00020\u0019H\u0083 J\u0013\u0010\u0080\u0001\u001a\u00020*2\u0007\u0010\u0081\u0001\u001a\u00020\bH\u0083 J\u0012\u0010\u0082\u0001\u001a\u00020*2\u0006\u0010r\u001a\u00020\u0019H\u0083 J\n\u0010\u0083\u0001\u001a\u00020*H\u0083 J\u0012\u0010\u0084\u0001\u001a\u00020*2\u0006\u0010r\u001a\u00020\u0019H\u0083 J\n\u0010\u0085\u0001\u001a\u00020*H\u0083 J\u0013\u0010\u0086\u0001\u001a\u00020*2\u0007\u0010\u0087\u0001\u001a\u00020\bH\u0083 J\u001e\u0010\u0088\u0001\u001a\u00020\u00192\b\u0010g\u001a\u0004\u0018\u00010J2\b\u00109\u001a\u0004\u0018\u00010:H\u0083 J\u001e\u0010\u0089\u0001\u001a\u00020\u00192\b\u0010g\u001a\u0004\u0018\u00010J2\b\u00109\u001a\u0004\u0018\u00010:H\u0083 J\n\u0010\u008a\u0001\u001a\u00020*H\u0083 J\n\u0010\u008b\u0001\u001a\u00020*H\u0083 J\n\u0010\u008c\u0001\u001a\u00020*H\u0083 J\n\u0010\u008d\u0001\u001a\u00020*H\u0083 J\n\u0010\u008e\u0001\u001a\u00020*H\u0083 J\u0013\u0010\u008f\u0001\u001a\u00020*2\u0007\u0010\u0090\u0001\u001a\u00020\bH\u0083 J\u0013\u0010\u0091\u0001\u001a\u00020*2\u0007\u0010\u0092\u0001\u001a\u00020\bH\u0083 J\u0013\u0010\u0093\u0001\u001a\u00020*2\u0007\u0010\u0090\u0001\u001a\u00020\bH\u0083 J\n\u0010\u0094\u0001\u001a\u00020\u0019H\u0083 J\n\u0010\u0095\u0001\u001a\u00020\u0019H\u0083 J\n\u0010\u0096\u0001\u001a\u00020\u0019H\u0083 J\n\u0010\u0097\u0001\u001a\u00020\u0019H\u0083 J\n\u0010\u0098\u0001\u001a\u00020*H\u0083 J\f\u0010\u0099\u0001\u001a\u0004\u0018\u00010JH\u0083 J\f\u0010\u009a\u0001\u001a\u0004\u0018\u00010:H\u0083 J\n\u0010\u009b\u0001\u001a\u00020\u0019H\u0083 J\u0013\u0010\u009c\u0001\u001a\u00020*2\u0007\u0010\u009d\u0001\u001a\u00020\u0019H\u0083 J\n\u0010\u009e\u0001\u001a\u00020\bH\u0083 J\u0012\u0010\u009f\u0001\u001a\u00020\u00192\u0006\u00109\u001a\u00020:H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 \u0001"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/SpenNoteVoiceManager;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "VOICE_PATH", "VOICE_MAX_DURATION", "", "VOICE_MAX_FILE_SIZE", "AUDIO_MIN_TIME", "TOAST_SAVED", "TOAST_ACCEPT_CALL", "REQUEST_STATE_NONE", "REQUEST_STATE_START", "REQUEST_STATE_RESUME", "mPath", "Ljava/io/File;", "mMediaPlayerInterface", "Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface;", "mContext", "Landroid/content/Context;", "mRecorder", "Lcom/samsung/android/spen/libwrapper/MediaRecorderWrapper;", "mIsAddStateListener", "", "mRecordTotalTime", "mBluetoothScoReceiver", "Lcom/samsung/android/sdk/composer/voice/BluetoothScoIntentReceiver;", "mMediaRecorderConfig", "Lcom/samsung/android/sdk/composer/voice/SpenMediaRecorderConfig;", "mToastActionListener", "Lcom/samsung/android/sdk/pen/engine/SpenToastActionListener;", "recorderListener", "Lcom/samsung/android/spen/libinterface/MediaRecorderInterface$MediaRecorderListener;", "mMediaPlayerListener", "Lcom/samsung/android/sdk/composer/voice/MediaPlayerInterface$MediaPlayerListener;", "mBluetoothScoStateListener", "Lcom/samsung/android/sdk/composer/voice/BluetoothScoStateListener;", "mVoiceListener", "Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnInnerStateChanged;", "construct", "", "context", "close", "registerBluetoothScoReceiver", "unregisterScoBluetoothReceiver", "addInnerStateListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeInnerStateListener", "isRecordingActivated", "isRecording", "isRecordingPaused", "isRecorderWorking", "setMediaRecorderConfig", "recorderConfig", "startRecording", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "stopRecording", "cancelRecording", "pauseRecording", "resumeRecording", "getRecordProgress", "getMaxAmplitude", "initRecorder", "filePath", "forceCancelRecording", "setRecorderListener", "isPlayingActivated", "isPlaying", "isPlayingPaused", "play", "voice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "initVoicePlayer", XmlErrorCodes.LIST, "Ljava/util/ArrayList;", "index", "playVoiceList", "stopPlaying", "resumePlaying", "pausePlaying", "getObjectVoice", "getVoiceData", "getPlayProgress", "setSpeed", "speed", "", "getSpeed", "insertVoiceData", "removeVoiceData", "updatePlayProgress", "seekTo", "time", "", "mode", "getPlayingTime", "timeStamp", "onAudioDevicesConnected", "isWiredHeadsetDevice", "onAudioDevicesDisconnected", "isAddingValidated", "objectVoice", "setToastActionListener", "setAudioEraserEnabled", "enabled", "toastVoiceMessage", "errorCode", "isAudioEraserSupported", "isSourceSeparator", "init", "initPlayer", "stopMediaPlayer", "isSwitchVoiceData", "isReleaseCurrentPlayer", "isReleaseNextPlayer", "getPlayTime", "emptyDirectory", "isSoundDetectorEnabled", "changeTimeToText", "requestSeekToByTimeStamp", "Native_VoiceManager_SetStoragePath", "storagePath", "Native_VoiceManager_Play_onError", "Native_VoiceManager_Play_onPrepared", XmlErrorCodes.DURATION, "Native_VoiceManager_Play_onStarted", "Native_VoiceManager_Play_onInfo", "mediaInfo", "Native_VoiceManager_Play_onPaused", "Native_VoiceManager_Play_onResumed", "Native_VoiceManager_Play_onStopped", "Native_VoiceManager_Play_onComplete", "Native_VoiceManager_Play_onSeekComplete", "position", "Native_VoiceManager_Play", "Native_VoiceManager_Init", "Native_VoiceManager_Record_onStarted", "Native_VoiceManager_Record_onStopped", "Native_VoiceManager_Record_onCancelled", "Native_VoiceManager_Record_onPaused", "Native_VoiceManager_Record_onResumed", "Native_VoiceManager_Record_onError", "what", "Native_VoiceManager_Record_onUpdateTime", "timeInSecond", "Native_VoiceManager_Info", "Native_VoiceManager_IsPlaying", "Native_VoiceManager_IsPlayingPaused", "Native_VoiceManager_IsRecording", "Native_VoiceManager_IsRecordingPaused", "Native_VoiceManager_SetStateListener", "Native_VoiceManager_GetObjectVoice", "Native_VoiceManager_GetVoiceData", "Native_VoiceManager_RequestMediaStartRecording", "Native_VoiceManager_RequestSetRecordingViaBluetooth", "enable", "Native_VoiceManager_GetStartBluetoothSCOState", "Native_VoiceManager_StartRecording", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
@SuppressLint({"StaticFieldLeak"})
public final class SpenNoteVoiceManager {
    private static final int AUDIO_MIN_TIME = 1000;
    private static final int REQUEST_STATE_NONE = 0;
    private static final int REQUEST_STATE_RESUME = 2;
    private static final int REQUEST_STATE_START = 1;

    @NotNull
    private static final String TAG = "SpenNoteVoiceManager";
    private static final int TOAST_ACCEPT_CALL = 2;
    private static final int TOAST_SAVED = 1;
    private static final int VOICE_MAX_DURATION = 21600000;
    private static final int VOICE_MAX_FILE_SIZE = 524288000;

    @NotNull
    private static final String VOICE_PATH = "/Voice";

    @Nullable
    private static BluetoothScoIntentReceiver mBluetoothScoReceiver;

    @Nullable
    private static Context mContext;
    private static boolean mIsAddStateListener;
    private static MediaPlayerInterface mMediaPlayerInterface;

    @Nullable
    private static SpenMediaRecorderConfig mMediaRecorderConfig;
    private static File mPath;
    private static int mRecordTotalTime;

    @Nullable
    private static MediaRecorderWrapper mRecorder;

    @Nullable
    private static SpenToastActionListener mToastActionListener;

    @NotNull
    public static final SpenNoteVoiceManager INSTANCE = new SpenNoteVoiceManager();

    @NotNull
    private static final MediaRecorderInterface.MediaRecorderListener recorderListener = new MediaRecorderInterface.MediaRecorderListener() { // from class: com.samsung.android.sdk.composer.voice.SpenNoteVoiceManager$recorderListener$1
        @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface.MediaRecorderListener
        public void onError() {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Record_onError(SpenVoiceListenerManager.ERROR_PREPARE_RECORDER);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface.MediaRecorderListener
        public void onPaused() {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Record_onPaused();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface.MediaRecorderListener
        public void onResumed() {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Record_onResumed();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface.MediaRecorderListener
        public void onStarted() {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Record_onStarted();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface.MediaRecorderListener
        public void onStopped() {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Record_onStopped();
                Unit unit = Unit.INSTANCE;
            }
        }
    };

    @NotNull
    private static final MediaPlayerInterface.MediaPlayerListener mMediaPlayerListener = new MediaPlayerInterface.MediaPlayerListener() { // from class: com.samsung.android.sdk.composer.voice.SpenNoteVoiceManager$mMediaPlayerListener$1
        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public boolean init(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
            boolean zNative_VoiceManager_Init;
            synchronized (this) {
                zNative_VoiceManager_Init = SpenNoteVoiceManager.Native_VoiceManager_Init(objectVoice, voiceData);
            }
            return zNative_VoiceManager_Init;
        }

        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public void onComplete() {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Play_onComplete();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public void onError(int errorCode) {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Play_onError(errorCode);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public void onInfo(int mediaInfo) {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Play_onInfo(mediaInfo);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public void onPaused(boolean isSwitchVoiceData) {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Play_onPaused(isSwitchVoiceData);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public void onPrepared(int duration, SpenObjectVoice objectVoice, SpenVoiceData voiceData, boolean isSwitchVoiceData) {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Play_onPrepared(duration, objectVoice, voiceData, isSwitchVoiceData);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public void onResumed() {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Play_onResumed();
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public void onSeekComplete(int position) {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Play_onSeekComplete(position);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public void onStarted(boolean isSwitchVoiceData) {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Play_onStarted(isSwitchVoiceData);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public void onStopped(boolean isSwitchVoiceData) {
            synchronized (this) {
                SpenNoteVoiceManager.Native_VoiceManager_Play_onStopped(isSwitchVoiceData);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.MediaPlayerInterface.MediaPlayerListener
        public boolean play(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
            boolean zNative_VoiceManager_Play;
            synchronized (this) {
                zNative_VoiceManager_Play = SpenNoteVoiceManager.Native_VoiceManager_Play(objectVoice, voiceData);
            }
            return zNative_VoiceManager_Play;
        }
    };

    @NotNull
    private static final BluetoothScoStateListener mBluetoothScoStateListener = new BluetoothScoStateListener() { // from class: com.samsung.android.sdk.composer.voice.SpenNoteVoiceManager$mBluetoothScoStateListener$1
        @Override // com.samsung.android.sdk.composer.voice.BluetoothScoStateListener
        public void onScoAudioConnected() {
            int iNative_VoiceManager_GetStartBluetoothSCOState = SpenNoteVoiceManager.Native_VoiceManager_GetStartBluetoothSCOState();
            AbstractC2322a.m1631u(iNative_VoiceManager_GetStartBluetoothSCOState, "onScoAudioConnected requestState: ", "SpenNoteVoiceManager");
            if (iNative_VoiceManager_GetStartBluetoothSCOState != 1) {
                if (iNative_VoiceManager_GetStartBluetoothSCOState == 2 && SpenNoteVoiceManager.INSTANCE.isRecordingPaused()) {
                    SpenNoteVoiceManager.resumeRecording();
                    return;
                }
                return;
            }
            if (SpenNoteVoiceManager.INSTANCE.isRecordingActivated()) {
                return;
            }
            Log.i("SpenNoteVoiceManager", "onScoAudioConnected START recording");
            SpenNoteVoiceManager.Native_VoiceManager_RequestMediaStartRecording();
        }

        @Override // com.samsung.android.sdk.composer.voice.BluetoothScoStateListener
        public void onScoAudioConnecting() {
        }

        @Override // com.samsung.android.sdk.composer.voice.BluetoothScoStateListener
        public void onScoAudioDisconnected() {
            int iNative_VoiceManager_GetStartBluetoothSCOState = SpenNoteVoiceManager.Native_VoiceManager_GetStartBluetoothSCOState();
            AbstractC2322a.m1631u(iNative_VoiceManager_GetStartBluetoothSCOState, "onScoAudioDisconnected requestState: ", "SpenNoteVoiceManager");
            if (iNative_VoiceManager_GetStartBluetoothSCOState == 1) {
                if (SpenNoteVoiceManager.INSTANCE.isRecordingActivated()) {
                    return;
                }
                Log.i("SpenNoteVoiceManager", "onScoAudioDisconnected START recording");
                SpenNoteVoiceManager.Native_VoiceManager_RequestMediaStartRecording();
                return;
            }
            if (iNative_VoiceManager_GetStartBluetoothSCOState != 2) {
                if (SpenNoteVoiceManager.INSTANCE.isRecording()) {
                    SpenNoteVoiceManager.pauseRecording();
                }
            } else if (SpenNoteVoiceManager.INSTANCE.isRecordingPaused()) {
                SpenNoteVoiceManager.resumeRecording();
            }
        }

        @Override // com.samsung.android.sdk.composer.voice.BluetoothScoStateListener
        public void onScoAudioError() {
            int iNative_VoiceManager_GetStartBluetoothSCOState = SpenNoteVoiceManager.Native_VoiceManager_GetStartBluetoothSCOState();
            AbstractC2322a.m1631u(iNative_VoiceManager_GetStartBluetoothSCOState, "onScoAudioError requestState: ", "SpenNoteVoiceManager");
            if (iNative_VoiceManager_GetStartBluetoothSCOState != 1) {
                if (iNative_VoiceManager_GetStartBluetoothSCOState != 2) {
                    if (SpenNoteVoiceManager.INSTANCE.isRecording()) {
                        SpenNoteVoiceManager.pauseRecording();
                    }
                } else if (SpenNoteVoiceManager.INSTANCE.isRecordingPaused()) {
                    SpenNoteVoiceManager.resumeRecording();
                }
            } else if (!SpenNoteVoiceManager.INSTANCE.isRecordingActivated()) {
                SpenNoteVoiceManager.Native_VoiceManager_RequestMediaStartRecording();
            }
            SpenNoteVoiceManager.Native_VoiceManager_RequestSetRecordingViaBluetooth(false);
        }
    };

    @NotNull
    private static SpenVoiceListenerManager.OnInnerStateChanged mVoiceListener = new SpenVoiceListenerManager.OnInnerStateChanged() { // from class: com.samsung.android.sdk.composer.voice.SpenNoteVoiceManager$mVoiceListener$1
        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onInfo(SpenObjectVoice contentVoice, int what) {
            Intrinsics.checkNotNullParameter(contentVoice, "contentVoice");
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onPlayComplete(SpenObjectVoice contentVoice, SpenVoiceData voiceData) {
            MediaKeyEventManager.INSTANCE.getInstance().releaseMediaSession();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onPlayError(SpenObjectVoice contentVoice, SpenVoiceData voiceData, int errorCode) {
            MediaKeyEventManager.INSTANCE.getInstance().releaseMediaSession();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onPlayInfo(SpenObjectVoice objectVoice, SpenVoiceData voiceData, int mediaInfo) {
            MediaKeyEventManager.INSTANCE.getInstance().createMediaSession(SpenNoteVoiceManager.mContext, false);
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onPlayPaused(SpenObjectVoice contentVoice, SpenVoiceData voiceData) {
            MediaKeyEventManager.INSTANCE.getInstance().createMediaSession(SpenNoteVoiceManager.mContext, false);
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onPlayPrepared(SpenObjectVoice contentVoice, SpenVoiceData voiceData, int duration) {
            MediaKeyEventManager.INSTANCE.getInstance().createMediaSession(SpenNoteVoiceManager.mContext, false);
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onPlayResumed(SpenObjectVoice contentVoice, SpenVoiceData voiceData) {
            MediaKeyEventManager.INSTANCE.getInstance().createMediaSession(SpenNoteVoiceManager.mContext, false);
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onPlaySeekComplete(SpenObjectVoice contentVoice, SpenVoiceData voiceData, int position) {
            MediaKeyEventManager.INSTANCE.getInstance().createMediaSession(SpenNoteVoiceManager.mContext, false);
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onPlayStarted(SpenObjectVoice contentVoice, SpenVoiceData voiceData) {
            MediaKeyEventManager.INSTANCE.getInstance().createMediaSession(SpenNoteVoiceManager.mContext, false);
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onPlayStopped(SpenObjectVoice contentVoice, SpenVoiceData voiceData) {
            MediaKeyEventManager.INSTANCE.getInstance().releaseMediaSession();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onRecordCancelled(SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            MediaKeyEventManager.INSTANCE.getInstance().releaseMediaSession();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onRecordError(SpenVoiceData voiceData, int errorCode) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            MediaKeyEventManager.INSTANCE.getInstance().releaseMediaSession();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onRecordPaused(SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            MediaKeyEventManager.INSTANCE.getInstance().createMediaSession(SpenNoteVoiceManager.mContext, true);
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onRecordResumed(SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            MediaKeyEventManager.INSTANCE.getInstance().createMediaSession(SpenNoteVoiceManager.mContext, true);
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onRecordStarted(SpenVoiceData voiceData, String cachePath) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            Intrinsics.checkNotNullParameter(cachePath, "cachePath");
            MediaKeyEventManager.INSTANCE.getInstance().createMediaSession(SpenNoteVoiceManager.mContext, true);
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onRecordStopped(SpenVoiceData voiceData) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
            MediaKeyEventManager.INSTANCE.getInstance().releaseMediaSession();
        }

        @Override // com.samsung.android.sdk.composer.voice.SpenVoiceListenerManager.OnInnerStateChanged
        public void onRecordUpdateTime(SpenVoiceData voiceData, int timeInSecond) {
            Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        }
    };

    private SpenNoteVoiceManager() {
    }

    @JvmStatic
    private static final native SpenObjectVoice Native_VoiceManager_GetObjectVoice();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native int Native_VoiceManager_GetStartBluetoothSCOState();

    @JvmStatic
    private static final native SpenVoiceData Native_VoiceManager_GetVoiceData();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Info(int what);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_VoiceManager_Init(SpenObjectVoice objectVoice, SpenVoiceData voiceData);

    @JvmStatic
    private static final native boolean Native_VoiceManager_IsPlaying();

    @JvmStatic
    private static final native boolean Native_VoiceManager_IsPlayingPaused();

    @JvmStatic
    private static final native boolean Native_VoiceManager_IsRecording();

    @JvmStatic
    private static final native boolean Native_VoiceManager_IsRecordingPaused();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_VoiceManager_Play(SpenObjectVoice objectVoice, SpenVoiceData voiceData);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Play_onComplete();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Play_onError(int errorCode);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Play_onInfo(int mediaInfo);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Play_onPaused(boolean isSwitchVoiceData);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Play_onPrepared(int duration, SpenObjectVoice objectVoice, SpenVoiceData voiceData, boolean isSwitchVoiceData);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Play_onResumed();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Play_onSeekComplete(int position);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Play_onStarted(boolean isSwitchVoiceData);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Play_onStopped(boolean isSwitchVoiceData);

    @JvmStatic
    private static final native void Native_VoiceManager_Record_onCancelled();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Record_onError(int what);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Record_onPaused();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Record_onResumed();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Record_onStarted();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Record_onStopped();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_Record_onUpdateTime(int timeInSecond);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native boolean Native_VoiceManager_RequestMediaStartRecording();

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_VoiceManager_RequestSetRecordingViaBluetooth(boolean enable);

    @JvmStatic
    private static final native void Native_VoiceManager_SetStateListener();

    @JvmStatic
    private static final native void Native_VoiceManager_SetStoragePath(String storagePath);

    @JvmStatic
    private static final native boolean Native_VoiceManager_StartRecording(SpenVoiceData voiceData);

    @JvmStatic
    public static final synchronized void cancelRecording() {
        try {
            MediaRecorderWrapper mediaRecorderWrapper = mRecorder;
            if (mediaRecorderWrapper != null) {
                try {
                    SpenNoteVoiceManager spenNoteVoiceManager = INSTANCE;
                    if (spenNoteVoiceManager.isRecording() || spenNoteVoiceManager.isRecordingPaused()) {
                        mediaRecorderWrapper.cancel();
                        Native_VoiceManager_Record_onCancelled();
                    }
                } catch (PlatformException unused) {
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final String changeTimeToText(int time) {
        int i = time % 60;
        int i2 = time / 60;
        int i4 = i2 % 60;
        int i5 = i2 / 60;
        StringBuffer stringBuffer = new StringBuffer();
        if (i5 < 10) {
            stringBuffer.append(0);
        }
        stringBuffer.append(i5);
        stringBuffer.append(':');
        if (i4 < 10) {
            stringBuffer.append(0);
        }
        stringBuffer.append(i4);
        stringBuffer.append(':');
        if (i < 10) {
            stringBuffer.append(0);
        }
        stringBuffer.append(i);
        String string = stringBuffer.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    @JvmStatic
    private static final void emptyDirectory() {
        File file = mPath;
        if (file == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPath");
            file = null;
        }
        if (file.isDirectory()) {
            File file2 = mPath;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mPath");
                file2 = null;
            }
            String[] list = file2.list();
            if (list == null) {
                return;
            }
            Iterator it = ArrayIteratorKt.iterator(list);
            while (it.hasNext()) {
                String str = (String) it.next();
                File file3 = mPath;
                if (file3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPath");
                    file3 = null;
                }
                new File(file3, str).delete();
            }
        }
    }

    @JvmStatic
    private static final synchronized void forceCancelRecording() {
        MediaRecorderWrapper mediaRecorderWrapper = mRecorder;
        if (mediaRecorderWrapper != null) {
            try {
                mediaRecorderWrapper.cancel();
                Native_VoiceManager_Record_onCancelled();
            } catch (PlatformException unused) {
            }
        }
    }

    @JvmStatic
    public static final synchronized int getPlayProgress() {
        MediaPlayerInterface mediaPlayerInterface;
        try {
            mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return mediaPlayerInterface.getPlayProgress();
    }

    @JvmStatic
    public static final synchronized int getPlayTime(@Nullable String filePath) {
        MediaPlayer mediaPlayer;
        if (filePath == null) {
            return -1;
        }
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(filePath);
                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                Intrinsics.checkNotNull(strExtractMetadata);
                int i = Integer.parseInt(strExtractMetadata);
                mediaMetadataRetriever.release();
                return i;
            } catch (Exception unused) {
                Intrinsics.checkNotNull(mediaMetadataRetriever);
                mediaMetadataRetriever.release();
                mediaPlayer = new MediaPlayer();
                try {
                    try {
                        mediaPlayer.reset();
                        mediaPlayer.setDataSource(filePath);
                        mediaPlayer.prepare();
                        int duration = mediaPlayer.getDuration();
                        mediaPlayer.reset();
                        mediaPlayer.release();
                        return duration;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return -1;
                    }
                } finally {
                    mediaPlayer.release();
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            mediaPlayer = new MediaPlayer();
            mediaPlayer.reset();
            mediaPlayer.setDataSource(filePath);
            mediaPlayer.prepare();
            int duration2 = mediaPlayer.getDuration();
            mediaPlayer.reset();
            mediaPlayer.release();
            return duration2;
        }
    }

    @JvmStatic
    public static final int getPlayingTime(@Nullable SpenVoiceData voiceData, long timeStamp) {
        long j;
        if (voiceData == null) {
            Log.e(TAG, "getPlayingTime() voiceData is null");
            return -1;
        }
        ArrayList<SpenVoiceData.VoiceProperty> voicePropertyList = voiceData.getVoicePropertyList();
        if (voicePropertyList == null) {
            Log.e(TAG, "getPlayingTime() voicePropertyList is null");
            return -1;
        }
        int size = voicePropertyList.size();
        int i = 0;
        long timeStamp2 = 0;
        long timeStamp3 = 0;
        while (true) {
            if (i >= size) {
                j = timeStamp2 / ((long) 1000);
                break;
            }
            SpenVoiceData.VoiceProperty voiceProperty = voicePropertyList.get(i);
            Intrinsics.checkNotNullExpressionValue(voiceProperty, "get(...)");
            SpenVoiceData.VoiceProperty voiceProperty2 = voiceProperty;
            int i2 = voiceProperty2.action;
            if (i2 == 1) {
                timeStamp2 = timeStamp - voiceProperty2.getTimeStamp();
            } else if (i2 != 2) {
                if (i2 != 3) {
                    continue;
                } else {
                    if (timeStamp3 == 0) {
                        j = timeStamp2 / ((long) 1000);
                        break;
                    }
                    timeStamp2 -= voiceProperty2.getTimeStamp() - timeStamp3;
                    timeStamp3 = 0;
                }
            } else if (timeStamp >= voiceProperty2.getTimeStamp()) {
                timeStamp3 = voiceProperty2.getTimeStamp();
            }
            i++;
        }
        return (int) j;
    }

    @JvmStatic
    private static final synchronized void init(String filePath) {
        if (filePath == null) {
            return;
        }
        try {
            SpenNoteVoiceManager spenNoteVoiceManager = INSTANCE;
            if (spenNoteVoiceManager.isRecording()) {
                stopRecording();
            }
            if (spenNoteVoiceManager.isPlaying()) {
                spenNoteVoiceManager.stopMediaPlayer(false, false, false);
            }
            Log.i(TAG, "filePath: ".concat(filePath));
            if (spenNoteVoiceManager.initPlayer(filePath)) {
                Log.i(TAG, "init successful filePath: ".concat(filePath));
            } else {
                Native_VoiceManager_Play_onError(SpenVoiceListenerManager.ERROR_INITIALIZE_PLAYER);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized boolean initPlayer(String filePath) {
        MediaPlayerInterface mediaPlayerInterface;
        try {
            if (!mIsAddStateListener) {
                Native_VoiceManager_SetStateListener();
                mIsAddStateListener = true;
            }
            mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return mediaPlayerInterface.initMediaPlayer(filePath);
    }

    private final synchronized boolean initRecorder() {
        try {
            try {
                if (!mIsAddStateListener) {
                    Native_VoiceManager_SetStateListener();
                    mIsAddStateListener = true;
                }
                if (mRecorder != null && !isRecordingActivated()) {
                    try {
                        MediaRecorderWrapper mediaRecorderWrapper = mRecorder;
                        Intrinsics.checkNotNull(mediaRecorderWrapper);
                        mediaRecorderWrapper.reset();
                        MediaRecorderWrapper mediaRecorderWrapper2 = mRecorder;
                        Intrinsics.checkNotNull(mediaRecorderWrapper2);
                        mediaRecorderWrapper2.release();
                        mRecorder = null;
                    } catch (PlatformException unused) {
                        mRecorder = null;
                    }
                }
                mRecorder = MediaRecorderWrapper.create(mContext);
                setRecorderListener();
            } catch (PlatformException unused2) {
                Log.i(TAG, "Use AndroidMediaRecorder");
                try {
                    mRecorder = MediaRecorderWrapper.create(new AndroidMediaRecorder());
                    setRecorderListener();
                } catch (PlatformException e) {
                    e.printStackTrace();
                    return false;
                }
            }
            if (mMediaRecorderConfig == null) {
                mMediaRecorderConfig = new SpenMediaRecorderConfig();
            }
            MediaRecorderWrapper mediaRecorderWrapper3 = mRecorder;
            if (mediaRecorderWrapper3 != null) {
                SpenMediaRecorderConfig spenMediaRecorderConfig = mMediaRecorderConfig;
                Intrinsics.checkNotNull(spenMediaRecorderConfig);
                mediaRecorderWrapper3.setMediaRecorderConfig(spenMediaRecorderConfig);
            }
        } catch (Throwable th) {
            throw th;
        }
        return true;
    }

    @JvmStatic
    public static final synchronized boolean isRecorderWorking() {
        try {
            SpenNoteVoiceManager spenNoteVoiceManager = INSTANCE;
            if (spenNoteVoiceManager.isSoundDetectorEnabled()) {
                Log.i("voice", "isSoundDetectorEnabled false");
                return true;
            }
            if (mRecorder == null) {
                spenNoteVoiceManager.initRecorder();
            }
            boolean zIsRecorderWorking = MediaRecorderWrapper.isRecorderWorking();
            Log.i(TAG, "isRecorderWorking :" + zIsRecorderWorking);
            return zIsRecorderWorking;
        } catch (PlatformException e) {
            Log.e(TAG, "isRecorderWorking error: " + e);
            return false;
        }
    }

    private final boolean isSoundDetectorEnabled() {
        Context context = mContext;
        if (context == null) {
            return false;
        }
        Intrinsics.checkNotNull(context);
        if (Settings.System.getInt(context.getContentResolver(), "sound_detector", 0) != 1) {
            Context context2 = mContext;
            Intrinsics.checkNotNull(context2);
            if (Settings.System.getInt(context2.getContentResolver(), "doorbell_detector", 0) != 1) {
                return false;
            }
        }
        return true;
    }

    private final boolean isSourceSeparator(Context context) {
        try {
            String string = FloatingFeatureWrapper.create(context).getString("SEC_FLOATING_FEATURE_AUDIO_CONFIG_MULTISOURCE_SEPARATOR");
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return StringsKt.m14162r(string, "SourceSeparator");
        } catch (PlatformException e) {
            Log.e(TAG, "isSourceSeparator exception: " + e);
            return false;
        }
    }

    @JvmStatic
    public static final synchronized void pausePlaying() {
        try {
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.pausePlaying();
        } catch (Throwable th) {
            throw th;
        }
    }

    @JvmStatic
    public static final synchronized void pauseRecording() {
        MediaRecorderWrapper mediaRecorderWrapper = mRecorder;
        if (mediaRecorderWrapper != null) {
            try {
                if (INSTANCE.isRecording()) {
                    mediaRecorderWrapper.pause(recorderListener);
                }
            } catch (PlatformException unused) {
            }
        }
    }

    @JvmStatic
    private static final synchronized void requestSeekToByTimeStamp(long timeStamp) {
        try {
            Log.i(TAG, "requestSeekToByTimeStamp() timeStamp: " + timeStamp);
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.requestSeekToByTimeStamp(timeStamp);
        } catch (Throwable th) {
            throw th;
        }
    }

    @JvmStatic
    public static final synchronized void resumePlaying() {
        try {
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.resumePlaying();
        } catch (Throwable th) {
            throw th;
        }
    }

    @JvmStatic
    public static final synchronized void resumeRecording() {
        MediaRecorderWrapper mediaRecorderWrapper = mRecorder;
        if (mediaRecorderWrapper != null) {
            try {
                if (INSTANCE.isRecordingPaused()) {
                    mediaRecorderWrapper.resume(recorderListener);
                }
            } catch (PlatformException unused) {
            }
        }
    }

    @JvmStatic
    public static final synchronized void seekTo(int time) {
        try {
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.seekTo(time);
        } catch (Throwable th) {
            throw th;
        }
    }

    private final void setRecorderListener() throws PlatformException {
        MediaRecorderWrapper mediaRecorderWrapper = mRecorder;
        if (mediaRecorderWrapper != null) {
            mediaRecorderWrapper.setActionListener(new MediaRecorderInterface.ActionListener() { // from class: com.samsung.android.sdk.composer.voice.SpenNoteVoiceManager$setRecorderListener$1$1
                @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface.ActionListener
                public void onError(int what, int args) {
                    synchronized (this) {
                        Log.i("SpenNoteVoiceManager", "onError] what: " + what + ", args: " + args);
                        SpenNoteVoiceManager.Native_VoiceManager_Record_onError(what);
                        Unit unit = Unit.INSTANCE;
                    }
                }

                @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface.ActionListener
                public void onInfo(int what, int args) {
                    synchronized (this) {
                        Log.i("SpenNoteVoiceManager", "onInfo] what: " + what + ", args: " + args);
                        SpenNoteVoiceManager.Native_VoiceManager_Info(what);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            });
            mediaRecorderWrapper.setTimeListener(new MediaRecorderInterface.TimeListener() { // from class: com.samsung.android.sdk.composer.voice.SpenNoteVoiceManager$setRecorderListener$1$2
                @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface.TimeListener
                public void onUpdateTime(int i) {
                    synchronized (this) {
                        SpenNoteVoiceManager.mRecordTotalTime = i;
                        SpenNoteVoiceManager.Native_VoiceManager_Record_onUpdateTime(i);
                        Unit unit = Unit.INSTANCE;
                    }
                }
            });
        }
    }

    private final synchronized void stopMediaPlayer(boolean isSwitchVoiceData, boolean isReleaseCurrentPlayer, boolean isReleaseNextPlayer) {
        try {
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.stopMediaPlayer(isSwitchVoiceData, isReleaseCurrentPlayer, isReleaseNextPlayer);
        } catch (Throwable th) {
            throw th;
        }
    }

    @JvmStatic
    public static final synchronized void stopPlaying() {
        try {
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.stopPlaying();
        } catch (Throwable th) {
            throw th;
        }
    }

    @JvmStatic
    public static final synchronized void stopRecording() {
        MediaRecorderWrapper mediaRecorderWrapper = mRecorder;
        if (mediaRecorderWrapper != null) {
            try {
                if (INSTANCE.isRecordingActivated()) {
                    mediaRecorderWrapper.stop(recorderListener);
                }
            } catch (PlatformException unused) {
            }
        }
    }

    @JvmStatic
    public static final void toastVoiceMessage(int errorCode) {
        int i;
        if (errorCode == 1) {
            i = C7932R.string.voice_record_saved;
        } else if (errorCode == 2) {
            i = C7932R.string.f5433xf2f8863c;
        } else if (errorCode == 5001) {
            i = C7932R.string.voice_error_not_enough_time;
        } else if (errorCode == 5002) {
            i = C7932R.string.voice_error_prepare_failed;
        } else if (errorCode == 5010) {
            i = C7932R.string.voice_warning_call_isactive;
        } else if (errorCode == 5011) {
            i = C7932R.string.voice_unable_to_play_during_call;
        } else if (errorCode == 5014) {
            i = C7932R.string.voice_unsupported_file_type;
        } else if (errorCode == 10001) {
            i = C7932R.string.voice_warning_earphone_plugged;
        } else if (errorCode != 10002) {
            switch (errorCode) {
                case SpenVoiceListenerManager.ERROR_FILE_READ_PLAY_TIME /* 5005 */:
                    i = C7932R.string.voice_unsupported_file;
                    break;
                case SpenVoiceListenerManager.ERROR_ALREADY_RECORDING /* 5006 */:
                    i = C7932R.string.voice_unable_to_play_voice_recording_while_recording;
                    break;
                case SpenVoiceListenerManager.ERROR_ALREADY_RECORDER_WORKING /* 5007 */:
                    i = C7932R.string.voice_error_other_app_is_already_recording;
                    break;
                default:
                    i = -1;
                    break;
            }
        } else {
            i = C7932R.string.voice_warning_earphone_plugged_while_recording;
        }
        if (mContext == null || i == -1) {
            return;
        }
        SpenToastActionListener spenToastActionListener = mToastActionListener;
        if (spenToastActionListener != null) {
            Intrinsics.checkNotNull(spenToastActionListener);
            Context context = mContext;
            Intrinsics.checkNotNull(context);
            spenToastActionListener.show(context.getResources().getText(i), 1);
            return;
        }
        if (Build.VERSION.SDK_INT > 30) {
            Context context2 = mContext;
            Intrinsics.checkNotNull(context2);
            Toast.makeText(context2, context2.getResources().getText(i), 1).show();
            return;
        }
        View viewInflate = LayoutInflater.from(mContext).inflate(C7932R.layout.composer_toast_popup, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(C7932R.id.toast_text);
        Context context3 = mContext;
        Intrinsics.checkNotNull(context3);
        textView.setText(context3.getResources().getText(i));
        Toast toast = new Toast(mContext);
        toast.setView(viewInflate);
        toast.setDuration(1);
        toast.show();
    }

    @JvmStatic
    public static final synchronized void updatePlayProgress() {
        try {
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.updatePlayProgress();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void addInnerStateListener(@NotNull SpenVoiceListenerManager.OnInnerStateChanged listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SpenVoiceListenerManager.addInnerStateListener(listener);
    }

    public final synchronized void close() {
        unregisterScoBluetoothReceiver();
        MediaKeyEventManager.INSTANCE.getInstance().removeInnerStateListener();
        removeInnerStateListener(mVoiceListener);
        mContext = null;
        mBluetoothScoReceiver = null;
        mMediaRecorderConfig = null;
        mToastActionListener = null;
    }

    public final synchronized void construct(@NotNull Context context) {
        File cacheDir;
        File filesDir;
        try {
            Intrinsics.checkNotNullParameter(context, "context");
            mContext = context.getApplicationContext();
            MediaKeyEventManager.INSTANCE.getInstance().addInnerStateListener();
            addInnerStateListener(mVoiceListener);
            Context context2 = mContext;
            MediaPlayerInterface mediaPlayerInterface = null;
            String str = ((context2 == null || (filesDir = context2.getFilesDir()) == null) ? null : filesDir.getAbsolutePath()) + VOICE_PATH;
            File file = new File(str);
            mPath = file;
            if (!file.exists()) {
                File file2 = mPath;
                if (file2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPath");
                    file2 = null;
                }
                if (!file2.mkdirs()) {
                    Log.i(TAG, "construct - Failed to mkdirs");
                    Native_VoiceManager_SetStoragePath(null);
                    return;
                }
            }
            Native_VoiceManager_SetStoragePath(str);
            if (!mIsAddStateListener) {
                Native_VoiceManager_SetStateListener();
                mIsAddStateListener = true;
            }
            boolean zIsAudioEraserSupported = isAudioEraserSupported();
            Log.i(TAG, "construct isSupportAudioEraser= " + zIsAudioEraserSupported);
            MediaPlayerInterface spenSemMediaPlayer = zIsAudioEraserSupported ? new SpenSemMediaPlayer(mMediaPlayerListener) : new SpenAndroidMediaPlayer(mMediaPlayerListener);
            mMediaPlayerInterface = spenSemMediaPlayer;
            if (spenSemMediaPlayer instanceof SpenSemMediaPlayer) {
                Context context3 = mContext;
                String str2 = ((context3 == null || (cacheDir = context3.getCacheDir()) == null) ? null : cacheDir.getAbsolutePath()) + VOICE_PATH;
                MediaPlayerInterface mediaPlayerInterface2 = mMediaPlayerInterface;
                if (mediaPlayerInterface2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                } else {
                    mediaPlayerInterface = mediaPlayerInterface2;
                }
                ((SpenSemMediaPlayer) mediaPlayerInterface).setAudioEraserCachePath(str2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized int getMaxAmplitude() {
        try {
            if (mRecorder != null && isRecording()) {
                MediaRecorderWrapper mediaRecorderWrapper = mRecorder;
                Intrinsics.checkNotNull(mediaRecorderWrapper);
                return mediaRecorderWrapper.getMaxAmplitude();
            }
        } catch (PlatformException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Nullable
    public final SpenObjectVoice getObjectVoice() {
        return Native_VoiceManager_GetObjectVoice();
    }

    public final synchronized int getRecordProgress() {
        if (mRecorder == null || !isRecordingActivated()) {
            return 0;
        }
        return mRecordTotalTime;
    }

    public final synchronized float getSpeed() {
        MediaPlayerInterface mediaPlayerInterface;
        try {
            mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return mediaPlayerInterface.getSpeed();
    }

    @Nullable
    public final SpenVoiceData getVoiceData() {
        return Native_VoiceManager_GetVoiceData();
    }

    public final synchronized boolean initVoicePlayer(@Nullable ArrayList<SpenVoiceData> list, int index) {
        MediaPlayerInterface mediaPlayerInterface;
        try {
            mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return mediaPlayerInterface.initVoicePlayer(list, index);
    }

    public final synchronized boolean insertVoiceData(int index, @Nullable SpenVoiceData voiceData) {
        MediaPlayerInterface mediaPlayerInterface;
        try {
            mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return mediaPlayerInterface.insertVoiceData(index, voiceData);
    }

    public final boolean isAddingValidated(@NotNull SpenObjectVoice objectVoice) {
        Intrinsics.checkNotNullParameter(objectVoice, "objectVoice");
        String attachedFile = objectVoice.getAttachedFile();
        if (attachedFile == null || attachedFile.length() == 0) {
            return false;
        }
        String playTime = objectVoice.getPlayTime();
        if (playTime != null && playTime.length() != 0) {
            return true;
        }
        int playTime2 = getPlayTime(attachedFile);
        if (playTime2 < 1000) {
            return false;
        }
        objectVoice.setPlayTime(changeTimeToText(playTime2 / 1000));
        return true;
    }

    public final boolean isAudioEraserSupported() {
        Integer configAiVersion;
        if (!PlatformUtils.isSemDevice(mContext)) {
            return false;
        }
        SpenConfiguration.Companion companion = SpenConfiguration.INSTANCE;
        if (companion.getOneUiVersion(mContext) >= 80000 && isSourceSeparator(mContext) && (configAiVersion = companion.getConfigAiVersion(mContext)) != null) {
            Log.i(TAG, "isAudioEraserSupported configAiVersion: " + configAiVersion);
            if (configAiVersion.intValue() >= 20253) {
                return true;
            }
        }
        return false;
    }

    public final boolean isPlaying() {
        return Native_VoiceManager_IsPlaying();
    }

    public final boolean isPlayingActivated() {
        return Native_VoiceManager_IsPlaying() || Native_VoiceManager_IsPlayingPaused();
    }

    public final boolean isPlayingPaused() {
        return Native_VoiceManager_IsPlayingPaused();
    }

    public final boolean isRecording() {
        return Native_VoiceManager_IsRecording();
    }

    public final boolean isRecordingActivated() {
        return Native_VoiceManager_IsRecording() || Native_VoiceManager_IsRecordingPaused();
    }

    public final boolean isRecordingPaused() {
        return Native_VoiceManager_IsRecordingPaused();
    }

    public final void onAudioDevicesConnected(boolean isWiredHeadsetDevice) {
        Log.i(TAG, "onAudioDevicesConnected isWiredHeadsetDevice= " + isWiredHeadsetDevice);
        if (isRecording()) {
            stopRecording();
            if (isWiredHeadsetDevice) {
                VoiceManager.toastVoiceMessage(SpenVoiceListenerManager.WARNING_EARPHONE_PLUGGED_WHILE_RECORDING);
            }
        }
    }

    public final void onAudioDevicesDisconnected(boolean isWiredHeadsetDevice) {
        Log.i(TAG, "onAudioDevicesDisconnected isWiredHeadsetDevice= " + isWiredHeadsetDevice);
        if (isRecording()) {
            stopRecording();
        } else if (isPlaying()) {
            pausePlaying();
        }
        if (isWiredHeadsetDevice) {
            return;
        }
        Native_VoiceManager_RequestSetRecordingViaBluetooth(false);
    }

    public final synchronized boolean play(@Nullable SpenObjectVoice voice) {
        MediaPlayerInterface mediaPlayerInterface;
        try {
            mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return mediaPlayerInterface.play(voice);
    }

    public final synchronized boolean playVoiceList(@Nullable ArrayList<SpenVoiceData> list, int index) {
        MediaPlayerInterface mediaPlayerInterface;
        try {
            mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return mediaPlayerInterface.playVoiceList(list, index);
    }

    public final synchronized void registerBluetoothScoReceiver() {
        Log.i(TAG, "registerBluetoothScoReceiver");
        if (AudioFocus.INSTANCE.isRecordingViaBluetoothEnabled()) {
            Context context = mContext;
            if (context != null) {
                if (mBluetoothScoReceiver == null) {
                    mBluetoothScoReceiver = new BluetoothScoIntentReceiver(mBluetoothScoStateListener);
                }
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.bluetooth.headset.profile.action.AUDIO_STATE_CHANGED");
                    intentFilter.addAction("android.media.ACTION_SCO_AUDIO_STATE_UPDATED");
                    context.registerReceiver(mBluetoothScoReceiver, intentFilter);
                } catch (Exception e) {
                    e.printStackTrace();
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    }

    public final synchronized void removeInnerStateListener(@NotNull SpenVoiceListenerManager.OnInnerStateChanged listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        SpenVoiceListenerManager.removeInnerStateListener(listener);
    }

    public final synchronized boolean removeVoiceData(int index) {
        MediaPlayerInterface mediaPlayerInterface;
        try {
            mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
        } catch (Throwable th) {
            throw th;
        }
        return mediaPlayerInterface.removeVoiceData(index);
    }

    public final synchronized void setAudioEraserEnabled(boolean enabled) {
        try {
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            SpenSemMediaPlayer spenSemMediaPlayer = mediaPlayerInterface instanceof SpenSemMediaPlayer ? (SpenSemMediaPlayer) mediaPlayerInterface : null;
            if (spenSemMediaPlayer != null) {
                spenSemMediaPlayer.setAudioEraserEnabled(enabled);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void setMediaRecorderConfig(@NotNull SpenMediaRecorderConfig recorderConfig) {
        try {
            Intrinsics.checkNotNullParameter(recorderConfig, "recorderConfig");
            if (mMediaRecorderConfig == null) {
                mMediaRecorderConfig = new SpenMediaRecorderConfig();
            }
            SpenMediaRecorderConfig spenMediaRecorderConfig = mMediaRecorderConfig;
            if (spenMediaRecorderConfig != null) {
                spenMediaRecorderConfig.copy(recorderConfig);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void setSpeed(float speed) {
        try {
            Log.i(TAG, "setSpeed() " + speed);
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.setSpeed(speed);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void setToastActionListener(@Nullable SpenToastActionListener listener) {
        mToastActionListener = listener;
    }

    public final synchronized boolean startRecording(@NotNull SpenVoiceData voiceData) {
        Intrinsics.checkNotNullParameter(voiceData, "voiceData");
        Log.i(TAG, "startRecording voiceData " + voiceData.getName());
        return Native_VoiceManager_StartRecording(voiceData);
    }

    public final synchronized void unregisterScoBluetoothReceiver() {
        BluetoothScoIntentReceiver bluetoothScoIntentReceiver;
        Log.i(TAG, "unregisterScoBluetoothReceiver");
        if (AudioFocus.INSTANCE.isRecordingViaBluetoothEnabled()) {
            if (mContext != null && (bluetoothScoIntentReceiver = mBluetoothScoReceiver) != null) {
                try {
                    Intrinsics.checkNotNull(bluetoothScoIntentReceiver);
                    bluetoothScoIntentReceiver.close();
                    Context context = mContext;
                    Intrinsics.checkNotNull(context);
                    context.unregisterReceiver(mBluetoothScoReceiver);
                    mBluetoothScoReceiver = null;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @JvmStatic
    private static final synchronized void play(String filePath) {
        if (filePath == null) {
            return;
        }
        try {
            SpenNoteVoiceManager spenNoteVoiceManager = INSTANCE;
            if (spenNoteVoiceManager.isRecording()) {
                stopRecording();
            }
            if (spenNoteVoiceManager.isPlaying()) {
                spenNoteVoiceManager.stopMediaPlayer(false, false, false);
            }
            Log.i(TAG, "filePath: ".concat(filePath));
            if (spenNoteVoiceManager.initPlayer(filePath)) {
                Log.i(TAG, "init successful filePath: ".concat(filePath));
            } else {
                Native_VoiceManager_Play_onError(SpenVoiceListenerManager.ERROR_INITIALIZE_PLAYER);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @JvmStatic
    private static final synchronized boolean startRecording(String filePath) {
        INSTANCE.initRecorder();
        mRecordTotalTime = 0;
        MediaRecorderWrapper mediaRecorderWrapper = mRecorder;
        if (mediaRecorderWrapper != null) {
            try {
                long availableInternalMemorySize = SpenComposerUtil.getAvailableInternalMemorySize();
                if (mediaRecorderWrapper.start(filePath, recorderListener, VOICE_MAX_DURATION, ((long) 524288000) > availableInternalMemorySize ? (int) availableInternalMemorySize : 524288000)) {
                    return true;
                }
            } catch (PlatformException unused) {
                return false;
            }
        }
        return false;
    }

    public final synchronized void seekTo(int index, int time) {
        try {
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.seekTo(index, time);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void seekTo(long time, int mode) {
        try {
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.seekTo(mode, mode);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void seekTo(int index, long time, int mode) {
        try {
            MediaPlayerInterface mediaPlayerInterface = mMediaPlayerInterface;
            if (mediaPlayerInterface == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMediaPlayerInterface");
                mediaPlayerInterface = null;
            }
            mediaPlayerInterface.seekTo(index, time, mode);
        } catch (Throwable th) {
            throw th;
        }
    }
}
