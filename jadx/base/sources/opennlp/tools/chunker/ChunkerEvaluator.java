package opennlp.tools.chunker;

import opennlp.tools.util.eval.Evaluator;
import opennlp.tools.util.eval.FMeasure;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkerEvaluator extends Evaluator<ChunkSample> {
    private final Chunker chunker;
    private final FMeasure fmeasure;

    public ChunkerEvaluator(Chunker chunker, ChunkerEvaluationMonitor... chunkerEvaluationMonitorArr) {
        super(chunkerEvaluationMonitorArr);
        this.fmeasure = new FMeasure();
        this.chunker = chunker;
    }

    public FMeasure getFMeasure() {
        return this.fmeasure;
    }

    @Override // opennlp.tools.util.eval.Evaluator
    public ChunkSample processSample(ChunkSample chunkSample) {
        ChunkSample chunkSample2 = new ChunkSample(chunkSample.getSentence(), chunkSample.getTags(), this.chunker.chunk(chunkSample.getSentence(), chunkSample.getTags()));
        this.fmeasure.updateScores(chunkSample.getPhrasesAsSpanList(), chunkSample2.getPhrasesAsSpanList());
        return chunkSample2;
    }
}
