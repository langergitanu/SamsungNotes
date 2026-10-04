package opennlp.tools.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface ObjectStream<T> extends AutoCloseable {
    T read();

    default void reset() {
        throw new UnsupportedOperationException("reset is not supported on this stream");
    }

    @Override // java.lang.AutoCloseable
    default void close() {
    }
}
