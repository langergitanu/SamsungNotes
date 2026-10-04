package com.samsung.android.app.notes.sync;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import p079T.AbstractC0299q;
import p186h1.C12028i;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC6663b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3943a = 0;

    public /* synthetic */ RunnableC6663b() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3943a) {
            case 0:
                Debugger.m8615i("SyncSALoggingHelper", "doEveryWeek() : start");
                AbstractC0299q.m601K("b");
                AbstractC0299q.m601K("d");
                AbstractC0299q.m601K("e");
                AbstractC0299q.m602L("5032");
                AbstractC0299q.m602L("5033");
                AbstractC0299q.m602L("5034");
                AbstractC0299q.m602L("5035");
                AbstractC0299q.m602L("5036");
                Debugger.m8615i("SyncSALoggingHelper", "doEveryWeek() : finish");
                break;
            default:
                long jM13707a = C12028i.m13707a();
                if (jM13707a != 0) {
                    C12028i.f8793c = true;
                }
                Debugger.m8615i("SyncTimeHelper", "[Time] initServerTime() : currentServerTime = " + jM13707a);
                C12028i.f8792b = 0;
                break;
        }
    }

    public RunnableC6663b(C12028i c12028i) {
    }
}
