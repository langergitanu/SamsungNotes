package opennlp.tools.p217ml.naivebayes;

import java.io.File;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.AbstractModelReader;
import opennlp.tools.p217ml.model.DataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class NaiveBayesModelReader extends AbstractModelReader {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) NaiveBayesModelReader.class);

    public NaiveBayesModelReader(File file) {
        super(file);
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelReader
    public void checkModelType() {
        String utf = readUTF();
        if (utf.equals("NaiveBayes")) {
            return;
        }
        logger.error("Attempting to load a {} model as a NaiveBayes model. You should expect problems.", utf);
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelReader
    public AbstractModel constructModel() {
        String[] outcomes = getOutcomes();
        int[][] outcomePatterns = getOutcomePatterns();
        return new NaiveBayesModel(getParameters(outcomePatterns), getPredicates(), outcomes);
    }

    public NaiveBayesModelReader(DataReader dataReader) {
        super(dataReader);
    }
}
