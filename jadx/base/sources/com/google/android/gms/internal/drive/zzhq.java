package com.google.android.gms.internal.drive;

import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes5.dex */
public final class zzhq extends zzhh<Boolean> {
    public zzhq(TaskCompletionSource<Boolean> taskCompletionSource) {
        super(taskCompletionSource);
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void onSuccess() {
        zzay().setResult(Boolean.TRUE);
    }
}
