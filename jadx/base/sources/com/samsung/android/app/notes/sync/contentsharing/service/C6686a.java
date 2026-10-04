package com.samsung.android.app.notes.sync.contentsharing.service;

import com.google.android.gms.common.data.AbstractC4539a;
import p063P.InterfaceC0192a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.service.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6686a implements InterfaceC0192a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ShareOldService f3988a;

    public C6686a(ShareOldService shareOldService) {
        this.f3988a = shareOldService;
    }

    @Override // p063P.InterfaceC0192a
    public final void onEnded(String str, int i) {
        ShareOldService shareOldService = this.f3988a;
        if (shareOldService.mIsSharingPended) {
            AbstractC4539a.m3190D("Deletion ended. Restart pended sharing : ", str, "ShareOldService");
            shareOldService.requestShareNow(str, false);
        }
        shareOldService.mIsSharingPended = false;
    }

    @Override // p063P.InterfaceC0192a
    public final void onStarted(String str) {
    }
}
