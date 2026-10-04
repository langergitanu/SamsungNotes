package com.vladsch.flexmark.util.sequence.builder.tree;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p148nt.data.common.utils.AbstractC11014a;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.sun.imageio.plugins.jpeg.JPEG;
import com.vladsch.flexmark.util.misc.Utils;
import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.builder.Seg;
import com.yubico.yubikit.core.fido.CtapException;
import org.jetbrains.annotations.NotNull;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public abstract class Segment {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    static final int TYPE_ANCHOR = 0;
    static final int TYPE_BASE = 32;
    static final int TYPE_HAS_BOTH = 768;
    static final int TYPE_HAS_BYTE = 4096;
    static final int TYPE_HAS_BYTES = 8192;
    static final int TYPE_HAS_CHAR = 1024;
    static final int TYPE_HAS_CHARS = 2048;
    static final int TYPE_HAS_LENGTH = 512;
    static final int TYPE_HAS_OFFSET = 256;
    static final int TYPE_LENGTH_BYTES = 12;
    static final int TYPE_MASK = 224;
    static final int TYPE_NO_SIZE_BYTES = 16;
    static final int TYPE_REPEATED_ASCII = 160;
    static final int TYPE_REPEATED_EOL = 224;
    static final int TYPE_REPEATED_SPACE = 192;
    static final int TYPE_REPEATED_TEXT = 96;
    static final int TYPE_START_BYTES = 3;
    static final int TYPE_TEXT = 64;
    static final int TYPE_TEXT_ASCII = 128;
    protected final int byteOffset;
    protected final byte[] bytes;
    protected final int pos;
    protected final int startIndex;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Base extends Segment {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @NotNull
        protected final BasedSequence baseSeq;
        protected final int endOffset;
        protected final int startOffset;

        public Base(int i, byte[] bArr, int i2, int i4, @NotNull BasedSequence basedSequence) {
            super(i, bArr, i2, i4);
            this.baseSeq = basedSequence;
            int i5 = i2 + 1;
            int i6 = bArr[i2];
            int i7 = i6 & 255;
            if ((i6 & JPEG.APP0) != 0) {
                int i8 = (i6 & 3) + 1;
                int i9 = Segment.getInt(bArr, i5, i8);
                this.startOffset = i9;
                this.endOffset = Segment.getInt(bArr, i5 + i8, ((i6 & 12) >> 2) + 1) + i9;
                return;
            }
            if (hasAll(i7, 16)) {
                int i10 = i6 & 15;
                this.startOffset = i10;
                this.endOffset = i10;
            } else {
                int i11 = Segment.getInt(bArr, i5, (i6 & 3) + 1);
                this.startOffset = i11;
                this.endOffset = i11;
            }
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public char charAt(int i) {
            int i2 = this.startIndex;
            if (i >= i2 && i - i2 < length()) {
                return this.baseSeq.charAt((this.startOffset + i) - this.startIndex);
            }
            int i4 = this.startIndex;
            int length = length();
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i4, "index ", " out of bounds [", SQLKeyword.COMMA);
            sbM1173s.append(i4);
            sbM1173s.append(length);
            sbM1173s.append(")");
            throw new IndexOutOfBoundsException(sbM1173s.toString());
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public CharSequence getCharSequence() {
            return this.baseSeq.subSequence(this.startOffset, this.endOffset);
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public int getEndOffset() {
            return this.endOffset;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public int getStartOffset() {
            return this.startOffset;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public boolean isAnchor() {
            return this.startOffset == this.endOffset;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public boolean isBase() {
            return true;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public boolean isFirst256Start() {
            return false;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public boolean isRepeatedTextEnd() {
            return false;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public boolean isText() {
            return false;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public int length() {
            return this.endOffset - this.startOffset;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum SegType {
        ANCHOR(256),
        BASE(800),
        TEXT(2624),
        REPEATED_TEXT(1632),
        TEXT_ASCII(8832),
        REPEATED_ASCII(4768),
        REPEATED_SPACE(704),
        REPEATED_EOL(736);

        public final int flags;

        SegType(int i) {
            this.flags = i;
        }

        public static SegType fromTypeMask(int i) {
            int i2 = i & JPEG.APP0;
            if (i2 == 0) {
                return ANCHOR;
            }
            if (i2 == 32) {
                return BASE;
            }
            if (i2 == 64) {
                return TEXT;
            }
            if (i2 == 96) {
                return REPEATED_TEXT;
            }
            if (i2 == 128) {
                return TEXT_ASCII;
            }
            if (i2 == 160) {
                return REPEATED_ASCII;
            }
            if (i2 == 192) {
                return REPEATED_SPACE;
            }
            if (i2 == 224) {
                return REPEATED_EOL;
            }
            throw new IllegalStateException(String.format("Invalid text type %02x", Integer.valueOf(i)));
        }

        public boolean hasAll(int i) {
            return (this.flags & i) == i;
        }

        public boolean hasBoth() {
            return hasAll(768);
        }

        public boolean hasByte() {
            return hasAll(4096);
        }

        public boolean hasBytes() {
            return hasAll(8192);
        }

        public boolean hasChar() {
            return hasAll(1024);
        }

        public boolean hasChars() {
            return hasAll(2048);
        }

        public boolean hasLength() {
            return hasAll(512);
        }

        public boolean hasOffset() {
            return hasAll(256);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Text extends Segment {

        @NotNull
        protected final CharSequence chars;

        public Text(int i, byte[] bArr, int i2, int i4) {
            int i5;
            super(i, bArr, i2, i4);
            int i6 = i2 + 1;
            int i7 = bArr[i2];
            int i8 = i7 & JPEG.APP0;
            if (hasAll(i7 & 255, 16)) {
                i5 = i7 & 15;
            } else {
                int i9 = ((i7 & 12) >> 2) + 1;
                int i10 = Segment.getInt(bArr, i6, i9);
                i6 += i9;
                i5 = i10;
            }
            if (i8 == 64) {
                this.chars = new TextCharSequence(bArr, i6, 0, i5);
                return;
            }
            if (i8 == 96) {
                this.chars = new TextRepeatedSequence(Segment.getChar(bArr, i6), i5);
                return;
            }
            if (i8 == 128) {
                this.chars = new TextAsciiCharSequence(bArr, i6, 0, i5);
                return;
            }
            if (i8 == 160) {
                this.chars = new TextRepeatedSequence((char) (bArr[i6] & 255), i5);
            } else if (i8 == 192) {
                this.chars = new TextRepeatedSequence(' ', i5);
            } else {
                if (i8 != 224) {
                    throw new IllegalStateException(AbstractC0000a.m11h(i8, "Invalid text type "));
                }
                this.chars = new TextRepeatedSequence('\n', i5);
            }
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public char charAt(int i) {
            int i2 = this.startIndex;
            if (i >= i2 && i - i2 < this.chars.length()) {
                return this.chars.charAt(i - this.startIndex);
            }
            int i4 = this.startIndex;
            int length = this.chars.length();
            StringBuilder sbM1173s = AbstractC0622a.m1173s(i, i4, "index ", " out of bounds [", SQLKeyword.COMMA);
            sbM1173s.append(i4);
            sbM1173s.append(length);
            sbM1173s.append(")");
            throw new IndexOutOfBoundsException(sbM1173s.toString());
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        @NotNull
        public CharSequence getCharSequence() {
            return this.chars;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public int getEndOffset() {
            return -1;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public int getStartOffset() {
            return -1;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public boolean isAnchor() {
            return false;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public boolean isBase() {
            return false;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public boolean isFirst256Start() {
            int iTextType = textType();
            return iTextType == 128 || iTextType == 160 || iTextType == 192 || iTextType == 224;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public boolean isRepeatedTextEnd() {
            int iTextType = textType();
            return iTextType == 96 || iTextType == 160 || iTextType == 192 || iTextType == 224;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public boolean isText() {
            return true;
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment
        public int length() {
            return this.chars.length();
        }

        public int textType() {
            return this.bytes[this.byteOffset] & CtapException.ERR_EXTENSION_FIRST;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TextAsciiCharSequence extends TextCharSequenceBase {
        public TextAsciiCharSequence(byte[] bArr, int i, int i2, int i4) {
            super(bArr, i, i2, i4);
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment.TextCharSequenceBase, java.lang.CharSequence
        public char charAt(int i) {
            if (i < 0 || i >= this.length) {
                throw new IndexOutOfBoundsException(AbstractC0622a.m1164j(i, this.length, "index ", " out of bounds [0, ", ")"));
            }
            return (char) (this.bytes[this.byteOffset + this.startOffset + i] & 255);
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment.TextCharSequenceBase
        public CharSequence create(int i, int i2) {
            return new TextAsciiCharSequence(this.bytes, this.byteOffset, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TextCharSequence extends TextCharSequenceBase {
        public TextCharSequence(byte[] bArr, int i, int i2, int i4) {
            super(bArr, i, i2, i4);
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment.TextCharSequenceBase, java.lang.CharSequence
        public char charAt(int i) {
            if (i < 0 || i >= this.length) {
                throw new IndexOutOfBoundsException(AbstractC0622a.m1164j(i, this.length, "index ", " out of bounds [0, ", ")"));
            }
            return Segment.getChar(this.bytes, ((this.startOffset + i) * 2) + this.byteOffset);
        }

        @Override // com.vladsch.flexmark.util.sequence.builder.tree.Segment.TextCharSequenceBase
        public CharSequence create(int i, int i2) {
            return new TextCharSequence(this.bytes, this.byteOffset, i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class TextCharSequenceBase implements CharSequence {
        protected final int byteOffset;
        protected final byte[] bytes;
        protected final int length;
        protected final int startOffset;

        public TextCharSequenceBase(byte[] bArr, int i, int i2, int i4) {
            this.bytes = bArr;
            this.byteOffset = i;
            this.startOffset = i2;
            this.length = i4;
        }

        @Override // java.lang.CharSequence
        public abstract char charAt(int i);

        public abstract CharSequence create(int i, int i2);

        @Override // java.lang.CharSequence
        public int length() {
            return this.length;
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            if (i >= 0 && i <= i2 && i2 <= this.length) {
                return create(this.startOffset + i, i2 - i);
            }
            throw new IndexOutOfBoundsException(AbstractC2821a.m2223n(AbstractC0622a.m1173s(i, i2, "Invalid index range [", SQLKeyword.COMMA, "] out of bounds [0, "), ")", length()));
        }

        @Override // java.lang.CharSequence
        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.length; i++) {
                sb.append(charAt(i));
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TextRepeatedSequence implements CharSequence {

        /* JADX INFO: renamed from: c */
        protected final char f8417c;
        protected final int length;

        public TextRepeatedSequence(char c, int i) {
            this.f8417c = c;
            this.length = i;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            if (i < 0 || i >= this.length) {
                throw new IndexOutOfBoundsException(AbstractC0622a.m1164j(i, this.length, "index ", " out of bounds [0, ", ")"));
            }
            return this.f8417c;
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.length;
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            if (i >= 0 && i <= i2 && i2 <= this.length) {
                return new TextRepeatedSequence(this.f8417c, i2 - i);
            }
            throw new IndexOutOfBoundsException(AbstractC2821a.m2223n(AbstractC0622a.m1173s(i, i2, "Invalid index range [", SQLKeyword.COMMA, "] out of bounds [0, "), ")", length()));
        }

        @Override // java.lang.CharSequence
        @NotNull
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.length; i++) {
                sb.append(this.f8417c);
            }
            return sb.toString();
        }
    }

    public Segment(int i, byte[] bArr, int i2, int i4) {
        this.pos = i;
        this.bytes = bArr;
        this.byteOffset = i2;
        this.startIndex = i4;
    }

    public static int addChar(byte[] bArr, int i, char c) {
        int i2 = i + 1;
        bArr[i] = (byte) ((65280 & c) >> 8);
        int i4 = i + 2;
        bArr[i2] = (byte) (c & 255);
        return i4;
    }

    public static int addCharAscii(byte[] bArr, int i, char c) {
        int i2 = i + 1;
        bArr[i] = (byte) (c & 255);
        return i2;
    }

    public static int addChars(byte[] bArr, int i, @NotNull CharSequence charSequence, int i2, int i4) {
        while (i2 < i4) {
            char cCharAt = charSequence.charAt(i2);
            int i5 = i + 1;
            bArr[i] = (byte) ((65280 & cCharAt) >> 8);
            i += 2;
            bArr[i5] = (byte) (cCharAt & 255);
            i2++;
        }
        return i;
    }

    public static int addCharsAscii(byte[] bArr, int i, @NotNull CharSequence charSequence, int i2, int i4) {
        while (i2 < i4) {
            bArr[i] = (byte) (charSequence.charAt(i2) & 255);
            i2++;
            i++;
        }
        return i;
    }

    public static int addIntBytes(byte[] bArr, int i, int i2, int i4) {
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        return i;
                    }
                    bArr[i] = (byte) (((-16777216) & i2) >> 24);
                    i++;
                }
                bArr[i] = (byte) ((16711680 & i2) >> 16);
                i++;
            }
            bArr[i] = (byte) ((65280 & i2) >> 8);
            i++;
        }
        int i5 = i + 1;
        bArr[i] = (byte) (i2 & 255);
        return i5;
    }

    public static int addSegBytes(byte[] bArr, int i, @NotNull Seg seg, @NotNull CharSequence charSequence) {
        SegType segType = getSegType(seg, charSequence);
        int length = seg.length();
        if (segType.hasOffset()) {
            int start = seg.getStart();
            if (segType.hasLength()) {
                int intBytes = getIntBytes(start);
                int intBytes2 = getIntBytes(length);
                bArr[i] = (byte) (segType.flags | (intBytes - 1) | ((intBytes2 - 1) << 2));
                i = addIntBytes(bArr, addIntBytes(bArr, i + 1, start, intBytes), length, intBytes2);
            } else {
                int offsetBytes = getOffsetBytes(start);
                if (offsetBytes == 0) {
                    bArr[i] = (byte) (start | segType.flags | 16);
                    i++;
                } else {
                    bArr[i] = (byte) (segType.flags | (offsetBytes - 1));
                    i = addIntBytes(bArr, i + 1, start, offsetBytes);
                }
            }
        } else if (segType.hasLength()) {
            int lengthBytes = getLengthBytes(length);
            if (lengthBytes == 0) {
                bArr[i] = (byte) (length | segType.flags | 16);
                i++;
            } else {
                bArr[i] = (byte) (segType.flags | ((lengthBytes - 1) << 2));
                i = addIntBytes(bArr, i + 1, length, lengthBytes);
            }
        }
        return segType.hasChar() ? addChar(bArr, i, charSequence.charAt(seg.getTextStart())) : segType.hasChars() ? addChars(bArr, i, charSequence, seg.getTextStart(), seg.getTextEnd()) : segType.hasByte() ? addCharAscii(bArr, i, charSequence.charAt(seg.getTextStart())) : segType.hasBytes() ? addCharsAscii(bArr, i, charSequence, seg.getTextStart(), seg.getTextEnd()) : i;
    }

    public static char getChar(byte[] bArr, int i) {
        int i2 = i + 1;
        return (char) ((bArr[i2] & 255) | ((char) ((bArr[i] & 255) << 8)));
    }

    public static char getCharAscii(byte[] bArr, int i) {
        return (char) (bArr[i] & 255);
    }

    public static int getInt(byte[] bArr, int i, int i2) {
        int i4 = 0;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 != 3) {
                    if (i2 != 4) {
                        return 0;
                    }
                    i4 = (bArr[i] & 255) << 24;
                    i++;
                }
                i4 |= (bArr[i] & 255) << 16;
                i++;
            }
            i4 |= (bArr[i] & 255) << 8;
            i++;
        }
        return (bArr[i] & 255) | i4;
    }

    public static int getIntBytes(int i) {
        if (i < 256) {
            return 1;
        }
        if (i < 65536) {
            return 2;
        }
        return i < 16777216 ? 3 : 4;
    }

    public static int getLengthBytes(int i) {
        if (i < 16) {
            return 0;
        }
        if (i < 256) {
            return 1;
        }
        if (i < 65536) {
            return 2;
        }
        return i < 16777216 ? 3 : 4;
    }

    public static int getOffsetBytes(int i) {
        if (i < 16) {
            return 0;
        }
        if (i < 256) {
            return 1;
        }
        if (i < 65536) {
            return 2;
        }
        return i < 16777216 ? 3 : 4;
    }

    public static int getSegByteLength(@NotNull SegType segType, int i, int i2) {
        int intBytes;
        int lengthBytes;
        if (segType.hasBoth()) {
            intBytes = getIntBytes(i2) + getIntBytes(i) + 1;
        } else {
            if (segType.hasOffset()) {
                lengthBytes = getOffsetBytes(i);
            } else if (segType.hasLength()) {
                lengthBytes = getLengthBytes(i2);
            } else {
                intBytes = 1;
            }
            intBytes = lengthBytes + 1;
        }
        return segType.hasChar() ? intBytes + 2 : segType.hasChars() ? (i2 * 2) + intBytes : segType.hasByte() ? intBytes + 1 : segType.hasBytes() ? intBytes + i2 : intBytes;
    }

    public static SegType getSegType(@NotNull Seg seg, @NotNull CharSequence charSequence) {
        if (seg.isBase()) {
            return seg.isAnchor() ? SegType.ANCHOR : SegType.BASE;
        }
        if (!seg.isText()) {
            throw new IllegalStateException("Unknown seg type " + seg);
        }
        boolean zIsFirst256Start = seg.isFirst256Start();
        boolean zIsRepeatedTextEnd = seg.isRepeatedTextEnd();
        if (!zIsFirst256Start) {
            return zIsRepeatedTextEnd ? SegType.REPEATED_TEXT : SegType.TEXT;
        }
        if (!zIsRepeatedTextEnd) {
            return SegType.TEXT_ASCII;
        }
        char cCharAt = charSequence.charAt(seg.getTextStart());
        return cCharAt == ' ' ? SegType.REPEATED_SPACE : cCharAt == '\n' ? SegType.REPEATED_EOL : SegType.REPEATED_ASCII;
    }

    public static Segment getSegment(byte[] bArr, int i, int i2, int i4, @NotNull BasedSequence basedSequence) {
        int i5 = bArr[i] & CtapException.ERR_EXTENSION_FIRST;
        if (i5 == 0 || i5 == 32) {
            return new Base(i2, bArr, i, i4, basedSequence);
        }
        if (i5 == 64 || i5 == 96 || i5 == 128 || i5 == 160 || i5 == 192 || i5 == 224) {
            return new Text(i2, bArr, i, i4);
        }
        throw new IllegalStateException(AbstractC0000a.m11h(i5, "Invalid text type "));
    }

    public abstract char charAt(int i);

    public final int getByteLength() {
        return getSegByteLength(getType(), getStartOffset(), length());
    }

    public final int getByteOffset() {
        return this.byteOffset;
    }

    public byte[] getBytes() {
        return this.bytes;
    }

    public abstract CharSequence getCharSequence();

    public final int getEndIndex() {
        return length() + this.startIndex;
    }

    public abstract int getEndOffset();

    public int getPos() {
        return this.pos;
    }

    public final int getStartIndex() {
        return this.startIndex;
    }

    public abstract int getStartOffset();

    public final SegType getType() {
        return SegType.fromTypeMask(this.bytes[this.byteOffset]);
    }

    public boolean hasAll(int i, int i2) {
        return (i & i2) == i2;
    }

    public abstract boolean isAnchor();

    public abstract boolean isBase();

    public abstract boolean isFirst256Start();

    public abstract boolean isRepeatedTextEnd();

    public abstract boolean isText();

    public abstract int length();

    public boolean notInSegment(int i) {
        int i2 = this.startIndex;
        return i < i2 || i >= length() + i2;
    }

    public boolean offsetNotInSegment(int i) {
        return i < getStartOffset() || i >= getEndOffset();
    }

    public String toString() {
        if (isBase()) {
            return isAnchor() ? AbstractC0541b.m767i(getStartOffset(), "[", ")") : AbstractC0622a.m1164j(getStartOffset(), getEndOffset(), "[", SQLKeyword.COMMA, ")");
        }
        CharSequence charSequence = getCharSequence();
        if (!isRepeatedTextEnd() || length() <= 1) {
            int length = charSequence.length();
            String string = length <= 20 ? charSequence.toString() : AbstractC0541b.m757C(charSequence.subSequence(0, 10).toString(), "…", charSequence.subSequence(length - 10, length).toString());
            return isFirst256Start() ? AbstractC0541b.m773o("a:'", Utils.escapeJavaString(string), "'") : AbstractC0541b.m773o("'", Utils.escapeJavaString(string), "'");
        }
        if (isFirst256Start()) {
            return AbstractC11014a.m12321f("a:", length(), "x'", Utils.escapeJavaString(charSequence.subSequence(0, 1)), "'");
        }
        return length() + "x'" + Utils.escapeJavaString(charSequence.subSequence(0, 1)) + "'";
    }

    public static int getSegByteLength(@NotNull Seg seg, @NotNull CharSequence charSequence) {
        return getSegByteLength(getSegType(seg, charSequence), seg.getSegStart(), seg.length());
    }
}
