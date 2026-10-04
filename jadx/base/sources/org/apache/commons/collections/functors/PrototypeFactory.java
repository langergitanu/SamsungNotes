package org.apache.commons.collections.functors;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.apache.commons.collections.Factory;
import org.apache.commons.collections.FunctorException;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class PrototypeFactory {

    /* JADX INFO: renamed from: class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeCloneFactory */
    static /* synthetic */ Class f9711xfff14dc2;

    /* JADX INFO: renamed from: class$org$apache$commons$collections$functors$PrototypeFactory$PrototypeSerializationFactory */
    static /* synthetic */ Class f9712xbf39ecf;

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PrototypeCloneFactory implements Factory, Serializable {
        private static final long serialVersionUID = 5604271422565175555L;
        private transient Method iCloneMethod;
        private final Object iPrototype;

        private void findCloneMethod() {
            try {
                this.iCloneMethod = this.iPrototype.getClass().getMethod("clone", null);
            } catch (NoSuchMethodException unused) {
                throw new IllegalArgumentException("PrototypeCloneFactory: The clone method must exist and be public ");
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            Class clsClass$ = PrototypeFactory.f9711xfff14dc2;
            if (clsClass$ == null) {
                clsClass$ = PrototypeFactory.class$("org.apache.commons.collections.functors.PrototypeFactory$PrototypeCloneFactory");
                PrototypeFactory.f9711xfff14dc2 = clsClass$;
            }
            FunctorUtils.checkUnsafeSerialization(clsClass$);
            objectInputStream.defaultReadObject();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Class clsClass$ = PrototypeFactory.f9711xfff14dc2;
            if (clsClass$ == null) {
                clsClass$ = PrototypeFactory.class$("org.apache.commons.collections.functors.PrototypeFactory$PrototypeCloneFactory");
                PrototypeFactory.f9711xfff14dc2 = clsClass$;
            }
            FunctorUtils.checkUnsafeSerialization(clsClass$);
            objectOutputStream.defaultWriteObject();
        }

        @Override // org.apache.commons.collections.Factory
        public Object create() {
            if (this.iCloneMethod == null) {
                findCloneMethod();
            }
            try {
                return this.iCloneMethod.invoke(this.iPrototype, null);
            } catch (IllegalAccessException e) {
                throw new FunctorException("PrototypeCloneFactory: Clone method must be public", e);
            } catch (InvocationTargetException e2) {
                throw new FunctorException("PrototypeCloneFactory: Clone method threw an exception", e2);
            }
        }

        private PrototypeCloneFactory(Object obj, Method method) {
            this.iPrototype = obj;
            this.iCloneMethod = method;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static class PrototypeSerializationFactory implements Factory, Serializable {
        private static final long serialVersionUID = -8704966966139178833L;
        private final Serializable iPrototype;

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            Class clsClass$ = PrototypeFactory.f9712xbf39ecf;
            if (clsClass$ == null) {
                clsClass$ = PrototypeFactory.class$("org.apache.commons.collections.functors.PrototypeFactory$PrototypeSerializationFactory");
                PrototypeFactory.f9712xbf39ecf = clsClass$;
            }
            FunctorUtils.checkUnsafeSerialization(clsClass$);
            objectInputStream.defaultReadObject();
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            Class clsClass$ = PrototypeFactory.f9712xbf39ecf;
            if (clsClass$ == null) {
                clsClass$ = PrototypeFactory.class$("org.apache.commons.collections.functors.PrototypeFactory$PrototypeSerializationFactory");
                PrototypeFactory.f9712xbf39ecf = clsClass$;
            }
            FunctorUtils.checkUnsafeSerialization(clsClass$);
            objectOutputStream.defaultWriteObject();
        }

        /* JADX WARN: Removed duplicated region for block: B:38:0x004e A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override // org.apache.commons.collections.Factory
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object create() throws Throwable {
            Throwable th;
            ClassNotFoundException e;
            IOException e2;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
            ByteArrayInputStream byteArrayInputStream = null;
            try {
                try {
                    new ObjectOutputStream(byteArrayOutputStream).writeObject(this.iPrototype);
                    ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                    try {
                        Object object = new ObjectInputStream(byteArrayInputStream2).readObject();
                        try {
                            byteArrayInputStream2.close();
                        } catch (IOException unused) {
                        }
                        try {
                            byteArrayOutputStream.close();
                        } catch (IOException unused2) {
                        }
                        return object;
                    } catch (IOException e3) {
                        e2 = e3;
                        throw new FunctorException(e2);
                    } catch (ClassNotFoundException e5) {
                        e = e5;
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
            } catch (IOException e6) {
                e2 = e6;
            } catch (ClassNotFoundException e7) {
                e = e7;
            } catch (Throwable th3) {
                th = th3;
                if (0 != 0) {
                }
                byteArrayOutputStream.close();
                throw th;
            }
        }

        private PrototypeSerializationFactory(Serializable serializable) {
            this.iPrototype = serializable;
        }
    }

    private PrototypeFactory() {
    }

    public static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Factory getInstance(Object obj) {
        if (obj == null) {
            return ConstantFactory.NULL_INSTANCE;
        }
        try {
            try {
                return new PrototypeCloneFactory(obj, obj.getClass().getMethod("clone", null));
            } catch (NoSuchMethodException unused) {
                if (obj instanceof Serializable) {
                    return new PrototypeSerializationFactory((Serializable) obj);
                }
                throw new IllegalArgumentException("The prototype must be cloneable via a public clone method");
            }
        } catch (NoSuchMethodException unused2) {
            obj.getClass().getConstructor(obj.getClass());
            return new InstantiateFactory(obj.getClass(), new Class[]{obj.getClass()}, new Object[]{obj});
        }
    }
}
