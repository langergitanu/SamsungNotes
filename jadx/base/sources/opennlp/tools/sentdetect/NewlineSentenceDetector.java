package opennlp.tools.sentdetect;

import java.util.ArrayList;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NewlineSentenceDetector implements SentenceDetector {
    @Override // opennlp.tools.sentdetect.SentenceDetector
    public String[] sentDetect(CharSequence charSequence) {
        return Span.spansToStrings(sentPosDetect(charSequence), charSequence);
    }

    @Override // opennlp.tools.sentdetect.SentenceDetector
    public Span[] sentPosDetect(CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        for (int i2 = 0; i2 < charSequence.length(); i2++) {
            char cCharAt = charSequence.charAt(i2);
            if ((cCharAt == '\n' || cCharAt == '\r') && i2 - i > 0) {
                Span spanTrim = new Span(i, i2).trim(charSequence);
                if (spanTrim.length() > 0) {
                    arrayList.add(spanTrim);
                }
                i = i2 + 1;
            }
        }
        if (charSequence.length() - i > 0) {
            Span spanTrim2 = new Span(i, charSequence.length()).trim(charSequence);
            if (spanTrim2.length() > 0) {
                arrayList.add(spanTrim2);
            }
        }
        return (Span[]) arrayList.toArray(new Span[0]);
    }
}
