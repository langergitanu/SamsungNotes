package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.play.core.internal.x */
/* JADX INFO: loaded from: classes5.dex */
public final class C5240x extends C5225i implements InterfaceC5241y {
    public C5240x(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetPackExtractionServiceCallback");
    }

    @Override // com.google.android.play.core.internal.InterfaceC5241y
    /* JADX INFO: renamed from: a */
    public final void mo4028a(Bundle bundle) {
        Parcel parcelM4009a = m4009a();
        C5227k.m4013a(parcelM4009a, bundle);
        m4010a(3, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5241y
    /* JADX INFO: renamed from: b */
    public final void mo4030b(Bundle bundle) {
        Parcel parcelM4009a = m4009a();
        C5227k.m4013a(parcelM4009a, bundle);
        m4010a(4, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5241y
    /* JADX INFO: renamed from: a */
    public final void mo4029a(Bundle bundle, Bundle bundle2) {
        Parcel parcelM4009a = m4009a();
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4013a(parcelM4009a, bundle2);
        m4010a(2, parcelM4009a);
    }
}
