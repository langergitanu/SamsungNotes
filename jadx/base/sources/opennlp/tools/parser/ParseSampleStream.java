package opennlp.tools.parser;

import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParseSampleStream extends FilterObjectStream<String, Parse> {
    public ParseSampleStream(ObjectStream<String> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public Parse read() {
        String str = (String) this.samples.read();
        if (str != null) {
            return !str.trim().isEmpty() ? Parse.parseParse(str) : read();
        }
        return null;
    }
}
