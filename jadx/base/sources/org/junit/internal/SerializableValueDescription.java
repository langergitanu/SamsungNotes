package org.junit.internal;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
class SerializableValueDescription implements Serializable {
    private final String value;

    private SerializableValueDescription(Object obj) {
        this.value = String.valueOf(obj);
    }

    public static Object asSerializableValue(Object obj) {
        return (obj == null || (obj instanceof Serializable)) ? obj : new SerializableValueDescription(obj);
    }

    public String toString() {
        return this.value;
    }
}
