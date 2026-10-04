package opennlp.tools.tokenize;

import opennlp.tools.util.Span;
import opennlp.tools.util.eval.Evaluator;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TokenizerEvaluator extends Evaluator<TokenSample> {
    private final FMeasure fmeasure;
    private final Tokenizer tokenizer;

    public TokenizerEvaluator(Tokenizer tokenizer, TokenizerEvaluationMonitor... tokenizerEvaluationMonitorArr) {
        super(tokenizerEvaluationMonitorArr);
        this.fmeasure = new FMeasure();
        this.tokenizer = tokenizer;
    }

    public FMeasure getFMeasure() {
        return this.fmeasure;
    }

    @Override // opennlp.tools.util.eval.Evaluator
    public TokenSample processSample(TokenSample tokenSample) {
        Span[] spanArr = this.tokenizer.tokenizePos(tokenSample.getText());
        this.fmeasure.updateScores(tokenSample.getTokenSpans(), spanArr);
        return new TokenSample(tokenSample.getText(), spanArr);
    }
}
