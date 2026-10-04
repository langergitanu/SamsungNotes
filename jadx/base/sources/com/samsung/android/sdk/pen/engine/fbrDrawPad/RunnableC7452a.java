package com.samsung.android.sdk.pen.engine.fbrDrawPad;

import android.view.PixelCopy;
import com.samsung.android.sdk.pen.engine.fbrDrawPad.SpenFbrDrawPad;
import com.samsung.android.sdk.pen.engine.fbrDrawPad.SpenFbrDrawPadProPainting;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.engine.fbrDrawPad.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class RunnableC7452a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f4970a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ PixelCopy.OnPixelCopyFinishedListener f4971b;

    public /* synthetic */ RunnableC7452a(PixelCopy.OnPixelCopyFinishedListener onPixelCopyFinishedListener, int i) {
        this.f4970a = i;
        this.f4971b = onPixelCopyFinishedListener;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4970a) {
            case 0:
                ((SpenFbrDrawPad.FbrPixelCopyListener) this.f4971b).onPixelCopyFinished(4);
                break;
            default:
                ((SpenFbrDrawPadProPainting.FbrPixelCopyListener) this.f4971b).onPixelCopyFinished(4);
                break;
        }
    }
}
