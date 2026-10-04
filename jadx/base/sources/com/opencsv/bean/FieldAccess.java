package com.opencsv.bean;

import com.opencsv.bean.function.AccessorInvoker;
import com.opencsv.bean.function.AssignmentInvoker;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;
import org.apache.commons.beanutils.FluentPropertyBeanIntrospector;
import org.apache.commons.lang3.reflect.FieldUtils;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes6.dex */
public class FieldAccess<T> {
    private final AccessorInvoker<Object, T> accessor = determineAccessorMethod();
    private final AssignmentInvoker<Object, T> assignment = determineAssignmentMethod();
    private final Field field;

    public FieldAccess(Field field) {
        this.field = field;
    }

    private AccessorInvoker<Object, T> determineAccessorMethod() {
        try {
            Method method = this.field.getDeclaringClass().getMethod("get" + Character.toUpperCase(this.field.getName().charAt(0)) + this.field.getName().substring(1), null);
            return method.getReturnType().equals(Optional.class) ? new C6626i(method, 2) : new C6626i(method, 3);
        } catch (NoSuchMethodException unused) {
            return new C6627j(this);
        }
    }

    private AssignmentInvoker<Object, T> determineAssignmentMethod() {
        String str = FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX + Character.toUpperCase(this.field.getName().charAt(0)) + this.field.getName().substring(1);
        try {
            try {
                Method method = this.field.getDeclaringClass().getMethod(str, this.field.getType());
                method.getClass();
                return new C6626i(method, 0);
            } catch (NoSuchMethodException unused) {
                return new C6626i(this.field.getDeclaringClass().getMethod(str, Optional.class), 1);
            }
        } catch (NoSuchMethodException unused2) {
            return new C6627j(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$determineAccessorMethod$0(Method method, Object obj) {
        return ((Optional) method.invoke(obj, null)).orElse(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Object lambda$determineAccessorMethod$1(Method method, Object obj) {
        return method.invoke(obj, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object lambda$determineAccessorMethod$2(Object obj) {
        return FieldUtils.readField(this.field, obj, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$determineAssignmentMethod$3(Method method, Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        method.invoke(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$determineAssignmentMethod$4(Method method, Object obj, Object obj2) throws IllegalAccessException, InvocationTargetException {
        method.invoke(obj, Optional.ofNullable(obj2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$determineAssignmentMethod$5(Object obj, Object obj2) throws IllegalAccessException {
        FieldUtils.writeField(this.field, obj, obj2, true);
    }

    public boolean equals(Object obj) {
        if (obj instanceof FieldAccess) {
            return this.field.equals(((FieldAccess) obj).field);
        }
        return false;
    }

    public T getField(Object obj) {
        return this.accessor.invoke(obj);
    }

    public int hashCode() {
        return this.field.hashCode();
    }

    public void setField(Object obj, T t) {
        this.assignment.invoke(obj, t);
    }

    public String toString() {
        return this.field.toString();
    }
}
