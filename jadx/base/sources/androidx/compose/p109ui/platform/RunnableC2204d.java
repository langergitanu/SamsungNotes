package androidx.compose.p109ui.platform;

import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: androidx.compose.ui.platform.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC2204d implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1185a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f1186b;

    public /* synthetic */ RunnableC2204d(Object obj, int i) {
        this.f1185a = i;
        this.f1186b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1185a) {
            case 0:
                ((Function0) this.f1186b).invoke();
                break;
            case 1:
                AndroidComposeView.sendHoverExitEvent$lambda$8((AndroidComposeView) this.f1186b);
                break;
            default:
                AndroidComposeViewAccessibilityDelegateCompat.semanticsChangeChecker$lambda$49((AndroidComposeViewAccessibilityDelegateCompat) this.f1186b);
                break;
        }
    }
}
