package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
final class zzck extends TaskApiCall<zzaw, DriveFolder> {
    public zzck(zzch zzchVar) {
    }

    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource<DriveFolder> taskCompletionSource) {
        zzaw zzawVar = (zzaw) anyClient;
        if (zzawVar.zzae() == null) {
            taskCompletionSource.setException(new ApiException(new Status(10, "Drive#SCOPE_FILE must be requested")));
        } else {
            taskCompletionSource.setResult(new zzbs(zzawVar.zzae()));
        }
    }
}
