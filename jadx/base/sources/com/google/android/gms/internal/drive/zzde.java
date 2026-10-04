package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
final class zzde extends TaskApiCall<zzaw, MetadataBuffer> {
    private final /* synthetic */ DriveResource zzfq;

    public zzde(zzch zzchVar, DriveResource driveResource) {
        this.zzfq = driveResource;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<MetadataBuffer> taskCompletionSource) {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzex(this.zzfq.getDriveId()), new zzho(taskCompletionSource));
    }
}
