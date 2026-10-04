package opennlp.tools.lemmatizer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.util.AbstractEventStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmaSampleEventStream extends AbstractEventStream<LemmaSample> {
    private final LemmatizerContextGenerator contextGenerator;

    public LemmaSampleEventStream(ObjectStream<LemmaSample> objectStream, LemmatizerContextGenerator lemmatizerContextGenerator) {
        super(objectStream);
        this.contextGenerator = lemmatizerContextGenerator;
    }

    @Override // opennlp.tools.util.AbstractEventStream
    public Iterator<Event> createEvents(LemmaSample lemmaSample) {
        if (lemmaSample == null) {
            return Collections.emptyListIterator();
        }
        ArrayList arrayList = new ArrayList();
        String[] tokens = lemmaSample.getTokens();
        String[] tags = lemmaSample.getTags();
        String[] strArrEncodeLemmas = LemmatizerME.encodeLemmas(tokens, lemmaSample.getLemmas());
        int length = lemmaSample.getTokens().length;
        for (int i = 0; i < length; i++) {
            arrayList.add(new Event(strArrEncodeLemmas[i], this.contextGenerator.getContext(i, tokens, tags, strArrEncodeLemmas)));
        }
        return arrayList.iterator();
    }
}
