package org.apache.commons.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public interface Bag extends Collection {
    @Override // java.util.Collection
    boolean add(Object obj);

    boolean add(Object obj, int i);

    @Override // java.util.Collection
    boolean containsAll(Collection collection);

    int getCount(Object obj);

    @Override // java.util.Collection, java.lang.Iterable
    Iterator iterator();

    @Override // java.util.Collection
    boolean remove(Object obj);

    boolean remove(Object obj, int i);

    @Override // java.util.Collection
    boolean removeAll(Collection collection);

    @Override // java.util.Collection
    boolean retainAll(Collection collection);

    @Override // java.util.Collection
    int size();

    Set uniqueSet();
}
