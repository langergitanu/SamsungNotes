package org.apache.commons.collections4.trie;

import java.util.Map;
import org.apache.commons.collections4.trie.analyzer.StringKeyAnalyzer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PatriciaTrie<V> extends AbstractPatriciaTrie<String, V> {
    private static final long serialVersionUID = 4446367780901817838L;

    public PatriciaTrie() {
        super(StringKeyAnalyzer.INSTANCE);
    }

    public PatriciaTrie(Map<? extends String, ? extends V> map) {
        super(StringKeyAnalyzer.INSTANCE, map);
    }
}
