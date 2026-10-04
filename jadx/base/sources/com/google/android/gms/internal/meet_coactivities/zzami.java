package com.google.android.gms.internal.meet_coactivities;

import java.lang.Thread;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzami implements Thread.UncaughtExceptionHandler {
    public zzami(zzanr zzanrVar) {
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread thread, Throwable th) {
        throw new zzabf(zzabd.zzc(th).zze("Uncaught exception in the SynchronizationContext. Re-thrown."), null);
    }
}
