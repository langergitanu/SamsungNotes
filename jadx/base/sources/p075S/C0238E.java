package p075S;

import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: S.E */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0238E implements ShareApi.SpaceResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CompletableFuture f688a;

    public C0238E(CompletableFuture completableFuture) {
        this.f688a = completableFuture;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
    public final void onResult(SpaceResult spaceResult) {
        this.f688a.complete(spaceResult);
    }
}
