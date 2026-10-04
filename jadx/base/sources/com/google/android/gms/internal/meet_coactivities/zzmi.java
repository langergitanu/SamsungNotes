package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzmi {
    private static final long zza;
    private static final zzmi zzb;
    private final int zzc;
    private final int zzd;
    private final int zze;

    static {
        long jCharAt = 0;
        for (int i = 0; i < 7; i++) {
            jCharAt |= (((long) i) + 1) << ((int) (((long) (" #(+,-0".charAt(i) - ' ')) * 3));
        }
        zza = jCharAt;
        zzb = new zzmi(0, -1, -1);
    }

    private zzmi(int i, int i2, int i4) {
        this.zzc = i;
        this.zzd = i2;
        this.zze = i4;
    }

    public static int zzd(String str, boolean z) {
        int i = true != z ? 0 : 128;
        for (int i2 = 0; i2 < str.length(); i2++) {
            int iZzm = zzm(str.charAt(i2));
            if (iZzm < 0) {
                throw new IllegalArgumentException("invalid flags: ".concat(str));
            }
            i |= 1 << iZzm;
        }
        return i;
    }

    public static zzmi zzf() {
        return zzb;
    }

    public static zzmi zzg(String str, int i, int i2, boolean z) {
        if (i == i2 && !z) {
            return zzb;
        }
        int i4 = true != z ? 0 : 128;
        while (i != i2) {
            int i5 = i + 1;
            char cCharAt = str.charAt(i);
            if (cCharAt < ' ' || cCharAt > '0') {
                if (cCharAt > '9') {
                    throw zzpf.zza("invalid flag", str, i);
                }
                int i6 = cCharAt - '0';
                while (i5 != i2) {
                    int i7 = i5 + 1;
                    char cCharAt2 = str.charAt(i5);
                    if (cCharAt2 == '.') {
                        return new zzmi(i4, i6, zzn(str, i7, i2));
                    }
                    char c = (char) (cCharAt2 - '0');
                    if (c >= '\n') {
                        throw zzpf.zza("invalid width character", str, i5);
                    }
                    i6 = (i6 * 10) + c;
                    if (i6 > 999999) {
                        throw zzpf.zzc("width too large", str, i, i2);
                    }
                    i5 = i7;
                }
                return new zzmi(i4, i6, -1);
            }
            int iZzm = zzm(cCharAt);
            if (iZzm < 0) {
                if (cCharAt == '.') {
                    return new zzmi(i4, -1, zzn(str, i5, i2));
                }
                throw zzpf.zza("invalid flag", str, i);
            }
            int i8 = 1 << iZzm;
            if ((i4 & i8) != 0) {
                throw zzpf.zza("repeated flag", str, i);
            }
            i4 |= i8;
            i = i5;
        }
        return new zzmi(i4, -1, -1);
    }

    private static int zzm(char c) {
        return ((int) ((zza >>> ((c - ' ') * 3)) & 7)) - 1;
    }

    private static int zzn(String str, int i, int i2) {
        if (i == i2) {
            throw zzpf.zza("missing precision", str, i - 1);
        }
        int i4 = 0;
        for (int i5 = i; i5 < i2; i5++) {
            char cCharAt = (char) (str.charAt(i5) - '0');
            if (cCharAt >= '\n') {
                throw zzpf.zza("invalid precision character", str, i5);
            }
            i4 = (i4 * 10) + cCharAt;
            if (i4 > 999999) {
                throw zzpf.zzc("precision too large", str, i, i2);
            }
        }
        if (i4 != 0) {
            return i4;
        }
        if (i2 == i + 1) {
            return 0;
        }
        throw zzpf.zzc("invalid precision", str, i, i2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzmi) {
            zzmi zzmiVar = (zzmi) obj;
            if (zzmiVar.zzc == this.zzc && zzmiVar.zzd == this.zzd && zzmiVar.zze == this.zze) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.zzc * 31) + this.zzd) * 31) + this.zze;
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return this.zze;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final zzmi zze(int i, boolean z, boolean z2) {
        if (!zzj()) {
            int i2 = this.zzc;
            int i4 = i2 & 128;
            if (i4 == 0) {
                return zzb;
            }
            if (i4 != i2 || this.zzd != -1 || this.zze != -1) {
                return new zzmi(i4, -1, -1);
            }
        }
        return this;
    }

    public final StringBuilder zzh(StringBuilder sb) {
        if (!zzj()) {
            int i = this.zzc;
            int i2 = 0;
            while (true) {
                int i4 = i & (-129);
                int i5 = 1 << i2;
                if (i5 > i4) {
                    break;
                }
                if ((i4 & i5) != 0) {
                    sb.append(" #(+,-0".charAt(i2));
                }
                i2++;
            }
            int i6 = this.zzd;
            if (i6 != -1) {
                sb.append(i6);
            }
            if (this.zze != -1) {
                sb.append('.');
                sb.append(this.zze);
            }
        }
        return sb;
    }

    public final boolean zzi(zzmh zzmhVar) {
        return zzl(zzmhVar.zzb(), zzmhVar.zzd().zza());
    }

    public final boolean zzj() {
        return this == zzb;
    }

    public final boolean zzk() {
        return (this.zzc & 128) != 0;
    }

    public final boolean zzl(int i, boolean z) {
        int i2;
        if (zzj()) {
            return true;
        }
        int i4 = this.zzc;
        if (((~i) & i4) != 0) {
            return false;
        }
        if (!z && this.zze != -1) {
            return false;
        }
        int i5 = this.zzd;
        if ((i4 & 9) == 9 || (i2 = i4 & 96) == 96) {
            return false;
        }
        return i2 == 0 || i5 != -1;
    }
}
