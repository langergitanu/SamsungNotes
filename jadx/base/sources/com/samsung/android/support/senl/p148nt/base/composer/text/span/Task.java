package com.samsung.android.support.senl.p148nt.base.composer.text.span;

import androidx.annotation.Size;
import com.samsung.android.sdk.pen.document.textspan.SpenBulletParagraph;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class Task extends AbsIntegerSpan {
    public static final int TASK_BULLET = 8;
    public static final int TASK_NONE = 0;
    public static final int TASK_NUMBERING = 4;
    public static final int TASK_TODO = 2;

    public Task() {
        super(0);
    }

    public SpenBulletParagraph getSPenSpan(@Size(2) int[] iArr) {
        return new SpenBulletParagraph(iArr[0], iArr[1], getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public int getType() {
        return getValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ int getValue() {
        return super.getValue();
    }

    public boolean isBullet() {
        return 8 == getValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsSpan
    public /* bridge */ /* synthetic */ boolean isEnable() {
        return super.isEnable();
    }

    public boolean isNumbering() {
        return 4 == getValue();
    }

    public boolean isTodo() {
        return 2 == getValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsSpan
    public /* bridge */ /* synthetic */ void setEnable(boolean z) {
        super.setEnable(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ void setValue(int i) {
        super.setValue(i);
    }

    public Task(int i) {
        super(i);
    }
}
