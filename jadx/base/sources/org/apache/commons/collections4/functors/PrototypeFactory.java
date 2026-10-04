package org.apache.commons.collections4.functors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.FunctorException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PrototypeFactory {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PrototypeCloneFactory<T> implements Factory<T> {
        private transient Method iCloneMethod;
        private final T iPrototype;

        private void findCloneMethod() {
            try {
                this.iCloneMethod = this.iPrototype.getClass().getMethod("clone", null);
            } catch (NoSuchMethodException unused) {
                throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
            }
        }

        @Override // org.apache.commons.collections4.Factory
        public T create() {
            if (this.iCloneMethod == null) {
                findCloneMethod();
            }
            try {
                return (T) this.iCloneMethod.invoke(this.iPrototype, null);
            } catch (IllegalAccessException e) {
                throw new FunctorException("PrototypeCloneFactory: Clone method must be public", e);
            } catch (InvocationTargetException e2) {
                throw new FunctorException("PrototypeCloneFactory: Clone method threw an exception", e2);
            }
        }

        private PrototypeCloneFactory(T t, Method method) {
            this.iPrototype = t;
            this.iCloneMethod = method;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PrototypeSerializationFactory<T extends Serializable> implements Factory<T> {
        private final T iPrototype;

        private PrototypeSerializationFactory(T t) {
            this.iPrototype = t;
        }

        /* JADX WARN: Removed duplicated region for block: B:32:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // org.apache.commons.collections4.Factory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public T create() throws Throwable {
            Throwable th;
            Throwable e;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            ByteArrayInputStream byteArrayInputStream = null;
            try {
                try {
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(this.iPrototype);
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    try {
                        T t = (T) new ObjectInputStream(byteArrayInputStream2).readObject();
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException unused) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused2) {
                        }
                        return t;
                    } catch (IOException e2) {
                        e = e2;
                        throw new FunctorException(e);
                    } catch (ClassNotFoundException e3) {
                        e = e3;
                        throw new FunctorException(e);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (0 != 0) {
                        try {
                            byteArrayInputStream.close();
                        } catch (IOException unused3) {
                        }
                    }
                    try {
                        byteArrayOutputStream.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
            } catch (IOException e5) {
                e = e5;
                e = e;
                throw new FunctorException(e);
            } catch (ClassNotFoundException e6) {
                e = e6;
                e = e;
                throw new FunctorException(e);
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                byteArrayOutputStream.close();
                throw th;
            }
        }
    }

    private PrototypeFactory() {
    }

    public static <T> Factory<T> prototypeFactory(T t) {
        if (t == null) {
            return ConstantFactory.constantFactory(null);
        }
        try {
            try {
                return new PrototypeCloneFactory(t, t.getClass().getMethod("clone", null));
            } catch (NoSuchMethodException unused) {
                t.getClass().getConstructor(t.getClass());
                return new InstantiateFactory(t.getClass(), new Class[]{t.getClass()}, new Object[]{t});
            }
        } catch (NoSuchMethodException unused2) {
            if (t instanceof Serializable) {
                return new PrototypeSerializationFactory((Serializable) t);
            }
            throw new IllegalArgumentException("The prototype must be cloneable via a public clone method");
        }
    }
}
