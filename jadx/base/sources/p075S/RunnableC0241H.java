package p075S;

import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: S.H */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0241H implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ShareApi.ShareSyncResultCallback f692a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CompletableFuture f693b;

    public RunnableC0241H(ShareApi.ShareSyncResultCallback shareSyncResultCallback, CompletableFuture completableFuture) {
        this.f692a = shareSyncResultCallback;
        this.f693b = completableFuture;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CompletableFuture completableFuture = this.f693b;
        try {
            completableFuture.complete(Integer.valueOf(AbstractC0248O.m527a().requestSync(this.f692a != null ? new C0240G(this) : null)));
        } catch (Exception unused) {
            Debugger.m8607d("SesShareApi", "requestSync. Request Failure!");
            completableFuture.complete(-1);
        }
    }
}
