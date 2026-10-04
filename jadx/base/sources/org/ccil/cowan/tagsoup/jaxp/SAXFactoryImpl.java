package org.ccil.cowan.tagsoup.jaxp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SAXFactoryImpl extends SAXParserFactory {
    private SAXParserImpl prototypeParser = null;
    private HashMap features = null;

    private SAXParserImpl getPrototype() {
        if (this.prototypeParser == null) {
            this.prototypeParser = new SAXParserImpl();
        }
        return this.prototypeParser;
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public boolean getFeature(String str) {
        return getPrototype().getFeature(str);
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public SAXParser newSAXParser() throws ParserConfigurationException {
        try {
            return SAXParserImpl.newInstance(this.features);
        } catch (SAXException e) {
            throw new ParserConfigurationException(e.getMessage());
        }
    }

    @Override // javax.xml.parsers.SAXParserFactory
    public void setFeature(String str, boolean z) throws SAXNotRecognizedException {
        getPrototype().setFeature(str, z);
        if (this.features == null) {
            this.features = new LinkedHashMap();
        }
        this.features.put(str, z ? Boolean.TRUE : Boolean.FALSE);
    }
}
