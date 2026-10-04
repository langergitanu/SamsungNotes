package com.samsung.android.imagetranslation;

import android.graphics.Bitmap;
import com.samsung.android.imagetranslation.LttEngine;
import com.samsung.android.imagetranslation.data.MaskResponse;
import com.samsung.android.imagetranslation.inpainting.InpainterResult;

/* JADX INFO: renamed from: com.samsung.android.imagetranslation.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7115b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4776a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ LttEngine.C71121 f4777b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ int f4778c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Object f4779d;

    public /* synthetic */ RunnableC7115b(LttEngine.C71121 c71121, int i, Object obj, int i2) {
        this.f4776a = i2;
        this.f4777b = c71121;
        this.f4778c = i;
        this.f4779d = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4776a) {
            case 0:
                this.f4777b.lambda$onRenderSuccess$0(this.f4778c, (Bitmap) this.f4779d);
                break;
            case 1:
                this.f4777b.lambda$onInpaintingSuccess$2(this.f4778c, (InpainterResult) this.f4779d);
                break;
            default:
                this.f4777b.lambda$onMaskAvailable$3(this.f4778c, (MaskResponse) this.f4779d);
                break;
        }
    }
}
