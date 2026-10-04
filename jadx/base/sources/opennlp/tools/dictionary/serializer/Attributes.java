package opennlp.tools.dictionary.serializer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class Attributes {
    private final Map<String, String> mNameValueMap = new HashMap();

    public String getValue(String str) {
        return this.mNameValueMap.get(str);
    }

    public Iterator<String> iterator() {
        return this.mNameValueMap.keySet().iterator();
    }

    public void setValue(String str, String str2) {
        Objects.requireNonNull(str, "key must not be null");
        Objects.requireNonNull(str2, "value must not be null");
        this.mNameValueMap.put(str, str2);
    }
}
