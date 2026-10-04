package opennlp.tools.p217ml.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SequenceStreamEventStream implements ObjectStream<Event> {
    private Iterator<Event> eventIt = Collections.emptyListIterator();
    private final SequenceStream<Event> sequenceStream;

    public SequenceStreamEventStream(SequenceStream<Event> sequenceStream) {
        this.sequenceStream = sequenceStream;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.eventIt = Collections.emptyListIterator();
        this.sequenceStream.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.eventIt = Collections.emptyListIterator();
        this.sequenceStream.reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public Event read() {
        while (!this.eventIt.hasNext()) {
            Sequence sequence = this.sequenceStream.read();
            if (sequence == null) {
                return null;
            }
            this.eventIt = Arrays.asList(sequence.getEvents()).iterator();
        }
        return this.eventIt.next();
    }
}
