package p031G2;

import com.samsung.android.support.senl.docscan.DocumentScanActivity;

/* JADX INFO: renamed from: G2.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public final /* synthetic */ class RunnableC0108a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f354a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ DocumentScanActivity f355b;

    public /* synthetic */ RunnableC0108a(DocumentScanActivity documentScanActivity, int i) {
        this.f354a = i;
        this.f355b = documentScanActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f354a) {
            case 0:
                this.f355b.finishWithFailed("Permission not granted");
                break;
            default:
                DocumentScanActivity.mPostActionWhenDenied$lambda$1(this.f355b);
                break;
        }
    }
}
