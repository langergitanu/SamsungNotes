package org.apache.poi.openxml4j.opc.internal.unmarshallers;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.InputStream;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.ZipPackage;
import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
import org.apache.poi.openxml4j.opc.internal.PartUnmarshaller;
import org.apache.poi.openxml4j.opc.internal.ZipHelper;
import org.apache.poi.util.DocumentHelper;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class PackagePropertiesUnmarshaller implements PartUnmarshaller {
    protected static final String KEYWORD_CATEGORY = "category";
    protected static final String KEYWORD_CONTENT_STATUS = "contentStatus";
    protected static final String KEYWORD_CONTENT_TYPE = "contentType";
    protected static final String KEYWORD_CREATED = "created";
    protected static final String KEYWORD_CREATOR = "creator";
    protected static final String KEYWORD_DESCRIPTION = "description";
    protected static final String KEYWORD_IDENTIFIER = "identifier";
    protected static final String KEYWORD_KEYWORDS = "keywords";
    protected static final String KEYWORD_LANGUAGE = "language";
    protected static final String KEYWORD_LAST_MODIFIED_BY = "lastModifiedBy";
    protected static final String KEYWORD_LAST_PRINTED = "lastPrinted";
    protected static final String KEYWORD_MODIFIED = "modified";
    protected static final String KEYWORD_REVISION = "revision";
    protected static final String KEYWORD_SUBJECT = "subject";
    protected static final String KEYWORD_TITLE = "title";
    protected static final String KEYWORD_VERSION = "version";

    private String loadCategory(Document document) {
        return readElement(document, "category", PackagePropertiesPart.NAMESPACE_CP_URI);
    }

    private String loadContentStatus(Document document) {
        return readElement(document, KEYWORD_CONTENT_STATUS, PackagePropertiesPart.NAMESPACE_CP_URI);
    }

    private String loadContentType(Document document) {
        return readElement(document, KEYWORD_CONTENT_TYPE, PackagePropertiesPart.NAMESPACE_CP_URI);
    }

    private String loadCreated(Document document) {
        return readElement(document, KEYWORD_CREATED, "http://purl.org/dc/terms/");
    }

    private String loadCreator(Document document) {
        return readElement(document, "creator", "http://purl.org/dc/elements/1.1/");
    }

    private String loadDescription(Document document) {
        return readElement(document, KEYWORD_DESCRIPTION, "http://purl.org/dc/elements/1.1/");
    }

    private String loadIdentifier(Document document) {
        return readElement(document, KEYWORD_IDENTIFIER, "http://purl.org/dc/elements/1.1/");
    }

    private String loadKeywords(Document document) {
        return readElement(document, "keywords", PackagePropertiesPart.NAMESPACE_CP_URI);
    }

    private String loadLanguage(Document document) {
        return readElement(document, "language", "http://purl.org/dc/elements/1.1/");
    }

    private String loadLastModifiedBy(Document document) {
        return readElement(document, KEYWORD_LAST_MODIFIED_BY, PackagePropertiesPart.NAMESPACE_CP_URI);
    }

    private String loadLastPrinted(Document document) {
        return readElement(document, KEYWORD_LAST_PRINTED, PackagePropertiesPart.NAMESPACE_CP_URI);
    }

    private String loadModified(Document document) {
        return readElement(document, KEYWORD_MODIFIED, "http://purl.org/dc/terms/");
    }

    private String loadRevision(Document document) {
        return readElement(document, KEYWORD_REVISION, PackagePropertiesPart.NAMESPACE_CP_URI);
    }

    private String loadSubject(Document document) {
        return readElement(document, KEYWORD_SUBJECT, "http://purl.org/dc/elements/1.1/");
    }

    private String loadTitle(Document document) {
        return readElement(document, "title", "http://purl.org/dc/elements/1.1/");
    }

    private String loadVersion(Document document) {
        return readElement(document, "version", PackagePropertiesPart.NAMESPACE_CP_URI);
    }

    private String readElement(Document document, String str, String str2) {
        Element element = (Element) document.getDocumentElement().getElementsByTagNameNS(str2, str).item(0);
        if (element == null) {
            return null;
        }
        return element.getTextContent();
    }

    public void checkElementForOPCCompliance(Element element) throws InvalidFormatException {
        NamedNodeMap attributes = element.getAttributes();
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            Attr attr = (Attr) attributes.item(0);
            if (attr.getNamespaceURI().equals("http://www.w3.org/2000/xmlns/") && attr.getValue().equals("http://schemas.openxmlformats.org/markup-compatibility/2006")) {
                throw new InvalidFormatException("OPC Compliance error [M4.2]: A format consumer shall consider the use of the Markup Compatibility namespace to be an error.");
            }
        }
        String localName = element.getLocalName();
        if (element.getNamespaceURI().equals("http://purl.org/dc/terms/") && !localName.equals(KEYWORD_CREATED) && !localName.equals(KEYWORD_MODIFIED)) {
            throw new InvalidFormatException("OPC Compliance error [M4.3]: Producers shall not create a document element that contains refinements to the Dublin Core elements, except for the two specified in the schema: <dcterms:created> and <dcterms:modified> Consumers shall consider a document element that violates this constraint to be an error.");
        }
        if (element.getAttributeNodeNS("http://www.w3.org/XML/1998/namespace", "lang") != null) {
            throw new InvalidFormatException("OPC Compliance error [M4.4]: Producers shall not create a document element that contains the xml:lang attribute. Consumers shall consider a document element that violates this constraint to be an error.");
        }
        if (element.getNamespaceURI().equals("http://purl.org/dc/terms/")) {
            if (!localName.equals(KEYWORD_CREATED) && !localName.equals(KEYWORD_MODIFIED)) {
                throw new InvalidFormatException(AbstractC0541b.m773o("Namespace error : ", localName, " shouldn't have the following naemspace -> http://purl.org/dc/terms/"));
            }
            Attr attributeNodeNS = element.getAttributeNodeNS("http://www.w3.org/2001/XMLSchema-instance", "type");
            if (attributeNodeNS == null) {
                throw new InvalidFormatException(AbstractC0541b.m773o("The element '", localName, "' must have the 'xsi:type' attribute present !"));
            }
            if (!attributeNodeNS.getValue().equals(element.getPrefix() + ":W3CDTF")) {
                StringBuilder sbM15l = AbstractC0000a.m15l("The element '", localName, "' must have the 'xsi:type' attribute with the value '");
                sbM15l.append(element.getPrefix());
                sbM15l.append(":W3CDTF', but had '");
                sbM15l.append(attributeNodeNS.getValue());
                sbM15l.append("' !");
                throw new InvalidFormatException(sbM15l.toString());
            }
        }
        NodeList elementsByTagName = element.getElementsByTagName("*");
        int length2 = elementsByTagName.getLength();
        for (int i2 = 0; i2 < length2; i2++) {
            checkElementForOPCCompliance((Element) elementsByTagName.item(i2));
        }
    }

    @Override // org.apache.poi.openxml4j.opc.internal.PartUnmarshaller
    public PackagePart unmarshall(UnmarshallContext unmarshallContext, InputStream inputStream) throws InvalidFormatException, IOException {
        PackagePropertiesPart packagePropertiesPart = new PackagePropertiesPart(unmarshallContext.getPackage(), unmarshallContext.getPartName());
        if (inputStream == null) {
            if (unmarshallContext.getZipEntry() != null) {
                inputStream = ((ZipPackage) unmarshallContext.getPackage()).getZipArchive().getInputStream(unmarshallContext.getZipEntry());
            } else {
                if (unmarshallContext.getPackage() == null) {
                    throw new IOException("Error while trying to get the part input stream.");
                }
                inputStream = ((ZipPackage) unmarshallContext.getPackage()).getZipArchive().getInputStream(ZipHelper.getCorePropertiesZipEntry((ZipPackage) unmarshallContext.getPackage()));
            }
        }
        try {
            Document document = DocumentHelper.readDocument(inputStream);
            checkElementForOPCCompliance(document.getDocumentElement());
            packagePropertiesPart.setCategoryProperty(loadCategory(document));
            packagePropertiesPart.setContentStatusProperty(loadContentStatus(document));
            packagePropertiesPart.setContentTypeProperty(loadContentType(document));
            packagePropertiesPart.setCreatedProperty(loadCreated(document));
            packagePropertiesPart.setCreatorProperty(loadCreator(document));
            packagePropertiesPart.setDescriptionProperty(loadDescription(document));
            packagePropertiesPart.setIdentifierProperty(loadIdentifier(document));
            packagePropertiesPart.setKeywordsProperty(loadKeywords(document));
            packagePropertiesPart.setLanguageProperty(loadLanguage(document));
            packagePropertiesPart.setLastModifiedByProperty(loadLastModifiedBy(document));
            packagePropertiesPart.setLastPrintedProperty(loadLastPrinted(document));
            packagePropertiesPart.setModifiedProperty(loadModified(document));
            packagePropertiesPart.setRevisionProperty(loadRevision(document));
            packagePropertiesPart.setSubjectProperty(loadSubject(document));
            packagePropertiesPart.setTitleProperty(loadTitle(document));
            packagePropertiesPart.setVersionProperty(loadVersion(document));
            return packagePropertiesPart;
        } catch (SAXException e) {
            throw new IOException(e.getMessage());
        }
    }
}
