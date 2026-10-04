package androidx.reflect.widget;

import android.os.Build;
import android.widget.AbsListView;
import android.widget.EdgeEffect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslAbsListViewReflector {
    private static final Class<?> mClass = AbsListView.class;

    private SeslAbsListViewReflector() {
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static EdgeEffect getField_mEdgeGlowTop(@NonNull AbsListView absListView) {
        Object objInvoke;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_mEdgeGlowTop", (Class<?>[]) new Class[0]);
            objInvoke = declaredMethod != null ? SeslBaseReflector.invoke(absListView, declaredMethod, new Object[0]) : null;
        } else {
            Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "mEdgeGlowTop");
            if (declaredField != null) {
                objInvoke = SeslBaseReflector.get(absListView, declaredField);
            }
        }
        if (objInvoke instanceof EdgeEffect) {
            return (EdgeEffect) objInvoke;
        }
        return null;
    }

    public static void setField_mEdgeGlowBottom(@NonNull AbsListView absListView, @NonNull EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_mEdgeGlowBottom", (Class<?>[]) new Class[]{EdgeEffect.class});
            if (declaredMethod != null) {
                SeslBaseReflector.invoke(absListView, declaredMethod, edgeEffect);
                return;
            }
            return;
        }
        Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "mEdgeGlowBottom");
        if (declaredField != null) {
            SeslBaseReflector.set(absListView, declaredField, edgeEffect);
        }
    }

    public static void setField_mEdgeGlowTop(@NonNull AbsListView absListView, @NonNull EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_mEdgeGlowTop", (Class<?>[]) new Class[]{EdgeEffect.class});
            if (declaredMethod != null) {
                SeslBaseReflector.invoke(absListView, declaredMethod, edgeEffect);
                return;
            }
            return;
        }
        Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "mEdgeGlowTop");
        if (declaredField != null) {
            SeslBaseReflector.set(absListView, declaredField, edgeEffect);
        }
    }
}
