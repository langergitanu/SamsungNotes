package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.AddonSessionHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzkl implements zzkm {
    private zzkl() {
        throw null;
    }

    public static zzkl zzb() {
        return zzkj.zza;
    }

    public static final AddonSessionHandler.Privilege zzc(zzam zzamVar) {
        return zzd(zzamVar);
    }

    private static AddonSessionHandler.Privilege zzd(zzam zzamVar) {
        AddonSessionHandler.Privilege privilege = AddonSessionHandler.Privilege.UNKNOWN;
        int iOrdinal = zzamVar.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return AddonSessionHandler.Privilege.MAY_CHANGE_ADDON_SESSION_STATE;
            }
            if (iOrdinal != 2) {
                throw new AssertionError();
            }
        }
        return AddonSessionHandler.Privilege.UNKNOWN;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzkm
    public final /* synthetic */ Object zza(Object obj) {
        return zzd((zzam) obj);
    }

    public /* synthetic */ zzkl(zzkk zzkkVar) {
    }
}
