package opennlp.tools.util;

import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ObjectStreamUtils {
    public static <T> ObjectStream<T> concatenateObjectStream(Collection<ObjectStream<T>> collection) {
        Iterator<ObjectStream<T>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("stream cannot be null");
            }
        }
        return new ObjectStream<T>(collection) { // from class: opennlp.tools.util.ObjectStreamUtils.3
            private ObjectStream<T> currentStream;
            private Iterator<ObjectStream<T>> iterator;
            final /* synthetic */ Collection val$streams;

            {
                this.val$streams = collection;
                Iterator<ObjectStream<T>> it2 = collection.iterator();
                this.iterator = it2;
                this.currentStream = it2.next();
            }

            @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
            public void close() {
                Iterator it2 = this.val$streams.iterator();
                while (it2.hasNext()) {
                    ((ObjectStream) it2.next()).close();
                }
            }

            @Override // opennlp.tools.util.ObjectStream
            public T read() {
                T t = null;
                while (true) {
                    ObjectStream<T> objectStream = this.currentStream;
                    if (objectStream == null || t != null) {
                        break;
                    }
                    t = objectStream.read();
                    if (t == null) {
                        this.currentStream = this.iterator.hasNext() ? this.iterator.next() : null;
                    }
                }
                return t;
            }

            @Override // opennlp.tools.util.ObjectStream
            public void reset() {
                Iterator it2 = this.val$streams.iterator();
                while (it2.hasNext()) {
                    ((ObjectStream) it2.next()).reset();
                }
                this.iterator = this.val$streams.iterator();
            }
        };
    }

    @SafeVarargs
    public static <T> ObjectStream<T> createObjectStream(final T... tArr) {
        return new ObjectStream<T>() { // from class: opennlp.tools.util.ObjectStreamUtils.1
            private int index = 0;

            @Override // opennlp.tools.util.ObjectStream
            public T read() {
                int i = this.index;
                Object[] objArr = tArr;
                if (i >= objArr.length) {
                    return null;
                }
                this.index = i + 1;
                return (T) objArr[i];
            }

            @Override // opennlp.tools.util.ObjectStream
            public void reset() {
                this.index = 0;
            }

            @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    public static <T> ObjectStream<T> createObjectStream(Collection<T> collection) {
        return new ObjectStream<T>(collection) { // from class: opennlp.tools.util.ObjectStreamUtils.2
            private Iterator<T> iterator;
            final /* synthetic */ Collection val$collection;

            {
                this.val$collection = collection;
                this.iterator = collection.iterator();
            }

            @Override // opennlp.tools.util.ObjectStream
            public T read() {
                if (this.iterator.hasNext()) {
                    return this.iterator.next();
                }
                return null;
            }

            @Override // opennlp.tools.util.ObjectStream
            public void reset() {
                this.iterator = this.val$collection.iterator();
            }

            @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
            public void close() {
            }
        };
    }

    @SafeVarargs
    public static <T> ObjectStream<T> concatenateObjectStream(final ObjectStream<T>... objectStreamArr) {
        for (ObjectStream<T> objectStream : objectStreamArr) {
            if (objectStream == null) {
                throw new NullPointerException("stream cannot be null");
            }
        }
        return new ObjectStream<T>() { // from class: opennlp.tools.util.ObjectStreamUtils.4
            private int streamIndex = 0;

            @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
            public void close() {
                for (ObjectStream objectStream2 : objectStreamArr) {
                    objectStream2.close();
                }
            }

            @Override // opennlp.tools.util.ObjectStream
            public T read() {
                T t = null;
                while (true) {
                    int i = this.streamIndex;
                    ObjectStream[] objectStreamArr2 = objectStreamArr;
                    if (i >= objectStreamArr2.length || t != null) {
                        break;
                    }
                    t = (T) objectStreamArr2[i].read();
                    if (t == null) {
                        this.streamIndex++;
                    }
                }
                return t;
            }

            @Override // opennlp.tools.util.ObjectStream
            public void reset() {
                this.streamIndex = 0;
                for (ObjectStream objectStream2 : objectStreamArr) {
                    objectStream2.reset();
                }
            }
        };
    }
}
