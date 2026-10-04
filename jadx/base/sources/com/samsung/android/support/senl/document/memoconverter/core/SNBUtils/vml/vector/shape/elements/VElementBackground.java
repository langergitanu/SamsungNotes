package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.util.VUtilString;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementBackground extends VElementBase {
    public static final String NAME = "v:background";
    private boolean mFill;
    private String mFillcolor;

    public boolean getFill() {
        return this.mFill;
    }

    public String getFillcolor() {
        return this.mFillcolor;
    }

    public void setFill(boolean z) {
        this.mFill = z;
    }

    public void setFillcolor(String str) {
        this.mFillcolor = str;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public String toString() {
        StringBuilder sb = new StringBuilder("Background [mFill=");
        sb.append(this.mFill);
        sb.append(", mFillcolor=");
        sb.append(this.mFillcolor);
        sb.append(", toString()=");
        return AbstractC0622a.m1170p(super.toString(), "]", sb);
    }

    public void setFill(String str) {
        if (str == null || str.isEmpty()) {
            setFill(true);
        } else {
            setFill(VUtilString.parseBoolean(str));
        }
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public void setDefaultMember() {
    }
}
