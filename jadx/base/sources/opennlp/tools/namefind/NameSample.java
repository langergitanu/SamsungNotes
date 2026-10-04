package opennlp.tools.namefind;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.glance.AbstractC2821a;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import opennlp.tools.commons.Sample;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NameSample implements Sample {
    public static final String DEFAULT_TYPE = "default";
    private static final Pattern START_TAG_PATTERN = Pattern.compile("<START(:([^:>\\s]*))?>");
    private static final long serialVersionUID = 1655333056555270688L;
    private final String[][] additionalContext;

    /* JADX INFO: renamed from: id */
    private final String f9679id;
    private final boolean isClearAdaptiveData;
    private final List<Span> names;
    private final List<String> sentence;

    public NameSample(String str, String[] strArr, Span[] spanArr, String[][] strArr2, boolean z) {
        this.f9679id = str;
        Objects.requireNonNull(strArr, "sentence must not be null");
        spanArr = spanArr == null ? new Span[0] : spanArr;
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str2 : strArr) {
            Objects.requireNonNull(str2);
            arrayList.add(str2);
        }
        this.sentence = Collections.unmodifiableList(arrayList);
        List listAsList = Arrays.asList(spanArr);
        Collections.sort(listAsList);
        this.names = Collections.unmodifiableList(listAsList);
        if (strArr2 != null) {
            this.additionalContext = new String[strArr2.length][];
            for (int i = 0; i < strArr2.length; i++) {
                String[][] strArr3 = this.additionalContext;
                String[] strArr4 = new String[strArr2[i].length];
                strArr3[i] = strArr4;
                String[] strArr5 = strArr2[i];
                System.arraycopy(strArr5, 0, strArr4, 0, strArr5.length);
            }
        } else {
            this.additionalContext = null;
        }
        this.isClearAdaptiveData = z;
        if (this.names.size() > 1) {
            for (int i2 = 1; i2 < this.names.size(); i2++) {
                int i4 = i2 - 1;
                if (this.names.get(i2).getStart() < this.names.get(i4).getEnd()) {
                    throw new RuntimeException(String.format("name spans %s and %s are overlapped in file: %s, sentence: %s", this.names.get(i4), this.names.get(i2), str, this.sentence.toString()));
                }
            }
        }
    }

    private static String errorTokenWithContext(String[] strArr, int i) {
        StringBuilder sb = new StringBuilder();
        if (i > 1) {
            sb.append(strArr[i - 2]);
            sb.append(" ");
        }
        if (i > 0) {
            sb.append(strArr[i - 1]);
            sb.append(" ");
        }
        sb.append("###");
        int iM2213d = AbstractC2821a.m2213d(sb, i, 1, strArr[i], "### ");
        if (iM2213d < strArr.length) {
            sb.append(strArr[iM2213d]);
            sb.append(" ");
        }
        int i2 = i + 2;
        if (i2 < strArr.length) {
            sb.append(strArr[i2]);
        }
        return sb.toString();
    }

    public static NameSample parse(String str, boolean z) {
        return parse(str, "default", z);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof NameSample) {
            NameSample nameSample = (NameSample) obj;
            if (Arrays.equals(getSentence(), nameSample.getSentence()) && Arrays.equals(getNames(), nameSample.getNames()) && Arrays.equals(getAdditionalContext(), nameSample.getAdditionalContext()) && isClearAdaptiveDataSet() == nameSample.isClearAdaptiveDataSet()) {
                return true;
            }
        }
        return false;
    }

    public String[][] getAdditionalContext() {
        return this.additionalContext;
    }

    public String getId() {
        return this.f9679id;
    }

    public Span[] getNames() {
        return (Span[]) this.names.toArray(new Span[0]);
    }

    public String[] getSentence() {
        return (String[]) this.sentence.toArray(new String[0]);
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(Arrays.hashCode(getSentence())), Integer.valueOf(Arrays.hashCode(getNames())), Integer.valueOf(Arrays.hashCode(getAdditionalContext())), Boolean.valueOf(isClearAdaptiveDataSet()));
    }

    public boolean isClearAdaptiveDataSet() {
        return this.isClearAdaptiveData;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isClearAdaptiveDataSet()) {
            sb.append("\n");
        }
        for (int i = 0; i < this.sentence.size(); i++) {
            for (Span span : this.names) {
                if (span.getStart() == i) {
                    if (span.getType() == null) {
                        sb.append("<START> ");
                    } else {
                        sb.append(NameSampleDataStream.START_TAG_PREFIX);
                        sb.append(span.getType());
                        sb.append("> ");
                    }
                }
                if (span.getEnd() == i) {
                    sb.append("<END> ");
                }
            }
            sb.append(this.sentence.get(i));
            sb.append(' ');
        }
        if (this.sentence.size() > 1) {
            sb.setLength(sb.length() - 1);
        }
        Iterator<Span> it = this.names.iterator();
        while (it.hasNext()) {
            if (it.next().getEnd() == this.sentence.size()) {
                sb.append(' ');
                sb.append(NameSampleDataStream.END_TAG);
            }
        }
        return sb.toString();
    }

    public static NameSample parse(String str, String str2, boolean z) throws IOException {
        String[] strArr = WhitespaceTokenizer.INSTANCE.tokenize(str);
        ArrayList arrayList = new ArrayList(strArr.length);
        ArrayList arrayList2 = new ArrayList();
        int i = -1;
        boolean z2 = false;
        int i2 = 0;
        for (int i4 = 0; i4 < strArr.length; i4++) {
            Matcher matcher = START_TAG_PATTERN.matcher(strArr[i4]);
            if (matcher.matches()) {
                if (z2) {
                    throw new IOException(AbstractC0541b.m772n("Found unexpected annotation while handling a name sequence: ", errorTokenWithContext(strArr, i4)));
                }
                String strGroup = matcher.group(2);
                if (strGroup != null) {
                    if (strGroup.length() == 0) {
                        throw new IOException(AbstractC0541b.m772n("Missing a name type: ", errorTokenWithContext(strArr, i4)));
                    }
                    str2 = strGroup;
                }
                z2 = true;
                i = i2;
            } else if (!strArr[i4].equals(NameSampleDataStream.END_TAG)) {
                arrayList.add(strArr[i4]);
                i2++;
            } else {
                if (!z2) {
                    throw new IOException(AbstractC0541b.m772n("Found unexpected annotation: ", errorTokenWithContext(strArr, i4)));
                }
                arrayList2.add(new Span(i, i2, str2));
                z2 = false;
            }
        }
        return new NameSample((String[]) arrayList.toArray(new String[0]), (Span[]) arrayList2.toArray(new Span[0]), z);
    }

    public NameSample(String[] strArr, Span[] spanArr, String[][] strArr2, boolean z) {
        this(null, strArr, spanArr, strArr2, z);
    }

    public NameSample(String[] strArr, Span[] spanArr, boolean z) {
        this(strArr, spanArr, null, z);
    }
}
