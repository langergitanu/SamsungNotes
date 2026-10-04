package opennlp.tools.parser;

import opennlp.tools.postag.POSSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PosSampleStream extends FilterObjectStream<Parse, POSSample> {
    public PosSampleStream(ObjectStream<Parse> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public POSSample read() {
        Parse parse = (Parse) this.samples.read();
        if (parse == null) {
            return null;
        }
        Parse[] tagNodes = parse.getTagNodes();
        String[] strArr = new String[tagNodes.length];
        String[] strArr2 = new String[tagNodes.length];
        for (int i = 0; i < tagNodes.length; i++) {
            Parse parse2 = tagNodes[i];
            strArr[i] = parse2.getCoveredText();
            strArr2[i] = parse2.getType();
        }
        return new POSSample(strArr, strArr2);
    }
}
