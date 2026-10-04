package org.apache.commons.collections;

import java.util.Collection;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class HashBag extends DefaultMapBag implements Bag {
    public HashBag() {
        super(new HashMap());
    }

    public HashBag(Collection collection) {
        this();
        addAll(collection);
    }
}
