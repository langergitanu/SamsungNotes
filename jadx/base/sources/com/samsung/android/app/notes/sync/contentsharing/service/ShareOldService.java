package com.samsung.android.app.notes.sync.contentsharing.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.SparseBooleanArray;
import com.samsung.android.app.notes.sync.contentsharing.sharehelpers.C6719b;
import com.samsung.android.app.notes.sync.contentsharing.sharehelpers.C6721d;
import com.samsung.android.app.notes.sync.contentsharing.sharehelpers.C6722e;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6724b;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6727e;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6728f;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6729g;
import com.samsung.android.app.notes.sync.contentsharing.sharelogic.C6730h;
import com.samsung.android.app.notes.sync.synchronization.managers.C6907j;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.List;
import p001A.AbstractC0000a;
import p020E.C0073a;
import p044K.C0158a;
import p063P.InterfaceC0192a;
import p234q1.C14433b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public class ShareOldService extends Service {
    private static final String TAG = "ShareOldService";
    private boolean mIsSharingPended;
    private C6727e mMdeDeleteLogic;
    private C6728f mMdeImportLogic;
    private C6730h mShareLogic;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public ShareOldService getService() {
            return ShareOldService.this;
        }
    }

    public static boolean isMdeSharing() {
        return C6730h.m4822b();
    }

    public void addImportProgressListener(InterfaceC0192a interfaceC0192a) {
        C6728f.m4820b(interfaceC0192a);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return new LocalBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Debugger.m8607d(TAG, "onCreate()");
        C6730h c6730h = new C6730h();
        c6730h.f4092d = new C0073a(c6730h, 6);
        this.mShareLogic = c6730h;
        C6728f c6728f = new C6728f();
        c6728f.f4087d = new C14433b(c6728f, 7);
        this.mMdeImportLogic = c6728f;
        C6727e c6727e = new C6727e();
        c6727e.f4082d = new C6907j();
        this.mMdeDeleteLogic = c6727e;
        C6730h c6730h2 = this.mShareLogic;
        c6730h2.f4072a = ShareOldService.class;
        this.mMdeImportLogic.f4072a = ShareOldService.class;
        c6727e.f4072a = ShareOldService.class;
        synchronized (C6730h.class) {
            try {
                if (C6730h.f4091f == null) {
                    C6722e c6722e = new C6722e(c6730h2.f4074c, c6730h2.f4072a);
                    c6722e.f4063h = null;
                    C6730h.f4091f = c6722e;
                }
                C6722e c6722e2 = C6730h.f4091f;
                C0073a c0073a = c6730h2.f4092d;
                synchronized (c6722e2) {
                    c6722e2.f4063h = c0073a;
                }
            } finally {
            }
        }
        C6728f c6728f2 = this.mMdeImportLogic;
        c6728f2.getClass();
        synchronized (C6730h.class) {
            try {
                if (C6728f.f4085g == null) {
                    C6728f.f4085g = new C6721d(c6728f2.f4074c, c6728f2.f4072a);
                }
                C6721d c6721d = C6728f.f4085g;
                C14433b c14433b = c6728f2.f4087d;
                synchronized (c6721d) {
                    c6721d.f4060h = c14433b;
                }
            } finally {
            }
        }
        C6727e c6727e2 = this.mMdeDeleteLogic;
        c6727e2.getClass();
        synchronized (C6719b.class) {
            try {
                if (C6727e.f4079f == null) {
                    C6727e.f4079f = new C6719b(c6727e2.f4074c, c6727e2.f4072a);
                }
                C6719b c6719b = C6727e.f4079f;
                C6907j c6907j = c6727e2.f4082d;
                synchronized (c6719b) {
                    c6719b.f4060h = c6907j;
                }
            } finally {
            }
        }
        this.mIsSharingPended = false;
        C6727e.m4818b(new C6686a(this));
    }

    @Override // android.app.Service
    public void onDestroy() {
        Debugger.m8607d(TAG, "onDestroy()");
        C6730h c6730h = this.mShareLogic;
        if (c6730h != null) {
            c6730h.f4072a = null;
        }
        C6727e c6727e = this.mMdeDeleteLogic;
        if (c6727e != null) {
            c6727e.f4072a = null;
        }
        C6728f c6728f = this.mMdeImportLogic;
        if (c6728f != null) {
            c6728f.f4072a = null;
        }
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        super.onStartCommand(intent, i, i2);
        AbstractC0000a.m17n(i, "ShareOldService : onStartCommand() : flags = ", TAG);
        return 1;
    }

    public void removeImportProgressListener(InterfaceC0192a interfaceC0192a) {
        C6728f.m4821c(interfaceC0192a);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x002d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void requestDelete(String str, List<String> list) {
        if (C6730h.m4822b()) {
            this.mShareLogic.getClass();
            if (str.equals(C6730h.f4091f.f4058f)) {
                Debugger.m8607d(TAG, "Stop sharing because of deletion. spaceId : ".concat(str));
                this.mShareLogic.getClass();
                C6730h.m4823d();
                this.mIsSharingPended = true;
            } else {
                this.mIsSharingPended = false;
            }
        }
        C6724b c6724b = this.mMdeDeleteLogic.f4073b;
        Debugger.m8607d("MdeDeleteLogic", "requestDelete()");
        if (C0158a.m407a().m415h()) {
            Message messageObtainMessage = c6724b.f4071e.obtainMessage();
            messageObtainMessage.what = 200;
            messageObtainMessage.arg1 = 0;
            messageObtainMessage.obj = new C6729g(str, list);
            c6724b.f4071e.sendMessage(messageObtainMessage);
            c6724b.m4815a(messageObtainMessage.what);
        }
    }

    public void requestDeleteLocalAll() {
        C6724b c6724b = this.mMdeDeleteLogic.f4073b;
        Debugger.m8607d("MdeDeleteLogic", "requestDeleteLocalAll()");
        if (C0158a.m407a().m415h()) {
            Message messageObtainMessage = c6724b.f4071e.obtainMessage();
            messageObtainMessage.what = 300;
            messageObtainMessage.arg1 = 0;
            c6724b.f4071e.sendMessage(messageObtainMessage);
            c6724b.m4815a(messageObtainMessage.what);
        }
    }

    public void requestImport(String str, List<String> list) {
        C6724b c6724b = this.mMdeImportLogic.f4073b;
        Debugger.m8607d("MdeImportLogic", "requestImport()");
        if (C0158a.m407a().m415h()) {
            Message messageObtainMessage = c6724b.f4071e.obtainMessage();
            messageObtainMessage.what = 100;
            messageObtainMessage.arg1 = 0;
            messageObtainMessage.obj = new C6729g(str, list);
            c6724b.f4071e.sendMessage(messageObtainMessage);
            c6724b.m4815a(messageObtainMessage.what);
        }
    }

    public void requestShare(String str) {
        C6724b c6724b = this.mShareLogic.f4073b;
        Debugger.m8607d("ShareLogic", "requestShareNow()");
        if (C0158a.m407a().m415h()) {
            Handler handler = c6724b.f4071e;
            Handler handler2 = c6724b.f4071e;
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 100;
            messageObtainMessage.arg1 = 0;
            messageObtainMessage.obj = str;
            SparseBooleanArray sparseBooleanArray = c6724b.f4070d;
            if (sparseBooleanArray.get(100)) {
                c6724b.m4816b(100);
                sparseBooleanArray.delete(100);
                handler2.removeMessages(100);
            }
            handler2.sendMessageDelayed(messageObtainMessage, 5000L);
            c6724b.m4815a(messageObtainMessage.what);
        }
    }

    public void requestShareNow(String str, boolean z) {
        C6724b c6724b = this.mShareLogic.f4073b;
        Debugger.m8607d("ShareLogic", "requestShareNow() : " + z);
        if (C0158a.m407a().m415h()) {
            Handler handler = c6724b.f4071e;
            Handler handler2 = c6724b.f4071e;
            Message messageObtainMessage = handler.obtainMessage();
            messageObtainMessage.what = 100;
            if (z) {
                messageObtainMessage.arg1 = 1;
            } else {
                messageObtainMessage.arg1 = 0;
            }
            messageObtainMessage.obj = str;
            SparseBooleanArray sparseBooleanArray = c6724b.f4070d;
            if (sparseBooleanArray.get(100)) {
                c6724b.m4816b(100);
                sparseBooleanArray.delete(100);
                handler2.removeMessages(100);
            }
            handler2.sendMessage(messageObtainMessage);
            c6724b.m4815a(messageObtainMessage.what);
        }
    }

    public void stopDelete() {
        this.mMdeDeleteLogic.getClass();
        Debugger.m8607d("MdeDeleteLogic", "stopDelete()");
        C6727e.f4079f.m4814k();
    }

    public void stopImport() {
        this.mMdeImportLogic.getClass();
        Debugger.m8607d("MdeImportLogic", "stopImport()");
        C6728f.f4085g.m4814k();
    }

    public void stopShare() {
        this.mShareLogic.getClass();
        C6730h.m4823d();
    }
}
