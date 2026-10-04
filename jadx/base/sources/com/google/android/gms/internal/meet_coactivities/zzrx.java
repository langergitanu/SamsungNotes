package com.google.android.gms.internal.meet_coactivities;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzrx implements zzup {
    private final zzrw zza;
    private int zzb;
    private int zzc;
    private int zzd = 0;

    private zzrx(zzrw zzrwVar) {
        byte[] bArr = zztg.zzb;
        this.zza = zzrwVar;
        zzrwVar.zzd = this;
    }

    private final Object zzQ(zzvp zzvpVar, Class cls, zzsj zzsjVar) throws zzth {
        zzvp zzvpVar2 = zzvp.zza;
        switch (zzvpVar.ordinal()) {
            case 0:
                return Double.valueOf(zza());
            case 1:
                return Float.valueOf(zzb());
            case 2:
                return Long.valueOf(zzl());
            case 3:
                return Long.valueOf(zzo());
            case 4:
                return Integer.valueOf(zzg());
            case 5:
                return Long.valueOf(zzk());
            case 6:
                return Integer.valueOf(zzf());
            case 7:
                return Boolean.valueOf(zzO());
            case 8:
                return zzs();
            case 9:
            default:
                throw new IllegalArgumentException("unsupported field type.");
            case 10:
                zzV(2);
                return zzR(zzum.zza().zzb(cls), zzsjVar);
            case 11:
                return zzp();
            case 12:
                return Integer.valueOf(zzj());
            case 13:
                return Integer.valueOf(zze());
            case 14:
                return Integer.valueOf(zzh());
            case 15:
                return Long.valueOf(zzm());
            case 16:
                return Integer.valueOf(zzi());
            case 17:
                return Long.valueOf(zzn());
        }
    }

    private final Object zzR(zzuq zzuqVar, zzsj zzsjVar) throws zzti {
        Object objZze = zzuqVar.zze();
        zzT(objZze, zzuqVar, zzsjVar);
        zzuqVar.zzf(objZze);
        return objZze;
    }

    private final void zzS(Object obj, zzuq zzuqVar, zzsj zzsjVar) {
        int i = this.zzc;
        this.zzc = ((this.zzb >>> 3) << 3) | 4;
        try {
            zzuqVar.zzh(obj, this, zzsjVar);
            if (this.zzb == this.zzc) {
            } else {
                throw zzti.zzg();
            }
        } finally {
            this.zzc = i;
        }
    }

    private final void zzT(Object obj, zzuq zzuqVar, zzsj zzsjVar) throws zzti {
        zzrw zzrwVar = this.zza;
        int iZzn = zzrwVar.zzn();
        if (zzrwVar.zza >= zzrwVar.zzb) {
            throw new zzti("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
        }
        int iZze = this.zza.zze(iZzn);
        this.zza.zza++;
        zzuqVar.zzh(obj, this, zzsjVar);
        this.zza.zzz(0);
        r4.zza--;
        this.zza.zzA(iZze);
    }

    private final void zzU(int i) throws zzti {
        if (this.zza.zzd() != i) {
            throw zzti.zzi();
        }
    }

    private final void zzV(int i) throws zzth {
        if ((this.zzb & 7) != i) {
            throw zzti.zza();
        }
    }

    private static final void zzW(int i) throws zzti {
        if ((i & 3) != 0) {
            throw zzti.zzg();
        }
    }

    private static final void zzX(int i) throws zzti {
        if ((i & 7) != 0) {
            throw zzti.zzg();
        }
    }

    public static zzrx zzq(zzrw zzrwVar) {
        zzrx zzrxVar = zzrwVar.zzd;
        return zzrxVar != null ? zzrxVar : new zzrx(zzrwVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzA(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzts) {
            zzts zztsVar = (zzts) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzti.zza();
                }
                int iZzn = this.zza.zzn();
                zzX(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zztsVar.zzf(this.zza.zzo());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            do {
                zztsVar.zzf(this.zza.zzo());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                int iZzn2 = this.zza.zzn();
                zzX(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzo()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzo()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzB(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzsq) {
            zzsq zzsqVar = (zzsq) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzn = this.zza.zzn();
                zzW(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzsqVar.zzf(this.zza.zzc());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i != 5) {
                throw zzti.zza();
            }
            do {
                zzsqVar.zzf(this.zza.zzc());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZzn2 = this.zza.zzn();
                zzW(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Float.valueOf(this.zza.zzc()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            if (i2 != 5) {
                throw zzti.zza();
            }
            do {
                list.add(Float.valueOf(this.zza.zzc()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    @Deprecated
    public final void zzC(List list, zzuq zzuqVar, zzsj zzsjVar) throws zzth {
        int iZzm;
        int i = this.zzb;
        if ((i & 7) != 3) {
            throw zzti.zza();
        }
        do {
            Object objZze = zzuqVar.zze();
            zzS(objZze, zzuqVar, zzsjVar);
            zzuqVar.zzf(objZze);
            list.add(objZze);
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == i);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzD(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzsz) {
            zzsz zzszVar = (zzsz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar = this.zza;
                int iZzd = zzrwVar.zzd() + zzrwVar.zzn();
                do {
                    zzszVar.zzh(this.zza.zzh());
                } while (this.zza.zzd() < iZzd);
                zzU(iZzd);
                return;
            }
            do {
                zzszVar.zzh(this.zza.zzh());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar2 = this.zza;
                int iZzd2 = zzrwVar2.zzd() + zzrwVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzh()));
                } while (this.zza.zzd() < iZzd2);
                zzU(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzh()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzE(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzts) {
            zzts zztsVar = (zzts) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar = this.zza;
                int iZzd = zzrwVar.zzd() + zzrwVar.zzn();
                do {
                    zztsVar.zzf(this.zza.zzp());
                } while (this.zza.zzd() < iZzd);
                zzU(iZzd);
                return;
            }
            do {
                zztsVar.zzf(this.zza.zzp());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar2 = this.zza;
                int iZzd2 = zzrwVar2.zzd() + zzrwVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzp()));
                } while (this.zza.zzd() < iZzd2);
                zzU(iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzp()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r8.put(r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005f, code lost:
    
        r7.zza.zzA(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0064, code lost:
    
        return;
     */
    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zzF(Map map, zztw zztwVar, zzsj zzsjVar) throws zzth {
        zzV(2);
        zzrw zzrwVar = this.zza;
        int iZze = zzrwVar.zze(zzrwVar.zzn());
        Object objZzQ = zztwVar.zzd;
        Object objZzQ2 = zztwVar.zzb;
        while (true) {
            try {
                int iZzc = zzc();
                if (iZzc == Integer.MAX_VALUE || this.zza.zzC()) {
                    break;
                }
                if (iZzc == 1) {
                    objZzQ2 = zzQ(zztwVar.zza, null, null);
                } else if (iZzc != 2) {
                    try {
                        if (!zzP()) {
                            throw new zzti("Unable to parse map entry.");
                        }
                    } catch (zzth unused) {
                        if (!zzP()) {
                            throw new zzti("Unable to parse map entry.");
                        }
                    }
                } else {
                    objZzQ = zzQ(zztwVar.zzc, zztwVar.zzd.getClass(), zzsjVar);
                }
            } catch (Throwable th) {
                this.zza.zzA(iZze);
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzG(List list, zzuq zzuqVar, zzsj zzsjVar) throws zzth {
        int iZzm;
        int i = this.zzb;
        if ((i & 7) != 2) {
            throw zzti.zza();
        }
        do {
            list.add(zzR(zzuqVar, zzsjVar));
            if (this.zza.zzC() || this.zzd != 0) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == i);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzH(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzsz) {
            zzsz zzszVar = (zzsz) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzn = this.zza.zzn();
                zzW(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzszVar.zzh(this.zza.zzk());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i != 5) {
                throw zzti.zza();
            }
            do {
                zzszVar.zzh(this.zza.zzk());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZzn2 = this.zza.zzn();
                zzW(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzk()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            if (i2 != 5) {
                throw zzti.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzk()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzI(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzts) {
            zzts zztsVar = (zzts) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzti.zza();
                }
                int iZzn = this.zza.zzn();
                zzX(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zztsVar.zzf(this.zza.zzt());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            do {
                zztsVar.zzf(this.zza.zzt());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                int iZzn2 = this.zza.zzn();
                zzX(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Long.valueOf(this.zza.zzt()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzt()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzJ(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzsz) {
            zzsz zzszVar = (zzsz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar = this.zza;
                int iZzd = zzrwVar.zzd() + zzrwVar.zzn();
                do {
                    zzszVar.zzh(this.zza.zzl());
                } while (this.zza.zzd() < iZzd);
                zzU(iZzd);
                return;
            }
            do {
                zzszVar.zzh(this.zza.zzl());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar2 = this.zza;
                int iZzd2 = zzrwVar2.zzd() + zzrwVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzl()));
                } while (this.zza.zzd() < iZzd2);
                zzU(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzl()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzK(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzts) {
            zzts zztsVar = (zzts) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar = this.zza;
                int iZzd = zzrwVar.zzd() + zzrwVar.zzn();
                do {
                    zztsVar.zzf(this.zza.zzu());
                } while (this.zza.zzd() < iZzd);
                zzU(iZzd);
                return;
            }
            do {
                zztsVar.zzf(this.zza.zzu());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar2 = this.zza;
                int iZzd2 = zzrwVar2.zzd() + zzrwVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzu()));
                } while (this.zza.zzd() < iZzd2);
                zzU(iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzu()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    public final void zzL(List list, boolean z) throws zzth {
        int iZzm;
        int iZzm2;
        if ((this.zzb & 7) != 2) {
            throw zzti.zza();
        }
        if ((list instanceof zztp) && !z) {
            zztp zztpVar = (zztp) list;
            do {
                zzp();
                zztpVar.zza();
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            do {
                list.add(z ? zzs() : zzr());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzM(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzsz) {
            zzsz zzszVar = (zzsz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar = this.zza;
                int iZzd = zzrwVar.zzd() + zzrwVar.zzn();
                do {
                    zzszVar.zzh(this.zza.zzn());
                } while (this.zza.zzd() < iZzd);
                zzU(iZzd);
                return;
            }
            do {
                zzszVar.zzh(this.zza.zzn());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar2 = this.zza;
                int iZzd2 = zzrwVar2.zzd() + zzrwVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzn()));
                } while (this.zza.zzd() < iZzd2);
                zzU(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzn()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzN(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzts) {
            zzts zztsVar = (zzts) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar = this.zza;
                int iZzd = zzrwVar.zzd() + zzrwVar.zzn();
                do {
                    zztsVar.zzf(this.zza.zzv());
                } while (this.zza.zzd() < iZzd);
                zzU(iZzd);
                return;
            }
            do {
                zztsVar.zzf(this.zza.zzv());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar2 = this.zza;
                int iZzd2 = zzrwVar2.zzd() + zzrwVar2.zzn();
                do {
                    list.add(Long.valueOf(this.zza.zzv()));
                } while (this.zza.zzd() < iZzd2);
                zzU(iZzd2);
                return;
            }
            do {
                list.add(Long.valueOf(this.zza.zzv()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final boolean zzO() throws zzth {
        zzV(0);
        return this.zza.zzD();
    }

    public final boolean zzP() {
        int i;
        if (this.zza.zzC() || (i = this.zzb) == this.zzc) {
            return false;
        }
        return this.zza.zzE(i);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final double zza() throws zzth {
        zzV(1);
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final float zzb() throws zzth {
        zzV(5);
        return this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final int zzc() {
        int iZzm = this.zzd;
        if (iZzm != 0) {
            this.zzb = iZzm;
            this.zzd = 0;
        } else {
            iZzm = this.zza.zzm();
            this.zzb = iZzm;
        }
        if (iZzm == 0 || iZzm == this.zzc) {
            return Integer.MAX_VALUE;
        }
        return iZzm >>> 3;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final int zze() throws zzth {
        zzV(0);
        return this.zza.zzf();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final int zzf() throws zzth {
        zzV(5);
        return this.zza.zzg();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final int zzg() throws zzth {
        zzV(0);
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final int zzh() throws zzth {
        zzV(5);
        return this.zza.zzk();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final int zzi() throws zzth {
        zzV(0);
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final int zzj() throws zzth {
        zzV(0);
        return this.zza.zzn();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final long zzk() throws zzth {
        zzV(1);
        return this.zza.zzo();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final long zzl() throws zzth {
        zzV(0);
        return this.zza.zzp();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final long zzm() throws zzth {
        zzV(1);
        return this.zza.zzt();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final long zzn() throws zzth {
        zzV(0);
        return this.zza.zzu();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final long zzo() throws zzth {
        zzV(0);
        return this.zza.zzv();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final zzrq zzp() throws zzth {
        zzV(2);
        return this.zza.zzw();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final String zzr() throws zzth {
        zzV(2);
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final String zzs() throws zzth {
        zzV(2);
        return this.zza.zzy();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzt(Object obj, zzuq zzuqVar, zzsj zzsjVar) throws zzth {
        zzV(3);
        zzS(obj, zzuqVar, zzsjVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzu(Object obj, zzuq zzuqVar, zzsj zzsjVar) throws zzti {
        zzV(2);
        zzT(obj, zzuqVar, zzsjVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzv(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzrg) {
            zzrg zzrgVar = (zzrg) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar = this.zza;
                int iZzd = zzrwVar.zzd() + zzrwVar.zzn();
                do {
                    zzrgVar.zze(this.zza.zzD());
                } while (this.zza.zzd() < iZzd);
                zzU(iZzd);
                return;
            }
            do {
                zzrgVar.zze(this.zza.zzD());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar2 = this.zza;
                int iZzd2 = zzrwVar2.zzd() + zzrwVar2.zzn();
                do {
                    list.add(Boolean.valueOf(this.zza.zzD()));
                } while (this.zza.zzd() < iZzd2);
                zzU(iZzd2);
                return;
            }
            do {
                list.add(Boolean.valueOf(this.zza.zzD()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzw(List list) throws zzth {
        int iZzm;
        if ((this.zzb & 7) != 2) {
            throw zzti.zza();
        }
        do {
            list.add(zzp());
            if (this.zza.zzC()) {
                return;
            } else {
                iZzm = this.zza.zzm();
            }
        } while (iZzm == this.zzb);
        this.zzd = iZzm;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzx(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzsd) {
            zzsd zzsdVar = (zzsd) list;
            int i = this.zzb & 7;
            if (i != 1) {
                if (i != 2) {
                    throw zzti.zza();
                }
                int iZzn = this.zza.zzn();
                zzX(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzsdVar.zzf(this.zza.zzb());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            do {
                zzsdVar.zzf(this.zza.zzb());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 1) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                int iZzn2 = this.zza.zzn();
                zzX(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Double.valueOf(this.zza.zzb()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            do {
                list.add(Double.valueOf(this.zza.zzb()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzy(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzsz) {
            zzsz zzszVar = (zzsz) list;
            int i = this.zzb & 7;
            if (i != 0) {
                if (i != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar = this.zza;
                int iZzd = zzrwVar.zzd() + zzrwVar.zzn();
                do {
                    zzszVar.zzh(this.zza.zzf());
                } while (this.zza.zzd() < iZzd);
                zzU(iZzd);
                return;
            }
            do {
                zzszVar.zzh(this.zza.zzf());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 != 0) {
                if (i2 != 2) {
                    throw zzti.zza();
                }
                zzrw zzrwVar2 = this.zza;
                int iZzd2 = zzrwVar2.zzd() + zzrwVar2.zzn();
                do {
                    list.add(Integer.valueOf(this.zza.zzf()));
                } while (this.zza.zzd() < iZzd2);
                zzU(iZzd2);
                return;
            }
            do {
                list.add(Integer.valueOf(this.zza.zzf()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzup
    public final void zzz(List list) throws zzti {
        int iZzm;
        int iZzm2;
        if (list instanceof zzsz) {
            zzsz zzszVar = (zzsz) list;
            int i = this.zzb & 7;
            if (i == 2) {
                int iZzn = this.zza.zzn();
                zzW(iZzn);
                int iZzd = this.zza.zzd() + iZzn;
                do {
                    zzszVar.zzh(this.zza.zzg());
                } while (this.zza.zzd() < iZzd);
                return;
            }
            if (i != 5) {
                throw zzti.zza();
            }
            do {
                zzszVar.zzh(this.zza.zzg());
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm2 = this.zza.zzm();
                }
            } while (iZzm2 == this.zzb);
        } else {
            int i2 = this.zzb & 7;
            if (i2 == 2) {
                int iZzn2 = this.zza.zzn();
                zzW(iZzn2);
                int iZzd2 = this.zza.zzd() + iZzn2;
                do {
                    list.add(Integer.valueOf(this.zza.zzg()));
                } while (this.zza.zzd() < iZzd2);
                return;
            }
            if (i2 != 5) {
                throw zzti.zza();
            }
            do {
                list.add(Integer.valueOf(this.zza.zzg()));
                if (this.zza.zzC()) {
                    return;
                } else {
                    iZzm = this.zza.zzm();
                }
            } while (iZzm == this.zzb);
            iZzm2 = iZzm;
        }
        this.zzd = iZzm2;
    }
}
