package p079T;

import com.samsung.android.sdk.mobileservice.social.share.ShareApi;
import com.samsung.android.sdk.mobileservice.social.share.ShareSnapshot;
import com.samsung.android.sdk.mobileservice.social.share.SharedItemWithUriList;
import com.samsung.android.sdk.mobileservice.social.share.result.SharedItemListWithUriListResult;
import com.samsung.android.support.senl.p148nt.data.repository.sync.SyncNoteDataRepository;
import java.util.List;

/* JADX INFO: renamed from: T.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final class C0288f implements ShareApi.ShareUploadResultCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ String f749a;

    public C0288f(String str) {
        this.f749a = str;
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareUploadResultCallback
    public final void onProgress(ShareSnapshot shareSnapshot) {
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareUploadResultCallback
    public final void onResult(Object obj) {
        List<SharedItemWithUriList> successList;
        SharedItemWithUriList sharedItemWithUriList;
        SharedItemListWithUriListResult sharedItemListWithUriListResult = (SharedItemListWithUriListResult) obj;
        if (sharedItemListWithUriListResult == null || (successList = sharedItemListWithUriListResult.getSuccessList()) == null || successList.isEmpty() || (sharedItemWithUriList = successList.get(0)) == null) {
            return;
        }
        new SyncNoteDataRepository().updateModifiedTime(this.f749a, sharedItemWithUriList.getModifiedTime());
    }

    @Override // com.samsung.android.sdk.mobileservice.social.share.ShareApi.ShareUploadResultCallback
    public final void onUploadComplete(ShareSnapshot shareSnapshot) {
    }
}
