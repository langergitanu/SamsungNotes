package org.apache.commons.collections.iterators;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.ResettableIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EntrySetMapIterator implements MapIterator, ResettableIterator {
    private boolean canRemove = false;
    private Iterator iterator;
    private Map.Entry last;
    private final Map map;

    public EntrySetMapIterator(Map map) {
        this.map = map;
        this.iterator = map.entrySet().iterator();
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object getKey() {
        Map.Entry entry = this.last;
        if (entry != null) {
            return entry.getKey();
        }
        throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object getValue() {
        Map.Entry entry = this.last;
        if (entry != null) {
            return entry.getValue();
        }
        throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public Object next() {
        Map.Entry entry = (Map.Entry) this.iterator.next();
        this.last = entry;
        this.canRemove = true;
        return entry.getKey();
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public void remove() {
        if (!this.canRemove) {
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
        this.iterator.remove();
        this.last = null;
        this.canRemove = false;
    }

    @Override // org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.iterator = this.map.entrySet().iterator();
        this.last = null;
        this.canRemove = false;
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object setValue(Object obj) {
        Map.Entry entry = this.last;
        if (entry != null) {
            return entry.setValue(obj);
        }
        throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
    }

    public String toString() {
        if (this.last == null) {
            return "MapIterator[]";
        }
        StringBuffer stringBuffer = new StringBuffer("MapIterator[");
        stringBuffer.append(getKey());
        stringBuffer.append(MarketingConstants.REFERRER_DELIMITER_U003D);
        stringBuffer.append(getValue());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
