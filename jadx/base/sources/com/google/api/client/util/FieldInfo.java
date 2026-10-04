package com.google.api.client.util;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes5.dex */
public class FieldInfo {
    private static final Map<Field, FieldInfo> CACHE = new WeakHashMap();
    private final Field field;
    private final boolean isPrimitive;
    private final String name;

    public FieldInfo(Field field, String str) {
        this.field = field;
        this.name = str == null ? null : str.intern();
        this.isPrimitive = Data.isPrimitive(getType());
    }

    public static Object getFieldValue(Field field, Object obj) {
        try {
            return field.get(obj);
        } catch (IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /* JADX INFO: renamed from: of */
    public static FieldInfo m4226of(Enum<?> r32) {
        try {
            FieldInfo fieldInfoM4227of = m4227of(r32.getClass().getField(r32.name()));
            Preconditions.checkArgument(fieldInfoM4227of != null, "enum constant missing @Value or @NullValue annotation: %s", r32);
            return fieldInfoM4227of;
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static void setFieldValue(Field field, Object obj, Object obj2) {
        if (!Modifier.isFinal(field.getModifiers())) {
            try {
                field.set(obj, obj2);
                return;
            } catch (IllegalAccessException e) {
                throw new IllegalArgumentException(e);
            } catch (SecurityException e2) {
                throw new IllegalArgumentException(e2);
            }
        }
        Object fieldValue = getFieldValue(field, obj);
        if (obj2 == null) {
            if (fieldValue == null) {
                return;
            }
        } else if (obj2.equals(fieldValue)) {
            return;
        }
        throw new IllegalArgumentException("expected final value <" + fieldValue + "> but was <" + obj2 + "> on " + field.getName() + " field in " + obj.getClass().getName());
    }

    public <T extends Enum<T>> T enumValue() {
        return (T) Enum.valueOf(this.field.getDeclaringClass(), this.field.getName());
    }

    public ClassInfo getClassInfo() {
        return ClassInfo.m4224of(this.field.getDeclaringClass());
    }

    public Field getField() {
        return this.field;
    }

    public Type getGenericType() {
        return this.field.getGenericType();
    }

    public String getName() {
        return this.name;
    }

    public Class<?> getType() {
        return this.field.getType();
    }

    public Object getValue(Object obj) {
        return getFieldValue(this.field, obj);
    }

    public boolean isFinal() {
        return Modifier.isFinal(this.field.getModifiers());
    }

    public boolean isPrimitive() {
        return this.isPrimitive;
    }

    public void setValue(Object obj, Object obj2) {
        setFieldValue(this.field, obj, obj2);
    }

    /* JADX INFO: renamed from: of */
    public static FieldInfo m4227of(Field field) {
        String strValue = null;
        if (field == null) {
            return null;
        }
        Map<Field, FieldInfo> map = CACHE;
        synchronized (map) {
            try {
                FieldInfo fieldInfo = map.get(field);
                boolean zIsEnumConstant = field.isEnumConstant();
                if (fieldInfo == null && (zIsEnumConstant || !Modifier.isStatic(field.getModifiers()))) {
                    if (zIsEnumConstant) {
                        Value value = (Value) field.getAnnotation(Value.class);
                        if (value != null) {
                            strValue = value.value();
                        } else if (((NullValue) field.getAnnotation(NullValue.class)) == null) {
                            return null;
                        }
                    } else {
                        Key key = (Key) field.getAnnotation(Key.class);
                        if (key == null) {
                            return null;
                        }
                        strValue = key.value();
                        field.setAccessible(true);
                    }
                    if ("##default".equals(strValue)) {
                        strValue = field.getName();
                    }
                    fieldInfo = new FieldInfo(field, strValue);
                    map.put(field, fieldInfo);
                }
                return fieldInfo;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
