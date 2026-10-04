package com.google.android.material.search;

import com.google.android.material.search.SearchBar;
import com.google.android.material.search.SearchBarAnimationHelper;

/* JADX INFO: renamed from: com.google.android.material.search.c */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4837c implements SearchBarAnimationHelper.OnLoadAnimationInvocation {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2353a;

    public /* synthetic */ C4837c(int i) {
        this.f2353a = i;
    }

    @Override // com.google.android.material.search.SearchBarAnimationHelper.OnLoadAnimationInvocation
    public final void invoke(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback) {
        switch (this.f2353a) {
            case 0:
                onLoadAnimationCallback.onAnimationStart();
                break;
            default:
                onLoadAnimationCallback.onAnimationEnd();
                break;
        }
    }
}
