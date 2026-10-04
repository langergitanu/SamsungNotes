package androidx.reflect.widget;

import android.os.Build;
import android.widget.AdapterView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslAdapterViewReflector {
    private static final Class<?> mClass = AdapterView.class;

    private SeslAdapterViewReflector() {
    }

    public static int getField_mSelectedPosition(@NonNull AdapterView adapterView) {
        Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "mSelectedPosition");
        if (declaredField == null) {
            return -1;
        }
        Object obj = SeslBaseReflector.get(adapterView, declaredField);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return -1;
    }

    public static void semSetBottomColor(@NonNull AdapterView adapterView, @ColorInt int i) {
        int i2 = Build.VERSION.SDK_INT;
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, i2 >= 29 ? "hidden_semSetBottomColor" : i2 >= 28 ? "semSetBottomColor" : null, (Class<?>[]) new Class[]{Integer.TYPE});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(adapterView, declaredMethod, Integer.valueOf(i));
        }
    }
}
