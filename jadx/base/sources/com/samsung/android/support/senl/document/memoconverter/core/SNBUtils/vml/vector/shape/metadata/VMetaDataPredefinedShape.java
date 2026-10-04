package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.elements.VElementInfo;
import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.predefined.VPredefinedBase;
import java.util.ArrayList;
import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VMetaDataPredefinedShape extends VMetaDataBase {
    public static final String ARC = "arc";
    public static final String CURVE = "curve";
    public static final String IMAGE = "image";
    public static final String LINE = "line";
    public static final String OVAL = "oval";
    public static final String POLYLINE = "polyline";
    public static final String RECT = "rect";
    public static final String ROUNDRECT = "roundrect";
    private String mKey;
    private VPredefinedBase mObject;

    public ArrayList<VElementInfo> getElements() {
        return this.mObject.getElements();
    }

    public String getKey() {
        return this.mKey;
    }

    public VPredefinedBase getObject() {
        return this.mObject;
    }

    public ArrayList<VElementInfo> makeAndGetElements() {
        this.mObject.setElements(new ArrayList<>());
        return this.mObject.getElements();
    }

    public void setAll(String str, VPredefinedBase vPredefinedBase) {
        this.mKey = str;
        this.mObject = vPredefinedBase;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataBase
    public void setDefaultMember() {
        this.mObject = new VPredefinedBase();
    }

    public void setElements(ArrayList<VElementInfo> arrayList) {
        this.mObject.setElements(arrayList);
    }

    public void setKey(String str) {
        this.mKey = str;
    }

    public void setObject(VPredefinedBase vPredefinedBase) {
        this.mObject = vPredefinedBase;
    }

    public String toString() {
        return "VPredefinedShape [mKey=" + this.mKey + ", mObject=" + this.mObject + PropertyUtils.INDEXED_DELIM2;
    }
}
