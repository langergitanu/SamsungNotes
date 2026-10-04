package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import com.samsung.android.support.senl.p148nt.data.database.core.document.data.MainListDocumentData;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditMainListEntry {
    public static final int TYPE_FAKE = 2;
    public static final int TYPE_NOTE = 0;
    public static final int TYPE_SPACE = 1;
    private String mAuthority;
    private MainListDocumentData mMainListDocumentData;
    private int mMemberCount;
    private long mModifiedTime;
    private long mPreviousModifiedTime;
    private SpaceEntry mSpaceEntry;
    private int mType;
    private long mSocialServerChangePoint = -1;
    private long mClientSavedChangePoint = -1;

    public String getAuthority() {
        return this.mAuthority;
    }

    public long getClientSavedChangePoint() {
        return this.mClientSavedChangePoint;
    }

    public MainListDocumentData getMainListDocumentData() {
        return this.mMainListDocumentData;
    }

    public int getMemberCount() {
        return this.mMemberCount;
    }

    public long getModifiedTime() {
        return this.mModifiedTime;
    }

    public long getPreviousModifiedTime() {
        return this.mPreviousModifiedTime;
    }

    public long getSocialServerChangePoint() {
        return this.mSocialServerChangePoint;
    }

    public SpaceEntry getSpaceEntry() {
        return this.mSpaceEntry;
    }

    public int getType() {
        return this.mType;
    }

    public boolean isModifiedTimeChanged() {
        return this.mModifiedTime > this.mPreviousModifiedTime;
    }

    public boolean isSnapShotUpdateRequired() {
        if (this.mMainListDocumentData != null) {
            long j = this.mSocialServerChangePoint;
            if (j != -1) {
                long j2 = this.mClientSavedChangePoint;
                if (j2 != -1 && j2 < j) {
                    return true;
                }
            }
        }
        return false;
    }

    public void printSnapShotLog() {
        if (this.mMainListDocumentData == null) {
            return;
        }
        Debugger.m8607d("CoeditMainListEntry", "isSnapShotUpdateRequired# " + this.mMainListDocumentData.getUuid() + SQLKeyword.COMMA + this.mClientSavedChangePoint + " : " + this.mSocialServerChangePoint);
    }

    public void setAuthority(String str) {
        this.mAuthority = str;
    }

    public void setClientSavedChangePoint(long j) {
        this.mClientSavedChangePoint = j;
    }

    public void setMainListEntry(MainListDocumentData mainListDocumentData, int i) {
        this.mMainListDocumentData = mainListDocumentData;
        this.mMemberCount = i;
    }

    public void setModifiedTime(long j) {
        this.mModifiedTime = j;
    }

    public void setPreviousModifiedTime(long j) {
        this.mPreviousModifiedTime = j;
    }

    public void setSocialServerChangePoint(long j) {
        this.mSocialServerChangePoint = j;
    }

    public void setSpaceEntry(SpaceEntry spaceEntry) {
        this.mSpaceEntry = spaceEntry;
    }

    public void setType(int i) {
        this.mType = i;
    }
}
