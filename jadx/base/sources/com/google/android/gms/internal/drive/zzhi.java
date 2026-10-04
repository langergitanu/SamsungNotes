package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
public final class zzhi extends zzhh<DriveContents> {
    public zzhi(TaskCompletionSource<DriveContents> taskCompletionSource) {
        super(taskCompletionSource);
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfh zzfhVar) {
        zzay().setResult(new zzbi(zzfhVar.zzar()));
    }
}
