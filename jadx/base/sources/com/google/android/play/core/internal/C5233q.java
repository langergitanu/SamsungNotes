package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.internal.q */
/* JADX INFO: loaded from: classes5.dex */
public final class C5233q extends C5225i implements InterfaceC5235s {
    public C5233q(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    @Override // com.google.android.play.core.internal.InterfaceC5235s
    /* JADX INFO: renamed from: a */
    public final void mo4017a(String str, Bundle bundle, Bundle bundle2, InterfaceC5237u interfaceC5237u) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4013a(parcelM4009a, bundle2);
        C5227k.m4012a(parcelM4009a, interfaceC5237u);
        m4010a(6, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5235s
    /* JADX INFO: renamed from: b */
    public final void mo4020b(String str, Bundle bundle, Bundle bundle2, InterfaceC5237u interfaceC5237u) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4013a(parcelM4009a, bundle2);
        C5227k.m4012a(parcelM4009a, interfaceC5237u);
        m4010a(7, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5235s
    /* JADX INFO: renamed from: c */
    public final void mo4023c(String str, Bundle bundle, Bundle bundle2, InterfaceC5237u interfaceC5237u) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4013a(parcelM4009a, bundle2);
        C5227k.m4012a(parcelM4009a, interfaceC5237u);
        m4010a(9, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5235s
    /* JADX INFO: renamed from: d */
    public final void mo4025d(String str, Bundle bundle, Bundle bundle2, InterfaceC5237u interfaceC5237u) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4013a(parcelM4009a, bundle2);
        C5227k.m4012a(parcelM4009a, interfaceC5237u);
        m4010a(11, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5235s
    /* JADX INFO: renamed from: e */
    public final void mo4026e(String str, Bundle bundle, Bundle bundle2, InterfaceC5237u interfaceC5237u) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4013a(parcelM4009a, bundle2);
        C5227k.m4012a(parcelM4009a, interfaceC5237u);
        m4010a(13, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5235s
    /* JADX INFO: renamed from: a */
    public final void mo4018a(String str, Bundle bundle, InterfaceC5237u interfaceC5237u) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5237u);
        m4010a(5, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5235s
    /* JADX INFO: renamed from: b */
    public final void mo4021b(String str, Bundle bundle, InterfaceC5237u interfaceC5237u) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5237u);
        m4010a(10, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5235s
    /* JADX INFO: renamed from: c */
    public final void mo4024c(String str, List<Bundle> list, Bundle bundle, InterfaceC5237u interfaceC5237u) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        parcelM4009a.writeTypedList(list);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5237u);
        m4010a(12, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5235s
    /* JADX INFO: renamed from: a */
    public final void mo4019a(String str, List<Bundle> list, Bundle bundle, InterfaceC5237u interfaceC5237u) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        parcelM4009a.writeTypedList(list);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5237u);
        m4010a(2, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5235s
    /* JADX INFO: renamed from: b */
    public final void mo4022b(String str, List<Bundle> list, Bundle bundle, InterfaceC5237u interfaceC5237u) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        parcelM4009a.writeTypedList(list);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5237u);
        m4010a(14, parcelM4009a);
    }
}
