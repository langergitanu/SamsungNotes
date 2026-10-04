package com.samsung.android.sdk.pen.recogengine.hwrdata;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrExtraDataType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EXTRA_DATA_TYPE_NONE", "EXTRA_DATA_TYPE_STRAIGHT_MARKER", "EXTRA_DATA_TYPE_SHAPE_LINE", "EXTRA_DATA_TYPE_SHAPE_RECT", "EXTRA_DATA_TYPE_SHAPE_OTHER", "EXTRA_DATA_TYPE_LARGE", "EXTRA_DATA_TYPE_OTHER", "EXTRA_DATA_TYPE_RESERVED", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHwrExtraDataType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SpenHwrExtraDataType[] $VALUES;
    private final int value;
    public static final SpenHwrExtraDataType EXTRA_DATA_TYPE_NONE = new SpenHwrExtraDataType("EXTRA_DATA_TYPE_NONE", 0, 0);
    public static final SpenHwrExtraDataType EXTRA_DATA_TYPE_STRAIGHT_MARKER = new SpenHwrExtraDataType("EXTRA_DATA_TYPE_STRAIGHT_MARKER", 1, 1);
    public static final SpenHwrExtraDataType EXTRA_DATA_TYPE_SHAPE_LINE = new SpenHwrExtraDataType("EXTRA_DATA_TYPE_SHAPE_LINE", 2, 2);
    public static final SpenHwrExtraDataType EXTRA_DATA_TYPE_SHAPE_RECT = new SpenHwrExtraDataType("EXTRA_DATA_TYPE_SHAPE_RECT", 3, 3);
    public static final SpenHwrExtraDataType EXTRA_DATA_TYPE_SHAPE_OTHER = new SpenHwrExtraDataType("EXTRA_DATA_TYPE_SHAPE_OTHER", 4, 4);
    public static final SpenHwrExtraDataType EXTRA_DATA_TYPE_LARGE = new SpenHwrExtraDataType("EXTRA_DATA_TYPE_LARGE", 5, 5);
    public static final SpenHwrExtraDataType EXTRA_DATA_TYPE_OTHER = new SpenHwrExtraDataType("EXTRA_DATA_TYPE_OTHER", 6, 6);
    public static final SpenHwrExtraDataType EXTRA_DATA_TYPE_RESERVED = new SpenHwrExtraDataType("EXTRA_DATA_TYPE_RESERVED", 7, -2);

    private static final /* synthetic */ SpenHwrExtraDataType[] $values() {
        return new SpenHwrExtraDataType[]{EXTRA_DATA_TYPE_NONE, EXTRA_DATA_TYPE_STRAIGHT_MARKER, EXTRA_DATA_TYPE_SHAPE_LINE, EXTRA_DATA_TYPE_SHAPE_RECT, EXTRA_DATA_TYPE_SHAPE_OTHER, EXTRA_DATA_TYPE_LARGE, EXTRA_DATA_TYPE_OTHER, EXTRA_DATA_TYPE_RESERVED};
    }

    static {
        SpenHwrExtraDataType[] spenHwrExtraDataTypeArr$values = $values();
        $VALUES = spenHwrExtraDataTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(spenHwrExtraDataTypeArr$values);
    }

    private SpenHwrExtraDataType(String str, int i, int i2) {
        this.value = i2;
    }

    @NotNull
    public static EnumEntries<SpenHwrExtraDataType> getEntries() {
        return $ENTRIES;
    }

    public static SpenHwrExtraDataType valueOf(String str) {
        return (SpenHwrExtraDataType) Enum.valueOf(SpenHwrExtraDataType.class, str);
    }

    public static SpenHwrExtraDataType[] values() {
        return (SpenHwrExtraDataType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
