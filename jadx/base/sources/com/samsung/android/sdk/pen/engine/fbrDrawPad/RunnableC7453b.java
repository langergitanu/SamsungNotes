package com.samsung.android.sdk.pen.engine.fbrDrawPad;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.PixelCopy;
import android.view.SurfaceView;
import com.samsung.android.sdk.pen.engine.fbrDrawPad.SpenFbrDrawPad;
import com.samsung.android.sdk.pen.engine.fbrDrawPad.SpenFbrDrawPadProPainting;
import kotlin.jvm.internal.Ref;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.engine.fbrDrawPad.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7453b implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4972a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Ref.ObjectRef f4973b;

    /* JADX INFO: renamed from: c */
    public final /* synthetic */ Ref.ObjectRef f4974c;

    /* JADX INFO: renamed from: d */
    public final /* synthetic */ Bitmap f4975d;

    /* JADX INFO: renamed from: e */
    public final /* synthetic */ Looper f4976e;

    /* JADX INFO: renamed from: f */
    public final /* synthetic */ Ref.ObjectRef f4977f;

    /* JADX INFO: renamed from: g */
    public final /* synthetic */ SurfaceView f4978g;

    /* JADX INFO: renamed from: h */
    public final /* synthetic */ PixelCopy.OnPixelCopyFinishedListener f4979h;

    public /* synthetic */ RunnableC7453b(SurfaceView surfaceView, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2, Bitmap bitmap, PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener, Looper looper, Ref.ObjectRef objectRef3, int i) {
        this.f4972a = i;
        this.f4978g = surfaceView;
        this.f4973b = objectRef;
        this.f4974c = objectRef2;
        this.f4975d = bitmap;
        this.f4979h = onPixelCopyFinishedListener;
        this.f4976e = looper;
        this.f4977f = objectRef3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4972a) {
            case 0:
                SpenFbrDrawPad.takeBackground$lambda$5((SpenFbrDrawPad) this.f4978g, this.f4973b, this.f4974c, this.f4975d, (SpenFbrDrawPad.FbrPixelCopyListener) this.f4979h, this.f4976e, this.f4977f);
                break;
            default:
                SpenFbrDrawPadProPainting.takeBackground$lambda$4((SpenFbrDrawPadProPainting) this.f4978g, this.f4973b, this.f4974c, this.f4975d, (SpenFbrDrawPadProPainting.FbrPixelCopyListener) this.f4979h, this.f4976e, this.f4977f);
                break;
        }
    }
}
