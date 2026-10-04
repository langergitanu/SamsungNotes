package org.apache.commons.collections4.functors;

import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class InvokerTransformer<T, R> implements Transformer<T, R> {
    private final Object[] iArgs;
    private final String iMethodName;
    private final Class<?>[] iParamTypes;

    private InvokerTransformer(String str) {
        this.iMethodName = str;
        this.iParamTypes = null;
        this.iArgs = null;
    }

    public static <I, O> Transformer<I, O> invokerTransformer(String str) {
        Objects.requireNonNull(str, "methodName");
        return new InvokerTransformer(str);
    }

    @Override // org.apache.commons.collections4.Transformer
    public R transform(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return (R) obj.getClass().getMethod(this.iMethodName, this.iParamTypes).invoke(obj, this.iArgs);
        } catch (IllegalAccessException unused) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + obj.getClass() + "' cannot be accessed");
        } catch (NoSuchMethodException unused2) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + obj.getClass() + "' does not exist");
        } catch (InvocationTargetException e) {
            throw new FunctorException("InvokerTransformer: The method '" + this.iMethodName + "' on '" + obj.getClass() + "' threw an exception", e);
        }
    }

    public static <I, O> Transformer<I, O> invokerTransformer(String str, Class<?>[] clsArr, Object[] objArr) {
        Objects.requireNonNull(str, "methodName");
        if ((clsArr != null || objArr == null) && ((clsArr == null || objArr != null) && (clsArr == null || objArr == null || clsArr.length == objArr.length))) {
            return (clsArr == null || clsArr.length == 0) ? new InvokerTransformer(str) : new InvokerTransformer(str, clsArr, objArr);
        }
        throw new IllegalArgumentException("The parameter types must match the arguments");
    }

    public InvokerTransformer(String str, Class<?>[] clsArr, Object[] objArr) {
        this.iMethodName = str;
        this.iParamTypes = clsArr != null ? (Class[]) clsArr.clone() : null;
        this.iArgs = objArr != null ? (Object[]) objArr.clone() : null;
    }
}
