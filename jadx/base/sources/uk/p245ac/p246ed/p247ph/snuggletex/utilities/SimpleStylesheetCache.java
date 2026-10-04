package uk.p245ac.p246ed.p247ph.snuggletex.utilities;

import java.util.HashMap;
import java.util.Map;
import javax.xml.transform.Templates;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class SimpleStylesheetCache implements StylesheetCache {
    private final Map<String, Templates> cacheMap = new HashMap();

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.utilities.StylesheetCache
    public Templates getStylesheet(String str) {
        return this.cacheMap.get(str);
    }

    @Override // uk.p245ac.p246ed.p247ph.snuggletex.utilities.StylesheetCache
    public void putStylesheet(String str, Templates templates) {
        this.cacheMap.put(str, templates);
    }

    public String toString() {
        return getClass().getSimpleName() + "(map=" + this.cacheMap + ")";
    }
}
