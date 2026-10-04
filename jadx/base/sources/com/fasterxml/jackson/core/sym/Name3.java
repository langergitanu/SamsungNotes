package com.fasterxml.jackson.core.sym;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Name3 extends Name {
    final int mQuad1;
    final int mQuad2;
    final int mQuad3;

    public Name3(String str, int i, int i2, int i4, int i5) {
        super(str, i);
        this.mQuad1 = i2;
        this.mQuad2 = i4;
        this.mQuad3 = i5;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 3 && iArr[0] == this.mQuad1 && iArr[1] == this.mQuad2 && iArr[2] == this.mQuad3;
    }
}
