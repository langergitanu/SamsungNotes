package opennlp.tools.formats.brat;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class SegmenterObjectStream<S, T> extends FilterObjectStream<S, T> {
    private Iterator<T> sampleIt;

    public SegmenterObjectStream(ObjectStream<S> objectStream) {
        super(objectStream);
        this.sampleIt = Collections.emptyIterator();
    }

    @Override // opennlp.tools.util.ObjectStream
    public final T read() {
        if (this.sampleIt.hasNext()) {
            return this.sampleIt.next();
        }
        S s = this.samples.read();
        if (s == null) {
            return null;
        }
        List<T> list = read(s);
        if (list != null) {
            this.sampleIt = list.iterator();
        }
        return read();
    }

    public abstract List<T> read(S s);
}
