package androidx.core.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.EdgeEffect;
import androidx.annotation.RequiresApi;
import androidx.reflect.view.SeslViewRuneReflector;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class EdgeEffectCompat {
    private final EdgeEffect mEdgeEffect;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static void onPull(EdgeEffect edgeEffect, float f, float f4) {
            edgeEffect.onPull(f, f4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(31)
    public static class Api31Impl {
        private Api31Impl() {
        }

        public static EdgeEffect create(Context context, AttributeSet attributeSet) {
            try {
                return new EdgeEffect(context, attributeSet);
            } catch (Throwable unused) {
                return new EdgeEffect(context);
            }
        }

        public static float getDistance(EdgeEffect edgeEffect) {
            try {
                return edgeEffect.getDistance();
            } catch (Throwable unused) {
                return 0.0f;
            }
        }

        public static float onPullDistance(EdgeEffect edgeEffect, float f, float f4) {
            try {
                return edgeEffect.onPullDistance(f, f4);
            } catch (Throwable unused) {
                edgeEffect.onPull(f, f4);
                return 0.0f;
            }
        }
    }

    @Deprecated
    public EdgeEffectCompat(Context context) {
        this.mEdgeEffect = new EdgeEffect(context);
    }

    public static EdgeEffect create(Context context, AttributeSet attributeSet) {
        return (Build.VERSION.SDK_INT < 31 || !SeslViewRuneReflector.isEdgeEffectStretchType()) ? new EdgeEffect(context) : Api31Impl.create(context, attributeSet);
    }

    public static float getDistance(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT < 31 || !SeslViewRuneReflector.isEdgeEffectStretchType()) {
            return 0.0f;
        }
        return Api31Impl.getDistance(edgeEffect);
    }

    public static float onPullDistance(EdgeEffect edgeEffect, float f, float f4) {
        if (Build.VERSION.SDK_INT >= 31 && SeslViewRuneReflector.isEdgeEffectStretchType()) {
            return Api31Impl.onPullDistance(edgeEffect, f, f4);
        }
        onPull(edgeEffect, f, f4);
        return f;
    }

    @Deprecated
    public boolean draw(Canvas canvas) {
        return this.mEdgeEffect.draw(canvas);
    }

    @Deprecated
    public void finish() {
        this.mEdgeEffect.finish();
    }

    @Deprecated
    public boolean isFinished() {
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public boolean onAbsorb(int i) {
        this.mEdgeEffect.onAbsorb(i);
        return true;
    }

    @Deprecated
    public boolean onPull(float f) {
        this.mEdgeEffect.onPull(f);
        return true;
    }

    @Deprecated
    public boolean onRelease() {
        this.mEdgeEffect.onRelease();
        return this.mEdgeEffect.isFinished();
    }

    @Deprecated
    public void setSize(int i, int i2) {
        this.mEdgeEffect.setSize(i, i2);
    }

    @Deprecated
    public boolean onPull(float f, float f4) {
        onPull(this.mEdgeEffect, f, f4);
        return true;
    }

    public static void onPull(EdgeEffect edgeEffect, float f, float f4) {
        Api21Impl.onPull(edgeEffect, f, f4);
    }
}
