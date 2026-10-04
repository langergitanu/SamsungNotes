package opennlp.tools.namefind;

import opennlp.tools.util.Span;
import opennlp.tools.util.eval.Evaluator;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenNameFinderEvaluator extends Evaluator<NameSample> {
    private final FMeasure fmeasure;
    private final TokenNameFinder nameFinder;

    public TokenNameFinderEvaluator(TokenNameFinder tokenNameFinder, TokenNameFinderEvaluationMonitor... tokenNameFinderEvaluationMonitorArr) {
        super(tokenNameFinderEvaluationMonitorArr);
        this.fmeasure = new FMeasure();
        this.nameFinder = tokenNameFinder;
    }

    public FMeasure getFMeasure() {
        return this.fmeasure;
    }

    @Override // opennlp.tools.util.eval.Evaluator
    public NameSample processSample(NameSample nameSample) {
        if (nameSample.isClearAdaptiveDataSet()) {
            this.nameFinder.clearAdaptiveData();
        }
        Span[] spanArrFind = this.nameFinder.find(nameSample.getSentence());
        Span[] names = nameSample.getNames();
        for (int i = 0; i < names.length; i++) {
            if (names[i].getType() == null) {
                names[i] = new Span(names[i].getStart(), names[i].getEnd(), "default");
            }
        }
        this.fmeasure.updateScores(names, spanArrFind);
        return new NameSample(nameSample.getSentence(), spanArrFind, nameSample.isClearAdaptiveDataSet());
    }
}
