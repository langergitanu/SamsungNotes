package com.samsung.android.support.senl.p148nt.stt.base.audio;

import android.content.Context;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizer;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001:B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0005\u0010\u0006J*\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0010\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u001f\u001a\u00020\u0015J\u0006\u0010 \u001a\u00020\u0015J\u0006\u0010!\u001a\u00020\u0015J\u0010\u0010\"\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004J\b\u0010#\u001a\u00020\u0015H\u0016J\u0012\u0010$\u001a\u00020\u00152\b\u0010%\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020)H\u0016J4\u0010*\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010\u00042\b\u0010,\u001a\u0004\u0018\u00010-2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010/2\u0006\u00101\u001a\u00020\u001aH\u0016J\b\u00102\u001a\u00020\u0015H\u0016J\u0010\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020)H\u0016J\u0012\u00105\u001a\u00020\u00152\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u00106\u001a\u00020\u00152\b\u00107\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u00108\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u00109\u001a\u00020\u0015H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006;"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertWorker;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/OnDecoderListener;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertStatusChangedListener;", "mSession", "", "<init>", "(Ljava/lang/String;)V", "mScsRecognizer", "Lcom/samsung/android/support/senl/nt/stt/base/audio/ScsRecognizer;", "mFastDecoder", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastDecoder;", "mListener", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertStateListener;", "mStartSendFile", "", "value", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertResultData;", "fastConvertResultData", "getFastConvertResultData", "()Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertResultData;", "startConvert", "", "context", "Landroid/content/Context;", "filePath", "isEnableAutoDetect", "", "locale", "Ljava/util/Locale;", "registerListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "unregisterListener", "stopConvert", "cancelConvert", "readPcmFile", "onDecodeStart", "onDecodeComplete", "path", "onDecoderError", "error", "errorCode", "", "onResultWord", "recognizeText", "timingInfo", "", "speechInfoList", "", "Lcom/samsung/android/sivs/ai/sdkcommon/asr/SpeechInfo;", "isNeedGetRawText", "onRecognitionStart", "onProgressUpdate", "percent", "onLocaleChanged", "onNoLangPackInstalled", "mChangedLocale", "onError", "onNoMatch", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class FastConvertWorker implements OnDecoderListener, FastConvertStatusChangedListener {

    @NotNull
    private static final String EMPTY_SESSION = "EMPTY_SESSION";

    @NotNull
    private static final String TAG = "FastConvertWorker";

    @Nullable
    private FastConvertResultData fastConvertResultData;

    @Nullable
    private FastDecoder mFastDecoder;

    @Nullable
    private FastConvertStateListener mListener;

    @Nullable
    private ScsRecognizer mScsRecognizer;

    @Nullable
    private final String mSession;
    private long mStartSendFile;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final ConcurrentHashMap<String, FastConvertWorker> mFastConvertWorkerMap = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertWorker$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", FastConvertWorker.EMPTY_SESSION, "mFastConvertWorkerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertWorker;", "getInstance", "session", "release", "", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final synchronized FastConvertWorker getInstance(@Nullable String session) {
            FastConvertWorker fastConvertWorker;
            try {
                Logger.m12713i(FastConvertWorker.TAG, "getInstance: ".concat(session == null ? "null" : session));
                if (session == null) {
                    session = FastConvertWorker.EMPTY_SESSION;
                }
                ConcurrentHashMap concurrentHashMap = FastConvertWorker.mFastConvertWorkerMap;
                Intrinsics.checkNotNull(concurrentHashMap);
                fastConvertWorker = (FastConvertWorker) concurrentHashMap.get(session);
                if (fastConvertWorker == null) {
                    fastConvertWorker = new FastConvertWorker(session);
                    FastConvertWorker.mFastConvertWorkerMap.putIfAbsent(session, fastConvertWorker);
                }
            } catch (Throwable th) {
                throw th;
            }
            return fastConvertWorker;
        }

        public final void release() {
            ConcurrentHashMap concurrentHashMap = FastConvertWorker.mFastConvertWorkerMap;
            Intrinsics.checkNotNull(concurrentHashMap);
            concurrentHashMap.clear();
        }

        private Companion() {
        }

        public final void release(@Nullable String session) {
            ConcurrentHashMap concurrentHashMap = FastConvertWorker.mFastConvertWorkerMap;
            Intrinsics.checkNotNull(concurrentHashMap);
            if (((FastConvertWorker) concurrentHashMap.get(session)) != null) {
                FastConvertWorker.mFastConvertWorkerMap.remove(session);
            }
        }
    }

    public FastConvertWorker(@Nullable String str) {
        this.mSession = str;
        ScsRecognizer.Companion companion = ScsRecognizer.INSTANCE;
        Intrinsics.checkNotNull(str);
        this.mScsRecognizer = companion.getInstance(str);
        this.mFastDecoder = FastDecoder.INSTANCE.getInstance(str);
    }

    public final void cancelConvert() {
        Logger.m12713i(TAG, "cancelConvert");
        FastDecoder fastDecoder = this.mFastDecoder;
        Intrinsics.checkNotNull(fastDecoder);
        fastDecoder.unregisterListener();
        FastDecoder fastDecoder2 = this.mFastDecoder;
        Intrinsics.checkNotNull(fastDecoder2);
        fastDecoder2.cancelFastDecoder();
        ScsRecognizer scsRecognizer = this.mScsRecognizer;
        Intrinsics.checkNotNull(scsRecognizer);
        scsRecognizer.setStatusChangedListener(null);
        ScsRecognizer scsRecognizer2 = this.mScsRecognizer;
        Intrinsics.checkNotNull(scsRecognizer2);
        scsRecognizer2.cancelRecognize();
        ConcurrentHashMap<String, FastConvertWorker> concurrentHashMap = mFastConvertWorkerMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(this.mSession);
        }
        unregisterListener();
    }

    @Nullable
    public final FastConvertResultData getFastConvertResultData() {
        return this.fastConvertResultData;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.OnDecoderListener
    public void onDecodeComplete(@Nullable String path) {
        Logger.m12713i(TAG, "onPartialDecodeComplete : " + path);
        readPcmFile(path);
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.OnDecoderListener
    public void onDecodeStart() {
        Logger.m12713i(TAG, "onDecodeStart");
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.OnDecoderListener
    public void onDecoderError(@NotNull String error, int errorCode) {
        Intrinsics.checkNotNullParameter(error, "error");
        String str = "Decode " + error;
        FastConvertStateListener fastConvertStateListener = this.mListener;
        if (fastConvertStateListener != null) {
            Intrinsics.checkNotNull(fastConvertStateListener);
            String str2 = this.mSession;
            Intrinsics.checkNotNull(str2);
            fastConvertStateListener.updateState(str2, 16, str, errorCode);
        }
        cancelConvert();
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStatusChangedListener
    public void onError(@Nullable String error) {
        Logger.m12711e(TAG, "Fast convert " + this.mSession + " - error: " + error);
        String strM772n = AbstractC0541b.m772n("ASR failed: ", error);
        FastConvertStateListener fastConvertStateListener = this.mListener;
        if (fastConvertStateListener != null) {
            Intrinsics.checkNotNull(fastConvertStateListener);
            String str = this.mSession;
            Intrinsics.checkNotNull(str);
            fastConvertStateListener.updateState(str, 16, strM772n, 2);
        }
        cancelConvert();
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStatusChangedListener
    public void onLocaleChanged(@Nullable Locale locale) {
        FastConvertStateListener fastConvertStateListener = this.mListener;
        if (fastConvertStateListener != null) {
            Intrinsics.checkNotNull(fastConvertStateListener);
            String str = this.mSession;
            Intrinsics.checkNotNull(str);
            fastConvertStateListener.onLocaleChanged(str, locale);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStatusChangedListener
    public void onNoLangPackInstalled(@Nullable Locale mChangedLocale) {
        FastConvertStateListener fastConvertStateListener = this.mListener;
        if (fastConvertStateListener != null) {
            Intrinsics.checkNotNull(fastConvertStateListener);
            String str = this.mSession;
            Intrinsics.checkNotNull(str);
            fastConvertStateListener.onNoLangPackInstalled(str, mChangedLocale);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStatusChangedListener
    public void onNoMatch() {
        FastConvertStateListener fastConvertStateListener = this.mListener;
        if (fastConvertStateListener != null) {
            Intrinsics.checkNotNull(fastConvertStateListener);
            String str = this.mSession;
            Intrinsics.checkNotNull(str);
            fastConvertStateListener.onNoMatch(str);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStatusChangedListener
    public void onProgressUpdate(int percent) {
        FastConvertStateListener fastConvertStateListener = this.mListener;
        if (fastConvertStateListener != null) {
            Intrinsics.checkNotNull(fastConvertStateListener);
            String str = this.mSession;
            Intrinsics.checkNotNull(str);
            fastConvertStateListener.onUpdateProgress(str, percent);
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStatusChangedListener
    public void onResultWord(@Nullable String recognizeText, @Nullable int[] timingInfo, @Nullable List<? extends SpeechInfo> speechInfoList, boolean isNeedGetRawText) {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.mStartSendFile;
        Logger.m12713i(TAG, "receive Fast convert ASR result");
        Logger.m12713i(TAG, "total ASR time (transfer+ASR+SD): " + jCurrentTimeMillis);
        stopConvert();
        this.fastConvertResultData = new FastConvertResultData(recognizeText, timingInfo, speechInfoList, true, isNeedGetRawText);
        FastConvertStateListener fastConvertStateListener = this.mListener;
        if (fastConvertStateListener != null) {
            Intrinsics.checkNotNull(fastConvertStateListener);
            String str = this.mSession;
            Intrinsics.checkNotNull(str);
            fastConvertStateListener.updateState(str, 15, null, -1);
        }
    }

    public final void readPcmFile(@Nullable String filePath) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.mStartSendFile = jCurrentTimeMillis;
        Logger.m12713i(TAG, "send inputStream to SCS: " + jCurrentTimeMillis);
        if (this.mScsRecognizer == null) {
            ScsRecognizer.Companion companion = ScsRecognizer.INSTANCE;
            String str = this.mSession;
            Intrinsics.checkNotNull(str);
            this.mScsRecognizer = companion.getInstance(str);
        }
        if (filePath != null) {
            ScsRecognizer scsRecognizer = this.mScsRecognizer;
            Intrinsics.checkNotNull(scsRecognizer);
            if (scsRecognizer.startRecognizer(filePath)) {
                FastConvertStateListener fastConvertStateListener = this.mListener;
                if (fastConvertStateListener != null) {
                    Intrinsics.checkNotNull(fastConvertStateListener);
                    String str2 = this.mSession;
                    Intrinsics.checkNotNull(str2);
                    fastConvertStateListener.updateState(str2, 14, null, -1);
                    return;
                }
                return;
            }
        }
        FastConvertStateListener fastConvertStateListener2 = this.mListener;
        if (fastConvertStateListener2 != null) {
            Intrinsics.checkNotNull(fastConvertStateListener2);
            String str3 = this.mSession;
            Intrinsics.checkNotNull(str3);
            fastConvertStateListener2.updateState(str3, 16, "mScsRecognizer.startRecognizer false", 0);
        }
    }

    public final void registerListener(@Nullable FastConvertStateListener listener) {
        this.mListener = listener;
    }

    public final void startConvert(@Nullable Context context, @NotNull String filePath, boolean isEnableAutoDetect, @Nullable Locale locale) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Logger.m12713i(TAG, " startConvert " + filePath);
        if (this.mScsRecognizer == null) {
            ScsRecognizer.Companion companion = ScsRecognizer.INSTANCE;
            String str = this.mSession;
            Intrinsics.checkNotNull(str);
            this.mScsRecognizer = companion.getInstance(str);
        }
        ScsRecognizer scsRecognizer = this.mScsRecognizer;
        Intrinsics.checkNotNull(scsRecognizer);
        scsRecognizer.setIsFastConvert(true);
        ScsRecognizer scsRecognizer2 = this.mScsRecognizer;
        Intrinsics.checkNotNull(scsRecognizer2);
        scsRecognizer2.setStatusChangedListener(this);
        if (this.mFastDecoder == null) {
            String str2 = this.mSession;
            Intrinsics.checkNotNull(str2);
            this.mFastDecoder = new FastDecoder(str2);
        }
        FastDecoder fastDecoder = this.mFastDecoder;
        Intrinsics.checkNotNull(fastDecoder);
        fastDecoder.registerListener(this);
        FastDecoder fastDecoder2 = this.mFastDecoder;
        Intrinsics.checkNotNull(fastDecoder2);
        fastDecoder2.startFastDecoder(filePath);
        FastConvertStateListener fastConvertStateListener = this.mListener;
        if (fastConvertStateListener != null) {
            Intrinsics.checkNotNull(fastConvertStateListener);
            String str3 = this.mSession;
            Intrinsics.checkNotNull(str3);
            fastConvertStateListener.updateState(str3, 13, null, -1);
        }
        ScsRecognizer scsRecognizer3 = this.mScsRecognizer;
        Intrinsics.checkNotNull(scsRecognizer3);
        scsRecognizer3.setEnableAutoDetect(isEnableAutoDetect);
        ScsRecognizer scsRecognizer4 = this.mScsRecognizer;
        Intrinsics.checkNotNull(scsRecognizer4);
        scsRecognizer4.setRecognizeLocale(locale);
        ScsRecognizer scsRecognizer5 = this.mScsRecognizer;
        Intrinsics.checkNotNull(scsRecognizer5);
        scsRecognizer5.startRecognition(context);
    }

    public final void stopConvert() {
        Logger.m12713i(TAG, "stopConvert");
        FastDecoder fastDecoder = this.mFastDecoder;
        Intrinsics.checkNotNull(fastDecoder);
        fastDecoder.cancelFastDecoder();
    }

    public final void unregisterListener() {
        this.mListener = null;
    }

    @Override // com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertStatusChangedListener
    public void onRecognitionStart() {
    }
}
