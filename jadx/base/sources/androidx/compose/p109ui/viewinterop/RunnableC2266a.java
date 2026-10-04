package androidx.compose.p109ui.viewinterop;

import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: androidx.compose.ui.viewinterop.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2266a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1206a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Function0 f1207b;

    public /* synthetic */ RunnableC2266a(Function0 function0, int i) {
        this.f1206a = i;
        this.f1207b = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1206a) {
            case 0:
                this.f1207b.invoke();
                break;
            default:
                this.f1207b.invoke();
                break;
        }
    }
}
