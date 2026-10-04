package com.samsung.android.app.notes.sync.contentsharing.sessession;

import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6701a extends AbstractC6703c {
    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: a */
    public final String mo4787a() {
        return ((AbstractC6714n) this.f4022a).mo4794a().concat("$ConnectedState");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: b */
    public final void mo4788b(SeMobileServiceSession seMobileServiceSession) {
        Debugger.m8615i(mo4787a(), "[CS0-1] connect() : already connected");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: e */
    public final void mo4789e(SeMobileServiceSession seMobileServiceSession) {
        Debugger.m8615i(mo4787a(), "[CS0-1] reConnect() : already connected");
    }

    public final String toString() {
        return "ConnectedState";
    }
}
