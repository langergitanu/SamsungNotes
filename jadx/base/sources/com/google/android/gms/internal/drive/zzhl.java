package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.DriveId;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
public final class zzhl extends zzhh<DriveId> {
    public zzhl(TaskCompletionSource<DriveId> taskCompletionSource) {
        super(taskCompletionSource);
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfn zzfnVar) {
        zzay().setResult(zzfnVar.getDriveId());
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfy zzfyVar) {
        zzay().setResult(new zzaa(zzfyVar.zzaw()).getDriveId());
    }
}
