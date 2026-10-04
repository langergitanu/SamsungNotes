package opennlp.tools.formats.ontonotes;

import opennlp.tools.parser.Parse;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class OntoNotesParseSampleStream extends FilterObjectStream<String, Parse> {
    public OntoNotesParseSampleStream(ObjectStream<String> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public Parse read() {
        StringBuilder sb = new StringBuilder();
        while (true) {
            String strTrim = (String) this.samples.read();
            if (strTrim != null) {
                strTrim = strTrim.trim();
            }
            if (strTrim == null || strTrim.isEmpty()) {
                break;
            }
            sb.append(strTrim);
            sb.append(" ");
        }
        if (sb.length() > 0) {
            return Parse.parseParse(sb.toString());
        }
        return null;
    }
}
