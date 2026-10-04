package org.apache.commons.collections4.keyvalue;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.Serializable;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.KeyValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TiedMapEntry<K, V> implements Map.Entry<K, V>, KeyValue<K, V>, Serializable {
    private static final long serialVersionUID = -8453869361373831205L;
    private final K key;
    private final Map<K, V> map;

    public TiedMapEntry(Map<K, V> map, K k) {
        this.map = map;
        this.key = k;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.equals(this.key, entry.getKey()) && Objects.equals(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.map.get(this.key);
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        V value = getValue();
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        if (v != this) {
            return this.map.put(this.key, v);
        }
        throw new IllegalArgumentException("Cannot set value to this map entry");
    }

    public String toString() {
        return getKey() + MarketingConstants.REFERRER_DELIMITER_U003D + getValue();
    }
}
