package org.apache.xmlbeans.impl.regex;

import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.io.PrintStream;
import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
final class RangeToken extends Token implements Serializable {
    private static final int MAPSIZE = 256;
    boolean compacted;
    RangeToken icaseCache;
    int[] map;
    int nonMapIndex;
    int[] ranges;
    boolean sorted;

    public RangeToken(int i) {
        super(i);
        this.icaseCache = null;
        this.map = null;
        setSorted(false);
    }

    public static Token complementRanges(Token token) {
        int i = token.type;
        if (i != 4 && i != 5) {
            StringBuffer stringBuffer = new StringBuffer("Token#complementRanges(): must be RANGE: ");
            stringBuffer.append(token.type);
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        RangeToken rangeToken = (RangeToken) token;
        rangeToken.sortRanges();
        rangeToken.compactRanges();
        int[] iArr = rangeToken.ranges;
        int length = iArr.length;
        int i2 = length + 2;
        int i4 = 0;
        if (iArr[0] != 0) {
            length = i2;
        }
        int i5 = iArr[iArr.length - 1];
        if (i5 == 1114111) {
            length -= 2;
        }
        RangeToken rangeTokenCreateRange = Token.createRange();
        int[] iArr2 = new int[length];
        rangeTokenCreateRange.ranges = iArr2;
        int[] iArr3 = rangeToken.ranges;
        if (iArr3[0] > 0) {
            iArr2[0] = 0;
            iArr2[1] = iArr3[0] - 1;
            i4 = 2;
        }
        int i6 = 1;
        while (true) {
            int[] iArr4 = rangeToken.ranges;
            if (i6 >= iArr4.length - 2) {
                break;
            }
            int[] iArr5 = rangeTokenCreateRange.ranges;
            int i7 = i4 + 1;
            iArr5[i4] = iArr4[i6] + 1;
            i4 += 2;
            iArr5[i7] = iArr4[i6 + 1] - 1;
            i6 += 2;
        }
        if (i5 != 1114111) {
            int[] iArr6 = rangeTokenCreateRange.ranges;
            iArr6[i4] = i5 + 1;
            iArr6[i4 + 1] = 1114111;
        }
        rangeTokenCreateRange.setCompacted();
        return rangeTokenCreateRange;
    }

    private void createMap() {
        int[] iArr = new int[8];
        int length = this.ranges.length;
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            iArr[i2] = 0;
        }
        while (true) {
            int[] iArr2 = this.ranges;
            if (i >= iArr2.length) {
                break;
            }
            int i4 = iArr2[i];
            int i5 = iArr2[i + 1];
            if (i4 >= 256) {
                break;
            }
            while (i4 <= i5 && i4 < 256) {
                int i6 = i4 / 32;
                iArr[i6] = iArr[i6] | (1 << (i4 & 31));
                i4++;
            }
            if (i5 >= 256) {
                break;
            } else {
                i += 2;
            }
        }
        length = i;
        this.nonMapIndex = length;
        this.map = iArr;
    }

    private static String escapeCharInCharClass(int i) {
        if (i == 9) {
            return "\\t";
        }
        if (i == 10) {
            return "\\n";
        }
        if (i == 12) {
            return "\\f";
        }
        if (i == 13) {
            return "\\r";
        }
        if (i == 27) {
            return "\\e";
        }
        if (i != 44 && i != 45) {
            switch (i) {
                case 91:
                case 92:
                case 93:
                case 94:
                    break;
                default:
                    if (i < 32) {
                        StringBuffer stringBuffer = new StringBuffer("0");
                        stringBuffer.append(Integer.toHexString(i));
                        String string = stringBuffer.toString();
                        StringBuffer stringBuffer2 = new StringBuffer("\\x");
                        stringBuffer2.append(string.substring(string.length() - 2, string.length()));
                        return stringBuffer2.toString();
                    }
                    if (i < 65536) {
                        StringBuffer stringBuffer3 = new StringBuffer("");
                        stringBuffer3.append((char) i);
                        return stringBuffer3.toString();
                    }
                    StringBuffer stringBuffer4 = new StringBuffer("0");
                    stringBuffer4.append(Integer.toHexString(i));
                    String string2 = stringBuffer4.toString();
                    StringBuffer stringBuffer5 = new StringBuffer("\\v");
                    stringBuffer5.append(string2.substring(string2.length() - 6, string2.length()));
                    return stringBuffer5.toString();
            }
        }
        StringBuffer stringBuffer6 = new StringBuffer("\\");
        stringBuffer6.append((char) i);
        return stringBuffer6.toString();
    }

    private final boolean isCompacted() {
        return this.compacted;
    }

    private final boolean isSorted() {
        return this.sorted;
    }

    private final void setCompacted() {
        this.compacted = true;
    }

    private final void setSorted(boolean z) {
        this.sorted = z;
        if (z) {
            return;
        }
        this.compacted = false;
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void addRange(int i, int i2) {
        this.icaseCache = null;
        if (i > i2) {
            i2 = i;
            i = i2;
        }
        int[] iArr = this.ranges;
        if (iArr == null) {
            this.ranges = new int[]{i, i2};
            setSorted(true);
            return;
        }
        int length = iArr.length;
        int i4 = length - 1;
        if (iArr[i4] + 1 == i) {
            iArr[i4] = i2;
            return;
        }
        int[] iArr2 = new int[length + 2];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this.ranges = iArr2;
        if (iArr2[i4] >= i) {
            setSorted(false);
        }
        int[] iArr3 = this.ranges;
        iArr3[length] = i;
        iArr3[length + 1] = i2;
        if (this.sorted) {
            return;
        }
        sortRanges();
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void compactRanges() {
        int i;
        int i2;
        int[] iArr = this.ranges;
        if (iArr == null || iArr.length <= 2 || isCompacted()) {
            return;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int[] iArr2 = this.ranges;
            if (i4 >= iArr2.length) {
                if (i5 != iArr2.length) {
                    int[] iArr3 = new int[i5];
                    System.arraycopy(iArr2, 0, iArr3, 0, i5);
                    this.ranges = iArr3;
                }
                setCompacted();
                return;
            }
            if (i5 != i4) {
                int i6 = i4 + 1;
                iArr2[i5] = iArr2[i4];
                i4 += 2;
                iArr2[i5 + 1] = iArr2[i6];
            } else {
                i4 += 2;
            }
            int i7 = i5 + 1;
            int i8 = iArr2[i7];
            while (true) {
                int[] iArr4 = this.ranges;
                if (i4 >= iArr4.length || (i = i8 + 1) < (i2 = iArr4[i4])) {
                    break;
                }
                if (i == i2) {
                    i8 = iArr4[i4 + 1];
                    iArr4[i7] = i8;
                } else {
                    int i9 = i4 + 1;
                    int i10 = iArr4[i9];
                    if (i8 < i10) {
                        if (i8 >= i10) {
                            StringBuffer stringBuffer = new StringBuffer("Token#compactRanges(): Internel Error: [");
                            stringBuffer.append(this.ranges[i5]);
                            stringBuffer.append(",");
                            stringBuffer.append(this.ranges[i7]);
                            stringBuffer.append("] [");
                            stringBuffer.append(this.ranges[i4]);
                            stringBuffer.append(",");
                            stringBuffer.append(this.ranges[i9]);
                            stringBuffer.append("]");
                            throw new RuntimeException(stringBuffer.toString());
                        }
                        iArr4[i7] = i10;
                        i4 += 2;
                        i8 = i10;
                    }
                }
                i4 += 2;
            }
            i5 += 2;
        }
    }

    public void dumpRanges() {
        System.err.print("RANGE: ");
        if (this.ranges == null) {
            System.err.println(" NULL");
        }
        for (int i = 0; i < this.ranges.length; i += 2) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer("[");
            stringBuffer.append(this.ranges[i]);
            stringBuffer.append(",");
            stringBuffer.append(this.ranges[i + 1]);
            stringBuffer.append("] ");
            printStream.print(stringBuffer.toString());
        }
        System.err.println("");
    }

    public synchronized RangeToken getCaseInsensitiveToken() {
        try {
            RangeToken rangeToken = this.icaseCache;
            if (rangeToken != null) {
                return rangeToken;
            }
            RangeToken rangeTokenCreateRange = this.type == 4 ? Token.createRange() : Token.createNRange();
            int i = 0;
            int i2 = 0;
            while (true) {
                int[] iArr = this.ranges;
                if (i2 >= iArr.length) {
                    break;
                }
                for (int i4 = iArr[i2]; i4 <= this.ranges[i2 + 1]; i4++) {
                    if (i4 > 65535) {
                        rangeTokenCreateRange.addRange(i4, i4);
                    } else {
                        char upperCase = Character.toUpperCase((char) i4);
                        rangeTokenCreateRange.addRange(upperCase, upperCase);
                    }
                }
                i2 += 2;
            }
            RangeToken rangeTokenCreateRange2 = this.type == 4 ? Token.createRange() : Token.createNRange();
            while (true) {
                int[] iArr2 = rangeTokenCreateRange.ranges;
                if (i >= iArr2.length) {
                    rangeTokenCreateRange2.mergeRanges(rangeTokenCreateRange);
                    rangeTokenCreateRange2.mergeRanges(this);
                    rangeTokenCreateRange2.compactRanges();
                    this.icaseCache = rangeTokenCreateRange2;
                    return rangeTokenCreateRange2;
                }
                for (int i5 = iArr2[i]; i5 <= rangeTokenCreateRange.ranges[i + 1]; i5++) {
                    if (i5 > 65535) {
                        rangeTokenCreateRange2.addRange(i5, i5);
                    } else {
                        char upperCase2 = Character.toUpperCase((char) i5);
                        rangeTokenCreateRange2.addRange(upperCase2, upperCase2);
                    }
                }
                i += 2;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x00bd, code lost:
    
        r13 = r12.ranges;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00c0, code lost:
    
        if (r2 >= r13.length) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00c2, code lost:
    
        r3 = r4 + 1;
        r5 = r2 + 1;
        r0[r4] = r13[r2];
        r4 = r4 + 2;
        r2 = r2 + 2;
        r0[r3] = r13[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00d3, code lost:
    
        r13 = new int[r4];
        r12.ranges = r13;
        java.lang.System.arraycopy(r0, 0, r13, 0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00da, code lost:
    
        return;
     */
    @Override // org.apache.xmlbeans.impl.regex.Token
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void intersectRanges(Token token) {
        RangeToken rangeToken = (RangeToken) token;
        if (rangeToken.ranges != null && this.ranges != null) {
            this.icaseCache = null;
            sortRanges();
            compactRanges();
            rangeToken.sortRanges();
            rangeToken.compactRanges();
            int[] iArr = new int[this.ranges.length + rangeToken.ranges.length];
            int i = 0;
            int i2 = 0;
            int i4 = 0;
            while (true) {
                int[] iArr2 = this.ranges;
                if (i >= iArr2.length) {
                    break;
                }
                int[] iArr3 = rangeToken.ranges;
                if (i2 >= iArr3.length) {
                    break;
                }
                int i5 = iArr2[i];
                int i6 = i + 1;
                int i7 = iArr2[i6];
                int i8 = iArr3[i2];
                int i9 = i2 + 1;
                int i10 = iArr3[i9];
                if (i7 >= i8) {
                    if (i7 < i8 || i5 > i10) {
                        if (i10 >= i5) {
                            StringBuffer stringBuffer = new StringBuffer("Token#intersectRanges(): Internal Error: [");
                            stringBuffer.append(this.ranges[i]);
                            stringBuffer.append(",");
                            stringBuffer.append(this.ranges[i6]);
                            stringBuffer.append("] & [");
                            stringBuffer.append(rangeToken.ranges[i2]);
                            stringBuffer.append(",");
                            stringBuffer.append(rangeToken.ranges[i9]);
                            stringBuffer.append("]");
                            throw new RuntimeException(stringBuffer.toString());
                        }
                        i2 += 2;
                    } else if (i7 <= i10) {
                        int i11 = i4 + 1;
                        iArr[i4] = i5;
                        i4 += 2;
                        iArr[i11] = i7;
                    } else if (i8 <= i5) {
                        int i12 = i4 + 1;
                        iArr[i4] = i5;
                        i4 += 2;
                        iArr[i12] = i10;
                        iArr2[i] = i10 + 1;
                        i2 += 2;
                    } else if (i7 <= i10) {
                        int i13 = i4 + 1;
                        iArr[i4] = i8;
                        i4 += 2;
                        iArr[i13] = i7;
                    } else {
                        int i14 = i4 + 1;
                        iArr[i4] = i8;
                        i4 += 2;
                        iArr[i14] = i10;
                        iArr2[i] = i10 + 1;
                    }
                }
                i += 2;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public boolean match(int i) {
        if (this.map == null) {
            createMap();
        }
        if (this.type == 4) {
            if (i < 256) {
                return ((1 << (i & 31)) & this.map[i / 32]) != 0;
            }
            int i2 = this.nonMapIndex;
            while (true) {
                int[] iArr = this.ranges;
                if (i2 >= iArr.length) {
                    return false;
                }
                if (iArr[i2] <= i && i <= iArr[i2 + 1]) {
                    return true;
                }
                i2 += 2;
            }
        } else {
            if (i < 256) {
                return ((1 << (i & 31)) & this.map[i / 32]) == 0;
            }
            int i4 = this.nonMapIndex;
            while (true) {
                int[] iArr2 = this.ranges;
                if (i4 >= iArr2.length) {
                    return true;
                }
                if (iArr2[i4] <= i && i <= iArr2[i4 + 1]) {
                    return false;
                }
                i4 += 2;
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void mergeRanges(Token token) {
        RangeToken rangeToken = (RangeToken) token;
        sortRanges();
        rangeToken.sortRanges();
        if (rangeToken.ranges == null) {
            return;
        }
        this.icaseCache = null;
        setSorted(true);
        int[] iArr = this.ranges;
        int i = 0;
        if (iArr == null) {
            int[] iArr2 = new int[rangeToken.ranges.length];
            this.ranges = iArr2;
            int[] iArr3 = rangeToken.ranges;
            System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
            return;
        }
        int[] iArr4 = new int[iArr.length + rangeToken.ranges.length];
        int i2 = 0;
        int i4 = 0;
        while (true) {
            int[] iArr5 = this.ranges;
            if (i >= iArr5.length && i2 >= rangeToken.ranges.length) {
                this.ranges = iArr4;
                return;
            }
            if (i >= iArr5.length) {
                int i5 = i4 + 1;
                int[] iArr6 = rangeToken.ranges;
                int i6 = i2 + 1;
                iArr4[i4] = iArr6[i2];
                i4 += 2;
                i2 += 2;
                iArr4[i5] = iArr6[i6];
            } else {
                int[] iArr7 = rangeToken.ranges;
                if (i2 >= iArr7.length) {
                    int i7 = i4 + 1;
                    int i8 = i + 1;
                    iArr4[i4] = iArr5[i];
                    i4 += 2;
                    i += 2;
                    iArr4[i7] = iArr5[i8];
                } else {
                    int i9 = iArr7[i2];
                    int i10 = iArr5[i];
                    if (i9 < i10 || (i9 == i10 && iArr7[i2 + 1] < iArr5[i + 1])) {
                        int i11 = i4 + 1;
                        int i12 = i2 + 1;
                        iArr4[i4] = i9;
                        i4 += 2;
                        i2 += 2;
                        iArr4[i11] = iArr7[i12];
                    } else {
                        int i13 = i4 + 1;
                        int i14 = i + 1;
                        iArr4[i4] = i10;
                        i4 += 2;
                        i += 2;
                        iArr4[i13] = iArr5[i14];
                    }
                }
            }
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public void sortRanges() {
        int[] iArr;
        if (isSorted() || (iArr = this.ranges) == null) {
            return;
        }
        for (int length = iArr.length - 4; length >= 0; length -= 2) {
            int i = 0;
            while (i <= length) {
                int[] iArr2 = this.ranges;
                int i2 = iArr2[i];
                int i4 = i + 2;
                int i5 = iArr2[i4];
                if (i2 > i5 || (i2 == i5 && iArr2[i + 1] > iArr2[i + 3])) {
                    iArr2[i4] = i2;
                    iArr2[i] = i5;
                    int i6 = i + 3;
                    int i7 = iArr2[i6];
                    int i8 = i + 1;
                    iArr2[i6] = iArr2[i8];
                    iArr2[i8] = i7;
                }
                i = i4;
            }
        }
        setSorted(true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00c8, code lost:
    
        r13 = r12.ranges;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cb, code lost:
    
        if (r2 >= r13.length) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00cd, code lost:
    
        r3 = r4 + 1;
        r5 = r2 + 1;
        r0[r4] = r13[r2];
        r4 = r4 + 2;
        r2 = r2 + 2;
        r0[r3] = r13[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00de, code lost:
    
        r13 = new int[r4];
        r12.ranges = r13;
        java.lang.System.arraycopy(r0, 0, r13, 0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e5, code lost:
    
        return;
     */
    @Override // org.apache.xmlbeans.impl.regex.Token
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void subtractRanges(Token token) {
        if (token.type != 5) {
            RangeToken rangeToken = (RangeToken) token;
            if (rangeToken.ranges != null && this.ranges != null) {
                this.icaseCache = null;
                sortRanges();
                compactRanges();
                rangeToken.sortRanges();
                rangeToken.compactRanges();
                int[] iArr = new int[this.ranges.length + rangeToken.ranges.length];
                int i = 0;
                int i2 = 0;
                int i4 = 0;
                while (true) {
                    int[] iArr2 = this.ranges;
                    if (i >= iArr2.length) {
                        break;
                    }
                    int[] iArr3 = rangeToken.ranges;
                    if (i2 >= iArr3.length) {
                        break;
                    }
                    int i5 = iArr2[i];
                    int i6 = i + 1;
                    int i7 = iArr2[i6];
                    int i8 = iArr3[i2];
                    int i9 = i2 + 1;
                    int i10 = iArr3[i9];
                    if (i7 < i8) {
                        int i11 = i4 + 1;
                        iArr[i4] = i5;
                        i4 += 2;
                        i += 2;
                        iArr[i11] = iArr2[i6];
                    } else if (i7 < i8 || i5 > i10) {
                        if (i10 >= i5) {
                            StringBuffer stringBuffer = new StringBuffer("Token#subtractRanges(): Internal Error: [");
                            stringBuffer.append(this.ranges[i]);
                            stringBuffer.append(",");
                            stringBuffer.append(this.ranges[i6]);
                            stringBuffer.append("] - [");
                            stringBuffer.append(rangeToken.ranges[i2]);
                            stringBuffer.append(",");
                            stringBuffer.append(rangeToken.ranges[i9]);
                            stringBuffer.append("]");
                            throw new RuntimeException(stringBuffer.toString());
                        }
                        i2 += 2;
                    } else {
                        if (i8 > i5 || i7 > i10) {
                            if (i8 <= i5) {
                                iArr2[i] = i10 + 1;
                            } else if (i7 <= i10) {
                                int i12 = i4 + 1;
                                iArr[i4] = i5;
                                i4 += 2;
                                iArr[i12] = i8 - 1;
                            } else {
                                int i13 = i4 + 1;
                                iArr[i4] = i5;
                                i4 += 2;
                                iArr[i13] = i8 - 1;
                                iArr2[i] = i10 + 1;
                            }
                            i2 += 2;
                        }
                        i += 2;
                    }
                }
            }
        } else {
            intersectRanges(token);
        }
    }

    @Override // org.apache.xmlbeans.impl.regex.Token
    public String toString(int i) {
        int i2 = 0;
        if (this.type != 4) {
            if (this == Token.token_not_0to9) {
                return "\\D";
            }
            if (this == Token.token_not_wordchars) {
                return "\\W";
            }
            if (this == Token.token_not_spaces) {
                return "\\S";
            }
            StringBuffer stringBuffer = new StringBuffer("[^");
            while (i2 < this.ranges.length) {
                if ((i & 1024) != 0 && i2 > 0) {
                    stringBuffer.append(",");
                }
                int[] iArr = this.ranges;
                int i4 = iArr[i2];
                int i5 = i2 + 1;
                if (i4 == iArr[i5]) {
                    stringBuffer.append(escapeCharInCharClass(i4));
                } else {
                    stringBuffer.append(escapeCharInCharClass(i4));
                    stringBuffer.append('-');
                    stringBuffer.append(escapeCharInCharClass(this.ranges[i5]));
                }
                i2 += 2;
            }
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
        if (this == Token.token_dot) {
            return Extension.DOT;
        }
        if (this == Token.token_0to9) {
            return "\\d";
        }
        if (this == Token.token_wordchars) {
            return "\\w";
        }
        if (this == Token.token_spaces) {
            return "\\s";
        }
        StringBuffer stringBuffer2 = new StringBuffer("[");
        while (i2 < this.ranges.length) {
            if ((i & 1024) != 0 && i2 > 0) {
                stringBuffer2.append(",");
            }
            int[] iArr2 = this.ranges;
            int i6 = iArr2[i2];
            int i7 = i2 + 1;
            if (i6 == iArr2[i7]) {
                stringBuffer2.append(escapeCharInCharClass(i6));
            } else {
                stringBuffer2.append(escapeCharInCharClass(i6));
                stringBuffer2.append('-');
                stringBuffer2.append(escapeCharInCharClass(this.ranges[i7]));
            }
            i2 += 2;
        }
        stringBuffer2.append("]");
        return stringBuffer2.toString();
    }
}
