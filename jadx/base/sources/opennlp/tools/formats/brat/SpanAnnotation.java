package opennlp.tools.formats.brat;

import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.util.Arrays;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SpanAnnotation extends BratAnnotation {
    private final String coveredText;
    private final Span[] spans;

    public SpanAnnotation(String str, String str2, Span[] spanArr, String str3) {
        super(str, str2);
        Span[] spanArr2 = (Span[]) Arrays.copyOf(spanArr, spanArr.length);
        this.spans = spanArr2;
        Arrays.sort(spanArr2);
        this.coveredText = str3;
    }

    public String getCoveredText() {
        return this.coveredText;
    }

    public Span[] getSpans() {
        return this.spans;
    }

    @Override // opennlp.tools.formats.brat.BratAnnotation
    public String toString() {
        return AbstractC2322a.m1622l(super.toString(), " ", Arrays.toString(this.spans), " ", getCoveredText());
    }
}
