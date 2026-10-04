package com.samsung.android.app.notes.sync.coedit.sharelogic;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.util.SparseBooleanArray;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.lang.ref.WeakReference;
import p086V.C0322h;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.coedit.sharelogic.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6677b {

    /* JADX INFO: renamed from: a */
    public final WeakReference f3962a;

    /* JADX INFO: renamed from: b */
    public final ServiceConnection f3963b = new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.coedit.sharelogic.CoeditBaseLogic$CoeditBaseLogicHandler$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Debugger.m8607d("CoeditBaseLogic", "SelfBind connected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Debugger.m8607d("CoeditBaseLogic", "SelfBind disconnected");
        }
    };

    /* JADX INFO: renamed from: d */
    public final SparseBooleanArray f3965d = new SparseBooleanArray();

    /* JADX INFO: renamed from: e */
    public final Handler f3966e = new CoeditBaseLogic$CoeditBaseLogicHandler$2(this);

    /* JADX INFO: renamed from: c */
    public final Context f3964c = C0322h.m670a().f815a.getAppContext();

    public C6677b(AbstractC6678c abstractC6678c) {
        this.f3962a = new WeakReference(abstractC6678c);
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m4771a(int i) {
        Context context;
        try {
            if (this.f3965d.size() == 0) {
                Debugger.m8615i("CoeditBaseLogic", "selfBind() call bindService()");
                AbstractC6678c abstractC6678c = (AbstractC6678c) this.f3962a.get();
                if (abstractC6678c != null && abstractC6678c.f3967a != null && (context = this.f3964c) != null) {
                    context.bindService(new Intent(this.f3964c, (Class<?>) abstractC6678c.f3967a), this.f3963b, 1);
                }
            }
            this.f3965d.put(i, true);
            Debugger.m8607d("CoeditBaseLogic", "selfBind() count:" + this.f3965d.size() + " what:" + i);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[Catch: all -> 0x002b, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x0019, B:8:0x0025, B:14:0x0036, B:13:0x002e), top: B:21:0x0004, inners: #0 }] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void m4772b(int i) {
        Context context;
        Debugger.m8615i("CoeditBaseLogic", "selfUnbind() start");
        this.f3965d.delete(i);
        if (this.f3965d.size() == 0) {
            try {
                Debugger.m8615i("CoeditBaseLogic", "selfUnbind() call unbindService()");
                context = this.f3964c;
            } catch (IllegalArgumentException e) {
                Debugger.m8610e("CoeditBaseLogic", "selfUnbind() unbindService", e);
            }
            if (context != null) {
                context.unbindService(this.f3963b);
                Debugger.m8607d("CoeditBaseLogic", "selfUnbind() count:" + this.f3965d.size() + " what:" + i);
            } else {
                Debugger.m8607d("CoeditBaseLogic", "selfUnbind() count:" + this.f3965d.size() + " what:" + i);
            }
        }
    }
}
