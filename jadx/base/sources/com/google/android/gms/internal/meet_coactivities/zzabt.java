package com.google.android.gms.internal.meet_coactivities;

import android.content.Context;
import android.os.UserHandle;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzabt implements zzaex {
    private final Context zza;
    private final zzabv zzb;
    private final Executor zzc;
    private final zzale zzd;
    private final zzale zze;
    private final zzabz zzf;
    private final zzabr zzg;
    private final zzabw zzh;
    private ScheduledExecutorService zzi;
    private Executor zzj;
    private boolean zzk;

    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.Object, java.util.concurrent.Executor] */
    public zzabt(Context context, zzabv zzabvVar, Executor executor, zzale zzaleVar, zzale zzaleVar2, zzabz zzabzVar, @Nullable UserHandle userHandle, zzabr zzabrVar, zzabw zzabwVar) {
        this.zza = context;
        this.zzb = zzabvVar;
        this.zzc = executor;
        this.zzd = zzaleVar;
        this.zze = zzaleVar2;
        this.zzf = zzabzVar;
        this.zzg = zzabrVar;
        this.zzh = zzabwVar;
        this.zzi = (ScheduledExecutorService) zzaleVar.zza();
        this.zzj = zzaleVar2.zza();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaex, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zzk = true;
        this.zzd.zzb(this.zzi);
        this.zzi = null;
        this.zze.zzb(this.zzj);
        this.zzj = null;
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaex
    public final zzaey zza(SocketAddress socketAddress, zzaew zzaewVar, zzwg zzwgVar) {
        if (this.zzk) {
            throw new IllegalStateException("The transport factory is closed.");
        }
        return new zzacj(this.zza, this.zzb, (zzabn) socketAddress, null, this.zzg, this.zzc, this.zzd, this.zze, this.zzf, this.zzh, zzadc.zzb, zzaewVar.zza());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaex
    public final ScheduledExecutorService zzb() {
        return this.zzi;
    }
}
