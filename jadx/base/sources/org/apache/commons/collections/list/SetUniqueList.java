package org.apache.commons.collections.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import org.apache.commons.collections.iterators.AbstractIteratorDecorator;
import org.apache.commons.collections.iterators.AbstractListIteratorDecorator;
import org.apache.commons.collections.set.UnmodifiableSet;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SetUniqueList extends AbstractSerializableListDecorator {
    static /* synthetic */ Class class$java$util$HashSet = null;
    private static final long serialVersionUID = 7196982186153478694L;
    protected final Set set;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SetListIterator extends AbstractIteratorDecorator {
        protected Object last;
        protected final Set set;

        public SetListIterator(Iterator it, Set set) {
            super(it);
            this.last = null;
            this.set = set;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public Object next() {
            Object next = super.next();
            this.last = next;
            return next;
        }

        @Override // org.apache.commons.collections.iterators.AbstractIteratorDecorator, java.util.Iterator
        public void remove() {
            super.remove();
            this.set.remove(this.last);
            this.last = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SetListListIterator extends AbstractListIteratorDecorator {
        protected Object last;
        protected final Set set;

        public SetListListIterator(ListIterator listIterator, Set set) {
            super(listIterator);
            this.last = null;
            this.set = set;
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void add(Object obj) {
            if (this.set.contains(obj)) {
                return;
            }
            super.add(obj);
            this.set.add(obj);
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public Object next() {
            Object next = super.next();
            this.last = next;
            return next;
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public Object previous() {
            Object objPrevious = super.previous();
            this.last = objPrevious;
            return objPrevious;
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.set.remove(this.last);
            this.last = null;
        }

        @Override // org.apache.commons.collections.iterators.AbstractListIteratorDecorator, java.util.ListIterator
        public void set(Object obj) {
            throw new UnsupportedOperationException("ListIterator does not support set");
        }
    }

    public SetUniqueList(List list, Set set) {
        super(list);
        if (set == null) {
            throw new IllegalArgumentException("Set must not be null");
        }
        this.set = set;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static SetUniqueList decorate(List list) {
        if (list == null) {
            throw new IllegalArgumentException("List must not be null");
        }
        if (list.isEmpty()) {
            return new SetUniqueList(list, new HashSet());
        }
        ArrayList arrayList = new ArrayList(list);
        list.clear();
        SetUniqueList setUniqueList = new SetUniqueList(list, new HashSet());
        setUniqueList.addAll(arrayList);
        return setUniqueList;
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean add(Object obj) {
        int size = size();
        add(size(), obj);
        return size != size();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    public Set asSet() {
        return UnmodifiableSet.decorate(this.set);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public void clear() {
        super.clear();
        this.set.clear();
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.set.contains(obj);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.set.containsAll(collection);
    }

    public Set createSetBasedOnList(Set set, List list) {
        Set hashSet;
        Class<?> cls = set.getClass();
        Class clsClass$ = class$java$util$HashSet;
        if (clsClass$ == null) {
            clsClass$ = class$("java.util.HashSet");
            class$java$util$HashSet = clsClass$;
        }
        if (cls.equals(clsClass$)) {
            hashSet = new HashSet();
        } else {
            try {
                hashSet = (Set) set.getClass().newInstance();
            } catch (IllegalAccessException unused) {
                hashSet = new HashSet();
            } catch (InstantiationException unused2) {
                hashSet = new HashSet();
            }
        }
        hashSet.addAll(list);
        return hashSet;
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, java.lang.Iterable, org.apache.commons.collections.Bag
    public Iterator iterator() {
        return new SetListIterator(super.iterator(), this.set);
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public ListIterator listIterator() {
        return new SetListListIterator(super.listIterator(), this.set);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean remove(Object obj) {
        boolean zRemove = super.remove(obj);
        this.set.remove(obj);
        return zRemove;
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean removeAll(Collection collection) {
        boolean zRemoveAll = super.removeAll(collection);
        this.set.removeAll(collection);
        return zRemoveAll;
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean retainAll(Collection collection) {
        boolean zRetainAll = super.retainAll(collection);
        this.set.retainAll(collection);
        return zRetainAll;
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public Object set(int i, Object obj) {
        int iIndexOf = indexOf(obj);
        Object obj2 = super.set(i, obj);
        if (iIndexOf != -1 && iIndexOf != i) {
            super.remove(iIndexOf);
        }
        this.set.remove(obj2);
        this.set.add(obj);
        return obj2;
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public List subList(int i, int i2) {
        List listSubList = super.subList(i, i2);
        return new SetUniqueList(listSubList, createSetBasedOnList(this.set, listSubList));
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i, Collection collection) {
        int size = size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            int size2 = size();
            add(i, it.next());
            if (size2 != size()) {
                i++;
            }
        }
        return size != size();
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public ListIterator listIterator(int i) {
        return new SetListListIterator(super.listIterator(i), this.set);
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public Object remove(int i) {
        Object objRemove = super.remove(i);
        this.set.remove(objRemove);
        return objRemove;
    }

    @Override // org.apache.commons.collections.list.AbstractListDecorator, java.util.List
    public void add(int i, Object obj) {
        if (this.set.contains(obj)) {
            return;
        }
        super.add(i, obj);
        this.set.add(obj);
    }
}
