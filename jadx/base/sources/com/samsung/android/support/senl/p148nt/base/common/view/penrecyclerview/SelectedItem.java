package com.samsung.android.support.senl.p148nt.base.common.view.penrecyclerview;

import kotlin.Metadata;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(m13885d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\t¨\u0006\u0012"}, m13886d2 = {"Lcom/samsung/android/support/senl/nt/base/common/view/penrecyclerview/SelectedItem;", "", "<init>", "()V", "left", "", "getLeft", "()I", "setLeft", "(I)V", "right", "getRight", "setRight", "position", "getPosition", "setPosition", "isOverlaid", "", "ntBase_release"}, m13887k = 1, m13888mv = {2, 1, 0}, m13890xi = 48)
public final class SelectedItem {
    private int left;
    private int position;
    private int right;

    public final int getLeft() {
        return this.left;
    }

    public final int getPosition() {
        return this.position;
    }

    public final int getRight() {
        return this.right;
    }

    public final boolean isOverlaid(int left, int right) {
        int i;
        int i2;
        int i4 = this.left;
        return (left > i4 && right < this.right) || ((i = left + 1) <= i4 && i4 < right) || (i <= (i2 = this.right) && i2 < right);
    }

    public final void setLeft(int i) {
        this.left = i;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setRight(int i) {
        this.right = i;
    }
}
