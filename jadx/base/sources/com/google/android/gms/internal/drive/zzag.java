package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.query.Query;

/* JADX INFO: loaded from: classes5.dex */
final class zzag extends zzar {
    private final /* synthetic */ Query zzdu;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzag(zzaf zzafVar, GoogleApiClient googleApiClient, Query query) {
        super(googleApiClient);
        this.zzdu = query;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgq(this.zzdu), new zzas(this));
    }
}
