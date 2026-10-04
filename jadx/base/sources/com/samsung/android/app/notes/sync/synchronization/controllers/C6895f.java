package com.samsung.android.app.notes.sync.synchronization.controllers;

import com.samsung.android.app.notes.sync.synchronization.services.SyncOldService;
import p026F1.C0099c;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.synchronization.controllers.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6895f {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4445a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C0099c f4446b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C6896g f4447c;

    public /* synthetic */ C6895f(C6896g c6896g, C0099c c0099c, int i) {
        this.f4445a = i;
        this.f4447c = c6896g;
        this.f4446b = c0099c;
    }

    /* JADX INFO: renamed from: a */
    public final void m5094a(SyncOldService syncOldService) {
        switch (this.f4445a) {
            case 0:
                C6896g c6896g = this.f4447c;
                c6896g.f4459h = false;
                syncOldService.requestSync(this.f4446b);
                c6896g.f4459h = true;
                break;
            default:
                C6896g c6896g2 = this.f4447c;
                c6896g2.f4459h = false;
                syncOldService.requestSync(this.f4446b);
                c6896g2.f4459h = true;
                break;
        }
    }
}
