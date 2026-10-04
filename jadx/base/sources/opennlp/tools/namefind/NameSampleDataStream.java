package opennlp.tools.namefind;

import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NameSampleDataStream extends FilterObjectStream<String, NameSample> {
    public static final String END_TAG = "<END>";
    public static final String START_TAG = "<START>";
    public static final String START_TAG_PREFIX = "<START:";

    public NameSampleDataStream(ObjectStream<String> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public NameSample read() {
        String str = (String) this.samples.read();
        boolean z = false;
        while (str != null && str.trim().length() == 0) {
            str = (String) this.samples.read();
            z = true;
        }
        if (str != null) {
            return NameSample.parse(str, z);
        }
        return null;
    }
}
