package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.graph.DirectedGraphConnections;

/* JADX INFO: renamed from: com.google.common.graph.d */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C5769d implements Function {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f3362a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f3363b;

    public /* synthetic */ C5769d(Object obj, int i) {
        this.f3362a = i;
        this.f3363b = obj;
    }

    @Override // com.google.common.base.Function
    public final Object apply(Object obj) {
        switch (this.f3362a) {
            case 0:
                return DirectedGraphConnections.lambda$incidentEdgeIterator$0(this.f3363b, obj);
            case 1:
                return EndpointPair.ordered(this.f3363b, obj);
            case 2:
                return DirectedGraphConnections.lambda$incidentEdgeIterator$2(this.f3363b, (DirectedGraphConnections.NodeConnection) obj);
            default:
                return EndpointPair.unordered(this.f3363b, obj);
        }
    }
}
