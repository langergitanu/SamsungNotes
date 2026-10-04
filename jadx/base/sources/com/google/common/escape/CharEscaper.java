package com.google.common.escape;

import androidx.compose.runtime.AbstractC1974b;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public abstract class CharEscaper extends Escaper {
    private static final int DEST_PAD_MULTIPLIER = 2;

    private static char[] growBuffer(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        char[] cArr2 = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, cArr2, 0, i);
        }
        return cArr2;
    }

    @Override // com.google.common.escape.Escaper
    public String escape(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (escape(str.charAt(i)) != null) {
                return escapeSlow(str, i);
            }
        }
        return str;
    }

    @CheckForNull
    public abstract char[] escape(char c);

    public final String escapeSlow(String str, int i) {
        int length = str.length();
        char[] cArrCharBufferFromThreadLocal = Platform.charBufferFromThreadLocal();
        int length2 = cArrCharBufferFromThreadLocal.length;
        int i2 = 0;
        int i4 = 0;
        while (i < length) {
            char[] cArrEscape = escape(str.charAt(i));
            if (cArrEscape != null) {
                int length3 = cArrEscape.length;
                int i5 = i - i2;
                int i6 = i4 + i5;
                int i7 = i6 + length3;
                if (length2 < i7) {
                    length2 = AbstractC1974b.m1304A(length, i, 2, i7);
                    cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, i4, length2);
                }
                if (i5 > 0) {
                    str.getChars(i2, i, cArrCharBufferFromThreadLocal, i4);
                    i4 = i6;
                }
                if (length3 > 0) {
                    System.arraycopy(cArrEscape, 0, cArrCharBufferFromThreadLocal, i4, length3);
                    i4 += length3;
                }
                i2 = i + 1;
            }
            i++;
        }
        int i8 = length - i2;
        if (i8 > 0) {
            int i9 = i8 + i4;
            if (length2 < i9) {
                cArrCharBufferFromThreadLocal = growBuffer(cArrCharBufferFromThreadLocal, i4, i9);
            }
            str.getChars(i2, length, cArrCharBufferFromThreadLocal, i4);
            i4 = i9;
        }
        return new String(cArrCharBufferFromThreadLocal, 0, i4);
    }
}
