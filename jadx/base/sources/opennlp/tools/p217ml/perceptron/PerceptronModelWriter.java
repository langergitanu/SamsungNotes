package opennlp.tools.p217ml.perceptron;

import java.util.Arrays;
import java.util.Map;
import opennlp.tools.p217ml.AbstractMLModelWriter;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.ComparablePredicate;
import opennlp.tools.p217ml.model.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class PerceptronModelWriter extends AbstractMLModelWriter {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) PerceptronModelWriter.class);

    public PerceptronModelWriter(AbstractModel abstractModel) {
        Object[] dataStructures = abstractModel.getDataStructures();
        this.numOutcomes = abstractModel.getNumOutcomes();
        int i = 0;
        this.PARAMS = (Context[]) dataStructures[0];
        Map map = (Map) dataStructures[1];
        this.OUTCOME_LABELS = (String[]) dataStructures[2];
        this.PARAMS = new Context[map.size()];
        this.PRED_LABELS = new String[map.size()];
        for (Map.Entry entry : map.entrySet()) {
            this.PRED_LABELS[i] = (String) entry.getKey();
            this.PARAMS[i] = (Context) entry.getValue();
            i++;
        }
    }

    @Override // opennlp.tools.p217ml.AbstractMLModelWriter, opennlp.tools.p217ml.model.AbstractModelWriter
    public void persist() {
        writeUTF("Perceptron");
        super.persist();
    }

    @Override // opennlp.tools.p217ml.AbstractMLModelWriter
    public ComparablePredicate[] sortValues() {
        ComparablePredicate[] comparablePredicateArr = new ComparablePredicate[this.PARAMS.length];
        int i = this.numOutcomes;
        int[] iArr = new int[i];
        double[] dArr = new double[i];
        int i2 = 0;
        int i4 = 0;
        while (true) {
            Context[] contextArr = this.PARAMS;
            if (i2 >= contextArr.length) {
                logger.info("Compressed {} parameters to {}", Integer.valueOf(contextArr.length), Integer.valueOf(i4));
                ComparablePredicate[] comparablePredicateArr2 = new ComparablePredicate[i4];
                System.arraycopy(comparablePredicateArr, 0, comparablePredicateArr2, 0, i4);
                Arrays.sort(comparablePredicateArr2);
                return comparablePredicateArr2;
            }
            double[] parameters = contextArr[i2].getParameters();
            int[] outcomes = this.PARAMS[i2].getOutcomes();
            int i5 = 0;
            for (int i6 = 0; i6 < parameters.length; i6++) {
                double d = parameters[i6];
                if (d != 0.0d) {
                    iArr[i5] = outcomes[i6];
                    dArr[i5] = d;
                    i5++;
                }
            }
            int[] iArr2 = new int[i5];
            double[] dArr2 = new double[i5];
            for (int i7 = 0; i7 < i5; i7++) {
                iArr2[i7] = iArr[i7];
                dArr2[i7] = dArr[i7];
            }
            if (i5 != 0) {
                comparablePredicateArr[i4] = new ComparablePredicate(this.PRED_LABELS[i2], iArr2, dArr2);
                i4++;
            }
            i2++;
        }
    }
}
