package com.samsung.android.app.notes.sync.saccount.samsungaccountclient;

import com.samsung.android.app.notes.sync.saccount.SAccountException;
import com.samsung.android.support.senl.p148nt.base.common.sync.SamsungAccountUtil;
import p207n1.C13534a;
import p207n1.C13537d;
import p212o1.C13573a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.saccount.samsungaccountclient.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6885l implements InterfaceC6874a {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C13537d f4423a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ C13573a f4424b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ C6883j f4425c;

    public C6885l(C6883j c6883j, C13537d c13537d, C13573a c13573a) {
        this.f4425c = c6883j;
        this.f4423a = c13537d;
        this.f4424b = c13573a;
    }

    @Override // com.samsung.android.app.notes.sync.saccount.samsungaccountclient.InterfaceC6874a
    /* JADX INFO: renamed from: a */
    public final void mo5061a(C13534a c13534a) {
        C13537d c13537d = this.f4423a;
        try {
            if (c13534a.f9558c) {
                throw new SAccountException("404", "Invalid auth info!");
            }
            c13537d.f9573g = c13534a.f9556a;
            c13537d.f9572f = SamsungAccountUtil.getApplicationRegion();
            C6877d.m5071a().m5073c(c13537d, this.f4424b);
        } catch (Exception e) {
            this.f4425c.m5080e(e);
        }
    }
}
