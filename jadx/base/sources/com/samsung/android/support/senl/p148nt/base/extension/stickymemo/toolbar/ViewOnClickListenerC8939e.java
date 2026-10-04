package com.samsung.android.support.senl.p148nt.base.extension.stickymemo.toolbar;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.support.senl.nt.base.extension.stickymemo.toolbar.e */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ViewOnClickListenerC8939e implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f6478a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SmToolbar f6479b;

    public /* synthetic */ ViewOnClickListenerC8939e(SmToolbar smToolbar, int i) {
        this.f6478a = i;
        this.f6479b = smToolbar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6478a) {
            case 0:
                SmToolbar.initMoreBtn$lambda$1(this.f6479b, view);
                break;
            default:
                SmToolbar.initMinimizeBtn$lambda$2(this.f6479b, view);
                break;
        }
    }
}
