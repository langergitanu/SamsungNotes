package com.google.android.gms.iid;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: classes5.dex */
public final class zzr {
    private final ScheduledExecutorService zzce;

    @GuardedBy("this")
    private zzt zzcf;

    @GuardedBy("this")
    private int zzcg;
    private final Context zzl;

    public zzr(Context context) {
        this(context, com.google.android.gms.internal.gcm.zzg.zzaa().zze(1, new NamedThreadFactory("MessengerIpcClient"), 9));
    }

    private final synchronized int zzs() {
        int i;
        i = this.zzcg;
        this.zzcg = i + 1;
        return i;
    }

    public final Task<Bundle> zzd(int i, Bundle bundle) {
        return zzd(new zzab(zzs(), 1, bundle));
    }

    private final synchronized <T> Task<T> zzd(zzz<T> zzzVar) {
        try {
            if (Log.isLoggable("MessengerIpcClient", 3)) {
                String strValueOf = String.valueOf(zzzVar);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 9);
                sb.append("Queueing ");
                sb.append(strValueOf);
                Log.d("MessengerIpcClient", sb.toString());
            }
            if (!this.zzcf.zze(zzzVar)) {
                zzt zztVar = new zzt(this);
                this.zzcf = zztVar;
                zztVar.zze(zzzVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return zzzVar.zzcq.getTask();
    }

    @VisibleForTesting
    private zzr(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.zzcf = new zzt(this);
        this.zzcg = 1;
        this.zzl = context.getApplicationContext();
        this.zzce = scheduledExecutorService;
    }
}
