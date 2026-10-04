package p079T;

import com.samsung.android.sdk.mobileservice.social.group.Group;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.sdk.mobileservice.social.group.result.GroupListResult;
import java.util.Iterator;
import java.util.List;
import p001A.AbstractC0000a;
import p075S.AbstractC0272x;

/* JADX INFO: renamed from: T.j */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0292j implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ GroupApi.GroupSyncResultCallback f756a;

    public RunnableC0292j(GroupApi.GroupSyncResultCallback groupSyncResultCallback) {
        this.f756a = groupSyncResultCallback;
    }

    @Override // java.lang.Runnable
    public final void run() {
        List<Group> result;
        try {
            GroupListResult groupListResultM551b = AbstractC0272x.m551b();
            if (groupListResultM551b == null || (result = groupListResultM551b.getResult()) == null) {
                return;
            }
            C0293k c0293k = new C0293k(result.size(), this.f756a);
            Iterator<Group> it = result.iterator();
            while (it.hasNext()) {
                AbstractC0272x.m558i(it.next().getGroupId(), c0293k);
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            AbstractC0000a.m21r(e2, new StringBuilder("updateGroupMemberInfoForce# failed - "), "SesGroupUtil");
        }
    }
}
