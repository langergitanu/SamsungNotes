package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
final class zzdb extends TaskApiCall<zzaw, DriveFolder> {
    private final /* synthetic */ MetadataChangeSet zzfd;
    private final /* synthetic */ DriveFolder zzfz;

    public zzdb(zzch zzchVar, MetadataChangeSet metadataChangeSet, DriveFolder driveFolder) {
        this.zzfd = metadataChangeSet;
        this.zzfz = driveFolder;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<DriveFolder> taskCompletionSource) {
        zzaw zzawVar = (zzaw) anyClient;
        this.zzfd.zzq().zza(zzawVar.getContext());
        ((zzeo) zzawVar.getService()).zza(new zzy(this.zzfz.getDriveId(), this.zzfd.zzq()), new zzhk(taskCompletionSource));
    }
}
