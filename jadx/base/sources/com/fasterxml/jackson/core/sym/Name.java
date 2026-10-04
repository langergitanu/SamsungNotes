package com.fasterxml.jackson.core.sym;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Name {
    protected final int _hashCode;
    protected final String _name;

    public Name(String str, int i) {
        this._name = str;
        this._hashCode = i;
    }

    public abstract boolean equals(int i);

    public abstract boolean equals(int i, int i2);

    public boolean equals(Object obj) {
        return obj == this;
    }

    public abstract boolean equals(int[] iArr, int i);

    public String getName() {
        return this._name;
    }

    public final int hashCode() {
        return this._hashCode;
    }

    public String toString() {
        return this._name;
    }
}
