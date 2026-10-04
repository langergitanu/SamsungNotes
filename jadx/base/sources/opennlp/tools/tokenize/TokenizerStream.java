package opennlp.tools.tokenize;

import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenizerStream implements ObjectStream<TokenSample> {
    private final ObjectStream<String> input;
    private final Tokenizer tokenizer;

    public TokenizerStream(Tokenizer tokenizer, ObjectStream<String> objectStream) {
        this.tokenizer = tokenizer;
        this.input = objectStream;
    }

    @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
    public void close() {
        this.input.close();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.input.reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public TokenSample read() {
        String str = this.input.read();
        if (str != null) {
            return new TokenSample(str, this.tokenizer.tokenizePos(str));
        }
        return null;
    }
}
