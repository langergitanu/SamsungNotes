package com.bumptech.glide.load.resource.bitmap;

import android.graphics.ImageDecoder;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.view.textclassifier.TextClassification;
import android.view.textclassifier.TextClassificationContext;

/* JADX INFO: renamed from: com.bumptech.glide.load.resource.bitmap.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public abstract /* synthetic */ class AbstractC4446a {
    /* JADX INFO: renamed from: A */
    public static /* synthetic */ void m3093A() {
    }

    /* JADX INFO: renamed from: D */
    public static /* synthetic */ void m3096D() {
    }

    /* JADX INFO: renamed from: f */
    public static /* bridge */ /* synthetic */ ImageDecoder.Source m3102f(Object obj) {
        return (ImageDecoder.Source) obj;
    }

    /* JADX INFO: renamed from: h */
    public static /* bridge */ /* synthetic */ AnimatedImageDrawable m3104h(Drawable drawable) {
        return (AnimatedImageDrawable) drawable;
    }

    /* JADX INFO: renamed from: k */
    public static /* synthetic */ TextClassification.Request.Builder m3107k(int i, int i2, String str) {
        return new TextClassification.Request.Builder(str, i, i2);
    }

    /* JADX INFO: renamed from: o */
    public static /* synthetic */ TextClassificationContext.Builder m3111o(String str) {
        return new TextClassificationContext.Builder(str, "textview");
    }

    /* JADX INFO: renamed from: y */
    public static /* bridge */ /* synthetic */ boolean m3121y(Drawable drawable) {
        return drawable instanceof AnimatedImageDrawable;
    }
}
