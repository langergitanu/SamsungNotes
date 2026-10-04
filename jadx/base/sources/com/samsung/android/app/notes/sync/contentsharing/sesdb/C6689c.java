package com.samsung.android.app.notes.sync.contentsharing.sesdb;

import com.samsung.android.sdk.mobileservice.social.group.Group;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.entity.CoeditGroupEntry;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: com.samsung.android.app.notes.sync.contentsharing.sesdb.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C6689c extends AbstractC6688b {
    @Override // com.samsung.android.app.notes.sync.contentsharing.sesdb.AbstractC6688b
    /* JADX INFO: renamed from: a */
    public final Object mo4781a() {
        ArrayList arrayList = new ArrayList();
        List<Group> groupList = SesCoeditGroupReadResolver.getInstance().getGroupList();
        if (groupList != null) {
            for (Group group : groupList) {
                CoeditGroupEntry coeditGroupEntry = new CoeditGroupEntry();
                coeditGroupEntry.setGroupId(group.getGroupId());
                coeditGroupEntry.setGroupName(group.getGroupName());
                coeditGroupEntry.setType(group.getGroupType());
                coeditGroupEntry.setOwnerId(group.getLeaderId());
                arrayList.add(coeditGroupEntry);
            }
        }
        return arrayList;
    }
}
