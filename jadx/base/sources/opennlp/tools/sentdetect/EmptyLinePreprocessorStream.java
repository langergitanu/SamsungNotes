package opennlp.tools.sentdetect;

import opennlp.tools.commons.Internal;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
public class EmptyLinePreprocessorStream extends FilterObjectStream<String, String> {
    private boolean lastLineWasEmpty;

    public EmptyLinePreprocessorStream(ObjectStream<String> objectStream) {
        super(objectStream);
        this.lastLineWasEmpty = true;
    }

    private static boolean isLineEmpty(String str) {
        return str.trim().length() == 0;
    }

    @Override // opennlp.tools.util.ObjectStream
    public String read() {
        String str = (String) this.samples.read();
        if (this.lastLineWasEmpty) {
            this.lastLineWasEmpty = false;
            while (str != null && isLineEmpty(str)) {
                str = (String) this.samples.read();
            }
        }
        if (str == null || !isLineEmpty(str)) {
            return str;
        }
        this.lastLineWasEmpty = true;
        return "";
    }
}
