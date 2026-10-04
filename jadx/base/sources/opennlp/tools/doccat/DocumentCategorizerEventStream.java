package opennlp.tools.doccat;

import java.util.Iterator;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.util.AbstractEventStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentCategorizerEventStream extends AbstractEventStream<DocumentSample> {
    private final DocumentCategorizerContextGenerator mContextGenerator;

    public DocumentCategorizerEventStream(ObjectStream<DocumentSample> objectStream, FeatureGenerator... featureGeneratorArr) {
        super(objectStream);
        this.mContextGenerator = new DocumentCategorizerContextGenerator(featureGeneratorArr);
    }

    @Override // opennlp.tools.util.AbstractEventStream
    public Iterator<Event> createEvents(final DocumentSample documentSample) {
        return new Iterator<Event>() { // from class: opennlp.tools.doccat.DocumentCategorizerEventStream.1
            private boolean isVirgin = true;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.isVirgin;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            @Override // java.util.Iterator
            public Event next() {
                this.isVirgin = false;
                return new Event(documentSample.getCategory(), DocumentCategorizerEventStream.this.mContextGenerator.getContext(documentSample.getText(), documentSample.getExtraInformation()));
            }
        };
    }

    public DocumentCategorizerEventStream(ObjectStream<DocumentSample> objectStream) {
        super(objectStream);
        this.mContextGenerator = new DocumentCategorizerContextGenerator(new BagOfWordsFeatureGenerator());
    }
}
