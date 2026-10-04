package com.vladsch.flexmark.util.misc;

import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final class Pair<K, V> implements Paired<K, V> {
    private final K first;
    private final V second;

    public Pair(K k, V v) {
        this.first = k;
        this.second = v;
    }

    /* JADX INFO: renamed from: of */
    public static <K1, V1> Pair<K1, V1> m13429of(K1 k12, V1 v12) {
        return new Pair<>(k12, v12);
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (Objects.equals(this.first, entry.getKey())) {
            return Objects.equals(this.second, entry.getValue());
        }
        return false;
    }

    @Override // com.vladsch.flexmark.util.misc.Paired
    public K getFirst() {
        return this.first;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.first;
    }

    @Override // com.vladsch.flexmark.util.misc.Paired
    public V getSecond() {
        return this.second;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.second;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K k = this.first;
        int iHashCode = (k != null ? k.hashCode() : 0) * 31;
        V v = this.second;
        return iHashCode + (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new IllegalStateException("setValue not supported");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        K k = this.first;
        if (k == null) {
            sb.append("null");
        } else {
            sb.append(k);
        }
        sb.append(SQLKeyword.COMMA);
        V v = this.second;
        if (v == null) {
            sb.append("null");
        } else {
            sb.append(v);
        }
        sb.append(PropertyUtils.MAPPED_DELIM2);
        return sb.toString();
    }
}
