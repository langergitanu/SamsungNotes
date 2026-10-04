package androidx.compose.foundation.text.input.internal;

import java.util.function.IntConsumer;

/* JADX INFO: renamed from: androidx.compose.foundation.text.input.internal.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RunnableC1345c implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f1042a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ IntConsumer f1043b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f1044c;

    public /* synthetic */ RunnableC1345c(IntConsumer intConsumer, int i, int i2) {
        this.f1042a = i2;
        this.f1043b = intConsumer;
        this.f1044c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1042a) {
            case 0:
                this.f1043b.accept(this.f1044c);
                break;
            default:
                this.f1043b.accept(this.f1044c);
                break;
        }
    }
}
