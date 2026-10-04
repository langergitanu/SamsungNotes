package opennlp.tools.cmdline.lemmatizer;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractEvaluatorTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.EvaluatorParams;
import opennlp.tools.cmdline.params.FineGrainedEvaluatorParams;
import opennlp.tools.lemmatizer.LemmaSample;
import opennlp.tools.lemmatizer.LemmatizerEvaluator;
import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.lemmatizer.LemmatizerModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class LemmatizerEvaluatorTool extends AbstractEvaluatorTool<LemmaSample, EvalToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) LemmatizerEvaluatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface EvalToolParams extends EvaluatorParams, FineGrainedEvaluatorParams {
    }

    public LemmatizerEvaluatorTool() {
        super(LemmaSample.class, EvalToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Measures the performance of the Lemmatizer model with the reference data";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        FileOutputStream fileOutputStream;
        super.run(str, strArr);
        LemmatizerModel lemmatizerModelLoad = new LemmatizerModelLoader().load(((EvalToolParams) this.params).getModel());
        LemmatizerFineGrainedReportListener lemmatizerFineGrainedReportListener = null;
        LemmaEvaluationErrorListener lemmaEvaluationErrorListener = ((EvalToolParams) this.params).getMisclassified().booleanValue() ? new LemmaEvaluationErrorListener() : null;
        File reportOutputFile = ((EvalToolParams) this.params).getReportOutputFile();
        if (reportOutputFile != null) {
            CmdLineUtil.checkOutputFile("Report Output File", reportOutputFile);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(reportOutputFile);
                fileOutputStream = fileOutputStream2;
                lemmatizerFineGrainedReportListener = new LemmatizerFineGrainedReportListener(fileOutputStream2);
            } catch (FileNotFoundException e) {
                throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while creating Lemmatizer fine-grained report file: ", e.getMessage()));
            }
        } else {
            fileOutputStream = null;
        }
        LemmatizerEvaluator lemmatizerEvaluator = new LemmatizerEvaluator(new LemmatizerME(lemmatizerModelLoad), lemmaEvaluationErrorListener, lemmatizerFineGrainedReportListener);
        logger.info("Evaluating ... ");
        try {
            try {
                lemmatizerEvaluator.evaluate(this.sampleStream);
                Logger logger2 = logger;
                logger2.info(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE);
                if (lemmatizerFineGrainedReportListener != null) {
                    logger2.info("Writing fine-grained report to {}", ((EvalToolParams) this.params).getReportOutputFile().getAbsolutePath());
                    lemmatizerFineGrainedReportListener.writeReport();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                }
                logger.info("Accuracy: {}", Double.valueOf(lemmatizerEvaluator.getWordAccuracy()));
            } catch (IOException e2) {
                throw new TerminateToolException(-1, "IO error while reading test data: " + e2.getMessage(), e2);
            }
        } finally {
            try {
                this.sampleStream.close();
            } catch (IOException unused2) {
            }
        }
    }
}
