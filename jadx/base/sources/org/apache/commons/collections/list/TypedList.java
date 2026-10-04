package org.apache.commons.collections.list;

import java.util.List;
import org.apache.commons.collections.functors.InstanceofPredicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TypedList {
    public static List decorate(List list, Class cls) {
        return new PredicatedList(list, InstanceofPredicate.getInstance(cls));
    }
}
