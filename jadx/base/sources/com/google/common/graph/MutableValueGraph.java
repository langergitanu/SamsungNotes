package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@Beta
@ElementTypesAreNonnullByDefault
public interface MutableValueGraph<N, V> extends ValueGraph<N, V> {
    @CanIgnoreReturnValue
    boolean addNode(N n);

    @CanIgnoreReturnValue
    @CheckForNull
    V putEdgeValue(EndpointPair<N> endpointPair, V v);

    @CanIgnoreReturnValue
    @CheckForNull
    V putEdgeValue(N n, N n2, V v);

    @CanIgnoreReturnValue
    @CheckForNull
    V removeEdge(EndpointPair<N> endpointPair);

    @CanIgnoreReturnValue
    @CheckForNull
    V removeEdge(N n, N n2);

    @CanIgnoreReturnValue
    boolean removeNode(N n);
}
