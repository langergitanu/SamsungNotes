package com.samsung.android.support.senl.p148nt.composer.main.base.view.menu.list.animator;

import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes3.dex */
public class CustomLottieAnimationView extends LottieAnimationView {
    public CustomLottieAnimationView(Context context) {
        super(context);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
        }
        super.onDetachedFromWindow();
    }

    public CustomLottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomLottieAnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
