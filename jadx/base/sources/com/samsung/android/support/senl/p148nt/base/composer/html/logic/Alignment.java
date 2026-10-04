package com.samsung.android.support.senl.p148nt.base.composer.html.logic;

import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/composer/html/logic/Alignment;", "", "spenAlign", "", "<init>", "(Ljava/lang/String;II)V", "getSpenAlign", "()I", CoverStickerConstants.Category.NONE.NAME, "LEFT", "CENTER", "RIGHT", "JUSTIFY", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class Alignment {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Alignment[] $VALUES;
    private final int spenAlign;
    public static final Alignment NONE = new Alignment(CoverStickerConstants.Category.NONE.NAME, 0, -1);
    public static final Alignment LEFT = new Alignment("LEFT", 1, 0);
    public static final Alignment CENTER = new Alignment("CENTER", 2, 2);
    public static final Alignment RIGHT = new Alignment("RIGHT", 3, 1);
    public static final Alignment JUSTIFY = new Alignment("JUSTIFY", 4, 3);

    private static final /* synthetic */ Alignment[] $values() {
        return new Alignment[]{NONE, LEFT, CENTER, RIGHT, JUSTIFY};
    }

    static {
        Alignment[] alignmentArr$values = $values();
        $VALUES = alignmentArr$values;
        $ENTRIES = EnumEntriesKt.enumEntries(alignmentArr$values);
    }

    private Alignment(String str, int i, int i2) {
        this.spenAlign = i2;
    }

    @NotNull
    public static EnumEntries<Alignment> getEntries() {
        return $ENTRIES;
    }

    public static Alignment valueOf(String str) {
        return (Alignment) Enum.valueOf(Alignment.class, str);
    }

    public static Alignment[] values() {
        return (Alignment[]) $VALUES.clone();
    }

    public final int getSpenAlign() {
        return this.spenAlign;
    }
}
