package org.apache.commons.beanutils.converters;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-a629e001fb94ba727dd9a6e89a87761aaa44877a48f13f9f60a19cb2354a0b6a */
/* JADX INFO: loaded from: classes10.dex */
public final class FileConverter extends AbstractConverter {
    public FileConverter() {
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public <T> T convertToType(Class<T> cls, Object obj) {
        if (File.class.equals(cls)) {
            return cls.cast(new File(obj.toString()));
        }
        throw conversionException(cls, obj);
    }

    @Override // org.apache.commons.beanutils.converters.AbstractConverter
    public Class<?> getDefaultType() {
        return File.class;
    }

    public FileConverter(Object obj) {
        super(obj);
    }
}
