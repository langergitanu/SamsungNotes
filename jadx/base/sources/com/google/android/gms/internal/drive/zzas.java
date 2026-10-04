package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.MetadataBuffer;

/* JADX INFO: loaded from: classes5.dex */
final class zzas extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> zzdx;

    public zzas(BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzft zzftVar) {
        this.zzdx.setResult(new zzaq(Status.RESULT_SUCCESS, new MetadataBuffer(zzftVar.zzii), zzftVar.zzea));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.zzdx.setResult(new zzaq(status, null, false));
    }
}
