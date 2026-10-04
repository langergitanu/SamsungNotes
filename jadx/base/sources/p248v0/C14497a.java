package p248v0;

import com.samsung.android.app.notes.sync.importing.controllers.C6752a;
import com.samsung.android.app.notes.sync.importing.controllers.C6754c;
import com.samsung.android.app.notes.sync.importing.core.types.AbstractImportType;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.startmanager.ModelStartManager;
import p044K.C0158a;
import p192j1.C12936a;
import p212o1.C13573a;

/* JADX INFO: renamed from: v0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C14497a {

    /* JADX INFO: renamed from: b */
    public static C14497a f10309b;

    /* JADX INFO: renamed from: a */
    public final C6754c f10310a = new C6754c();

    /* JADX INFO: renamed from: a */
    public static synchronized C14497a m15078a() {
        try {
            if (f10309b == null) {
                f10309b = new C14497a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f10309b;
    }

    /* JADX INFO: renamed from: b */
    public final void m15079b(boolean z, boolean z2) {
        C0158a.m407a().getClass();
        if (!C0158a.m411g()) {
            Debugger.m8615i("ImportManager", "onNetworkConnected : not supported!)");
            return;
        }
        Debugger.m8615i("ImportManager", "Network : onNetworkConnected() : " + z);
        this.f10310a.m4894a(new C6752a(z, z2), true);
    }

    /* JADX INFO: renamed from: c */
    public final void m15080c() {
        C0158a.m407a().getClass();
        if (!C0158a.m411g()) {
            Debugger.m8615i("ImportManager", "reTryImporting : not supported!)");
        } else if (ModelStartManager.INSTANCE.isBlocked()) {
            Debugger.m8615i("ImportManager", "reTryImporting, blocked");
        } else {
            this.f10310a.m4894a(new C12936a(), true);
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m15081d(AbstractImportType abstractImportType) {
        C0158a.m407a().getClass();
        if (!C0158a.m411g()) {
            Debugger.m8615i("ImportManager", "startImport : not supported!)");
        } else if (ModelStartManager.INSTANCE.isBlocked()) {
            Debugger.m8615i("ImportManager", "startImport, blocked");
        } else {
            this.f10310a.m4894a(new C13573a(abstractImportType, 8), false);
        }
    }
}
