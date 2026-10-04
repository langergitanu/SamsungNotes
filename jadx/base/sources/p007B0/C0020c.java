package p007B0;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.microsoft.graph.http.connectednotes.NoteDeleteTask;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import p033H0.C0111a;
import p186h1.C12020a;

/* JADX INFO: renamed from: B0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0020c {

    /* JADX INFO: renamed from: a */
    public String f110a;

    /* JADX INFO: renamed from: b */
    public String f111b;

    public C0020c(String str, String str2) {
        this.f110a = str;
        this.f111b = str2;
    }

    /* JADX INFO: renamed from: a */
    public void m45a() {
        StringBuilder sb = new StringBuilder("perform. uuid : ");
        sb.append(this.f111b);
        sb.append("connectedNotesId : ");
        String str = this.f110a;
        sb.append(str);
        MSLogger.m8632d(Bixby2Constants.BIXBY_ACTION_DELETE, sb.toString());
        C0111a c0111aM256c = C0111a.m256c();
        C12020a c12020a = new C12020a(this, 3);
        c0111aM256c.getClass();
        MSLogger.m8632d("ConnectedNotesHelper", "deleteNote, connectedNotesid : " + str);
        try {
            new NoteDeleteTask("https://graph.microsoft.com/beta/me/notes/" + str + "?nonIpmNote=1", "DELETE", c12020a).executeOnExecutor(C0111a.f360b, new Void[0]);
        } catch (Exception e) {
            AbstractC6670b.m4753n(e, new StringBuilder("deleteNote Failed, "), "ConnectedNotesHelper");
        }
    }
}
