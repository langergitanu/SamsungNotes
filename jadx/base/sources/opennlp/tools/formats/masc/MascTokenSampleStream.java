package opennlp.tools.formats.masc;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.util.List;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MascTokenSampleStream extends FilterObjectStream<MascDocument, TokenSample> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) MascTokenSampleStream.class);
    private MascDocument buffer;

    public MascTokenSampleStream(ObjectStream<MascDocument> objectStream) throws IOException {
        MascDocument mascDocument;
        super(objectStream);
        do {
            try {
                mascDocument = objectStream.read();
                this.buffer = mascDocument;
            } catch (Exception e) {
                throw new IOException(AbstractC0541b.m772n("None of the documents has Penn tokenization", e.getMessage()));
            }
        } while (!mascDocument.hasPennTags());
    }

    @Override // opennlp.tools.util.FilterObjectStream, opennlp.tools.util.ObjectStream
    public void reset() {
        this.samples.reset();
        this.buffer = (MascDocument) this.samples.read();
    }

    @Override // opennlp.tools.util.ObjectStream
    public TokenSample read() throws IOException {
        String tokenText;
        List<Span> tokensSpans;
        boolean z = true;
        do {
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
                tokenText = mascSentence.getTokenText();
                tokensSpans = mascSentence.getTokensSpans();
                if (tokenText.length() == 0) {
                    logger.warn("Zero sentence found. There is a sentence without any tokens. sentence: {}, spans: {}", tokenText, tokensSpans);
                    z = false;
                }
                for (int i = 0; i < tokensSpans.size(); i++) {
                    Span span = tokensSpans.get(i);
                    if (span.getEnd() - span.getStart() == 0) {
                        logger.warn("Zero token found. There is a token without any quarks. sentence: {}, spans: {}", tokenText, tokensSpans);
                        z = false;
                    }
                }
            } catch (IOException unused) {
                throw new IOException("Could not get a sample of tokens from the data.");
            }
        } while (!z);
        Span[] spanArr = new Span[tokensSpans.size()];
        tokensSpans.toArray(spanArr);
        return new TokenSample(tokenText, spanArr);
    }
}
