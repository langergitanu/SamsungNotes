package opennlp.tools.cmdline.parser;

import androidx.appcompat.widget.AbstractC0541b;
import com.samsung.android.app.sdk.deepsky.textextraction.languagepack.LangPackConfigConstants;
import com.samsung.android.support.notes.bixby.bixby2.constants.Bixby2Constants;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.menu.p155ai.drawing.common.Constant;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractTrainerTool;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.EncodingParameter;
import opennlp.tools.cmdline.params.TrainingToolParams;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.parser.AbstractBottomUpParser;
import opennlp.tools.parser.HeadRules;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.parser.ParserType;
import opennlp.tools.parser.chunking.Parser;
import opennlp.tools.parser.lang.p219en.HeadRules;
import opennlp.tools.parser.lang.p220es.AncoraSpanishHeadRules;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.ext.ExtensionLoader;
import opennlp.tools.util.model.ArtifactSerializer;
import opennlp.tools.util.model.ModelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ParserTrainerTool extends AbstractTrainerTool<Parse, TrainerToolParams> {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) ParserTrainerTool.class);

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface TrainerToolParams extends TrainingParams, TrainingToolParams, EncodingParameter {
    }

    public ParserTrainerTool() {
        super(Parse.class, TrainerToolParams.class);
    }

    public static Dictionary buildDictionary(ObjectStream<Parse> objectStream, HeadRules headRules, int i) {
        Dictionary dictionaryBuildDictionary;
        logger.info("Building dictionary ...");
        try {
            dictionaryBuildDictionary = AbstractBottomUpParser.buildDictionary(objectStream, headRules, i);
        } catch (IOException e) {
            logger.error("Error while building dictionary.", (Throwable) e);
            dictionaryBuildDictionary = null;
        }
        logger.info(Constant.DRAWING_TOOLKIT_KEY_RETURN_TYPE_DONE);
        return dictionaryBuildDictionary;
    }

    public static HeadRules createHeadRules(TrainerToolParams trainerToolParams) {
        Object objCreate = (trainerToolParams.getHeadRulesSerializerImpl() != null ? (ArtifactSerializer) ExtensionLoader.instantiateExtension(ArtifactSerializer.class, trainerToolParams.getHeadRulesSerializerImpl()) : ("en".equals(trainerToolParams.getLang()) || "eng".equals(trainerToolParams.getLang())) ? new HeadRules.HeadRulesSerializer() : (LangPackConfigConstants.LANGUAGE_CODE_ES.equals(trainerToolParams.getLang()) || "spa".equals(trainerToolParams.getLang())) ? new AncoraSpanishHeadRules.HeadRulesSerializer() : new HeadRules.HeadRulesSerializer()).create(new FileInputStream(trainerToolParams.getHeadRules()));
        if (objCreate instanceof opennlp.tools.parser.HeadRules) {
            return (opennlp.tools.parser.HeadRules) objCreate;
        }
        throw new TerminateToolException(-1, "HeadRules Artifact Serializer must create an object of type HeadRules!");
    }

    public static ParserType parseParserType(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        ParserType parserType = ParserType.parse(str);
        if (parserType != null) {
            return parserType;
        }
        throw new TerminateToolException(1, AbstractC0541b.m773o("ParserType training parameter '", str, "' is invalid!"));
    }

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Trains the learnable parser";
    }

    @Override // opennlp.tools.cmdline.AbstractEvaluatorTool, opennlp.tools.cmdline.TypedCmdLineTool
    public void run(String str, String[] strArr) {
        ParserModel parserModelTrain;
        super.run(str, strArr);
        TrainingParameters trainingParametersLoadTrainingParameters = CmdLineUtil.loadTrainingParameters(((TrainerToolParams) this.params).getParams(), true);
        this.mlParams = trainingParametersLoadTrainingParameters;
        if (trainingParametersLoadTrainingParameters != null) {
            if (!TrainerFactory.isValid(trainingParametersLoadTrainingParameters.getParameters("build"))) {
                throw new TerminateToolException(1, "Build training parameters are invalid!");
            }
            if (!TrainerFactory.isValid(this.mlParams.getParameters(Bixby2Constants.BIXBY_PARAM_CHECK))) {
                throw new TerminateToolException(1, "Check training parameters are invalid!");
            }
            if (!TrainerFactory.isValid(this.mlParams.getParameters("attach"))) {
                throw new TerminateToolException(1, "Attach training parameters are invalid!");
            }
            if (!TrainerFactory.isValid(this.mlParams.getParameters("tagger"))) {
                throw new TerminateToolException(1, "Tagger training parameters are invalid!");
            }
            if (!TrainerFactory.isValid(this.mlParams.getParameters("chunker"))) {
                throw new TerminateToolException(1, "Chunker training parameters are invalid!");
            }
        }
        if (this.mlParams == null) {
            this.mlParams = ModelUtil.createDefaultTrainingParameters();
        }
        File model = ((TrainerToolParams) this.params).getModel();
        CmdLineUtil.checkOutputFile("parser model", model);
        try {
            try {
                opennlp.tools.parser.HeadRules headRulesCreateHeadRules = createHeadRules((TrainerToolParams) this.params);
                ParserType parserType = parseParserType(((TrainerToolParams) this.params).getParserType());
                if (((TrainerToolParams) this.params).getFun().booleanValue()) {
                    Parse.useFunctionTags(true);
                }
                if (ParserType.CHUNKING.equals(parserType)) {
                    parserModelTrain = Parser.train(((TrainerToolParams) this.params).getLang(), this.sampleStream, headRulesCreateHeadRules, this.mlParams);
                } else {
                    if (!ParserType.TREEINSERT.equals(parserType)) {
                        throw new IllegalStateException();
                    }
                    parserModelTrain = opennlp.tools.parser.treeinsert.Parser.train(((TrainerToolParams) this.params).getLang(), this.sampleStream, headRulesCreateHeadRules, this.mlParams);
                }
                try {
                    this.sampleStream.close();
                } catch (IOException unused) {
                }
                CmdLineUtil.writeModel("parser", model, parserModelTrain);
            } catch (IOException e) {
                throw createTerminationIOException(e);
            }
        } catch (Throwable th) {
            try {
                this.sampleStream.close();
            } catch (IOException unused2) {
            }
            throw th;
        }
    }
}
