package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
final class zzjq extends zzjo {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzoc;
    private int zzod;
    private int zzoe;
    private int zzof;

    private zzjq(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zzof = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzoe = i;
        this.zzoc = z;
    }

    @Override // com.google.android.gms.internal.drive.zzjo
    public final int zzbz() {
        return this.pos - this.zzoe;
    }

    @Override // com.google.android.gms.internal.drive.zzjo
    public final int zzv(int i) {
        if (i < 0) {
            throw zzkq.zzdj();
        }
        int iZzbz = i + zzbz();
        int i2 = this.zzof;
        if (iZzbz > i2) {
            throw zzkq.zzdi();
        }
        this.zzof = iZzbz;
        int i4 = this.limit + this.zzod;
        this.limit = i4;
        int i5 = i4 - this.zzoe;
        if (i5 <= iZzbz) {
            this.zzod = 0;
            return i2;
        }
        int i6 = i5 - iZzbz;
        this.zzod = i6;
        this.limit = i4 - i6;
        return i2;
    }
}
