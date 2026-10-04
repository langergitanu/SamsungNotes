package opennlp.tools.formats.masc;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.ocr.C7212a;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.collections.AbstractC12991c;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascSentence extends Span {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) MascSentence.class);
    private static final long serialVersionUID = 6295507533472650848L;
    private final List<MascWord> allDocumentWords;
    private List<Span> namedEntities;
    private List<MascToken> sentenceTokens;
    private final String text;
    private final Map<Integer, Integer> tokensById;
    private final List<MascWord> words;
    private final Map<Integer, MascWord> wordsById;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class QuarkExtractor extends AbstractC12991c {
        private final List<MascWord> allDocumentWords;
        private final Map<Integer, MascWord> wordsById;

        public /* synthetic */ QuarkExtractor(List list, int i, Map map) {
            this(map, list);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public MascWord get(int i) throws IOException {
            if (this.wordsById.containsKey(Integer.valueOf(i))) {
                return this.wordsById.get(Integer.valueOf(i));
            }
            for (MascWord mascWord : this.allDocumentWords) {
                if (mascWord.getId() == i) {
                    return mascWord;
                }
            }
            throw new IOException(AbstractC0541b.m767i(i, "Word", " not found in the document."));
        }

        public List<MascWord> allDocumentWords() {
            return this.allDocumentWords;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof QuarkExtractor)) {
                return false;
            }
            QuarkExtractor quarkExtractor = (QuarkExtractor) obj;
            return Objects.equals(this.wordsById, quarkExtractor.wordsById) && Objects.equals(this.allDocumentWords, quarkExtractor.allDocumentWords);
        }

        public final int hashCode() {
            Map<Integer, MascWord> map = this.wordsById;
            List<MascWord> list = this.allDocumentWords;
            return Objects.hashCode(list) + (Objects.hashCode(map) * 31);
        }

        public final String toString() {
            Object[] objArr = {this.wordsById, this.allDocumentWords};
            String[] strArrSplit = "wordsById;allDocumentWords".length() == 0 ? new String[0] : "wordsById;allDocumentWords".split(";");
            StringBuilder sb = new StringBuilder();
            sb.append(QuarkExtractor.class.getSimpleName());
            sb.append("[");
            for (int i = 0; i < strArrSplit.length; i++) {
                sb.append(strArrSplit[i]);
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                sb.append(objArr[i]);
                if (i != strArrSplit.length - 1) {
                    sb.append(SQLKeyword.COMMA);
                }
            }
            sb.append("]");
            return sb.toString();
        }

        public Map<Integer, MascWord> wordsById() {
            return this.wordsById;
        }

        private QuarkExtractor(Map<Integer, MascWord> map, List<MascWord> list) {
            this.wordsById = map;
            this.allDocumentWords = list;
        }
    }

    public MascSentence(int i, int i2, String str, List<MascWord> list, List<MascWord> list2) {
        super(i, i2);
        this.sentenceTokens = null;
        this.tokensById = new HashMap();
        this.namedEntities = new ArrayList();
        this.text = str;
        this.words = list;
        this.allDocumentWords = list2;
        HashMap map = new HashMap();
        for (MascWord mascWord : list) {
            map.put(Integer.valueOf(mascWord.getId()), mascWord);
        }
        this.wordsById = map;
    }

    public boolean addNamedEntities(Map<Integer, String> map, Map<Integer, List<Integer>> map2) throws IOException {
        int i;
        if (this.sentenceTokens == null) {
            throw new IOException("Named entity labels provided for an un-tokenized sentence.");
        }
        Iterator<Map.Entry<Integer, List<Integer>>> it = map2.entrySet().iterator();
        while (true) {
            i = 0;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Integer, List<Integer>> next = it.next();
            Integer key = next.getKey();
            key.intValue();
            String str = map.get(key);
            List<Integer> value = next.getValue();
            int size = this.sentenceTokens.size();
            int iIntValue = size;
            int iIntValue2 = 0;
            for (Integer num : value) {
                num.intValue();
                if (this.tokensById.containsKey(num)) {
                    if (this.tokensById.get(num).intValue() < iIntValue) {
                        iIntValue = this.tokensById.get(num).intValue();
                    }
                    if (this.tokensById.get(num).intValue() > iIntValue2) {
                        iIntValue2 = this.tokensById.get(num).intValue() + 1;
                    }
                    i = 1;
                }
            }
            if (i != 0) {
                this.namedEntities.add(new Span(iIntValue, iIntValue2, str));
            }
        }
        this.namedEntities.sort(Comparator.comparingInt(new C7212a(3)));
        HashSet hashSet = new HashSet();
        int i2 = 0;
        int i4 = 1;
        boolean z = true;
        while (i4 < this.namedEntities.size()) {
            Span span = this.namedEntities.get(i2);
            Span span2 = this.namedEntities.get(i4);
            if (span.contains(span2) || span.crosses(span2)) {
                logger.warn("Named entities overlap. This is forbidden in OpenNLP.\n\tKeeping the longer of them.");
                if (span2.length() > span.length()) {
                    hashSet.add(Integer.valueOf(i2));
                } else {
                    hashSet.add(Integer.valueOf(i4));
                }
                i4++;
                z = false;
            } else {
                i2++;
            }
        }
        if (!z) {
            ArrayList arrayList = new ArrayList();
            while (i < this.namedEntities.size() - 1) {
                if (!hashSet.contains(Integer.valueOf(i))) {
                    arrayList.add(this.namedEntities.get(i));
                }
                i++;
            }
            this.namedEntities = Collections.unmodifiableList(arrayList);
        }
        return z;
    }

    public List<Span> getNamedEntities() {
        return this.namedEntities;
    }

    public String getSentDetectText() {
        return this.text.substring(getStart(), getEnd());
    }

    public List<String> getTags() {
        ArrayList arrayList = new ArrayList();
        Iterator<MascToken> it = this.sentenceTokens.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getPos());
        }
        return arrayList;
    }

    public List<String> getTokenStrings() {
        ArrayList arrayList = new ArrayList();
        for (MascToken mascToken : this.sentenceTokens) {
            arrayList.add(this.text.substring(mascToken.getStart(), mascToken.getEnd()));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String getTokenText() {
        return this.sentenceTokens.isEmpty() ? "" : this.text.substring(this.sentenceTokens.get(0).getStart(), ((MascToken) AbstractC0000a.m10g(this.sentenceTokens, 1)).getEnd());
    }

    public List<Span> getTokensSpans() {
        ArrayList arrayList = new ArrayList();
        int start = this.sentenceTokens.isEmpty() ? 0 : this.sentenceTokens.get(0).getStart();
        for (MascToken mascToken : this.sentenceTokens) {
            arrayList.add(new Span(mascToken.getStart() - start, mascToken.getEnd() - start));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6 */
    public boolean tokenizePenn(Map<Integer, int[]> map, Map<Integer, int[]> map2, Map<Integer, String> map3, Map<Integer, String> map4) {
        QuarkExtractor quarkExtractor;
        Iterator<MascWord> it;
        int i;
        int i2 = 0;
        QuarkExtractor quarkExtractor2 = new QuarkExtractor(this.allDocumentWords, i2, this.wordsById);
        this.sentenceTokens = new ArrayList();
        HashMap map5 = new HashMap();
        Iterator<MascWord> it2 = this.words.iterator();
        boolean z = 1;
        while (it2.hasNext()) {
            int[] iArr = map2.get(Integer.valueOf(it2.next().getId()));
            if (iArr != null) {
                int length = iArr.length;
                int i4 = i2;
                z = z;
                while (i4 < length) {
                    int i5 = iArr[i4];
                    if (map5.containsKey(Integer.valueOf(i5))) {
                        quarkExtractor = quarkExtractor2;
                        it = it2;
                        i = i2;
                    } else {
                        int[] iArr2 = map.get(Integer.valueOf(i5));
                        if (iArr2 == null) {
                            i = i2;
                            logger.warn("Token without quarks found: {}", Integer.valueOf(i5));
                        } else {
                            i = i2;
                        }
                        int length2 = iArr2.length;
                        int i6 = i;
                        z = z;
                        while (i6 < length2) {
                            int i7 = iArr2[i6];
                            Iterator<MascWord> it3 = it2;
                            if (!this.wordsById.containsKey(Integer.valueOf(i7))) {
                                logger.warn("Some tokens cross sentence boundaries.\n\tQuark ID: {}\n\tPenn token ID: {}", Integer.valueOf(i7), Integer.valueOf(i5));
                                z = i;
                            }
                            i6++;
                            it2 = it3;
                            z = z;
                        }
                        it = it2;
                        int length3 = iArr2.length;
                        MascWord[] mascWordArr = new MascWord[length3];
                        for (int i8 = i; i8 < length3; i8++) {
                            mascWordArr[i8] = quarkExtractor2.get(iArr2[i8]);
                        }
                        int start = quarkExtractor2.get(iArr2[i]).getStart();
                        int end = quarkExtractor2.get(iArr2[iArr2.length - 1]).getEnd();
                        if (end - start > 0) {
                            quarkExtractor = quarkExtractor2;
                            this.sentenceTokens.add(new MascToken(start, end, i5, map4.get(Integer.valueOf(i5)), map3.get(Integer.valueOf(i5)), mascWordArr));
                            map5.put(Integer.valueOf(i5), Boolean.TRUE);
                        } else {
                            quarkExtractor = quarkExtractor2;
                        }
                    }
                    i4++;
                    i2 = i;
                    it2 = it;
                    quarkExtractor2 = quarkExtractor;
                    z = z;
                }
            }
            i2 = i2;
            it2 = it2;
            quarkExtractor2 = quarkExtractor2;
            z = z;
        }
        while (i2 < this.sentenceTokens.size()) {
            this.tokensById.put(Integer.valueOf(this.sentenceTokens.get(i2).getTokenId()), Integer.valueOf(i2));
            i2++;
        }
        this.sentenceTokens = Collections.unmodifiableList(this.sentenceTokens);
        return z;
    }
}
