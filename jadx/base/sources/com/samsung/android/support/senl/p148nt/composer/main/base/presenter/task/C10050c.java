package com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task;

import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskAddImage;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.TaskCommitContent;
import com.samsung.android.support.senl.p148nt.composer.main.base.presenter.task.paste.AbsPasteLogic;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import java.io.File;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.composer.main.base.presenter.task.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C10050c implements DownloadBitmap.ICheckerToImageFile, AbsPasteLogic.Contract {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7091a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f7092b;

    public /* synthetic */ C10050c(Object obj, int i) {
        this.f7091a = i;
        this.f7092b = obj;
    }

    @Override // com.samsung.android.support.senl.nt.model.base.utils.image.DownloadBitmap.ICheckerToImageFile
    public void checkImageWithFile(File file) {
        switch (this.f7091a) {
            case 0:
                TaskAddImage.CallableC99693.lambda$call$0((TaskAddImage.ResultItem) this.f7092b, file);
                break;
            default:
                TaskCommitContent.lambda$executeTask$0((TaskCommitContent.InputValues) this.f7092b, file);
                break;
        }
    }

    @Override // com.samsung.android.support.senl.nt.composer.main.base.presenter.task.paste.AbsPasteLogic.Contract
    public void release() {
        ((TaskPasteHandler) this.f7092b).release();
    }
}
