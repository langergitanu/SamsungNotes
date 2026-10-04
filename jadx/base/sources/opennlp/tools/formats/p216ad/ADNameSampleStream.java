package opennlp.tools.formats.p216ad;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementFormulasCmd;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.result.presenter.format.ServerResultMeetingParser;
import com.vladsch.flexmark.util.html.Attribute;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.p216ad.ADSentenceStream;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.Span;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ADNameSampleStream implements ObjectStream<NameSample> {
    private static final Map<String, String> HAREM;
    private final ObjectStream<ADSentenceStream.Sentence> adSentenceStream;
    private String leftContractionPart;
    private final boolean splitHyphenatedTokens;
    private int textID;
    private static final Pattern TAG_PATTERN = Pattern.compile("<(NER:)?(.*?)>");
    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\s+");
    private static final Pattern UNDERLINE_PATTERN = Pattern.compile("[_]+");
    private static final Pattern HYPHEN_PATTERN = Pattern.compile("((\\p{L}+)-$)|(^-(\\p{L}+)(.*))|((\\p{L}+)-(\\p{L}+)(.*))");
    private static final Pattern ALPHANUMERIC_PATTERN = Pattern.compile("^[\\p{L}\\p{Nd}]+$");

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public enum Type {
        ama,
        cie,
        lit
    }

    static {
        HashMap mapM13996q = AbstractC12991c.m13996q("hum", "person", "official", "person");
        mapM13996q.put("member", "person");
        mapM13996q.put("admin", "organization");
        mapM13996q.put("org", "organization");
        mapM13996q.put("inst", "organization");
        mapM13996q.put("media", "organization");
        mapM13996q.put("party", "organization");
        mapM13996q.put("suborg", "organization");
        mapM13996q.put("groupind", "group");
        mapM13996q.put("groupofficial", "group");
        mapM13996q.put("top", ServerResultMeetingParser.PLACE);
        mapM13996q.put("civ", ServerResultMeetingParser.PLACE);
        mapM13996q.put("address", ServerResultMeetingParser.PLACE);
        mapM13996q.put("site", ServerResultMeetingParser.PLACE);
        mapM13996q.put("virtual", ServerResultMeetingParser.PLACE);
        mapM13996q.put("astro", ServerResultMeetingParser.PLACE);
        mapM13996q.put("occ", "event");
        mapM13996q.put("event", "event");
        mapM13996q.put("history", "event");
        mapM13996q.put("tit", "artprod");
        mapM13996q.put("pub", "artprod");
        mapM13996q.put(VElementFormulasCmd.FPRODUCT, "artprod");
        mapM13996q.put(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "artprod");
        mapM13996q.put("artwork", "artprod");
        mapM13996q.put("brand", "abstract");
        mapM13996q.put("genre", "abstract");
        mapM13996q.put("school", "abstract");
        mapM13996q.put("idea", "abstract");
        mapM13996q.put("plan", "abstract");
        mapM13996q.put("author", "abstract");
        mapM13996q.put("absname", "abstract");
        mapM13996q.put("disease", "abstract");
        mapM13996q.put(CoeditServiceConstants.Element.NAME_OBJECT, "thing");
        mapM13996q.put("common", "thing");
        mapM13996q.put("mat", "thing");
        mapM13996q.put(Attribute.CLASS_ATTR, "thing");
        mapM13996q.put("plant", "thing");
        mapM13996q.put("currency", "thing");
        mapM13996q.put("date", "time");
        mapM13996q.put("hour", "time");
        mapM13996q.put(TypedValues.Cycle.S_WAVE_PERIOD, "time");
        mapM13996q.put("cyclic", "time");
        mapM13996q.put("quantity", "numeric");
        mapM13996q.put("prednum", "numeric");
        mapM13996q.put("currency", "numeric");
        HAREM = Collections.unmodifiableMap(mapM13996q);
    }

    public ADNameSampleStream(ObjectStream<String> objectStream, boolean z) {
        this.leftContractionPart = null;
        this.textID = -1;
        this.adSentenceStream = new ADSentenceStream(objectStream);
        this.splitHyphenatedTokens = z;
    }

    private void addIfNotEmpty(String str, List<String> list) {
        if (str == null || str.length() <= 0) {
            return;
        }
        list.addAll(processTok(str));
    }

    private static String getNER(String str) {
        if (str.contains("<NER2>")) {
            return null;
        }
        for (String str2 : str.split("\\s+")) {
            Matcher matcher = TAG_PATTERN.matcher(str2);
            if (matcher.matches()) {
                String strGroup = matcher.group(2);
                Map<String, String> map = HAREM;
                if (map.containsKey(strGroup)) {
                    return map.get(strGroup);
                }
            }
        }
        return null;
    }

    private int getTextID(ADSentenceStream.Sentence sentence) {
        Type type;
        Pattern patternCompile;
        String metadata = sentence.getMetadata();
        if (metadata.startsWith("LIT")) {
            type = Type.lit;
            patternCompile = Pattern.compile("^([a-zA-Z\\-]+)(\\d+).*?p=(\\d+).*");
        } else if (metadata.startsWith("CIE")) {
            type = Type.cie;
            patternCompile = Pattern.compile("^.*?source=\"(.*?)\".*");
        } else {
            type = Type.ama;
            patternCompile = Pattern.compile("^(?:[a-zA-Z\\-]*(\\d+)).*?p=(\\d+).*");
        }
        if (type.equals(Type.lit)) {
            Matcher matcher = patternCompile.matcher(metadata);
            if (matcher.matches()) {
                return !matcher.group(1).equals("") ? 0 : -1;
            }
            throw new RuntimeException("Invalid metadata: ".concat(metadata));
        }
        if (type.equals(Type.cie)) {
            Matcher matcher2 = patternCompile.matcher(metadata);
            if (matcher2.matches()) {
                return !matcher2.group(1).equals("") ? 0 : -1;
            }
            throw new RuntimeException("Invalid metadata: ".concat(metadata));
        }
        if (!type.equals(Type.ama)) {
            return 0;
        }
        Matcher matcher3 = patternCompile.matcher(metadata);
        if (matcher3.matches()) {
            return Integer.parseInt(matcher3.group(1));
        }
        throw new RuntimeException("Invalid metadata: ".concat(metadata));
    }

    private void process(ADSentenceStream.SentenceParser.Node node, List<String> list, List<Span> list2) {
        if (node != null) {
            for (ADSentenceStream.SentenceParser.TreeElement treeElement : node.getElements()) {
                if (treeElement.isLeaf()) {
                    processLeaf((ADSentenceStream.SentenceParser.Leaf) treeElement, list, list2);
                } else {
                    process((ADSentenceStream.SentenceParser.Node) treeElement, list, list2);
                }
            }
        }
    }

    private void processLeaf(ADSentenceStream.SentenceParser.Leaf leaf, List<String> list, List<Span> list2) {
        boolean z;
        String ner = null;
        boolean zContains = false;
        if (this.leftContractionPart != null) {
            String contraction = PortugueseContractionUtility.toContraction(this.leftContractionPart, leaf.getLexeme());
            if (contraction != null) {
                list.addAll(Arrays.asList(WHITESPACE_PATTERN.split(contraction)));
                z = true;
            } else {
                list.add(this.leftContractionPart);
                z = false;
            }
            this.leftContractionPart = null;
        } else {
            z = false;
        }
        String secondaryTag = leaf.getSecondaryTag();
        if (secondaryTag != null) {
            if (secondaryTag.contains("<sam->") && !z) {
                String[] strArrSplit = UNDERLINE_PATTERN.split(leaf.getLexeme());
                if (strArrSplit.length > 1) {
                    list.addAll(Arrays.asList(strArrSplit).subList(0, strArrSplit.length - 1));
                }
                this.leftContractionPart = strArrSplit[strArrSplit.length - 1];
                return;
            }
            zContains = secondaryTag.contains("<NER2>");
            ner = getNER(secondaryTag);
        }
        int size = ner != null ? list.size() : -1;
        if (!z) {
            list.addAll(processLexeme(leaf.getLexeme()));
        }
        if (ner != null) {
            list2.add(new Span(size, list.size(), ner));
        }
        if (zContains) {
            int size2 = list2.size() - 1;
            if (list2.size() > 0) {
                Span span = list2.get(size2);
                if (span.getEnd() == list.size() - 1) {
                    list2.set(size2, new Span(span.getStart(), list.size(), span.getType()));
                }
            }
        }
    }

    private List<String> processLexeme(String str) {
        ArrayList arrayList = new ArrayList();
        for (String str2 : UNDERLINE_PATTERN.split(str)) {
            if (str2.length() <= 1 || ALPHANUMERIC_PATTERN.matcher(str2).matches()) {
                arrayList.add(str2);
            } else {
                arrayList.addAll(processTok(str2));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00ad  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private List<String> processTok(String str) {
        String strSubstring;
        String strGroup;
        String strGroup2;
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();
        char cCharAt = str.charAt(0);
        if (cCharAt == 171) {
            arrayList.add(Character.toString(cCharAt));
            strSubstring = str.substring(1);
        } else {
            strSubstring = str;
        }
        char cM4a = AbstractC0000a.m4a(1, strSubstring);
        if (cM4a == 187 || cM4a == ':' || cM4a == ',' || cM4a == '!') {
            linkedList.add(Character.toString(cM4a));
            strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
        }
        if (this.splitHyphenatedTokens && strSubstring.contains(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR) && strSubstring.length() > 1) {
            Matcher matcher = HYPHEN_PATTERN.matcher(strSubstring);
            if (matcher.matches()) {
                String strGroup3 = null;
                if (matcher.group(1) != null) {
                    String strGroup4 = matcher.group(2);
                    strGroup2 = null;
                    strGroup3 = strGroup4;
                    strGroup = null;
                } else if (matcher.group(3) != null) {
                    strGroup = matcher.group(4);
                    strGroup2 = matcher.group(5);
                } else if (matcher.group(6) != null) {
                    strGroup3 = matcher.group(7);
                    strGroup = matcher.group(8);
                    strGroup2 = matcher.group(9);
                } else {
                    strGroup = null;
                    strGroup2 = null;
                }
                addIfNotEmpty(strGroup3, arrayList);
                addIfNotEmpty(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR, arrayList);
                addIfNotEmpty(strGroup, arrayList);
                addIfNotEmpty(strGroup2, arrayList);
            }
        } else if (str.equals(strSubstring) || strSubstring.length() <= 1 || ALPHANUMERIC_PATTERN.matcher(strSubstring).matches()) {
            arrayList.add(strSubstring);
        } else {
            arrayList.addAll(processTok(strSubstring));
        }
        arrayList.addAll(linkedList);
        return arrayList;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.adSentenceStream.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.adSentenceStream.reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public NameSample read() {
        boolean z;
        ADSentenceStream.Sentence sentence = this.adSentenceStream.read();
        if (sentence == null) {
            return null;
        }
        int textID = getTextID(sentence);
        if (textID != this.textID) {
            this.textID = textID;
            z = true;
        } else {
            z = false;
        }
        ADSentenceStream.SentenceParser.Node root = sentence.getRoot();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        process(root, arrayList, arrayList2);
        return new NameSample((String[]) arrayList.toArray(new String[0]), (Span[]) arrayList2.toArray(new Span[0]), z);
    }

    @Deprecated(forRemoval = true)
    public ADNameSampleStream(InputStreamFactory inputStreamFactory, String str, boolean z) {
        this(new PlainTextByLineStream(inputStreamFactory, str), z);
    }
}
