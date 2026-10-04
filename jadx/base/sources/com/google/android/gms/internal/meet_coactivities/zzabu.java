package com.google.android.gms.internal.meet_coactivities;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzabu extends zzxo {
    private final zzaku zza;
    private final Executor zzb;
    private final zzale zzc = zzaoq.zzc(zzahv.zzj);
    private zzabz zzd = new zzabx();
    private final zzabw zze = zzabw.zza;
    private zzabr zzf = zzabr.zza;

    private zzabu(@Nullable zzabn zzabnVar, @Nullable String str, Context context, zzabv zzabvVar) {
        this.zzb = ContextCompat.getMainExecutor((Context) Preconditions.checkNotNull(context, "sourceContext"));
        if (zzabnVar != null) {
            this.zza = new zzaku(zzabnVar, zzabnVar.zzc(), null, null, new zzabs(this, context, zzabvVar), null);
        } else {
            this.zza = new zzaku(null, null, null, new zzabs(this, context, zzabvVar), null);
        }
        zzf(60L, TimeUnit.SECONDS);
    }

    public static zzabu zze(zzabn zzabnVar, Context context) {
        return new zzabu((zzabn) Preconditions.checkNotNull(zzabnVar, "directAddress"), null, context, zzabv.zza());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzxo, com.google.android.gms.internal.meet_coactivities.zzxn
    public final zzzk zzb() {
        return this.zza;
    }

    public final zzabu zzf(long j, TimeUnit timeUnit) {
        Preconditions.checkState(true, "Idle timeouts are not supported when strict lifecycle management is enabled");
        this.zza.zzd(j, timeUnit);
        return this;
    }

    public final zzabu zzg(zzabz zzabzVar) {
        this.zzd = (zzabz) Preconditions.checkNotNull(zzabzVar, "securityPolicy");
        return this;
    }

    public final zzabu zzh(zzabr zzabrVar) {
        this.zzf = zzabrVar;
        return this;
    }
}
