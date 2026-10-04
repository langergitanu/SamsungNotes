package org.junit.runner.manipulation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.junit.runner.Description;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class Orderer {
    private final Ordering ordering;

    public Orderer(Ordering ordering) {
        this.ordering = ordering;
    }

    public void apply(Object obj) {
        if (obj instanceof Orderable) {
            ((Orderable) obj).order(this);
        }
    }

    public List<Description> order(Collection<Description> collection) throws InvalidOrderingException {
        List<Description> listOrderItems = this.ordering.orderItems(Collections.unmodifiableCollection(collection));
        if (!this.ordering.validateOrderingIsCorrect()) {
            return listOrderItems;
        }
        HashSet hashSet = new HashSet(collection);
        if (!hashSet.containsAll(listOrderItems)) {
            throw new InvalidOrderingException("Ordering added items");
        }
        HashSet hashSet2 = new HashSet(listOrderItems);
        if (hashSet2.size() != listOrderItems.size()) {
            throw new InvalidOrderingException("Ordering duplicated items");
        }
        if (hashSet2.containsAll(hashSet)) {
            return listOrderItems;
        }
        throw new InvalidOrderingException("Ordering removed items");
    }
}
