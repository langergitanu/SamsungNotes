package org.apache.commons.collections;

import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DoubleOrderedMap extends AbstractMap {
    private static final int FIRST_INDEX = 0;
    private static final int KEY = 0;
    private static final int NUMBER_OF_INDICES = 2;
    private static final int SUM_OF_INDICES = 1;
    private static final int VALUE = 1;
    private static final String[] dataName = {"key", "value"};
    private Collection[] collectionOfValues;
    private int modifications;
    private int nodeCount;
    private Node[] rootNode;
    private Set[] setOfEntries;
    private Set[] setOfKeys;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class DoubleOrderedMapIterator implements Iterator {
        private int expectedModifications;
        private int iteratorType;
        protected Node lastReturnedNode = null;
        private Node nextNode;

        public DoubleOrderedMapIterator(int i) {
            this.iteratorType = i;
            this.expectedModifications = DoubleOrderedMap.this.modifications;
            Node[] nodeArr = DoubleOrderedMap.this.rootNode;
            int i2 = this.iteratorType;
            this.nextNode = DoubleOrderedMap.leastNode(nodeArr[i2], i2);
        }

        public abstract Object doGetNext();

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.nextNode != null;
        }

        @Override // java.util.Iterator
        public final Object next() {
            if (this.nextNode == null) {
                throw new NoSuchElementException();
            }
            if (DoubleOrderedMap.this.modifications != this.expectedModifications) {
                throw new ConcurrentModificationException();
            }
            Node node = this.nextNode;
            this.lastReturnedNode = node;
            this.nextNode = DoubleOrderedMap.this.nextGreater(node, this.iteratorType);
            return doGetNext();
        }

        @Override // java.util.Iterator
        public final void remove() {
            if (this.lastReturnedNode == null) {
                throw new IllegalStateException();
            }
            if (DoubleOrderedMap.this.modifications != this.expectedModifications) {
                throw new ConcurrentModificationException();
            }
            DoubleOrderedMap.this.doRedBlackDelete(this.lastReturnedNode);
            this.expectedModifications++;
            this.lastReturnedNode = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class Node implements Map.Entry, KeyValue {
        private Comparable[] data;
        private int hashcodeValue;
        private Node[] leftNode = {null, null};
        private Node[] rightNode = {null, null};
        private Node[] parentNode = {null, null};
        private boolean[] blackColor = {true, true};
        private boolean calculatedHashCode = false;

        public Node(Comparable comparable, Comparable comparable2) {
            this.data = new Comparable[]{comparable, comparable2};
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void copyColor(Node node, int i) {
            this.blackColor[i] = node.blackColor[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Comparable getData(int i) {
            return this.data[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node getLeft(int i) {
            return this.leftNode[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node getParent(int i) {
            return this.parentNode[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node getRight(int i) {
            return this.rightNode[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isBlack(int i) {
            return this.blackColor[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isRed(int i) {
            return !this.blackColor[i];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBlack(int i) {
            this.blackColor[i] = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeft(Node node, int i) {
            this.leftNode[i] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParent(Node node, int i) {
            this.parentNode[i] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRed(int i) {
            this.blackColor[i] = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRight(Node node, int i) {
            this.rightNode[i] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void swapColors(Node node, int i) {
            boolean[] zArr = this.blackColor;
            boolean z = zArr[i];
            boolean[] zArr2 = node.blackColor;
            boolean z2 = z ^ zArr2[i];
            zArr[i] = z2;
            boolean z3 = z2 ^ zArr2[i];
            zArr2[i] = z3;
            zArr[i] = zArr[i] ^ z3;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.data[0].equals(entry.getKey()) && this.data[1].equals(entry.getValue());
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getKey() {
            return this.data[0];
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
        public Object getValue() {
            return this.data[1];
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.calculatedHashCode) {
                this.hashcodeValue = this.data[0].hashCode() ^ this.data[1].hashCode();
                this.calculatedHashCode = true;
            }
            return this.hashcodeValue;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
        }
    }

    public DoubleOrderedMap() {
        this.rootNode = new Node[]{null, null};
        this.nodeCount = 0;
        this.modifications = 0;
        this.setOfKeys = new Set[]{null, null};
        this.setOfEntries = new Set[]{null, null};
        this.collectionOfValues = new Collection[]{null, null};
    }

    private static void checkKey(Object obj) {
        checkNonNullComparable(obj, 0);
    }

    private static void checkKeyAndValue(Object obj, Object obj2) {
        checkKey(obj);
        checkValue(obj2);
    }

    private static void checkNonNullComparable(Object obj, int i) {
        if (obj == null) {
            throw new NullPointerException(AbstractC8014b.m7199a(new StringBuffer(), dataName[i], " cannot be null"));
        }
        if (!(obj instanceof Comparable)) {
            throw new ClassCastException(AbstractC8014b.m7199a(new StringBuffer(), dataName[i], " must be Comparable"));
        }
    }

    private static void checkValue(Object obj) {
        checkNonNullComparable(obj, 1);
    }

    private static int compare(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    private static void copyColor(Node node, Node node2, int i) {
        if (node2 != null) {
            if (node == null) {
                node2.setBlack(i);
            } else {
                node2.copyColor(node, i);
            }
        }
    }

    private Object doGet(Comparable comparable, int i) {
        checkNonNullComparable(comparable, i);
        Node nodeLookup = lookup(comparable, i);
        if (nodeLookup == null) {
            return null;
        }
        return nodeLookup.getData(oppositeIndex(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRedBlackDelete(Node node) {
        for (int i = 0; i < 2; i++) {
            if (node.getLeft(i) != null && node.getRight(i) != null) {
                swapPosition(nextGreater(node, i), node, i);
            }
            Node left = node.getLeft(i) != null ? node.getLeft(i) : node.getRight(i);
            if (left != null) {
                left.setParent(node.getParent(i), i);
                if (node.getParent(i) == null) {
                    this.rootNode[i] = left;
                } else if (node == node.getParent(i).getLeft(i)) {
                    node.getParent(i).setLeft(left, i);
                } else {
                    node.getParent(i).setRight(left, i);
                }
                node.setLeft(null, i);
                node.setRight(null, i);
                node.setParent(null, i);
                if (isBlack(node, i)) {
                    doRedBlackDeleteFixup(left, i);
                }
            } else if (node.getParent(i) == null) {
                this.rootNode[i] = null;
            } else {
                if (isBlack(node, i)) {
                    doRedBlackDeleteFixup(node, i);
                }
                if (node.getParent(i) != null) {
                    if (node == node.getParent(i).getLeft(i)) {
                        node.getParent(i).setLeft(null, i);
                    } else {
                        node.getParent(i).setRight(null, i);
                    }
                    node.setParent(null, i);
                }
            }
        }
        shrink();
    }

    private void doRedBlackDeleteFixup(Node node, int i) {
        while (node != this.rootNode[i] && isBlack(node, i)) {
            if (isLeftChild(node, i)) {
                Node rightChild = getRightChild(getParent(node, i), i);
                if (isRed(rightChild, i)) {
                    makeBlack(rightChild, i);
                    makeRed(getParent(node, i), i);
                    rotateLeft(getParent(node, i), i);
                    rightChild = getRightChild(getParent(node, i), i);
                }
                if (isBlack(getLeftChild(rightChild, i), i) && isBlack(getRightChild(rightChild, i), i)) {
                    makeRed(rightChild, i);
                    node = getParent(node, i);
                } else {
                    if (isBlack(getRightChild(rightChild, i), i)) {
                        makeBlack(getLeftChild(rightChild, i), i);
                        makeRed(rightChild, i);
                        rotateRight(rightChild, i);
                        rightChild = getRightChild(getParent(node, i), i);
                    }
                    copyColor(getParent(node, i), rightChild, i);
                    makeBlack(getParent(node, i), i);
                    makeBlack(getRightChild(rightChild, i), i);
                    rotateLeft(getParent(node, i), i);
                    node = this.rootNode[i];
                }
            } else {
                Node leftChild = getLeftChild(getParent(node, i), i);
                if (isRed(leftChild, i)) {
                    makeBlack(leftChild, i);
                    makeRed(getParent(node, i), i);
                    rotateRight(getParent(node, i), i);
                    leftChild = getLeftChild(getParent(node, i), i);
                }
                if (isBlack(getRightChild(leftChild, i), i) && isBlack(getLeftChild(leftChild, i), i)) {
                    makeRed(leftChild, i);
                    node = getParent(node, i);
                } else {
                    if (isBlack(getLeftChild(leftChild, i), i)) {
                        makeBlack(getRightChild(leftChild, i), i);
                        makeRed(leftChild, i);
                        rotateLeft(leftChild, i);
                        leftChild = getLeftChild(getParent(node, i), i);
                    }
                    copyColor(getParent(node, i), leftChild, i);
                    makeBlack(getParent(node, i), i);
                    makeBlack(getLeftChild(leftChild, i), i);
                    rotateRight(getParent(node, i), i);
                    node = this.rootNode[i];
                }
            }
        }
        makeBlack(node, i);
    }

    private void doRedBlackInsert(Node node, int i) {
        makeRed(node, i);
        while (node != null && node != this.rootNode[i] && isRed(node.getParent(i), i)) {
            if (isLeftChild(getParent(node, i), i)) {
                Node rightChild = getRightChild(getGrandParent(node, i), i);
                if (isRed(rightChild, i)) {
                    makeBlack(getParent(node, i), i);
                    makeBlack(rightChild, i);
                    makeRed(getGrandParent(node, i), i);
                    node = getGrandParent(node, i);
                } else {
                    if (isRightChild(node, i)) {
                        node = getParent(node, i);
                        rotateLeft(node, i);
                    }
                    makeBlack(getParent(node, i), i);
                    makeRed(getGrandParent(node, i), i);
                    if (getGrandParent(node, i) != null) {
                        rotateRight(getGrandParent(node, i), i);
                    }
                }
            } else {
                Node leftChild = getLeftChild(getGrandParent(node, i), i);
                if (isRed(leftChild, i)) {
                    makeBlack(getParent(node, i), i);
                    makeBlack(leftChild, i);
                    makeRed(getGrandParent(node, i), i);
                    node = getGrandParent(node, i);
                } else {
                    if (isLeftChild(node, i)) {
                        node = getParent(node, i);
                        rotateRight(node, i);
                    }
                    makeBlack(getParent(node, i), i);
                    makeRed(getGrandParent(node, i), i);
                    if (getGrandParent(node, i) != null) {
                        rotateLeft(getGrandParent(node, i), i);
                    }
                }
            }
        }
        makeBlack(this.rootNode[i], i);
    }

    private Object doRemove(Comparable comparable, int i) {
        Node nodeLookup = lookup(comparable, i);
        if (nodeLookup == null) {
            return null;
        }
        Comparable data = nodeLookup.getData(oppositeIndex(i));
        doRedBlackDelete(nodeLookup);
        return data;
    }

    private static Node getGrandParent(Node node, int i) {
        return getParent(getParent(node, i), i);
    }

    private static Node getLeftChild(Node node, int i) {
        if (node == null) {
            return null;
        }
        return node.getLeft(i);
    }

    private static Node getParent(Node node, int i) {
        if (node == null) {
            return null;
        }
        return node.getParent(i);
    }

    private static Node getRightChild(Node node, int i) {
        if (node == null) {
            return null;
        }
        return node.getRight(i);
    }

    private void grow() {
        modify();
        this.nodeCount++;
    }

    private void insertValue(Node node) {
        Node left = this.rootNode[1];
        while (true) {
            int iCompare = compare(node.getData(1), left.getData(1));
            if (iCompare == 0) {
                StringBuffer stringBuffer = new StringBuffer("Cannot store a duplicate value (\"");
                stringBuffer.append(node.getData(1));
                stringBuffer.append("\") in this Map");
                throw new IllegalArgumentException(stringBuffer.toString());
            }
            if (iCompare < 0) {
                if (left.getLeft(1) == null) {
                    left.setLeft(node, 1);
                    node.setParent(left, 1);
                    doRedBlackInsert(node, 1);
                    return;
                }
                left = left.getLeft(1);
            } else {
                if (left.getRight(1) == null) {
                    left.setRight(node, 1);
                    node.setParent(left, 1);
                    doRedBlackInsert(node, 1);
                    return;
                }
                left = left.getRight(1);
            }
        }
    }

    private static boolean isBlack(Node node, int i) {
        if (node == null) {
            return true;
        }
        return node.isBlack(i);
    }

    private static boolean isLeftChild(Node node, int i) {
        if (node == null) {
            return true;
        }
        return node.getParent(i) != null && node == node.getParent(i).getLeft(i);
    }

    private static boolean isRed(Node node, int i) {
        if (node == null) {
            return false;
        }
        return node.isRed(i);
    }

    private static boolean isRightChild(Node node, int i) {
        if (node == null) {
            return true;
        }
        return node.getParent(i) != null && node == node.getParent(i).getRight(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Node leastNode(Node node, int i) {
        if (node != null) {
            while (node.getLeft(i) != null) {
                node = node.getLeft(i);
            }
        }
        return node;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node lookup(Comparable comparable, int i) {
        Node left = this.rootNode[i];
        while (left != null) {
            int iCompare = compare(comparable, left.getData(i));
            if (iCompare == 0) {
                return left;
            }
            left = iCompare < 0 ? left.getLeft(i) : left.getRight(i);
        }
        return null;
    }

    private static void makeBlack(Node node, int i) {
        if (node != null) {
            node.setBlack(i);
        }
    }

    private static void makeRed(Node node, int i) {
        if (node != null) {
            node.setRed(i);
        }
    }

    private void modify() {
        this.modifications++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node nextGreater(Node node, int i) {
        if (node == null) {
            return null;
        }
        if (node.getRight(i) != null) {
            return leastNode(node.getRight(i), i);
        }
        Node parent = node.getParent(i);
        while (true) {
            Node node2 = parent;
            Node node3 = node;
            node = node2;
            if (node == null || node3 != node.getRight(i)) {
                break;
            }
            parent = node.getParent(i);
        }
        return node;
    }

    private int oppositeIndex(int i) {
        return 1 - i;
    }

    private void rotateLeft(Node node, int i) {
        Node right = node.getRight(i);
        node.setRight(right.getLeft(i), i);
        if (right.getLeft(i) != null) {
            right.getLeft(i).setParent(node, i);
        }
        right.setParent(node.getParent(i), i);
        if (node.getParent(i) == null) {
            this.rootNode[i] = right;
        } else if (node.getParent(i).getLeft(i) == node) {
            node.getParent(i).setLeft(right, i);
        } else {
            node.getParent(i).setRight(right, i);
        }
        right.setLeft(node, i);
        node.setParent(right, i);
    }

    private void rotateRight(Node node, int i) {
        Node left = node.getLeft(i);
        node.setLeft(left.getRight(i), i);
        if (left.getRight(i) != null) {
            left.getRight(i).setParent(node, i);
        }
        left.setParent(node.getParent(i), i);
        if (node.getParent(i) == null) {
            this.rootNode[i] = left;
        } else if (node.getParent(i).getRight(i) == node) {
            node.getParent(i).setRight(left, i);
        } else {
            node.getParent(i).setLeft(left, i);
        }
        left.setRight(node, i);
        node.setParent(left, i);
    }

    private void shrink() {
        modify();
        this.nodeCount--;
    }

    private void swapPosition(Node node, Node node2, int i) {
        Node parent = node.getParent(i);
        Node left = node.getLeft(i);
        Node right = node.getRight(i);
        Node parent2 = node2.getParent(i);
        Node left2 = node2.getLeft(i);
        Node right2 = node2.getRight(i);
        boolean z = false;
        boolean z2 = node.getParent(i) != null && node == node.getParent(i).getLeft(i);
        if (node2.getParent(i) != null && node2 == node2.getParent(i).getLeft(i)) {
            z = true;
        }
        if (node == parent2) {
            node.setParent(node2, i);
            if (z) {
                node2.setLeft(node, i);
                node2.setRight(right, i);
            } else {
                node2.setRight(node, i);
                node2.setLeft(left, i);
            }
        } else {
            node.setParent(parent2, i);
            if (parent2 != null) {
                if (z) {
                    parent2.setLeft(node, i);
                } else {
                    parent2.setRight(node, i);
                }
            }
            node2.setLeft(left, i);
            node2.setRight(right, i);
        }
        if (node2 == parent) {
            node2.setParent(node, i);
            if (z2) {
                node.setLeft(node2, i);
                node.setRight(right2, i);
            } else {
                node.setRight(node2, i);
                node.setLeft(left2, i);
            }
        } else {
            node2.setParent(parent, i);
            if (parent != null) {
                if (z2) {
                    parent.setLeft(node2, i);
                } else {
                    parent.setRight(node2, i);
                }
            }
            node.setLeft(left2, i);
            node.setRight(right2, i);
        }
        if (node.getLeft(i) != null) {
            node.getLeft(i).setParent(node, i);
        }
        if (node.getRight(i) != null) {
            node.getRight(i).setParent(node, i);
        }
        if (node2.getLeft(i) != null) {
            node2.getLeft(i).setParent(node2, i);
        }
        if (node2.getRight(i) != null) {
            node2.getRight(i).setParent(node2, i);
        }
        node.swapColors(node2, i);
        Node[] nodeArr = this.rootNode;
        Node node3 = nodeArr[i];
        if (node3 == node) {
            nodeArr[i] = node2;
        } else if (node3 == node2) {
            nodeArr[i] = node;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        modify();
        this.nodeCount = 0;
        Node[] nodeArr = this.rootNode;
        nodeArr[0] = null;
        nodeArr[1] = null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        checkKey(obj);
        return lookup((Comparable) obj, 0) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        checkValue(obj);
        return lookup((Comparable) obj, 1) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set[] setArr = this.setOfEntries;
        if (setArr[0] == null) {
            setArr[0] = new AbstractSet() { // from class: org.apache.commons.collections.DoubleOrderedMap.6
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object value = entry.getValue();
                    Node nodeLookup = DoubleOrderedMap.this.lookup((Comparable) entry.getKey(), 0);
                    return nodeLookup != null && nodeLookup.getData(1).equals(value);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 0) { // from class: org.apache.commons.collections.DoubleOrderedMap.6.1
                        private final /* synthetic */ C136856 this$1;

                        {
                            DoubleOrderedMap doubleOrderedMap = DoubleOrderedMap.this;
                            this.this$1 = this;
                        }

                        @Override // org.apache.commons.collections.DoubleOrderedMap.DoubleOrderedMapIterator
                        public Object doGetNext() {
                            return this.lastReturnedNode;
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object value = entry.getValue();
                    Node nodeLookup = DoubleOrderedMap.this.lookup((Comparable) entry.getKey(), 0);
                    if (nodeLookup == null || !nodeLookup.getData(1).equals(value)) {
                        return false;
                    }
                    DoubleOrderedMap.this.doRedBlackDelete(nodeLookup);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.setOfEntries[0];
    }

    public Set entrySetByValue() {
        Set[] setArr = this.setOfEntries;
        if (setArr[1] == null) {
            setArr[1] = new AbstractSet() { // from class: org.apache.commons.collections.DoubleOrderedMap.1
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Node nodeLookup = DoubleOrderedMap.this.lookup((Comparable) entry.getValue(), 1);
                    return nodeLookup != null && nodeLookup.getData(0).equals(key);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 1) { // from class: org.apache.commons.collections.DoubleOrderedMap.1.1
                        private final /* synthetic */ C136801 this$1;

                        {
                            DoubleOrderedMap doubleOrderedMap = DoubleOrderedMap.this;
                            this.this$1 = this;
                        }

                        @Override // org.apache.commons.collections.DoubleOrderedMap.DoubleOrderedMapIterator
                        public Object doGetNext() {
                            return this.lastReturnedNode;
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    if (!(obj instanceof Map.Entry)) {
                        return false;
                    }
                    Map.Entry entry = (Map.Entry) obj;
                    Object key = entry.getKey();
                    Node nodeLookup = DoubleOrderedMap.this.lookup((Comparable) entry.getValue(), 1);
                    if (nodeLookup == null || !nodeLookup.getData(0).equals(key)) {
                        return false;
                    }
                    DoubleOrderedMap.this.doRedBlackDelete(nodeLookup);
                    return true;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.setOfEntries[1];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        return doGet((Comparable) obj, 0);
    }

    public Object getKeyForValue(Object obj) {
        return doGet((Comparable) obj, 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set[] setArr = this.setOfKeys;
        if (setArr[0] == null) {
            setArr[0] = new AbstractSet() { // from class: org.apache.commons.collections.DoubleOrderedMap.4
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return DoubleOrderedMap.this.containsKey(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 0) { // from class: org.apache.commons.collections.DoubleOrderedMap.4.1
                        private final /* synthetic */ C136834 this$1;

                        {
                            DoubleOrderedMap doubleOrderedMap = DoubleOrderedMap.this;
                            this.this$1 = this;
                        }

                        @Override // org.apache.commons.collections.DoubleOrderedMap.DoubleOrderedMapIterator
                        public Object doGetNext() {
                            return this.lastReturnedNode.getData(0);
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    int i = DoubleOrderedMap.this.nodeCount;
                    DoubleOrderedMap.this.remove(obj);
                    return DoubleOrderedMap.this.nodeCount != i;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.setOfKeys[0];
    }

    public Set keySetByValue() {
        Set[] setArr = this.setOfKeys;
        if (setArr[1] == null) {
            setArr[1] = new AbstractSet() { // from class: org.apache.commons.collections.DoubleOrderedMap.2
                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean contains(Object obj) {
                    return DoubleOrderedMap.this.containsKey(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 1) { // from class: org.apache.commons.collections.DoubleOrderedMap.2.1
                        private final /* synthetic */ C136812 this$1;

                        {
                            DoubleOrderedMap doubleOrderedMap = DoubleOrderedMap.this;
                            this.this$1 = this;
                        }

                        @Override // org.apache.commons.collections.DoubleOrderedMap.DoubleOrderedMapIterator
                        public Object doGetNext() {
                            return this.lastReturnedNode.getData(0);
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public boolean remove(Object obj) {
                    int i = DoubleOrderedMap.this.nodeCount;
                    DoubleOrderedMap.this.remove(obj);
                    return DoubleOrderedMap.this.nodeCount != i;
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.setOfKeys[1];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        checkKeyAndValue(obj, obj2);
        Node left = this.rootNode[0];
        if (left == null) {
            Node node = new Node((Comparable) obj, (Comparable) obj2);
            Node[] nodeArr = this.rootNode;
            nodeArr[0] = node;
            nodeArr[1] = node;
            grow();
            return null;
        }
        while (true) {
            Comparable comparable = (Comparable) obj;
            int iCompare = compare(comparable, left.getData(0));
            if (iCompare == 0) {
                StringBuffer stringBuffer = new StringBuffer("Cannot store a duplicate key (\"");
                stringBuffer.append(obj);
                stringBuffer.append("\") in this Map");
                throw new IllegalArgumentException(stringBuffer.toString());
            }
            if (iCompare < 0) {
                if (left.getLeft(0) == null) {
                    Node node2 = new Node(comparable, (Comparable) obj2);
                    insertValue(node2);
                    left.setLeft(node2, 0);
                    node2.setParent(left, 0);
                    doRedBlackInsert(node2, 0);
                    grow();
                    return null;
                }
                left = left.getLeft(0);
            } else {
                if (left.getRight(0) == null) {
                    Node node3 = new Node(comparable, (Comparable) obj2);
                    insertValue(node3);
                    left.setRight(node3, 0);
                    node3.setParent(left, 0);
                    doRedBlackInsert(node3, 0);
                    grow();
                    return null;
                }
                left = left.getRight(0);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        return doRemove((Comparable) obj, 0);
    }

    public Object removeValue(Object obj) {
        return doRemove((Comparable) obj, 1);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.nodeCount;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection[] collectionArr = this.collectionOfValues;
        if (collectionArr[0] == null) {
            collectionArr[0] = new AbstractCollection() { // from class: org.apache.commons.collections.DoubleOrderedMap.5
                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object obj) {
                    return DoubleOrderedMap.this.containsValue(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 0) { // from class: org.apache.commons.collections.DoubleOrderedMap.5.1
                        private final /* synthetic */ C136845 this$1;

                        {
                            DoubleOrderedMap doubleOrderedMap = DoubleOrderedMap.this;
                            this.this$1 = this;
                        }

                        @Override // org.apache.commons.collections.DoubleOrderedMap.DoubleOrderedMapIterator
                        public Object doGetNext() {
                            return this.lastReturnedNode.getData(1);
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean remove(Object obj) {
                    int i = DoubleOrderedMap.this.nodeCount;
                    DoubleOrderedMap.this.removeValue(obj);
                    return DoubleOrderedMap.this.nodeCount != i;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection collection) {
                    Iterator it = collection.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        if (DoubleOrderedMap.this.removeValue(it.next()) != null) {
                            z = true;
                        }
                    }
                    return z;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.collectionOfValues[0];
    }

    public Collection valuesByValue() {
        Collection[] collectionArr = this.collectionOfValues;
        if (collectionArr[1] == null) {
            collectionArr[1] = new AbstractCollection() { // from class: org.apache.commons.collections.DoubleOrderedMap.3
                @Override // java.util.AbstractCollection, java.util.Collection
                public void clear() {
                    DoubleOrderedMap.this.clear();
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean contains(Object obj) {
                    return DoubleOrderedMap.this.containsValue(obj);
                }

                @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
                public Iterator iterator() {
                    return new DoubleOrderedMapIterator(this, 1) { // from class: org.apache.commons.collections.DoubleOrderedMap.3.1
                        private final /* synthetic */ C136823 this$1;

                        {
                            DoubleOrderedMap doubleOrderedMap = DoubleOrderedMap.this;
                            this.this$1 = this;
                        }

                        @Override // org.apache.commons.collections.DoubleOrderedMap.DoubleOrderedMapIterator
                        public Object doGetNext() {
                            return this.lastReturnedNode.getData(1);
                        }
                    };
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean remove(Object obj) {
                    int i = DoubleOrderedMap.this.nodeCount;
                    DoubleOrderedMap.this.removeValue(obj);
                    return DoubleOrderedMap.this.nodeCount != i;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public boolean removeAll(Collection collection) {
                    Iterator it = collection.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        if (DoubleOrderedMap.this.removeValue(it.next()) != null) {
                            z = true;
                        }
                    }
                    return z;
                }

                @Override // java.util.AbstractCollection, java.util.Collection
                public int size() {
                    return DoubleOrderedMap.this.size();
                }
            };
        }
        return this.collectionOfValues[1];
    }

    public DoubleOrderedMap(Map map) {
        this.rootNode = new Node[]{null, null};
        this.nodeCount = 0;
        this.modifications = 0;
        this.setOfKeys = new Set[]{null, null};
        this.setOfEntries = new Set[]{null, null};
        this.collectionOfValues = new Collection[]{null, null};
        putAll(map);
    }
}
