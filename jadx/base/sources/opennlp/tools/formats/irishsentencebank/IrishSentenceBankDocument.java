package opennlp.tools.formats.irishsentencebank;

import com.microsoft.identity.common.internal.providers.oauth2.ResponseType;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.support.senl.p145cm.base.framework.view.InputMethodCompat;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.Span;
import opennlp.tools.util.XmlUtil;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class IrishSentenceBankDocument {
    private final List<IrishSentenceBankSentence> sentences = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IrishSentenceBankFlex {
        final String[] flex;
        final String surface;

        public IrishSentenceBankFlex(String str, String[] strArr) {
            this.surface = str;
            this.flex = strArr;
        }

        public String[] getFlex() {
            return this.flex;
        }

        public String getSurface() {
            return this.surface;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class IrishSentenceBankSentence {
        private final IrishSentenceBankFlex[] flex;
        private final String original;
        private final String source;
        private final Span[] tokens;
        private final String translation;

        public IrishSentenceBankSentence(String str, String str2, String str3, Span[] spanArr, IrishSentenceBankFlex[] irishSentenceBankFlexArr) {
            this.source = str;
            this.translation = str2;
            this.original = str3;
            this.tokens = spanArr;
            this.flex = irishSentenceBankFlexArr;
        }

        public IrishSentenceBankFlex[] getFlex() {
            return this.flex;
        }

        public String getOriginal() {
            return this.original;
        }

        public String getSource() {
            return this.source;
        }

        public TokenSample getTokenSample() {
            return new TokenSample(this.original, this.tokens);
        }

        public Span[] getTokens() {
            return this.tokens;
        }

        public String getTranslation() {
            return this.translation;
        }
    }

    private static int advanceLeft(String str, int i) {
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        for (int i2 = 0; i2 < length && charArray[i2] == ' '; i2++) {
            i++;
        }
        return i;
    }

    private static int advanceRight(String str, int i) {
        int length = str.length() - 1;
        int i2 = i + length + 1;
        while (length > 0 && str.charAt(length) == ' ') {
            i2--;
            length--;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$parse$0(Integer num) {
        return new ArrayList();
    }

    public static IrishSentenceBankDocument parse(InputStream inputStream) throws IOException {
        NodeList nodeList;
        IrishSentenceBankDocument irishSentenceBankDocument;
        int i;
        IrishSentenceBankDocument irishSentenceBankDocument2;
        int i2;
        String str;
        String str2;
        String str3;
        int i4;
        IrishSentenceBankDocument irishSentenceBankDocument3 = new IrishSentenceBankDocument();
        try {
            Document document = XmlUtil.createDocumentBuilder().parse(inputStream);
            String nodeName = document.getDocumentElement().getNodeName();
            if (!nodeName.equalsIgnoreCase("sentences")) {
                throw new IOException("Expected root node ".concat(nodeName));
            }
            NodeList childNodes = document.getDocumentElement().getChildNodes();
            int i5 = 0;
            while (i5 < childNodes.getLength()) {
                Node nodeItem = childNodes.item(i5);
                String str4 = "#comment";
                if (nodeItem.getNodeName().equals("sentence")) {
                    String nodeValue = nodeItem.getAttributes().getNamedItem("source").getNodeValue();
                    String textContent = "";
                    HashMap map = new HashMap();
                    HashMap map2 = new HashMap();
                    ArrayList arrayList = new ArrayList();
                    NodeList childNodes2 = nodeItem.getChildNodes();
                    StringBuilder sb = new StringBuilder();
                    int i6 = 1;
                    int i7 = 0;
                    while (i7 < childNodes2.getLength()) {
                        String nodeName2 = childNodes2.item(i7).getNodeName();
                        NodeList nodeList2 = childNodes;
                        switch (nodeName2.hashCode()) {
                            case -1840647503:
                                irishSentenceBankDocument2 = irishSentenceBankDocument3;
                                i2 = i5;
                                str = str4;
                                str2 = nodeValue;
                                if (!nodeName2.equals(InputMethodCompat.EXTRA_VALUE_BOARD_HBD_TRANSLATE)) {
                                    throw new IOException("Unexpected node: " + nodeName2);
                                }
                                textContent = childNodes2.item(i7).getFirstChild().getTextContent();
                                i7++;
                                i5 = i2;
                                childNodes = nodeList2;
                                nodeValue = str2;
                                str4 = str;
                                irishSentenceBankDocument3 = irishSentenceBankDocument2;
                                break;
                                break;
                            case 3145721:
                                irishSentenceBankDocument2 = irishSentenceBankDocument3;
                                i2 = i5;
                                str3 = textContent;
                                str = str4;
                                str2 = nodeValue;
                                if (!nodeName2.equals("flex")) {
                                    throw new IOException("Unexpected node: " + nodeName2);
                                }
                                int i8 = Integer.parseInt(childNodes2.item(i7).getAttributes().getNamedItem("slot").getNodeValue());
                                Integer numValueOf = Integer.valueOf(i8);
                                if (i8 > i6) {
                                    i6 = i8;
                                }
                                map2.computeIfAbsent(numValueOf, new C11419a(24));
                                ((List) map2.get(numValueOf)).add(childNodes2.item(i7).getAttributes().getNamedItem("lemma").getNodeValue());
                                textContent = str3;
                                i7++;
                                i5 = i2;
                                childNodes = nodeList2;
                                nodeValue = str2;
                                str4 = str;
                                irishSentenceBankDocument3 = irishSentenceBankDocument2;
                                break;
                                break;
                            case 35879888:
                                irishSentenceBankDocument2 = irishSentenceBankDocument3;
                                i2 = i5;
                                str3 = textContent;
                                str = str4;
                                str2 = nodeValue;
                                if (!nodeName2.equals("#text")) {
                                    throw new IOException("Unexpected node: " + nodeName2);
                                }
                                textContent = str3;
                                i7++;
                                i5 = i2;
                                childNodes = nodeList2;
                                nodeValue = str2;
                                str4 = str;
                                irishSentenceBankDocument3 = irishSentenceBankDocument2;
                                break;
                            case 1379043793:
                                i2 = i5;
                                if (!nodeName2.equals(ShareApi.ORIGINAL_SIZE_IMAGE)) {
                                    throw new IOException("Unexpected node: " + nodeName2);
                                }
                                NodeList childNodes3 = childNodes2.item(i7).getChildNodes();
                                str3 = textContent;
                                str2 = nodeValue;
                                int length = 0;
                                int i9 = 0;
                                while (i9 < childNodes3.getLength()) {
                                    String nodeName3 = childNodes3.item(i9).getNodeName();
                                    String str5 = str4;
                                    int iHashCode = nodeName3.hashCode();
                                    IrishSentenceBankDocument irishSentenceBankDocument4 = irishSentenceBankDocument3;
                                    if (iHashCode != 35879888) {
                                        if (iHashCode != 110541305 || !nodeName3.equals(ResponseType.TOKEN)) {
                                            throw new IOException("Unexpected node: " + childNodes3.item(i9).getNodeName());
                                        }
                                        String textContent2 = childNodes3.item(i9).getFirstChild().getTextContent();
                                        arrayList.add(new Span(length, textContent2.length() + length));
                                        int i10 = Integer.parseInt(childNodes3.item(i9).getAttributes().getNamedItem("slot").getNodeValue());
                                        if (i10 > i6) {
                                            i6 = i10;
                                        }
                                        map.put(Integer.valueOf(i10), textContent2);
                                        sb.append(textContent2);
                                        length += textContent2.length();
                                        i9++;
                                        str4 = str5;
                                        irishSentenceBankDocument3 = irishSentenceBankDocument4;
                                    } else {
                                        if (!nodeName3.equals("#text")) {
                                            throw new IOException("Unexpected node: " + childNodes3.item(i9).getNodeName());
                                        }
                                        String textContent3 = childNodes3.item(i9).getTextContent();
                                        sb.append(textContent3);
                                        if (" ".equals(textContent3)) {
                                            i4 = i6;
                                        } else {
                                            i4 = i6;
                                            arrayList.add(new Span(advanceLeft(textContent3, length), advanceRight(textContent3, length)));
                                        }
                                        length += textContent3.length();
                                        i6 = i4;
                                        i9++;
                                        str4 = str5;
                                        irishSentenceBankDocument3 = irishSentenceBankDocument4;
                                    }
                                }
                                irishSentenceBankDocument2 = irishSentenceBankDocument3;
                                str = str4;
                                textContent = str3;
                                i7++;
                                i5 = i2;
                                childNodes = nodeList2;
                                nodeValue = str2;
                                str4 = str;
                                irishSentenceBankDocument3 = irishSentenceBankDocument2;
                                break;
                                break;
                            case 1819218140:
                                if (!nodeName2.equals(str4)) {
                                    throw new IOException("Unexpected node: " + nodeName2);
                                }
                                irishSentenceBankDocument2 = irishSentenceBankDocument3;
                                i2 = i5;
                                str3 = textContent;
                                str = str4;
                                str2 = nodeValue;
                                textContent = str3;
                                i7++;
                                i5 = i2;
                                childNodes = nodeList2;
                                nodeValue = str2;
                                str4 = str;
                                irishSentenceBankDocument3 = irishSentenceBankDocument2;
                                break;
                                break;
                            default:
                                throw new IOException("Unexpected node: " + nodeName2);
                        }
                    }
                    nodeList = childNodes;
                    IrishSentenceBankDocument irishSentenceBankDocument5 = irishSentenceBankDocument3;
                    i = i5;
                    String str6 = textContent;
                    String str7 = nodeValue;
                    IrishSentenceBankFlex[] irishSentenceBankFlexArr = new IrishSentenceBankFlex[i6];
                    Iterator it = map.entrySet().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            Map.Entry entry = (Map.Entry) it.next();
                            Integer num = (Integer) entry.getKey();
                            String str8 = (String) entry.getValue();
                            if (map2.get(num) == null) {
                                irishSentenceBankFlexArr = null;
                            } else {
                                irishSentenceBankFlexArr[num.intValue() - 1] = new IrishSentenceBankFlex(str8, (String[]) ((List) map2.get(num)).toArray(new String[((List) map2.get(num)).size()]));
                            }
                        }
                    }
                    irishSentenceBankDocument = irishSentenceBankDocument5;
                    irishSentenceBankDocument.add(new IrishSentenceBankSentence(str7, str6, sb.toString(), (Span[]) arrayList.toArray(new Span[arrayList.size()]), irishSentenceBankFlexArr));
                } else {
                    nodeList = childNodes;
                    irishSentenceBankDocument = irishSentenceBankDocument3;
                    i = i5;
                    if (!nodeItem.getNodeName().equals("#text") && !nodeItem.getNodeName().equals("#comment")) {
                        throw new IOException("Unexpected node: " + nodeItem.getNodeName());
                    }
                }
                i5 = i + 1;
                irishSentenceBankDocument3 = irishSentenceBankDocument;
                childNodes = nodeList;
            }
            return irishSentenceBankDocument3;
        } catch (SAXException e) {
            throw new IOException("Failed to parse IrishSentenceBank document", e);
        }
    }

    public void add(IrishSentenceBankSentence irishSentenceBankSentence) {
        this.sentences.add(irishSentenceBankSentence);
    }

    public List<IrishSentenceBankSentence> getSentences() {
        return Collections.unmodifiableList(this.sentences);
    }

    public static IrishSentenceBankDocument parse(File file) throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(file.toPath(), new OpenOption[0]));
        try {
            IrishSentenceBankDocument irishSentenceBankDocument = parse(bufferedInputStream);
            bufferedInputStream.close();
            return irishSentenceBankDocument;
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
