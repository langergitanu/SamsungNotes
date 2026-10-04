package com.samsung.android.sdk.scs.p142ai.downloader;

import com.samsung.android.sdk.scs.base.tasks.OnCompleteListener;
import com.samsung.android.sdk.scs.base.tasks.Task;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: renamed from: com.samsung.android.sdk.scs.ai.downloader.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class C7728a implements OnCompleteListener, DownloadBitmap.ICheckerToImageFile {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ CountDownLatch f5178a;

    public /* synthetic */ C7728a(CountDownLatch countDownLatch) {
        this.f5178a = countDownLatch;
    }

    @Override // com.samsung.android.support.senl.nt.model.base.utils.image.DownloadBitmap.ICheckerToImageFile
    public void checkImageWithFile(File file) {
        this.f5178a.countDown();
    }

    @Override // com.samsung.android.sdk.scs.base.tasks.OnCompleteListener
    public void onComplete(Task task) {
        this.f5178a.countDown();
    }
}
