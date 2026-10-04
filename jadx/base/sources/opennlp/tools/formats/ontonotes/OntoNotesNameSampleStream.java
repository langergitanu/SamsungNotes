package opennlp.tools.formats.ontonotes;

import com.microsoft.identity.client.internal.MsalUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.parser.Parse;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;
import opennlp.tools.util.StringUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class OntoNotesNameSampleStream extends FilterObjectStream<String, NameSample> {
    private final List<NameSample> nameSamples;
    private final Map<String, String> tokenConversionMap;

    public OntoNotesNameSampleStream(ObjectStream<String> objectStream) {
        super(objectStream);
        this.nameSamples = new LinkedList();
        HashMap mapM13996q = AbstractC12991c.m13996q("-LRB-", "(", "-RRB-", ")");
        mapM13996q.put("-LSB-", "[");
        mapM13996q.put("-RSB-", "]");
        mapM13996q.put("-LCB-", Parse.BRACKET_LCB);
        mapM13996q.put("-RCB-", "}");
        mapM13996q.put("-AMP-", MsalUtils.QUERY_STRING_DELIMITER);
        this.tokenConversionMap = Collections.unmodifiableMap(mapM13996q);
    }

    private String convertToken(String str) {
        StringBuilder sb = new StringBuilder(str);
        int iIndexOf = sb.indexOf(">");
        if (str.contains("=\"") && iIndexOf != -1) {
            sb.delete(0, iIndexOf + 1);
        }
        int iIndexOf2 = sb.indexOf("<");
        int iIndexOf3 = sb.indexOf(">");
        if (iIndexOf2 != -1 && iIndexOf3 != -1) {
            sb.delete(iIndexOf2, iIndexOf3 + 1);
        }
        String string = sb.toString();
        return this.tokenConversionMap.get(string) != null ? this.tokenConversionMap.get(string) : string;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x008d  */
    @Override // opennlp.tools.util.ObjectStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public NameSample read() throws IOException {
        String str;
        if (this.nameSamples.isEmpty() && (str = (String) this.samples.read()) != null) {
            BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
            boolean z = true;
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (!line.startsWith("<DOC")) {
                    if (line.equals("</DOC>")) {
                        break;
                    }
                    String[] strArr = WhitespaceTokenizer.INSTANCE.tokenize(line);
                    LinkedList linkedList = new LinkedList();
                    ArrayList arrayList = new ArrayList(strArr.length);
                    boolean z2 = false;
                    int i = 0;
                    int i2 = -1;
                    String lowerCase = null;
                    for (String str2 : strArr) {
                        if (str2.startsWith("<ENAMEX")) {
                            z2 = true;
                        } else if (z2) {
                            if (str2.startsWith("TYPE=\"")) {
                                lowerCase = StringUtil.toLowerCase(str2.substring(6, str2.indexOf("\"", 6)));
                            }
                            if (str2.contains(">")) {
                                z2 = false;
                                i2 = i;
                                if (str2.endsWith("</ENAMEX>")) {
                                }
                                arrayList.add(convertToken(str2));
                                i++;
                            }
                        } else {
                            if (str2.endsWith("</ENAMEX>")) {
                                linkedList.add(new Span(i2, i + 1, lowerCase));
                                i2 = -1;
                            }
                            arrayList.add(convertToken(str2));
                            i++;
                        }
                    }
                    this.nameSamples.add(new NameSample((String[]) arrayList.toArray(new String[0]), (Span[]) linkedList.toArray(new Span[0]), z));
                    z = false;
                }
            }
        }
        if (this.nameSamples.isEmpty()) {
            return null;
        }
        return this.nameSamples.remove(0);
    }
}
