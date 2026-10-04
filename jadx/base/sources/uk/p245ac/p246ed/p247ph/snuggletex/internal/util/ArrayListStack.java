package uk.p245ac.p246ed.p247ph.snuggletex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.EmptyStackException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public class ArrayListStack<E> extends ArrayList<E> {
    private static final long serialVersionUID = -4103564522108783429L;

    public ArrayListStack() {
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return get(size() - 1);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return remove(size() - 1);
    }

    public E push(E e) {
        super.add(e);
        return e;
    }

    public int search(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return -1;
        }
        return iIndexOf + 1;
    }

    public ArrayListStack(Collection<? extends E> collection) {
        super(collection);
    }

    public ArrayListStack(int i) {
        super(i);
    }
}
