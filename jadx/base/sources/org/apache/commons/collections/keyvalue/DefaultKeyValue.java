package org.apache.commons.collections.keyvalue;

import java.util.Map;
import org.apache.commons.collections.KeyValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DefaultKeyValue extends AbstractKeyValue {
    public DefaultKeyValue() {
        super(null, null);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultKeyValue)) {
            return false;
        }
        DefaultKeyValue defaultKeyValue = (DefaultKeyValue) obj;
        if (getKey() != null ? getKey().equals(defaultKeyValue.getKey()) : defaultKeyValue.getKey() == null) {
            if (getValue() != null ? getValue().equals(defaultKeyValue.getValue()) : defaultKeyValue.getValue() == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    public Object setKey(Object obj) {
        if (obj == this) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a key.");
        }
        Object obj2 = this.key;
        this.key = obj;
        return obj2;
    }

    public Object setValue(Object obj) {
        if (obj == this) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a value.");
        }
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }

    public Map.Entry toMapEntry() {
        return new DefaultMapEntry(this);
    }

    public DefaultKeyValue(Object obj, Object obj2) {
        super(obj, obj2);
    }

    public DefaultKeyValue(KeyValue keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public DefaultKeyValue(Map.Entry entry) {
        super(entry.getKey(), entry.getValue());
    }
}
