package org.apache.commons.collections.keyvalue;

import java.util.Map;
import org.apache.commons.collections.KeyValue;
import org.apache.commons.collections.Unmodifiable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class UnmodifiableMapEntry extends AbstractMapEntry implements Unmodifiable {
    public UnmodifiableMapEntry(Object obj, Object obj2) {
        super(obj, obj2);
    }

    @Override // org.apache.commons.collections.keyvalue.AbstractMapEntry, java.util.Map.Entry
    public Object setValue(Object obj) {
        throw new UnsupportedOperationException("setValue() is not supported");
    }

    public UnmodifiableMapEntry(KeyValue keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public UnmodifiableMapEntry(Map.Entry entry) {
        super(entry.getKey(), entry.getValue());
    }
}
