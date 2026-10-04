package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(@CheckForNull Object obj);

    @Override // 
    List<V> get(@ParametricNullness K k);

    @Override // 
    @CanIgnoreReturnValue
    List<V> removeAll(@CheckForNull Object obj);

    @Override // 
    @CanIgnoreReturnValue
    List<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable);
}
