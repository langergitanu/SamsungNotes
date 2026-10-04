package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
final class zzbd extends TaskApiCall<zzaw, TransferPreferences> {
    public zzbd(zzbb zzbbVar) {
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<TransferPreferences> taskCompletionSource) {
        ((zzeo) ((zzaw) anyClient).getService()).zzb(new zzhm(taskCompletionSource));
    }
}
