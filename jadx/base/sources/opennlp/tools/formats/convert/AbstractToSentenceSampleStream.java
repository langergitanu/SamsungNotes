package opennlp.tools.formats.convert;

import androidx.appcompat.widget.AbstractC0541b;
import java.util.ArrayList;
import java.util.Objects;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.tokenize.Detokenizer;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractToSentenceSampleStream<T> extends FilterObjectStream<T, SentenceSample> {
    private final int chunkSize;
    private final Detokenizer detokenizer;

    public AbstractToSentenceSampleStream(Detokenizer detokenizer, ObjectStream<T> objectStream, int i) {
        super(objectStream);
        Objects.requireNonNull(detokenizer, "detokenizer must not be null");
        this.detokenizer = detokenizer;
        if (i < 0) {
            throw new IllegalArgumentException(AbstractC0541b.m767i(i, "chunkSize must be zero or larger but was ", "!"));
        }
        if (i > 0) {
            this.chunkSize = i;
        } else {
            this.chunkSize = Integer.MAX_VALUE;
        }
    }

    public abstract String[] toSentence(T t);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // opennlp.tools.util.ObjectStream
    public SentenceSample read() {
        Object obj;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            obj = this.samples.read();
            if (obj == null || i >= this.chunkSize) {
                break;
            }
            arrayList.add(toSentence(obj));
            i++;
        }
        if (arrayList.size() > 0) {
            return new SentenceSample(this.detokenizer, (String[][]) arrayList.toArray(new String[arrayList.size()][]));
        }
        if (obj != null) {
            return read();
        }
        return null;
    }
}
