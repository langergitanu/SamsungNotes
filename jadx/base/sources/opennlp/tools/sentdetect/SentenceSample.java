package opennlp.tools.sentdetect;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import opennlp.tools.commons.Sample;
import opennlp.tools.tokenize.Detokenizer;
import opennlp.tools.util.Span;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SentenceSample implements Sample {
    private static final long serialVersionUID = 1771522768104567531L;
    private final String document;
    private final List<Span> sentences;

    public SentenceSample(CharSequence charSequence, Span... spanArr) {
        this.document = charSequence.toString();
        this.sentences = Collections.unmodifiableList(new ArrayList(Arrays.asList(spanArr)));
        for (Span span : spanArr) {
            if (span.getEnd() > charSequence.length()) {
                throw new IllegalArgumentException(String.format("Sentence span is outside of document text [len %d] and span %s", Integer.valueOf(charSequence.length()), span));
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SentenceSample) {
            SentenceSample sentenceSample = (SentenceSample) obj;
            if (getDocument().equals(sentenceSample.getDocument()) && Arrays.equals(getSentences(), sentenceSample.getSentences())) {
                return true;
            }
        }
        return false;
    }

    public String getDocument() {
        return this.document;
    }

    public Span[] getSentences() {
        return (Span[]) this.sentences.toArray(new Span[0]);
    }

    public int hashCode() {
        return Objects.hash(getDocument(), Integer.valueOf(Arrays.hashCode(getSentences())));
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Span> it = this.sentences.iterator();
        while (it.hasNext()) {
            sb.append(it.next().getCoveredText(this.document).toString().replace(StringUtils.f9761CR, "<CR>").replace("\n", "<LF>"));
            sb.append("\n");
        }
        return sb.toString();
    }

    public SentenceSample(Detokenizer detokenizer, String[][] strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        StringBuilder sb = new StringBuilder();
        for (String[] strArr2 : strArr) {
            String strDetokenize = detokenizer.detokenize(strArr2, null);
            int length = sb.length();
            sb.append(strDetokenize);
            arrayList.add(new Span(length, sb.length()));
        }
        this.document = sb.toString();
        this.sentences = Collections.unmodifiableList(arrayList);
    }
}
