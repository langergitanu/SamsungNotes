package opennlp.tools.formats.convert;

import java.util.ArrayList;
import opennlp.tools.commons.Internal;
import opennlp.tools.parser.Parse;
import opennlp.tools.postag.POSSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class ParseToPOSSampleStream extends FilterObjectStream<Parse, POSSample> {
    public ParseToPOSSampleStream(ObjectStream<Parse> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public POSSample read() {
        Parse parse = (Parse) this.samples.read();
        if (parse == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Parse parse2 : parse.getTagNodes()) {
            arrayList.add(parse2.getCoveredText());
            arrayList2.add(parse2.getType());
        }
        return new POSSample(arrayList, arrayList2);
    }
}
