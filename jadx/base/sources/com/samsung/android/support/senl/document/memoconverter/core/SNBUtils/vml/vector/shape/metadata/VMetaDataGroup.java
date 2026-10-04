package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.attribute.VAttributeCore;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VMetaDataGroup extends VMetaDataBase {
    public static final String NAME = "v:group";
    private VAttributeCore mCoreAttrs;
    private ArrayList<VMetaDataInfo> mMetaDataList;

    public VAttributeCore getCoreAttrs() {
        return this.mCoreAttrs;
    }

    public ArrayList<VMetaDataInfo> getMetaDataList() {
        return this.mMetaDataList;
    }

    public void setCoreAttrs(VAttributeCore vAttributeCore) {
        this.mCoreAttrs = vAttributeCore;
    }

    @Override // com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataBase
    public void setDefaultMember() {
        this.mCoreAttrs = new VAttributeCore();
        this.mMetaDataList = new ArrayList<>();
    }

    public void setMetaDataList(ArrayList<VMetaDataInfo> arrayList) {
        this.mMetaDataList = arrayList;
    }

    public String toString() {
        return "Group [mCoreAttrs=" + this.mCoreAttrs + ", mMetaDataList=" + this.mMetaDataList + "]";
    }
}
