package opennlp.tools.formats.conllu;

import java.util.ArrayList;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ConlluSentenceSampleStream extends FilterObjectStream<ConlluSentence, SentenceSample> {
    private final int sentencesPerSample;

    public ConlluSentenceSampleStream(ObjectStream<ConlluSentence> objectStream, int i) {
        super(objectStream);
        this.sentencesPerSample = i;
    }

    @Override // opennlp.tools.util.ObjectStream
    public SentenceSample read() {
        ConlluSentence conlluSentence;
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.sentencesPerSample && (conlluSentence = (ConlluSentence) this.samples.read()) != null; i++) {
            int length = sb.length();
            sb.append(conlluSentence.getTextComment());
            sb.append(' ');
            arrayList.add(new Span(length, sb.length() - 1));
        }
        if (sb.length() <= 0) {
            return null;
        }
        sb.setLength(sb.length() - 1);
        return new SentenceSample(sb, (Span[]) arrayList.toArray(new Span[0]));
    }
}
