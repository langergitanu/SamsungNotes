package com.google.android.gms.internal.meet_coactivities;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import java.time.Duration;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
@AutoValue
public abstract class zzgg {
    private static final zzkz zzb = zzkz.zzj("com/google/android/meet/addons/internal/ClientConfigInfo");
    static final zzgg zza = zze().zze();

    public static zzgf zze() {
        zzft zzftVar = new zzft();
        zzftVar.zzb(false);
        zzftVar.zzc(Duration.ofSeconds(1L));
        zzftVar.zzd(Duration.ofMillis(500L));
        zzftVar.zza(false);
        return zzftVar;
    }

    public static zzgg zzf(@Nullable zzg zzgVar) {
        zzgf zzgfVarZze = zze();
        if (zzgVar == null) {
            ((zzkv) zzb.zze().zzh("com/google/android/meet/addons/internal/ClientConfigInfo", "fromProto", 50, "ClientConfigInfo.java")).zzo("Received null config info from Meet.");
            return zzgfVarZze.zze();
        }
        zzgfVarZze.zzb(zzgVar.zzf());
        zzgfVarZze.zza(zzgVar.zze());
        if (zzgVar.zzg()) {
            zzgfVarZze.zzc(zzvt.zzb(zzgVar.zzc()));
        }
        if (zzgVar.zzh()) {
            zzgfVarZze.zzd(zzvt.zzb(zzgVar.zzd()));
        }
        return zzgfVarZze.zze();
    }

    public abstract Duration zza();

    public abstract Duration zzb();

    public abstract boolean zzc();

    public abstract boolean zzd();
}
