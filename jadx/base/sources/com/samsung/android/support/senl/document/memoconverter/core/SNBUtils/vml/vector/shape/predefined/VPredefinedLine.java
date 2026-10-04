package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonPoint;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPredefinedLine extends VPredefinedBase {
    public static final String NAME = "v:line";
    public VCommonPoint mFrom;
    public VCommonPoint mTo;

    public VCommonPoint getFrom() {
        return this.mFrom;
    }

    public VCommonPoint getTo() {
        return this.mTo;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedBase
    public void setDefaultMember() {
        super.setDefaultMember();
        this.mFrom = new VCommonPoint();
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
        return "Line [toString()=" + super.toString() + "] [mFrom=" + this.mFrom + ", mTo=" + this.mTo + "]";
    }

    public void setFrom(String str) {
        this.mFrom.setPoint(str);
    }

    public void setTo(String str) {
        this.mTo.setPoint(str);
    }
}
