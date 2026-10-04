package androidx.core.view;

import android.view.View;
import androidx.core.view.SoftwareKeyboardControllerCompat;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: androidx.core.view.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC2467l implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1349a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1350b;

    public /* synthetic */ RunnableC2467l(Object obj, int i) {
        this.f1349a = i;
        this.f1350b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1349a) {
            case 0:
                SoftwareKeyboardControllerCompat.Impl20.lambda$show$0((View) this.f1350b);
                break;
            default:
                ((Function0) this.f1350b).invoke();
                break;
        }
    }
}
