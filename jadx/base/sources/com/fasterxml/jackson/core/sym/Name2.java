package com.fasterxml.jackson.core.sym;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final class Name2 extends Name {
    final int mQuad1;
    final int mQuad2;

    public Name2(String str, int i, int i2, int i4) {
        super(str, i);
        this.mQuad1 = i2;
        this.mQuad2 = i4;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i, int i2) {
        return i == this.mQuad1 && i2 == this.mQuad2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i) {
        return i == 2 && iArr[0] == this.mQuad1 && iArr[1] == this.mQuad2;
    }
}
