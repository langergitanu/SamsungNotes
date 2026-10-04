package p075S;

import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: S.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0250b implements GroupApi.GroupSyncResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CompletableFuture f701a;

    public C0250b(CompletableFuture completableFuture) {
        this.f701a = completableFuture;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupSyncResultCallback
    public final void onResult(BooleanResult booleanResult) {
        this.f701a.complete(booleanResult);
    }
}
