package opennlp.tools.formats.letsmt;

import java.util.Iterator;
import java.util.LinkedList;
import opennlp.tools.formats.letsmt.LetsmtDocument;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class LetsmtSentenceStream implements ObjectStream<SentenceSample> {
    private Iterator<LetsmtDocument.LetsmtSentence> sentenceIt;
    private final LetsmtDocument source;

    public LetsmtSentenceStream(LetsmtDocument letsmtDocument) {
        this.source = letsmtDocument;
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
        for (int i = 0; this.sentenceIt.hasNext() && i < 25; i++) {
            LetsmtDocument.LetsmtSentence next = this.sentenceIt.next();
            int length = sb.length();
            if (next.getTokens() != null) {
                sb.append(String.join(" ", next.getTokens()));
            } else if (next.getNonTokenizedText() != null) {
                sb.append(next.getNonTokenizedText());
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
