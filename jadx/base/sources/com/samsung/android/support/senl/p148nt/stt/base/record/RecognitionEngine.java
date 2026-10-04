package com.samsung.android.support.senl.p148nt.stt.base.record;

import android.content.Context;
import android.media.AudioRecord;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.sdk.scs.p142ai.AiServices;
import com.samsung.android.sdk.scs.p142ai.asr.ConnectionType;
import com.samsung.android.sdk.scs.p142ai.asr.RecognitionConfig;
import com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener;
import com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognizer;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u0000 .2\u00020\u0001:\u0001.B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\"J\u0006\u0010)\u001a\u00020'J\b\u0010*\u001a\u00020'H\u0002J\b\u0010+\u001a\u00020'H\u0002J\u0006\u0010,\u001a\u00020'J\u0006\u0010-\u001a\u00020'R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0018@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0017\u001a\u00020\u001b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010#\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001a\"\u0004\b$\u0010%¨\u0006/"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/record/RecognitionEngine;", "", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mContext", "mRecognizer", "Lcom/samsung/android/sdk/scs/ai/asr/SpeechRecognizer;", "mConfig", "Lcom/samsung/android/sdk/scs/ai/asr/RecognitionConfig;", "locale", "Ljava/util/Locale;", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "mAudioRecorder", "Landroid/media/AudioRecord;", "mInputStream", "Ljava/io/InputStream;", "mOutputStream", "Ljava/io/PipedOutputStream;", "value", "", "isRecording", "()Z", "", "startRecordingTime", "getStartRecordingTime", "()J", "mExecutorService", "Ljava/util/concurrent/ExecutorService;", "mRecognitionListener", "Lcom/samsung/android/sdk/scs/ai/asr/SpeechRecognitionListener;", "isAutoTranscribeProgressing", "setAutoTranscribeProgressing", "(Z)V", "setRecognitionListener", "", "recognitionListener", "startRecognition", "init", "startAudioRecorder", "stopRecognition", "release", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RecognitionEngine {
    private static final int AUDIO_CHANNEL = 16;
    private static final int AUDIO_FORMAT = 2;
    private static final int AUDIO_SAMPLE_RATE = 16000;
    private static final int AUDIO_SOURCE = 1;
    private static final int BUFFER_SIZE = 320;

    @NotNull
    private static final String TAG = "RecognitionEngine";
    private boolean isAutoTranscribeProgressing;
    private boolean isRecording;

    @NotNull
    private Locale locale;

    @Nullable
    private AudioRecord mAudioRecorder;

    @Nullable
    private RecognitionConfig mConfig;

    @Nullable
    private Context mContext;

    @Nullable
    private ExecutorService mExecutorService;

    @Nullable
    private InputStream mInputStream;

    @Nullable
    private PipedOutputStream mOutputStream;

    @Nullable
    private SpeechRecognitionListener mRecognitionListener;

    @Nullable
    private SpeechRecognizer mRecognizer;
    private long startRecordingTime;

    public RecognitionEngine(@Nullable Context context) {
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        this.locale = US;
        Logger.m12710d(TAG, "Record Engine Constructor");
        this.mContext = context;
    }

    private final void init() {
        if (this.isRecording && this.mAudioRecorder != null) {
            this.mInputStream = null;
            this.isRecording = false;
            this.mAudioRecorder = null;
        }
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        SpeechRecognitionListener speechRecognitionListener = this.mRecognitionListener;
        Intrinsics.checkNotNull(speechRecognitionListener);
        SpeechRecognizer speechRecognizer = AiServices.getSpeechRecognizer(applicationContext, speechRecognitionListener);
        this.mRecognizer = speechRecognizer;
        Intrinsics.checkNotNull(speechRecognizer);
        speechRecognizer.init();
        this.mConfig = new RecognitionConfig.Builder().setLocale(this.locale).setType(ConnectionType.LOCAL).enableAudioCompression(true).enablePartialResult(true).enableSpeakerDiarisation(true).build();
    }

    private final void startAudioRecorder() {
        Context context = this.mContext;
        Intrinsics.checkNotNull(context);
        if (ContextCompat.checkSelfPermission(context, "android.permission.RECORD_AUDIO") != 0) {
            Logger.m12711e(TAG, "startAudioRecorder: checkSelfPermission RECORD_AUDIO NOT GRANTED");
            return;
        }
        this.mAudioRecorder = new AudioRecord(1, 16000, 16, 2, BUFFER_SIZE);
        ExecutorService executorServiceM3201k = AbstractC4539a.m3201k(TAG);
        this.mExecutorService = executorServiceM3201k;
        Intrinsics.checkNotNull(executorServiceM3201k);
        executorServiceM3201k.execute(new Runnable() { // from class: com.samsung.android.support.senl.nt.stt.base.record.RecognitionEngine.startAudioRecorder.1
            @Override // java.lang.Runnable
            public void run() {
                if (RecognitionEngine.this.mAudioRecorder == null) {
                    Logger.m12711e(RecognitionEngine.TAG, "startAudioRecorder: mAudioRecorder is null");
                    return;
                }
                AudioRecord audioRecord = RecognitionEngine.this.mAudioRecorder;
                Intrinsics.checkNotNull(audioRecord);
                audioRecord.startRecording();
                RecognitionEngine.this.isRecording = true;
                RecognitionEngine.this.startRecordingTime = System.currentTimeMillis();
                byte[] bArr = new byte[RecognitionEngine.BUFFER_SIZE];
                int i = 0;
                while (RecognitionEngine.this.getIsRecording()) {
                    try {
                        AudioRecord audioRecord2 = RecognitionEngine.this.mAudioRecorder;
                        Intrinsics.checkNotNull(audioRecord2);
                        int i2 = audioRecord2.read(bArr, 0, RecognitionEngine.BUFFER_SIZE);
                        PipedOutputStream pipedOutputStream = RecognitionEngine.this.mOutputStream;
                        Intrinsics.checkNotNull(pipedOutputStream);
                        pipedOutputStream.write(bArr, 0, i2);
                        i += i2;
                        if (i % 320000 == 0) {
                            Logger.m12710d(RecognitionEngine.TAG, "total byte size " + i);
                        }
                    } catch (Exception e) {
                        AbstractC12991c.m14005z("startAudioRecorder recording error: ", e.getMessage(), RecognitionEngine.TAG);
                    }
                }
                Logger.m12710d(RecognitionEngine.TAG, "total sent byte size " + i);
                try {
                    PipedOutputStream pipedOutputStream2 = RecognitionEngine.this.mOutputStream;
                    Intrinsics.checkNotNull(pipedOutputStream2);
                    pipedOutputStream2.close();
                    InputStream inputStream = RecognitionEngine.this.mInputStream;
                    Intrinsics.checkNotNull(inputStream);
                    inputStream.close();
                    Logger.m12710d(RecognitionEngine.TAG, "recording stopped");
                } catch (IOException e2) {
                    AbstractC12991c.m14005z("IOException : startAudioRecorder close stream error: ", e2.getMessage(), RecognitionEngine.TAG);
                } catch (Exception e3) {
                    AbstractC12991c.m14005z("Exception : startAudioRecorder close stream error: ", e3.getMessage(), RecognitionEngine.TAG);
                }
            }
        });
    }

    @NotNull
    public final Locale getLocale() {
        return this.locale;
    }

    public final long getStartRecordingTime() {
        return this.startRecordingTime;
    }

    public final boolean isAutoTranscribeProgressing() {
        Logger.m12713i(TAG, "isAutoTranscribeProgressing#get " + this.isAutoTranscribeProgressing);
        return this.isAutoTranscribeProgressing;
    }

    /* JADX INFO: renamed from: isRecording, reason: from getter */
    public final boolean getIsRecording() {
        return this.isRecording;
    }

    public final void release() {
        this.mContext = null;
        SpeechRecognizer speechRecognizer = this.mRecognizer;
        if (speechRecognizer != null) {
            Intrinsics.checkNotNull(speechRecognizer);
            speechRecognizer.release();
            this.mRecognizer = null;
        }
        AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord != null) {
            Intrinsics.checkNotNull(audioRecord);
            audioRecord.release();
            this.mAudioRecorder = null;
        }
    }

    public final void setAutoTranscribeProgressing(boolean z) {
        Logger.m12713i(TAG, "isAutoTranscribeProgressing#set " + z);
        this.isAutoTranscribeProgressing = z;
    }

    public final void setLocale(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "<set-?>");
        this.locale = locale;
    }

    public final void setRecognitionListener(@Nullable SpeechRecognitionListener recognitionListener) {
        this.mRecognitionListener = recognitionListener;
    }

    public final void startRecognition() {
        Logger.m12710d(TAG, "startRecognition");
        init();
        try {
            this.mOutputStream = new PipedOutputStream();
            this.mInputStream = new PipedInputStream(this.mOutputStream);
            startAudioRecorder();
            SpeechRecognizer speechRecognizer = this.mRecognizer;
            Intrinsics.checkNotNull(speechRecognizer);
            RecognitionConfig recognitionConfig = this.mConfig;
            Intrinsics.checkNotNull(recognitionConfig);
            InputStream inputStream = this.mInputStream;
            Intrinsics.checkNotNull(inputStream);
            speechRecognizer.start(recognitionConfig, inputStream);
            setAutoTranscribeProgressing(true);
        } catch (IOException e) {
            AbstractC12991c.m14005z("startRecognition error: ", e.getMessage(), TAG);
        }
    }

    public final void stopRecognition() {
        this.isRecording = false;
        setAutoTranscribeProgressing(false);
        AudioRecord audioRecord = this.mAudioRecorder;
        if (audioRecord != null) {
            try {
                Intrinsics.checkNotNull(audioRecord);
                audioRecord.stop();
            } catch (Exception e) {
                AbstractC12991c.m14005z("stopRecognition error: ", e.getMessage(), TAG);
            }
        }
    }
}
