package androidx.appcompat.app;

import android.content.Context;
import android.widget.LinearLayout;

/* JADX INFO: renamed from: androidx.appcompat.app.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC0452b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f938a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f939b;

    public /* synthetic */ RunnableC0452b(Object obj, int i) {
        this.f938a = i;
        this.f939b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f938a) {
            case 0:
                AppCompatDelegate.lambda$syncRequestedAndStoredLocales$1((Context) this.f939b);
                break;
            case 1:
                AppCompatDelegate.syncRequestedAndStoredLocales((Context) this.f939b);
                break;
            default:
                AlertController.lambda$seslExpandTouchTarget$0((LinearLayout) this.f939b);
                break;
        }
    }
}
