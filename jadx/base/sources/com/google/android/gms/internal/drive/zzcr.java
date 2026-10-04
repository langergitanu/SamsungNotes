package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
final class zzcr extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource zzfq;

    public zzcr(zzch zzchVar, DriveResource driveResource) {
        this.zzfq = driveResource;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<Void> taskCompletionSource) {
        zzaw zzawVar = (zzaw) anyClient;
        if (!zzawVar.zzec) {
            throw new IllegalStateException("Application must define an exported DriveEventService subclass in AndroidManifest.xml to add event subscriptions");
        }
        ((zzeo) zzawVar.getService()).zza(new zzj(1, this.zzfq.getDriveId()), (zzes) null, (String) null, new zzhr(taskCompletionSource));
    }
}
