package org.apache.commons.collections.keyvalue;

import org.apache.commons.collections.KeyValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractKeyValue implements KeyValue {
    protected Object key;
    protected Object value;

    public AbstractKeyValue(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    @Override // org.apache.commons.collections.KeyValue
    public Object getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections.KeyValue
    public Object getValue() {
        return this.value;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getKey());
        stringBuffer.append('=');
        stringBuffer.append(getValue());
        return stringBuffer.toString();
    }
}
