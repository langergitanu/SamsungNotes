package opennlp.tools.tokenize;

import java.util.Objects;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenSampleStream extends FilterObjectStream<String, TokenSample> {
    private final String separatorChars;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TokenSampleStream(ObjectStream<String> objectStream, String str) {
        super(objectStream);
        Objects.requireNonNull(objectStream, "sampleStrings must not be null");
        Objects.requireNonNull(str, "separatorChars must not be null");
        this.separatorChars = str;
    }

    @Override // opennlp.tools.util.ObjectStream
    public TokenSample read() {
        String str = (String) this.samples.read();
        if (str != null) {
            return TokenSample.parse(str, this.separatorChars);
        }
        return null;
    }

    public TokenSampleStream(ObjectStream<String> objectStream) {
        this(objectStream, TokenSample.DEFAULT_SEPARATOR_CHARS);
    }
}
