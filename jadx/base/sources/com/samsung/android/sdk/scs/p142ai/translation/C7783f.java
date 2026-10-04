package com.samsung.android.sdk.scs.p142ai.translation;

import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.translation.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7783f implements OnCompleteListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5242a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ NeuralTranslator f5243b;

    public /* synthetic */ C7783f(NeuralTranslator neuralTranslator, int i) {
        this.f5242a = i;
        this.f5243b = neuralTranslator;
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        switch (this.f5242a) {
            case 0:
                this.f5243b.lambda$clear$3(task);
                break;
            case 1:
                this.f5243b.lambda$refresh$5(task);
                break;
            default:
                this.f5243b.lambda$clear$4(task);
                break;
        }
    }
}
