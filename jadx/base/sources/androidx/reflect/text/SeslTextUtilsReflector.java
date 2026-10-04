package androidx.reflect.text;

import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslTextUtilsReflector {
    private static final Class<?> mClass = TextUtils.class;

    private SeslTextUtilsReflector() {
    }

    @Nullable
    public static char[] semGetPrefixCharForSpan(@NonNull TextPaint textPaint, @NonNull CharSequence charSequence, @NonNull char[] cArr) {
        Method declaredMethod = Build.VERSION.SDK_INT >= 29 ? SeslBaseReflector.getDeclaredMethod(mClass, "hidden_semGetPrefixCharForSpan", (Class<?>[]) new Class[]{TextPaint.class, CharSequence.class, char[].class}) : SeslBaseReflector.getMethod(mClass, "semGetPrefixCharForSpan", (Class<?>[]) new Class[]{TextPaint.class, CharSequence.class, char[].class});
        if (declaredMethod == null) {
            return new char[0];
        }
        Object objInvoke = SeslBaseReflector.invoke(null, declaredMethod, textPaint, charSequence, cArr);
        if (objInvoke instanceof char[]) {
            return (char[]) objInvoke;
        }
        return null;
    }
}
