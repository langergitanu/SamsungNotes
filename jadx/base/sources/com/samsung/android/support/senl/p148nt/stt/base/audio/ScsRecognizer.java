package com.samsung.android.support.senl.p148nt.stt.base.audio;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.microsoft.identity.common.java.WarningType;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.sdk.scs.p142ai.AiServices;
import com.samsung.android.sdk.scs.p142ai.asr.ConnectionType;
import com.samsung.android.sdk.scs.p142ai.asr.DictationType;
import com.samsung.android.sdk.scs.p142ai.asr.RecognitionConfig;
import com.samsung.android.sdk.scs.p142ai.asr.SpeechRecognizer;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.DialogInfo;
import com.samsung.android.sivs.p144ai.sdkcommon.asr.SpeechInfo;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.AiLanguageHelper;
import com.samsung.android.support.senl.p148nt.base.winset.app.language.STTLanguageHelper;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.support.senl.p148nt.stt.common.Logger;
import com.samsung.android.support.senl.p148nt.stt.view.language.LanguageInfo;
import com.samsung.android.support.senl.p148nt.stt.view.language.STTLanguageManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.AbstractC12991c;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;
import p092W3.C0332a;
import p100Y3.C0348a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(m13885d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 32\u00020\u0001:\u00013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000fJ\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u000fJ\u0010\u0010\u0019\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010\u001b\u001a\u00020\u00152\b\u0010\u001c\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fJ\u0010\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u0003H\u0007J\u001c\u0010\"\u001a\u00020\u00152\b\u0010#\u001a\u0004\u0018\u00010\u00032\b\u0010$\u001a\u0004\u0018\u00010%H\u0007J\u000e\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u0003J\u0010\u0010(\u001a\u00020\u00152\b\u0010)\u001a\u0004\u0018\u00010\rJ\u0018\u0010*\u001a\u00020\u00152\u0006\u0010+\u001a\u00020,2\b\u0010-\u001a\u0004\u0018\u00010\u0003J\u0012\u0010.\u001a\u00020\u00152\b\u0010-\u001a\u0004\u0018\u00010\u0003H\u0002J\u0006\u0010/\u001a\u00020\u0015J\u0006\u00100\u001a\u00020\u0015J\b\u00101\u001a\u00020\u000fH\u0002J\u0012\u00102\u001a\u00020\u000f2\b\u0010)\u001a\u0004\u0018\u00010\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/ScsRecognizer;", "", "mSession", "", "<init>", "(Ljava/lang/String;)V", "mSpeechRecognizer", "Lcom/samsung/android/sdk/scs/ai/asr/SpeechRecognizer;", "mType", "Lcom/samsung/android/sdk/scs/ai/asr/ConnectionType;", "mFastConvertStatusChangedListener", "Lcom/samsung/android/support/senl/nt/stt/base/audio/FastConvertStatusChangedListener;", "mRecognizeLocale", "Ljava/util/Locale;", "mIsFastConvert", "", "mPCMInputStream", "Ljava/io/FileInputStream;", "mChangedLocale", "mIsEnableAutoDetect", "setEnableAutoDetect", "", "enableAutoDetect", "setIsFastConvert", "isFastConvert", "setStatusChangedListener", "fastConvertStatusChangedListener", "setRecognizeLocale", "recognizeLocale", "startRecognition", "context", "Landroid/content/Context;", "startRecognizer", "pcmPath", "handleFinalResult", "result", "extra", "Landroid/os/Bundle;", "handleProgressUpdate", "percentString", "handleLocaleChanged", "locale", "handleServerError", "errorCode", "", "error", "handleLegacyError", "cancelRecognize", "destroy", "checkCountryNeedGetRawText", "isLanguageNeedGetRawText", "Companion", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
@SourceDebugExtension({"SMAP\nScsRecognizer.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ScsRecognizer.kt\ncom/samsung/android/support/senl/nt/stt/base/audio/ScsRecognizer\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,383:1\n1#2:384\n37#3:385\n36#3,3:386\n*S KotlinDebug\n*F\n+ 1 ScsRecognizer.kt\ncom/samsung/android/support/senl/nt/stt/base/audio/ScsRecognizer\n*L\n116#1:385\n116#1:386,3\n*E\n"})
public final class ScsRecognizer {

    @NotNull
    private static final String ERROR_INIT_NOT_CALLED = "INIT_NOT_CALLED";

    @NotNull
    private static final String ERROR_NO_LID_LANGUAGE_PACKAGE_INSTALLED = "NO_LID_LANGUAGE_PACKAGE_INSTALLED";

    @NotNull
    private static final String ERROR_NO_LID_SERVICE = "No LID SERVICE";

    @NotNull
    private static final String ERROR_NO_PROPER_LANGUAGE_PACKAGE_INSTALLED = "NO_PROPER_LANGUAGE_PACKAGE_INSTALLED";

    @NotNull
    private static final String ERROR_NO_TARGET_SERVICE = "No Target Service";

    @NotNull
    private static final String EXCEPTION_ERROR_NO_LID_SERVICE = "java.lang.RuntimeException: No LID SERVICE";

    @NotNull
    private static final String EXCEPTION_ERROR_NO_TARGET_SERVICE = "java.lang.RuntimeException: No Target Service";

    @NotNull
    private static final String MAIN_SESSION = "stt_fast_convert_main_session";

    @NotNull
    private static final String TAG = "ScsRecognizer";

    @Nullable
    private Locale mChangedLocale;

    @Nullable
    private FastConvertStatusChangedListener mFastConvertStatusChangedListener;
    private boolean mIsEnableAutoDetect;
    private boolean mIsFastConvert;

    @Nullable
    private FileInputStream mPCMInputStream;

    @Nullable
    private Locale mRecognizeLocale;

    @NotNull
    private final String mSession;

    @Nullable
    private SpeechRecognizer mSpeechRecognizer;

    @Nullable
    private ConnectionType mType;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static final ConcurrentHashMap<String, ScsRecognizer> mRecognizerMap = new ConcurrentHashMap<>();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/stt/base/audio/ScsRecognizer$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "MAIN_SESSION", "ERROR_NO_PROPER_LANGUAGE_PACKAGE_INSTALLED", "ERROR_NO_LID_LANGUAGE_PACKAGE_INSTALLED", "ERROR_NO_TARGET_SERVICE", "EXCEPTION_ERROR_NO_TARGET_SERVICE", "ERROR_NO_LID_SERVICE", "EXCEPTION_ERROR_NO_LID_SERVICE", "ERROR_INIT_NOT_CALLED", "mRecognizerMap", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/samsung/android/support/senl/nt/stt/base/audio/ScsRecognizer;", "getInstance", "session", "defaultDeviceLocale", "Ljava/util/Locale;", "getDefaultDeviceLocale", "()Ljava/util/Locale;", "ntStt_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Locale getDefaultDeviceLocale() {
            Locale localeForLanguageTag = Locale.forLanguageTag(AiLanguageHelper.convertToLanguageTag(Locale.getDefault().toLanguageTag()));
            Intrinsics.checkNotNullExpressionValue(localeForLanguageTag, "forLanguageTag(...)");
            return localeForLanguageTag;
        }

        @NotNull
        public final synchronized ScsRecognizer getInstance(@NotNull String session) {
            ScsRecognizer scsRecognizer;
            Intrinsics.checkNotNullParameter(session, "session");
            ConcurrentHashMap concurrentHashMap = ScsRecognizer.mRecognizerMap;
            Intrinsics.checkNotNull(concurrentHashMap);
            scsRecognizer = (ScsRecognizer) concurrentHashMap.get(session);
            if (scsRecognizer == null) {
                scsRecognizer = new ScsRecognizer(session);
                ScsRecognizer.mRecognizerMap.putIfAbsent(session, scsRecognizer);
            }
            return scsRecognizer;
        }

        private Companion() {
        }
    }

    public ScsRecognizer(@NotNull String mSession) {
        Intrinsics.checkNotNullParameter(mSession, "mSession");
        this.mSession = mSession;
    }

    private final boolean checkCountryNeedGetRawText() {
        boolean zIsLanguageNeedGetRawText = this.mIsEnableAutoDetect ? isLanguageNeedGetRawText(this.mChangedLocale) : isLanguageNeedGetRawText(this.mRecognizeLocale);
        Logger.m12713i(TAG, "checkCountryNeedGetRawText: " + zIsLanguageNeedGetRawText);
        return zIsLanguageNeedGetRawText;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003d, code lost:
    
        if (r3.equals(com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizer.ERROR_NO_LID_SERVICE) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0046, code lost:
    
        if (r3.equals(com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizer.ERROR_NO_TARGET_SERVICE) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004f, code lost:
    
        if (r3.equals(com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizer.EXCEPTION_ERROR_NO_TARGET_SERVICE) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0058, code lost:
    
        if (r3.equals(com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizer.EXCEPTION_ERROR_NO_LID_SERVICE) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        if (r3.equals(com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizer.ERROR_NO_LID_LANGUAGE_PACKAGE_INSTALLED) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006a, code lost:
    
        if (r3.equals(com.samsung.android.support.senl.p148nt.stt.base.audio.ScsRecognizer.ERROR_INIT_NOT_CALLED) == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0081, code lost:
    
        r3 = r2.mFastConvertStatusChangedListener;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0083, code lost:
    
        if (r3 == null) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0085, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r3);
        r3.onLocaleChanged(r2.mChangedLocale);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void handleLegacyError(String error) {
        SpeechRecognizer speechRecognizer;
        FastConvertStatusChangedListener fastConvertStatusChangedListener;
        Logger.m12710d(TAG, "handleLegacyError : ".concat(error == null ? "null" : error));
        if (error == null) {
            Logger.m12711e(TAG, "handleLegacyError error null");
        }
        switch (error.hashCode()) {
            case -1735919336:
                break;
            case -1683920784:
                break;
            case -1650331282:
                break;
            case -1466867116:
                break;
            case -728287419:
                break;
            case 248556061:
                break;
            case 1093058731:
                if (error.equals(ERROR_NO_PROPER_LANGUAGE_PACKAGE_INSTALLED)) {
                    FastConvertStatusChangedListener fastConvertStatusChangedListener2 = this.mFastConvertStatusChangedListener;
                    if (fastConvertStatusChangedListener2 != null) {
                        Intrinsics.checkNotNull(fastConvertStatusChangedListener2);
                        fastConvertStatusChangedListener2.onNoLangPackInstalled(this.mChangedLocale);
                    }
                }
                speechRecognizer = this.mSpeechRecognizer;
                if (speechRecognizer != null) {
                    Intrinsics.checkNotNull(speechRecognizer);
                    speechRecognizer.cancel();
                }
                fastConvertStatusChangedListener = this.mFastConvertStatusChangedListener;
                if (fastConvertStatusChangedListener == null) {
                    Intrinsics.checkNotNull(fastConvertStatusChangedListener);
                    fastConvertStatusChangedListener.onError(error);
                }
                break;
            default:
                speechRecognizer = this.mSpeechRecognizer;
                if (speechRecognizer != null) {
                }
                fastConvertStatusChangedListener = this.mFastConvertStatusChangedListener;
                if (fastConvertStatusChangedListener == null) {
                }
                break;
        }
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale startRecognizer$lambda$1(String str) {
        Locale localeForLanguageTag = Locale.forLanguageTag(str);
        String language = localeForLanguageTag.getLanguage();
        String country = localeForLanguageTag.getCountry();
        StringBuilder sbM16m = AbstractC0000a.m16m("setAlternativeLocales downloadedLocale : ", str, " ", language, " ");
        sbM16m.append(country);
        sbM16m.append(" ");
        sbM16m.append(localeForLanguageTag);
        Logger.m12713i(TAG, sbM16m.toString());
        return localeForLanguageTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale startRecognizer$lambda$2(Function1 function1, Object obj) {
        return (Locale) function1.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale[] startRecognizer$lambda$3(int i) {
        return new Locale[i];
    }

    public final synchronized void cancelRecognize() {
        Logger.m12713i(TAG, "---- cancelRecognize");
        destroy();
    }

    public final void destroy() {
        Logger.m12713i(TAG, "destroy");
        SpeechRecognizer speechRecognizer = this.mSpeechRecognizer;
        if (speechRecognizer != null) {
            Intrinsics.checkNotNull(speechRecognizer);
            speechRecognizer.release();
        }
        ConcurrentHashMap<String, ScsRecognizer> concurrentHashMap = mRecognizerMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.remove(this.mSession);
        }
    }

    @SuppressLint({"RestrictedApi"})
    public final void handleFinalResult(@Nullable String result, @Nullable Bundle extra) {
        Logger.m12710d(TAG, "---- handleFinalResult");
        FileInputStream fileInputStream = this.mPCMInputStream;
        if (fileInputStream != null) {
            try {
                Intrinsics.checkNotNull(fileInputStream);
                fileInputStream.close();
            } catch (Exception e) {
                Logger.m12712e(TAG, "can not close mPCMInputStream ", e);
            }
        }
        if (extra == null) {
            Logger.m12710d(TAG, "handleFinalResult bundle extra null");
            FastConvertStatusChangedListener fastConvertStatusChangedListener = this.mFastConvertStatusChangedListener;
            if (fastConvertStatusChangedListener != null) {
                Intrinsics.checkNotNull(fastConvertStatusChangedListener);
                fastConvertStatusChangedListener.onResultWord(null, null, null, false);
                return;
            }
            return;
        }
        int[] intArray = extra.getIntArray("timing_info");
        List<SpeechInfo> arrayList = new ArrayList<>();
        extra.setClassLoader(DialogInfo.class.getClassLoader());
        DialogInfo dialogInfo = Build.VERSION.SDK_INT >= 33 ? (DialogInfo) extra.getParcelable("dialog_info", DialogInfo.class) : (DialogInfo) extra.getParcelable("dialog_info");
        if (dialogInfo != null) {
            arrayList = dialogInfo.getSpeakerInfos();
            Intrinsics.checkNotNullExpressionValue(arrayList, "getSpeakerInfos(...)");
        }
        if (this.mFastConvertStatusChangedListener == null) {
            AbstractC12991c.m14005z("listener == null in session", this.mSession, TAG);
            return;
        }
        boolean zCheckCountryNeedGetRawText = checkCountryNeedGetRawText();
        if (zCheckCountryNeedGetRawText) {
            String string = extra.getString("result_rawtext");
            if (!TextUtils.isEmpty(string)) {
                Logger.m12713i(TAG, "onResults get rawtext");
                result = string;
            }
        }
        FastConvertStatusChangedListener fastConvertStatusChangedListener2 = this.mFastConvertStatusChangedListener;
        Intrinsics.checkNotNull(fastConvertStatusChangedListener2);
        fastConvertStatusChangedListener2.onResultWord(result, intArray, arrayList, zCheckCountryNeedGetRawText);
    }

    public final void handleLocaleChanged(@Nullable Locale locale) {
        if (locale == null) {
            Logger.m12710d(TAG, "handleLocaleChanged null");
            return;
        }
        Logger.m12710d(TAG, "handleLocaleChanged: " + locale);
        this.mChangedLocale = locale;
        Intrinsics.checkNotNull(locale);
        STTLanguageHelper.setDefaultLocaleTag(locale.toLanguageTag());
        FastConvertStatusChangedListener fastConvertStatusChangedListener = this.mFastConvertStatusChangedListener;
        if (fastConvertStatusChangedListener != null) {
            Intrinsics.checkNotNull(fastConvertStatusChangedListener);
            fastConvertStatusChangedListener.onLocaleChanged(locale);
        }
    }

    public final void handleProgressUpdate(@NotNull String percentString) {
        int i;
        Intrinsics.checkNotNullParameter(percentString, "percentString");
        if (this.mFastConvertStatusChangedListener != null) {
            if (TextUtils.isEmpty(percentString)) {
                i = 0;
            } else {
                try {
                    i = Integer.parseInt(percentString);
                } catch (NumberFormatException unused) {
                    AbstractC12991c.m14005z("percent parse error ", percentString, TAG);
                    i = 0;
                }
            }
            FastConvertStatusChangedListener fastConvertStatusChangedListener = this.mFastConvertStatusChangedListener;
            Intrinsics.checkNotNull(fastConvertStatusChangedListener);
            fastConvertStatusChangedListener.onProgressUpdate(i);
        }
    }

    public final void handleServerError(int errorCode, @Nullable String error) {
        Logger.m12710d(TAG, "handleServerError, " + error + " , " + errorCode);
        if (this.mChangedLocale == null) {
            this.mChangedLocale = INSTANCE.getDefaultDeviceLocale();
        }
        if (errorCode == 3 || errorCode == 7) {
            FastConvertStatusChangedListener fastConvertStatusChangedListener = this.mFastConvertStatusChangedListener;
            if (fastConvertStatusChangedListener != null) {
                Intrinsics.checkNotNull(fastConvertStatusChangedListener);
                fastConvertStatusChangedListener.onNoMatch();
                return;
            }
            return;
        }
        if (errorCode == 10) {
            FastConvertStatusChangedListener fastConvertStatusChangedListener2 = this.mFastConvertStatusChangedListener;
            if (fastConvertStatusChangedListener2 != null) {
                Intrinsics.checkNotNull(fastConvertStatusChangedListener2);
                fastConvertStatusChangedListener2.onNoLangPackInstalled(this.mChangedLocale);
                return;
            }
            return;
        }
        if (errorCode != 14) {
            handleLegacyError(error);
            return;
        }
        if (this.mFastConvertStatusChangedListener != null) {
            STTLanguageManager companion = STTLanguageManager.INSTANCE.getInstance();
            companion.initLanguageData();
            Locale locale = this.mChangedLocale;
            Intrinsics.checkNotNull(locale);
            LanguageInfo languageInfo = companion.getLanguageInfo(locale.toLanguageTag());
            if (languageInfo == null || !companion.isLangPackInstalled(languageInfo.getLangPackage())) {
                FastConvertStatusChangedListener fastConvertStatusChangedListener3 = this.mFastConvertStatusChangedListener;
                Intrinsics.checkNotNull(fastConvertStatusChangedListener3);
                fastConvertStatusChangedListener3.onLocaleChanged(this.mChangedLocale);
            } else {
                Logger.m12711e(TAG, "installed older language pack version that does not support auto detect");
                FastConvertStatusChangedListener fastConvertStatusChangedListener4 = this.mFastConvertStatusChangedListener;
                Intrinsics.checkNotNull(fastConvertStatusChangedListener4);
                fastConvertStatusChangedListener4.onNoMatch();
            }
        }
    }

    public final void setEnableAutoDetect(boolean enableAutoDetect) {
        this.mIsEnableAutoDetect = enableAutoDetect;
    }

    public final void setIsFastConvert(boolean isFastConvert) {
        this.mIsFastConvert = isFastConvert;
    }

    public final void setRecognizeLocale(@Nullable Locale recognizeLocale) {
        this.mRecognizeLocale = recognizeLocale;
    }

    public final void setStatusChangedListener(@Nullable FastConvertStatusChangedListener fastConvertStatusChangedListener) {
        this.mFastConvertStatusChangedListener = fastConvertStatusChangedListener;
    }

    public final void startRecognition(@Nullable Context context) {
        Logger.m12713i(TAG, "--- startRecognition");
        SpeechRecognizer speechRecognizer = this.mSpeechRecognizer;
        if (speechRecognizer != null) {
            Intrinsics.checkNotNull(speechRecognizer);
            speechRecognizer.cancel();
        }
        this.mSpeechRecognizer = context != null ? AiServices.getSpeechRecognizer(context, new ScsRecognizerListener(this.mSession)) : null;
        if (this.mRecognizeLocale == null) {
            Locale localeForLanguageTag = Locale.forLanguageTag("en-US");
            Logger.m12713i(TAG, "use defaultLanguage Code : en-US");
            this.mRecognizeLocale = localeForLanguageTag;
        }
        this.mType = ConnectionType.LOCAL;
    }

    @SuppressLint({WarningType.NewApi})
    public final boolean startRecognizer(@NotNull String pcmPath) {
        Intrinsics.checkNotNullParameter(pcmPath, "pcmPath");
        try {
            this.mPCMInputStream = new FileInputStream(pcmPath);
        } catch (FileNotFoundException e) {
            Logger.m12711e(TAG, "startRecognizer fileNotFound " + pcmPath);
            e.printStackTrace();
        }
        if (this.mPCMInputStream == null) {
            Logger.m12711e(TAG, "startRecognizer mPCMInputStream null");
            return false;
        }
        boolean z = !this.mIsFastConvert;
        Logger.m12713i(TAG, "--------------startRecognizer------------");
        RecognitionConfig.Builder builderEnableProgress = new RecognitionConfig.Builder().setType(this.mType).enableCensor(true).enableAudioCompression(true).enablePartialResult(z).enableSpeakerDiarisation(true).addDictationType(DictationType.TYPING).enableProgress(true);
        if (this.mIsEnableAutoDetect) {
            builderEnableProgress.enableLocaleRecognition(true);
            STTLanguageManager companion = STTLanguageManager.INSTANCE.getInstance();
            Intrinsics.checkNotNull(companion);
            companion.initLanguageData();
            List<String> downloadedLocaleList = companion.getDownloadedLocaleList();
            Intrinsics.checkNotNull(downloadedLocaleList);
            Locale[] localeArr = (Locale[]) downloadedLocaleList.stream().map(new C0332a(new C0348a(13), 7)).toArray(new C11496b(0));
            Intrinsics.checkNotNull(localeArr);
            Locale[] localeArr2 = (Locale[]) ArraysKt.filterNotNull(localeArr).toArray(new Locale[0]);
            builderEnableProgress.setAlternativeLocales((Locale[]) Arrays.copyOf(localeArr2, localeArr2.length));
        } else {
            Locale locale = this.mRecognizeLocale;
            Intrinsics.checkNotNull(locale);
            builderEnableProgress.setLocale(locale);
        }
        RecognitionConfig recognitionConfigBuild = builderEnableProgress.build();
        FastConvertStatusChangedListener fastConvertStatusChangedListener = this.mFastConvertStatusChangedListener;
        if (fastConvertStatusChangedListener != null) {
            Intrinsics.checkNotNull(fastConvertStatusChangedListener);
            fastConvertStatusChangedListener.onRecognitionStart();
        }
        SpeechRecognizer speechRecognizer = this.mSpeechRecognizer;
        if (speechRecognizer == null) {
            Logger.m12711e(TAG, "mSpeechRecognizer null");
            return false;
        }
        Intrinsics.checkNotNull(speechRecognizer);
        speechRecognizer.init();
        SpeechRecognizer speechRecognizer2 = this.mSpeechRecognizer;
        Intrinsics.checkNotNull(speechRecognizer2);
        FileInputStream fileInputStream = this.mPCMInputStream;
        Intrinsics.checkNotNull(fileInputStream);
        speechRecognizer2.start(recognitionConfigBuild, fileInputStream);
        return true;
    }
}
