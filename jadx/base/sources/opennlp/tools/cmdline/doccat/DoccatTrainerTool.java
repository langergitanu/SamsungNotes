package opennlp.tools.cmdline.doccat;

import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractTrainerTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.params.TrainingToolParams;
import opennlp.tools.doccat.BagOfWordsFeatureGenerator;
import opennlp.tools.doccat.DoccatFactory;
import opennlp.tools.doccat.DocumentCategorizerME;
import opennlp.tools.doccat.DocumentSample;
import opennlp.tools.doccat.FeatureGenerator;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.ext.ExtensionLoader;
import opennlp.tools.util.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DoccatTrainerTool extends AbstractTrainerTool<DocumentSample, TrainerToolParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TrainerToolParams extends TrainingParams, TrainingToolParams {
    }

    public DoccatTrainerTool() {
        super(DocumentSample.class, TrainerToolParams.class);
    }

    public static FeatureGenerator[] createFeatureGenerators(String str) {
        if (str == null) {
            return new FeatureGenerator[]{new BagOfWordsFeatureGenerator()};
        }
        String[] strArrSplit = str.split(",");
        int length = strArrSplit.length;
        FeatureGenerator[] featureGeneratorArr = new FeatureGenerator[length];
        for (int i = 0; i < length; i++) {
            featureGeneratorArr[i] = (FeatureGenerator) ExtensionLoader.instantiateExtension(FeatureGenerator.class, strArrSplit[i]);
        }
        return featureGeneratorArr;
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Trainer for the learnable document categorizer";
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
        CmdLineUtil.checkOutputFile("document categorizer model", model);
        try {
            try {
                CmdLineUtil.writeModel("document categorizer", model, DocumentCategorizerME.train(((TrainerToolParams) this.params).getLang(), this.sampleStream, this.mlParams, DoccatFactory.create(((TrainerToolParams) this.params).getFactory(), createFeatureGenerators(((TrainerToolParams) this.params).getFeatureGenerators()))));
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
