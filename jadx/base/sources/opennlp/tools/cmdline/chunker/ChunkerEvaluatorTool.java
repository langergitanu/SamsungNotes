package opennlp.tools.cmdline.chunker;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.IOException;
import java.util.LinkedList;
import opennlp.tools.chunker.ChunkSample;
import opennlp.tools.chunker.ChunkerEvaluationMonitor;
import opennlp.tools.chunker.ChunkerEvaluator;
import opennlp.tools.chunker.ChunkerME;
import opennlp.tools.chunker.ChunkerModel;
import opennlp.tools.cmdline.AbstractEvaluatorTool;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.EvaluatorParams;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ChunkerEvaluatorTool extends AbstractEvaluatorTool<ChunkSample, EvalToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ChunkerEvaluatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EvalToolParams extends EvaluatorParams {
    }

    public ChunkerEvaluatorTool() {
        super(ChunkSample.class, EvalToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Measures the performance of the Chunker model with the reference data";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        ChunkerModel chunkerModelLoad = new ChunkerModelLoader().load(((EvalToolParams) this.params).getModel());
        LinkedList linkedList = new LinkedList();
        if (((EvalToolParams) this.params).getMisclassified().booleanValue()) {
            linkedList.add(new ChunkEvaluationErrorListener());
        }
        ChunkerEvaluator chunkerEvaluator = new ChunkerEvaluator(new ChunkerME(chunkerModelLoad), (ChunkerEvaluationMonitor[]) linkedList.toArray(new ChunkerEvaluationMonitor[0]));
        final PerformanceMonitor performanceMonitor = new PerformanceMonitor("sent");
        try {
            ObjectStream<ChunkSample> objectStream = new ObjectStream<ChunkSample>() { // from class: opennlp.tools.cmdline.chunker.ChunkerEvaluatorTool.1
                @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
                public void close() {
                    ((AbstractEvaluatorTool) ChunkerEvaluatorTool.this).sampleStream.close();
                }

                @Override // opennlp.tools.util.ObjectStream
                public void reset() {
                    ((AbstractEvaluatorTool) ChunkerEvaluatorTool.this).sampleStream.reset();
                }

                @Override // opennlp.tools.util.ObjectStream
                public ChunkSample read() {
                    performanceMonitor.incrementCounter();
                    return (ChunkSample) ((AbstractEvaluatorTool) ChunkerEvaluatorTool.this).sampleStream.read();
                }
            };
            try {
                performanceMonitor.startAndPrintThroughput();
                chunkerEvaluator.evaluate(objectStream);
                objectStream.close();
                performanceMonitor.stopAndPrintFinalResult();
                logger.info(chunkerEvaluator.getFMeasure().toString());
            } finally {
            }
        } catch (IOException e) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while reading test data: ", e.getMessage()), e);
        }
    }
}
