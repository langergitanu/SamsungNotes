package androidx.activity;

import androidx.activity.ComponentActivity;

/* JADX INFO: renamed from: androidx.activity.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0407d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f896a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f897b;

    public /* synthetic */ RunnableC0407d(Object obj, int i) {
        this.f896a = i;
        this.f897b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f896a) {
            case 0:
                ((ComponentActivity.ReportFullyDrawnExecutorApi16Impl) this.f897b).lambda$execute$0();
                break;
            case 1:
                ((ComponentActivity) this.f897b).invalidateMenu();
                break;
            case 2:
                ComponentDialog.onBackPressedDispatcher$lambda$1((ComponentDialog) this.f897b);
                break;
            default:
                FullyDrawnReporter.reportRunnable$lambda$2((FullyDrawnReporter) this.f897b);
                break;
        }
    }
}
