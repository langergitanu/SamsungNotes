package opennlp.tools.doccat;

import java.io.IOException;
import opennlp.tools.tokenize.WhitespaceTokenizer;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DocumentSampleStream extends FilterObjectStream<String, DocumentSample> {
    public DocumentSampleStream(ObjectStream<String> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public DocumentSample read() throws IOException {
        String str = (String) this.samples.read();
        if (str == null) {
            return null;
        }
        String[] strArr = WhitespaceTokenizer.INSTANCE.tokenize(str);
        if (strArr.length <= 1) {
            throw new IOException("Empty lines, or lines with only a category string are not allowed!");
        }
        String str2 = strArr[0];
        String[] strArr2 = new String[strArr.length - 1];
        System.arraycopy(strArr, 1, strArr2, 0, strArr.length - 1);
        return new DocumentSample(str2, strArr2);
    }
}
