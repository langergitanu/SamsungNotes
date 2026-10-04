package com.samsung.android.app.notes.sync.network;

import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6853d;
import com.samsung.android.app.notes.sync.quota.OneDriverTask;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.network.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6836a implements InterfaceC6853d {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4252a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f4253b;

    public /* synthetic */ C6836a(Object obj, int i) {
        this.f4252a = i;
        this.f4253b = obj;
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6853d
    /* JADX INFO: renamed from: b */
    public final void mo5000b(int i, String str) {
        switch (this.f4252a) {
            case 0:
                ((String[]) this.f4253b)[0] = str;
                break;
            case 1:
                ((String[]) this.f4253b)[0] = str;
                break;
            case 2:
                ((String[]) this.f4253b)[0] = str;
                break;
            default:
                Debugger.m8615i("QT/OneDriverTask", "handleResponse()");
                OneDriverTask oneDriverTask = (OneDriverTask) this.f4253b;
                oneDriverTask.storeOdStatus(str);
                oneDriverTask.storeEofStatus(str);
                oneDriverTask.storeIsNewUserStatus(str);
                break;
        }
    }
}
