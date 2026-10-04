package p122b2;

import com.samsung.android.mcf.continuity.api.ContinuitySessionFileManager;

/* JADX INFO: renamed from: b2.h */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC4185h implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1781a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ContinuitySessionFileManager.FileStatusListener f1782b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f1783c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ double f1784d;

    public /* synthetic */ RunnableC4185h(int i, int i2, double d, ContinuitySessionFileManager.FileStatusListener fileStatusListener) {
        this.f1781a = i2;
        this.f1782b = fileStatusListener;
        this.f1783c = i;
        this.f1784d = d;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1781a) {
            case 0:
                this.f1782b.onFileStatusUpdated(this.f1783c, this.f1784d);
                break;
            case 1:
                this.f1782b.onFileStatusUpdated(this.f1783c, this.f1784d);
                break;
            default:
                this.f1782b.onFileStatusUpdated(this.f1783c, this.f1784d);
                break;
        }
    }
}
