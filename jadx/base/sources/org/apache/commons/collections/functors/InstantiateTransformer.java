package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.FunctorException;
import org.apache.commons.collections.Transformer;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class InstantiateTransformer implements Transformer, Serializable {
    public static final Transformer NO_ARG_INSTANCE = new InstantiateTransformer();

    /* JADX INFO: renamed from: class$org$apache$commons$collections$functors$InstantiateTransformer */
    static /* synthetic */ Class f9710xfbee869e = null;
    private static final long serialVersionUID = 3786388740793356347L;
    private final Object[] iArgs;
    private final Class[] iParamTypes;

    private InstantiateTransformer() {
        this.iParamTypes = null;
        this.iArgs = null;
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Transformer getInstance(Class[] clsArr, Object[] objArr) {
        if ((clsArr != null || objArr == null) && ((clsArr == null || objArr != null) && (clsArr == null || objArr == null || clsArr.length == objArr.length))) {
            return (clsArr == null || clsArr.length == 0) ? NO_ARG_INSTANCE : new InstantiateTransformer((Class[]) clsArr.clone(), (Object[]) objArr.clone());
        }
        throw new IllegalArgumentException("Parameter types must match the arguments");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class clsClass$ = f9710xfbee869e;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.InstantiateTransformer");
            f9710xfbee869e = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class clsClass$ = f9710xfbee869e;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.InstantiateTransformer");
            f9710xfbee869e = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectOutputStream.defaultWriteObject();
    }

    @Override // org.apache.commons.collections.Transformer
    public Object transform(Object obj) {
        try {
            if (obj instanceof Class) {
                return ((Class) obj).getConstructor(this.iParamTypes).newInstance(this.iArgs);
            }
            throw new FunctorException("InstantiateTransformer: Input object was not an instanceof Class, it was a ".concat(obj == null ? "null object" : obj.getClass().getName()));
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

    public InstantiateTransformer(Class[] clsArr, Object[] objArr) {
        this.iParamTypes = clsArr;
        this.iArgs = objArr;
    }
}
