package com.google.android.gms.internal.meet_coactivities;

import com.google.common.primitives.Ints;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@NotThreadSafe
final class zzacm extends InputStream {

    @Nullable
    private byte[][] zza;

    @Nullable
    private byte[] zzb;
    private int zzc;
    private int zzd;
    private int zze;
    private boolean zzf;

    public zzacm(byte[] bArr) {
        this.zza = null;
        int length = bArr.length;
        this.zzb = length <= 0 ? null : bArr;
        this.zze = length;
    }

    private final void zza() {
        int i = this.zzc + 1;
        this.zzc = i;
        this.zzd = 0;
        byte[][] bArr = this.zza;
        if (bArr == null || i >= bArr.length) {
            this.zzb = null;
        } else {
            this.zzb = bArr[i];
        }
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.zze;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.zzf) {
            return;
        }
        this.zzf = true;
        byte[][] bArr = this.zza;
        if (bArr != null) {
            for (byte[] bArr2 : bArr) {
                zzacn.zza(bArr2);
            }
        } else {
            byte[] bArr3 = this.zzb;
            if (bArr3 != null) {
                zzacn.zza(bArr3);
            }
        }
        this.zzb = null;
        this.zza = null;
    }

    @Override // java.io.InputStream
    public final int read() {
        byte[] bArr = this.zzb;
        if (bArr == null) {
            return -1;
        }
        int i = this.zzd;
        int i2 = i + 1;
        this.zzd = i2;
        byte b = bArr[i];
        this.zze--;
        if (i2 == bArr.length) {
            zza();
        }
        return b;
    }

    public zzacm(byte[][] bArr, int i) {
        this.zza = bArr;
        this.zze = i;
        if (bArr.length > 0) {
            this.zzb = bArr[0];
        }
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        int i4 = i2;
        while (true) {
            byte[] bArr2 = this.zzb;
            if (bArr2 == null) {
                break;
            }
            int iMin = Ints.min(i4, bArr2.length - this.zzd, this.zze);
            System.arraycopy(this.zzb, this.zzd, bArr, i, iMin);
            i += iMin;
            i4 -= iMin;
            this.zze -= iMin;
            if (i4 == 0) {
                int i5 = this.zzd + iMin;
                this.zzd = i5;
                if (i5 == this.zzb.length) {
                    zza();
                }
            } else {
                zza();
            }
        }
        int i6 = i2 - i4;
        if (i6 > 0 || this.zze > 0) {
            return i6;
        }
        return -1;
    }
}
