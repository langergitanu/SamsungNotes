package opennlp.tools.dictionary;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import opennlp.tools.util.StringList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Index {
    private final Set<String> tokens = new HashSet();

    public Index(Iterator<StringList> it) {
        while (it.hasNext()) {
            StringList next = it.next();
            for (int i = 0; i < next.size(); i++) {
                this.tokens.add(next.getToken(i));
            }
        }
    }

    public boolean contains(String str) {
        return this.tokens.contains(str);
    }
}
