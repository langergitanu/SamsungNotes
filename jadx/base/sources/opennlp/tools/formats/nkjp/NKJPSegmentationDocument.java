package opennlp.tools.formats.nkjp;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import opennlp.tools.util.Span;
import opennlp.tools.util.XmlUtil;
import org.apache.commons.lang3.BooleanUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NKJPSegmentationDocument {
    Map<String, Map<String, Pointer>> segments;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class Pointer {
        final String doc;

        /* JADX INFO: renamed from: id */
        final String f9666id;
        final int length;
        final int offset;
        final boolean space_after;

        public Pointer(String str, String str2, int i, int i2, boolean z) {
            this.doc = str;
            this.f9666id = str2;
            this.offset = i;
            this.length = i2;
            this.space_after = z;
        }

        public Span toSpan() {
            int i = this.offset;
            return new Span(i, this.length + i);
        }

        public String toString() {
            return this.doc + "#string-range(" + this.f9666id + "," + this.offset + "," + this.length + ")";
        }
    }

    public NKJPSegmentationDocument() {
        this.segments = new LinkedHashMap();
    }

    public static boolean checkRejected(Node node) {
        if (node.getAttributes() == null || node.getAttributes().getNamedItem("nkjp:rejected") == null) {
            return false;
        }
        return node.getAttributes().getNamedItem("nkjp:rejected").getTextContent().equals("true");
    }

    public static boolean checkRejectedParen(Node node) {
        if (node.getChildNodes().getLength() == 0) {
            return false;
        }
        for (int i = 0; i < node.getChildNodes().getLength(); i++) {
            Node nodeItem = node.getChildNodes().item(i);
            if (nodeItem.getNodeName().equals("seg") && !checkRejected(nodeItem)) {
                return false;
            }
        }
        return true;
    }

    public static Pointer fromSeg(Node node) throws IOException {
        int i;
        int i2;
        if (node.getAttributes() == null || node.getAttributes().getLength() < 2) {
            throw new IOException("Missing required attributes");
        }
        String textContent = node.getAttributes().getNamedItem("corresp") != null ? node.getAttributes().getNamedItem("corresp").getTextContent() : null;
        if (node.getAttributes().getNamedItem("nkjp:nps") != null) {
            node.getAttributes().getNamedItem("nkjp:nps").getTextContent();
        }
        if (textContent == null) {
            throw new IOException("Missing required attribute");
        }
        boolean zEquals = textContent.equals(BooleanUtils.YES);
        if (!textContent.contains(ContentUtils.HASH_SYMBOL) || !textContent.contains("(") || AbstractC0000a.m4a(1, textContent) != ')') {
            throw new IOException(AbstractC0541b.m773o("String ", textContent, " does not appear to be a valid NKJP corresp attribute"));
        }
        String strSubstring = textContent.substring(0, textContent.indexOf(35));
        String[] strArrSplit = textContent.substring(textContent.indexOf(40) + 1, textContent.length() - 1).split(",");
        if (strArrSplit.length < 3 || strArrSplit.length > 4) {
            throw new IOException(AbstractC0541b.m773o("String ", textContent, " does not appear to be a valid NKJP corresp attribute"));
        }
        String str = strArrSplit[0];
        if (strArrSplit.length == 3) {
            i = Integer.parseInt(strArrSplit[1]);
            i2 = Integer.parseInt(strArrSplit[2]);
        } else {
            i = (Integer.parseInt(strArrSplit[1]) * 1000) + Integer.parseInt(strArrSplit[2]);
            i2 = Integer.parseInt(strArrSplit[3]);
        }
        return new Pointer(strSubstring, str, i, i2, zEquals);
    }

    public static NKJPSegmentationDocument parse(InputStream inputStream) throws IOException {
        String str;
        String str2 = "xml:id";
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Document document = XmlUtil.createDocumentBuilder().parse(inputStream);
            XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
            XPathExpression xPathExpressionCompile = xPathNewXPath.compile("/teiCorpus/TEI/text/body/p/s");
            XPathExpression xPathExpressionCompile2 = xPathNewXPath.compile("./seg|./choice");
            XPathExpression xPathExpressionCompile3 = xPathNewXPath.compile("./seg");
            NodeList nodeList = (NodeList) xPathExpressionCompile.evaluate(document, XPathConstants.NODESET);
            int i = 0;
            while (i < nodeList.getLength()) {
                Node nodeItem = nodeList.item(i);
                String textContent = nodeItem.getAttributes().getNamedItem(str2) != null ? nodeItem.getAttributes().getNamedItem(str2).getTextContent() : null;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                NodeList nodeList2 = (NodeList) xPathExpressionCompile2.evaluate(nodeItem, XPathConstants.NODESET);
                int i2 = 0;
                while (i2 < nodeList2.getLength()) {
                    Node nodeItem2 = nodeList2.item(i2);
                    if (nodeItem2.getNodeName().equals("seg")) {
                        linkedHashMap2.put(xmlID(nodeItem2), fromSeg(nodeItem2));
                    } else if (nodeItem2.getNodeName().equals("choice")) {
                        NodeList childNodes = nodeItem2.getChildNodes();
                        int i4 = 0;
                        while (i4 < childNodes.getLength()) {
                            if (childNodes.item(i4).getNodeName().equals("nkjp:paren")) {
                                if (!checkRejectedParen(childNodes.item(i4))) {
                                    NodeList nodeList3 = (NodeList) xPathExpressionCompile3.evaluate(childNodes.item(i4), XPathConstants.NODESET);
                                    int i5 = 0;
                                    while (i5 < nodeList3.getLength()) {
                                        linkedHashMap2.put(xmlID(nodeList3.item(i5)), fromSeg(nodeList3.item(i5)));
                                        i5++;
                                        str2 = str2;
                                    }
                                }
                                str = str2;
                            } else {
                                str = str2;
                                if (childNodes.item(i4).getNodeName().equals("seg") && !checkRejected(childNodes.item(i4))) {
                                    linkedHashMap2.put(xmlID(childNodes.item(i4)), fromSeg(childNodes.item(i4)));
                                }
                            }
                            i4++;
                            str2 = str;
                        }
                    }
                    i2++;
                    str2 = str2;
                }
                String str3 = str2;
                linkedHashMap.put(textContent, linkedHashMap2);
                i++;
                str2 = str3;
            }
            return new NKJPSegmentationDocument(linkedHashMap);
        } catch (IOException | XPathExpressionException | SAXException e) {
            throw new IOException("Failed to parse NKJP document", e);
        }
    }

    public static String xmlID(Node node) throws IOException {
        if (node.getAttributes() == null || node.getAttributes().getLength() < 1) {
            throw new IOException("Missing required attributes");
        }
        String textContent = node.getAttributes().getNamedItem("xml:id") != null ? node.getAttributes().getNamedItem("xml:id").getTextContent() : null;
        if (textContent != null) {
            return textContent;
        }
        throw new IOException("Missing xml:id attribute");
    }

    public Map<String, Map<String, Pointer>> getSegments() {
        return this.segments;
    }

    public NKJPSegmentationDocument(Map<String, Map<String, Pointer>> map) {
        this();
        this.segments = map;
    }

    public static NKJPSegmentationDocument parse(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            NKJPSegmentationDocument nKJPSegmentationDocument = parse(bufferedInputStream);
            bufferedInputStream.close();
            return nKJPSegmentationDocument;
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
