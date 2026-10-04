package opennlp.tools.cmdline.postag;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import opennlp.tools.cmdline.AbstractTrainerTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.namefind.TokenNameFinderTrainerTool;
import opennlp.tools.cmdline.params.TrainingToolParams;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.postag.MutableTagDictionary;
import opennlp.tools.postag.POSSample;
import opennlp.tools.postag.POSTaggerFactory;
import opennlp.tools.postag.POSTaggerME;
import opennlp.tools.postag.TagDictionary;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class POSTaggerTrainerTool extends AbstractTrainerTool<POSSample, TrainerToolParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TrainerToolParams extends TrainingParams, TrainingToolParams {
    }

    public POSTaggerTrainerTool() {
        super(POSSample.class, TrainerToolParams.class);
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Trains a model for the part-of-speech tagger";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        TrainingParameters trainingParametersLoadTrainingParameters = CmdLineUtil.loadTrainingParameters(((TrainerToolParams) this.params).getParams(), true);
        this.mlParams = trainingParametersLoadTrainingParameters;
        if (trainingParametersLoadTrainingParameters != null && !TrainerFactory.isValid(trainingParametersLoadTrainingParameters)) {
            throw new TerminateToolException(1, AbstractC0541b.m773o("Training parameters file '", ((TrainerToolParams) this.params).getParams(), "' is invalid!"));
        }
        if (this.mlParams == null) {
            this.mlParams = ModelUtil.createDefaultTrainingParameters();
        }
        File model = ((TrainerToolParams) this.params).getModel();
        CmdLineUtil.checkOutputFile("pos tagger model", model);
        try {
            Map<String, Object> mapLoadResources = TokenNameFinderTrainerTool.loadResources(((TrainerToolParams) this.params).getResources(), ((TrainerToolParams) this.params).getFeaturegen());
            try {
                POSTaggerFactory pOSTaggerFactoryCreate = POSTaggerFactory.create(((TrainerToolParams) this.params).getFactory(), TokenNameFinderTrainerTool.openFeatureGeneratorBytes(((TrainerToolParams) this.params).getFeaturegen()), mapLoadResources, null);
                if (((TrainerToolParams) this.params).getDict() != null) {
                    try {
                        pOSTaggerFactoryCreate.setTagDictionary(pOSTaggerFactoryCreate.createTagDictionary(((TrainerToolParams) this.params).getDict()));
                    } catch (IOException e) {
                        throw new TerminateToolException(-1, "IO error while loading POS Dictionary", e);
                    }
                }
                if (((TrainerToolParams) this.params).getTagDictCutoff() != null) {
                    try {
                        TagDictionary tagDictionary = pOSTaggerFactoryCreate.getTagDictionary();
                        if (tagDictionary == null) {
                            tagDictionary = pOSTaggerFactoryCreate.createEmptyTagDictionary();
                            pOSTaggerFactoryCreate.setTagDictionary(tagDictionary);
                        }
                        if (!(tagDictionary instanceof MutableTagDictionary)) {
                            throw new IllegalArgumentException("Can't extend a POSDictionary that does not implement MutableTagDictionary.");
                        }
                        POSTaggerME.populatePOSDictionary(this.sampleStream, (MutableTagDictionary) tagDictionary, ((TrainerToolParams) this.params).getTagDictCutoff().intValue());
                        this.sampleStream.reset();
                    } catch (IOException e2) {
                        throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while creating/extending POS Dictionary: ", e2.getMessage()), e2);
                    }
                }
                try {
                    try {
                        CmdLineUtil.writeModel("pos tagger", model, POSTaggerME.train(((TrainerToolParams) this.params).getLang(), this.sampleStream, this.mlParams, pOSTaggerFactoryCreate));
                    } catch (IOException e3) {
                        throw createTerminationIOException(e3);
                    }
                } finally {
                    try {
                        this.sampleStream.close();
                    } catch (IOException unused) {
                    }
                }
            } catch (InvalidFormatException e5) {
                throw new TerminateToolException(-1, e5.getMessage(), e5);
            }
        } catch (IOException e6) {
            throw new TerminateToolException(-1, "IO error while loading resources", e6);
        }
    }
}
