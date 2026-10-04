package org.apache.commons.collections.keyvalue;

import java.util.Map;
import org.apache.commons.collections.KeyValue;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DefaultMapEntry extends AbstractMapEntry {
    public DefaultMapEntry(Object obj, Object obj2) {
        super(obj, obj2);
    }

    public DefaultMapEntry(KeyValue keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public DefaultMapEntry(Map.Entry entry) {
        super(entry.getKey(), entry.getValue());
    }
}
