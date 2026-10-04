package org.apache.commons.collections;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultMapEntry implements Map.Entry, KeyValue {
    private Object key;
    private Object value;

    public DefaultMapEntry() {
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
        if (getKey() != null ? getKey().equals(entry.getKey()) : entry.getKey() == null) {
            if (getValue() != null ? getValue().equals(entry.getValue()) : entry.getValue() == null) {
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
        return this.value;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    public void setKey(Object obj) {
        this.key = obj;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append(getKey());
        stringBuffer.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        stringBuffer.append(getValue());
        return stringBuffer.toString();
    }

    public DefaultMapEntry(Map.Entry entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    public DefaultMapEntry(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }
}
