package org.apache.commons.lang3;

import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.FailableIntConsumer;
import org.apache.commons.lang3.function.FailableRunnable;

/* JADX INFO: renamed from: org.apache.commons.lang3.s */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13898s implements FailableRunnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9929a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f9930b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f9931c;

    public /* synthetic */ C13898s(Object obj, int i, int i2) {
        this.f9929a = i2;
        this.f9931c = obj;
        this.f9930b = i;
    }

    @Override // org.apache.commons.lang3.function.FailableRunnable
    public final void run() {
        switch (this.f9929a) {
            case 0:
                Functions.lambda$tryWithResources$15((Functions.FailableRunnable[]) this.f9931c, this.f9930b);
                break;
            default:
                ((FailableIntConsumer) this.f9931c).accept(this.f9930b);
                break;
        }
    }
}
