package opennlp.tools.formats.brat;

import java.util.List;
import java.util.Set;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.sentdetect.SentenceDetector;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class BratNameSampleStream extends SegmenterObjectStream<BratDocument, NameSample> {
    private final BratDocumentParser parser;

    public BratNameSampleStream(SentenceDetector sentenceDetector, Tokenizer tokenizer, ObjectStream<BratDocument> objectStream) {
        super(objectStream);
        this.parser = new BratDocumentParser(sentenceDetector, tokenizer, null);
    }

    @Override // opennlp.tools.formats.brat.SegmenterObjectStream
    public List<NameSample> read(BratDocument bratDocument) {
        return this.parser.parse(bratDocument);
    }

    public BratNameSampleStream(SentenceModel sentenceModel, TokenizerModel tokenizerModel, ObjectStream<BratDocument> objectStream) {
        super(objectStream);
        this.parser = new BratDocumentParser(new SentenceDetectorME(sentenceModel), new TokenizerME(tokenizerModel), null);
    }

    public BratNameSampleStream(SentenceDetector sentenceDetector, Tokenizer tokenizer, ObjectStream<BratDocument> objectStream, Set<String> set) {
        super(objectStream);
        this.parser = new BratDocumentParser(sentenceDetector, tokenizer, set);
    }

    public BratNameSampleStream(SentenceModel sentenceModel, TokenizerModel tokenizerModel, ObjectStream<BratDocument> objectStream, Set<String> set) {
        super(objectStream);
        this.parser = new BratDocumentParser(new SentenceDetectorME(sentenceModel), new TokenizerME(tokenizerModel), set);
    }
}
