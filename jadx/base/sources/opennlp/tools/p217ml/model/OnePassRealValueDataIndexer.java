package opennlp.tools.p217ml.model;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class OnePassRealValueDataIndexer extends OnePassDataIndexer {
    private float[][] values;

    @Override // opennlp.tools.p217ml.model.AbstractDataIndexer, opennlp.tools.p217ml.model.DataIndexer
    public float[][] getValues() {
        return this.values;
    }

    @Override // opennlp.tools.p217ml.model.AbstractDataIndexer
    public int sortAndMerge(List<ComparableEvent> list, boolean z) {
        int iSortAndMerge = super.sortAndMerge(list, z);
        this.values = new float[iSortAndMerge][];
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            ComparableEvent comparableEvent = list.get(i2);
            if (comparableEvent != null) {
                this.values[i] = comparableEvent.values;
                i++;
            }
        }
        return iSortAndMerge;
    }
}
