package opennlp.tools.chunker;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import opennlp.tools.commons.Sample;
import opennlp.tools.util.Span;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkSample implements Sample {
    private static final long serialVersionUID = -3092850871020409815L;
    private final List<String> preds;
    private final List<String> sentence;
    private final List<String> tags;

    public ChunkSample(String[] strArr, String[] strArr2, String[] strArr3) {
        this((List<String>) Arrays.asList(strArr), (List<String>) Arrays.asList(strArr2), (List<String>) Arrays.asList(strArr3));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Span[] phrasesAsSpanList(String[] strArr, String[] strArr2, String[] strArr3) {
        validateArguments(strArr.length, strArr2.length, strArr3.length);
        ArrayList arrayList = new ArrayList(strArr.length);
        int length = strArr3.length;
        String strSubstring = "";
        boolean z = false;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            String str = strArr3[i2];
            if (!str.startsWith("B-")) {
                if (str.equals("I-" + strSubstring) || str.equals("O")) {
                    if (!str.equals("I-" + strSubstring) && z) {
                        arrayList.add(new Span(i, i2, strSubstring));
                        strSubstring = "";
                        z = false;
                    }
                } else {
                    if (z) {
                        arrayList.add(new Span(i, i2, strSubstring));
                    }
                    strSubstring = str.substring(2);
                    z = true;
                    i = i2;
                }
            }
        }
        if (z) {
            arrayList.add(new Span(i, strArr3.length, strSubstring));
        }
        return (Span[]) arrayList.toArray(new Span[0]);
    }

    private static void validateArguments(int i, int i2, int i4) {
        if (i != i2 || i2 != i4) {
            throw new IllegalArgumentException(AbstractC2821a.m2223n(AbstractC0622a.m1173s(i, i2, "All arrays must have the same length: sentenceSize: ", ", tagsSize: ", ", predsSize: "), "!", i4));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChunkSample) {
            ChunkSample chunkSample = (ChunkSample) obj;
            if (Arrays.equals(getSentence(), chunkSample.getSentence()) && Arrays.equals(getTags(), chunkSample.getTags()) && Arrays.equals(getPreds(), chunkSample.getPreds())) {
                return true;
            }
        }
        return false;
    }

    public Span[] getPhrasesAsSpanList() {
        return phrasesAsSpanList(getSentence(), getTags(), getPreds());
    }

    public String[] getPreds() {
        return (String[]) this.preds.toArray(new String[0]);
    }

    public String[] getSentence() {
        return (String[]) this.sentence.toArray(new String[0]);
    }

    public String[] getTags() {
        return (String[]) this.tags.toArray(new String[0]);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(getSentence())), Integer.valueOf(Arrays.hashCode(getTags())), Integer.valueOf(Arrays.hashCode(getPreds())));
    }

    public String nicePrint() {
        Span[] phrasesAsSpanList = getPhrasesAsSpanList();
        StringBuilder sb = new StringBuilder(" ");
        for (int i = 0; i < this.sentence.size(); i++) {
            for (Span span : phrasesAsSpanList) {
                if (span.getStart() == i) {
                    sb.append("[");
                    sb.append(span.getType());
                    sb.append(" ");
                }
                if (span.getEnd() == i) {
                    sb.append("] ");
                }
            }
            sb.append(this.sentence.get(i));
            sb.append("_");
            sb.append(this.tags.get(i));
            sb.append(' ');
        }
        if (this.sentence.size() > 1) {
            sb.setLength(sb.length() - 1);
        }
        for (Span span2 : phrasesAsSpanList) {
            if (span2.getEnd() == this.sentence.size()) {
                sb.append(PropertyUtils.INDEXED_DELIM2);
            }
        }
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iM2213d = 0;
        while (iM2213d < this.preds.size()) {
            sb.append(this.sentence.get(iM2213d));
            sb.append(" ");
            sb.append(this.tags.get(iM2213d));
            sb.append(" ");
            iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, this.preds.get(iM2213d), "\n");
        }
        return sb.toString();
    }

    public ChunkSample(List<String> list, List<String> list2, List<String> list3) {
        validateArguments(list.size(), list2.size(), list3.size());
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            Objects.requireNonNull(str);
            arrayList.add(str);
        }
        this.sentence = Collections.unmodifiableList(arrayList);
        ArrayList arrayList2 = new ArrayList(list2.size());
        for (String str2 : list2) {
            Objects.requireNonNull(str2);
            arrayList2.add(str2);
        }
        this.tags = Collections.unmodifiableList(arrayList2);
        ArrayList arrayList3 = new ArrayList(list3.size());
        for (String str3 : list3) {
            Objects.requireNonNull(str3);
            arrayList3.add(str3);
        }
        this.preds = Collections.unmodifiableList(arrayList3);
    }
}
