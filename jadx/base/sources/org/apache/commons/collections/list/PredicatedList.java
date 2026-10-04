package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.collection.PredicatedCollection;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PredicatedList extends PredicatedCollection implements List {
    private static final long serialVersionUID = -5722039223898659102L;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class PredicatedListIterator extends AbstractListIteratorDecorator {
        private final /* synthetic */ PredicatedList this$0;

        public PredicatedListIterator(PredicatedList predicatedList, ListIterator listIterator) {
            super(listIterator);
            this.this$0 = predicatedList;
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(Object obj) {
            this.this$0.validate(obj);
            this.iterator.add(obj);
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(Object obj) {
            this.this$0.validate(obj);
            this.iterator.set(obj);
        }
    }

    public PredicatedList(List list, Predicate predicate) {
        super(list, predicate);
    }

    public static List decorate(List list, Predicate predicate) {
        return new PredicatedList(list, predicate);
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        validate(obj);
        getList().add(i, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            validate(it.next());
        }
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
        return listIterator(0);
    }

    @Override // java.util.List
    public Object remove(int i) {
        return getList().remove(i);
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        validate(obj);
        return getList().set(i, obj);
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return new PredicatedList(getList().subList(i, i2), this.predicate);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return new PredicatedListIterator(this, getList().listIterator(i));
    }
}
