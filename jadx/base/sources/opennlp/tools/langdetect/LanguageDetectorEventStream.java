package opennlp.tools.langdetect;

import java.util.Iterator;
import opennlp.tools.p217ml.model.Event;
import opennlp.tools.util.AbstractEventStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorEventStream extends AbstractEventStream<LanguageSample> {
    private final LanguageDetectorContextGenerator mContextGenerator;

    public LanguageDetectorEventStream(ObjectStream<LanguageSample> objectStream, LanguageDetectorContextGenerator languageDetectorContextGenerator) {
        super(objectStream);
        this.mContextGenerator = languageDetectorContextGenerator;
    }

    @Override // opennlp.tools.util.AbstractEventStream
    public Iterator<Event> createEvents(final LanguageSample languageSample) {
        return new Iterator<Event>() { // from class: opennlp.tools.langdetect.LanguageDetectorEventStream.1
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
                return new Event(languageSample.language().getLang(), LanguageDetectorEventStream.this.mContextGenerator.getContext(languageSample.context().toString()));
            }
        };
    }
}
