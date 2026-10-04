package opennlp.tools.cmdline.parser;

import androidx.appcompat.widget.AbstractC0541b;
import java.io.File;
import java.io.IOException;
import opennlp.tools.cmdline.AbstractTypedParamTool;
import opennlp.tools.cmdline.ArgumentParser;
import opennlp.tools.cmdline.CmdLineUtil;
import opennlp.tools.cmdline.ObjectStreamFactory;
import opennlp.tools.cmdline.TerminateToolException;
import opennlp.tools.cmdline.params.TrainingToolParams;
import opennlp.tools.parser.Parse;
import opennlp.tools.parser.ParserModel;
import opennlp.tools.util.ObjectStream;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
abstract class ModelUpdaterTool extends AbstractTypedParamTool<Parse, ModelUpdaterParams> {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface ModelUpdaterParams extends TrainingToolParams {
    }

    public ModelUpdaterTool() {
        super(Parse.class, ModelUpdaterParams.class);
    }

    @Override // opennlp.tools.cmdline.TypedCmdLineTool
    public final void run(String str, String[] strArr) {
        ModelUpdaterParams modelUpdaterParams = (ModelUpdaterParams) validateAndParseParams(ArgumentParser.filter(strArr, ModelUpdaterParams.class), ModelUpdaterParams.class);
        File model = modelUpdaterParams.getModel();
        ParserModel parserModelLoad = new ParserModelLoader().load(model);
        ObjectStreamFactory<Parse, ModelUpdaterParams> streamFactory = getStreamFactory(str);
        String[] strArrFilter = ArgumentParser.filter(strArr, streamFactory.getParameters());
        validateFactoryArgs(streamFactory, strArrFilter);
        try {
            ObjectStream<Parse> objectStreamCreate = streamFactory.create(strArrFilter);
            try {
                ParserModel parserModelTrainAndUpdate = trainAndUpdate(parserModelLoad, objectStreamCreate, modelUpdaterParams);
                if (objectStreamCreate != null) {
                    objectStreamCreate.close();
                }
                CmdLineUtil.writeModel("parser", model, parserModelTrainAndUpdate);
            } finally {
            }
        } catch (IOException e) {
            throw new TerminateToolException(-1, AbstractC0541b.m772n("IO error while reading training data or indexing data: ", e.getMessage()), e);
        }
    }

    public abstract ParserModel trainAndUpdate(ParserModel parserModel, ObjectStream<Parse> objectStream, ModelUpdaterParams modelUpdaterParams);
}
