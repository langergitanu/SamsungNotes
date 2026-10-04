package opennlp.tools.sentdetect;

import java.util.LinkedList;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;
import org.apache.commons.lang3.StringUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SentenceSampleStream extends FilterObjectStream<String, SentenceSample> {
    public SentenceSampleStream(ObjectStream<String> objectStream) {
        super(new EmptyLinePreprocessorStream(objectStream));
    }

    public static String replaceNewLineEscapeTags(String str) {
        return str.replace("<LF>", "\n").replace("<CR>", StringUtils.f9761CR);
    }

    @Override // opennlp.tools.util.ObjectStream
    public SentenceSample read() {
        StringBuilder sb = new StringBuilder();
        LinkedList linkedList = new LinkedList();
        while (true) {
            String str = (String) this.samples.read();
            if (str == null || str.isEmpty()) {
                break;
            }
            int length = sb.length();
            sb.append(replaceNewLineEscapeTags(str.trim()));
            linkedList.add(new Span(length, sb.length()));
            sb.append(' ');
        }
        if (linkedList.isEmpty()) {
            return null;
        }
        return new SentenceSample(sb.toString(), (Span[]) linkedList.toArray(new Span[0]));
    }
}
