package opennlp.tools.util.wordvector;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
class MapWordVectorTable implements WordVectorTable {
    private final Map<String, WordVector> vectors;

    public MapWordVectorTable(Map<String, WordVector> map) {
        this.vectors = map;
    }

    @Override // opennlp.tools.util.wordvector.WordVectorTable
    public int dimension() {
        if (this.vectors.size() > 0) {
            return this.vectors.values().iterator().next().dimension();
        }
        return -1;
    }

    @Override // opennlp.tools.util.wordvector.WordVectorTable
    public WordVector get(String str) {
        return this.vectors.get(str);
    }

    @Override // opennlp.tools.util.wordvector.WordVectorTable
    public int size() {
        return this.vectors.size();
    }

    @Override // opennlp.tools.util.wordvector.WordVectorTable
    public Iterator<String> tokens() {
        return this.vectors.keySet().iterator();
    }
}
