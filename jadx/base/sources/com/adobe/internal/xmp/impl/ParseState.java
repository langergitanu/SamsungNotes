package com.adobe.internal.xmp.impl;

import com.adobe.internal.xmp.XMPException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
class ParseState {
    private int pos = 0;
    private String str;

    public ParseState(String str) {
        this.str = str;
    }

    /* JADX INFO: renamed from: ch */
    public char m3011ch(int i) {
        if (i < this.str.length()) {
            return this.str.charAt(i);
        }
        return (char) 0;
    }

    public int gatherInt(String str, int i) throws XMPException {
        char cM3011ch = m3011ch(this.pos);
        int i2 = 0;
        boolean z = false;
        while ('0' <= cM3011ch && cM3011ch <= '9') {
            i2 = (i2 * 10) + (cM3011ch - '0');
            z = true;
            int i4 = this.pos + 1;
            this.pos = i4;
            cM3011ch = m3011ch(i4);
        }
        if (!z) {
            throw new XMPException(str, 5);
        }
        if (i2 > i) {
            return i;
        }
        if (i2 < 0) {
            return 0;
        }
        return i2;
    }

    public boolean hasNext() {
        return this.pos < this.str.length();
    }

    public int length() {
        return this.str.length();
    }

    public int pos() {
        return this.pos;
    }

    public void skip() {
        this.pos++;
    }

    /* JADX INFO: renamed from: ch */
    public char m3010ch() {
        if (this.pos < this.str.length()) {
            return this.str.charAt(this.pos);
        }
        return (char) 0;
    }
}
