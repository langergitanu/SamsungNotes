package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzpd {
    private final zznu zza;
    private int zzb = 0;
    private int zzc = -1;

    public zzpd(zznu zznuVar) {
        zzpi.zza(zznuVar, "context");
        this.zza = zznuVar;
    }

    public abstract Object zza();

    public abstract void zzc(int i, int i2, zzoy zzoyVar);

    public final int zzh() {
        return this.zzc + 1;
    }

    public final zzpe zzi() {
        return this.zza.zza();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x0098  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object zzj() {
        int i;
        int i2;
        zzoy zzoyVarZza;
        String strZzb = this.zza.zzb();
        int iZzc = zzpg.zzc(strZzb, 0);
        int i4 = 0;
        int i5 = -1;
        while (iZzc >= 0) {
            int i6 = iZzc + 1;
            int i7 = 0;
            int i8 = i6;
            while (i8 < strZzb.length()) {
                int i9 = i8 + 1;
                char cCharAt = strZzb.charAt(i8);
                char c = (char) (cCharAt - '0');
                if (c >= '\n') {
                    if (cCharAt == '$') {
                        if (i8 - i6 == 0) {
                            throw zzpf.zzc("missing index", strZzb, iZzc, i9);
                        }
                        if (strZzb.charAt(i6) == '0') {
                            throw zzpf.zzc("index has leading zero", strZzb, iZzc, i9);
                        }
                        int i10 = i7 - 1;
                        if (i9 == strZzb.length()) {
                            throw zzpf.zzd("unterminated parameter", strZzb, iZzc);
                        }
                        i = i8 + 2;
                        strZzb.charAt(i9);
                        i5 = i10;
                    } else {
                        if (cCharAt != '<') {
                            i5 = i4;
                            i4++;
                            for (i2 = i9 - 1; i2 < strZzb.length(); i2++) {
                                if (((char) ((strZzb.charAt(i2) & (-33)) - 65)) < 26) {
                                    int i11 = i2 + 1;
                                    char cCharAt2 = strZzb.charAt(i2);
                                    zzmi zzmiVarZzg = zzmi.zzg(strZzb, i6, i2, (cCharAt2 & ' ') == 0);
                                    zzmh zzmhVarZzc = zzmh.zzc(cCharAt2);
                                    if (zzmhVarZzc != null) {
                                        if (!zzmiVarZzg.zzi(zzmhVarZzc)) {
                                            throw zzpf.zzc("invalid format specifier", strZzb, iZzc, i11);
                                        }
                                        zzoyVarZza = zzpa.zza(i5, zzmhVarZzc, zzmiVarZzg);
                                    } else if (cCharAt2 == 't' || cCharAt2 == 'T') {
                                        if (!zzmiVarZzg.zzl(160, false)) {
                                            throw zzpf.zzc("invalid format specification", strZzb, iZzc, i11);
                                        }
                                        int i12 = i2 + 2;
                                        if (i12 > strZzb.length()) {
                                            throw zzpf.zza("truncated format specifier", strZzb, iZzc);
                                        }
                                        zzow zzowVarZzb = zzow.zzb(strZzb.charAt(i11));
                                        if (zzowVarZzb == null) {
                                            throw zzpf.zza("illegal date/time conversion", strZzb, i11);
                                        }
                                        zzoyVarZza = zzox.zza(zzowVarZzb, zzmiVarZzg, i5);
                                        i11 = i12;
                                    } else {
                                        if (cCharAt2 != 'h' && cCharAt2 != 'H') {
                                            throw zzpf.zzc("invalid format specification", strZzb, iZzc, i11);
                                        }
                                        if (!zzmiVarZzg.zzl(160, false)) {
                                            throw zzpf.zzc("invalid format specification", strZzb, iZzc, i11);
                                        }
                                        zzoyVarZza = new zzpb(zzmiVarZzg, i5, zzmiVarZzg);
                                    }
                                    zzl(iZzc, i11, zzoyVarZza);
                                    iZzc = zzpg.zzc(strZzb, i11);
                                }
                            }
                            throw zzpf.zzd("unterminated parameter", strZzb, iZzc);
                        }
                        if (i5 == -1) {
                            throw zzpf.zzc("invalid relative parameter", strZzb, iZzc, i9);
                        }
                        if (i9 == strZzb.length()) {
                            throw zzpf.zzd("unterminated parameter", strZzb, iZzc);
                        }
                        i = i8 + 2;
                        strZzb.charAt(i9);
                    }
                    i6 = i9;
                    i9 = i;
                    while (i2 < strZzb.length()) {
                    }
                    throw zzpf.zzd("unterminated parameter", strZzb, iZzc);
                }
                i7 = (i7 * 10) + c;
                if (i7 >= 1000000) {
                    throw zzpf.zzc("index too large", strZzb, iZzc, i9);
                }
                i8 = i9;
            }
            throw zzpf.zzd("unterminated parameter", strZzb, iZzc);
        }
        int i13 = this.zzb;
        if (((i13 + 1) & i13) != 0 || (this.zzc > 31 && i13 != -1)) {
            throw zzpf.zzb(String.format("unreferenced arguments [first missing index=%d]", Integer.valueOf(Integer.numberOfTrailingZeros(~i13))), this.zza.zzb());
        }
        return zza();
    }

    public final String zzk() {
        return this.zza.zzb();
    }

    public final void zzl(int i, int i2, zzoy zzoyVar) {
        if (zzoyVar.zzc() < 32) {
            this.zzb |= 1 << zzoyVar.zzc();
        }
        this.zzc = Math.max(this.zzc, zzoyVar.zzc());
        zzc(i, i2, zzoyVar);
    }
}
