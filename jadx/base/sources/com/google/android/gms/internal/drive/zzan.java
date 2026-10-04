package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;

/* JADX INFO: loaded from: classes5.dex */
final class zzan extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.DriveIdResult> zzdx;

    public zzan(BaseImplementation.ResultHolder<DriveApi.DriveIdResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfy zzfyVar) {
        this.zzdx.setResult(new zzao(Status.RESULT_SUCCESS, new zzaa(zzfyVar.zzdn).getDriveId()));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfn zzfnVar) {
        this.zzdx.setResult(new zzao(Status.RESULT_SUCCESS, zzfnVar.zzdd));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.zzdx.setResult(new zzao(status, null));
    }
}
