package opennlp.tools.chunker;

import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.p217ml.model.Sequence;
import opennlp.tools.p217ml.model.SequenceStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkSampleSequenceStream implements SequenceStream<ChunkSample> {
    private final ChunkerContextGenerator contextGenerator;
    private final ObjectStream<ChunkSample> samples;

    public ChunkSampleSequenceStream(ObjectStream<ChunkSample> objectStream, ChunkerContextGenerator chunkerContextGenerator) {
        this.samples = objectStream;
        this.contextGenerator = chunkerContextGenerator;
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
    public Event[] updateContext(Sequence<ChunkSample> sequence, AbstractModel abstractModel) {
        return null;
    }

    @Override // opennlp.tools.util.ObjectStream
    public Sequence<ChunkSample> read() {
        ChunkSample chunkSample = this.samples.read();
        if (chunkSample == null) {
            return null;
        }
        String[] sentence = chunkSample.getSentence();
        String[] tags = chunkSample.getTags();
        Event[] eventArr = new Event[sentence.length];
        for (int i = 0; i < sentence.length; i++) {
            eventArr[i] = new Event(tags[i], this.contextGenerator.getContext(i, sentence, tags, (String[]) null));
        }
        return new Sequence<>(eventArr, chunkSample);
    }
}
