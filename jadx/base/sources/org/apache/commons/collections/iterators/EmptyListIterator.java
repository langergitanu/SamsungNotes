package org.apache.commons.collections.iterators;

import java.util.ListIterator;
import org.apache.commons.collections.ResettableListIterator;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class EmptyListIterator extends AbstractEmptyIterator implements ResettableListIterator {
    public static final ListIterator INSTANCE;
    public static final ResettableListIterator RESETTABLE_INSTANCE;

    static {
        EmptyListIterator emptyListIterator = new EmptyListIterator();
        RESETTABLE_INSTANCE = emptyListIterator;
        INSTANCE = emptyListIterator;
    }
}
