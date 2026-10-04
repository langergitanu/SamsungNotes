package opennlp.tools.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ParagraphStream extends FilterObjectStream<String, String> {
    public ParagraphStream(ObjectStream<String> objectStream) {
        super(objectStream);
    }

    @Override // opennlp.tools.util.ObjectStream
    public String read() {
        String str;
        StringBuilder sb = new StringBuilder();
        do {
            str = (String) this.samples.read();
            if (str != null && !str.isEmpty()) {
                sb.append(str);
                sb.append('\n');
            } else if (sb.length() > 0) {
                return sb.toString();
            }
        } while (str != null);
        return null;
    }
}
