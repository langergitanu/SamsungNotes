package org.apache.commons.lang3;

import java.util.function.Function;
import org.apache.commons.lang3.Functions;
import org.apache.commons.lang3.function.FailableConsumer;

/* JADX INFO: renamed from: org.apache.commons.lang3.u */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13926u implements FailableConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9966a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f9967b;

    public /* synthetic */ C13926u(Object obj, int i) {
        this.f9966a = i;
        this.f9967b = obj;
    }

    @Override // org.apache.commons.lang3.function.FailableConsumer
    public final void accept(Object obj) {
        switch (this.f9966a) {
            case 0:
                ((Functions.FailableConsumer) this.f9967b).accept((Throwable) obj);
                break;
            default:
                ((Function) this.f9967b).apply(obj);
                break;
        }
    }
}
