package org.apache.commons.beanutils;

import androidx.appcompat.widget.AbstractC0541b;
import androidx.collection.AbstractC0622a;
import androidx.compose.runtime.AbstractC1974b;
import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;
import java.util.function.Supplier;
import p001A.AbstractC0000a;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class MappedPropertyDescriptor extends PropertyDescriptor {
    private static final Class<?>[] STRING_CLASS_PARAMETER = {String.class};
    private Reference<Class<?>> mappedPropertyTypeRef;
    private MappedMethodReference mappedReadMethodRef;
    private MappedMethodReference mappedWriteMethodRef;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class MappedMethodReference {
        private String className;
        private Reference<Class<?>> classRef;
        private String methodName;
        private Reference<Method> methodRef;
        private String[] writeParamClassNames;
        private Reference<Class<?>> writeParamTypeRef0;
        private Reference<Class<?>> writeParamTypeRef1;

        public MappedMethodReference(Method method) {
            if (method != null) {
                this.className = method.getDeclaringClass().getName();
                this.methodName = method.getName();
                this.methodRef = new SoftReference(method);
                this.classRef = new WeakReference(method.getDeclaringClass());
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 2) {
                    this.writeParamTypeRef0 = new WeakReference(parameterTypes[0]);
                    this.writeParamTypeRef1 = new WeakReference(parameterTypes[1]);
                    String[] strArr = new String[2];
                    this.writeParamClassNames = strArr;
                    strArr[0] = parameterTypes[0].getName();
                    this.writeParamClassNames[1] = parameterTypes[1].getName();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Method get() {
            Class<?>[] clsArr;
            Reference<Method> reference = this.methodRef;
            if (reference == null) {
                return null;
            }
            Method method = reference.get();
            if (method != null) {
                return method;
            }
            Class<?> clsReLoadClass = this.classRef.get();
            if (clsReLoadClass == null && (clsReLoadClass = reLoadClass()) != null) {
                this.classRef = new WeakReference(clsReLoadClass);
            }
            Objects.requireNonNull(clsReLoadClass, (Supplier<String>) new Supplier() { // from class: org.apache.commons.beanutils.d
                @Override // java.util.function.Supplier
                public final Object get() {
                    return this.f9709a.lambda$get$0();
                }
            });
            if (this.writeParamClassNames != null) {
                clsArr = new Class[2];
                Class<?> cls = this.writeParamTypeRef0.get();
                clsArr[0] = cls;
                if (cls == null) {
                    Class<?> clsReLoadClass2 = reLoadClass(this.writeParamClassNames[0]);
                    clsArr[0] = clsReLoadClass2;
                    if (clsReLoadClass2 != null) {
                        this.writeParamTypeRef0 = new WeakReference(clsArr[0]);
                    }
                }
                Class<?> cls2 = this.writeParamTypeRef1.get();
                clsArr[1] = cls2;
                if (cls2 == null) {
                    Class<?> clsReLoadClass3 = reLoadClass(this.writeParamClassNames[1]);
                    clsArr[1] = clsReLoadClass3;
                    if (clsReLoadClass3 != null) {
                        this.writeParamTypeRef1 = new WeakReference(clsArr[1]);
                    }
                }
            } else {
                clsArr = MappedPropertyDescriptor.STRING_CLASS_PARAMETER;
            }
            try {
                Method method2 = clsReLoadClass.getMethod(this.methodName, clsArr);
                this.methodRef = new SoftReference(method2);
                return method2;
            } catch (NoSuchMethodException e) {
                StringBuilder sb = new StringBuilder("Method ");
                sb.append(this.methodName);
                sb.append(" for ");
                throw new IllegalStateException(AbstractC0622a.m1170p(this.className, " could not be reconstructed - method not found", sb), e);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ String lambda$get$0() {
            StringBuilder sb = new StringBuilder("Method ");
            sb.append(this.methodName);
            sb.append(" for ");
            return AbstractC0622a.m1170p(this.className, " could not be reconstructed - class reference has gone", sb);
        }

        private Class<?> reLoadClass() {
            return reLoadClass(this.className);
        }

        private Class<?> reLoadClass(String str) {
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader != null) {
                try {
                    return contextClassLoader.loadClass(str);
                } catch (ClassNotFoundException unused) {
                }
            }
            try {
                return MappedPropertyDescriptor.class.getClassLoader().loadClass(str);
            } catch (ClassNotFoundException unused2) {
                return null;
            }
        }
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MappedPropertyDescriptor(String str, Class<?> cls) throws IntrospectionException {
        Method method;
        super(str, (Method) null, (Method) null);
        Method method2 = null;
        if (str == null || str.length() == 0) {
            StringBuilder sbM15l = AbstractC0000a.m15l("bad property name: ", str, " on class: ");
            sbM15l.append(cls.getClass().getName());
            throw new IntrospectionException(sbM15l.toString());
        }
        setName(str);
        String strCapitalizePropertyName = capitalizePropertyName(str);
        try {
            try {
                method = getMethod(cls, "get" + strCapitalizePropertyName, STRING_CLASS_PARAMETER);
            } catch (IntrospectionException unused) {
                method = getMethod(cls, "is" + strCapitalizePropertyName, STRING_CLASS_PARAMETER);
            }
            try {
                method2 = getMethod(cls, FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX + strCapitalizePropertyName, (Class<?>[]) new Class[]{String.class, method.getReturnType()});
            } catch (IntrospectionException unused2) {
            }
        } catch (IntrospectionException unused3) {
            method = null;
        }
        method2 = method == null ? getMethod(cls, AbstractC0541b.m772n(FluentPropertyBeanIntrospector.DEFAULT_WRITE_METHOD_PREFIX, strCapitalizePropertyName), 2) : method2;
        if (method == null && method2 == null) {
            StringBuilder sbM15l2 = AbstractC0000a.m15l("Property '", str, "' not found on ");
            sbM15l2.append(cls.getName());
            throw new IntrospectionException(sbM15l2.toString());
        }
        this.mappedReadMethodRef = new MappedMethodReference(method);
        this.mappedWriteMethodRef = new MappedMethodReference(method2);
        findMappedPropertyType();
    }

    private static String capitalizePropertyName(String str) {
        if (str.length() == 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        charArray[0] = Character.toUpperCase(charArray[0]);
        return new String(charArray);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    private void findMappedPropertyType() throws IntrospectionException {
        Class<?> returnType;
        Method mappedReadMethod = getMappedReadMethod();
        Method mappedWriteMethod = getMappedWriteMethod();
        if (mappedReadMethod == null) {
            returnType = null;
        } else {
            if (mappedReadMethod.getParameterTypes().length != 1) {
                throw new IntrospectionException("bad mapped read method arg count");
            }
            returnType = mappedReadMethod.getReturnType();
            if (returnType == Void.TYPE) {
                throw new IntrospectionException("mapped read method " + mappedReadMethod.getName() + " returns void");
            }
        }
        if (mappedWriteMethod != null) {
            Class<?>[] parameterTypes = mappedWriteMethod.getParameterTypes();
            if (parameterTypes.length != 2) {
                throw new IntrospectionException("bad mapped write method arg count");
            }
            if (returnType != null && returnType != parameterTypes[1]) {
                throw new IntrospectionException("type mismatch between mapped read and write methods");
            }
            returnType = parameterTypes[1];
        }
        this.mappedPropertyTypeRef = new SoftReference(returnType);
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    private static Method getMethod(Class<?> cls, String str, Class<?>[] clsArr) throws IntrospectionException {
        if (str == null) {
            return null;
        }
        Method matchingAccessibleMethod = MethodUtils.getMatchingAccessibleMethod(cls, str, clsArr);
        if (matchingAccessibleMethod != null) {
            return matchingAccessibleMethod;
        }
        throw new IntrospectionException(AbstractC1974b.m1319l("No method \"", clsArr == null ? 0 : clsArr.length, str, "\" with ", " parameter(s) of matching types."));
    }

    private static Method internalGetMethod(Class<?> cls, String str, int i) {
        Class<?> superclass = cls;
        while (true) {
            int i2 = 0;
            if (superclass == null) {
                Class<?>[] interfaces = cls.getInterfaces();
                int length = interfaces.length;
                while (i2 < length) {
                    Method methodInternalGetMethod = internalGetMethod(interfaces[i2], str, i);
                    if (methodInternalGetMethod != null) {
                        return methodInternalGetMethod;
                    }
                    i2++;
                }
                return null;
            }
            Method[] declaredMethods = superclass.getDeclaredMethods();
            int length2 = declaredMethods.length;
            while (i2 < length2) {
                Method method = declaredMethods[i2];
                if (method != null) {
                    int modifiers = method.getModifiers();
                    if (Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers) && method.getName().equals(str) && method.getParameterTypes().length == i) {
                        return method;
                    }
                }
                i2++;
            }
            superclass = superclass.getSuperclass();
        }
    }

    public Class<?> getMappedPropertyType() {
        return this.mappedPropertyTypeRef.get();
    }

    public Method getMappedReadMethod() {
        return this.mappedReadMethodRef.get();
    }

    public Method getMappedWriteMethod() {
        return this.mappedWriteMethodRef.get();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    public void setMappedReadMethod(Method method) throws IntrospectionException {
        this.mappedReadMethodRef = new MappedMethodReference(method);
        findMappedPropertyType();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    public void setMappedWriteMethod(Method method) throws IntrospectionException {
        this.mappedWriteMethodRef = new MappedMethodReference(method);
        findMappedPropertyType();
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    private static Method getMethod(Class<?> cls, String str, int i) throws IntrospectionException {
        if (str == null) {
            return null;
        }
        Method methodInternalGetMethod = internalGetMethod(cls, str, i);
        if (methodInternalGetMethod != null) {
            return methodInternalGetMethod;
        }
        throw new IntrospectionException(AbstractC1974b.m1319l("No method \"", i, str, "\" with ", " parameter(s)"));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    public MappedPropertyDescriptor(String str, Class<?> cls, String str2, String str3) throws IntrospectionException {
        Method method;
        super(str, (Method) null, (Method) null);
        if (str != null && str.length() != 0) {
            setName(str);
            Method method2 = getMethod(cls, str2, STRING_CLASS_PARAMETER);
            if (method2 != null) {
                method = getMethod(cls, str3, (Class<?>[]) new Class[]{String.class, method2.getReturnType()});
            } else {
                method = getMethod(cls, str3, 2);
            }
            this.mappedReadMethodRef = new MappedMethodReference(method2);
            this.mappedWriteMethodRef = new MappedMethodReference(method);
            findMappedPropertyType();
            return;
        }
        throw new IntrospectionException(AbstractC0541b.m772n("bad property name: ", str));
    }

    /* JADX INFO: Thrown type has an unknown type hierarchy: java.beans.IntrospectionException */
    public MappedPropertyDescriptor(String str, Method method, Method method2) throws IntrospectionException {
        super(str, method, method2);
        if (str != null && str.length() != 0) {
            setName(str);
            this.mappedReadMethodRef = new MappedMethodReference(method);
            this.mappedWriteMethodRef = new MappedMethodReference(method2);
            findMappedPropertyType();
            return;
        }
        throw new IntrospectionException(AbstractC0541b.m772n("bad property name: ", str));
    }
}
