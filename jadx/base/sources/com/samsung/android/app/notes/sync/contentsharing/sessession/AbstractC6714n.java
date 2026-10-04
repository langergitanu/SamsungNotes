package com.samsung.android.app.notes.sync.contentsharing.sessession;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.appcompat.widget.AbstractC0541b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSession;
import com.samsung.android.sdk.mobileservice.SeMobileServiceSessionFactory;
import com.samsung.android.sdk.mobileservice.SeMobileServiceVstSessionFactory;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.sync.SesUiListener;
import com.samsung.android.support.senl.p148nt.base.common.util.CommonUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.ArrayList;
import java.util.Iterator;
import p001A.AbstractC0000a;
import p012C1.RunnableC0045a;
import p086V.C0322h;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sessession.n */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC6714n {

    /* JADX INFO: renamed from: m */
    public static final ArrayList f4038m = new ArrayList();

    /* JADX INFO: renamed from: a */
    public final Context f4039a;

    /* JADX INFO: renamed from: b */
    public String f4040b;

    /* JADX INFO: renamed from: c */
    public final C6701a f4041c;

    /* JADX INFO: renamed from: d */
    public final C6702b f4042d;

    /* JADX INFO: renamed from: e */
    public final C6707g f4043e;

    /* JADX INFO: renamed from: f */
    public final C6705e f4044f;

    /* JADX INFO: renamed from: g */
    public final C6704d f4045g;

    /* JADX INFO: renamed from: h */
    public final C6704d f4046h;

    /* JADX INFO: renamed from: i */
    public final C6706f f4047i;

    /* JADX INFO: renamed from: j */
    public AbstractC6703c f4048j;

    /* JADX INFO: renamed from: k */
    public SeMobileServiceSession f4049k;

    /* JADX INFO: renamed from: l */
    public final Handler f4050l;

    public AbstractC6714n() {
        final Looper mainLooper = Looper.getMainLooper();
        this.f4050l = new Handler(mainLooper) { // from class: com.samsung.android.app.notes.sync.contentsharing.sessession.SesSessionBase$1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    Debugger.m8609e(this.this$0.mo4794a(), "[CS0-2] handleMessage, invalid MESSAGE!");
                    return;
                }
                Debugger.m8607d(this.this$0.mo4794a(), "[CS0-1] handleMessage, MESSAGE_DISCONNECT");
                AbstractC6714n abstractC6714n = this.this$0;
                abstractC6714n.getClass();
                new SenlThreadFactory("SesSession-disconnectInternal").newThread(new RunnableC6713m(abstractC6714n, SystemClock.elapsedRealtime())).start();
            }
        };
        this.f4039a = C0322h.m670a().f815a.getAppContext();
        this.f4041c = new C6701a(this);
        this.f4042d = new C6702b(this);
        this.f4043e = new C6707g(this);
        C6705e c6705e = new C6705e(this);
        this.f4044f = c6705e;
        this.f4045g = new C6704d(this, 0);
        this.f4046h = new C6704d(this, 1);
        this.f4047i = new C6706f(this);
        this.f4048j = c6705e;
    }

    /* JADX INFO: renamed from: e */
    public static C6708h m4792e(int i, SesUiListener sesUiListener) {
        ArrayList<C6708h> arrayList = f4038m;
        C6708h c6708h = null;
        if (arrayList.size() != 0) {
            for (C6708h c6708h2 : arrayList) {
                if (i == c6708h2.f4025a && sesUiListener == c6708h2.f4027c) {
                    c6708h = c6708h2;
                }
            }
        }
        return c6708h;
    }

    /* JADX INFO: renamed from: i */
    public static boolean m4793i() {
        ArrayList arrayList = f4038m;
        synchronized (arrayList) {
            try {
                if (arrayList.size() != 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        if (((C6708h) it.next()).f4026b != 0) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo4794a();

    /* JADX INFO: renamed from: b */
    public final boolean m4795b(int i, SesUiListener sesUiListener) {
        String strMo4794a = mo4794a();
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "[CS0] connect() : requestId = ", ", callee = ");
        sbM778t.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        Debugger.m8615i(strMo4794a, sbM778t.toString());
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C6708h c6708hM4799g = m4799g(i, sesUiListener);
        try {
            this.f4048j.mo4788b(this.f4049k);
            if (this.f4048j instanceof C6701a) {
                Debugger.m8615i(mo4794a(), "[CS0-1] connect() : Service is already connected!");
                m4802k();
            }
            m4804m("connect()");
            Debugger.m8615i(mo4794a(), "[CS0-1] connect() Finish, requestId = " + c6708hM4799g.f4025a + ", mConnectionCount = " + c6708hM4799g.f4026b + ", et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            return true;
        } catch (Exception e) {
            Debugger.m8609e(mo4794a(), "[CS0-2] connect() Fail, Exception = " + e.getMessage());
            m4804m("connect()");
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m4796c(int i) throws SocialException {
        int i2;
        String strMo4794a = mo4794a();
        StringBuilder sbM778t = AbstractC0541b.m778t(i, "[CS0] connect_Sync() : requestId = ", ", callee = ");
        sbM778t.append(CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        Debugger.m8615i(strMo4794a, sbM778t.toString());
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        C6708h c6708hM4799g = m4799g(i, null);
        try {
            this.f4048j.mo4788b(this.f4049k);
            if (this.f4048j instanceof C6701a) {
                Debugger.m8615i(mo4794a(), "[CS0-1] connect() Finish, Service is already connected, mConnectionCount = " + c6708hM4799g.f4026b);
                return;
            }
            try {
                Debugger.m8607d(mo4794a(), "[CS0] connect_Sync() : Wait the connecting");
            } catch (InterruptedException e) {
                Debugger.m8609e(mo4794a(), "[CS0-2] connect_Sync() : Fail, Exception = " + e.getMessage());
            }
            for (i2 = 0; i2 < 100; i2++) {
                Thread.sleep(500L);
                AbstractC6703c abstractC6703c = this.f4048j;
                if (abstractC6703c instanceof C6701a) {
                    Debugger.m8615i(mo4794a(), "[CS0-1] connect_Sync() Finish to connect : mConnectionCount = " + c6708hM4799g.f4026b + " , et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                    return;
                }
                if (abstractC6703c instanceof C6705e) {
                    Debugger.m8609e(mo4794a(), "[CS0-2] connect_Sync() Fail, DisConnectedState : et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                }
                Debugger.m8609e(mo4794a(), "[CS0-2] connect_Sync() Fail, et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
                throw new SocialException("Fail to connect SES Session!");
            }
            Debugger.m8609e(mo4794a(), "[CS0-2] connect_Sync() Fail, et = " + (SystemClock.elapsedRealtime() - jElapsedRealtime));
            throw new SocialException("Fail to connect SES Session!");
        } catch (Exception e2) {
            Debugger.m8609e(mo4794a(), "[CS0-2] connect_Sync() : Fail, Exception = " + e2.getMessage());
            throw new SocialException(AbstractC2322a.m1619i(e2, new StringBuilder("Fail to connect SES Session : ")));
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m4797d(int i, SesUiListener sesUiListener) {
        C6708h c6708hM4792e;
        AbstractC0000a.m0A(i, "[CS0] disConnect() Start, requestId = ", mo4794a());
        ArrayList arrayList = f4038m;
        synchronized (arrayList) {
            try {
                c6708hM4792e = m4792e(i, sesUiListener);
                if (c6708hM4792e == null) {
                    Debugger.m8609e(mo4794a(), "[CS0-1] disConnect() : no listener of " + i);
                } else {
                    int i2 = c6708hM4792e.f4026b;
                    if (i2 > 0) {
                        c6708hM4792e.f4026b = i2 - 1;
                    }
                }
            } finally {
            }
        }
        if (m4793i()) {
            this.f4048j.mo4790c(this.f4049k);
        }
        if (c6708hM4792e == null) {
            Debugger.m8609e(mo4794a(), "[CS0-1] disConnect() Finish, no listener!");
        } else {
            synchronized (arrayList) {
                try {
                    if (c6708hM4792e.f4026b == 0) {
                        arrayList.remove(c6708hM4792e);
                    }
                } finally {
                }
            }
            Debugger.m8615i(mo4794a(), "[CS0-1] disConnect() Finish, requestId = " + c6708hM4792e.f4025a + ", mConnectionCount = " + c6708hM4792e.f4026b);
        }
        m4804m("disConnect()");
    }

    /* JADX INFO: renamed from: f */
    public final SeMobileServiceSession m4798f() {
        if (this.f4048j instanceof C6701a) {
            return this.f4049k;
        }
        Debugger.m8615i(mo4794a(), "[CS0] getSession() : Not connected yet <- " + this.f4048j.toString() + " , callee = " + CommonUtils.getCallee(Thread.currentThread().getStackTrace()));
        return null;
    }

    /* JADX INFO: renamed from: g */
    public final C6708h m4799g(int i, SesUiListener sesUiListener) {
        C6708h c6708hM4792e;
        ArrayList arrayList = f4038m;
        synchronized (arrayList) {
            try {
                c6708hM4792e = m4792e(i, sesUiListener);
                if (c6708hM4792e == null) {
                    c6708hM4792e = new C6708h();
                    c6708hM4792e.f4026b = 0;
                    c6708hM4792e.f4028d = false;
                    c6708hM4792e.f4025a = i;
                    c6708hM4792e.f4027c = sesUiListener;
                    arrayList.add(c6708hM4792e);
                }
                c6708hM4792e.f4026b++;
                if (c6708hM4792e.f4028d) {
                    Debugger.m8615i(mo4794a(), "[CS0] handleConnectListener() : Connected state was notified but reset!");
                    c6708hM4792e.f4028d = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c6708hM4792e;
    }

    /* JADX INFO: renamed from: h */
    public final void m4800h() {
        Debugger.m8607d(mo4794a(), "initializeAll()");
        boolean zIsVSTModel = DeviceInfo.isVSTModel();
        Context context = this.f4039a;
        SeMobileServiceSession seMobileServiceSessionBuild = zIsVSTModel ? new SeMobileServiceVstSessionFactory(context, new C6709i(this)).addService("SocialService").setAppId(this.f4040b).build() : new SeMobileServiceSessionFactory(context, new C6709i(this)).addService("AuthService").addService("SocialService").addService("ProfileService").setAppId(this.f4040b).build();
        this.f4049k = seMobileServiceSessionBuild;
        seMobileServiceSessionBuild.setSessionListener(new C6710j(this));
        this.f4049k.setOnAgentUpdatedListener(new C6711k(this));
    }

    /* JADX INFO: renamed from: j */
    public final boolean m4801j() {
        if (this.f4048j instanceof C6701a) {
            return true;
        }
        Debugger.m8615i(mo4794a(), "[CS0] isConnected() : Session is not connected <- ".concat(this.f4048j.toString()));
        return false;
    }

    /* JADX INFO: renamed from: k */
    public final void m4802k() {
        ArrayList<C6708h> arrayList = f4038m;
        synchronized (arrayList) {
            try {
                for (C6708h c6708h : arrayList) {
                    if (c6708h.f4027c != null && !c6708h.f4028d) {
                        new SenlThreadFactory("notifyConnectedState").newThread(new RunnableC0045a(this, c6708h, 5)).start();
                    }
                }
            } catch (Exception e) {
                Debugger.m8609e(mo4794a(), "[CS0-1] Exception : " + e.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: l */
    public final void m4803l(int i) {
        ArrayList<C6708h> arrayList = f4038m;
        synchronized (arrayList) {
            try {
                for (C6708h c6708h : arrayList) {
                    if (c6708h.f4027c != null) {
                        new SenlThreadFactory("notifyFailedState").newThread(new RunnableC6712l(this, c6708h, i)).start();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: m */
    public final void m4804m(String str) {
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
            sb.append(" -> \n");
        }
        ArrayList<C6708h> arrayList = f4038m;
        synchronized (arrayList) {
            try {
                for (C6708h c6708h : arrayList) {
                    try {
                        sb.append("requestId = ");
                        sb.append(c6708h.f4025a);
                        sb.append(SQLKeyword.COMMA);
                        sb.append("connectionCount = ");
                        sb.append(c6708h.f4026b);
                        sb.append(SQLKeyword.COMMA);
                        sb.append(c6708h.f4027c == null ? " " : "sesUiListener exists");
                        sb.append(SQLKeyword.COMMA);
                        sb.append("isConnectedStateNotified = ");
                        sb.append(c6708h.f4028d);
                        sb.append(";\n");
                    } catch (Exception e) {
                        Debugger.m8609e(mo4794a(), "[CS0-1] printSesListenerInfo() : Exception = " + e.getMessage());
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        Debugger.m8615i(mo4794a(), "[CS0] printSesListenerInfo() : " + ((Object) sb));
    }

    /* JADX INFO: renamed from: n */
    public final void m4805n() {
        Handler handler = this.f4050l;
        if (handler.hasMessages(1)) {
            handler.removeMessages(1);
            Debugger.m8615i(mo4794a(), "[CS0] Remove previous disconnect msg");
        }
    }

    /* JADX INFO: renamed from: o */
    public final void m4806o(boolean z) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        Handler handler = this.f4050l;
        if (handler.hasMessages(1)) {
            handler.removeMessages(messageObtain.what);
            Debugger.m8615i(mo4794a(), "[CS0] Remove previous disconnect msg");
        }
        Debugger.m8615i(mo4794a(), "[CS0] Send disconnect msg : isNow = " + z);
        if (z) {
            handler.sendMessage(messageObtain);
        } else {
            handler.sendMessageDelayed(messageObtain, 120000L);
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m4807p(AbstractC6703c abstractC6703c) {
        if (abstractC6703c == null) {
            Debugger.m8609e(mo4794a(), "setState() : No state!");
        } else {
            Debugger.m8615i(mo4794a(), "setState() : ".concat(abstractC6703c.toString()));
            this.f4048j = abstractC6703c;
        }
    }
}
