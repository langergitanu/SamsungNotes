package p075S;

import android.os.Handler;
import android.os.Looper;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.share.ShareApi;

/* JADX INFO: renamed from: S.G */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0240G implements ShareApi.ShareSyncResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ RunnableC0241H f691a;

    public C0240G(RunnableC0241H runnableC0241H) {
        this.f691a = runnableC0241H;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareSyncResultCallback
    public final void onResult(BooleanResult booleanResult) {
        new Handler(Looper.getMainLooper()).post(new RunnableC0239F(this, booleanResult));
    }
}
