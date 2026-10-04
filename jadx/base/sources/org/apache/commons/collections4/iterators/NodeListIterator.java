package org.apache.commons.collections4.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NodeListIterator implements Iterator<Node> {
    private int index;
    private final NodeList nodeList;

    public NodeListIterator(Node node) {
        Objects.requireNonNull(node, "node");
        this.nodeList = node.getChildNodes();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        NodeList nodeList = this.nodeList;
        return nodeList != null && this.index < nodeList.getLength();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method not supported for a NodeListIterator.");
    }

    @Override // java.util.Iterator
    public Node next() {
        NodeList nodeList = this.nodeList;
        if (nodeList == null || this.index >= nodeList.getLength()) {
            throw new NoSuchElementException("underlying nodeList has no more elements");
        }
        NodeList nodeList2 = this.nodeList;
        int i = this.index;
        this.index = i + 1;
        return nodeList2.item(i);
    }

    public NodeListIterator(NodeList nodeList) {
        Objects.requireNonNull(nodeList, "nodeList");
        this.nodeList = nodeList;
    }
}
