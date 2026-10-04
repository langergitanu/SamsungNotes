package opennlp.tools.formats.masc;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import opennlp.tools.postag.POSSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascPOSSampleStream extends FilterObjectStream<MascDocument, POSSample> {
    private MascDocument buffer;

    public MascPOSSampleStream(ObjectStream<MascDocument> objectStream) throws IOException {
        MascDocument mascDocument;
        super(objectStream);
        do {
            try {
                mascDocument = objectStream.read();
                this.buffer = mascDocument;
            } catch (Exception e) {
                throw new IOException(AbstractC0541b.m772n("None of the documents has POS tags", e.getMessage()));
            }
        } while (!mascDocument.hasPennTags());
    }

    @Override // opennlp.tools.util.FilterObjectStream, opennlp.tools.util.ObjectStream
    public void reset() {
        this.samples.reset();
        this.buffer = (MascDocument) this.samples.read();
    }

    @Override // opennlp.tools.util.ObjectStream
    public POSSample read() throws IOException {
        try {
            MascSentence mascSentence = this.buffer.read();
            while (mascSentence == null) {
                MascDocument mascDocument = (MascDocument) this.samples.read();
                this.buffer = mascDocument;
                if (mascDocument == null) {
                    return null;
                }
                if (mascDocument.hasPennTags()) {
                    mascSentence = this.buffer.read();
                }
            }
            return new POSSample(mascSentence.getTokenStrings(), mascSentence.getTags());
        } catch (IOException unused) {
            throw new IOException("Could not get a sample of POS tags from the data.");
        }
    }
}
