package com.google.android.gms.auth;

import android.os.IBinder;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzi implements zzk {
    final /* synthetic */ AccountChangeEventsRequest zza;

    public zzi(AccountChangeEventsRequest accountChangeEventsRequest) {
        this.zza = accountChangeEventsRequest;
    }

    @Override // com.google.android.gms.auth.zzk
    public final /* bridge */ /* synthetic */ Object zza(IBinder iBinder) throws IOException {
        AccountChangeEventsResponse accountChangeEventsResponseZzh = com.google.android.gms.internal.auth.zze.zzb(iBinder).zzh(this.zza);
        zzl.zzd(accountChangeEventsResponseZzh);
        return accountChangeEventsResponseZzh.getEvents();
    }
}
