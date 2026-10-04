package org.apache.commons.collections;

import java.util.ArrayList;
import java.util.EmptyStackException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class ArrayStack extends ArrayList implements Buffer {
    private static final long serialVersionUID = 2130079159931574599L;

    public ArrayStack() {
    }

    public boolean empty() {
        return isEmpty();
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        int size = size();
        if (size != 0) {
            return get(size - 1);
        }
        throw new BufferUnderflowException();
    }

    public Object peek() {
        int size = size();
        if (size > 0) {
            return get(size - 1);
        }
        throw new EmptyStackException();
    }

    public Object pop() {
        int size = size();
        if (size > 0) {
            return remove(size - 1);
        }
        throw new EmptyStackException();
    }

    public Object push(Object obj) {
        add(obj);
        return obj;
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        int size = size();
        if (size != 0) {
            return remove(size - 1);
        }
        throw new BufferUnderflowException();
    }

    public int search(Object obj) {
        int i = 1;
        int size = size() - 1;
        while (size >= 0) {
            Object obj2 = get(size);
            if ((obj == null && obj2 == null) || (obj != null && obj.equals(obj2))) {
                return i;
            }
            size--;
            i++;
        }
        return -1;
    }

    public ArrayStack(int i) {
        super(i);
    }

    public Object peek(int i) {
        int size = (size() - i) - 1;
        if (size >= 0) {
            return get(size);
        }
        throw new EmptyStackException();
    }
}
