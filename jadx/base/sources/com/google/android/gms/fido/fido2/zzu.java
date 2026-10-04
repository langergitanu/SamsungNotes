package com.google.android.gms.fido.fido2;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzu extends com.google.android.gms.internal.fido.zzd {
    final /* synthetic */ TaskCompletionSource zza;

    public zzu(Fido2PrivilegedApiClient fido2PrivilegedApiClient, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.fido.zze
    public final void zzb(boolean z) {
        this.zza.setResult(Boolean.valueOf(z));
    }

    @Override // com.google.android.gms.internal.fido.zze
    public final void zzc(Status status) {
        this.zza.trySetException(new ApiException(status));
    }
}
