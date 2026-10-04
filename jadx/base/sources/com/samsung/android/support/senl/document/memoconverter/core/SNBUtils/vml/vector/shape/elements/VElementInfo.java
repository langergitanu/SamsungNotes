package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements;

import androidx.appcompat.widget.AbstractC0541b;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VElementInfo {
    private final String mKey;
    private final VElementBase mObject;

    public VElementInfo(String str, VElementBase vElementBase) {
        this.mKey = str;
        this.mObject = vElementBase;
    }

    public String getKey() {
        return this.mKey;
    }

    public VElementBase getObject() {
        return this.mObject;
    }

    public String toString() {
        return AbstractC0541b.m776r(new StringBuilder("ElementInfo [mKey="), this.mKey, ", mObject=", "background".compareToIgnoreCase(this.mKey) == 0 ? ((VElementBackground) this.mObject).toString() : VElementKey.FILL.compareToIgnoreCase(this.mKey) == 0 ? ((VElementFill) this.mObject).toString() : VElementKey.FORMULAS.compareToIgnoreCase(this.mKey) == 0 ? ((VElementFormulas) this.mObject).toString() : VElementKey.HANDLES.compareToIgnoreCase(this.mKey) == 0 ? ((VElementHandles) this.mObject).toString() : VElementKey.IMAGEDATA.compareToIgnoreCase(this.mKey) == 0 ? ((VElementImageData) this.mObject).toString() : VElementKey.SHADOW.compareToIgnoreCase(this.mKey) == 0 ? ((VElementShadow) this.mObject).toString() : "stroke".compareToIgnoreCase(this.mKey) == 0 ? ((VElementStroke) this.mObject).toString() : "textbox".compareToIgnoreCase(this.mKey) == 0 ? ((VElementTextBox) this.mObject).toString() : VElementKey.TEXTPATH.compareToIgnoreCase(this.mKey) == 0 ? ((VElementTextPath) this.mObject).toString() : "path".compareToIgnoreCase(this.mKey) == 0 ? ((VElementPath) this.mObject).toString() : "", "]");
    }
}
