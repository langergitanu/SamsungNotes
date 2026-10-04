package opennlp.tools.formats.conllu;

import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.p148nt.base.common.displaydata.ContentUtils;
import com.samsung.android.support.senl.p148nt.model.collector.common.C11419a;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.stream.Collectors;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.ParagraphStream;
import opennlp.tools.util.PlainTextByLineStream;
import org.slf4j.Marker;
import p074R1.C0233e;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConlluStream implements ObjectStream<ConlluSentence> {
    private static final Pattern regex = Pattern.compile("text_([a-z]{2,3})");
    private final ObjectStream<String> sentenceStream;

    public ConlluStream(InputStreamFactory inputStreamFactory) {
        this.sentenceStream = new ParagraphStream(new PlainTextByLineStream(inputStreamFactory, StandardCharsets.UTF_8));
    }

    private Map<Locale, String> addTextLang(String str, String str2, Map<Locale, String> map) throws InvalidFormatException {
        try {
            Matcher matcher = regex.matcher(str);
            String strGroup = matcher.find() ? matcher.group(1) : "";
            if (strGroup.isEmpty()) {
                throw new InvalidFormatException("Locale language code is invalid: ".concat(strGroup));
            }
            map.put(new Locale(strGroup), str2);
            return map;
        } catch (PatternSyntaxException e) {
            throw new InvalidFormatException(e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$mergeAnnotation$0(ConlluWordLine conlluWordLine) {
        return !"_".equals(conlluWordLine.getLemma());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$mergeAnnotation$1(ConlluWordLine conlluWordLine) {
        return !"_".equals(conlluWordLine.getPosTag(ConlluTagset.U));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$mergeAnnotation$2(ConlluWordLine conlluWordLine) {
        return conlluWordLine.getPosTag(ConlluTagset.U);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$mergeAnnotation$3(ConlluWordLine conlluWordLine) {
        return !"_".equals(conlluWordLine.getPosTag(ConlluTagset.X));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String lambda$mergeAnnotation$4(ConlluWordLine conlluWordLine) {
        return conlluWordLine.getPosTag(ConlluTagset.X);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$mergeAnnotation$5(ConlluWordLine conlluWordLine) {
        return !"_".equals(conlluWordLine.getFeats());
    }

    private ConlluWordLine mergeAnnotation(ConlluWordLine conlluWordLine, List<ConlluWordLine> list) {
        return new ConlluWordLine(conlluWordLine.getId(), conlluWordLine.getForm(), (String) list.stream().filter(new C0233e(10)).map(new C11419a(20)).collect(Collectors.joining(Marker.ANY_NON_NULL_MARKER)), (String) list.stream().filter(new C0233e(11)).map(new C11419a(21)).collect(Collectors.joining(Marker.ANY_NON_NULL_MARKER)), (String) list.stream().filter(new C0233e(12)).map(new C11419a(22)).collect(Collectors.joining(Marker.ANY_NON_NULL_MARKER)), (String) list.stream().filter(new C0233e(13)).map(new C11419a(23)).collect(Collectors.joining(Marker.ANY_NON_NULL_MARKER)), conlluWordLine.getHead(), conlluWordLine.getDeprel(), conlluWordLine.getDeps(), conlluWordLine.getMisc());
    }

    private List<ConlluWordLine> postProcessContractions(List<ConlluWordLine> list) {
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ConlluWordLine conlluWordLine = list.get(i);
            map.put(conlluWordLine.getId(), Integer.valueOf(i));
            if (conlluWordLine.getId().contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
                ArrayList arrayList2 = new ArrayList();
                String[] strArrSplit = conlluWordLine.getId().split(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
                int i2 = Integer.parseInt(strArrSplit[1]);
                for (int i4 = Integer.parseInt(strArrSplit[0]); i4 <= i2; i4++) {
                    String string = Integer.toString(i4);
                    arrayList2.add(string);
                    arrayList.add(string);
                }
                map2.put(conlluWordLine.getId(), arrayList2);
            }
        }
        for (Map.Entry entry : map2.entrySet()) {
            String str = (String) entry.getKey();
            List list2 = (List) entry.getValue();
            int iIntValue = ((Integer) map.get(str)).intValue();
            ConlluWordLine conlluWordLine2 = list.get(iIntValue);
            ArrayList arrayList3 = new ArrayList();
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                arrayList3.add(list.get(((Integer) map.get((String) it.next())).intValue()));
            }
            list.set(iIntValue, mergeAnnotation(conlluWordLine2, arrayList3));
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            list.remove(((Integer) map.get(arrayList.get(size))).intValue());
        }
        return list;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.sentenceStream.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.sentenceStream.reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public ConlluSentence read() throws IOException {
        String str = this.sentenceStream.read();
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        Map<Locale, String> map = null;
        String str6 = null;
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return new ConlluSentence(postProcessContractions(arrayList), str2, str3, z, str4, z2, str5, map, str6);
            }
            if (line.trim().startsWith(ContentUtils.HASH_SYMBOL)) {
                String strSubstring = line.trim().substring(1);
                int iIndexOf = strSubstring.indexOf(61);
                if (iIndexOf != -1) {
                    String strTrim = strSubstring.substring(i, iIndexOf).trim();
                    String strTrim2 = strSubstring.substring(iIndexOf + 1, strSubstring.length()).trim();
                    if (!strTrim2.isEmpty()) {
                        strTrim.getClass();
                        switch (strTrim) {
                            case "newdoc id":
                                str4 = strTrim2;
                                z = true;
                                break;
                            case "text":
                                str3 = strTrim2;
                                break;
                            case "newpar id":
                                str5 = strTrim2;
                                z2 = true;
                                break;
                            case "translit":
                                str6 = strTrim2;
                                break;
                            case "sent_id":
                                str2 = strTrim2;
                                break;
                        }
                    }
                    if (strTrim.startsWith("text_")) {
                        if (map == null) {
                            map = new HashMap<>();
                        }
                        addTextLang(strTrim, strTrim2, map);
                    }
                } else {
                    String strTrim3 = strSubstring.trim();
                    strTrim3.getClass();
                    if (strTrim3.equals("newdoc")) {
                        z = true;
                    } else if (strTrim3.equals("newpar")) {
                        z2 = true;
                    }
                }
            } else {
                arrayList.add(new ConlluWordLine(line));
            }
            i = 0;
        }
    }
}
