package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractListDecorator extends AbstractCollectionDecorator implements List {
    public AbstractListDecorator() {
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        getList().add(i, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        return getList().addAll(i, collection);
    }

    @Override // java.util.List
    public Object get(int i) {
        return getList().get(i);
    }

    public List getList() {
        return (List) getCollection();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return getList().listIterator();
    }

    @Override // java.util.List
    public Object remove(int i) {
        return getList().remove(i);
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        return getList().set(i, obj);
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return getList().subList(i, i2);
    }

    public AbstractListDecorator(List list) {
        super(list);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return getList().listIterator(i);
    }
}
