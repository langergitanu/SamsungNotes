package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveFile;

/* JADX INFO: loaded from: classes5.dex */
final class zzgl extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> zzdx;
    private final DriveFile.DownloadProgressListener zziq;

    public zzgl(BaseImplementation.ResultHolder<DriveApi.DriveContentsResult> resultHolder, DriveFile.DownloadProgressListener downloadProgressListener) {
        this.zzdx = resultHolder;
        this.zziq = downloadProgressListener;
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfh zzfhVar) {
        this.zzdx.setResult(new zzal(zzfhVar.zzhv ? new Status(-1) : Status.RESULT_SUCCESS, new zzbi(zzfhVar.zzes)));
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfl zzflVar) {
        DriveFile.DownloadProgressListener downloadProgressListener = this.zziq;
        if (downloadProgressListener != null) {
            downloadProgressListener.onProgress(zzflVar.zzhy, zzflVar.zzhz);
        }
    }

    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) {
        this.zzdx.setResult(new zzal(status, null));
    }
}
