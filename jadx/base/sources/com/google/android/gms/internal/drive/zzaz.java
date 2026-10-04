package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: loaded from: classes5.dex */
final class zzaz extends zzav {
    private final /* synthetic */ zzj zzek;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzaz(zzaw zzawVar, GoogleApiClient googleApiClient, zzj zzjVar) {
        super(googleApiClient);
        this.zzek = zzjVar;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) {
        ((zzeo) ((zzaw) anyClient).getService()).zza(this.zzek, (zzes) null, (String) null, new zzgy(this));
    }
}
