package com.samsung.android.support.senl.p148nt.base.composer.text.span;

import androidx.annotation.Size;
import com.samsung.android.sdk.pen.document.textspan.SpenForegroundColorSpan;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class FontColor extends AbsIntegerSpan {
    private int defaultColor;

    public FontColor(int i) {
        super(i);
        this.defaultColor = i;
    }

    public int getDefaultValue() {
        return this.defaultColor;
    }

    public SpenForegroundColorSpan getSPenSpan(@Size(2) int[] iArr) {
        return new SpenForegroundColorSpan(iArr[0], iArr[1], 3, getValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ int getType() {
        return super.getType();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ int getValue() {
        return super.getValue();
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsSpan
    public /* bridge */ /* synthetic */ boolean isEnable() {
        return super.isEnable();
    }

    public void reset() {
        setValue(getDefaultValue());
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsSpan
    public /* bridge */ /* synthetic */ void setEnable(boolean z) {
        super.setEnable(z);
    }

    @Override // com.samsung.android.support.senl.p148nt.base.composer.text.span.AbsIntegerSpan
    public /* bridge */ /* synthetic */ void setValue(int i) {
        super.setValue(i);
    }
}
