package org.jsoup.select;

import org.jsoup.nodes.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NodeTraversor {
    private NodeVisitor visitor;

    public NodeTraversor(NodeVisitor nodeVisitor) {
        this.visitor = nodeVisitor;
    }

    public void traverse(Node node) {
        Node nodeChildNode = node;
        int i = 0;
        while (nodeChildNode != null) {
            this.visitor.head(nodeChildNode, i);
            if (nodeChildNode.childNodeSize() > 0) {
                nodeChildNode = nodeChildNode.childNode(0);
                i++;
            } else {
                while (nodeChildNode.nextSibling() == null && i > 0) {
                    this.visitor.tail(nodeChildNode, i);
                    nodeChildNode = nodeChildNode.parentNode();
                    i--;
                }
                this.visitor.tail(nodeChildNode, i);
                if (nodeChildNode == node) {
                    return;
                } else {
                    nodeChildNode = nodeChildNode.nextSibling();
                }
            }
        }
    }
}
