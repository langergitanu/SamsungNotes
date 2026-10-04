package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zztv implements zzur {
    private static final zzuc zza = new zztt();
    private final zzuc zzb;

    public zztv() {
        zzsr zzsrVarZza = zzsr.zza();
        int i = zzum.zza;
        zztu zztuVar = new zztu(zzsrVarZza, zza);
        byte[] bArr = zztg.zzb;
        this.zzb = zztuVar;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzur
    public final zzuq zza(Class cls) {
        int i = zzus.zza;
        if (!zzsy.class.isAssignableFrom(cls)) {
            int i2 = zzum.zza;
        }
        zzub zzubVarZzb = this.zzb.zzb(cls);
        if (zzubVarZzb.zzb()) {
            int i4 = zzum.zza;
            return zzui.zzc(zzus.zzm(), zzsm.zza(), zzubVarZzb.zza());
        }
        int i5 = zzum.zza;
        return zzuh.zzm(cls, zzubVarZzb, zzuk.zza(), zztr.zza(), zzus.zzm(), zzubVarZzb.zzc() + (-1) != 1 ? zzsm.zza() : null, zzua.zza());
    }
}
