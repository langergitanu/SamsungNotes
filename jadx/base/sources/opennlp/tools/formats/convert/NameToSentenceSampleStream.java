package opennlp.tools.formats.convert;

import opennlp.tools.commons.Internal;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.tokenize.Detokenizer;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class NameToSentenceSampleStream extends AbstractToSentenceSampleStream<NameSample> {
    public NameToSentenceSampleStream(Detokenizer detokenizer, ObjectStream<NameSample> objectStream, int i) {
        super(detokenizer, objectStream, i);
    }

    @Override // opennlp.tools.formats.convert.AbstractToSentenceSampleStream
    public String[] toSentence(NameSample nameSample) {
        return nameSample.getSentence();
    }
}
