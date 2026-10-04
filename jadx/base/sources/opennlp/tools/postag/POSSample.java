package opennlp.tools.postag;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.compose.foundation.layout.AbstractC1038a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import opennlp.tools.commons.Sample;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.InvalidFormatException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSSample implements Sample {
    private static final long serialVersionUID = -5782784526335651421L;
    private final String[][] additionalContext;
    private final List<String> sentence;
    private final List<String> tags;

    public POSSample(String[] strArr, String[] strArr2) {
        this(strArr, strArr2, (String[][]) null);
    }

    private void checkArguments() {
        if (this.sentence.size() != this.tags.size()) {
            throw new IllegalArgumentException(AbstractC1038a.m1214o(this.sentence.size(), this.tags.size(), "There must be exactly one tag for each token. tokens: ", ", tags: "));
        }
        if (this.sentence.contains(null)) {
            throw new IllegalArgumentException("null elements are not allowed in sentence tokens!");
        }
        if (this.tags.contains(null)) {
            throw new IllegalArgumentException("null elements are not allowed in tags!");
        }
    }

    public static POSSample parse(String str) throws InvalidFormatException {
        String[] strArr = WhitespaceTokenizer.INSTANCE.tokenize(str);
        String[] strArr2 = new String[strArr.length];
        String[] strArr3 = new String[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            int iLastIndexOf = strArr[i].lastIndexOf("_");
            if (iLastIndexOf == -1) {
                throw new InvalidFormatException(AbstractC0541b.m773o("Cannot find \"_\" inside token '", strArr[i], "'!"));
            }
            strArr2[i] = strArr[i].substring(0, iLastIndexOf);
            strArr3[i] = strArr[i].substring(iLastIndexOf + 1);
        }
        return new POSSample(strArr2, strArr3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof POSSample) {
            POSSample pOSSample = (POSSample) obj;
            if (Arrays.equals(getSentence(), pOSSample.getSentence()) && Arrays.equals(getTags(), pOSSample.getTags())) {
                return true;
            }
        }
        return false;
    }

    public String[][] getAdditionalContext() {
        return this.additionalContext;
    }

    public String[] getSentence() {
        return (String[]) this.sentence.toArray(new String[0]);
    }

    public String[] getTags() {
        return (String[]) this.tags.toArray(new String[0]);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(getSentence())), Integer.valueOf(Arrays.hashCode(getTags())));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getSentence().length; i++) {
            sb.append(getSentence()[i]);
            sb.append('_');
            sb.append(getTags()[i]);
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public POSSample(List<String> list, List<String> list2) {
        this(list, list2, (String[][]) null);
    }

    public POSSample(List<String> list, List<String> list2, String[][] strArr) {
        String[][] strArr2;
        this.sentence = Collections.unmodifiableList(list);
        this.tags = Collections.unmodifiableList(list2);
        checkArguments();
        if (strArr != null) {
            strArr2 = new String[strArr.length][];
            for (int i = 0; i < strArr.length; i++) {
                String[] strArr3 = new String[strArr[i].length];
                strArr2[i] = strArr3;
                String[] strArr4 = strArr[i];
                System.arraycopy(strArr4, 0, strArr3, 0, strArr4.length);
            }
        } else {
            strArr2 = null;
        }
        this.additionalContext = strArr2;
    }

    public POSSample(String[] strArr, String[] strArr2, String[][] strArr3) {
        this((List<String>) Arrays.asList(strArr), (List<String>) Arrays.asList(strArr2), strArr3);
    }
}
