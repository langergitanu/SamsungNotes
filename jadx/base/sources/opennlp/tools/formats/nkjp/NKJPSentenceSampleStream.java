package opennlp.tools.formats.nkjp;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import opennlp.tools.formats.nkjp.NKJPSegmentationDocument;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NKJPSentenceSampleStream implements ObjectStream<SentenceSample> {
    private Iterator<Map.Entry<String, Map<String, NKJPSegmentationDocument.Pointer>>> segmentIt;
    private final NKJPSegmentationDocument segments;
    private final NKJPTextDocument text;

    public NKJPSentenceSampleStream(NKJPSegmentationDocument nKJPSegmentationDocument, NKJPTextDocument nKJPTextDocument) {
        this.segments = nKJPSegmentationDocument;
        this.text = nKJPTextDocument;
        reset();
    }

    @Override // opennlp.tools.util.ObjectStream
    public void reset() {
        this.segmentIt = this.segments.getSegments().entrySet().iterator();
    }

    @Override // opennlp.tools.util.ObjectStream
    public SentenceSample read() {
        StringBuilder sb = new StringBuilder();
        LinkedList linkedList = new LinkedList();
        Map<String, String> paragraphs = this.text.getParagraphs();
        while (true) {
            int start = 0;
            if (!this.segmentIt.hasNext()) {
                break;
            }
            Map.Entry<String, Map<String, NKJPSegmentationDocument.Pointer>> next = this.segmentIt.next();
            Iterator<String> it = next.getValue().keySet().iterator();
            boolean z = false;
            String str = "";
            String str2 = str;
            int end = 0;
            while (it.hasNext()) {
                NKJPSegmentationDocument.Pointer pointer = next.getValue().get(it.next());
                Span span = pointer.toSpan();
                if (!z) {
                    start = span.getStart();
                    str2 = pointer.f9666id;
                    str = paragraphs.get(str2);
                    z = true;
                }
                if (str2.equals(pointer.f9666id)) {
                    end = span.getEnd();
                } else {
                    int length = sb.length();
                    sb.append(str.substring(start, end));
                    linkedList.add(new Span(length, sb.length()));
                    sb.append(' ');
                    start = span.getStart();
                    end = span.getEnd();
                    String str3 = pointer.f9666id;
                    str2 = str3;
                    str = paragraphs.get(str3);
                }
            }
            int length2 = sb.length();
            sb.append(str.substring(start, end));
            linkedList.add(new Span(length2, sb.length()));
            sb.append(' ');
        }
        if (linkedList.size() == 0) {
            return null;
        }
        return new SentenceSample(sb.toString(), (Span[]) linkedList.toArray(new Span[0]));
    }
}
