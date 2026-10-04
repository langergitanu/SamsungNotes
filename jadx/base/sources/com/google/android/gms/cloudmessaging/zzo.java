package com.google.android.gms.cloudmessaging;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
final class zzo extends zzp<Void> {
    public zzo(int i, int i2, Bundle bundle) {
        super(i, 2, bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.zzp
    public final void zza(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            zzd(null);
        } else {
            zzc(new zzq(4, "Invalid response to one way request", null));
        }
    }

    @Override // com.google.android.gms.cloudmessaging.zzp
    public final boolean zzb() {
        return true;
    }
}
