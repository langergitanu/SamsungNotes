package org.apache.commons.collections4.list;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.p145cm.base.common.constants.Extension;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.OrderedIterator;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TreeList<E> extends AbstractList<E> {
    private AVLNode<E> root;
    private int size;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class TreeListIterator<E> implements ListIterator<E>, OrderedIterator<E> {
        private AVLNode<E> current;
        private int currentIndex;
        private int expectedModCount;
        private AVLNode<E> next;
        private int nextIndex;
        private final TreeList<E> parent;

        public TreeListIterator(TreeList<E> treeList, int i) {
            this.parent = treeList;
            this.expectedModCount = ((AbstractList) treeList).modCount;
            this.next = ((TreeList) treeList).root == null ? null : ((TreeList) treeList).root.get(i);
            this.nextIndex = i;
            this.currentIndex = -1;
        }

        @Override // java.util.ListIterator
        public void add(E e) {
            checkModCount();
            this.parent.add(this.nextIndex, e);
            this.current = null;
            this.currentIndex = -1;
            this.nextIndex++;
            this.expectedModCount++;
        }

        public void checkModCount() {
            if (((AbstractList) this.parent).modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.nextIndex < this.parent.size();
        }

        @Override // java.util.ListIterator, org.apache.commons.collections4.OrderedIterator
        public boolean hasPrevious() {
            return this.nextIndex > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public E next() {
            checkModCount();
            if (!hasNext()) {
                throw new NoSuchElementException(AbstractC2821a.m2223n(new StringBuilder("No element at index "), Extension.DOT, this.nextIndex));
            }
            if (this.next == null) {
                this.next = ((TreeList) this.parent).root.get(this.nextIndex);
            }
            E value = this.next.getValue();
            AVLNode<E> aVLNode = this.next;
            this.current = aVLNode;
            int i = this.nextIndex;
            this.nextIndex = i + 1;
            this.currentIndex = i;
            this.next = aVLNode.next();
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
            AVLNode<E> aVLNode = this.next;
            if (aVLNode == null) {
                this.next = ((TreeList) this.parent).root.get(this.nextIndex - 1);
            } else {
                this.next = aVLNode.previous();
            }
            E value = this.next.getValue();
            this.current = this.next;
            int i = this.nextIndex - 1;
            this.nextIndex = i;
            this.currentIndex = i;
            return value;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return nextIndex() - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            checkModCount();
            int i = this.currentIndex;
            if (i == -1) {
                throw new IllegalStateException();
            }
            this.parent.remove(i);
            int i2 = this.nextIndex;
            if (i2 != this.currentIndex) {
                this.nextIndex = i2 - 1;
            }
            this.next = null;
            this.current = null;
            this.currentIndex = -1;
            this.expectedModCount++;
        }

        @Override // java.util.ListIterator
        public void set(E e) {
            checkModCount();
            AVLNode<E> aVLNode = this.current;
            if (aVLNode == null) {
                throw new IllegalStateException();
            }
            aVLNode.setValue(e);
        }
    }

    public TreeList() {
    }

    private void checkInterval(int i, int i2, int i4) {
        if (i < i2 || i > i4) {
            StringBuilder sbM778t = AbstractC0541b.m778t(i, "Invalid index:", ", size=");
            sbM778t.append(size());
            throw new IndexOutOfBoundsException(sbM778t.toString());
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i, E e) {
        ((AbstractList) this).modCount++;
        checkInterval(i, 0, size());
        AVLNode<E> aVLNode = this.root;
        if (aVLNode == null) {
            this.root = new AVLNode<>(i, e, null, null);
        } else {
            this.root = aVLNode.insert(i, e);
        }
        this.size++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount = collection.size() + ((AbstractList) this).modCount;
        AVLNode<E> aVLNode = new AVLNode<>(collection);
        AVLNode<E> aVLNode2 = this.root;
        if (aVLNode2 != null) {
            aVLNode = aVLNode2.addAll(aVLNode, this.size);
        }
        this.root = aVLNode;
        this.size = collection.size() + this.size;
        return true;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        ((AbstractList) this).modCount++;
        this.root = null;
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        checkInterval(i, 0, size() - 1);
        return this.root.get(i).getValue();
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        AVLNode<E> aVLNode = this.root;
        if (aVLNode == null) {
            return -1;
        }
        return aVLNode.indexOf(obj, ((AVLNode) aVLNode).relativePosition);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i) {
        ((AbstractList) this).modCount++;
        checkInterval(i, 0, size() - 1);
        E e = get(i);
        this.root = this.root.remove(i);
        this.size--;
        return e;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i, E e) {
        checkInterval(i, 0, size() - 1);
        AVLNode<E> aVLNode = this.root.get(i);
        E e2 = (E) ((AVLNode) aVLNode).value;
        aVLNode.setValue(e);
        return e2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        Object[] objArr = new Object[size()];
        AVLNode<E> aVLNode = this.root;
        if (aVLNode != null) {
            aVLNode.toArray(objArr, ((AVLNode) aVLNode).relativePosition);
        }
        return objArr;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class AVLNode<E> {
        private int height;
        private AVLNode<E> left;
        private boolean leftIsPrevious;
        private int relativePosition;
        private AVLNode<E> right;
        private boolean rightIsNext;
        private E value;

        /* JADX INFO: Access modifiers changed from: private */
        public AVLNode<E> addAll(AVLNode<E> aVLNode, int i) {
            AVLNode<E> aVLNodeMax = max();
            AVLNode<E> aVLNodeMin = aVLNode.min();
            if (aVLNode.height <= this.height) {
                AVLNode<E> aVLNodeRemoveMin = aVLNode.removeMin();
                ArrayDeque arrayDeque = new ArrayDeque();
                int i2 = this.relativePosition;
                int i4 = 0;
                AVLNode<E> aVLNode2 = this;
                while (aVLNode2 != null && aVLNode2.height > getHeight(aVLNodeRemoveMin)) {
                    arrayDeque.push(aVLNode2);
                    aVLNode2 = aVLNode2.right;
                    if (aVLNode2 != null) {
                        int i5 = i2;
                        i2 = aVLNode2.relativePosition + i2;
                        i4 = i5;
                    } else {
                        i4 = i2;
                    }
                }
                aVLNodeMin.setRight(aVLNodeRemoveMin, null);
                aVLNodeMin.setLeft(aVLNode2, aVLNodeMax);
                if (aVLNodeRemoveMin != null) {
                    aVLNodeRemoveMin.min().setLeft(null, aVLNodeMin);
                    aVLNodeRemoveMin.relativePosition++;
                }
                if (aVLNode2 != null) {
                    aVLNode2.max().setRight(null, aVLNodeMin);
                    aVLNode2.relativePosition = i2 - i;
                }
                aVLNodeMin.relativePosition = i - i4;
                while (!arrayDeque.isEmpty()) {
                    AVLNode aVLNode3 = (AVLNode) arrayDeque.pop();
                    aVLNode3.setRight(aVLNodeMin, null);
                    aVLNodeMin = aVLNode3.balance();
                }
                return aVLNodeMin;
            }
            AVLNode<E> aVLNodeRemoveMax = removeMax();
            ArrayDeque arrayDeque2 = new ArrayDeque();
            int i6 = 0;
            int i7 = aVLNode.relativePosition + i;
            AVLNode<E> aVLNode4 = aVLNode;
            while (aVLNode4 != null && aVLNode4.height > getHeight(aVLNodeRemoveMax)) {
                arrayDeque2.push(aVLNode4);
                aVLNode4 = aVLNode4.left;
                if (aVLNode4 != null) {
                    i6 = i7;
                    i7 = aVLNode4.relativePosition + i7;
                } else {
                    i6 = i7;
                }
            }
            aVLNodeMax.setLeft(aVLNodeRemoveMax, null);
            aVLNodeMax.setRight(aVLNode4, aVLNodeMin);
            if (aVLNodeRemoveMax != null) {
                aVLNodeRemoveMax.max().setRight(null, aVLNodeMax);
                aVLNodeRemoveMax.relativePosition -= i - 1;
            }
            if (aVLNode4 != null) {
                aVLNode4.min().setLeft(null, aVLNodeMax);
                aVLNode4.relativePosition = (i7 - i) + 1;
            }
            aVLNodeMax.relativePosition = (i - 1) - i6;
            aVLNode.relativePosition += i;
            while (!arrayDeque2.isEmpty()) {
                AVLNode aVLNode5 = (AVLNode) arrayDeque2.pop();
                aVLNode5.setLeft(aVLNodeMax, null);
                aVLNodeMax = aVLNode5.balance();
            }
            return aVLNodeMax;
        }

        private AVLNode<E> balance() {
            int iHeightRightMinusLeft = heightRightMinusLeft();
            if (iHeightRightMinusLeft == -2) {
                if (this.left.heightRightMinusLeft() > 0) {
                    setLeft(this.left.rotateLeft(), null);
                }
                return rotateRight();
            }
            if (iHeightRightMinusLeft == -1 || iHeightRightMinusLeft == 0 || iHeightRightMinusLeft == 1) {
                return this;
            }
            if (iHeightRightMinusLeft != 2) {
                throw new IllegalStateException("tree inconsistent!");
            }
            if (this.right.heightRightMinusLeft() < 0) {
                setRight(this.right.rotateRight(), null);
            }
            return rotateLeft();
        }

        private int getHeight(AVLNode<E> aVLNode) {
            if (aVLNode == null) {
                return -1;
            }
            return aVLNode.height;
        }

        private AVLNode<E> getLeftSubTree() {
            if (this.leftIsPrevious) {
                return null;
            }
            return this.left;
        }

        private int getOffset(AVLNode<E> aVLNode) {
            if (aVLNode == null) {
                return 0;
            }
            return aVLNode.relativePosition;
        }

        private AVLNode<E> getRightSubTree() {
            if (this.rightIsNext) {
                return null;
            }
            return this.right;
        }

        private int heightRightMinusLeft() {
            return getHeight(getRightSubTree()) - getHeight(getLeftSubTree());
        }

        private AVLNode<E> insertOnLeft(int i, E e) {
            if (getLeftSubTree() == null) {
                setLeft(new AVLNode<>(-1, e, this, this.left), null);
            } else {
                setLeft(this.left.insert(i, e), null);
            }
            int i2 = this.relativePosition;
            if (i2 >= 0) {
                this.relativePosition = i2 + 1;
            }
            AVLNode<E> aVLNodeBalance = balance();
            recalcHeight();
            return aVLNodeBalance;
        }

        private AVLNode<E> insertOnRight(int i, E e) {
            if (getRightSubTree() == null) {
                setRight(new AVLNode<>(1, e, this.right, this), null);
            } else {
                setRight(this.right.insert(i, e), null);
            }
            int i2 = this.relativePosition;
            if (i2 < 0) {
                this.relativePosition = i2 - 1;
            }
            AVLNode<E> aVLNodeBalance = balance();
            recalcHeight();
            return aVLNodeBalance;
        }

        private AVLNode<E> max() {
            return getRightSubTree() == null ? this : this.right.max();
        }

        private AVLNode<E> min() {
            return getLeftSubTree() == null ? this : this.left.min();
        }

        private void recalcHeight() {
            this.height = Math.max(getLeftSubTree() == null ? -1 : getLeftSubTree().height, getRightSubTree() != null ? getRightSubTree().height : -1) + 1;
        }

        private AVLNode<E> removeMax() {
            if (getRightSubTree() == null) {
                return removeSelf();
            }
            setRight(this.right.removeMax(), this.right.right);
            int i = this.relativePosition;
            if (i < 0) {
                this.relativePosition = i + 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeMin() {
            if (getLeftSubTree() == null) {
                return removeSelf();
            }
            setLeft(this.left.removeMin(), this.left.left);
            int i = this.relativePosition;
            if (i > 0) {
                this.relativePosition = i - 1;
            }
            recalcHeight();
            return balance();
        }

        private AVLNode<E> removeSelf() {
            if (getRightSubTree() == null && getLeftSubTree() == null) {
                return null;
            }
            if (getRightSubTree() == null) {
                int i = this.relativePosition;
                if (i > 0) {
                    this.left.relativePosition += i;
                }
                this.left.max().setRight(null, this.right);
                return this.left;
            }
            if (getLeftSubTree() == null) {
                AVLNode<E> aVLNode = this.right;
                int i2 = aVLNode.relativePosition;
                int i4 = this.relativePosition;
                aVLNode.relativePosition = (i4 - (i4 < 0 ? 0 : 1)) + i2;
                aVLNode.min().setLeft(null, this.left);
                return this.right;
            }
            if (heightRightMinusLeft() > 0) {
                AVLNode<E> aVLNodeMin = this.right.min();
                this.value = aVLNodeMin.value;
                if (this.leftIsPrevious) {
                    this.left = aVLNodeMin.left;
                }
                this.right = this.right.removeMin();
                int i5 = this.relativePosition;
                if (i5 < 0) {
                    this.relativePosition = i5 + 1;
                }
            } else {
                AVLNode<E> aVLNodeMax = this.left.max();
                this.value = aVLNodeMax.value;
                if (this.rightIsNext) {
                    this.right = aVLNodeMax.right;
                }
                AVLNode<E> aVLNode2 = this.left;
                AVLNode<E> aVLNode3 = aVLNode2.left;
                AVLNode<E> aVLNodeRemoveMax = aVLNode2.removeMax();
                this.left = aVLNodeRemoveMax;
                if (aVLNodeRemoveMax == null) {
                    this.left = aVLNode3;
                    this.leftIsPrevious = true;
                }
                int i6 = this.relativePosition;
                if (i6 > 0) {
                    this.relativePosition = i6 - 1;
                }
            }
            recalcHeight();
            return this;
        }

        private AVLNode<E> rotateLeft() {
            AVLNode<E> aVLNode = this.right;
            AVLNode<E> leftSubTree = getRightSubTree().getLeftSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(leftSubTree);
            setRight(leftSubTree, aVLNode);
            aVLNode.setLeft(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i);
            setOffset(leftSubTree, offset2);
            return aVLNode;
        }

        private AVLNode<E> rotateRight() {
            AVLNode<E> aVLNode = this.left;
            AVLNode<E> rightSubTree = getLeftSubTree().getRightSubTree();
            int offset = this.relativePosition + getOffset(aVLNode);
            int i = -aVLNode.relativePosition;
            int offset2 = getOffset(aVLNode) + getOffset(rightSubTree);
            setLeft(rightSubTree, aVLNode);
            aVLNode.setRight(this, null);
            setOffset(aVLNode, offset);
            setOffset(this, i);
            setOffset(rightSubTree, offset2);
            return aVLNode;
        }

        private void setLeft(AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            boolean z = aVLNode == null;
            this.leftIsPrevious = z;
            if (z) {
                aVLNode = aVLNode2;
            }
            this.left = aVLNode;
            recalcHeight();
        }

        private int setOffset(AVLNode<E> aVLNode, int i) {
            if (aVLNode == null) {
                return 0;
            }
            int offset = getOffset(aVLNode);
            aVLNode.relativePosition = i;
            return offset;
        }

        private void setRight(AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            boolean z = aVLNode == null;
            this.rightIsNext = z;
            if (z) {
                aVLNode = aVLNode2;
            }
            this.right = aVLNode;
            recalcHeight();
        }

        public AVLNode<E> get(int i) {
            int i2 = i - this.relativePosition;
            if (i2 == 0) {
                return this;
            }
            AVLNode<E> leftSubTree = i2 < 0 ? getLeftSubTree() : getRightSubTree();
            if (leftSubTree == null) {
                return null;
            }
            return leftSubTree.get(i2);
        }

        public E getValue() {
            return this.value;
        }

        public int indexOf(Object obj, int i) {
            if (getLeftSubTree() != null) {
                AVLNode<E> aVLNode = this.left;
                int iIndexOf = aVLNode.indexOf(obj, aVLNode.relativePosition + i);
                if (iIndexOf != -1) {
                    return iIndexOf;
                }
            }
            if (Objects.equals(this.value, obj)) {
                return i;
            }
            if (getRightSubTree() == null) {
                return -1;
            }
            AVLNode<E> aVLNode2 = this.right;
            return aVLNode2.indexOf(obj, i + aVLNode2.relativePosition);
        }

        public AVLNode<E> insert(int i, E e) {
            int i2 = i - this.relativePosition;
            return i2 <= 0 ? insertOnLeft(i2, e) : insertOnRight(i2, e);
        }

        public AVLNode<E> next() {
            AVLNode<E> aVLNode;
            return (this.rightIsNext || (aVLNode = this.right) == null) ? this.right : aVLNode.min();
        }

        public AVLNode<E> previous() {
            AVLNode<E> aVLNode;
            return (this.leftIsPrevious || (aVLNode = this.left) == null) ? this.left : aVLNode.max();
        }

        public AVLNode<E> remove(int i) {
            int i2 = i - this.relativePosition;
            if (i2 == 0) {
                return removeSelf();
            }
            if (i2 > 0) {
                setRight(this.right.remove(i2), this.right.right);
                int i4 = this.relativePosition;
                if (i4 < 0) {
                    this.relativePosition = i4 + 1;
                }
            } else {
                setLeft(this.left.remove(i2), this.left.left);
                int i5 = this.relativePosition;
                if (i5 > 0) {
                    this.relativePosition = i5 - 1;
                }
            }
            recalcHeight();
            return balance();
        }

        public void setValue(E e) {
            this.value = e;
        }

        public void toArray(Object[] objArr, int i) {
            objArr[i] = this.value;
            if (getLeftSubTree() != null) {
                AVLNode<E> aVLNode = this.left;
                aVLNode.toArray(objArr, aVLNode.relativePosition + i);
            }
            if (getRightSubTree() != null) {
                AVLNode<E> aVLNode2 = this.right;
                aVLNode2.toArray(objArr, i + aVLNode2.relativePosition);
            }
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("AVLNode(");
            sb.append(this.relativePosition);
            sb.append(",");
            sb.append(this.left != null);
            sb.append(",");
            sb.append(this.value);
            sb.append(",");
            sb.append(getRightSubTree() != null);
            return AbstractC0000a.m14k(sb, this.rightIsNext, ")");
        }

        private AVLNode(Collection<? extends E> collection) {
            this(collection.iterator(), 0, collection.size() - 1, 0, null, null);
        }

        private AVLNode(int i, E e, AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            this.relativePosition = i;
            this.value = e;
            this.rightIsNext = true;
            this.leftIsPrevious = true;
            this.right = aVLNode;
            this.left = aVLNode2;
        }

        private AVLNode(Iterator<? extends E> it, int i, int i2, int i4, AVLNode<E> aVLNode, AVLNode<E> aVLNode2) {
            AVLNode<E> aVLNode3;
            Iterator<? extends E> it2;
            int iM7d = AbstractC0000a.m7d(i2, i, 2, i);
            if (i < iM7d) {
                it2 = it;
                aVLNode3 = this;
                aVLNode3.left = new AVLNode<>(it2, i, iM7d - 1, iM7d, aVLNode, this);
            } else {
                aVLNode3 = this;
                it2 = it;
                aVLNode3.leftIsPrevious = true;
                aVLNode3.left = aVLNode;
            }
            aVLNode3.value = it2.next();
            aVLNode3.relativePosition = iM7d - i4;
            if (iM7d < i2) {
                aVLNode3.right = new AVLNode<>(it2, iM7d + 1, i2, iM7d, aVLNode3, aVLNode2);
            } else {
                aVLNode3.rightIsNext = true;
                aVLNode3.right = aVLNode2;
            }
            recalcHeight();
        }
    }

    public TreeList(Collection<? extends E> collection) {
        if (collection.isEmpty()) {
            return;
        }
        this.root = new AVLNode<>(collection);
        this.size = collection.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator<E> listIterator(int i) {
        checkInterval(i, 0, size());
        return new TreeListIterator(this, i);
    }
}
