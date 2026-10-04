package opennlp.tools.formats.convert;

import java.util.Objects;
import opennlp.tools.commons.Internal;
import opennlp.tools.postag.POSSample;
import opennlp.tools.tokenize.Detokenizer;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class POSToTokenSampleStream extends FilterObjectStream<POSSample, TokenSample> {
    private final Detokenizer detokenizer;

    public POSToTokenSampleStream(Detokenizer detokenizer, ObjectStream<POSSample> objectStream) {
        super(objectStream);
        Objects.requireNonNull(detokenizer, "detokenizer must not be null!");
        this.detokenizer = detokenizer;
    }

    @Override // opennlp.tools.util.ObjectStream
    public TokenSample read() {
        POSSample pOSSample = (POSSample) this.samples.read();
        if (pOSSample != null) {
            return new TokenSample(this.detokenizer, pOSSample.getSentence());
        }
        return null;
    }
}
