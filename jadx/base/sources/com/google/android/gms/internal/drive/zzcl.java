package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
final class zzcl extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource zzfq;

    public zzcl(zzch zzchVar, DriveResource driveResource) {
        this.zzfq = driveResource;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<Void> taskCompletionSource) {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzab(this.zzfq.getDriveId()), new zzhr(taskCompletionSource));
    }
}
