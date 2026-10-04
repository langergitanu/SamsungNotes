package opennlp.tools.formats.convert;

import opennlp.tools.commons.Internal;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.tokenize.Detokenizer;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class NameToTokenSampleStream extends FilterObjectStream<NameSample, TokenSample> {
    private final Detokenizer detokenizer;

    public NameToTokenSampleStream(Detokenizer detokenizer, ObjectStream<NameSample> objectStream) {
        super(objectStream);
        this.detokenizer = detokenizer;
    }

    @Override // opennlp.tools.util.ObjectStream
    public TokenSample read() {
        NameSample nameSample = (NameSample) this.samples.read();
        if (nameSample != null) {
            return new TokenSample(this.detokenizer, nameSample.getSentence());
        }
        return null;
    }
}
