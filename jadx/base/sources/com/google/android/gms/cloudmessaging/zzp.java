package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.tasks.TaskCompletionSource;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzp<T> {
    final int zza;
    final TaskCompletionSource<T> zzb = new TaskCompletionSource<>();
    final int zzc;
    final Bundle zzd;

    public zzp(int i, int i2, Bundle bundle) {
        this.zza = i;
        this.zzc = i2;
        this.zzd = bundle;
    }

    public final String toString() {
        int i = this.zzc;
        int i2 = this.zza;
        StringBuilder sb = new StringBuilder(55);
        sb.append("Request { what=");
        sb.append(i);
        sb.append(" id=");
        sb.append(i2);
        sb.append(" oneWay=");
        return AbstractC0000a.m14k(sb, zzb(), "}");
    }

    public abstract void zza(Bundle bundle);

    public abstract boolean zzb();

    public final void zzc(zzq zzqVar) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(zzqVar);
            Log.d("MessengerIpcClient", AbstractC0541b.m776r(new StringBuilder(strValueOf.length() + 14 + strValueOf2.length()), "Failing ", strValueOf, " with ", strValueOf2));
        }
        this.zzb.setException(zzqVar);
    }

    public final void zzd(T t) {
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(t);
            Log.d("MessengerIpcClient", AbstractC0541b.m776r(new StringBuilder(strValueOf.length() + 16 + strValueOf2.length()), "Finishing ", strValueOf, " with ", strValueOf2));
        }
        this.zzb.setResult(t);
    }
}
