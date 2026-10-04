package uk.p245ac.p246ed.p247ph.snuggletex.internal.util;

import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes11.dex */
public final class ObjectUtilities {
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];

    public static String beanToString(Object obj) {
        String strSubstring;
        Class<?> cls = obj.getClass();
        StringBuilder sb = new StringBuilder(cls.getName());
        sb.append(Log.TAG_SEPARATOR);
        sb.append(Integer.toHexString(System.identityHashCode(obj)));
        sb.append("(");
        boolean z = false;
        for (Method method : cls.getMethods()) {
            String name = method.getName();
            if (name.startsWith("get") && method.getParameterTypes().length == 0 && !name.equals("getClass") && name.length() > 3) {
                strSubstring = name.substring(3);
            } else if (name.startsWith("is") && method.getParameterTypes().length == 0 && name.length() > 2) {
                strSubstring = name.substring(2);
            }
            BeanToStringOptions beanToStringOptions = (BeanToStringOptions) method.getAnnotation(BeanToStringOptions.class);
            PropertyOptions propertyOptionsValue = beanToStringOptions != null ? beanToStringOptions.value() : null;
            if (propertyOptionsValue == null || propertyOptionsValue != PropertyOptions.IGNORE_PROPERTY) {
                if (z) {
                    sb.append(",");
                } else {
                    z = true;
                }
                sb.append(Character.toLowerCase(strSubstring.charAt(0)));
                if (name.length() > 1) {
                    sb.append(strSubstring.substring(1));
                }
                sb.append(MarketingConstants.REFERRER_DELIMITER_U003D);
                try {
                    Object objInvoke = method.invoke(obj, null);
                    if (propertyOptionsValue != null && propertyOptionsValue == PropertyOptions.HIDE_VALUE) {
                        sb.append("[hidden]");
                    } else if (objInvoke instanceof Object[]) {
                        sb.append(Arrays.toString((Object[]) objInvoke));
                    } else {
                        sb.append(objInvoke);
                    }
                } catch (Exception e) {
                    sb.append("[Caused Exception ");
                    sb.append(e);
                    sb.append("]");
                }
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static <E> E[] concat(E[] eArr, E[] eArr2, Class<E> cls) {
        boolean zIsNullOrEmpty = isNullOrEmpty(eArr);
        boolean zIsNullOrEmpty2 = isNullOrEmpty(eArr2);
        if (zIsNullOrEmpty && zIsNullOrEmpty2) {
            return (E[]) ((Object[]) Array.newInstance((Class<?>) cls, 0));
        }
        if (zIsNullOrEmpty) {
            return eArr2;
        }
        if (zIsNullOrEmpty2) {
            return eArr;
        }
        E[] eArr3 = (E[]) ((Object[]) Array.newInstance((Class<?>) cls, eArr.length + eArr2.length));
        System.arraycopy(eArr, 0, eArr3, 0, eArr.length);
        System.arraycopy(eArr2, 0, eArr3, eArr.length, eArr2.length);
        return eArr3;
    }

    public static boolean isNullOrEmpty(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean nullSafeEquals(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static String safeToString(Object obj) {
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }
}
