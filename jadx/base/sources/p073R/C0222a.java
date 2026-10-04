package p073R;

import com.samsung.android.app.notes.sync.coedit.deletecore.CoeditDeleteLocalSharedSdocTask;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import p032H.C0110a;

/* JADX INFO: renamed from: R.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0222a implements GroupApi.GroupResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C0223b f662a;

    public C0222a(C0223b c0223b) {
        this.f662a = c0223b;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
    public final void onResult(Object obj) {
        BooleanResult booleanResult = (BooleanResult) obj;
        Logger.m8702i("GcsComposerResolver", "requestDeleteCoeditSpace(). onResult() " + booleanResult.getResult());
        if (booleanResult.getResult()) {
            new CoeditDeleteLocalSharedSdocTask(CoeditDeleteLocalSharedSdocTask.DeleteType.GROUP, this.f662a.f663a, new C0110a()).execute(new Void[0]);
            return;
        }
        Logger.m8698e("GcsComposerResolver", "requestDeleteCoeditSpace(). failed() " + booleanResult.getStatus().getMessage());
    }
}
