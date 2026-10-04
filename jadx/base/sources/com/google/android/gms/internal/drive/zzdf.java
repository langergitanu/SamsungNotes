package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* JADX INFO: loaded from: classes5.dex */
final class zzdf extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource zzfq;
    private final /* synthetic */ List zzgb;

    public zzdf(zzch zzchVar, DriveResource driveResource, List list) {
        this.zzfq = driveResource;
        this.zzgb = list;
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<Void> taskCompletionSource) {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgw(this.zzfq.getDriveId(), this.zzgb), new zzhr(taskCompletionSource));
    }
}
