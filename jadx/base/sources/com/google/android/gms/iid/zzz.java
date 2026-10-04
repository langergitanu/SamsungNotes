package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
abstract class zzz<T> {
    final int what;
    final int zzcp;
    final TaskCompletionSource<T> zzcq = new TaskCompletionSource<>();
    final Bundle zzcr;

    public zzz(int i, int i2, Bundle bundle) {
        this.zzcp = i;
        this.what = i2;
        this.zzcr = bundle;
    }

    public String toString() {
        int i = this.what;
        int i2 = this.zzcp;
        zzw();
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=false}");
        return sb.toString();
    }

    public final void zzd(zzaa zzaaVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(zzaaVar);
            StringBuilder sb = new StringBuilder(strValueOf2.length() + strValueOf.length() + 14);
            sb.append("Failing ");
            sb.append(strValueOf);
            sb.append(" with ");
            sb.append(strValueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.zzcq.setException(zzaaVar);
    }

    public abstract void zzh(Bundle bundle);

    public abstract boolean zzw();
}
