package opennlp.tools.formats.p216ad;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.p216ad.ADSentenceStream;
import opennlp.tools.postag.POSSample;
import opennlp.tools.util.InputStreamFactory;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.PlainTextByLineStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ADPOSSampleStream implements ObjectStream<POSSample> {
    private static final Pattern WHITESPACES_PATTERN = Pattern.compile("\\s+");
    private final ObjectStream<ADSentenceStream.Sentence> adSentenceStream;
    private final boolean expandME;
    private final boolean isIncludeFeatures;

    public ADPOSSampleStream(ObjectStream<String> objectStream, boolean z, boolean z2) {
        this.adSentenceStream = new ADSentenceStream(objectStream);
        this.expandME = z;
        this.isIncludeFeatures = z2;
    }

    private void process(ADSentenceStream.SentenceParser.Node node, List<String> list, List<String> list2) {
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

    private void processLeaf(ADSentenceStream.SentenceParser.Leaf leaf, List<String> list, List<String> list2) {
        if (leaf != null) {
            String lexeme = leaf.getLexeme();
            String functionalTag = leaf.getFunctionalTag();
            if (functionalTag == null) {
                functionalTag = leaf.getLexeme();
            }
            if (this.isIncludeFeatures && leaf.getMorphologicalTag() != null) {
                functionalTag = AbstractC0541b.m757C(functionalTag, " ", leaf.getMorphologicalTag());
            }
            String strReplaceAll = WHITESPACES_PATTERN.matcher(functionalTag).replaceAll(MarketingConstants.REFERRER_DELIMITER_U003D);
            if (strReplaceAll == null) {
                strReplaceAll = lexeme;
            }
            if (!this.expandME || !lexeme.contains("_")) {
                list.add(lexeme);
                list2.add(strReplaceAll);
                return;
            }
            StringTokenizer stringTokenizer = new StringTokenizer(lexeme, "_");
            if (stringTokenizer.countTokens() <= 0) {
                list.add(lexeme);
                list2.add(strReplaceAll);
                return;
            }
            ArrayList arrayList = new ArrayList(stringTokenizer.countTokens());
            ArrayList arrayList2 = new ArrayList(stringTokenizer.countTokens());
            arrayList.add(stringTokenizer.nextToken());
            arrayList2.add("B-" + strReplaceAll);
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.add(stringTokenizer.nextToken());
                arrayList2.add("I-" + strReplaceAll);
            }
            list.addAll(arrayList);
            list2.addAll(arrayList2);
        }
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
    public POSSample read() {
        ADSentenceStream.Sentence sentence = this.adSentenceStream.read();
        if (sentence == null) {
            return null;
        }
        ADSentenceStream.SentenceParser.Node root = sentence.getRoot();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        process(root, arrayList, arrayList2);
        return new POSSample(arrayList, arrayList2);
    }

    public ADPOSSampleStream(InputStreamFactory inputStreamFactory, String str, boolean z, boolean z2) {
        this(new PlainTextByLineStream(inputStreamFactory, str), z, z2);
    }
}
