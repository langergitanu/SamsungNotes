package p212o1;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.appcompat.widget.AbstractC0541b;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6680e;
import com.samsung.android.app.notes.sync.importing.controllers.InterfaceC6755d;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.app.notes.sync.importing.services.ImportService;
import com.samsung.android.app.notes.sync.microsoft.graph.AbstractC6784f;
import com.samsung.android.app.notes.sync.microsoft.graph.C6785g;
import com.samsung.android.app.notes.sync.microsoft.graph.GraphItem$RequestType;
import com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f;
import com.samsung.android.app.notes.sync.synchronization.core.tasks.RecoveryTask;
import com.samsung.android.app.notes.sync.synchronization.core.tasks.SyncProcessTask;
import com.samsung.android.sdk.smp.Smp;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p145cm.base.framework.support.BaseUtils;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONObject;
import p007B0.C0026i;
import p012C1.RunnableC0045a;
import p017D1.C0064e;
import p028G.InterfaceC0103b;
import p029G0.C0106c;
import p037I0.C0124c;
import p037I0.InterfaceC0122a;
import p063P.InterfaceC0192a;
import p068Q.C0204a;
import p083U.InterfaceC0307d;
import p202m1.C13526a;
import p202m1.C13527b;
import p207n1.C13541h;
import p211o0.C13571e;
import p211o0.C13572f;
import p249v1.C14500c;

/* JADX INFO: renamed from: o1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13573a implements InterfaceC6855f, InterfaceC0122a, InterfaceC0103b, InterfaceC0307d, InterfaceC6755d, IAuthorizationListener {

    /* JADX INFO: renamed from: c */
    public static C13573a f9633c;

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9634a;

    /* JADX INFO: renamed from: b */
    public Object f9635b;

    public /* synthetic */ C13573a(int i, boolean z) {
        this.f9634a = i;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m14382c(C13573a c13573a) {
        HashSet hashSet;
        Logger.m8697d("OnenoteAccountLinkingStatusManager", "OD checked 0");
        Bundle bundleCall = BaseUtils.getApplicationContext().getContentResolver().call(Uri.parse("content://com.samsung.android.scloud.app.ui.datamigrator.linkcontext"), "GET_MIGRATION_STATE", (String) null, (Bundle) null);
        boolean zContains = (!bundleCall.containsKey("AllowedOperations") || (hashSet = (HashSet) bundleCall.getSerializable("AllowedOperations")) == null) ? false : hashSet.contains("OneDriveAccountAvailable");
        if (zContains) {
            Logger.m8697d("OnenoteAccountLinkingStatusManager", "OD checked 1");
        }
        return zContains;
    }

    /* JADX INFO: renamed from: e */
    public static void m14383e(C13573a c13573a, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        ((HashMap) c13573a.f9635b).put(str, str2);
    }

    /* JADX INFO: renamed from: j */
    public static void m14384j(Context context, boolean z) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_NAME_ONE_DRIVE_ACCOUNT_LINKING", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("PREF_VALUE_ACTIVATED", z).apply();
        }
    }

    /* JADX INFO: renamed from: k */
    public static void m14385k(Context context, int i) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("PREF_NAME_ONE_DRIVE_ACCOUNT_LINKING", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putInt("PREF_VALUE_TYPE", i).apply();
        }
    }

    @Override // p028G.InterfaceC0103b
    /* JADX INFO: renamed from: a */
    public void mo245a(String str) {
        Debugger.m8607d("CoeditImportLogic", "onEnded()");
        ((C6680e) this.f9635b).getClass();
        Debugger.m8607d("CoeditImportLogic", "onImportEnded : " + Long.toString(System.currentTimeMillis() - C6680e.f3976f) + "ms");
        ArrayList arrayList = C6680e.f3978h;
        synchronized (arrayList) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0192a) it.next()).onEnded(str, -1);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.controllers.InterfaceC6755d
    /* JADX INFO: renamed from: b */
    public void mo4893b(ImportService importService) {
        importService.startImport((AbstractImportType) this.f9635b);
    }

    @Override // p028G.InterfaceC0103b
    /* JADX INFO: renamed from: d */
    public void mo246d(String str, ArrayList arrayList) {
        Debugger.m8607d("CoeditImportLogic", "onError()");
        Debugger.m8609e("CoeditImportLogic", "onFailed[" + str + "]");
        if (arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = C6680e.f3978h;
        synchronized (arrayList2) {
            try {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((InterfaceC0192a) it.next()).onEnded(str, ((C0204a) arrayList.get(0)).f634c.f10350b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: renamed from: f */
    public void m14386f(Context context) {
        String pushType;
        C13527b c13527b = (C13527b) this.f9635b;
        if (c13527b == null) {
            Debugger.m8609e("PushClient", "[PUSH] registerPush() : mRegisterMethod is null!");
            return;
        }
        String pushToken = null;
        try {
            pushType = Smp.getPushType(context);
        } catch (Exception e) {
            e = e;
            pushType = null;
        }
        try {
            pushToken = Smp.getPushToken(context);
        } catch (Exception e2) {
            e = e2;
            AbstractC4539a.m3213w(e, new StringBuilder("[PUSH] registerPush : Exception = "), "RegisterSmpUsingPam");
        }
        if (TextUtils.isEmpty(pushType) || TextUtils.isEmpty(pushToken)) {
            Debugger.m8615i("RegisterSmpUsingPam", "[PUSH] registerPush : pushType or pushToken is empty and so initializeSmp!");
            new SenlThreadFactory("initializeSmpThread").newThread(new RunnableC0045a(c13527b, context, 9)).start();
        } else {
            try {
                Debugger.m8615i("RegisterSmpUsingPam", "[PUSH] activatePush() start");
                C13541h.m14287e().m14295i(new C13526a(c13527b, context, 0));
            } catch (Exception e3) {
                AbstractC4539a.m3213w(e3, new StringBuilder("[PUSH] registerPush : Exception = "), "RegisterSmpUsingPam");
            }
        }
        Debugger.m8615i("RegisterSmpUsingPam", "[PUSH] registerPush finish");
    }

    @Override // p037I0.InterfaceC0122a
    /* JADX INFO: renamed from: g */
    public void mo252g(C0124c c0124c) {
        C0106c c0106c = (C0106c) this.f9635b;
        MSLogger.m8632d("UploadPage", "addPage, onResult : " + c0124c);
        if (c0124c == null) {
            return;
        }
        try {
            int i = c0124c.f387b;
            if (i == 401) {
                C6785g c6785g = AbstractC6784f.f4180a;
                c6785g.m4943b(c0106c.f349a, "", GraphItem$RequestType.NONE);
                c6785g.m4948l();
            } else {
                if (i == 429) {
                    MSLogger.m8632d("UploadPage", "HTTP_TOO_MANY_REQUESTS");
                    return;
                }
                if (i == -1) {
                    MSLogger.m8632d("UploadPage", "HTTP_RESPONSE_COMMON_FAILED");
                    return;
                }
                String string = new JSONObject(c0124c.f386a).getString("id");
                MSLogger.m8632d("UploadPage", "pageId : " + string);
                if (TextUtils.isEmpty(string)) {
                    AbstractC6784f.f4180a.m4943b(c0106c.f349a, "", GraphItem$RequestType.NONE);
                }
            }
        } catch (Exception e) {
            AbstractC6670b.m4753n(e, new StringBuilder("Failed. "), "UploadPage");
        }
    }

    @Override // com.samsung.android.app.notes.sync.network.networkutils.InterfaceC6855f
    /* JADX INFO: renamed from: h */
    public void mo142h() {
        C0064e c0064e = (C0064e) this.f9635b;
        c0064e.f238b.m219f(c0064e.f239c, "SyncSDocxCreateTempLocalNote");
    }

    /* JADX INFO: renamed from: i */
    public void m14387i(byte[] bArr) {
        if (bArr.length == 32) {
            this.f9635b = Arrays.copyOf(bArr, 32);
        } else {
            Log.e("WCon_WDocHashBlock", "fail to setHash : data size is not same");
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener
    public void onError(String str, String str2) {
        switch (this.f9634a) {
            case 13:
                Debugger.m8609e("RequestEdpStateTask", "[EDP] onError() : " + str2);
                C13571e c13571e = (C13571e) ((C13526a) this.f9635b).f9527c;
                c13571e.f9627d = new C13572f(604, str2);
                c13571e.f9625b.countDown();
                break;
            default:
                ((C14500c) this.f9635b).mo5104a(122, AbstractC0541b.m774p("errCode = ", str, " errMsg = ", str2));
                break;
        }
    }

    @Override // com.samsung.android.support.senl.p148nt.base.common.sync.IAuthorizationListener
    public void onReceived(String str) {
        switch (this.f9634a) {
            case 13:
                if (!TextUtils.isEmpty(str)) {
                    new SenlThreadFactory("AuthApiThread").newThread(new RunnableC0045a(this, str, 13)).start();
                    return;
                }
                Debugger.m8609e("RequestEdpStateTask", "[EDP] onReceived() : cloudToken is null!");
                C13571e c13571e = (C13571e) ((C13526a) this.f9635b).f9527c;
                c13571e.f9627d = new C13572f(604, "cloudToken is null!");
                c13571e.f9625b.countDown();
                return;
            default:
                synchronized (((C14500c) this.f9635b).f10330i) {
                    try {
                        Debugger.m8615i("WDocCloudSyncHelper", "onReceived() : mRequestType = " + ((C14500c) this.f9635b).f10323b);
                        C14500c c14500c = (C14500c) this.f9635b;
                        if (c14500c.f10323b != 1) {
                            c14500c.f10325d = null;
                            throw new UnsupportedOperationException();
                        }
                        if (c14500c.f10329h.f322a == 1024) {
                            C14500c c14500c2 = (C14500c) this.f9635b;
                            c14500c.f10325d = new RecoveryTask(c14500c2.f10324c, str, c14500c2);
                        } else {
                            C14500c c14500c3 = (C14500c) this.f9635b;
                            c14500c.f10325d = new SyncProcessTask(c14500c3.f10324c, str, c14500c3);
                        }
                        C14500c c14500c4 = (C14500c) this.f9635b;
                        c14500c4.f10325d.setRequestSyncInfo(c14500c4.f10329h);
                        C14500c c14500c5 = (C14500c) this.f9635b;
                        if (c14500c5.f10325d != null) {
                            c14500c5.f10322a = 3;
                            Debugger.m8615i("WDocCloudSyncHelper", "onReceived() : execute SyncProcessTask!");
                            C14500c c14500c6 = (C14500c) this.f9635b;
                            c14500c6.f10325d.executeOnExecutor(c14500c6.f10326e, new Void[0]);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    @Override // p028G.InterfaceC0103b
    public void onStart() {
        Debugger.m8607d("CoeditImportLogic", "onStart()");
    }

    public /* synthetic */ C13573a(Object obj, int i) {
        this.f9634a = i;
        this.f9635b = obj;
    }

    public C13573a(int i) {
        this.f9634a = i;
        switch (i) {
            case 9:
                this.f9635b = new HashMap();
                break;
            default:
                C0026i c0026i = new C0026i();
                c0026i.f140a = null;
                c0026i.f141b = null;
                c0026i.f142c = 0L;
                this.f9635b = c0026i;
                break;
        }
    }
}
