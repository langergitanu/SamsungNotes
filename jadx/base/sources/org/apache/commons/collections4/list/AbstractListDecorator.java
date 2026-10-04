package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.collection.AbstractCollectionDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractListDecorator<E> extends AbstractCollectionDecorator<E> implements List<E> {
    private static final long serialVersionUID = 4500739654952315623L;

    public AbstractListDecorator() {
    }

    @Override // java.util.List
    public void add(int i, E e) {
        decorated().add(i, e);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        return decorated().addAll(i, collection);
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return obj == this || decorated().equals(obj);
    }

    @Override // java.util.List
    public E get(int i) {
        return decorated().get(i);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return decorated().hashCode();
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return decorated().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return decorated().lastIndexOf(obj);
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return decorated().listIterator();
    }

    @Override // java.util.List
    public E remove(int i) {
        return decorated().remove(i);
    }

    @Override // java.util.List
    public E set(int i, E e) {
        return decorated().set(i, e);
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return decorated().subList(i, i2);
    }

    public AbstractListDecorator(List<E> list) {
        super(list);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public List<E> decorated() {
        return (List) super.decorated();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return decorated().listIterator(i);
    }
}
