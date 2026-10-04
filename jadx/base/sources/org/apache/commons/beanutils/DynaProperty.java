package org.apache.commons.beanutils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.StreamCorruptedException;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public class DynaProperty implements Serializable {
    private static final int BOOLEAN_TYPE = 1;
    private static final int BYTE_TYPE = 2;
    private static final int CHAR_TYPE = 3;
    private static final int DOUBLE_TYPE = 4;
    private static final int FLOAT_TYPE = 5;
    private static final int INT_TYPE = 6;
    private static final int LONG_TYPE = 7;
    private static final int SHORT_TYPE = 8;
    private static final long serialVersionUID = 1;
    protected transient Class<?> contentType;
    protected String name;
    protected transient Class<?> type;

    public DynaProperty(String str) {
        this(str, Object.class);
    }

    private Class<?> readAnyClass(ObjectInputStream objectInputStream) throws StreamCorruptedException {
        if (!objectInputStream.readBoolean()) {
            return (Class) objectInputStream.readObject();
        }
        switch (objectInputStream.readInt()) {
            case 1:
                return Boolean.TYPE;
            case 2:
                return Byte.TYPE;
            case 3:
                return Character.TYPE;
            case 4:
                return Double.TYPE;
            case 5:
                return Float.TYPE;
            case 6:
                return Integer.TYPE;
            case 7:
                return Long.TYPE;
            case 8:
                return Short.TYPE;
            default:
                throw new StreamCorruptedException("Invalid primitive type. Check version of beanutils used to serialize is compatible.");
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        this.type = readAnyClass(objectInputStream);
        if (isMapped() || isIndexed()) {
            this.contentType = readAnyClass(objectInputStream);
        }
        objectInputStream.defaultReadObject();
    }

    private void writeAnyClass(Class<?> cls, ObjectOutputStream objectOutputStream) throws IOException {
        int i = Boolean.TYPE.equals(cls) ? 1 : Byte.TYPE.equals(cls) ? 2 : Character.TYPE.equals(cls) ? 3 : Double.TYPE.equals(cls) ? 4 : Float.TYPE.equals(cls) ? 5 : Integer.TYPE.equals(cls) ? 6 : Long.TYPE.equals(cls) ? 7 : Short.TYPE.equals(cls) ? 8 : 0;
        if (i == 0) {
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeObject(cls);
        } else {
            objectOutputStream.writeBoolean(true);
            objectOutputStream.writeInt(i);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        writeAnyClass(this.type, objectOutputStream);
        if (isMapped() || isIndexed()) {
            writeAnyClass(this.contentType, objectOutputStream);
        }
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        boolean z = obj == this;
        if (z || !(obj instanceof DynaProperty)) {
            return z;
        }
        DynaProperty dynaProperty = (DynaProperty) obj;
        String str = this.name;
        if (str != null ? str.equals(dynaProperty.name) : dynaProperty.name == null) {
            Class<?> cls = this.type;
            if (cls != null ? cls.equals(dynaProperty.type) : dynaProperty.type == null) {
                Class<?> cls2 = this.contentType;
                Class<?> cls3 = dynaProperty.contentType;
                if (cls2 != null ? cls2.equals(cls3) : cls3 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public Class<?> getContentType() {
        return this.contentType;
    }

    public String getName() {
        return this.name;
    }

    public Class<?> getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        Class<?> cls = this.type;
        int iHashCode2 = (iHashCode + (cls == null ? 0 : cls.hashCode())) * 31;
        Class<?> cls2 = this.contentType;
        return iHashCode2 + (cls2 != null ? cls2.hashCode() : 0);
    }

    public boolean isIndexed() {
        Class<?> cls = this.type;
        if (cls == null) {
            return false;
        }
        return cls.isArray() || List.class.isAssignableFrom(this.type);
    }

    public boolean isMapped() {
        Class<?> cls = this.type;
        if (cls == null) {
            return false;
        }
        return Map.class.isAssignableFrom(cls);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DynaProperty[name=");
        sb.append(this.name);
        sb.append(",type=");
        sb.append(this.type);
        if (isMapped() || isIndexed()) {
            sb.append(" <");
            sb.append(this.contentType);
            sb.append(">");
        }
        sb.append("]");
        return sb.toString();
    }

    public DynaProperty(String str, Class<?> cls) {
        this.name = str;
        this.type = cls;
        if (cls == null || !cls.isArray()) {
            return;
        }
        this.contentType = cls.getComponentType();
    }

    public DynaProperty(String str, Class<?> cls, Class<?> cls2) {
        this.name = str;
        this.type = cls;
        this.contentType = cls2;
    }
}
