package com.samsung.android.app.notes.sync.coedit.service;

import com.google.android.gms.common.data.AbstractC4539a;
import p028G.InterfaceC0102a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.service.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6668a implements InterfaceC0102a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CoeditShareOldService f3947a;

    public C6668a(CoeditShareOldService coeditShareOldService) {
        this.f3947a = coeditShareOldService;
    }

    @Override // p028G.InterfaceC0102a
    public final void onEnded(String str, int i) {
        CoeditShareOldService coeditShareOldService = this.f3947a;
        if (coeditShareOldService.mIsSharingPended) {
            AbstractC4539a.m3190D("Deletion ended. Restart pended sharing : ", str, "CoeditShareOldService");
            coeditShareOldService.requestShareNow(str, false);
        }
        coeditShareOldService.mIsSharingPended = false;
    }

    @Override // p028G.InterfaceC0102a
    public final void onProgress(int i, int i2) {
    }

    @Override // p028G.InterfaceC0102a
    public final void onStarted(String str) {
    }
}
