package com.vladsch.flexmark.util.sequence.builder;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.Range;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class Seg {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Seg ANCHOR_0;
    public static final int F_TEXT_OPTION = 1073741824;
    public static final int MAX_TEXT_OFFSET = 1073741823;
    public static final Seg NULL;
    private final int end;
    private final int start;

    static {
        Range range = Range.NULL;
        NULL = new Seg(range.getStart(), range.getEnd());
        ANCHOR_0 = new Seg(0, 0);
    }

    private Seg(int i, int i2) {
        this.start = i;
        this.end = i2;
    }

    public static int getTextEnd(int i, boolean z) {
        if (z) {
            i |= 1073741824;
        }
        return (-i) - 1;
    }

    public static int getTextOffset(int i) {
        return ((-i) - 1) & 1073741823;
    }

    public static int getTextStart(int i, boolean z) {
        if (z) {
            i |= 1073741824;
        }
        return (-i) - 1;
    }

    public static boolean isFirst256Start(int i) {
        return (((-i) - 1) & 1073741824) != 0;
    }

    public static boolean isRepeatedTextEnd(int i) {
        return (((-i) - 1) & 1073741824) != 0;
    }

    @NotNull
    public static Seg segOf(int i, int i2) {
        return (i == 0 && i2 == 0) ? ANCHOR_0 : new Seg(i, i2);
    }

    @NotNull
    public static Seg textOf(int i, int i2, boolean z, boolean z2) {
        return new Seg(getTextStart(i, z), getTextEnd(i2, z2));
    }

    public int getEnd() {
        return this.end;
    }

    @NotNull
    public Range getRange() {
        return Range.m13451of(this.start, this.end);
    }

    public int getSegEnd() {
        return isText() ? getTextEnd() : this.end;
    }

    public int getSegStart() {
        return isText() ? getTextStart() : this.start;
    }

    public int getStart() {
        return this.start;
    }

    public boolean isAnchor() {
        int i;
        int i2 = this.start;
        return i2 >= 0 && (i = this.end) >= 0 && i2 == i;
    }

    public boolean isBase() {
        int i;
        int i2 = this.start;
        return i2 >= 0 && (i = this.end) >= 0 && i2 <= i;
    }

    public boolean isNull() {
        return (isBase() || isText()) ? false : true;
    }

    public boolean isText() {
        int i;
        int i2 = this.start;
        return i2 < 0 && (i = this.end) < 0 && (i2 & 1073741823) > (i & 1073741823);
    }

    public int length() {
        int i;
        int i2;
        if (isBase()) {
            i = this.end;
            i2 = this.start;
        } else {
            if (!isText()) {
                return 0;
            }
            i = this.start & 1073741823;
            i2 = 1073741823 & this.end;
        }
        return i - i2;
    }

    public String toString(@NotNull CharSequence charSequence) {
        if (isNull()) {
            return "NULL";
        }
        if (isBase()) {
            int i = this.start;
            int i2 = this.end;
            return i == i2 ? AbstractC0541b.m767i(i, "[", ")") : AbstractC0622a.m1164j(i, i2, "[", SQLKeyword.COMMA, ")");
        }
        CharSequence charSequenceSubSequence = charSequence.subSequence(getTextStart(), getTextEnd());
        if (!isRepeatedTextEnd() || length() <= 1) {
            String string = length() <= 20 ? charSequenceSubSequence.toString() : AbstractC0541b.m757C(charSequenceSubSequence.subSequence(0, 10).toString(), "…", charSequenceSubSequence.subSequence(length() - 10, length()).toString());
            return isFirst256Start() ? AbstractC0541b.m773o("a:'", Utils.escapeJavaString(string), "'") : AbstractC0541b.m773o("'", Utils.escapeJavaString(string), "'");
        }
        if (isFirst256Start()) {
            return AbstractC11014a.m12321f("a:", length(), "x'", Utils.escapeJavaString(charSequenceSubSequence.subSequence(0, 1)), "'");
        }
        return length() + "x'" + Utils.escapeJavaString(charSequenceSubSequence.subSequence(0, 1)) + "'";
    }

    public int getTextEnd() {
        return getTextOffset(this.end);
    }

    public int getTextStart() {
        return getTextOffset(this.start);
    }

    public boolean isFirst256Start() {
        return isFirst256Start(this.start);
    }

    public boolean isRepeatedTextEnd() {
        return isRepeatedTextEnd(this.end);
    }

    public String toString() {
        if (isNull()) {
            return "NULL";
        }
        if (isBase()) {
            int i = this.start;
            int i2 = this.end;
            if (i == i2) {
                return AbstractC0541b.m767i(i, "BASE[", ")");
            }
            return AbstractC0622a.m1164j(i, i2, "BASE[", SQLKeyword.COMMA, ")");
        }
        return AbstractC0622a.m1164j(getTextStart(), getTextEnd(), "TEXT[", SQLKeyword.COMMA, ")");
    }
}
