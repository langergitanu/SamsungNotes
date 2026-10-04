package opennlp.tools.formats.irishsentencebank;

import java.util.Iterator;
import opennlp.tools.commons.Internal;
import opennlp.tools.formats.irishsentencebank.IrishSentenceBankDocument;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
class IrishSentenceBankTokenSampleStream implements ObjectStream<TokenSample> {
    private Iterator<IrishSentenceBankDocument.IrishSentenceBankSentence> sentenceIt;
    private final IrishSentenceBankDocument source;

    public IrishSentenceBankTokenSampleStream(IrishSentenceBankDocument irishSentenceBankDocument) {
        this.source = irishSentenceBankDocument;
        reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.sentenceIt = this.source.getSentences().iterator();
    }

    @Override // opennlp.tools.util.ObjectStream
    public TokenSample read() {
        if (this.sentenceIt.hasNext()) {
            return this.sentenceIt.next().getTokenSample();
        }
        return null;
    }
}
