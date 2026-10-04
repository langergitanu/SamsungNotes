package com.google.android.gms.internal.meet_coactivities;

import io.grpc.internal.GrpcUtil;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzalx extends zzzf {
    static final boolean zza = zzahv.zzg("GRPC_EXPERIMENTAL_ENABLE_NEW_PICK_FIRST", false);
    public static final /* synthetic */ int zzb = 0;

    @Override // com.google.android.gms.internal.meet_coactivities.zzyr
    public final zzzd zza(zzyt zzytVar) {
        return zza ? new zzalq(zzytVar) : new zzalw(zzytVar);
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzf
    public final int zzb() {
        return 5;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzf
    public final zzaag zzc(Map map) {
        try {
            Boolean boolZza = zzaiu.zza(map, "shuffleAddressList");
            return zzaag.zza(zza ? new zzall(boolZza, null) : new zzals(boolZza, null));
        } catch (RuntimeException e) {
            return zzaag.zzb(zzabd.zzk.zzd(e).zze("Failed parsing configuration for pick_first"));
        }
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzf
    public final String zzd() {
        return GrpcUtil.DEFAULT_LB_POLICY;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzzf
    public final boolean zze() {
        return true;
    }
}
