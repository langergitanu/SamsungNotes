package com.vladsch.flexmark.util.collection;

import java.util.Map;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class MapEntry<K, V> implements Map.Entry<K, V> {

    @NotNull
    private final K key;

    @Nullable
    private final V value;

    public MapEntry(@NotNull K k, @Nullable V v) {
        this.key = k;
        this.value = v;
    }

    @Override // java.util.Map.Entry
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || MapEntry.class != obj.getClass()) {
            return false;
        }
        MapEntry mapEntry = (MapEntry) obj;
        if (Objects.equals(this.key, mapEntry.key)) {
            return Objects.equals(this.value, mapEntry.value);
        }
        return false;
    }

    @Override // java.util.Map.Entry
    @NotNull
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry
    @Nullable
    public V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        int iHashCode = this.key.hashCode() * 31;
        V v = this.value;
        return iHashCode + (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    @Nullable
    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
