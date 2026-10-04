package opennlp.tools.p217ml.maxent.p218io;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import opennlp.tools.p217ml.AbstractMLModelWriter;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.ComparablePredicate;
import opennlp.tools.p217ml.model.Context;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class GISModelWriter extends AbstractMLModelWriter {
    public GISModelWriter(AbstractModel abstractModel) {
        Object[] dataStructures = abstractModel.getDataStructures();
        Map map = (Map) dataStructures[1];
        this.OUTCOME_LABELS = (String[]) dataStructures[2];
        this.PARAMS = new Context[map.size()];
        this.PRED_LABELS = new String[map.size()];
        int i = 0;
        for (Map.Entry entry : map.entrySet()) {
            this.PRED_LABELS[i] = (String) entry.getKey();
            this.PARAMS[i] = (Context) entry.getValue();
            i++;
        }
    }

    @Override // opennlp.tools.p217ml.AbstractMLModelWriter, opennlp.tools.p217ml.model.AbstractModelWriter
    public void persist() {
        writeUTF("GIS");
        writeInt(1);
        writeDouble(1.0d);
        writeInt(this.OUTCOME_LABELS.length);
        for (String str : this.OUTCOME_LABELS) {
            writeUTF(str);
        }
        ComparablePredicate[] comparablePredicateArrSortValues = sortValues();
        List<List<ComparablePredicate>> listCompressOutcomes = compressOutcomes(comparablePredicateArrSortValues);
        writeInt(listCompressOutcomes.size());
        for (List<ComparablePredicate> list : listCompressOutcomes) {
            writeUTF(list.size() + list.get(0).toString());
        }
        writeInt(this.PARAMS.length);
        for (ComparablePredicate comparablePredicate : comparablePredicateArrSortValues) {
            writeUTF(comparablePredicate.name);
        }
        for (ComparablePredicate comparablePredicate2 : comparablePredicateArrSortValues) {
            int i = 0;
            while (true) {
                double[] dArr = comparablePredicate2.params;
                if (i < dArr.length) {
                    writeDouble(dArr[i]);
                    i++;
                }
            }
        }
        close();
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
