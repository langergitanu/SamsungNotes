package com.google.common.graph;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
final class UndirectedNetworkConnections<N, E> extends AbstractUndirectedNetworkConnections<N, E> {
    public UndirectedNetworkConnections(Map<E, N> map) {
        super(map);
    }

    /* JADX INFO: renamed from: of */
    public static <N, E> UndirectedNetworkConnections<N, E> m4442of() {
        return new UndirectedNetworkConnections<>(HashBiMap.create(2));
    }

    public static <N, E> UndirectedNetworkConnections<N, E> ofImmutable(Map<E, N> map) {
        return new UndirectedNetworkConnections<>(ImmutableBiMap.copyOf((Map) map));
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<N> adjacentNodes() {
        return Collections.unmodifiableSet(((BiMap) this.incidentEdgeMap).values());
    }

    @Override // com.google.common.graph.NetworkConnections
    public Set<E> edgesConnecting(N n) {
        return new EdgesConnecting(((BiMap) this.incidentEdgeMap).inverse(), n);
    }
}
