package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;

/* JADX INFO: loaded from: classes5.dex */
final class zzak extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> zzdx;

    public zzak(BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfh zzfhVar) {
        this.zzdx.setResult(new zzal(Status.RESULT_SUCCESS, new zzbi(zzfhVar.zzes)));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.zzdx.setResult(new zzal(status, null));
    }
}
