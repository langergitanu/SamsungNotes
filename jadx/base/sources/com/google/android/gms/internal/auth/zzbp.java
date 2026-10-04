package com.google.android.gms.internal.auth;

import com.google.android.gms.auth.api.proxy.ProxyResponse;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzbp extends zzbd {
    final /* synthetic */ zzbq zza;

    public zzbp(zzbq zzbqVar) {
        this.zza = zzbqVar;
    }

    @Override // com.google.android.gms.internal.auth.zzbd, com.google.android.gms.internal.auth.zzbg
    public final void zzb(ProxyResponse proxyResponse) {
        this.zza.setResult(new zzbu(proxyResponse));
    }
}
