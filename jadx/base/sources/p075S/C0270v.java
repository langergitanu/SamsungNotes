package p075S;

import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: S.v */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0270v implements GroupApi.GroupResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CompletableFuture f718a;

    public C0270v(CompletableFuture completableFuture) {
        this.f718a = completableFuture;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
    public final void onResult(Object obj) {
        this.f718a.complete((BooleanResult) obj);
    }
}
