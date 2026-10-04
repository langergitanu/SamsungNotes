package opennlp.tools.util;

import java.io.IOException;
import java.io.Writer;
import opennlp.tools.p217ml.model.Event;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EventTraceStream extends FilterObjectStream<Event, Event> {
    private final Writer writer;

    public EventTraceStream(ObjectStream<Event> objectStream, Writer writer) {
        super(objectStream);
        this.writer = writer;
    }

    @Override // opennlp.tools.util.ObjectStream
    public Event read() throws IOException {
        Event event = (Event) this.samples.read();
        if (event != null) {
            this.writer.write(event.toString());
            this.writer.write("\n");
        }
        return event;
    }
}
