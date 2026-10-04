package com.opencsv.bean;

import java.util.Deque;
import java.util.function.Consumer;
import org.apache.commons.collections4.bloomfilter.LayerManager;

/* JADX INFO: renamed from: com.opencsv.bean.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C6629l implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3688a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f3689b;

    public /* synthetic */ C6629l(int i, int i2) {
        this.f3688a = i2;
        this.f3689b = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f3688a) {
            case 0:
                ((PositionToBeanField) obj).attenuateRanges(this.f3689b);
                break;
            default:
                LayerManager.Cleanup.lambda$onMaxSize$1(this.f3689b, (Deque) obj);
                break;
        }
    }
}
