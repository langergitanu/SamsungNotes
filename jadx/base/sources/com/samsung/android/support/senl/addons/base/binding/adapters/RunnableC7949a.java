package com.samsung.android.support.senl.addons.base.binding.adapters;

import android.widget.TextView;

/* JADX INFO: renamed from: com.samsung.android.support.senl.addons.base.binding.adapters.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class RunnableC7949a implements Runnable {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5700a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ TextView f5701b;

    public /* synthetic */ RunnableC7949a(TextView textView, int i) {
        this.f5700a = i;
        this.f5701b = textView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f5700a) {
            case 0:
                BAZoomRatioText.setZoomRatioText$lambda$1(this.f5701b);
                break;
            case 1:
                BAZoomRatioText.setZoomRatioText$lambda$1$lambda$0(this.f5701b);
                break;
            default:
                this.f5701b.setVisibility(4);
                break;
        }
    }
}
