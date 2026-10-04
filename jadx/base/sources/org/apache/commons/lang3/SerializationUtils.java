package org.apache.commons.lang3;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class SerializationUtils {

    /* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
    public static final class ClassLoaderAwareObjectInputStream extends ObjectInputStream {
        private final ClassLoader classLoader;

        public ClassLoaderAwareObjectInputStream(InputStream inputStream, ClassLoader classLoader) {
            super(inputStream);
            this.classLoader = classLoader;
        }

        @Override // java.io.ObjectInputStream
        public Class<?> resolveClass(ObjectStreamClass objectStreamClass) throws ClassNotFoundException {
            String name = objectStreamClass.getName();
            try {
                try {
                    return Class.forName(name, false, this.classLoader);
                } catch (ClassNotFoundException e) {
                    Class<?> primitiveClass = ClassUtils.getPrimitiveClass(name);
                    if (primitiveClass != null) {
                        return primitiveClass;
                    }
                    throw e;
                }
            } catch (ClassNotFoundException unused) {
                return Class.forName(name, false, Thread.currentThread().getContextClassLoader());
            }
        }
    }

    @Deprecated
    public SerializationUtils() {
    }

    public static <T extends Serializable> T clone(T t) {
        if (t == null) {
            return null;
        }
        try {
            ClassLoaderAwareObjectInputStream classLoaderAwareObjectInputStream = new ClassLoaderAwareObjectInputStream(new ByteArrayInputStream(serialize(t)), ObjectUtils.getClass(t).getClassLoader());
            try {
                T t2 = (T) classLoaderAwareObjectInputStream.readObject();
                classLoaderAwareObjectInputStream.close();
                return t2;
            } catch (Throwable th) {
                try {
                    classLoaderAwareObjectInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new SerializationException(e.getClass().getSimpleName().concat(" while reading cloned object data"), e);
        }
    }

    public static <T> T deserialize(byte[] bArr) {
        Objects.requireNonNull(bArr, "objectData");
        return (T) deserialize(new ByteArrayInputStream(bArr));
    }

    public static <T extends Serializable> T roundtrip(T t) {
        return (T) deserialize(serialize(t));
    }

    public static byte[] serialize(Serializable serializable) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        serialize(serializable, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static <T> T deserialize(InputStream inputStream) {
        Objects.requireNonNull(inputStream, "inputStream");
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            try {
                T t = (T) objectInputStream.readObject();
                objectInputStream.close();
                return t;
            } catch (Throwable th) {
                try {
                    objectInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException | ClassNotFoundException | NegativeArraySizeException e) {
            throw new SerializationException(e);
        }
    }

    public static void serialize(Serializable serializable, OutputStream outputStream) {
        Objects.requireNonNull(outputStream, "outputStream");
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            try {
                objectOutputStream.writeObject(serializable);
                objectOutputStream.close();
            } finally {
            }
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }
}
