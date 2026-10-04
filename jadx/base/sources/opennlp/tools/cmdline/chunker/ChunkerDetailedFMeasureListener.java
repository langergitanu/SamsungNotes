package opennlp.tools.cmdline.chunker;

import opennlp.tools.chunker.ChunkSample;
import opennlp.tools.chunker.ChunkerEvaluationMonitor;
import opennlp.tools.cmdline.DetailedFMeasureListener;
import opennlp.tools.util.Span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkerDetailedFMeasureListener extends DetailedFMeasureListener<ChunkSample> implements ChunkerEvaluationMonitor {
    @Override // opennlp.tools.cmdline.DetailedFMeasureListener
    public Span[] asSpanArray(ChunkSample chunkSample) {
        return chunkSample.getPhrasesAsSpanList();
    }
}
