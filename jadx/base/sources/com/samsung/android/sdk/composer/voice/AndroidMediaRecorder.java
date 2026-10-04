package com.samsung.android.sdk.composer.voice;

import android.media.MediaRecorder;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.spen.libinterface.MediaRecorderConfigInterface;
import com.samsung.android.spen.libinterface.MediaRecorderInterface;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.io.IOException;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.xmlbeans.XmlErrorCodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\f\u0018\u0000 Q2\u00020\u0001:\u0003OPQB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0016J\u0010\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0010\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0011H\u0016J\u0012\u0010\u001d\u001a\u00020\u00182\b\u0010\u001e\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010 \u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0011J\u000e\u0010!\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0011J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0007H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\"\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u000f2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0016J\b\u0010*\u001a\u00020&H\u0002J(\u0010-\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000f2\u0006\u0010.\u001a\u00020/2\u0006\u0010(\u001a\u00020\u00112\u0006\u0010)\u001a\u00020\u0011H\u0016J\u0010\u00100\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00101\u001a\u00020&H\u0016J\b\u00102\u001a\u00020&H\u0016J\b\u00103\u001a\u00020\u0018H\u0016J\b\u00104\u001a\u00020\u0018H\u0016J\u0010\u00105\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00106\u001a\u00020&2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00107\u001a\u00020&H\u0016J\u000e\u00108\u001a\u00020\u00182\u0006\u00109\u001a\u00020\u0011J\u000e\u0010:\u001a\u00020\u00182\u0006\u0010;\u001a\u00020<J\u0012\u0010A\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010B\u001a\u00020\u00182\b\u0010.\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010C\u001a\u00020\u0011H\u0016J\u0012\u0010D\u001a\u00020\u00182\b\u0010E\u001a\u0004\u0018\u00010FH\u0002J\b\u0010G\u001a\u00020\u0018H\u0002J\b\u0010H\u001a\u00020\u0018H\u0002J\b\u0010I\u001a\u00020\u0018H\u0002J\b\u0010J\u001a\u00020\u0018H\u0002J\b\u0010K\u001a\u00020\u0018H\u0002J\b\u0010L\u001a\u00020\u0018H\u0002J\b\u0010M\u001a\u00020\u0018H\u0002J\b\u0010N\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010+\u001a\u00060,R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020>X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020@X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/AndroidMediaRecorder;", "Lcom/samsung/android/spen/libinterface/MediaRecorderInterface;", "<init>", "()V", "mAndroidMediaRecorder", "Landroid/media/MediaRecorder;", "mMediaRecorderConfig", "Lcom/samsung/android/spen/libinterface/MediaRecorderConfigInterface;", "mSingleThreadExecutor", "Ljava/util/concurrent/Executor;", "mListener", "Lcom/samsung/android/spen/libinterface/MediaRecorderInterface$ActionListener;", "mTimeListener", "Lcom/samsung/android/spen/libinterface/MediaRecorderInterface$TimeListener;", "mResultFilePath", "", "mRecordTimeInSecond", "", "mRecordTimeInMilliSecond", "mTimer", "Ljava/util/Timer;", "mHandler", "Landroid/os/Handler;", "setAudioSource", "", "audioSource", "setOutputFormat", "var1", "setAudioEncoder", "setOutputFile", "path", "setAudioChannels", "setAudioSamplingRate", "setAudioEncodingBitRate", "setMediaRecorderConfig", "mediaRecorderConfigInterface", "prepare", "prepareRecording", "", "filePath", "maxDuration", "maxFileSize", "startImpl", "mRecorderAsyncTask", "Lcom/samsung/android/sdk/composer/voice/AndroidMediaRecorder$MediaRecorderAsyncTask;", "start", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/samsung/android/spen/libinterface/MediaRecorderInterface$MediaRecorderListener;", "stop", "cancel", "isStarting", "reset", "release", "pause", "resume", "isPauseSupported", "setMaxDuration", XmlErrorCodes.DURATION, "setMaxFileSize", "fileSize", "", "mInfoListener", "Landroid/media/MediaRecorder$OnInfoListener;", "mErrorListener", "Landroid/media/MediaRecorder$OnErrorListener;", "setActionListener", "setTimeListener", "getMaxAmplitude", "printLog", "e", "", "startTimer", "stopTimer", "cancelTimer", "pauseTimer", "resumeTimer", "runTimer", "updateTimeOnUIThread", "updateTime", "RecorderTaskState", "MediaRecorderAsyncTask", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class AndroidMediaRecorder implements MediaRecorderInterface {
    private static long mWaitTimeForStartRecording;

    @Nullable
    private MediaRecorder mAndroidMediaRecorder;

    @NotNull
    private final MediaRecorder.OnErrorListener mErrorListener;

    @NotNull
    private final Handler mHandler;

    @NotNull
    private final MediaRecorder.OnInfoListener mInfoListener;

    @Nullable
    private MediaRecorderInterface.ActionListener mListener;

    @Nullable
    private MediaRecorderConfigInterface mMediaRecorderConfig;
    private int mRecordTimeInMilliSecond;
    private int mRecordTimeInSecond;

    @NotNull
    private final MediaRecorderAsyncTask mRecorderAsyncTask;

    @Nullable
    private String mResultFilePath;

    @NotNull
    private final Executor mSingleThreadExecutor;

    @Nullable
    private MediaRecorderInterface.TimeListener mTimeListener;

    @Nullable
    private Timer mTimer;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "AndroidMediaRecorder";
    private static final long RECORD_TIME_DURATION = 50;
    private static final int ONE_SECOND = 1000;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/AndroidMediaRecorder$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "RECORD_TIME_DURATION", "", "ONE_SECOND", "", "mWaitTimeForStartRecording", "setWaitTimeForStartRecording", "", "ms", "waitForStartRecording", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void setWaitTimeForStartRecording(long ms) {
            AndroidMediaRecorder.mWaitTimeForStartRecording = System.currentTimeMillis() + ms;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void waitForStartRecording() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis < AndroidMediaRecorder.mWaitTimeForStartRecording) {
                try {
                    Thread.sleep(AndroidMediaRecorder.mWaitTimeForStartRecording - jCurrentTimeMillis);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\b\u0080\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\u0012\u001a\u00020\u0013H\u0014J%\u0010\u0014\u001a\u00020\u00132\u0016\u0010\u0015\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00030\u0016\"\u0004\u0018\u00010\u0003H\u0014¢\u0006\u0002\u0010\u0017J\u0012\u0010\u0018\u001a\u00020\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0014J%\u0010\u001a\u001a\u00020\u00042\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0016\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u0004H\u0014J\u0010\u0010\u001f\u001a\u00020 2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/AndroidMediaRecorder$MediaRecorderAsyncTask;", "Landroid/os/AsyncTask;", "Lcom/samsung/android/spen/libinterface/MediaRecorderInterface$MediaRecorderListener;", "", "Ljava/lang/Boolean;", "<init>", "(Lcom/samsung/android/sdk/composer/voice/AndroidMediaRecorder;)V", "mListener", "mMaxDuration", "getMMaxDuration", "()I", "setMMaxDuration", "(I)V", "mMaxFileSize", "getMMaxFileSize", "setMMaxFileSize", "mState", "Lcom/samsung/android/sdk/composer/voice/AndroidMediaRecorder$RecorderTaskState;", "onPreExecute", "", "onProgressUpdate", "progress", "", "([Ljava/lang/Integer;)V", "onCancelled", "aBoolean", "doInBackground", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "([Lcom/samsung/android/spen/libinterface/MediaRecorderInterface$MediaRecorderListener;)Ljava/lang/Boolean;", "onPostExecute", "result", "run", "", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public final class MediaRecorderAsyncTask extends AsyncTask<MediaRecorderInterface.MediaRecorderListener, Integer, Boolean> {

        @Nullable
        private MediaRecorderInterface.MediaRecorderListener mListener;
        private int mMaxDuration;
        private int mMaxFileSize;

        @NotNull
        private RecorderTaskState mState = RecorderTaskState.IDLE;

        public MediaRecorderAsyncTask() {
        }

        public final int getMMaxDuration() {
            return this.mMaxDuration;
        }

        public final int getMMaxFileSize() {
            return this.mMaxFileSize;
        }

        @Override // android.os.AsyncTask
        public void onPreExecute() {
            super.onPreExecute();
        }

        public final boolean run(@Nullable MediaRecorderInterface.MediaRecorderListener listener) {
            if (getStatus() != AsyncTask.Status.RUNNING) {
                synchronized (this) {
                    this.mState = RecorderTaskState.READY;
                    Unit unit = Unit.INSTANCE;
                }
                executeOnExecutor(AndroidMediaRecorder.this.mSingleThreadExecutor, listener);
                return true;
            }
            Log.d(AndroidMediaRecorder.TAG, "previous RecorderTask is not finished(" + getStatus() + "). Skip run.");
            return false;
        }

        public final void setMMaxDuration(int i) {
            this.mMaxDuration = i;
        }

        public final void setMMaxFileSize(int i) {
            this.mMaxFileSize = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
        @Override // android.os.AsyncTask
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Boolean doInBackground(@NotNull MediaRecorderInterface.MediaRecorderListener... listener) {
            Intrinsics.checkNotNullParameter(listener, "listener");
            Log.d(AndroidMediaRecorder.TAG, "doInBackground");
            synchronized (this) {
                if (this.mState != RecorderTaskState.READY) {
                    Log.d(AndroidMediaRecorder.TAG, "invalid RecorderTask state(" + this.mState + "). Skip doInBackground.");
                    return Boolean.FALSE;
                }
                this.mState = RecorderTaskState.DO_IN_BACKGROUND;
                Unit unit = Unit.INSTANCE;
                Boolean bool = Boolean.FALSE;
                MediaRecorderInterface.MediaRecorderListener mediaRecorderListener = listener[0];
                this.mListener = mediaRecorderListener;
                if (mediaRecorderListener != null) {
                    AndroidMediaRecorder androidMediaRecorder = AndroidMediaRecorder.this;
                    if (androidMediaRecorder.prepareRecording(androidMediaRecorder.mResultFilePath, this.mMaxDuration, this.mMaxFileSize) && AndroidMediaRecorder.this.startImpl()) {
                        MediaRecorder mediaRecorder = AndroidMediaRecorder.this.mAndroidMediaRecorder;
                        if (mediaRecorder != null) {
                            mediaRecorder.setOnInfoListener(AndroidMediaRecorder.this.mInfoListener);
                        }
                        MediaRecorder mediaRecorder2 = AndroidMediaRecorder.this.mAndroidMediaRecorder;
                        if (mediaRecorder2 != null) {
                            mediaRecorder2.setOnErrorListener(AndroidMediaRecorder.this.mErrorListener);
                        }
                        bool = Boolean.TRUE;
                    } else {
                        AndroidMediaRecorder.this.release();
                        AndroidMediaRecorder.this.mAndroidMediaRecorder = null;
                        AndroidMediaRecorder.this.mMediaRecorderConfig = null;
                    }
                }
                synchronized (this) {
                    Intrinsics.checkNotNull(this, "null cannot be cast to non-null type java.lang.Object");
                    notify();
                    this.mState = RecorderTaskState.ON_POST_EXECUTE;
                }
                return bool;
            }
        }

        @Override // android.os.AsyncTask
        public void onCancelled(@Nullable Boolean aBoolean) {
            super.onCancelled(aBoolean);
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(@NotNull Boolean result) {
            Intrinsics.checkNotNullParameter(result, "result");
            if (this.mState != RecorderTaskState.ON_POST_EXECUTE) {
                Log.d(AndroidMediaRecorder.TAG, "invalid RecorderTask state(" + this.mState + "). Skip onPostExecute.");
                return;
            }
            if (result.booleanValue()) {
                Log.d(AndroidMediaRecorder.TAG, "onPostExecute: success");
                AndroidMediaRecorder.this.startTimer();
                MediaRecorderInterface.MediaRecorderListener mediaRecorderListener = this.mListener;
                if (mediaRecorderListener != null) {
                    AndroidMediaRecorder.INSTANCE.setWaitTimeForStartRecording(500L);
                    mediaRecorderListener.onStarted();
                }
            } else {
                Log.d(AndroidMediaRecorder.TAG, "onPostExecute: fail");
                MediaRecorderInterface.MediaRecorderListener mediaRecorderListener2 = this.mListener;
                if (mediaRecorderListener2 != null) {
                    mediaRecorderListener2.onError();
                }
            }
            this.mState = RecorderTaskState.IDLE;
        }

        @Override // android.os.AsyncTask
        public void onProgressUpdate(@NotNull Integer... progress) {
            Intrinsics.checkNotNullParameter(progress, "progress");
            super.onProgressUpdate(Arrays.copyOf(progress, progress.length));
        }

        @Override // android.os.AsyncTask
        public void onCancelled() {
            super.onCancelled();
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/sdk/composer/voice/AndroidMediaRecorder$RecorderTaskState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "READY", "DO_IN_BACKGROUND", "ON_POST_EXECUTE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class RecorderTaskState {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ RecorderTaskState[] $VALUES;
        public static final RecorderTaskState IDLE = new RecorderTaskState("IDLE", 0);
        public static final RecorderTaskState READY = new RecorderTaskState("READY", 1);
        public static final RecorderTaskState DO_IN_BACKGROUND = new RecorderTaskState("DO_IN_BACKGROUND", 2);
        public static final RecorderTaskState ON_POST_EXECUTE = new RecorderTaskState("ON_POST_EXECUTE", 3);

        private static final /* synthetic */ RecorderTaskState[] $values() {
            return new RecorderTaskState[]{IDLE, READY, DO_IN_BACKGROUND, ON_POST_EXECUTE};
        }

        static {
            RecorderTaskState[] recorderTaskStateArr$values = $values();
            $VALUES = recorderTaskStateArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(recorderTaskStateArr$values);
        }

        private RecorderTaskState(String str, int i) {
        }

        @NotNull
        public static EnumEntries<RecorderTaskState> getEntries() {
            return $ENTRIES;
        }

        public static RecorderTaskState valueOf(String str) {
            return (RecorderTaskState) Enum.valueOf(RecorderTaskState.class, str);
        }

        public static RecorderTaskState[] values() {
            return (RecorderTaskState[]) $VALUES.clone();
        }
    }

    public AndroidMediaRecorder() {
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.mSingleThreadExecutor = executorServiceNewSingleThreadExecutor;
        this.mHandler = new Handler();
        this.mRecorderAsyncTask = new AndroidMediaRecorder().new MediaRecorderAsyncTask();
        this.mInfoListener = new MediaRecorder.OnInfoListener() { // from class: com.samsung.android.sdk.composer.voice.AndroidMediaRecorder$mInfoListener$1
            @Override // android.media.MediaRecorder.OnInfoListener
            public void onInfo(MediaRecorder mr, int what, int extra) {
                MediaRecorderInterface.ActionListener actionListener = this.this$0.mListener;
                if (actionListener != null) {
                    actionListener.onInfo(what, extra);
                }
            }
        };
        this.mErrorListener = new MediaRecorder.OnErrorListener() { // from class: com.samsung.android.sdk.composer.voice.AndroidMediaRecorder$mErrorListener$1
            @Override // android.media.MediaRecorder.OnErrorListener
            public void onError(MediaRecorder mr, int what, int extra) {
                MediaRecorderInterface.ActionListener actionListener = this.this$0.mListener;
                if (actionListener != null) {
                    actionListener.onError(what, extra);
                }
            }
        };
    }

    private final void cancelTimer() {
        Timer timer = this.mTimer;
        if (timer != null) {
            timer.cancel();
        }
        this.mTimer = null;
    }

    private final void pauseTimer() {
        cancelTimer();
    }

    private final void printLog(Throwable e) {
        Log.e(TAG, Log.getStackTraceString(e));
    }

    private final void resumeTimer() {
        cancelTimer();
        runTimer();
    }

    private final void runTimer() {
        this.mTimer = new Timer();
        TimerTask timerTask = new TimerTask() { // from class: com.samsung.android.sdk.composer.voice.AndroidMediaRecorder$runTimer$mTimerTask$1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                this.this$0.updateTimeOnUIThread();
            }
        };
        Timer timer = this.mTimer;
        if (timer != null) {
            long j = RECORD_TIME_DURATION;
            timer.schedule(timerTask, j, j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean startImpl() {
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.start();
                return true;
            } catch (Exception e) {
                printLog(e);
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startTimer() {
        stopTimer();
        runTimer();
    }

    private final void stopTimer() {
        cancelTimer();
        this.mHandler.removeCallbacksAndMessages(null);
        this.mRecordTimeInSecond = 0;
        this.mRecordTimeInMilliSecond = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTime() {
        int i = this.mRecordTimeInMilliSecond + ((int) RECORD_TIME_DURATION);
        this.mRecordTimeInMilliSecond = i;
        int i2 = i / ONE_SECOND;
        if (i2 > this.mRecordTimeInSecond) {
            this.mRecordTimeInSecond = i2;
            MediaRecorderInterface.TimeListener timeListener = this.mTimeListener;
            if (timeListener != null) {
                timeListener.onUpdateTime(i2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTimeOnUIThread() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler.post(new Runnable() { // from class: com.samsung.android.sdk.composer.voice.AndroidMediaRecorder.updateTimeOnUIThread.1
            @Override // java.lang.Runnable
            public void run() {
                AndroidMediaRecorder.this.updateTime();
            }
        });
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean cancel() {
        INSTANCE.waitForStartRecording();
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        boolean z = false;
        if (mediaRecorder != null) {
            stopTimer();
            try {
                mediaRecorder.stop();
                release();
                z = true;
            } catch (Exception e) {
                printLog(e);
            }
            this.mAndroidMediaRecorder = null;
            this.mMediaRecorderConfig = null;
        }
        return z;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public int getMaxAmplitude() {
        try {
            MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
            if (mediaRecorder != null) {
                return mediaRecorder.getMaxAmplitude();
            }
            return -1;
        } catch (Exception e) {
            printLog(e);
            return -1;
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean isPauseSupported() {
        return true;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean isStarting() {
        return this.mRecorderAsyncTask.getStatus() == AsyncTask.Status.RUNNING;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean pause(@NotNull MediaRecorderInterface.MediaRecorderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        INSTANCE.waitForStartRecording();
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            if (!isPauseSupported()) {
                VoiceManager.toastVoiceMessage(SpenVoiceListenerManager.ERROR_PAUSE_FAILED);
                return false;
            }
            try {
                mediaRecorder.pause();
                pauseTimer();
                listener.onPaused();
                return true;
            } catch (Exception e) {
                printLog(e);
            }
        }
        return false;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void prepare() throws IOException {
        Log.d(TAG, "prepare");
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.prepare();
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean prepareRecording(@Nullable String filePath, int maxDuration, int maxFileSize) {
        try {
            Log.d(TAG, "prepareRecording");
            this.mAndroidMediaRecorder = new MediaRecorder();
            MediaRecorderConfigInterface mediaRecorderConfigInterface = this.mMediaRecorderConfig;
            setAudioSamplingRate(mediaRecorderConfigInterface != null ? mediaRecorderConfigInterface.getMAudioSamplingRate() : MediaRecorderConfigInterface.AudioSamplingRate);
            MediaRecorderConfigInterface mediaRecorderConfigInterface2 = this.mMediaRecorderConfig;
            setAudioEncodingBitRate(mediaRecorderConfigInterface2 != null ? mediaRecorderConfigInterface2.getMAudioEncodingBitRate() : MediaRecorderConfigInterface.AudioEncodingBitRate);
            MediaRecorderConfigInterface mediaRecorderConfigInterface3 = this.mMediaRecorderConfig;
            setAudioChannels(mediaRecorderConfigInterface3 != null ? mediaRecorderConfigInterface3.getMAudioChannels() : 2);
            MediaRecorderConfigInterface mediaRecorderConfigInterface4 = this.mMediaRecorderConfig;
            setAudioSource(mediaRecorderConfigInterface4 != null ? mediaRecorderConfigInterface4.getMAudioSource() : 1);
            MediaRecorderConfigInterface mediaRecorderConfigInterface5 = this.mMediaRecorderConfig;
            setOutputFormat(mediaRecorderConfigInterface5 != null ? mediaRecorderConfigInterface5.getMOutputFormat() : 1);
            MediaRecorderConfigInterface mediaRecorderConfigInterface6 = this.mMediaRecorderConfig;
            setAudioEncoder(mediaRecorderConfigInterface6 != null ? mediaRecorderConfigInterface6.getMAudioEncoder() : 3);
            setOutputFile(filePath);
            setMaxDuration(maxDuration);
            setMaxFileSize(maxFileSize);
            prepare();
            return true;
        } catch (IllegalStateException e) {
            printLog(e);
            return false;
        } catch (RuntimeException e2) {
            printLog(e2);
            return false;
        } catch (Exception e3) {
            printLog(e3);
            return false;
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void release() {
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.release();
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void reset() {
        Log.d(TAG, "reset");
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.reset();
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean resume(@NotNull MediaRecorderInterface.MediaRecorderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            try {
                mediaRecorder.resume();
                resumeTimer();
                listener.onResumed();
                return true;
            } catch (Exception e) {
                printLog(e);
            }
        }
        return false;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setActionListener(@Nullable MediaRecorderInterface.ActionListener listener) {
        this.mListener = listener;
    }

    public final void setAudioChannels(int var1) {
        Log.d(TAG, "setAudioChannels");
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setAudioChannels(var1);
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setAudioEncoder(int var1) {
        Log.d(TAG, "setAudioEncoder");
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setAudioEncoder(var1);
        }
    }

    public final void setAudioEncodingBitRate(int var1) {
        Log.d(TAG, "setAudioEncodingBitRate");
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setAudioEncodingBitRate(var1);
        }
    }

    public final void setAudioSamplingRate(int var1) {
        Log.d(TAG, "setAudioSamplingRate");
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setAudioSamplingRate(var1);
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setAudioSource(int audioSource) {
        Log.d(TAG, "setAudioSource");
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setAudioSource(audioSource);
        }
    }

    public final void setMaxDuration(int duration) {
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setMaxDuration(duration);
        }
    }

    public final void setMaxFileSize(long fileSize) {
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setMaxFileSize(fileSize);
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setMediaRecorderConfig(@NotNull MediaRecorderConfigInterface mediaRecorderConfigInterface) {
        Intrinsics.checkNotNullParameter(mediaRecorderConfigInterface, "mediaRecorderConfigInterface");
        this.mMediaRecorderConfig = mediaRecorderConfigInterface;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setOutputFile(@Nullable String path) {
        Log.d(TAG, "setOutputFile");
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setOutputFile(path);
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setOutputFormat(int var1) {
        Log.d(TAG, "setOutputFormat");
        MediaRecorder mediaRecorder = this.mAndroidMediaRecorder;
        if (mediaRecorder != null) {
            mediaRecorder.setOutputFormat(var1);
        }
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public void setTimeListener(@Nullable MediaRecorderInterface.TimeListener listener) {
        this.mTimeListener = listener;
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean start(@NotNull String filePath, @NotNull MediaRecorderInterface.MediaRecorderListener listener, int maxDuration, int maxFileSize) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(listener, "listener");
        Log.d(TAG, "start");
        INSTANCE.setWaitTimeForStartRecording(1000L);
        this.mResultFilePath = filePath;
        this.mRecorderAsyncTask.setMMaxDuration(maxDuration);
        this.mRecorderAsyncTask.setMMaxFileSize(maxFileSize);
        return this.mRecorderAsyncTask.run(listener);
    }

    @Override // com.samsung.android.spen.libinterface.MediaRecorderInterface
    public boolean stop(@NotNull MediaRecorderInterface.MediaRecorderListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        Log.d(TAG, "stop");
        if (!cancel()) {
            return false;
        }
        listener.onStopped();
        return true;
    }
}
