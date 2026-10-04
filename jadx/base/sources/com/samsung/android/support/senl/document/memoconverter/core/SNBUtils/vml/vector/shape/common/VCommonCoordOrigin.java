package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VCommonCoordOrigin {
    private static final float defaultOrigin = 0.0f;
    private float mSx;
    private float mSy;

    public VCommonCoordOrigin() {
        this.mSx = 0.0f;
        this.mSy = 0.0f;
    }

    public float getSx() {
        return this.mSx;
    }

    public float getSy() {
        return this.mSy;
    }

    public void setCoordOrigin(String str) {
        if (str == null) {
            return;
        }
        if (Pattern.compile(".*[,]*").matcher(str).matches()) {
            String[] strArrSplit = str.split(",");
            setSx(VUtilString.parseFloat(strArrSplit[0]));
            setSy(VUtilString.parseFloat(strArrSplit[1]));
        } else if (Pattern.compile(".*[ ]*").matcher(str).matches()) {
            String[] strArrSplit2 = str.split(" ");
            setSx(VUtilString.parseFloat(strArrSplit2[0]));
            setSy(VUtilString.parseFloat(strArrSplit2[1]));
        }
    }

    public void setSx(float f) {
        this.mSx = f;
    }

    public void setSy(float f) {
        this.mSy = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("CoordOrigin [mSx=");
        sb.append(this.mSx);
        sb.append(", mSy=");
        return AbstractC1038a.m1217r(sb, "]", this.mSy);
    }

    public VCommonCoordOrigin(float f, float f4) {
        this.mSx = f;
        this.mSy = f4;
    }
}
