package opennlp.tools.cmdline.langdetect;

import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractTrainerTool;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.langdetect.LanguageDetectorFactory;
import opennlp.tools.langdetect.LanguageDetectorME;
import opennlp.tools.langdetect.LanguageSample;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LanguageDetectorTrainerTool extends AbstractTrainerTool<LanguageSample, TrainerToolParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TrainerToolParams extends TrainingParams {
        @ArgumentParser.ParameterDescription(description = "output model file.", valueName = "modelFile")
        File getModel();

        @Override // opennlp.tools.cmdline.langdetect.TrainingParams
        @ArgumentParser.OptionalParameter
        @ArgumentParser.ParameterDescription(description = "training parameters file.", valueName = "paramsFile")
        String getParams();
    }

    public LanguageDetectorTrainerTool() {
        super(LanguageSample.class, TrainerToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Trainer for the learnable language detector";
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
        CmdLineUtil.checkOutputFile("language detector model", model);
        try {
            try {
                CmdLineUtil.writeModel("language detector", model, LanguageDetectorME.train(this.sampleStream, this.mlParams, LanguageDetectorFactory.create(((TrainerToolParams) this.params).getFactory())));
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
