package opennlp.tools.cmdline.tokenizer;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractTrainerTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.TrainingToolParams;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.tokenize.TokenSample;
import opennlp.tools.tokenize.TokenizerFactory;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TokenizerTrainerTool extends AbstractTrainerTool<TokenSample, TrainerToolParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TrainerToolParams extends TrainingParams, TrainingToolParams {
    }

    public TokenizerTrainerTool() {
        super(TokenSample.class, TrainerToolParams.class);
    }

    public static Dictionary loadDict(File file) {
        if (file == null) {
            return null;
        }
        CmdLineUtil.checkInputFile("abb dict", file);
        return new Dictionary(new BufferedInputStream(new FileInputStream(file)));
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Trainer for the learnable tokenizer";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        if (((TrainerToolParams) this.params).getParams() != null) {
            this.mlParams = CmdLineUtil.loadTrainingParameters(((TrainerToolParams) this.params).getParams(), false);
        } else {
            this.mlParams = TrainingParameters.setParams(strArr);
        }
        TrainingParameters trainingParameters = this.mlParams;
        if (trainingParameters != null) {
            if (!TrainerFactory.isValid(trainingParameters)) {
                throw new TerminateToolException(1, AbstractC0541b.m773o("Training parameters file '", ((TrainerToolParams) this.params).getParams(), "' is invalid!"));
            }
            if (!TrainerFactory.TrainerType.EVENT_MODEL_TRAINER.equals(TrainerFactory.getTrainerType(this.mlParams))) {
                throw new TerminateToolException(1, "Sequence training is not supported!");
            }
        }
        if (this.mlParams == null) {
            this.mlParams = ModelUtil.createDefaultTrainingParameters();
        }
        File model = ((TrainerToolParams) this.params).getModel();
        CmdLineUtil.checkOutputFile("tokenizer model", model);
        try {
            try {
                CmdLineUtil.writeModel("tokenizer", model, TokenizerME.train(this.sampleStream, TokenizerFactory.create(((TrainerToolParams) this.params).getFactory(), ((TrainerToolParams) this.params).getLang(), loadDict(((TrainerToolParams) this.params).getAbbDict()), ((TrainerToolParams) this.params).getAlphaNumOpt().booleanValue(), null), this.mlParams));
            } catch (IOException e) {
                throw createTerminationIOException(e);
            }
        } finally {
            try {
                this.sampleStream.close();
            } catch (IOException unused) {
            }
        }
    }
}
