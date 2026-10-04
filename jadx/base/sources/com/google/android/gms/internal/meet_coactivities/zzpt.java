package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;
import okio.internal.BufferKt;
import org.apache.commons.beanutils.PropertyUtils;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzpt implements Closeable {
    private final Reader zzb;
    private long zzh;
    private int zzi;
    private String zzj;
    private int[] zzk;
    private String[] zzm;
    private int[] zzn;
    private final char[] zzc = new char[1024];
    private int zzd = 0;
    private int zze = 0;
    private int zzf = 0;
    private int zzg = 0;
    int zza = 0;
    private int zzl = 1;

    static {
        zzpr.zza = new zzps();
    }

    public zzpt(Reader reader) {
        int[] iArr = new int[32];
        this.zzk = iArr;
        iArr[0] = 6;
        this.zzm = new String[32];
        this.zzn = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.zzb = reader;
    }

    private final int zzo(boolean z) throws IOException {
        int i = this.zzd;
        int i2 = this.zze;
        while (true) {
            if (i == i2) {
                this.zzd = i;
                if (!zzv(1)) {
                    if (z) {
                        throw new EOFException("End of input".concat(zzd()));
                    }
                    return -1;
                }
                i = this.zzd;
                i2 = this.zze;
            }
            int i4 = i + 1;
            char c = this.zzc[i];
            if (c == '\n') {
                this.zzf++;
                this.zzg = i4;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c != '/') {
                    if (c != '#') {
                        this.zzd = i4;
                        return c;
                    }
                    this.zzd = i4;
                    throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
                }
                this.zzd = i4;
                if (i4 == i2) {
                    this.zzd = i;
                    boolean zZzv = zzv(2);
                    this.zzd++;
                    if (!zZzv) {
                        return 47;
                    }
                }
                throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
            }
            i = i4;
        }
    }

    private final zzpu zzp(String str) throws zzpu {
        throw new zzpu(AbstractC0541b.m757C(str, zzd(), "\nSee https://github.com/google/gson/blob/main/Troubleshooting.md#malformed-json"));
    }

    private final IllegalStateException zzq(String str) throws IOException {
        String str2;
        int iZzn = zzn();
        switch (zzn()) {
            case 1:
                str2 = "BEGIN_ARRAY";
                break;
            case 2:
                str2 = "END_ARRAY";
                break;
            case 3:
                str2 = "BEGIN_OBJECT";
                break;
            case 4:
                str2 = "END_OBJECT";
                break;
            case 5:
                str2 = "NAME";
                break;
            case 6:
                str2 = "STRING";
                break;
            case 7:
                str2 = "NUMBER";
                break;
            case 8:
                str2 = "BOOLEAN";
                break;
            case 9:
                str2 = "NULL";
                break;
            default:
                str2 = "END_DOCUMENT";
                break;
        }
        StringBuilder sbM16m = AbstractC0000a.m16m("Expected ", str, " but was ", str2, zzd());
        sbM16m.append("\nSee ");
        sbM16m.append("https://github.com/google/gson/blob/main/Troubleshooting.md#".concat(iZzn == 9 ? "adapter-not-null-safe" : "unexpected-json-structure"));
        return new IllegalStateException(sbM16m.toString());
    }

    private final String zzr(boolean z) {
        StringBuilder sb = new StringBuilder("$");
        for (int i = 0; i < this.zzl; i++) {
            int i2 = this.zzk[i];
            switch (i2) {
                case 1:
                case 2:
                    int i4 = this.zzn[i];
                    sb.append(PropertyUtils.INDEXED_DELIM);
                    sb.append(i4);
                    sb.append(PropertyUtils.INDEXED_DELIM2);
                    break;
                case 3:
                case 4:
                case 5:
                    sb.append('.');
                    String str = this.zzm[i];
                    if (str != null) {
                        sb.append(str);
                    }
                    break;
                case 6:
                case 7:
                case 8:
                    break;
                default:
                    throw new AssertionError(AbstractC0000a.m11h(i2, "Unknown scope value: "));
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:87:0x0119, code lost:
    
        r3 = r1 - r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x011b, code lost:
    
        if (r0 != null) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x011d, code lost:
    
        r0 = new java.lang.StringBuilder(java.lang.Math.max(r3 + r3, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0129, code lost:
    
        r0.append(r4, r2, r3);
        r10.zzd = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String zzs(char c) throws zzpu {
        char[] cArr;
        int i;
        StringBuilder sb = null;
        loop0: do {
            int i2 = this.zzd;
            int i4 = this.zze;
            int i5 = i2;
            while (true) {
                char[] cArr2 = this.zzc;
                if (i2 >= i4) {
                    break;
                }
                int i6 = i2 + 1;
                char c2 = cArr2[i2];
                if (c2 == c) {
                    int i7 = (i6 - i5) - 1;
                    this.zzd = i6;
                    if (sb == null) {
                        return new String(cArr2, i5, i7);
                    }
                    sb.append(cArr2, i5, i7);
                    return sb.toString();
                }
                char c4 = '\n';
                if (c2 == '\\') {
                    int i8 = i6 - i5;
                    int i9 = i8 - 1;
                    this.zzd = i6;
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i8 + i8, 16));
                    }
                    sb.append(cArr2, i5, i9);
                    if (this.zzd == this.zze && !zzv(1)) {
                        throw zzp("Unterminated escape sequence");
                    }
                    char[] cArr3 = this.zzc;
                    int i10 = this.zzd;
                    int i11 = i10 + 1;
                    this.zzd = i11;
                    char c5 = cArr3[i10];
                    if (c5 != '\n') {
                        if (c5 != '\"' && c5 != '\'' && c5 != '/' && c5 != '\\') {
                            if (c5 == 'b') {
                                c4 = '\b';
                            } else if (c5 == 'f') {
                                c4 = '\f';
                            } else if (c5 != 'n') {
                                if (c5 == 'r') {
                                    c4 = '\r';
                                } else if (c5 == 't') {
                                    c4 = '\t';
                                } else {
                                    if (c5 != 'u') {
                                        throw zzp("Invalid escape sequence");
                                    }
                                    if (i10 + 5 > this.zze && !zzv(4)) {
                                        throw zzp("Unterminated escape sequence");
                                    }
                                    int i12 = this.zzd;
                                    int i13 = i12 + 4;
                                    int i14 = 0;
                                    while (i12 < i13) {
                                        cArr = this.zzc;
                                        int i15 = i14 << 4;
                                        char c6 = cArr[i12];
                                        if (c6 >= '0' && c6 <= '9') {
                                            i = c6 - '0';
                                        } else if (c6 >= 'a' && c6 <= 'f') {
                                            i = c6 - 'W';
                                        } else {
                                            if (c6 < 'A' || c6 > 'F') {
                                                break loop0;
                                            }
                                            i = c6 - '7';
                                        }
                                        i14 = i + i15;
                                        i12++;
                                    }
                                    this.zzd += 4;
                                    c4 = (char) i14;
                                }
                            }
                        }
                        sb.append(c4);
                        i5 = this.zzd;
                        i4 = this.zze;
                        i2 = i5;
                    } else {
                        this.zzf++;
                        this.zzg = i11;
                    }
                    c4 = c5;
                    sb.append(c4);
                    i5 = this.zzd;
                    i4 = this.zze;
                    i2 = i5;
                } else {
                    if (c2 == '\n') {
                        this.zzf++;
                        this.zzg = i6;
                    }
                    i2 = i6;
                }
            }
            throw zzp("Malformed Unicode escape \\u".concat(new String(cArr, this.zzd, 4)));
        } while (zzv(1));
        throw zzp("Unterminated string");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x004e, code lost:
    
        throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String zzt() throws zzpu {
        String string;
        int i = 0;
        StringBuilder sb = null;
        do {
            int i2 = 0;
            while (true) {
                int i4 = this.zzd + i2;
                if (i4 < this.zze) {
                    char c = this.zzc[i4];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                                    break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 >= 1024) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.zzc, this.zzd, i2);
                    this.zzd += i2;
                } else if (zzv(i2 + 1)) {
                }
            }
            i = i2;
            if (sb != null) {
                string = new String(this.zzc, this.zzd, i);
            } else {
                sb.append(this.zzc, this.zzd, i);
                string = sb.toString();
            }
            this.zzd += i;
            return string;
        } while (zzv(1));
        if (sb != null) {
        }
        this.zzd += i;
        return string;
    }

    private final void zzu(int i) {
        int i2 = this.zzl;
        int[] iArr = this.zzk;
        if (i2 == iArr.length) {
            int i4 = i2 + i2;
            this.zzk = Arrays.copyOf(iArr, i4);
            this.zzn = Arrays.copyOf(this.zzn, i4);
            this.zzm = (String[]) Arrays.copyOf(this.zzm, i4);
        }
        int[] iArr2 = this.zzk;
        int i5 = this.zzl;
        this.zzl = i5 + 1;
        iArr2[i5] = i;
    }

    private final boolean zzv(int i) throws IOException {
        int i2;
        int i4 = this.zzg;
        int i5 = this.zzd;
        this.zzg = i4 - i5;
        char[] cArr = this.zzc;
        int i6 = this.zze;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.zze = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.zze = 0;
        }
        this.zzd = 0;
        do {
            Reader reader = this.zzb;
            int i8 = this.zze;
            int i9 = reader.read(cArr, i8, 1024 - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.zze + i9;
            this.zze = i2;
            if (this.zzf == 0 && this.zzg == 0 && i2 > 0 && cArr[0] == 65279) {
                this.zzd++;
                this.zzg = 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    private final boolean zzw(char c) throws zzpu {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zza = 0;
        this.zzk[0] = 8;
        this.zzl = 1;
        this.zzb.close();
    }

    public final String toString() {
        return "zzpt".concat(zzd());
    }

    public final double zza() throws IOException {
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        if (iZzb == 15) {
            this.zza = 0;
            int[] iArr = this.zzn;
            int i = this.zzl - 1;
            iArr[i] = iArr[i] + 1;
            return this.zzh;
        }
        if (iZzb == 16) {
            char[] cArr = this.zzc;
            int i2 = this.zzd;
            int i4 = this.zzi;
            this.zzj = new String(cArr, i2, i4);
            this.zzd = i2 + i4;
        } else if (iZzb == 8 || iZzb == 9) {
            this.zzj = zzs(iZzb == 8 ? '\'' : '\"');
        } else if (iZzb == 10) {
            this.zzj = zzt();
        } else if (iZzb != 11) {
            throw zzq("a double");
        }
        this.zza = 11;
        double d = Double.parseDouble(this.zzj);
        if (Double.isNaN(d) || Double.isInfinite(d)) {
            throw zzp(AbstractC1974b.m1318k("JSON forbids NaN and infinities: ", d));
        }
        this.zzj = null;
        this.zza = 0;
        int[] iArr2 = this.zzn;
        int i5 = this.zzl - 1;
        iArr2[i5] = iArr2[i5] + 1;
        return d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:138:0x01b6, code lost:
    
        if (zzw(r12) == false) goto L140;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x01ba, code lost:
    
        if (r8 != 2) goto L157;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x01bc, code lost:
    
        if (r18 == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x01c2, code lost:
    
        if (r6 != Long.MIN_VALUE) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x01c4, code lost:
    
        if (r19 == false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01c6, code lost:
    
        r3 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x01c8, code lost:
    
        r8 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x01ca, code lost:
    
        r3 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x01ce, code lost:
    
        if (r6 != 0) goto L152;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x01d0, code lost:
    
        if (r3 != false) goto L146;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x01d3, code lost:
    
        if (r3 == false) goto L154;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x01d6, code lost:
    
        r6 = -r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x01d7, code lost:
    
        r25.zzh = r6;
        r25.zzd += r9;
        r6 = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x01e0, code lost:
    
        r25.zza = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x01e3, code lost:
    
        if (r8 == 2) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x01e6, code lost:
    
        if (r8 == 4) goto L162;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x01e9, code lost:
    
        if (r8 != 7) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x01eb, code lost:
    
        r25.zzi = r9;
        r6 = 16;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x021e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0237 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0120  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int zzb() throws IOException {
        int iZzo;
        int i;
        String str;
        String str2;
        int i2;
        char c;
        char c2;
        int i4;
        int i5;
        int[] iArr = this.zzk;
        int i6 = this.zzl - 1;
        int i7 = iArr[i6];
        int i8 = 3;
        boolean z = true;
        if (i7 != 1) {
            if (i7 == 2) {
                int iZzo2 = zzo(true);
                if (iZzo2 != 44) {
                    if (iZzo2 == 59) {
                        throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
                    }
                    if (iZzo2 != 93) {
                        throw zzp("Unterminated array");
                    }
                    i8 = 4;
                }
            } else if (i7 == 3 || i7 == 5) {
                iArr[i6] = 4;
                if (i7 != 5 || (iZzo = zzo(true)) == 44) {
                    int iZzo3 = zzo(true);
                    if (iZzo3 == 34) {
                        i8 = 13;
                    } else {
                        if (iZzo3 == 39) {
                            throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
                        }
                        if (iZzo3 != 125) {
                            throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
                        }
                        if (i7 == 5) {
                            throw zzp("Expected name");
                        }
                    }
                } else {
                    if (iZzo == 59) {
                        throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
                    }
                    if (iZzo != 125) {
                        throw zzp("Unterminated object");
                    }
                }
                i8 = 2;
            } else if (i7 == 4) {
                iArr[i6] = 5;
                int iZzo4 = zzo(true);
                if (iZzo4 != 58) {
                    if (iZzo4 != 61) {
                        throw zzp("Expected ':'");
                    }
                    throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
                }
            } else if (i7 == 6) {
                iArr[i6] = 7;
            } else if (i7 == 7) {
                if (zzo(false) != -1) {
                    throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
                }
                i8 = 17;
            } else if (i7 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
            this.zza = i8;
            return i8;
        }
        iArr[i6] = 2;
        int iZzo5 = zzo(true);
        if (iZzo5 != 34) {
            if (iZzo5 == 39) {
                throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
            }
            if (iZzo5 == 44 || iZzo5 == 59) {
                i = 1;
            } else if (iZzo5 != 91) {
                if (iZzo5 == 93) {
                    i = 1;
                    if (i7 == 1) {
                        i8 = 4;
                    }
                } else if (iZzo5 != 123) {
                    int i9 = this.zzd - 1;
                    this.zzd = i9;
                    char c4 = this.zzc[i9];
                    if (c4 == 't' || c4 == 'T') {
                        str = "TRUE";
                        str2 = "true";
                        i2 = 5;
                    } else if (c4 == 'f' || c4 == 'F') {
                        str = "FALSE";
                        str2 = "false";
                        i2 = 6;
                    } else {
                        if (c4 == 'n' || c4 == 'N') {
                            str = "NULL";
                            str2 = "null";
                            i2 = 7;
                        }
                        i2 = 0;
                        if (i2 == 0) {
                            return i2;
                        }
                        char[] cArr = this.zzc;
                        int i10 = this.zzd;
                        int i11 = this.zze;
                        boolean z2 = true;
                        char c5 = 0;
                        int i12 = 0;
                        boolean z3 = false;
                        long j = 0;
                        while (true) {
                            if (i10 + i12 == i11) {
                                if (i12 == 1024) {
                                    break;
                                }
                                if (!zzv(i12 + 1)) {
                                    break;
                                }
                                i10 = this.zzd;
                                i11 = this.zze;
                                c2 = cArr[i10 + i12];
                                if (c2 != '+') {
                                }
                            } else {
                                c2 = cArr[i10 + i12];
                                if (c2 != '+') {
                                    i4 = i11;
                                    if (c5 != 5) {
                                        break;
                                    }
                                    c5 = 6;
                                    i12++;
                                    i11 = i4;
                                    z = true;
                                } else if (c2 == 'E' || c2 == 'e') {
                                    i4 = i11;
                                    if (c5 != 2 && c5 != 4) {
                                        break;
                                    }
                                    c5 = 5;
                                    i12++;
                                    i11 = i4;
                                    z = true;
                                } else if (c2 == '-') {
                                    i4 = i11;
                                    if (c5 == 0) {
                                        c5 = 1;
                                        z3 = true;
                                        i12++;
                                        i11 = i4;
                                        z = true;
                                    } else {
                                        if (c5 != 5) {
                                            break;
                                        }
                                        c5 = 6;
                                        i12++;
                                        i11 = i4;
                                        z = true;
                                    }
                                } else if (c2 == '.') {
                                    i4 = i11;
                                    if (c5 != 2) {
                                        break;
                                    }
                                    c5 = 3;
                                    i12++;
                                    i11 = i4;
                                    z = true;
                                } else {
                                    if (c2 < '0' || c2 > '9') {
                                        break;
                                    }
                                    if (c5 == z || c5 == 0) {
                                        i4 = i11;
                                        j = -(c2 - '0');
                                        c5 = 2;
                                    } else if (c5 != 2) {
                                        i4 = i11;
                                        if (c5 == 3) {
                                            c5 = 4;
                                        } else if (c5 == 5 || c5 == 6) {
                                            c5 = 7;
                                        }
                                        i12++;
                                        i11 = i4;
                                        z = true;
                                    } else {
                                        if (j == 0) {
                                            break;
                                        }
                                        i4 = i11;
                                        long j2 = (10 * j) - ((long) (c2 - '0'));
                                        z2 &= j > BufferKt.OVERFLOW_ZONE || (j == BufferKt.OVERFLOW_ZONE && j2 < j);
                                        j = j2;
                                    }
                                    i12++;
                                    i11 = i4;
                                    z = true;
                                }
                            }
                            if (i5 == 0) {
                                return i5;
                            }
                            if (zzw(this.zzc[this.zzd])) {
                                throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
                            }
                            throw zzp("Expected value");
                        }
                        i5 = 0;
                        if (i5 == 0) {
                        }
                    }
                    int i13 = 0;
                    while (true) {
                        int length = str2.length();
                        if (i13 < length) {
                            if ((this.zzd + i13 >= this.zze && !zzv(i13 + 1)) || ((c = this.zzc[this.zzd + i13]) != str2.charAt(i13) && c != str.charAt(i13))) {
                                break;
                            }
                            i13++;
                        } else {
                            if ((this.zzd + length < this.zze || zzv(length + 1)) && zzw(this.zzc[this.zzd + length])) {
                                break;
                            }
                            this.zzd += length;
                            this.zza = i2;
                        }
                    }
                    i2 = 0;
                    if (i2 == 0) {
                    }
                } else {
                    i8 = 1;
                }
            }
            if (i7 == i || i7 == 2) {
                throw zzp("Use JsonReader.setStrictness(Strictness.LENIENT) to accept malformed JSON");
            }
            throw zzp("Unexpected value");
        }
        i8 = 9;
        this.zza = i8;
        return i8;
    }

    public final String zzc() {
        return zzr(false);
    }

    public final String zzd() {
        int i = this.zzf + 1;
        int i2 = this.zzd - this.zzg;
        String strZzr = zzr(false);
        StringBuilder sbM778t = AbstractC0541b.m778t(i, " at line ", " column ");
        sbM778t.append(i2 + 1);
        sbM778t.append(" path ");
        sbM778t.append(strZzr);
        return sbM778t.toString();
    }

    public final String zze() throws IOException {
        String strZzs;
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        if (iZzb == 14) {
            strZzs = zzt();
        } else if (iZzb == 12) {
            strZzs = zzs('\'');
        } else {
            if (iZzb != 13) {
                throw zzq("a name");
            }
            strZzs = zzs('\"');
        }
        this.zza = 0;
        this.zzm[this.zzl - 1] = strZzs;
        return strZzs;
    }

    public final String zzf() throws IOException {
        String string;
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        if (iZzb == 10) {
            string = zzt();
        } else if (iZzb == 8) {
            string = zzs('\'');
        } else if (iZzb == 9) {
            string = zzs('\"');
        } else if (iZzb == 11) {
            string = this.zzj;
            this.zzj = null;
        } else if (iZzb == 15) {
            string = Long.toString(this.zzh);
        } else {
            if (iZzb != 16) {
                throw zzq("a string");
            }
            String str = new String(this.zzc, this.zzd, this.zzi);
            this.zzd += this.zzi;
            string = str;
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i = this.zzl - 1;
        iArr[i] = iArr[i] + 1;
        return string;
    }

    public final void zzg() throws IOException {
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        if (iZzb != 3) {
            throw zzq("BEGIN_ARRAY");
        }
        zzu(1);
        this.zzn[this.zzl - 1] = 0;
        this.zza = 0;
    }

    public final void zzh() throws IOException {
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        if (iZzb != 1) {
            throw zzq("BEGIN_OBJECT");
        }
        zzu(3);
        this.zza = 0;
    }

    public final void zzi() throws IOException {
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        if (iZzb != 4) {
            throw zzq("END_ARRAY");
        }
        int i = this.zzl;
        this.zzl = i - 1;
        int[] iArr = this.zzn;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.zza = 0;
    }

    public final void zzj() throws IOException {
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        if (iZzb != 2) {
            throw zzq("END_OBJECT");
        }
        int i = this.zzl;
        int i2 = i - 1;
        this.zzl = i2;
        this.zzm[i2] = null;
        int[] iArr = this.zzn;
        int i4 = i - 2;
        iArr[i4] = iArr[i4] + 1;
        this.zza = 0;
    }

    public final void zzk() throws IOException {
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        if (iZzb != 7) {
            throw zzq("null");
        }
        this.zza = 0;
        int[] iArr = this.zzn;
        int i = this.zzl - 1;
        iArr[i] = iArr[i] + 1;
    }

    public final boolean zzl() throws IOException {
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        return (iZzb == 2 || iZzb == 4 || iZzb == 17) ? false : true;
    }

    public final boolean zzm() throws IOException {
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        if (iZzb == 5) {
            this.zza = 0;
            int[] iArr = this.zzn;
            int i = this.zzl - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iZzb != 6) {
            throw zzq("a boolean");
        }
        this.zza = 0;
        int[] iArr2 = this.zzn;
        int i2 = this.zzl - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return false;
    }

    public final int zzn() throws IOException {
        int iZzb = this.zza;
        if (iZzb == 0) {
            iZzb = zzb();
        }
        switch (iZzb) {
            case 1:
                return 3;
            case 2:
                return 4;
            case 3:
                return 1;
            case 4:
                return 2;
            case 5:
            case 6:
                return 8;
            case 7:
                return 9;
            case 8:
            case 9:
            case 10:
            case 11:
                return 6;
            case 12:
            case 13:
            case 14:
                return 5;
            case 15:
            case 16:
                return 7;
            default:
                return 10;
        }
    }
}
