package com.google.android.gms.internal.meet_coactivities;

import com.google.common.annotations.GoogleInternal;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zznr {

    @GoogleInternal
    private static String zza = "com.google.android.gms.internal.meet_coactivities.zzny";

    @GoogleInternal
    private static String zzb = "com.google.common.flogger.backend.google.GooglePlatform";
    private static String zzc = "com.google.common.flogger.backend.system.DefaultPlatform";
    private static final String[] zzd = {"com.google.android.gms.internal.meet_coactivities.zzny", "com.google.common.flogger.backend.google.GooglePlatform", "com.google.common.flogger.backend.system.DefaultPlatform"};

    public static int zza() {
        return zzpk.zza();
    }

    public static long zzb() {
        return zznp.zza.zzc();
    }

    public static zzmn zzd(String str) {
        return zznp.zza.zze(str);
    }

    public static zzmr zzf() {
        return zzi().zza();
    }

    public static zznq zzg() {
        return zznp.zza.zzh();
    }

    public static zzoj zzi() {
        return zznp.zza.zzj();
    }

    public static zzov zzk() {
        return zzi().zzc();
    }

    public static String zzl() {
        return zznp.zza.zzm();
    }

    public static boolean zzn(String str, Level level, boolean z) {
        zzi().zzd(str, level, z);
        return false;
    }

    public long zzc() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    public abstract zzmn zze(String str);

    public abstract zznq zzh();

    public zzoj zzj() {
        return zzoj.zze();
    }

    public abstract String zzm();
}
