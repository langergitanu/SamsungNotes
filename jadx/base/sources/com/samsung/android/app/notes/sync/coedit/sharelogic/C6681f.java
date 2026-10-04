package com.samsung.android.app.notes.sync.coedit.sharelogic;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.CoeditShareSingleTask;
import com.samsung.android.app.notes.sync.coedit.sharehelpers.C6675e;
import com.samsung.android.app.notes.sync.infos.ModelType;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.NotificationModelContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import p010C.RunnableC0037b;
import p042J1.C0145c;
import p068Q.C0204a;
import p079T.AbstractC0299q;
import p086V.C0322h;
import p234q1.C14433b;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharelogic.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6681f extends AbstractC6678c {

    /* JADX INFO: renamed from: e */
    public static final ExecutorService f3980e = AbstractC4539a.m3201k("CoeditShareLogic");

    /* JADX INFO: renamed from: f */
    public static final ArrayList f3981f = new ArrayList();

    /* JADX INFO: renamed from: g */
    public static C6675e f3982g = null;

    /* JADX INFO: renamed from: d */
    public C14433b f3983d;

    /* JADX INFO: renamed from: c */
    public static void m4775c() {
        Debugger.m8607d("CoeditShareLogic", "stopShare()");
        C6675e c6675e = f3982g;
        synchronized (c6675e) {
            try {
                CoeditShareSingleTask coeditShareSingleTask = c6675e.f3959i;
                if (coeditShareSingleTask != null) {
                    coeditShareSingleTask.stop();
                    c6675e.f3959i = null;
                    if (c6675e.f3958h != null) {
                        Debugger.m8615i("CoeditSdocShareHelper", "call onShareEnded()");
                        c6675e.f3958h.mo4733c();
                    }
                    if (c6675e.f3951d) {
                        c6675e.f3949b.unbindService(c6675e.f3954g);
                        c6675e.f3951d = false;
                    }
                }
                c6675e.f3948a = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.coedit.sharelogic.AbstractC6678c
    /* JADX INFO: renamed from: a */
    public final void mo4773a(Message message) {
        if (message.what != 100) {
            return;
        }
        int i = message.arg1;
        Object obj = message.obj;
        Debugger.m8615i("CoeditShareLogic", "startShare : msgCode = " + i);
        System.currentTimeMillis();
        if (!C0145c.m334s(this.f3969c)) {
            if ((i & 1) != 1) {
                AbstractC0299q.m618a0(this.f3969c, Boolean.TRUE);
            }
            C0204a c0204a = new C0204a(4, "", 2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0204a);
            m4776b(arrayList);
            Debugger.m8615i("CoeditShareLogic", "Skip startShare due to Network disconnected!");
            Debugger.m8616s("CoeditShareLogic", "can't start sharing now!");
            return;
        }
        Debugger.m8607d("CoeditShareLogic", "initializeShareData()");
        Context context = this.f3969c;
        AbstractC0299q.m618a0(context, Boolean.FALSE);
        AbstractC0299q.m615Y(context, false);
        Debugger.m8607d("CoeditShareLogic", "removeShareUi()");
        NotificationModelContractImpl notificationModelContractImpl = C0322h.m670a().f819e;
        Context context2 = this.f3969c;
        ModelType modelType = ModelType.SHARE;
        notificationModelContractImpl.remove(context2, modelType, 0);
        C0322h.m670a().f820f.removeTipCard(context2, modelType, 0);
        String string = obj != null ? obj.toString() : null;
        C6675e c6675e = f3982g;
        ExecutorService executorService = f3980e;
        c6675e.f3949b.bindService(new Intent(c6675e.f3949b, (Class<?>) c6675e.f3952e), c6675e.f3954g, 1);
        synchronized (c6675e) {
            try {
                c6675e.f3950c = executorService;
                int i2 = c6675e.f3948a;
                if (i2 == 1) {
                    c6675e.f3948a = 2;
                    c6675e.f3953f = string;
                    new SenlThreadFactory("CoeditAbsShareHelper").newThread(new RunnableC0037b(c6675e, 3)).start();
                } else if (i2 == 2) {
                    Debugger.m8615i("CoeditSdocShareHelper", "Share(state) is checking authorization!");
                } else if (i2 == 3) {
                    Debugger.m8615i("CoeditSdocShareHelper", "Share(state) is already started!");
                }
            } finally {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m4776b(ArrayList arrayList) {
        Debugger.m8609e("CoeditShareLogic", "onFailed(" + arrayList.size() + ")");
        if (f3982g.f3948a == 1) {
            Boolean bool = Boolean.TRUE;
            Context context = this.f3969c;
            AbstractC0299q.m618a0(context, bool);
            AbstractC0299q.m615Y(context, false);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C0204a) it.next()).m487a();
        }
    }
}
