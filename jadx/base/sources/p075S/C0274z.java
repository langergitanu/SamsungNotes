package p075S;

import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.ShareSnapshot;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListResult;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: S.z */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0274z implements ShareApi.ShareUploadResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CompletableFuture f721a;

    public C0274z(CompletableFuture completableFuture) {
        this.f721a = completableFuture;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareUploadResultCallback
    public final void onProgress(ShareSnapshot shareSnapshot) {
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareUploadResultCallback
    public final void onResult(Object obj) {
        this.f721a.complete((SharedItemListResult) obj);
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareUploadResultCallback
    public final void onUploadComplete(ShareSnapshot shareSnapshot) {
    }
}
