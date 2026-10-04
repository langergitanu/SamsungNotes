package opennlp.tools.formats.irishsentencebank;

import java.util.Iterator;
import java.util.LinkedList;
import opennlp.tools.formats.irishsentencebank.IrishSentenceBankDocument;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class IrishSentenceBankSentenceStream implements ObjectStream<SentenceSample> {
    private Iterator<IrishSentenceBankDocument.IrishSentenceBankSentence> sentenceIt;
    private final IrishSentenceBankDocument source;

    public IrishSentenceBankSentenceStream(IrishSentenceBankDocument irishSentenceBankDocument) {
        this.source = irishSentenceBankDocument;
        reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.sentenceIt = this.source.getSentences().iterator();
    }

    @Override // opennlp.tools.util.ObjectStream
    public SentenceSample read() {
        StringBuilder sb = new StringBuilder();
        LinkedList linkedList = new LinkedList();
        while (this.sentenceIt.hasNext()) {
            IrishSentenceBankDocument.IrishSentenceBankSentence next = this.sentenceIt.next();
            int length = sb.length();
            if (next.getOriginal() != null) {
                sb.append(next.getOriginal());
            }
            linkedList.add(new Span(length, sb.length()));
            sb.append(' ');
        }
        if (linkedList.size() == 0) {
            return null;
        }
        return new SentenceSample(sb.toString(), (Span[]) linkedList.toArray(new Span[0]));
    }
}
