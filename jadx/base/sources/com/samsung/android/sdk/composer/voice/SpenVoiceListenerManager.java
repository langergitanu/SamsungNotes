package com.samsung.android.sdk.composer.voice;

import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sdk.pen.document.SpenObjectVoice;
import com.samsung.android.sdk.pen.worddoc.SpenVoiceData;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002EFB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000bH\u0007J\u0010\u0010%\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000bH\u0007J\u0010\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0007J\u0010\u0010'\u001a\u00020#2\u0006\u0010$\u001a\u00020\tH\u0007J$\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010-\u001a\u00020\rH\u0003J$\u0010.\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010/\u001a\u00020\rH\u0003J$\u00100\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00101\u001a\u00020\rH\u0003J\u001c\u00102\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0003J\u001c\u00103\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0003J\u001c\u00104\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0003J\u001c\u00105\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0003J$\u00106\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\u0006\u00107\u001a\u00020\rH\u0003J\u001c\u00108\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0003J\u0018\u00109\u001a\u00020#2\u0006\u0010+\u001a\u00020,2\u0006\u0010:\u001a\u00020\u0005H\u0003J\u0010\u0010;\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0003J\u0010\u0010<\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0003J\u0010\u0010=\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0003J\u0010\u0010>\u001a\u00020#2\u0006\u0010+\u001a\u00020,H\u0003J\u0018\u0010?\u001a\u00020#2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\rH\u0003J\u0018\u0010@\u001a\u00020#2\u0006\u0010+\u001a\u00020,2\u0006\u0010A\u001a\u00020\rH\u0003J\u0018\u0010B\u001a\u00020#2\u0006\u0010)\u001a\u00020*2\u0006\u0010C\u001a\u00020\rH\u0003J\u0010\u0010D\u001a\u00020#2\u0006\u0010)\u001a\u00020*H\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\rX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0086T¢\u0006\u0002\n\u0000¨\u0006G"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mSync", "mListenerList", "Ljava/util/ArrayList;", "Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnInnerStateChanged;", "mFixedListener", "Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnStateChanged;", "ERROR_CODE_BASE", "", "ERROR_NOT_ENOUGH_TIME", "ERROR_PREPARE_RECORDER", "ERROR_PAUSE_FAILED", "ERROR_INITIALIZE_PLAYER", "ERROR_FILE_READ_PLAY_TIME", "ERROR_ALREADY_RECORDING", "ERROR_ALREADY_RECORDER_WORKING", "ERROR_NOT_ENOUGH_STORAGE", "ERROR_SECURITY_POLICY", "ERROR_IS_CALLING_RECORD", "ERROR_IS_CALLING_PLAY", "ERROR_NO_PLAY_FILE", "ERROR_FAILED_TO_ATTACH_FILE", "ERROR_UNSUPPORTED_FILE_TYPE", "ERROR_MEDIA_PLAYER", "MEDIA_RECORDER_INFO_MAX_DURATION_REACHED", "MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED", "INFO_CODE_BASE", "INFO_EARPHONE_PLUGGED", "WARNING_EARPHONE_PLUGGED_WHILE_RECORDING", "setStateListener", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "removeStateListener", "addInnerStateListener", "removeInnerStateListener", "onPlayError", "objectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "errorCode", "onPlayPrepared", XmlErrorCodes.DURATION, "onPlayInfo", "mediaInfo", "onPlayStarted", "onPlayPaused", "onPlayResumed", "onPlayStopped", "onPlaySeekComplete", "position", "onPlayComplete", "onRecordStarted", "cachePath", "onRecordStopped", "onRecordCancelled", "onRecordPaused", "onRecordResumed", "onRecordError", "onRecordUpdateTime", "timeInSecond", "onInfo", "what", "onPlayClicked", "OnStateChanged", "OnInnerStateChanged", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenVoiceListenerManager {
    public static final int ERROR_ALREADY_RECORDER_WORKING = 5007;
    public static final int ERROR_ALREADY_RECORDING = 5006;
    private static final int ERROR_CODE_BASE = 5000;
    public static final int ERROR_FAILED_TO_ATTACH_FILE = 5013;
    public static final int ERROR_FILE_READ_PLAY_TIME = 5005;
    public static final int ERROR_INITIALIZE_PLAYER = 5004;
    public static final int ERROR_IS_CALLING_PLAY = 5011;
    public static final int ERROR_IS_CALLING_RECORD = 5010;
    public static final int ERROR_MEDIA_PLAYER = 5015;
    public static final int ERROR_NOT_ENOUGH_STORAGE = 5008;
    public static final int ERROR_NOT_ENOUGH_TIME = 5001;
    public static final int ERROR_NO_PLAY_FILE = 5012;
    public static final int ERROR_PAUSE_FAILED = 5003;
    public static final int ERROR_PREPARE_RECORDER = 5002;
    public static final int ERROR_SECURITY_POLICY = 5009;
    public static final int ERROR_UNSUPPORTED_FILE_TYPE = 5014;
    private static final int INFO_CODE_BASE = 10000;
    public static final int INFO_EARPHONE_PLUGGED = 10001;
    public static final int MEDIA_RECORDER_INFO_MAX_DURATION_REACHED = 800;
    public static final int MEDIA_RECORDER_INFO_MAX_FILESIZE_REACHED = 801;

    @NotNull
    private static final String TAG = "VoiceListenerManager";
    public static final int WARNING_EARPHONE_PLUGGED_WHILE_RECORDING = 10002;

    @NotNull
    public static final SpenVoiceListenerManager INSTANCE = new SpenVoiceListenerManager();

    @NotNull
    private static final Object mSync = new Object();

    @NotNull
    private static final ArrayList<OnInnerStateChanged> mListenerList = new ArrayList<>();

    @NotNull
    private static final ArrayList<OnStateChanged> mFixedListener = new ArrayList<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH&J$\u0010\n\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\tH&J$\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\tH&J\u001c\u0010\u000e\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u000f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J$\u0010\u0012\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0013\u001a\u00020\tH&J\u001c\u0010\u0014\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\tH&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\tH&¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnInnerStateChanged;", "", "onPlayError", "", "objectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "errorCode", "", "onPlayPrepared", XmlErrorCodes.DURATION, "onPlayInfo", "mediaInfo", "onPlayStarted", "onPlayPaused", "onPlayResumed", "onPlayStopped", "onPlaySeekComplete", "position", "onPlayComplete", "onRecordStarted", "cachePath", "", "onRecordStopped", "onRecordCancelled", "onRecordPaused", "onRecordResumed", "onRecordError", "onRecordUpdateTime", "timeInSecond", "onInfo", "what", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnInnerStateChanged {
        void onInfo(@NotNull SpenObjectVoice objectVoice, int what);

        void onPlayComplete(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData);

        void onPlayError(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData, int errorCode);

        void onPlayInfo(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData, int mediaInfo);

        void onPlayPaused(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData);

        void onPlayPrepared(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData, int duration);

        void onPlayResumed(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData);

        void onPlaySeekComplete(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData, int position);

        void onPlayStarted(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData);

        void onPlayStopped(@Nullable SpenObjectVoice objectVoice, @Nullable SpenVoiceData voiceData);

        void onRecordCancelled(@NotNull SpenVoiceData voiceData);

        void onRecordError(@NotNull SpenVoiceData voiceData, int errorCode);

        void onRecordPaused(@NotNull SpenVoiceData voiceData);

        void onRecordResumed(@NotNull SpenVoiceData voiceData);

        void onRecordStarted(@NotNull SpenVoiceData voiceData, @NotNull String cachePath);

        void onRecordStopped(@NotNull SpenVoiceData voiceData);

        void onRecordUpdateTime(@NotNull SpenVoiceData voiceData, int timeInSecond);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0007H&J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u0007H&J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0007H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\""}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/SpenVoiceListenerManager$OnStateChanged;", "", "onPlayError", "", "objectVoice", "Lcom/samsung/android/sdk/pen/document/SpenObjectVoice;", "errorCode", "", "onPlayPrepared", XmlErrorCodes.DURATION, "onPlayInfo", "mediaInfo", "onPlayStarted", "onPlayPaused", "onPlayResumed", "onPlayStopped", "onPlaySeekComplete", "position", "onPlayComplete", "voiceData", "Lcom/samsung/android/sdk/pen/worddoc/SpenVoiceData;", "onRecordStarted", "cachePath", "", "onRecordStopped", "onRecordCancelled", "onRecordPaused", "onRecordResumed", "onRecordError", "onRecordUpdateTime", "timeInSecond", "onInfo", "what", "onPlayClicked", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public interface OnStateChanged {
        void onInfo(@NotNull SpenObjectVoice objectVoice, int what);

        void onPlayClicked(@NotNull SpenObjectVoice objectVoice);

        void onPlayComplete(@NotNull SpenObjectVoice objectVoice);

        void onPlayComplete(@NotNull SpenVoiceData voiceData);

        void onPlayError(@NotNull SpenObjectVoice objectVoice, int errorCode);

        void onPlayError(@NotNull SpenVoiceData voiceData, int errorCode);

        void onPlayInfo(@NotNull SpenObjectVoice objectVoice, int mediaInfo);

        void onPlayInfo(@NotNull SpenVoiceData voiceData, int mediaInfo);

        void onPlayPaused(@NotNull SpenObjectVoice objectVoice);

        void onPlayPaused(@NotNull SpenVoiceData voiceData);

        void onPlayPrepared(@NotNull SpenObjectVoice objectVoice, int duration);

        void onPlayPrepared(@NotNull SpenVoiceData voiceData, int duration);

        void onPlayResumed(@NotNull SpenObjectVoice objectVoice);

        void onPlayResumed(@NotNull SpenVoiceData voiceData);

        void onPlaySeekComplete(@NotNull SpenObjectVoice objectVoice, int position);

        void onPlaySeekComplete(@NotNull SpenVoiceData voiceData, int position);

        void onPlayStarted(@NotNull SpenObjectVoice objectVoice);

        void onPlayStarted(@NotNull SpenVoiceData voiceData);

        void onPlayStopped(@NotNull SpenObjectVoice objectVoice);

        void onPlayStopped(@NotNull SpenVoiceData voiceData);

        void onRecordCancelled(@NotNull SpenVoiceData voiceData);

        void onRecordError(@NotNull SpenVoiceData voiceData, int errorCode);

        void onRecordPaused(@NotNull SpenVoiceData voiceData);

        void onRecordResumed(@NotNull SpenVoiceData voiceData);

        void onRecordStarted(@NotNull SpenVoiceData voiceData, @NotNull String cachePath);

        void onRecordStopped(@NotNull SpenVoiceData voiceData);

        void onRecordUpdateTime(@NotNull SpenVoiceData voiceData, int timeInSecond);
    }

    private SpenVoiceListenerManager() {
    }

    @JvmStatic
    public static final void addInnerStateListener(@NotNull OnInnerStateChanged listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (mSync) {
            try {
                ArrayList<OnInnerStateChanged> arrayList = mListenerList;
                if (arrayList.indexOf(listener) < 0) {
                    arrayList.add(listener);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onInfo(SpenObjectVoice objectVoice, int what) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onInfo(objectVoice, what);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    next2.onInfo(objectVoice, what);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onPlayClicked(SpenObjectVoice objectVoice) {
        synchronized (mSync) {
            try {
                Iterator<OnStateChanged> it = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlayClicked(objectVoice);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onPlayComplete(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlayComplete(objectVoice, voiceData);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    OnStateChanged onStateChanged = next2;
                    if (objectVoice != null) {
                        onStateChanged.onPlayComplete(objectVoice);
                    }
                    if (voiceData != null) {
                        onStateChanged.onPlayComplete(voiceData);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onPlayError(SpenObjectVoice objectVoice, SpenVoiceData voiceData, int errorCode) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlayError(objectVoice, voiceData, errorCode);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    OnStateChanged onStateChanged = next2;
                    if (objectVoice != null) {
                        onStateChanged.onPlayError(objectVoice, errorCode);
                    }
                    if (voiceData != null) {
                        onStateChanged.onPlayError(voiceData, errorCode);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onPlayInfo(SpenObjectVoice objectVoice, SpenVoiceData voiceData, int mediaInfo) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlayInfo(objectVoice, voiceData, mediaInfo);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    OnStateChanged onStateChanged = next2;
                    if (objectVoice != null) {
                        onStateChanged.onPlayInfo(objectVoice, mediaInfo);
                    }
                    if (voiceData != null) {
                        onStateChanged.onPlayInfo(voiceData, mediaInfo);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onPlayPaused(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlayPaused(objectVoice, voiceData);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    OnStateChanged onStateChanged = next2;
                    if (objectVoice != null) {
                        onStateChanged.onPlayPaused(objectVoice);
                    }
                    if (voiceData != null) {
                        onStateChanged.onPlayPaused(voiceData);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onPlayPrepared(SpenObjectVoice objectVoice, SpenVoiceData voiceData, int duration) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlayPrepared(objectVoice, voiceData, duration);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    OnStateChanged onStateChanged = next2;
                    if (objectVoice != null) {
                        onStateChanged.onPlayPrepared(objectVoice, duration);
                    }
                    if (voiceData != null) {
                        onStateChanged.onPlayPrepared(voiceData, duration);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onPlayResumed(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlayResumed(objectVoice, voiceData);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    OnStateChanged onStateChanged = next2;
                    if (objectVoice != null) {
                        onStateChanged.onPlayResumed(objectVoice);
                    }
                    if (voiceData != null) {
                        onStateChanged.onPlayResumed(voiceData);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onPlaySeekComplete(SpenObjectVoice objectVoice, SpenVoiceData voiceData, int position) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlaySeekComplete(objectVoice, voiceData, position);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    OnStateChanged onStateChanged = next2;
                    Log.d(TAG, "Play_onSeekComplete: " + position);
                    if (objectVoice != null) {
                        onStateChanged.onPlaySeekComplete(objectVoice, position);
                    }
                    if (voiceData != null) {
                        onStateChanged.onPlaySeekComplete(voiceData, position);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onPlayStarted(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlayStarted(objectVoice, voiceData);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    OnStateChanged onStateChanged = next2;
                    if (objectVoice != null) {
                        onStateChanged.onPlayStarted(objectVoice);
                    }
                    if (voiceData != null) {
                        onStateChanged.onPlayStarted(voiceData);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onPlayStopped(SpenObjectVoice objectVoice, SpenVoiceData voiceData) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onPlayStopped(objectVoice, voiceData);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    OnStateChanged onStateChanged = next2;
                    if (objectVoice != null) {
                        onStateChanged.onPlayStopped(objectVoice);
                    }
                    if (voiceData != null) {
                        onStateChanged.onPlayStopped(voiceData);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onRecordCancelled(SpenVoiceData voiceData) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onRecordCancelled(voiceData);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    next2.onRecordCancelled(voiceData);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onRecordError(SpenVoiceData voiceData, int errorCode) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onRecordError(voiceData, errorCode);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    next2.onRecordError(voiceData, errorCode);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onRecordPaused(SpenVoiceData voiceData) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onRecordPaused(voiceData);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    next2.onRecordPaused(voiceData);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onRecordResumed(SpenVoiceData voiceData) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onRecordResumed(voiceData);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    next2.onRecordResumed(voiceData);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onRecordStarted(SpenVoiceData voiceData, String cachePath) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onRecordStarted(voiceData, cachePath);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    next2.onRecordStarted(voiceData, cachePath);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onRecordStopped(SpenVoiceData voiceData) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onRecordStopped(voiceData);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    next2.onRecordStopped(voiceData);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    private static final void onRecordUpdateTime(SpenVoiceData voiceData, int timeInSecond) {
        synchronized (mSync) {
            try {
                Iterator<OnInnerStateChanged> it = mListenerList.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    OnInnerStateChanged next = it.next();
                    Intrinsics.checkNotNullExpressionValue(next, "next(...)");
                    next.onRecordUpdateTime(voiceData, timeInSecond);
                }
                Iterator<OnStateChanged> it2 = mFixedListener.iterator();
                Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
                while (it2.hasNext()) {
                    OnStateChanged next2 = it2.next();
                    Intrinsics.checkNotNullExpressionValue(next2, "next(...)");
                    next2.onRecordUpdateTime(voiceData, timeInSecond);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @JvmStatic
    public static final void removeInnerStateListener(@NotNull OnInnerStateChanged listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (mSync) {
            mListenerList.remove(listener);
        }
    }

    @JvmStatic
    public static final void removeStateListener(@NotNull OnStateChanged listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (mSync) {
            mFixedListener.remove(listener);
        }
    }

    @JvmStatic
    public static final void setStateListener(@NotNull OnStateChanged listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        synchronized (mSync) {
            try {
                ArrayList<OnStateChanged> arrayList = mFixedListener;
                if (arrayList.indexOf(listener) < 0) {
                    arrayList.add(listener);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
