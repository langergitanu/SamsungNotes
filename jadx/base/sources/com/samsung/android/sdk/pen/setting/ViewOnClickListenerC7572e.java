package com.samsung.android.sdk.pen.setting;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnClickListenerC7572e implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5049a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenPenMiniLayoutControl f5050b;

    public /* synthetic */ ViewOnClickListenerC7572e(SpenPenMiniLayoutControl spenPenMiniLayoutControl, int i) {
        this.f5049a = i;
        this.f5050b = spenPenMiniLayoutControl;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5049a) {
            case 0:
                SpenPenMiniLayoutControl.mFooterButtonClickListener$lambda$0(this.f5050b, view);
                break;
            case 1:
                SpenPenMiniLayoutControl.mColorItemClickListener$lambda$1(this.f5050b, view);
                break;
            case 2:
                SpenPenMiniLayoutControl.addHeader$lambda$8(this.f5050b, view);
                break;
            case 3:
                this.f5050b.changeMode(2);
                break;
            case 4:
                this.f5050b.changeMode(16);
                break;
            default:
                this.f5050b.changeMode(4);
                break;
        }
    }
}
