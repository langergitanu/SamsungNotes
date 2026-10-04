package opennlp.tools.cmdline.doccat;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import opennlp.tools.cmdline.AbstractEvaluatorTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.EvaluatorParams;
import opennlp.tools.cmdline.params.FineGrainedEvaluatorParams;
import opennlp.tools.doccat.DoccatEvaluationMonitor;
import opennlp.tools.doccat.DoccatModel;
import opennlp.tools.doccat.DocumentCategorizerEvaluator;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class DoccatEvaluatorTool extends AbstractEvaluatorTool<DocumentSample, EvalToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) DoccatEvaluatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EvalToolParams extends EvaluatorParams, FineGrainedEvaluatorParams {
    }

    public DoccatEvaluatorTool() {
        super(DocumentSample.class, EvalToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Measures the performance of the Doccat model with the reference data";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        FileOutputStream fileOutputStream;
        DoccatFineGrainedReportListener doccatFineGrainedReportListener;
        super.run(str, strArr);
        DoccatModel doccatModelLoad = new DoccatModelLoader().load(((EvalToolParams) this.params).getModel());
        LinkedList linkedList = new LinkedList();
        if (((EvalToolParams) this.params).getMisclassified().booleanValue()) {
            linkedList.add(new DoccatEvaluationErrorListener());
        }
        File reportOutputFile = ((EvalToolParams) this.params).getReportOutputFile();
        if (reportOutputFile != null) {
            CmdLineUtil.checkOutputFile("Report Output File", reportOutputFile);
            try {
                fileOutputStream = new FileOutputStream(reportOutputFile);
                doccatFineGrainedReportListener = new DoccatFineGrainedReportListener(fileOutputStream);
                linkedList.add(doccatFineGrainedReportListener);
            } catch (FileNotFoundException e) {
                throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while creating Doccat fine-grained report file: ", e.getMessage()));
            }
        } else {
            fileOutputStream = null;
            doccatFineGrainedReportListener = null;
        }
        DocumentCategorizerEvaluator documentCategorizerEvaluator = new DocumentCategorizerEvaluator(new DocumentCategorizerME(doccatModelLoad), (DoccatEvaluationMonitor[]) linkedList.toArray(new DoccatEvaluationMonitor[0]));
        final PerformanceMonitor performanceMonitor = new PerformanceMonitor("doc");
        try {
            ObjectStream<DocumentSample> objectStream = new ObjectStream<DocumentSample>() { // from class: opennlp.tools.cmdline.doccat.DoccatEvaluatorTool.1
                @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
                public void close() {
                    ((AbstractEvaluatorTool) DoccatEvaluatorTool.this).sampleStream.close();
                }

                @Override // opennlp.tools.util.ObjectStream
                public void reset() {
                    ((AbstractEvaluatorTool) DoccatEvaluatorTool.this).sampleStream.reset();
                }

                @Override // opennlp.tools.util.ObjectStream
                public DocumentSample read() {
                    performanceMonitor.incrementCounter();
                    return (DocumentSample) ((AbstractEvaluatorTool) DoccatEvaluatorTool.this).sampleStream.read();
                }
            };
            try {
                performanceMonitor.startAndPrintThroughput();
                documentCategorizerEvaluator.evaluate(objectStream);
                objectStream.close();
                performanceMonitor.stopAndPrintFinalResult();
                Logger logger2 = logger;
                logger2.info(documentCategorizerEvaluator.toString());
                if (doccatFineGrainedReportListener != null) {
                    logger2.info("Writing fine-grained report to {}", ((EvalToolParams) this.params).getReportOutputFile().getAbsolutePath());
                    doccatFineGrainedReportListener.writeReport();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                }
            } finally {
            }
        } catch (IOException e2) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while reading test data: ", e2.getMessage()), e2);
        }
    }
}
