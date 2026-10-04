package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeShape;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementInfo;
import java.util.ArrayList;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VPredefinedBase {
    private VAttributeCore mCoreAttrs;
    private ArrayList<VElementInfo> mElements;
    private VAttributeShape mShapeAttrs;

    public VAttributeCore getCoreAttrs() {
        return this.mCoreAttrs;
    }

    public ArrayList<VElementInfo> getElements() {
        return this.mElements;
    }

    public VAttributeShape getShapeAttrs() {
        return this.mShapeAttrs;
    }

    public void setCoreAttrs(VAttributeCore vAttributeCore) {
        this.mCoreAttrs = vAttributeCore;
    }

    public void setDefaultMember() {
        this.mCoreAttrs = new VAttributeCore();
        this.mShapeAttrs = new VAttributeShape();
    }

    public void setElements(ArrayList<VElementInfo> arrayList) {
        this.mElements = arrayList;
    }

    public void setShapeAttrs(VAttributeShape vAttributeShape) {
        this.mShapeAttrs = vAttributeShape;
    }

    public String toString() {
        return "VFigure [mCoreAttrs=" + this.mCoreAttrs + ", mShapeAttrs=" + this.mShapeAttrs + ", mElements=" + this.mElements + PropertyUtils.INDEXED_DELIM2;
    }
}
