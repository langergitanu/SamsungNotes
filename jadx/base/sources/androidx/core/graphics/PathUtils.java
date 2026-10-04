package androidx.core.graphics;

import android.graphics.Path;
import android.graphics.PointF;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Collection;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
public final class PathUtils {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RequiresApi(26)
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static float[] approximate(Path path, float f) {
            return path.approximate(f);
        }
    }

    private PathUtils() {
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path) {
        return flatten(path, 0.5f);
    }

    @NonNull
    @RequiresApi(26)
    public static Collection<PathSegment> flatten(@NonNull Path path, @FloatRange(from = 0.0d) float f) {
        float[] fArrApproximate = Api26Impl.approximate(path, f);
        int length = fArrApproximate.length / 3;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 1; i < length; i++) {
            int i2 = i * 3;
            int i4 = (i - 1) * 3;
            float f4 = fArrApproximate[i2];
            float f5 = fArrApproximate[i2 + 1];
            float f6 = fArrApproximate[i2 + 2];
            float f7 = fArrApproximate[i4];
            float f8 = fArrApproximate[i4 + 1];
            float f9 = fArrApproximate[i4 + 2];
            if (f4 != f7 && (f5 != f8 || f6 != f9)) {
                arrayList.add(new PathSegment(new PointF(f8, f9), f7, new PointF(f5, f6), f4));
            }
        }
        return arrayList;
    }
}
