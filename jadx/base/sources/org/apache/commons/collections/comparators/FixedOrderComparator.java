package org.apache.commons.collections.comparators;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FixedOrderComparator implements Comparator {
    public static final int UNKNOWN_AFTER = 1;
    public static final int UNKNOWN_BEFORE = 0;
    public static final int UNKNOWN_THROW_EXCEPTION = 2;
    private final Map map = new HashMap();
    private int counter = 0;
    private boolean isLocked = false;
    private int unknownObjectBehavior = 2;

    public FixedOrderComparator() {
    }

    public boolean add(Object obj) {
        checkLocked();
        Map map = this.map;
        int i = this.counter;
        this.counter = i + 1;
        return map.put(obj, new Integer(i)) == null;
    }

    public boolean addAsEqual(Object obj, Object obj2) {
        checkLocked();
        Integer num = (Integer) this.map.get(obj);
        if (num != null) {
            return this.map.put(obj2, num) == null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(obj);
        stringBuffer.append(" not known to ");
        stringBuffer.append(this);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public void checkLocked() {
        if (isLocked()) {
            throw new UnsupportedOperationException("Cannot modify a FixedOrderComparator after a comparison");
        }
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        this.isLocked = true;
        Integer num = (Integer) this.map.get(obj);
        Integer num2 = (Integer) this.map.get(obj2);
        if (num != null && num2 != null) {
            return num.compareTo(num2);
        }
        int i = this.unknownObjectBehavior;
        if (i == 0) {
            if (num == null) {
                return num2 == null ? 0 : -1;
            }
            return 1;
        }
        if (i == 1) {
            if (num == null) {
                return num2 == null ? 0 : 1;
            }
            return -1;
        }
        if (i != 2) {
            StringBuffer stringBuffer = new StringBuffer("Unknown unknownObjectBehavior: ");
            stringBuffer.append(this.unknownObjectBehavior);
            throw new UnsupportedOperationException(stringBuffer.toString());
        }
        if (num != null) {
            obj = obj2;
        }
        StringBuffer stringBuffer2 = new StringBuffer("Attempting to compare unknown object ");
        stringBuffer2.append(obj);
        throw new IllegalArgumentException(stringBuffer2.toString());
    }

    public int getUnknownObjectBehavior() {
        return this.unknownObjectBehavior;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void setUnknownObjectBehavior(int i) {
        checkLocked();
        if (i != 1 && i != 0 && i != 2) {
            throw new IllegalArgumentException("Unrecognised value for unknown behaviour flag");
        }
        this.unknownObjectBehavior = i;
    }

    public FixedOrderComparator(Object[] objArr) {
        if (objArr != null) {
            for (Object obj : objArr) {
                add(obj);
            }
            return;
        }
        throw new IllegalArgumentException("The list of items must not be null");
    }

    public FixedOrderComparator(List list) {
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                add(it.next());
            }
            return;
        }
        throw new IllegalArgumentException("The list of items must not be null");
    }
}
