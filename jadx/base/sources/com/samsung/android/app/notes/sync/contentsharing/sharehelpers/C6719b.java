package com.samsung.android.app.notes.sync.contentsharing.sharehelpers;

import com.samsung.android.app.notes.sync.contentsharing.deletecore.MdeDeleteSDocTask;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p056N.InterfaceC0179a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharehelpers.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6719b extends AbstractC6720c implements InterfaceC0179a {
    @Override // com.samsung.android.app.notes.sync.contentsharing.sharehelpers.AbstractC6718a
    /* JADX INFO: renamed from: i */
    public final void mo4812i(String str) {
        Debugger.m8616s("MdeSdocDeleteHelper", "Finish getting account id : ".concat(str));
        synchronized (this) {
            MdeDeleteSDocTask mdeDeleteSDocTask = new MdeDeleteSDocTask(this.f4058f, this.f4062j, this);
            this.f4061i = mdeDeleteSDocTask;
            this.f4053a = 3;
            mdeDeleteSDocTask.executeOnExecutor(this.f4055c, new Void[0]);
        }
    }

    @Override // p056N.InterfaceC0179a
    public final void onDeleteLocalSharedSdocFinished() {
        Debugger.m8607d("MdeSdocDeleteHelper", "onDeleteLocalSharedSdocFinished()");
        synchronized (this) {
            try {
                if (this.f4056d) {
                    this.f4054b.unbindService(this.f4059g);
                    this.f4056d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
