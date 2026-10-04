package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes5.dex */
final class zzcd extends zzav {
    private final /* synthetic */ zzei zzfl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzcd(zzcb zzcbVar, GoogleApiClient googleApiClient, zzei zzeiVar) {
        super(googleApiClient);
        this.zzfl = zzeiVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzeo) ((zzaw) anyClient).getService()).zza(new zzgu(this.zzfl), new zzgy(this));
    }
}
