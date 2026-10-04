package com.google.android.gms.internal.fido;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzdr implements Comparable {
    private final zzdr zzc(Class cls) throws zzdq {
        if (cls.isInstance(this)) {
            return (zzdr) cls.cast(this);
        }
        throw new zzdq(AbstractC0541b.m774p("Expected a ", cls.getName(), " value, but got ", getClass().getName()));
    }

    public static int zzd(byte b) {
        return (b >> 5) & 7;
    }

    public static zzdm zzg(long j) {
        return new zzdm(j);
    }

    public static zzdp zzi(String str) {
        return new zzdp(str);
    }

    public static zzdr zzj(byte... bArr) {
        bArr.getClass();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Arrays.copyOf(bArr, bArr.length));
        return zzds.zza(byteArrayInputStream, new zzdu(byteArrayInputStream));
    }

    public static zzdr zzk(InputStream inputStream) {
        return zzds.zza(inputStream, new zzdu(inputStream));
    }

    public abstract int zza();

    public int zzb() {
        return 0;
    }

    public final zzdk zze() {
        return (zzdk) zzc(zzdk.class);
    }

    public final zzdm zzf() {
        return (zzdm) zzc(zzdm.class);
    }

    public final zzdo zzh() {
        return (zzdo) zzc(zzdo.class);
    }
}
