package com.google.android.material.timepicker;

import com.google.android.material.button.MaterialButtonToggleGroup;

/* JADX INFO: renamed from: com.google.android.material.timepicker.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4940c implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2411a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2412b;

    public /* synthetic */ C4940c(Object obj, int i) {
        this.f2411a = i;
        this.f2412b = obj;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        switch (this.f2411a) {
            case 0:
                ((TimePickerTextInputPresenter) this.f2412b).lambda$setupPeriodToggle$0(materialButtonToggleGroup, i, z);
                break;
            default:
                ((TimePickerView) this.f2412b).lambda$new$0(materialButtonToggleGroup, i, z);
                break;
        }
    }
}
