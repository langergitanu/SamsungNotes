package com.sun.imageio.plugins.jpeg;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.PrintStream;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class MarkerSegment implements Cloneable {
    protected static final int LENGTH_SIZE = 2;
    byte[] data;
    int length;
    int tag;
    boolean unknown;

    public MarkerSegment(JPEGBuffer jPEGBuffer) throws IIOException {
        this.data = null;
        this.unknown = false;
        jPEGBuffer.loadBuf(3);
        byte[] bArr = jPEGBuffer.buf;
        int i = jPEGBuffer.bufPtr;
        int i2 = i + 1;
        jPEGBuffer.bufPtr = i2;
        this.tag = bArr[i] & 255;
        int i4 = i + 2;
        jPEGBuffer.bufPtr = i4;
        int i5 = (bArr[i2] & 255) << 8;
        this.length = i5;
        jPEGBuffer.bufPtr = i + 3;
        int i6 = ((bArr[i4] & 255) | i5) - 2;
        this.length = i6;
        if (i6 >= 0) {
            jPEGBuffer.bufAvail -= 3;
            jPEGBuffer.loadBuf(i6);
        } else {
            throw new IIOException("Invalid segment length: " + this.length);
        }
    }

    public static int getAttributeValue(Node node, NamedNodeMap namedNodeMap, String str, int i, int i2, boolean z) throws IIOInvalidTreeException {
        if (namedNodeMap == null) {
            namedNodeMap = node.getAttributes();
        }
        String nodeValue = namedNodeMap.getNamedItem(str).getNodeValue();
        if (nodeValue == null) {
            if (z) {
                throw new IIOInvalidTreeException(AbstractC0541b.m756B(str, " attribute not found"), node);
            }
            return -1;
        }
        int i4 = Integer.parseInt(nodeValue);
        if (i4 < i || i4 > i2) {
            throw new IIOInvalidTreeException(AbstractC0541b.m756B(str, " attribute out of range"), node);
        }
        return i4;
    }

    public static void write2bytes(ImageOutputStream imageOutputStream, int i) {
        imageOutputStream.write((i >> 8) & 255);
        imageOutputStream.write(i & 255);
    }

    public Object clone() {
        MarkerSegment markerSegment;
        try {
            markerSegment = (MarkerSegment) super.clone();
        } catch (CloneNotSupportedException unused) {
            markerSegment = null;
        }
        byte[] bArr = this.data;
        if (bArr != null) {
            markerSegment.data = (byte[]) bArr.clone();
        }
        return markerSegment;
    }

    public IIOMetadataNode getNativeNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("unknown");
        iIOMetadataNode.setAttribute("MarkerTag", Integer.toString(this.tag));
        iIOMetadataNode.setUserObject(this.data);
        return iIOMetadataNode;
    }

    public void loadData(JPEGBuffer jPEGBuffer) throws IIOException {
        byte[] bArr = new byte[this.length];
        this.data = bArr;
        jPEGBuffer.readData(bArr);
    }

    public void print() {
        printTag("Unknown");
        int i = 0;
        if (this.length > 10) {
            System.out.print("First 5 bytes:");
            while (i < 5) {
                System.out.print(" Ox" + Integer.toHexString(this.data[i]));
                i++;
            }
            System.out.print("\nLast 5 bytes:");
            for (int length = this.data.length - 5; length < this.data.length; length++) {
                System.out.print(" Ox" + Integer.toHexString(this.data[length]));
            }
        } else {
            System.out.print("Data:");
            while (i < this.data.length) {
                System.out.print(" Ox" + Integer.toHexString(this.data[i]));
                i++;
            }
        }
        System.out.println();
    }

    public void printTag(String str) {
        PrintStream printStream = System.out;
        StringBuilder sbM781w = AbstractC0541b.m781w(str, " marker segment - marker = 0x");
        sbM781w.append(Integer.toHexString(this.tag));
        printStream.println(sbM781w.toString());
        System.out.println("length: " + this.length);
    }

    public void write(ImageOutputStream imageOutputStream) {
        byte[] bArr = this.data;
        this.length = (bArr != null ? bArr.length : 0) + 2;
        writeTag(imageOutputStream);
        byte[] bArr2 = this.data;
        if (bArr2 != null) {
            imageOutputStream.write(bArr2);
        }
    }

    public void writeTag(ImageOutputStream imageOutputStream) {
        imageOutputStream.write(255);
        imageOutputStream.write(this.tag);
        write2bytes(imageOutputStream, this.length);
    }

    public MarkerSegment(int i) {
        this.data = null;
        this.unknown = false;
        this.tag = i;
        this.length = 0;
    }

    public MarkerSegment(Node node) throws IIOInvalidTreeException {
        this.data = null;
        this.unknown = false;
        this.tag = getAttributeValue(node, null, "MarkerTag", 0, 255, true);
        this.length = 0;
        if (node instanceof IIOMetadataNode) {
            try {
                this.data = (byte[]) ((IIOMetadataNode) node).getUserObject();
                return;
            } catch (Exception e) {
                IIOInvalidTreeException iIOInvalidTreeException = new IIOInvalidTreeException("Can't get User Object", node);
                iIOInvalidTreeException.initCause(e);
                throw iIOInvalidTreeException;
            }
        }
        throw new IIOInvalidTreeException("Node must have User Object", node);
    }
}
