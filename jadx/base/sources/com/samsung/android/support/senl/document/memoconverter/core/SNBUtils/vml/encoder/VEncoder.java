package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.encoder;

import com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata.VMetaDataInfo;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VEncoder {
    private String mEncodeData;
    private ArrayList<VMetaDataInfo> mMetaDataInfos;

    public String getEncodeData() {
        return this.mEncodeData;
    }

    public ArrayList<VMetaDataInfo> getMetaDataInfos() {
        return this.mMetaDataInfos;
    }

    public void setEncodeData(String str) {
        this.mEncodeData = str;
    }

    public void setMetaDataInfos(ArrayList<VMetaDataInfo> arrayList) {
        this.mMetaDataInfos = arrayList;
    }

    public void encode() {
    }
}
