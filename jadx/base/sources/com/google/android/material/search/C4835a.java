package com.google.android.material.search;

import android.animation.Animator;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import com.google.android.material.animation.AnimatableView;

/* JADX INFO: renamed from: com.google.android.material.search.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4835a implements AccessibilityManagerCompat.TouchExplorationStateChangeListener, AnimatableView.Listener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ Object f2350a;

    public /* synthetic */ C4835a(Object obj) {
        this.f2350a = obj;
    }

    @Override // com.google.android.material.animation.AnimatableView.Listener
    public void onAnimationEnd() {
        ((Animator) this.f2350a).start();
    }

    @Override // androidx.core.view.accessibility.AccessibilityManagerCompat.TouchExplorationStateChangeListener
    public void onTouchExplorationStateChanged(boolean z) {
        ((SearchBar) this.f2350a).lambda$new$0(z);
    }
}
