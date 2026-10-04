package com.samsung.android.support.senl.p148nt.base.composer.text.span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbsIntegerSpan extends AbsSpan {
    int value;

    public AbsIntegerSpan(int i) {
        this.value = i;
    }

    public int getType() {
        return 0;
    }

    public int getValue() {
        return this.value;
    }

    public void setValue(int i) {
        this.value = i;
    }
}
