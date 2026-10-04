package opennlp.tools.formats.p216ad;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.samsung.context.sdk.samsunganalytics.LogBuilders;
import java.util.ArrayList;
import java.util.List;
import opennlp.tools.chunker.ChunkSample;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.p216ad.ADSentenceStream;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;
import opennlp.tools.util.StringUtil;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ADChunkSampleStream implements ObjectStream<ChunkSample> {
    public static final String OTHER = "O";
    protected final ObjectStream<ADSentenceStream.Sentence> adSentenceStream;
    private int end;
    private int index;
    private int start;

    public ADChunkSampleStream(ObjectStream<String> objectStream) {
        this.start = -1;
        this.end = -1;
        this.index = 0;
        this.adSentenceStream = new ADSentenceStream(objectStream);
    }

    public static String convertFuncTag(String str, boolean z) {
        return z ? ("art".equals(str) || "pron-det".equals(str) || "pron-indef".equals(str)) ? LogBuilders.CustomDimension.DETAIL : str : str;
    }

    private void processNode(ADSentenceStream.SentenceParser.Node node, List<String> list, List<String> list2, List<String> list3, String str) {
        boolean z;
        String str2;
        List<String> list4;
        String str3;
        List<String> list5;
        List<String> list6;
        ADChunkSampleStream aDChunkSampleStream;
        int i;
        List<String> list7 = list3;
        String chunkTag = getChunkTag(node);
        if (!chunkTag.equals("O") || str == null) {
            z = false;
        } else {
            chunkTag = str;
            z = true;
        }
        ADSentenceStream.SentenceParser.TreeElement[] elements = node.getElements();
        String str4 = chunkTag;
        int i2 = 0;
        while (i2 < elements.length) {
            if (elements[i2].isLeaf()) {
                ADSentenceStream.SentenceParser.Leaf leaf = (ADSentenceStream.SentenceParser.Leaf) elements[i2];
                String chunkTag2 = getChunkTag(leaf);
                if (chunkTag2 == null || str4.equals(chunkTag2)) {
                    chunkTag2 = str4;
                }
                boolean z2 = isIntermediate(list2, list7, chunkTag2) && (z || i2 > 0);
                if (isIncludePunctuations() || leaf.getFunctionalTag() != null || ((i = i2 + 1) < elements.length && elements[i].isLeaf() && i2 > 0 && elements[i2 - 1].isLeaf())) {
                    list4 = list2;
                    str3 = chunkTag2;
                    list5 = list7;
                    list6 = list;
                    aDChunkSampleStream = this;
                } else {
                    list4 = list2;
                    str3 = "O";
                    z2 = false;
                    aDChunkSampleStream = this;
                    list5 = list7;
                    list6 = list;
                }
                aDChunkSampleStream.processLeaf(leaf, z2, str3, list6, list4, list5);
                list7 = list3;
                str2 = str4;
            } else {
                int size = list3.size();
                list7 = list3;
                str2 = str4;
                processNode((ADSentenceStream.SentenceParser.Node) elements[i2], list, list2, list7, str2);
                for (int size2 = list7.size() - 1; size2 >= size; size2--) {
                    if (!list7.get(size2).endsWith(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR + str2)) {
                        str4 = "O";
                        break;
                    }
                }
            }
            str4 = str2;
            i2++;
        }
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.adSentenceStream.close();
    }

    public String getChunkTag(ADSentenceStream.SentenceParser.Leaf leaf) {
        if ("P".equals(leaf.getSyntacticTag())) {
            return "VP";
        }
        return null;
    }

    public String getPhraseTagFromPosTag(String str) {
        return str.equals("v-fin") ? "VP" : str.equals("n") ? "NP" : "O";
    }

    public boolean isIncludePunctuations() {
        return false;
    }

    public boolean isIntermediate(List<String> list, List<String> list2, String str) {
        if (list2.size() <= 0) {
            return false;
        }
        String str2 = (String) AbstractC0000a.m10g(list2, 1);
        StringBuilder sb = new StringBuilder(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR);
        sb.append(str);
        return str2.endsWith(sb.toString());
    }

    public void processLeaf(ADSentenceStream.SentenceParser.Leaf leaf, boolean z, String str, List<String> list, List<String> list2, List<String> list3) {
        if (leaf.getFunctionalTag() != null && str.equals("O")) {
            str = getPhraseTagFromPosTag(leaf.getFunctionalTag());
        }
        if (!str.equals("O")) {
            str = z ? "I-".concat(str) : "B-".concat(str);
        }
        list.add(leaf.getLexeme());
        if (leaf.getSyntacticTag() == null) {
            list2.add(leaf.getLexeme());
        } else {
            list2.add(convertFuncTag(leaf.getFunctionalTag(), false));
        }
        list3.add(str);
    }

    public void processRoot(ADSentenceStream.SentenceParser.Node node, List<String> list, List<String> list2, List<String> list3) {
        if (node != null) {
            for (ADSentenceStream.SentenceParser.TreeElement treeElement : node.getElements()) {
                if (treeElement.isLeaf()) {
                    processLeaf((ADSentenceStream.SentenceParser.Leaf) treeElement, false, "O", list, list2, list3);
                } else {
                    processNode((ADSentenceStream.SentenceParser.Node) treeElement, list, list2, list3, null);
                }
            }
        }
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.adSentenceStream.reset();
    }

    public void setEnd(int i) {
        this.end = i;
    }

    public void setStart(int i) {
        this.start = i;
    }

    @Override // opennlp.tools.util.ObjectStream
    public ChunkSample read() {
        int i;
        while (true) {
            ADSentenceStream.Sentence sentence = this.adSentenceStream.read();
            if (sentence == null) {
                return null;
            }
            int i2 = this.end;
            if (i2 > -1 && this.index >= i2) {
                return null;
            }
            int i4 = this.start;
            if (i4 <= -1 || (i = this.index) >= i4) {
                ADSentenceStream.SentenceParser.Node root = sentence.getRoot();
                ArrayList arrayList = new ArrayList();
                List<String> arrayList2 = new ArrayList<>();
                List<String> arrayList3 = new ArrayList<>();
                processRoot(root, arrayList, arrayList2, arrayList3);
                if (arrayList.size() > 0) {
                    this.index++;
                    return new ChunkSample(arrayList, arrayList2, arrayList3);
                }
            } else {
                this.index = i + 1;
            }
        }
    }

    public String getChunkTag(ADSentenceStream.SentenceParser.Node node) {
        String syntacticTag = node.getSyntacticTag();
        String strSubstring = syntacticTag.substring(syntacticTag.lastIndexOf(":") + 1);
        while (strSubstring.endsWith(CacheKeyValueDelegate.CACHE_VALUE_SEPARATOR)) {
            strSubstring = AbstractC2322a.m1614d(1, 0, strSubstring);
        }
        if (!strSubstring.equals("np") && !strSubstring.equals("vp") && !strSubstring.equals("pp") && !strSubstring.equals("ap") && !strSubstring.equals("advp") && !strSubstring.equals("adjp")) {
            return "O";
        }
        return StringUtil.toUpperCase(strSubstring);
    }

    public ADChunkSampleStream(InputStreamFactory inputStreamFactory, String str) {
        this(new PlainTextByLineStream(inputStreamFactory, str));
    }
}
