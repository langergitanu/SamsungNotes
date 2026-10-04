package p033H0;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes.NoteAttachmentTask;
import com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes.NoteCreateTask;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import java.util.concurrent.ExecutorService;
import p025F0.C0094i;
import p037I0.InterfaceC0122a;

/* JADX INFO: renamed from: H0.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0111a {

    /* JADX INFO: renamed from: a */
    public static C0111a f359a;

    /* JADX INFO: renamed from: b */
    public static final ExecutorService f360b = AbstractC4539a.m3201k("ConnectedNotesHelper");

    /* JADX INFO: renamed from: a */
    public static void m254a(String str, String str2, int i, InterfaceC0122a interfaceC0122a) {
        StringBuilder sbM1629s = AbstractC2322a.m1629s("addAttachmentNote, number : ", i, ", connectedNotesId : ", str, ", path : ");
        sbM1629s.append(str2);
        MSLogger.m8632d("ConnectedNotesHelper", sbM1629s.toString());
        try {
            new NoteAttachmentTask("https://graph.microsoft.com/beta/me/notes/" + str + "/attachments?nonIpmNote=1", "POST", "application/json", str2, i, interfaceC0122a).executeOnExecutor(f360b, new Void[0]);
        } catch (Exception e) {
            AbstractC6670b.m4753n(e, new StringBuilder("addAttachmentNote Failed, "), "ConnectedNotesHelper");
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m255b(C0094i c0094i, InterfaceC0122a interfaceC0122a) {
        MSLogger.m8632d("ConnectedNotesHelper", "createNote, uuid : " + c0094i.f306c);
        try {
            new NoteCreateTask("https://graph.microsoft.com/beta/me/notes?nonIpmNote=1", "POST", "application/json", c0094i, interfaceC0122a).executeOnExecutor(f360b, new Void[0]);
        } catch (Exception e) {
            AbstractC6670b.m4753n(e, new StringBuilder("createNote Failed, "), "ConnectedNotesHelper");
        }
    }

    /* JADX INFO: renamed from: c */
    public static synchronized C0111a m256c() {
        try {
            if (f359a == null) {
                f359a = new C0111a();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f359a;
    }
}
