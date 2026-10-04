package com.samsung.android.vexfwk.docscan;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m13886d2 = {"Lcom/samsung/android/vexfwk/docscan/VexFwkDocDewarpModes;", "", "()V", "Companion", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
public final class VexFwkDocDewarpModes {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\b"}, m13886d2 = {"Lcom/samsung/android/vexfwk/docscan/VexFwkDocDewarpModes$Companion;", "", "()V", "fromIntToDewarpMode", "Lcom/samsung/android/vexfwk/docscan/VexFwkDocDewarpModes$Companion$DewarpMode;", "value", "", "DewarpMode", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
    @SourceDebugExtension({"SMAP\nVexFwkDocDewarpModes.kt\nKotlin\n*S Kotlin\n*F\n+ 1 VexFwkDocDewarpModes.kt\ncom/samsung/android/vexfwk/docscan/VexFwkDocDewarpModes$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,16:1\n1#2:17\n*E\n"})
    public static final class Companion {

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
        /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
        @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m13886d2 = {"Lcom/samsung/android/vexfwk/docscan/VexFwkDocDewarpModes$Companion$DewarpMode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "DEWARP_MODE_AUTO", "DEWARP_MODE_CV", "DEWARP_MODE_AI", "vexfwk_sdk_release"}, m13887k = 1, m13888mv = {1, 9, 0}, m13890xi = 48)
        public static final class DewarpMode {
            private static final /* synthetic */ EnumEntries $ENTRIES;
            private static final /* synthetic */ DewarpMode[] $VALUES;
            private final int value;
            public static final DewarpMode DEWARP_MODE_AUTO = new DewarpMode("DEWARP_MODE_AUTO", 0, 0);
            public static final DewarpMode DEWARP_MODE_CV = new DewarpMode("DEWARP_MODE_CV", 1, 1);
            public static final DewarpMode DEWARP_MODE_AI = new DewarpMode("DEWARP_MODE_AI", 2, 2);

            private static final /* synthetic */ DewarpMode[] $values() {
                return new DewarpMode[]{DEWARP_MODE_AUTO, DEWARP_MODE_CV, DEWARP_MODE_AI};
            }

            static {
                DewarpMode[] dewarpModeArr$values = $values();
                $VALUES = dewarpModeArr$values;
                $ENTRIES = EnumEntriesKt.enumEntries(dewarpModeArr$values);
            }

            private DewarpMode(String str, int i, int i2) {
                this.value = i2;
            }

            @NotNull
            public static EnumEntries<DewarpMode> getEntries() {
                return $ENTRIES;
            }

            public static DewarpMode valueOf(String str) {
                return (DewarpMode) Enum.valueOf(DewarpMode.class, str);
            }

            public static DewarpMode[] values() {
                return (DewarpMode[]) $VALUES.clone();
            }

            public final int getValue() {
                return this.value;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final DewarpMode fromIntToDewarpMode(int value) {
            for (DewarpMode dewarpMode : DewarpMode.values()) {
                if (dewarpMode.getValue() == value) {
                    return dewarpMode;
                }
            }
            return null;
        }

        private Companion() {
        }
    }
}
