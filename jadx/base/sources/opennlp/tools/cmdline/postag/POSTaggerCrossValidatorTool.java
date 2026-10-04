package opennlp.tools.cmdline.postag;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractCrossValidatorTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.namefind.TokenNameFinderTrainerTool;
import opennlp.tools.cmdline.params.CVParams;
import opennlp.tools.cmdline.params.FineGrainedEvaluatorParams;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerCrossValidator;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class POSTaggerCrossValidatorTool extends AbstractCrossValidatorTool<POSSample, CVToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) POSTaggerCrossValidatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CVToolParams extends CVParams, TrainingParams, FineGrainedEvaluatorParams {
    }

    public POSTaggerCrossValidatorTool() {
        super(POSSample.class, CVToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "K-fold cross validator for the learnable POS tagger";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        FileOutputStream fileOutputStream;
        super.run(str, strArr);
        TrainingParameters trainingParametersLoadTrainingParameters = CmdLineUtil.loadTrainingParameters(((CVToolParams) this.params).getParams(), false);
        this.mlParams = trainingParametersLoadTrainingParameters;
        if (trainingParametersLoadTrainingParameters == null) {
            this.mlParams = ModelUtil.createDefaultTrainingParameters();
        }
        POSTaggerFineGrainedReportListener pOSTaggerFineGrainedReportListener = null;
        POSEvaluationErrorListener pOSEvaluationErrorListener = ((CVToolParams) this.params).getMisclassified().booleanValue() ? new POSEvaluationErrorListener() : null;
        File reportOutputFile = ((CVToolParams) this.params).getReportOutputFile();
        if (reportOutputFile != null) {
            CmdLineUtil.checkOutputFile("Report Output File", reportOutputFile);
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(reportOutputFile);
                fileOutputStream = fileOutputStream2;
                pOSTaggerFineGrainedReportListener = new POSTaggerFineGrainedReportListener(fileOutputStream2);
            } catch (FileNotFoundException e) {
                throw createTerminationIOException(e);
            }
        } else {
            fileOutputStream = null;
        }
        try {
            try {
                try {
                    POSTaggerCrossValidator pOSTaggerCrossValidator = new POSTaggerCrossValidator(((CVToolParams) this.params).getLang(), this.mlParams, ((CVToolParams) this.params).getDict(), TokenNameFinderTrainerTool.openFeatureGeneratorBytes(((CVToolParams) this.params).getFeaturegen()), TokenNameFinderTrainerTool.loadResources(((CVToolParams) this.params).getResources(), ((CVToolParams) this.params).getFeaturegen()), ((CVToolParams) this.params).getTagDictCutoff(), ((CVToolParams) this.params).getFactory(), pOSEvaluationErrorListener, pOSTaggerFineGrainedReportListener);
                    pOSTaggerCrossValidator.evaluate(this.sampleStream, ((CVToolParams) this.params).getFolds().intValue());
                    Logger logger2 = logger;
                    logger2.info(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE);
                    if (pOSTaggerFineGrainedReportListener != null) {
                        logger2.info("Writing fine-grained report to {}", ((CVToolParams) this.params).getReportOutputFile().getAbsolutePath());
                        pOSTaggerFineGrainedReportListener.writeReport();
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    logger.info("Accuracy: {}", Double.valueOf(pOSTaggerCrossValidator.getWordAccuracy()));
                } catch (IOException e2) {
                    throw new TerminateToolException(-1, "IO error while reading training data or indexing data: " + e2.getMessage(), e2);
                }
            } finally {
                try {
                    this.sampleStream.close();
                } catch (IOException unused2) {
                }
            }
        } catch (IOException e3) {
            throw new TerminateToolException(-1, "IO error while loading resources", e3);
        }
    }
}
