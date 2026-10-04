package com.samsung.android.support.senl.p148nt.base.winset.view.toolbar;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.winset.view.toolbar.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnLayoutChangeListenerC8993a implements View.OnLayoutChangeListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6514a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ CustomToolbar f6515b;

    public /* synthetic */ ViewOnLayoutChangeListenerC8993a(CustomToolbar customToolbar, int i) {
        this.f6514a = i;
        this.f6515b = customToolbar;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9) {
        switch (this.f6514a) {
            case 0:
                CustomToolbar.enableAdjustableMenu$lambda$3(this.f6515b, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
            default:
                CustomToolbar.initialize$lambda$1(this.f6515b, view, i, i2, i4, i5, i6, i7, i8, i9);
                break;
        }
    }
}
