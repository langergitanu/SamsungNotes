package com.samsung.android.support.senl.p148nt.app.sync.contractimpl;

import com.samsung.android.app.notes.sync.synchronization.controllers.C6896g;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p010C.C0042g;
import p244u1.C14477a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SyncManagerContractImpl {
    public void requestSyncBackground() {
        C14477a.m15065b().m15071g(null);
    }

    public void setSyncEnable(boolean z, boolean z2) {
        C6896g c6896g = C14477a.m15065b().f10283a;
        c6896g.m5102l(z, z2, false);
        C0042g c0042gM78a = C0042g.m78a(c6896g.f4454c);
        if (c0042gM78a.m79b()) {
            c0042gM78a.f186b.mo68e(z);
        } else {
            Debugger.m8609e("SCRPCSettingManager", "notifyAutoSyncChanged() : fail!");
        }
    }
}
