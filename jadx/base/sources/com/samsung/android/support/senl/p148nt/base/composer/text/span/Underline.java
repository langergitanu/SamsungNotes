package com.samsung.android.support.senl.p148nt.base.composer.text.span;

import androidx.annotation.Size;
import com.samsung.android.sdk.pen.document.SpenObjectShape;
import com.samsung.android.sdk.pen.document.textspan.SpenUnderlineSpan;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class Underline extends ShapeStyleSpan {
    private static final boolean DEFAULT = false;
    public static final int STYLE_UNDERLINE = 7;

    public Underline() {
        super(false);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.ShapeStyleSpan
    public void applySPenSpan(@Size(2) int[] iArr, SpenObjectShape spenObjectShape) {
        spenObjectShape.appendTextSpan(new SpenUnderlineSpan(iArr[0], iArr[1], 3, getValue()));
    }

    public SpenUnderlineSpan getSPenSpan(@Size(2) int[] iArr) {
        return new SpenUnderlineSpan(iArr[0], iArr[1], 3, getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.ShapeStyleSpan, com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsBooleanSpan
    public int getType() {
        return 7;
    }

    public void reset() {
        setValue(false);
    }

    public Underline(boolean z) {
        super(z);
    }
}
