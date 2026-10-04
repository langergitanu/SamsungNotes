package p122b2;

import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;
import com.samsung.android.mcf.continuity.impl.ContinuityConnection;
import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import java.net.Socket;
import java.util.function.BiFunction;

/* JADX INFO: renamed from: b2.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C4188k implements BiFunction {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1791a = 0;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ String f1792b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Socket f1793c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f1794d;

    public /* synthetic */ C4188k(ContinuitySession continuitySession, Socket socket, String str) {
        this.f1794d = continuitySession;
        this.f1793c = socket;
        this.f1792b = str;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        switch (this.f1791a) {
            case 0:
                return ((ContinuitySession) this.f1794d).lambda$onAccepted$1(this.f1793c, this.f1792b, (String) obj, (ContinuityConnection) obj2);
            default:
                return ContinuitySession.lambda$onAccepted$2(this.f1792b, this.f1793c, (ContinuitySessionFileManager.FileInfoListener) this.f1794d, (String) obj, (ContinuityConnection) obj2);
        }
    }

    public /* synthetic */ C4188k(String str, Socket socket, ContinuitySessionFileManager.FileInfoListener fileInfoListener) {
        this.f1792b = str;
        this.f1793c = socket;
        this.f1794d = fileInfoListener;
    }
}
