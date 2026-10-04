package androidx.test.internal.util;

import androidx.annotation.RestrictTo;
import androidx.constraintlayout.motion.widget.AbstractC2322a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes4.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@Deprecated
public class ReflectionUtil {
    private static final String TAG = "ReflectionUtil";

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static class ReflectionException extends Exception {
        public ReflectionException(Exception exc) {
            super("Reflective call failed", exc);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class ReflectionParams {
        final Class<?> type;
        final Object value;

        public ReflectionParams(Class<?> cls, Object obj) {
            this.type = cls;
            this.value = obj;
        }

        public static Class<?>[] getTypes(ReflectionParams[] reflectionParamsArr) {
            Class<?>[] clsArr = new Class[reflectionParamsArr.length];
            for (int i = 0; i < reflectionParamsArr.length; i++) {
                clsArr[i] = reflectionParamsArr[i].type;
            }
            return clsArr;
        }

        public static Object[] getValues(ReflectionParams[] reflectionParamsArr) {
            Object[] objArr = new Object[reflectionParamsArr.length];
            for (int i = 0; i < reflectionParamsArr.length; i++) {
                objArr[i] = reflectionParamsArr[i].value;
            }
            return objArr;
        }
    }

    public static Object callStaticMethod(String str, String str2, ReflectionParams... reflectionParamsArr) throws ReflectionException {
        try {
            return callStaticMethod(Class.forName(str), str2, reflectionParamsArr);
        } catch (ClassNotFoundException e) {
            throw new ReflectionException(e);
        }
    }

    public static Object callStaticMethod(Class<?> cls, String str, ReflectionParams... reflectionParamsArr) throws ReflectionException {
        AbstractC2322a.m1609C("Attempting to reflectively call: ", str, TAG);
        try {
            Class<?>[] types = ReflectionParams.getTypes(reflectionParamsArr);
            Object[] values = ReflectionParams.getValues(reflectionParamsArr);
            Method declaredMethod = cls.getDeclaredMethod(str, types);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(null, values);
        } catch (IllegalAccessException e) {
            throw new ReflectionException(e);
        } catch (NoSuchMethodException e2) {
            throw new ReflectionException(e2);
        } catch (InvocationTargetException e3) {
            throw new ReflectionException(e3);
        }
    }
}
