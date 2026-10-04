package opennlp.tools.p217ml.maxent;

import opennlp.tools.p217ml.model.Event;
import opennlp.tools.p217ml.model.RealValueFileEventStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class RealBasicEventStream implements ObjectStream<Event> {

    /* JADX INFO: renamed from: ds */
    private final ObjectStream<String> f9669ds;

    public RealBasicEventStream(ObjectStream<String> objectStream) {
        this.f9669ds = objectStream;
    }

    private Event createEvent(String str) {
        int iIndexOf = str.indexOf(32);
        if (iIndexOf == -1) {
            return null;
        }
        String strSubstring = str.substring(0, iIndexOf);
        String[] strArrSplit = str.substring(iIndexOf + 1).split("\\s+");
        return new Event(strSubstring, strArrSplit, RealValueFileEventStream.parseContexts(strArrSplit));
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.f9669ds.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.f9669ds.reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public Event read() {
        String str = this.f9669ds.read();
        if (str != null) {
            return createEvent(str);
        }
        return null;
    }
}
