package org.apache.commons.collections4.bloomfilter;

import java.util.Deque;
import java.util.function.Consumer;
import org.apache.commons.collections4.bloomfilter.LayerManager;

/* JADX INFO: renamed from: org.apache.commons.collections4.bloomfilter.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class C13754m implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f9736a;

    public /* synthetic */ C13754m(int i) {
        this.f9736a = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Deque deque = (Deque) obj;
        switch (this.f9736a) {
            case 0:
                LayerManager.Cleanup.lambda$noCleanup$0(deque);
                break;
            default:
                LayerManager.Cleanup.lambda$removeEmptyTarget$2(deque);
                break;
        }
    }
}
