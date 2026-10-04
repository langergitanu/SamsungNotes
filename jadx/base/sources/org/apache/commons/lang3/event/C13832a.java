package org.apache.commons.lang3.event;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.function.Failable;
import org.apache.commons.lang3.function.FailableConsumer;

/* JADX INFO: renamed from: org.apache.commons.lang3.event.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13832a implements FailableConsumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9822a;

    public /* synthetic */ C13832a(int i) {
        this.f9822a = i;
    }

    @Override // org.apache.commons.lang3.function.FailableConsumer
    public final void accept(Object obj) {
        Throwable th = (Throwable) obj;
        switch (this.f9822a) {
            case 0:
                ExceptionUtils.rethrow(th);
                break;
            default:
                Failable.rethrow(th);
                break;
        }
    }
}
