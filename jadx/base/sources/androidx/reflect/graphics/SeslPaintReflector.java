package androidx.reflect.graphics;

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
public class SeslPaintReflector {
    private static final Class<?> mClass = Paint.class;

    private SeslPaintReflector() {
    }

    public static float getHCTStrokeWidth(@NonNull Paint paint) {
        Method method = SeslBaseReflector.getMethod(mClass, "getHCTStrokeWidth", (Class<?>[]) new Class[0]);
        if (method == null) {
            return 0.0f;
        }
        Object objInvoke = SeslBaseReflector.invoke(paint, method, new Object[0]);
        if (objInvoke instanceof Float) {
            return ((Float) objInvoke).floatValue();
        }
        return 0.0f;
    }
}
