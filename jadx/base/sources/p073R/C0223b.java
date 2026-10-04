package p073R;

import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.result.SpaceResult;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import p075S.AbstractC0254f;

/* JADX INFO: renamed from: R.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0223b implements ShareApi.SpaceResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f663a;

    public C0223b(String str) {
        this.f663a = str;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.SpaceResultCallback
    public final void onResult(SpaceResult spaceResult) {
        try {
            AbstractC0254f.m535a().requestGroupDeletion(this.f663a, new C0222a(this));
        } catch (Exception e) {
            Logger.m8698e("GcsComposerResolver", "requestDeleteCoeditSpace(). requestGroupDeletion failed() " + e.toString());
        }
    }
}
