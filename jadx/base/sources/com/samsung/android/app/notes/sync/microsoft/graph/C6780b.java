package com.samsung.android.app.notes.sync.microsoft.graph;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import p016D0.C0059d;
import p025F0.AbstractC0089d;
import p037I0.InterfaceC0123b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.microsoft.graph.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6780b implements InterfaceC0123b {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6785g f4172a;

    public C6780b(C6785g c6785g) {
        this.f4172a = c6785g;
    }

    @Override // p037I0.InterfaceC0123b
    public final void onFailure(String str) {
        MSLogger.m8632d("GraphManager", "onFailure, " + str);
        if (str == null) {
            try {
                C0059d c0059dM139g = C0059d.m139g(BaseUtils.getApplicationContext());
                C6785g c6785g = this.f4172a;
                c6785g.getClass();
                c0059dM139g.m141d(new C6783e(c6785g));
            } catch (Exception e) {
                AbstractC6670b.m4753n(e, new StringBuilder("Failed to acquire token, "), "GraphManager");
            }
        }
    }

    @Override // p037I0.InterfaceC0123b
    public final void onSuccess(String str, String str2) {
        MSLogger.m8632d("GraphManager", "onSuccess");
        this.f4172a.f4184d = GraphManager$State.IDLE;
        AbstractC0089d.m230b(false);
    }
}
