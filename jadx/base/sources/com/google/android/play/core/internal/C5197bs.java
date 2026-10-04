package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.List;

/* JADX INFO: renamed from: com.google.android.play.core.internal.bs */
/* JADX INFO: loaded from: classes5.dex */
public final class C5197bs extends C5225i implements InterfaceC5199bu {
    public C5197bs(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    @Override // com.google.android.play.core.internal.InterfaceC5199bu
    /* JADX INFO: renamed from: a */
    public final void mo3950a(String str, int i, Bundle bundle, InterfaceC5201bw interfaceC5201bw) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        parcelM4009a.writeInt(i);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5201bw);
        m4010a(4, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5199bu
    /* JADX INFO: renamed from: b */
    public final void mo3954b(String str, List<Bundle> list, Bundle bundle, InterfaceC5201bw interfaceC5201bw) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        parcelM4009a.writeTypedList(list);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5201bw);
        m4010a(7, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5199bu
    /* JADX INFO: renamed from: c */
    public final void mo3955c(String str, List<Bundle> list, Bundle bundle, InterfaceC5201bw interfaceC5201bw) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        parcelM4009a.writeTypedList(list);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5201bw);
        m4010a(8, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5199bu
    /* JADX INFO: renamed from: d */
    public final void mo3956d(String str, List<Bundle> list, Bundle bundle, InterfaceC5201bw interfaceC5201bw) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        parcelM4009a.writeTypedList(list);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5201bw);
        m4010a(13, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5199bu
    /* JADX INFO: renamed from: e */
    public final void mo3957e(String str, List<Bundle> list, Bundle bundle, InterfaceC5201bw interfaceC5201bw) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        parcelM4009a.writeTypedList(list);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5201bw);
        m4010a(14, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5199bu
    /* JADX INFO: renamed from: a */
    public final void mo3951a(String str, int i, InterfaceC5201bw interfaceC5201bw) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        parcelM4009a.writeInt(i);
        C5227k.m4012a(parcelM4009a, interfaceC5201bw);
        m4010a(5, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5199bu
    /* JADX INFO: renamed from: a */
    public final void mo3952a(String str, InterfaceC5201bw interfaceC5201bw) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        C5227k.m4012a(parcelM4009a, interfaceC5201bw);
        m4010a(6, parcelM4009a);
    }

    @Override // com.google.android.play.core.internal.InterfaceC5199bu
    /* JADX INFO: renamed from: a */
    public final void mo3953a(String str, List<Bundle> list, Bundle bundle, InterfaceC5201bw interfaceC5201bw) {
        Parcel parcelM4009a = m4009a();
        parcelM4009a.writeString(str);
        parcelM4009a.writeTypedList(list);
        C5227k.m4013a(parcelM4009a, bundle);
        C5227k.m4012a(parcelM4009a, interfaceC5201bw);
        m4010a(2, parcelM4009a);
    }
}
