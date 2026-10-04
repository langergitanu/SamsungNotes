package org.apache.poi.javax.imageio.metadata;

import org.apache.poi.javax.imageio.IIOException;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IIOInvalidTreeException extends IIOException {
    protected Node offendingNode;

    public IIOInvalidTreeException(String str, Node node) {
        super(str);
        this.offendingNode = node;
    }

    public Node getOffendingNode() {
        return this.offendingNode;
    }

    public IIOInvalidTreeException(String str, Throwable th, Node node) {
        super(str, th);
        this.offendingNode = node;
    }
}
