package com.sun.imageio.plugins.jpeg;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import androidx.exifinterface.media.ExifInterface;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.FolderNodeItem;
import com.sun.imageio.plugins.jpeg.DHTMarkerSegment;
import com.sun.imageio.plugins.jpeg.DQTMarkerSegment;
import com.sun.imageio.plugins.jpeg.JPEG;
import com.sun.imageio.plugins.jpeg.SOFMarkerSegment;
import com.sun.imageio.plugins.jpeg.SOSMarkerSegment;
import com.vladsch.flexmark.util.html.Attribute;
import cz.msebera.android.httpclient.cookie.ClientCookie;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.poi.java.awt.Point;
import org.apache.poi.java.awt.color.ColorSpace;
import org.apache.poi.java.awt.color.ICC_ColorSpace;
import org.apache.poi.java.awt.color.ICC_Profile;
import org.apache.poi.java.awt.image.ColorModel;
import org.apache.poi.javax.imageio.IIOException;
import org.apache.poi.javax.imageio.ImageTypeSpecifier;
import org.apache.poi.javax.imageio.ImageWriteParam;
import org.apache.poi.javax.imageio.metadata.IIOInvalidTreeException;
import org.apache.poi.javax.imageio.metadata.IIOMetadata;
import org.apache.poi.javax.imageio.metadata.IIOMetadataFormatImpl;
import org.apache.poi.javax.imageio.metadata.IIOMetadataNode;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import org.apache.poi.javax.imageio.plugins.jpeg.JPEGImageWriteParam;
import org.apache.poi.javax.imageio.stream.ImageInputStream;
import org.apache.poi.javax.imageio.stream.ImageOutputStream;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class JPEGMetadata extends IIOMetadata implements Cloneable {
    private static final boolean debug = false;
    private boolean hasAlpha;
    private boolean inThumb;
    final boolean isStream;
    List markerSequence;
    private List resetSequence;
    private boolean transparencyDone;

    public JPEGMetadata(boolean z, boolean z2) {
        super(true, JPEG.nativeImageMetadataFormatName, JPEG.nativeImageMetadataFormatClassName, null, null);
        this.resetSequence = null;
        this.inThumb = false;
        this.markerSequence = new ArrayList();
        this.inThumb = z2;
        this.isStream = z;
        if (z) {
            this.nativeMetadataFormatName = JPEG.nativeStreamMetadataFormatName;
            this.nativeMetadataFormatClassName = JPEG.nativeStreamMetadataFormatClassName;
        }
    }

    private List cloneSequence() {
        if (this.markerSequence == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.markerSequence.size());
        Iterator it = this.markerSequence.iterator();
        while (it.hasNext()) {
            arrayList.add(((MarkerSegment) it.next()).clone());
        }
        return arrayList;
    }

    private int countScanBands() {
        ArrayList arrayList = new ArrayList();
        for (MarkerSegment markerSegment : this.markerSequence) {
            if (markerSegment instanceof SOSMarkerSegment) {
                for (SOSMarkerSegment.ScanComponentSpec scanComponentSpec : ((SOSMarkerSegment) markerSegment).componentSpecs) {
                    Integer num = new Integer(scanComponentSpec.componentSelector);
                    if (!arrayList.contains(num)) {
                        arrayList.add(num);
                    }
                }
            }
        }
        return arrayList.size();
    }

    private static Point findIntegerRatio(float f) {
        boolean z;
        float fAbs = Math.abs(f);
        int i = 1;
        if (fAbs <= 0.005f) {
            return new Point(1, 255);
        }
        if (fAbs >= 255.0f) {
            return new Point(255, 1);
        }
        if (fAbs < 1.0d) {
            fAbs = 1.0f / fAbs;
            z = true;
        } else {
            z = false;
        }
        int iRound = Math.round(fAbs);
        float fAbs2 = Math.abs(fAbs - iRound);
        while (fAbs2 > 0.005f) {
            i++;
            float f4 = i;
            int iRound2 = Math.round(f4 * fAbs);
            fAbs2 = Math.abs(fAbs - (iRound2 / f4));
            iRound = iRound2;
        }
        return z ? new Point(i, iRound) : new Point(iRound, i);
    }

    private int findLastUnknownMarkerSegmentPosition() {
        List list = this.markerSequence;
        ListIterator listIterator = list.listIterator(list.size());
        int size = this.markerSequence.size() - 1;
        while (listIterator.hasPrevious()) {
            if (((MarkerSegment) listIterator.previous()).unknown) {
                return size;
            }
            size--;
        }
        return -1;
    }

    private int findMarkerSegmentPosition(Class cls, boolean z) {
        if (z) {
            ListIterator listIterator = this.markerSequence.listIterator();
            int i = 0;
            while (listIterator.hasNext()) {
                if (cls.isInstance((MarkerSegment) listIterator.next())) {
                    return i;
                }
                i++;
            }
            return -1;
        }
        List list = this.markerSequence;
        ListIterator listIterator2 = list.listIterator(list.size());
        int size = this.markerSequence.size();
        do {
            size--;
            if (!listIterator2.hasPrevious()) {
                return -1;
            }
        } while (!cls.isInstance((MarkerSegment) listIterator2.previous()));
        return size;
    }

    private void insertAdobeMarkerSegment(AdobeMarkerSegment adobeMarkerSegment) {
        boolean z = findMarkerSegment(JFIFMarkerSegment.class, true) != null;
        int iFindLastUnknownMarkerSegmentPosition = findLastUnknownMarkerSegmentPosition();
        if (z) {
            this.markerSequence.add(1, adobeMarkerSegment);
        } else if (iFindLastUnknownMarkerSegmentPosition != -1) {
            this.markerSequence.add(iFindLastUnknownMarkerSegmentPosition + 1, adobeMarkerSegment);
        } else {
            this.markerSequence.add(0, adobeMarkerSegment);
        }
    }

    private void insertCOMMarkerSegment(COMMarkerSegment cOMMarkerSegment) {
        int iFindMarkerSegmentPosition = findMarkerSegmentPosition(COMMarkerSegment.class, false);
        boolean z = findMarkerSegment(JFIFMarkerSegment.class, true) != null;
        int iFindMarkerSegmentPosition2 = findMarkerSegmentPosition(AdobeMarkerSegment.class, true);
        if (iFindMarkerSegmentPosition != -1) {
            this.markerSequence.add(iFindMarkerSegmentPosition + 1, cOMMarkerSegment);
            return;
        }
        if (z) {
            this.markerSequence.add(1, cOMMarkerSegment);
        } else if (iFindMarkerSegmentPosition2 != -1) {
            this.markerSequence.add(iFindMarkerSegmentPosition2 + 1, cOMMarkerSegment);
        } else {
            this.markerSequence.add(0, cOMMarkerSegment);
        }
    }

    private boolean isConsistent() {
        SOFMarkerSegment sOFMarkerSegment = (SOFMarkerSegment) findMarkerSegment(SOFMarkerSegment.class, true);
        JFIFMarkerSegment jFIFMarkerSegment = (JFIFMarkerSegment) findMarkerSegment(JFIFMarkerSegment.class, true);
        AdobeMarkerSegment adobeMarkerSegment = (AdobeMarkerSegment) findMarkerSegment(AdobeMarkerSegment.class, true);
        if (!this.isStream) {
            if (sOFMarkerSegment != null) {
                int length = sOFMarkerSegment.componentSpecs.length;
                int iCountScanBands = countScanBands();
                boolean z = iCountScanBands == 0 || iCountScanBands == length;
                if (jFIFMarkerSegment != null) {
                    if (length != 1 && length != 3) {
                        z = false;
                    }
                    int i = 0;
                    while (i < length) {
                        int i2 = sOFMarkerSegment.componentSpecs[i].componentId;
                        i++;
                        if (i2 != i) {
                            z = false;
                        }
                    }
                    if (adobeMarkerSegment != null && ((length == 1 && adobeMarkerSegment.transform != 0) || (length == 3 && adobeMarkerSegment.transform != 1))) {
                        return false;
                    }
                }
                return z;
            }
            SOSMarkerSegment sOSMarkerSegment = (SOSMarkerSegment) findMarkerSegment(SOSMarkerSegment.class, true);
            if (jFIFMarkerSegment != null || adobeMarkerSegment != null || sOFMarkerSegment != null || sOSMarkerSegment != null) {
                return false;
            }
        }
        return true;
    }

    private void mergeAdobeNode(Node node) throws IIOInvalidTreeException {
        AdobeMarkerSegment adobeMarkerSegment = (AdobeMarkerSegment) findMarkerSegment(AdobeMarkerSegment.class, true);
        if (adobeMarkerSegment != null) {
            adobeMarkerSegment.updateFromNativeNode(node, false);
        } else {
            insertAdobeMarkerSegment(new AdobeMarkerSegment(node));
        }
    }

    private void mergeCOMNode(Node node) {
        insertCOMMarkerSegment(new COMMarkerSegment(node));
    }

    private void mergeDHTNode(Node node) throws IIOInvalidTreeException {
        ArrayList arrayList = new ArrayList();
        for (MarkerSegment markerSegment : this.markerSequence) {
            if (markerSegment instanceof DHTMarkerSegment) {
                arrayList.add(markerSegment);
            }
        }
        if (arrayList.isEmpty()) {
            DHTMarkerSegment dHTMarkerSegment = new DHTMarkerSegment(node);
            int iFindMarkerSegmentPosition = findMarkerSegmentPosition(DQTMarkerSegment.class, false);
            int iFindMarkerSegmentPosition2 = findMarkerSegmentPosition(SOFMarkerSegment.class, true);
            int iFindMarkerSegmentPosition3 = findMarkerSegmentPosition(SOSMarkerSegment.class, true);
            if (iFindMarkerSegmentPosition != -1) {
                this.markerSequence.add(iFindMarkerSegmentPosition + 1, dHTMarkerSegment);
                return;
            }
            if (iFindMarkerSegmentPosition2 != -1) {
                this.markerSequence.add(iFindMarkerSegmentPosition2, dHTMarkerSegment);
                return;
            } else if (iFindMarkerSegmentPosition3 != -1) {
                this.markerSequence.add(iFindMarkerSegmentPosition3, dHTMarkerSegment);
                return;
            } else {
                this.markerSequence.add(dHTMarkerSegment);
                return;
            }
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            NamedNodeMap attributes = nodeItem.getAttributes();
            int attributeValue = MarkerSegment.getAttributeValue(nodeItem, attributes, "htableId", 0, 3, true);
            int attributeValue2 = MarkerSegment.getAttributeValue(nodeItem, attributes, Attribute.CLASS_ATTR, 0, 1, true);
            DHTMarkerSegment dHTMarkerSegment2 = null;
            int i2 = -1;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                DHTMarkerSegment dHTMarkerSegment3 = (DHTMarkerSegment) arrayList.get(i4);
                int i5 = 0;
                while (true) {
                    if (i5 >= dHTMarkerSegment3.tables.size()) {
                        break;
                    }
                    DHTMarkerSegment.Htable htable = (DHTMarkerSegment.Htable) dHTMarkerSegment3.tables.get(i5);
                    if (attributeValue == htable.tableID && attributeValue2 == htable.tableClass) {
                        dHTMarkerSegment2 = dHTMarkerSegment3;
                        i2 = i5;
                        break;
                    }
                    i5++;
                }
                if (dHTMarkerSegment2 != null) {
                    break;
                }
            }
            if (dHTMarkerSegment2 != null) {
                dHTMarkerSegment2.tables.set(i2, dHTMarkerSegment2.getHtableFromNode(nodeItem));
            } else {
                DHTMarkerSegment dHTMarkerSegment4 = (DHTMarkerSegment) AbstractC1974b.m1313f(1, arrayList);
                dHTMarkerSegment4.tables.add(dHTMarkerSegment4.getHtableFromNode(nodeItem));
            }
        }
    }

    private void mergeDQTNode(Node node) throws IIOInvalidTreeException {
        ArrayList arrayList = new ArrayList();
        for (MarkerSegment markerSegment : this.markerSequence) {
            if (markerSegment instanceof DQTMarkerSegment) {
                arrayList.add(markerSegment);
            }
        }
        if (arrayList.isEmpty()) {
            DQTMarkerSegment dQTMarkerSegment = new DQTMarkerSegment(node);
            int iFindMarkerSegmentPosition = findMarkerSegmentPosition(DHTMarkerSegment.class, true);
            int iFindMarkerSegmentPosition2 = findMarkerSegmentPosition(SOFMarkerSegment.class, true);
            int iFindMarkerSegmentPosition3 = findMarkerSegmentPosition(SOSMarkerSegment.class, true);
            if (iFindMarkerSegmentPosition != -1) {
                this.markerSequence.add(iFindMarkerSegmentPosition, dQTMarkerSegment);
                return;
            }
            if (iFindMarkerSegmentPosition2 != -1) {
                this.markerSequence.add(iFindMarkerSegmentPosition2, dQTMarkerSegment);
                return;
            } else if (iFindMarkerSegmentPosition3 != -1) {
                this.markerSequence.add(iFindMarkerSegmentPosition3, dQTMarkerSegment);
                return;
            } else {
                this.markerSequence.add(dQTMarkerSegment);
                return;
            }
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            DQTMarkerSegment dQTMarkerSegment2 = null;
            int attributeValue = MarkerSegment.getAttributeValue(nodeItem, null, "qtableId", 0, 3, true);
            int i2 = -1;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                DQTMarkerSegment dQTMarkerSegment3 = (DQTMarkerSegment) arrayList.get(i4);
                int i5 = 0;
                while (true) {
                    if (i5 >= dQTMarkerSegment3.tables.size()) {
                        break;
                    }
                    if (attributeValue == ((DQTMarkerSegment.Qtable) dQTMarkerSegment3.tables.get(i5)).tableID) {
                        dQTMarkerSegment2 = dQTMarkerSegment3;
                        i2 = i5;
                        break;
                    }
                    i5++;
                }
                if (dQTMarkerSegment2 != null) {
                    break;
                }
            }
            if (dQTMarkerSegment2 != null) {
                dQTMarkerSegment2.tables.set(i2, dQTMarkerSegment2.getQtableFromNode(nodeItem));
            } else {
                DQTMarkerSegment dQTMarkerSegment4 = (DQTMarkerSegment) AbstractC1974b.m1313f(1, arrayList);
                dQTMarkerSegment4.tables.add(dQTMarkerSegment4.getQtableFromNode(nodeItem));
            }
        }
    }

    private void mergeDRINode(Node node) {
        DRIMarkerSegment dRIMarkerSegment = (DRIMarkerSegment) findMarkerSegment(DRIMarkerSegment.class, true);
        if (dRIMarkerSegment != null) {
            dRIMarkerSegment.updateFromNativeNode(node, false);
            return;
        }
        DRIMarkerSegment dRIMarkerSegment2 = new DRIMarkerSegment(node);
        int iFindMarkerSegmentPosition = findMarkerSegmentPosition(SOFMarkerSegment.class, true);
        int iFindMarkerSegmentPosition2 = findMarkerSegmentPosition(SOSMarkerSegment.class, true);
        if (iFindMarkerSegmentPosition != -1) {
            this.markerSequence.add(iFindMarkerSegmentPosition, dRIMarkerSegment2);
        } else if (iFindMarkerSegmentPosition2 != -1) {
            this.markerSequence.add(iFindMarkerSegmentPosition2, dRIMarkerSegment2);
        } else {
            this.markerSequence.add(dRIMarkerSegment2);
        }
    }

    private void mergeJFIFsubtree(Node node) throws IIOInvalidTreeException {
        if (node.getChildNodes().getLength() != 0) {
            Node firstChild = node.getFirstChild();
            JFIFMarkerSegment jFIFMarkerSegment = (JFIFMarkerSegment) findMarkerSegment(JFIFMarkerSegment.class, true);
            if (jFIFMarkerSegment != null) {
                jFIFMarkerSegment.updateFromNativeNode(firstChild, false);
            } else {
                this.markerSequence.add(0, new JFIFMarkerSegment(firstChild));
            }
        }
    }

    private void mergeNativeTree(Node node) throws IIOInvalidTreeException {
        String nodeName = node.getNodeName();
        if (nodeName != (this.isStream ? JPEG.nativeStreamMetadataFormatName : JPEG.nativeImageMetadataFormatName)) {
            throw new IIOInvalidTreeException(AbstractC0541b.m772n("Invalid root node name: ", nodeName), node);
        }
        if (node.getChildNodes().getLength() != 2) {
            throw new IIOInvalidTreeException("JPEGvariety and markerSequence nodes must be present", node);
        }
        mergeJFIFsubtree(node.getFirstChild());
        mergeSequenceSubtree(node.getLastChild());
    }

    private void mergeSOFNode(Node node) throws IIOInvalidTreeException {
        SOFMarkerSegment sOFMarkerSegment = (SOFMarkerSegment) findMarkerSegment(SOFMarkerSegment.class, true);
        if (sOFMarkerSegment != null) {
            sOFMarkerSegment.updateFromNativeNode(node, false);
            return;
        }
        SOFMarkerSegment sOFMarkerSegment2 = new SOFMarkerSegment(node);
        int iFindMarkerSegmentPosition = findMarkerSegmentPosition(SOSMarkerSegment.class, true);
        if (iFindMarkerSegmentPosition != -1) {
            this.markerSequence.add(iFindMarkerSegmentPosition, sOFMarkerSegment2);
        } else {
            this.markerSequence.add(sOFMarkerSegment2);
        }
    }

    private void mergeSOSNode(Node node) throws IIOInvalidTreeException {
        SOSMarkerSegment sOSMarkerSegment = (SOSMarkerSegment) findMarkerSegment(SOSMarkerSegment.class, true);
        SOSMarkerSegment sOSMarkerSegment2 = (SOSMarkerSegment) findMarkerSegment(SOSMarkerSegment.class, false);
        if (sOSMarkerSegment == null) {
            this.markerSequence.add(new SOSMarkerSegment(node));
        } else {
            if (sOSMarkerSegment != sOSMarkerSegment2) {
                throw new IIOInvalidTreeException("Can't merge SOS node into a tree with > 1 SOS node", node);
            }
            sOSMarkerSegment.updateFromNativeNode(node, false);
        }
    }

    private void mergeSequenceSubtree(Node node) throws IIOInvalidTreeException {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            String nodeName = nodeItem.getNodeName();
            if (nodeName.equals("dqt")) {
                mergeDQTNode(nodeItem);
            } else if (nodeName.equals("dht")) {
                mergeDHTNode(nodeItem);
            } else if (nodeName.equals("dri")) {
                mergeDRINode(nodeItem);
            } else if (nodeName.equals("com")) {
                mergeCOMNode(nodeItem);
            } else if (nodeName.equals("app14Adobe")) {
                mergeAdobeNode(nodeItem);
            } else if (nodeName.equals("unknown")) {
                mergeUnknownNode(nodeItem);
            } else if (nodeName.equals("sof")) {
                mergeSOFNode(nodeItem);
            } else {
                if (!nodeName.equals("sos")) {
                    throw new IIOInvalidTreeException("Invalid node: ".concat(nodeName), nodeItem);
                }
                mergeSOSNode(nodeItem);
            }
        }
    }

    private void mergeStandardChromaNode(Node node, NodeList nodeList) throws IIOInvalidTreeException {
        int i;
        boolean z;
        boolean z2;
        int i2;
        boolean z3;
        char c;
        char c2;
        boolean zWantAlpha;
        int i4;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        if (this.transparencyDone) {
            throw new IIOInvalidTreeException("Transparency node must follow Chroma node", node);
        }
        Node firstChild = node.getFirstChild();
        if (firstChild == null || !firstChild.getNodeName().equals("ColorSpaceType")) {
            return;
        }
        String nodeValue = firstChild.getAttributes().getNamedItem("name").getNodeValue();
        boolean z8 = false;
        char c4 = 2;
        char c5 = 3;
        byte[] bArr = {1, 2, 3, 4};
        if (nodeValue.equals("GRAY")) {
            z2 = false;
            i2 = 0;
            z3 = false;
            i = 1;
            z = true;
        } else if (nodeValue.equals("YCbCr")) {
            i = 3;
            z2 = false;
            i2 = 0;
            z = true;
            z3 = true;
        } else if (nodeValue.equals("PhotoYCC")) {
            bArr[0] = 89;
            bArr[1] = 67;
            bArr[2] = 99;
            i = 3;
            z = false;
            z3 = false;
            z2 = true;
            i2 = 1;
        } else {
            if (nodeValue.equals("RGB")) {
                bArr[0] = 82;
                bArr[1] = 71;
                bArr[2] = 66;
                i = 3;
            } else {
                if (nodeValue.equals("XYZ") || nodeValue.equals("Lab") || nodeValue.equals("Luv") || nodeValue.equals("YxY") || nodeValue.equals("HSV") || nodeValue.equals("HLS") || nodeValue.equals("CMY") || nodeValue.equals("3CLR")) {
                    i = 3;
                } else if (nodeValue.equals("YCCK")) {
                    i = 4;
                    i2 = 2;
                    z = false;
                    z2 = true;
                    z3 = true;
                } else if (nodeValue.equals("CMYK")) {
                    i = 4;
                } else if (!nodeValue.equals("4CLR")) {
                    return;
                } else {
                    i = 4;
                }
                z = false;
                z2 = false;
                i2 = 0;
                z3 = false;
            }
            z = false;
            i2 = 0;
            z3 = false;
            z2 = true;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= nodeList.getLength()) {
                c = c4;
                c2 = c5;
                zWantAlpha = false;
                break;
            }
            Node nodeItem = nodeList.item(i5);
            c = c4;
            c2 = c5;
            if (nodeItem.getNodeName().equals("Transparency")) {
                zWantAlpha = wantAlpha(nodeItem);
                break;
            } else {
                i5++;
                c4 = c;
                c5 = c2;
            }
        }
        if (zWantAlpha) {
            int i6 = i + 1;
            if (bArr[0] == 82) {
                bArr[c2] = 65;
                i4 = i6;
                z4 = false;
                z = false;
            } else {
                boolean z9 = z2;
                i4 = i6;
                z4 = z9;
                z = false;
            }
        } else {
            boolean z10 = z2;
            i4 = i;
            z4 = z10;
        }
        JFIFMarkerSegment jFIFMarkerSegment = (JFIFMarkerSegment) findMarkerSegment(JFIFMarkerSegment.class, true);
        AdobeMarkerSegment adobeMarkerSegment = (AdobeMarkerSegment) findMarkerSegment(AdobeMarkerSegment.class, true);
        SOFMarkerSegment sOFMarkerSegment = (SOFMarkerSegment) findMarkerSegment(SOFMarkerSegment.class, true);
        SOSMarkerSegment sOSMarkerSegment = (SOSMarkerSegment) findMarkerSegment(SOSMarkerSegment.class, true);
        if (sOFMarkerSegment == null || sOFMarkerSegment.tag != 194 || sOFMarkerSegment.componentSpecs.length == i4 || sOSMarkerSegment == null) {
            if (!z && jFIFMarkerSegment != null) {
                this.markerSequence.remove(jFIFMarkerSegment);
            }
            if (z && !this.isStream) {
                this.markerSequence.add(0, new JFIFMarkerSegment());
            }
            if (z4) {
                if (adobeMarkerSegment != null || this.isStream) {
                    adobeMarkerSegment.transform = i2;
                } else {
                    insertAdobeMarkerSegment(new AdobeMarkerSegment(i2));
                }
            } else if (adobeMarkerSegment != null) {
                this.markerSequence.remove(adobeMarkerSegment);
            }
            int[] iArr = new int[4];
            iArr[0] = 0;
            iArr[1] = 1;
            iArr[c] = 1;
            iArr[c2] = 0;
            int[] iArr2 = new int[4];
            iArr2[0] = 0;
            iArr2[1] = 0;
            iArr2[c] = 0;
            iArr2[c2] = 0;
            if (!z3) {
                iArr = iArr2;
            }
            if (sOFMarkerSegment != null) {
                SOFMarkerSegment.ComponentSpec[] componentSpecArr = sOFMarkerSegment.componentSpecs;
                boolean z11 = sOFMarkerSegment.tag == 194;
                List list = this.markerSequence;
                int iIndexOf = list.indexOf(sOFMarkerSegment);
                z5 = z3;
                list.set(iIndexOf, new SOFMarkerSegment(z11, false, z5, bArr, i4));
                z7 = false;
                for (int i7 = 0; i7 < componentSpecArr.length; i7++) {
                    if (componentSpecArr[i7].QtableSelector != iArr[i7]) {
                        z7 = true;
                    }
                }
                if (z11) {
                    boolean z12 = false;
                    for (int i8 = 0; i8 < componentSpecArr.length; i8++) {
                        if (bArr[i8] != componentSpecArr[i8].componentId) {
                            z12 = true;
                        }
                    }
                    if (z12) {
                        for (MarkerSegment markerSegment : this.markerSequence) {
                            if (markerSegment instanceof SOSMarkerSegment) {
                                SOSMarkerSegment sOSMarkerSegment2 = (SOSMarkerSegment) markerSegment;
                                int i9 = 0;
                                while (true) {
                                    SOSMarkerSegment.ScanComponentSpec[] scanComponentSpecArr = sOSMarkerSegment2.componentSpecs;
                                    if (i9 < scanComponentSpecArr.length) {
                                        int i10 = scanComponentSpecArr[i9].componentSelector;
                                        for (int i11 = 0; i11 < componentSpecArr.length; i11++) {
                                            if (componentSpecArr[i11].componentId == i10) {
                                                sOSMarkerSegment2.componentSpecs[i9].componentSelector = bArr[i11];
                                            }
                                        }
                                        i9++;
                                    }
                                }
                            }
                        }
                    }
                } else if (sOSMarkerSegment != null) {
                    int i12 = 0;
                    z6 = false;
                    while (true) {
                        SOSMarkerSegment.ScanComponentSpec[] scanComponentSpecArr2 = sOSMarkerSegment.componentSpecs;
                        if (i12 >= scanComponentSpecArr2.length) {
                            break;
                        }
                        SOSMarkerSegment.ScanComponentSpec scanComponentSpec = scanComponentSpecArr2[i12];
                        int i13 = scanComponentSpec.dcHuffTable;
                        int i14 = iArr[i12];
                        if (i13 != i14 || scanComponentSpec.acHuffTable != i14) {
                            z6 = true;
                        }
                        i12++;
                    }
                    List list2 = this.markerSequence;
                    list2.set(list2.indexOf(sOSMarkerSegment), new SOSMarkerSegment(z5, bArr, i4));
                }
                z6 = false;
            } else {
                z5 = z3;
                z6 = this.isStream;
                z7 = z6;
            }
            if (z7) {
                ArrayList arrayList = new ArrayList();
                for (MarkerSegment markerSegment2 : this.markerSequence) {
                    if (markerSegment2 instanceof DQTMarkerSegment) {
                        arrayList.add(markerSegment2);
                    }
                }
                if (!arrayList.isEmpty() && z5) {
                    Iterator it = arrayList.iterator();
                    boolean z13 = false;
                    while (it.hasNext()) {
                        Iterator it2 = ((DQTMarkerSegment) it.next()).tables.iterator();
                        while (it2.hasNext()) {
                            if (((DQTMarkerSegment.Qtable) it2.next()).tableID == 1) {
                                z13 = true;
                            }
                        }
                    }
                    if (!z13) {
                        Iterator it3 = arrayList.iterator();
                        DQTMarkerSegment.Qtable qtable = null;
                        while (it3.hasNext()) {
                            for (DQTMarkerSegment.Qtable qtable2 : ((DQTMarkerSegment) it3.next()).tables) {
                                if (qtable2.tableID == 0) {
                                    qtable = qtable2;
                                }
                            }
                        }
                        DQTMarkerSegment dQTMarkerSegment = (DQTMarkerSegment) AbstractC1974b.m1313f(1, arrayList);
                        dQTMarkerSegment.tables.add(dQTMarkerSegment.getChromaForLuma(qtable));
                    }
                }
            }
            if (z6) {
                ArrayList arrayList2 = new ArrayList();
                for (MarkerSegment markerSegment3 : this.markerSequence) {
                    if (markerSegment3 instanceof DHTMarkerSegment) {
                        arrayList2.add(markerSegment3);
                    }
                }
                if (arrayList2.isEmpty() || !z5) {
                    return;
                }
                Iterator it4 = arrayList2.iterator();
                while (it4.hasNext()) {
                    Iterator it5 = ((DHTMarkerSegment) it4.next()).tables.iterator();
                    while (it5.hasNext()) {
                        if (((DHTMarkerSegment.Htable) it5.next()).tableID == 1) {
                            z8 = true;
                        }
                    }
                }
                if (z8) {
                    return;
                }
                DHTMarkerSegment dHTMarkerSegment = (DHTMarkerSegment) AbstractC1974b.m1313f(1, arrayList2);
                dHTMarkerSegment.addHtable(JPEGHuffmanTable.StdDCLuminance, true, 1);
                dHTMarkerSegment.addHtable(JPEGHuffmanTable.StdACLuminance, true, 1);
            }
        }
    }

    private void mergeStandardCompressionNode(Node node) {
    }

    private void mergeStandardDataNode(Node node) {
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void mergeStandardDimensionNode(Node node) {
        boolean z;
        int length;
        JFIFMarkerSegment jFIFMarkerSegment = (JFIFMarkerSegment) findMarkerSegment(JFIFMarkerSegment.class, true);
        if (jFIFMarkerSegment == null) {
            SOFMarkerSegment sOFMarkerSegment = (SOFMarkerSegment) findMarkerSegment(SOFMarkerSegment.class, true);
            if (sOFMarkerSegment == null || !((length = sOFMarkerSegment.componentSpecs.length) == 1 || length == 3)) {
                z = false;
                if (z) {
                    jFIFMarkerSegment = new JFIFMarkerSegment();
                    this.markerSequence.add(0, jFIFMarkerSegment);
                }
            } else {
                z = true;
                int i = 0;
                while (true) {
                    SOFMarkerSegment.ComponentSpec[] componentSpecArr = sOFMarkerSegment.componentSpecs;
                    if (i >= componentSpecArr.length) {
                        break;
                    }
                    int i2 = componentSpecArr[i].componentId;
                    i++;
                    if (i2 != i) {
                        z = false;
                    }
                }
                AdobeMarkerSegment adobeMarkerSegment = (AdobeMarkerSegment) findMarkerSegment(AdobeMarkerSegment.class, true);
                if (adobeMarkerSegment != null) {
                    if (adobeMarkerSegment.transform != (length == 1 ? 0 : 1)) {
                    }
                }
                if (z) {
                }
            }
        }
        if (jFIFMarkerSegment != null) {
            NodeList childNodes = node.getChildNodes();
            for (int i4 = 0; i4 < childNodes.getLength(); i4++) {
                Node nodeItem = childNodes.item(i4);
                NamedNodeMap attributes = nodeItem.getAttributes();
                String nodeName = nodeItem.getNodeName();
                if (nodeName.equals("PixelAspectRatio")) {
                    Point pointFindIntegerRatio = findIntegerRatio(Float.parseFloat(attributes.getNamedItem("value").getNodeValue()));
                    jFIFMarkerSegment.resUnits = 0;
                    int i5 = pointFindIntegerRatio.f10092x;
                    jFIFMarkerSegment.Xdensity = pointFindIntegerRatio.f10093y;
                } else if (nodeName.equals("HorizontalPixelSize")) {
                    int iRound = (int) Math.round(1.0d / (((double) Float.parseFloat(attributes.getNamedItem("value").getNodeValue())) * 10.0d));
                    jFIFMarkerSegment.resUnits = 2;
                    jFIFMarkerSegment.Xdensity = iRound;
                } else if (nodeName.equals("VerticalPixelSize")) {
                    int iRound2 = (int) Math.round(1.0d / (((double) Float.parseFloat(attributes.getNamedItem("value").getNodeValue())) * 10.0d));
                    jFIFMarkerSegment.resUnits = 2;
                    jFIFMarkerSegment.Ydensity = iRound2;
                }
            }
        }
    }

    private void mergeStandardDocumentNode(Node node) {
    }

    private void mergeStandardTextNode(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            NamedNodeMap attributes = childNodes.item(i).getAttributes();
            Node namedItem = attributes.getNamedItem("compression");
            if (namedItem == null || namedItem.getNodeValue().equals("none")) {
                insertCOMMarkerSegment(new COMMarkerSegment(attributes.getNamedItem("value").getNodeValue()));
            }
        }
    }

    private void mergeStandardTransparencyNode(Node node) {
        SOFMarkerSegment.ComponentSpec[] componentSpecArr;
        if (this.transparencyDone || this.isStream) {
            return;
        }
        boolean zWantAlpha = wantAlpha(node);
        JFIFMarkerSegment jFIFMarkerSegment = (JFIFMarkerSegment) findMarkerSegment(JFIFMarkerSegment.class, true);
        AdobeMarkerSegment adobeMarkerSegment = (AdobeMarkerSegment) findMarkerSegment(AdobeMarkerSegment.class, true);
        SOFMarkerSegment sOFMarkerSegment = (SOFMarkerSegment) findMarkerSegment(SOFMarkerSegment.class, true);
        SOSMarkerSegment sOSMarkerSegment = (SOSMarkerSegment) findMarkerSegment(SOSMarkerSegment.class, true);
        if ((sOFMarkerSegment != null && sOFMarkerSegment.tag == 194) || sOFMarkerSegment == null) {
            return;
        }
        int length = sOFMarkerSegment.componentSpecs.length;
        if ((length == 2 || length == 4) == zWantAlpha) {
            return;
        }
        if (!zWantAlpha) {
            int i = length - 1;
            SOFMarkerSegment.ComponentSpec[] componentSpecArr2 = new SOFMarkerSegment.ComponentSpec[i];
            for (int i2 = 0; i2 < i; i2++) {
                componentSpecArr2[i2] = sOFMarkerSegment.componentSpecs[i2];
            }
            sOFMarkerSegment.componentSpecs = componentSpecArr2;
            SOSMarkerSegment.ScanComponentSpec[] scanComponentSpecArr = new SOSMarkerSegment.ScanComponentSpec[i];
            for (int i4 = 0; i4 < i; i4++) {
                scanComponentSpecArr[i4] = sOSMarkerSegment.componentSpecs[i4];
            }
            sOSMarkerSegment.componentSpecs = scanComponentSpecArr;
            return;
        }
        int i5 = length + 1;
        if (jFIFMarkerSegment != null) {
            this.markerSequence.remove(jFIFMarkerSegment);
        }
        if (adobeMarkerSegment != null) {
            adobeMarkerSegment.transform = 0;
        }
        SOFMarkerSegment.ComponentSpec[] componentSpecArr3 = new SOFMarkerSegment.ComponentSpec[i5];
        int i6 = 0;
        while (true) {
            componentSpecArr = sOFMarkerSegment.componentSpecs;
            if (i6 >= componentSpecArr.length) {
                break;
            }
            componentSpecArr3[i6] = componentSpecArr[i6];
            i6++;
        }
        SOFMarkerSegment.ComponentSpec componentSpec = componentSpecArr[0];
        byte b = (byte) (((byte) componentSpec.componentId) > 1 ? 65 : 4);
        componentSpecArr3[length] = sOFMarkerSegment.getComponentSpec(b, componentSpec.HsamplingFactor, componentSpec.QtableSelector);
        sOFMarkerSegment.componentSpecs = componentSpecArr3;
        SOSMarkerSegment.ScanComponentSpec[] scanComponentSpecArr2 = new SOSMarkerSegment.ScanComponentSpec[i5];
        int i7 = 0;
        while (true) {
            SOSMarkerSegment.ScanComponentSpec[] scanComponentSpecArr3 = sOSMarkerSegment.componentSpecs;
            if (i7 >= scanComponentSpecArr3.length) {
                scanComponentSpecArr2[length] = sOSMarkerSegment.getScanComponentSpec(b, 0);
                sOSMarkerSegment.componentSpecs = scanComponentSpecArr2;
                return;
            } else {
                scanComponentSpecArr2[i7] = scanComponentSpecArr3[i7];
                i7++;
            }
        }
    }

    private void mergeStandardTree(Node node) throws IIOInvalidTreeException {
        this.transparencyDone = false;
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            String nodeName = nodeItem.getNodeName();
            if (nodeName.equals("Chroma")) {
                mergeStandardChromaNode(nodeItem, childNodes);
            } else if (nodeName.equals(ExifInterface.TAG_COMPRESSION)) {
                mergeStandardCompressionNode(nodeItem);
            } else if (nodeName.equals("Data")) {
                mergeStandardDataNode(nodeItem);
            } else if (nodeName.equals("Dimension")) {
                mergeStandardDimensionNode(nodeItem);
            } else if (nodeName.equals("Document")) {
                mergeStandardDocumentNode(nodeItem);
            } else if (nodeName.equals(Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT)) {
                mergeStandardTextNode(nodeItem);
            } else {
                if (!nodeName.equals("Transparency")) {
                    throw new IIOInvalidTreeException("Invalid node: ".concat(nodeName), nodeItem);
                }
                mergeStandardTransparencyNode(nodeItem);
            }
        }
    }

    private void mergeUnknownNode(Node node) {
        MarkerSegment markerSegment = new MarkerSegment(node);
        int iFindLastUnknownMarkerSegmentPosition = findLastUnknownMarkerSegmentPosition();
        boolean z = findMarkerSegment(JFIFMarkerSegment.class, true) != null;
        int iFindMarkerSegmentPosition = findMarkerSegmentPosition(AdobeMarkerSegment.class, true);
        if (iFindLastUnknownMarkerSegmentPosition != -1) {
            this.markerSequence.add(iFindLastUnknownMarkerSegmentPosition + 1, markerSegment);
        } else if (z) {
            this.markerSequence.add(1, markerSegment);
        }
        if (iFindMarkerSegmentPosition != -1) {
            this.markerSequence.add(iFindMarkerSegmentPosition, markerSegment);
        } else {
            this.markerSequence.add(0, markerSegment);
        }
    }

    private void setFromNativeTree(Node node) throws IIOInvalidTreeException {
        if (this.resetSequence == null) {
            this.resetSequence = this.markerSequence;
        }
        this.markerSequence = new ArrayList();
        String nodeName = node.getNodeName();
        boolean z = this.isStream;
        if (nodeName != (z ? JPEG.nativeStreamMetadataFormatName : JPEG.nativeImageMetadataFormatName)) {
            throw new IIOInvalidTreeException(AbstractC0541b.m772n("Invalid root node name: ", nodeName), node);
        }
        if (!z) {
            if (node.getChildNodes().getLength() != 2) {
                throw new IIOInvalidTreeException("JPEGvariety and markerSequence nodes must be present", node);
            }
            Node firstChild = node.getFirstChild();
            if (firstChild.getChildNodes().getLength() != 0) {
                this.markerSequence.add(new JFIFMarkerSegment(firstChild.getFirstChild()));
            }
        }
        if (!this.isStream) {
            node = node.getLastChild();
        }
        setFromMarkerSequenceNode(node);
    }

    private boolean wantAlpha(Node node) {
        Node firstChild = node.getFirstChild();
        boolean z = firstChild.getNodeName().equals("Alpha") && firstChild.hasAttributes() && !firstChild.getAttributes().getNamedItem("value").getNodeValue().equals("none");
        this.transparencyDone = true;
        return z;
    }

    public Object clone() {
        JPEGMetadata jPEGMetadata;
        try {
            jPEGMetadata = (JPEGMetadata) super.clone();
        } catch (CloneNotSupportedException unused) {
            jPEGMetadata = null;
        }
        if (this.markerSequence != null) {
            jPEGMetadata.markerSequence = cloneSequence();
        }
        jPEGMetadata.resetSequence = null;
        return jPEGMetadata;
    }

    public MarkerSegment findMarkerSegment(int i) {
        for (MarkerSegment markerSegment : this.markerSequence) {
            if (markerSegment.tag == i) {
                return markerSegment;
            }
        }
        return null;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public Node getAsTree(String str) {
        if (str == null) {
            throw new IllegalArgumentException("null formatName!");
        }
        if (this.isStream) {
            if (str.equals(JPEG.nativeStreamMetadataFormatName)) {
                return getNativeTree();
            }
        } else {
            if (str.equals(JPEG.nativeImageMetadataFormatName)) {
                return getNativeTree();
            }
            if (str.equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
                return getStandardTree();
            }
        }
        throw new IllegalArgumentException("Unsupported format name: ".concat(str));
    }

    public IIOMetadataNode getNativeTree() {
        IIOMetadataNode iIOMetadataNode;
        IIOMetadataNode iIOMetadataNode2;
        IIOMetadataNode iIOMetadataNode3;
        Iterator it = this.markerSequence.iterator();
        if (this.isStream) {
            iIOMetadataNode3 = new IIOMetadataNode(JPEG.nativeStreamMetadataFormatName);
            iIOMetadataNode2 = iIOMetadataNode3;
        } else {
            Node iIOMetadataNode4 = new IIOMetadataNode("markerSequence");
            if (this.inThumb) {
                iIOMetadataNode = iIOMetadataNode4;
            } else {
                iIOMetadataNode = new IIOMetadataNode(JPEG.nativeImageMetadataFormatName);
                IIOMetadataNode iIOMetadataNode5 = new IIOMetadataNode("JPEGvariety");
                iIOMetadataNode.appendChild(iIOMetadataNode5);
                JFIFMarkerSegment jFIFMarkerSegment = (JFIFMarkerSegment) findMarkerSegment(JFIFMarkerSegment.class, true);
                if (jFIFMarkerSegment != null) {
                    it.next();
                    iIOMetadataNode5.appendChild(jFIFMarkerSegment.getNativeNode());
                }
                iIOMetadataNode.appendChild(iIOMetadataNode4);
            }
            IIOMetadataNode iIOMetadataNode6 = iIOMetadataNode;
            iIOMetadataNode2 = iIOMetadataNode4;
            iIOMetadataNode3 = iIOMetadataNode6;
        }
        while (it.hasNext()) {
            iIOMetadataNode2.appendChild(((MarkerSegment) it.next()).getNativeNode());
        }
        return iIOMetadataNode3;
    }

    /* JADX WARN: Removed duplicated region for block: B:74:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0127 A[SYNTHETIC] */
    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public IIOMetadataNode getStandardChromaNode() {
        SOFMarkerSegment.ComponentSpec[] componentSpecArr;
        char c;
        int i;
        SOFMarkerSegment.ComponentSpec[] componentSpecArr2;
        this.hasAlpha = false;
        char c2 = 1;
        SOFMarkerSegment sOFMarkerSegment = (SOFMarkerSegment) findMarkerSegment(SOFMarkerSegment.class, true);
        if (sOFMarkerSegment == null) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Chroma");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("ColorSpaceType");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        int length = sOFMarkerSegment.componentSpecs.length;
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("NumChannels");
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        iIOMetadataNode3.setAttribute("value", Integer.toString(length));
        if (findMarkerSegment(JFIFMarkerSegment.class, true) != null) {
            if (length == 1) {
                iIOMetadataNode2.setAttribute("name", "GRAY");
                return iIOMetadataNode;
            }
            iIOMetadataNode2.setAttribute("name", "YCbCr");
            return iIOMetadataNode;
        }
        AdobeMarkerSegment adobeMarkerSegment = (AdobeMarkerSegment) findMarkerSegment(AdobeMarkerSegment.class, true);
        char c4 = 2;
        if (adobeMarkerSegment != null) {
            int i2 = adobeMarkerSegment.transform;
            if (i2 != 0) {
                if (i2 == 1) {
                    iIOMetadataNode2.setAttribute("name", "YCbCr");
                    return iIOMetadataNode;
                }
                if (i2 == 2) {
                    iIOMetadataNode2.setAttribute("name", "YCCK");
                    return iIOMetadataNode;
                }
            } else {
                if (length == 3) {
                    iIOMetadataNode2.setAttribute("name", "RGB");
                    return iIOMetadataNode;
                }
                if (length == 4) {
                    iIOMetadataNode2.setAttribute("name", "CMYK");
                    return iIOMetadataNode;
                }
            }
        } else if (length < 3) {
            iIOMetadataNode2.setAttribute("name", "GRAY");
            if (length == 2) {
                this.hasAlpha = true;
                return iIOMetadataNode;
            }
        } else {
            int i4 = 0;
            boolean z = true;
            while (true) {
                componentSpecArr = sOFMarkerSegment.componentSpecs;
                c = c4;
                if (i4 >= componentSpecArr.length) {
                    break;
                }
                int i5 = componentSpecArr[i4].componentId;
                if (i5 < 1 || i5 >= componentSpecArr.length) {
                    z = false;
                }
                i4++;
                c4 = c;
            }
            if (z) {
                iIOMetadataNode2.setAttribute("name", "YCbCr");
                if (length == 4) {
                    this.hasAlpha = true;
                    return iIOMetadataNode;
                }
            } else {
                SOFMarkerSegment.ComponentSpec componentSpec = componentSpecArr[0];
                int i6 = componentSpec.componentId;
                if (i6 != 82) {
                    if (i6 != 89 && componentSpecArr[c2].componentId == 67 && componentSpecArr[c].componentId == 99) {
                        iIOMetadataNode2.setAttribute("name", "PhotoYCC");
                        if (length == 4 && sOFMarkerSegment.componentSpecs[3].componentId == 65) {
                            this.hasAlpha = true;
                            return iIOMetadataNode;
                        }
                    } else {
                        int i7 = componentSpec.HsamplingFactor;
                        int i8 = componentSpec.VsamplingFactor;
                        i = 1;
                        while (true) {
                            componentSpecArr2 = sOFMarkerSegment.componentSpecs;
                            if (i < componentSpecArr2.length) {
                                if (length == 3) {
                                    iIOMetadataNode2.setAttribute("name", "RGB");
                                    return iIOMetadataNode;
                                }
                                iIOMetadataNode2.setAttribute("name", "CMYK");
                                return iIOMetadataNode;
                            }
                            SOFMarkerSegment.ComponentSpec componentSpec2 = componentSpecArr2[i];
                            if (componentSpec2.HsamplingFactor != i7 || componentSpec2.VsamplingFactor != i8) {
                                break;
                            }
                            i++;
                        }
                        iIOMetadataNode2.setAttribute("name", "YCbCr");
                        if (length == 4) {
                            this.hasAlpha = true;
                        }
                    }
                } else if (componentSpecArr[1].componentId == 71 && componentSpecArr[c].componentId == 66) {
                    iIOMetadataNode2.setAttribute("name", "RGB");
                    if (length == 4 && sOFMarkerSegment.componentSpecs[3].componentId == 65) {
                        this.hasAlpha = true;
                        return iIOMetadataNode;
                    }
                } else {
                    c2 = 1;
                    if (i6 != 89) {
                        int i72 = componentSpec.HsamplingFactor;
                        int i82 = componentSpec.VsamplingFactor;
                        i = 1;
                        while (true) {
                            componentSpecArr2 = sOFMarkerSegment.componentSpecs;
                            if (i < componentSpecArr2.length) {
                            }
                            i++;
                        }
                    }
                }
            }
        }
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardCompressionNode() {
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(ExifInterface.TAG_COMPRESSION);
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("CompressionTypeName");
        iIOMetadataNode2.setAttribute("value", "JPEG");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("Lossless");
        iIOMetadataNode3.setAttribute("value", "FALSE");
        iIOMetadataNode.appendChild(iIOMetadataNode3);
        Iterator it = this.markerSequence.iterator();
        int i = 0;
        while (it.hasNext()) {
            if (((MarkerSegment) it.next()).tag == 218) {
                i++;
            }
        }
        if (i != 0) {
            IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("NumProgressiveScans");
            iIOMetadataNode4.setAttribute("value", Integer.toString(i));
            iIOMetadataNode.appendChild(iIOMetadataNode4);
        }
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardDimensionNode() {
        float f;
        int i;
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Dimension");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("ImageOrientation");
        iIOMetadataNode2.setAttribute("value", FolderNodeItem.SYNC_WDOC_FOLDER_NODE_STATE_NORMAL);
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        JFIFMarkerSegment jFIFMarkerSegment = (JFIFMarkerSegment) findMarkerSegment(JFIFMarkerSegment.class, true);
        if (jFIFMarkerSegment != null) {
            if (jFIFMarkerSegment.resUnits == 0) {
                f = jFIFMarkerSegment.Xdensity;
                i = jFIFMarkerSegment.Ydensity;
            } else {
                f = jFIFMarkerSegment.Ydensity;
                i = jFIFMarkerSegment.Xdensity;
            }
            float f4 = f / i;
            IIOMetadataNode iIOMetadataNode3 = new IIOMetadataNode("PixelAspectRatio");
            iIOMetadataNode3.setAttribute("value", Float.toString(f4));
            iIOMetadataNode.insertBefore(iIOMetadataNode3, iIOMetadataNode2);
            int i2 = jFIFMarkerSegment.resUnits;
            if (i2 != 0) {
                float f5 = i2 == 1 ? 25.4f : 10.0f;
                IIOMetadataNode iIOMetadataNode4 = new IIOMetadataNode("HorizontalPixelSize");
                iIOMetadataNode4.setAttribute("value", Float.toString(f5 / jFIFMarkerSegment.Xdensity));
                iIOMetadataNode.appendChild(iIOMetadataNode4);
                IIOMetadataNode iIOMetadataNode5 = new IIOMetadataNode("VerticalPixelSize");
                iIOMetadataNode5.setAttribute("value", Float.toString(f5 / jFIFMarkerSegment.Ydensity));
                iIOMetadataNode.appendChild(iIOMetadataNode5);
            }
        }
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardTextNode() {
        if (findMarkerSegment(JPEG.COM) == null) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode(Bixby2Constants.SLOT_VALUE_SHARE_AS_TEXT);
        for (MarkerSegment markerSegment : this.markerSequence) {
            if (markerSegment.tag == 254) {
                IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("TextEntry");
                iIOMetadataNode2.setAttribute(Bixby2Constants.BIXBY_PARAM_KEYWORD, ClientCookie.COMMENT_ATTR);
                iIOMetadataNode2.setAttribute("value", ((COMMarkerSegment) markerSegment).getComment());
                iIOMetadataNode.appendChild(iIOMetadataNode2);
            }
        }
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public IIOMetadataNode getStandardTransparencyNode() {
        if (!this.hasAlpha) {
            return null;
        }
        IIOMetadataNode iIOMetadataNode = new IIOMetadataNode("Transparency");
        IIOMetadataNode iIOMetadataNode2 = new IIOMetadataNode("Alpha");
        iIOMetadataNode2.setAttribute("value", "nonpremultiplied");
        iIOMetadataNode.appendChild(iIOMetadataNode2);
        return iIOMetadataNode;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public boolean isReadOnly() {
        return false;
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void mergeTree(String str, Node node) throws IIOInvalidTreeException {
        List listCloneSequence;
        if (str == null) {
            throw new IllegalArgumentException("null formatName!");
        }
        if (node == null) {
            throw new IllegalArgumentException("null root!");
        }
        if (this.resetSequence == null) {
            listCloneSequence = cloneSequence();
            this.resetSequence = listCloneSequence;
        } else {
            listCloneSequence = cloneSequence();
        }
        if (this.isStream && str.equals(JPEG.nativeStreamMetadataFormatName)) {
            mergeNativeTree(node);
        } else if (!this.isStream && str.equals(JPEG.nativeImageMetadataFormatName)) {
            mergeNativeTree(node);
        } else {
            if (this.isStream || !str.equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
                throw new IllegalArgumentException("Unsupported format name: ".concat(str));
            }
            mergeStandardTree(node);
        }
        if (isConsistent()) {
            return;
        }
        this.markerSequence = listCloneSequence;
        throw new IIOInvalidTreeException("Merged tree is invalid; original restored", node);
    }

    public void print() {
        for (int i = 0; i < this.markerSequence.size(); i++) {
            ((MarkerSegment) this.markerSequence.get(i)).print();
        }
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void reset() {
        List list = this.resetSequence;
        if (list != null) {
            this.markerSequence = list;
            this.resetSequence = null;
        }
    }

    public void setFromMarkerSequenceNode(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            String nodeName = nodeItem.getNodeName();
            if (nodeName.equals("dqt")) {
                this.markerSequence.add(new DQTMarkerSegment(nodeItem));
            } else if (nodeName.equals("dht")) {
                this.markerSequence.add(new DHTMarkerSegment(nodeItem));
            } else if (nodeName.equals("dri")) {
                this.markerSequence.add(new DRIMarkerSegment(nodeItem));
            } else if (nodeName.equals("com")) {
                this.markerSequence.add(new COMMarkerSegment(nodeItem));
            } else if (nodeName.equals("app14Adobe")) {
                this.markerSequence.add(new AdobeMarkerSegment(nodeItem));
            } else if (nodeName.equals("unknown")) {
                this.markerSequence.add(new MarkerSegment(nodeItem));
            } else if (nodeName.equals("sof")) {
                this.markerSequence.add(new SOFMarkerSegment(nodeItem));
            } else {
                if (!nodeName.equals("sos")) {
                    throw new IIOInvalidTreeException(AbstractC2322a.m1626p(new StringBuilder("Invalid "), this.isStream ? "stream " : "image ", "child: ", nodeName), nodeItem);
                }
                this.markerSequence.add(new SOSMarkerSegment(nodeItem));
            }
        }
    }

    @Override // org.apache.poi.javax.imageio.metadata.IIOMetadata
    public void setFromTree(String str, Node node) throws IIOInvalidTreeException {
        if (str == null) {
            throw new IllegalArgumentException("null formatName!");
        }
        if (node == null) {
            throw new IllegalArgumentException("null root!");
        }
        if (this.isStream && str.equals(JPEG.nativeStreamMetadataFormatName)) {
            setFromNativeTree(node);
            return;
        }
        if (!this.isStream && str.equals(JPEG.nativeImageMetadataFormatName)) {
            setFromNativeTree(node);
        } else {
            if (this.isStream || !str.equals(IIOMetadataFormatImpl.standardMetadataFormatName)) {
                throw new IllegalArgumentException("Unsupported format name: ".concat(str));
            }
            super.setFromTree(str, node);
        }
    }

    public void writeToStream(ImageOutputStream imageOutputStream, boolean z, boolean z2, List list, ICC_Profile iCC_Profile, boolean z3, int i, JPEGImageWriter jPEGImageWriter) {
        if (z2) {
            JFIFMarkerSegment.writeDefaultJFIF(imageOutputStream, list, iCC_Profile, jPEGImageWriter);
            if (!z3 && i != -1 && i != 0 && i != 1) {
                jPEGImageWriter.warningOccurred(13);
                z3 = true;
            }
        }
        for (MarkerSegment markerSegment : this.markerSequence) {
            if (markerSegment instanceof JFIFMarkerSegment) {
                if (!z) {
                    ((JFIFMarkerSegment) markerSegment).writeWithThumbs(imageOutputStream, list, jPEGImageWriter);
                    if (iCC_Profile != null) {
                        JFIFMarkerSegment.writeICC(iCC_Profile, imageOutputStream);
                    }
                }
            } else if (!(markerSegment instanceof AdobeMarkerSegment)) {
                markerSegment.write(imageOutputStream);
            } else if (!z3) {
                if (i != -1) {
                    AdobeMarkerSegment adobeMarkerSegment = (AdobeMarkerSegment) markerSegment.clone();
                    adobeMarkerSegment.transform = i;
                    adobeMarkerSegment.write(imageOutputStream);
                } else if (z2) {
                    AdobeMarkerSegment adobeMarkerSegment2 = (AdobeMarkerSegment) markerSegment;
                    int i2 = adobeMarkerSegment2.transform;
                    if (i2 == 0 || i2 == 1) {
                        adobeMarkerSegment2.write(imageOutputStream);
                    } else {
                        jPEGImageWriter.warningOccurred(13);
                    }
                } else {
                    markerSegment.write(imageOutputStream);
                }
            }
        }
    }

    public MarkerSegment findMarkerSegment(Class cls, boolean z) {
        if (z) {
            for (MarkerSegment markerSegment : this.markerSequence) {
                if (cls.isInstance(markerSegment)) {
                    return markerSegment;
                }
            }
            return null;
        }
        List list = this.markerSequence;
        ListIterator listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            MarkerSegment markerSegment2 = (MarkerSegment) listIterator.previous();
            if (cls.isInstance(markerSegment2)) {
                return markerSegment2;
            }
        }
        return null;
    }

    public JPEGMetadata(boolean z, boolean z2, ImageInputStream imageInputStream, JPEGImageReader jPEGImageReader) throws IIOException {
        this(z, z2);
        JPEGBuffer jPEGBuffer = new JPEGBuffer(imageInputStream);
        boolean z3 = false;
        jPEGBuffer.loadBuf(0);
        byte[] bArr = jPEGBuffer.buf;
        if ((bArr[0] & 255) == 255 && (bArr[1] & 255) == 216 && (bArr[2] & 255) == 255) {
            jPEGBuffer.bufAvail -= 2;
            jPEGBuffer.bufPtr = 2;
            while (true) {
                MarkerSegment dHTMarkerSegment = null;
                while (!z3) {
                    jPEGBuffer.loadBuf(1);
                    jPEGBuffer.scanForFF(jPEGImageReader);
                    byte[] bArr2 = jPEGBuffer.buf;
                    int i = jPEGBuffer.bufPtr;
                    int i2 = bArr2[i] & 255;
                    if (i2 == 0) {
                        jPEGBuffer.bufAvail--;
                        jPEGBuffer.bufPtr = i + 1;
                    } else if (i2 == 196) {
                        dHTMarkerSegment = new DHTMarkerSegment(jPEGBuffer);
                    } else if (i2 == 221) {
                        dHTMarkerSegment = new DRIMarkerSegment(jPEGBuffer);
                    } else if (i2 == 224) {
                        jPEGBuffer.loadBuf(8);
                        byte[] bArr3 = jPEGBuffer.buf;
                        int i4 = jPEGBuffer.bufPtr;
                        byte b = bArr3[i4 + 3];
                        if (b == 74 && bArr3[i4 + 4] == 70 && bArr3[i4 + 5] == 73 && bArr3[i4 + 6] == 70 && bArr3[i4 + 7] == 0) {
                            if (this.inThumb) {
                                jPEGImageReader.warningOccurred(1);
                                new JFIFMarkerSegment(jPEGBuffer);
                            } else if (!z) {
                                if (this.markerSequence.isEmpty()) {
                                    dHTMarkerSegment = new JFIFMarkerSegment(jPEGBuffer);
                                } else {
                                    throw new IIOException("JFIF APP0 must be first marker after SOI");
                                }
                            } else {
                                throw new IIOException("JFIF not permitted in stream metadata");
                            }
                        } else if (b != 74 || bArr3[i4 + 4] != 70 || bArr3[i4 + 5] != 88 || bArr3[i4 + 6] != 88 || bArr3[i4 + 7] != 0) {
                            dHTMarkerSegment = new MarkerSegment(jPEGBuffer);
                            dHTMarkerSegment.loadData(jPEGBuffer);
                        } else if (!z) {
                            if (!this.inThumb) {
                                JFIFMarkerSegment jFIFMarkerSegment = (JFIFMarkerSegment) findMarkerSegment(JFIFMarkerSegment.class, true);
                                if (jFIFMarkerSegment != null) {
                                    jFIFMarkerSegment.addJFXX(jPEGBuffer, jPEGImageReader);
                                } else {
                                    throw new IIOException("JFXX encountered without prior JFIF!");
                                }
                            } else {
                                throw new IIOException("JFXX markers not allowed in JFIF JPEG thumbnail");
                            }
                        } else {
                            throw new IIOException("JFXX not permitted in stream metadata");
                        }
                    } else if (i2 == 226) {
                        jPEGBuffer.loadBuf(15);
                        byte[] bArr4 = jPEGBuffer.buf;
                        int i5 = jPEGBuffer.bufPtr;
                        if (bArr4[i5 + 3] != 73 || bArr4[i5 + 4] != 67 || bArr4[i5 + 5] != 67 || bArr4[i5 + 6] != 95 || bArr4[i5 + 7] != 80 || bArr4[i5 + 8] != 82 || bArr4[i5 + 9] != 79 || bArr4[i5 + 10] != 70 || bArr4[i5 + 11] != 73 || bArr4[i5 + 12] != 76 || bArr4[i5 + 13] != 69 || bArr4[i5 + 14] != 0) {
                            dHTMarkerSegment = new MarkerSegment(jPEGBuffer);
                            dHTMarkerSegment.loadData(jPEGBuffer);
                        } else if (!z) {
                            JFIFMarkerSegment jFIFMarkerSegment2 = (JFIFMarkerSegment) findMarkerSegment(JFIFMarkerSegment.class, true);
                            if (jFIFMarkerSegment2 == null) {
                                dHTMarkerSegment = new MarkerSegment(jPEGBuffer);
                                dHTMarkerSegment.loadData(jPEGBuffer);
                            } else {
                                jFIFMarkerSegment2.addICC(jPEGBuffer);
                            }
                        } else {
                            throw new IIOException("ICC profiles not permitted in stream metadata");
                        }
                    } else if (i2 == 238) {
                        jPEGBuffer.loadBuf(8);
                        byte[] bArr5 = jPEGBuffer.buf;
                        int i6 = jPEGBuffer.bufPtr;
                        if (bArr5[i6 + 3] != 65 || bArr5[i6 + 4] != 100 || bArr5[i6 + 5] != 111 || bArr5[i6 + 6] != 98 || bArr5[i6 + 7] != 101) {
                            dHTMarkerSegment = new MarkerSegment(jPEGBuffer);
                            dHTMarkerSegment.loadData(jPEGBuffer);
                        } else if (!z) {
                            dHTMarkerSegment = new AdobeMarkerSegment(jPEGBuffer);
                        } else {
                            throw new IIOException("Adobe APP14 markers not permitted in stream metadata");
                        }
                    } else if (i2 != 254) {
                        switch (i2) {
                            case 192:
                            case 193:
                            case JPEG.SOF2 /* 194 */:
                                if (!z) {
                                    dHTMarkerSegment = new SOFMarkerSegment(jPEGBuffer);
                                } else {
                                    throw new IIOException("SOF not permitted in stream metadata");
                                }
                                break;
                            default:
                                switch (i2) {
                                    case JPEG.RST0 /* 208 */:
                                    case JPEG.RST1 /* 209 */:
                                    case 210:
                                    case 211:
                                    case 212:
                                    case 213:
                                    case 214:
                                    case JPEG.RST7 /* 215 */:
                                        jPEGBuffer.bufPtr = i + 1;
                                        jPEGBuffer.bufAvail--;
                                        break;
                                    default:
                                        switch (i2) {
                                            case JPEG.EOI /* 217 */:
                                                jPEGBuffer.bufPtr = i + 1;
                                                jPEGBuffer.bufAvail--;
                                                z3 = true;
                                                break;
                                            case JPEG.SOS /* 218 */:
                                                if (!z) {
                                                    dHTMarkerSegment = new SOSMarkerSegment(jPEGBuffer);
                                                } else {
                                                    throw new IIOException("SOS not permitted in stream metadata");
                                                }
                                                break;
                                            case JPEG.DQT /* 219 */:
                                                dHTMarkerSegment = new DQTMarkerSegment(jPEGBuffer);
                                                break;
                                            default:
                                                dHTMarkerSegment = new MarkerSegment(jPEGBuffer);
                                                dHTMarkerSegment.loadData(jPEGBuffer);
                                                dHTMarkerSegment.unknown = true;
                                                break;
                                        }
                                        break;
                                }
                                break;
                        }
                    } else {
                        dHTMarkerSegment = new COMMarkerSegment(jPEGBuffer);
                    }
                    if (dHTMarkerSegment != null) {
                        break;
                    }
                }
                jPEGBuffer.pushBack();
                if (!isConsistent()) {
                    throw new IIOException("Inconsistent metadata read from stream");
                }
                return;
                this.markerSequence.add(dHTMarkerSegment);
            }
        } else {
            throw new IIOException("Image format error");
        }
    }

    public JPEGMetadata(ImageWriteParam imageWriteParam, JPEGImageWriter jPEGImageWriter) {
        this(true, false);
        JPEGImageWriteParam jPEGImageWriteParam = null;
        if (imageWriteParam != null && (imageWriteParam instanceof JPEGImageWriteParam)) {
            JPEGImageWriteParam jPEGImageWriteParam2 = (JPEGImageWriteParam) imageWriteParam;
            if (jPEGImageWriteParam2.areTablesSet()) {
                jPEGImageWriteParam = jPEGImageWriteParam2;
            }
        }
        if (jPEGImageWriteParam != null) {
            this.markerSequence.add(new DQTMarkerSegment(jPEGImageWriteParam.getQTables()));
            this.markerSequence.add(new DHTMarkerSegment(jPEGImageWriteParam.getDCHuffmanTables(), jPEGImageWriteParam.getACHuffmanTables()));
        } else {
            this.markerSequence.add(new DQTMarkerSegment(JPEG.getDefaultQTables()));
            this.markerSequence.add(new DHTMarkerSegment(JPEG.getDefaultHuffmanTables(true), JPEG.getDefaultHuffmanTables(false)));
        }
        if (!isConsistent()) {
            throw new InternalError("Default stream metadata is inconsistent");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x015c, code lost:
    
        if (r12 != false) goto L85;
     */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0184  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JPEGMetadata(ImageTypeSpecifier imageTypeSpecifier, ImageWriteParam imageWriteParam, JPEGImageWriter jPEGImageWriter) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        ImageTypeSpecifier destinationType;
        ColorSpace colorSpace;
        boolean z5;
        int i;
        int numComponents;
        boolean z6;
        boolean z7;
        boolean z8;
        this(false, false);
        byte[] bArr = {1, 2, 3, 4};
        float compressionQuality = 0.75f;
        if (imageWriteParam != null) {
            destinationType = imageWriteParam.getDestinationType();
            if (destinationType != null && imageTypeSpecifier != null) {
                jPEGImageWriter.warningOccurred(0);
                destinationType = null;
            }
            if (imageWriteParam.canWriteProgressive() && imageWriteParam.getProgressiveMode() == 1) {
                z3 = false;
                z = true;
            } else {
                z = false;
                z3 = true;
            }
            if (imageWriteParam instanceof JPEGImageWriteParam) {
                JPEGImageWriteParam jPEGImageWriteParam = (JPEGImageWriteParam) imageWriteParam;
                if (!jPEGImageWriteParam.areTablesSet()) {
                    z2 = false;
                    z4 = true;
                } else if (jPEGImageWriteParam.getDCHuffmanTables().length > 2 || jPEGImageWriteParam.getACHuffmanTables().length > 2) {
                    z3 = false;
                    z4 = false;
                    z2 = true;
                } else {
                    z3 = false;
                    z2 = false;
                    z4 = false;
                }
                if (!z && jPEGImageWriteParam.getOptimizeHuffmanTables()) {
                    z3 = false;
                }
            } else {
                z2 = false;
                z4 = true;
            }
            if (imageWriteParam.canWriteCompressed() && imageWriteParam.getCompressionMode() == 2) {
                compressionQuality = imageWriteParam.getCompressionQuality();
            }
        } else {
            z = false;
            z2 = false;
            z3 = true;
            z4 = true;
            destinationType = null;
        }
        boolean z9 = false;
        if (destinationType != null) {
            ColorModel colorModel = destinationType.getColorModel();
            numComponents = colorModel.getNumComponents();
            boolean z10 = colorModel.getNumColorComponents() != numComponents;
            boolean zHasAlpha = colorModel.hasAlpha();
            ColorSpace colorSpace2 = colorModel.getColorSpace();
            int type = colorSpace2.getType();
            if (type == 3) {
                if (!z10) {
                    z5 = false;
                    i = 0;
                    z6 = true;
                    z8 = true;
                } else if (zHasAlpha) {
                    z6 = false;
                    z5 = false;
                    i = 0;
                    z8 = true;
                } else {
                    z6 = false;
                    z5 = true;
                    z8 = true;
                    i = 2;
                }
                z7 = z8;
                colorSpace = colorSpace2;
            } else if (type != 13) {
                if (type == 5) {
                    bArr[0] = 82;
                    bArr[1] = 71;
                    bArr[2] = 66;
                    if (zHasAlpha) {
                        bArr[3] = 65;
                    }
                    z6 = false;
                    z8 = false;
                    i = 0;
                    z5 = true;
                } else if (type == 6 && !z10) {
                    z5 = false;
                    z8 = false;
                    i = 0;
                    z6 = true;
                } else {
                    z6 = false;
                    z5 = false;
                    z8 = false;
                    i = 0;
                }
                z7 = z8;
                colorSpace = colorSpace2;
            } else {
                if (colorSpace2 == JPEG.JCS.getYCC()) {
                    bArr[0] = 89;
                    bArr[1] = 67;
                    bArr[2] = 99;
                    if (zHasAlpha) {
                        bArr[3] = 65;
                    }
                    z6 = false;
                    z5 = false;
                    i = 0;
                    z8 = true;
                    z7 = z8;
                    colorSpace = colorSpace2;
                }
                z5 = false;
                i = 0;
                z6 = true;
                z8 = true;
                z7 = z8;
                colorSpace = colorSpace2;
            }
        } else {
            if (imageTypeSpecifier != null) {
                ColorModel colorModel2 = imageTypeSpecifier.getColorModel();
                numComponents = colorModel2.getNumComponents();
                boolean z11 = colorModel2.getNumColorComponents() != numComponents;
                boolean zHasAlpha2 = colorModel2.hasAlpha();
                ColorSpace colorSpace3 = colorModel2.getColorSpace();
                int type2 = colorSpace3.getType();
                if (type2 == 3) {
                    if (z11) {
                        if (zHasAlpha2) {
                            colorSpace = colorSpace3;
                            z6 = false;
                            z5 = false;
                            i = 0;
                            z7 = true;
                        }
                    }
                    colorSpace = colorSpace3;
                    z5 = false;
                    i = 0;
                } else if (type2 == 9) {
                    colorSpace = colorSpace3;
                    z6 = false;
                    z5 = true;
                    z7 = true;
                    i = 2;
                } else if (type2 != 13) {
                    if (type2 != 5) {
                        if (type2 == 6 && !z11) {
                            colorSpace = colorSpace3;
                            z5 = false;
                            i = 0;
                            z7 = false;
                            z6 = true;
                        } else {
                            colorSpace = colorSpace3;
                            z6 = false;
                            z5 = false;
                            i = 0;
                            z7 = false;
                        }
                    }
                } else if (colorSpace3.equals(ColorSpace.getInstance(1002))) {
                    bArr[0] = 89;
                    bArr[1] = 67;
                    bArr[2] = 99;
                    if (zHasAlpha2) {
                        bArr[3] = 65;
                    }
                    colorSpace = colorSpace3;
                    z6 = false;
                    i = 0;
                    z5 = true;
                    z7 = true;
                }
            } else {
                colorSpace = null;
                z5 = false;
                i = 0;
                numComponents = 0;
            }
            z6 = true;
            z7 = true;
        }
        if (z6 && JPEG.isNonStandardICC(colorSpace)) {
            z9 = true;
        }
        if (z6) {
            JFIFMarkerSegment jFIFMarkerSegment = new JFIFMarkerSegment();
            this.markerSequence.add(jFIFMarkerSegment);
            if (z9) {
                try {
                    jFIFMarkerSegment.addICC((ICC_ColorSpace) colorSpace);
                } catch (IOException unused) {
                }
            }
        }
        if (z5) {
            this.markerSequence.add(new AdobeMarkerSegment(i));
        }
        if (z4) {
            this.markerSequence.add(new DQTMarkerSegment(compressionQuality, z7));
        }
        if (z3) {
            this.markerSequence.add(new DHTMarkerSegment(z7));
        }
        boolean z12 = z;
        this.markerSequence.add(new SOFMarkerSegment(z12, z2, z7, bArr, numComponents));
        if (!z12) {
            this.markerSequence.add(new SOSMarkerSegment(z7, bArr, numComponents));
        }
        if (!isConsistent()) {
            throw new InternalError("Default image metadata is inconsistent");
        }
    }
}
