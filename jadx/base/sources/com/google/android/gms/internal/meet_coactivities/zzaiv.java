package com.google.android.gms.internal.meet_coactivities;

import androidx.appcompat.widget.AbstractC0541b;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zzaiv implements Runnable {
    private static final Logger zza = Logger.getLogger(zzaiv.class.getName());
    private final Runnable zzb;

    public zzaiv(Runnable runnable) {
        this.zzb = (Runnable) Preconditions.checkNotNull(runnable, "task");
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzb.run();
        } catch (Throwable th) {
            zza.logp(Level.SEVERE, "io.grpc.internal.LogExceptionRunnable", "run", "Exception while executing runnable ".concat(String.valueOf(this.zzb)), th);
            Throwables.throwIfUnchecked(th);
            throw new AssertionError(th);
        }
    }

    public final String toString() {
        return AbstractC0541b.m773o("LogExceptionRunnable(", String.valueOf(this.zzb), ")");
    }
}
