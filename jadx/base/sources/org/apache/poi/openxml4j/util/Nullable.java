package org.apache.poi.openxml4j.util;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class Nullable<E> {
    private E value;

    public Nullable() {
    }

    public E getValue() {
        return this.value;
    }

    public boolean hasValue() {
        return this.value != null;
    }

    public void nullify() {
        this.value = null;
    }

    public Nullable(E e) {
        this.value = e;
    }
}
