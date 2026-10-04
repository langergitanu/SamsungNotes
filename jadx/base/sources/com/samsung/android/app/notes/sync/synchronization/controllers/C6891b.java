package com.samsung.android.app.notes.sync.synchronization.controllers;

import com.samsung.android.app.notes.sync.synchronization.services.ForegroundSyncService;
import p026F1.C0099c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.controllers.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6891b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4437a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C0099c f4438b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C6892c f4439c;

    public /* synthetic */ C6891b(C6892c c6892c, C0099c c0099c, int i) {
        this.f4437a = i;
        this.f4439c = c6892c;
        this.f4438b = c0099c;
    }

    /* JADX INFO: renamed from: a */
    public final void m5088a(ForegroundSyncService foregroundSyncService) {
        switch (this.f4437a) {
            case 0:
                C6892c c6892c = this.f4439c;
                c6892c.f4441p = false;
                foregroundSyncService.requestSync(this.f4438b);
                c6892c.f4441p = true;
                break;
            default:
                C6892c c6892c2 = this.f4439c;
                c6892c2.f4441p = false;
                foregroundSyncService.requestSync(this.f4438b);
                c6892c2.f4441p = true;
                break;
        }
    }
}
