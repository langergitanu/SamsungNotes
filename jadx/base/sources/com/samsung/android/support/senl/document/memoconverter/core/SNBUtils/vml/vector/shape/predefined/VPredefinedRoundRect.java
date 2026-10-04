package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPredefinedRoundRect extends VPredefinedBase {
    public static final String NAME = "v:roundrect";
    private float mArcSize = 0.2f;
    private char mArcUnit;

    public float getArcSize() {
        return this.mArcSize;
    }

    public char getArcUnit() {
        return this.mArcUnit;
    }

    public void setArcSize(String str) {
        this.mArcUnit = AbstractC0000a.m4a(1, str);
        setArcSize(VUtilString.parseFloat(str));
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedBase
    public void setDefaultMember() {
        super.setDefaultMember();
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedBase
    public String toString() {
        return AbstractC0622a.m1170p(super.toString(), "]", new StringBuilder("RoundRect [toString()="));
    }

    public void setArcSize(float f) {
        this.mArcSize = f;
    }
}
