package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPredefinedArc extends VPredefinedBase {
    public static final String NAME = "v:arc";
    private float mEndAngle;
    private float mStartAngle;

    public float getEndAngle() {
        return this.mEndAngle;
    }

    public float getStartAngle() {
        return this.mStartAngle;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedBase
    public void setDefaultMember() {
        super.setDefaultMember();
    }

    public void setEndAngle(float f) {
        this.mEndAngle = f;
    }

    public void setStartAngle(float f) {
        this.mStartAngle = f;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedBase
    public String toString() {
        StringBuilder sb = new StringBuilder("Arc  [toString()=");
        sb.append(super.toString());
        sb.append("] [mStartAngle=");
        sb.append(this.mStartAngle);
        sb.append(", mEndAngle=");
        return AbstractC1038a.m1217r(sb, "]", this.mEndAngle);
    }

    public void setEndAngle(String str) {
        setEndAngle(VUtilString.parseFloat(str));
    }

    public void setStartAngle(String str) {
        setStartAngle(VUtilString.parseFloat(str));
    }
}
