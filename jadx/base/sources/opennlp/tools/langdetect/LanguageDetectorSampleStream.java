package opennlp.tools.langdetect;

import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorSampleStream extends FilterObjectStream<String, LanguageSample> {
    public LanguageDetectorSampleStream(ObjectStream<String> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public LanguageSample read() {
        String str;
        int iIndexOf;
        do {
            str = (String) this.samples.read();
            if (str == null) {
                return null;
            }
            iIndexOf = str.indexOf("\t");
        } while (iIndexOf <= 0);
        String strSubstring = str.substring(0, iIndexOf);
        return new LanguageSample(new Language(strSubstring), str.substring(iIndexOf + 1));
    }
}
