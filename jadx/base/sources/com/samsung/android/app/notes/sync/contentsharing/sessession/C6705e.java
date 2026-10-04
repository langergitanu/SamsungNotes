package com.samsung.android.app.notes.sync.contentsharing.sessession;

import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6705e extends AbstractC6703c {
    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: a */
    public final String mo4787a() {
        return ((AbstractC6714n) this.f4022a).mo4794a().concat("$DisConnectedState");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: c */
    public final void mo4790c(SeMobileServiceSession seMobileServiceSession) {
        Debugger.m8609e(mo4787a(), "[CS0-1] disConnect() : already disconnected");
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sessession.AbstractC6703c
    /* JADX INFO: renamed from: e */
    public final void mo4789e(SeMobileServiceSession seMobileServiceSession) {
        Debugger.m8609e(mo4787a(), "[CS0-2] reConnect() : already disconnected");
    }

    public final String toString() {
        return "DisConnectedState";
    }
}
