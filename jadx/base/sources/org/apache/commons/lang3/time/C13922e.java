package org.apache.commons.lang3.time;

import java.time.Instant;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableRunnable;

/* JADX INFO: renamed from: org.apache.commons.lang3.time.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13922e implements FailableConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9955a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9956b;

    public /* synthetic */ C13922e(Object obj, int i) {
        this.f9955a = i;
        this.f9956b = obj;
    }

    @Override // org.apache.commons.lang3.function.FailableConsumer
    public final void accept(Object obj) {
        switch (this.f9955a) {
            case 0:
                ((FailableRunnable) this.f9956b).run();
                break;
            default:
                ((FailableConsumer) this.f9956b).accept((Instant) obj);
                break;
        }
    }
}
