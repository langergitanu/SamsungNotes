package androidx.reflect.view;

import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslDecorViewReflector {
    private SeslDecorViewReflector() {
    }

    public static void semSetForceHideRoundedCorner(@NonNull View view, boolean z) {
        Method declaredMethod;
        if (Build.VERSION.SDK_INT < 30 || (declaredMethod = SeslBaseReflector.getDeclaredMethod(view.getClass(), "hidden_semSetForceHideRoundedCorner", (Class<?>[]) new Class[]{Boolean.TYPE})) == null) {
            return;
        }
        SeslBaseReflector.invoke(view, declaredMethod, Boolean.valueOf(z));
    }
}
