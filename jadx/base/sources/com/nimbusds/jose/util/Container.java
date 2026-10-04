package com.nimbusds.jose.util;

import net.jcip.annotations.NotThreadSafe;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
@NotThreadSafe
public class Container<T> {
    private T item;

    public Container() {
    }

    public T get() {
        return this.item;
    }

    public void set(T t) {
        this.item = t;
    }

    public Container(T t) {
        this.item = t;
    }
}
