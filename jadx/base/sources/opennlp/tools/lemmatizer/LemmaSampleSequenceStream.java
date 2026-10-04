package opennlp.tools.lemmatizer;

import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.p217ml.model.Sequence;
import opennlp.tools.p217ml.model.SequenceStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmaSampleSequenceStream implements SequenceStream<LemmaSample> {
    private final LemmatizerContextGenerator contextGenerator;
    private final ObjectStream<LemmaSample> samples;

    public LemmaSampleSequenceStream(ObjectStream<LemmaSample> objectStream, LemmatizerContextGenerator lemmatizerContextGenerator) {
        this.samples = objectStream;
        this.contextGenerator = lemmatizerContextGenerator;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.samples.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.samples.reset();
    }

    @Override // opennlp.tools.p217ml.model.SequenceStream
    public Event[] updateContext(Sequence<LemmaSample> sequence, AbstractModel abstractModel) {
        return null;
    }

    @Override // opennlp.tools.util.ObjectStream
    public Sequence<LemmaSample> read() {
        LemmaSample lemmaSample = this.samples.read();
        if (lemmaSample == null) {
            return null;
        }
        String[] tokens = lemmaSample.getTokens();
        String[] tags = lemmaSample.getTags();
        String[] lemmas = lemmaSample.getLemmas();
        Event[] eventArr = new Event[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            eventArr[i] = new Event(tags[i], this.contextGenerator.getContext(i, tokens, tags, lemmas));
        }
        return new Sequence<>(eventArr, lemmaSample);
    }
}
