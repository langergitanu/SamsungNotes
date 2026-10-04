package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
final class zzcx extends TaskApiCall<zzaw, DriveContents> {
    private final /* synthetic */ DriveContents zzfx;

    public zzcx(zzch zzchVar, DriveContents driveContents) {
        this.zzfx = driveContents;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<DriveContents> taskCompletionSource) {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgj(this.zzfx.getDriveId(), 536870912, this.zzfx.zzi().getRequestId()), new zzhi(taskCompletionSource));
    }
}
