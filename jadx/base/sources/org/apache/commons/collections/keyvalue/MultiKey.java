package org.apache.commons.collections.keyvalue;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MultiKey implements Serializable {
    private static final long serialVersionUID = 4465448607415788805L;
    private transient int hashCode;
    private final Object[] keys;

    public MultiKey(Object obj, Object obj2) {
        this(new Object[]{obj, obj2}, false);
    }

    private void calculateHashCode(Object[] objArr) {
        int iHashCode = 0;
        for (Object obj : objArr) {
            if (obj != null) {
                iHashCode ^= obj.hashCode();
            }
        }
        this.hashCode = iHashCode;
    }

    private Object readResolve() {
        calculateHashCode(this.keys);
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof MultiKey) {
            return Arrays.equals(this.keys, ((MultiKey) obj).keys);
        }
        return false;
    }

    public Object getKey(int i) {
        return this.keys[i];
    }

    public Object[] getKeys() {
        return (Object[]) this.keys.clone();
    }

    public int hashCode() {
        return this.hashCode;
    }

    public int size() {
        return this.keys.length;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("MultiKey");
        stringBuffer.append(Arrays.asList(this.keys).toString());
        return stringBuffer.toString();
    }

    public MultiKey(Object obj, Object obj2, Object obj3) {
        this(new Object[]{obj, obj2, obj3}, false);
    }

    public MultiKey(Object obj, Object obj2, Object obj3, Object obj4) {
        this(new Object[]{obj, obj2, obj3, obj4}, false);
    }

    public MultiKey(Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        this(new Object[]{obj, obj2, obj3, obj4, obj5}, false);
    }

    public MultiKey(Object[] objArr) {
        this(objArr, true);
    }

    public MultiKey(Object[] objArr, boolean z) {
        if (objArr != null) {
            if (z) {
                this.keys = (Object[]) objArr.clone();
            } else {
                this.keys = objArr;
            }
            calculateHashCode(objArr);
            return;
        }
        throw new IllegalArgumentException("The array of keys must not be null");
    }
}
