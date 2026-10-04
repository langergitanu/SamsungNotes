package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import java.lang.Thread;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzajc implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ zzakn zza;

    public zzajc(zzakn zzaknVar) {
        this.zza = zzaknVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        zzakn.zza.logp(Level.SEVERE, "io.grpc.internal.ManagedChannelImpl$3", "uncaughtException", AbstractC0541b.m773o("[", String.valueOf(this.zza.zzc()), "] Uncaught exception in the SynchronizationContext. Panic!"), th);
        this.zza.zzV(th);
    }
}
