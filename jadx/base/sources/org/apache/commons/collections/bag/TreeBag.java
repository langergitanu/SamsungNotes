package org.apache.commons.collections.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections.SortedBag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TreeBag extends AbstractMapBag implements SortedBag, Serializable {
    private static final long serialVersionUID = -7740146511091606676L;

    public TreeBag() {
        super(new TreeMap());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        super.doReadObject(new TreeMap((Comparator) objectInputStream.readObject()), objectInputStream);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(comparator());
        super.doWriteObject(objectOutputStream);
    }

    @Override // org.apache.commons.collections.SortedBag
    public Comparator comparator() {
        return ((SortedMap) getMap()).comparator();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object first() {
        return ((SortedMap) getMap()).firstKey();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object last() {
        return ((SortedMap) getMap()).lastKey();
    }

    public TreeBag(Comparator comparator) {
        super(new TreeMap(comparator));
    }

    public TreeBag(Collection collection) {
        this();
        addAll(collection);
    }
}
