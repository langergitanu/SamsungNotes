package com.samsung.android.support.senl.p148nt.base.composer.text.span;

import androidx.annotation.Size;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenBoldSpan;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class Bold extends ShapeStyleSpan {
    private static final boolean DEFAULT = false;
    public static final int STYLE_BOLD = 5;

    public Bold() {
        super(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.ShapeStyleSpan
    public void applySPenSpan(@Size(2) int[] iArr, SpenObjectShape spenObjectShape) {
        spenObjectShape.appendTextSpan(new SpenBoldSpan(iArr[0], iArr[1], 3, getValue()));
    }

    public SpenBoldSpan getSPenSpan(@Size(2) int[] iArr) {
        return new SpenBoldSpan(iArr[0], iArr[1], 3, getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.ShapeStyleSpan, com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsBooleanSpan
    public int getType() {
        return 5;
    }

    public void reset() {
        setValue(false);
    }

    public Bold(boolean z) {
        super(z);
    }
}
