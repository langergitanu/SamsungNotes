package kotlin.reflect.jvm;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KCallable;
import kotlin.reflect.KFunction;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.UtilKt;
import kotlin.reflect.jvm.internal.calls.Caller;
import org.apache.commons.beanutils.PropertyUtils;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(m13885d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\",\u0010\u0002\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0002\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, m13886d2 = {"value", "", "isAccessible", "Lkotlin/reflect/KCallable;", "(Lkotlin/reflect/KCallable;)Z", "setAccessible", "(Lkotlin/reflect/KCallable;Z)V", "kotlin-reflection"}, m13887k = 2, m13888mv = {2, 0, 0}, m13890xi = 48)
@JvmName(name = "KCallablesJvm")
public final class KCallablesJvm {
    public static final boolean isAccessible(@NotNull KCallable<?> kCallable) {
        Caller<?> defaultCaller;
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        if (kCallable instanceof KMutableProperty) {
            KProperty kProperty = (KProperty) kCallable;
            Field javaField = ReflectJvmMapping.getJavaField(kProperty);
            if (javaField != null ? javaField.isAccessible() : true) {
                Method javaGetter = ReflectJvmMapping.getJavaGetter(kProperty);
                if (javaGetter != null ? javaGetter.isAccessible() : true) {
                    Method javaSetter = ReflectJvmMapping.getJavaSetter((KMutableProperty) kCallable);
                    if (javaSetter != null ? javaSetter.isAccessible() : true) {
                        return true;
                    }
                }
            }
            return false;
        }
        if (kCallable instanceof KProperty) {
            KProperty kProperty2 = (KProperty) kCallable;
            Field javaField2 = ReflectJvmMapping.getJavaField(kProperty2);
            if (javaField2 != null ? javaField2.isAccessible() : true) {
                Method javaGetter2 = ReflectJvmMapping.getJavaGetter(kProperty2);
                if (javaGetter2 != null ? javaGetter2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (kCallable instanceof KProperty.Getter) {
            Field javaField3 = ReflectJvmMapping.getJavaField(((KProperty.Getter) kCallable).getProperty());
            if (javaField3 != null ? javaField3.isAccessible() : true) {
                Method javaMethod = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
                if (javaMethod != null ? javaMethod.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (kCallable instanceof KMutableProperty.Setter) {
            Field javaField4 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) kCallable).getProperty());
            if (javaField4 != null ? javaField4.isAccessible() : true) {
                Method javaMethod2 = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
                if (javaMethod2 != null ? javaMethod2.isAccessible() : true) {
                    return true;
                }
            }
            return false;
        }
        if (!(kCallable instanceof KFunction)) {
            throw new UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + PropertyUtils.MAPPED_DELIM2);
        }
        KFunction kFunction = (KFunction) kCallable;
        Method javaMethod3 = ReflectJvmMapping.getJavaMethod(kFunction);
        if (javaMethod3 != null ? javaMethod3.isAccessible() : true) {
            KCallableImpl<?> kCallableImplAsKCallableImpl = UtilKt.asKCallableImpl(kCallable);
            Member memberMo23485getMember = (kCallableImplAsKCallableImpl == null || (defaultCaller = kCallableImplAsKCallableImpl.getDefaultCaller()) == null) ? null : defaultCaller.mo23485getMember();
            AccessibleObject accessibleObject = memberMo23485getMember instanceof AccessibleObject ? (AccessibleObject) memberMo23485getMember : null;
            if (accessibleObject != null ? accessibleObject.isAccessible() : true) {
                Constructor javaConstructor = ReflectJvmMapping.getJavaConstructor(kFunction);
                if (javaConstructor != null ? javaConstructor.isAccessible() : true) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final void setAccessible(@NotNull KCallable<?> kCallable, boolean z) {
        Caller<?> defaultCaller;
        Intrinsics.checkNotNullParameter(kCallable, "<this>");
        if (kCallable instanceof KMutableProperty) {
            KProperty kProperty = (KProperty) kCallable;
            Field javaField = ReflectJvmMapping.getJavaField(kProperty);
            if (javaField != null) {
                javaField.setAccessible(z);
            }
            Method javaGetter = ReflectJvmMapping.getJavaGetter(kProperty);
            if (javaGetter != null) {
                javaGetter.setAccessible(z);
            }
            Method javaSetter = ReflectJvmMapping.getJavaSetter((KMutableProperty) kCallable);
            if (javaSetter != null) {
                javaSetter.setAccessible(z);
                return;
            }
            return;
        }
        if (kCallable instanceof KProperty) {
            KProperty kProperty2 = (KProperty) kCallable;
            Field javaField2 = ReflectJvmMapping.getJavaField(kProperty2);
            if (javaField2 != null) {
                javaField2.setAccessible(z);
            }
            Method javaGetter2 = ReflectJvmMapping.getJavaGetter(kProperty2);
            if (javaGetter2 != null) {
                javaGetter2.setAccessible(z);
                return;
            }
            return;
        }
        if (kCallable instanceof KProperty.Getter) {
            Field javaField3 = ReflectJvmMapping.getJavaField(((KProperty.Getter) kCallable).getProperty());
            if (javaField3 != null) {
                javaField3.setAccessible(z);
            }
            Method javaMethod = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod != null) {
                javaMethod.setAccessible(z);
                return;
            }
            return;
        }
        if (kCallable instanceof KMutableProperty.Setter) {
            Field javaField4 = ReflectJvmMapping.getJavaField(((KMutableProperty.Setter) kCallable).getProperty());
            if (javaField4 != null) {
                javaField4.setAccessible(z);
            }
            Method javaMethod2 = ReflectJvmMapping.getJavaMethod((KFunction) kCallable);
            if (javaMethod2 != null) {
                javaMethod2.setAccessible(z);
                return;
            }
            return;
        }
        if (!(kCallable instanceof KFunction)) {
            throw new UnsupportedOperationException("Unknown callable: " + kCallable + " (" + kCallable.getClass() + PropertyUtils.MAPPED_DELIM2);
        }
        KFunction kFunction = (KFunction) kCallable;
        Method javaMethod3 = ReflectJvmMapping.getJavaMethod(kFunction);
        if (javaMethod3 != null) {
            javaMethod3.setAccessible(z);
        }
        KCallableImpl<?> kCallableImplAsKCallableImpl = UtilKt.asKCallableImpl(kCallable);
        Member memberMo23485getMember = (kCallableImplAsKCallableImpl == null || (defaultCaller = kCallableImplAsKCallableImpl.getDefaultCaller()) == null) ? null : defaultCaller.mo23485getMember();
        AccessibleObject accessibleObject = memberMo23485getMember instanceof AccessibleObject ? (AccessibleObject) memberMo23485getMember : null;
        if (accessibleObject != null) {
            accessibleObject.setAccessible(true);
        }
        Constructor javaConstructor = ReflectJvmMapping.getJavaConstructor(kFunction);
        if (javaConstructor != null) {
            javaConstructor.setAccessible(z);
        }
    }
}
