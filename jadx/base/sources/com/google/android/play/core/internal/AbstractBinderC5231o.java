package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.play.core.internal.o */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinderC5231o extends BinderC5226j implements InterfaceC5232p {
    public AbstractBinderC5231o() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // com.google.android.play.core.internal.BinderC5226j
    /* JADX INFO: renamed from: a */
    public final boolean mo3868a(int i, Parcel parcel) {
        if (i == 2) {
            mo3596a((Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
            return true;
        }
        if (i != 3) {
            return false;
        }
        mo3597b((Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
        return true;
    }
}
