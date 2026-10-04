package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

/* JADX INFO: renamed from: androidx.profileinstaller.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC3726a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1640a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f1641b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f1642c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f1643d;

    public /* synthetic */ RunnableC3726a(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj, int i2) {
        this.f1640a = i2;
        this.f1641b = diagnosticsCallback;
        this.f1642c = i;
        this.f1643d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1640a) {
            case 0:
                this.f1641b.onResultReceived(this.f1642c, this.f1643d);
                break;
            default:
                this.f1641b.onDiagnosticReceived(this.f1642c, this.f1643d);
                break;
        }
    }
}
