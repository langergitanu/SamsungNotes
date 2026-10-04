package androidx.core.view.animation;

import android.graphics.Path;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class PathInterpolatorCompat {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        public static Interpolator createPathInterpolator(Path path) {
            return new PathInterpolator(path);
        }

        public static Interpolator createPathInterpolator(float f, float f4) {
            return new PathInterpolator(f, f4);
        }

        public static Interpolator createPathInterpolator(float f, float f4, float f5, float f6) {
            return new PathInterpolator(f, f4, f5, f6);
        }
    }

    private PathInterpolatorCompat() {
    }

    @NonNull
    public static Interpolator create(@NonNull Path path) {
        return Api21Impl.createPathInterpolator(path);
    }

    @NonNull
    public static Interpolator create(float f, float f4) {
        return Api21Impl.createPathInterpolator(f, f4);
    }

    @NonNull
    public static Interpolator create(float f, float f4, float f5, float f6) {
        return Api21Impl.createPathInterpolator(f, f4, f5, f6);
    }
}
