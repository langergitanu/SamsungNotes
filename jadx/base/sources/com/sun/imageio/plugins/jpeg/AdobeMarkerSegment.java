package com.sun.imageio.plugins.jpeg;

import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class AdobeMarkerSegment extends MarkerSegment {
    private static final int ID_SIZE = 5;
    int flags0;
    int flags1;
    int transform;
    int version;

    public AdobeMarkerSegment(int i) {
        super(JPEG.APP14);
        this.version = 101;
        this.flags0 = 0;
        this.flags1 = 0;
        this.transform = i;
    }

    public static void writeAdobeSegment(ImageOutputStream imageOutputStream, int i) {
        new AdobeMarkerSegment(i).write(imageOutputStream);
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public IIOMetadataNode getNativeNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("app14Adobe");
        iIOMetadataNode.setAttribute("version", Integer.toString(this.version));
        iIOMetadataNode.setAttribute("flags0", Integer.toString(this.flags0));
        iIOMetadataNode.setAttribute("flags1", Integer.toString(this.flags1));
        iIOMetadataNode.setAttribute("transform", Integer.toString(this.transform));
        return iIOMetadataNode;
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public void print() {
        printTag("Adobe APP14");
        System.out.print("Version: ");
        System.out.println(this.version);
        System.out.print("Flags0: 0x");
        System.out.println(Integer.toHexString(this.flags0));
        System.out.print("Flags1: 0x");
        System.out.println(Integer.toHexString(this.flags1));
        System.out.print("Transform: ");
        System.out.println(this.transform);
    }

    public void updateFromNativeNode(Node node, boolean z) throws IIOInvalidTreeException {
        NamedNodeMap attributes = node.getAttributes();
        this.transform = MarkerSegment.getAttributeValue(node, attributes, "transform", 0, 2, true);
        int length = attributes.getLength();
        if (length > 4) {
            throw new IIOInvalidTreeException("Adobe APP14 node cannot have > 4 attributes", node);
        }
        if (length > 1) {
            int attributeValue = MarkerSegment.getAttributeValue(node, attributes, "version", 100, 255, false);
            if (attributeValue == -1) {
                attributeValue = this.version;
            }
            this.version = attributeValue;
            int attributeValue2 = MarkerSegment.getAttributeValue(node, attributes, "flags0", 0, 65535, false);
            if (attributeValue2 == -1) {
                attributeValue2 = this.flags0;
            }
            this.flags0 = attributeValue2;
            int attributeValue3 = MarkerSegment.getAttributeValue(node, attributes, "flags1", 0, 65535, false);
            if (attributeValue3 == -1) {
                attributeValue3 = this.flags1;
            }
            this.flags1 = attributeValue3;
        }
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public void write(ImageOutputStream imageOutputStream) {
        this.length = 14;
        writeTag(imageOutputStream);
        imageOutputStream.write(new byte[]{65, 100, 111, 98, 101});
        MarkerSegment.write2bytes(imageOutputStream, this.version);
        MarkerSegment.write2bytes(imageOutputStream, this.flags0);
        MarkerSegment.write2bytes(imageOutputStream, this.flags1);
        imageOutputStream.write(this.transform);
    }

    public AdobeMarkerSegment(JPEGBuffer jPEGBuffer) {
        super(jPEGBuffer);
        int i = jPEGBuffer.bufPtr;
        byte[] bArr = jPEGBuffer.buf;
        int i2 = i + 6;
        jPEGBuffer.bufPtr = i2;
        int i4 = (bArr[i + 5] & 255) << 8;
        this.version = i4;
        int i5 = i + 7;
        jPEGBuffer.bufPtr = i5;
        this.version = i4 | (bArr[i2] & 255);
        int i6 = i + 8;
        jPEGBuffer.bufPtr = i6;
        int i7 = (bArr[i5] & 255) << 8;
        this.flags0 = i7;
        int i8 = i + 9;
        jPEGBuffer.bufPtr = i8;
        this.flags0 = (bArr[i6] & 255) | i7;
        int i9 = i + 10;
        jPEGBuffer.bufPtr = i9;
        int i10 = (bArr[i8] & 255) << 8;
        this.flags1 = i10;
        int i11 = i + 11;
        jPEGBuffer.bufPtr = i11;
        this.flags1 = (bArr[i9] & 255) | i10;
        jPEGBuffer.bufPtr = i + 12;
        this.transform = bArr[i11] & 255;
        jPEGBuffer.bufAvail -= this.length;
    }

    public AdobeMarkerSegment(Node node) throws IIOInvalidTreeException {
        this(0);
        updateFromNativeNode(node, true);
    }
}
