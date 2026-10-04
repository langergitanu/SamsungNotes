package com.google.android.gms.internal.drive;

/* JADX INFO: loaded from: classes5.dex */
abstract class zzla {
    private static final zzla zztm;
    private static final zzla zztn;

    static {
        zzlb zzlbVar = null;
        zztm = new zzlc();
        zztn = new zzld();
    }

    private zzla() {
    }

    public static zzla zzdt() {
        return zztm;
    }

    public static zzla zzdu() {
        return zztn;
    }

    public abstract void zza(Object obj, long j);

    public abstract <L> void zza(Object obj, Object obj2, long j);
}
