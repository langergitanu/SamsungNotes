package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common;

import androidx.compose.foundation.layout.AbstractC1038a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VCommonSize {
    private float mHeight;
    private float mWidth;

    public VCommonSize() {
    }

    public float getHeight() {
        return this.mHeight;
    }

    public float getWidth() {
        return this.mWidth;
    }

    public void setHeight(float f) {
        this.mHeight = f;
    }

    public void setSize(String str) {
        if (str == null) {
            return;
        }
        if (Pattern.compile(".*[,]*").matcher(str).matches()) {
            String[] strArrSplit = str.split(",");
            setWidth(VUtilString.parseFloat(strArrSplit[0]));
            setHeight(VUtilString.parseFloat(strArrSplit[1]));
        } else if (Pattern.compile(".*[ ]*").matcher(str).matches()) {
            String[] strArrSplit2 = str.split(" ");
            setWidth(VUtilString.parseFloat(strArrSplit2[0]));
            setHeight(VUtilString.parseFloat(strArrSplit2[1]));
        }
    }

    public void setWidth(float f) {
        this.mWidth = f;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Size [mWidth=");
        sb.append(this.mWidth);
        sb.append(", mHeight=");
        return AbstractC1038a.m1217r(sb, "]", this.mHeight);
    }

    public VCommonSize(float f, float f4) {
        this.mWidth = f;
        this.mHeight = f4;
    }
}
