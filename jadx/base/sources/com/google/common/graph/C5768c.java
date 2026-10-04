package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.AbstractNetwork;
import com.google.common.graph.Graphs;

/* JADX INFO: renamed from: com.google.common.graph.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5768c implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3360a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3361b;

    public /* synthetic */ C5768c(Object obj, int i) {
        this.f3360a = i;
        this.f3361b = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3360a) {
            case 0:
                return ((AbstractNetwork.C57371.AnonymousClass1) this.f3361b).lambda$iterator$0(obj);
            case 1:
                return ((Graphs.TransposedGraph.C57491) this.f3361b).lambda$iterator$0((EndpointPair) obj);
            default:
                return AbstractValueGraph.lambda$edgeValueMap$0((ValueGraph) this.f3361b, (EndpointPair) obj);
        }
    }
}
