package com.google.android.gms.internal.meet_coactivities;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaoy extends InputStream {

    @Nullable
    private zzue zza;

    @Nullable
    private ByteArrayInputStream zzb;

    public zzaoy(zzue zzueVar, zzul zzulVar) {
        this.zza = zzueVar;
    }

    @Override // java.io.InputStream
    public final int available() {
        zzue zzueVar = this.zza;
        if (zzueVar != null) {
            return zzueVar.zzz();
        }
        ByteArrayInputStream byteArrayInputStream = this.zzb;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.available();
        }
        return 0;
    }

    @Override // java.io.InputStream
    public final int read() {
        zzue zzueVar = this.zza;
        if (zzueVar != null) {
            this.zzb = new ByteArrayInputStream(zzueVar.zzx());
            this.zza = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.zzb;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i2) {
        zzue zzueVar = this.zza;
        if (zzueVar != null) {
            int iZzz = zzueVar.zzz();
            if (iZzz == 0) {
                this.zza = null;
                this.zzb = null;
                return -1;
            }
            if (i2 >= iZzz) {
                zzsb zzsbVarZzB = zzsb.zzB(bArr, i, iZzz);
                this.zza.zzS(zzsbVarZzB);
                zzsbVarZzB.zzC();
                this.zza = null;
                this.zzb = null;
                return iZzz;
            }
            this.zzb = new ByteArrayInputStream(this.zza.zzx());
            this.zza = null;
        }
        ByteArrayInputStream byteArrayInputStream = this.zzb;
        if (byteArrayInputStream != null) {
            return byteArrayInputStream.read(bArr, i, i2);
        }
        return -1;
    }
}
