package p211o0;

import com.samsung.android.app.notes.sync.C6662a;
import com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a;
import com.samsung.android.app.notes.sync.contentsharing.service.ShareOldService;
import com.samsung.android.app.notes.sync.p135db.C6742k;
import com.samsung.android.support.senl.p145cm.base.common.thread.SenlThreadFactory;
import com.samsung.android.support.senl.p148nt.app.common.samsunganalytics.NotesSAConstants;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.common.constants.CoverStickerConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import p001A.AbstractC0000a;
import p042J1.C0145c;
import p044K.C0158a;

/* JADX INFO: renamed from: o0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C13567a implements InterfaceC6683a {

    /* JADX INFO: renamed from: c */
    public static C13567a f9614c;

    /* JADX INFO: renamed from: a */
    public boolean f9615a;

    /* JADX INFO: renamed from: b */
    public Object f9616b;

    /* JADX INFO: renamed from: a */
    public static synchronized C13567a m14371a() {
        try {
            if (f9614c == null) {
                C13567a c13567a = new C13567a();
                c13567a.f9616b = new C6742k(8);
                c13567a.m14372c();
                f9614c = c13567a;
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9614c;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.controllers.InterfaceC6683a
    /* JADX INFO: renamed from: b */
    public void mo251b(ShareOldService shareOldService) {
        Debugger.m8607d("ShareOldServiceController", "onReady()");
        shareOldService.requestShareNow((String) this.f9616b, this.f9615a);
    }

    /* JADX INFO: renamed from: c */
    public boolean m14372c() {
        boolean zEquals = NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON.equals(C0145c.m331p("SyncEdp", "SyncEdpState", CoverStickerConstants.Category.NONE.NAME));
        this.f9615a = zEquals;
        return zEquals;
    }

    /* JADX INFO: renamed from: d */
    public void m14373d(InterfaceC13568b interfaceC13568b) {
        Debugger.m8615i("EdpInfoHelper", "[EDP] requestStateToServer()");
        if (!C0158a.m407a().m414e()) {
            Debugger.m8615i("EdpInfoHelper", "[EDP] fail to requestStateToServer() due to the limited data call!");
            return;
        }
        C6742k c6742k = (C6742k) this.f9616b;
        synchronized (((ArrayList) c6742k.f4110b)) {
            try {
                Iterator it = ((ArrayList) c6742k.f4110b).iterator();
                while (it.hasNext()) {
                    if (((InterfaceC13568b) it.next()) == interfaceC13568b) {
                        Debugger.m8615i("EdpInfoManager", "[EDP] requestState() : Listener exists!");
                        return;
                    }
                }
                ((ArrayList) c6742k.f4110b).add(interfaceC13568b);
                int size = ((ArrayList) c6742k.f4110b).size();
                if (size != 1) {
                    AbstractC0000a.m0A(size, "[EDP] requestState() : pass to requestRequiredConsent, # of listeners = ", "EdpInfoManager");
                    return;
                }
                Debugger.m8615i("EdpInfoManager", "[EDP] requestState() : RequestEdpState!");
                C6662a c6662a = new C6662a(c6742k, 2);
                C13571e c13571e = (C13571e) c6742k.f4111c;
                c13571e.f9624a = c6662a;
                if (c13571e.f9626c) {
                    Debugger.m8609e("RequestEdpStateTask", "[EDP] requestEdpState() : isRequestingEdpState is true!");
                    return;
                }
                c13571e.f9626c = true;
                Debugger.m8615i("RequestEdpStateTask", "run()");
                c13571e.f9625b = new CountDownLatch(1);
                new SenlThreadFactory("RequestEdpStateTaskThread").newThread(new RunnableC13570d(c13571e, 0)).start();
                new SenlThreadFactory("RequestEdpStateThread").newThread(new RunnableC13570d(c13571e, 1)).start();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX INFO: renamed from: e */
    public void m14374e(String str) {
        String upperCase = str.toUpperCase();
        upperCase.getClass();
        int iHashCode = upperCase.hashCode();
        boolean z = true;
        String str2 = NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_OFF;
        byte b = -1;
        switch (iHashCode) {
            case 2527:
                if (upperCase.equals(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON)) {
                    b = 0;
                }
                break;
            case 78159:
                if (upperCase.equals(NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_OFF)) {
                    b = 1;
                }
                break;
            case 2402104:
                if (upperCase.equals(CoverStickerConstants.Category.NONE.NAME)) {
                    b = 2;
                }
                break;
        }
        switch (b) {
            case 0:
                str2 = NotesSAConstants.DETAIL_SEARCH_INSIDE_FOLDERS_ON;
                break;
            default:
                Debugger.m8609e("EdpInfoHelper", "[EDP] setEdpState() : invalid EDP state = ".concat(upperCase));
            case 2:
                str2 = CoverStickerConstants.Category.NONE.NAME;
            case 1:
                z = false;
                break;
        }
        if (C0145c.m331p("SyncEdp", "SyncEdpState", CoverStickerConstants.Category.NONE.NAME).equals(str2)) {
            return;
        }
        Debugger.m8615i("EdpInfoHelper", "[EDP] storeEdpState() : ".concat(str2));
        C0145c.m310R("SyncEdp", "SyncEdpState", str2);
        Debugger.m8615i("EdpInfoHelper", "[EDP] setEdpState() : ".concat(str2));
        if (this.f9615a != z) {
            this.f9615a = z;
            Debugger.m8615i("EdpInfoHelper", "[EDP] setEdpState() : mIsEnabled = " + this.f9615a);
        }
    }
}
