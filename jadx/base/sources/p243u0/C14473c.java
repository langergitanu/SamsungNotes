package p243u0;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.task.TaskState;
import p042J1.C0145c;

/* JADX INFO: renamed from: u0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14473c extends AbstractC14471a {
    @Override // p243u0.AbstractC14471a
    /* JADX INFO: renamed from: f */
    public final void mo15053f() {
        m15061j();
    }

    @Override // p243u0.AbstractC14471a
    /* JADX INFO: renamed from: g */
    public final void mo15054g() {
        m15061j();
    }

    /* JADX INFO: renamed from: j */
    public final void m15061j() {
        Context context = (Context) this.f4022a;
        if (!C0145c.m338w(context)) {
            C0145c.m309Q(context, Boolean.TRUE);
        }
        TaskState.Companion companion = TaskState.INSTANCE;
        TaskState companion2 = companion.getInstance();
        TaskState.Type.Companion companion3 = TaskState.Type.INSTANCE;
        if (companion2.isRunning("CONVERT")) {
            Debugger.m8609e("SyncErrorSyncBlockedByInternalTasks", "Fail to sync due to Converting");
        } else if (companion.getInstance().isRunning("RESTORE_TASK")) {
            Debugger.m8609e("SyncErrorSyncBlockedByInternalTasks", "Fail to sync due to Restoring");
        } else if (companion.getInstance().isRunning("COEDIT_SERVICE")) {
            Debugger.m8609e("SyncErrorSyncBlockedByInternalTasks", "Fail to sync due to Composing a coEdit note");
        } else {
            Debugger.m8609e("SyncErrorSyncBlockedByInternalTasks", "Fail to sync due to the unknown type");
        }
        m15056i();
    }
}
