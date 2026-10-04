package p079T;

import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.common.result.CommonResultStatus;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: renamed from: T.k */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0293k implements GroupApi.GroupResultCallback {

    /* JADX INFO: renamed from: a */
    public final int f757a;

    /* JADX INFO: renamed from: b */
    public final GroupApi.GroupSyncResultCallback f758b;

    /* JADX INFO: renamed from: c */
    public final AtomicInteger f759c = new AtomicInteger(0);

    public C0293k(int i, GroupApi.GroupSyncResultCallback groupSyncResultCallback) {
        this.f757a = i;
        this.f758b = groupSyncResultCallback;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
    public final void onResult(Object obj) {
        if (this.f759c.incrementAndGet() == this.f757a) {
            Debugger.m8607d("SesGroupUtil", " GroupInfoUpdateCallback result");
            this.f758b.onResult(new BooleanResult(new CommonResultStatus(0), true));
        }
    }
}
