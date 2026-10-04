package com.google.android.gms.iid;

import android.content.Intent;
import android.util.Log;
import com.google.android.gms.common.data.AbstractC4539a;

/* JADX INFO: loaded from: classes5.dex */
final class zzh implements Runnable {
    private final /* synthetic */ Intent zzbf;
    private final /* synthetic */ zzg zzbl;

    public zzh(zzg zzgVar, Intent intent) {
        this.zzbl = zzgVar;
        this.zzbf = intent;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String action = this.zzbf.getAction();
        StringBuilder sb = new StringBuilder(AbstractC4539a.m3194d(61, action));
        sb.append("Service took too long to process intent: ");
        sb.append(action);
        sb.append(" App may get closed.");
        Log.w("EnhancedIntentService", sb.toString());
        this.zzbl.finish();
    }
}
