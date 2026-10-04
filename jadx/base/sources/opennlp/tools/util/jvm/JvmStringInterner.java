package opennlp.tools.util.jvm;

import opennlp.tools.commons.Internal;
import opennlp.tools.commons.ThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
@Internal
@ThreadSafe
class JvmStringInterner implements StringInterner {
    @Override // opennlp.tools.util.jvm.StringInterner
    public String intern(String str) {
        return str.intern();
    }
}
