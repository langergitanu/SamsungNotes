package com.samsung.android.app.notes.sync.importing.controllers;

import com.samsung.android.app.notes.sync.importing.services.ImportService;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.importing.controllers.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6752a implements InterfaceC6755d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ boolean f4146a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ boolean f4147b;

    public C6752a(boolean z, boolean z2) {
        this.f4146a = z;
        this.f4147b = z2;
    }

    @Override // com.samsung.android.app.notes.sync.importing.controllers.InterfaceC6755d
    /* JADX INFO: renamed from: b */
    public final void mo4893b(ImportService importService) {
        importService.onNetworkConnected(this.f4146a, this.f4147b);
    }
}
