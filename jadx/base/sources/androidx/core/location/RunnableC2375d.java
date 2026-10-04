package androidx.core.location;

import android.location.Location;
import androidx.core.util.Consumer;

/* JADX INFO: renamed from: androidx.core.location.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2375d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1282a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Consumer f1283b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Location f1284c;

    public /* synthetic */ RunnableC2375d(Consumer consumer, Location location, int i) {
        this.f1282a = i;
        this.f1283b = consumer;
        this.f1284c = location;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1282a) {
            case 0:
                this.f1283b.accept(this.f1284c);
                break;
            default:
                this.f1283b.accept(this.f1284c);
                break;
        }
    }
}
