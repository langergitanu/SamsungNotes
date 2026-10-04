package p122b2;

import android.content.Context;
import com.samsung.android.mcf.continuity.impl.ContinuityAdapterImpl;

/* JADX INFO: renamed from: b2.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4179b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1758a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContinuityAdapterImpl f1759b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Context f1760c;

    public /* synthetic */ RunnableC4179b(ContinuityAdapterImpl continuityAdapterImpl, Context context, int i) {
        this.f1758a = i;
        this.f1759b = continuityAdapterImpl;
        this.f1760c = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1758a) {
            case 0:
                this.f1759b.lambda$unbindService$3(this.f1760c);
                break;
            default:
                this.f1759b.lambda$release$1(this.f1760c);
                break;
        }
    }
}
