package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzsr implements zzuc {
    private static final zzsr zza = new zzsr();

    private zzsr() {
    }

    public static zzsr zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuc
    public final zzub zzb(Class cls) {
        if (!zzsy.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzub) zzsy.zzC(cls.asSubclass(zzsy.class)).zzi(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzuc
    public final boolean zzc(Class cls) {
        return zzsy.class.isAssignableFrom(cls);
    }
}
