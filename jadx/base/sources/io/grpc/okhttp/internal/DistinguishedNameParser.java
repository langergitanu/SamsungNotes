package io.grpc.okhttp.internal;

import javax.security.auth.x500.X500Principal;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
final class DistinguishedNameParser {
    private int beg;
    private char[] chars;
    private int cur;

    /* JADX INFO: renamed from: dn */
    private final String f8853dn;
    private int end;
    private final int length;
    private int pos;

    public DistinguishedNameParser(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.f8853dn = name;
        this.length = name.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0051, code lost:
    
        r2 = r8.beg;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005b, code lost:
    
        return new java.lang.String(r1, r2, r8.end - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String escapedAV() {
        int i;
        int i2;
        char c;
        int i4 = this.pos;
        this.beg = i4;
        this.end = i4;
        while (true) {
            int i5 = this.pos;
            if (i5 >= this.length) {
                char[] cArr = this.chars;
                int i6 = this.beg;
                return new String(cArr, i6, this.end - i6);
            }
            char[] cArr2 = this.chars;
            char c2 = cArr2[i5];
            if (c2 == ' ') {
                int i7 = this.end;
                this.cur = i7;
                this.pos = i5 + 1;
                this.end = i7 + 1;
                cArr2[i7] = ' ';
                while (true) {
                    i = this.pos;
                    i2 = this.length;
                    if (i >= i2) {
                        break;
                    }
                    char[] cArr3 = this.chars;
                    if (cArr3[i] != ' ') {
                        break;
                    }
                    int i8 = this.end;
                    this.end = i8 + 1;
                    cArr3[i8] = ' ';
                    this.pos = i + 1;
                }
                if (i == i2 || (c = this.chars[i]) == ',' || c == '+' || c == ';') {
                    break;
                }
            } else {
                if (c2 == ';') {
                    break;
                }
                if (c2 == '\\') {
                    int i9 = this.end;
                    this.end = i9 + 1;
                    cArr2[i9] = getEscaped();
                    this.pos++;
                } else {
                    if (c2 == '+' || c2 == ',') {
                        break;
                    }
                    int i10 = this.end;
                    this.end = i10 + 1;
                    cArr2[i10] = c2;
                    this.pos = i5 + 1;
                }
            }
        }
        char[] cArr4 = this.chars;
        int i11 = this.beg;
        return new String(cArr4, i11, this.cur - i11);
    }

    private int getByte(int i) {
        int i2;
        int i4;
        int i5 = i + 1;
        if (i5 >= this.length) {
            throw new IllegalStateException("Malformed DN: " + this.f8853dn);
        }
        char[] cArr = this.chars;
        char c = cArr[i];
        if (c >= '0' && c <= '9') {
            i2 = c - '0';
        } else if (c >= 'a' && c <= 'f') {
            i2 = c - 'W';
        } else {
            if (c < 'A' || c > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f8853dn);
            }
            i2 = c - '7';
        }
        char c2 = cArr[i5];
        if (c2 >= '0' && c2 <= '9') {
            i4 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i4 = c2 - 'W';
        } else {
            if (c2 < 'A' || c2 > 'F') {
                throw new IllegalStateException("Malformed DN: " + this.f8853dn);
            }
            i4 = c2 - '7';
        }
        return (i2 << 4) + i4;
    }

    private char getEscaped() {
        int i = this.pos + 1;
        this.pos = i;
        if (i == this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8853dn);
        }
        char c = this.chars[i];
        if (c == ' ' || c == '%' || c == '\\' || c == '_' || c == '\"' || c == '#') {
            return c;
        }
        switch (c) {
            case '*':
            case '+':
            case ',':
                return c;
            default:
                switch (c) {
                    case ';':
                    case '<':
                    case '=':
                    case '>':
                        return c;
                    default:
                        return getUTF8();
                }
        }
    }

    private char getUTF8() {
        int i;
        int i2;
        int i4 = getByte(this.pos);
        this.pos++;
        if (i4 < 128) {
            return (char) i4;
        }
        if (i4 < 192 || i4 > 247) {
            return '?';
        }
        if (i4 <= 223) {
            i = i4 & 31;
            i2 = 1;
        } else if (i4 <= 239) {
            i = i4 & 15;
            i2 = 2;
        } else {
            i = i4 & 7;
            i2 = 3;
        }
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = this.pos;
            int i7 = i6 + 1;
            this.pos = i7;
            if (i7 == this.length || this.chars[i7] != '\\') {
                return '?';
            }
            int i8 = i6 + 2;
            this.pos = i8;
            int i9 = getByte(i8);
            this.pos++;
            if ((i9 & 192) != 128) {
                return '?';
            }
            i = (i << 6) + (i9 & 63);
        }
        return (char) i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        r6.end = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String hexAV() {
        char[] cArr;
        char c;
        int i = this.pos;
        if (i + 4 >= this.length) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8853dn);
        }
        this.beg = i;
        this.pos = i + 1;
        while (true) {
            int i2 = this.pos;
            if (i2 == this.length || (c = (cArr = this.chars)[i2]) == '+' || c == ',' || c == ';') {
                break;
            }
            if (c == ' ') {
                this.end = i2;
                this.pos = i2 + 1;
                while (true) {
                    int i4 = this.pos;
                    if (i4 >= this.length || this.chars[i4] != ' ') {
                        break;
                    }
                    this.pos = i4 + 1;
                }
            } else {
                if (c >= 'A' && c <= 'F') {
                    cArr[i2] = (char) (c + ' ');
                }
                this.pos = i2 + 1;
            }
        }
        int i5 = this.end;
        int i6 = this.beg;
        int i7 = i5 - i6;
        if (i7 < 5 || (i7 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8853dn);
        }
        int i8 = i7 / 2;
        byte[] bArr = new byte[i8];
        int i9 = i6 + 1;
        for (int i10 = 0; i10 < i8; i10++) {
            bArr[i10] = (byte) getByte(i9);
            i9 += 2;
        }
        return new String(this.chars, this.beg, i7);
    }

    private String nextAT() {
        int i;
        int i2;
        int i4;
        int i5;
        char c;
        int i6;
        int i7;
        char c2;
        char c4;
        while (true) {
            i = this.pos;
            i2 = this.length;
            if (i >= i2 || this.chars[i] != ' ') {
                break;
            }
            this.pos = i + 1;
        }
        if (i == i2) {
            return null;
        }
        this.beg = i;
        this.pos = i + 1;
        while (true) {
            i4 = this.pos;
            i5 = this.length;
            if (i4 >= i5 || (c4 = this.chars[i4]) == '=' || c4 == ' ') {
                break;
            }
            this.pos = i4 + 1;
        }
        if (i4 >= i5) {
            throw new IllegalStateException("Unexpected end of DN: " + this.f8853dn);
        }
        this.end = i4;
        if (this.chars[i4] == ' ') {
            while (true) {
                i6 = this.pos;
                i7 = this.length;
                if (i6 >= i7 || (c2 = this.chars[i6]) == '=' || c2 != ' ') {
                    break;
                }
                this.pos = i6 + 1;
            }
            if (this.chars[i6] != '=' || i6 == i7) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f8853dn);
            }
        }
        this.pos++;
        while (true) {
            int i8 = this.pos;
            if (i8 >= this.length || this.chars[i8] != ' ') {
                break;
            }
            this.pos = i8 + 1;
        }
        int i9 = this.end;
        int i10 = this.beg;
        if (i9 - i10 > 4) {
            char[] cArr = this.chars;
            if (cArr[i10 + 3] == '.' && (((c = cArr[i10]) == 'O' || c == 'o') && ((cArr[i10 + 1] == 'I' || cArr[i10 + 1] == 'i') && (cArr[i10 + 2] == 'D' || cArr[i10 + 2] == 'd')))) {
                this.beg = i10 + 4;
            }
        }
        char[] cArr2 = this.chars;
        int i11 = this.beg;
        return new String(cArr2, i11, i9 - i11);
    }

    private String quotedAV() {
        int i = this.pos + 1;
        this.pos = i;
        this.beg = i;
        this.end = i;
        while (true) {
            int i2 = this.pos;
            if (i2 == this.length) {
                throw new IllegalStateException("Unexpected end of DN: " + this.f8853dn);
            }
            char[] cArr = this.chars;
            char c = cArr[i2];
            if (c == '\"') {
                this.pos = i2 + 1;
                while (true) {
                    int i4 = this.pos;
                    if (i4 >= this.length || this.chars[i4] != ' ') {
                        break;
                    }
                    this.pos = i4 + 1;
                }
                char[] cArr2 = this.chars;
                int i5 = this.beg;
                return new String(cArr2, i5, this.end - i5);
            }
            if (c == '\\') {
                cArr[this.end] = getEscaped();
            } else {
                cArr[this.end] = c;
            }
            this.pos++;
            this.end++;
        }
    }

    public String findMostSpecific(String str) {
        this.pos = 0;
        this.beg = 0;
        this.end = 0;
        this.cur = 0;
        this.chars = this.f8853dn.toCharArray();
        String strNextAT = nextAT();
        if (strNextAT == null) {
            return null;
        }
        do {
            int i = this.pos;
            if (i == this.length) {
                return null;
            }
            char c = this.chars[i];
            String strEscapedAV = c != '\"' ? c != '#' ? (c == '+' || c == ',' || c == ';') ? "" : escapedAV() : hexAV() : quotedAV();
            if (str.equalsIgnoreCase(strNextAT)) {
                return strEscapedAV;
            }
            int i2 = this.pos;
            if (i2 >= this.length) {
                return null;
            }
            char c2 = this.chars[i2];
            if (c2 != ',' && c2 != ';' && c2 != '+') {
                throw new IllegalStateException("Malformed DN: " + this.f8853dn);
            }
            this.pos = i2 + 1;
            strNextAT = nextAT();
        } while (strNextAT != null);
        throw new IllegalStateException("Malformed DN: " + this.f8853dn);
    }
}
