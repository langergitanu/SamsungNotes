package com.fasterxml.jackson.core.sym;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Name1 extends Name {
    static final Name1 sEmptyName = new Name1("", 0, 0);
    final int mQuad;

    public Name1(String str, int i, int i2) {
        super(str, i);
        this.mQuad = i2;
    }

    public static Name1 getEmptyName() {
        return sEmptyName;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return i == this.mQuad;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return i == this.mQuad && i2 == 0;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 1 && iArr[0] == this.mQuad;
    }
}
