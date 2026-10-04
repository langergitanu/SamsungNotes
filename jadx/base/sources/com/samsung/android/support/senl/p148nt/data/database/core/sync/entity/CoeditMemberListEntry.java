package com.samsung.android.support.senl.p148nt.data.database.core.sync.entity;

import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CoeditMemberListEntry {
    private final List<CoeditResolverContract.MemberInfo> mMemberList = new ArrayList();
    private final List<CoeditResolverContract.MemberInfo> mPendingList = new ArrayList();

    public List<CoeditResolverContract.MemberInfo> getMemberList() {
        return this.mMemberList;
    }

    public List<CoeditResolverContract.MemberInfo> getPendingList() {
        return this.mPendingList;
    }
}
