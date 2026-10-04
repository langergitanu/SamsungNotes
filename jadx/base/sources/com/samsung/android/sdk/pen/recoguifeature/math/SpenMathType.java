package com.samsung.android.sdk.pen.recoguifeature.math;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathType;", "", "<init>", "()V", "MathPanelVisibility", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMathType {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathType$MathPanelVisibility;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "INVISIBLE", "PARTIAL", "FULL", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
    public static final class MathPanelVisibility {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ MathPanelVisibility[] $VALUES;
        private final int value;
        public static final MathPanelVisibility INVISIBLE = new MathPanelVisibility("INVISIBLE", 0, 0);
        public static final MathPanelVisibility PARTIAL = new MathPanelVisibility("PARTIAL", 1, 1);
        public static final MathPanelVisibility FULL = new MathPanelVisibility("FULL", 2, 2);

        private static final /* synthetic */ MathPanelVisibility[] $values() {
            return new MathPanelVisibility[]{INVISIBLE, PARTIAL, FULL};
        }

        static {
            MathPanelVisibility[] mathPanelVisibilityArr$values = $values();
            $VALUES = mathPanelVisibilityArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(mathPanelVisibilityArr$values);
        }

        private MathPanelVisibility(String str, int i, int i2) {
            this.value = i2;
        }

        @NotNull
        public static EnumEntries<MathPanelVisibility> getEntries() {
            return $ENTRIES;
        }

        public static MathPanelVisibility valueOf(String str) {
            return (MathPanelVisibility) Enum.valueOf(MathPanelVisibility.class, str);
        }

        public static MathPanelVisibility[] values() {
            return (MathPanelVisibility[]) $VALUES.clone();
        }

        public final int getValue() {
            return this.value;
        }
    }
}
