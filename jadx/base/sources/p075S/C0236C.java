package p075S;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;

/* JADX INFO: renamed from: S.C */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0236C implements ShareApi.SpaceResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RunnableC0237D f684a;

    public C0236C(RunnableC0237D runnableC0237D) {
        this.f684a = runnableC0237D;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
    public final void onResult(SpaceResult spaceResult) {
        new Handler(Looper.getMainLooper()).post(new RunnableC0235B(this, spaceResult));
    }
}
