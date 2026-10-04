package com.google.android.gms.internal.meet_coactivities;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzrs extends zzrw {
    private final byte[] zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    public /* synthetic */ zzrs(byte[] bArr, int i, int i2, boolean z, zzrr zzrrVar) {
        super(null);
        this.zzk = Integer.MAX_VALUE;
        this.zzf = bArr;
        this.zzg = i2;
        this.zzi = 0;
    }

    private final void zzL() {
        int i = this.zzg + this.zzh;
        this.zzg = i;
        int i2 = this.zzk;
        if (i <= i2) {
            this.zzh = 0;
            return;
        }
        int i4 = i - i2;
        this.zzh = i4;
        this.zzg = i - i4;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final void zzA(int i) {
        this.zzk = i;
        zzL();
    }

    public final void zzB(int i) throws zzti {
        if (i >= 0) {
            int i2 = this.zzg;
            int i4 = this.zzi;
            if (i <= i2 - i4) {
                this.zzi = i4 + i;
                return;
            }
        }
        if (i >= 0) {
            throw zzti.zzi();
        }
        throw zzti.zzf();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final boolean zzC() {
        return this.zzi == this.zzg;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final boolean zzD() {
        return zzr() != 0;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final boolean zzE(int i) throws zzti {
        int iZzm;
        int i2 = i & 7;
        int i4 = 0;
        if (i2 == 0) {
            if (this.zzg - this.zzi < 10) {
                while (i4 < 10) {
                    if (zza() < 0) {
                        i4++;
                    }
                }
                throw zzti.zze();
            }
            while (i4 < 10) {
                byte[] bArr = this.zzf;
                int i5 = this.zzi;
                this.zzi = i5 + 1;
                if (bArr[i5] < 0) {
                    i4++;
                }
            }
            throw zzti.zze();
            return true;
        }
        if (i2 == 1) {
            zzB(8);
            return true;
        }
        if (i2 == 2) {
            zzB(zzj());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzti.zza();
            }
            zzB(4);
            return true;
        }
        do {
            iZzm = zzm();
            if (iZzm == 0) {
                break;
            }
        } while (zzE(iZzm));
        zzz(((i >>> 3) << 3) | 4);
        return true;
    }

    public final byte zza() throws zzti {
        int i = this.zzi;
        if (i == this.zzg) {
            throw zzti.zzi();
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 1;
        return bArr[i];
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final double zzb() {
        return Double.longBitsToDouble(zzq());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final float zzc() {
        return Float.intBitsToFloat(zzi());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final int zzd() {
        return this.zzi;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final int zze(int i) throws zzti {
        if (i < 0) {
            throw zzti.zzf();
        }
        int i2 = i + this.zzi;
        if (i2 < 0) {
            throw zzti.zzg();
        }
        int i4 = this.zzk;
        if (i2 > i4) {
            throw zzti.zzi();
        }
        this.zzk = i2;
        zzL();
        return i4;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final int zzf() {
        return zzj();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final int zzg() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final int zzh() {
        return zzj();
    }

    public final int zzi() throws zzti {
        int i = this.zzi;
        if (this.zzg - i < 4) {
            throw zzti.zzi();
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 4;
        int i2 = bArr[i] & 255;
        int i4 = bArr[i + 1] & 255;
        int i5 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i4 << 8) | i2 | (i5 << 16);
    }

    public final int zzj() {
        int i;
        int i2 = this.zzi;
        int i4 = this.zzg;
        if (i4 != i2) {
            byte[] bArr = this.zzf;
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzi = i5;
                return b;
            }
            if (i4 - i5 >= 9) {
                int i6 = i2 + 2;
                int i7 = (bArr[i5] << 7) ^ b;
                if (i7 < 0) {
                    i = i7 ^ (-128);
                } else {
                    int i8 = i2 + 3;
                    int i9 = (bArr[i6] << 14) ^ i7;
                    if (i9 >= 0) {
                        i = i9 ^ 16256;
                    } else {
                        int i10 = i2 + 4;
                        int i11 = i9 ^ (bArr[i8] << 21);
                        if (i11 < 0) {
                            i = (-2080896) ^ i11;
                        } else {
                            i8 = i2 + 5;
                            byte b5 = bArr[i10];
                            int i12 = (i11 ^ (b5 << 28)) ^ 266354560;
                            if (b5 < 0) {
                                i10 = i2 + 6;
                                if (bArr[i8] < 0) {
                                    i8 = i2 + 7;
                                    if (bArr[i10] < 0) {
                                        i10 = i2 + 8;
                                        if (bArr[i8] < 0) {
                                            i8 = i2 + 9;
                                            if (bArr[i10] < 0) {
                                                int i13 = i2 + 10;
                                                if (bArr[i8] >= 0) {
                                                    i6 = i13;
                                                    i = i12;
                                                }
                                            }
                                        }
                                    }
                                }
                                i = i12;
                            }
                            i = i12;
                        }
                        i6 = i10;
                    }
                    i6 = i8;
                }
                this.zzi = i6;
                return i;
            }
        }
        return (int) zzs();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final int zzk() {
        return zzi();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final int zzl() {
        return zzrw.zzF(zzj());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final int zzm() throws zzti {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int iZzj = zzj();
        this.zzj = iZzj;
        if ((iZzj >>> 3) != 0) {
            return iZzj;
        }
        throw zzti.zzc();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final int zzn() {
        return zzj();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final long zzo() {
        return zzq();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final long zzp() {
        return zzr();
    }

    public final long zzq() throws zzti {
        int i = this.zzi;
        if (this.zzg - i < 8) {
            throw zzti.zzi();
        }
        byte[] bArr = this.zzf;
        this.zzi = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j5 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j5 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public final long zzr() {
        long j;
        long j2;
        int i = this.zzi;
        int i2 = this.zzg;
        if (i2 != i) {
            byte[] bArr = this.zzf;
            int i4 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzi = i4;
                return b;
            }
            if (i2 - i4 >= 9) {
                int i5 = i + 2;
                int i6 = (bArr[i4] << 7) ^ b;
                if (i6 < 0) {
                    j = i6 ^ (-128);
                } else {
                    int i7 = i + 3;
                    int i8 = (bArr[i5] << 14) ^ i6;
                    if (i8 >= 0) {
                        j = i8 ^ 16256;
                    } else {
                        int i9 = i + 4;
                        int i10 = i8 ^ (bArr[i7] << 21);
                        if (i10 < 0) {
                            long j3 = (-2080896) ^ i10;
                            i5 = i9;
                            j = j3;
                        } else {
                            i7 = i + 5;
                            long j5 = (((long) bArr[i9]) << 28) ^ ((long) i10);
                            if (j5 >= 0) {
                                j = j5 ^ 266354560;
                            } else {
                                i5 = i + 6;
                                long j6 = (((long) bArr[i7]) << 35) ^ j5;
                                if (j6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    int i11 = i + 7;
                                    long j7 = j6 ^ (((long) bArr[i5]) << 42);
                                    if (j7 >= 0) {
                                        j = j7 ^ 4363953127296L;
                                    } else {
                                        i5 = i + 8;
                                        j6 = j7 ^ (((long) bArr[i11]) << 49);
                                        if (j6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i11 = i + 9;
                                            long j8 = (j6 ^ (((long) bArr[i5]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                i5 = i + 10;
                                                if (bArr[i11] >= 0) {
                                                    j = j8;
                                                }
                                            } else {
                                                j = j8;
                                            }
                                        }
                                    }
                                    i5 = i11;
                                }
                                j = j6 ^ j2;
                            }
                        }
                    }
                    i5 = i7;
                }
                this.zzi = i5;
                return j;
            }
        }
        return zzs();
    }

    public final long zzs() throws zzti {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte bZza = zza();
            j |= ((long) (bZza & 127)) << i;
            if ((bZza & 128) == 0) {
                return j;
            }
        }
        throw zzti.zze();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final long zzt() {
        return zzq();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final long zzu() {
        return zzrw.zzH(zzr());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final long zzv() {
        return zzr();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final zzrq zzw() throws zzti {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzj <= i - i2) {
                zzrq zzrqVarZzk = zzrq.zzk(this.zzf, i2, iZzj);
                this.zzi += iZzj;
                return zzrqVarZzk;
            }
        }
        if (iZzj == 0) {
            return zzrq.zzb;
        }
        if (iZzj > 0) {
            int i4 = this.zzg;
            int i5 = this.zzi;
            if (iZzj <= i4 - i5) {
                int i6 = iZzj + i5;
                this.zzi = i6;
                return new zzrp(Arrays.copyOfRange(this.zzf, i5, i6));
            }
        }
        if (iZzj <= 0) {
            throw zzti.zzf();
        }
        throw zzti.zzi();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final String zzx() throws zzti {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzj <= i - i2) {
                String str = new String(this.zzf, i2, iZzj, zztg.zza);
                this.zzi += iZzj;
                return str;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj < 0) {
            throw zzti.zzf();
        }
        throw zzti.zzi();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final String zzy() throws zzti {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i = this.zzg;
            int i2 = this.zzi;
            if (iZzj <= i - i2) {
                String strZzd = zzvo.zzd(this.zzf, i2, iZzj);
                this.zzi += iZzj;
                return strZzd;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj <= 0) {
            throw zzti.zzf();
        }
        throw zzti.zzi();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final void zzz(int i) throws zzti {
        if (this.zzj != i) {
            throw zzti.zzb();
        }
    }
}
