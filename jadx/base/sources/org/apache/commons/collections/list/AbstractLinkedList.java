package org.apache.commons.collections.list;

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
import org.apache.commons.collections.OrderedIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractLinkedList implements List {
    protected transient Node header;
    protected transient int modCount;
    protected transient int size;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkedListIterator implements ListIterator, OrderedIterator {
        protected Node current;
        protected int expectedModCount;
        protected Node next;
        protected int nextIndex;
        protected final AbstractLinkedList parent;

        public LinkedListIterator(AbstractLinkedList abstractLinkedList, int i) {
            this.parent = abstractLinkedList;
            this.expectedModCount = abstractLinkedList.modCount;
            this.next = abstractLinkedList.getNode(i, true);
            this.nextIndex = i;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            checkModCount();
            this.parent.addNodeBefore(this.next, obj);
            this.current = null;
            this.nextIndex++;
            this.expectedModCount++;
        }

        public void checkModCount() {
            if (this.parent.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        public Node getLastNodeReturned() {
            Node node = this.current;
            if (node != null) {
                return node;
            }
            throw new IllegalStateException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.next != this.parent.header;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return this.next.previous != this.parent.header;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            checkModCount();
            if (!hasNext()) {
                StringBuffer stringBuffer = new StringBuffer("No element at index ");
                stringBuffer.append(this.nextIndex);
                stringBuffer.append(Extension.DOT);
                throw new NoSuchElementException(stringBuffer.toString());
            }
            Object value = this.next.getValue();
            Node node = this.next;
            this.current = node;
            this.next = node.next;
            this.nextIndex++;
            return value;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.nextIndex;
        }

        @Override // java.util.ListIterator, org.apache.commons.collections.OrderedIterator
        public Object previous() {
            checkModCount();
            if (!hasPrevious()) {
                throw new NoSuchElementException("Already at start of list.");
            }
            Node node = this.next.previous;
            this.next = node;
            Object value = node.getValue();
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
            Node node = this.current;
            Node node2 = this.next;
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
        public void set(Object obj) {
            checkModCount();
            getLastNodeReturned().setValue(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LinkedSubList extends AbstractList {
        int expectedModCount;
        int offset;
        AbstractLinkedList parent;
        int size;

        public LinkedSubList(AbstractLinkedList abstractLinkedList, int i, int i2) {
            if (i < 0) {
                StringBuffer stringBuffer = new StringBuffer("fromIndex = ");
                stringBuffer.append(i);
                throw new IndexOutOfBoundsException(stringBuffer.toString());
            }
            if (i2 > abstractLinkedList.size()) {
                StringBuffer stringBuffer2 = new StringBuffer("toIndex = ");
                stringBuffer2.append(i2);
                throw new IndexOutOfBoundsException(stringBuffer2.toString());
            }
            if (i <= i2) {
                this.parent = abstractLinkedList;
                this.offset = i;
                this.size = i2 - i;
                this.expectedModCount = abstractLinkedList.modCount;
                return;
            }
            StringBuffer stringBuffer3 = new StringBuffer("fromIndex(");
            stringBuffer3.append(i);
            stringBuffer3.append(") > toIndex(");
            stringBuffer3.append(i2);
            stringBuffer3.append(")");
            throw new IllegalArgumentException(stringBuffer3.toString());
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i, Object obj) {
            rangeCheck(i, this.size + 1);
            checkModCount();
            this.parent.add(i + this.offset, obj);
            this.expectedModCount = this.parent.modCount;
            this.size++;
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean addAll(Collection collection) {
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
            Iterator it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i) {
            rangeCheck(i, this.size);
            checkModCount();
            return this.parent.get(i + this.offset);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator iterator() {
            checkModCount();
            return this.parent.createSubListIterator(this);
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator listIterator(int i) {
            rangeCheck(i, this.size + 1);
            checkModCount();
            return this.parent.createSubListListIterator(this, i);
        }

        public void rangeCheck(int i, int i2) {
            if (i < 0 || i >= i2) {
                StringBuffer stringBuffer = new StringBuffer("Index '");
                stringBuffer.append(i);
                stringBuffer.append("' out of bounds for size '");
                stringBuffer.append(this.size);
                stringBuffer.append("'");
                throw new IndexOutOfBoundsException(stringBuffer.toString());
            }
        }

        @Override // java.util.AbstractList, java.util.List
        public Object remove(int i) {
            rangeCheck(i, this.size);
            checkModCount();
            Object objRemove = this.parent.remove(i + this.offset);
            this.expectedModCount = this.parent.modCount;
            this.size--;
            ((AbstractList) this).modCount++;
            return objRemove;
        }

        @Override // java.util.AbstractList, java.util.List
        public Object set(int i, Object obj) {
            rangeCheck(i, this.size);
            checkModCount();
            return this.parent.set(i + this.offset, obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            checkModCount();
            return this.size;
        }

        @Override // java.util.AbstractList, java.util.List
        public List subList(int i, int i2) {
            AbstractLinkedList abstractLinkedList = this.parent;
            int i4 = this.offset;
            return new LinkedSubList(abstractLinkedList, i + i4, i2 + i4);
        }

        @Override // java.util.AbstractList, java.util.List
        public boolean addAll(int i, Collection collection) {
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
    public static class LinkedSubListIterator extends LinkedListIterator {
        protected final LinkedSubList sub;

        public LinkedSubListIterator(LinkedSubList linkedSubList, int i) {
            super(linkedSubList.parent, i + linkedSubList.offset);
            this.sub = linkedSubList;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(Object obj) {
            super.add(obj);
            LinkedSubList linkedSubList = this.sub;
            linkedSubList.expectedModCount = this.parent.modCount;
            linkedSubList.size++;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return nextIndex() < this.sub.size;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, org.apache.commons.collections.OrderedIterator
        public boolean hasPrevious() {
            return previousIndex() >= 0;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.sub.expectedModCount = this.parent.modCount;
            r0.size--;
        }
    }

    public AbstractLinkedList() {
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        return addAll(this.size, collection);
    }

    public boolean addFirst(Object obj) {
        addNodeAfter(this.header, obj);
        return true;
    }

    public boolean addLast(Object obj) {
        addNodeBefore(this.header, obj);
        return true;
    }

    public void addNode(Node node, Node node2) {
        node.next = node2;
        node.previous = node2.previous;
        node2.previous.next = node;
        node2.previous = node;
        this.size++;
        this.modCount++;
    }

    public void addNodeAfter(Node node, Object obj) {
        addNode(createNode(obj), node.next);
    }

    public void addNodeBefore(Node node, Object obj) {
        addNode(createNode(obj), node);
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
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public Node createHeaderNode() {
        return new Node();
    }

    public Node createNode(Object obj) {
        return new Node(obj);
    }

    public Iterator createSubListIterator(LinkedSubList linkedSubList) {
        return createSubListListIterator(linkedSubList, 0);
    }

    public ListIterator createSubListListIterator(LinkedSubList linkedSubList, int i) {
        return new LinkedSubListIterator(linkedSubList, i);
    }

    public void doReadObject(ObjectInputStream objectInputStream) throws IOException {
        init();
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            add(objectInputStream.readObject());
        }
    }

    public void doWriteObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(size());
        Iterator it = iterator();
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
        ListIterator listIterator = listIterator();
        ListIterator listIterator2 = list.listIterator();
        while (listIterator.hasNext() && listIterator2.hasNext()) {
            Object next = listIterator.next();
            Object next2 = listIterator2.next();
            if (next == null) {
                if (next2 != null) {
                    return false;
                }
            } else if (!next.equals(next2)) {
                return false;
            }
        }
        return (listIterator.hasNext() || listIterator2.hasNext()) ? false : true;
    }

    @Override // java.util.List
    public Object get(int i) {
        return getNode(i, false).getValue();
    }

    public Object getFirst() {
        Node node = this.header;
        Node node2 = node.next;
        if (node2 != node) {
            return node2.getValue();
        }
        throw new NoSuchElementException();
    }

    public Object getLast() {
        Node node = this.header;
        Node node2 = node.previous;
        if (node2 != node) {
            return node2.getValue();
        }
        throw new NoSuchElementException();
    }

    public Node getNode(int i, boolean z) {
        if (i < 0) {
            StringBuffer stringBuffer = new StringBuffer("Couldn't get the node: index (");
            stringBuffer.append(i);
            stringBuffer.append(") less than zero.");
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
        if (!z && i == this.size) {
            StringBuffer stringBuffer2 = new StringBuffer("Couldn't get the node: index (");
            stringBuffer2.append(i);
            stringBuffer2.append(") is the size of the list.");
            throw new IndexOutOfBoundsException(stringBuffer2.toString());
        }
        int i2 = this.size;
        if (i > i2) {
            StringBuffer stringBuffer3 = new StringBuffer("Couldn't get the node: index (");
            stringBuffer3.append(i);
            stringBuffer3.append(") greater than the size of the list (");
            stringBuffer3.append(this.size);
            stringBuffer3.append(").");
            throw new IndexOutOfBoundsException(stringBuffer3.toString());
        }
        if (i >= i2 / 2) {
            Node node = this.header;
            while (i2 > i) {
                node = node.previous;
                i2--;
            }
            return node;
        }
        Node node2 = this.header.next;
        for (int i4 = 0; i4 < i; i4++) {
            node2 = node2.next;
        }
        return node2;
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 1;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode = (iHashCode * 31) + (next == null ? 0 : next.hashCode());
        }
        return iHashCode;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int i = 0;
        for (Node node = this.header.next; node != this.header; node = node.next) {
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
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int i = this.size - 1;
        Node node = this.header;
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
    public ListIterator listIterator() {
        return new LinkedListIterator(this, 0);
    }

    @Override // java.util.List
    public Object remove(int i) {
        Node node = getNode(i, false);
        Object value = node.getValue();
        removeNode(node);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = iterator();
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
        Node node = this.header;
        node.next = node;
        node.previous = node;
        this.size = 0;
        this.modCount++;
    }

    public Object removeFirst() {
        Node node = this.header;
        Node node2 = node.next;
        if (node2 == node) {
            throw new NoSuchElementException();
        }
        Object value = node2.getValue();
        removeNode(node2);
        return value;
    }

    public Object removeLast() {
        Node node = this.header;
        Node node2 = node.previous;
        if (node2 == node) {
            throw new NoSuchElementException();
        }
        Object value = node2.getValue();
        removeNode(node2);
        return value;
    }

    public void removeNode(Node node) {
        Node node2 = node.previous;
        node2.next = node.next;
        node.next.previous = node2;
        this.size--;
        this.modCount++;
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        Iterator it = iterator();
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
    public Object set(int i, Object obj) {
        Node node = getNode(i, false);
        Object value = node.getValue();
        updateNode(node, obj);
        return value;
    }

    @Override // java.util.List, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return new LinkedSubList(this, i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return toArray(new Object[this.size]);
    }

    public String toString() {
        if (size() == 0) {
            return XMPConst.ARRAY_ITEM_NAME;
        }
        StringBuffer stringBuffer = new StringBuffer(size() * 16);
        stringBuffer.append("[");
        Iterator it = iterator();
        boolean zHasNext = it.hasNext();
        while (zHasNext) {
            Object next = it.next();
            if (next == this) {
                next = "(this Collection)";
            }
            stringBuffer.append(next);
            zHasNext = it.hasNext();
            if (zHasNext) {
                stringBuffer.append(SQLKeyword.COMMA);
            }
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void updateNode(Node node, Object obj) {
        node.setValue(obj);
    }

    public AbstractLinkedList(Collection collection) {
        init();
        addAll(collection);
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        addNodeBefore(getNode(i, true), obj);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        Node node = getNode(i, true);
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            addNodeBefore(node, it.next());
        }
        return true;
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return new LinkedListIterator(this, i);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        if (objArr.length < this.size) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), this.size);
        }
        Node node = this.header.next;
        int i = 0;
        while (node != this.header) {
            objArr[i] = node.getValue();
            node = node.next;
            i++;
        }
        int length = objArr.length;
        int i2 = this.size;
        if (length > i2) {
            objArr[i2] = null;
        }
        return objArr;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Node {
        protected Node next;
        protected Node previous;
        protected Object value;

        public Node() {
            this.previous = this;
            this.next = this;
        }

        public Node getNextNode() {
            return this.next;
        }

        public Node getPreviousNode() {
            return this.previous;
        }

        public Object getValue() {
            return this.value;
        }

        public void setNextNode(Node node) {
            this.next = node;
        }

        public void setPreviousNode(Node node) {
            this.previous = node;
        }

        public void setValue(Object obj) {
            this.value = obj;
        }

        public Node(Object obj) {
            this.value = obj;
        }

        public Node(Node node, Node node2, Object obj) {
            this.previous = node;
            this.next = node2;
            this.value = obj;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        Node node = this.header;
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
