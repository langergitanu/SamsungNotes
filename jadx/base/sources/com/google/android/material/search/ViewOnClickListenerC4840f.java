package com.google.android.material.search;

import android.view.View;

/* JADX INFO: renamed from: com.google.android.material.search.f */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class ViewOnClickListenerC4840f implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2361a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ SearchView f2362b;

    public /* synthetic */ ViewOnClickListenerC4840f(SearchView searchView, int i) {
        this.f2361a = i;
        this.f2362b = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2361a) {
            case 0:
                this.f2362b.lambda$setUpBackButton$1(view);
                break;
            case 1:
                this.f2362b.lambda$setUpClearButton$2(view);
                break;
            default:
                this.f2362b.lambda$setupWithSearchBar$7(view);
                break;
        }
    }
}
