package com.samsung.android.sdk.pen.setting;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnClickListenerC7521b implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5003a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenFavoritePenMiniLayoutControl f5004b;

    public /* synthetic */ ViewOnClickListenerC7521b(SpenFavoritePenMiniLayoutControl spenFavoritePenMiniLayoutControl, int i) {
        this.f5003a = i;
        this.f5004b = spenFavoritePenMiniLayoutControl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5003a) {
            case 0:
                SpenFavoritePenMiniLayoutControl.addFooter$lambda$3(this.f5004b, view);
                break;
            case 1:
                this.f5004b.notifyButtonClicked(1);
                break;
            case 2:
                this.f5004b.notifyButtonClicked(4);
                break;
            default:
                this.f5004b.notifyButtonClicked(5);
                break;
        }
    }
}
