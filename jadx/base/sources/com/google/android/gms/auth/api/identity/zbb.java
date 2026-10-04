package com.google.android.gms.auth.api.identity;

import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class zbb {
    private String zba;

    private zbb() {
    }

    public static final zbb zbc(zbc zbcVar) {
        String strZbb = zbcVar.zbb();
        zbb zbbVar = new zbb();
        if (strZbb != null) {
            zbbVar.zba = Preconditions.checkNotEmpty(strZbb);
        }
        return zbbVar;
    }

    public final zbb zba(@NonNull String str) {
        this.zba = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zbc zbb() {
        return new zbc(this.zba);
    }

    public /* synthetic */ zbb(zba zbaVar) {
    }
}
