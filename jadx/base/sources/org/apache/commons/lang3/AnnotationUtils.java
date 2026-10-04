package org.apache.commons.lang3;

import com.samsung.android.sdk.scs.base.utils.Log;
import com.samsung.android.support.senl.p148nt.data.database.core.query.sqlbuilder.SQLKeyword;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.commons.lang3.exception.UncheckedException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class AnnotationUtils {
    private static final ToStringStyle TO_STRING_STYLE = new C137821();

    /* JADX INFO: renamed from: org.apache.commons.lang3.AnnotationUtils$1 */
    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public class C137821 extends ToStringStyle {
        private static final long serialVersionUID = 1;

        public C137821() {
            setDefaultFullDetail(true);
            setArrayContentDetail(true);
            setUseClassName(true);
            setUseShortClassName(true);
            setUseIdentityHashCode(false);
            setContentStart("(");
            setContentEnd(")");
            setFieldSeparator(SQLKeyword.COMMA);
            setArrayStart("[");
            setArrayEnd("]");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$getShortClassName$0(Class cls) {
            return Log.TAG_SEPARATOR.concat(cls.getName());
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public void appendDetail(StringBuffer stringBuffer, String str, Object obj) {
            if (obj instanceof Annotation) {
                obj = AnnotationUtils.toString((Annotation) obj);
            }
            super.appendDetail(stringBuffer, str, obj);
        }

        @Override // org.apache.commons.lang3.builder.ToStringStyle
        public String getShortClassName(Class<?> cls) {
            int i = 0;
            return (String) ClassUtils.getAllInterfaces(cls).stream().filter(new C13790a(i)).findFirst().map(new C13791b(i)).orElse("");
        }
    }

    @Deprecated
    public AnnotationUtils() {
    }

    private static boolean annotationArrayMemberEquals(Annotation[] annotationArr, Annotation[] annotationArr2) {
        if (annotationArr.length != annotationArr2.length) {
            return false;
        }
        for (int i = 0; i < annotationArr.length; i++) {
            if (!equals(annotationArr[i], annotationArr2[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean arrayMemberEquals(Class<?> cls, Object obj, Object obj2) {
        return cls.isAnnotation() ? annotationArrayMemberEquals((Annotation[]) obj, (Annotation[]) obj2) : cls.equals(Byte.TYPE) ? Arrays.equals((byte[]) obj, (byte[]) obj2) : cls.equals(Short.TYPE) ? Arrays.equals((short[]) obj, (short[]) obj2) : cls.equals(Integer.TYPE) ? Arrays.equals((int[]) obj, (int[]) obj2) : cls.equals(Character.TYPE) ? Arrays.equals((char[]) obj, (char[]) obj2) : cls.equals(Long.TYPE) ? Arrays.equals((long[]) obj, (long[]) obj2) : cls.equals(Float.TYPE) ? Arrays.equals((float[]) obj, (float[]) obj2) : cls.equals(Double.TYPE) ? Arrays.equals((double[]) obj, (double[]) obj2) : cls.equals(Boolean.TYPE) ? Arrays.equals((boolean[]) obj, (boolean[]) obj2) : Arrays.equals((Object[]) obj, (Object[]) obj2);
    }

    private static int arrayMemberHash(Class<?> cls, Object obj) {
        return cls.equals(Byte.TYPE) ? Arrays.hashCode((byte[]) obj) : cls.equals(Short.TYPE) ? Arrays.hashCode((short[]) obj) : cls.equals(Integer.TYPE) ? Arrays.hashCode((int[]) obj) : cls.equals(Character.TYPE) ? Arrays.hashCode((char[]) obj) : cls.equals(Long.TYPE) ? Arrays.hashCode((long[]) obj) : cls.equals(Float.TYPE) ? Arrays.hashCode((float[]) obj) : cls.equals(Double.TYPE) ? Arrays.hashCode((double[]) obj) : cls.equals(Boolean.TYPE) ? Arrays.hashCode((boolean[]) obj) : Arrays.hashCode((Object[]) obj);
    }

    public static boolean equals(Annotation annotation, Annotation annotation2) {
        if (annotation == annotation2) {
            return true;
        }
        if (annotation != null && annotation2 != null) {
            Class<? extends Annotation> clsAnnotationType = annotation.annotationType();
            Class<? extends Annotation> clsAnnotationType2 = annotation2.annotationType();
            Validate.notNull(clsAnnotationType, "Annotation %s with null annotationType()", annotation);
            Validate.notNull(clsAnnotationType2, "Annotation %s with null annotationType()", annotation2);
            if (!clsAnnotationType.equals(clsAnnotationType2)) {
                return false;
            }
            try {
                for (Method method : clsAnnotationType.getDeclaredMethods()) {
                    if (method.getParameterTypes().length == 0 && isValidAnnotationMemberType(method.getReturnType())) {
                        if (!memberEquals(method.getReturnType(), method.invoke(annotation, null), method.invoke(annotation2, null))) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (ReflectiveOperationException unused) {
            }
        }
        return false;
    }

    public static int hashCode(Annotation annotation) {
        int iHashMember = 0;
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            try {
                Object objInvoke = method.invoke(annotation, null);
                if (objInvoke == null) {
                    throw new IllegalStateException("Annotation method " + method + " returned null");
                }
                iHashMember += hashMember(method.getName(), objInvoke);
            } catch (ReflectiveOperationException e) {
                throw new UncheckedException(e);
            }
        }
        return iHashMember;
    }

    private static int hashMember(String str, Object obj) {
        return (str.hashCode() * 127) ^ (ObjectUtils.isArray(obj) ? arrayMemberHash(obj.getClass().getComponentType(), obj) : obj instanceof Annotation ? hashCode((Annotation) obj) : obj.hashCode());
    }

    public static boolean isValidAnnotationMemberType(Class<?> cls) {
        if (cls == null) {
            return false;
        }
        if (cls.isArray()) {
            cls = cls.getComponentType();
        }
        return cls.isPrimitive() || cls.isEnum() || cls.isAnnotation() || String.class.equals(cls) || Class.class.equals(cls);
    }

    private static boolean memberEquals(Class<?> cls, Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return cls.isArray() ? arrayMemberEquals(cls.getComponentType(), obj, obj2) : cls.isAnnotation() ? equals((Annotation) obj, (Annotation) obj2) : obj.equals(obj2);
    }

    public static String toString(Annotation annotation) {
        ToStringBuilder toStringBuilder = new ToStringBuilder(annotation, TO_STRING_STYLE);
        for (Method method : annotation.annotationType().getDeclaredMethods()) {
            if (method.getParameterTypes().length <= 0) {
                try {
                    toStringBuilder.append(method.getName(), method.invoke(annotation, null));
                } catch (ReflectiveOperationException e) {
                    throw new UncheckedException(e);
                }
            }
        }
        return toStringBuilder.build();
    }
}
