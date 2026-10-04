package com.vladsch.flexmark.parser.internal;

import com.vladsch.flexmark.util.sequence.BasedSequence;
import com.vladsch.flexmark.util.sequence.Escaping;
import java.util.BitSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LinkDestinationParser {
    public final BitSet EXCLUDED_0_TO_SPACE_CHARS;
    public final BitSet JEKYLL_EXCLUDED_CHARS;
    public final BitSet PAREN_ESCAPABLE_CHARS;
    public final BitSet PAREN_EXCLUDED_CHARS;
    public final BitSet PAREN_QUOTE_CHARS;
    public final boolean allowMatchedParentheses;
    public final boolean intellijDummyIdentifier;
    public final boolean parseJekyllMacrosInUrls;
    public final boolean spaceInUrls;

    public LinkDestinationParser(boolean z, boolean z2, boolean z3, boolean z4) {
        this.allowMatchedParentheses = z || z3;
        this.spaceInUrls = z2;
        this.parseJekyllMacrosInUrls = z3;
        this.intellijDummyIdentifier = z4;
        BitSet charSet = getCharSet((char) 0, ' ');
        this.EXCLUDED_0_TO_SPACE_CHARS = charSet;
        if (z4) {
            charSet.clear(31);
        }
        BitSet charSet2 = getCharSet("{}\\");
        this.JEKYLL_EXCLUDED_CHARS = charSet2;
        charSet2.or(charSet);
        charSet2.clear(32);
        charSet2.clear(9);
        BitSet charSet3 = getCharSet("()\\");
        this.PAREN_EXCLUDED_CHARS = charSet3;
        charSet3.or(charSet);
        this.PAREN_ESCAPABLE_CHARS = getCharSet(Escaping.ESCAPABLE_CHARS);
        this.PAREN_QUOTE_CHARS = getCharSet("\"'");
    }

    public static BitSet getCharSet(CharSequence charSequence) {
        BitSet bitSet = new BitSet(charSequence.length());
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            bitSet.set(charSequence.charAt(i));
        }
        return bitSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
    
        if (r16.JEKYLL_EXCLUDED_CHARS.get(r11) != false) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0043, code lost:
    
        r10 = r10 + r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x006d, code lost:
    
        if (r16.JEKYLL_EXCLUDED_CHARS.get(r11) != false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0044 A[PHI: r10
      0x0044: PHI (r10v7 int) = (r10v1 int), (r10v1 int), (r10v1 int), (r10v8 int) binds: [B:43:0x0070, B:45:0x0073, B:35:0x005e, B:22:0x0043] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BasedSequence parseLinkDestination(BasedSequence basedSequence, int i) {
        int length = basedSequence.length();
        byte b = this.parseJekyllMacrosInUrls ? (byte) 0 : (byte) -1;
        int i2 = i;
        int i4 = i2;
        byte b5 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i2 < length) {
            char cCharAt = basedSequence.charAt(i2);
            i2++;
            if (b >= 0) {
                if (b != 0) {
                    if (b != 1) {
                        if (b != 2) {
                            if (b != 3) {
                                throw new IllegalStateException("Illegal Jekyll Macro Parsing State");
                            }
                            if (b5 == 1) {
                                b = 2;
                            } else if (cCharAt == '}') {
                                i4 = i2;
                                b = 0;
                                b5 = 0;
                            }
                        } else if (b5 != 1) {
                            if (cCharAt == '}') {
                                b = 3;
                            } else if (cCharAt == '(') {
                                i5++;
                            } else if (cCharAt == ')') {
                                if (i5 > 0) {
                                    if (b5 != -1) {
                                        i4 = i2;
                                    }
                                    i5--;
                                } else {
                                    b = 0;
                                }
                            }
                        }
                    } else if (b5 != 1 && cCharAt == '{') {
                        b = 2;
                        i5 = 0;
                    }
                } else if (b5 != 1 && cCharAt == '{' && basedSequence.safeCharAt(i2) == '{') {
                    b = 1;
                }
            }
            if (b5 >= 0) {
                if (b5 == 0) {
                    if (cCharAt == '\\') {
                        b5 = this.PAREN_ESCAPABLE_CHARS.get(basedSequence.safeCharAt(i2)) ? (byte) 1 : b5;
                    } else if (cCharAt == '(') {
                        if (b != 2) {
                            if (this.allowMatchedParentheses || i6 == 0) {
                                i6++;
                            } else {
                                i4 = i;
                                b5 = -1;
                            }
                        }
                    } else if (cCharAt != ')') {
                        if (cCharAt == ' ') {
                            if (!this.spaceInUrls || this.PAREN_QUOTE_CHARS.get(basedSequence.safeCharAt(i2))) {
                            }
                        } else if (!this.PAREN_EXCLUDED_CHARS.get(cCharAt)) {
                        }
                        b5 = -1;
                    } else if (b != 2) {
                        if (i6 > 0) {
                            i6--;
                        } else {
                            boolean z = this.allowMatchedParentheses;
                            b5 = -1;
                        }
                    }
                    i4 = i2;
                } else {
                    if (b5 != 1) {
                        throw new IllegalStateException("Illegal Jekyll Macro Parsing State");
                    }
                    i4 = i2;
                    b5 = 0;
                }
            }
            if (b <= 0 && b5 == -1) {
                break;
            }
        }
        return basedSequence.subSequence(i, i4);
    }

    public static BitSet getCharSet(char c, char c2) {
        BitSet bitSet = new BitSet();
        for (int i = c; i <= c2; i++) {
            bitSet.set(i);
        }
        return bitSet;
    }
}
