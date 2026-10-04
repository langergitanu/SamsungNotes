package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
public final class zzhj extends zzhh<DriveFile> {
    public zzhj(TaskCompletionSource<DriveFile> taskCompletionSource) {
        super(taskCompletionSource);
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfn zzfnVar) {
        zzay().setResult(zzfnVar.getDriveId().asDriveFile());
    }
}
