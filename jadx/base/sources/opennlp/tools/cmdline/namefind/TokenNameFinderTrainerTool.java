package opennlp.tools.cmdline.namefind;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import opennlp.tools.cmdline.AbstractTrainerTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.TrainingToolParams;
import opennlp.tools.namefind.BilouCodec;
import opennlp.tools.namefind.BioCodec;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.NameSample;
import opennlp.tools.namefind.NameSampleTypeFilter;
import opennlp.tools.namefind.TokenNameFinderFactory;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.util.InvalidFormatException;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.featuregen.GeneratorFactory;
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class TokenNameFinderTrainerTool extends AbstractTrainerTool<NameSample, TrainerToolParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TrainerToolParams extends TrainingParams, TrainingToolParams {
    }

    public TokenNameFinderTrainerTool() {
        super(NameSample.class, TrainerToolParams.class);
    }

    public static Map<String, Object> loadResources(File file, File file2) throws IOException {
        BufferedInputStream bufferedInputStream;
        HashMap map = new HashMap();
        if (file != null) {
            HashMap map2 = new HashMap();
            if (file2 != null) {
                bufferedInputStream = new BufferedInputStream(CmdLineUtil.openInFile(file2));
                try {
                    map2.putAll(GeneratorFactory.extractArtifactSerializerMappings(bufferedInputStream));
                    bufferedInputStream.close();
                } finally {
                }
            }
            for (Map.Entry entry : map2.entrySet()) {
                String str = (String) entry.getKey();
                bufferedInputStream = new BufferedInputStream(CmdLineUtil.openInFile(new File(file, str)));
                try {
                    map.put(str, ((ArtifactSerializer) entry.getValue()).create(bufferedInputStream));
                    bufferedInputStream.close();
                } finally {
                }
            }
        }
        return map;
    }

    public static byte[] openFeatureGeneratorBytes(String str) {
        if (str != null) {
            return openFeatureGeneratorBytes(new File(str));
        }
        return null;
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Trainer for the learnable name finder";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        super.run(str, strArr);
        TrainingParameters trainingParametersLoadTrainingParameters = CmdLineUtil.loadTrainingParameters(((TrainerToolParams) this.params).getParams(), true);
        this.mlParams = trainingParametersLoadTrainingParameters;
        if (trainingParametersLoadTrainingParameters == null) {
            this.mlParams = new TrainingParameters();
        }
        File model = ((TrainerToolParams) this.params).getModel();
        byte[] bArrOpenFeatureGeneratorBytes = openFeatureGeneratorBytes(((TrainerToolParams) this.params).getFeaturegen());
        try {
            Map<String, Object> mapLoadResources = loadResources(((TrainerToolParams) this.params).getResources(), ((TrainerToolParams) this.params).getFeaturegen());
            CmdLineUtil.checkOutputFile("name finder model", model);
            if (((TrainerToolParams) this.params).getNameTypes() != null) {
                this.sampleStream = new NameSampleTypeFilter(((TrainerToolParams) this.params).getNameTypes().split(","), (ObjectStream<NameSample>) this.sampleStream);
            }
            String sequenceCodec = ((TrainerToolParams) this.params).getSequenceCodec();
            if ("BIO".equals(sequenceCodec)) {
                sequenceCodec = BioCodec.class.getName();
            } else if ("BILOU".equals(sequenceCodec)) {
                sequenceCodec = BilouCodec.class.getName();
            }
            try {
                try {
                    TokenNameFinderFactory tokenNameFinderFactoryCreate = TokenNameFinderFactory.create(((TrainerToolParams) this.params).getFactory(), bArrOpenFeatureGeneratorBytes, mapLoadResources, TokenNameFinderFactory.instantiateSequenceCodec(sequenceCodec));
                    NameSampleCountersStream nameSampleCountersStream = new NameSampleCountersStream(this.sampleStream);
                    this.sampleStream = nameSampleCountersStream;
                    try {
                        try {
                            TokenNameFinderModel tokenNameFinderModelTrain = NameFinderME.train(((TrainerToolParams) this.params).getLang(), ((TrainerToolParams) this.params).getType(), this.sampleStream, this.mlParams, tokenNameFinderFactoryCreate);
                            nameSampleCountersStream.printSummary();
                            CmdLineUtil.writeModel("name finder", model, tokenNameFinderModelTrain);
                        } catch (IOException e) {
                            throw createTerminationIOException(e);
                        }
                    } finally {
                        try {
                            this.sampleStream.close();
                        } catch (IOException unused) {
                        }
                    }
                } catch (InvalidFormatException e2) {
                    throw new TerminateToolException(-1, e2.getMessage(), e2);
                }
            } catch (InvalidFormatException e3) {
                throw new TerminateToolException(-1, e3.getMessage(), e3);
            }
        } catch (IOException e5) {
            throw new TerminateToolException(-1, e5.getMessage(), e5);
        }
    }

    public static byte[] openFeatureGeneratorBytes(File file) {
        if (file == null) {
            return null;
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(CmdLineUtil.openInFile(file));
            try {
                byte[] bArr = ModelUtil.read(bufferedInputStream);
                bufferedInputStream.close();
                return bArr;
            } finally {
            }
        } catch (IOException e) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while reading training data or indexing data: ", e.getMessage()), e);
        }
    }
}
