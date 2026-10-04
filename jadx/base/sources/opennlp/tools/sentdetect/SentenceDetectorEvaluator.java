package opennlp.tools.sentdetect;

import opennlp.tools.util.Span;
import opennlp.tools.util.eval.Evaluator;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SentenceDetectorEvaluator extends Evaluator<SentenceSample> {
    private final FMeasure fmeasure;
    private final SentenceDetector sentenceDetector;

    public SentenceDetectorEvaluator(SentenceDetector sentenceDetector, SentenceDetectorEvaluationMonitor... sentenceDetectorEvaluationMonitorArr) {
        super(sentenceDetectorEvaluationMonitorArr);
        this.fmeasure = new FMeasure();
        this.sentenceDetector = sentenceDetector;
    }

    private Span[] trimSpans(String str, Span[] spanArr) {
        Span[] spanArr2 = new Span[spanArr.length];
        for (int i = 0; i < spanArr.length; i++) {
            spanArr2[i] = spanArr[i].trim(str);
        }
        return spanArr2;
    }

    public FMeasure getFMeasure() {
        return this.fmeasure;
    }

    @Override // opennlp.tools.util.eval.Evaluator
    public SentenceSample processSample(SentenceSample sentenceSample) {
        Span[] spanArrTrimSpans = trimSpans(sentenceSample.getDocument(), this.sentenceDetector.sentPosDetect(sentenceSample.getDocument()));
        this.fmeasure.updateScores(trimSpans(sentenceSample.getDocument(), sentenceSample.getSentences()), spanArrTrimSpans);
        return new SentenceSample(sentenceSample.getDocument(), spanArrTrimSpans);
    }
}
