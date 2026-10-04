package com.google.android.play.core.splitinstall;

/* JADX INFO: renamed from: com.google.android.play.core.splitinstall.s */
/* JADX INFO: loaded from: classes5.dex */
final class RunnableC5318s implements Runnable {

    /* JADX INFO: renamed from: a */
    final /* synthetic */ SplitInstallSessionState f3146a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ int f3147b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ int f3148c;

    /* JADX INFO: renamed from: d */
    final /* synthetic */ C5319t f3149d;

    public RunnableC5318s(C5319t c5319t, SplitInstallSessionState splitInstallSessionState, int i, int i2) {
        this.f3149d = c5319t;
        this.f3146a = splitInstallSessionState;
        this.f3147b = i;
        this.f3148c = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C5319t c5319t = this.f3149d;
        SplitInstallSessionState splitInstallSessionState = this.f3146a;
        c5319t.m4034a(new C5273a(splitInstallSessionState.sessionId(), this.f3147b, this.f3148c, splitInstallSessionState.bytesDownloaded(), splitInstallSessionState.totalBytesToDownload(), splitInstallSessionState.mo4104a(), splitInstallSessionState.mo4105b(), splitInstallSessionState.resolutionIntent(), splitInstallSessionState.mo4106c()));
    }
}
