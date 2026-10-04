package p075S;

import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.ItemListResult;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: S.r */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0266r implements ShareApi.ShareBaseResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CompletableFuture f714a;

    public C0266r(CompletableFuture completableFuture) {
        this.f714a = completableFuture;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareBaseResultCallback
    public final void onResult(Object obj) {
        this.f714a.complete((ItemListResult) obj);
    }
}
