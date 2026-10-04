package p075S;

import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: S.l */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0260l implements ShareApi.ShareSyncResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CompletableFuture f709a;

    public C0260l(CompletableFuture completableFuture) {
        this.f709a = completableFuture;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareSyncResultCallback
    public final void onResult(BooleanResult booleanResult) {
        this.f709a.complete(booleanResult);
    }
}
