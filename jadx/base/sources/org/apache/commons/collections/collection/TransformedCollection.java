package org.apache.commons.collections.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TransformedCollection extends AbstractSerializableCollectionDecorator {
    private static final long serialVersionUID = 8692300188161871514L;
    protected final Transformer transformer;

    public TransformedCollection(Collection collection, Transformer transformer) {
        super(collection);
        if (transformer == null) {
            throw new IllegalArgumentException("Transformer must not be null");
        }
        this.transformer = transformer;
    }

    public static Collection decorate(Collection collection, Transformer transformer) {
        return new TransformedCollection(collection, transformer);
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections.Bag
    public boolean add(Object obj) {
        return getCollection().add(transform(obj));
    }

    @Override // org.apache.commons.collections.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection collection) {
        return getCollection().addAll(transform(collection));
    }

    public Object transform(Object obj) {
        return this.transformer.transform(obj);
    }

    public Collection transform(Collection collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            arrayList.add(transform(it.next()));
        }
        return arrayList;
    }
}
