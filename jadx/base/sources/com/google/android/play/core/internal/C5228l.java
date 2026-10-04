package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: renamed from: com.google.android.play.core.internal.l */
/* JADX INFO: loaded from: classes5.dex */
public final class C5228l extends C5225i implements InterfaceC5230n {
    public C5228l(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    @Override // com.google.android.play.core.internal.InterfaceC5230n
    /* JADX INFO: renamed from: a */
    public final void mo4014a(String str, Bundle bundle, InterfaceC5232p interfaceC5232p) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5232p);
        m4010a(2, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5230n
    /* JADX INFO: renamed from: b */
    public final void mo4015b(String str, Bundle bundle, InterfaceC5232p interfaceC5232p) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5232p);
        m4010a(3, parcelM4009a);
    }
}
