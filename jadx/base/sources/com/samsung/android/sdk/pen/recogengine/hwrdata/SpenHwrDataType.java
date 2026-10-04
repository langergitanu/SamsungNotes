package com.samsung.android.sdk.pen.recogengine.hwrdata;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recogengine/hwrdata/SpenHwrDataType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "HWR_DATA_TYPE_NONE", "HWR_DATA_TYPE_LINE", "HWR_DATA_TYPE_EXTRA", "HWR_DATA_TYPE_ALL", "HWR_DATA_TYPE_RESERVED", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenHwrDataType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SpenHwrDataType[] $VALUES;
    public static final SpenHwrDataType HWR_DATA_TYPE_ALL;
    public static final SpenHwrDataType HWR_DATA_TYPE_EXTRA;
    public static final SpenHwrDataType HWR_DATA_TYPE_LINE;
    public static final SpenHwrDataType HWR_DATA_TYPE_NONE;
    public static final SpenHwrDataType HWR_DATA_TYPE_RESERVED;
    private final int value;

    private static final /* synthetic */ SpenHwrDataType[] $values() {
        return new SpenHwrDataType[]{HWR_DATA_TYPE_NONE, HWR_DATA_TYPE_LINE, HWR_DATA_TYPE_EXTRA, HWR_DATA_TYPE_ALL, HWR_DATA_TYPE_RESERVED};
    }

    static {
        SpenHwrDataType spenHwrDataType = new SpenHwrDataType("HWR_DATA_TYPE_NONE", 0, 1);
        HWR_DATA_TYPE_NONE = spenHwrDataType;
        SpenHwrDataType spenHwrDataType2 = new SpenHwrDataType("HWR_DATA_TYPE_LINE", 1, spenHwrDataType.value << 1);
        HWR_DATA_TYPE_LINE = spenHwrDataType2;
        SpenHwrDataType spenHwrDataType3 = new SpenHwrDataType("HWR_DATA_TYPE_EXTRA", 2, spenHwrDataType2.value << 1);
        HWR_DATA_TYPE_EXTRA = spenHwrDataType3;
        HWR_DATA_TYPE_ALL = new SpenHwrDataType("HWR_DATA_TYPE_ALL", 3, spenHwrDataType.value | spenHwrDataType2.value | spenHwrDataType3.value);
        HWR_DATA_TYPE_RESERVED = new SpenHwrDataType("HWR_DATA_TYPE_RESERVED", 4, -2);
        SpenHwrDataType[] spenHwrDataTypeArr$values = $values();
        $VALUES = spenHwrDataTypeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(spenHwrDataTypeArr$values);
    }

    private SpenHwrDataType(String str, int i, int i2) {
        this.value = i2;
    }

    @NotNull
    public static EnumEntries<SpenHwrDataType> getEntries() {
        return $ENTRIES;
    }

    public static SpenHwrDataType valueOf(String str) {
        return (SpenHwrDataType) Enum.valueOf(SpenHwrDataType.class, str);
    }

    public static SpenHwrDataType[] values() {
        return (SpenHwrDataType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
