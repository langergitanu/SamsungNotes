package opennlp.tools.cmdline.chunker;

import java.io.OutputStream;
import java.io.PrintStream;
import opennlp.tools.chunker.ChunkSample;
import opennlp.tools.chunker.ChunkerEvaluationMonitor;
import opennlp.tools.cmdline.EvaluationErrorPrinter;
import opennlp.tools.log.LogPrintStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ChunkEvaluationErrorListener extends EvaluationErrorPrinter<ChunkSample> implements ChunkerEvaluationMonitor {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ChunkEvaluationErrorListener.class);

    public ChunkEvaluationErrorListener() {
        super((PrintStream) new LogPrintStream(logger));
    }

    public ChunkEvaluationErrorListener(OutputStream outputStream) {
        super(outputStream);
    }

    @Override // opennlp.tools.cmdline.EvaluationErrorPrinter, opennlp.tools.util.eval.EvaluationMonitor
    public void misclassified(ChunkSample chunkSample, ChunkSample chunkSample2) {
        printError(chunkSample.getPhrasesAsSpanList(), chunkSample2.getPhrasesAsSpanList(), chunkSample, chunkSample2, chunkSample.getSentence());
    }
}
