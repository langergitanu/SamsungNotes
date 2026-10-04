package io.netty.util.internal;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.util.Arrays;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final class AppendableCharSequence implements CharSequence, Appendable {
    private char[] chars;
    private int pos;

    public AppendableCharSequence(int i) {
        this.chars = new char[ObjectUtil.checkPositive(i, "length")];
    }

    private static char[] expand(char[] cArr, int i, int i2) {
        int length = cArr.length;
        do {
            length <<= 1;
            if (length < 0) {
                throw new IllegalStateException();
            }
        } while (i > length);
        char[] cArr2 = new char[length];
        System.arraycopy(cArr, 0, cArr2, 0, i2);
        return cArr2;
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i <= this.pos) {
            return this.chars[i];
        }
        throw new IndexOutOfBoundsException();
    }

    public char charAtUnsafe(int i) {
        return this.chars[i];
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.pos;
    }

    public void reset() {
        this.pos = 0;
    }

    public void setLength(int i) {
        if (i < 0 || i > this.pos) {
            throw new IllegalArgumentException(AbstractC0000a.m13j(AbstractC0541b.m778t(i, "length: ", " (length: >= 0, <= "), this.pos, PropertyUtils.MAPPED_DELIM2));
        }
        this.pos = i;
    }

    public String subStringUnsafe(int i, int i2) {
        return new String(this.chars, i, i2 - i);
    }

    public String substring(int i, int i2) {
        int i4 = i2 - i;
        int i5 = this.pos;
        if (i > i5 || i4 > i5) {
            throw new IndexOutOfBoundsException(AbstractC2821a.m2223n(new StringBuilder("expected: start and length <= ("), ")", this.pos));
        }
        return new String(this.chars, i, i4);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return new String(this.chars, 0, this.pos);
    }

    @Override // java.lang.CharSequence
    public AppendableCharSequence subSequence(int i, int i2) {
        return i == i2 ? new AppendableCharSequence(Math.min(16, this.chars.length)) : new AppendableCharSequence(Arrays.copyOfRange(this.chars, i, i2));
    }

    private AppendableCharSequence(char[] cArr) {
        this.chars = ObjectUtil.checkNonEmpty(cArr, "chars");
        this.pos = cArr.length;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(char c) {
        int i = this.pos;
        char[] cArr = this.chars;
        if (i == cArr.length) {
            char[] cArr2 = new char[cArr.length << 1];
            this.chars = cArr2;
            System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        }
        char[] cArr3 = this.chars;
        int i2 = this.pos;
        this.pos = i2 + 1;
        cArr3[i2] = c;
        return this;
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence) {
        return append(charSequence, 0, charSequence.length());
    }

    @Override // java.lang.Appendable
    public AppendableCharSequence append(CharSequence charSequence, int i, int i2) {
        if (charSequence.length() >= i2) {
            int i4 = i2 - i;
            char[] cArr = this.chars;
            int length = cArr.length;
            int i5 = this.pos;
            if (i4 > length - i5) {
                this.chars = expand(cArr, i5 + i4, i5);
            }
            if (charSequence instanceof AppendableCharSequence) {
                System.arraycopy(((AppendableCharSequence) charSequence).chars, i, this.chars, this.pos, i4);
                this.pos += i4;
                return this;
            }
            while (i < i2) {
                char[] cArr2 = this.chars;
                int i6 = this.pos;
                this.pos = i6 + 1;
                cArr2[i6] = charSequence.charAt(i);
                i++;
            }
            return this;
        }
        StringBuilder sbM778t = AbstractC0541b.m778t(i2, "expected: csq.length() >= (", "),but actual is (");
        sbM778t.append(charSequence.length());
        sbM778t.append(")");
        throw new IndexOutOfBoundsException(sbM778t.toString());
    }
}
