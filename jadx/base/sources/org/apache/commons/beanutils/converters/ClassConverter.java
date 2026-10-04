package org.apache.commons.beanutils.converters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class ClassConverter extends AbstractConverter {
    public ClassConverter() {
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public String convertToString(Object obj) {
        return obj instanceof Class ? ((Class) obj).getName() : obj.toString();
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public <T> T convertToType(Class<T> cls, Object obj) {
        if (!Class.class.equals(cls)) {
            throw conversionException(cls, obj);
        }
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                return cls.cast(contextClassLoader.loadClass(obj.toString()));
            } catch (ClassNotFoundException unused) {
            }
        }
        return cls.cast(ClassConverter.class.getClassLoader().loadClass(obj.toString()));
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<?> getDefaultType() {
        return Class.class;
    }

    public ClassConverter(Object obj) {
        super(obj);
    }
}
