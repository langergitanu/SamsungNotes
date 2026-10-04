package com.samsung.android.sdk.pen.setting.favoritepen;

import android.view.View;

/* JADX INFO: renamed from: com.samsung.android.sdk.pen.setting.favoritepen.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public final /* synthetic */ class ViewOnClickListenerC7580a implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f5053a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SpenFavoritePenLayout f5054b;

    public /* synthetic */ ViewOnClickListenerC7580a(SpenFavoritePenLayout spenFavoritePenLayout, int i) {
        this.f5053a = i;
        this.f5054b = spenFavoritePenLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5053a) {
            case 0:
                SpenFavoritePenLayout.mDoneButtonClickListener$lambda$0(this.f5054b, view);
                break;
            default:
                SpenFavoritePenLayout.initView$lambda$8(this.f5054b, view);
                break;
        }
    }
}
