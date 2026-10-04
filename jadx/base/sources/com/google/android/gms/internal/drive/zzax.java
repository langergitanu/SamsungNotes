package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes5.dex */
final class zzax extends zzav {
    private final /* synthetic */ zzj zzek;
    private final /* synthetic */ zzee zzel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzax(zzaw zzawVar, GoogleApiClient googleApiClient, zzj zzjVar, zzee zzeeVar) {
        super(googleApiClient);
        this.zzek = zzjVar;
        this.zzel = zzeeVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzeo) ((zzaw) anyClient).getService()).zza(this.zzek, this.zzel, (String) null, new zzgy(this));
    }
}
