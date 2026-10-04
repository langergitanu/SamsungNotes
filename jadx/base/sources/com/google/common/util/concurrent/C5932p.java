package com.google.common.util.concurrent;

import com.google.common.base.Supplier;

/* JADX INFO: renamed from: com.google.common.util.concurrent.p */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5932p implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3452a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f3453b;

    public /* synthetic */ C5932p(int i, int i2) {
        this.f3452a = i2;
        this.f3453b = i;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f3452a) {
            case 0:
                return Striped.lambda$semaphore$1(this.f3453b);
            default:
                return Striped.lambda$lazyWeakSemaphore$2(this.f3453b);
        }
    }
}
