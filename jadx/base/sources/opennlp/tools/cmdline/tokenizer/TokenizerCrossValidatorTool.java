package opennlp.tools.cmdline.tokenizer;

import java.io.IOException;
import opennlp.tools.cmdline.AbstractCrossValidatorTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.params.CVParams;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.tokenize.TokenizerCrossValidator;
import opennlp.tools.tokenize.TokenizerFactory;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TokenizerCrossValidatorTool extends AbstractCrossValidatorTool<TokenSample, CVToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) TokenizerCrossValidatorTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface CVToolParams extends CVParams, TrainingParams {
    }

    public TokenizerCrossValidatorTool() {
        super(TokenSample.class, CVToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "K-fold cross validator for the learnable tokenizer";
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
                TokenizerCrossValidator tokenizerCrossValidator = new TokenizerCrossValidator(this.mlParams, TokenizerFactory.create(((CVToolParams) this.params).getFactory(), ((CVToolParams) this.params).getLang(), TokenizerTrainerTool.loadDict(((CVToolParams) this.params).getAbbDict()), ((CVToolParams) this.params).getAlphaNumOpt().booleanValue(), null), ((CVToolParams) this.params).getMisclassified().booleanValue() ? new TokenEvaluationErrorListener() : null);
                tokenizerCrossValidator.evaluate(this.sampleStream, ((CVToolParams) this.params).getFolds().intValue());
                logger.info(tokenizerCrossValidator.getFMeasure().toString());
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
