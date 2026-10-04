package opennlp.tools.sentdetect;

import java.util.ArrayList;
import java.util.Iterator;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.util.AbstractEventStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SDEventStream extends AbstractEventStream<SentenceSample> {

    /* JADX INFO: renamed from: cg */
    private final SDContextGenerator f9687cg;
    private final EndOfSentenceScanner scanner;

    public SDEventStream(ObjectStream<SentenceSample> objectStream, SDContextGenerator sDContextGenerator, EndOfSentenceScanner endOfSentenceScanner) {
        super(objectStream);
        this.f9687cg = sDContextGenerator;
        this.scanner = endOfSentenceScanner;
    }

    @Override // opennlp.tools.util.AbstractEventStream
    public Iterator<Event> createEvents(SentenceSample sentenceSample) {
        ArrayList arrayList = new ArrayList();
        for (Span span : sentenceSample.getSentences()) {
            Iterator<Integer> it = this.scanner.getPositions(span.getCoveredText(sentenceSample.getDocument()).toString()).iterator();
            while (it.hasNext()) {
                arrayList.add(new Event(!it.hasNext() ? "s" : "n", this.f9687cg.getContext(sentenceSample.getDocument(), span.getStart() + it.next().intValue())));
            }
        }
        return arrayList.iterator();
    }
}
