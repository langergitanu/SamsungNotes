package opennlp.tools.cmdline.lemmatizer;

import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractTrainerTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.params.TrainingToolParams;
import opennlp.tools.lemmatizer.LemmaSample;
import opennlp.tools.lemmatizer.LemmatizerFactory;
import opennlp.tools.lemmatizer.LemmatizerME;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LemmatizerTrainerTool extends AbstractTrainerTool<LemmaSample, TrainerToolParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TrainerToolParams extends TrainingParams, TrainingToolParams {
    }

    public LemmatizerTrainerTool() {
        super(LemmaSample.class, TrainerToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getName() {
        return "LemmatizerTrainerME";
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Trainer for the learnable lemmatizer";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        TrainingParameters trainingParametersLoadTrainingParameters = CmdLineUtil.loadTrainingParameters(((TrainerToolParams) this.params).getParams(), false);
        this.mlParams = trainingParametersLoadTrainingParameters;
        if (trainingParametersLoadTrainingParameters == null) {
            this.mlParams = ModelUtil.createDefaultTrainingParameters();
        }
        File model = ((TrainerToolParams) this.params).getModel();
        CmdLineUtil.checkOutputFile("lemmatizer model", model);
        try {
            try {
                CmdLineUtil.writeModel("lemmatizer", model, LemmatizerME.train(((TrainerToolParams) this.params).getLang(), this.sampleStream, this.mlParams, LemmatizerFactory.create(((TrainerToolParams) this.params).getFactory())));
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
