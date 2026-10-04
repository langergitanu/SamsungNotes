package org.apache.poi.javax.imageio.metadata;

import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.TypeInfo;
import org.w3c.dom.UserDataHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IIOMetadataNode implements Element, NodeList {
    private List attributes;
    private IIOMetadataNode firstChild;
    private IIOMetadataNode lastChild;
    private IIOMetadataNode nextSibling;
    private String nodeName;
    private String nodeValue;
    private int numChildren;
    private IIOMetadataNode parent;
    private IIOMetadataNode previousSibling;
    private Object userObject;

    public IIOMetadataNode() {
        this.nodeName = null;
        this.nodeValue = null;
        this.userObject = null;
        this.parent = null;
        this.numChildren = 0;
        this.firstChild = null;
        this.lastChild = null;
        this.nextSibling = null;
        this.previousSibling = null;
        this.attributes = new ArrayList();
    }

    private void checkNode(Node node) {
        if (node != null && !(node instanceof IIOMetadataNode)) {
            throw new IIODOMException((short) 4, "Node not an IIOMetadataNode!");
        }
    }

    @Override // org.w3c.dom.Node
    public Node appendChild(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("newChild == null!");
        }
        checkNode(node);
        return insertBefore(node, null);
    }

    @Override // org.w3c.dom.Node
    public Node cloneNode(boolean z) {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(this.nodeName);
        iIOMetadataNode.setUserObject(getUserObject());
        if (z) {
            for (IIOMetadataNode iIOMetadataNode2 = this.firstChild; iIOMetadataNode2 != null; iIOMetadataNode2 = iIOMetadataNode2.nextSibling) {
                iIOMetadataNode.appendChild(iIOMetadataNode2.cloneNode(true));
            }
        }
        return iIOMetadataNode;
    }

    @Override // org.w3c.dom.Node
    public short compareDocumentPosition(Node node) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Element
    public String getAttribute(String str) {
        Attr attributeNode = getAttributeNode(str);
        return attributeNode == null ? "" : attributeNode.getValue();
    }

    @Override // org.w3c.dom.Element
    public String getAttributeNS(String str, String str2) {
        return getAttribute(str2);
    }

    @Override // org.w3c.dom.Element
    public Attr getAttributeNode(String str) {
        return (Attr) getAttributes().getNamedItem(str);
    }

    @Override // org.w3c.dom.Element
    public Attr getAttributeNodeNS(String str, String str2) {
        return getAttributeNode(str2);
    }

    @Override // org.w3c.dom.Node
    public NamedNodeMap getAttributes() {
        return new IIONamedNodeMap(this.attributes);
    }

    @Override // org.w3c.dom.Node
    public String getBaseURI() {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagName(String str) {
        ArrayList arrayList = new ArrayList();
        getElementsByTagName(str, arrayList);
        return new IIONodeList(arrayList);
    }

    @Override // org.w3c.dom.Element
    public NodeList getElementsByTagNameNS(String str, String str2) {
        return getElementsByTagName(str2);
    }

    @Override // org.w3c.dom.Node
    public Object getFeature(String str, String str2) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Node
    public Node getFirstChild() {
        return this.firstChild;
    }

    @Override // org.w3c.dom.Node
    public Node getLastChild() {
        return this.lastChild;
    }

    @Override // org.w3c.dom.NodeList
    public int getLength() {
        return this.numChildren;
    }

    @Override // org.w3c.dom.Node
    public String getLocalName() {
        return this.nodeName;
    }

    @Override // org.w3c.dom.Node
    public String getNamespaceURI() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getNextSibling() {
        return this.nextSibling;
    }

    @Override // org.w3c.dom.Node
    public String getNodeName() {
        return this.nodeName;
    }

    @Override // org.w3c.dom.Node
    public short getNodeType() {
        return (short) 1;
    }

    @Override // org.w3c.dom.Node
    public String getNodeValue() {
        return this.nodeValue;
    }

    @Override // org.w3c.dom.Node
    public Document getOwnerDocument() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getParentNode() {
        return this.parent;
    }

    @Override // org.w3c.dom.Node
    public String getPrefix() {
        return null;
    }

    @Override // org.w3c.dom.Node
    public Node getPreviousSibling() {
        return this.previousSibling;
    }

    @Override // org.w3c.dom.Element
    public TypeInfo getSchemaTypeInfo() {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Element
    public String getTagName() {
        return this.nodeName;
    }

    @Override // org.w3c.dom.Node
    public String getTextContent() {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Node
    public Object getUserData(String str) {
        throw new DOMException((short) 9, "Method not supported");
    }

    public Object getUserObject() {
        return this.userObject;
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttribute(String str) {
        return getAttributeNode(str) != null;
    }

    @Override // org.w3c.dom.Element
    public boolean hasAttributeNS(String str, String str2) {
        return hasAttribute(str2);
    }

    @Override // org.w3c.dom.Node
    public boolean hasAttributes() {
        return this.attributes.size() > 0;
    }

    @Override // org.w3c.dom.Node
    public boolean hasChildNodes() {
        return this.numChildren > 0;
    }

    @Override // org.w3c.dom.Node
    public Node insertBefore(Node node, Node node2) {
        IIOMetadataNode iIOMetadataNode;
        IIOMetadataNode iIOMetadataNode2;
        if (node == null) {
            throw new IllegalArgumentException("newChild == null!");
        }
        checkNode(node);
        checkNode(node2);
        IIOMetadataNode iIOMetadataNode3 = (IIOMetadataNode) node;
        IIOMetadataNode iIOMetadataNode4 = (IIOMetadataNode) node2;
        if (node2 == null) {
            iIOMetadataNode = this.lastChild;
            this.lastChild = iIOMetadataNode3;
            iIOMetadataNode2 = null;
        } else {
            iIOMetadataNode = iIOMetadataNode4.previousSibling;
            iIOMetadataNode2 = iIOMetadataNode4;
        }
        if (iIOMetadataNode != null) {
            iIOMetadataNode.nextSibling = iIOMetadataNode3;
        }
        if (iIOMetadataNode2 != null) {
            iIOMetadataNode2.previousSibling = iIOMetadataNode3;
        }
        iIOMetadataNode3.parent = this;
        iIOMetadataNode3.previousSibling = iIOMetadataNode;
        iIOMetadataNode3.nextSibling = iIOMetadataNode2;
        if (this.firstChild == iIOMetadataNode4) {
            this.firstChild = iIOMetadataNode3;
        }
        this.numChildren++;
        return iIOMetadataNode3;
    }

    @Override // org.w3c.dom.Node
    public boolean isDefaultNamespace(String str) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Node
    public boolean isEqualNode(Node node) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Node
    public boolean isSameNode(Node node) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Node
    public boolean isSupported(String str, String str2) {
        return false;
    }

    @Override // org.w3c.dom.NodeList
    public Node item(int i) {
        if (i < 0) {
            return null;
        }
        Node firstChild = getFirstChild();
        while (firstChild != null) {
            int i2 = i - 1;
            if (i <= 0) {
                break;
            }
            firstChild = firstChild.getNextSibling();
            i = i2;
        }
        return firstChild;
    }

    @Override // org.w3c.dom.Node
    public String lookupNamespaceURI(String str) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Node
    public String lookupPrefix(String str) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Element
    public void removeAttribute(String str) {
        removeAttribute(str, true);
    }

    @Override // org.w3c.dom.Element
    public void removeAttributeNS(String str, String str2) {
        removeAttribute(str2);
    }

    @Override // org.w3c.dom.Element
    public Attr removeAttributeNode(Attr attr) {
        removeAttribute(attr.getName());
        return attr;
    }

    @Override // org.w3c.dom.Node
    public Node removeChild(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("oldChild == null!");
        }
        checkNode(node);
        IIOMetadataNode iIOMetadataNode = (IIOMetadataNode) node;
        IIOMetadataNode iIOMetadataNode2 = iIOMetadataNode.previousSibling;
        IIOMetadataNode iIOMetadataNode3 = iIOMetadataNode.nextSibling;
        if (iIOMetadataNode2 != null) {
            iIOMetadataNode2.nextSibling = iIOMetadataNode3;
        }
        if (iIOMetadataNode3 != null) {
            iIOMetadataNode3.previousSibling = iIOMetadataNode2;
        }
        if (this.firstChild == iIOMetadataNode) {
            this.firstChild = iIOMetadataNode3;
        }
        if (this.lastChild == iIOMetadataNode) {
            this.lastChild = iIOMetadataNode2;
        }
        iIOMetadataNode.parent = null;
        iIOMetadataNode.previousSibling = null;
        iIOMetadataNode.nextSibling = null;
        this.numChildren--;
        return iIOMetadataNode;
    }

    @Override // org.w3c.dom.Node
    public Node replaceChild(Node node, Node node2) {
        if (node == null) {
            throw new IllegalArgumentException("newChild == null!");
        }
        checkNode(node);
        checkNode(node2);
        IIOMetadataNode iIOMetadataNode = (IIOMetadataNode) node;
        IIOMetadataNode iIOMetadataNode2 = (IIOMetadataNode) node2;
        IIOMetadataNode iIOMetadataNode3 = iIOMetadataNode2.previousSibling;
        IIOMetadataNode iIOMetadataNode4 = iIOMetadataNode2.nextSibling;
        if (iIOMetadataNode3 != null) {
            iIOMetadataNode3.nextSibling = iIOMetadataNode;
        }
        if (iIOMetadataNode4 != null) {
            iIOMetadataNode4.previousSibling = iIOMetadataNode;
        }
        iIOMetadataNode.parent = this;
        iIOMetadataNode.previousSibling = iIOMetadataNode3;
        iIOMetadataNode.nextSibling = iIOMetadataNode4;
        if (this.firstChild == iIOMetadataNode2) {
            this.firstChild = iIOMetadataNode;
        }
        if (this.lastChild == iIOMetadataNode2) {
            this.lastChild = iIOMetadataNode;
        }
        iIOMetadataNode2.parent = null;
        iIOMetadataNode2.previousSibling = null;
        iIOMetadataNode2.nextSibling = null;
        return iIOMetadataNode2;
    }

    @Override // org.w3c.dom.Element
    public void setAttribute(String str, String str2) {
        for (char c : str.toCharArray()) {
            if (c >= 65534) {
                throw new IIODOMException((short) 5, "Attribute name is illegal!");
            }
        }
        removeAttribute(str, false);
        this.attributes.add(new IIOAttr(this, str, str2));
    }

    @Override // org.w3c.dom.Element
    public void setAttributeNS(String str, String str2, String str3) {
        setAttribute(str2, str3);
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNode(Attr attr) {
        IIOAttr iIOAttr;
        Element ownerElement = attr.getOwnerElement();
        if (ownerElement != null) {
            if (ownerElement == this) {
                return null;
            }
            throw new DOMException((short) 10, "Attribute is already in use");
        }
        if (attr instanceof IIOAttr) {
            iIOAttr = (IIOAttr) attr;
            iIOAttr.setOwnerElement(this);
        } else {
            iIOAttr = new IIOAttr(this, attr.getName(), attr.getValue());
        }
        Attr attributeNode = getAttributeNode(iIOAttr.getName());
        if (attributeNode != null) {
            removeAttributeNode(attributeNode);
        }
        this.attributes.add(iIOAttr);
        return attributeNode;
    }

    @Override // org.w3c.dom.Element
    public Attr setAttributeNodeNS(Attr attr) {
        return setAttributeNode(attr);
    }

    @Override // org.w3c.dom.Element
    public void setIdAttribute(String str, boolean z) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNS(String str, String str2, boolean z) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Element
    public void setIdAttributeNode(Attr attr, boolean z) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Node
    public void setNodeValue(String str) {
        this.nodeValue = str;
    }

    @Override // org.w3c.dom.Node
    public void setTextContent(String str) {
        throw new DOMException((short) 9, "Method not supported");
    }

    @Override // org.w3c.dom.Node
    public Object setUserData(String str, Object obj, UserDataHandler userDataHandler) {
        throw new DOMException((short) 9, "Method not supported");
    }

    public void setUserObject(Object obj) {
        this.userObject = obj;
    }

    private void removeAttribute(String str, boolean z) {
        int size = this.attributes.size();
        for (int i = 0; i < size; i++) {
            IIOAttr iIOAttr = (IIOAttr) this.attributes.get(i);
            if (str.equals(iIOAttr.getName())) {
                iIOAttr.setOwnerElement(null);
                this.attributes.remove(i);
                return;
            }
        }
        if (z) {
            throw new IIODOMException((short) 8, "No such attribute!");
        }
    }

    private void getElementsByTagName(String str, List list) {
        if (this.nodeName.equals(str)) {
            list.add(this);
        }
        for (Node firstChild = getFirstChild(); firstChild != null; firstChild = firstChild.getNextSibling()) {
            ((IIOMetadataNode) firstChild).getElementsByTagName(str, list);
        }
    }

    public IIOMetadataNode(String str) {
        this.nodeName = null;
        this.nodeValue = null;
        this.userObject = null;
        this.parent = null;
        this.numChildren = 0;
        this.firstChild = null;
        this.lastChild = null;
        this.nextSibling = null;
        this.previousSibling = null;
        this.attributes = new ArrayList();
        this.nodeName = str;
    }

    @Override // org.w3c.dom.Node
    public NodeList getChildNodes() {
        return this;
    }

    @Override // org.w3c.dom.Node
    public void normalize() {
    }

    @Override // org.w3c.dom.Node
    public void setPrefix(String str) {
    }
}
