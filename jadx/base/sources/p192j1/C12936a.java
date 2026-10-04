package p192j1;

import android.content.Context;
import com.samsung.android.app.notes.sync.coedit.sharelogic.C6679d;
import com.samsung.android.app.notes.sync.importing.controllers.InterfaceC6755d;
import com.samsung.android.app.notes.sync.importing.services.ImportService;
import com.samsung.android.support.senl.p145cm.base.framework.support.DeviceInfo;
import com.samsung.android.support.senl.p148nt.app.sync.contractimpl.AppInfoContractImpl;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.winset.app.permission.PermissionHelper;
import java.util.ArrayList;
import java.util.Iterator;
import p028G.InterfaceC0102a;
import p028G.InterfaceC0103b;
import p068Q.C0204a;
import p086V.C0322h;

/* JADX INFO: renamed from: j1.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C12936a implements InterfaceC0103b, InterfaceC6755d {

    /* JADX INFO: renamed from: a */
    public static C12936a f9140a;

    /* JADX INFO: renamed from: c */
    public static synchronized C12936a m13839c() {
        try {
            if (f9140a == null) {
                f9140a = new C12936a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9140a;
    }

    /* JADX INFO: renamed from: e */
    public static ArrayList m13840e() {
        ArrayList arrayList = new ArrayList();
        AppInfoContractImpl appInfoContractImpl = C0322h.m670a().f815a;
        if (appInfoContractImpl == null) {
            Debugger.m8609e("PermissionManager", "getNeedPermissionForSync() : appInfoContract is null!");
            return arrayList;
        }
        Context appContext = appInfoContractImpl.getAppContext();
        if (DeviceInfo.isOtherCorpDevice()) {
            if (!PermissionHelper.isPermissionGrantedWithoutNotice(appContext, "android.permission.GET_ACCOUNTS")) {
                arrayList.add("android.permission.GET_ACCOUNTS");
            }
            if (!PermissionHelper.isPermissionGrantedWithoutNotice(appContext, "android.permission.READ_PHONE_STATE")) {
                arrayList.add("android.permission.READ_PHONE_STATE");
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: f */
    public static boolean m13841f() {
        ArrayList arrayList = new ArrayList();
        AppInfoContractImpl appInfoContractImpl = C0322h.m670a().f815a;
        if (appInfoContractImpl != null) {
            Context appContext = appInfoContractImpl.getAppContext();
            if (DeviceInfo.isOtherCorpDevice() && !PermissionHelper.isPermissionGrantedWithoutNotice(appContext, "android.permission.GET_ACCOUNTS")) {
                arrayList.add("android.permission.GET_ACCOUNTS");
            }
        }
        if (arrayList.isEmpty()) {
            return true;
        }
        Debugger.m8615i("PermissionManager", "Import Permission is not granted!");
        return false;
    }

    /* JADX INFO: renamed from: g */
    public static boolean m13842g() {
        if (m13840e().isEmpty()) {
            return true;
        }
        Debugger.m8615i("PermissionManager", "Sync Permission is not granted!");
        return false;
    }

    @Override // p028G.InterfaceC0103b
    /* JADX INFO: renamed from: a */
    public void mo245a(String str) {
        Debugger.m8607d("MdeDeleteLogic", "onEnded()");
        Debugger.m8607d("MdeDeleteLogic", "onEnded : " + (System.currentTimeMillis() - C6679d.f3973h) + "ms");
        Iterator it = C6679d.f3972g.iterator();
        while (it.hasNext()) {
            ((InterfaceC0102a) it.next()).onEnded(str, -1);
        }
    }

    @Override // com.samsung.android.app.notes.sync.importing.controllers.InterfaceC6755d
    /* JADX INFO: renamed from: b */
    public void mo4893b(ImportService importService) {
        importService.reTryImporting();
    }

    @Override // p028G.InterfaceC0103b
    /* JADX INFO: renamed from: d */
    public void mo246d(String str, ArrayList arrayList) {
        Debugger.m8607d("MdeDeleteLogic", "onError()");
        Debugger.m8607d("MdeDeleteLogic", "onFailed [" + str + "]");
        if (arrayList.isEmpty()) {
            return;
        }
        Iterator it = C6679d.f3972g.iterator();
        while (it.hasNext()) {
            ((InterfaceC0102a) it.next()).onEnded(str, ((C0204a) arrayList.get(0)).f634c.f10350b);
        }
    }

    @Override // p028G.InterfaceC0103b
    public void onStart() {
        Debugger.m8607d("MdeDeleteLogic", "onStart()");
    }
}
