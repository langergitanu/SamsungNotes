package org.apache.poi.javax.imageio.spi;

import java.util.AbstractSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class PartiallyOrderedSet extends AbstractSet {
    private Set nodes;
    private Map poNodes;

    public PartiallyOrderedSet() {
        HashMap map = new HashMap();
        this.poNodes = map;
        this.nodes = map.keySet();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        if (this.nodes.contains(obj)) {
            return false;
        }
        this.poNodes.put(obj, new DigraphNode(obj));
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.poNodes.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return this.nodes.contains(obj);
    }

    public boolean hasOrdering(Object obj, Object obj2) {
        return ((DigraphNode) this.poNodes.get(obj)).hasEdge((DigraphNode) this.poNodes.get(obj2));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new PartialOrderIterator(this.poNodes.values().iterator());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        DigraphNode digraphNode = (DigraphNode) this.poNodes.get(obj);
        if (digraphNode == null) {
            return false;
        }
        this.poNodes.remove(obj);
        digraphNode.dispose();
        return true;
    }

    public boolean setOrdering(Object obj, Object obj2) {
        DigraphNode digraphNode = (DigraphNode) this.poNodes.get(obj);
        DigraphNode digraphNode2 = (DigraphNode) this.poNodes.get(obj2);
        digraphNode2.removeEdge(digraphNode);
        return digraphNode.addEdge(digraphNode2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.nodes.size();
    }

    public boolean unsetOrdering(Object obj, Object obj2) {
        DigraphNode digraphNode = (DigraphNode) this.poNodes.get(obj);
        DigraphNode digraphNode2 = (DigraphNode) this.poNodes.get(obj2);
        return digraphNode.removeEdge(digraphNode2) || digraphNode2.removeEdge(digraphNode);
    }
}
