package opennlp.tools.cmdline.langdetect;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import opennlp.tools.cmdline.AbstractCrossValidatorTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.CVParams;
import opennlp.tools.cmdline.params.FineGrainedEvaluatorParams;
import opennlp.tools.langdetect.LanguageDetectorCrossValidator;
import opennlp.tools.langdetect.LanguageDetectorEvaluationMonitor;
import opennlp.tools.langdetect.LanguageDetectorFactory;
import opennlp.tools.langdetect.LanguageSample;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class LanguageDetectorCrossValidatorTool extends AbstractCrossValidatorTool<LanguageSample, CVToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) LanguageDetectorCrossValidatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CVToolParams extends CVParams, TrainingParams, FineGrainedEvaluatorParams {
    }

    public LanguageDetectorCrossValidatorTool() {
        super(LanguageSample.class, CVToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "K-fold cross validator for the learnable Language Detector";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        FileOutputStream fileOutputStream;
        LanguageDetectorFineGrainedReportListener languageDetectorFineGrainedReportListener;
        super.run(str, strArr);
        TrainingParameters trainingParametersLoadTrainingParameters = CmdLineUtil.loadTrainingParameters(((CVToolParams) this.params).getParams(), false);
        this.mlParams = trainingParametersLoadTrainingParameters;
        if (trainingParametersLoadTrainingParameters == null) {
            this.mlParams = ModelUtil.createDefaultTrainingParameters();
        }
        LinkedList linkedList = new LinkedList();
        if (((CVToolParams) this.params).getMisclassified().booleanValue()) {
            linkedList.add(new LanguageDetectorEvaluationErrorListener());
        }
        File reportOutputFile = ((CVToolParams) this.params).getReportOutputFile();
        if (reportOutputFile != null) {
            CmdLineUtil.checkOutputFile("Report Output File", reportOutputFile);
            try {
                fileOutputStream = new FileOutputStream(reportOutputFile);
                languageDetectorFineGrainedReportListener = new LanguageDetectorFineGrainedReportListener(fileOutputStream);
                linkedList.add(languageDetectorFineGrainedReportListener);
            } catch (FileNotFoundException e) {
                throw createTerminationIOException(e);
            }
        } else {
            fileOutputStream = null;
            languageDetectorFineGrainedReportListener = null;
        }
        try {
            try {
                LanguageDetectorCrossValidator languageDetectorCrossValidator = new LanguageDetectorCrossValidator(this.mlParams, LanguageDetectorFactory.create(((CVToolParams) this.params).getFactory()), (LanguageDetectorEvaluationMonitor[]) linkedList.toArray(new LanguageDetectorEvaluationMonitor[0]));
                languageDetectorCrossValidator.evaluate(this.sampleStream, ((CVToolParams) this.params).getFolds().intValue());
                Logger logger2 = logger;
                logger2.info(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE);
                if (languageDetectorFineGrainedReportListener != null) {
                    logger2.info("Writing fine-grained report to {}", ((CVToolParams) this.params).getReportOutputFile().getAbsolutePath());
                    languageDetectorFineGrainedReportListener.writeReport();
                    try {
                        fileOutputStream.close();
                    } catch (IOException unused) {
                    }
                }
                logger.info("Accuracy: {} Number of documents: {}", Double.valueOf(languageDetectorCrossValidator.getDocumentAccuracy()), Long.valueOf(languageDetectorCrossValidator.getDocumentCount()));
            } catch (IOException e2) {
                throw new TerminateToolException(-1, "IO error while reading training data or indexing data: " + e2.getMessage(), e2);
            }
        } finally {
            try {
                this.sampleStream.close();
            } catch (IOException unused2) {
            }
        }
    }
}
