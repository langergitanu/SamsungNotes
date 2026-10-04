package androidx.core.content.p110pm;

import android.graphics.Insets;
import android.view.WindowInsetsAnimation;
import android.view.animation.Interpolator;

/* JADX INFO: renamed from: androidx.core.content.pm.a */
/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public abstract /* synthetic */ class AbstractC2362a {
    /* JADX INFO: renamed from: h */
    public static /* synthetic */ WindowInsetsAnimation.Bounds m1671h(Insets insets, Insets insets2) {
        return new WindowInsetsAnimation.Bounds(insets, insets2);
    }

    /* JADX INFO: renamed from: i */
    public static /* synthetic */ WindowInsetsAnimation m1672i(int i, Interpolator interpolator, long j) {
        return new WindowInsetsAnimation(i, interpolator, j);
    }

    /* JADX INFO: renamed from: j */
    public static /* bridge */ /* synthetic */ WindowInsetsAnimation m1673j(Object obj) {
        return (WindowInsetsAnimation) obj;
    }

    /* JADX INFO: renamed from: m */
    public static /* synthetic */ void m1676m() {
    }
}
