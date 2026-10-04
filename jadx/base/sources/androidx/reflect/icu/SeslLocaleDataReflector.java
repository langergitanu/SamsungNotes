package androidx.reflect.icu;

import android.os.Build;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.reflect.SeslBaseReflector;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.DateFormatSymbols;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RequiresApi(23)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class SeslLocaleDataReflector {
    private static String mClassName = "libcore.icu.LocaleData";
    private static String mDateFormatSymbolsClass = "android.icu.text.DateFormatSymbols";
    private static String mSemClassName = "com.samsung.sesl.icu.SemLocaleData";
    private static String mSemDateFormatSymbolsClass = "com.samsung.sesl.icu.SemDateFormatSymbols";

    private SeslLocaleDataReflector() {
    }

    @Nullable
    public static Object get(@NonNull Locale locale) {
        Object objInvoke;
        Method declaredMethod = Build.VERSION.SDK_INT >= 29 ? SeslBaseReflector.getDeclaredMethod(mSemClassName, "get", (Class<?>[]) new Class[]{Locale.class}) : SeslBaseReflector.getMethod(mClassName, "get", (Class<?>[]) new Class[]{Locale.class});
        if (declaredMethod == null || (objInvoke = SeslBaseReflector.invoke(null, declaredMethod, locale)) == null || !objInvoke.getClass().getName().equals(mClassName)) {
            return null;
        }
        return objInvoke;
    }

    public static String[] getAmpmNarrowStrings(@NonNull Object obj) {
        Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mSemDateFormatSymbolsClass, "getAmpmNarrowStrings", (Class<?>[]) new Class[]{SeslBaseReflector.getClass(mDateFormatSymbolsClass)});
        Object objInvoke = declaredMethod != null ? SeslBaseReflector.invoke(null, declaredMethod, obj) : null;
        if (objInvoke instanceof String[]) {
            return (String[]) objInvoke;
        }
        Log.e("SeslLocaleDataReflector", "amPm narrow strings failed. Use getAmPmStrings for ampm");
        return new DateFormatSymbols().getAmPmStrings();
    }

    @Nullable
    public static String[] getField_amPm(@NonNull Object obj) {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mSemClassName, "getAmPm", (Class<?>[]) new Class[]{SeslBaseReflector.getClass(mClassName)});
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, obj);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "amPm");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(obj, field);
            }
        }
        if (objInvoke instanceof String[]) {
            return (String[]) objInvoke;
        }
        Log.e("SeslLocaleDataReflector", "amPm failed. Use DateFormatSymbols for ampm");
        return new DateFormatSymbols().getAmPmStrings();
    }

    @NonNull
    public static String getField_narrowAm(@NonNull Object obj) {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mSemClassName, "getNarrowAm", (Class<?>[]) new Class[]{SeslBaseReflector.getClass(mClassName)});
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, obj);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "narrowAm");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(obj, field);
            }
        }
        return objInvoke instanceof String ? (String) objInvoke : "Am";
    }

    @NonNull
    public static String getField_narrowPm(@NonNull Object obj) {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mSemClassName, "getNarrowPm", (Class<?>[]) new Class[]{SeslBaseReflector.getClass(mClassName)});
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, obj);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "narrowPm");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(obj, field);
            }
        }
        return objInvoke instanceof String ? (String) objInvoke : "Pm";
    }

    public static char getField_zeroDigit(@NonNull Object obj) {
        Object objInvoke = null;
        if (Build.VERSION.SDK_INT >= 29) {
            Method declaredMethod = SeslBaseReflector.getDeclaredMethod(mSemClassName, "getZeroDigit", (Class<?>[]) new Class[]{SeslBaseReflector.getClass(mClassName)});
            if (declaredMethod != null) {
                objInvoke = SeslBaseReflector.invoke(null, declaredMethod, obj);
            }
        } else {
            Field field = SeslBaseReflector.getField(mClassName, "zeroDigit");
            if (field != null) {
                objInvoke = SeslBaseReflector.get(obj, field);
            }
        }
        if (objInvoke instanceof Character) {
            return ((Character) objInvoke).charValue();
        }
        return '0';
    }
}
