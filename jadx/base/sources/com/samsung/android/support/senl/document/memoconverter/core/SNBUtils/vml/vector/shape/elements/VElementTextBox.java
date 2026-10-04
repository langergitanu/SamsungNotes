package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.collection.AbstractC0622a;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.common.VCommonTextBoxStyle;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementTextBox extends VElementBase {
    public static final String NAME = "v:textbox";
    private VCommonTextBoxStyle mStyle;

    public VCommonTextBoxStyle getStyle() {
        return this.mStyle;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public void setDefaultMember() {
        this.mStyle = new VCommonTextBoxStyle();
    }

    public void setStyle(VCommonTextBoxStyle vCommonTextBoxStyle) {
        this.mStyle = vCommonTextBoxStyle;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementBase
    public String toString() {
        StringBuilder sb = new StringBuilder("TextBox [mStyle=");
        sb.append(this.mStyle);
        sb.append(", toString()=");
        return AbstractC0622a.m1170p(super.toString(), "]", sb);
    }

    public void setStyle(String str) {
        this.mStyle.setStyle(str);
    }
}
