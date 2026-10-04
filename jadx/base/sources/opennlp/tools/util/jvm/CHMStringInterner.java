package opennlp.tools.util.jvm;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import opennlp.tools.commons.Internal;
import opennlp.tools.commons.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
@ThreadSafe
class CHMStringInterner implements StringInterner {
    private final Map<String, String> map = new ConcurrentHashMap();

    @Override // opennlp.tools.util.jvm.StringInterner
    public String intern(String str) {
        String strPutIfAbsent = this.map.putIfAbsent(str, str);
        return strPutIfAbsent == null ? str : strPutIfAbsent;
    }
}
