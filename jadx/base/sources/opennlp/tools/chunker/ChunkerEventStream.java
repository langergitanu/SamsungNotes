package opennlp.tools.chunker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.util.AbstractEventStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkerEventStream extends AbstractEventStream<ChunkSample> {

    /* JADX INFO: renamed from: cg */
    private final ChunkerContextGenerator f9651cg;

    public ChunkerEventStream(ObjectStream<ChunkSample> objectStream, ChunkerContextGenerator chunkerContextGenerator) {
        super(objectStream);
        this.f9651cg = chunkerContextGenerator;
    }

    @Override // opennlp.tools.util.AbstractEventStream
    public Iterator<Event> createEvents(ChunkSample chunkSample) {
        if (chunkSample == null) {
            return Collections.emptyListIterator();
        }
        ArrayList arrayList = new ArrayList();
        String[] sentence = chunkSample.getSentence();
        String[] tags = chunkSample.getTags();
        String[] preds = chunkSample.getPreds();
        int length = chunkSample.getSentence().length;
        for (int i = 0; i < length; i++) {
            arrayList.add(new Event(preds[i], this.f9651cg.getContext(i, sentence, tags, preds)));
        }
        return arrayList.iterator();
    }
}
