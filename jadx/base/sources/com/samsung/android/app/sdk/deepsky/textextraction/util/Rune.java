package com.samsung.android.app.sdk.deepsky.textextraction.util;

import android.os.Build;
import com.samsung.android.app.sdk.deepsky.textextraction.logger.LibLogger;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import com.samsung.android.vexfwk.sdk.imagetranslator.VexFwkImageTranslator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\f\u0010\bR\u001b\u0010\u000e\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0011\u0010\u001b\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u001d\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0010R\u000e\u0010\u001e\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m13886d2 = {"Lcom/samsung/android/app/sdk/deepsky/textextraction/util/Rune;", "", "()V", "CONFIG_AI_VERSION_OVER_20242", "", "FEATURE_CONFIG_AI_VERSION", "", "getFEATURE_CONFIG_AI_VERSION", "()I", "FEATURE_CONFIG_AI_VERSION$delegate", "Lkotlin/Lazy;", "FEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION", "getFEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION", "FEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION$delegate", "FEATURE_DISABLE_NATIVE_AI", "getFEATURE_DISABLE_NATIVE_AI", "()Z", "FEATURE_DISABLE_NATIVE_AI$delegate", "ONE_UI_4_1_1", "ONE_UI_6_1", "SUPPORT_AFTER_ONE_UI_4_1_1", "SUPPORT_AFTER_ONE_UI_6_1", SearchConstants.TargetContents.TAG, "", "isLogPrivacy", "isSupportCapsule", "isSupportImageInPainting", "isSupportOcr", "isSupportTranslation", "isSupportVex", "semPlatformInt", "deepsky-sdk-textextraction-8.0.19_release"}, m13887k = 1, m13888mv = {1, 8, 0}, m13890xi = 48)
public final class Rune {
    private static final boolean CONFIG_AI_VERSION_OVER_20242;

    /* JADX INFO: renamed from: FEATURE_CONFIG_AI_VERSION$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy FEATURE_CONFIG_AI_VERSION;

    /* JADX INFO: renamed from: FEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy FEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION;

    /* JADX INFO: renamed from: FEATURE_DISABLE_NATIVE_AI$delegate, reason: from kotlin metadata */
    @NotNull
    private static final Lazy FEATURE_DISABLE_NATIVE_AI;

    @NotNull
    public static final Rune INSTANCE;
    private static final int ONE_UI_4_1_1 = 130500;
    private static final int ONE_UI_6_1 = 150100;
    private static final boolean SUPPORT_AFTER_ONE_UI_4_1_1;
    private static final boolean SUPPORT_AFTER_ONE_UI_6_1;

    @NotNull
    private static final String TAG = "Rune";
    public static final boolean isLogPrivacy = false;
    private static final boolean isSupportCapsule;
    private static final boolean isSupportImageInPainting;
    private static final boolean isSupportOcr;
    private static final boolean isSupportTranslation;
    private static final boolean isSupportVex;
    private static final int semPlatformInt;

    static {
        Rune rune = new Rune();
        INSTANCE = rune;
        int i = Build.VERSION.SEM_PLATFORM_INT;
        LibLogger.m5432i(TAG, "SEM_PLATFORM_INT: " + i);
        semPlatformInt = i;
        FEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION = LazyKt.lazy(new Function0<Integer>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.util.Rune$FEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                Object objM22215constructorimpl;
                Rune rune2 = Rune.INSTANCE;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    int i2 = SemFloatingFeature.getInstance().getInt("SEC_FLOATING_FEATURE_VISION_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION");
                    LibLogger.m5432i("Rune", "FEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION: " + i2);
                    objM22215constructorimpl = Result.m22215constructorimpl(Integer.valueOf(i2));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                    objM22215constructorimpl = null;
                }
                Integer num = (Integer) objM22215constructorimpl;
                return Integer.valueOf(num != null ? num.intValue() : 0);
            }
        });
        FEATURE_DISABLE_NATIVE_AI = LazyKt.lazy(new Function0<Boolean>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.util.Rune$FEATURE_DISABLE_NATIVE_AI$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                Object objM22215constructorimpl;
                Rune rune2 = Rune.INSTANCE;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    boolean z = SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_COMMON_DISABLE_NATIVE_AI");
                    LibLogger.m5432i("Rune", "FEATURE_DISABLE_NATIVE_AI: " + z);
                    objM22215constructorimpl = Result.m22215constructorimpl(Boolean.valueOf(z));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                    objM22215constructorimpl = null;
                }
                Boolean bool = (Boolean) objM22215constructorimpl;
                return Boolean.valueOf(bool != null ? bool.booleanValue() : true);
            }
        });
        FEATURE_CONFIG_AI_VERSION = LazyKt.lazy(new Function0<Integer>() { // from class: com.samsung.android.app.sdk.deepsky.textextraction.util.Rune$FEATURE_CONFIG_AI_VERSION$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                Object objM22215constructorimpl;
                Rune rune2 = Rune.INSTANCE;
                try {
                    Result.Companion companion = Result.INSTANCE;
                    String string = SemFloatingFeature.getInstance().getString("SEC_FLOATING_FEATURE_COMMON_CONFIG_AI_VERSION");
                    Intrinsics.checkNotNullExpressionValue(string, "getInstance()\n          …OMMON_CONFIG_AI_VERSION\")");
                    int i2 = Integer.parseInt(string);
                    LibLogger.m5432i("Rune", "FEATURE_CONFIG_AI_VERSION: " + i2);
                    objM22215constructorimpl = Result.m22215constructorimpl(Integer.valueOf(i2));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM22215constructorimpl = Result.m22215constructorimpl(ResultKt.createFailure(th));
                }
                if (Result.m22221isFailureimpl(objM22215constructorimpl)) {
                    objM22215constructorimpl = null;
                }
                Integer num = (Integer) objM22215constructorimpl;
                return Integer.valueOf(num != null ? num.intValue() : 0);
            }
        });
        boolean z = i >= ONE_UI_4_1_1;
        SUPPORT_AFTER_ONE_UI_4_1_1 = z;
        boolean z2 = i >= 150100;
        SUPPORT_AFTER_ONE_UI_6_1 = z2;
        boolean z3 = rune.getFEATURE_CONFIG_AI_VERSION() >= 20242;
        CONFIG_AI_VERSION_OVER_20242 = z3;
        isSupportOcr = z;
        isSupportCapsule = z2;
        isSupportTranslation = !rune.getFEATURE_DISABLE_NATIVE_AI() && z2 && z3;
        isSupportImageInPainting = rune.getFEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION() >= 5;
        isSupportVex = VexFwkImageTranslator.INSTANCE.isAvailable();
    }

    private Rune() {
    }

    private final int getFEATURE_CONFIG_AI_VERSION() {
        return ((Number) FEATURE_CONFIG_AI_VERSION.getValue()).intValue();
    }

    private final int getFEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION() {
        return ((Number) FEATURE_CONFIG_IMAGE_TRANSLATION_OVERLAY_VERSION.getValue()).intValue();
    }

    private final boolean getFEATURE_DISABLE_NATIVE_AI() {
        return ((Boolean) FEATURE_DISABLE_NATIVE_AI.getValue()).booleanValue();
    }

    public final boolean isSupportCapsule() {
        return isSupportCapsule;
    }

    public final boolean isSupportImageInPainting() {
        return isSupportImageInPainting;
    }

    public final boolean isSupportOcr() {
        return isSupportOcr;
    }

    public final boolean isSupportTranslation() {
        return isSupportTranslation;
    }

    public final boolean isSupportVex() {
        return isSupportVex;
    }
}
