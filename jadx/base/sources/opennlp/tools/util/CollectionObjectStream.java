package opennlp.tools.util;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class CollectionObjectStream<E> implements ObjectStream<E> {
    private final Collection<E> collection;
    private Iterator<E> iterator;

    public CollectionObjectStream(Collection<E> collection) {
        this.collection = collection;
        reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public E read() {
        if (this.iterator.hasNext()) {
            return this.iterator.next();
        }
        return null;
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.iterator = this.collection.iterator();
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
    }
}
