package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzlz {
    public static final zzlz zzc = new zzlu();
    public static final zzlz zzd = new zzlu();

    public static zzlz zzc(zzlz zzlzVar, zzlz zzlzVar2) {
        zzlz zzlzVar3;
        zzlz zzlzVar4;
        return zzlzVar == null ? zzlzVar2 : (zzlzVar2 == null || zzlzVar == (zzlzVar3 = zzc) || zzlzVar2 == (zzlzVar4 = zzd)) ? zzlzVar : (zzlzVar2 == zzlzVar3 || zzlzVar == zzlzVar4) ? zzlzVar2 : new zzlv(zzlzVar, zzlzVar2);
    }

    public abstract void zzb();
}
