package com.sun.imageio.plugins.jpeg;

import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
class SOFMarkerSegment extends MarkerSegment {
    ComponentSpec[] componentSpecs;
    int numLines;
    int samplePrecision;
    int samplesPerLine;

    public SOFMarkerSegment(boolean z, boolean z2, boolean z3, byte[] bArr, int i) {
        int i2;
        super(z ? JPEG.SOF2 : z2 ? 193 : 192);
        this.samplePrecision = 8;
        this.numLines = 0;
        this.samplesPerLine = 0;
        this.componentSpecs = new ComponentSpec[i];
        for (int i4 = 0; i4 < i; i4++) {
            int i5 = 1;
            if (!z3) {
                i2 = 0;
            } else if (i4 == 1 || i4 == 2) {
                i2 = 1;
            } else {
                i5 = 2;
                i2 = 0;
            }
            this.componentSpecs[i4] = new ComponentSpec(bArr[i4], i5, i2);
        }
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public Object clone() {
        SOFMarkerSegment sOFMarkerSegment = (SOFMarkerSegment) super.clone();
        ComponentSpec[] componentSpecArr = this.componentSpecs;
        if (componentSpecArr != null) {
            sOFMarkerSegment.componentSpecs = (ComponentSpec[]) componentSpecArr.clone();
            int i = 0;
            while (true) {
                ComponentSpec[] componentSpecArr2 = this.componentSpecs;
                if (i >= componentSpecArr2.length) {
                    break;
                }
                sOFMarkerSegment.componentSpecs[i] = (ComponentSpec) componentSpecArr2[i].clone();
                i++;
            }
        }
        return sOFMarkerSegment;
    }

    public ComponentSpec getComponentSpec(byte b, int i, int i2) {
        return new ComponentSpec(b, i, i2);
    }

    public int getIDencodedCSType() {
        int i = 0;
        while (true) {
            ComponentSpec[] componentSpecArr = this.componentSpecs;
            if (i >= componentSpecArr.length) {
                int length = componentSpecArr.length;
                if (length == 3) {
                    int i2 = componentSpecArr[0].componentId;
                    if (i2 == 82 && i2 == 71 && i2 == 66) {
                        return 2;
                    }
                    return (i2 == 89 && i2 == 67 && i2 == 99) ? 5 : 0;
                }
                if (length != 4) {
                    return 0;
                }
                int i4 = componentSpecArr[0].componentId;
                if (i4 == 82 && i4 == 71 && i4 == 66 && i4 == 65) {
                    return 6;
                }
                return (i4 == 89 && i4 == 67 && i4 == 99 && i4 == 65) ? 10 : 0;
            }
            if (componentSpecArr[i].componentId < 65) {
                return 0;
            }
            i++;
        }
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public IIOMetadataNode getNativeNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("sof");
        iIOMetadataNode.setAttribute("process", Integer.toString(this.tag - 192));
        iIOMetadataNode.setAttribute("samplePrecision", Integer.toString(this.samplePrecision));
        iIOMetadataNode.setAttribute("numLines", Integer.toString(this.numLines));
        iIOMetadataNode.setAttribute("samplesPerLine", Integer.toString(this.samplesPerLine));
        iIOMetadataNode.setAttribute("numFrameComponents", Integer.toString(this.componentSpecs.length));
        int i = 0;
        while (true) {
            ComponentSpec[] componentSpecArr = this.componentSpecs;
            if (i >= componentSpecArr.length) {
                return iIOMetadataNode;
            }
            iIOMetadataNode.appendChild(componentSpecArr[i].getNativeNode());
            i++;
        }
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public void print() {
        printTag("SOF");
        System.out.print("Sample precision: ");
        System.out.println(this.samplePrecision);
        System.out.print("Number of lines: ");
        System.out.println(this.numLines);
        System.out.print("Samples per line: ");
        System.out.println(this.samplesPerLine);
        System.out.print("Number of components: ");
        System.out.println(this.componentSpecs.length);
        int i = 0;
        while (true) {
            ComponentSpec[] componentSpecArr = this.componentSpecs;
            if (i >= componentSpecArr.length) {
                return;
            }
            componentSpecArr[i].print();
            i++;
        }
    }

    public void updateFromNativeNode(Node node, boolean z) throws IIOInvalidTreeException {
        NamedNodeMap attributes = node.getAttributes();
        int attributeValue = MarkerSegment.getAttributeValue(node, attributes, "process", 0, 2, false);
        this.tag = attributeValue != -1 ? attributeValue + 192 : this.tag;
        MarkerSegment.getAttributeValue(node, attributes, "samplePrecision", 8, 8, false);
        int attributeValue2 = MarkerSegment.getAttributeValue(node, attributes, "numLines", 0, 65535, false);
        if (attributeValue2 == -1) {
            attributeValue2 = this.numLines;
        }
        this.numLines = attributeValue2;
        int attributeValue3 = MarkerSegment.getAttributeValue(node, attributes, "samplesPerLine", 0, 65535, false);
        if (attributeValue3 == -1) {
            attributeValue3 = this.samplesPerLine;
        }
        this.samplesPerLine = attributeValue3;
        int attributeValue4 = MarkerSegment.getAttributeValue(node, attributes, "numFrameComponents", 1, 4, false);
        NodeList childNodes = node.getChildNodes();
        if (childNodes.getLength() != attributeValue4) {
            throw new IIOInvalidTreeException("numFrameComponents must match number of children", node);
        }
        this.componentSpecs = new ComponentSpec[attributeValue4];
        for (int i = 0; i < attributeValue4; i++) {
            this.componentSpecs[i] = new ComponentSpec(childNodes.item(i));
        }
    }

    @Override // com.sun.imageio.plugins.jpeg.MarkerSegment
    public void write(ImageOutputStream imageOutputStream) {
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class ComponentSpec implements Cloneable {
        int HsamplingFactor;
        int QtableSelector;
        int VsamplingFactor;
        int componentId;

        public ComponentSpec(byte b, int i, int i2) {
            this.componentId = b;
            this.HsamplingFactor = i;
            this.VsamplingFactor = i;
            this.QtableSelector = i2;
        }

        public Object clone() {
            try {
                return super.clone();
            } catch (CloneNotSupportedException unused) {
                return null;
            }
        }

        public IIOMetadataNode getNativeNode() {
            IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("componentSpec");
            iIOMetadataNode.setAttribute("componentId", Integer.toString(this.componentId));
            iIOMetadataNode.setAttribute("HsamplingFactor", Integer.toString(this.HsamplingFactor));
            iIOMetadataNode.setAttribute("VsamplingFactor", Integer.toString(this.VsamplingFactor));
            iIOMetadataNode.setAttribute("QtableSelector", Integer.toString(this.QtableSelector));
            return iIOMetadataNode;
        }

        public void print() {
            System.out.print("Component ID: ");
            System.out.println(this.componentId);
            System.out.print("H sampling factor: ");
            System.out.println(this.HsamplingFactor);
            System.out.print("V sampling factor: ");
            System.out.println(this.VsamplingFactor);
            System.out.print("Q table selector: ");
            System.out.println(this.QtableSelector);
        }

        public ComponentSpec(JPEGBuffer jPEGBuffer) {
            byte[] bArr = jPEGBuffer.buf;
            int i = jPEGBuffer.bufPtr;
            int i2 = i + 1;
            jPEGBuffer.bufPtr = i2;
            this.componentId = bArr[i];
            byte b = bArr[i2];
            this.HsamplingFactor = b >>> 4;
            int i4 = i + 2;
            jPEGBuffer.bufPtr = i4;
            this.VsamplingFactor = b & 15;
            jPEGBuffer.bufPtr = i + 3;
            this.QtableSelector = bArr[i4];
        }

        public ComponentSpec(Node node) {
            NamedNodeMap attributes = node.getAttributes();
            this.componentId = MarkerSegment.getAttributeValue(node, attributes, "componentId", 0, 255, true);
            this.HsamplingFactor = MarkerSegment.getAttributeValue(node, attributes, "HsamplingFactor", 1, 255, true);
            this.VsamplingFactor = MarkerSegment.getAttributeValue(node, attributes, "VsamplingFactor", 1, 255, true);
            this.QtableSelector = MarkerSegment.getAttributeValue(node, attributes, "QtableSelector", 0, 3, true);
        }
    }

    public SOFMarkerSegment(JPEGBuffer jPEGBuffer) {
        super(jPEGBuffer);
        byte[] bArr = jPEGBuffer.buf;
        int i = jPEGBuffer.bufPtr;
        int i2 = i + 1;
        jPEGBuffer.bufPtr = i2;
        this.samplePrecision = bArr[i];
        int i4 = i + 2;
        jPEGBuffer.bufPtr = i4;
        int i5 = (bArr[i2] & 255) << 8;
        this.numLines = i5;
        int i6 = i + 3;
        jPEGBuffer.bufPtr = i6;
        this.numLines = i5 | (bArr[i4] & 255);
        int i7 = i + 4;
        jPEGBuffer.bufPtr = i7;
        int i8 = (bArr[i6] & 255) << 8;
        this.samplesPerLine = i8;
        int i9 = i + 5;
        jPEGBuffer.bufPtr = i9;
        this.samplesPerLine = (bArr[i7] & 255) | i8;
        jPEGBuffer.bufPtr = i + 6;
        int i10 = bArr[i9] & 255;
        this.componentSpecs = new ComponentSpec[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            this.componentSpecs[i11] = new ComponentSpec(jPEGBuffer);
        }
        jPEGBuffer.bufAvail -= this.length;
    }

    public SOFMarkerSegment(Node node) throws IIOInvalidTreeException {
        super(192);
        this.samplePrecision = 8;
        this.numLines = 0;
        this.samplesPerLine = 0;
        updateFromNativeNode(node, true);
    }
}
