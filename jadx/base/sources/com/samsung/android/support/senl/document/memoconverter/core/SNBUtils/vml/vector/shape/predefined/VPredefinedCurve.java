package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPredefinedCurve extends VPredefinedBase {
    public static final String NAME = "v:curve";
    private VCommonPoint mControl1;
    private VCommonPoint mControl2;
    private VCommonPoint mFrom;
    private VCommonPoint mTo;

    public VCommonPoint getControl1() {
        return this.mControl1;
    }

    public VCommonPoint getControl2() {
        return this.mControl2;
    }

    public VCommonPoint getFrom() {
        return this.mFrom;
    }

    public VCommonPoint getTo() {
        return this.mTo;
    }

    public void setControl1(VCommonPoint vCommonPoint) {
        this.mControl1 = vCommonPoint;
    }

    public void setControl2(VCommonPoint vCommonPoint) {
        this.mControl2 = vCommonPoint;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedBase
    public void setDefaultMember() {
        super.setDefaultMember();
        this.mFrom = new VCommonPoint();
        this.mControl1 = new VCommonPoint();
        this.mControl2 = new VCommonPoint();
        this.mTo = new VCommonPoint();
    }

    public void setFrom(VCommonPoint vCommonPoint) {
        this.mFrom = vCommonPoint;
    }

    public void setTo(VCommonPoint vCommonPoint) {
        this.mTo = vCommonPoint;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedBase
    public String toString() {
        return "Curve  [toString()=" + super.toString() + "] [mFrom=" + this.mFrom + ", mControl1=" + this.mControl1 + ", mControl2=" + this.mControl2 + ", mTo=" + this.mTo + "]";
    }

    public void setControl1(String str) {
        this.mControl1.setPoint(str);
    }

    public void setControl2(String str) {
        this.mControl2.setPoint(str);
    }

    public void setFrom(String str) {
        this.mFrom.setPoint(str);
    }

    public void setTo(String str) {
        this.mTo.setPoint(str);
    }
}
