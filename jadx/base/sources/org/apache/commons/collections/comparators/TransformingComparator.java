package org.apache.commons.collections.comparators;

import java.util.Comparator;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformingComparator implements Comparator {
    protected Comparator decorated;
    protected Transformer transformer;

    public TransformingComparator(Transformer transformer) {
        this(transformer, new ComparableComparator());
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.decorated.compare(this.transformer.transform(obj), this.transformer.transform(obj2));
    }

    public TransformingComparator(Transformer transformer, Comparator comparator) {
        this.decorated = comparator;
        this.transformer = transformer;
    }
}
