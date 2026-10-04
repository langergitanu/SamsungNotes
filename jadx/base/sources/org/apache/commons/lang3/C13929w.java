package org.apache.commons.lang3;

import org.apache.commons.lang3.function.FailableBiConsumer;

/* JADX INFO: renamed from: org.apache.commons.lang3.w */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13929w implements FailableBiConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9970a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9971b;

    public /* synthetic */ C13929w(Object obj, int i) {
        this.f9970a = i;
        this.f9971b = obj;
    }

    @Override // org.apache.commons.lang3.function.FailableBiConsumer
    public final void accept(Object obj, Object obj2) throws InterruptedException {
        switch (this.f9970a) {
            case 0:
                this.f9971b.wait(((Long) obj).longValue(), ((Integer) obj2).intValue());
                break;
            default:
                ((Thread) this.f9971b).join(((Long) obj).longValue(), ((Integer) obj2).intValue());
                break;
        }
    }
}
