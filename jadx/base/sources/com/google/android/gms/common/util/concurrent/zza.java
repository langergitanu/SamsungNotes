package com.google.android.gms.common.util.concurrent;

import android.os.Process;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zza implements Runnable {
    private final Runnable zza;

    public zza(Runnable runnable, int i) {
        this.zza = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(0);
        this.zza.run();
    }
}
