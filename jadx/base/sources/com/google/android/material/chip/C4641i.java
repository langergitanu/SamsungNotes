package com.google.android.material.chip;

import android.content.Context;
import com.google.android.material.chip.SeslChipGroup;

/* JADX INFO: renamed from: com.google.android.material.chip.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4641i implements SeslChipGroup.OnChipAddListener, SeslChipGroup.OnChipRemovedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SeslPeoplePicker f2258a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Context f2259b;

    public /* synthetic */ C4641i(SeslPeoplePicker seslPeoplePicker, Context context) {
        this.f2258a = seslPeoplePicker;
        this.f2259b = context;
    }

    @Override // com.google.android.material.chip.SeslChipGroup.OnChipAddListener
    public void onAdd() {
        this.f2258a.lambda$setListeners$2(this.f2259b);
    }

    @Override // com.google.android.material.chip.SeslChipGroup.OnChipRemovedListener
    public void onRemove() {
        this.f2258a.lambda$setListeners$3(this.f2259b);
    }
}
