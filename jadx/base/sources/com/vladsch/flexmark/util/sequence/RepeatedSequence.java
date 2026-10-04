package com.vladsch.flexmark.util.sequence;

import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class RepeatedSequence implements CharSequence {
    public static RepeatedSequence NULL = new RepeatedSequence(BasedSequence.NULL, 0, 0);
    private final CharSequence chars;
    private final int endIndex;
    private int hashCode;
    private final int startIndex;

    private RepeatedSequence(CharSequence charSequence, int i, int i2) {
        this.chars = charSequence;
        this.startIndex = i;
        this.endIndex = i2;
    }

    @Deprecated
    @NotNull
    /* JADX INFO: renamed from: of */
    public static CharSequence m13452of(char c, int i) {
        return repeatOf(c, i);
    }

    @NotNull
    public static CharSequence ofSpaces(int i) {
        return new RepeatedSequence(" ", 0, i);
    }

    @NotNull
    public static CharSequence repeatOf(char c, int i) {
        return new RepeatedSequence(String.valueOf(c), 0, i);
    }

    @Override // java.lang.CharSequence
    public char charAt(int i) {
        if (i >= 0) {
            int i2 = this.endIndex;
            int i4 = this.startIndex;
            if (i < i2 - i4) {
                CharSequence charSequence = this.chars;
                return charSequence.charAt((i4 + i) % charSequence.length());
            }
        }
        throw new IndexOutOfBoundsException();
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof CharSequence) && toString().equals(obj.toString());
        }
        return true;
    }

    public int hashCode() {
        int iCharAt = this.hashCode;
        if (iCharAt == 0 && length() > 0) {
            for (int i = 0; i < length(); i++) {
                iCharAt = (iCharAt * 31) + charAt(i);
            }
            this.hashCode = iCharAt;
        }
        return iCharAt;
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.endIndex - this.startIndex;
    }

    public RepeatedSequence repeat(int i) {
        int i2 = this.startIndex;
        int i4 = this.endIndex;
        int iM1304A = AbstractC1974b.m1304A(i4, i2, i, i2);
        return i2 >= i4 ? NULL : i4 == iM1304A ? this : new RepeatedSequence(this.chars, i2, iM1304A);
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        if (i >= 0 && i <= i2) {
            int i4 = this.endIndex;
            int i5 = this.startIndex;
            if (i2 <= i4 - i5) {
                return i == i2 ? NULL : (i == i5 && i2 == i4) ? this : new RepeatedSequence(this.chars, i + i5, i5 + i2);
            }
        }
        throw new IllegalArgumentException(AbstractC0622a.m1164j(this.startIndex, this.endIndex, "subSequence($startIndex, $endIndex) in RepeatedCharSequence('', ", SQLKeyword.COMMA, ")"));
    }

    @Override // java.lang.CharSequence
    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) this, 0, length());
        return sb.toString();
    }

    @Deprecated
    @NotNull
    /* JADX INFO: renamed from: of */
    public static CharSequence m13453of(@NotNull CharSequence charSequence, int i) {
        return repeatOf(charSequence, i);
    }

    @NotNull
    public static CharSequence repeatOf(@NotNull CharSequence charSequence, int i) {
        return new RepeatedSequence(charSequence, 0, charSequence.length() * i);
    }

    @Deprecated
    @NotNull
    /* JADX INFO: renamed from: of */
    public static CharSequence m13454of(@NotNull CharSequence charSequence, int i, int i2) {
        return repeatOf(charSequence, i, i2);
    }

    @NotNull
    public static CharSequence repeatOf(@NotNull CharSequence charSequence, int i, int i2) {
        return new RepeatedSequence(charSequence, i, i2);
    }
}
