package opennlp.tools.formats.masc;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.util.List;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascNamedEntitySampleStream extends FilterObjectStream<MascDocument, NameSample> {
    private MascDocument buffer;

    public MascNamedEntitySampleStream(ObjectStream<MascDocument> objectStream) throws IOException {
        MascDocument mascDocument;
        super(objectStream);
        do {
            try {
                mascDocument = objectStream.read();
                this.buffer = mascDocument;
            } catch (Exception e) {
                throw new IOException(AbstractC0541b.m772n("None of the documents has named entity labels", e.getMessage()));
            }
        } while (!mascDocument.hasNamedEntities());
    }

    @Override // opennlp.tools.util.FilterObjectStream, opennlp.tools.util.ObjectStream
    public void reset() {
        this.samples.reset();
        this.buffer = (MascDocument) this.samples.read();
    }

    @Override // opennlp.tools.util.ObjectStream
    public NameSample read() throws IOException {
        try {
            MascSentence mascSentence = this.buffer.read();
            while (mascSentence == null) {
                MascDocument mascDocument = (MascDocument) this.samples.read();
                this.buffer = mascDocument;
                if (mascDocument == null) {
                    return null;
                }
                if (mascDocument.hasNamedEntities()) {
                    mascSentence = this.buffer.read();
                }
            }
            List<String> tokenStrings = mascSentence.getTokenStrings();
            String[] strArr = new String[tokenStrings.size()];
            tokenStrings.toArray(strArr);
            List<Span> namedEntities = mascSentence.getNamedEntities();
            Span[] spanArr = new Span[namedEntities.size()];
            namedEntities.toArray(spanArr);
            return new NameSample(strArr, spanArr, true);
        } catch (IOException unused) {
            throw new IOException("Could not get a sample of named entities from the data.");
        }
    }
}
