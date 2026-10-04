package opennlp.tools.cmdline.namefind;

import opennlp.tools.cmdline.DetailedFMeasureListener;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.TokenNameFinderEvaluationMonitor;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenNameFinderDetailedFMeasureListener extends DetailedFMeasureListener<NameSample> implements TokenNameFinderEvaluationMonitor {
    @Override // opennlp.tools.cmdline.DetailedFMeasureListener
    public Span[] asSpanArray(NameSample nameSample) {
        return nameSample.getNames();
    }
}
