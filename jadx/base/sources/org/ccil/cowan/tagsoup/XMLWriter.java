package org.ccil.cowan.tagsoup;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import com.samsung.scsp.common.Header;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Properties;
import kotlin.text.Typography;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.text.lookup.StringLookupFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.NamespaceSupport;
import org.xml.sax.helpers.XMLFilterImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class XMLWriter extends XMLFilterImpl implements LexicalHandler {
    public static final String CDATA_SECTION_ELEMENTS = "cdata-section-elements";
    public static final String DOCTYPE_PUBLIC = "doctype-public";
    public static final String DOCTYPE_SYSTEM = "doctype-system";
    public static final String ENCODING = "encoding";
    public static final String INDENT = "indent";
    public static final String MEDIA_TYPE = "media-type";
    public static final String METHOD = "method";
    public static final String OMIT_XML_DECLARATION = "omit-xml-declaration";
    public static final String STANDALONE = "standalone";
    public static final String VERSION = "version";
    private final Attributes EMPTY_ATTS;
    private String[] booleans;
    private boolean cdataElement;
    private Hashtable doneDeclTable;
    private int elementLevel;
    private boolean forceDTD;
    private Hashtable forcedDeclTable;
    private boolean hasOutputDTD;
    private boolean htmlMode;
    private NamespaceSupport nsSupport;
    private Writer output;
    private String outputEncoding;
    private Properties outputProperties;
    private String overridePublic;
    private String overrideSystem;
    private int prefixCounter;
    private Hashtable prefixTable;
    private String standalone;
    private boolean unicodeMode;
    private String version;

    public XMLWriter() {
        this.booleans = new String[]{"checked", "compact", "declare", "defer", "disabled", "ismap", "multiple", "nohref", "noresize", "noshade", "nowrap", "readonly", "selected"};
        this.EMPTY_ATTS = new org.xml.sax.helpers.AttributesImpl();
        this.elementLevel = 0;
        this.prefixCounter = 0;
        this.unicodeMode = false;
        this.outputEncoding = "";
        this.htmlMode = false;
        this.forceDTD = false;
        this.hasOutputDTD = false;
        this.overridePublic = null;
        this.overrideSystem = null;
        this.version = null;
        this.standalone = null;
        this.cdataElement = false;
        init(null);
    }

    private boolean booleanAttribute(String str, String str2, String str3) {
        int iIndexOf;
        if (str == null && (iIndexOf = str2.indexOf(58)) != -1) {
            str = str2.substring(iIndexOf + 1, str2.length());
        }
        if (!str.equals(str3)) {
            return false;
        }
        int i = 0;
        while (true) {
            String[] strArr = this.booleans;
            if (i >= strArr.length) {
                return false;
            }
            if (str.equals(strArr[i])) {
                return true;
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private String doPrefix(String str, String str2, boolean z) {
        String string = "";
        String uri = this.nsSupport.getURI("");
        String str3 = null;
        if ("".equals(str)) {
            if (z && uri != null) {
                this.nsSupport.declarePrefix("", "");
            }
            return null;
        }
        String prefix = (z && uri != null && str.equals(uri)) ? "" : this.nsSupport.getPrefix(str);
        if (prefix != null) {
            return prefix;
        }
        String str4 = (String) this.doneDeclTable.get(str);
        if (str4 != null && (((!z || uri != null) && "".equals(str4)) || this.nsSupport.getURI(str4) != null)) {
            str4 = null;
        }
        if (str4 != null || (str4 = (String) this.prefixTable.get(str)) == null || (((z && uri == null) || !"".equals(str4)) && this.nsSupport.getURI(str4) == null)) {
            str3 = str4;
        }
        if (str3 != null || str2 == null || "".equals(str2)) {
            string = str3;
        } else {
            int iIndexOf = str2.indexOf(58);
            if (iIndexOf != -1) {
                string = str2.substring(0, iIndexOf);
            } else if (!z || uri != null) {
            }
        }
        while (true) {
            if (string != null && this.nsSupport.getURI(string) == null) {
                this.nsSupport.declarePrefix(string, str);
                this.doneDeclTable.put(str, string);
                return string;
            }
            StringBuffer stringBuffer = new StringBuffer("__NS");
            int i = this.prefixCounter + 1;
            this.prefixCounter = i;
            stringBuffer.append(i);
            string = stringBuffer.toString();
        }
    }

    private void forceNSDecls() {
        Enumeration enumerationKeys = this.forcedDeclTable.keys();
        while (enumerationKeys.hasMoreElements()) {
            doPrefix((String) enumerationKeys.nextElement(), null, true);
        }
    }

    private void init(Writer writer) {
        setOutput(writer);
        this.nsSupport = new NamespaceSupport();
        this.prefixTable = new Hashtable();
        this.forcedDeclTable = new Hashtable();
        this.doneDeclTable = new Hashtable();
        this.outputProperties = new Properties();
    }

    private void write(char c) throws SAXException {
        try {
            this.output.write(c);
        } catch (IOException e) {
            throw new SAXException(e);
        }
    }

    private void writeAttributes(Attributes attributes) throws SAXException {
        int length = attributes.getLength();
        for (int i = 0; i < length; i++) {
            char[] charArray = attributes.getValue(i).toCharArray();
            write(' ');
            writeName(attributes.getURI(i), attributes.getLocalName(i), attributes.getQName(i), false);
            if (this.htmlMode && booleanAttribute(attributes.getLocalName(i), attributes.getQName(i), attributes.getValue(i))) {
                return;
            }
            write("=\"");
            writeEsc(charArray, 0, charArray.length, true);
            write('\"');
        }
    }

    private void writeEsc(char[] cArr, int i, int i2, boolean z) throws SAXException {
        for (int i4 = i; i4 < i + i2; i4++) {
            char c = cArr[i4];
            if (c != '\"') {
                if (c == '&') {
                    write("&amp;");
                } else if (c == '<') {
                    write("&lt;");
                } else if (c == '>') {
                    write("&gt;");
                } else if (this.unicodeMode || c <= 127) {
                    write(c);
                } else {
                    write("&#");
                    write(Integer.toString(cArr[i4]));
                    write(SQLKeyword.DELIMITER);
                }
            } else if (z) {
                write("&quot;");
            } else {
                write('\"');
            }
        }
    }

    private void writeNSDecls() throws SAXException {
        Enumeration declaredPrefixes = this.nsSupport.getDeclaredPrefixes();
        while (declaredPrefixes.hasMoreElements()) {
            String str = (String) declaredPrefixes.nextElement();
            String uri = this.nsSupport.getURI(str);
            if (uri == null) {
                uri = "";
            }
            char[] charArray = uri.toCharArray();
            write(' ');
            if ("".equals(str)) {
                write("xmlns=\"");
            } else {
                write("xmlns:");
                write(str);
                write("=\"");
            }
            writeEsc(charArray, 0, charArray.length, true);
            write('\"');
        }
    }

    private void writeName(String str, String str2, String str3, boolean z) throws SAXException {
        String strDoPrefix = doPrefix(str, str3, z);
        if (strDoPrefix != null && !"".equals(strDoPrefix)) {
            write(strDoPrefix);
            write(':');
        }
        if (str2 == null || "".equals(str2)) {
            write(str3.substring(str3.indexOf(58) + 1, str3.length()));
        } else {
            write(str2);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void characters(char[] cArr, int i, int i2) throws SAXException {
        if (this.cdataElement) {
            for (int i4 = i; i4 < i + i2; i4++) {
                write(cArr[i4]);
            }
        } else {
            writeEsc(cArr, i, i2, false);
        }
        super.characters(cArr, i, i2);
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void comment(char[] cArr, int i, int i2) throws SAXException {
        int i4;
        write("<!--");
        int i5 = i;
        while (true) {
            int i6 = i + i2;
            if (i5 >= i6) {
                write("-->");
                return;
            }
            write(cArr[i5]);
            if (cArr[i5] == '-' && (i4 = i5 + 1) <= i6 && cArr[i4] == '-') {
                write(' ');
            }
            i5++;
        }
    }

    public void dataElement(String str, String str2, String str3, Attributes attributes, String str4) throws SAXException {
        startElement(str, str2, str3, attributes);
        characters(str4);
        endElement(str, str2, str3);
    }

    public void emptyElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        this.nsSupport.pushContext();
        write(Typography.less);
        writeName(str, str2, str3, true);
        writeAttributes(attributes);
        if (this.elementLevel == 1) {
            forceNSDecls();
        }
        writeNSDecls();
        write("/>");
        super.startElement(str, str2, str3, attributes);
        super.endElement(str, str2, str3);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endDocument() throws SAXException {
        write('\n');
        super.endDocument();
        try {
            flush();
        } catch (IOException e) {
            throw new SAXException(e);
        }
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) throws SAXException {
        if (!this.htmlMode || ((!str.equals("http://www.w3.org/1999/xhtml") && !str.equals("")) || (!str3.equals("area") && !str3.equals("base") && !str3.equals("basefont") && !str3.equals(Header.f8126BR) && !str3.equals("col") && !str3.equals(TypedValues.Attributes.S_FRAME) && !str3.equals("hr") && !str3.equals("img") && !str3.equals("input") && !str3.equals("isindex") && !str3.equals("link") && !str3.equals("meta") && !str3.equals("param")))) {
            write("</");
            writeName(str, str2, str3, true);
            write('>');
        }
        this.cdataElement = false;
        super.endElement(str, str2, str3);
        this.nsSupport.popContext();
        this.elementLevel--;
    }

    public void flush() throws IOException {
        this.output.flush();
    }

    public void forceNSDecl(String str) {
        this.forcedDeclTable.put(str, Boolean.TRUE);
    }

    public String getOutputProperty(String str) {
        return this.outputProperties.getProperty(str);
    }

    public String getPrefix(String str) {
        return (String) this.prefixTable.get(str);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void ignorableWhitespace(char[] cArr, int i, int i2) throws SAXException {
        writeEsc(cArr, i, i2, false);
        super.ignorableWhitespace(cArr, i, i2);
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void processingInstruction(String str, String str2) throws SAXException {
        write("<?");
        write(str);
        write(' ');
        write(str2);
        write("?>");
        if (this.elementLevel < 1) {
            write('\n');
        }
        super.processingInstruction(str, str2);
    }

    public void reset() {
        this.elementLevel = 0;
        this.prefixCounter = 0;
        this.nsSupport.reset();
    }

    public void setOutput(Writer writer) {
        if (writer == null) {
            this.output = new OutputStreamWriter(System.out);
        } else {
            this.output = writer;
        }
    }

    public void setOutputProperty(String str, String str2) {
        this.outputProperties.setProperty(str, str2);
        if (str.equals(ENCODING)) {
            this.outputEncoding = str2;
            this.unicodeMode = str2.substring(0, 3).equalsIgnoreCase("utf");
            return;
        }
        if (str.equals("method")) {
            this.htmlMode = str2.equals("html");
            return;
        }
        if (str.equals(DOCTYPE_PUBLIC)) {
            this.overridePublic = str2;
            this.forceDTD = true;
        } else if (str.equals(DOCTYPE_SYSTEM)) {
            this.overrideSystem = str2;
            this.forceDTD = true;
        } else if (str.equals("version")) {
            this.version = str2;
        } else if (str.equals(STANDALONE)) {
            this.standalone = str2;
        }
    }

    public void setPrefix(String str, String str2) {
        this.prefixTable.put(str, str2);
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startDTD(String str, String str2, String str3) throws SAXException {
        if (str == null || this.hasOutputDTD) {
            return;
        }
        this.hasOutputDTD = true;
        write("<!DOCTYPE ");
        write(str);
        if (str3 == null) {
            str3 = "";
        }
        String str4 = this.overrideSystem;
        if (str4 != null) {
            str3 = str4;
        }
        char c = str3.indexOf(34) != -1 ? '\'' : '\"';
        String str5 = this.overridePublic;
        if (str5 != null) {
            str2 = str5;
        }
        if (str2 == null || "".equals(str2)) {
            write(" SYSTEM ");
        } else {
            char c2 = str2.indexOf(34) != -1 ? '\'' : '\"';
            write(" PUBLIC ");
            write(c2);
            write(str2);
            write(c2);
            write(' ');
        }
        write(c);
        write(str3);
        write(c);
        write(">\n");
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startDocument() throws SAXException {
        reset();
        if (!BooleanUtils.YES.equals(this.outputProperties.getProperty(OMIT_XML_DECLARATION, BooleanUtils.f9757NO))) {
            write("<?xml");
            if (this.version == null) {
                write(" version=\"1.0\"");
            } else {
                write(" version=\"");
                write(this.version);
                write("\"");
            }
            String str = this.outputEncoding;
            if (str != null && str != "") {
                write(" encoding=\"");
                write(this.outputEncoding);
                write("\"");
            }
            if (this.standalone == null) {
                write(" standalone=\"yes\"?>\n");
            } else {
                write(" standalone=\"");
                write(this.standalone);
                write("\"");
            }
        }
        super.startDocument();
    }

    @Override // org.xml.sax.helpers.XMLFilterImpl, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        this.elementLevel++;
        this.nsSupport.pushContext();
        if (this.forceDTD && !this.hasOutputDTD) {
            startDTD(str2 == null ? str3 : str2, "", "");
        }
        write(Typography.less);
        writeName(str, str2, str3, true);
        writeAttributes(attributes);
        if (this.elementLevel == 1) {
            forceNSDecls();
        }
        writeNSDecls();
        write('>');
        if (this.htmlMode && (str3.equals(StringLookupFactory.KEY_SCRIPT) || str3.equals("style"))) {
            this.cdataElement = true;
        }
        super.startElement(str, str2, str3, attributes);
    }

    public void forceNSDecl(String str, String str2) {
        setPrefix(str, str2);
        forceNSDecl(str);
    }

    private void write(String str) throws SAXException {
        try {
            this.output.write(str);
        } catch (IOException e) {
            throw new SAXException(e);
        }
    }

    public void dataElement(String str, String str2, String str3) throws SAXException {
        dataElement(str, str2, "", this.EMPTY_ATTS, str3);
    }

    public void characters(String str) throws SAXException {
        char[] charArray = str.toCharArray();
        characters(charArray, 0, charArray.length);
    }

    public void dataElement(String str, String str2) throws SAXException {
        dataElement("", str, "", this.EMPTY_ATTS, str2);
    }

    public void endElement(String str, String str2) throws SAXException {
        endElement(str, str2, "");
    }

    public void endElement(String str) throws SAXException {
        endElement("", str, "");
    }

    public void emptyElement(String str, String str2) throws SAXException {
        emptyElement(str, str2, "", this.EMPTY_ATTS);
    }

    public void emptyElement(String str) throws SAXException {
        emptyElement("", str, "", this.EMPTY_ATTS);
    }

    public void startElement(String str, String str2) throws SAXException {
        startElement(str, str2, "", this.EMPTY_ATTS);
    }

    public void startElement(String str) throws SAXException {
        startElement("", str, "", this.EMPTY_ATTS);
    }

    public XMLWriter(Writer writer) {
        this.booleans = new String[]{"checked", "compact", "declare", "defer", "disabled", "ismap", "multiple", "nohref", "noresize", "noshade", "nowrap", "readonly", "selected"};
        this.EMPTY_ATTS = new org.xml.sax.helpers.AttributesImpl();
        this.elementLevel = 0;
        this.prefixCounter = 0;
        this.unicodeMode = false;
        this.outputEncoding = "";
        this.htmlMode = false;
        this.forceDTD = false;
        this.hasOutputDTD = false;
        this.overridePublic = null;
        this.overrideSystem = null;
        this.version = null;
        this.standalone = null;
        this.cdataElement = false;
        init(writer);
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endDTD() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startCDATA() {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void endEntity(String str) {
    }

    @Override // org.xml.sax.ext.LexicalHandler
    public void startEntity(String str) {
    }

    public XMLWriter(XMLReader xMLReader) {
        super(xMLReader);
        this.booleans = new String[]{"checked", "compact", "declare", "defer", "disabled", "ismap", "multiple", "nohref", "noresize", "noshade", "nowrap", "readonly", "selected"};
        this.EMPTY_ATTS = new org.xml.sax.helpers.AttributesImpl();
        this.elementLevel = 0;
        this.prefixCounter = 0;
        this.unicodeMode = false;
        this.outputEncoding = "";
        this.htmlMode = false;
        this.forceDTD = false;
        this.hasOutputDTD = false;
        this.overridePublic = null;
        this.overrideSystem = null;
        this.version = null;
        this.standalone = null;
        this.cdataElement = false;
        init(null);
    }

    public XMLWriter(XMLReader xMLReader, Writer writer) {
        super(xMLReader);
        this.booleans = new String[]{"checked", "compact", "declare", "defer", "disabled", "ismap", "multiple", "nohref", "noresize", "noshade", "nowrap", "readonly", "selected"};
        this.EMPTY_ATTS = new org.xml.sax.helpers.AttributesImpl();
        this.elementLevel = 0;
        this.prefixCounter = 0;
        this.unicodeMode = false;
        this.outputEncoding = "";
        this.htmlMode = false;
        this.forceDTD = false;
        this.hasOutputDTD = false;
        this.overridePublic = null;
        this.overrideSystem = null;
        this.version = null;
        this.standalone = null;
        this.cdataElement = false;
        init(writer);
    }
}
