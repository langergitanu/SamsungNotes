package com.samsung.android.support.senl.p148nt.stt.picker;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.stt.picker.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class ViewOnClickListenerC11506a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f7864a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ AudioPickerActivity f7865b;

    public /* synthetic */ ViewOnClickListenerC11506a(AudioPickerActivity audioPickerActivity, int i) {
        this.f7864a = i;
        this.f7865b = audioPickerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f7864a) {
            case 0:
                AudioPickerActivity.initDoneButton$lambda$2(this.f7865b, view);
                break;
            case 1:
                this.f7865b.initSearchMode();
                break;
            case 2:
                AudioPickerActivity.initPickerList$lambda$3(this.f7865b, view);
                break;
            case 3:
                AudioPickerActivity.initPickerList$lambda$4(this.f7865b, view);
                break;
            default:
                AudioPickerActivity.initPickerList$lambda$5(this.f7865b, view);
                break;
        }
    }
}
