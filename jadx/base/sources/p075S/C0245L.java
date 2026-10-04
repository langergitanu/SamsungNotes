package p075S;

import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.SharedContentDownloadSnapshot;
import com.samsung.android.sdk.mobileservice.social.share.result.ContentDownloadResult;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: S.L */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0245L implements ShareApi.ContentDownloadingResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CompletableFuture f696a;

    public C0245L(CompletableFuture completableFuture) {
        this.f696a = completableFuture;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ContentDownloadingResultCallback
    public final void onProgress(SharedContentDownloadSnapshot sharedContentDownloadSnapshot) {
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ContentDownloadingResultCallback
    public final void onResult(ContentDownloadResult contentDownloadResult) {
        this.f696a.complete(contentDownloadResult);
    }
}
