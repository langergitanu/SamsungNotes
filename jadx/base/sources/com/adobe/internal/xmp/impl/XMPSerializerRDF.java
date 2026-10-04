package com.adobe.internal.xmp.impl;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.runtime.AbstractC1974b;
import com.adobe.internal.xmp.XMPConst;
import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.XMPMetaFactory;
import com.adobe.internal.xmp.options.SerializeOptions;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XMPSerializerRDF {
    private static final int DEFAULT_PAD = 2048;
    private static final String PACKET_HEADER = "<?xpacket begin=\"\ufeff\" id=\"W5M0MpCehiHzreSzNTczkc9d\"?>";
    private static final String PACKET_TRAILER = "<?xpacket end=\"";
    private static final String PACKET_TRAILER2 = "\"?>";
    static final Set RDF_ATTR_QUALIFIER = new HashSet(Arrays.asList(XMPConst.XML_LANG, "rdf:resource", "rdf:ID", "rdf:bagID", "rdf:nodeID"));
    private static final String RDF_EMPTY_STRUCT = "<rdf:Description/>";
    private static final String RDF_RDF_END = "</rdf:RDF>";
    private static final String RDF_RDF_START = "<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\">";
    private static final String RDF_SCHEMA_END = "</rdf:Description>";
    private static final String RDF_SCHEMA_START = "<rdf:Description rdf:about=";
    private static final String RDF_STRUCT_END = "</rdf:Description>";
    private static final String RDF_STRUCT_START = "<rdf:Description";
    private static final String RDF_XMPMETA_END = "</x:xmpmeta>";
    private static final String RDF_XMPMETA_START = "<x:xmpmeta xmlns:x=\"adobe:ns:meta/\" x:xmptk=\"";
    private SerializeOptions options;
    private CountOutputStream outputStream;
    private int padding;
    private int unicodeSize = 1;
    private OutputStreamWriter writer;
    private XMPMetaImpl xmp;

    private void addPadding(int i) throws XMPException, IOException {
        if (this.options.getExactPacketLength()) {
            int bytesWritten = (i * this.unicodeSize) + this.outputStream.getBytesWritten();
            int i2 = this.padding;
            if (bytesWritten > i2) {
                throw new XMPException("Can't fit into specified packet size", 107);
            }
            this.padding = i2 - bytesWritten;
        }
        this.padding /= this.unicodeSize;
        int length = this.options.getNewline().length();
        int i4 = this.padding;
        if (i4 < length) {
            writeChars(i4, ' ');
            return;
        }
        this.padding = i4 - length;
        while (true) {
            int i5 = this.padding;
            int i6 = length + 100;
            if (i5 < i6) {
                writeChars(i5, ' ');
                writeNewline();
                return;
            } else {
                writeChars(100, ' ');
                writeNewline();
                this.padding -= i6;
            }
        }
    }

    private void appendNodeValue(String str, boolean z) throws IOException {
        if (str == null) {
            str = "";
        }
        write(Utils.escapeXML(str, z, true));
    }

    private boolean canBeRDFAttrProp(XMPNode xMPNode) {
        return (xMPNode.hasQualifier() || xMPNode.getOptions().isURI() || xMPNode.getOptions().isCompositeProperty() || XMPConst.ARRAY_ITEM_NAME.equals(xMPNode.getName())) ? false : true;
    }

    private void declareNamespace(String str, String str2, Set set, int i) throws IOException {
        if (str2 == null) {
            QName qName = new QName(str);
            if (!qName.hasPrefix()) {
                return;
            }
            str = qName.getPrefix();
            str2 = XMPMetaFactory.getSchemaRegistry().getNamespaceURI(str + ":");
            declareNamespace(str, str2, set, i);
        }
        if (set.contains(str)) {
            return;
        }
        writeNewline();
        writeIndent(i);
        write("xmlns:");
        write(str);
        write("=\"");
        write(str2);
        write(34);
        set.add(str);
    }

    private void declareUsedNamespaces(XMPNode xMPNode, Set set, int i) throws IOException {
        if (xMPNode.getOptions().isSchemaNode()) {
            declareNamespace(xMPNode.getValue().substring(0, xMPNode.getValue().length() - 1), xMPNode.getName(), set, i);
        } else if (xMPNode.getOptions().isStruct()) {
            Iterator itIterateChildren = xMPNode.iterateChildren();
            while (itIterateChildren.hasNext()) {
                declareNamespace(((XMPNode) itIterateChildren.next()).getName(), null, set, i);
            }
        }
        Iterator itIterateChildren2 = xMPNode.iterateChildren();
        while (itIterateChildren2.hasNext()) {
            declareUsedNamespaces((XMPNode) itIterateChildren2.next(), set, i);
        }
        Iterator itIterateQualifier = xMPNode.iterateQualifier();
        while (itIterateQualifier.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) itIterateQualifier.next();
            declareNamespace(xMPNode2.getName(), null, set, i);
            declareUsedNamespaces(xMPNode2, set, i);
        }
    }

    private void emitRDFArrayTag(XMPNode xMPNode, boolean z, int i) throws IOException {
        if (z || xMPNode.hasChildren()) {
            writeIndent(i);
            write(z ? "<rdf:" : "</rdf:");
            if (xMPNode.getOptions().isArrayAlternate()) {
                write("Alt");
            } else if (xMPNode.getOptions().isArrayOrdered()) {
                write("Seq");
            } else {
                write("Bag");
            }
            if (!z || xMPNode.hasChildren()) {
                write(">");
            } else {
                write("/>");
            }
            writeNewline();
        }
    }

    private void endOuterRDFDescription(int i) throws IOException {
        writeIndent(i + 1);
        write("</rdf:Description>");
        writeNewline();
    }

    private String serializeAsRDF() throws XMPException, IOException {
        int i = 0;
        if (!this.options.getOmitPacketWrapper()) {
            writeIndent(0);
            write(PACKET_HEADER);
            writeNewline();
        }
        if (!this.options.getOmitXmpMetaElement()) {
            writeIndent(0);
            write(RDF_XMPMETA_START);
            if (!this.options.getOmitVersionAttribute()) {
                write(XMPMetaFactory.getVersionInfo().getMessage());
            }
            write("\">");
            writeNewline();
            i = 1;
        }
        writeIndent(i);
        write(RDF_RDF_START);
        writeNewline();
        if (this.options.getUseCanonicalFormat()) {
            serializeCanonicalRDFSchemas(i);
        } else {
            serializeCompactRDFSchemas(i);
        }
        writeIndent(i);
        write(RDF_RDF_END);
        writeNewline();
        if (!this.options.getOmitXmpMetaElement()) {
            writeIndent(i - 1);
            write(RDF_XMPMETA_END);
            writeNewline();
        }
        String string = "";
        if (this.options.getOmitPacketWrapper()) {
            return "";
        }
        for (int baseIndent = this.options.getBaseIndent(); baseIndent > 0; baseIndent--) {
            StringBuilder sbM1324q = AbstractC1974b.m1324q(string);
            sbM1324q.append(this.options.getIndent());
            string = sbM1324q.toString();
        }
        StringBuilder sbM1324q2 = AbstractC1974b.m1324q(AbstractC0541b.m756B(string, PACKET_TRAILER));
        sbM1324q2.append(this.options.getReadOnlyPacket() ? 'r' : 'w');
        return AbstractC0541b.m756B(sbM1324q2.toString(), PACKET_TRAILER2);
    }

    private void serializeCanonicalRDFProperty(XMPNode xMPNode, boolean z, boolean z2, int i) throws XMPException, IOException {
        boolean z3;
        int i2 = i;
        String name = xMPNode.getName();
        if (z2) {
            name = "rdf:value";
        } else if (XMPConst.ARRAY_ITEM_NAME.equals(name)) {
            name = "rdf:li";
        }
        writeIndent(i2);
        write(60);
        write(name);
        Iterator itIterateQualifier = xMPNode.iterateQualifier();
        boolean z4 = false;
        boolean z5 = false;
        boolean zEquals = false;
        while (true) {
            z3 = true;
            if (!itIterateQualifier.hasNext()) {
                break;
            }
            XMPNode xMPNode2 = (XMPNode) itIterateQualifier.next();
            if (RDF_ATTR_QUALIFIER.contains(xMPNode2.getName())) {
                zEquals = "rdf:resource".equals(xMPNode2.getName());
                if (!z2) {
                    write(32);
                    write(xMPNode2.getName());
                    write("=\"");
                    appendNodeValue(xMPNode2.getValue(), true);
                    write(34);
                }
            } else {
                z5 = true;
            }
        }
        if (!z5 || z2) {
            if (xMPNode.getOptions().isCompositeProperty()) {
                if (xMPNode.getOptions().isArray()) {
                    write(62);
                    writeNewline();
                    int i4 = i2 + 1;
                    emitRDFArrayTag(xMPNode, true, i4);
                    if (xMPNode.getOptions().isArrayAltText()) {
                        XMPNodeUtils.normalizeLangArray(xMPNode);
                    }
                    Iterator itIterateChildren = xMPNode.iterateChildren();
                    while (itIterateChildren.hasNext()) {
                        serializeCanonicalRDFProperty((XMPNode) itIterateChildren.next(), z, false, i2 + 2);
                    }
                    emitRDFArrayTag(xMPNode, false, i4);
                } else if (zEquals) {
                    Iterator itIterateChildren2 = xMPNode.iterateChildren();
                    while (itIterateChildren2.hasNext()) {
                        XMPNode xMPNode3 = (XMPNode) itIterateChildren2.next();
                        if (!canBeRDFAttrProp(xMPNode3)) {
                            throw new XMPException("Can't mix rdf:resource and complex fields", 202);
                        }
                        writeNewline();
                        writeIndent(i2 + 1);
                        write(32);
                        write(xMPNode3.getName());
                        write("=\"");
                        appendNodeValue(xMPNode3.getValue(), true);
                        write(34);
                    }
                    write("/>");
                    writeNewline();
                } else if (xMPNode.hasChildren()) {
                    if (z) {
                        write(">");
                        writeNewline();
                        i2++;
                        writeIndent(i2);
                        write(RDF_STRUCT_START);
                        write(">");
                    } else {
                        write(" rdf:parseType=\"Resource\">");
                    }
                    writeNewline();
                    Iterator itIterateChildren3 = xMPNode.iterateChildren();
                    while (itIterateChildren3.hasNext()) {
                        serializeCanonicalRDFProperty((XMPNode) itIterateChildren3.next(), z, false, i2 + 1);
                    }
                    if (z) {
                        writeIndent(i2);
                        write("</rdf:Description>");
                        writeNewline();
                        i2--;
                    }
                } else {
                    if (z) {
                        write(">");
                        writeNewline();
                        writeIndent(i2 + 1);
                        write(RDF_EMPTY_STRUCT);
                        z4 = true;
                    } else {
                        write(" rdf:parseType=\"Resource\"/>");
                    }
                    writeNewline();
                }
                z4 = true;
            } else if (xMPNode.getOptions().isURI()) {
                write(" rdf:resource=\"");
                appendNodeValue(xMPNode.getValue(), true);
                write("\"/>");
                writeNewline();
            } else if (xMPNode.getValue() == null || "".equals(xMPNode.getValue())) {
                write("/>");
                writeNewline();
            } else {
                write(62);
                appendNodeValue(xMPNode.getValue(), false);
                z3 = false;
                z4 = true;
            }
        } else {
            if (zEquals) {
                throw new XMPException("Can't mix rdf:resource and general qualifiers", 202);
            }
            if (z) {
                write(">");
                writeNewline();
                i2++;
                writeIndent(i2);
                write(RDF_STRUCT_START);
                write(">");
            } else {
                write(" rdf:parseType=\"Resource\">");
            }
            writeNewline();
            int i5 = i2 + 1;
            serializeCanonicalRDFProperty(xMPNode, z, true, i5);
            Iterator itIterateQualifier2 = xMPNode.iterateQualifier();
            while (itIterateQualifier2.hasNext()) {
                XMPNode xMPNode4 = (XMPNode) itIterateQualifier2.next();
                if (!RDF_ATTR_QUALIFIER.contains(xMPNode4.getName())) {
                    serializeCanonicalRDFProperty(xMPNode4, z, false, i5);
                }
            }
            if (z) {
                writeIndent(i2);
                write("</rdf:Description>");
                writeNewline();
                i2--;
            }
            z4 = true;
        }
        if (z4) {
            if (z3) {
                writeIndent(i2);
            }
            write("</");
            write(name);
            write(62);
            writeNewline();
        }
    }

    private void serializeCanonicalRDFSchema(XMPNode xMPNode, int i) throws XMPException, IOException {
        Iterator itIterateChildren = xMPNode.iterateChildren();
        while (itIterateChildren.hasNext()) {
            serializeCanonicalRDFProperty((XMPNode) itIterateChildren.next(), this.options.getUseCanonicalFormat(), false, i + 2);
        }
    }

    private void serializeCanonicalRDFSchemas(int i) throws XMPException, IOException {
        if (this.xmp.getRoot().getChildrenLength() > 0) {
            startOuterRDFDescription(this.xmp.getRoot(), i);
            Iterator itIterateChildren = this.xmp.getRoot().iterateChildren();
            while (itIterateChildren.hasNext()) {
                serializeCanonicalRDFSchema((XMPNode) itIterateChildren.next(), i);
            }
            endOuterRDFDescription(i);
            return;
        }
        writeIndent(i + 1);
        write(RDF_SCHEMA_START);
        writeTreeName();
        write("/>");
        writeNewline();
    }

    private void serializeCompactRDFArrayProp(XMPNode xMPNode, int i) throws XMPException, IOException {
        write(62);
        writeNewline();
        int i2 = i + 1;
        emitRDFArrayTag(xMPNode, true, i2);
        if (xMPNode.getOptions().isArrayAltText()) {
            XMPNodeUtils.normalizeLangArray(xMPNode);
        }
        serializeCompactRDFElementProps(xMPNode, i + 2);
        emitRDFArrayTag(xMPNode, false, i2);
    }

    private boolean serializeCompactRDFAttrProps(XMPNode xMPNode, int i) throws IOException {
        Iterator itIterateChildren = xMPNode.iterateChildren();
        boolean z = true;
        while (itIterateChildren.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) itIterateChildren.next();
            if (canBeRDFAttrProp(xMPNode2)) {
                writeNewline();
                writeIndent(i);
                write(xMPNode2.getName());
                write("=\"");
                appendNodeValue(xMPNode2.getValue(), true);
                write(34);
            } else {
                z = false;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b9 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0004 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void serializeCompactRDFElementProps(XMPNode xMPNode, int i) throws XMPException, IOException {
        boolean zSerializeCompactRDFStructProp;
        boolean zBooleanValue;
        Iterator itIterateChildren = xMPNode.iterateChildren();
        while (itIterateChildren.hasNext()) {
            XMPNode xMPNode2 = (XMPNode) itIterateChildren.next();
            if (!canBeRDFAttrProp(xMPNode2)) {
                String name = xMPNode2.getName();
                if (XMPConst.ARRAY_ITEM_NAME.equals(name)) {
                    name = "rdf:li";
                }
                writeIndent(i);
                write(60);
                write(name);
                Iterator itIterateQualifier = xMPNode2.iterateQualifier();
                boolean z = false;
                boolean zEquals = false;
                while (true) {
                    zSerializeCompactRDFStructProp = true;
                    if (!itIterateQualifier.hasNext()) {
                        break;
                    }
                    XMPNode xMPNode3 = (XMPNode) itIterateQualifier.next();
                    if (RDF_ATTR_QUALIFIER.contains(xMPNode3.getName())) {
                        zEquals = "rdf:resource".equals(xMPNode3.getName());
                        write(32);
                        write(xMPNode3.getName());
                        write("=\"");
                        appendNodeValue(xMPNode3.getValue(), true);
                        write(34);
                    } else {
                        z = true;
                    }
                }
                if (z) {
                    serializeCompactRDFGeneralQualifier(i, xMPNode2);
                } else {
                    if (!xMPNode2.getOptions().isCompositeProperty()) {
                        Object[] objArrSerializeCompactRDFSimpleProp = serializeCompactRDFSimpleProp(xMPNode2);
                        boolean zBooleanValue2 = ((Boolean) objArrSerializeCompactRDFSimpleProp[0]).booleanValue();
                        zBooleanValue = ((Boolean) objArrSerializeCompactRDFSimpleProp[1]).booleanValue();
                        zSerializeCompactRDFStructProp = zBooleanValue2;
                    } else if (xMPNode2.getOptions().isArray()) {
                        serializeCompactRDFArrayProp(xMPNode2, i);
                    } else {
                        zSerializeCompactRDFStructProp = serializeCompactRDFStructProp(xMPNode2, i, zEquals);
                        zBooleanValue = true;
                    }
                    if (zSerializeCompactRDFStructProp) {
                        if (zBooleanValue) {
                            writeIndent(i);
                        }
                        write("</");
                        write(name);
                        write(62);
                        writeNewline();
                    }
                }
                zBooleanValue = true;
                if (zSerializeCompactRDFStructProp) {
                }
            }
        }
    }

    private void serializeCompactRDFGeneralQualifier(int i, XMPNode xMPNode) throws XMPException, IOException {
        write(" rdf:parseType=\"Resource\">");
        writeNewline();
        int i2 = i + 1;
        serializeCanonicalRDFProperty(xMPNode, false, true, i2);
        Iterator itIterateQualifier = xMPNode.iterateQualifier();
        while (itIterateQualifier.hasNext()) {
            serializeCanonicalRDFProperty((XMPNode) itIterateQualifier.next(), false, false, i2);
        }
    }

    private void serializeCompactRDFSchemas(int i) throws XMPException, IOException {
        int i2 = i + 1;
        writeIndent(i2);
        write(RDF_SCHEMA_START);
        writeTreeName();
        HashSet hashSet = new HashSet();
        hashSet.add("xml");
        hashSet.add("rdf");
        Iterator itIterateChildren = this.xmp.getRoot().iterateChildren();
        while (itIterateChildren.hasNext()) {
            declareUsedNamespaces((XMPNode) itIterateChildren.next(), hashSet, i + 3);
        }
        Iterator itIterateChildren2 = this.xmp.getRoot().iterateChildren();
        boolean zSerializeCompactRDFAttrProps = true;
        while (itIterateChildren2.hasNext()) {
            zSerializeCompactRDFAttrProps &= serializeCompactRDFAttrProps((XMPNode) itIterateChildren2.next(), i + 2);
        }
        if (zSerializeCompactRDFAttrProps) {
            write("/>");
            writeNewline();
            return;
        }
        write(62);
        writeNewline();
        Iterator itIterateChildren3 = this.xmp.getRoot().iterateChildren();
        while (itIterateChildren3.hasNext()) {
            serializeCompactRDFElementProps((XMPNode) itIterateChildren3.next(), i + 2);
        }
        writeIndent(i2);
        write("</rdf:Description>");
        writeNewline();
    }

    private Object[] serializeCompactRDFSimpleProp(XMPNode xMPNode) throws IOException {
        Boolean bool;
        Boolean bool2;
        Boolean bool3 = Boolean.TRUE;
        if (xMPNode.getOptions().isURI()) {
            write(" rdf:resource=\"");
            appendNodeValue(xMPNode.getValue(), true);
            write("\"/>");
            writeNewline();
            bool = Boolean.FALSE;
        } else {
            if (xMPNode.getValue() != null && xMPNode.getValue().length() != 0) {
                write(62);
                appendNodeValue(xMPNode.getValue(), false);
                bool2 = Boolean.FALSE;
                return new Object[]{bool3, bool2};
            }
            write("/>");
            writeNewline();
            bool = Boolean.FALSE;
        }
        bool3 = bool;
        bool2 = bool3;
        return new Object[]{bool3, bool2};
    }

    private boolean serializeCompactRDFStructProp(XMPNode xMPNode, int i, boolean z) throws XMPException, IOException {
        Iterator itIterateChildren = xMPNode.iterateChildren();
        boolean z2 = false;
        boolean z3 = false;
        while (itIterateChildren.hasNext()) {
            if (canBeRDFAttrProp((XMPNode) itIterateChildren.next())) {
                z2 = true;
            } else {
                z3 = true;
            }
            if (z2 && z3) {
                break;
            }
        }
        if (z && z3) {
            throw new XMPException("Can't mix rdf:resource qualifier and element fields", 202);
        }
        if (!xMPNode.hasChildren()) {
            write(" rdf:parseType=\"Resource\"/>");
            writeNewline();
            return false;
        }
        if (!z3) {
            serializeCompactRDFAttrProps(xMPNode, i + 1);
            write("/>");
            writeNewline();
            return false;
        }
        if (!z2) {
            write(" rdf:parseType=\"Resource\">");
            writeNewline();
            serializeCompactRDFElementProps(xMPNode, i + 1);
            return true;
        }
        write(62);
        writeNewline();
        int i2 = i + 1;
        writeIndent(i2);
        write(RDF_STRUCT_START);
        serializeCompactRDFAttrProps(xMPNode, i + 2);
        write(">");
        writeNewline();
        serializeCompactRDFElementProps(xMPNode, i2);
        writeIndent(i2);
        write("</rdf:Description>");
        writeNewline();
        return true;
    }

    private void startOuterRDFDescription(XMPNode xMPNode, int i) throws IOException {
        writeIndent(i + 1);
        write(RDF_SCHEMA_START);
        writeTreeName();
        HashSet hashSet = new HashSet();
        hashSet.add("xml");
        hashSet.add("rdf");
        declareUsedNamespaces(xMPNode, hashSet, i + 3);
        write(62);
        writeNewline();
    }

    private void write(int i) throws IOException {
        this.writer.write(i);
    }

    private void writeChars(int i, char c) throws IOException {
        while (i > 0) {
            this.writer.write(c);
            i--;
        }
    }

    private void writeIndent(int i) throws IOException {
        for (int baseIndent = this.options.getBaseIndent() + i; baseIndent > 0; baseIndent--) {
            this.writer.write(this.options.getIndent());
        }
    }

    private void writeNewline() throws IOException {
        this.writer.write(this.options.getNewline());
    }

    private void writeTreeName() throws IOException {
        write(34);
        String name = this.xmp.getRoot().getName();
        if (name != null) {
            appendNodeValue(name, true);
        }
        write(34);
    }

    public void checkOptionsConsistence() throws XMPException {
        if (this.options.getEncodeUTF16BE() | this.options.getEncodeUTF16LE()) {
            this.unicodeSize = 2;
        }
        if (this.options.getExactPacketLength()) {
            if (this.options.getOmitPacketWrapper() || this.options.getIncludeThumbnailPad()) {
                throw new XMPException("Inconsistent options for exact size serialize", 103);
            }
            if ((this.options.getPadding() & (this.unicodeSize - 1)) != 0) {
                throw new XMPException("Exact size must be a multiple of the Unicode element", 103);
            }
            return;
        }
        if (this.options.getReadOnlyPacket()) {
            if (this.options.getOmitPacketWrapper() || this.options.getIncludeThumbnailPad()) {
                throw new XMPException("Inconsistent options for read-only packet", 103);
            }
            this.padding = 0;
        } else {
            if (this.options.getOmitPacketWrapper()) {
                if (this.options.getIncludeThumbnailPad()) {
                    throw new XMPException("Inconsistent options for non-packet serialize", 103);
                }
                this.padding = 0;
                return;
            }
            if (this.padding == 0) {
                this.padding = this.unicodeSize * 2048;
            }
            if (!this.options.getIncludeThumbnailPad() || this.xmp.doesPropertyExist(XMPConst.NS_XMP, "Thumbnails")) {
                return;
            }
            this.padding = (this.unicodeSize * 10000) + this.padding;
        }
    }

    public void serialize(XMPMeta xMPMeta, OutputStream outputStream, SerializeOptions serializeOptions) throws XMPException {
        try {
            this.outputStream = new CountOutputStream(outputStream);
            this.writer = new OutputStreamWriter(this.outputStream, serializeOptions.getEncoding());
            this.xmp = (XMPMetaImpl) xMPMeta;
            this.options = serializeOptions;
            this.padding = serializeOptions.getPadding();
            this.writer = new OutputStreamWriter(this.outputStream, serializeOptions.getEncoding());
            checkOptionsConsistence();
            String strSerializeAsRDF = serializeAsRDF();
            this.writer.flush();
            addPadding(strSerializeAsRDF.length());
            write(strSerializeAsRDF);
            this.writer.flush();
            this.outputStream.close();
        } catch (IOException unused) {
            throw new XMPException("Error writing to the OutputStream", 0);
        }
    }

    private void write(String str) throws IOException {
        this.writer.write(str);
    }
}
