package opennlp.tools.formats.letsmt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.tokenize.Detokenizer;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DetokenizeSentenceSampleStream extends FilterObjectStream<SentenceSample, SentenceSample> {
    private final Detokenizer detokenizer;

    public DetokenizeSentenceSampleStream(Detokenizer detokenizer, ObjectStream<SentenceSample> objectStream) {
        super(objectStream);
        Objects.requireNonNull(detokenizer);
        this.detokenizer = detokenizer;
    }

    @Override // opennlp.tools.util.ObjectStream
    public SentenceSample read() {
        SentenceSample sentenceSample = (SentenceSample) this.samples.read();
        if (sentenceSample == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Span span : sentenceSample.getSentences()) {
            arrayList.add(sentenceSample.getDocument().substring(span.getStart(), span.getEnd()));
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String[] strArr = WhitespaceTokenizer.INSTANCE.tokenize((String) it.next());
            int length = sb.length();
            sb.append(this.detokenizer.detokenize(strArr, null));
            arrayList2.add(new Span(length, sb.length()));
            sb.append(' ');
        }
        return new SentenceSample(sb, (Span[]) arrayList2.toArray(new Span[0]));
    }
}
