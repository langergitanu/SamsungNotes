package org.apache.commons.collections4.bidimap;

import androidx.compose.runtime.AbstractC1974b;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.apache.commons.collections4.KeyValue;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.OrderedBidiMap;
import org.apache.commons.collections4.OrderedIterator;
import org.apache.commons.collections4.OrderedMapIterator;
import org.apache.commons.collections4.iterators.EmptyOrderedMapIterator;
import org.apache.commons.collections4.keyvalue.UnmodifiableMapEntry;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TreeBidiMap<K extends Comparable<K>, V extends Comparable<V>> implements OrderedBidiMap<K, V>, Serializable {
    private static final long serialVersionUID = 721969328361807L;
    private transient Set<Map.Entry<K, V>> entrySet;
    private transient TreeBidiMap<K, V>.Inverse inverse;
    private transient Set<K> keySet;
    private transient int modifications;
    private transient int nodeCount;
    private transient Node<K, V>[] rootNode;
    private transient Set<V> valuesSet;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class AbstractView<E> extends AbstractSet<E> {
        final DataElement orderType;

        public AbstractView(DataElement dataElement) {
            this.orderType = dataElement;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            TreeBidiMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return TreeBidiMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public abstract class AbstractViewIterator {
        private int expectedModifications;
        private Node<K, V> nextNode;
        private final DataElement orderType;
        Node<K, V> lastReturnedNode = null;
        private Node<K, V> previousNode = null;

        public AbstractViewIterator(DataElement dataElement) {
            this.orderType = dataElement;
            this.expectedModifications = TreeBidiMap.this.modifications;
            this.nextNode = TreeBidiMap.this.leastNode(TreeBidiMap.this.rootNode[dataElement.ordinal()], dataElement);
        }

        public final boolean hasNext() {
            return this.nextNode != null;
        }

        public boolean hasPrevious() {
            return this.previousNode != null;
        }

        public Node<K, V> navigateNext() {
            if (this.nextNode == null) {
                throw new NoSuchElementException();
            }
            if (TreeBidiMap.this.modifications != this.expectedModifications) {
                throw new ConcurrentModificationException();
            }
            Node<K, V> node = this.nextNode;
            this.lastReturnedNode = node;
            this.previousNode = node;
            this.nextNode = TreeBidiMap.this.nextGreater(node, this.orderType);
            return this.lastReturnedNode;
        }

        public Node<K, V> navigatePrevious() {
            if (this.previousNode == null) {
                throw new NoSuchElementException();
            }
            if (TreeBidiMap.this.modifications != this.expectedModifications) {
                throw new ConcurrentModificationException();
            }
            Node<K, V> node = this.lastReturnedNode;
            this.nextNode = node;
            if (node == null) {
                this.nextNode = TreeBidiMap.this.nextGreater(this.previousNode, this.orderType);
            }
            Node<K, V> node2 = this.previousNode;
            this.lastReturnedNode = node2;
            this.previousNode = TreeBidiMap.this.nextSmaller(node2, this.orderType);
            return this.lastReturnedNode;
        }

        public final void remove() {
            if (this.lastReturnedNode == null) {
                throw new IllegalStateException();
            }
            if (TreeBidiMap.this.modifications != this.expectedModifications) {
                throw new ConcurrentModificationException();
            }
            TreeBidiMap.this.doRedBlackDelete(this.lastReturnedNode);
            this.expectedModifications++;
            this.lastReturnedNode = null;
            Node<K, V> node = this.nextNode;
            if (node != null) {
                this.previousNode = TreeBidiMap.this.nextSmaller(node, this.orderType);
            } else {
                TreeBidiMap treeBidiMap = TreeBidiMap.this;
                this.previousNode = treeBidiMap.greatestNode(treeBidiMap.rootNode[this.orderType.ordinal()], this.orderType);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum DataElement {
        KEY("key"),
        VALUE("value");

        private final String description;

        DataElement(String str) {
            this.description = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.description;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class EntryView extends TreeBidiMap<K, V>.AbstractView<Map.Entry<K, V>> {
        public EntryView() {
            super(DataElement.KEY);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node nodeLookupKey = TreeBidiMap.this.lookupKey(entry.getKey());
            return nodeLookupKey != null && Objects.equals(nodeLookupKey.getValue(), value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new ViewMapEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node nodeLookupKey = TreeBidiMap.this.lookupKey(entry.getKey());
            if (nodeLookupKey == null || !Objects.equals(nodeLookupKey.getValue(), value)) {
                return false;
            }
            TreeBidiMap.this.doRedBlackDelete(nodeLookupKey);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class Inverse implements OrderedBidiMap<V, K> {
        private Set<Map.Entry<V, K>> inverseEntrySet;
        private Set<V> inverseKeySet;
        private Set<K> inverseValuesSet;

        public Inverse() {
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void clear() {
            TreeBidiMap.this.clear();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean containsKey(Object obj) {
            return TreeBidiMap.this.containsValue(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean containsValue(Object obj) {
            return TreeBidiMap.this.containsKey(obj);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Set<Map.Entry<V, K>> entrySet() {
            if (this.inverseEntrySet == null) {
                this.inverseEntrySet = new InverseEntryView();
            }
            return this.inverseEntrySet;
        }

        @Override // java.util.Map
        public boolean equals(Object obj) {
            return TreeBidiMap.this.doEquals(obj, DataElement.VALUE);
        }

        @Override // java.util.Map
        public int hashCode() {
            return TreeBidiMap.this.doHashCode(DataElement.VALUE);
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public boolean isEmpty() {
            return TreeBidiMap.this.isEmpty();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public Set<V> keySet() {
            if (this.inverseKeySet == null) {
                this.inverseKeySet = new ValueView(DataElement.VALUE);
            }
            return this.inverseKeySet;
        }

        @Override // java.util.Map, org.apache.commons.collections4.Put
        public void putAll(Map<? extends V, ? extends K> map) {
            for (Map.Entry<? extends V, ? extends K> entry : map.entrySet()) {
                put((Comparable) entry.getKey(), (Comparable) entry.getValue());
            }
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public int size() {
            return TreeBidiMap.this.size();
        }

        public String toString() {
            return TreeBidiMap.this.doToString(DataElement.VALUE);
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public V firstKey() {
            if (TreeBidiMap.this.nodeCount == 0) {
                throw new NoSuchElementException("Map is empty");
            }
            TreeBidiMap treeBidiMap = TreeBidiMap.this;
            Node[] nodeArr = treeBidiMap.rootNode;
            DataElement dataElement = DataElement.VALUE;
            return (V) treeBidiMap.leastNode(nodeArr[dataElement.ordinal()], dataElement).getValue();
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public K get(Object obj) {
            return (K) TreeBidiMap.this.getKey(obj);
        }

        @Override // org.apache.commons.collections4.BidiMap
        public V getKey(Object obj) {
            return (V) TreeBidiMap.this.get(obj);
        }

        @Override // org.apache.commons.collections4.OrderedBidiMap, org.apache.commons.collections4.BidiMap
        public OrderedBidiMap<K, V> inverseBidiMap() {
            return TreeBidiMap.this;
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public V lastKey() {
            if (TreeBidiMap.this.nodeCount == 0) {
                throw new NoSuchElementException("Map is empty");
            }
            TreeBidiMap treeBidiMap = TreeBidiMap.this;
            Node[] nodeArr = treeBidiMap.rootNode;
            DataElement dataElement = DataElement.VALUE;
            return (V) treeBidiMap.greatestNode(nodeArr[dataElement.ordinal()], dataElement).getValue();
        }

        @Override // org.apache.commons.collections4.IterableGet
        public OrderedMapIterator<V, K> mapIterator() {
            return isEmpty() ? EmptyOrderedMapIterator.emptyOrderedMapIterator() : new InverseViewMapIterator(DataElement.VALUE);
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public V nextKey(V v) {
            TreeBidiMap.checkKey(v);
            TreeBidiMap treeBidiMap = TreeBidiMap.this;
            DataElement dataElement = DataElement.VALUE;
            Node nodeNextGreater = treeBidiMap.nextGreater(treeBidiMap.lookup(v, dataElement), dataElement);
            if (nodeNextGreater == null) {
                return null;
            }
            return (V) nodeNextGreater.getValue();
        }

        @Override // org.apache.commons.collections4.OrderedMap
        public V previousKey(V v) {
            TreeBidiMap.checkKey(v);
            TreeBidiMap treeBidiMap = TreeBidiMap.this;
            DataElement dataElement = DataElement.VALUE;
            Node nodeNextSmaller = treeBidiMap.nextSmaller(treeBidiMap.lookup(v, dataElement), dataElement);
            if (nodeNextSmaller == null) {
                return null;
            }
            return (V) nodeNextSmaller.getValue();
        }

        @Override // org.apache.commons.collections4.BidiMap, java.util.Map, org.apache.commons.collections4.Put
        public K put(V v, K k) {
            K k2 = (K) get((Object) v);
            TreeBidiMap.this.doPut(k, v);
            return k2;
        }

        @Override // java.util.Map, org.apache.commons.collections4.Get
        public K remove(Object obj) {
            return (K) TreeBidiMap.this.removeValue(obj);
        }

        @Override // org.apache.commons.collections4.BidiMap
        public V removeValue(Object obj) {
            return (V) TreeBidiMap.this.remove(obj);
        }

        @Override // org.apache.commons.collections4.BidiMap, java.util.Map, org.apache.commons.collections4.Get
        public Set<K> values() {
            if (this.inverseValuesSet == null) {
                this.inverseValuesSet = new KeyView(DataElement.VALUE);
            }
            return this.inverseValuesSet;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class InverseEntryView extends TreeBidiMap<K, V>.AbstractView<Map.Entry<V, K>> {
        public InverseEntryView() {
            super(DataElement.VALUE);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node nodeLookupValue = TreeBidiMap.this.lookupValue(entry.getKey());
            return nodeLookupValue != null && Objects.equals(nodeLookupValue.getKey(), value);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<V, K>> iterator() {
            return new InverseViewMapEntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            Object value = entry.getValue();
            Node nodeLookupValue = TreeBidiMap.this.lookupValue(entry.getKey());
            if (nodeLookupValue == null || !Objects.equals(nodeLookupValue.getKey(), value)) {
                return false;
            }
            TreeBidiMap.this.doRedBlackDelete(nodeLookupValue);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class InverseViewMapEntryIterator extends TreeBidiMap<K, V>.AbstractViewIterator implements OrderedIterator<Map.Entry<V, K>> {
        public InverseViewMapEntryIterator() {
            super(DataElement.VALUE);
        }

        private Map.Entry<V, K> createEntry(Node<K, V> node) {
            return new UnmodifiableMapEntry(node.getValue(), node.getKey());
        }

        @Override // java.util.Iterator
        public Map.Entry<V, K> next() {
            return createEntry(navigateNext());
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public Map.Entry<V, K> previous() {
            return createEntry(navigatePrevious());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class InverseViewMapIterator extends TreeBidiMap<K, V>.AbstractViewIterator implements OrderedMapIterator<V, K> {
        public InverseViewMapIterator(DataElement dataElement) {
            super(dataElement);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getKey() {
            Node<K, V> node = this.lastReturnedNode;
            if (node != null) {
                return (V) node.getValue();
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getValue() {
            Node<K, V> node = this.lastReturnedNode;
            if (node != null) {
                return (K) node.getKey();
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public V next() {
            return (V) navigateNext().getValue();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public V previous() {
            return (V) navigatePrevious().getValue();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K setValue(K k) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class KeyView extends TreeBidiMap<K, V>.AbstractView<K> {
        public KeyView(DataElement dataElement) {
            super(dataElement);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TreeBidiMap.checkNonNullComparable(obj, DataElement.KEY);
            return TreeBidiMap.this.lookupKey(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<K> iterator() {
            return new ViewMapIterator(this.orderType);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return TreeBidiMap.this.doRemoveKey(obj) != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Node<K extends Comparable<K>, V extends Comparable<V>> implements Map.Entry<K, V>, KeyValue<K, V> {
        private int hashCodeValue;
        private final K key;
        private final V value;
        private final Node<K, V>[] leftNode = new Node[2];
        private final Node<K, V>[] rightNode = new Node[2];
        private final Node<K, V>[] parentNode = new Node[2];
        private final boolean[] blackColor = {true, true};
        private boolean calculatedHashCode = false;

        public Node(K k, V v) {
            this.key = k;
            this.value = v;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void copyColor(Node<K, V> node, DataElement dataElement) {
            this.blackColor[dataElement.ordinal()] = node.blackColor[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Object getData(DataElement dataElement) {
            int iOrdinal = dataElement.ordinal();
            if (iOrdinal == 0) {
                return getKey();
            }
            if (iOrdinal == 1) {
                return getValue();
            }
            throw new IllegalArgumentException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node<K, V> getLeft(DataElement dataElement) {
            return this.leftNode[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node<K, V> getParent(DataElement dataElement) {
            return this.parentNode[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Node<K, V> getRight(DataElement dataElement) {
            return this.rightNode[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isBlack(DataElement dataElement) {
            return this.blackColor[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isLeftChild(DataElement dataElement) {
            return this.parentNode[dataElement.ordinal()] != null && this.parentNode[dataElement.ordinal()].leftNode[dataElement.ordinal()] == this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isRed(DataElement dataElement) {
            return !this.blackColor[dataElement.ordinal()];
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isRightChild(DataElement dataElement) {
            return this.parentNode[dataElement.ordinal()] != null && this.parentNode[dataElement.ordinal()].rightNode[dataElement.ordinal()] == this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBlack(DataElement dataElement) {
            this.blackColor[dataElement.ordinal()] = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLeft(Node<K, V> node, DataElement dataElement) {
            this.leftNode[dataElement.ordinal()] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setParent(Node<K, V> node, DataElement dataElement) {
            this.parentNode[dataElement.ordinal()] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRed(DataElement dataElement) {
            this.blackColor[dataElement.ordinal()] = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRight(Node<K, V> node, DataElement dataElement) {
            this.rightNode[dataElement.ordinal()] = node;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void swapColors(Node<K, V> node, DataElement dataElement) {
            boolean[] zArr = this.blackColor;
            int iOrdinal = dataElement.ordinal();
            zArr[iOrdinal] = zArr[iOrdinal] ^ node.blackColor[dataElement.ordinal()];
            boolean[] zArr2 = node.blackColor;
            int iOrdinal2 = dataElement.ordinal();
            zArr2[iOrdinal2] = zArr2[iOrdinal2] ^ this.blackColor[dataElement.ordinal()];
            boolean[] zArr3 = this.blackColor;
            int iOrdinal3 = dataElement.ordinal();
            zArr3[iOrdinal3] = node.blackColor[dataElement.ordinal()] ^ zArr3[iOrdinal3];
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return Objects.equals(getKey(), entry.getKey()) && Objects.equals(getValue(), entry.getValue());
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            if (!this.calculatedHashCode) {
                this.hashCodeValue = getKey().hashCode() ^ getValue().hashCode();
                this.calculatedHashCode = true;
            }
            return this.hashCodeValue;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public K getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
        public V getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException("Map.Entry.setValue is not supported");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class ValueView extends TreeBidiMap<K, V>.AbstractView<V> {
        public ValueView(DataElement dataElement) {
            super(dataElement);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            TreeBidiMap.checkNonNullComparable(obj, DataElement.VALUE);
            return TreeBidiMap.this.lookupValue(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<V> iterator() {
            return new InverseViewMapIterator(this.orderType);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return TreeBidiMap.this.doRemoveValue(obj) != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class ViewMapEntryIterator extends TreeBidiMap<K, V>.AbstractViewIterator implements OrderedIterator<Map.Entry<K, V>> {
        public ViewMapEntryIterator() {
            super(DataElement.KEY);
        }

        @Override // java.util.Iterator
        public Map.Entry<K, V> next() {
            return navigateNext();
        }

        @Override // org.apache.commons.collections4.OrderedIterator
        public Map.Entry<K, V> previous() {
            return navigatePrevious();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public final class ViewMapIterator extends TreeBidiMap<K, V>.AbstractViewIterator implements OrderedMapIterator<K, V> {
        public ViewMapIterator(DataElement dataElement) {
            super(dataElement);
        }

        @Override // org.apache.commons.collections4.MapIterator
        public K getKey() {
            Node<K, V> node = this.lastReturnedNode;
            if (node != null) {
                return (K) node.getKey();
            }
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V getValue() {
            Node<K, V> node = this.lastReturnedNode;
            if (node != null) {
                return (V) node.getValue();
            }
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }

        @Override // org.apache.commons.collections4.MapIterator, java.util.Iterator
        public K next() {
            return (K) navigateNext().getKey();
        }

        @Override // org.apache.commons.collections4.OrderedMapIterator, org.apache.commons.collections4.OrderedIterator
        public K previous() {
            return (K) navigatePrevious().getKey();
        }

        @Override // org.apache.commons.collections4.MapIterator
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }
    }

    public TreeBidiMap() {
        this.rootNode = new Node[2];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkKey(Object obj) {
        checkNonNullComparable(obj, DataElement.KEY);
    }

    private static void checkKeyAndValue(Object obj, Object obj2) {
        checkKey(obj);
        checkValue(obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void checkNonNullComparable(Object obj, DataElement dataElement) {
        Objects.requireNonNull(obj, Objects.toString(dataElement));
        if (obj instanceof Comparable) {
            return;
        }
        throw new ClassCastException(dataElement + " must be Comparable");
    }

    private static void checkValue(Object obj) {
        checkNonNullComparable(obj, DataElement.VALUE);
    }

    private static <T extends Comparable<T>> int compare(T t, T t2) {
        return t.compareTo(t2);
    }

    private void copyColor(Node<K, V> node, Node<K, V> node2, DataElement dataElement) {
        if (node2 != null) {
            if (node == null) {
                node2.setBlack(dataElement);
            } else {
                node2.copyColor(node, dataElement);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean doEquals(Object obj, DataElement dataElement) {
        MapIterator<?, ?> mapIterator;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (map.size() != size()) {
            return false;
        }
        if (this.nodeCount > 0) {
            try {
                mapIterator = getMapIterator(dataElement);
            } catch (ClassCastException | NullPointerException unused) {
            }
            while (mapIterator.hasNext()) {
                if (!mapIterator.getValue().equals(map.get(mapIterator.next()))) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int doHashCode(DataElement dataElement) {
        int iHashCode = 0;
        if (this.nodeCount > 0) {
            MapIterator<?, ?> mapIterator = getMapIterator(dataElement);
            while (mapIterator.hasNext()) {
                iHashCode += mapIterator.next().hashCode() ^ mapIterator.getValue().hashCode();
            }
        }
        return iHashCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPut(K k, V v) {
        checkKeyAndValue(k, v);
        doRemoveKey(k);
        doRemoveValue(v);
        Node<K, V>[] nodeArr = this.rootNode;
        DataElement dataElement = DataElement.KEY;
        Node<K, V> left = nodeArr[dataElement.ordinal()];
        if (left == null) {
            Node<K, V> node = new Node<>(k, v);
            this.rootNode[dataElement.ordinal()] = node;
            this.rootNode[DataElement.VALUE.ordinal()] = node;
            grow();
            return;
        }
        while (true) {
            int iCompare = compare(k, left.getKey());
            if (iCompare == 0) {
                throw new IllegalArgumentException("Cannot store a duplicate key (\"" + k + "\") in this Map");
            }
            if (iCompare < 0) {
                DataElement dataElement2 = DataElement.KEY;
                if (left.getLeft(dataElement2) == null) {
                    Node<K, V> node2 = new Node<>(k, v);
                    insertValue(node2);
                    left.setLeft(node2, dataElement2);
                    node2.setParent(left, dataElement2);
                    doRedBlackInsert(node2, dataElement2);
                    grow();
                    return;
                }
                left = left.getLeft(dataElement2);
            } else {
                DataElement dataElement3 = DataElement.KEY;
                if (left.getRight(dataElement3) == null) {
                    Node<K, V> node3 = new Node<>(k, v);
                    insertValue(node3);
                    left.setRight(node3, dataElement3);
                    node3.setParent(left, dataElement3);
                    doRedBlackInsert(node3, dataElement3);
                    grow();
                    return;
                }
                left = left.getRight(dataElement3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doRedBlackDelete(Node<K, V> node) {
        for (DataElement dataElement : DataElement.values()) {
            if (node.getLeft(dataElement) != null && node.getRight(dataElement) != null) {
                swapPosition(nextGreater(node, dataElement), node, dataElement);
            }
            Node<K, V> left = node.getLeft(dataElement) != null ? node.getLeft(dataElement) : node.getRight(dataElement);
            if (left != null) {
                left.setParent(node.getParent(dataElement), dataElement);
                if (node.getParent(dataElement) == null) {
                    this.rootNode[dataElement.ordinal()] = left;
                } else if (node == node.getParent(dataElement).getLeft(dataElement)) {
                    node.getParent(dataElement).setLeft(left, dataElement);
                } else {
                    node.getParent(dataElement).setRight(left, dataElement);
                }
                node.setLeft(null, dataElement);
                node.setRight(null, dataElement);
                node.setParent(null, dataElement);
                if (isBlack(node, dataElement)) {
                    doRedBlackDeleteFixup(left, dataElement);
                }
            } else if (node.getParent(dataElement) == null) {
                this.rootNode[dataElement.ordinal()] = null;
            } else {
                if (isBlack(node, dataElement)) {
                    doRedBlackDeleteFixup(node, dataElement);
                }
                if (node.getParent(dataElement) != null) {
                    if (node == node.getParent(dataElement).getLeft(dataElement)) {
                        node.getParent(dataElement).setLeft(null, dataElement);
                    } else {
                        node.getParent(dataElement).setRight(null, dataElement);
                    }
                    node.setParent(null, dataElement);
                }
            }
        }
        shrink();
    }

    private void doRedBlackDeleteFixup(Node<K, V> node, DataElement dataElement) {
        while (node != this.rootNode[dataElement.ordinal()] && isBlack(node, dataElement)) {
            if (node.isLeftChild(dataElement)) {
                Node<K, V> rightChild = getRightChild(getParent(node, dataElement), dataElement);
                if (isRed(rightChild, dataElement)) {
                    makeBlack(rightChild, dataElement);
                    makeRed(getParent(node, dataElement), dataElement);
                    rotateLeft(getParent(node, dataElement), dataElement);
                    rightChild = getRightChild(getParent(node, dataElement), dataElement);
                }
                if (isBlack(getLeftChild(rightChild, dataElement), dataElement) && isBlack(getRightChild(rightChild, dataElement), dataElement)) {
                    makeRed(rightChild, dataElement);
                    node = getParent(node, dataElement);
                } else {
                    if (isBlack(getRightChild(rightChild, dataElement), dataElement)) {
                        makeBlack(getLeftChild(rightChild, dataElement), dataElement);
                        makeRed(rightChild, dataElement);
                        rotateRight(rightChild, dataElement);
                        rightChild = getRightChild(getParent(node, dataElement), dataElement);
                    }
                    copyColor(getParent(node, dataElement), rightChild, dataElement);
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeBlack(getRightChild(rightChild, dataElement), dataElement);
                    rotateLeft(getParent(node, dataElement), dataElement);
                    node = this.rootNode[dataElement.ordinal()];
                }
            } else {
                Node<K, V> leftChild = getLeftChild(getParent(node, dataElement), dataElement);
                if (isRed(leftChild, dataElement)) {
                    makeBlack(leftChild, dataElement);
                    makeRed(getParent(node, dataElement), dataElement);
                    rotateRight(getParent(node, dataElement), dataElement);
                    leftChild = getLeftChild(getParent(node, dataElement), dataElement);
                }
                if (isBlack(getRightChild(leftChild, dataElement), dataElement) && isBlack(getLeftChild(leftChild, dataElement), dataElement)) {
                    makeRed(leftChild, dataElement);
                    node = getParent(node, dataElement);
                } else {
                    if (isBlack(getLeftChild(leftChild, dataElement), dataElement)) {
                        makeBlack(getRightChild(leftChild, dataElement), dataElement);
                        makeRed(leftChild, dataElement);
                        rotateLeft(leftChild, dataElement);
                        leftChild = getLeftChild(getParent(node, dataElement), dataElement);
                    }
                    copyColor(getParent(node, dataElement), leftChild, dataElement);
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeBlack(getLeftChild(leftChild, dataElement), dataElement);
                    rotateRight(getParent(node, dataElement), dataElement);
                    node = this.rootNode[dataElement.ordinal()];
                }
            }
        }
        makeBlack(node, dataElement);
    }

    private void doRedBlackInsert(Node<K, V> node, DataElement dataElement) {
        makeRed(node, dataElement);
        while (node != null && node != this.rootNode[dataElement.ordinal()] && isRed(node.getParent(dataElement), dataElement)) {
            if (node.isLeftChild(dataElement)) {
                Node<K, V> rightChild = getRightChild(getGrandParent(node, dataElement), dataElement);
                if (isRed(rightChild, dataElement)) {
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeBlack(rightChild, dataElement);
                    makeRed(getGrandParent(node, dataElement), dataElement);
                    node = getGrandParent(node, dataElement);
                } else {
                    if (node.isRightChild(dataElement)) {
                        node = getParent(node, dataElement);
                        rotateLeft(node, dataElement);
                    }
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeRed(getGrandParent(node, dataElement), dataElement);
                    if (getGrandParent(node, dataElement) != null) {
                        rotateRight(getGrandParent(node, dataElement), dataElement);
                    }
                }
            } else {
                Node<K, V> leftChild = getLeftChild(getGrandParent(node, dataElement), dataElement);
                if (isRed(leftChild, dataElement)) {
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeBlack(leftChild, dataElement);
                    makeRed(getGrandParent(node, dataElement), dataElement);
                    node = getGrandParent(node, dataElement);
                } else {
                    if (node.isLeftChild(dataElement)) {
                        node = getParent(node, dataElement);
                        rotateRight(node, dataElement);
                    }
                    makeBlack(getParent(node, dataElement), dataElement);
                    makeRed(getGrandParent(node, dataElement), dataElement);
                    if (getGrandParent(node, dataElement) != null) {
                        rotateLeft(getGrandParent(node, dataElement), dataElement);
                    }
                }
            }
        }
        makeBlack(this.rootNode[dataElement.ordinal()], dataElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public V doRemoveKey(Object obj) {
        Node<K, V> nodeLookupKey = lookupKey(obj);
        if (nodeLookupKey == null) {
            return null;
        }
        doRedBlackDelete(nodeLookupKey);
        return (V) nodeLookupKey.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public K doRemoveValue(Object obj) {
        Node<K, V> nodeLookupValue = lookupValue(obj);
        if (nodeLookupValue == null) {
            return null;
        }
        doRedBlackDelete(nodeLookupValue);
        return (K) nodeLookupValue.getKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String doToString(DataElement dataElement) {
        int i = this.nodeCount;
        if (i == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 32);
        sb.append('{');
        MapIterator<?, ?> mapIterator = getMapIterator(dataElement);
        boolean zHasNext = mapIterator.hasNext();
        while (zHasNext) {
            Object next = mapIterator.next();
            Object value = mapIterator.getValue();
            if (next == this) {
                next = "(this Map)";
            }
            sb.append(next);
            sb.append('=');
            if (value == this) {
                value = "(this Map)";
            }
            sb.append(value);
            zHasNext = mapIterator.hasNext();
            if (zHasNext) {
                sb.append(SQLKeyword.COMMA);
            }
        }
        sb.append('}');
        return sb.toString();
    }

    private Node<K, V> getGrandParent(Node<K, V> node, DataElement dataElement) {
        return getParent(getParent(node, dataElement), dataElement);
    }

    private Node<K, V> getLeftChild(Node<K, V> node, DataElement dataElement) {
        if (node == null) {
            return null;
        }
        return node.getLeft(dataElement);
    }

    private MapIterator<?, ?> getMapIterator(DataElement dataElement) {
        int iOrdinal = dataElement.ordinal();
        if (iOrdinal == 0) {
            return new ViewMapIterator(DataElement.KEY);
        }
        if (iOrdinal == 1) {
            return new InverseViewMapIterator(DataElement.VALUE);
        }
        throw new IllegalArgumentException();
    }

    private Node<K, V> getParent(Node<K, V> node, DataElement dataElement) {
        if (node == null) {
            return null;
        }
        return node.getParent(dataElement);
    }

    private Node<K, V> getRightChild(Node<K, V> node, DataElement dataElement) {
        if (node == null) {
            return null;
        }
        return node.getRight(dataElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> greatestNode(Node<K, V> node, DataElement dataElement) {
        if (node != null) {
            while (node.getRight(dataElement) != null) {
                node = node.getRight(dataElement);
            }
        }
        return node;
    }

    private void grow() {
        modify();
        this.nodeCount++;
    }

    private void insertValue(Node<K, V> node) {
        Node<K, V> left = this.rootNode[DataElement.VALUE.ordinal()];
        while (true) {
            int iCompare = compare(node.getValue(), left.getValue());
            if (iCompare == 0) {
                throw new IllegalArgumentException(AbstractC1974b.m1320m(new StringBuilder("Cannot store a duplicate value (\""), node.getData(DataElement.VALUE), "\") in this Map"));
            }
            if (iCompare < 0) {
                DataElement dataElement = DataElement.VALUE;
                if (left.getLeft(dataElement) == null) {
                    left.setLeft(node, dataElement);
                    node.setParent(left, dataElement);
                    doRedBlackInsert(node, dataElement);
                    return;
                }
                left = left.getLeft(dataElement);
            } else {
                DataElement dataElement2 = DataElement.VALUE;
                if (left.getRight(dataElement2) == null) {
                    left.setRight(node, dataElement2);
                    node.setParent(left, dataElement2);
                    doRedBlackInsert(node, dataElement2);
                    return;
                }
                left = left.getRight(dataElement2);
            }
        }
    }

    private static boolean isBlack(Node<?, ?> node, DataElement dataElement) {
        return node == null || node.isBlack(dataElement);
    }

    private static boolean isRed(Node<?, ?> node, DataElement dataElement) {
        return node != null && node.isRed(dataElement);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> leastNode(Node<K, V> node, DataElement dataElement) {
        if (node != null) {
            while (node.getLeft(dataElement) != null) {
                node = node.getLeft(dataElement);
            }
        }
        return node;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T extends Comparable<T>> Node<K, V> lookup(Object obj, DataElement dataElement) {
        Node<K, V> left = this.rootNode[dataElement.ordinal()];
        while (left != null) {
            int iCompare = compare((Comparable) obj, (Comparable) left.getData(dataElement));
            if (iCompare == 0) {
                return left;
            }
            left = iCompare < 0 ? left.getLeft(dataElement) : left.getRight(dataElement);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> lookupKey(Object obj) {
        return lookup(obj, DataElement.KEY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> lookupValue(Object obj) {
        return lookup(obj, DataElement.VALUE);
    }

    private static void makeBlack(Node<?, ?> node, DataElement dataElement) {
        if (node != null) {
            node.setBlack(dataElement);
        }
    }

    private static void makeRed(Node<?, ?> node, DataElement dataElement) {
        if (node != null) {
            node.setRed(dataElement);
        }
    }

    private void modify() {
        this.modifications++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> nextGreater(Node<K, V> node, DataElement dataElement) {
        if (node == null) {
            return null;
        }
        if (node.getRight(dataElement) != null) {
            return leastNode(node.getRight(dataElement), dataElement);
        }
        Node<K, V> parent = node.getParent(dataElement);
        while (true) {
            Node<K, V> node2 = parent;
            Node<K, V> node3 = node;
            node = node2;
            if (node == null || node3 != node.getRight(dataElement)) {
                break;
            }
            parent = node.getParent(dataElement);
        }
        return node;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Node<K, V> nextSmaller(Node<K, V> node, DataElement dataElement) {
        if (node == null) {
            return null;
        }
        if (node.getLeft(dataElement) != null) {
            return greatestNode(node.getLeft(dataElement), dataElement);
        }
        Node<K, V> parent = node.getParent(dataElement);
        while (true) {
            Node<K, V> node2 = parent;
            Node<K, V> node3 = node;
            node = node2;
            if (node == null || node3 != node.getLeft(dataElement)) {
                break;
            }
            parent = node.getParent(dataElement);
        }
        return node;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.rootNode = new Node[2];
        int i = objectInputStream.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            put((Comparable) objectInputStream.readObject(), (Comparable) objectInputStream.readObject());
        }
    }

    private void rotateLeft(Node<K, V> node, DataElement dataElement) {
        Node<K, V> right = node.getRight(dataElement);
        node.setRight(right.getLeft(dataElement), dataElement);
        if (right.getLeft(dataElement) != null) {
            right.getLeft(dataElement).setParent(node, dataElement);
        }
        right.setParent(node.getParent(dataElement), dataElement);
        if (node.getParent(dataElement) == null) {
            this.rootNode[dataElement.ordinal()] = right;
        } else if (node.getParent(dataElement).getLeft(dataElement) == node) {
            node.getParent(dataElement).setLeft(right, dataElement);
        } else {
            node.getParent(dataElement).setRight(right, dataElement);
        }
        right.setLeft(node, dataElement);
        node.setParent(right, dataElement);
    }

    private void rotateRight(Node<K, V> node, DataElement dataElement) {
        Node<K, V> left = node.getLeft(dataElement);
        node.setLeft(left.getRight(dataElement), dataElement);
        if (left.getRight(dataElement) != null) {
            left.getRight(dataElement).setParent(node, dataElement);
        }
        left.setParent(node.getParent(dataElement), dataElement);
        if (node.getParent(dataElement) == null) {
            this.rootNode[dataElement.ordinal()] = left;
        } else if (node.getParent(dataElement).getRight(dataElement) == node) {
            node.getParent(dataElement).setRight(left, dataElement);
        } else {
            node.getParent(dataElement).setLeft(left, dataElement);
        }
        left.setRight(node, dataElement);
        node.setParent(left, dataElement);
    }

    private void shrink() {
        modify();
        this.nodeCount--;
    }

    private void swapPosition(Node<K, V> node, Node<K, V> node2, DataElement dataElement) {
        Node<K, V> parent = node.getParent(dataElement);
        Node left = node.getLeft(dataElement);
        Node right = node.getRight(dataElement);
        Node<K, V> parent2 = node2.getParent(dataElement);
        Node left2 = node2.getLeft(dataElement);
        Node right2 = node2.getRight(dataElement);
        boolean z = false;
        boolean z2 = node.getParent(dataElement) != null && node == node.getParent(dataElement).getLeft(dataElement);
        if (node2.getParent(dataElement) != null && node2 == node2.getParent(dataElement).getLeft(dataElement)) {
            z = true;
        }
        if (node == parent2) {
            node.setParent(node2, dataElement);
            if (z) {
                node2.setLeft(node, dataElement);
                node2.setRight(right, dataElement);
            } else {
                node2.setRight(node, dataElement);
                node2.setLeft(left, dataElement);
            }
        } else {
            node.setParent(parent2, dataElement);
            if (parent2 != null) {
                if (z) {
                    parent2.setLeft(node, dataElement);
                } else {
                    parent2.setRight(node, dataElement);
                }
            }
            node2.setLeft(left, dataElement);
            node2.setRight(right, dataElement);
        }
        if (node2 == parent) {
            node2.setParent(node, dataElement);
            if (z2) {
                node.setLeft(node2, dataElement);
                node.setRight(right2, dataElement);
            } else {
                node.setRight(node2, dataElement);
                node.setLeft(left2, dataElement);
            }
        } else {
            node2.setParent(parent, dataElement);
            if (parent != null) {
                if (z2) {
                    parent.setLeft(node2, dataElement);
                } else {
                    parent.setRight(node2, dataElement);
                }
            }
            node.setLeft(left2, dataElement);
            node.setRight(right2, dataElement);
        }
        if (node.getLeft(dataElement) != null) {
            node.getLeft(dataElement).setParent(node, dataElement);
        }
        if (node.getRight(dataElement) != null) {
            node.getRight(dataElement).setParent(node, dataElement);
        }
        if (node2.getLeft(dataElement) != null) {
            node2.getLeft(dataElement).setParent(node2, dataElement);
        }
        if (node2.getRight(dataElement) != null) {
            node2.getRight(dataElement).setParent(node2, dataElement);
        }
        node.swapColors(node2, dataElement);
        if (this.rootNode[dataElement.ordinal()] == node) {
            this.rootNode[dataElement.ordinal()] = node2;
        } else if (this.rootNode[dataElement.ordinal()] == node2) {
            this.rootNode[dataElement.ordinal()] = node;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(size());
        for (Map.Entry<K, V> entry : entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void clear() {
        modify();
        this.nodeCount = 0;
        this.rootNode[DataElement.KEY.ordinal()] = null;
        this.rootNode[DataElement.VALUE.ordinal()] = null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsKey(Object obj) {
        checkKey(obj);
        return lookupKey(obj) != null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean containsValue(Object obj) {
        checkValue(obj);
        return lookupValue(obj) != null;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.entrySet == null) {
            this.entrySet = new EntryView();
        }
        return this.entrySet;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return doEquals(obj, DataElement.KEY);
    }

    @Override // java.util.Map
    public int hashCode() {
        return doHashCode(DataElement.KEY);
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public boolean isEmpty() {
        return this.nodeCount == 0;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public Set<K> keySet() {
        if (this.keySet == null) {
            this.keySet = new KeyView(DataElement.KEY);
        }
        return this.keySet;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Put
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put((Comparable) entry.getKey(), (Comparable) entry.getValue());
        }
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public int size() {
        return this.nodeCount;
    }

    public String toString() {
        return doToString(DataElement.KEY);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K firstKey() {
        if (this.nodeCount == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        Node<K, V>[] nodeArr = this.rootNode;
        DataElement dataElement = DataElement.KEY;
        return (K) leastNode(nodeArr[dataElement.ordinal()], dataElement).getKey();
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V get(Object obj) {
        checkKey(obj);
        Node<K, V> nodeLookupKey = lookupKey(obj);
        if (nodeLookupKey == null) {
            return null;
        }
        return (V) nodeLookupKey.getValue();
    }

    @Override // org.apache.commons.collections4.BidiMap
    public K getKey(Object obj) {
        checkValue(obj);
        Node<K, V> nodeLookupValue = lookupValue(obj);
        if (nodeLookupValue == null) {
            return null;
        }
        return (K) nodeLookupValue.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedBidiMap, org.apache.commons.collections4.BidiMap
    public OrderedBidiMap<V, K> inverseBidiMap() {
        if (this.inverse == null) {
            this.inverse = new Inverse();
        }
        return this.inverse;
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K lastKey() {
        if (this.nodeCount == 0) {
            throw new NoSuchElementException("Map is empty");
        }
        Node<K, V>[] nodeArr = this.rootNode;
        DataElement dataElement = DataElement.KEY;
        return (K) greatestNode(nodeArr[dataElement.ordinal()], dataElement).getKey();
    }

    @Override // org.apache.commons.collections4.IterableGet
    public OrderedMapIterator<K, V> mapIterator() {
        return isEmpty() ? EmptyOrderedMapIterator.emptyOrderedMapIterator() : new ViewMapIterator(DataElement.KEY);
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K nextKey(K k) {
        checkKey(k);
        Node<K, V> nodeNextGreater = nextGreater(lookupKey(k), DataElement.KEY);
        if (nodeNextGreater == null) {
            return null;
        }
        return (K) nodeNextGreater.getKey();
    }

    @Override // org.apache.commons.collections4.OrderedMap
    public K previousKey(K k) {
        checkKey(k);
        Node<K, V> nodeNextSmaller = nextSmaller(lookupKey(k), DataElement.KEY);
        if (nodeNextSmaller == null) {
            return null;
        }
        return (K) nodeNextSmaller.getKey();
    }

    @Override // org.apache.commons.collections4.BidiMap, java.util.Map, org.apache.commons.collections4.Put
    public V put(K k, V v) {
        V v4 = (V) get((Object) k);
        doPut(k, v);
        return v4;
    }

    @Override // java.util.Map, org.apache.commons.collections4.Get
    public V remove(Object obj) {
        return (V) doRemoveKey(obj);
    }

    @Override // org.apache.commons.collections4.BidiMap
    public K removeValue(Object obj) {
        return (K) doRemoveValue(obj);
    }

    @Override // org.apache.commons.collections4.BidiMap, java.util.Map, org.apache.commons.collections4.Get
    public Set<V> values() {
        if (this.valuesSet == null) {
            this.valuesSet = new ValueView(DataElement.KEY);
        }
        return this.valuesSet;
    }

    public TreeBidiMap(Map<? extends K, ? extends V> map) {
        this();
        putAll(map);
    }
}
