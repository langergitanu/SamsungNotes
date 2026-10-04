package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveFolder;

/* JADX INFO: loaded from: classes5.dex */
final class zzbw extends zzl {
    private final BaseImplementation.ResultHolder<DriveFolder.DriveFolderResult> zzdx;

    public zzbw(BaseImplementation.ResultHolder<DriveFolder.DriveFolderResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfn zzfnVar) {
        this.zzdx.setResult(new zzbz(Status.RESULT_SUCCESS, new zzbs(zzfnVar.zzdd)));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.zzdx.setResult(new zzbz(status, null));
    }
}
