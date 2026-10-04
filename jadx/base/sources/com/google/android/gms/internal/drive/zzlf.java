package com.google.android.gms.internal.drive;

import com.google.android.gms.internal.drive.zzkk;

/* JADX INFO: loaded from: classes5.dex */
final class zzlf implements zzmg {
    private static final zzlp zzts = new zzlg();
    private final zzlp zztr;

    public zzlf() {
        this(new zzlh(zzkj.zzcv(), zzdv()));
    }

    private static boolean zza(zzlo zzloVar) {
        return zzloVar.zzec() == zzkk.zze.zzsf;
    }

    private static zzlp zzdv() {
        try {
            return (zzlp) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            return zzts;
        }
    }

    @Override // com.google.android.gms.internal.drive.zzmg
    public final <T> zzmf<T> zze(Class<T> cls) {
        zzmh.zzg((Class<?>) cls);
        zzlo zzloVarZzc = this.zztr.zzc(cls);
        return zzloVarZzc.zzed() ? zzkk.class.isAssignableFrom(cls) ? zzlw.zza(zzmh.zzeo(), zzka.zzcl(), zzloVarZzc.zzee()) : zzlw.zza(zzmh.zzem(), zzka.zzcm(), zzloVarZzc.zzee()) : zzkk.class.isAssignableFrom(cls) ? zza(zzloVarZzc) ? zzlu.zza(cls, zzloVarZzc, zzma.zzeh(), zzla.zzdu(), zzmh.zzeo(), zzka.zzcl(), zzln.zzea()) : zzlu.zza(cls, zzloVarZzc, zzma.zzeh(), zzla.zzdu(), zzmh.zzeo(), (zzjy<?>) null, zzln.zzea()) : zza(zzloVarZzc) ? zzlu.zza(cls, zzloVarZzc, zzma.zzeg(), zzla.zzdt(), zzmh.zzem(), zzka.zzcm(), zzln.zzdz()) : zzlu.zza(cls, zzloVarZzc, zzma.zzeg(), zzla.zzdt(), zzmh.zzen(), (zzjy<?>) null, zzln.zzdz());
    }

    private zzlf(zzlp zzlpVar) {
        this.zztr = (zzlp) zzkm.zza(zzlpVar, "messageInfoFactory");
    }
}
