package com.google.common.graph;

import com.google.common.base.Function;

/* JADX INFO: renamed from: com.google.common.graph.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5767b implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3358a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Network f3359b;

    public /* synthetic */ C5767b(Network network, int i) {
        this.f3358a = i;
        this.f3359b = network;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3358a) {
            case 0:
                return this.f3359b.incidentNodes(obj);
            case 1:
                return ImmutableNetwork.lambda$sourceNodeFn$0(this.f3359b, obj);
            default:
                return ImmutableNetwork.lambda$targetNodeFn$1(this.f3359b, obj);
        }
    }
}
