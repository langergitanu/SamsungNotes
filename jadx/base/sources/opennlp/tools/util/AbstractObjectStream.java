package opennlp.tools.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractObjectStream<T> implements ObjectStream<T> {
    private final ObjectStream<T> stream;

    public AbstractObjectStream(ObjectStream<T> objectStream) {
        this.stream = objectStream;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.stream.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public T read() {
        return this.stream.read();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.stream.reset();
    }
}
