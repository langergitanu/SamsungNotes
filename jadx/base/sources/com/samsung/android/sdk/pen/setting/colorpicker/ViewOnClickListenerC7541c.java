package com.samsung.android.sdk.pen.setting.colorpicker;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.colorpicker.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnClickListenerC7541c implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5019a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenColorPickerView f5020b;

    public /* synthetic */ ViewOnClickListenerC7541c(SpenColorPickerView spenColorPickerView, int i) {
        this.f5019a = i;
        this.f5020b = spenColorPickerView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5019a) {
            case 0:
                SpenColorPickerView.initEyedropperButton$lambda$14(this.f5020b, view);
                break;
            default:
                SpenColorPickerView.mModeButtonClickListener$lambda$0(this.f5020b, view);
                break;
        }
    }
}
