package opennlp.tools.util;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class FilterObjectStream<S, T> implements ObjectStream<T> {
    protected final ObjectStream<S> samples;

    public FilterObjectStream(ObjectStream<S> objectStream) {
        Objects.requireNonNull(objectStream, "samples must not be null!");
        this.samples = objectStream;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.samples.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.samples.reset();
    }
}
