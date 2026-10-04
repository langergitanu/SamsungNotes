package com.samsung.android.app.notes.sync.coedit.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.SparseBooleanArray;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharehelpers.C6672b;
import com.samsung.android.app.notes.sync.coedit.sharehelpers.C6674d;
import com.samsung.android.app.notes.sync.coedit.sharehelpers.C6675e;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6677b;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6679d;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6680e;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6681f;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6682g;
import com.samsung.android.app.notes.sync.contentsharing.sharehelpers.C6719b;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6730h;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;
import p044K.C0158a;
import p063P.InterfaceC0192a;
import p192j1.C12936a;
import p212o1.C13573a;
import p234q1.C14433b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class CoeditShareOldService extends Service {
    private static final String TAG = "CoeditShareOldService";
    private C6679d mDeleteLogic;
    private C6680e mImportLogic;
    private boolean mIsSharingPended;
    private C6681f mShareLogic;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public CoeditShareOldService getService() {
            return CoeditShareOldService.this;
        }
    }

    public static boolean isMdeSharing() {
        return C6730h.m4822b();
    }

    public void addImportProgressListener(InterfaceC0192a interfaceC0192a) {
        ArrayList arrayList = C6680e.f3978h;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC0192a) it.next()).equals(interfaceC0192a)) {
                        return;
                    }
                }
                ArrayList arrayList2 = C6680e.f3978h;
                arrayList2.add(interfaceC0192a);
                Debugger.m8607d("CoeditImportLogic", "Added progress listener - size : " + arrayList2.size());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Debugger.m8607d(TAG, "onCreate()");
        C6681f c6681f = new C6681f();
        int i = 6;
        c6681f.f3983d = new C14433b(c6681f, i);
        this.mShareLogic = c6681f;
        C6680e c6680e = new C6680e();
        c6680e.f3979d = new C13573a(c6680e, i);
        this.mImportLogic = c6680e;
        C6679d c6679d = new C6679d();
        c6679d.f3974d = new C12936a();
        this.mDeleteLogic = c6679d;
        C6681f c6681f2 = this.mShareLogic;
        c6681f2.f3967a = CoeditShareOldService.class;
        this.mImportLogic.f3967a = CoeditShareOldService.class;
        c6679d.f3967a = CoeditShareOldService.class;
        synchronized (C6681f.class) {
            try {
                if (C6681f.f3982g == null) {
                    C6675e c6675e = new C6675e(c6681f2.f3969c, c6681f2.f3967a);
                    c6675e.f3958h = null;
                    C6681f.f3982g = c6675e;
                }
                C6675e c6675e2 = C6681f.f3982g;
                C14433b c14433b = c6681f2.f3983d;
                synchronized (c6675e2) {
                    c6675e2.f3958h = c14433b;
                }
            } finally {
            }
        }
        C6680e c6680e2 = this.mImportLogic;
        c6680e2.getClass();
        synchronized (C6681f.class) {
            try {
                if (C6680e.f3977g == null) {
                    C6680e.f3977g = new C6674d(c6680e2.f3969c, c6680e2.f3967a);
                }
                C6674d c6674d = C6680e.f3977g;
                C13573a c13573a = c6680e2.f3979d;
                synchronized (c6674d) {
                    c6674d.f3955h = c13573a;
                }
            } finally {
            }
        }
        C6679d c6679d2 = this.mDeleteLogic;
        c6679d2.getClass();
        synchronized (C6719b.class) {
            try {
                if (C6679d.f3971f == null) {
                    C6679d.f3971f = new C6672b(c6679d2.f3969c, c6679d2.f3967a);
                }
                C6672b c6672b = C6679d.f3971f;
                C12936a c12936a = c6679d2.f3974d;
                synchronized (c6672b) {
                    c6672b.f3955h = c12936a;
                }
            } finally {
            }
        }
        this.mIsSharingPended = false;
        C6679d.m4774b(new C6668a(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        Debugger.m8607d(TAG, "onDestroy()");
        this.mShareLogic.f3967a = null;
        this.mImportLogic.f3967a = null;
        this.mDeleteLogic.f3967a = null;
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        AbstractC0000a.m17n(i, "CoeditShareOldService : onStartCommand() : flags = ", TAG);
        return 1;
    }

    public void removeImportProgressListener(InterfaceC0192a interfaceC0192a) {
        ArrayList arrayList = C6680e.f3978h;
        synchronized (arrayList) {
            arrayList.remove(interfaceC0192a);
            Debugger.m8607d("CoeditImportLogic", "Removed progress listener - size : " + arrayList.size());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void requestDelete(String str, List<String> list) {
        C6675e c6675e = C6681f.f3982g;
        boolean z = (c6675e == null || c6675e.f3948a == 1) ? false : true;
        AbstractC4539a.m3215y("isMdeSharing : ", "CoeditShareLogic", z);
        if (z) {
            this.mShareLogic.getClass();
            if (str.equals(C6681f.f3982g.f3953f)) {
                Debugger.m8607d(TAG, "Stop sharing because of deletion. spaceId : ".concat(str));
                this.mShareLogic.getClass();
                C6681f.m4775c();
                this.mIsSharingPended = true;
            } else {
                this.mIsSharingPended = false;
            }
        }
        C6679d c6679d = this.mDeleteLogic;
        C6677b c6677b = c6679d.f3968b;
        Debugger.m8607d("MdeDeleteLogic", "requestDelete()");
        if (C0158a.m409d(c6679d.f3969c.getApplicationContext())) {
            Message messageObtainMessage = c6677b.f3966e.obtainMessage();
            messageObtainMessage.what = 200;
            messageObtainMessage.arg1 = 0;
            messageObtainMessage.obj = new C6682g(str, list);
            c6677b.f3966e.sendMessage(messageObtainMessage);
            c6677b.m4771a(messageObtainMessage.what);
        }
    }

    public void requestDeleteLocalAll() {
        C6679d c6679d = this.mDeleteLogic;
        C6677b c6677b = c6679d.f3968b;
        Debugger.m8607d("MdeDeleteLogic", "requestDeleteLocalAll()");
        if (C0158a.m409d(c6679d.f3969c.getApplicationContext())) {
            Message messageObtainMessage = c6677b.f3966e.obtainMessage();
            messageObtainMessage.what = 300;
            messageObtainMessage.arg1 = 0;
            c6677b.f3966e.sendMessage(messageObtainMessage);
            c6677b.m4771a(messageObtainMessage.what);
        }
    }

    public void requestImport(String str, List<String> list) {
        C6680e c6680e = this.mImportLogic;
        C6677b c6677b = c6680e.f3968b;
        Debugger.m8607d("CoeditImportLogic", "requestImport()");
        if (C0158a.m409d(c6680e.f3969c.getApplicationContext())) {
            Message messageObtainMessage = c6677b.f3966e.obtainMessage();
            messageObtainMessage.what = 100;
            messageObtainMessage.arg1 = 0;
            messageObtainMessage.obj = new C6682g(str, list);
            c6677b.f3966e.sendMessage(messageObtainMessage);
            c6677b.m4771a(messageObtainMessage.what);
        }
    }

    public void requestShare(String str) {
        C6681f c6681f = this.mShareLogic;
        C6677b c6677b = c6681f.f3968b;
        Debugger.m8607d("CoeditShareLogic", "requestShareNow()");
        if (C0158a.m409d(c6681f.f3969c.getApplicationContext())) {
            Handler handler = c6677b.f3966e;
            Handler handler2 = c6677b.f3966e;
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 100;
            messageObtainMessage.arg1 = 0;
            messageObtainMessage.obj = str;
            SparseBooleanArray sparseBooleanArray = c6677b.f3965d;
            if (sparseBooleanArray.get(100)) {
                c6677b.m4772b(100);
                sparseBooleanArray.delete(100);
                handler2.removeMessages(100);
            }
            handler2.sendMessageDelayed(messageObtainMessage, 5000L);
            c6677b.m4771a(messageObtainMessage.what);
        }
    }

    public void requestShareNow(String str, boolean z) {
        C6681f c6681f = this.mShareLogic;
        C6677b c6677b = c6681f.f3968b;
        AbstractC4539a.m3215y("requestShareNow() : ", "CoeditShareLogic", z);
        if (C0158a.m409d(c6681f.f3969c.getApplicationContext())) {
            Handler handler = c6677b.f3966e;
            Handler handler2 = c6677b.f3966e;
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 100;
            if (z) {
                messageObtainMessage.arg1 = 1;
            } else {
                messageObtainMessage.arg1 = 0;
            }
            messageObtainMessage.obj = str;
            SparseBooleanArray sparseBooleanArray = c6677b.f3965d;
            if (sparseBooleanArray.get(100)) {
                c6677b.m4772b(100);
                sparseBooleanArray.delete(100);
                handler2.removeMessages(100);
            }
            handler2.sendMessage(messageObtainMessage);
            c6677b.m4771a(messageObtainMessage.what);
        }
    }

    public void stopDelete() {
        this.mDeleteLogic.getClass();
        Debugger.m8607d("MdeDeleteLogic", "stopDelete()");
        C6679d.f3971f.m4770k();
    }

    public void stopImport() {
        this.mImportLogic.getClass();
        Debugger.m8607d("CoeditImportLogic", "stopImport()");
        C6680e.f3977g.m4770k();
    }

    public void stopShare() {
        this.mShareLogic.getClass();
        C6681f.m4775c();
    }
}
