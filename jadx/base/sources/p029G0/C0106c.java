package p029G0;

import com.samsung.android.app.notes.sync.coedit.sharecore.strategy.AbstractC6670b;
import com.samsung.android.app.notes.sync.microsoft.graph.http.NotePageTask;
import com.samsung.android.support.senl.p148nt.base.common.log.MSLogger;
import java.util.List;
import p033H0.C0112b;
import p212o1.C13573a;

/* JADX INFO: renamed from: G0.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0106c {

    /* JADX INFO: renamed from: a */
    public String f349a;

    /* JADX INFO: renamed from: b */
    public String f350b;

    /* JADX INFO: renamed from: c */
    public String f351c;

    /* JADX INFO: renamed from: d */
    public List f352d;

    /* JADX INFO: renamed from: e */
    public int f353e;

    /* JADX INFO: renamed from: a */
    public final void m253a() {
        MSLogger.m8632d("UploadPage", "perform. ");
        C0112b c0112bM261h = C0112b.m261h();
        String str = this.f351c;
        String str2 = this.f350b;
        List list = this.f352d;
        int i = this.f353e;
        C13573a c13573a = new C13573a(this, 4);
        c0112bM261h.getClass();
        MSLogger.m8632d("GraphHttpHelper", "addPage ");
        try {
            new NotePageTask("https://graph.microsoft.com/v1.0/me/onenote/sections/" + str2 + "/pages", "POST", str, list, i, c13573a).execute(new Void[0]);
        } catch (Exception e) {
            AbstractC6670b.m4753n(e, new StringBuilder("addPage Failed, "), "GraphHttpHelper");
        }
    }
}
