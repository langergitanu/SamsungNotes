package org.apache.commons.collections.set;

import java.util.Set;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.collection.TransformedCollection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformedSet extends TransformedCollection implements Set {
    private static final long serialVersionUID = 306127383500410386L;

    public TransformedSet(Set set, Transformer transformer) {
        super(set, transformer);
    }

    public static Set decorate(Set set, Transformer transformer) {
        return new TransformedSet(set, transformer);
    }
}
