package uk.p245ac.p246ed.p247ph.snuggletex.internal.util;

import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.commons.lang3.BooleanUtils;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import uk.p245ac.p246ed.p247ph.snuggletex.SerializationSpecifier;
import uk.p245ac.p246ed.p247ph.snuggletex.SnuggleRuntimeException;
import uk.p245ac.p246ed.p247ph.snuggletex.definitions.Globals;
import uk.p245ac.p246ed.p247ph.snuggletex.utilities.StylesheetManager;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class XMLUtilities {
    public static final String SAXON_TRANSFORMER_FACTORY_CLASS_NAME = "net.sf.saxon.TransformerFactoryImpl";

    public static TransformerFactory createJAXPTransformerFactory() {
        try {
            TransformerFactory transformerFactoryNewInstance = TransformerFactory.newInstance();
            requireFeature(transformerFactoryNewInstance, "http://javax.xml.transform.dom.DOMSource/feature");
            requireFeature(transformerFactoryNewInstance, "http://javax.xml.transform.dom.DOMResult/feature");
            return transformerFactoryNewInstance;
        } catch (TransformerFactoryConfigurationError e) {
            throw new SnuggleRuntimeException(e);
        }
    }

    public static DocumentBuilder createNSAwareDocumentBuilder() {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        try {
            return documentBuilderFactoryNewInstance.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            throw new SnuggleRuntimeException("Could not create Namespace-aware DocumentBuilder", e);
        }
    }

    public static TransformerFactory createSaxonTransformerFactory() {
        try {
            TransformerFactory transformerFactory = (TransformerFactory) Class.forName(SAXON_TRANSFORMER_FACTORY_CLASS_NAME).newInstance();
            requireFeature(transformerFactory, "http://javax.xml.transform.dom.DOMSource/feature");
            requireFeature(transformerFactory, "http://javax.xml.transform.dom.DOMResult/feature");
            return transformerFactory;
        } catch (Exception e) {
            throw new SnuggleRuntimeException("Failed to explicitly instantiate Saxon net.sf.saxon.TransformerFactoryImpl class - check your ClassPath!", e);
        }
    }

    private static String ensureExtractTextNodeValue(Node node) {
        if (node.getNodeType() == 3) {
            return node.getNodeValue();
        }
        throw new IllegalArgumentException("Node is not a text Node");
    }

    public static String extractTextElementValue(Element element) {
        NodeList childNodes = element.getChildNodes();
        if (childNodes.getLength() == 1) {
            return ensureExtractTextNodeValue(childNodes.item(0));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childNodes.getLength(); i++) {
            sb.append(ensureExtractTextNodeValue(childNodes.item(i)));
        }
        return sb.toString();
    }

    public static boolean isSaxonAvailable() {
        try {
            Class.forName(SAXON_TRANSFORMER_FACTORY_CLASS_NAME);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean isXMLNCName(String str) {
        return str != null && str.matches("[a-zA-Z_][a-zA-Z0-9_.-]*");
    }

    public static boolean isXMLName(String str) {
        return str != null && str.matches("[a-zA-Z_:][a-zA-Z0-9_:.-]*");
    }

    public static void requireFeature(TransformerFactory transformerFactory, String str) {
        if (transformerFactory.getFeature(str)) {
            return;
        }
        throw new SnuggleRuntimeException("TransformerFactory " + transformerFactory.getClass().getName() + " needs to support feature " + str + " in order to be used with SnuggleTeX");
    }

    public static String serializeNode(Node node, SerializationSpecifier serializationSpecifier) {
        return serializeNode(new StylesheetManager(), node, serializationSpecifier);
    }

    public static String serializeNodeChildren(StylesheetManager stylesheetManager, Node node, SerializationSpecifier serializationSpecifier) {
        StringWriter stringWriter = new StringWriter();
        try {
            stylesheetManager.getSerializer(Globals.EXTRACT_CHILD_NODES_XSL_RESOURCE_NAME, serializationSpecifier).transform(new DOMSource(node), new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (Exception e) {
            throw new SnuggleRuntimeException("Could not serialize DOM", e);
        }
    }

    public static void setIndentation(Transformer transformer, int i) {
        if (i < 0) {
            transformer.setOutputProperty(XMLWriter.INDENT, BooleanUtils.f9757NO);
            return;
        }
        String strValueOf = String.valueOf(i);
        transformer.setOutputProperty(XMLWriter.INDENT, BooleanUtils.YES);
        transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", strValueOf);
        transformer.setOutputProperty("{http://saxon.sf.net/}indent-spaces", strValueOf);
    }

    public static boolean supportsXSLT20(TransformerFactory transformerFactory) {
        return transformerFactory.getClass().getName().startsWith("net.sf.saxon.");
    }

    public static String serializeNode(StylesheetManager stylesheetManager, Node node, SerializationSpecifier serializationSpecifier) {
        StringWriter stringWriter = new StringWriter();
        try {
            stylesheetManager.getSerializer(null, serializationSpecifier).transform(new DOMSource(node), new StreamResult(stringWriter));
            return stringWriter.toString();
        } catch (Exception e) {
            throw new SnuggleRuntimeException("Could not serialize DOM", e);
        }
    }

    public static boolean supportsXSLT20(Transformer transformer) {
        return transformer.getClass().getName().startsWith("net.sf.saxon.");
    }
}
