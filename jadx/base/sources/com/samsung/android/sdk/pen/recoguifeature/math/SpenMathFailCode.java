package com.samsung.android.sdk.pen.recoguifeature.math;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00152\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0015B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0016"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/math/SpenMathFailCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MF_Default", "MF_InvalidInput", "MF_InvalidOutput", "MF_DBNotLoaded", "MF_Canceled", "MF_MathRecogInputError", "MF_MathRecogFailed", "MF_MathSolverFailed", "MF_HwrGenInputError", "MF_HwrGenFailed", "MF_NotInitialized", "toString", "", "Companion", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenMathFailCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SpenMathFailCode[] $VALUES;

    @NotNull
    private static final String TAG = "SpenMathFailCode";
    private final int value;
    public static final SpenMathFailCode MF_Default = new SpenMathFailCode("MF_Default", 0, 0);
    public static final SpenMathFailCode MF_InvalidInput = new SpenMathFailCode("MF_InvalidInput", 1, 1);
    public static final SpenMathFailCode MF_InvalidOutput = new SpenMathFailCode("MF_InvalidOutput", 2, 2);
    public static final SpenMathFailCode MF_DBNotLoaded = new SpenMathFailCode("MF_DBNotLoaded", 3, 3);
    public static final SpenMathFailCode MF_Canceled = new SpenMathFailCode("MF_Canceled", 4, 4);
    public static final SpenMathFailCode MF_MathRecogInputError = new SpenMathFailCode("MF_MathRecogInputError", 5, 5);
    public static final SpenMathFailCode MF_MathRecogFailed = new SpenMathFailCode("MF_MathRecogFailed", 6, 6);
    public static final SpenMathFailCode MF_MathSolverFailed = new SpenMathFailCode("MF_MathSolverFailed", 7, 7);
    public static final SpenMathFailCode MF_HwrGenInputError = new SpenMathFailCode("MF_HwrGenInputError", 8, 8);
    public static final SpenMathFailCode MF_HwrGenFailed = new SpenMathFailCode("MF_HwrGenFailed", 9, 9);
    public static final SpenMathFailCode MF_NotInitialized = new SpenMathFailCode("MF_NotInitialized", 10, 10);

    private static final /* synthetic */ SpenMathFailCode[] $values() {
        return new SpenMathFailCode[]{MF_Default, MF_InvalidInput, MF_InvalidOutput, MF_DBNotLoaded, MF_Canceled, MF_MathRecogInputError, MF_MathRecogFailed, MF_MathSolverFailed, MF_HwrGenInputError, MF_HwrGenFailed, MF_NotInitialized};
    }

    static {
        SpenMathFailCode[] spenMathFailCodeArr$values = $values();
        $VALUES = spenMathFailCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(spenMathFailCodeArr$values);
        INSTANCE = new Companion(null);
    }

    private SpenMathFailCode(String str, int i, int i2) {
        this.value = i2;
    }

    @NotNull
    public static EnumEntries<SpenMathFailCode> getEntries() {
        return $ENTRIES;
    }

    public static SpenMathFailCode valueOf(String str) {
        return (SpenMathFailCode) Enum.valueOf(SpenMathFailCode.class, str);
    }

    public static SpenMathFailCode[] values() {
        return (SpenMathFailCode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return name();
    }
}
