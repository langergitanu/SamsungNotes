package org.apache.commons.collections.iterators;

import org.apache.commons.collections.OrderedIterator;
import org.apache.commons.collections.ResettableIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EmptyOrderedIterator extends AbstractEmptyIterator implements OrderedIterator, ResettableIterator {
    public static final OrderedIterator INSTANCE = new EmptyOrderedIterator();
}
