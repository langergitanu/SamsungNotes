package org.apache.commons.beanutils.converters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class StringConverter extends AbstractConverter {
    public StringConverter() {
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public <T> T convertToType(Class<T> cls, Object obj) {
        if (String.class.equals(cls) || Object.class.equals(cls)) {
            return cls.cast(obj.toString());
        }
        throw conversionException(cls, obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<?> getDefaultType() {
        return String.class;
    }

    public StringConverter(Object obj) {
        super(obj);
    }
}
