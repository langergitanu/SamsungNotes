package com.samsung.android.app.notes.sync.importing.controllers;

import com.samsung.android.app.notes.sync.importing.services.ImportService;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.importing.controllers.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6753b implements InterfaceC6755d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4148a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f4149b;

    public C6753b(int i, int i2) {
        this.f4148a = i;
        this.f4149b = i2;
    }

    @Override // com.samsung.android.app.notes.sync.importing.controllers.InterfaceC6755d
    /* JADX INFO: renamed from: b */
    public final void mo4893b(ImportService importService) {
        importService.onNetworkConnectionFailedDialogFinish(this.f4148a, this.f4149b);
    }
}
