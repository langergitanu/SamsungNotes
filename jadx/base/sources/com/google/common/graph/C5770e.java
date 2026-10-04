package com.google.common.graph;

import com.google.common.base.Function;

/* JADX INFO: renamed from: com.google.common.graph.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5770e implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3364a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3365b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f3366c;

    public /* synthetic */ C5770e(Object obj, Object obj2, int i) {
        this.f3364a = i;
        this.f3366c = obj;
        this.f3365b = obj2;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3364a) {
            case 0:
                return ImmutableNetwork.lambda$adjacentNodeFn$2((Network) this.f3366c, this.f3365b, obj);
            default:
                return ImmutableValueGraph.lambda$connectionsOf$0((ValueGraph) this.f3366c, this.f3365b, obj);
        }
    }
}
