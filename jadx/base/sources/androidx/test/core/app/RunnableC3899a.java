package androidx.test.core.app;

import android.app.Activity;
import androidx.test.core.app.ActivityScenario;
import java.util.Set;

/* JADX INFO: renamed from: androidx.test.core.app.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class RunnableC3899a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1687a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1688b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f1689c;

    public /* synthetic */ RunnableC3899a(Object obj, Object obj2, int i) {
        this.f1687a = i;
        this.f1688b = obj;
        this.f1689c = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1687a) {
            case 0:
                InstrumentationActivityInvoker.lambda$checkActivityStageIsIn$0((Activity) this.f1688b, (Set) this.f1689c);
                break;
            default:
                ((ActivityScenario) this.f1688b).lambda$onActivity$2((ActivityScenario.ActivityAction) this.f1689c);
                break;
        }
    }
}
