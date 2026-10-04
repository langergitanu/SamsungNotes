package opennlp.tools.cmdline.parser;

import opennlp.tools.cmdline.parser.ModelUpdaterTool;
import opennlp.tools.dictionary.Dictionary;
import opennlp.tools.p217ml.TrainerFactory;
import opennlp.tools.p217ml.model.MaxentModel;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.ParserEventTypeEnum;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.parser.chunking.ParserEventStream;
import opennlp.tools.util.ObjectStream;
import opennlp.tools.util.model.ModelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class CheckModelUpdaterTool extends ModelUpdaterTool {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) CheckModelUpdaterTool.class);

    @Override // opennlp.tools.cmdline.CmdLineTool
    public String getShortDescription() {
        return "Trains and updates the check model in a parser model";
    }

    @Override // opennlp.tools.cmdline.parser.ModelUpdaterTool
    public ParserModel trainAndUpdate(ParserModel parserModel, ObjectStream<Parse> objectStream, ModelUpdaterTool.ModelUpdaterParams modelUpdaterParams) {
        Dictionary dictionaryBuildDictionary = ParserTrainerTool.buildDictionary(objectStream, parserModel.getHeadRules(), 5);
        objectStream.reset();
        logger.info("Training check model");
        MaxentModel maxentModelTrain = TrainerFactory.getEventTrainer(ModelUtil.createDefaultTrainingParameters(), null).train(new ParserEventStream(objectStream, parserModel.getHeadRules(), ParserEventTypeEnum.CHECK, dictionaryBuildDictionary));
        objectStream.close();
        return parserModel.updateCheckModel(maxentModelTrain);
    }
}
