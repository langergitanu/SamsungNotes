package opennlp.tools.util;

import java.util.Collections;
import java.util.Iterator;
import opennlp.tools.p217ml.model.Event;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractEventStream<T> implements ObjectStream<Event> {
    private Iterator<Event> events = Collections.emptyIterator();
    private final ObjectStream<T> samples;

    public AbstractEventStream(ObjectStream<T> objectStream) {
        this.samples = objectStream;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.samples.close();
    }

    public abstract Iterator<Event> createEvents(T t);

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.events = Collections.emptyIterator();
        this.samples.reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public final Event read() {
        T t;
        if (this.events.hasNext()) {
            return this.events.next();
        }
        while (!this.events.hasNext() && (t = this.samples.read()) != null) {
            this.events = createEvents(t);
        }
        if (this.events.hasNext()) {
            return read();
        }
        return null;
    }
}
