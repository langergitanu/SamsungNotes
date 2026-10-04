package com.google.android.gms.internal.fido;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.spr.drawable.document.attribute.SprAttributeBase;
import com.yubico.yubikit.core.fido.CtapException;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import kotlin.time.DurationKt;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdu implements Closeable {
    private final InputStream zza;
    private zzdt zzb;
    private final byte[] zzc = new byte[8];
    private final zzdv zzd = zzdv.zza();

    public zzdu(InputStream inputStream) {
        this.zza = inputStream;
    }

    private final long zzh() throws IOException {
        if (this.zzb.zza() < 24) {
            long jZza = this.zzb.zza();
            this.zzb = null;
            return jZza;
        }
        if (this.zzb.zza() == 24) {
            int i = this.zza.read();
            if (i == -1) {
                throw new EOFException();
            }
            this.zzb = null;
            return ((long) i) & 255;
        }
        if (this.zzb.zza() == 25) {
            zzk(this.zzc, 2);
            byte[] bArr = this.zzc;
            return ((((long) bArr[0]) & 255) << 8) | (((long) bArr[1]) & 255);
        }
        if (this.zzb.zza() == 26) {
            zzk(this.zzc, 4);
            byte[] bArr2 = this.zzc;
            long j = bArr2[0];
            long j2 = bArr2[1];
            return (((long) bArr2[3]) & 255) | ((j2 & 255) << 16) | ((j & 255) << 24) | ((bArr2[2] & 255) << 8);
        }
        if (this.zzb.zza() != 27) {
            throw new IOException(AbstractC1038a.m1214o(this.zzb.zza(), this.zzb.zzc(), "invalid additional information ", " for major type "));
        }
        zzk(this.zzc, 8);
        byte[] bArr3 = this.zzc;
        long j3 = bArr3[0];
        long j5 = bArr3[1];
        long j6 = bArr3[2];
        return (((long) bArr3[7]) & 255) | ((j6 & 255) << 40) | ((j3 & 255) << 56) | ((j5 & 255) << 48) | ((bArr3[3] & 255) << 32) | ((bArr3[4] & 255) << 24) | ((bArr3[5] & 255) << 16) | ((bArr3[6] & 255) << 8);
    }

    private final void zzi() {
        zzd();
        if (this.zzb.zza() == 31) {
            throw new IllegalStateException(AbstractC0000a.m11h(this.zzb.zza(), "expected definite length but found "));
        }
    }

    private final void zzj(byte b) {
        zzd();
        if (this.zzb.zzb() != b) {
            throw new IllegalStateException(AbstractC1038a.m1214o((b >> 5) & 7, this.zzb.zzc(), "expected major type ", " but found "));
        }
    }

    private final void zzk(byte[] bArr, int i) throws IOException {
        int i2 = 0;
        while (i2 != i) {
            int i4 = this.zza.read(bArr, i2, i - i2);
            if (i4 == -1) {
                throw new EOFException();
            }
            i2 += i4;
        }
        this.zzb = null;
    }

    private final byte[] zzl() throws IOException {
        zzi();
        long jZzh = zzh();
        if (jZzh < 0 || jZzh > 2147483647L) {
            throw new UnsupportedOperationException("the maximum supported byte/text string length is 2147483647 bytes");
        }
        if (this.zza.available() < jZzh) {
            throw new EOFException();
        }
        int i = (int) jZzh;
        byte[] bArr = new byte[i];
        zzk(bArr, i);
        return bArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zza.close();
        this.zzd.zzb();
    }

    public final long zza() {
        zzj((byte) -128);
        zzi();
        long jZzh = zzh();
        if (jZzh < 0) {
            throw new UnsupportedOperationException("the maximum supported array length is 9223372036854775807");
        }
        if (jZzh > 0) {
            this.zzd.zzg(jZzh);
        }
        return jZzh;
    }

    public final long zzb() {
        boolean z;
        zzd();
        if (this.zzb.zzb() == 0) {
            z = true;
        } else {
            if (this.zzb.zzb() != 32) {
                throw new IllegalStateException(AbstractC0000a.m11h(this.zzb.zzc(), "expected major type 0 or 1 but found "));
            }
            z = false;
        }
        long jZzh = zzh();
        if (jZzh >= 0) {
            return z ? jZzh : ~jZzh;
        }
        throw new UnsupportedOperationException("the maximum supported unsigned/negative integer is 9223372036854775807");
    }

    public final long zzc() {
        zzj((byte) -96);
        zzi();
        long jZzh = zzh();
        if (jZzh < 0 || jZzh > DurationKt.MAX_MILLIS) {
            throw new UnsupportedOperationException("the maximum supported map length is 4611686018427387903L");
        }
        if (jZzh > 0) {
            this.zzd.zzg(jZzh + jZzh);
        }
        return jZzh;
    }

    public final zzdt zzd() {
        if (this.zzb == null) {
            int i = this.zza.read();
            if (i == -1) {
                this.zzd.zzb();
                return null;
            }
            zzdt zzdtVar = new zzdt(i);
            this.zzb = zzdtVar;
            byte bZzb = zzdtVar.zzb();
            if (bZzb == -128 || bZzb == -96 || bZzb == -64) {
                this.zzd.zzd();
                this.zzd.zzf();
            } else {
                if (bZzb != -32) {
                    if (bZzb != 0 && bZzb != 32) {
                        if (bZzb == 64) {
                            this.zzd.zze(-1L);
                        } else {
                            if (bZzb != 96) {
                                throw new IllegalStateException(AbstractC0000a.m11h(this.zzb.zzc(), "invalid major type: "));
                            }
                            this.zzd.zze(-2L);
                        }
                    }
                    this.zzd.zzf();
                } else if (this.zzb.zza() == 31) {
                    this.zzd.zzc();
                }
                this.zzd.zzd();
                this.zzd.zzf();
            }
        }
        return this.zzb;
    }

    public final String zze() {
        zzj(SprAttributeBase.TYPE_DURATION);
        return new String(zzl(), StandardCharsets.UTF_8);
    }

    public final boolean zzf() {
        zzj(CtapException.ERR_EXTENSION_FIRST);
        if (this.zzb.zza() > 24) {
            throw new IllegalStateException("expected simple value");
        }
        int iZzh = (int) zzh();
        if (iZzh == 20) {
            return false;
        }
        if (iZzh == 21) {
            return true;
        }
        throw new IllegalStateException("expected FALSE or TRUE");
    }

    public final byte[] zzg() {
        zzj((byte) 64);
        return zzl();
    }
}
