package com.sun.imageio.plugins.jpeg;

import com.vladsch.flexmark.util.html.Attribute;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class DHTMarkerSegment extends MarkerSegment {
    List tables;

    public DHTMarkerSegment(boolean z) {
        super(JPEG.DHT);
        ArrayList arrayList = new ArrayList();
        this.tables = arrayList;
        arrayList.add(new Htable(JPEGHuffmanTable.StdDCLuminance, true, 0));
        if (z) {
            this.tables.add(new Htable(JPEGHuffmanTable.StdDCChrominance, true, 1));
        }
        this.tables.add(new Htable(JPEGHuffmanTable.StdACLuminance, false, 0));
        if (z) {
            this.tables.add(new Htable(JPEGHuffmanTable.StdACChrominance, false, 1));
        }
    }

    public void addHtable(JPEGHuffmanTable jPEGHuffmanTable, boolean z, int i) {
        this.tables.add(new Htable(jPEGHuffmanTable, z, i));
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public Object clone() {
        DHTMarkerSegment dHTMarkerSegment = (DHTMarkerSegment) super.clone();
        dHTMarkerSegment.tables = new ArrayList(this.tables.size());
        Iterator it = this.tables.iterator();
        while (it.hasNext()) {
            dHTMarkerSegment.tables.add(((Htable) it.next()).clone());
        }
        return dHTMarkerSegment;
    }

    public Htable getHtableFromNode(Node node) {
        return new Htable(node);
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public IIOMetadataNode getNativeNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("dht");
        for (int i = 0; i < this.tables.size(); i++) {
            iIOMetadataNode.appendChild(((Htable) this.tables.get(i)).getNativeNode());
        }
        return iIOMetadataNode;
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public void print() {
        printTag("DHT");
        System.out.println("Num tables: " + Integer.toString(this.tables.size()));
        for (int i = 0; i < this.tables.size(); i++) {
            ((Htable) this.tables.get(i)).print();
        }
        System.out.println();
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public void write(ImageOutputStream imageOutputStream) {
    }

    public DHTMarkerSegment(JPEGBuffer jPEGBuffer) {
        super(jPEGBuffer);
        this.tables = new ArrayList();
        int length = this.length;
        while (length > 0) {
            Htable htable = new Htable(jPEGBuffer);
            this.tables.add(htable);
            length -= htable.values.length + 17;
        }
        jPEGBuffer.bufAvail -= this.length;
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class Htable implements Cloneable {
        private static final int NUM_LENGTHS = 16;
        short[] numCodes;
        int tableClass;
        int tableID;
        short[] values;

        public Htable(JPEGBuffer jPEGBuffer) {
            this.numCodes = new short[16];
            byte[] bArr = jPEGBuffer.buf;
            int i = jPEGBuffer.bufPtr;
            byte b = bArr[i];
            this.tableClass = b >>> 4;
            jPEGBuffer.bufPtr = i + 1;
            this.tableID = b & 15;
            for (int i2 = 0; i2 < 16; i2++) {
                short[] sArr = this.numCodes;
                byte[] bArr2 = jPEGBuffer.buf;
                int i4 = jPEGBuffer.bufPtr;
                jPEGBuffer.bufPtr = i4 + 1;
                sArr[i2] = (short) (bArr2[i4] & 255);
            }
            int i5 = 0;
            for (int i6 = 0; i6 < 16; i6++) {
                i5 += this.numCodes[i6];
            }
            this.values = new short[i5];
            for (int i7 = 0; i7 < i5; i7++) {
                short[] sArr2 = this.values;
                byte[] bArr3 = jPEGBuffer.buf;
                int i8 = jPEGBuffer.bufPtr;
                jPEGBuffer.bufPtr = i8 + 1;
                sArr2[i7] = (short) (bArr3[i8] & 255);
            }
        }

        public Object clone() {
            Htable htable;
            try {
                htable = (Htable) super.clone();
            } catch (CloneNotSupportedException unused) {
                htable = null;
            }
            short[] sArr = this.numCodes;
            if (sArr != null) {
                htable.numCodes = (short[]) sArr.clone();
            }
            short[] sArr2 = this.values;
            if (sArr2 != null) {
                htable.values = (short[]) sArr2.clone();
            }
            return htable;
        }

        public IIOMetadataNode getNativeNode() {
            IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("dhtable");
            iIOMetadataNode.setAttribute(Attribute.CLASS_ATTR, Integer.toString(this.tableClass));
            iIOMetadataNode.setAttribute("htableId", Integer.toString(this.tableID));
            iIOMetadataNode.setUserObject(new JPEGHuffmanTable(this.numCodes, this.values));
            return iIOMetadataNode;
        }

        public void print() {
            System.out.println("Huffman Table");
            System.out.println("table class: ".concat(this.tableClass == 0 ? "DC" : "AC"));
            System.out.println("table id: " + Integer.toString(this.tableID));
            new JPEGHuffmanTable(this.numCodes, this.values).toString();
        }

        public Htable(JPEGHuffmanTable jPEGHuffmanTable, boolean z, int i) {
            this.numCodes = new short[16];
            this.tableClass = !z ? 1 : 0;
            this.tableID = i;
            this.numCodes = jPEGHuffmanTable.getLengths();
            this.values = jPEGHuffmanTable.getValues();
        }

        public Htable(Node node) throws IIOInvalidTreeException {
            this.numCodes = new short[16];
            if (node.getNodeName().equals("dhtable")) {
                NamedNodeMap attributes = node.getAttributes();
                if (attributes.getLength() == 2) {
                    this.tableClass = MarkerSegment.getAttributeValue(node, attributes, Attribute.CLASS_ATTR, 0, 1, true);
                    this.tableID = MarkerSegment.getAttributeValue(node, attributes, "htableId", 0, 3, true);
                    if (node instanceof IIOMetadataNode) {
                        JPEGHuffmanTable jPEGHuffmanTable = (JPEGHuffmanTable) ((IIOMetadataNode) node).getUserObject();
                        if (jPEGHuffmanTable != null) {
                            this.numCodes = jPEGHuffmanTable.getLengths();
                            this.values = jPEGHuffmanTable.getValues();
                            return;
                        }
                        throw new IIOInvalidTreeException("dhtable node must have user object", node);
                    }
                    throw new IIOInvalidTreeException("dhtable node must have user object", node);
                }
                throw new IIOInvalidTreeException("dhtable node must have 2 attributes", node);
            }
            throw new IIOInvalidTreeException("Invalid node, expected dqtable", node);
        }
    }

    public DHTMarkerSegment(JPEGHuffmanTable[] jPEGHuffmanTableArr, JPEGHuffmanTable[] jPEGHuffmanTableArr2) {
        super(JPEG.DHT);
        this.tables = new ArrayList();
        for (int i = 0; i < jPEGHuffmanTableArr.length; i++) {
            this.tables.add(new Htable(jPEGHuffmanTableArr[i], true, i));
        }
        for (int i2 = 0; i2 < jPEGHuffmanTableArr2.length; i2++) {
            this.tables.add(new Htable(jPEGHuffmanTableArr2[i2], false, i2));
        }
    }

    public DHTMarkerSegment(Node node) throws IIOInvalidTreeException {
        super(JPEG.DHT);
        this.tables = new ArrayList();
        NodeList childNodes = node.getChildNodes();
        int length = childNodes.getLength();
        if (length < 1 || length > 4) {
            throw new IIOInvalidTreeException("Invalid DHT node", node);
        }
        for (int i = 0; i < length; i++) {
            this.tables.add(new Htable(childNodes.item(i)));
        }
    }
}
