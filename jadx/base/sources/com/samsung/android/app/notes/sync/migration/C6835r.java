package com.samsung.android.app.notes.sync.migration;

import com.samsung.android.support.senl.p148nt.base.common.startmanager.CoeditStartManager;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.ComposerStartManager;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.MainListStartManager;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.ModelStartManager;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.SyncStartManager;
import java.util.Timer;
import p079T.AbstractC0299q;
import p186h1.C12021b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.migration.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6835r {

    /* JADX INFO: renamed from: f */
    public static final String f4246f = "SS$".concat("MigrationScheduler");

    /* JADX INFO: renamed from: a */
    public final C6789b f4247a;

    /* JADX INFO: renamed from: b */
    public C12021b f4248b;

    /* JADX INFO: renamed from: c */
    public Timer f4249c;

    /* JADX INFO: renamed from: d */
    public Timer f4250d;

    /* JADX INFO: renamed from: e */
    public MigrationScheduler$State f4251e = MigrationScheduler$State.NONE;

    public C6835r(C6789b c6789b) {
        this.f4247a = c6789b;
    }

    /* JADX INFO: renamed from: a */
    public static void m4996a(C6835r c6835r) {
        synchronized (c6835r) {
            long count = c6835r.f4248b.getCount();
            AbstractC0299q.m643n(f4246f, "latchDown count " + count + " > " + (count - 1));
            c6835r.f4248b.countDown();
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m4997d(long j) {
        ComposerStartManager.INSTANCE.getInstance().setFinalBlockTimeToStartComposer(j);
        SyncStartManager.INSTANCE.setFinalBlockTimeToStartSync(j);
        ModelStartManager.INSTANCE.setFinalBlockTime(j);
        MainListStartManager.INSTANCE.getInstance().setFinalBlockTime(j);
        CoeditStartManager.INSTANCE.setFinalBlockTimeToStartSync(j);
    }

    /* JADX INFO: renamed from: b */
    public final boolean m4998b(MigrationScheduler$State migrationScheduler$State) {
        MigrationScheduler$State migrationScheduler$State2 = this.f4251e;
        AbstractC0299q.m643n(f4246f, "isValidState checkState/currentState " + migrationScheduler$State + "/" + migrationScheduler$State2);
        int i = AbstractC6834q.f4245a[migrationScheduler$State.ordinal()];
        return ((i == 1 || i == 2) && migrationScheduler$State2 == MigrationScheduler$State.NONE) ? false : true;
    }

    /* JADX INFO: renamed from: c */
    public final void m4999c() {
        AbstractC0299q.m643n(f4246f, "onFinish");
        MigrationScheduler$State migrationScheduler$State = MigrationScheduler$State.FINISH;
        if (m4998b(migrationScheduler$State)) {
            this.f4251e = migrationScheduler$State;
            Timer timer = this.f4249c;
            if (timer != null) {
                timer.cancel();
            }
            Timer timer2 = this.f4250d;
            if (timer2 != null) {
                timer2.cancel();
            }
            m4997d(System.currentTimeMillis());
        }
    }
}
