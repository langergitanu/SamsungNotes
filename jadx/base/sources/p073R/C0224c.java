package p073R;

import com.samsung.android.app.notes.sync.coedit.deletecore.CoeditDeleteLocalSharedSdocTask;
import com.samsung.android.sdk.mobileservice.common.result.BooleanResult;
import com.samsung.android.sdk.mobileservice.social.group.GroupApi;
import com.samsung.android.support.senl.p148nt.base.framework.support.Logger;
import p079T.C0283a;

/* JADX INFO: renamed from: R.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0224c implements GroupApi.GroupResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f664a;

    public C0224c(String str) {
        this.f664a = str;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.group.GroupApi.GroupResultCallback
    public final void onResult(Object obj) {
        BooleanResult booleanResult = (BooleanResult) obj;
        Logger.m8702i("GcsComposerResolver", "requestLeaveCoeditSpace(). onResult() " + booleanResult.getResult());
        if (booleanResult.getResult()) {
            new CoeditDeleteLocalSharedSdocTask(CoeditDeleteLocalSharedSdocTask.DeleteType.GROUP_LEAVE, this.f664a, new C0283a()).execute(new Void[0]);
        } else {
            Logger.m8698e("GcsComposerResolver", "requestLeaveCoeditSpace(). failed() " + booleanResult.getStatus().getMessage());
        }
    }
}
