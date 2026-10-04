package org.apache.poi.javax.imageio.spi;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class DigraphNode implements Cloneable, Serializable {
    protected Object data;
    protected Set outNodes = new HashSet();
    protected int inDegree = 0;
    private Set inNodes = new HashSet();

    public DigraphNode(Object obj) {
        this.data = obj;
    }

    private void decrementInDegree() {
        this.inDegree--;
    }

    private void incrementInDegree() {
        this.inDegree++;
    }

    public boolean addEdge(DigraphNode digraphNode) {
        if (this.outNodes.contains(digraphNode)) {
            return false;
        }
        this.outNodes.add(digraphNode);
        digraphNode.inNodes.add(this);
        digraphNode.incrementInDegree();
        return true;
    }

    public void dispose() {
        for (Object obj : this.inNodes.toArray()) {
            ((DigraphNode) obj).removeEdge(this);
        }
        for (Object obj2 : this.outNodes.toArray()) {
            removeEdge((DigraphNode) obj2);
        }
    }

    public Object getData() {
        return this.data;
    }

    public int getInDegree() {
        return this.inDegree;
    }

    public Iterator getOutNodes() {
        return this.outNodes.iterator();
    }

    public boolean hasEdge(DigraphNode digraphNode) {
        return this.outNodes.contains(digraphNode);
    }

    public boolean removeEdge(DigraphNode digraphNode) {
        if (!this.outNodes.contains(digraphNode)) {
            return false;
        }
        this.outNodes.remove(digraphNode);
        digraphNode.inNodes.remove(this);
        digraphNode.decrementInDegree();
        return true;
    }
}
