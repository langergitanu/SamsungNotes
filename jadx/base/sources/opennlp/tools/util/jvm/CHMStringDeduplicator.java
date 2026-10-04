package opennlp.tools.util.jvm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import opennlp.tools.commons.Internal;
import opennlp.tools.commons.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
@ThreadSafe
class CHMStringDeduplicator implements StringInterner {
    private final Map<String, String> map;
    private final int prob;

    public CHMStringDeduplicator() {
        this(0.5d);
    }

    @Override // opennlp.tools.util.jvm.StringInterner
    public String intern(String str) {
        String strPutIfAbsent;
        return (ThreadLocalRandom.current().nextInt() <= this.prob && (strPutIfAbsent = this.map.putIfAbsent(str, str)) != null) ? strPutIfAbsent : str;
    }

    public CHMStringDeduplicator(double d) {
        this.prob = (int) ((d * 4.294967296E9d) - 2.147483648E9d);
        this.map = new ConcurrentHashMap();
    }
}
