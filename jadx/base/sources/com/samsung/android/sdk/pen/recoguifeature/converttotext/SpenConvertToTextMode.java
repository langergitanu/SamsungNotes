package com.samsung.android.sdk.pen.recoguifeature.converttotext;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/recoguifeature/converttotext/SpenConvertToTextMode;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "MODE_DEFAULT", "MODE_EXTRACT_TEXT", "MODE_AUTO_FORMAT", "MODE_AUTO_FORMAT_EXTRACT_TEXT", "MODE_AUTO_RESERVED", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class SpenConvertToTextMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SpenConvertToTextMode[] $VALUES;
    public static final SpenConvertToTextMode MODE_AUTO_FORMAT;
    public static final SpenConvertToTextMode MODE_AUTO_FORMAT_EXTRACT_TEXT;
    public static final SpenConvertToTextMode MODE_AUTO_RESERVED;
    public static final SpenConvertToTextMode MODE_DEFAULT;
    public static final SpenConvertToTextMode MODE_EXTRACT_TEXT;
    private final int value;

    private static final /* synthetic */ SpenConvertToTextMode[] $values() {
        return new SpenConvertToTextMode[]{MODE_DEFAULT, MODE_EXTRACT_TEXT, MODE_AUTO_FORMAT, MODE_AUTO_FORMAT_EXTRACT_TEXT, MODE_AUTO_RESERVED};
    }

    static {
        SpenConvertToTextMode spenConvertToTextMode = new SpenConvertToTextMode("MODE_DEFAULT", 0, 1);
        MODE_DEFAULT = spenConvertToTextMode;
        SpenConvertToTextMode spenConvertToTextMode2 = new SpenConvertToTextMode("MODE_EXTRACT_TEXT", 1, spenConvertToTextMode.value << 1);
        MODE_EXTRACT_TEXT = spenConvertToTextMode2;
        SpenConvertToTextMode spenConvertToTextMode3 = new SpenConvertToTextMode("MODE_AUTO_FORMAT", 2, spenConvertToTextMode2.value << 1);
        MODE_AUTO_FORMAT = spenConvertToTextMode3;
        MODE_AUTO_FORMAT_EXTRACT_TEXT = new SpenConvertToTextMode("MODE_AUTO_FORMAT_EXTRACT_TEXT", 3, spenConvertToTextMode3.value | spenConvertToTextMode2.value);
        MODE_AUTO_RESERVED = new SpenConvertToTextMode("MODE_AUTO_RESERVED", 4, -2);
        SpenConvertToTextMode[] spenConvertToTextModeArr$values = $values();
        $VALUES = spenConvertToTextModeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(spenConvertToTextModeArr$values);
    }

    private SpenConvertToTextMode(String str, int i, int i2) {
        this.value = i2;
    }

    @NotNull
    public static EnumEntries<SpenConvertToTextMode> getEntries() {
        return $ENTRIES;
    }

    public static SpenConvertToTextMode valueOf(String str) {
        return (SpenConvertToTextMode) Enum.valueOf(SpenConvertToTextMode.class, str);
    }

    public static SpenConvertToTextMode[] values() {
        return (SpenConvertToTextMode[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }
}
