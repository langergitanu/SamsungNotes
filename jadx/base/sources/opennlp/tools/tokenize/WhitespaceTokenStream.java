package opennlp.tools.tokenize;

import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class WhitespaceTokenStream extends FilterObjectStream<TokenSample, String> {
    public WhitespaceTokenStream(ObjectStream<TokenSample> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public String read() {
        TokenSample tokenSample = (TokenSample) this.samples.read();
        if (tokenSample == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Span span : tokenSample.getTokenSpans()) {
            sb.append(span.getCoveredText(tokenSample.getText()));
            sb.append(' ');
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}
