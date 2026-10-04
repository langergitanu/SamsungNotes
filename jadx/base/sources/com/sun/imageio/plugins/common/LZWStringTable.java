package com.sun.imageio.plugins.common;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import java.io.PrintStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class LZWStringTable {
    private static final short HASHSIZE = 9973;
    private static final short HASHSTEP = 2039;
    private static final short HASH_FREE = -1;
    private static final int MAXBITS = 12;
    private static final int MAXSTR = 4096;
    private static final short NEXT_FIRST = -1;
    private static final int RES_CODES = 2;
    short numStrings;
    byte[] strChr = new byte[4096];
    short[] strNxt = new short[4096];
    int[] strLen = new int[4096];
    short[] strHsh = new short[9973];

    public static int hash(short s, byte b) {
        return ((s ^ ((short) (b << 8))) & 65535) % 9973;
    }

    public int addCharString(short s, byte b) {
        short[] sArr;
        if (this.numStrings >= 4096) {
            return 65535;
        }
        int iHash = hash(s, b);
        while (true) {
            sArr = this.strHsh;
            if (sArr[iHash] == -1) {
                break;
            }
            iHash = (iHash + 2039) % 9973;
        }
        short s2 = this.numStrings;
        sArr[iHash] = s2;
        this.strChr[s2] = b;
        if (s == -1) {
            this.strNxt[s2] = -1;
            this.strLen[s2] = 1;
        } else {
            this.strNxt[s2] = s;
            int[] iArr = this.strLen;
            iArr[s2] = iArr[s] + 1;
        }
        this.numStrings = (short) (s2 + 1);
        return s2;
    }

    public void clearTable(int i) {
        this.numStrings = (short) 0;
        for (int i2 = 0; i2 < 9973; i2++) {
            this.strHsh[i2] = -1;
        }
        int i4 = (1 << i) + 2;
        for (int i5 = 0; i5 < i4; i5++) {
            addCharString((short) -1, (byte) i5);
        }
    }

    public void dump(PrintStream printStream) {
        for (int i = SlidingPaneLayout.SESL_PENDING_COLLAPSED_LOCK; i < this.numStrings; i++) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, " strNxt[", "] = ");
            sbM778t.append((int) this.strNxt[i]);
            sbM778t.append(" strChr ");
            sbM778t.append(Integer.toHexString(this.strChr[i] & 255));
            sbM778t.append(" strLen ");
            sbM778t.append(Integer.toHexString(this.strLen[i]));
            printStream.println(sbM778t.toString());
        }
    }

    public int expandCode(byte[] bArr, int i, short s, int i2) {
        int i4;
        if (i == -2 && i2 == 1) {
            i2 = 0;
        }
        if (s == -1 || i2 == (i4 = this.strLen[s])) {
            return 0;
        }
        int i5 = i4 - i2;
        int length = bArr.length - i;
        if (length > i5) {
            length = i5;
        }
        int i6 = i5 - length;
        int i7 = i + length;
        while (i7 > i && s != -1) {
            i6--;
            if (i6 < 0) {
                i7--;
                bArr[i7] = this.strChr[s];
            }
            s = this.strNxt[s];
        }
        return i5 > length ? -length : length;
    }

    public short findCharString(short s, byte b) {
        if (s == -1) {
            return (short) (b & 255);
        }
        int iHash = hash(s, b);
        while (true) {
            short s2 = this.strHsh[iHash];
            if (s2 == -1) {
                return (short) -1;
            }
            if (this.strNxt[s2] == s && this.strChr[s2] == b) {
                return s2;
            }
            iHash = (iHash + 2039) % 9973;
        }
    }
}
