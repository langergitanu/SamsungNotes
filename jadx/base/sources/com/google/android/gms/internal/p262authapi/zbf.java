package com.google.android.gms.internal.p262authapi;

import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.common.api.Status;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zbf extends zbd {
    final /* synthetic */ zbg zba;

    public zbf(zbg zbgVar) {
        this.zba = zbgVar;
    }

    @Override // com.google.android.gms.internal.p262authapi.zbd, com.google.android.gms.internal.p262authapi.zbs
    public final void zbb(Status status, Credential credential) {
        this.zba.setResult(new zbe(status, credential));
    }

    @Override // com.google.android.gms.internal.p262authapi.zbd, com.google.android.gms.internal.p262authapi.zbs
    public final void zbc(Status status) {
        this.zba.setResult(new zbe(status, null));
    }
}
