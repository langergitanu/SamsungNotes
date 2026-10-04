package org.apache.commons.collections.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.list.AbstractLinkedList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CursorableLinkedList extends AbstractLinkedList implements Serializable {
    private static final long serialVersionUID = 8836393098519411393L;
    protected transient List cursors;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class SubCursor extends Cursor {
        protected final AbstractLinkedList.LinkedSubList sub;

        public SubCursor(AbstractLinkedList.LinkedSubList linkedSubList, int i) {
            super((CursorableLinkedList) linkedSubList.parent, i + linkedSubList.offset);
            this.sub = linkedSubList;
        }

        @Override // org.apache.commons.collections.list.CursorableLinkedList.Cursor, org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(Object obj) {
            super.add(obj);
            AbstractLinkedList.LinkedSubList linkedSubList = this.sub;
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

        @Override // org.apache.commons.collections.list.CursorableLinkedList.Cursor, org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            return super.nextIndex() - this.sub.offset;
        }

        @Override // org.apache.commons.collections.list.CursorableLinkedList.Cursor, org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            super.remove();
            this.sub.expectedModCount = this.parent.modCount;
            r0.size--;
        }
    }

    public CursorableLinkedList() {
        this.cursors = new ArrayList();
        init();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    public void addNode(AbstractLinkedList.Node node, AbstractLinkedList.Node node2) {
        super.addNode(node, node2);
        broadcastNodeInserted(node);
    }

    public void broadcastNodeChanged(AbstractLinkedList.Node node) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeChanged(node);
            }
        }
    }

    public void broadcastNodeInserted(AbstractLinkedList.Node node) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeInserted(node);
            }
        }
    }

    public void broadcastNodeRemoved(AbstractLinkedList.Node node) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            Cursor cursor = (Cursor) ((WeakReference) it.next()).get();
            if (cursor == null) {
                it.remove();
            } else {
                cursor.nodeRemoved(node);
            }
        }
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    public ListIterator createSubListListIterator(AbstractLinkedList.LinkedSubList linkedSubList, int i) {
        SubCursor subCursor = new SubCursor(linkedSubList, i);
        registerCursor(subCursor);
        return subCursor;
    }

    public Cursor cursor() {
        return cursor(0);
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    public void init() {
        super.init();
        this.cursors = new ArrayList();
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList, java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return super.listIterator(0);
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList, java.util.List
    public ListIterator listIterator() {
        return cursor(0);
    }

    public void registerCursor(Cursor cursor) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            if (((WeakReference) it.next()).get() == null) {
                it.remove();
            }
        }
        this.cursors.add(new WeakReference(cursor));
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    public void removeAllNodes() {
        if (size() > 0) {
            Iterator it = iterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        }
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    public void removeNode(AbstractLinkedList.Node node) {
        super.removeNode(node);
        broadcastNodeRemoved(node);
    }

    public void unregisterCursor(Cursor cursor) {
        Iterator it = this.cursors.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            Cursor cursor2 = (Cursor) weakReference.get();
            if (cursor2 == null) {
                it.remove();
            } else if (cursor2 == cursor) {
                weakReference.clear();
                it.remove();
                return;
            }
        }
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList
    public void updateNode(AbstractLinkedList.Node node, Object obj) {
        super.updateNode(node, obj);
        broadcastNodeChanged(node);
    }

    public Cursor cursor(int i) {
        Cursor cursor = new Cursor(this, i);
        registerCursor(cursor);
        return cursor;
    }

    @Override // org.apache.commons.collections.list.AbstractLinkedList, java.util.List
    public ListIterator listIterator(int i) {
        return cursor(i);
    }

    public CursorableLinkedList(Collection collection) {
        super(collection);
        this.cursors = new ArrayList();
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Cursor extends AbstractLinkedList.LinkedListIterator {
        boolean currentRemovedByAnother;
        boolean nextIndexValid;
        boolean valid;

        public Cursor(CursorableLinkedList cursorableLinkedList, int i) {
            super(cursorableLinkedList, i);
            this.nextIndexValid = true;
            this.currentRemovedByAnother = false;
            this.valid = true;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public void add(Object obj) {
            super.add(obj);
            this.next = this.next.next;
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator
        public void checkModCount() {
            if (!this.valid) {
                throw new ConcurrentModificationException("Cursor closed");
            }
        }

        public void close() {
            if (this.valid) {
                ((CursorableLinkedList) this.parent).unregisterCursor(this);
                this.valid = false;
            }
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator
        public int nextIndex() {
            if (!this.nextIndexValid) {
                AbstractLinkedList.Node node = this.next;
                AbstractLinkedList abstractLinkedList = this.parent;
                AbstractLinkedList.Node node2 = abstractLinkedList.header;
                if (node == node2) {
                    this.nextIndex = abstractLinkedList.size();
                } else {
                    int i = 0;
                    for (AbstractLinkedList.Node node3 = node2.next; node3 != this.next; node3 = node3.next) {
                        i++;
                    }
                    this.nextIndex = i;
                }
                this.nextIndexValid = true;
            }
            return this.nextIndex;
        }

        public void nodeInserted(AbstractLinkedList.Node node) {
            if (node.previous == this.current) {
                this.next = node;
            } else if (this.next.previous == node) {
                this.next = node;
            } else {
                this.nextIndexValid = false;
            }
        }

        public void nodeRemoved(AbstractLinkedList.Node node) {
            AbstractLinkedList.Node node2 = this.next;
            if (node == node2 && node == this.current) {
                this.next = node.next;
                this.current = null;
                this.currentRemovedByAnother = true;
            } else if (node == node2) {
                this.next = node.next;
                this.currentRemovedByAnother = false;
            } else if (node != this.current) {
                this.nextIndexValid = false;
                this.currentRemovedByAnother = false;
            } else {
                this.current = null;
                this.currentRemovedByAnother = true;
                this.nextIndex--;
            }
        }

        @Override // org.apache.commons.collections.list.AbstractLinkedList.LinkedListIterator, java.util.ListIterator, java.util.Iterator
        public void remove() {
            if (this.current != null || !this.currentRemovedByAnother) {
                checkModCount();
                this.parent.removeNode(getLastNodeReturned());
            }
            this.currentRemovedByAnother = false;
        }

        public void nodeChanged(AbstractLinkedList.Node node) {
        }
    }
}
