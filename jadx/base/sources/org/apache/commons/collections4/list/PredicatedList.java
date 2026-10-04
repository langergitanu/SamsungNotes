package org.apache.commons.collections4.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.collection.PredicatedCollection;
import org.apache.commons.collections4.iterators.AbstractListIteratorDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PredicatedList<E> extends PredicatedCollection<E> implements List<E> {
    private static final long serialVersionUID = -5722039223898659102L;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PredicatedListIterator extends AbstractListIteratorDecorator<E> {
        public PredicatedListIterator(ListIterator<E> listIterator) {
            super(listIterator);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(E e) {
            PredicatedList.this.validate(e);
            getListIterator().add(e);
        }

        @Override // org.apache.commons.collections4.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(E e) {
            PredicatedList.this.validate(e);
            getListIterator().set(e);
        }
    }

    public PredicatedList(List<E> list, Predicate<? super E> predicate) {
        super(list, predicate);
    }

    public static <T> PredicatedList<T> predicatedList(List<T> list, Predicate<? super T> predicate) {
        return new PredicatedList<>(list, predicate);
    }

    @Override // java.util.List
    public void add(int i, E e) {
        validate(e);
        decorated().add(i, e);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            validate(it.next());
        }
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
        return listIterator(0);
    }

    @Override // java.util.List
    public E remove(int i) {
        return decorated().remove(i);
    }

    @Override // java.util.List
    public E set(int i, E e) {
        validate(e);
        return decorated().set(i, e);
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return new PredicatedList(decorated().subList(i, i2), this.predicate);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator
    public List<E> decorated() {
        return (List) super.decorated();
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new PredicatedListIterator(decorated().listIterator(i));
    }
}
