package org.slf4j.event;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class KeyValuePair {
    public final String key;
    public final Object value;

    public KeyValuePair(String str, Object obj) {
        this.key = str;
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            KeyValuePair keyValuePair = (KeyValuePair) obj;
            if (Objects.equals(this.key, keyValuePair.key) && Objects.equals(this.value, keyValuePair.value)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Objects.hash(this.key, this.value);
    }

    public String toString() {
        return String.valueOf(this.key) + "=\"" + String.valueOf(this.value) + "\"";
    }
}
