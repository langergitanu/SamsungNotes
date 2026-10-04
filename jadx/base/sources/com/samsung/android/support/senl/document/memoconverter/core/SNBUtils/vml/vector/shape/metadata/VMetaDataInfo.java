package com.samsung.android.support.senl.document.memoconverter.core.SNBUtils.vml.vector.shape.metadata;

import org.apache.commons.beanutils.PropertyUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
public class VMetaDataInfo {
    private final String mKey;
    private final VMetaDataBase mObject;

    public VMetaDataInfo(String str, VMetaDataBase vMetaDataBase) {
        this.mKey = str;
        this.mObject = vMetaDataBase;
    }

    public String getKey() {
        return this.mKey;
    }

    public VMetaDataBase getObject() {
        return this.mObject;
    }

    public String toString() {
        return "VMetaDataInfo [mKey=" + this.mKey + ", mObject=" + this.mObject + PropertyUtils.INDEXED_DELIM2;
    }
}
