package opennlp.tools.namefind;

import java.util.Collections;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.p217ml.model.Sequence;
import opennlp.tools.p217ml.model.SequenceStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.SequenceCodec;
import opennlp.tools.util.featuregen.AdaptiveFeatureGenerator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NameSampleSequenceStream implements SequenceStream<NameSample> {
    private final NameContextGenerator pcg;
    private final ObjectStream<NameSample> psi;
    private final SequenceCodec<String> seqCodec;
    private final boolean useOutcomes;

    public NameSampleSequenceStream(ObjectStream<NameSample> objectStream) {
        this(objectStream, (NameContextGenerator) new DefaultNameContextGenerator(null), true);
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
    public Event[] updateContext(Sequence<NameSample> sequence, AbstractModel abstractModel) {
        NameFinderME nameFinderME = new NameFinderME(new TokenNameFinderModel("x-unspecified", abstractModel, Collections.EMPTY_MAP, null));
        String[] sentence = sequence.getSource().getSentence();
        String[] strArrEncode = this.seqCodec.encode(nameFinderME.find(sentence), sentence.length);
        Event[] eventArr = new Event[sentence.length];
        NameFinderEventStream.generateEvents(sentence, strArrEncode, this.pcg).toArray(eventArr);
        return eventArr;
    }

    public NameSampleSequenceStream(ObjectStream<NameSample> objectStream, AdaptiveFeatureGenerator adaptiveFeatureGenerator) {
        this(objectStream, (NameContextGenerator) new DefaultNameContextGenerator(adaptiveFeatureGenerator), true);
    }

    @Override // opennlp.tools.util.ObjectStream
    public Sequence<NameSample> read() {
        NameSample nameSample = this.psi.read();
        if (nameSample == null) {
            return null;
        }
        String[] sentence = nameSample.getSentence();
        String[] strArrEncode = this.seqCodec.encode(nameSample.getNames(), sentence.length);
        Event[] eventArr = new Event[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            eventArr[i] = new Event(strArrEncode[i], this.useOutcomes ? this.pcg.getContext(i, sentence, strArrEncode, null) : this.pcg.getContext(i, sentence, null, null));
        }
        return new Sequence<>(eventArr, nameSample);
    }

    public NameSampleSequenceStream(ObjectStream<NameSample> objectStream, AdaptiveFeatureGenerator adaptiveFeatureGenerator, boolean z) {
        this(objectStream, new DefaultNameContextGenerator(adaptiveFeatureGenerator), z);
    }

    public NameSampleSequenceStream(ObjectStream<NameSample> objectStream, NameContextGenerator nameContextGenerator) {
        this(objectStream, nameContextGenerator, true);
    }

    public NameSampleSequenceStream(ObjectStream<NameSample> objectStream, NameContextGenerator nameContextGenerator, boolean z) {
        this(objectStream, nameContextGenerator, z, new BioCodec());
    }

    public NameSampleSequenceStream(ObjectStream<NameSample> objectStream, NameContextGenerator nameContextGenerator, boolean z, SequenceCodec<String> sequenceCodec) {
        this.psi = objectStream;
        this.useOutcomes = z;
        this.pcg = nameContextGenerator;
        this.seqCodec = sequenceCodec;
    }
}
