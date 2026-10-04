package com.google.android.gms.internal.meet_coactivities;

import com.google.android.meet.addons.AddonException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzdb {
    public static Throwable zza(Throwable th) {
        zzaay zzaayVarZza = zzabd.zzc(th).zza();
        return zzaayVarZza.equals(zzaay.UNIMPLEMENTED) ? com.google.android.meet.addons.zza.zza(AddonException.Code.MEET_VERSION_UNSUPPORTED) : zzaayVarZza.equals(zzaay.UNAVAILABLE) ? com.google.android.meet.addons.zza.zza(AddonException.Code.SDK_VERSION_UNSUPPORTED) : th;
    }
}
