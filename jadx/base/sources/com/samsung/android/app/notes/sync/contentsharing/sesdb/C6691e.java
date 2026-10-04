package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import android.content.Context;
import com.samsung.android.support.senl.p148nt.base.common.sync.CoeditResolverContract;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditMemberListEntry;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6691e extends AbstractC6688b {

    /* JADX INFO: renamed from: f */
    public final String f3997f;

    public C6691e(Context context, String str) {
        super(context, SesCoeditGroupReadResolver.getInstance().getMemberContentUri(), true);
        this.f3997f = str;
    }

    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.AbstractC6688b
    /* JADX INFO: renamed from: a */
    public final Object mo4781a() {
        CoeditMemberListEntry coeditMemberListEntry = new CoeditMemberListEntry();
        for (CoeditResolverContract.MemberInfo memberInfo : SesCoeditGroupReadResolver.getInstance().getMemberInfoListIncludePending(this.f3997f)) {
            if (memberInfo.getStatus() == 2) {
                coeditMemberListEntry.getMemberList().add(memberInfo);
            } else if (memberInfo.getStatus() == 1) {
                coeditMemberListEntry.getPendingList().add(memberInfo);
            }
        }
        return coeditMemberListEntry;
    }
}
