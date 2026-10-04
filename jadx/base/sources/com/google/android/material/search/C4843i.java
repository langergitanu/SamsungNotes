package com.google.android.material.search;

import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils;

/* JADX INFO: renamed from: com.google.android.material.search.i */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4843i implements ViewUtils.OnApplyWindowInsetsListener, OnApplyWindowInsetsListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SearchView f2368a;

    public /* synthetic */ C4843i(SearchView searchView) {
        this.f2368a = searchView;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return this.f2368a.lambda$setUpStatusBarSpacerInsetListener$5(view, windowInsetsCompat);
    }

    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        return this.f2368a.lambda$setUpToolbarInsetListener$4(view, windowInsetsCompat, relativePadding);
    }
}
