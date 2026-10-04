package com.adobe.internal.xmp.impl;

import com.adobe.internal.xmp.XMPConst;
import com.adobe.internal.xmp.XMPException;
import com.adobe.internal.xmp.XMPMeta;
import com.adobe.internal.xmp.options.ParseOptions;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.ccil.cowan.tagsoup.Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class XMPMetaParser {
    private static final Object XMP_RDF = new Object();
    private static DocumentBuilderFactory factory = createDocumentBuilderFactory();

    private XMPMetaParser() {
    }

    private static DocumentBuilderFactory createDocumentBuilderFactory() {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        documentBuilderFactoryNewInstance.setIgnoringComments(true);
        documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
        try {
            documentBuilderFactoryNewInstance.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            documentBuilderFactoryNewInstance.setFeature(Parser.externalGeneralEntitiesFeature, false);
            documentBuilderFactoryNewInstance.setFeature("http://xerces.apache.org/xerces2-j/features.html#disallow-doctype-decl", false);
            documentBuilderFactoryNewInstance.setFeature(Parser.externalParameterEntitiesFeature, false);
            documentBuilderFactoryNewInstance.setFeature("http://xerces.apache.org/xerces2-j/features.html#external-parameter-entities", false);
            documentBuilderFactoryNewInstance.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
            documentBuilderFactoryNewInstance.setXIncludeAware(false);
            documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
        } catch (Throwable unused) {
        }
        return documentBuilderFactoryNewInstance;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Object[] findRootNode(Node node, boolean z, Object[] objArr) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (7 == nodeItem.getNodeType()) {
                ProcessingInstruction processingInstruction = (ProcessingInstruction) nodeItem;
                if (XMPConst.XMP_PI.equals(processingInstruction.getTarget())) {
                    if (objArr != null) {
                        objArr[2] = processingInstruction.getData();
                    }
                } else if (3 != nodeItem.getNodeType() && 7 != nodeItem.getNodeType()) {
                    String namespaceURI = nodeItem.getNamespaceURI();
                    String localName = nodeItem.getLocalName();
                    if ((XMPConst.TAG_XMPMETA.equals(localName) || XMPConst.TAG_XAPMETA.equals(localName)) && XMPConst.NS_X.equals(namespaceURI)) {
                        return findRootNode(nodeItem, false, objArr);
                    }
                    if (!z && "RDF".equals(localName) && XMPConst.NS_RDF.equals(namespaceURI)) {
                        if (objArr != null) {
                            objArr[0] = nodeItem;
                            objArr[1] = XMP_RDF;
                        }
                        return objArr;
                    }
                    Object[] objArrFindRootNode = findRootNode(nodeItem, z, objArr);
                    if (objArrFindRootNode != null) {
                        return objArrFindRootNode;
                    }
                }
            }
        }
        return null;
    }

    public static XMPMeta parse(Object obj, ParseOptions parseOptions) throws XMPException {
        ParameterAsserts.assertNotNull(obj);
        if (parseOptions == null) {
            parseOptions = new ParseOptions();
        }
        Object[] objArrFindRootNode = findRootNode(parseXml(obj, parseOptions), parseOptions.getRequireXMPMeta(), new Object[3]);
        if (objArrFindRootNode == null || objArrFindRootNode[1] != XMP_RDF) {
            return new XMPMetaImpl();
        }
        XMPMetaImpl xMPMetaImpl = ParseRDF.parse((Node) objArrFindRootNode[0], parseOptions);
        xMPMetaImpl.setPacketHeader((String) objArrFindRootNode[2]);
        return !parseOptions.getOmitNormalization() ? XMPNormalizer.process(xMPMetaImpl, parseOptions) : xMPMetaImpl;
    }

    private static Document parseInputSource(InputSource inputSource) throws XMPException {
        try {
            DocumentBuilder documentBuilderNewDocumentBuilder = factory.newDocumentBuilder();
            documentBuilderNewDocumentBuilder.setErrorHandler(null);
            return documentBuilderNewDocumentBuilder.parse(inputSource);
        } catch (IOException e) {
            throw new XMPException("Error reading the XML-file", 204, e);
        } catch (ParserConfigurationException e2) {
            throw new XMPException("XML Parser not correctly configured", 0, e2);
        } catch (SAXException e3) {
            throw new XMPException("XML parsing failure", 201, e3);
        }
    }

    private static Document parseXml(Object obj, ParseOptions parseOptions) {
        return obj instanceof InputStream ? parseXmlFromInputStream((InputStream) obj, parseOptions) : obj instanceof byte[] ? parseXmlFromBytebuffer(new ByteBuffer((byte[]) obj), parseOptions) : parseXmlFromString((String) obj, parseOptions);
    }

    private static Document parseXmlFromBytebuffer(ByteBuffer byteBuffer, ParseOptions parseOptions) throws XMPException {
        try {
            InputSource inputSource = new InputSource(byteBuffer.getByteStream());
            try {
                if (parseOptions.getDisallowDoctype()) {
                    try {
                        factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
                    } catch (Throwable unused) {
                    }
                }
                return parseInputSource(inputSource);
            } catch (XMPException e) {
                if ("DOCTYPE is disallowed".equals(e.getCause().getMessage())) {
                    throw new XMPException(e.getCause().getMessage(), 201);
                }
                if (e.getErrorCode() != 201 && e.getErrorCode() != 204) {
                    throw e;
                }
                if (parseOptions.getAcceptLatin1()) {
                    byteBuffer = Latin1Converter.convert(byteBuffer);
                }
                if (!parseOptions.getFixControlChars()) {
                    return parseInputSource(new InputSource(byteBuffer.getByteStream()));
                }
                return parseInputSource(new InputSource(new FixASCIIControlsReader(new InputStreamReader(byteBuffer.getByteStream(), byteBuffer.getEncoding()))));
            }
        } catch (UnsupportedEncodingException e2) {
            throw new XMPException("Unsupported Encoding", 9, e2);
        }
    }

    private static Document parseXmlFromInputStream(InputStream inputStream, ParseOptions parseOptions) throws XMPException {
        if (!parseOptions.getAcceptLatin1() && !parseOptions.getFixControlChars() && !parseOptions.getDisallowDoctype()) {
            return parseInputSource(new InputSource(inputStream));
        }
        try {
            return parseXmlFromBytebuffer(new ByteBuffer(inputStream), parseOptions);
        } catch (IOException e) {
            throw new XMPException("Error reading the XML-file", 204, e);
        }
    }

    private static Document parseXmlFromString(String str, ParseOptions parseOptions) throws XMPException {
        try {
            if (parseOptions.getDisallowDoctype()) {
                try {
                    factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
                } catch (Throwable unused) {
                }
            }
            return parseInputSource(new InputSource(new StringReader(str)));
        } catch (XMPException e) {
            if (e.getErrorCode() == 201 && parseOptions.getFixControlChars()) {
                return parseInputSource(new InputSource(new FixASCIIControlsReader(new StringReader(str))));
            }
            throw e;
        }
    }
}
