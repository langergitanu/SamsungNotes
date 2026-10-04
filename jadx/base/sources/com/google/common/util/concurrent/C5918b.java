package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractScheduledService;

/* JADX INFO: renamed from: com.google.common.util.concurrent.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5918b implements Supplier {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3422a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AbstractService f3423b;

    public /* synthetic */ C5918b(AbstractService abstractService, int i) {
        this.f3422a = i;
        this.f3423b = abstractService;
    }

    @Override // com.google.common.base.Supplier
    public final Object get() {
        switch (this.f3422a) {
            case 0:
                return ((AbstractExecutionThreadService.C58531) this.f3423b).lambda$doStart$0();
            default:
                return ((AbstractScheduledService.ServiceDelegate) this.f3423b).lambda$doStart$0();
        }
    }
}
