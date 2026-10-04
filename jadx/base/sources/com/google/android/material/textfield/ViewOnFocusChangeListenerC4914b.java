package com.google.android.material.textfield;

import android.view.View;

/* JADX INFO: renamed from: com.google.android.material.textfield.b */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ViewOnFocusChangeListenerC4914b implements View.OnFocusChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2399a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ EndIconDelegate f2400b;

    public /* synthetic */ ViewOnFocusChangeListenerC4914b(EndIconDelegate endIconDelegate, int i) {
        this.f2399a = i;
        this.f2400b = endIconDelegate;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        switch (this.f2399a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f2400b).lambda$new$1(view, z);
                break;
            default:
                ((DropdownMenuEndIconDelegate) this.f2400b).lambda$new$1(view, z);
                break;
        }
    }
}
