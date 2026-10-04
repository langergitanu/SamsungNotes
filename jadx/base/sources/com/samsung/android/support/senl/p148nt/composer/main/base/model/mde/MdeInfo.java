package com.samsung.android.support.senl.p148nt.composer.main.base.model.mde;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.samsung.android.support.senl.p148nt.app.addons.AbstractC8014b;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.composer.main.base.util.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class MdeInfo {
    public static final String PERMISSION_READ = "R";
    public static final String PERMISSION_WRITE = "R/W";
    private static final String TAG = Logger.createTag("MdeInfo");
    private int mAccountType;
    private List<CoeditResolverContract.MemberInfo> mCoeditMemberList;
    private String mCreatorName;
    private String mGroupId;
    private boolean mIsBanished;
    private boolean mIsReadOnly;
    private boolean mIsStandAlone;
    private String mLeaderId;
    private String mMyId;
    private final List<Observer> mObserverList = new ArrayList();
    private String mOwnerId;
    private String mPermission;
    private String mSpaceId;
    private String mSpaceName;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public interface Observer {
        void onCoeditMemberListChanged(List<CoeditResolverContract.MemberInfo> list);

        void onCreatorNameChanged(String str);

        void onLeaderChanged();

        void onPermissionChanged(MdeInfo mdeInfo);
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static abstract class ObserverAdapter implements Observer {
        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
        public void onCoeditMemberListChanged(List<CoeditResolverContract.MemberInfo> list) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
        public void onCreatorNameChanged(String str) {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
        public void onLeaderChanged() {
        }

        @Override // com.samsung.android.support.senl.nt.composer.main.base.model.mde.MdeInfo.Observer
        public void onPermissionChanged(MdeInfo mdeInfo) {
        }
    }

    public MdeInfo(String str, String str2, String str3, String str4, int i) {
        setData(str, str2, str3, i);
        this.mCreatorName = str4;
    }

    private void setPermission(String str) {
        if (this.mIsReadOnly) {
            Logger.m11003i(TAG, "setPermission# read only");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            AbstractC8014b.m7196B("setPermission# empty: ", str, TAG);
            return;
        }
        if (this.mPermission.equals(str)) {
            return;
        }
        AbstractC8014b.m7197C("setPermission# ", str, TAG);
        this.mPermission = str;
        Iterator<Observer> it = this.mObserverList.iterator();
        while (it.hasNext()) {
            it.next().onPermissionChanged(this);
        }
    }

    private void updatePermission() {
        for (CoeditResolverContract.MemberInfo memberInfo : this.mCoeditMemberList) {
            if (this.mMyId == null || memberInfo.getMemberId().equals(this.mMyId)) {
                setPermission(memberInfo.getAuthority());
                return;
            }
        }
    }

    public void addObserver(Observer observer) {
        if (this.mObserverList.contains(observer)) {
            return;
        }
        this.mObserverList.add(observer);
    }

    public int getAccountType() {
        return this.mAccountType;
    }

    @Nullable
    public List<CoeditResolverContract.MemberInfo> getCoeditMemberList() {
        return this.mCoeditMemberList;
    }

    public String getCreatorName() {
        return this.mCreatorName;
    }

    public String getGroupId() {
        return this.mGroupId;
    }

    public String getLeaderId() {
        return this.mLeaderId;
    }

    public String getMyId() {
        return this.mMyId;
    }

    public String getOwnerId() {
        return this.mOwnerId;
    }

    public String getSpaceId() {
        return this.mSpaceId;
    }

    public String getSpaceName() {
        return this.mSpaceName;
    }

    public boolean hasWritePermission() {
        return "R/W".equals(this.mPermission);
    }

    public boolean isBanished(List<CoeditResolverContract.MemberInfo> list) {
        if (this.mIsBanished) {
            return true;
        }
        if (this.mMyId == null || list == null) {
            return false;
        }
        Iterator<CoeditResolverContract.MemberInfo> it = list.iterator();
        while (it.hasNext()) {
            if (it.next().getMemberId().equals(this.mMyId)) {
                return false;
            }
        }
        this.mIsBanished = true;
        return true;
    }

    public boolean isCreator() {
        return this.mAccountType == 1;
    }

    public boolean isFixedReadPermission() {
        return this.mIsReadOnly;
    }

    public boolean isLeader() {
        if (TextUtils.isEmpty(this.mMyId)) {
            return false;
        }
        return this.mMyId.equals(getLeaderId());
    }

    public boolean isMde() {
        return this.mAccountType != 0;
    }

    public boolean isStandAlone() {
        return this.mIsStandAlone;
    }

    public void setAccountType(int i) {
        this.mAccountType = i;
    }

    public void setCoeditMemberList(List<CoeditResolverContract.MemberInfo> list) {
        String str = TAG;
        StringBuilder sb = new StringBuilder("setCoeditMemberList# ");
        sb.append(list == null ? "null" : String.valueOf(list.size()));
        Logger.m11003i(str, sb.toString());
        this.mCoeditMemberList = list;
        if (this.mAccountType == 2) {
            updatePermission();
        }
        Iterator<Observer> it = this.mObserverList.iterator();
        while (it.hasNext()) {
            it.next().onCoeditMemberListChanged(list);
        }
    }

    public void setCreatorName(String str) {
        Logger.m10999d(TAG, "setCreatorName#");
        this.mCreatorName = str;
        Iterator<Observer> it = this.mObserverList.iterator();
        while (it.hasNext()) {
            it.next().onCreatorNameChanged(str);
        }
    }

    public void setData(String str, String str2, String str3, int i) {
        this.mSpaceId = str;
        this.mGroupId = str2;
        this.mOwnerId = str3;
        this.mAccountType = i;
        this.mPermission = i == 2 ? "R" : "R/W";
        this.mLeaderId = null;
    }

    public void setFixedReadPermission(boolean z) {
        if (this.mIsReadOnly == z) {
            return;
        }
        AbstractC8014b.m7220v("setFixedReadPermission: ", TAG, z);
        if (z) {
            setPermission("R");
            this.mIsReadOnly = true;
        } else {
            this.mIsReadOnly = false;
            updatePermission();
        }
    }

    public void setLeaderId(String str) {
        String str2 = this.mLeaderId;
        if (str2 == null) {
            this.mLeaderId = str;
        } else {
            if (str2.equals(str)) {
                return;
            }
            this.mLeaderId = str;
            Iterator<Observer> it = this.mObserverList.iterator();
            while (it.hasNext()) {
                it.next().onLeaderChanged();
            }
        }
    }

    public void setMyId(String str) {
        this.mMyId = str;
    }

    public void setSpaceName(String str) {
        this.mSpaceName = str;
    }

    public void setStandAlone(boolean z) {
        this.mIsStandAlone = z;
    }
}
