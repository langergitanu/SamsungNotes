package com.samsung.android.support.senl.p148nt.app.main.noteslist.adapter.holderinfo;

import com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class SubHeaderHolderInfo extends CommonHolderInfo {
    private long mId;

    public long getId() {
        return this.mId;
    }

    @Override // com.samsung.android.support.senl.p148nt.app.main.common.adapter.CommonHolderInfo
    public CommonHolderInfo setEnable(boolean z) {
        if (this.mIsEnable != z) {
            this.mIsEnable = z;
            if (z) {
                getCheckBox().setEnabled(true);
                getCheckBox().setAlpha(1.0f);
                return this;
            }
            getCheckBox().setEnabled(false);
            getCheckBox().setAlpha(0.4f);
        }
        return this;
    }

    public SubHeaderHolderInfo setId(long j) {
        this.mId = j;
        return this;
    }
}
