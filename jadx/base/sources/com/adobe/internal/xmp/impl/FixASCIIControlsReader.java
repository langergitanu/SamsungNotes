package com.adobe.internal.xmp.impl;

import java.io.IOException;
import java.io.PushbackReader;
import java.io.Reader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class FixASCIIControlsReader extends PushbackReader {
    private static final int BUFFER_SIZE = 8;
    private static final int STATE_AMP = 1;
    private static final int STATE_DIG1 = 4;
    private static final int STATE_ERROR = 5;
    private static final int STATE_HASH = 2;
    private static final int STATE_HEX = 3;
    private static final int STATE_START = 0;
    private int control;
    private int digits;
    private int state;

    public FixASCIIControlsReader(Reader reader) {
        super(reader, 8);
        this.state = 0;
        this.control = 0;
        this.digits = 0;
    }

    private char processChar(char c) {
        int i = this.state;
        if (i != 0) {
            if (i == 1) {
                if (c == '#') {
                    this.state = 2;
                    return c;
                }
                this.state = 5;
                return c;
            }
            if (i == 2) {
                if (c == 'x') {
                    this.control = 0;
                    this.digits = 0;
                    this.state = 3;
                    return c;
                }
                if ('0' > c || c > '9') {
                    this.state = 5;
                    return c;
                }
                this.control = Character.digit(c, 10);
                this.digits = 1;
                this.state = 4;
                return c;
            }
            if (i == 3) {
                if (('0' > c || c > '9') && (('a' > c || c > 'f') && ('A' > c || c > 'F'))) {
                    if (c == ';' && Utils.isControlChar((char) this.control)) {
                        this.state = 0;
                        return (char) this.control;
                    }
                    this.state = 5;
                    return c;
                }
                this.control = Character.digit(c, 16) + (this.control * 16);
                int i2 = this.digits + 1;
                this.digits = i2;
                if (i2 <= 4) {
                    this.state = 3;
                    return c;
                }
                this.state = 5;
                return c;
            }
            if (i == 4) {
                if ('0' > c || c > '9') {
                    if (c == ';' && Utils.isControlChar((char) this.control)) {
                        this.state = 0;
                        return (char) this.control;
                    }
                    this.state = 5;
                    return c;
                }
                this.control = Character.digit(c, 10) + (this.control * 10);
                int i4 = this.digits + 1;
                this.digits = i4;
                if (i4 <= 5) {
                    this.state = 4;
                    return c;
                }
                this.state = 5;
                return c;
            }
            if (i == 5) {
                this.state = 0;
                return c;
            }
        } else if (c == '&') {
            this.state = 1;
        }
        return c;
    }

    @Override // java.io.PushbackReader, java.io.FilterReader, java.io.Reader
    public int read(char[] cArr, int i, int i2) throws IOException {
        boolean z;
        char[] cArr2 = new char[8];
        int i4 = 0;
        int i5 = 0;
        loop0: while (true) {
            z = true;
            while (z && i4 < i2) {
                z = super.read(cArr2, i5, 1) == 1;
                if (z) {
                    char cProcessChar = processChar(cArr2[i5]);
                    int i6 = this.state;
                    if (i6 == 0) {
                        if (Utils.isControlChar(cProcessChar)) {
                            cProcessChar = ' ';
                        }
                        cArr[i] = cProcessChar;
                        i4++;
                        i++;
                    } else if (i6 == 5) {
                        unread(cArr2, 0, i5 + 1);
                    } else {
                        i5++;
                    }
                    i5 = 0;
                } else if (i5 > 0) {
                    break;
                }
            }
            unread(cArr2, 0, i5);
            this.state = 5;
            i5 = 0;
        }
        if (i4 > 0 || z) {
            return i4;
        }
        return -1;
    }
}
