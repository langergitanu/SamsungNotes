package com.samsung.android.app.notes.sync.contentsharing.sharehelpers;

import com.samsung.android.app.notes.sync.contentsharing.importcore.strategy.MdeImportSingleTask;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharehelpers.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6721d extends AbstractC6720c {
    @Override // com.samsung.android.app.notes.sync.contentsharing.sharehelpers.AbstractC6718a
    /* JADX INFO: renamed from: i */
    public final void mo4812i(String str) {
        Debugger.m8616s("MdeSdocImportHelper", "Finish getting account id : ".concat(str));
        synchronized (this) {
            MdeImportSingleTask mdeImportSingleTask = new MdeImportSingleTask(this.f4054b, this, this.f4058f, this.f4062j);
            this.f4061i = mdeImportSingleTask;
            this.f4053a = 3;
            mdeImportSingleTask.executeOnExecutor(this.f4055c, new Void[0]);
        }
    }
}
