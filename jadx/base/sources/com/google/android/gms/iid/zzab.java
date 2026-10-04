package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;

/* JADX INFO: loaded from: classes5.dex */
final class zzab extends zzz<Bundle> {
    public zzab(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // com.google.android.gms.iid.zzz
    public final void zzh(Bundle bundle) {
        Object bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String strValueOf = String.valueOf(this);
            String strValueOf2 = String.valueOf(bundle2);
            StringBuilder sb = new StringBuilder(strValueOf2.length() + strValueOf.length() + 16);
            sb.append("Finishing ");
            sb.append(strValueOf);
            sb.append(" with ");
            sb.append(strValueOf2);
            Log.d("MessengerIpcClient", sb.toString());
        }
        this.zzcq.setResult((T) bundle2);
    }

    @Override // com.google.android.gms.iid.zzz
    public final boolean zzw() {
        return false;
    }
}
