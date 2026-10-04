package com.sun.imageio.plugins.jpeg;

import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.UnsupportedEncodingException;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class COMMarkerSegment extends MarkerSegment {
    private static final String ENCODING = "ISO-8859-1";

    public COMMarkerSegment(JPEGBuffer jPEGBuffer) throws IIOException {
        super(jPEGBuffer);
        loadData(jPEGBuffer);
    }

    public String getComment() {
        try {
            return new String(this.data, "ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public IIOMetadataNode getNativeNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("com");
        iIOMetadataNode.setAttribute(ClientCookie.COMMENT_ATTR, getComment());
        byte[] bArr = this.data;
        if (bArr != null) {
            iIOMetadataNode.setUserObject(bArr.clone());
        }
        return iIOMetadataNode;
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public void print() {
        printTag("COM");
        System.out.println("<" + getComment() + ">");
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public void write(ImageOutputStream imageOutputStream) {
        this.length = this.data.length + 2;
        writeTag(imageOutputStream);
        imageOutputStream.write(this.data);
    }

    public COMMarkerSegment(String str) {
        super(JPEG.COM);
        this.data = str.getBytes();
    }

    public COMMarkerSegment(Node node) throws IIOInvalidTreeException {
        super(JPEG.COM);
        if (node instanceof IIOMetadataNode) {
            this.data = (byte[]) ((IIOMetadataNode) node).getUserObject();
        }
        if (this.data == null) {
            String nodeValue = node.getAttributes().getNamedItem(ClientCookie.COMMENT_ATTR).getNodeValue();
            if (nodeValue != null) {
                this.data = nodeValue.getBytes();
                return;
            }
            throw new IIOInvalidTreeException("Empty comment node!", node);
        }
    }
}
