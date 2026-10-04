package p075S;

import com.samsung.android.sdk.mobileservice.social.share.ShareController;
import com.samsung.android.sdk.mobileservice.social.share.ShareSnapshot;
import com.samsung.android.support.senl.p148nt.base.common.log.Debugger;

/* JADX INFO: renamed from: S.K */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0244K implements ShareController.ShareStatusListener {
    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareController.ShareStatusListener
    public final void onComplete(ShareSnapshot shareSnapshot) {
        Debugger.m8607d("SesShareApi", "onComplete()");
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareController.ShareStatusListener
    public final void onPause(ShareSnapshot shareSnapshot) {
        Debugger.m8607d("SesShareApi", "onPause()");
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareController.ShareStatusListener
    public final void onResume(ShareSnapshot shareSnapshot) {
        Debugger.m8607d("SesShareApi", "onResume()");
    }
}
