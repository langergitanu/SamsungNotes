package com.sun.imageio.plugins.wbmp;

import com.google.common.net.HttpHeaders;
import com.sun.imageio.plugins.common.I18N;
import com.sun.imageio.plugins.common.ImageUtil;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class WBMPMetadata extends IIOMetadata {
    static final String nativeMetadataFormatName = "javax_imageio_wbmp_1.0";
    public int height;
    public int wbmpType;
    public int width;

    public WBMPMetadata() {
        super(true, nativeMetadataFormatName, "com.sun.imageio.plugins.wbmp.WBMPMetadataFormat", null, null);
    }

    private IIOMetadataNode addChildNode(IIOMetadataNode iIOMetadataNode, String str, Object obj) {
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode(str);
        if (obj != null) {
            iIOMetadataNode2.setUserObject(obj);
            iIOMetadataNode2.setNodeValue(ImageUtil.convertObjectToString(obj));
        }
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode2;
    }

    private Node getNativeTree() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(nativeMetadataFormatName);
        addChildNode(iIOMetadataNode, "WBMPType", new Integer(this.wbmpType));
        addChildNode(iIOMetadataNode, HttpHeaders.WIDTH, new Integer(this.width));
        addChildNode(iIOMetadataNode, "Height", new Integer(this.height));
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public Node getAsTree(String str) {
        if (str.equals(nativeMetadataFormatName)) {
            return getNativeTree();
        }
        if (str.equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
            return getStandardTree();
        }
        throw new IllegalArgumentException(I18N.getString("WBMPMetadata0"));
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardChromaNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Chroma");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("BlackIsZero");
        iIOMetadataNode2.setAttribute("value", "TRUE");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardDimensionNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Dimension");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("ImageOrientation");
        iIOMetadataNode2.setAttribute("value", "Normal");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public boolean isReadOnly() {
        return true;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void mergeTree(String str, Node node) {
        throw new IllegalStateException(I18N.getString("WBMPMetadata1"));
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void reset() {
        throw new IllegalStateException(I18N.getString("WBMPMetadata1"));
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void setFromTree(String str, Node node) {
        throw new IllegalStateException(I18N.getString("WBMPMetadata1"));
    }
}
