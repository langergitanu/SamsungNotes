package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

/* JADX INFO: loaded from: classes5.dex */
final class zzlw<T> implements zzmf<T> {
    private final zzlq zzuh;
    private final boolean zzui;
    private final zzmx<?, ?> zzur;
    private final zzjy<?> zzus;

    private zzlw(zzmx<?, ?> zzmxVar, zzjy<?> zzjyVar, zzlq zzlqVar) {
        this.zzur = zzmxVar;
        this.zzui = zzjyVar.zze(zzlqVar);
        this.zzus = zzjyVar;
        this.zzuh = zzlqVar;
    }

    public static <T> zzlw<T> zza(zzmx<?, ?> zzmxVar, zzjy<?> zzjyVar, zzlq zzlqVar) {
        return new zzlw<>(zzmxVar, zzjyVar, zzlqVar);
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final boolean equals(T t, T t2) {
        if (!this.zzur.zzr(t).equals(this.zzur.zzr(t2))) {
            return false;
        }
        if (this.zzui) {
            return this.zzus.zzb(t).equals(this.zzus.zzb(t2));
        }
        return true;
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final int hashCode(T t) {
        int iHashCode = this.zzur.zzr(t).hashCode();
        return this.zzui ? (iHashCode * 53) + this.zzus.zzb(t).hashCode() : iHashCode;
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final T newInstance() {
        return (T) this.zzuh.zzcz().zzde();
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zzc(T t, T t2) {
        zzmh.zza(this.zzur, t, t2);
        if (this.zzui) {
            zzmh.zza(this.zzus, t, t2);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zzd(T t) {
        this.zzur.zzd(t);
        this.zzus.zzd(t);
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final int zzn(T t) {
        zzmx<?, ?> zzmxVar = this.zzur;
        int iZzs = zzmxVar.zzs(zzmxVar.zzr(t));
        return this.zzui ? iZzs + this.zzus.zzb(t).zzco() : iZzs;
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final boolean zzp(T t) {
        return this.zzus.zzb(t).isInitialized();
    }

    @Override // com.google.android.gms.internal.drive.zzmf
    public final void zza(T t, zzns zznsVar) {
        for (T t2 : this.zzus.zzb(t)) {
            zzkd zzkdVar = (zzkd) t2.getKey();
            if (zzkdVar.zzcr() != zznr.MESSAGE || zzkdVar.zzcs() || zzkdVar.zzct()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            if (t2 instanceof zzkv) {
                zznsVar.zza(zzkdVar.zzcp(), (Object) ((zzkv) t2).zzdq().zzbl());
            } else {
                zznsVar.zza(zzkdVar.zzcp(), t2.getValue());
            }
        }
        zzmx<?, ?> zzmxVar = this.zzur;
        zzmxVar.zzc(zzmxVar.zzr(t), zznsVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a1, code lost:
    
        if (r12 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a3, code lost:
    
        r6.zzb((r11 << 3) | 2, r12);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a9, code lost:
    
        r12 = r13;
        r11 = r3;
        r13 = r5;
        r14 = r7;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a1 A[EDGE_INSN: B:58:0x00a1->B:35:0x00a1 BREAK  A[LOOP:1: B:18:0x0059->B:63:0x0059], SYNTHETIC] */
    @Override // com.google.android.gms.internal.drive.zzmf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(T t, byte[] bArr, int i, int i2, zziz zzizVar) throws zzkq {
        int iZza;
        zzkk zzkkVar = (zzkk) t;
        zzmy zzmyVarZzfb = zzkkVar.zzrq;
        if (zzmyVarZzfb == zzmy.zzfa()) {
            zzmyVarZzfb = zzmy.zzfb();
            zzkkVar.zzrq = zzmyVarZzfb;
        }
        zzmy zzmyVar = zzmyVarZzfb;
        ((zzkk.zzc) t).zzdg();
        zzkk.zzd zzdVar = null;
        while (i < i2) {
            int iZza2 = zziy.zza(bArr, i, zzizVar);
            int i4 = zzizVar.zznk;
            if (i4 == 11) {
                byte[] bArr2 = bArr;
                int i5 = i2;
                zziz zzizVar2 = zzizVar;
                int i6 = 0;
                zzjc zzjcVar = null;
                while (true) {
                    if (iZza2 >= i5) {
                        iZza = iZza2;
                        break;
                    }
                    iZza = zziy.zza(bArr2, iZza2, zzizVar2);
                    int i7 = zzizVar2.zznk;
                    int i8 = i7 >>> 3;
                    int i9 = i7 & 7;
                    if (i8 != 2) {
                        if (i8 == 3) {
                            if (zzdVar != null) {
                                zzmd.zzej();
                                throw new NoSuchMethodError();
                            }
                            if (i9 == 2) {
                                iZza2 = zziy.zze(bArr2, iZza, zzizVar2);
                                zzjcVar = (zzjc) zzizVar2.zznm;
                            }
                        }
                        if (i7 != 12) {
                            break;
                        } else {
                            iZza2 = zziy.zza(i7, bArr2, iZza, i5, zzizVar2);
                        }
                    } else if (i9 == 0) {
                        iZza2 = zziy.zza(bArr2, iZza, zzizVar2);
                        i6 = zzizVar2.zznk;
                        zzdVar = (zzkk.zzd) this.zzus.zza(zzizVar2.zznn, this.zzuh, i6);
                    } else if (i7 != 12) {
                    }
                }
            } else if ((i4 & 7) == 2) {
                zzdVar = (zzkk.zzd) this.zzus.zza(zzizVar.zznn, this.zzuh, i4 >>> 3);
                if (zzdVar == null) {
                    i = zziy.zza(i4, bArr, iZza2, i2, zzmyVar, zzizVar);
                } else {
                    zzmd.zzej();
                    throw new NoSuchMethodError();
                }
            } else {
                i = zziy.zza(i4, bArr, iZza2, i2, zzizVar);
            }
        }
        if (i != i2) {
            throw zzkq.zzdm();
        }
    }
}
