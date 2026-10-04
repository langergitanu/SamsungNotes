package com.samsung.android.sdk.pen.setting.colorpicker;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.colorpicker.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnClickListenerC7540b implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5017a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenColorPickerPopup f5018b;

    public /* synthetic */ ViewOnClickListenerC7540b(SpenColorPickerPopup spenColorPickerPopup, int i) {
        this.f5017a = i;
        this.f5018b = spenColorPickerPopup;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5017a) {
            case 0:
                this.f5018b.dismiss();
                break;
            case 1:
                this.f5018b.doneAction();
                break;
            default:
                SpenColorPickerPopup.reconfigureTitleLayout$lambda$8(this.f5018b, view);
                break;
        }
    }
}
