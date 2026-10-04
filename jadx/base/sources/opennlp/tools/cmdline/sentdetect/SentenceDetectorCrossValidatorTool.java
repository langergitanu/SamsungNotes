package opennlp.tools.cmdline.sentdetect;

import java.io.IOException;
import opennlp.tools.cmdline.AbstractCrossValidatorTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.params.CVParams;
import opennlp.tools.sentdetect.SDCrossValidator;
import opennlp.tools.sentdetect.SentenceDetectorFactory;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.sentdetect.SentenceSampleStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class SentenceDetectorCrossValidatorTool extends AbstractCrossValidatorTool<SentenceSample, CVToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) SentenceDetectorCrossValidatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CVToolParams extends TrainingParams, CVParams {
    }

    public SentenceDetectorCrossValidatorTool() {
        super(SentenceSample.class, CVToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "K-fold cross validator for the learnable sentence detector";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        TrainingParameters trainingParametersLoadTrainingParameters = CmdLineUtil.loadTrainingParameters(((CVToolParams) this.params).getParams(), false);
        this.mlParams = trainingParametersLoadTrainingParameters;
        if (trainingParametersLoadTrainingParameters == null) {
            this.mlParams = ModelUtil.createDefaultTrainingParameters();
        }
        try {
            try {
                SDCrossValidator sDCrossValidator = new SDCrossValidator(((CVToolParams) this.params).getLang(), this.mlParams, SentenceDetectorFactory.create(((CVToolParams) this.params).getFactory(), ((CVToolParams) this.params).getLang(), true, SentenceDetectorTrainerTool.loadDict(((CVToolParams) this.params).getAbbDict()), ((CVToolParams) this.params).getEosChars() != null ? SentenceSampleStream.replaceNewLineEscapeTags(((CVToolParams) this.params).getEosChars()).toCharArray() : null), ((CVToolParams) this.params).getMisclassified().booleanValue() ? new SentenceEvaluationErrorListener() : null);
                sDCrossValidator.evaluate(this.sampleStream, ((CVToolParams) this.params).getFolds().intValue());
                logger.info(sDCrossValidator.getFMeasure().toString());
            } finally {
                try {
                    this.sampleStream.close();
                } catch (IOException unused) {
                }
            }
        } catch (IOException e) {
            throw createTerminationIOException(e);
        }
    }
}
