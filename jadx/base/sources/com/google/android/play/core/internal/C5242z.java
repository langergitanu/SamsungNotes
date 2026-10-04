package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.play.core.internal.z */
/* JADX INFO: loaded from: classes5.dex */
public final class C5242z extends C5225i implements InterfaceC5153ab {
    public C5242z(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.inappreview.protocol.IInAppReviewService");
    }

    @Override // com.google.android.play.core.internal.InterfaceC5153ab
    /* JADX INFO: renamed from: a */
    public final void mo3867a(String str, Bundle bundle, InterfaceC5155ad interfaceC5155ad) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5155ad);
        m4010a(2, parcelM4009a);
    }
}
