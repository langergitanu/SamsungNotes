package com.samsung.android.sdk.pen.recoguifeature.hwrbeautifier;

import android.content.Context;
import android.util.Log;
import androidx.glance.AbstractC2821a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.sdk.pen.recogengine.SpenRecognizerAILanguages;
import com.samsung.android.sdk.pen.recogengine.SpenResourceProvider;
import com.samsung.android.sdk.pen.recoguifeature.SPenRecognitionWorker;
import com.samsung.android.support.senl.p148nt.composer.main.base.model.menu.toolbar.directwrite.constants.DirectWriteConstant;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\u0005J\u0006\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011J\u001e\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\u0010\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u000e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0011J\u0018\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0011H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager;", "", "<init>", "()V", "mHwrBeautifier", "", "mContext", "Landroid/content/Context;", "mBeautificationFlag", "", "setNativeHandle", "", "context", "handle", "close", "setAutoCleanUpOptions", "fixShapeOfLetters", "", "alignLetters", "cleanUpOptionWord", "updateLanguage", "text", "", "setAutoCleanUpEnabled", "enable", "setFlag", "flag", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SPenHwrBeautifierManager {
    public static final int CLEANUP_OPTION_FLAG_BASELINE_OF_LETTERS = 8;
    public static final int CLEANUP_OPTION_FLAG_LETTER = 4;
    public static final int CLEANUP_OPTION_FLAG_STRAIGHTEN = 32;
    public static final int CLEANUP_OPTION_FLAG_WORD = 16;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final String TAG = "HwrBeautifierManager";
    private int mBeautificationFlag = 60;

    @Nullable
    private Context mContext;
    private long mHwrBeautifier;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007J\u0019\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0083 J\u0011\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0083 J\u0019\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0005H\u0083 J\u0019\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0083 J\u0019\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0007H\u0083 R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001e"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager$Companion;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "CLEANUP_OPTION_FLAG_LETTER", "", "CLEANUP_OPTION_FLAG_BASELINE_OF_LETTERS", "CLEANUP_OPTION_FLAG_WORD", "CLEANUP_OPTION_FLAG_STRAIGHTEN", "getBeautifierSupportedLanguages", "", "context", "Landroid/content/Context;", "Native_init", "", "nativeHandle", "", "manager", "Lcom/samsung/android/sdk/pen/recoguifeature/hwrbeautifier/SPenHwrBeautifierManager;", "Native_finalize", "Native_updateLanguage", "lang", "Native_setAutoCleanUpEnable", "enabled", "", "Native_setAutoCleanUpFlag", "nativeAlignment", "beautificationFlag", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_finalize(long nativeHandle) {
            SPenHwrBeautifierManager.Native_finalize(nativeHandle);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_init(long nativeHandle, SPenHwrBeautifierManager manager) {
            SPenHwrBeautifierManager.Native_init(nativeHandle, manager);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAutoCleanUpEnable(long nativeHandle, boolean enabled) {
            SPenHwrBeautifierManager.Native_setAutoCleanUpEnable(nativeHandle, enabled);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_setAutoCleanUpFlag(long nativeAlignment, int beautificationFlag) {
            SPenHwrBeautifierManager.Native_setAutoCleanUpFlag(nativeAlignment, beautificationFlag);
        }

        /* JADX INFO: Access modifiers changed from: private */
        @JvmStatic
        public final void Native_updateLanguage(long nativeHandle, String lang) {
            SPenHwrBeautifierManager.Native_updateLanguage(nativeHandle, lang);
        }

        @JvmStatic
        @NotNull
        public final List<String> getBeautifierSupportedLanguages(@Nullable Context context) {
            return SPenRecognitionWorker.INSTANCE.getBeautifierSupportedLanguages(context);
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_finalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_init(long j, SPenHwrBeautifierManager sPenHwrBeautifierManager);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAutoCleanUpEnable(long j, boolean z);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_setAutoCleanUpFlag(long j, int i);

    /* JADX INFO: Access modifiers changed from: private */
    @JvmStatic
    public static final native void Native_updateLanguage(long j, String str);

    @JvmStatic
    @NotNull
    public static final List<String> getBeautifierSupportedLanguages(@Nullable Context context) {
        return INSTANCE.getBeautifierSupportedLanguages(context);
    }

    private final void setFlag(int flag, boolean enable) {
        int i;
        if (enable) {
            i = flag | this.mBeautificationFlag;
        } else {
            i = (~flag) & this.mBeautificationFlag;
        }
        this.mBeautificationFlag = i;
    }

    public final void close() {
        long j = this.mHwrBeautifier;
        if (j != 0) {
            INSTANCE.Native_finalize(j);
        }
        this.mHwrBeautifier = 0L;
    }

    public final void setAutoCleanUpEnabled(boolean enable) {
        long j = this.mHwrBeautifier;
        if (j != 0) {
            INSTANCE.Native_setAutoCleanUpEnable(j, enable);
        }
    }

    public final void setAutoCleanUpOptions(boolean fixShapeOfLetters, boolean alignLetters) {
        AbstractC6670b.m4758s("setAutoCleanUpOptions letter: ", ", line: ", TAG, fixShapeOfLetters, alignLetters);
        if (this.mHwrBeautifier == 0) {
            return;
        }
        setFlag(4, fixShapeOfLetters);
        setFlag(8, alignLetters);
        setFlag(16, false);
        setFlag(32, false);
        INSTANCE.Native_setAutoCleanUpFlag(this.mHwrBeautifier, this.mBeautificationFlag);
    }

    public final void setNativeHandle(@Nullable Context context, long handle) {
        this.mContext = context;
        this.mHwrBeautifier = handle;
        Log.i(TAG, "SPenHwrBeautifierManager::setNativeHandle mHwrBeautifier : " + handle);
        long j = this.mHwrBeautifier;
        if (j != 0) {
            INSTANCE.Native_init(j, this);
        }
    }

    public final void updateLanguage(@Nullable CharSequence text) {
        if (text == null || text.length() <= 0) {
            Log.e(TAG, "SPenHwrBeautifierManager::updateLanguage text == null || text.length() <= 0");
            return;
        }
        Log.i(TAG, "SPenHwrBeautifierManager::updateLanguage - " + ((Object) text));
        String internalLocale = SpenRecognizerAILanguages.getInternalLocale(text.toString());
        if (Intrinsics.areEqual("50101", SPenRecognitionWorker.INSTANCE.getStringOfOneUIVersion(this.mContext)) && Intrinsics.areEqual("en_GB", internalLocale)) {
            SpenResourceProvider spenResourceProvider = new SpenResourceProvider(this.mContext, SpenResourceProvider.EngineType.TEXT, SpenResourceProvider.ResourceType.FRAMEWORK);
            if (spenResourceProvider.isSupportedLanguage(this.mContext, DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE)) {
                Log.i(TAG, "SPenHwrBeautifierManager::updateLanguage : en_GB is changed to en_US");
                internalLocale = DirectWriteConstant.DEFAULT_RECOGNITION_LANGUAGE;
            } else {
                Log.i(TAG, "SPenHwrBeautifierManager::updateLanguage : en_US is not supported");
            }
            spenResourceProvider.close();
        }
        if (SPenRecognitionWorker.setLanguage(internalLocale)) {
            SPenRecognitionWorker.initializeSelf(this.mContext);
            long j = this.mHwrBeautifier;
            if (j == 0 || internalLocale == null) {
                return;
            }
            INSTANCE.Native_updateLanguage(j, internalLocale);
        }
    }

    public final void setAutoCleanUpOptions(boolean fixShapeOfLetters, boolean alignLetters, boolean cleanUpOptionWord) {
        AbstractC0000a.m27x(AbstractC2821a.m2230u("setAutoCleanUpOptions letter: ", ", line: ", ", word: ", fixShapeOfLetters, alignLetters), cleanUpOptionWord, TAG);
        if (this.mHwrBeautifier == 0) {
            return;
        }
        setFlag(4, fixShapeOfLetters);
        setFlag(8, alignLetters);
        setFlag(16, cleanUpOptionWord);
        setFlag(32, false);
        INSTANCE.Native_setAutoCleanUpFlag(this.mHwrBeautifier, this.mBeautificationFlag);
    }
}
