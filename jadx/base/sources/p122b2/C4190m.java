package p122b2;

import com.samsung.android.mcf.continuity.impl.ContinuitySession;
import java.util.function.Consumer;

/* JADX INFO: renamed from: b2.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C4190m implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1799a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContinuitySession f1800b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f1801c;

    public /* synthetic */ C4190m(ContinuitySession continuitySession, String str, int i) {
        this.f1799a = i;
        this.f1800b = continuitySession;
        this.f1801c = str;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f1799a) {
            case 0:
                this.f1800b.lambda$onAccepted$0(this.f1801c, (Boolean) obj);
                break;
            default:
                this.f1800b.lambda$handlePeerConnected$6(this.f1801c, (Boolean) obj);
                break;
        }
    }
}
