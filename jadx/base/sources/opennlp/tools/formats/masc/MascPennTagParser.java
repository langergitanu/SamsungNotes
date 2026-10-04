package opennlp.tools.formats.masc;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascPennTagParser extends DefaultHandler {
    private final Map<Integer, int[]> tokenToQuarks = new HashMap();
    private final Map<Integer, String> tokenToTag = new HashMap();
    private final Map<Integer, String> tokenToBase = new HashMap();
    private final Stack<Integer> tokenStack = new Stack<>();
    private final Stack<Integer> tokenStackTag = new Stack<>();

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void endElement(String str, String str2, String str3) {
        if (str3.equals("a")) {
            this.tokenStackTag.pop();
        }
    }

    public Map<Integer, String> getBases() {
        return this.tokenToBase;
    }

    public Map<Integer, String> getTags() {
        return this.tokenToTag;
    }

    public Map<Integer, int[]> getTokenToQuarks() {
        return this.tokenToQuarks;
    }

    @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        try {
            if (str3.equals("node")) {
                this.tokenStack.push(Integer.valueOf(Integer.parseInt(attributes.getValue("xml:id").replaceFirst("penn-n", ""))));
            }
            if (str3.equals("link")) {
                if (this.tokenStack.isEmpty()) {
                    throw new SAXException("The linking of tokens to quarks is broken.");
                }
                String[] strArrSplit = attributes.getValue("targets").replace("seg-r", "").split(" ");
                int[] iArr = new int[strArrSplit.length];
                for (int i = 0; i < strArrSplit.length; i++) {
                    iArr[i] = Integer.parseInt(strArrSplit[i]);
                }
                this.tokenToQuarks.put(this.tokenStack.pop(), iArr);
            }
            if (str3.equals("a")) {
                this.tokenStackTag.push(Integer.valueOf(Integer.parseInt(attributes.getValue("ref").replaceFirst("penn-n", ""))));
            }
            if (str3.equals("f")) {
                String value = attributes.getValue("name");
                if (this.tokenStackTag.isEmpty()) {
                    throw new SAXException("The linking of tokens to their tags/bases is broken.");
                }
                if (value.equals("msd")) {
                    this.tokenToTag.put(this.tokenStackTag.peek(), attributes.getValue("value"));
                } else if (value.equals("base")) {
                    this.tokenToBase.put(this.tokenStackTag.peek(), attributes.getValue("value"));
                }
            }
        } catch (Exception e) {
            throw new SAXException(AbstractC0541b.m772n("Could not parse the Penn-POS annotation file.\n", e.getMessage()), e);
        }
    }
}
