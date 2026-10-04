package com.airbnb.lottie.utils;

import android.graphics.RenderNode;
import android.graphics.drawable.ColorStateListDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Magnifier;

/* JADX INFO: renamed from: com.airbnb.lottie.utils.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC4359a {
    /* JADX INFO: renamed from: A */
    public static /* bridge */ /* synthetic */ boolean m3058A(Drawable drawable) {
        return drawable instanceof ColorStateListDrawable;
    }

    /* JADX INFO: renamed from: e */
    public static /* synthetic */ RenderNode m3066e() {
        return new RenderNode("OffscreenLayer.shadow");
    }

    /* JADX INFO: renamed from: f */
    public static /* bridge */ /* synthetic */ ColorStateListDrawable m3067f(Drawable drawable) {
        return (ColorStateListDrawable) drawable;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ Magnifier.Builder m3072k(View view) {
        return new Magnifier.Builder(view);
    }

    /* JADX INFO: renamed from: s */
    public static /* synthetic */ void m3080s() {
    }
}
