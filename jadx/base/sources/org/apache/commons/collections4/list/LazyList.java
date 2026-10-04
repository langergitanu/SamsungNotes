package org.apache.commons.collections4.list;

import java.util.List;
import java.util.Objects;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class LazyList<E> extends AbstractSerializableListDecorator<E> {
    private static final long serialVersionUID = -3677737457567429713L;
    private final Factory<? extends E> factory;
    private final Transformer<Integer, ? extends E> transformer;

    public LazyList(List<E> list, Factory<? extends E> factory) {
        super(list);
        Objects.requireNonNull(factory);
        this.factory = factory;
        this.transformer = null;
    }

    private E element(int i) {
        Factory<? extends E> factory = this.factory;
        if (factory != null) {
            return factory.get();
        }
        Transformer<Integer, ? extends E> transformer = this.transformer;
        if (transformer != null) {
            return transformer.apply(Integer.valueOf(i));
        }
        throw new IllegalStateException("Factory and Transformer are both null!");
    }

    public static <E> LazyList<E> lazyList(List<E> list, Factory<? extends E> factory) {
        return new LazyList<>(list, factory);
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public E get(int i) {
        int size = decorated().size();
        if (i < size) {
            E e = decorated().get(i);
            if (e != null) {
                return e;
            }
            E eElement = element(i);
            decorated().set(i, eElement);
            return eElement;
        }
        while (size < i) {
            decorated().add(null);
            size++;
        }
        E eElement2 = element(i);
        decorated().add(eElement2);
        return eElement2;
    }

    @Override // org.apache.commons.collections4.list.AbstractListDecorator, java.util.List
    public List<E> subList(int i, int i2) {
        List<E> listSubList = decorated().subList(i, i2);
        Factory<? extends E> factory = this.factory;
        if (factory != null) {
            return new LazyList(listSubList, factory);
        }
        Transformer<Integer, ? extends E> transformer = this.transformer;
        if (transformer != null) {
            return new LazyList(listSubList, transformer);
        }
        throw new IllegalStateException("Factory and Transformer are both null!");
    }

    public static <E> LazyList<E> lazyList(List<E> list, Transformer<Integer, ? extends E> transformer) {
        return new LazyList<>(list, transformer);
    }

    public LazyList(List<E> list, Transformer<Integer, ? extends E> transformer) {
        super(list);
        this.factory = null;
        Objects.requireNonNull(transformer);
        this.transformer = transformer;
    }
}
