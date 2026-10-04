package p008B1;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.data.AbstractC4539a;
import com.samsung.android.app.notes.sync.synchronization.managers.C6903f;
import com.samsung.android.support.senl.p148nt.base.common.diagmon.DiagMonLogger;
import p001A.AbstractC0000a;
import p026F1.C0097a;

/* JADX INFO: renamed from: B1.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0033f {

    /* JADX INFO: renamed from: a */
    public Object f164a;

    /* JADX INFO: renamed from: b */
    public Object f165b;

    /* JADX INFO: renamed from: c */
    public Object f166c;

    public /* synthetic */ AbstractC0033f(C6903f c6903f, Context context, C0097a c0097a) {
        this.f164a = c6903f;
        this.f165b = context;
        this.f166c = c0097a;
    }

    /* JADX INFO: renamed from: a */
    public void m62a() {
        StringBuilder sb = new StringBuilder("sendOnce() : mainErrCode = ");
        sb.append((String) this.f165b);
        sb.append(" , ");
        AbstractC0000a.m21r((Exception) this.f164a, sb, "SyncErrorDiagmon");
        try {
            if (TextUtils.isEmpty((String) this.f166c)) {
                DiagMonLogger.reportOnce((Exception) this.f164a, (String) this.f165b);
            } else {
                DiagMonLogger.reportOnce((Exception) this.f164a, (String) this.f165b, (String) this.f166c);
            }
        } catch (Exception e) {
            AbstractC4539a.m3213w(e, new StringBuilder("sendOnce() : fail to report = "), "SyncErrorDiagmon");
        }
    }
}
