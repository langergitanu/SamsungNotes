package p075S;

import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.ShareSnapshot;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListResult;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: S.J */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0243J implements ShareApi.ShareResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CompletableFuture f695a;

    public C0243J(CompletableFuture completableFuture) {
        this.f695a = completableFuture;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareResultCallback
    public final void onProgress(ShareSnapshot shareSnapshot) {
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareResultCallback
    public final void onResult(SharedItemListResult sharedItemListResult) {
        this.f695a.complete(sharedItemListResult);
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareResultCallback
    public final void onUploadComplete(ShareSnapshot shareSnapshot) {
        Debugger.m8607d("SesShareApi", "onUploadComplete()");
    }
}
