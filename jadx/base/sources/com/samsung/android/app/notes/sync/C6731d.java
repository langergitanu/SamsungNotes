package com.samsung.android.app.notes.sync;

import com.samsung.android.support.senl.p145cm.base.common.postprocessing.PostLaunchManager;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import p042J1.C0145c;
import p244u1.C14477a;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6731d implements TaskState.TaskStateListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C6751f f4093a;

    public C6731d(C6751f c6751f) {
        this.f4093a = c6751f;
    }

    @Override // com.samsung.android.support.senl.nt.base.common.task.TaskState.TaskStateListener
    public final void onTaskStateChanged(String str, boolean z) {
        TaskState.Type.Companion companion = TaskState.Type.INSTANCE;
        if ("COEDIT_SERVICE".equals(str)) {
            if (z) {
                C14477a c14477aM15065b = C14477a.m15065b();
                if (c14477aM15065b.f10283a.m5099h()) {
                    return;
                }
                c14477aM15065b.f10283a.mo5089a(111);
                return;
            }
            if (C0145c.m338w(this.f4093a.f4139a)) {
                PostLaunchManager.getInstance().executeBaseLogic(301);
                C14477a.m15065b().m15071g("requestSync() : requested by the closed coEdit service");
            }
        }
    }
}
