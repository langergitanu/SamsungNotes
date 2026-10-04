package androidx.compose.p109ui.scrollcapture;

import android.os.CancellationSignal;
import java.util.concurrent.CancellationException;
import kotlinx.coroutines.Job;

/* JADX INFO: renamed from: androidx.compose.ui.scrollcapture.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C2223a implements CancellationSignal.OnCancelListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1194a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Job f1195b;

    public /* synthetic */ C2223a(Job job, int i) {
        this.f1194a = i;
        this.f1195b = job;
    }

    @Override // android.os.CancellationSignal.OnCancelListener
    public final void onCancel() {
        switch (this.f1194a) {
            case 0:
                Job.DefaultImpls.cancel$default(this.f1195b, (CancellationException) null, 1, (Object) null);
                break;
            default:
                Job.DefaultImpls.cancel$default(this.f1195b, (CancellationException) null, 1, (Object) null);
                break;
        }
    }
}
