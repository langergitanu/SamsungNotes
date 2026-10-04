package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import com.samsung.android.support.senl.p148nt.data.common.constants.ExternalDataConstants;
import java.io.StringReader;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.ConstraintUtilities;
import uk.p245ac.p246ed.p247ph.snuggletex.internal.util.XMLUtilities;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class MathMLUtilities {
    public static final String ANNOTATION_LOCAL_NAME = "annotation";
    public static final String ANNOTATION_XML_LOCAL_NAME = "annotation-xml";

    public static void ensureMathMLContainer(Element element) {
        if (!isMathMLElement(element, "math")) {
            throw new IllegalArgumentException("Not a MathML <math/> element");
        }
    }

    public static Element ensureMathMLDocument(Document document) {
        Element documentElement = document.getDocumentElement();
        if (documentElement == null) {
            throw new IllegalArgumentException("Document does not have a document element");
        }
        ensureMathMLContainer(documentElement);
        return documentElement;
    }

    private static Element extractAnnotationElement(Element element, String str, String str2) {
        ensureMathMLContainer(element);
        ConstraintUtilities.ensureNotNull(str2, XMLWriter.ENCODING);
        Node firstChild = element.getFirstChild();
        if (firstChild != null && isMathMLElement(firstChild, "semantics")) {
            NodeList childNodes = ((Element) firstChild).getChildNodes();
            int length = childNodes.getLength();
            for (int i = 0; i < length; i++) {
                Node nodeItem = childNodes.item(i);
                if (isMathMLElement(nodeItem, str)) {
                    Element element2 = (Element) nodeItem;
                    if (str2.equals(element2.getAttribute(XMLWriter.ENCODING))) {
                        return element2;
                    }
                }
            }
        }
        return null;
    }

    public static String extractAnnotationString(Element element, String str) {
        Element elementExtractAnnotationElement = extractAnnotationElement(element, ANNOTATION_LOCAL_NAME, str);
        if (elementExtractAnnotationElement != null) {
            return XMLUtilities.extractTextElementValue(elementExtractAnnotationElement);
        }
        return null;
    }

    public static NodeList extractAnnotationXML(Element element, String str) {
        Element elementExtractAnnotationElement = extractAnnotationElement(element, ANNOTATION_XML_LOCAL_NAME, str);
        if (elementExtractAnnotationElement != null) {
            return elementExtractAnnotationElement.getChildNodes();
        }
        return null;
    }

    public static Element extractFirstSemanticsBranch(Element element) {
        ensureMathMLContainer(element);
        Node firstChild = element.getFirstChild();
        if (firstChild == null || !isMathMLElement(firstChild, "semantics")) {
            return null;
        }
        NodeList childNodes = ((Element) firstChild).getChildNodes();
        if (childNodes.getLength() == 0) {
            return null;
        }
        return (Element) childNodes.item(0);
    }

    public static boolean isMathMLElement(Node node) {
        return isMathMLElement(node, null);
    }

    public static Document isolateAnnotationXML(Element element, String str) {
        NodeList nodeListExtractAnnotationXML = extractAnnotationXML(element, str);
        if (nodeListExtractAnnotationXML != null) {
            return isolateDescendant(element, nodeListExtractAnnotationXML);
        }
        return null;
    }

    private static Document isolateDescendant(Element element, NodeList nodeList) {
        Document documentNewDocument = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
        Element element2 = (Element) element.cloneNode(false);
        documentNewDocument.adoptNode(element2);
        documentNewDocument.appendChild(element2);
        int length = nodeList.getLength();
        for (int i = 0; i < length; i++) {
            Node nodeCloneNode = nodeList.item(i).cloneNode(true);
            documentNewDocument.adoptNode(nodeCloneNode);
            element2.appendChild(nodeCloneNode);
        }
        return documentNewDocument;
    }

    public static Document isolateFirstSemanticsBranch(Element element) {
        Element elementExtractFirstSemanticsBranch = extractFirstSemanticsBranch(element);
        if (elementExtractFirstSemanticsBranch != null) {
            return isolateDescendant(element, elementExtractFirstSemanticsBranch);
        }
        return null;
    }

    public static Document parseMathMLDocumentString(String str) {
        ConstraintUtilities.ensureNotNull(str, "mathmlDocument");
        return XMLUtilities.createNSAwareDocumentBuilder().parse(new InputSource(new StringReader(str)));
    }

    public static String serializeDocument(Document document) {
        ConstraintUtilities.ensureNotNull(document, ExternalDataConstants.DOCUMENT_TABLE_NAME);
        return serializeNode(document, "UTF-8", true, true);
    }

    public static String serializeElement(Element element) {
        ConstraintUtilities.ensureNotNull(element, "element");
        return serializeNode(element, "UTF-8", true, true);
    }

    private static String serializeNode(Node node, SerializationSpecifier serializationSpecifier) {
        return XMLUtilities.serializeNode(node, serializationSpecifier);
    }

    public static UnwrappedParallelMathMLDOM unwrapParallelMathMLDOM(Element element) {
        ensureMathMLContainer(element);
        Node firstChild = element.getFirstChild();
        if (firstChild == null || !isMathMLElement(firstChild, "semantics")) {
            return null;
        }
        UnwrappedParallelMathMLDOM unwrappedParallelMathMLDOM = new UnwrappedParallelMathMLDOM();
        unwrappedParallelMathMLDOM.setMathElement(element);
        NodeList childNodes = ((Element) firstChild).getChildNodes();
        if (childNodes.getLength() == 0) {
            return null;
        }
        unwrappedParallelMathMLDOM.setFirstBranch((Element) childNodes.item(0));
        int length = childNodes.getLength();
        for (int i = 1; i < length; i++) {
            Node nodeItem = childNodes.item(i);
            if (isMathMLElement(nodeItem)) {
                Element element2 = (Element) nodeItem;
                if (ANNOTATION_LOCAL_NAME.equals(nodeItem.getLocalName())) {
                    unwrappedParallelMathMLDOM.getTextAnnotations().put(element2.getAttribute(XMLWriter.ENCODING), XMLUtilities.extractTextElementValue(element2));
                } else if (ANNOTATION_XML_LOCAL_NAME.equals(nodeItem.getLocalName())) {
                    unwrappedParallelMathMLDOM.getXmlAnnotations().put(element2.getAttribute(XMLWriter.ENCODING), element2.getChildNodes());
                }
            }
        }
        return unwrappedParallelMathMLDOM;
    }

    public static boolean isMathMLElement(Node node, String str) {
        ConstraintUtilities.ensureNotNull(node, "Node");
        if (node.getNodeType() == 1 && node.getNamespaceURI().equals("http://www.w3.org/1998/Math/MathML")) {
            return str == null || str.equals(node.getLocalName());
        }
        return false;
    }

    private static String serializeNode(Node node, String str, boolean z, boolean z2) {
        SerializationOptions serializationOptions = new SerializationOptions();
        if (str == null) {
            str = "UTF-8";
        }
        serializationOptions.setEncoding(str);
        serializationOptions.setIndenting(z);
        serializationOptions.setIncludingXMLDeclaration(!z2);
        return XMLUtilities.serializeNode(node, serializationOptions);
    }

    public static Document isolateAnnotationXML(UnwrappedParallelMathMLDOM unwrappedParallelMathMLDOM, String str) {
        ConstraintUtilities.ensureNotNull(unwrappedParallelMathMLDOM, "UnwrappedParallelMathMLDOM");
        NodeList nodeList = unwrappedParallelMathMLDOM.getXmlAnnotations().get(str);
        if (nodeList != null) {
            return isolateDescendant(unwrappedParallelMathMLDOM.getMathElement(), nodeList);
        }
        return null;
    }

    public static Document isolateFirstSemanticsBranch(UnwrappedParallelMathMLDOM unwrappedParallelMathMLDOM) {
        ConstraintUtilities.ensureNotNull(unwrappedParallelMathMLDOM, "UnwrappedParallelMathMLDOM");
        Element firstBranch = unwrappedParallelMathMLDOM.getFirstBranch();
        if (firstBranch != null) {
            return isolateDescendant(unwrappedParallelMathMLDOM.getMathElement(), firstBranch);
        }
        return null;
    }

    public static String serializeDocument(Document document, SerializationSpecifier serializationSpecifier) {
        ConstraintUtilities.ensureNotNull(document, ExternalDataConstants.DOCUMENT_TABLE_NAME);
        return serializeNode(document, serializationSpecifier);
    }

    public static String serializeElement(Element element, SerializationSpecifier serializationSpecifier) {
        ConstraintUtilities.ensureNotNull(element, "element");
        return serializeNode(element, serializationSpecifier);
    }

    public static String serializeDocument(Document document, SerializationSpecifier serializationSpecifier, StylesheetManager stylesheetManager) {
        ConstraintUtilities.ensureNotNull(stylesheetManager, "stylesheetManager");
        ConstraintUtilities.ensureNotNull(document, ExternalDataConstants.DOCUMENT_TABLE_NAME);
        return serializeNode(stylesheetManager, document, serializationSpecifier);
    }

    public static String serializeElement(Element element, SerializationSpecifier serializationSpecifier, StylesheetManager stylesheetManager) {
        ConstraintUtilities.ensureNotNull(element, "element");
        ConstraintUtilities.ensureNotNull(stylesheetManager, "stylesheetManager");
        return serializeNode(stylesheetManager, element, serializationSpecifier);
    }

    private static String serializeNode(StylesheetManager stylesheetManager, Node node, SerializationSpecifier serializationSpecifier) {
        return XMLUtilities.serializeNode(stylesheetManager, node, serializationSpecifier);
    }

    public static String serializeDocument(Document document, String str) {
        ConstraintUtilities.ensureNotNull(document, ExternalDataConstants.DOCUMENT_TABLE_NAME);
        return serializeNode(document, str, true, true);
    }

    public static String serializeElement(Element element, String str) {
        ConstraintUtilities.ensureNotNull(element, "element");
        return serializeNode(element, str, true, true);
    }

    private static Document isolateDescendant(Element element, Element element2) {
        Document documentNewDocument = XMLUtilities.createNSAwareDocumentBuilder().newDocument();
        Element element3 = (Element) element.cloneNode(false);
        documentNewDocument.adoptNode(element3);
        documentNewDocument.appendChild(element3);
        Element element4 = (Element) element2.cloneNode(true);
        documentNewDocument.adoptNode(element4);
        element3.appendChild(element4);
        return documentNewDocument;
    }

    public static String serializeDocument(Document document, String str, boolean z) {
        ConstraintUtilities.ensureNotNull(document, ExternalDataConstants.DOCUMENT_TABLE_NAME);
        return serializeNode(document, str, z, true);
    }

    public static String serializeElement(Element element, boolean z) {
        ConstraintUtilities.ensureNotNull(element, "element");
        return serializeNode(element, null, z, true);
    }

    @Deprecated
    public static String serializeDocument(Document document, boolean z, boolean z2) {
        ConstraintUtilities.ensureNotNull(document, ExternalDataConstants.DOCUMENT_TABLE_NAME);
        return serializeNode(document, null, z, z2);
    }

    @Deprecated
    public static String serializeElement(Element element, boolean z, boolean z2) {
        ConstraintUtilities.ensureNotNull(element, "element");
        return serializeNode(element, null, z, z2);
    }

    @Deprecated
    public static String serializeDocument(Document document, String str, boolean z, boolean z2) {
        ConstraintUtilities.ensureNotNull(document, ExternalDataConstants.DOCUMENT_TABLE_NAME);
        return serializeNode(document, str, z, z2);
    }

    @Deprecated
    public static String serializeElement(Element element, String str, boolean z, boolean z2) {
        ConstraintUtilities.ensureNotNull(element, "element");
        return serializeNode(element, str, z, z2);
    }

    public static String serializeElement(Element element, String str, boolean z) {
        ConstraintUtilities.ensureNotNull(element, "element");
        return serializeNode(element, str, z, true);
    }
}
