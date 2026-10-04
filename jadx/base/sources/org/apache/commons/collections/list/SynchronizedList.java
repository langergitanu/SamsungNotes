package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.collection.SynchronizedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SynchronizedList extends SynchronizedCollection implements List {
    private static final long serialVersionUID = -1403835447328619437L;

    public SynchronizedList(List list) {
        super(list);
    }

    public static List decorate(List list) {
        return new SynchronizedList(list);
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        synchronized (this.lock) {
            getList().add(i, obj);
        }
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        boolean zAddAll;
        synchronized (this.lock) {
            zAddAll = getList().addAll(i, collection);
        }
        return zAddAll;
    }

    @Override // java.util.List
    public Object get(int i) {
        Object obj;
        synchronized (this.lock) {
            obj = getList().get(i);
        }
        return obj;
    }

    public List getList() {
        return (List) this.collection;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int iIndexOf;
        synchronized (this.lock) {
            iIndexOf = getList().indexOf(obj);
        }
        return iIndexOf;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int iLastIndexOf;
        synchronized (this.lock) {
            iLastIndexOf = getList().lastIndexOf(obj);
        }
        return iLastIndexOf;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return getList().listIterator();
    }

    @Override // java.util.List
    public Object remove(int i) {
        Object objRemove;
        synchronized (this.lock) {
            objRemove = getList().remove(i);
        }
        return objRemove;
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        Object obj2;
        synchronized (this.lock) {
            obj2 = getList().set(i, obj);
        }
        return obj2;
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        SynchronizedList synchronizedList;
        synchronized (this.lock) {
            synchronizedList = new SynchronizedList(getList().subList(i, i2), this.lock);
        }
        return synchronizedList;
    }

    public SynchronizedList(List list, Object obj) {
        super(list, obj);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return getList().listIterator(i);
    }
}
