package org.ccil.cowan.tagsoup.jaxp;

import java.util.Map;
import javax.xml.parsers.SAXParser;
import org.ccil.cowan.tagsoup.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SAXParserImpl extends SAXParser {
    final Parser parser = new Parser();

    public static SAXParserImpl newInstance(Map map) throws SAXNotRecognizedException {
        SAXParserImpl sAXParserImpl = new SAXParserImpl();
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                sAXParserImpl.setFeature((String) entry.getKey(), ((Boolean) entry.getValue()).booleanValue());
            }
        }
        return sAXParserImpl;
    }

    public boolean getFeature(String str) {
        return this.parser.getFeature(str);
    }

    @Override // javax.xml.parsers.SAXParser
    public org.xml.sax.Parser getParser() {
        return new SAX1ParserAdapter(this.parser);
    }

    @Override // javax.xml.parsers.SAXParser
    public Object getProperty(String str) {
        return this.parser.getProperty(str);
    }

    @Override // javax.xml.parsers.SAXParser
    public XMLReader getXMLReader() {
        return this.parser;
    }

    @Override // javax.xml.parsers.SAXParser
    public boolean isNamespaceAware() {
        try {
            return this.parser.getFeature(Parser.namespacesFeature);
        } catch (SAXException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override // javax.xml.parsers.SAXParser
    public boolean isValidating() {
        try {
            return this.parser.getFeature(Parser.validationFeature);
        } catch (SAXException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void setFeature(String str, boolean z) throws SAXNotRecognizedException {
        this.parser.setFeature(str, z);
    }

    @Override // javax.xml.parsers.SAXParser
    public void setProperty(String str, Object obj) throws SAXNotRecognizedException, SAXNotSupportedException {
        this.parser.setProperty(str, obj);
    }
}
