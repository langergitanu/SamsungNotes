package opennlp.tools.formats.masc;

import com.samsung.android.sdk.mobileservice.social.buddy.provider.BuddyContract;
import java.util.ArrayList;
import java.util.List;
import opennlp.tools.util.Span;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class MascSentenceParser extends DefaultHandler {
    private final List<Span> sentenceAnchors = new ArrayList();

    public List<Span> getAnchors() {
        return this.sentenceAnchors;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        try {
            if (str3.equalsIgnoreCase(BuddyContract.Address.REGION)) {
                String[] strArrSplit = attributes.getValue("anchors").split(" ");
                this.sentenceAnchors.add(new Span(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1])));
            }
        } catch (Exception unused) {
            throw new SAXException("Could not parse the sentence annotation file.");
        }
    }
}
