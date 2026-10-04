package p017D1;

import com.samsung.android.app.notes.sync.error.SyncException;
import p026F1.AbstractC0100d;

/* JADX INFO: renamed from: D1.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public abstract class AbstractC0068i extends AbstractC0060a {
    /* JADX INFO: renamed from: a */
    public static void m158a() throws SyncException {
        AbstractC0100d.f327a = false;
        if (AbstractC0100d.f328b) {
            AbstractC0100d.f328b = false;
            throw new SyncException(507, "Push is received and resync!");
        }
    }
}
