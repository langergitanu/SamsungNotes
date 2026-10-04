package com.vladsch.flexmark.util.sequence;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import androidx.glance.AbstractC2821a;
import com.vladsch.flexmark.util.misc.BitField;
import com.vladsch.flexmark.util.misc.BitFieldSet;
import com.vladsch.flexmark.util.misc.Utils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class LineInfo {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final Flags BLANK_PREFIX;
    public static final Flags BLANK_TEXT;
    public static final int F_BLANK_PREFIX;
    public static final int F_BLANK_TEXT;
    public static final int F_PREFORMATTED;
    public static final LineInfo NULL;
    public static final Flags PREFORMATTED;
    public final int flags;
    public final int index;
    public final int length;
    public final CharSequence lineSeq;
    public final int prefixLength;
    public final int sumLength;
    public final int sumPrefixLength;
    public final int sumTextLength;
    public final int textLength;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Flags implements BitField {
        PREFORMATTED(2),
        BLANK_PREFIX,
        BLANK_TEXT;

        final int bits;

        Flags() {
            this(1);
        }

        @Override // com.vladsch.flexmark.util.misc.BitField
        public int getBits() {
            return this.bits;
        }

        Flags(int i) {
            this.bits = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Preformatted {
        NONE,
        FIRST,
        BODY,
        LAST;

        final int mask = BitFieldSet.setBitField(0, Flags.PREFORMATTED, ordinal());

        Preformatted() {
        }

        @NotNull
        public static Preformatted get(int i) {
            int i2 = i & LineInfo.F_PREFORMATTED;
            Preformatted preformatted = FIRST;
            if (i2 == preformatted.mask) {
                return preformatted;
            }
            Preformatted preformatted2 = BODY;
            if (i2 == preformatted2.mask) {
                return preformatted2;
            }
            Preformatted preformatted3 = LAST;
            return i2 == preformatted3.mask ? preformatted3 : NONE;
        }
    }

    static {
        Flags flags = Flags.BLANK_PREFIX;
        BLANK_PREFIX = flags;
        Flags flags2 = Flags.BLANK_TEXT;
        BLANK_TEXT = flags2;
        Flags flags3 = Flags.PREFORMATTED;
        PREFORMATTED = flags3;
        F_PREFORMATTED = BitFieldSet.intMask(flags3);
        F_BLANK_PREFIX = BitFieldSet.intMask(flags);
        F_BLANK_TEXT = BitFieldSet.intMask(flags2);
        NULL = new LineInfo(BasedSequence.NULL, -1, 0, 0, 0, 0, 0, 0, true, true, Preformatted.NONE);
    }

    private LineInfo(@NotNull CharSequence charSequence, int i, int i2, int i4, int i5, int i6, int i7, int i8, boolean z, boolean z2, @NotNull Preformatted preformatted) {
        this.lineSeq = charSequence;
        this.index = i;
        this.prefixLength = i2;
        this.textLength = i4;
        this.length = i5;
        this.sumPrefixLength = i6 + i2;
        this.sumTextLength = i7 + i4;
        this.sumLength = i8 + i5;
        this.flags = ((z2 || i4 == 0) ? F_BLANK_TEXT : 0) | ((z || i2 == 0) ? F_BLANK_PREFIX : 0) | preformatted.ordinal();
    }

    @NotNull
    public static LineInfo create(@NotNull CharSequence charSequence, int i, int i2, int i4, boolean z, boolean z2, @NotNull Preformatted preformatted) {
        return new LineInfo(charSequence, 0, i, i2, i4, 0, 0, 0, z, z2, preformatted);
    }

    @NotNull
    public BasedSequence getEOL() {
        return getLine().subSequence(this.prefixLength + this.textLength, this.length);
    }

    @NotNull
    public BasedSequence getLine() {
        CharSequence charSequence = this.lineSeq;
        return charSequence instanceof BasedSequence ? (BasedSequence) charSequence : BasedSequence.m13437of(charSequence);
    }

    @NotNull
    public BasedSequence getLineNoEOL() {
        return getLine().subSequence(0, this.prefixLength + this.textLength);
    }

    @NotNull
    public BasedSequence getPrefix() {
        return getLine().subSequence(0, this.prefixLength);
    }

    @NotNull
    public Preformatted getPreformatted() {
        return Preformatted.get(this.flags);
    }

    @NotNull
    public BasedSequence getText() {
        return getLine().subSequence(this.prefixLength, this.length);
    }

    public int getTextEnd() {
        return this.prefixLength + this.textLength;
    }

    @NotNull
    public BasedSequence getTextNoEOL() {
        BasedSequence line = getLine();
        int i = this.prefixLength;
        return line.subSequence(i, this.textLength + i);
    }

    public int getTextStart() {
        return this.prefixLength;
    }

    public boolean isBlankPrefix() {
        return BitFieldSet.any(this.flags, F_BLANK_PREFIX);
    }

    public boolean isBlankText() {
        return BitFieldSet.any(this.flags, F_BLANK_TEXT);
    }

    public boolean isBlankTextAndPrefix() {
        return BitFieldSet.all(this.flags, F_BLANK_PREFIX | F_BLANK_TEXT);
    }

    public boolean isNotNull() {
        return this != NULL;
    }

    public boolean isNull() {
        return this == NULL;
    }

    public boolean isPreformatted() {
        return BitFieldSet.any(this.flags, F_PREFORMATTED);
    }

    public boolean needAggregateUpdate(LineInfo lineInfo) {
        return (this.sumPrefixLength == lineInfo.sumPrefixLength && this.sumTextLength == lineInfo.sumTextLength && this.sumLength == lineInfo.sumLength) ? false : true;
    }

    public String toString() {
        String strM774p;
        int i = this.index;
        int i2 = this.prefixLength;
        int i4 = this.textLength;
        int i5 = this.length;
        int i6 = this.sumPrefixLength;
        int i7 = this.sumTextLength;
        int i8 = this.sumLength;
        strM774p = "";
        if (this.flags != 0) {
            strM774p = AbstractC0541b.m774p(",", isBlankPrefix() ? " bp" : "", isBlankText() ? " bt" : "", isPreformatted() ? " p" : "");
        }
        String strEscapeJavaString = Utils.escapeJavaString(this.lineSeq);
        StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i2, "LineInfo{i=", ", pl=", ", tl=");
        AbstractC2821a.m2235z(sbM1173s, i4, i5, ", l=", ", sumPl=");
        AbstractC2821a.m2235z(sbM1173s, i6, i7, ", sumTl=", ", sumL=");
        AbstractC1974b.m1331x(sbM1173s, i8, strM774p, ", '", strEscapeJavaString);
        sbM1173s.append("'}");
        return sbM1173s.toString();
    }

    @NotNull
    public static LineInfo create(@NotNull CharSequence charSequence, @NotNull LineInfo lineInfo, int i, int i2, int i4, boolean z, boolean z2, @NotNull Preformatted preformatted) {
        return new LineInfo(charSequence, lineInfo.index + 1, i, i2, i4, lineInfo.sumPrefixLength, lineInfo.sumTextLength, lineInfo.sumLength, z, z2, preformatted);
    }

    @NotNull
    public static LineInfo create(@NotNull LineInfo lineInfo, @NotNull LineInfo lineInfo2) {
        return new LineInfo(lineInfo2.lineSeq, lineInfo.index + 1, lineInfo2.prefixLength, lineInfo2.textLength, lineInfo2.length, lineInfo.sumPrefixLength, lineInfo.sumTextLength, lineInfo.sumLength, lineInfo2.isBlankPrefix(), lineInfo2.isBlankText(), lineInfo2.getPreformatted());
    }
}
