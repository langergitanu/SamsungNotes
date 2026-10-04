package androidx.reflect.graphics;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslCanvasReflector {
    private static final Class<?> mClass = Canvas.class;

    private SeslCanvasReflector() {
    }

    public static void restoreUnclippedLayer(@NonNull Canvas canvas, int i, Paint paint) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "restoreUnclippedLayer", (Class<?>[]) new Class[]{Integer.TYPE, Paint.class});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(canvas, declaredMethod, Integer.valueOf(i), paint);
        }
    }

    public static int saveUnclippedLayer(@NonNull Canvas canvas, int i, int i2, int i4, int i5) {
        Class<?> cls = mClass;
        Class cls2 = Integer.TYPE;
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(cls, "saveUnclippedLayer", (Class<?>[]) new Class[]{cls2, cls2, cls2, cls2});
        if (declaredMethod == null) {
            return -1;
        }
        Object objInvoke = SeslBaseReflector.invoke(canvas, declaredMethod, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i4), Integer.valueOf(i5));
        if (objInvoke instanceof Integer) {
            return ((Integer) objInvoke).intValue();
        }
        return -1;
    }
}
