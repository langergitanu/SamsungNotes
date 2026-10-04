package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;

/* JADX INFO: loaded from: classes5.dex */
final class zzbu extends zzca {
    private final /* synthetic */ MetadataChangeSet zzfd;
    private final /* synthetic */ zzbs zzfh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzbu(zzbs zzbsVar, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        super(googleApiClient);
        this.zzfh = zzbsVar;
        this.zzfd = metadataChangeSet;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        zzaw zzawVar = (zzaw) anyClient;
        this.zzfd.zzq().zza(zzawVar.getContext());
        ((zzeo) zzawVar.getService()).zza(new zzy(this.zzfh.getDriveId(), this.zzfd.zzq()), new zzbw(this));
    }
}
