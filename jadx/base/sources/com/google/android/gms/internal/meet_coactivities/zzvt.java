package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.PreferKotlinApi;
import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzvt {
    @PreferKotlinApi(imports = {"com.google.protobuf.util.kotlin.toProtoDuration"}, replacement = "duration.toProtoDuration()")
    public static zzsg zza(Duration duration) {
        return zzvs.zza(duration.getSeconds(), duration.getNano());
    }

    @PreferKotlinApi(imports = {"com.google.protobuf.util.kotlin.toJavaDuration"}, replacement = "duration.toJavaDuration()")
    public static Duration zzb(zzsg zzsgVar) {
        return Duration.ofSeconds(zzvs.zza(zzsgVar.zzd(), zzsgVar.zzc()).zzd(), r4.zzc());
    }
}
