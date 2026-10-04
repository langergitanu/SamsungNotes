package org.apache.poi.javax.imageio.metadata;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class IIOAttr extends IIOMetadataNode implements Attr {
    String name;
    Element owner;
    String value;

    public IIOAttr(Element element, String str, String str2) {
        this.owner = element;
        this.name = str;
        this.value = str2;
    }

    @Override // org.w3c.dom.Attr
    public String getName() {
        return this.name;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataNode, org.w3c.dom.Node
    public String getNodeName() {
        return this.name;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataNode, org.w3c.dom.Node
    public short getNodeType() {
        return (short) 2;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataNode, org.w3c.dom.Node
    public String getNodeValue() {
        return this.value;
    }

    @Override // org.w3c.dom.Attr
    public Element getOwnerElement() {
        return this.owner;
    }

    @Override // org.w3c.dom.Attr
    public boolean getSpecified() {
        return true;
    }

    @Override // org.w3c.dom.Attr
    public String getValue() {
        return this.value;
    }

    @Override // org.w3c.dom.Attr
    public boolean isId() {
        return false;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadataNode, org.w3c.dom.Node
    public void setNodeValue(String str) {
        this.value = str;
    }

    public void setOwnerElement(Element element) {
        this.owner = element;
    }

    @Override // org.w3c.dom.Attr
    public void setValue(String str) {
        this.value = str;
    }
}
