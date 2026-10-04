package androidx.reflect.view;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.PointerIcon;
import android.view.View;
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
public class SeslViewReflector {
    private static final String TAG = "SeslViewReflector";
    private static final Class<?> mClass = View.class;

    private SeslViewReflector() {
    }

    public static void clearAccessibilityFocus(@NonNull View view) {
        Method method = SeslBaseReflector.getMethod(mClass, "clearAccessibilityFocus", (Class<?>[]) new Class[0]);
        if (method != null) {
            SeslBaseReflector.invoke(view, method, new Object[0]);
        }
    }

    public static int getField_mPaddingLeft(@NonNull View view) {
        Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "mPaddingLeft");
        if (declaredField == null) {
            return 0;
        }
        Object obj = SeslBaseReflector.get(view, declaredField);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public static int getField_mPaddingRight(@NonNull View view) {
        Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "mPaddingRight");
        if (declaredField == null) {
            return 0;
        }
        Object obj = SeslBaseReflector.get(view, declaredField);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    public static void getWindowDisplayFrame(@NonNull View view, @NonNull Rect rect) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "getWindowDisplayFrame", (Class<?>[]) new Class[]{Rect.class});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(view, declaredMethod, rect);
        }
    }

    public static boolean isHighContrastTextEnabled(@NonNull View view) {
        Method method = SeslBaseReflector.getMethod(mClass, Build.VERSION.SDK_INT >= 29 ? "semIsHighContrastTextEnabled" : "isHighContrastTextEnabled", (Class<?>[]) new Class[0]);
        if (method != null) {
            Object objInvoke = SeslBaseReflector.invoke(view, method, new Object[0]);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        }
        return false;
    }

    public static boolean isHoveringUIEnabled(@NonNull View view) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "isHoveringUIEnabled", (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            Object objInvoke = SeslBaseReflector.invoke(view, declaredMethod, new Object[0]);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        }
        return false;
    }

    public static boolean isInScrollingContainer(@NonNull View view) {
        Method method = Build.VERSION.SDK_INT <= 30 ? SeslBaseReflector.getMethod(mClass, "isInScrollingContainer", (Class<?>[]) new Class[0]) : SeslBaseReflector.getMethod(mClass, "hidden_isInScrollingContainer", (Class<?>[]) new Class[0]);
        if (method != null) {
            Object objInvoke = SeslBaseReflector.invoke(view, method, new Object[0]);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        }
        return false;
    }

    public static boolean isVisibleToUser(@NonNull View view) {
        return isVisibleToUser(view, null);
    }

    public static void notifyViewAccessibilityStateChangedIfNeeded(@NonNull View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method method = i2 <= 30 ? SeslBaseReflector.getMethod(mClass, "notifyViewAccessibilityStateChangedIfNeeded", (Class<?>[]) new Class[]{cls}) : SeslBaseReflector.getMethod(mClass, "hidden_notifyViewAccessibilityStateChangedIfNeeded", (Class<?>[]) new Class[]{cls});
        if (method != null) {
            SeslBaseReflector.invoke(view, method, Integer.valueOf(i));
        }
    }

    public static boolean requestAccessibilityFocus(@NonNull View view) {
        Method method = SeslBaseReflector.getMethod(mClass, "requestAccessibilityFocus", (Class<?>[]) new Class[0]);
        if (method != null) {
            Object objInvoke = SeslBaseReflector.invoke(view, method, new Object[0]);
            if (objInvoke instanceof Boolean) {
                return ((Boolean) objInvoke).booleanValue();
            }
        }
        return false;
    }

    public static void resetPaddingToInitialValues(@NonNull View view) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "resetPaddingToInitialValues", (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(view, declaredMethod, new Object[0]);
        }
    }

    public static void resolvePadding(@NonNull View view) {
        Method declaredMethod = Build.VERSION.SDK_INT <= 30 ? SeslBaseReflector.getDeclaredMethod(mClass, "resolvePadding", (Class<?>[]) new Class[0]) : SeslBaseReflector.getDeclaredMethod(mClass, "hidden_resolvePadding", (Class<?>[]) new Class[0]);
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(view, declaredMethod, new Object[0]);
        }
    }

    public static Object semGetHoverPopup(@NonNull View view, boolean z) {
        int i = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        if (i >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semGetHoverPopup", (Class<?>[]) new Class[]{cls});
            if (declaredMethod != null) {
                return SeslBaseReflector.invoke(view, declaredMethod, Boolean.valueOf(z));
            }
            return null;
        }
        Method method = SeslBaseReflector.getMethod(mClass, "semGetHoverPopup", (Class<?>[]) new Class[]{cls});
        if (method != null) {
            return SeslBaseReflector.invoke(view, method, Boolean.valueOf(z));
        }
        return null;
    }

    public static int semGetHoverPopupType(@NonNull View view) {
        Method method = SeslBaseReflector.getMethod(mClass, "semGetHoverPopupType", (Class<?>[]) new Class[0]);
        if (method != null) {
            Object objInvoke = SeslBaseReflector.invoke(view, method, new Object[0]);
            if (objInvoke instanceof Integer) {
                return ((Integer) objInvoke).intValue();
            }
        }
        return 0;
    }

    public static void semSetBlurInfo(@NonNull View view, @Nullable Object obj) {
        if (Build.VERSION.SDK_INT >= 31) {
            try {
                Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semSetBlurInfo", (Class<?>[]) new Class[]{Class.forName("android.view.SemBlurInfo")});
                if (declaredMethod != null) {
                    SeslBaseReflector.invoke(view, declaredMethod, obj);
                }
            } catch (ClassNotFoundException e) {
                Log.e(TAG, "semSetBlurInfo ClassNotFoundException", e);
            }
        }
    }

    public static void semSetDirectPenInputEnabled(@NonNull View view, boolean z) {
        int i = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        Method declaredMethod = i >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semSetDirectPenInputEnabled", (Class<?>[]) new Class[]{cls}) : SeslBaseReflector.getMethod(mClass, "semSetDirectPenInputEnabled", (Class<?>[]) new Class[]{cls});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(view, declaredMethod, Boolean.valueOf(z));
        }
    }

    public static void semSetHoverPopupType(@NonNull View view, int i) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semSetHoverPopupType", (Class<?>[]) new Class[]{cls}) : SeslBaseReflector.getMethod(mClass, "semSetHoverPopupType", (Class<?>[]) new Class[]{cls});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(view, declaredMethod, Integer.valueOf(i));
        }
    }

    public static void semSetPointerIcon(@NonNull View view, int i, PointerIcon pointerIcon) {
        int i2 = Build.VERSION.SDK_INT;
        Class cls = Integer.TYPE;
        Method declaredMethod = i2 >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semSetPointerIcon", (Class<?>[]) new Class[]{cls, PointerIcon.class}) : SeslBaseReflector.getMethod(mClass, "semSetPointerIcon", (Class<?>[]) new Class[]{cls, PointerIcon.class});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(view, declaredMethod, Integer.valueOf(i), pointerIcon);
        }
    }

    public static void semSetScrollBarBottomPadding(@NonNull View view, @NonNull int i) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "semSetScrollBarBottomPadding", (Class<?>[]) new Class[]{Integer.TYPE});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(view, declaredMethod, Integer.valueOf(i));
        }
    }

    public static void semSetScrollBarTopPadding(@NonNull View view, @NonNull int i) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "semSetScrollBarTopPadding", (Class<?>[]) new Class[]{Integer.TYPE});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(view, declaredMethod, Integer.valueOf(i));
        }
    }

    public static void setField_mPaddingLeft(@NonNull View view, int i) {
        Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "mPaddingLeft");
        if (declaredField != null) {
            SeslBaseReflector.set(view, declaredField, Integer.valueOf(i));
        }
    }

    public static void setField_mPaddingRight(@NonNull View view, int i) {
        Field declaredField = SeslBaseReflector.getDeclaredField(mClass, "mPaddingRight");
        if (declaredField != null) {
            SeslBaseReflector.set(view, declaredField, Integer.valueOf(i));
        }
    }

    public static void setFrameContentVelocity(@NonNull View view, @NonNull float f) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "setFrameContentVelocity", (Class<?>[]) new Class[]{Float.TYPE});
        if (declaredMethod != null) {
            SeslBaseReflector.invoke(view, declaredMethod, Float.valueOf(f));
        }
    }

    public static boolean isVisibleToUser(@NonNull View view, Rect rect) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mClass, "isVisibleToUser", (Class<?>[]) new Class[]{Rect.class});
        if (declaredMethod == null) {
            return false;
        }
        Object objInvoke = SeslBaseReflector.invoke(view, declaredMethod, rect);
        if (objInvoke instanceof Boolean) {
            return ((Boolean) objInvoke).booleanValue();
        }
        return false;
    }
}
