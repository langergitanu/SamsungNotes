package org.apache.commons.collections4.functors;

import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections4.FunctorException;
import org.apache.commons.collections4.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class InstantiateTransformer<T> implements Transformer<Class<? extends T>, T> {
    private static final Transformer NO_ARG_INSTANCE = new InstantiateTransformer();
    private final Object[] iArgs;
    private final Class<?>[] iParamTypes;

    private InstantiateTransformer() {
        this.iParamTypes = null;
        this.iArgs = null;
    }

    public static <T> Transformer<Class<? extends T>, T> instantiateTransformer() {
        return NO_ARG_INSTANCE;
    }

    public static <T> Transformer<Class<? extends T>, T> instantiateTransformer(Class<?>[] clsArr, Object[] objArr) {
        if ((clsArr != null || objArr == null) && ((clsArr == null || objArr != null) && (clsArr == null || objArr == null || clsArr.length == objArr.length))) {
            return (clsArr == null || clsArr.length == 0) ? new InstantiateTransformer() : new InstantiateTransformer(clsArr, objArr);
        }
        throw new IllegalArgumentException("Parameter types must match the arguments");
    }

    @Override // org.apache.commons.collections4.Transformer
    public T transform(Class<? extends T> cls) {
        try {
            if (cls != null) {
                return cls.getConstructor(this.iParamTypes).newInstance(this.iArgs);
            }
            throw new FunctorException("InstantiateTransformer: Input object was not an instanceof Class, it was a null object");
        } catch (IllegalAccessException e) {
            throw new FunctorException("InstantiateTransformer: Constructor must be public", e);
        } catch (InstantiationException e2) {
            throw new FunctorException("InstantiateTransformer: InstantiationException", e2);
        } catch (NoSuchMethodException unused) {
            throw new FunctorException("InstantiateTransformer: The constructor must exist and be public ");
        } catch (InvocationTargetException e3) {
            throw new FunctorException("InstantiateTransformer: Constructor threw an exception", e3);
        }
    }

    public InstantiateTransformer(Class<?>[] clsArr, Object[] objArr) {
        this.iParamTypes = clsArr != null ? (Class[]) clsArr.clone() : null;
        this.iArgs = objArr != null ? (Object[]) objArr.clone() : null;
    }
}
