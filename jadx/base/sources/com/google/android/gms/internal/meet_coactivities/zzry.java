package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzry extends zzsb {
    private final byte[] zzc;
    private final int zzd;
    private int zze;

    public zzry(byte[] bArr, int i, int i2) {
        super(null);
        if (bArr == null) {
            throw new NullPointerException("buffer");
        }
        int i4 = i + i2;
        int length = bArr.length;
        if ((i | i2 | (length - i4)) < 0) {
            throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(length), Integer.valueOf(i), Integer.valueOf(i2)));
        }
        this.zzc = bArr;
        this.zze = i;
        this.zzd = i4;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final int zza() {
        return this.zzd - this.zze;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzb(byte b) throws zzrz {
        try {
            byte[] bArr = this.zzc;
            int i = this.zze;
            this.zze = i + 1;
            bArr[i] = b;
        } catch (IndexOutOfBoundsException e) {
            throw new zzrz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
        }
    }

    public final void zzc(byte[] bArr, int i, int i2) {
        try {
            System.arraycopy(bArr, 0, this.zzc, this.zze, i2);
            this.zze += i2;
        } catch (IndexOutOfBoundsException e) {
            throw new zzrz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), Integer.valueOf(i2)), e);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzd(int i, boolean z) throws zzrz {
        zzs(i << 3);
        zzb(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zze(int i, zzrq zzrqVar) {
        zzs((i << 3) | 2);
        zzf(zzrqVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzf(zzrq zzrqVar) {
        zzs(zzrqVar.zzd());
        zzrqVar.zzh(this);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzg(int i, int i2) throws zzrz {
        zzs((i << 3) | 5);
        zzh(i2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzh(int i) throws zzrz {
        try {
            byte[] bArr = this.zzc;
            int i2 = this.zze;
            int i4 = i2 + 1;
            this.zze = i4;
            bArr[i2] = (byte) (i & 255);
            int i5 = i2 + 2;
            this.zze = i5;
            bArr[i4] = (byte) ((i >> 8) & 255);
            int i6 = i2 + 3;
            this.zze = i6;
            bArr[i5] = (byte) ((i >> 16) & 255);
            this.zze = i2 + 4;
            bArr[i6] = (byte) ((i >> 24) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzrz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzi(int i, long j) throws zzrz {
        zzs((i << 3) | 1);
        zzj(j);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzj(long j) throws zzrz {
        try {
            byte[] bArr = this.zzc;
            int i = this.zze;
            int i2 = i + 1;
            this.zze = i2;
            bArr[i] = (byte) (((int) j) & 255);
            int i4 = i + 2;
            this.zze = i4;
            bArr[i2] = (byte) (((int) (j >> 8)) & 255);
            int i5 = i + 3;
            this.zze = i5;
            bArr[i4] = (byte) (((int) (j >> 16)) & 255);
            int i6 = i + 4;
            this.zze = i6;
            bArr[i5] = (byte) (((int) (j >> 24)) & 255);
            int i7 = i + 5;
            this.zze = i7;
            bArr[i6] = (byte) (((int) (j >> 32)) & 255);
            int i8 = i + 6;
            this.zze = i8;
            bArr[i7] = (byte) (((int) (j >> 40)) & 255);
            int i9 = i + 7;
            this.zze = i9;
            bArr[i8] = (byte) (((int) (j >> 48)) & 255);
            this.zze = i + 8;
            bArr[i9] = (byte) (((int) (j >> 56)) & 255);
        } catch (IndexOutOfBoundsException e) {
            throw new zzrz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzk(int i, int i2) throws zzrz {
        zzs(i << 3);
        zzl(i2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzl(int i) throws zzrz {
        if (i >= 0) {
            zzs(i);
        } else {
            zzu(i);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzm(byte[] bArr, int i, int i2) {
        zzc(bArr, 0, i2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzn(zzue zzueVar) {
        zzs(zzueVar.zzz());
        zzueVar.zzS(this);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzo(int i, String str) throws zzrz {
        zzs((i << 3) | 2);
        zzp(str);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzp(String str) throws zzrz {
        int i = this.zze;
        try {
            int iZzz = zzsb.zzz(str.length() * 3);
            int iZzz2 = zzsb.zzz(str.length());
            if (iZzz2 != iZzz) {
                zzs(zzvo.zzc(str));
                byte[] bArr = this.zzc;
                int i2 = this.zze;
                this.zze = zzvo.zzb(str, bArr, i2, this.zzd - i2);
                return;
            }
            int i4 = i + iZzz2;
            this.zze = i4;
            int iZzb = zzvo.zzb(str, this.zzc, i4, this.zzd - i4);
            this.zze = i;
            zzs((iZzb - i) - iZzz2);
            this.zze = iZzb;
        } catch (zzvn e) {
            this.zze = i;
            zzD(str, e);
        } catch (IndexOutOfBoundsException e2) {
            throw new zzrz(e2);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzq(int i, int i2) {
        zzs((i << 3) | i2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzr(int i, int i2) {
        zzs(i << 3);
        zzs(i2);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzs(int i) {
        while ((i & (-128)) != 0) {
            try {
                byte[] bArr = this.zzc;
                int i2 = this.zze;
                this.zze = i2 + 1;
                bArr[i2] = (byte) ((i | 128) & 255);
                i >>>= 7;
            } catch (IndexOutOfBoundsException e) {
                throw new zzrz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
            }
        }
        byte[] bArr2 = this.zzc;
        int i4 = this.zze;
        this.zze = i4 + 1;
        bArr2[i4] = (byte) i;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzt(int i, long j) throws zzrz {
        zzs(i << 3);
        zzu(j);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzsb
    public final void zzu(long j) throws zzrz {
        if (!zzsb.zzd || this.zzd - this.zze < 10) {
            while ((j & (-128)) != 0) {
                try {
                    byte[] bArr = this.zzc;
                    int i = this.zze;
                    this.zze = i + 1;
                    bArr[i] = (byte) ((((int) j) | 128) & 255);
                    j >>>= 7;
                } catch (IndexOutOfBoundsException e) {
                    throw new zzrz(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.zze), Integer.valueOf(this.zzd), 1), e);
                }
            }
            byte[] bArr2 = this.zzc;
            int i2 = this.zze;
            this.zze = i2 + 1;
            bArr2[i2] = (byte) j;
            return;
        }
        while (true) {
            int i4 = (int) j;
            if ((j & (-128)) == 0) {
                byte[] bArr3 = this.zzc;
                int i5 = this.zze;
                this.zze = i5 + 1;
                zzvl.zzn(bArr3, i5, (byte) i4);
                return;
            }
            byte[] bArr4 = this.zzc;
            int i6 = this.zze;
            this.zze = i6 + 1;
            zzvl.zzn(bArr4, i6, (byte) ((i4 | 128) & 255));
            j >>>= 7;
        }
    }
}
