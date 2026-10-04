package com.samsung.android.sdk.pen.setting;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideConfigFactory;", "", "<init>", "()V", "createBrushGuideConfig", "Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideConfig;", "type", "Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideConfigFactory$ConfigType;", "style", "", "ratio", "", "ConfigType", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenBrushGuideConfigFactory {

    @NotNull
    public static final SpenBrushGuideConfigFactory INSTANCE = new SpenBrushGuideConfigFactory();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/SpenBrushGuideConfigFactory$ConfigType;", "", "<init>", "(Ljava/lang/String;I)V", "PEN", "COLOR", "MARGIN", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class ConfigType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ ConfigType[] $VALUES;
        public static final ConfigType PEN = new ConfigType("PEN", 0);
        public static final ConfigType COLOR = new ConfigType("COLOR", 1);
        public static final ConfigType MARGIN = new ConfigType("MARGIN", 2);

        private static final /* synthetic */ ConfigType[] $values() {
            return new ConfigType[]{PEN, COLOR, MARGIN};
        }

        static {
            ConfigType[] configTypeArr$values = $values();
            $VALUES = configTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(configTypeArr$values);
        }

        private ConfigType(String str, int i) {
        }

        @NotNull
        public static EnumEntries<ConfigType> getEntries() {
            return $ENTRIES;
        }

        public static ConfigType valueOf(String str) {
            return (ConfigType) Enum.valueOf(ConfigType.class, str);
        }

        public static ConfigType[] values() {
            return (ConfigType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13887k = 3, m13888mv = {2, 0, 0}, m13890xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConfigType.values().length];
            try {
                iArr[ConfigType.PEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ConfigType.COLOR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ConfigType.MARGIN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private SpenBrushGuideConfigFactory() {
    }

    @JvmStatic
    @NotNull
    public static final SpenBrushGuideConfig createBrushGuideConfig(@NotNull ConfigType type, int style, float ratio) {
        Intrinsics.checkNotNullParameter(type, "type");
        int i = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
        if (i == 1) {
            return new SpenBrushGuidePenConfig(style);
        }
        if (i == 2) {
            return new SpenBrushGuideColorConfig(style);
        }
        if (i == 3) {
            return new SpenBrushGuideMarginConfig(style, ratio);
        }
        throw new NoWhenBranchMatchedException();
    }
}
