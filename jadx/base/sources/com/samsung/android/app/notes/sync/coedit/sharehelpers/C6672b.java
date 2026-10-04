package com.samsung.android.app.notes.sync.coedit.sharehelpers;

import com.samsung.android.app.notes.sync.coedit.deletecore.CoeditDeleteSDocTask;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p024F.InterfaceC0085b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharehelpers.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6672b extends AbstractC6673c implements InterfaceC0085b {
    @Override // com.samsung.android.app.notes.sync.coedit.sharehelpers.AbstractC6671a
    /* JADX INFO: renamed from: i */
    public final void mo4768i(String str) {
        Debugger.m8616s("MdeSdocDeleteHelper", "Finish getting account id : ".concat(str));
        synchronized (this) {
            CoeditDeleteSDocTask coeditDeleteSDocTask = new CoeditDeleteSDocTask(this.f3953f, this.f3957j, this);
            this.f3956i = coeditDeleteSDocTask;
            this.f3948a = 3;
            coeditDeleteSDocTask.executeOnExecutor(this.f3950c, new Void[0]);
        }
    }

    @Override // p024F.InterfaceC0085b
    public final void onDeleteLocalSharedSdocFinished() {
        Debugger.m8607d("MdeSdocDeleteHelper", "onDeleteLocalSharedSdocFinished()");
        synchronized (this) {
            try {
                if (this.f3951d) {
                    this.f3949b.unbindService(this.f3954g);
                    this.f3951d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
