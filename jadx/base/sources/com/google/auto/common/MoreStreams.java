package com.google.auto.common;

import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class MoreStreams {
    private MoreStreams() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map.Entry lambda$toImmutableBiMap$3(Function function, Function function2, Object obj) {
        return Maps.immutableEntry(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableBiMap.Builder lambda$toImmutableBiMap$5(ImmutableBiMap.Builder builder, ImmutableBiMap.Builder builder2) {
        return builder.putAll((Map) builder2.build());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Map.Entry lambda$toImmutableMap$0(Function function, Function function2, Object obj) {
        return Maps.immutableEntry(function.apply(obj), function2.apply(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ ImmutableMap.Builder lambda$toImmutableMap$2(ImmutableMap.Builder builder, ImmutableMap.Builder builder2) {
        return builder.putAll(builder2.build());
    }

    public static <T, K, V> Collector<T, ?, ImmutableBiMap<K, V>> toImmutableBiMap(Function<? super T, K> function, Function<? super T, V> function2) {
        int i = 0;
        return Collectors.mapping(new C5412B(function, function2, i), Collector.of(new C5415D(0), new C5416E(i), new C5414C(1), new C5452v(5), new Collector.Characteristics[0]));
    }

    public static <T> Collector<T, ?, ImmutableList<T>> toImmutableList() {
        return Collectors.collectingAndThen(Collectors.toList(), new C5452v(7));
    }

    public static <T, K, V> Collector<T, ?, ImmutableMap<K, V>> toImmutableMap(Function<? super T, K> function, Function<? super T, V> function2) {
        int i = 1;
        return Collectors.mapping(new C5412B(function, function2, i), Collector.of(new C5415D(1), new C5416E(i), new C5414C(0), new C5452v(4), new Collector.Characteristics[0]));
    }

    public static <T> Collector<T, ?, ImmutableSet<T>> toImmutableSet() {
        return Collectors.collectingAndThen(Collectors.toList(), new C5452v(6));
    }
}
