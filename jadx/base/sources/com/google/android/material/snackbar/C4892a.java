package com.google.android.material.snackbar;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.samsung.android.sdk.pen.setting.quicktool.SpenQTPenListAdapter;

/* JADX INFO: renamed from: com.google.android.material.snackbar.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public final /* synthetic */ class C4892a implements DynamicAnimation.OnAnimationEndListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ int f2386a;

    /* JADX INFO: renamed from: b */
    public final /* synthetic */ Object f2387b;

    public /* synthetic */ C4892a(Object obj, int i) {
        this.f2386a = i;
        this.f2387b = obj;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f4) {
        switch (this.f2386a) {
            case 0:
                ((BaseTransientBottomBar) this.f2387b).lambda$seslStartSuggestAnimation$1(dynamicAnimation, z, f, f4);
                break;
            case 1:
                SpenQTPenListAdapter.ViewHolder.startAnimationHide$lambda$3((SpenQTPenListAdapter) this.f2387b, dynamicAnimation, z, f, f4);
                break;
            default:
                ((Runnable) this.f2387b).run();
                break;
        }
    }
}
