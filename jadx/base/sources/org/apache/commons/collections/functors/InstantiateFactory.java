package org.apache.commons.collections.functors;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FunctorException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class InstantiateFactory implements Factory, Serializable {
    static /* synthetic */ Class class$org$apache$commons$collections$functors$InstantiateFactory = null;
    private static final long serialVersionUID = -7732226881069447957L;
    private final Object[] iArgs;
    private final Class iClassToInstantiate;
    private transient Constructor iConstructor;
    private final Class[] iParamTypes;

    public InstantiateFactory(Class cls) {
        this.iConstructor = null;
        this.iClassToInstantiate = cls;
        this.iParamTypes = null;
        this.iArgs = null;
        findConstructor();
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    private void findConstructor() {
        try {
            this.iConstructor = this.iClassToInstantiate.getConstructor(this.iParamTypes);
        } catch (NoSuchMethodException unused) {
            throw new IllegalArgumentException("InstantiateFactory: The constructor must exist and be public ");
        }
    }

    public static Factory getInstance(Class cls, Class[] clsArr, Object[] objArr) {
        if (cls == null) {
            throw new IllegalArgumentException("Class to instantiate must not be null");
        }
        if ((clsArr != null || objArr == null) && ((clsArr == null || objArr != null) && (clsArr == null || objArr == null || clsArr.length == objArr.length))) {
            return (clsArr == null || clsArr.length == 0) ? new InstantiateFactory(cls) : new InstantiateFactory(cls, (Class[]) clsArr.clone(), (Object[]) objArr.clone());
        }
        throw new IllegalArgumentException("Parameter types must match the arguments");
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        Class clsClass$ = class$org$apache$commons$collections$functors$InstantiateFactory;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.InstantiateFactory");
            class$org$apache$commons$collections$functors$InstantiateFactory = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        Class clsClass$ = class$org$apache$commons$collections$functors$InstantiateFactory;
        if (clsClass$ == null) {
            clsClass$ = class$("org.apache.commons.collections.functors.InstantiateFactory");
            class$org$apache$commons$collections$functors$InstantiateFactory = clsClass$;
        }
        FunctorUtils.checkUnsafeSerialization(clsClass$);
        objectOutputStream.defaultWriteObject();
    }

    @Override // org.apache.commons.collections.Factory
    public Object create() {
        if (this.iConstructor == null) {
            findConstructor();
        }
        try {
            return this.iConstructor.newInstance(this.iArgs);
        } catch (IllegalAccessException e) {
            throw new FunctorException("InstantiateFactory: Constructor must be public", e);
        } catch (InstantiationException e2) {
            throw new FunctorException("InstantiateFactory: InstantiationException", e2);
        } catch (InvocationTargetException e3) {
            throw new FunctorException("InstantiateFactory: Constructor threw an exception", e3);
        }
    }

    public InstantiateFactory(Class cls, Class[] clsArr, Object[] objArr) {
        this.iConstructor = null;
        this.iClassToInstantiate = cls;
        this.iParamTypes = clsArr;
        this.iArgs = objArr;
        findConstructor();
    }
}
