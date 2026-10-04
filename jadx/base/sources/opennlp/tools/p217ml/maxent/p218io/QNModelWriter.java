package opennlp.tools.p217ml.maxent.p218io;

import java.util.List;
import opennlp.tools.p217ml.model.AbstractModel;
import opennlp.tools.p217ml.model.ComparablePredicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class QNModelWriter extends GISModelWriter {
    public QNModelWriter(AbstractModel abstractModel) {
        super(abstractModel);
    }

    @Override // opennlp.tools.p217ml.maxent.p218io.GISModelWriter, opennlp.tools.p217ml.AbstractMLModelWriter, opennlp.tools.p217ml.model.AbstractModelWriter
    public void persist() {
        writeUTF("QN");
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
}
