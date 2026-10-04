package opennlp.tools.cmdline.sentdetect;

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
import opennlp.tools.sentdetect.SentenceDetectorFactory;
import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceSample;
import opennlp.tools.sentdetect.SentenceSampleStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class SentenceDetectorTrainerTool extends AbstractTrainerTool<SentenceSample, TrainerToolParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TrainerToolParams extends TrainingParams, TrainingToolParams {
    }

    public SentenceDetectorTrainerTool() {
        super(SentenceSample.class, TrainerToolParams.class);
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
        return "Trainer for the learnable sentence detector";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        TrainingParameters trainingParametersLoadTrainingParameters = CmdLineUtil.loadTrainingParameters(((TrainerToolParams) this.params).getParams(), false);
        this.mlParams = trainingParametersLoadTrainingParameters;
        if (trainingParametersLoadTrainingParameters != null && !TrainerFactory.TrainerType.EVENT_MODEL_TRAINER.equals(TrainerFactory.getTrainerType(trainingParametersLoadTrainingParameters))) {
            throw new TerminateToolException(1, "Sequence training is not supported!");
        }
        if (this.mlParams == null) {
            this.mlParams = ModelUtil.createDefaultTrainingParameters();
        }
        File model = ((TrainerToolParams) this.params).getModel();
        CmdLineUtil.checkOutputFile("sentence detector model", model);
        try {
            try {
                CmdLineUtil.writeModel("sentence detector", model, SentenceDetectorME.train(((TrainerToolParams) this.params).getLang(), this.sampleStream, SentenceDetectorFactory.create(((TrainerToolParams) this.params).getFactory(), ((TrainerToolParams) this.params).getLang(), true, loadDict(((TrainerToolParams) this.params).getAbbDict()), ((TrainerToolParams) this.params).getEosChars() != null ? SentenceSampleStream.replaceNewLineEscapeTags(((TrainerToolParams) this.params).getEosChars()).toCharArray() : null), this.mlParams));
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
