package org.apache.poi.javax.imageio.spi;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class PartialOrderIterator implements Iterator {
    LinkedList zeroList = new LinkedList();
    Map inDegrees = new HashMap();

    public PartialOrderIterator(Iterator it) {
        while (it.hasNext()) {
            DigraphNode digraphNode = (DigraphNode) it.next();
            int inDegree = digraphNode.getInDegree();
            this.inDegrees.put(digraphNode, new Integer(inDegree));
            if (inDegree == 0) {
                this.zeroList.add(digraphNode);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.zeroList.isEmpty();
    }

    @Override // java.util.Iterator
    public Object next() {
        DigraphNode digraphNode = (DigraphNode) this.zeroList.removeFirst();
        Iterator outNodes = digraphNode.getOutNodes();
        while (outNodes.hasNext()) {
            DigraphNode digraphNode2 = (DigraphNode) outNodes.next();
            int iIntValue = ((Integer) this.inDegrees.get(digraphNode2)).intValue() - 1;
            this.inDegrees.put(digraphNode2, new Integer(iIntValue));
            if (iIntValue == 0) {
                this.zeroList.add(digraphNode2);
            }
        }
        return digraphNode.getData();
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
