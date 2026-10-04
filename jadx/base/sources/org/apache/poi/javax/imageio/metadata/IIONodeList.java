package org.apache.poi.javax.imageio.metadata;

import java.util.List;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class IIONodeList implements NodeList {
    List nodes;

    public IIONodeList(List list) {
        this.nodes = list;
    }

    @Override // org.w3c.dom.NodeList
    public int getLength() {
        return this.nodes.size();
    }

    @Override // org.w3c.dom.NodeList
    public Node item(int i) {
        if (i < 0 || i > this.nodes.size()) {
            return null;
        }
        return (Node) this.nodes.get(i);
    }
}
