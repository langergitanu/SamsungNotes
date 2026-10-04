package org.apache.poi;

import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.pathdata.VPathDataCmd;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import org.apache.poi.javax.xml.stream.XMLStreamReader;
import org.apache.poi.util.DocumentHelper;
import org.apache.poi.util.Removal;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.xmlbeans.SchemaType;
import org.apache.xmlbeans.SchemaTypeLoader;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.apache.xmlbeans.xml.stream.XMLInputStream;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POIXMLTypeLoader {
    public static final XmlOptions DEFAULT_XML_OPTIONS;
    private static final String MS_EXCEL_URN = "urn:schemas-microsoft-com:office:excel";
    private static final String MS_OFFICE_URN = "urn:schemas-microsoft-com:office:office";
    private static final String MS_VML_URN = "urn:schemas-microsoft-com:vml";
    private static final String MS_WORD_URN = "urn:schemas-microsoft-com:office:word";
    private static ThreadLocal<SchemaTypeLoader> typeLoader = new ThreadLocal<>();

    static {
        XmlOptions xmlOptions = new XmlOptions();
        DEFAULT_XML_OPTIONS = xmlOptions;
        xmlOptions.setSaveOuter();
        xmlOptions.setUseDefaultNamespace();
        xmlOptions.setSaveAggressiveNamespaces();
        xmlOptions.setCharacterEncoding("UTF-8");
        HashMap map = new HashMap();
        map.put(XSSFRelation.NS_DRAWINGML, "a");
        map.put(XSSFRelation.NS_CHART, "c");
        map.put("http://schemas.openxmlformats.org/drawingml/2006/wordprocessingDrawing", "wp");
        map.put("http://schemas.openxmlformats.org/markup-compatibility/2006", "ve");
        map.put("http://schemas.openxmlformats.org/officeDocument/2006/math", "m");
        map.put("http://schemas.openxmlformats.org/officeDocument/2006/relationships", "r");
        map.put("http://schemas.openxmlformats.org/officeDocument/2006/docPropsVTypes", "vt");
        map.put("http://schemas.openxmlformats.org/presentationml/2006/main", "p");
        map.put("http://schemas.openxmlformats.org/wordprocessingml/2006/main", "w");
        map.put("http://schemas.microsoft.com/office/word/2006/wordml", "wne");
        map.put(MS_OFFICE_URN, "o");
        map.put(MS_EXCEL_URN, "x");
        map.put(MS_WORD_URN, "w10");
        map.put(MS_VML_URN, VPathDataCmd.RCurveTo);
        xmlOptions.setSaveSuggestedPrefixes(Collections.unmodifiableMap(map));
    }

    private static SchemaTypeLoader getTypeLoader(SchemaType schemaType) {
        SchemaTypeLoader schemaTypeLoader = typeLoader.get();
        if (schemaTypeLoader != null) {
            return schemaTypeLoader;
        }
        SchemaTypeLoader schemaTypeLoaderTypeLoaderForClassLoader = XmlBeans.typeLoaderForClassLoader(schemaType.getClass().getClassLoader());
        typeLoader.set(schemaTypeLoaderTypeLoaderForClassLoader);
        return schemaTypeLoaderTypeLoaderForClassLoader;
    }

    private static XmlOptions getXmlOptions(XmlOptions xmlOptions) {
        return xmlOptions == null ? DEFAULT_XML_OPTIONS : xmlOptions;
    }

    public static XmlObject newInstance(SchemaType schemaType, XmlOptions xmlOptions) {
        return getTypeLoader(schemaType).newInstance(schemaType, getXmlOptions(xmlOptions));
    }

    public static XMLInputStream newValidatingXMLInputStream(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) {
        return getTypeLoader(schemaType).newValidatingXMLInputStream(xMLInputStream, schemaType, getXmlOptions(xmlOptions));
    }

    public static XmlObject parse(String str, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        try {
            return parse(new StringReader(str), schemaType, xmlOptions);
        } catch (IOException e) {
            throw new XmlException("Unable to parse xml bean", e);
        }
    }

    public static XmlObject parse(File file, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            return parse(fileInputStream, schemaType, xmlOptions);
        } finally {
            fileInputStream.close();
        }
    }

    public static XmlObject parse(URL url, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        InputStream inputStreamOpenStream = url.openStream();
        try {
            return parse(inputStreamOpenStream, schemaType, xmlOptions);
        } finally {
            inputStreamOpenStream.close();
        }
    }

    public static XmlObject parse(InputStream inputStream, SchemaType schemaType, XmlOptions xmlOptions) throws IOException {
        try {
            return getTypeLoader(schemaType).parse(DocumentHelper.readDocument(inputStream).getDocumentElement(), schemaType, getXmlOptions(xmlOptions));
        } catch (SAXException e) {
            throw new IOException("Unable to parse xml bean", e);
        }
    }

    public static XmlObject parse(XMLStreamReader xMLStreamReader, SchemaType schemaType, XmlOptions xmlOptions) {
        return getTypeLoader(schemaType).parse(xMLStreamReader, schemaType, getXmlOptions(xmlOptions));
    }

    public static XmlObject parse(Reader reader, SchemaType schemaType, XmlOptions xmlOptions) throws XmlException {
        try {
            return getTypeLoader(schemaType).parse(DocumentHelper.readDocument(new InputSource(reader)).getDocumentElement(), schemaType, getXmlOptions(xmlOptions));
        } catch (SAXException e) {
            throw new XmlException("Unable to parse xml bean", e);
        }
    }

    public static XmlObject parse(Node node, SchemaType schemaType, XmlOptions xmlOptions) {
        return getTypeLoader(schemaType).parse(node, schemaType, getXmlOptions(xmlOptions));
    }

    public static XmlObject parse(XMLInputStream xMLInputStream, SchemaType schemaType, XmlOptions xmlOptions) {
        return getTypeLoader(schemaType).parse(xMLInputStream, schemaType, getXmlOptions(xmlOptions));
    }

    @Removal(version = AuthenticationConstants.FOUR_POINT_ZERO)
    @Deprecated
    public static void setClassLoader(ClassLoader classLoader) {
    }
}
