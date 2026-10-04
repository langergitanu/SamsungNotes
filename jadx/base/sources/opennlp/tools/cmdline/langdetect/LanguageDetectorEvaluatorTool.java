package opennlp.tools.cmdline.langdetect;

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
import opennlp.tools.langdetect.LanguageDetectorEvaluationMonitor;
import opennlp.tools.langdetect.LanguageDetectorEvaluator;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageDetectorModel;
import opennlp.tools.langdetect.LanguageSample;
import opennlp.tools.util.ObjectStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class LanguageDetectorEvaluatorTool extends AbstractEvaluatorTool<LanguageSample, EvalToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) LanguageDetectorEvaluatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EvalToolParams extends EvaluatorParams, FineGrainedEvaluatorParams {
    }

    public LanguageDetectorEvaluatorTool() {
        super(LanguageSample.class, EvalToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Measures the performance of the Language Detector model with the reference data";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        FileOutputStream fileOutputStream;
        LanguageDetectorFineGrainedReportListener languageDetectorFineGrainedReportListener;
        super.run(str, strArr);
        LanguageDetectorModel languageDetectorModelLoad = new LanguageDetectorModelLoader().load(((EvalToolParams) this.params).getModel());
        LinkedList linkedList = new LinkedList();
        if (((EvalToolParams) this.params).getMisclassified().booleanValue()) {
            linkedList.add(new LanguageDetectorEvaluationErrorListener());
        }
        File reportOutputFile = ((EvalToolParams) this.params).getReportOutputFile();
        if (reportOutputFile != null) {
            CmdLineUtil.checkOutputFile("Report Output File", reportOutputFile);
            try {
                fileOutputStream = new FileOutputStream(reportOutputFile);
                languageDetectorFineGrainedReportListener = new LanguageDetectorFineGrainedReportListener(fileOutputStream);
                linkedList.add(languageDetectorFineGrainedReportListener);
            } catch (FileNotFoundException e) {
                throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while creating LanguageDetector fine-grained report file: ", e.getMessage()));
            }
        } else {
            fileOutputStream = null;
            languageDetectorFineGrainedReportListener = null;
        }
        LanguageDetectorEvaluator languageDetectorEvaluator = new LanguageDetectorEvaluator(new LanguageDetectorME(languageDetectorModelLoad), (LanguageDetectorEvaluationMonitor[]) linkedList.toArray(new LanguageDetectorEvaluationMonitor[0]));
        final PerformanceMonitor performanceMonitor = new PerformanceMonitor("doc");
        try {
            ObjectStream<LanguageSample> objectStream = new ObjectStream<LanguageSample>() { // from class: opennlp.tools.cmdline.langdetect.LanguageDetectorEvaluatorTool.1
                @Override // opennlp.tools.util.ObjectStream, java.lang.AutoCloseable
                public void close() {
                    ((AbstractEvaluatorTool) LanguageDetectorEvaluatorTool.this).sampleStream.close();
                }

                @Override // opennlp.tools.util.ObjectStream
                public void reset() {
                    ((AbstractEvaluatorTool) LanguageDetectorEvaluatorTool.this).sampleStream.reset();
                }

                @Override // opennlp.tools.util.ObjectStream
                public LanguageSample read() {
                    performanceMonitor.incrementCounter();
                    return (LanguageSample) ((AbstractEvaluatorTool) LanguageDetectorEvaluatorTool.this).sampleStream.read();
                }
            };
            try {
                performanceMonitor.startAndPrintThroughput();
                languageDetectorEvaluator.evaluate(objectStream);
                objectStream.close();
                performanceMonitor.stopAndPrintFinalResult();
                Logger logger2 = logger;
                logger2.info(languageDetectorEvaluator.toString());
                if (languageDetectorFineGrainedReportListener != null) {
                    logger2.info("Writing fine-grained report to {}", ((EvalToolParams) this.params).getReportOutputFile().getAbsolutePath());
                    languageDetectorFineGrainedReportListener.writeReport();
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
