package opennlp.tools.formats.leipzig;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class SampleShuffleStream<T> implements ObjectStream<T> {
    private final List<T> bufferedSamples = new ArrayList();
    private Iterator<T> sampleIt;

    public SampleShuffleStream(ObjectStream<T> objectStream) {
        while (true) {
            T t = objectStream.read();
            if (t == null) {
                Collections.shuffle(this.bufferedSamples, new Random(23L));
                reset();
                return;
            }
            this.bufferedSamples.add(t);
        }
    }

    @Override // opennlp.tools.util.ObjectStream
    public T read() {
        if (this.sampleIt.hasNext()) {
            return this.sampleIt.next();
        }
        return null;
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.sampleIt = this.bufferedSamples.iterator();
    }
}
