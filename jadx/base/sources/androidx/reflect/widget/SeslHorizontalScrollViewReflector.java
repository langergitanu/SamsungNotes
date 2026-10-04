package androidx.reflect.widget;

import android.os.Build;
import android.widget.HorizontalScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslHorizontalScrollViewReflector {
    private static final Class<?> mClass = HorizontalScrollView.class;

    private SeslHorizontalScrollViewReflector() {
    }

    public static void setTouchSlop(@NonNull HorizontalScrollView horizontalScrollView, int i) {
        Method declaredMethod;
        if (Build.VERSION.SDK_INT < 31 || (declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_setTouchSlop", (Class<?>[]) new Class[]{Integer.TYPE})) == null) {
            return;
        }
        SeslBaseReflector.invoke(horizontalScrollView, declaredMethod, Integer.valueOf(i));
    }
}
