package org.apache.commons.beanutils.converters;

import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class URLConverter extends AbstractConverter {
    public URLConverter() {
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public <T> T convertToType(Class<T> cls, Object obj) {
        if (URL.class.equals(cls)) {
            return cls.cast(new URL(obj.toString()));
        }
        throw conversionException(cls, obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<?> getDefaultType() {
        return URL.class;
    }

    public URLConverter(Object obj) {
        super(obj);
    }
}
