package org.apache.commons.lang3.reflect;

import com.samsung.android.sdk.smp.common.constants.MarketingConstants;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.Validate;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class FieldUtils {
    @Deprecated
    public FieldUtils() {
    }

    public static Field[] getAllFields(Class<?> cls) {
        return (Field[]) getAllFieldsList(cls).toArray(ArrayUtils.EMPTY_FIELD_ARRAY);
    }

    public static List<Field> getAllFieldsList(Class<?> cls) {
        Objects.requireNonNull(cls, MarketingConstants.INTENT_CLASS);
        ArrayList arrayList = new ArrayList();
        while (cls != null) {
            Collections.addAll(arrayList, cls.getDeclaredFields());
            cls = cls.getSuperclass();
        }
        return arrayList;
    }

    public static Field getDeclaredField(Class<?> cls, String str) {
        return getDeclaredField(cls, str, false);
    }

    public static Field getField(Class<?> cls, String str) {
        return (Field) MemberUtils.setAccessibleWorkaround(getField(cls, str, false));
    }

    public static List<Field> getFieldsListWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        Objects.requireNonNull(cls2, "annotationCls");
        return (List) getAllFieldsList(cls).stream().filter(new C13895a(cls2, 0)).collect(Collectors.toList());
    }

    public static Field[] getFieldsWithAnnotation(Class<?> cls, Class<? extends Annotation> cls2) {
        return (Field[]) getFieldsListWithAnnotation(cls, cls2).toArray(ArrayUtils.EMPTY_FIELD_ARRAY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$getFieldsListWithAnnotation$0(Class cls, Field field) {
        return field.getAnnotation(cls) != null;
    }

    public static Object readDeclaredField(Object obj, String str) {
        return readDeclaredField(obj, str, false);
    }

    public static Object readDeclaredStaticField(Class<?> cls, String str) {
        return readDeclaredStaticField(cls, str, false);
    }

    public static Object readField(Field field, Object obj) {
        return readField(field, obj, false);
    }

    public static Object readStaticField(Class<?> cls, String str) {
        return readStaticField(cls, str, false);
    }

    public static void removeFinalModifier(Field field) {
        removeFinalModifier(field, true);
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeDeclaredField(obj, str, obj2, false);
    }

    public static void writeDeclaredStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        writeDeclaredStaticField(cls, str, obj, false);
    }

    public static void writeField(Field field, Object obj, Object obj2) throws IllegalAccessException {
        writeField(field, obj, obj2, false);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj) throws IllegalAccessException {
        writeStaticField(cls, str, obj, false);
    }

    public static Field getDeclaredField(Class<?> cls, String str, boolean z) {
        Objects.requireNonNull(cls, MarketingConstants.INTENT_CLASS);
        Validate.isTrue(StringUtils.isNotBlank(str), "The field name must not be blank/empty", new Object[0]);
        try {
            Field declaredField = cls.getDeclaredField(str);
            if (!MemberUtils.isAccessible(declaredField)) {
                if (!z) {
                    return null;
                }
                declaredField.setAccessible(true);
            }
            return declaredField;
        } catch (NoSuchFieldException unused) {
            return null;
        }
    }

    public static Field getField(Class<?> cls, String str, boolean z) {
        Field declaredField;
        Objects.requireNonNull(cls, MarketingConstants.INTENT_CLASS);
        Validate.isTrue(StringUtils.isNotBlank(str), "The field name must not be blank/empty", new Object[0]);
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                declaredField = superclass.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
            }
            if (!MemberUtils.isPublic(declaredField)) {
                if (z) {
                    declaredField.setAccessible(true);
                }
            }
            return declaredField;
        }
        Iterator<Class<?>> it = ClassUtils.getAllInterfaces(cls).iterator();
        Field field = null;
        while (it.hasNext()) {
            try {
                Field field2 = it.next().getField(str);
                Validate.isTrue(field == null, "Reference to field %s is ambiguous relative to %s; a matching field exists on two or more implemented interfaces.", str, cls);
                field = field2;
            } catch (NoSuchFieldException unused2) {
            }
        }
        return field;
    }

    public static Object readDeclaredField(Object obj, String str, boolean z) {
        Objects.requireNonNull(obj, "target");
        Class<?> cls = obj.getClass();
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls, str);
        return readField(declaredField, obj, false);
    }

    public static Object readDeclaredStaticField(Class<?> cls, String str, boolean z) {
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.notNull(declaredField, "Cannot locate declared field %s.%s", cls.getName(), str);
        return readStaticField(declaredField, false);
    }

    public static Object readField(Field field, Object obj, boolean z) {
        Objects.requireNonNull(field, "field");
        if (!z || field.isAccessible()) {
            MemberUtils.setAccessibleWorkaround(field);
        } else {
            field.setAccessible(true);
        }
        return field.get(obj);
    }

    public static Object readStaticField(Class<?> cls, String str, boolean z) {
        Field field = getField(cls, str, z);
        Validate.notNull(field, "Cannot locate field '%s' on %s", str, cls);
        return readStaticField(field, false);
    }

    @Deprecated
    public static void removeFinalModifier(Field field, boolean z) {
        Objects.requireNonNull(field, "field");
        try {
            if (Modifier.isFinal(field.getModifiers())) {
                Field declaredField = Field.class.getDeclaredField("modifiers");
                boolean z2 = z && !declaredField.isAccessible();
                if (z2) {
                    declaredField.setAccessible(true);
                }
                try {
                    declaredField.setInt(field, field.getModifiers() & (-17));
                } finally {
                    if (z2) {
                        declaredField.setAccessible(false);
                    }
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            if (SystemUtils.isJavaVersionAtLeast(JavaVersion.JAVA_12)) {
                throw new UnsupportedOperationException("In java 12+ final cannot be removed.", e);
            }
        }
    }

    public static void writeDeclaredField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Objects.requireNonNull(obj, "target");
        Class<?> cls = obj.getClass();
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.isTrue(declaredField != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(declaredField, obj, obj2, false);
    }

    public static void writeDeclaredStaticField(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Field declaredField = getDeclaredField(cls, str, z);
        Validate.notNull(declaredField, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(declaredField, (Object) null, obj, false);
    }

    public static void writeField(Field field, Object obj, Object obj2, boolean z) throws IllegalAccessException {
        Objects.requireNonNull(field, "field");
        if (!z || field.isAccessible()) {
            MemberUtils.setAccessibleWorkaround(field);
        } else {
            field.setAccessible(true);
        }
        field.set(obj, obj2);
    }

    public static void writeStaticField(Class<?> cls, String str, Object obj, boolean z) throws IllegalAccessException {
        Field field = getField(cls, str, z);
        Validate.notNull(field, "Cannot locate field %s on %s", str, cls);
        writeStaticField(field, obj, false);
    }

    public static Object readStaticField(Field field) {
        return readStaticField(field, false);
    }

    public static void writeStaticField(Field field, Object obj) throws IllegalAccessException {
        writeStaticField(field, obj, false);
    }

    public static Object readStaticField(Field field, boolean z) {
        Objects.requireNonNull(field, "field");
        Validate.isTrue(MemberUtils.isStatic(field), "The field '%s' is not static", field.getName());
        return readField(field, (Object) null, z);
    }

    public static void writeStaticField(Field field, Object obj, boolean z) throws IllegalAccessException {
        Objects.requireNonNull(field, "field");
        Validate.isTrue(MemberUtils.isStatic(field), "The field %s.%s is not static", field.getDeclaringClass().getName(), field.getName());
        writeField(field, (Object) null, obj, z);
    }

    public static Object readField(Object obj, String str) {
        return readField(obj, str, false);
    }

    public static void writeField(Object obj, String str, Object obj2) throws IllegalAccessException {
        writeField(obj, str, obj2, false);
    }

    public static Object readField(Object obj, String str, boolean z) {
        Objects.requireNonNull(obj, "target");
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, z);
        Validate.isTrue(field != null, "Cannot locate field %s on %s", str, cls);
        return readField(field, obj, false);
    }

    public static void writeField(Object obj, String str, Object obj2, boolean z) throws IllegalAccessException {
        Objects.requireNonNull(obj, "target");
        Class<?> cls = obj.getClass();
        Field field = getField(cls, str, z);
        Validate.isTrue(field != null, "Cannot locate declared field %s.%s", cls.getName(), str);
        writeField(field, obj, obj2, false);
    }
}
