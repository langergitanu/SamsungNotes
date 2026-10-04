package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzru extends zzrw {
    private final InputStream zzf;
    private final byte[] zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;

    public /* synthetic */ zzru(InputStream inputStream, int i, zzrt zzrtVar) {
        super(null);
        this.zzm = Integer.MAX_VALUE;
        byte[] bArr = zztg.zzb;
        this.zzf = inputStream;
        this.zzg = new byte[4096];
        this.zzh = 0;
        this.zzj = 0;
        this.zzl = 0;
    }

    private final List zzL(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i4 = this.zzf.read(bArr, i2, iMin - i2);
                if (i4 == -1) {
                    throw zzti.zzi();
                }
                this.zzl += i4;
                i2 += i4;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzM() {
        int i = this.zzh + this.zzi;
        this.zzh = i;
        int i2 = this.zzl + i;
        int i4 = this.zzm;
        if (i2 <= i4) {
            this.zzi = 0;
            return;
        }
        int i5 = i2 - i4;
        this.zzi = i5;
        this.zzh = i - i5;
    }

    private final void zzN(int i) throws zzti {
        if (zzO(i)) {
            return;
        }
        if (i <= (this.zzc - this.zzl) - this.zzj) {
            throw zzti.zzi();
        }
        throw zzti.zzh();
    }

    private final boolean zzO(int i) throws IOException {
        int i2 = this.zzj;
        int i4 = i2 + i;
        int i5 = this.zzh;
        if (i4 <= i5) {
            throw new IllegalStateException(AbstractC0541b.m767i(i, "refillBuffer() called when ", " bytes were already available in buffer"));
        }
        int i6 = this.zzc;
        int i7 = this.zzl;
        if (i > (i6 - i7) - i2 || i7 + i2 + i > this.zzm) {
            return false;
        }
        if (i2 > 0) {
            if (i5 > i2) {
                byte[] bArr = this.zzg;
                System.arraycopy(bArr, i2, bArr, 0, i5 - i2);
            }
            i7 = this.zzl + i2;
            this.zzl = i7;
            i5 = this.zzh - i2;
            this.zzh = i5;
            this.zzj = 0;
        }
        try {
            int i8 = this.zzf.read(this.zzg, i5, Math.min(4096 - i5, (this.zzc - i7) - i5));
            if (i8 == 0 || i8 < -1 || i8 > 4096) {
                throw new IllegalStateException(String.valueOf(this.zzf.getClass()) + "#read(byte[]) returned invalid result: " + i8 + "\nThe InputStream implementation is buggy.");
            }
            if (i8 <= 0) {
                return false;
            }
            this.zzh += i8;
            zzM();
            if (this.zzh >= i) {
                return true;
            }
            return zzO(i);
        } catch (zzti e) {
            e.zzj();
            throw e;
        }
    }

    private final byte[] zzP(int i, boolean z) throws IOException {
        byte[] bArrZzQ = zzQ(i);
        if (bArrZzQ != null) {
            return bArrZzQ;
        }
        int i2 = this.zzj;
        int i4 = this.zzh;
        int i5 = i4 - i2;
        this.zzl += i4;
        this.zzj = 0;
        this.zzh = 0;
        List<byte[]> listZzL = zzL(i - i5);
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzg, i2, bArr, 0, i5);
        for (byte[] bArr2 : listZzL) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i5, length);
            i5 += length;
        }
        return bArr;
    }

    private final byte[] zzQ(int i) throws IOException {
        if (i == 0) {
            return zztg.zzb;
        }
        int i2 = this.zzl;
        int i4 = this.zzj;
        int i5 = i2 + i4 + i;
        if (i5 - this.zzc > 0) {
            throw zzti.zzh();
        }
        int i6 = this.zzm;
        if (i5 > i6) {
            zzB((i6 - i2) - i4);
            throw zzti.zzi();
        }
        int i7 = this.zzh - i4;
        int i8 = i - i7;
        if (i8 >= 4096) {
            try {
                if (i8 > this.zzf.available()) {
                    return null;
                }
            } catch (zzti e) {
                e.zzj();
                throw e;
            }
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.zzg, i4, bArr, 0, i7);
        this.zzl += this.zzh;
        this.zzj = 0;
        this.zzh = 0;
        while (i7 < i) {
            try {
                int i9 = this.zzf.read(bArr, i7, i - i7);
                if (i9 == -1) {
                    throw zzti.zzi();
                }
                this.zzl += i9;
                i7 += i9;
            } catch (zzti e2) {
                e2.zzj();
                throw e2;
            }
        }
        return bArr;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final void zzA(int i) {
        this.zzm = i;
        zzM();
    }

    public final void zzB(int i) throws zzti {
        int i2 = this.zzh;
        int i4 = this.zzj;
        int i5 = i2 - i4;
        if (i <= i5 && i >= 0) {
            this.zzj = i4 + i;
            return;
        }
        if (i < 0) {
            throw zzti.zzf();
        }
        int i6 = this.zzl;
        int i7 = i6 + i4;
        int i8 = this.zzm;
        if (i7 + i > i8) {
            zzB((i8 - i6) - i4);
            throw zzti.zzi();
        }
        this.zzl = i7;
        this.zzh = 0;
        this.zzj = 0;
        while (i5 < i) {
            try {
                long j = i - i5;
                try {
                    long jSkip = this.zzf.skip(j);
                    if (jSkip < 0 || jSkip > j) {
                        throw new IllegalStateException(String.valueOf(this.zzf.getClass()) + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                    }
                    if (jSkip == 0) {
                        break;
                    } else {
                        i5 += (int) jSkip;
                    }
                } catch (zzti e) {
                    e.zzj();
                    throw e;
                }
            } catch (Throwable th) {
                this.zzl += i5;
                zzM();
                throw th;
            }
        }
        this.zzl += i5;
        zzM();
        if (i5 >= i) {
            return;
        }
        int i9 = this.zzh;
        int i10 = i9 - this.zzj;
        this.zzj = i9;
        zzN(1);
        while (true) {
            int i11 = i - i10;
            int i12 = this.zzh;
            if (i11 <= i12) {
                this.zzj = i11;
                return;
            } else {
                i10 += i12;
                this.zzj = i12;
                zzN(1);
            }
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final boolean zzC() {
        return this.zzj == this.zzh && !zzO(1);
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
            if (this.zzh - this.zzj < 10) {
                while (i4 < 10) {
                    if (zza() < 0) {
                        i4++;
                    }
                }
                throw zzti.zze();
            }
            while (i4 < 10) {
                byte[] bArr = this.zzg;
                int i5 = this.zzj;
                this.zzj = i5 + 1;
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
        if (this.zzj == this.zzh) {
            zzN(1);
        }
        byte[] bArr = this.zzg;
        int i = this.zzj;
        this.zzj = i + 1;
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
        return this.zzl + this.zzj;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final int zze(int i) throws zzti {
        if (i < 0) {
            throw zzti.zzf();
        }
        int i2 = this.zzl + this.zzj + i;
        if (i2 < 0) {
            throw zzti.zzg();
        }
        int i4 = this.zzm;
        if (i2 > i4) {
            throw zzti.zzi();
        }
        this.zzm = i2;
        zzM();
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
        int i = this.zzj;
        if (this.zzh - i < 4) {
            zzN(4);
            i = this.zzj;
        }
        byte[] bArr = this.zzg;
        this.zzj = i + 4;
        int i2 = bArr[i] & 255;
        int i4 = bArr[i + 1] & 255;
        int i5 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i4 << 8) | i2 | (i5 << 16);
    }

    public final int zzj() {
        int i;
        int i2 = this.zzj;
        int i4 = this.zzh;
        if (i4 != i2) {
            byte[] bArr = this.zzg;
            int i5 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.zzj = i5;
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
                this.zzj = i6;
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
            this.zzk = 0;
            return 0;
        }
        int iZzj = zzj();
        this.zzk = iZzj;
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
        int i = this.zzj;
        if (this.zzh - i < 8) {
            zzN(8);
            i = this.zzj;
        }
        byte[] bArr = this.zzg;
        this.zzj = i + 8;
        long j = bArr[i];
        long j2 = (((long) bArr[i + 1]) & 255) << 8;
        long j3 = bArr[i + 2];
        long j5 = bArr[i + 3];
        return ((((long) bArr[i + 6]) & 255) << 48) | (j & 255) | j2 | ((j3 & 255) << 16) | ((j5 & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public final long zzr() {
        long j;
        long j2;
        int i = this.zzj;
        int i2 = this.zzh;
        if (i2 != i) {
            byte[] bArr = this.zzg;
            int i4 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.zzj = i4;
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
                this.zzj = i5;
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
    public final zzrq zzw() throws IOException {
        int iZzj = zzj();
        int i = this.zzh;
        int i2 = this.zzj;
        if (iZzj <= i - i2 && iZzj > 0) {
            zzrq zzrqVarZzk = zzrq.zzk(this.zzg, i2, iZzj);
            this.zzj += iZzj;
            return zzrqVarZzk;
        }
        if (iZzj == 0) {
            return zzrq.zzb;
        }
        if (iZzj < 0) {
            throw zzti.zzf();
        }
        byte[] bArrZzQ = zzQ(iZzj);
        if (bArrZzQ != null) {
            return zzrq.zzk(bArrZzQ, 0, bArrZzQ.length);
        }
        int i4 = this.zzj;
        int i5 = this.zzh;
        int i6 = i5 - i4;
        this.zzl += i5;
        this.zzj = 0;
        this.zzh = 0;
        List<byte[]> listZzL = zzL(iZzj - i6);
        byte[] bArr = new byte[iZzj];
        System.arraycopy(this.zzg, i4, bArr, 0, i6);
        for (byte[] bArr2 : listZzL) {
            int length = bArr2.length;
            System.arraycopy(bArr2, 0, bArr, i6, length);
            i6 += length;
        }
        return new zzrp(bArr);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final String zzx() throws zzti {
        int iZzj = zzj();
        if (iZzj > 0) {
            int i = this.zzh;
            int i2 = this.zzj;
            if (iZzj <= i - i2) {
                String str = new String(this.zzg, i2, iZzj, zztg.zza);
                this.zzj += iZzj;
                return str;
            }
        }
        if (iZzj == 0) {
            return "";
        }
        if (iZzj < 0) {
            throw zzti.zzf();
        }
        if (iZzj > this.zzh) {
            return new String(zzP(iZzj, false), zztg.zza);
        }
        zzN(iZzj);
        String str2 = new String(this.zzg, this.zzj, iZzj, zztg.zza);
        this.zzj += iZzj;
        return str2;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final String zzy() throws IOException {
        byte[] bArrZzP;
        int iZzj = zzj();
        int i = this.zzj;
        int i2 = this.zzh;
        if (iZzj <= i2 - i && iZzj > 0) {
            bArrZzP = this.zzg;
            this.zzj = i + iZzj;
        } else {
            if (iZzj == 0) {
                return "";
            }
            if (iZzj < 0) {
                throw zzti.zzf();
            }
            i = 0;
            if (iZzj <= i2) {
                zzN(iZzj);
                bArrZzP = this.zzg;
                this.zzj = iZzj;
            } else {
                bArrZzP = zzP(iZzj, false);
            }
        }
        return zzvo.zzd(bArrZzP, i, iZzj);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzrw
    public final void zzz(int i) throws zzti {
        if (this.zzk != i) {
            throw zzti.zzb();
        }
    }
}
