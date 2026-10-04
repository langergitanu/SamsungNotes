package opennlp.tools.formats.masc;

import com.samsung.android.sdk.mobileservice.social.buddy.provider.BuddyContract;
import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class MascWordParser extends DefaultHandler {
    private final List<MascWord> wordAnchors = new ArrayList();

    public List<MascWord> getAnchors() {
        return this.wordAnchors;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        try {
            if (str3.equalsIgnoreCase(BuddyContract.Address.REGION)) {
                int i = Integer.parseInt(attributes.getValue("xml:id").replaceFirst("seg-r", ""));
                String[] strArrSplit = attributes.getValue("anchors").split(" ");
                this.wordAnchors.add(new MascWord(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), i));
            }
        } catch (Exception unused) {
            throw new SAXException("Could not parse the word segmentation annotation file.");
        }
    }
}
