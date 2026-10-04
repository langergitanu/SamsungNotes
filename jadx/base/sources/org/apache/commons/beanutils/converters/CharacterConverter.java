package org.apache.commons.beanutils.converters;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class CharacterConverter extends AbstractConverter {
    public CharacterConverter() {
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public String convertToString(Object obj) {
        String string = obj.toString();
        return string.length() == 0 ? "" : string.substring(0, 1);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public <T> T convertToType(Class<T> cls, Object obj) {
        if (Character.class.equals(cls) || Character.TYPE.equals(cls)) {
            return cls.cast(Character.valueOf(obj.toString().charAt(0)));
        }
        throw conversionException(cls, obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<?> getDefaultType() {
        return Character.class;
    }

    public CharacterConverter(Object obj) {
        super(obj);
    }
}
