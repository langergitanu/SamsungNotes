package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

/* JADX INFO: loaded from: classes5.dex */
final class zzkj implements zzlp {
    private static final zzkj zzrp = new zzkj();

    private zzkj() {
    }

    public static zzkj zzcv() {
        return zzrp;
    }

    @Override // com.google.android.gms.internal.drive.zzlp
    public final boolean zzb(Class<?> cls) {
        return zzkk.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.drive.zzlp
    public final zzlo zzc(Class<?> cls) {
        if (!zzkk.class.isAssignableFrom(cls)) {
            String name = cls.getName();
            throw new IllegalArgumentException(name.length() != 0 ? "Unsupported message type: ".concat(name) : new String("Unsupported message type: "));
        }
        try {
            return (zzlo) zzkk.zzd(cls.asSubclass(zzkk.class)).zza(zzkk.zze.zzrz, (Object) null, (Object) null);
        } catch (Exception e) {
            String name2 = cls.getName();
            throw new RuntimeException(name2.length() != 0 ? "Unable to get message info for ".concat(name2) : new String("Unable to get message info for "), e);
        }
    }
}
