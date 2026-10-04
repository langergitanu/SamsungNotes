package org.apache.commons.collections4.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class GrowthList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3620001881672L;

    public GrowthList() {
        super(new ArrayList());
    }

    public static <E> GrowthList<E> growthList(List<E> list) {
        return new GrowthList<>(list);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public void add(int i, E e) {
        int size = decorated().size();
        if (i > size) {
            decorated().addAll(Collections.nCopies(i - size, null));
        }
        decorated().add(i, e);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        boolean z;
        int size = decorated().size();
        if (i > size) {
            decorated().addAll(Collections.nCopies(i - size, null));
            z = true;
        } else {
            z = false;
        }
        return decorated().addAll(i, collection) || z;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E set(int i, E e) {
        int size = decorated().size();
        if (i >= size) {
            decorated().addAll(Collections.nCopies((i - size) + 1, null));
        }
        return decorated().set(i, e);
    }

    public GrowthList(int i) {
        super(new ArrayList(i));
    }

    public GrowthList(List<E> list) {
        super(list);
    }
}
