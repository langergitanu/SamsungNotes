package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.play.core.internal.ac */
/* JADX INFO: loaded from: classes5.dex */
public abstract class AbstractBinderC5154ac extends BinderC5226j implements InterfaceC5155ad {
    public AbstractBinderC5154ac() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    @Override // com.google.android.play.core.internal.BinderC5226j
    /* JADX INFO: renamed from: a */
    public final boolean mo3868a(int i, Parcel parcel) {
        if (i != 2) {
            return false;
        }
        mo3869a((Bundle) C5227k.m4011a(parcel, Bundle.CREATOR));
        return true;
    }
}
