package opennlp.tools.lemmatizer;

import androidx.collection.AbstractC0622a;
import androidx.glance.AbstractC2821a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import opennlp.tools.commons.Sample;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmaSample implements Sample {
    private static final long serialVersionUID = -7956607496164605337L;
    private final List<String> lemmas;
    private final List<String> tags;
    private final List<String> tokens;

    public LemmaSample(String[] strArr, String[] strArr2, String[] strArr3) {
        this((List<String>) Arrays.asList(strArr), (List<String>) Arrays.asList(strArr2), (List<String>) Arrays.asList(strArr3));
    }

    private void validateArguments(int i, int i2, int i4) {
        if (i != i2 || i2 != i4) {
            throw new IllegalArgumentException(AbstractC2821a.m2223n(AbstractC0622a.m1173s(i, i2, "All arrays must have the same length: sentenceSize: ", ", tagsSize: ", ", predsSize: "), "!", i4));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LemmaSample) {
            LemmaSample lemmaSample = (LemmaSample) obj;
            if (Arrays.equals(getTokens(), lemmaSample.getTokens()) && Arrays.equals(getTags(), lemmaSample.getTags()) && Arrays.equals(getLemmas(), lemmaSample.getLemmas())) {
                return true;
            }
        }
        return false;
    }

    public String[] getLemmas() {
        return (String[]) this.lemmas.toArray(new String[0]);
    }

    public String[] getTags() {
        return (String[]) this.tags.toArray(new String[0]);
    }

    public String[] getTokens() {
        return (String[]) this.tokens.toArray(new String[0]);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(getTokens())), Integer.valueOf(Arrays.hashCode(getTags())), Integer.valueOf(Arrays.hashCode(getLemmas())));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int iM2213d = 0;
        while (iM2213d < this.lemmas.size()) {
            sb.append(this.tokens.get(iM2213d));
            sb.append("\t");
            sb.append(this.tags.get(iM2213d));
            sb.append("\t");
            iM2213d = AbstractC2821a.m2213d(sb, iM2213d, 1, this.lemmas.get(iM2213d), "\n");
        }
        return sb.toString();
    }

    public LemmaSample(List<String> list, List<String> list2, List<String> list3) {
        validateArguments(list.size(), list2.size(), list3.size());
        ArrayList arrayList = new ArrayList(list.size());
        for (String str : list) {
            Objects.requireNonNull(str);
            arrayList.add(str);
        }
        this.tokens = Collections.unmodifiableList(arrayList);
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
        this.lemmas = Collections.unmodifiableList(arrayList3);
    }
}
