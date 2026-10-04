package com.samsung.android.sdk.pen.recoguifeature.common;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/common/SpenHwrFailCode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "FAILED_CODE_NO_HANDWRITING", "FAILED_CODE_ABNORMAL_BEHAVIOR", "FAILED_CODE_NO_RESULT", "FAILED_CODE_CANCELED", "FAILED_CODE_NOT_INITIALIZED", "FAILED_CODE_CODE_SIZE", "FAILED_CODE_RESERVED", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHwrFailCode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SpenHwrFailCode[] $VALUES;
    private final int value;
    public static final SpenHwrFailCode FAILED_CODE_NO_HANDWRITING = new SpenHwrFailCode("FAILED_CODE_NO_HANDWRITING", 0, 0);
    public static final SpenHwrFailCode FAILED_CODE_ABNORMAL_BEHAVIOR = new SpenHwrFailCode("FAILED_CODE_ABNORMAL_BEHAVIOR", 1, 1);
    public static final SpenHwrFailCode FAILED_CODE_NO_RESULT = new SpenHwrFailCode("FAILED_CODE_NO_RESULT", 2, 2);
    public static final SpenHwrFailCode FAILED_CODE_CANCELED = new SpenHwrFailCode("FAILED_CODE_CANCELED", 3, 3);
    public static final SpenHwrFailCode FAILED_CODE_NOT_INITIALIZED = new SpenHwrFailCode("FAILED_CODE_NOT_INITIALIZED", 4, 4);
    public static final SpenHwrFailCode FAILED_CODE_CODE_SIZE = new SpenHwrFailCode("FAILED_CODE_CODE_SIZE", 5, 5);
    public static final SpenHwrFailCode FAILED_CODE_RESERVED = new SpenHwrFailCode("FAILED_CODE_RESERVED", 6, -2);

    private static final /* synthetic */ SpenHwrFailCode[] $values() {
        return new SpenHwrFailCode[]{FAILED_CODE_NO_HANDWRITING, FAILED_CODE_ABNORMAL_BEHAVIOR, FAILED_CODE_NO_RESULT, FAILED_CODE_CANCELED, FAILED_CODE_NOT_INITIALIZED, FAILED_CODE_CODE_SIZE, FAILED_CODE_RESERVED};
    }

    static {
        SpenHwrFailCode[] spenHwrFailCodeArr$values = $values();
        $VALUES = spenHwrFailCodeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(spenHwrFailCodeArr$values);
    }

    private SpenHwrFailCode(String str, int i, int i2) {
        this.value = i2;
    }

    @NotNull
    public static EnumEntries<SpenHwrFailCode> getEntries() {
        return $ENTRIES;
    }

    public static SpenHwrFailCode valueOf(String str) {
        return (SpenHwrFailCode) Enum.valueOf(SpenHwrFailCode.class, str);
    }

    public static SpenHwrFailCode[] values() {
        return (SpenHwrFailCode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
