package com.samsung.android.sdk.pen.setting.colorpalette;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(m13885d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m13886d2 = {"Lcom/samsung/android/sdk/pen/setting/colorpalette/ColorChipShape;", "", "<init>", "(Ljava/lang/String;I)V", "RECTANGLE", "CIRCLE", "SDK_fullRelease"}, m13887k = 1, m13888mv = {2, 0, 0}, m13890xi = 48)
public final class ColorChipShape {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ColorChipShape[] $VALUES;
    public static final ColorChipShape RECTANGLE = new ColorChipShape("RECTANGLE", 0);
    public static final ColorChipShape CIRCLE = new ColorChipShape("CIRCLE", 1);

    private static final /* synthetic */ ColorChipShape[] $values() {
        return new ColorChipShape[]{RECTANGLE, CIRCLE};
    }

    static {
        ColorChipShape[] colorChipShapeArr$values = $values();
        $VALUES = colorChipShapeArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(colorChipShapeArr$values);
    }

    private ColorChipShape(String str, int i) {
    }

    @NotNull
    public static EnumEntries<ColorChipShape> getEntries() {
        return $ENTRIES;
    }

    public static ColorChipShape valueOf(String str) {
        return (ColorChipShape) Enum.valueOf(ColorChipShape.class, str);
    }

    public static ColorChipShape[] values() {
        return (ColorChipShape[]) $VALUES.clone();
    }
}
