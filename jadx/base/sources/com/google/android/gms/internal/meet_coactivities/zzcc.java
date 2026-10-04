package com.google.android.gms.internal.meet_coactivities;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import com.google.common.collect.ImmutableMap;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzcc implements zzdd {
    private final ImmutableMap zza;

    public zzcc(Context context) {
        this.zza = ImmutableMap.m4325of(zzj.HOST_APP_FAKE_TACHYON, zzb("com.google.android.apps.faketachyon", context), zzj.HOST_APP_DUET, zzb("com.google.android.apps.tachyon", context), zzj.HOST_APP_HAM, zzb("com.google.android.apps.meetings", context), zzj.HOST_APP_MIG, zzb("com.google.android.gm", context));
    }

    private static zzc zzb(String str, Context context) {
        zzabp zzabpVarZzb = zzabr.zza.zzb();
        if (Build.VERSION.SDK_INT >= 34) {
            zzabpVarZzb.zza(true);
        }
        zzabu zzabuVarZze = zzabu.zze(zzabn.zzb(new ComponentName(str, "com.google.android.libraries.communications.conference.service.impl.synchronicityservice.SynchronicityEndpointService")), context);
        zzabuVarZze.zzg(zzacb.zza());
        zzabuVarZze.zzf(zzcd.zza.toMinutes(), TimeUnit.MINUTES);
        zzabuVarZze.zzh(zzabpVarZzb.zzc());
        zzabuVarZze.zzc();
        return zzd.zza(zzabuVarZze.zza());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzdd
    public final Optional zza(zzj zzjVar) {
        return Optional.ofNullable((zzc) this.zza.get(zzjVar));
    }
}
