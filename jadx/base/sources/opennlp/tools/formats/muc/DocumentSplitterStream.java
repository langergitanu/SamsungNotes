package opennlp.tools.formats.muc;

import java.util.ArrayList;
import java.util.List;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class DocumentSplitterStream extends FilterObjectStream<String, String> {
    private static final String DOC_END_ELEMENT = "</DOC>";
    private static final String DOC_START_ELEMENT = "<DOC>";
    private final List<String> docs;

    public DocumentSplitterStream(ObjectStream<String> objectStream) {
        super(objectStream);
        this.docs = new ArrayList();
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x003b, code lost:
    
        if (r3 != r2) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        throw new opennlp.tools.util.InvalidFormatException("Missing <DOC> or </DOC> element!");
     */
    @Override // opennlp.tools.util.ObjectStream
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String read() throws InvalidFormatException {
        String str;
        if (this.docs.isEmpty() && (str = (String) this.samples.read()) != null) {
            int i = 0;
            while (true) {
                int iIndexOf = str.indexOf(DOC_START_ELEMENT, i);
                int iIndexOf2 = str.indexOf(DOC_END_ELEMENT, i);
                if (iIndexOf == -1 || iIndexOf2 == -1) {
                    break;
                }
                if (iIndexOf >= iIndexOf2) {
                    throw new InvalidFormatException("<DOC> element is not closed!");
                }
                i = iIndexOf2 + 6;
                this.docs.add(str.substring(iIndexOf, i));
            }
        }
        if (this.docs.size() > 0) {
            return this.docs.remove(0);
        }
        return null;
    }
}
