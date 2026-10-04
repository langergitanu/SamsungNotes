package opennlp.tools.cmdline.namefind;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import opennlp.tools.cmdline.AbstractEvaluatorTool;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.PerformanceMonitor;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.EvaluatorParams;
import opennlp.tools.cmdline.params.FineGrainedEvaluatorParams;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleTypeFilter;
import opennlp.tools.namefind.TokenNameFinderEvaluationMonitor;
import opennlp.tools.namefind.TokenNameFinderEvaluator;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TokenNameFinderEvaluatorTool extends AbstractEvaluatorTool<NameSample, EvalToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TokenNameFinderEvaluatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EvalToolParams extends EvaluatorParams, FineGrainedEvaluatorParams {
        @ArgumentParser.OptionalParameter
        @ArgumentParser.ParameterDescription(description = "name types to use for evaluation", valueName = "types")
        String getNameTypes();
    }

    public TokenNameFinderEvaluatorTool() {
        super(NameSample.class, EvalToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Measures the performance of the NameFinder model with the reference data";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        TokenNameFinderFineGrainedReportListener tokenNameFinderFineGrainedReportListener;
        super.run(str, strArr);
        TokenNameFinderModel tokenNameFinderModelLoad = new TokenNameFinderModelLoader().load(((EvalToolParams) this.params).getModel());
        LinkedList linkedList = new LinkedList();
        if (((EvalToolParams) this.params).getMisclassified().booleanValue()) {
            linkedList.add(new NameEvaluationErrorListener());
        }
        File reportOutputFile = ((EvalToolParams) this.params).getReportOutputFile();
        if (reportOutputFile != null) {
            CmdLineUtil.checkOutputFile("Report Output File", reportOutputFile);
            try {
                tokenNameFinderFineGrainedReportListener = new TokenNameFinderFineGrainedReportListener(tokenNameFinderModelLoad.getSequenceCodec(), new FileOutputStream(reportOutputFile));
                linkedList.add(tokenNameFinderFineGrainedReportListener);
            } catch (FileNotFoundException e) {
                throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while creating Name Finder fine-grained report file: ", e.getMessage()));
            }
        } else {
            tokenNameFinderFineGrainedReportListener = null;
        }
        if (((EvalToolParams) this.params).getNameTypes() != null) {
            this.sampleStream = new NameSampleTypeFilter(((EvalToolParams) this.params).getNameTypes().split(","), (ObjectStream<NameSample>) this.sampleStream);
        }
        TokenNameFinderEvaluator tokenNameFinderEvaluator = new TokenNameFinderEvaluator(new NameFinderME(tokenNameFinderModelLoad), (TokenNameFinderEvaluationMonitor[]) linkedList.toArray(new TokenNameFinderEvaluationMonitor[0]));
        final PerformanceMonitor performanceMonitor = new PerformanceMonitor("sent");
        try {
            ObjectStream<NameSample> objectStream = new ObjectStream<NameSample>() { // from class: opennlp.tools.cmdline.namefind.TokenNameFinderEvaluatorTool.1
                @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
                public void close() {
                    ((AbstractEvaluatorTool) TokenNameFinderEvaluatorTool.this).sampleStream.close();
                }

                @Override // opennlp.tools.util.ObjectStream
                public void reset() {
                    ((AbstractEvaluatorTool) TokenNameFinderEvaluatorTool.this).sampleStream.reset();
                }

                @Override // opennlp.tools.util.ObjectStream
                public NameSample read() {
                    performanceMonitor.incrementCounter();
                    return (NameSample) ((AbstractEvaluatorTool) TokenNameFinderEvaluatorTool.this).sampleStream.read();
                }
            };
            try {
                performanceMonitor.startAndPrintThroughput();
                tokenNameFinderEvaluator.evaluate(objectStream);
                objectStream.close();
                performanceMonitor.stopAndPrintFinalResult();
                if (reportOutputFile != null) {
                    tokenNameFinderFineGrainedReportListener.writeReport();
                }
                logger.info(tokenNameFinderEvaluator.getFMeasure().toString());
            } finally {
            }
        } catch (IOException e2) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while reading test data: ", e2.getMessage()), e2);
        }
    }
}
