package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
final class zzbc extends TaskApiCall<zzaw, DriveId> {
    private final /* synthetic */ String zzdw;

    public zzbc(zzbb zzbbVar, String str) {
        this.zzdw = str;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<DriveId> taskCompletionSource) {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzek(DriveId.zza(this.zzdw), false), new zzhl(taskCompletionSource));
    }
}
