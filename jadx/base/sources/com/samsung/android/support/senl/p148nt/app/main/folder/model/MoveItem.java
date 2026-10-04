package com.samsung.android.support.senl.p148nt.app.main.folder.model;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public class MoveItem {
    final String mDesUuid;
    boolean mIsAlreadyMoved = false;
    final String mSrcDisplayName;
    final String mSrcUuid;

    public MoveItem(String str, String str2, String str3) {
        this.mSrcUuid = str;
        this.mDesUuid = str2;
        this.mSrcDisplayName = str3;
    }

    public String getDesUuid() {
        return this.mDesUuid;
    }

    public boolean getIsAlreadyMoved() {
        return this.mIsAlreadyMoved;
    }

    public String getSrcDisplayName() {
        return this.mSrcDisplayName;
    }

    public String getSrcUuid() {
        return this.mSrcUuid;
    }

    public void setAlreadyMoved() {
        this.mIsAlreadyMoved = true;
    }
}
