package androidx.reflect.widget;

import android.os.Build;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslOverScrollerReflector {
    private static final Class<?> mClass = OverScroller.class;

    private SeslOverScrollerReflector() {
    }

    public static void fling(@NonNull OverScroller overScroller, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, boolean z, float f) {
        if (Build.VERSION.SDK_INT >= 30) {
            Class<?> cls = mClass;
            Class cls2 = Boolean.TYPE;
            Class cls3 = Float.TYPE;
            Class cls4 = Integer.TYPE;
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(cls, "hidden_fling", (Class<?>[]) new Class[]{cls4, cls4, cls2, cls3});
            if (declaredMethod != null) {
                SeslBaseReflector.invoke(overScroller, declaredMethod, Integer.valueOf(i4), Integer.valueOf(i5), Boolean.valueOf(z), Float.valueOf(f));
                return;
            }
        }
        overScroller.fling(i, i2, i4, i5, i6, i7, i8, i9);
    }

    public static void fling2(@NonNull OverScroller overScroller, int i, int i2, int i4, int i5, int i6, int i7, int i8, int i9, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            Class<?> cls = mClass;
            Class cls2 = Integer.TYPE;
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(cls, "hidden_fling", (Class<?>[]) new Class[]{cls2, cls2, cls2, cls2, cls2, cls2, cls2, cls2, Boolean.TYPE});
            if (declaredMethod != null) {
                SeslBaseReflector.invoke(overScroller, declaredMethod, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Boolean.valueOf(z));
                return;
            }
        }
        overScroller.fling(i, i2, i4, i5, i6, i7, i8, i9);
    }

    public static void setSmoothScrollEnabled(@NonNull OverScroller overScroller, boolean z) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "semSetSmoothScrollEnabled", (Class<?>[]) new Class[]{Boolean.TYPE});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(overScroller, declaredMethod, Boolean.valueOf(z));
        }
    }
}
