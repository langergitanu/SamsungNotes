package opennlp.tools.p217ml.model;

import java.util.HashMap;
import java.util.Map;
import opennlp.tools.p217ml.AbstractEventTrainer;
import opennlp.tools.util.TrainingParameters;
import opennlp.tools.util.ext.ExtensionLoader;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DataIndexerFactory {
    public static DataIndexer getDataIndexer(TrainingParameters trainingParameters, Map<String, String> map) {
        String stringParameter;
        DataIndexer onePassRealValueDataIndexer;
        stringParameter = trainingParameters.getStringParameter(AbstractEventTrainer.DATA_INDEXER_PARAM, AbstractEventTrainer.DATA_INDEXER_TWO_PASS_VALUE);
        if (map == null) {
            map = new HashMap<>();
        }
        stringParameter.getClass();
        switch (stringParameter) {
            case "OnePassRealValue":
                onePassRealValueDataIndexer = new OnePassRealValueDataIndexer();
                break;
            case "OnePass":
                onePassRealValueDataIndexer = new OnePassDataIndexer();
                break;
            case "TwoPass":
                onePassRealValueDataIndexer = new TwoPassDataIndexer();
                break;
            default:
                onePassRealValueDataIndexer = (DataIndexer) ExtensionLoader.instantiateExtension(DataIndexer.class, stringParameter);
                break;
        }
        onePassRealValueDataIndexer.init(trainingParameters, map);
        return onePassRealValueDataIndexer;
    }
}
