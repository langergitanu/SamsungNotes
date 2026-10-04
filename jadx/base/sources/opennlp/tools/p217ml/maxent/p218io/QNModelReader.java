package opennlp.tools.p217ml.maxent.p218io;

import java.io.File;
import opennlp.tools.p217ml.maxent.quasinewton.QNModel;
import opennlp.tools.p217ml.model.DataReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class QNModelReader extends GISModelReader {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) QNModelReader.class);

    public QNModelReader(DataReader dataReader) {
        super(dataReader);
    }

    @Override // opennlp.tools.p217ml.maxent.p218io.GISModelReader, opennlp.tools.p217ml.model.AbstractModelReader
    public void checkModelType() {
        String utf = readUTF();
        if (utf.equals("QN")) {
            return;
        }
        logger.error("Attempting to load a {} model as a MAXENT_QN model. You should expect problems.", utf);
    }

    public QNModelReader(File file) {
        super(file);
    }

    @Override // opennlp.tools.p217ml.maxent.p218io.GISModelReader, opennlp.tools.p217ml.model.AbstractModelReader
    public QNModel constructModel() {
        String[] outcomes = getOutcomes();
        int[][] outcomePatterns = getOutcomePatterns();
        return new QNModel(getParameters(outcomePatterns), getPredicates(), outcomes);
    }
}
