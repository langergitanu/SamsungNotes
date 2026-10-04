package com.google.android.gms.fido.fido2;

import android.app.PendingIntent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzt extends com.google.android.gms.internal.fido.zzl {
    final /* synthetic */ TaskCompletionSource zza;

    public zzt(Fido2PrivilegedApiClient fido2PrivilegedApiClient, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zzm
    public final void zzb(Status status, @Nullable PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, new com.google.android.gms.internal.fido.zzi(pendingIntent), this.zza);
    }
}
