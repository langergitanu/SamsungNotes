package com.samsung.android.app.notes.sync.coedit.sharehelpers;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharehelpers.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6674d extends AbstractC6673c {
    @Override // com.samsung.android.app.notes.sync.coedit.sharehelpers.AbstractC6671a
    /* JADX INFO: renamed from: i */
    public final void mo4768i(String str) {
        Debugger.m8616s("MdeSdocImportHelper", "Finish getting account id : ".concat(str));
        synchronized (this) {
            this.f3948a = 3;
            this.f3956i.executeOnExecutor(this.f3950c, new Void[0]);
        }
    }
}
