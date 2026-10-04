package opennlp.tools.formats.moses;

import java.util.LinkedList;
import opennlp.tools.sentdetect.EmptyLinePreprocessorStream;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.util.FilterObjectStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MosesSentenceSampleStream extends FilterObjectStream<String, SentenceSample> {
    public MosesSentenceSampleStream(ObjectStream<String> objectStream) {
        super(new EmptyLinePreprocessorStream(objectStream));
    }

    @Override // opennlp.tools.util.ObjectStream
    public SentenceSample read() {
        String str;
        StringBuilder sb = new StringBuilder();
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 25 && (str = (String) this.samples.read()) != null; i++) {
            int length = sb.length();
            sb.append(str.trim());
            linkedList.add(new Span(length, sb.length()));
            sb.append(' ');
        }
        if (linkedList.size() > 0) {
            return new SentenceSample(sb.toString(), (Span[]) linkedList.toArray(new Span[0]));
        }
        return null;
    }
}
