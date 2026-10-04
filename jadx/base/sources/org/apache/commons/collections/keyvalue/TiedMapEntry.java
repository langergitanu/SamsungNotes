package org.apache.commons.collections.keyvalue;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.KeyValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TiedMapEntry implements Map.Entry, KeyValue, Serializable {
    private static final long serialVersionUID = -8453869361373831205L;
    private final Object key;
    private final Map map;

    public TiedMapEntry(Map map, Object obj) {
        this.map = map;
        this.key = obj;
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
        Object value = getValue();
        Object obj2 = this.key;
        if (obj2 != null ? obj2.equals(entry.getKey()) : entry.getKey() == null) {
            Object value2 = entry.getValue();
            if (value != null ? value.equals(value2) : value2 == null) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
    public Object getKey() {
        return this.key;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
    public Object getValue() {
        return this.map.get(this.key);
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        Object value = getValue();
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        if (obj != this) {
            return this.map.put(this.key, obj);
        }
        throw new IllegalArgumentException("Cannot set value to this map entry");
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getKey());
        stringBuffer.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        stringBuffer.append(getValue());
        return stringBuffer.toString();
    }
}
