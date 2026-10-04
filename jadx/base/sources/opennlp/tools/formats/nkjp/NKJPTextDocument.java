package opennlp.tools.formats.nkjp;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.xml.namespace.QName;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import opennlp.tools.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NKJPTextDocument {
    private Map<String, String> divtypes;
    private Map<String, Map<String, Map<String, String>>> texts;

    public NKJPTextDocument() {
        this.divtypes = new HashMap();
        this.texts = new HashMap();
    }

    private static String attrib(Node node, String str, boolean z) throws IOException {
        if (z && (node.getAttributes() == null || node.getAttributes().getLength() == 0)) {
            throw new IOException(AbstractC0541b.m772n("Missing required attributes in node ", node.getNodeName()));
        }
        if (node.getAttributes().getNamedItem(str) != null) {
            return node.getAttributes().getNamedItem(str).getTextContent();
        }
        if (z) {
            throw new IOException(AbstractC0541b.m774p("Required attribute \"", str, "\" missing in node ", node.getNodeName()));
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2, types: [int] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [org.w3c.dom.NodeList] */
    public static NKJPTextDocument parse(InputStream inputStream) throws IOException {
        String str = "xml:id";
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        try {
            Document document = XmlUtil.createDocumentBuilder().parse(inputStream);
            XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
            XPathExpression xPathExpressionCompile = xPathNewXPath.compile("/teiCorpus/TEI/text/group/text");
            XPathExpression xPathExpressionCompile2 = xPathNewXPath.compile("/teiCorpus/TEI/text");
            XPathExpression xPathExpressionCompile3 = xPathNewXPath.compile("./body/div");
            XPathExpression xPathExpressionCompile4 = xPathNewXPath.compile("./p|./ab");
            document.getDocumentElement().normalize();
            String nodeName = document.getDocumentElement().getNodeName();
            if (!nodeName.equalsIgnoreCase("teiCorpus")) {
                throw new IOException("Expected root node ".concat(nodeName));
            }
            QName qName = XPathConstants.NODESET;
            NodeList nodeList = (NodeList) xPathExpressionCompile.evaluate(document, qName);
            if (nodeList.getLength() == 0) {
                nodeList = (NodeList) xPathExpressionCompile2.evaluate(document, qName);
            }
            boolean z = false;
            int i = 0;
            while (i < nodeList.getLength()) {
                Node nodeItem = nodeList.item(i);
                boolean z2 = true;
                String strAttrib = attrib(nodeItem, str, true);
                HashMap map3 = new HashMap();
                ?? r7 = (NodeList) xPathExpressionCompile3.evaluate(nodeItem, XPathConstants.NODESET);
                for (?? r12 = z; r12 < r7.getLength(); r12++) {
                    Node nodeItem2 = r7.item(r12);
                    String strAttrib2 = attrib(nodeItem2, "type", z);
                    String strAttrib3 = attrib(nodeItem2, str, z2);
                    map.put(strAttrib3, strAttrib2);
                    HashMap map4 = new HashMap();
                    NodeList nodeList2 = (NodeList) xPathExpressionCompile4.evaluate(nodeItem2, XPathConstants.NODESET);
                    int i2 = 0;
                    while (i2 < nodeList2.getLength()) {
                        Node nodeItem3 = nodeList2.item(i2);
                        NodeList nodeList3 = nodeList2;
                        int i4 = i;
                        String strAttrib4 = attrib(nodeItem3, str, true);
                        String str2 = str;
                        if (nodeItem3.getChildNodes().getLength() != 1 && !nodeItem3.getFirstChild().getNodeName().equals("#text")) {
                            throw new IOException("Unexpected content in p element " + strAttrib4);
                        }
                        map4.put(strAttrib4, nodeItem3.getTextContent());
                        i2++;
                        i = i4;
                        nodeList2 = nodeList3;
                        str = str2;
                    }
                    map3.put(strAttrib3, map4);
                    i = i;
                    str = str;
                    z = false;
                    z2 = true;
                }
                String str3 = str;
                int i5 = i;
                map2.put(strAttrib, map3);
                i = i5 + 1;
                str = str3;
                z = false;
            }
            return new NKJPTextDocument(map, map2);
        } catch (IOException | XPathExpressionException | SAXException e) {
            throw new IOException("Failed to parse NKJP document", e);
        }
    }

    public Map<String, String> getDivtypes() {
        return Collections.unmodifiableMap(this.divtypes);
    }

    public Map<String, String> getParagraphs() {
        HashMap map = new HashMap();
        for (String str : this.texts.keySet()) {
            for (String str2 : this.texts.get(str).keySet()) {
                for (String str3 : this.texts.get(str).get(str2).keySet()) {
                    map.put(str3, this.texts.get(str).get(str2).get(str3));
                }
            }
        }
        return map;
    }

    public Map<String, Map<String, Map<String, String>>> getTexts() {
        return Collections.unmodifiableMap(this.texts);
    }

    public NKJPTextDocument(Map<String, String> map, Map<String, Map<String, Map<String, String>>> map2) {
        this();
        this.divtypes = map;
        this.texts = map2;
    }

    public static NKJPTextDocument parse(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            NKJPTextDocument nKJPTextDocument = parse(bufferedInputStream);
            bufferedInputStream.close();
            return nKJPTextDocument;
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
