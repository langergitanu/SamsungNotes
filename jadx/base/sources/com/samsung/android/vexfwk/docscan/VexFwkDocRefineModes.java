package com.samsung.android.vexfwk.docscan;

import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes;", "", "()V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkDocRefineModes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0002\t\nB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes$Companion;", "", "()V", "fromIntToColorFilterType", "Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes$Companion$ColorFilterType;", "value", "", "fromIntToEnhancementMode", "Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes$Companion$EnhancementMode;", "ColorFilterType", "EnhancementMode", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkDocRefineModes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkDocRefineModes.kt\ncom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,25:1\n1#2:26\n*E\n"})
    public static final class Companion {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes$Companion$ColorFilterType;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "COLOR_FILTER_NONE", "COLOR_FILTER_LIGHT_AUTO", "COLOR_FILTER_GRAY", "COLOR_FILTER_BLACK_AND_WHITE", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class ColorFilterType {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ ColorFilterType[] $VALUES;
            private final int value;
            public static final ColorFilterType COLOR_FILTER_NONE = new ColorFilterType("COLOR_FILTER_NONE", 0, 0);
            public static final ColorFilterType COLOR_FILTER_LIGHT_AUTO = new ColorFilterType("COLOR_FILTER_LIGHT_AUTO", 1, 1);
            public static final ColorFilterType COLOR_FILTER_GRAY = new ColorFilterType("COLOR_FILTER_GRAY", 2, 2);
            public static final ColorFilterType COLOR_FILTER_BLACK_AND_WHITE = new ColorFilterType("COLOR_FILTER_BLACK_AND_WHITE", 3, 3);

            private static final /* synthetic */ ColorFilterType[] $values() {
                return new ColorFilterType[]{COLOR_FILTER_NONE, COLOR_FILTER_LIGHT_AUTO, COLOR_FILTER_GRAY, COLOR_FILTER_BLACK_AND_WHITE};
            }

            static {
                ColorFilterType[] colorFilterTypeArr$values = $values();
                $VALUES = colorFilterTypeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(colorFilterTypeArr$values);
            }

            private ColorFilterType(String str, int i, int i2) {
                this.value = i2;
            }

            @NotNull
            public static EnumEntries<ColorFilterType> getEntries() {
                return $ENTRIES;
            }

            public static ColorFilterType valueOf(String str) {
                return (ColorFilterType) Enum.valueOf(ColorFilterType.class, str);
            }

            public static ColorFilterType[] values() {
                return (ColorFilterType[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }
        }

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m13886d2 = {"Lcom/samsung/android/vexfwk/docscan/VexFwkDocRefineModes$Companion$EnhancementMode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_OFF, NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON, "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class EnhancementMode {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ EnhancementMode[] $VALUES;
            public static final EnhancementMode OFF = new EnhancementMode(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_OFF, 0, 0);

            /* JADX INFO: renamed from: ON */
            public static final EnhancementMode f8081ON = new EnhancementMode(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON, 1, 1);
            private final int value;

            private static final /* synthetic */ EnhancementMode[] $values() {
                return new EnhancementMode[]{OFF, f8081ON};
            }

            static {
                EnhancementMode[] enhancementModeArr$values = $values();
                $VALUES = enhancementModeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(enhancementModeArr$values);
            }

            private EnhancementMode(String str, int i, int i2) {
                this.value = i2;
            }

            @NotNull
            public static EnumEntries<EnhancementMode> getEntries() {
                return $ENTRIES;
            }

            public static EnhancementMode valueOf(String str) {
                return (EnhancementMode) Enum.valueOf(EnhancementMode.class, str);
            }

            public static EnhancementMode[] values() {
                return (EnhancementMode[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final ColorFilterType fromIntToColorFilterType(int value) {
            for (ColorFilterType colorFilterType : ColorFilterType.values()) {
                if (colorFilterType.getValue() == value) {
                    return colorFilterType;
                }
            }
            return null;
        }

        @Nullable
        public final EnhancementMode fromIntToEnhancementMode(int value) {
            for (EnhancementMode enhancementMode : EnhancementMode.values()) {
                if (enhancementMode.getValue() == value) {
                    return enhancementMode;
                }
            }
            return null;
        }

        private Companion() {
        }
    }
}
