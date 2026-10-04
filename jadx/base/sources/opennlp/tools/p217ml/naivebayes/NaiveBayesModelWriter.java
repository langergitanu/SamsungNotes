package opennlp.tools.p217ml.naivebayes;

import java.util.Arrays;
import java.util.Map;
import opennlp.tools.p217ml.AbstractMLModelWriter;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.ComparablePredicate;
import opennlp.tools.p217ml.model.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class NaiveBayesModelWriter extends AbstractMLModelWriter {
    public NaiveBayesModelWriter(AbstractModel abstractModel) {
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
        writeUTF("NaiveBayes");
        super.persist();
    }

    @Override // opennlp.tools.p217ml.AbstractMLModelWriter
    public ComparablePredicate[] sortValues() {
        ComparablePredicate[] comparablePredicateArr = new ComparablePredicate[this.PARAMS.length];
        int i = 0;
        while (true) {
            Context[] contextArr = this.PARAMS;
            if (i >= contextArr.length) {
                Arrays.sort(comparablePredicateArr);
                return comparablePredicateArr;
            }
            int[] outcomes = contextArr[i].getOutcomes();
            int length = outcomes.length;
            comparablePredicateArr[i] = new ComparablePredicate(this.PRED_LABELS[i], outcomes, this.PARAMS[i].getParameters());
            i++;
        }
    }
}
