package com.samsung.android.app.notes.sync.contentsharing.sharelogic;

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

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sharelogic.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6724b {

    /* JADX INFO: renamed from: a */
    public final WeakReference f4067a;

    /* JADX INFO: renamed from: b */
    public final ServiceConnection f4068b = new ServiceConnection() { // from class: com.samsung.android.app.notes.sync.contentsharing.sharelogic.BaseLogic$BaseLogicHandler$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Debugger.m8607d("BaseLogic", "SelfBind connected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Debugger.m8607d("BaseLogic", "SelfBind disconnected");
        }
    };

    /* JADX INFO: renamed from: d */
    public final SparseBooleanArray f4070d = new SparseBooleanArray();

    /* JADX INFO: renamed from: e */
    public final Handler f4071e = new BaseLogic$BaseLogicHandler$2(this);

    /* JADX INFO: renamed from: c */
    public final Context f4069c = C0322h.m670a().f815a.getAppContext();

    public C6724b(AbstractC6725c abstractC6725c) {
        this.f4067a = new WeakReference(abstractC6725c);
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m4815a(int i) {
        Context context;
        try {
            if (this.f4070d.size() == 0) {
                Debugger.m8615i("BaseLogic", "selfBind() call bindService()");
                AbstractC6725c abstractC6725c = (AbstractC6725c) this.f4067a.get();
                if (abstractC6725c != null && abstractC6725c.f4072a != null && (context = this.f4069c) != null) {
                    context.bindService(new Intent(this.f4069c, (Class<?>) abstractC6725c.f4072a), this.f4068b, 1);
                }
            }
            this.f4070d.put(i, true);
            Debugger.m8607d("BaseLogic", "selfBind() count:" + this.f4070d.size() + " what:" + i);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[Catch: all -> 0x002b, TRY_LEAVE, TryCatch #1 {, blocks: (B:4:0x0004, B:6:0x0019, B:8:0x0025, B:14:0x0036, B:13:0x002e), top: B:21:0x0004, inners: #0 }] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void m4816b(int i) {
        Context context;
        Debugger.m8615i("BaseLogic", "selfUnbind() start");
        this.f4070d.delete(i);
        if (this.f4070d.size() == 0) {
            try {
                Debugger.m8615i("BaseLogic", "selfUnbind() call unbindService()");
                context = this.f4069c;
            } catch (IllegalArgumentException e) {
                Debugger.m8610e("BaseLogic", "selfUnbind() unbindService", e);
            }
            if (context != null) {
                context.unbindService(this.f4068b);
                Debugger.m8607d("BaseLogic", "selfUnbind() count:" + this.f4070d.size() + " what:" + i);
            } else {
                Debugger.m8607d("BaseLogic", "selfUnbind() count:" + this.f4070d.size() + " what:" + i);
            }
        }
    }
}
