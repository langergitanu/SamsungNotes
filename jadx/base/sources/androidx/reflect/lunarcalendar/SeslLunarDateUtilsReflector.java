package androidx.reflect.lunarcalendar;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import androidx.reflect.SeslPathClassReflector;
import dalvik.system.PathClassLoader;
import java.lang.reflect.Method;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslLunarDateUtilsReflector {
    private static final String mClassName = "com.android.calendar.event.widget.datetimepicker.LunarDateUtils";

    private SeslLunarDateUtilsReflector() {
    }

    @Nullable
    public static String buildLunarDateString(@NonNull PathClassLoader pathClassLoader, @NonNull Calendar calendar, @NonNull Context context) {
        Method method = SeslPathClassReflector.getMethod(pathClassLoader, mClassName, "buildLunarDateString", Calendar.class, Context.class);
        if (method != null) {
            Object objInvoke = SeslBaseReflector.invoke(null, method, calendar, context);
            if (objInvoke instanceof String) {
                return (String) objInvoke;
            }
        }
        return null;
    }
}
