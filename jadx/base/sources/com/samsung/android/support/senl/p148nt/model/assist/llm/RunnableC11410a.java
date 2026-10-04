package com.samsung.android.support.senl.p148nt.model.assist.llm;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.assist.llm.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class RunnableC11410a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7683a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NeuralTranslator f7684b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f7685c;

    public /* synthetic */ RunnableC11410a(NeuralTranslator neuralTranslator, String str, int i) {
        this.f7683a = i;
        this.f7684b = neuralTranslator;
        this.f7685c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f7683a) {
            case 0:
                this.f7684b.lambda$execute$0(this.f7685c);
                break;
            default:
                this.f7684b.lambda$translate$1(this.f7685c);
                break;
        }
    }
}
