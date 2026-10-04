package com.samsung.android.sdk.pen.setting.util;

import android.content.Context;
import android.graphics.Color;
import com.samsung.android.support.senl.p148nt.data.common.constants.SearchConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001:\u0006\u000f\u0010\u0011\u0012\u0013\u0014B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilAdaptiveColor;", "", "<init>", "()V", SearchConstants.TargetContents.TAG, "", "isAdaptiveColor", "", "context", "Landroid/content/Context;", "color", "", "type", "Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilAdaptiveColor$UseType;", "isNightMode", "UseType", "AdaptiveColorForBg", "AdaptiveColorForFg", "AdaptiveColorForColorChip", "AdaptiveColorForThickness", "AdaptiveColorForTransparency", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenSettingUtilAdaptiveColor {

    @NotNull
    public static final SpenSettingUtilAdaptiveColor INSTANCE = new SpenSettingUtilAdaptiveColor();

    @NotNull
    private static final String TAG = "SpenSettingUtilAdaptiveColor";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilAdaptiveColor$AdaptiveColorForBg;", "", "<init>", "()V", "isAdaptiveColor", "", "color", "", "isNightMode", "isAdaptiveColorInDayMode", "hue", "", "saturation", "value", "isAdaptiveColorInNightMode", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AdaptiveColorForBg {

        @NotNull
        public static final AdaptiveColorForBg INSTANCE = new AdaptiveColorForBg();

        private AdaptiveColorForBg() {
        }

        private final boolean isAdaptiveColorInDayMode(float hue, float saturation, float value) {
            if (saturation < 0.1f) {
                return value >= 0.97f;
            }
            if (saturation >= 0.3f) {
                return false;
            }
            if (value >= 0.99f) {
                return true;
            }
            return value >= 0.88f && value < 0.93f;
        }

        private final boolean isAdaptiveColorInNightMode(float hue, float saturation, float value) {
            return saturation <= 0.1f && 0.1d <= ((double) value) && value <= 0.2f;
        }

        public final boolean isAdaptiveColor(int color, boolean isNightMode) {
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            return !isNightMode ? isAdaptiveColorInDayMode(fArr[0], fArr[1], fArr[2]) : isAdaptiveColorInNightMode(fArr[0], fArr[1], fArr[2]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilAdaptiveColor$AdaptiveColorForColorChip;", "", "<init>", "()V", "isAdaptiveColor", "", "color", "", "isNightMode", "isAdaptiveColorInDayMode", "hue", "", "saturation", "value", "isAdaptiveColorInNightMode", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AdaptiveColorForColorChip {

        @NotNull
        public static final AdaptiveColorForColorChip INSTANCE = new AdaptiveColorForColorChip();

        private AdaptiveColorForColorChip() {
        }

        private final boolean isAdaptiveColorInDayMode(float hue, float saturation, float value) {
            return hue == 0.0f && saturation == 0.0f && value >= 0.96f;
        }

        private final boolean isAdaptiveColorInNightMode(float hue, float saturation, float value) {
            return hue == 0.0f && saturation == 0.0f && 0.1f <= value && value < 0.2f;
        }

        public final boolean isAdaptiveColor(int color, boolean isNightMode) {
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            return !isNightMode ? isAdaptiveColorInDayMode(fArr[0], fArr[1], fArr[2]) : isAdaptiveColorInNightMode(fArr[0], fArr[1], fArr[2]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J(\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002J(\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0007H\u0002¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilAdaptiveColor$AdaptiveColorForFg;", "", "<init>", "()V", "isAdaptiveColor", "", "color", "", "isNightMode", "isAdaptiveColorInDayMode", "hue", "", "saturation", "value", "alpha", "isAdaptiveColorInNightMode", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AdaptiveColorForFg {

        @NotNull
        public static final AdaptiveColorForFg INSTANCE = new AdaptiveColorForFg();

        private AdaptiveColorForFg() {
        }

        private final boolean isAdaptiveColorInDayMode(float hue, float saturation, float value, int alpha) {
            if (alpha <= 40) {
                return true;
            }
            if (value < 0.95f) {
                return false;
            }
            return (25.0f < hue && hue < 190.0f) || saturation < 0.5f;
        }

        private final boolean isAdaptiveColorInNightMode(float hue, float saturation, float value, int alpha) {
            return alpha > 80 && value >= 0.95f && ((30.0f < hue && hue < 190.0f) || saturation < 0.5f);
        }

        public final boolean isAdaptiveColor(int color, boolean isNightMode) {
            float[] fArr = new float[3];
            int alphaToPercent = SpenSettingUtilOpacity.getAlphaToPercent(Color.alpha(color));
            Color.colorToHSV(color, fArr);
            return !isNightMode ? isAdaptiveColorInDayMode(fArr[0], fArr[1], fArr[2], alphaToPercent) : isAdaptiveColorInNightMode(fArr[0], fArr[1], fArr[2], alphaToPercent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilAdaptiveColor$AdaptiveColorForThickness;", "", "<init>", "()V", "isAdaptiveColor", "", "color", "", "isNightMode", "isAdaptiveColorInDayMode", "hue", "", "saturation", "value", "isAdaptiveColorInNightMode", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AdaptiveColorForThickness {

        @NotNull
        public static final AdaptiveColorForThickness INSTANCE = new AdaptiveColorForThickness();

        private AdaptiveColorForThickness() {
        }

        private final boolean isAdaptiveColorInDayMode(float hue, float saturation, float value) {
            return 0.0f <= saturation && saturation <= 0.05f && 0.92f < value && value < 0.97f;
        }

        private final boolean isAdaptiveColorInNightMode(float hue, float saturation, float value) {
            return saturation < 0.5f && value >= 0.8f;
        }

        public final boolean isAdaptiveColor(int color, boolean isNightMode) {
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            return !isNightMode ? isAdaptiveColorInDayMode(fArr[0], fArr[1], fArr[2]) : isAdaptiveColorInNightMode(fArr[0], fArr[1], fArr[2]);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005J \u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilAdaptiveColor$AdaptiveColorForTransparency;", "", "<init>", "()V", "isAdaptiveColor", "", "color", "", "isNightMode", "isAdaptiveColorInDayMode", "hue", "", "saturation", "value", "isAdaptiveColorInNightMode", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class AdaptiveColorForTransparency {

        @NotNull
        public static final AdaptiveColorForTransparency INSTANCE = new AdaptiveColorForTransparency();

        private AdaptiveColorForTransparency() {
        }

        private final boolean isAdaptiveColorInDayMode(float hue, float saturation, float value) {
            return hue == 0.0f && saturation == 0.0f && 0.96f < value;
        }

        private final boolean isAdaptiveColorInNightMode(float hue, float saturation, float value) {
            return hue == 0.0f && saturation == 0.0f && 0.1f <= value && value < 0.2f;
        }

        public final boolean isAdaptiveColor(int color, boolean isNightMode) {
            float[] fArr = new float[3];
            Color.colorToHSV(color, fArr);
            return !isNightMode ? isAdaptiveColorInDayMode(fArr[0], fArr[1], fArr[2]) : isAdaptiveColorInNightMode(fArr[0], fArr[1], fArr[2]);
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/util/SpenSettingUtilAdaptiveColor$UseType;", "", "<init>", "(Ljava/lang/String;I)V", "DECISION_BG_COLOR", "DECISION_FG_COLOR", "DECISION_THICKNESS_OUTLINE", "DECISION_COLOR_CHIP_OUTLINE", "DECISION_TRANSPARENCY_OUTLINE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class UseType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ UseType[] $VALUES;
        public static final UseType DECISION_BG_COLOR = new UseType("DECISION_BG_COLOR", 0);
        public static final UseType DECISION_FG_COLOR = new UseType("DECISION_FG_COLOR", 1);
        public static final UseType DECISION_THICKNESS_OUTLINE = new UseType("DECISION_THICKNESS_OUTLINE", 2);
        public static final UseType DECISION_COLOR_CHIP_OUTLINE = new UseType("DECISION_COLOR_CHIP_OUTLINE", 3);
        public static final UseType DECISION_TRANSPARENCY_OUTLINE = new UseType("DECISION_TRANSPARENCY_OUTLINE", 4);

        private static final /* synthetic */ UseType[] $values() {
            return new UseType[]{DECISION_BG_COLOR, DECISION_FG_COLOR, DECISION_THICKNESS_OUTLINE, DECISION_COLOR_CHIP_OUTLINE, DECISION_TRANSPARENCY_OUTLINE};
        }

        static {
            UseType[] useTypeArr$values = $values();
            $VALUES = useTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(useTypeArr$values);
        }

        private UseType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<UseType> getEntries() {
            return $ENTRIES;
        }

        public static UseType valueOf(String str) {
            return (UseType) Enum.valueOf(UseType.class, str);
        }

        public static UseType[] values() {
            return (UseType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[UseType.values().length];
            try {
                iArr[UseType.DECISION_BG_COLOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[UseType.DECISION_FG_COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[UseType.DECISION_COLOR_CHIP_OUTLINE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[UseType.DECISION_THICKNESS_OUTLINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[UseType.DECISION_TRANSPARENCY_OUTLINE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SpenSettingUtilAdaptiveColor() {
    }

    @JvmStatic
    public static final boolean isAdaptiveColor(@Nullable Context context, int color, @NotNull UseType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        SpenSettingUtilAdaptiveColor spenSettingUtilAdaptiveColor = INSTANCE;
        Intrinsics.checkNotNull(context);
        return spenSettingUtilAdaptiveColor.isAdaptiveColor(color, type, SpenSettingUtil.isNightMode(context));
    }

    @JvmStatic
    public static final boolean isAdaptiveColor(int color, @NotNull UseType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return INSTANCE.isAdaptiveColor(color, type, false);
    }

    private final boolean isAdaptiveColor(int color, UseType type, boolean isNightMode) {
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return AdaptiveColorForBg.INSTANCE.isAdaptiveColor(color, isNightMode);
        }
        if (i == 2) {
            return AdaptiveColorForFg.INSTANCE.isAdaptiveColor(color, isNightMode);
        }
        if (i == 3) {
            return AdaptiveColorForColorChip.INSTANCE.isAdaptiveColor(color, isNightMode);
        }
        if (i == 4) {
            return AdaptiveColorForThickness.INSTANCE.isAdaptiveColor(color, isNightMode);
        }
        if (i == 5) {
            return AdaptiveColorForTransparency.INSTANCE.isAdaptiveColor(color, isNightMode);
        }
        throw new NoWhenBranchMatchedException();
    }
}
