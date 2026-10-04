package com.google.android.gms.internal.meet_coactivities;

import com.google.common.base.Preconditions;
import java.net.SocketAddress;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzaeg implements zzaex {
    private final zzaex zza;

    public zzaeg(zzaex zzaexVar, zzvz zzvzVar, Executor executor) {
        this.zza = (zzaex) Preconditions.checkNotNull(zzaexVar, "delegate");
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaex, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.zza.close();
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaex
    public final zzaey zza(SocketAddress socketAddress, zzaew zzaewVar, zzwg zzwgVar) {
        return new zzaef(this, this.zza.zza(socketAddress, zzaewVar, zzwgVar), zzaewVar.zzf());
    }

    @Override // com.google.android.gms.internal.meet_coactivities.zzaex
    public final ScheduledExecutorService zzb() {
        return this.zza.zzb();
    }
}
