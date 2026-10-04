package org.apache.commons.collections4.bag;

import androidx.glance.AbstractC2821a;
import com.samsung.android.support.senl.ntnl.coedit.constants.CoeditServiceConstants;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections4.SortedBag;
import org.apache.commons.collections4.bag.AbstractMapBag;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class TreeBag<E> extends AbstractMapBag<E> implements SortedBag<E>, Serializable {
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

    @Override // org.apache.commons.collections4.bag.AbstractMapBag, org.apache.commons.collections4.Bag, java.util.Collection
    public boolean add(E e) {
        if (comparator() != null || (e instanceof Comparable)) {
            return super.add(e);
        }
        Objects.requireNonNull(e, CoeditServiceConstants.Element.NAME_OBJECT);
        throw new IllegalArgumentException(AbstractC2821a.m2222m(new StringBuilder("Objects of type "), e, " cannot be added to a naturally ordered TreeBag as it does not implement Comparable"));
    }

    @Override // org.apache.commons.collections4.SortedBag
    public Comparator<? super E> comparator() {
        return getMap().comparator();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E first() {
        return getMap().firstKey();
    }

    @Override // org.apache.commons.collections4.SortedBag
    public E last() {
        return getMap().lastKey();
    }

    public TreeBag(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    @Override // org.apache.commons.collections4.bag.AbstractMapBag
    public SortedMap<E, AbstractMapBag.MutableInteger> getMap() {
        return (SortedMap) super.getMap();
    }

    public TreeBag(Comparator<? super E> comparator) {
        super(new TreeMap(comparator));
    }

    public TreeBag(Iterable<? extends E> iterable) {
        super(new TreeMap(), iterable);
    }
}
