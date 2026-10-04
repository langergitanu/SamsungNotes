package opennlp.tools.dictionary.serializer;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.StringList;
import opennlp.tools.util.model.UncloseableInputStream;
import org.apache.commons.lang3.BooleanUtils;
import org.ccil.cowan.tagsoup.XMLWriter;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DictionaryEntryPersistor {
    private static final String ATTRIBUTE_CASE_SENSITIVE = "case_sensitive";
    private static final String DICTIONARY_ELEMENT = "dictionary";
    private static final String ENTRY_ELEMENT = "entry";
    private static final String SAX_FEATURE_NAMESPACES = "http://xml.org/sax/features/namespaces";
    private static final SAXParserFactory SAX_PARSER_FACTORY = SAXParserFactory.newInstance();
    private static final String TOKEN_ELEMENT = "token";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class DictionaryContenthandler implements ContentHandler {
        private Attributes mAttributes;
        private final EntryInserter mInserter;
        private boolean mIsCaseSensitiveDictionary;
        private boolean mIsInsideTokenElement;
        private final List<String> mTokenList;
        private final StringBuilder token;

        public /* synthetic */ DictionaryContenthandler(EntryInserter entryInserter, int i) {
            this(entryInserter);
        }

        @Override // org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            if (this.mIsInsideTokenElement) {
                this.token.append(cArr, i, i2);
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            if ("token".equals(str2)) {
                this.mTokenList.add(this.token.toString().trim());
                this.token.setLength(0);
                this.mIsInsideTokenElement = false;
            } else if (DictionaryEntryPersistor.ENTRY_ELEMENT.equals(str2)) {
                try {
                    this.mInserter.insert(new Entry(new StringList((String[]) this.mTokenList.toArray(new String[0])), this.mAttributes));
                    this.mTokenList.clear();
                    this.mAttributes = null;
                } catch (InvalidFormatException e) {
                    throw new SAXException("Invalid dictionary format!", e);
                }
            }
        }

        @Override // org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, org.xml.sax.Attributes attributes) {
            int i = 0;
            if (DictionaryEntryPersistor.DICTIONARY_ELEMENT.equals(str2)) {
                this.mAttributes = new Attributes();
                while (i < attributes.getLength()) {
                    this.mAttributes.setValue(attributes.getLocalName(i), attributes.getValue(i));
                    i++;
                }
                if (this.mAttributes.getValue(DictionaryEntryPersistor.ATTRIBUTE_CASE_SENSITIVE) != null) {
                    this.mIsCaseSensitiveDictionary = Boolean.parseBoolean(this.mAttributes.getValue(DictionaryEntryPersistor.ATTRIBUTE_CASE_SENSITIVE));
                }
                this.mAttributes = null;
                return;
            }
            if (!DictionaryEntryPersistor.ENTRY_ELEMENT.equals(str2)) {
                if ("token".equals(str2)) {
                    this.mIsInsideTokenElement = true;
                }
            } else {
                this.mAttributes = new Attributes();
                while (i < attributes.getLength()) {
                    this.mAttributes.setValue(attributes.getLocalName(i), attributes.getValue(i));
                    i++;
                }
            }
        }

        private DictionaryContenthandler(EntryInserter entryInserter) {
            this.mTokenList = new LinkedList();
            this.token = new StringBuilder();
            this.mInserter = entryInserter;
            this.mIsCaseSensitiveDictionary = true;
        }

        @Override // org.xml.sax.ContentHandler
        public void endDocument() {
        }

        @Override // org.xml.sax.ContentHandler
        public void startDocument() {
        }

        @Override // org.xml.sax.ContentHandler
        public void endPrefixMapping(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void setDocumentLocator(Locator locator) {
        }

        @Override // org.xml.sax.ContentHandler
        public void skippedEntity(String str) {
        }

        @Override // org.xml.sax.ContentHandler
        public void processingInstruction(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void startPrefixMapping(String str, String str2) {
        }

        @Override // org.xml.sax.ContentHandler
        public void ignorableWhitespace(char[] cArr, int i, int i2) {
        }
    }

    public static boolean create(InputStream inputStream, EntryInserter entryInserter) {
        DictionaryContenthandler dictionaryContenthandler = new DictionaryContenthandler(entryInserter, 0);
        try {
            XMLReader xMLReader = SAX_PARSER_FACTORY.newSAXParser().getXMLReader();
            xMLReader.setFeature("http://xml.org/sax/features/namespaces", true);
            xMLReader.setContentHandler(dictionaryContenthandler);
            xMLReader.parse(new InputSource(new UncloseableInputStream(inputStream)));
            return dictionaryContenthandler.mIsCaseSensitiveDictionary;
        } catch (ParserConfigurationException | SAXException e) {
            throw new InvalidFormatException("The profile data stream has an invalid format!", e);
        }
    }

    public static void serialize(OutputStream outputStream, Iterator<Entry> it, boolean z) {
        StreamResult streamResult = new StreamResult(outputStream);
        try {
            TransformerHandler transformerHandlerNewTransformerHandler = ((SAXTransformerFactory) TransformerFactory.newInstance()).newTransformerHandler();
            Transformer transformer = transformerHandlerNewTransformerHandler.getTransformer();
            transformer.setOutputProperty(XMLWriter.ENCODING, StandardCharsets.UTF_8.name());
            transformer.setOutputProperty(XMLWriter.INDENT, BooleanUtils.YES);
            transformerHandlerNewTransformerHandler.setResult(streamResult);
            try {
                transformerHandlerNewTransformerHandler.startDocument();
                AttributesImpl attributesImpl = new AttributesImpl();
                attributesImpl.addAttribute("", "", ATTRIBUTE_CASE_SENSITIVE, "", String.valueOf(z));
                transformerHandlerNewTransformerHandler.startElement("", "", DICTIONARY_ELEMENT, attributesImpl);
                while (it.hasNext()) {
                    serializeEntry(transformerHandlerNewTransformerHandler, it.next());
                }
                transformerHandlerNewTransformerHandler.endElement("", "", DICTIONARY_ELEMENT);
                transformerHandlerNewTransformerHandler.endDocument();
            } catch (SAXException e) {
                throw new IOException(AbstractC0541b.m772n("Error during serialization: ", e.getMessage()), e);
            }
        } catch (TransformerConfigurationException unused) {
            throw new InvalidFormatException("The Transformer configuration must be valid!");
        }
    }

    private static void serializeEntry(TransformerHandler transformerHandler, Entry entry) throws SAXException {
        AttributesImpl attributesImpl = new AttributesImpl();
        for (String str : entry.attributes()) {
            attributesImpl.addAttribute("", "", str, "", entry.attributes().getValue(str));
        }
        transformerHandler.startElement("", "", ENTRY_ELEMENT, attributesImpl);
        for (String str2 : entry.tokens()) {
            transformerHandler.startElement("", "", "token", new AttributesImpl());
            transformerHandler.characters(str2.toCharArray(), 0, str2.length());
            transformerHandler.endElement("", "", "token");
        }
        transformerHandler.endElement("", "", ENTRY_ELEMENT);
    }
}
