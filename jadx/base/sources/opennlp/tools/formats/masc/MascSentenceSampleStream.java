package opennlp.tools.formats.masc;

import java.io.IOException;
import java.util.ArrayList;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascSentenceSampleStream extends FilterObjectStream<MascDocument, SentenceSample> {
    private MascDocument buffer;
    private final int sentencesPerSample;

    public MascSentenceSampleStream(ObjectStream<MascDocument> objectStream, int i) {
        super(objectStream);
        this.sentencesPerSample = i;
        this.buffer = objectStream.read();
    }

    @Override // opennlp.tools.util.FilterObjectStream, opennlp.tools.util.ObjectStream
    public void reset() {
        this.samples.reset();
        this.buffer = (MascDocument) this.samples.read();
    }

    @Override // opennlp.tools.util.ObjectStream
    public SentenceSample read() throws IOException {
        try {
            StringBuilder sb = new StringBuilder();
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < this.sentencesPerSample) {
                MascSentence mascSentence = this.buffer.read();
                if (mascSentence == null) {
                    MascDocument mascDocument = (MascDocument) this.samples.read();
                    this.buffer = mascDocument;
                    if (mascDocument == null) {
                        break;
                    }
                    sb.append('\n');
                    i--;
                } else {
                    int length = sb.length();
                    sb.append(mascSentence.getSentDetectText());
                    sb.append(' ');
                    arrayList.add(new Span(length, sb.length() - 1));
                }
                i++;
            }
            if (sb.length() <= 0) {
                return null;
            }
            sb.setLength(sb.length() - 1);
            return new SentenceSample(sb, (Span[]) arrayList.toArray(new Span[0]));
        } catch (IOException unused) {
            throw new IOException("You are reading an empty document stream. Did you close it?");
        }
    }
}
