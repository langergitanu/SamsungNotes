package opennlp.tools.util;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Cache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 3037039043085908062L;
    private final int capacity;

    public Cache(int i) {
        this.capacity = i;
    }

    @Override // java.util.LinkedHashMap
    public boolean removeEldestEntry(Map.Entry<K, V> entry) {
        return size() > this.capacity;
    }
}
