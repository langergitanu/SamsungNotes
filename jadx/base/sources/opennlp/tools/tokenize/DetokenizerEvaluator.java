package opennlp.tools.tokenize;

import java.util.ArrayList;
import opennlp.tools.cmdline.tokenizer.DetokenEvaluationErrorListener;
import opennlp.tools.util.Span;
import opennlp.tools.util.eval.Evaluator;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DetokenizerEvaluator extends Evaluator<TokenSample> {
    private final Detokenizer detokenizer;
    private final FMeasure fmeasure;

    public DetokenizerEvaluator(Detokenizer detokenizer, DetokenEvaluationErrorListener... detokenEvaluationErrorListenerArr) {
        super(detokenEvaluationErrorListenerArr);
        this.fmeasure = new FMeasure();
        this.detokenizer = detokenizer;
    }

    public FMeasure getFMeasure() {
        return this.fmeasure;
    }

    @Override // opennlp.tools.util.eval.Evaluator
    public TokenSample processSample(TokenSample tokenSample) {
        String strDetokenize = this.detokenizer.detokenize(Span.spansToStrings(tokenSample.getTokenSpans(), tokenSample.getText()), null);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList.add(strDetokenize);
        arrayList2.add(tokenSample.getText());
        this.fmeasure.updateScores(arrayList2.toArray(), arrayList.toArray());
        return new TokenSample(strDetokenize, tokenSample.getTokenSpans());
    }
}
