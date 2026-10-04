package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import android.text.TextUtils;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class SpaceEntry {
    private long mCreatedTime;
    private String mGroupId;
    private boolean mIsOwnedByMe;
    private boolean mIsStandAlone = false;
    private final List<CoeditResolverContract.MemberInfo> mMembers = new ArrayList();
    private String mSpaceId;
    private String mTitle;
    private int mUnReadCount;

    public SpaceEntry(String str, String str2, long j) {
        this.mGroupId = str;
        this.mSpaceId = str2;
        this.mCreatedTime = j;
    }

    public long getCreatedTime() {
        return this.mCreatedTime;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public int getMemberCount() {
        return this.mMembers.size();
    }

    public List<CoeditResolverContract.MemberInfo> getMembers() {
        return this.mMembers;
    }

    public String getSpaceId() {
        return this.mSpaceId;
    }

    public boolean getStandAlone() {
        return this.mIsStandAlone;
    }

    public String getThumbnailIds() {
        if (getMemberCount() == 0) {
            return "";
        }
        int iMin = Math.min(getMemberCount(), 4);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iMin; i++) {
            if (!TextUtils.isEmpty(this.mMembers.get(i).getMemberName())) {
                sb.append(this.mMembers.get(i).getMemberName().substring(0, 1));
            }
            sb.append(this.mMembers.get(i).getUri());
            sb.append(";");
        }
        return sb.toString();
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int getUnReadCount() {
        return this.mUnReadCount;
    }

    public boolean isOwnedByMe() {
        return this.mIsOwnedByMe;
    }

    public void setGroupId(String str) {
        this.mGroupId = str;
    }

    public void setMembers(List<CoeditResolverContract.MemberInfo> list) {
        this.mMembers.clear();
        this.mMembers.addAll(list);
    }

    public void setOwnedByMe(boolean z) {
        this.mIsOwnedByMe = z;
    }

    public void setSpaceId(String str) {
        this.mSpaceId = str;
    }

    public void setStandAlone(boolean z) {
        this.mIsStandAlone = z;
    }

    public void setTitle(String str) {
        this.mTitle = str;
    }

    public void setUnReadCount(int i) {
        this.mUnReadCount = i;
    }
}
