package com.samsung.android.livetranslation.util;

import com.samsung.android.imagetranslation.data.LttOcrResult;
import com.samsung.android.support.senl.p148nt.data.database.core.sync.dao.SyncFolderInfoDao;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.livetranslation.util.m */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class C7182m implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4839a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ int f4840b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Object f4841c;

    public /* synthetic */ C7182m(Object obj, int i, int i2) {
        this.f4839a = i2;
        this.f4841c = obj;
        this.f4840b = i;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f4839a) {
            case 0:
                ((OcrDataToSceneTextConverter) this.f4841c).lambda$convert$1(this.f4840b, (LttOcrResult.BlockInfo) obj);
                break;
            default:
                ((SyncFolderInfoDao) this.f4841c).lambda$updateDeletedBy$1(this.f4840b, (String) obj);
                break;
        }
    }
}
