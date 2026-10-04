package opennlp.tools.formats.letsmt;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import opennlp.tools.util.XmlUtil;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LetsmtDocument {
    private static final String ORG_XML_FEATURES_DISALLOW_DOCTYPE_DECL = "http://apache.org/xml/features/disallow-doctype-decl";
    private final List<LetsmtSentence> sentences;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LetsmtDocumentHandler extends DefaultHandler {
        private final List<LetsmtSentence> sentences = new ArrayList();
        private final StringBuilder chars = new StringBuilder();
        private List<String> tokens = new ArrayList();

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i, int i2) {
            this.chars.append(cArr, i, i2);
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            super.endElement(str, str2, str3);
            str3.getClass();
            if (!str3.equals("s")) {
                if (str3.equals("w")) {
                    this.tokens.add(this.chars.toString().trim());
                    this.chars.setLength(0);
                    return;
                }
                return;
            }
            LetsmtSentence letsmtSentence = new LetsmtSentence();
            if (this.tokens.size() > 0) {
                letsmtSentence.tokens = (String[]) this.tokens.toArray(new String[0]);
                this.tokens = new ArrayList();
            } else {
                letsmtSentence.nonTokenizedText = this.chars.toString().trim();
            }
            this.sentences.add(letsmtSentence);
            this.chars.setLength(0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class LetsmtSentence {
        private String nonTokenizedText;
        private String[] tokens;

        public String getNonTokenizedText() {
            return this.nonTokenizedText;
        }

        public String[] getTokens() {
            String[] strArr = this.tokens;
            if (strArr != null) {
                return (String[]) Arrays.copyOf(strArr, strArr.length);
            }
            return null;
        }
    }

    private LetsmtDocument(List<LetsmtSentence> list) {
        this.sentences = list;
    }

    public static LetsmtDocument parse(InputStream inputStream) throws IOException {
        try {
            XMLReader xMLReader = XmlUtil.createSaxParser().getXMLReader();
            LetsmtDocumentHandler letsmtDocumentHandler = new LetsmtDocumentHandler();
            xMLReader.setContentHandler(letsmtDocumentHandler);
            xMLReader.setFeature(ORG_XML_FEATURES_DISALLOW_DOCTYPE_DECL, true);
            xMLReader.parse(new InputSource(inputStream));
            return new LetsmtDocument(letsmtDocumentHandler.sentences);
        } catch (SAXException e) {
            throw new IOException("Failed to parse letsmt xml!", e);
        }
    }

    public List<LetsmtSentence> getSentences() {
        return Collections.unmodifiableList(this.sentences);
    }

    public static LetsmtDocument parse(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        try {
            LetsmtDocument letsmtDocument = parse(bufferedInputStream);
            bufferedInputStream.close();
            return letsmtDocument;
        } catch (Throwable th) {
            try {
                bufferedInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }
}
