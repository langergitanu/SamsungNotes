package com.samsung.android.support.senl.p148nt.base.composer.text.span;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
abstract class AbsBooleanSpan extends AbsSpan {
    boolean value;

    public AbsBooleanSpan(boolean z) {
        this.value = z;
    }

    public int getType() {
        return 0;
    }

    public boolean getValue() {
        return this.value;
    }

    public void setValue(boolean z) {
        this.value = z;
    }

    public void toggleValue() {
        this.value = !this.value;
    }
}
