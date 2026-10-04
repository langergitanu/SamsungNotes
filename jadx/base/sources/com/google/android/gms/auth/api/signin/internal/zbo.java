package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zbo extends com.google.android.gms.internal.p262authapi.zbb implements zbp {
    public zbo() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    @Override // com.google.android.gms.internal.p262authapi.zbb
    public final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            zbc();
        } else {
            if (i != 2) {
                return false;
            }
            zbb();
        }
        return true;
    }
}
