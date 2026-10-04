package opennlp.tools.formats.muc;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MucNameSampleStream extends FilterObjectStream<String, NameSample> {
    private final List<NameSample> storedSamples;
    private final Tokenizer tokenizer;

    public MucNameSampleStream(Tokenizer tokenizer, ObjectStream<String> objectStream) {
        super(objectStream);
        this.storedSamples = new ArrayList();
        this.tokenizer = tokenizer;
    }

    @Override // opennlp.tools.util.ObjectStream
    public NameSample read() throws IOException {
        String str;
        if (this.storedSamples.isEmpty() && (str = (String) this.samples.read()) != null) {
            new SgmlParser().parse(new StringReader(str.replace(">>", ">")), new MucNameContentHandler(this.tokenizer, this.storedSamples));
        }
        if (this.storedSamples.size() > 0) {
            return this.storedSamples.remove(0);
        }
        return null;
    }
}
