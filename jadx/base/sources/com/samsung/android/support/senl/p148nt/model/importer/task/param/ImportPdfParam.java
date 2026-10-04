package com.samsung.android.support.senl.p148nt.model.importer.task.param;

import com.samsung.android.support.senl.p148nt.data.common.constants.PageMode;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public class ImportPdfParam extends ImportSDocXBaseParam<ImportPdfParam> {
    private String mUuidToCopyExtraData;

    @PageMode
    private int mPreferredPageMode = 0;
    private boolean mIsPortraitOrientation = true;

    public boolean getPreferredIsPortraitOrientation() {
        return this.mIsPortraitOrientation;
    }

    @PageMode
    public int getPreferredPageMode() {
        return this.mPreferredPageMode;
    }

    public String getUuidToCopyExtraData() {
        return this.mUuidToCopyExtraData;
    }

    @Override // com.samsung.android.support.senl.p148nt.model.importer.task.param.ImportBaseParam
    public ImportPdfParam self() {
        return this;
    }

    public ImportPdfParam setPreferredIsPortraitOrientation(boolean z) {
        this.mIsPortraitOrientation = z;
        return self();
    }

    public ImportPdfParam setPreferredPageMode(@PageMode int i) {
        this.mPreferredPageMode = i;
        return self();
    }

    public ImportPdfParam setUuidToCopyExtraData(String str) {
        this.mUuidToCopyExtraData = str;
        return self();
    }
}
