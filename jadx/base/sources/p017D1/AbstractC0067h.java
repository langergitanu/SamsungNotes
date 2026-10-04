package p017D1;

import androidx.glance.AbstractC2821a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.error.SyncException;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.common.diagmon.DiagMonLogger;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.base.common.util.WDocUtils;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import p001A.AbstractC0000a;
import p012C1.RunnableC0045a;
import p022E1.C0075a;
import p022E1.C0077c;
import p022E1.C0082h;
import p026F1.C0097a;
import p042J1.C0145c;
import p173d0.C11971a;
import p178f0.C11979b;
import p182g0.C11991a;
import p195k1.C12969a;
import p207n1.C13541h;
import p234q1.C14433b;
import p235r0.C14437c;
import p253w1.InterfaceC14510a;

/* JADX INFO: renamed from: D1.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0067h extends AbstractC0068i {

    /* JADX INFO: renamed from: f */
    public final String f245f;

    /* JADX INFO: renamed from: g */
    public final C0075a f246g;

    public AbstractC0067h(C0077c c0077c, C0082h c0082h, InterfaceC14510a interfaceC14510a, C0097a c0097a, String str, C0075a c0075a) {
        super(c0077c, c0082h, interfaceC14510a, c0097a, str);
        this.f245f = WDocUtils.getNoteFilePath(c0077c.f262e);
        this.f246g = c0075a;
    }

    /* JADX INFO: renamed from: b */
    public static void m155b(C12969a c12969a) throws Throwable {
        C11971a c11971a = (C11971a) c12969a.f9309c;
        if (c11971a == null) {
            return;
        }
        ArrayList<C11991a> arrayList = ((C11979b) c11971a.f8526j.f4483b).f8577e;
        Debugger.m8607d("SyncNote/SyncSDocLocalNote", "checkValidWDocFile() start : " + arrayList.size());
        for (C11991a c11991a : arrayList) {
            try {
                String strM327l = C0145c.m327l(new File(c11991a.f8610c));
                if (!c11991a.f8618k.equals(strM327l)) {
                    StringBuilder sb = new StringBuilder("checkValidWDocFile() : invalid file = ");
                    sb.append(Debugger.getEncode(c11991a.f8613f));
                    sb.append(", filehash = ");
                    AbstractC2821a.m2207B(sb, c11991a.f8618k, ", realHash = ", strM327l, ", url = ");
                    sb.append(c11991a.f8617j);
                    Debugger.m8609e("SyncNote/SyncSDocLocalNote", sb.toString());
                    C14437c c14437c = new C14437c();
                    c14437c.f165b = "SPEN_ERROR";
                    c14437c.f164a = new Exception(DiagMonLogger.getExceptionMsg((String) c14437c.f165b, 304, ""));
                    c14437c.m62a();
                    throw new SyncException(337, "checkValidWDocFile() : fail to save the server note due to the invalid hash!");
                }
                Debugger.m8615i("SyncNote/SyncSDocLocalNote", "checkValidWDocFile() : valid file = " + Debugger.getEncode(c11991a.f8613f) + ", realHash = " + strM327l);
            } catch (Exception unused) {
                throw new SyncException(312, "checkValidWDocFile() : fail to getFileSHA256(file)");
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m156c(C12969a c12969a) throws SyncException {
        HashMap map = (HashMap) c12969a.f9310d;
        if (map.isEmpty()) {
            Debugger.m8607d("SyncNote/SyncSDocLocalNote", "downloadFiles() : No content file!");
            return;
        }
        C13541h c13541h = new C13541h(this.f237a, this.f240d, new C14433b(this, 2));
        if (map.isEmpty()) {
            Debugger.m8607d("SyncNote/SyncFiles", "downloadFiles() : No content file!");
            return;
        }
        for (C11991a c11991a : ((C11979b) ((C11971a) c12969a.f9309c).f8526j.f4483b).f8577e) {
            if (c11991a.f8621n) {
                ((ExecutorService) c13541h.f9591d).submit(new RunnableC0045a(c13541h, new C6903f(c13541h, 1, c11991a, c12969a), 0));
            }
        }
        ((ExecutorService) c13541h.f9591d).shutdown();
        c13541h.m14288a();
        SyncException syncException = (SyncException) c13541h.f9588a;
        if (syncException != null) {
            throw syncException;
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m157d(C11971a c11971a, String str, boolean z) throws SyncException {
        AbstractC4539a.m3215y("handleDownloadedWDocData() : isRecovery = ", "SyncNote/SyncSDocLocalNote", z);
        if (c11971a == null) {
            return;
        }
        String str2 = c11971a.f8532p;
        this.f238b.getClass();
        C0082h.m217e(str2);
        String str3 = c11971a.f8532p;
        try {
            if (this.f246g.m209a(this.f245f, str, str3, c11971a, this.f240d, z)) {
                Debugger.m8615i("SyncNote/SyncSDocLocalNote", "addDownloadedWDocDataToApp() : add " + str3);
            } else {
                Debugger.m8612ef("SyncNote/SyncSDocLocalNote", "addDownloadedWDocDataToApp() : fail to add " + str3);
            }
        } catch (SyncException e) {
            StringBuilder sbM15l = AbstractC0000a.m15l("addDownloadedWDocDataToApp() : fail to add ", str3, SQLKeyword.COMMA);
            sbM15l.append(e.toString());
            Debugger.m8612ef("SyncNote/SyncSDocLocalNote", sbM15l.toString());
            throw e;
        } catch (Exception e2) {
            Debugger.m8609e("SyncNote/SyncSDocLocalNote", "addDownloadedWDocDataToApp() : fail to add = " + str3);
            throw new SyncException(328, "fail to add WDoc data to app!", e2);
        }
    }
}
