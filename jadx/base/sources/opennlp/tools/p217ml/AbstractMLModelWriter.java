package opennlp.tools.p217ml;

import java.util.ArrayList;
import java.util.List;
import opennlp.tools.p217ml.model.AbstractModelWriter;
import opennlp.tools.p217ml.model.ComparablePredicate;
import opennlp.tools.p217ml.model.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public abstract class AbstractMLModelWriter extends AbstractModelWriter {
    private static final Logger logger = LoggerFactory.getLogger((Class<?>) AbstractMLModelWriter.class);
    protected String[] OUTCOME_LABELS;
    protected Context[] PARAMS;
    protected String[] PRED_LABELS;
    protected int numOutcomes;

    public List<List<ComparablePredicate>> compressOutcomes(ComparablePredicate[] comparablePredicateArr) {
        ArrayList arrayList = new ArrayList();
        if (comparablePredicateArr.length > 0) {
            ComparablePredicate comparablePredicate = comparablePredicateArr[0];
            ArrayList arrayList2 = new ArrayList();
            for (ComparablePredicate comparablePredicate2 : comparablePredicateArr) {
                if (comparablePredicate.compareTo(comparablePredicate2) == 0) {
                    arrayList2.add(comparablePredicate2);
                } else {
                    arrayList.add(arrayList2);
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.add(comparablePredicate2);
                    arrayList2 = arrayList3;
                    comparablePredicate = comparablePredicate2;
                }
            }
            arrayList.add(arrayList2);
        }
        return arrayList;
    }

    public List<List<ComparablePredicate>> computeOutcomePatterns(ComparablePredicate[] comparablePredicateArr) {
        ComparablePredicate comparablePredicate = comparablePredicateArr[0];
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ComparablePredicate comparablePredicate2 : comparablePredicateArr) {
            if (comparablePredicate.compareTo(comparablePredicate2) == 0) {
                arrayList2.add(comparablePredicate2);
            } else {
                arrayList.add(arrayList2);
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(comparablePredicate2);
                arrayList2 = arrayList3;
                comparablePredicate = comparablePredicate2;
            }
        }
        arrayList.add(arrayList2);
        logger.info("{} outcome patterns", Integer.valueOf(arrayList.size()));
        return arrayList;
    }

    @Override // opennlp.tools.p217ml.model.AbstractModelWriter
    public void persist() {
        writeInt(this.OUTCOME_LABELS.length);
        for (String str : this.OUTCOME_LABELS) {
            writeUTF(str);
        }
        ComparablePredicate[] comparablePredicateArrSortValues = sortValues();
        List<List<ComparablePredicate>> listComputeOutcomePatterns = computeOutcomePatterns(comparablePredicateArrSortValues);
        writeInt(listComputeOutcomePatterns.size());
        for (List<ComparablePredicate> list : listComputeOutcomePatterns) {
            writeUTF(list.size() + list.get(0).toString());
        }
        writeInt(comparablePredicateArrSortValues.length);
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

    public abstract ComparablePredicate[] sortValues();
}
