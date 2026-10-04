package com.opencsv.bean.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class OrderedObject<E> {
    private final E element;
    private final long ordinal;

    public OrderedObject(long j, E e) {
        this.ordinal = j;
        this.element = e;
    }

    public E getElement() {
        return this.element;
    }

    public long getOrdinal() {
        return this.ordinal;
    }
}
