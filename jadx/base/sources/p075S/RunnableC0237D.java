package p075S;

import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;
import java.util.concurrent.CompletableFuture;

/* JADX INFO: renamed from: S.D */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class RunnableC0237D implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ ShareApi.SpaceResultCallback f685a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CompletableFuture f686b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ String f687c;

    public RunnableC0237D(ShareApi.SpaceResultCallback spaceResultCallback, CompletableFuture completableFuture, String str) {
        this.f685a = spaceResultCallback;
        this.f686b = completableFuture;
        this.f687c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CompletableFuture completableFuture = this.f686b;
        try {
            completableFuture.complete(Integer.valueOf(AbstractC0248O.m527a().requestSpace(this.f687c, this.f685a != null ? new C0236C(this) : null)));
        } catch (Exception unused) {
            Debugger.m8607d("SesShareApi", "requestSync. Request Failure!");
            completableFuture.complete(-1);
        }
    }
}
