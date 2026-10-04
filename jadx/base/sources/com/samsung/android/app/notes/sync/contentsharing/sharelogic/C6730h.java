package com.samsung.android.app.notes.sync.contentsharing.sharelogic;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.contentsharing.sharecore.strategy.ShareSingleTask;
import com.samsung.android.app.notes.sync.contentsharing.sharehelpers.C6722e;
import com.samsung.android.app.notes.sync.infos.ModelType;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.NotificationModelContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import p001A.AbstractC0000a;
import p010C.RunnableC0037b;
import p020E.C0073a;
import p042J1.C0145c;
import p068Q.C0204a;
import p079T.AbstractC0299q;
import p086V.C0322h;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharelogic.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6730h extends AbstractC6725c {

    /* JADX INFO: renamed from: e */
    public static final ExecutorService f4090e = AbstractC4539a.m3201k("ShareLogic");

    /* JADX INFO: renamed from: f */
    public static C6722e f4091f = null;

    /* JADX INFO: renamed from: d */
    public C0073a f4092d;

    /* JADX INFO: renamed from: b */
    public static boolean m4822b() {
        C6722e c6722e = f4091f;
        boolean z = false;
        if (c6722e != null && c6722e.f4053a != 1) {
            z = true;
        }
        AbstractC4539a.m3215y("isMdeSharing : ", "ShareLogic", z);
        return z;
    }

    /* JADX INFO: renamed from: d */
    public static void m4823d() {
        Debugger.m8607d("ShareLogic", "stopShare()");
        C6722e c6722e = f4091f;
        synchronized (c6722e) {
            try {
                ShareSingleTask shareSingleTask = c6722e.f4064i;
                if (shareSingleTask != null) {
                    shareSingleTask.stop();
                    c6722e.f4064i = null;
                    if (c6722e.f4063h != null) {
                        Debugger.m8615i("SdocShareHelper", "call onShareEnded()");
                        c6722e.f4063h.mo201c();
                    }
                    if (c6722e.f4056d) {
                        c6722e.f4054b.unbindService(c6722e.f4059g);
                        c6722e.f4056d = false;
                    }
                }
                c6722e.f4053a = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sharelogic.AbstractC6725c
    /* JADX INFO: renamed from: a */
    public final void mo4817a(Message message) {
        if (message.what != 100) {
            return;
        }
        int i = message.arg1;
        Object obj = message.obj;
        AbstractC0000a.m0A(i, "startShare : msgCode = ", "ShareLogic");
        if (!C0145c.m334s(this.f4074c)) {
            if ((i & 1) != 1) {
                AbstractC0299q.m618a0(this.f4074c, Boolean.TRUE);
            }
            C0204a c0204a = new C0204a(4, "", 2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(c0204a);
            m4824c(arrayList);
            Debugger.m8615i("ShareLogic", "Skip startShare due to Network disconnected!");
        } else {
            if (!C0145c.m333r(this.f4074c)) {
                Debugger.m8607d("ShareLogic", "initializeShareData()");
                Context context = this.f4074c;
                AbstractC0299q.m618a0(context, Boolean.FALSE);
                AbstractC0299q.m615Y(context, false);
                Debugger.m8607d("ShareLogic", "removeShareUi()");
                NotificationModelContractImpl notificationModelContractImpl = C0322h.m670a().f819e;
                Context context2 = this.f4074c;
                ModelType modelType = ModelType.SHARE;
                notificationModelContractImpl.remove(context2, modelType, 0);
                C0322h.m670a().f820f.removeTipCard(context2, modelType, 0);
                String string = obj != null ? obj.toString() : null;
                C6722e c6722e = f4091f;
                ExecutorService executorService = f4090e;
                c6722e.f4054b.bindService(new Intent(c6722e.f4054b, (Class<?>) c6722e.f4057e), c6722e.f4059g, 1);
                synchronized (c6722e) {
                    try {
                        c6722e.f4055c = executorService;
                        int i2 = c6722e.f4053a;
                        if (i2 == 1) {
                            c6722e.f4053a = 2;
                            c6722e.f4058f = string;
                            new SenlThreadFactory("AbsShareHelper").newThread(new RunnableC0037b(c6722e, 4)).start();
                        } else if (i2 == 2) {
                            Debugger.m8615i("SdocShareHelper", "Share(state) is checking authorization!");
                            return;
                        } else if (i2 == 3) {
                            Debugger.m8615i("SdocShareHelper", "Share(state) is already started!");
                            return;
                        }
                        return;
                    } finally {
                    }
                }
            }
            if ((i & 1) != 1) {
                AbstractC0299q.m618a0(this.f4074c, Boolean.TRUE);
            }
            C0204a c0204a2 = new C0204a("", 9);
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(c0204a2);
            m4824c(arrayList2);
            Debugger.m8615i("ShareLogic", "Skip startShare due to wifi only share sync");
        }
        Debugger.m8616s("ShareLogic", "can't start sharing now!");
    }

    /* JADX INFO: renamed from: c */
    public final void m4824c(ArrayList arrayList) {
        Debugger.m8609e("ShareLogic", "onFailed(" + arrayList.size() + ")");
        if (f4091f.f4053a == 1) {
            Boolean bool = Boolean.TRUE;
            Context context = this.f4074c;
            AbstractC0299q.m618a0(context, bool);
            AbstractC0299q.m615Y(context, false);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((C0204a) it.next()).m487a();
        }
    }
}
