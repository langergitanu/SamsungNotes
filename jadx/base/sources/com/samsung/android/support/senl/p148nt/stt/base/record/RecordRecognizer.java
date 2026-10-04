package com.samsung.android.support.senl.p148nt.stt.base.record;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.DialogInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertController;
import com.samsung.android.support.senl.p148nt.stt.base.audio.FastConvertResultData;
import com.samsung.android.support.senl.p148nt.stt.base.listener.STTRecognizeListener;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00011B\u001b\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\u001a\u001a\u00020\u0018J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0012\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!2\u0006\u0010#\u001a\u00020$H\u0003J\u0006\u0010%\u001a\u00020\u0018J\u0006\u0010&\u001a\u00020\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0011\u0010'\u001a\u00020\u001c8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R$\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u001f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u00062"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/record/RecordRecognizer;", "", "context", "Landroid/content/Context;", "sessionID", "", "<init>", "(Landroid/content/Context;Ljava/lang/String;)V", "mRecognitionEngine", "Lcom/samsung/android/support/senl/nt/stt/base/record/RecognitionEngine;", "mSTTRecognizeListener", "Lcom/samsung/android/support/senl/nt/stt/base/listener/STTRecognizeListener;", "currentSessionID", "getCurrentSessionID", "()Ljava/lang/String;", "setCurrentSessionID", "(Ljava/lang/String;)V", "autoTranscribeResultData", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertResultData;", "getAutoTranscribeResultData", "()Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertResultData;", "setAutoTranscribeResultData", "(Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertResultData;)V", "setSTTRecognizeListener", "", "sttRecognizeListener", "startVoiceRecognition", "checkCountryNeedGetRawText", "", "isLanguageNeedGetRawText", "locale", "Ljava/util/Locale;", "getSpeechInfoList", "", "Lcom/samsung/android/sivs/ai/sdkcommon/asr/SpeechInfo;", "bundle", "Landroid/os/Bundle;", "stopVoiceRecognition", "release", "isRecording", "()Z", "startRecodingTime", "", "getStartRecodingTime", "()J", "getLocale", "()Ljava/util/Locale;", "setLocale", "(Ljava/util/Locale;)V", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class RecordRecognizer {

    @NotNull
    private static final String TAG = "RecordRecognizer";

    @Nullable
    private static RecordRecognizer mInstance;

    @Nullable
    private FastConvertResultData autoTranscribeResultData;

    @Nullable
    private String currentSessionID;

    @NotNull
    private final RecognitionEngine mRecognitionEngine;

    @Nullable
    private STTRecognizeListener mSTTRecognizeListener;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final ConcurrentHashMap<String, RecordRecognizer> mRecordRecognizerMap = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/record/RecordRecognizer$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "mInstance", "Lcom/samsung/android/support/senl/nt/stt/base/record/RecordRecognizer;", "mRecordRecognizerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "getInstance", "context", "Landroid/content/Context;", "session", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final synchronized RecordRecognizer getInstance(@NotNull Context context, @NotNull String session) {
            RecordRecognizer recordRecognizer;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(session, "session");
            recordRecognizer = (RecordRecognizer) RecordRecognizer.mRecordRecognizerMap.get(session);
            if (recordRecognizer == null) {
                recordRecognizer = new RecordRecognizer(context, session, null);
                RecordRecognizer.mRecordRecognizerMap.putIfAbsent(session, recordRecognizer);
            }
            return recordRecognizer;
        }

        private Companion() {
        }
    }

    public /* synthetic */ RecordRecognizer(Context context, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean checkCountryNeedGetRawText() {
        boolean zIsLanguageNeedGetRawText = isLanguageNeedGetRawText(getLocale());
        Logger.m12713i(TAG, "checkCountryNeedGetRawText: " + zIsLanguageNeedGetRawText);
        return zIsLanguageNeedGetRawText;
    }

    @JvmStatic
    @NotNull
    public static final synchronized RecordRecognizer getInstance(@NotNull Context context, @NotNull String str) {
        return INSTANCE.getInstance(context, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"RestrictedApi"})
    public final List<SpeechInfo> getSpeechInfoList(Bundle bundle) {
        ArrayList arrayList = new ArrayList();
        bundle.setClassLoader(DialogInfo.class.getClassLoader());
        DialogInfo dialogInfo = Build.VERSION.SDK_INT >= 33 ? (DialogInfo) bundle.getParcelable("dialog_info", DialogInfo.class) : (DialogInfo) bundle.getParcelable("dialog_info");
        return dialogInfo != null ? dialogInfo.getSpeakerInfos() : arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean isLanguageNeedGetRawText(Locale locale) {
        boolean z;
        if (locale != null) {
            String languageTag = locale.toLanguageTag();
            Intrinsics.checkNotNullExpressionValue(languageTag, "toLanguageTag(...)");
            if (!StringsKt.m14162r(languageTag, "zh")) {
                String languageTag2 = locale.toLanguageTag();
                Intrinsics.checkNotNullExpressionValue(languageTag2, "toLanguageTag(...)");
                if (!StringsKt.m14162r(languageTag2, LangPackConfigConstants.LANGUAGE_CODE_JA)) {
                    z = false;
                }
            }
            z = true;
        }
        Logger.m12710d(TAG, "isLanguageNeedGetRawText# " + locale + " " + z);
        return z;
    }

    @Nullable
    public final FastConvertResultData getAutoTranscribeResultData() {
        return this.autoTranscribeResultData;
    }

    @Nullable
    public final String getCurrentSessionID() {
        return this.currentSessionID;
    }

    @NotNull
    public final Locale getLocale() {
        return this.mRecognitionEngine.getLocale();
    }

    public final long getStartRecodingTime() {
        return this.mRecognitionEngine.getStartRecordingTime();
    }

    public final boolean isRecording() {
        return this.mRecognitionEngine.getIsRecording();
    }

    public final void release() {
        AbstractC12991c.m14005z("release# sessionID = ", this.currentSessionID, TAG);
        FastConvertController.INSTANCE.getInstance().removeAutoTranscribeConvertItem(this.currentSessionID);
        this.mRecognitionEngine.release();
        mInstance = null;
        this.autoTranscribeResultData = null;
    }

    public final void setAutoTranscribeResultData(@Nullable FastConvertResultData fastConvertResultData) {
        this.autoTranscribeResultData = fastConvertResultData;
    }

    public final void setCurrentSessionID(@Nullable String str) {
        this.currentSessionID = str;
    }

    public final void setLocale(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, "locale");
        this.mRecognitionEngine.setLocale(locale);
    }

    public final void setSTTRecognizeListener(@Nullable STTRecognizeListener sttRecognizeListener) {
        this.mSTTRecognizeListener = sttRecognizeListener;
    }

    public final void startVoiceRecognition() {
        Logger.m12710d(TAG, "startVoiceRecognition");
        try {
            this.mRecognitionEngine.setRecognitionListener(new SpeechRecognitionListener() { // from class: com.samsung.android.support.senl.nt.stt.base.record.RecordRecognizer.startVoiceRecognition.1
                @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
                public void onError(int code, String message, Bundle bundle) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Intrinsics.checkNotNullParameter(bundle, "bundle");
                    Logger.m12711e(RecordRecognizer.TAG, "recognitionListener onError: code: " + code + " message: " + message);
                    if (RecordRecognizer.this.mSTTRecognizeListener != null) {
                        STTRecognizeListener sTTRecognizeListener = RecordRecognizer.this.mSTTRecognizeListener;
                        Intrinsics.checkNotNull(sTTRecognizeListener);
                        sTTRecognizeListener.onError(RecordRecognizer.this.getCurrentSessionID(), code, message);
                    }
                    RecordRecognizer.this.stopVoiceRecognition();
                    RecordRecognizer.this.release();
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0071  */
                @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
                @SuppressLint({"RestrictedApi"})
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onPartialResults(String partialResult, Bundle extra) {
                    String str;
                    Intrinsics.checkNotNullParameter(partialResult, "partialResult");
                    Logger.m12710d(RecordRecognizer.TAG, "onPartialResults: " + partialResult);
                    if (extra == null) {
                        Logger.m12710d(RecordRecognizer.TAG, "handlePartialResults bundle extra null");
                        if (RecordRecognizer.this.mSTTRecognizeListener != null) {
                            STTRecognizeListener sTTRecognizeListener = RecordRecognizer.this.mSTTRecognizeListener;
                            Intrinsics.checkNotNull(sTTRecognizeListener);
                            sTTRecognizeListener.onPartialResultWord(RecordRecognizer.this.getCurrentSessionID(), partialResult, null, null, false);
                            return;
                        }
                        return;
                    }
                    int[] intArray = extra.getIntArray("timing_info");
                    List<? extends SpeechInfo> speechInfoList = RecordRecognizer.this.getSpeechInfoList(extra);
                    if (RecordRecognizer.this.mSTTRecognizeListener != null) {
                        boolean zCheckCountryNeedGetRawText = RecordRecognizer.this.checkCountryNeedGetRawText();
                        if (zCheckCountryNeedGetRawText) {
                            String string = extra.getString("result_rawtext");
                            if (TextUtils.isEmpty(string)) {
                                str = partialResult;
                            } else {
                                Logger.m12713i(RecordRecognizer.TAG, "handleResult get rawtext");
                                Intrinsics.checkNotNull(string);
                                str = string;
                            }
                        }
                        STTRecognizeListener sTTRecognizeListener2 = RecordRecognizer.this.mSTTRecognizeListener;
                        Intrinsics.checkNotNull(sTTRecognizeListener2);
                        sTTRecognizeListener2.onPartialResultWord(RecordRecognizer.this.getCurrentSessionID(), str, intArray, speechInfoList, zCheckCountryNeedGetRawText);
                    }
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x0060  */
                @Override // com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognitionListener
                @SuppressLint({"RestrictedApi"})
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onResults(String result, Bundle bundle) {
                    String str;
                    Intrinsics.checkNotNullParameter(result, "result");
                    if (bundle == null) {
                        Logger.m12710d(RecordRecognizer.TAG, "handleResults bundle extra null");
                        if (RecordRecognizer.this.mSTTRecognizeListener != null) {
                            STTRecognizeListener sTTRecognizeListener = RecordRecognizer.this.mSTTRecognizeListener;
                            Intrinsics.checkNotNull(sTTRecognizeListener);
                            sTTRecognizeListener.onPartialResultWord(RecordRecognizer.this.getCurrentSessionID(), result, null, null, false);
                            return;
                        }
                        return;
                    }
                    int[] intArray = bundle.getIntArray("timing_info");
                    List<? extends SpeechInfo> speechInfoList = RecordRecognizer.this.getSpeechInfoList(bundle);
                    if (RecordRecognizer.this.mSTTRecognizeListener != null) {
                        boolean zCheckCountryNeedGetRawText = RecordRecognizer.this.checkCountryNeedGetRawText();
                        if (zCheckCountryNeedGetRawText) {
                            String string = bundle.getString("result_rawtext");
                            if (TextUtils.isEmpty(string)) {
                                str = result;
                            } else {
                                Logger.m12713i(RecordRecognizer.TAG, "handleResult get rawtext");
                                Intrinsics.checkNotNull(string);
                                str = string;
                            }
                            STTRecognizeListener sTTRecognizeListener2 = RecordRecognizer.this.mSTTRecognizeListener;
                            Intrinsics.checkNotNull(sTTRecognizeListener2);
                            sTTRecognizeListener2.onResultWord(RecordRecognizer.this.getCurrentSessionID(), str, intArray, speechInfoList, zCheckCountryNeedGetRawText);
                        }
                    }
                    RecordRecognizer.this.stopVoiceRecognition();
                    RecordRecognizer.this.release();
                }
            });
            this.mRecognitionEngine.startRecognition();
        } catch (Exception e) {
            e.printStackTrace();
            AbstractC12991c.m14005z("failed voice recognition, ", e.getMessage(), TAG);
        }
    }

    public final void stopVoiceRecognition() {
        Logger.m12710d(TAG, "stopVoiceRecognition");
        this.mRecognitionEngine.stopRecognition();
    }

    private RecordRecognizer(Context context, String str) {
        this.mRecognitionEngine = new RecognitionEngine(context);
        this.currentSessionID = str;
    }
}
