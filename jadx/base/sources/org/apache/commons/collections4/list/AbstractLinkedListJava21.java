package org.apache.commons.collections4.list;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import com.adobe.internal.xmp.XMPConst;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.OrderedIterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractLinkedListJava21<E> implements List<E> {
    transient Node<E> header;
    transient int modCount;
    transient int size;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkedListIterator<E> implements ListIterator<E>, OrderedIterator<E> {
        protected Node<E> current;
        protected int expectedModCount;
        protected Node<E> next;
        protected int nextIndex;
        protected final AbstractLinkedListJava21<E> parent;

        public LinkedListIterator(AbstractLinkedListJava21<E> abstractLinkedListJava21, int i) {
            this.parent = abstractLinkedListJava21;
            this.expectedModCount = abstractLinkedListJava21.modCount;
            this.next = abstractLinkedListJava21.getNode(i, true);
            this.nextIndex = i;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            checkModCount();
            this.parent.addNodeBefore(this.next, e);
            this.current = null;
            this.nextIndex++;
            this.expectedModCount++;
        }

        public void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public Node<E> getLastNodeReturned() {
            Node<E> node = this.current;
            if (node != null) {
                return node;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.next.previous != this.parent.header;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkModCount();
            if (!hasNext()) {
                throw new NoSuchElementException(AbstractC2821a.m2223n(new StringBuilder("No element at index "), Extension.DOT, this.nextIndex));
            }
            E value = this.next.getValue();
            Node<E> node = this.next;
            this.current = node;
            this.next = node.next;
            this.nextIndex++;
            return value;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public E previous() {
            checkModCount();
            if (!hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            Node<E> node = this.next.previous;
            this.next = node;
            E value = node.getValue();
            this.current = this.next;
            this.nextIndex--;
            return value;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return nextIndex() - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkModCount();
            Node<E> node = this.current;
            Node<E> node2 = this.next;
            if (node == node2) {
                this.next = node2.next;
                this.parent.removeNode(getLastNodeReturned());
            } else {
                this.parent.removeNode(getLastNodeReturned());
                this.nextIndex--;
            }
            this.current = null;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            checkModCount();
            getLastNodeReturned().setValue(e);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkedSubList<E> extends AbstractList<E> {
        int expectedModCount;
        int offset;
        AbstractLinkedListJava21<E> parent;
        int size;

        public LinkedSubList(AbstractLinkedListJava21<E> abstractLinkedListJava21, int i, int i2) {
            if (i < 0) {
                throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i, "fromIndex = "));
            }
            if (i2 > abstractLinkedListJava21.size()) {
                throw new IndexOutOfBoundsException(AbstractC0000a.m11h(i2, "toIndex = "));
            }
            if (i > i2) {
                throw new IllegalArgumentException(AbstractC0622a.m1164j(i, i2, "fromIndex(", ") > toIndex(", ")"));
            }
            this.parent = abstractLinkedListJava21;
            this.offset = i;
            this.size = i2 - i;
            this.expectedModCount = abstractLinkedListJava21.modCount;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, E e) {
            rangeCheck(i, this.size + 1);
            checkModCount();
            this.parent.add(i + this.offset, e);
            this.expectedModCount = this.parent.modCount;
            this.size++;
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection<? extends E> collection) {
            return addAll(this.size, collection);
        }

        public void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            checkModCount();
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            rangeCheck(i, this.size);
            checkModCount();
            return this.parent.get(i + this.offset);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<E> iterator() {
            checkModCount();
            return this.parent.createSubListIterator(this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<E> listIterator(int i) {
            rangeCheck(i, this.size + 1);
            checkModCount();
            return this.parent.createSubListListIterator(this, i);
        }

        public void rangeCheck(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException(AbstractC2821a.m2223n(AbstractC0541b.m778t(i, "Index '", "' out of bounds for size '"), "'", this.size));
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public E remove(int i) {
            rangeCheck(i, this.size);
            checkModCount();
            E eRemove = this.parent.remove(i + this.offset);
            this.expectedModCount = this.parent.modCount;
            this.size--;
            ((AbstractList) this).modCount++;
            return eRemove;
        }

        @Override // java.util.AbstractList, java.util.List
        public E set(int i, E e) {
            rangeCheck(i, this.size);
            checkModCount();
            return this.parent.set(i + this.offset, e);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            checkModCount();
            return this.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public List<E> subList(int i, int i2) {
            AbstractLinkedListJava21<E> abstractLinkedListJava21 = this.parent;
            int i4 = this.offset;
            return new LinkedSubList(abstractLinkedListJava21, i + i4, i2 + i4);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection<? extends E> collection) {
            rangeCheck(i, this.size + 1);
            int size = collection.size();
            if (size == 0) {
                return false;
            }
            checkModCount();
            this.parent.addAll(this.offset + i, collection);
            this.expectedModCount = this.parent.modCount;
            this.size += size;
            ((AbstractList) this).modCount++;
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkedSubListIterator<E> extends LinkedListIterator<E> {
        protected final LinkedSubList<E> sub;

        public LinkedSubListIterator(LinkedSubList<E> linkedSubList, int i) {
            super(linkedSubList.parent, i + linkedSubList.offset);
            this.sub = linkedSubList;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedListJava21.LinkedListIterator, java.util.ListIterator
        public void add(E e) {
            super.add(e);
            LinkedSubList<E> linkedSubList = this.sub;
            linkedSubList.expectedModCount = this.parent.modCount;
            linkedSubList.size++;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedListJava21.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return nextIndex() < this.sub.size;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedListJava21.LinkedListIterator, java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedListJava21.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections4.list.AbstractLinkedListJava21.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.sub.expectedModCount = this.parent.modCount;
            r0.size--;
        }
    }

    public AbstractLinkedListJava21() {
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        return addAll(this.size, collection);
    }

    public void addFirst(E e) {
        addNodeAfter(this.header, e);
    }

    public void addLast(E e) {
        addNodeBefore(this.header, e);
    }

    public void addNode(Node<E> node, Node<E> node2) {
        Objects.requireNonNull(node, "nodeToInsert");
        Objects.requireNonNull(node2, "insertBeforeNode");
        node.next = node2;
        node.previous = node2.previous;
        node2.previous.next = node;
        node2.previous = node;
        this.size++;
        this.modCount++;
    }

    public void addNodeAfter(Node<E> node, E e) {
        addNode(createNode(e), node.next);
    }

    public void addNodeBefore(Node<E> node, E e) {
        addNode(createNode(e), node);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        removeAllNodes();
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Node<E> createHeaderNode() {
        return new Node<>();
    }

    public Node<E> createNode(E e) {
        return new Node<>(e);
    }

    public Iterator<E> createSubListIterator(LinkedSubList<E> linkedSubList) {
        return createSubListListIterator(linkedSubList, 0);
    }

    public ListIterator<E> createSubListListIterator(LinkedSubList<E> linkedSubList, int i) {
        return new LinkedSubListIterator(linkedSubList, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void doReadObject(ObjectInputStream objectInputStream) throws IOException {
        init();
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            add(objectInputStream.readObject());
        }
    }

    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(size());
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        if (list.size() != size()) {
            return false;
        }
        ListIterator<E> listIterator = listIterator();
        ListIterator<E> listIterator2 = list.listIterator();
        while (listIterator.hasNext() && listIterator2.hasNext()) {
            if (!Objects.equals(listIterator.next(), listIterator2.next())) {
                return false;
            }
        }
        return (listIterator.hasNext() || listIterator2.hasNext()) ? false : true;
    }

    @Override // java.util.List
    public E get(int i) {
        return getNode(i, false).getValue();
    }

    public E getFirst() {
        Node<E> node = this.header;
        Node<E> node2 = node.next;
        if (node2 != node) {
            return node2.getValue();
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        Node<E> node = this.header;
        Node<E> node2 = node.previous;
        if (node2 != node) {
            return node2.getValue();
        }
        throw new NoSuchElementException();
    }

    public Node<E> getNode(int i, boolean z) {
        if (i < 0) {
            throw new IndexOutOfBoundsException(AbstractC0541b.m767i(i, "Couldn't get the node: index (", ") less than zero."));
        }
        if (!z && i == this.size) {
            throw new IndexOutOfBoundsException(AbstractC0541b.m767i(i, "Couldn't get the node: index (", ") is the size of the list."));
        }
        int i2 = this.size;
        if (i > i2) {
            throw new IndexOutOfBoundsException(AbstractC2821a.m2223n(AbstractC0541b.m778t(i, "Couldn't get the node: index (", ") greater than the size of the list ("), ").", this.size));
        }
        if (i >= i2 / 2) {
            Node<E> node = this.header;
            while (i2 > i) {
                node = node.previous;
                i2--;
            }
            return node;
        }
        Node<E> node2 = this.header.next;
        for (int i4 = 0; i4 < i; i4++) {
            node2 = node2.next;
        }
        return node2;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        Iterator<E> it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            E next = it.next();
            iHashCode = (iHashCode * 31) + (next == null ? 0 : next.hashCode());
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i = 0;
        for (Node<E> node = this.header.next; node != this.header; node = node.next) {
            if (isEqualValue(node.getValue(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public void init() {
        this.header = createHeaderNode();
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean isEqualValue(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int i = this.size - 1;
        Node<E> node = this.header;
        while (true) {
            node = node.previous;
            if (node == this.header) {
                return -1;
            }
            if (isEqualValue(node.getValue(), obj)) {
                return i;
            }
            i--;
        }
    }

    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return new LinkedListIterator(this, 0);
    }

    @Override // java.util.List
    public E remove(int i) {
        Node<E> node = getNode(i, false);
        E value = node.getValue();
        removeNode(node);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        Iterator<E> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public void removeAllNodes() {
        Node<E> node = this.header;
        node.next = node;
        node.previous = node;
        this.size = 0;
        this.modCount++;
    }

    public E removeFirst() {
        Node<E> node = this.header;
        Node<E> node2 = node.next;
        if (node2 == node) {
            throw new NoSuchElementException();
        }
        E value = node2.getValue();
        removeNode(node2);
        return value;
    }

    public E removeLast() {
        Node<E> node = this.header;
        Node<E> node2 = node.previous;
        if (node2 == node) {
            throw new NoSuchElementException();
        }
        E value = node2.getValue();
        removeNode(node2);
        return value;
    }

    public void removeNode(Node<E> node) {
        Objects.requireNonNull(node, "node");
        Node<E> node2 = node.previous;
        node2.next = node.next;
        node.next.previous = node2;
        this.size--;
        this.modCount++;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        Iterator<E> it = iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Override // java.util.List
    public E set(int i, E e) {
        Node<E> node = getNode(i, false);
        E value = node.getValue();
        updateNode(node, e);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return new LinkedSubList(this, i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[this.size]);
    }

    public String toString() {
        if (isEmpty()) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        StringBuilder sb = new StringBuilder(size() * 16);
        sb.append("[");
        Iterator<E> it = iterator();
        boolean zHasNext = it.hasNext();
        while (zHasNext) {
            Object next = it.next();
            if (next == this) {
                next = "(this Collection)";
            }
            sb.append(next);
            zHasNext = it.hasNext();
            if (zHasNext) {
                sb.append(SQLKeyword.COMMA);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void updateNode(Node<E> node, E e) {
        node.setValue(e);
    }

    public AbstractLinkedListJava21(Collection<? extends E> collection) {
        init();
        addAll(collection);
    }

    @Override // java.util.List
    public void add(int i, E e) {
        addNodeBefore(getNode(i, true), e);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        Node<E> node = getNode(i, true);
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            addNodeBefore(node, it.next());
        }
        return true;
    }

    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return new LinkedListIterator(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length < this.size) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.size));
        }
        Node<E> node = this.header.next;
        int i = 0;
        while (node != this.header) {
            tArr[i] = node.getValue();
            node = node.next;
            i++;
        }
        int length = tArr.length;
        int i2 = this.size;
        if (length > i2) {
            tArr[i2] = null;
        }
        return tArr;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Node<E> {
        protected Node<E> next;
        protected Node<E> previous;
        protected E value;

        public Node() {
            this.previous = this;
            this.next = this;
        }

        public Node<E> getNextNode() {
            return this.next;
        }

        public Node<E> getPreviousNode() {
            return this.previous;
        }

        public E getValue() {
            return this.value;
        }

        public void setNextNode(Node<E> node) {
            this.next = node;
        }

        public void setPreviousNode(Node<E> node) {
            this.previous = node;
        }

        public void setValue(E e) {
            this.value = e;
        }

        public Node(E e) {
            this.value = e;
        }

        public Node(Node<E> node, Node<E> node2, E e) {
            this.previous = node;
            this.next = node2;
            this.value = e;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        Node<E> node = this.header;
        do {
            node = node.next;
            if (node == this.header) {
                return false;
            }
        } while (!isEqualValue(node.getValue(), obj));
        removeNode(node);
        return true;
    }
}
