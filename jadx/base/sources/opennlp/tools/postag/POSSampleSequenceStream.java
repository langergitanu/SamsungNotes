package opennlp.tools.postag;

import java.util.Map;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.p217ml.model.Sequence;
import opennlp.tools.p217ml.model.SequenceStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class POSSampleSequenceStream implements SequenceStream<POSSample> {
    private final POSContextGenerator pcg;
    private final ObjectStream<POSSample> psi;

    public POSSampleSequenceStream(ObjectStream<POSSample> objectStream) {
        this(objectStream, new DefaultPOSContextGenerator(null));
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.psi.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.psi.reset();
    }

    @Override // opennlp.tools.p217ml.model.SequenceStream
    public Event[] updateContext(Sequence<POSSample> sequence, AbstractModel abstractModel) {
        POSTaggerME pOSTaggerME = new POSTaggerME(new POSModel("x-unspecified", abstractModel, (Map<String, String>) null, new POSTaggerFactory()));
        String[] sentence = sequence.getSource().getSentence();
        String[][] additionalContext = sequence.getSource().getAdditionalContext();
        String[] strArrTag = pOSTaggerME.tag(sequence.getSource().getSentence());
        Event[] eventArr = new Event[sentence.length];
        POSSampleEventStream.generateEvents(sentence, strArrTag, additionalContext, this.pcg).toArray(eventArr);
        return eventArr;
    }

    public POSSampleSequenceStream(ObjectStream<POSSample> objectStream, POSContextGenerator pOSContextGenerator) {
        this.psi = objectStream;
        this.pcg = pOSContextGenerator;
    }

    @Override // opennlp.tools.util.ObjectStream
    public Sequence<POSSample> read() {
        POSSample pOSSample = this.psi.read();
        if (pOSSample == null) {
            return null;
        }
        String[] sentence = pOSSample.getSentence();
        String[] tags = pOSSample.getTags();
        Event[] eventArr = new Event[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            eventArr[i] = new Event(tags[i], this.pcg.getContext(i, sentence, tags, (Object[]) null));
        }
        return new Sequence<>(eventArr, pOSSample);
    }
}
