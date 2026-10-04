package com.samsung.android.support.senl.p148nt.model.base.utils.data;

import com.samsung.android.support.senl.p148nt.model.base.utils.data.Content;
import com.samsung.android.support.senl.p148nt.model.base.utils.image.DownloadBitmap;
import java.util.function.Consumer;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.model.base.utils.data.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C11417a implements Consumer {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7693a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Content.Image f7694b;

    public /* synthetic */ C11417a(Content.Image image, int i) {
        this.f7693a = i;
        this.f7694b = image;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        switch (this.f7693a) {
            case 0:
                this.f7694b.lambda$download$0((String) obj);
                break;
            default:
                DownloadBitmap.lambda$saveBitmapFromUri$0(this.f7694b, (String) obj);
                break;
        }
    }
}
