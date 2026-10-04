package com.google.android.gms.internal.meet_coactivities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzd {
    private static volatile zzaab zza;
    private static volatile zzaab zzb;
    private static volatile zzaab zzc;
    private static volatile zzaab zzd;
    private static volatile zzaab zze;
    private static volatile zzaab zzf;

    private zzd() {
    }

    public static zzc zza(zzwe zzweVar) {
        return (zzc) zzapb.zza(new zza(), zzweVar, zzwd.zza);
    }

    public static zzaab zzb() {
        zzaab zzaabVarZzf;
        zzaab zzaabVar = zzf;
        if (zzaabVar != null) {
            return zzaabVar;
        }
        synchronized (zzd.class) {
            try {
                zzaabVarZzf = zzf;
                if (zzaabVarZzf == null) {
                    zzzx zzzxVarZza = zzaab.zza(null, null);
                    zzzxVarZza.zze(zzzz.UNARY);
                    zzzxVarZza.zza(zzaab.zze("com.google.android.libraries.communications.sdk.sync.api.proto.MeetActivityService", "BroadcastEventNotification"));
                    zzzxVarZza.zzd(true);
                    zzzxVarZza.zzb(zzapa.zza(zzai.zzc()));
                    zzzxVarZza.zzc(zzapa.zza(zzak.zzb()));
                    zzaabVarZzf = zzzxVarZza.zzf();
                    zzf = zzaabVarZzf;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzaabVarZzf;
    }

    public static zzaab zzc() {
        zzaab zzaabVarZzf;
        zzaab zzaabVar = zze;
        if (zzaabVar != null) {
            return zzaabVar;
        }
        synchronized (zzd.class) {
            try {
                zzaabVarZzf = zze;
                if (zzaabVarZzf == null) {
                    zzzx zzzxVarZza = zzaab.zza(null, null);
                    zzzxVarZza.zze(zzzz.UNARY);
                    zzzxVarZza.zza(zzaab.zze("com.google.android.libraries.communications.sdk.sync.api.proto.MeetActivityService", "BroadcastStatSample"));
                    zzzxVarZza.zzd(true);
                    zzzxVarZza.zzb(zzapa.zza(zzbg.zzc()));
                    zzzxVarZza.zzc(zzapa.zza(zzbi.zzb()));
                    zzaabVarZzf = zzzxVarZza.zzf();
                    zze = zzaabVarZzf;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzaabVarZzf;
    }

    public static zzaab zzd() {
        zzaab zzaabVarZzf;
        zzaab zzaabVar = zzd;
        if (zzaabVar != null) {
            return zzaabVar;
        }
        synchronized (zzd.class) {
            try {
                zzaabVarZzf = zzd;
                if (zzaabVarZzf == null) {
                    zzzx zzzxVarZza = zzaab.zza(null, null);
                    zzzxVarZza.zze(zzzz.BIDI_STREAMING);
                    zzzxVarZza.zza(zzaab.zze("com.google.android.libraries.communications.sdk.sync.api.proto.MeetActivityService", "BroadcastStateUpdate"));
                    zzzxVarZza.zzd(true);
                    zzzxVarZza.zzb(zzapa.zza(zzbk.zzc()));
                    zzzxVarZza.zzc(zzapa.zza(zzbn.zze()));
                    zzaabVarZzf = zzzxVarZza.zzf();
                    zzd = zzaabVarZzf;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzaabVarZzf;
    }

    public static zzaab zze() {
        zzaab zzaabVarZzf;
        zzaab zzaabVar = zzb;
        if (zzaabVar != null) {
            return zzaabVar;
        }
        synchronized (zzd.class) {
            try {
                zzaabVarZzf = zzb;
                if (zzaabVarZzf == null) {
                    zzzx zzzxVarZza = zzaab.zza(null, null);
                    zzzxVarZza.zze(zzzz.BIDI_STREAMING);
                    zzzxVarZza.zza(zzaab.zze("com.google.android.libraries.communications.sdk.sync.api.proto.MeetActivityService", "ConnectMeetingAsStream"));
                    zzzxVarZza.zzd(true);
                    zzzxVarZza.zzb(zzapa.zza(zzu.zzc()));
                    zzzxVarZza.zzc(zzapa.zza(zzx.zzd()));
                    zzaabVarZzf = zzzxVarZza.zzf();
                    zzb = zzaabVarZzf;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzaabVarZzf;
    }

    public static zzaab zzf() {
        zzaab zzaabVarZzf;
        zzaab zzaabVar = zza;
        if (zzaabVar != null) {
            return zzaabVar;
        }
        synchronized (zzd.class) {
            try {
                zzaabVarZzf = zza;
                if (zzaabVarZzf == null) {
                    zzzx zzzxVarZza = zzaab.zza(null, null);
                    zzzxVarZza.zze(zzzz.UNARY);
                    zzzxVarZza.zza(zzaab.zze("com.google.android.libraries.communications.sdk.sync.api.proto.MeetActivityService", "ConnectMeeting"));
                    zzzxVarZza.zzd(true);
                    zzzxVarZza.zzb(zzapa.zza(zzu.zzc()));
                    zzzxVarZza.zzc(zzapa.zza(zzx.zzd()));
                    zzaabVarZzf = zzzxVarZza.zzf();
                    zza = zzaabVarZzf;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzaabVarZzf;
    }

    public static zzaab zzg() {
        zzaab zzaabVarZzf;
        zzaab zzaabVar = zzc;
        if (zzaabVar != null) {
            return zzaabVar;
        }
        synchronized (zzd.class) {
            try {
                zzaabVarZzf = zzc;
                if (zzaabVarZzf == null) {
                    zzzx zzzxVarZza = zzaab.zza(null, null);
                    zzzxVarZza.zze(zzzz.UNARY);
                    zzzxVarZza.zza(zzaab.zze("com.google.android.libraries.communications.sdk.sync.api.proto.MeetActivityService", "DisconnectMeeting"));
                    zzzxVarZza.zzd(true);
                    zzzxVarZza.zzb(zzapa.zza(zzae.zzc()));
                    zzzxVarZza.zzc(zzapa.zza(zzag.zzb()));
                    zzaabVarZzf = zzzxVarZza.zzf();
                    zzc = zzaabVarZzf;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzaabVarZzf;
    }
}
