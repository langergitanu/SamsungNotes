package org.apache.poi.util;

import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.poi.javax.xml.stream.events.Namespace;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXParseException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DocumentHelper {
    private static final DocumentBuilderFactory documentBuilderFactory;
    private static final DocumentBuilder documentBuilderSingleton;
    private static POILogger logger = POILogFactory.getLogger((Class<?>) DocumentHelper.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DocHelperErrorHandler implements ErrorHandler {
        private DocHelperErrorHandler() {
        }

        private void printError(int i, SAXParseException sAXParseException) {
            StringBuilder sb = new StringBuilder();
            String systemId = sAXParseException.getSystemId();
            if (systemId != null) {
                int iLastIndexOf = systemId.lastIndexOf(47);
                if (iLastIndexOf != -1) {
                    systemId = systemId.substring(iLastIndexOf + 1);
                }
                sb.append(systemId);
            }
            sb.append(':');
            sb.append(sAXParseException.getLineNumber());
            sb.append(':');
            sb.append(sAXParseException.getColumnNumber());
            sb.append(": ");
            sb.append(sAXParseException.getMessage());
            DocumentHelper.logger.log(i, sb.toString(), sAXParseException);
        }

        @Override // org.xml.sax.ErrorHandler
        public void error(SAXParseException sAXParseException) {
            printError(7, sAXParseException);
        }

        @Override // org.xml.sax.ErrorHandler
        public void fatalError(SAXParseException sAXParseException) throws SAXParseException {
            printError(9, sAXParseException);
            throw sAXParseException;
        }

        @Override // org.xml.sax.ErrorHandler
        public void warning(SAXParseException sAXParseException) {
            printError(5, sAXParseException);
        }
    }

    static {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactory = documentBuilderFactoryNewInstance;
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setValidating(false);
        trySetSAXFeature(documentBuilderFactoryNewInstance, "http://javax.xml.XMLConstants/feature/secure-processing", true);
        trySetXercesSecurityManager(documentBuilderFactoryNewInstance);
        documentBuilderSingleton = newDocumentBuilder();
    }

    private DocumentHelper() {
    }

    public static void addNamespaceDeclaration(Element element, String str, String str2) {
        element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:" + str, str2);
    }

    public static synchronized Document createDocument() {
        return documentBuilderSingleton.newDocument();
    }

    public static synchronized DocumentBuilder newDocumentBuilder() {
        DocumentBuilder documentBuilderNewDocumentBuilder;
        try {
            documentBuilderNewDocumentBuilder = documentBuilderFactory.newDocumentBuilder();
            documentBuilderNewDocumentBuilder.setEntityResolver(SAXHelper.IGNORING_ENTITY_RESOLVER);
            documentBuilderNewDocumentBuilder.setErrorHandler(new DocHelperErrorHandler());
        } catch (ParserConfigurationException e) {
            throw new IllegalStateException("cannot create a DocumentBuilder", e);
        }
        return documentBuilderNewDocumentBuilder;
    }

    public static Document readDocument(InputStream inputStream) {
        return newDocumentBuilder().parse(inputStream);
    }

    private static void trySetSAXFeature(DocumentBuilderFactory documentBuilderFactory2, String str, boolean z) {
        try {
            documentBuilderFactory2.setFeature(str, z);
        } catch (AbstractMethodError e) {
            logger.log(5, "Cannot set SAX feature because outdated XML parser in classpath", str, e);
        } catch (Exception e2) {
            logger.log(5, "SAX Feature unsupported", str, e2);
        }
    }

    private static void trySetXercesSecurityManager(DocumentBuilderFactory documentBuilderFactory2) {
        String[] strArr = {"com.sun.org.apache.xerces.internal.util.SecurityManager", "org.apache.xerces.util.SecurityManager"};
        for (int i = 0; i < 2; i++) {
            try {
                Object objNewInstance = Class.forName(strArr[i]).newInstance();
                objNewInstance.getClass().getMethod("setEntityExpansionLimit", Integer.TYPE).invoke(objNewInstance, 4096);
                documentBuilderFactory2.setAttribute("http://apache.org/xml/properties/security-manager", objNewInstance);
                return;
            } catch (Throwable th) {
                logger.log(5, "SAX Security Manager could not be setup", th);
            }
        }
    }

    public static void addNamespaceDeclaration(Element element, Namespace namespace) {
        addNamespaceDeclaration(element, namespace.getPrefix(), namespace.getNamespaceURI());
    }

    public static Document readDocument(InputSource inputSource) {
        return newDocumentBuilder().parse(inputSource);
    }
}
