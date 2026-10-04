package org.apache.commons.collections.collection;

import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Predicate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PredicatedCollection extends AbstractSerializableCollectionDecorator {
    private static final long serialVersionUID = -5259182142076705162L;
    protected final Predicate predicate;

    public PredicatedCollection(Collection collection, Predicate predicate) {
        super(collection);
        if (predicate == null) {
            throw new IllegalArgumentException("Predicate must not be null");
        }
        this.predicate = predicate;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            validate(it.next());
        }
    }

    public static Collection decorate(Collection collection, Predicate predicate) {
        return new PredicatedCollection(collection, predicate);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean add(Object obj) {
        validate(obj);
        return getCollection().add(obj);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            validate(it.next());
        }
        return getCollection().addAll(collection);
    }

    public void validate(Object obj) {
        if (this.predicate.evaluate(obj)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer("Cannot add Object '");
        stringBuffer.append(obj);
        stringBuffer.append("' - Predicate rejected it");
        throw new IllegalArgumentException(stringBuffer.toString());
    }
}
