package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.DoNotMock;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock("Implement with a lambda, or use GraphBuilder to build a Graph with the desired edges")
@Beta
@ElementTypesAreNonnullByDefault
public interface PredecessorsFunction<N> {
    Iterable<? extends N> predecessors(N n);
}
